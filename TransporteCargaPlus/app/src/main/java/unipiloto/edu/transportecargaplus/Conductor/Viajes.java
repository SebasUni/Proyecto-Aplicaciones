package unipiloto.edu.transportecargaplus.Conductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



import java.util.ArrayList;


import unipiloto.edu.transportecargaplus.Controlador.ConexionSQLiteHelper;
import unipiloto.edu.transportecargaplus.Entidades.SolicitudVehicular;
import unipiloto.edu.transportecargaplus.Entidades.Vehiculo;
import unipiloto.edu.transportecargaplus.R;

public class Viajes extends AppCompatActivity {
    private static int AUTOCOMPLETE_REQUEST_CODE = 1;

    String s;
    Bundle  IdConductor;
    ConexionSQLiteHelper conn;
    private ArrayList<String> ListaCarga;
    private ArrayList<SolicitudVehicular> CargaLista;
    private ArrayList<Vehiculo> VehiculosLista;
    Spinner viajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajes);
        IdConductor= getIntent().getExtras();
        s= IdConductor.getString("IdConductor");
        Log.d("prueba",s);
      //  listvehiculos(IdConductor.getString("IdConductor"));
       // listcarga(VehiculosLista.get(0).getIdvehiculo());

      //  viajes=findViewById(R.id.spinnerVieajes);
      //  ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaCarga);
      //  viajes.setAdapter(adapter);
    //////////////////////////


    }
    public void listcarga(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_solicitud",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        SolicitudVehicular envio=null;
        CargaLista= new ArrayList<SolicitudVehicular>();
        //
        Cursor cursor=dbs.rawQuery("SELECT * FROM SOLICITUD WHERE IDVEHICULO=? ", new String[]{name});
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
            CargaLista.add(envio);

        }
        obtenerLista();
    }

    private void obtenerLista() {
        ListaCarga=new ArrayList<String>();
        ListaCarga.add("Slecciones");
        for (int i=0;i<CargaLista.size();i++){
            ListaCarga.add("ORIGEN: "+CargaLista.get(i).getDireccionOrigen());
        }
    }

    public void listvehiculos(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_vehiculos",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        Vehiculo envio=null;
        VehiculosLista= new ArrayList<Vehiculo>();
        //
        Cursor cursor=dbs.rawQuery("SELECT IDVEHICULO FROM VEHICULOS WHERE IDCONDUCTOR=? ", new String[]{name});
        while (cursor.moveToNext()){
            envio=new Vehiculo();
            envio.setIdvehiculo(cursor.getString(0));
            VehiculosLista.add(envio);

        }

    }

    public void mapas(View v){

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }

}