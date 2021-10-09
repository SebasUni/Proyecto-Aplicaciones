package unipiloto.edu.transportecargaplus.Cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import unipiloto.edu.transportecargaplus.Controlador.ConexionSQLiteHelper;
import unipiloto.edu.transportecargaplus.Entidades.SolicitudVehicular;
import unipiloto.edu.transportecargaplus.Entidades.Vehiculo;
import unipiloto.edu.transportecargaplus.R;

public class InformacionCarga extends AppCompatActivity {
    ConexionSQLiteHelper conn;
    String s;
    Bundle  IdPropietario;
    private ArrayList<SolicitudVehicular> solicitudLista;
    private ArrayList<String> ListaSolicitud;
    Spinner informacion;
    EditText origen, destino,estado,placa,marca;
    private ArrayList<Vehiculo> VehiculoLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_carga);
        IdPropietario= getIntent().getExtras();
        s= IdPropietario.getString("IdCliente");
        Log.d("prueba",s);
        origen=findViewById(R.id.EditOrigeninformacion);
        destino=findViewById(R.id.EditDestinoInformacion);
        estado=findViewById(R.id.EditEstadoInformacion);
        placa=findViewById(R.id.EditPlacaInfromacion);
        marca=findViewById(R.id.EditMarcaInformacion);


        informacion=findViewById(R.id.spinnerListasoliciud);
        listaSolicitud(IdPropietario.getString("IdCliente"));
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaSolicitud);
        informacion.setAdapter(adapter);

        informacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position !=0){
                    origen.setText(solicitudLista.get(position-1).getDireccionOrigen());
                    destino.setText(solicitudLista.get(position-1).getDireccionDestino());
                    estado.setText(solicitudLista.get(position-1).getEstado());
                    if(estado.getText().toString().equals("En proceso")){
                        estado.setTextColor(Color.RED);
                    }else{
                        estado.setTextColor(Color.GREEN);
                    }

                    solicitudLista.get(position-1).getIdvehiculo();
                    if (!solicitudLista.get(position-1).getIdvehiculo().equals("Sin Asignar")){
                        listaSolicitud2(solicitudLista.get(position-1).getIdvehiculo());
                          placa.setText(VehiculoLista.get(0).getPlaca());
                         marca.setText(VehiculoLista.get(0).getMarca());
                        Log.d("prueba","entro");
                    }else{
                        placa.setText("Vehiculo sin asignar");
                        marca.setText("Vehiculo sin asignar");
                    }

                }else{
                    origen.setText("");
                    destino.setText("");
                    estado.setText("");
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

    public void listaSolicitud2(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_vehiculos",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        Vehiculo envio=null;
        VehiculoLista= new ArrayList<Vehiculo>();
        //
        Cursor cursor=dbs.rawQuery("SELECT * FROM VEHICULOS WHERE IDVEHICULO=? ", new String[]{name});
        while (cursor.moveToNext()){
            envio=new Vehiculo();
            envio.setIdvehiculo(cursor.getString(0));
            envio.setPlaca(cursor.getString(1));
            envio.setMarca(cursor.getString(2));
            envio.setIdpropietario(cursor.getString(3));
            envio.setIdconductor(cursor.getString(4));
            VehiculoLista.add(envio);

        }
        obtenerLista();
    }


}