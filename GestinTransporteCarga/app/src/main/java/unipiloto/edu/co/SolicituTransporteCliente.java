package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import unipiloto.edu.co.utilidades.Utilidades;

public class SolicituTransporteCliente extends AppCompatActivity {
    EditText dimensionAncho,dimensionAlto,direccionDestino,direccionRecogida;
   // String correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitu_transporte_cliente);
        //se obtiene los datos del usuario para la solicitud de carga
        //MainActivity ini = new MainActivity();
        direccionRecogida=(EditText) findViewById(R.id.informacionDireccionOrigen);
        direccionDestino=(EditText) findViewById(R.id.informacionDireccionDestino);
        dimensionAncho=(EditText) findViewById(R.id.editTextNumberAncho);
        dimensionAlto=(EditText) findViewById(R.id.editTextNumberAlto);
       // correo=ini.CorreoUsuario;

    }
    public void CrearSolicitud(View v){
        SolicitudTrasporteCarga();

    }
    public void SolicitudTrasporteCarga(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_solicitudes", null,1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        MainActivity ini = new MainActivity();
        values.put(Utilidades.CAMPO_DIRECCIONRECOGIDA,direccionRecogida.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCIONDESTINO,direccionDestino.getText().toString());
        values.put(Utilidades.CAMPO_DIMENSIONALTO,dimensionAncho.getText().toString());
        values.put(Utilidades.CAMPO_DIMESIONANCHO,dimensionAlto.getText().toString());
        values.put(Utilidades.CAMPO_CORREOU,ini.CorreoUsuario);



        Long idResultante=db.insert(Utilidades.TABLA_SOLICITUDES,Utilidades.CAMPO_DIRECCIONRECOGIDA,values);

        Toast.makeText( getApplicationContext(),"Id Registro:"+ idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}