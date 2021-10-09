package unipiloto.edu.transportecargaplus.Cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import unipiloto.edu.transportecargaplus.Controlador.ConexionSQLiteHelper;
import unipiloto.edu.transportecargaplus.Controlador.Utilidades;
import unipiloto.edu.transportecargaplus.Entidades.SolicitudVehicular;
import unipiloto.edu.transportecargaplus.Entidades.Vehiculo;
import unipiloto.edu.transportecargaplus.R;

public class SolicitarTransporte extends AppCompatActivity {
    EditText origen,destino,alto,ancho;
    private ArrayList<SolicitudVehicular> SolicitudLista;
    Bundle IdCliente;
    String idcliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_transporte);
        IdCliente= getIntent().getExtras();
        idcliente=IdCliente.getString("IdCliente");


        origen=findViewById(R.id.EditOrigen);
        destino=findViewById(R.id.EditDestino);
        alto=findViewById(R.id.EditAlto);
        ancho=findViewById(R.id.EditAncho);
    }
    public void ListarSolicitud(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_solicitud", null, 1);
        SQLiteDatabase dbs = conn.getReadableDatabase();

        SolicitudVehicular envio;
        SolicitudLista= new ArrayList<>();
        Cursor cursor= dbs.rawQuery("SELECT * FROM SOLICITUD",null);
        while (cursor.moveToNext()){
            envio=new SolicitudVehicular();
            envio.setIdSolitud(cursor.getString(0));
            envio.setDireccionOrigen(cursor.getString(1));
            envio.setDireccionDestino(cursor.getString(2));
            envio.setTamanoAlto(cursor.getString(3));
            envio.setTamanoAlto(cursor.getString(4));

            SolicitudLista.add(envio);
        }
    }
    public void AgregarSolicitudes(View v){
        ListarSolicitud();
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_solicitud", null,1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_IDSOLICITUD,SolicitudLista.size()+1);
        values.put(Utilidades.CAMPO_IDUSUARIO,idcliente);
        values.put(Utilidades.CAMPO_DIRECCIONORIGEN,origen.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCIONDESTINO,destino.getText().toString());
        values.put(Utilidades.CAMPO_TAMANOALTO,alto.getText().toString());
        values.put(Utilidades.CAMPO_TAMANOANCHO,ancho.getText().toString());
        values.put(Utilidades.CAMPO_IDVEHICULO,"Sin Asignar");
        values.put(Utilidades.CAMPO_ESTADO,"En proceso");

        Long idResultante=db.insert(Utilidades.TABLA_SOLICITUD,Utilidades.CAMPO_IDVEHICULO,values);

        Toast.makeText( getApplicationContext(),"Id Registro:"+ idResultante, Toast.LENGTH_SHORT).show();


    }
}