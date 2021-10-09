package unipiloto.edu.transportecargaplus.Cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import unipiloto.edu.transportecargaplus.Controlador.ConexionSQLiteHelper;
import unipiloto.edu.transportecargaplus.Entidades.SolicitudVehicular;
import unipiloto.edu.transportecargaplus.Entidades.Vehiculo;
import unipiloto.edu.transportecargaplus.R;

public class HistorialCarga extends AppCompatActivity {
    ConexionSQLiteHelper conn;
    String s;
    Bundle  IdCliente;
    private ArrayList<SolicitudVehicular> solicitudLista;
    private ArrayList<String> ListaSolicitud;
    Spinner informacionHistorial;
    EditText origen, destino,estado,placa,marca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_carga);
        IdCliente= getIntent().getExtras();
        s=IdCliente.getString("IdCliente");
        Log.d("prueba",s);

        informacionHistorial=findViewById(R.id.spinnerHistorial);
        listaSolicitud(IdCliente.getString("IdCliente"));
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaSolicitud);
        informacionHistorial.setAdapter(adapter);
    }
    public void listaSolicitud(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_solicitud",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        SolicitudVehicular envio=null;
        solicitudLista= new ArrayList<SolicitudVehicular>();
        //
        Cursor cursor=dbs.rawQuery("SELECT * FROM SOLICITUD WHERE IDUSUARIO=? ", new String[]{name});
        while (cursor.moveToNext()){
            envio=new SolicitudVehicular();
            envio.setIdSolitud(cursor.getString(0));
            envio.setIdusuario(cursor.getString(1));
            envio.setDireccionOrigen(cursor.getString(2));
            envio.setDireccionDestino(cursor.getString(3));
            envio.setTamanoAlto(cursor.getString(4));
            envio.setTamanoAncho(cursor.getString(5));
            envio.setEstado(cursor.getString(6));
            envio.setIdvehiculo(cursor.getString(7));

            solicitudLista.add(envio);

        }
        obtenerLista();
    }

    public void obtenerLista() {
        ListaSolicitud=new ArrayList<String>();
        ListaSolicitud.add("Slecciones");
        for (int i=0;i<solicitudLista.size();i++){
            ListaSolicitud.add("Origen: "+solicitudLista.get(i).getDireccionOrigen());
        }
    }
}