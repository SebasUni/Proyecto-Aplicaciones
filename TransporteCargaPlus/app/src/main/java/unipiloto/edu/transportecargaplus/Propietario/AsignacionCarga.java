package unipiloto.edu.transportecargaplus.Propietario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import unipiloto.edu.transportecargaplus.Controlador.ConexionSQLiteHelper;
import unipiloto.edu.transportecargaplus.Controlador.Utilidades;
import unipiloto.edu.transportecargaplus.Entidades.SolicitudVehicular;
import unipiloto.edu.transportecargaplus.Entidades.Vehiculo;
import unipiloto.edu.transportecargaplus.Main.NewUser;
import unipiloto.edu.transportecargaplus.R;

public class AsignacionCarga extends AppCompatActivity {
    String s;
    Bundle  IdPropietario;
    ConexionSQLiteHelper conn;
    Spinner spinerCarga,spinervehiculo;
    EditText origen,destino,dimenciones;
    Button asignar;
    private ArrayList<SolicitudVehicular> CargaLista;
    private ArrayList<String> ListaCarga;
    private ArrayList<Vehiculo> VehiculoLista;
    private ArrayList<String> ListaVehiculo;
    String idsolicitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_carga);
        IdPropietario= getIntent().getExtras();
        s= IdPropietario.getString("IdPropietario");
        Log.d("prueba",s);
        origen=findViewById(R.id.EditOrigenCarga);
        destino=findViewById(R.id.EditDestinoCarga);
        asignar=findViewById(R.id.buttonasiganrcarga);


        spinerCarga=findViewById(R.id.spinnerCarga);
        spinervehiculo=findViewById(R.id.spinnerVehiculos);
        listcarga("En proceso");
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaCarga);
        spinerCarga.setAdapter(adapter);
        spinerCarga.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position !=0){
                    origen.setText(CargaLista.get(position-1).getDireccionOrigen());
                    destino.setText(CargaLista.get(position-1).getDireccionOrigen());
                    idsolicitud=CargaLista.get(position-1).getIdSolitud();
                }else{
                    origen.setText("");
                    destino.setText("");
                    idsolicitud="";

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listaVehiculos(IdPropietario.getString("IdPropietario"));
        ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaVehiculo);
        spinervehiculo.setAdapter(adapter2);

        asignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            actualizarSolicitud();
             atras();
            }
        });

    }
    public void listcarga(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_solicitud",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        SolicitudVehicular envio=null;
        CargaLista= new ArrayList<SolicitudVehicular>();
        //
        Cursor cursor=dbs.rawQuery("SELECT * FROM SOLICITUD WHERE ESTADO=? ", new String[]{name});
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

    public void listaVehiculos(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_vehiculos",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        Vehiculo envio=null;
        VehiculoLista= new ArrayList<Vehiculo>();
        //
        Cursor cursor=dbs.rawQuery("SELECT * FROM VEHICULOS WHERE IDPROPIETARIO=? ", new String[]{name});
        while (cursor.moveToNext()){
            envio=new Vehiculo();
            envio.setIdvehiculo(cursor.getString(0));
            envio.setPlaca(cursor.getString(1));
            envio.setMarca(cursor.getString(2));
            envio.setIdpropietario(cursor.getString(3));
            envio.setIdconductor(cursor.getString(4));
            VehiculoLista.add(envio);

        }
        obtenerLista2();
    }

    public void obtenerLista2() {
        ListaVehiculo=new ArrayList<String>();
        ListaVehiculo.add("Slecciones");
        for (int i=0;i<VehiculoLista.size();i++){
            ListaVehiculo.add("PLACA: "+VehiculoLista.get(i).getPlaca());
        }
    }

    public void actualizarSolicitud(){
             conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_solicitud",null,1);
            SQLiteDatabase dbs = conn.getWritableDatabase();
            String[] parametro = {idsolicitud};
            ContentValues values =new ContentValues();
            Log.d("prueba1",idsolicitud);
            values.put(Utilidades.CAMPO_ESTADO,"Carga Asignada");
             values.put(Utilidades.CAMPO_IDVEHICULO,"1");
            dbs.update(Utilidades.TABLA_SOLICITUD,values,Utilidades.CAMPO_IDSOLICITUD+"=?",parametro);
            Toast.makeText(getApplicationContext(),"se actualizo",Toast.LENGTH_LONG).show();
            dbs.close();




    }
    public void atras (){

        finish();

    }
}