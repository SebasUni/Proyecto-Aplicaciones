package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import unipiloto.edu.co.entidades.Solicitud;
import unipiloto.edu.co.utilidades.Utilidades;

public class AceptacionSolicitudesPropietario extends AppCompatActivity {
Spinner Solicitudpersonas;
ArrayList<String> ListaSolicitud;
ArrayList<Solicitud> SolicitudList;
ConexionSQLiteHelper conn;
TextView infocoreo,infodestino,inforecogida,infoaltura,infoancho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptacion_solicitudes_propietario);
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_solicitudes",null,1);
        Solicitudpersonas=(Spinner) findViewById(R.id.spinner);
        infocoreo= (TextView) findViewById(R.id.textCorreo);
        infodestino= (TextView) findViewById(R.id.textDireccionDestino);
        inforecogida= (TextView) findViewById(R.id.textDireccionRecogida);
        infoaltura= (TextView) findViewById(R.id.textView17);
        infoancho= (TextView) findViewById(R.id.textView18);
    consultarSoliciud();
    ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaSolicitud);

    Solicitudpersonas.setAdapter(adaptador);

    Solicitudpersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (position!=0){
                infocoreo.setText(SolicitudList.get(position-1).getCorreopropietario());
                infodestino.setText(SolicitudList.get(position-1).getDireccionDestino());
                inforecogida.setText(SolicitudList.get(position-1).getDireccionRecogida());
                infoaltura.setText(SolicitudList.get(position-1).getDimensionAltura());
                infoancho.setText(SolicitudList.get(position-1).getDimensionAncho());
            }else{
                infocoreo.setText("");
                infodestino.setText("");
                inforecogida.setText("");
                infoaltura.setText("");
                infoancho.setText("");


            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
    }
    public void consultarSoliciud(){
        SQLiteDatabase db = conn.getReadableDatabase();
        Solicitud envio=null;
        SolicitudList= new ArrayList<Solicitud>();
        //
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_SOLICITUDES,null);
        while (cursor.moveToNext()){
            envio=new Solicitud();
            envio.setDireccionRecogida(cursor.getString(0));
            envio.setDireccionDestino(cursor.getString(1));
            envio.setDimensionAltura(cursor.getString(2));
            envio.setDimensionAncho(cursor.getString(3));
            envio.setEstado(cursor.getString(4));
            envio.setCorreopropietario(cursor.getString(5));
            SolicitudList.add(envio);

        }
        cursor.close();
        obtenerLista();
    }

    private void obtenerLista() {
        ListaSolicitud=new ArrayList<String>();
        ListaSolicitud.add("Slecciones");
        for (int i=0;i<SolicitudList.size();i++){
             ListaSolicitud.add("Recogida: "+SolicitudList.get(i).getDireccionRecogida()+ " - Estado: "+SolicitudList.get(i).getEstado()+ " Correo: "+ SolicitudList.get(i).getCorreopropietario());
        }
    }
}