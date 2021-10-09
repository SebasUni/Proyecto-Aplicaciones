package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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

import unipiloto.edu.co.entidades.Carros;
import unipiloto.edu.co.entidades.Solicitud;
import unipiloto.edu.co.entidades.Usuario;
import unipiloto.edu.co.utilidades.Utilidades;

public class AsignacionConductor extends AppCompatActivity {
    Spinner Solicitudvehiculo,Solicitudconductores;

    ArrayList<String> ListaVehiculos;
    ArrayList<String> ListaConductores;
    ArrayList<Carros> VehiculosLista;
    ArrayList<Usuario> ConductoresLista;
    Bundle correoPropietario;
    ConexionSQLiteHelper conn;
    Button Asignar;
    EditText AsigNombre,AsignApellido,AsigPlaca,AsigMarca;
    String usurio,PLACAP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_conductor);


        Solicitudconductores=(Spinner) findViewById(R.id.spinnerConductores);
        Solicitudvehiculo=(Spinner) findViewById(R.id.spinnerVehiculos);
        correoPropietario= getIntent().getExtras();
        AsigNombre= findViewById(R.id.TextAsigNombre);
        AsignApellido=findViewById(R.id.TextAsigApellido);
        AsigPlaca=findViewById(R.id.TextAsigPlaca);
        AsigMarca=findViewById(R.id.TextAsigMarca);

        Asignar=findViewById(R.id.buttonAsignar);

        listvehiculos1(correoPropietario.getString("correoPropietario2"));
        ArrayAdapter<CharSequence> adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaConductores);
        Solicitudconductores.setAdapter(adapter1);

        Solicitudconductores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position!=0){
                    AsigNombre.setText(ConductoresLista.get(position-1).getNombre());
                    AsignApellido.setText(ConductoresLista.get(position-1).getApellido());
                    usurio=ConductoresLista.get(position-1).getCorreo();
                }else{
                    AsigNombre.setText("");
                    AsignApellido.setText("");
                    usurio="";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        listvehiculos(correoPropietario.getString("correoPropietario2"));
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaVehiculos);
        Solicitudvehiculo.setAdapter(adapter);
        Solicitudvehiculo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position!=0){
                    AsigPlaca.setText(VehiculosLista.get(position-1).getPlaca());
                    AsigMarca.setText(VehiculosLista.get(position-1).getMarca());
                    PLACAP=VehiculosLista.get(position-1).getPlaca();
                }else{
                    AsigPlaca.setText("");
                    AsigMarca.setText("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Asignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             asignarConducor();
            }
        });
    }
    public void listvehiculos(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_carros",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        Carros envio=null;
        VehiculosLista= new ArrayList<Carros>();
        //
        Cursor cursor=dbs.rawQuery("SELECT * FROM CARROS WHERE CORREOCARROS=? ", new String[]{name});
        while (cursor.moveToNext()){
            envio=new Carros();
            envio.setPlaca(cursor.getString(0));
            envio.setCorreocarros(cursor.getString(1));
            envio.setMarca(cursor.getString(2));
            envio.setConductor(cursor.getString(3));
            VehiculosLista.add(envio);

        }
        obtenerLista();
    }

    private void obtenerLista() {
        ListaVehiculos=new ArrayList<String>();
        ListaVehiculos.add("Slecciones");
        for (int i=0;i<VehiculosLista.size();i++){
            ListaVehiculos.add("Placa: "+VehiculosLista.get(i).getPlaca());
        }
    }
    private void asignarConducor(){
        SQLiteDatabase dbs = conn.getWritableDatabase();
        String[] parametro = {PLACAP};
        ContentValues values =new ContentValues();
        Log.d("prueba1",PLACAP);
        values.put(Utilidades.CAMPO_CONDUCTOR,usurio);
        dbs.update(Utilidades.TABLA_CARROS,values,Utilidades.CAMPO_PLACA+"=?",parametro);
        Toast.makeText(getApplicationContext(),"se actualizo",Toast.LENGTH_LONG).show();
        dbs.close();


    }

    public void listvehiculos1(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        Usuario envio=null;
        ConductoresLista= new ArrayList<Usuario>();
        //
        Cursor cursor=dbs.rawQuery("SELECT * FROM USUARIO WHERE Idpropietario=? ", new String[]{name});
        while (cursor.moveToNext()){
            envio=new Usuario();
            envio.setNombre(cursor.getString(0));
            envio.setApellido(cursor.getString(1));
            envio.setCorreo(cursor.getString(2));
            envio.setPassword(cursor.getString(3));
            envio.setRol(cursor.getString(4));
            envio.setIdpropietario(cursor.getString(5));

            ConductoresLista.add(envio);

        }
        obtenerLista1();
    }

    private void obtenerLista1() {
        ListaConductores=new ArrayList<String>();
        ListaConductores.add("Slecciones");
        for (int i=0;i<ConductoresLista.size();i++){
            ListaConductores.add("Nombre: "+ConductoresLista.get(i).getNombre());
        }
    }
}