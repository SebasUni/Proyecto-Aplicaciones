package unipiloto.edu.transportecargaplus.Propietario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CpuUsageInfo;
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
import unipiloto.edu.transportecargaplus.Entidades.Usuario;
import unipiloto.edu.transportecargaplus.Entidades.Vehiculo;
import unipiloto.edu.transportecargaplus.R;

public class AsignarConductor extends AppCompatActivity {
    Button asignar;
    String s,usuario,PLACAP;
    Bundle  IdPropietario;
    Spinner SpinerListaVehiculos,SpinerUsuarios;
    ArrayList<String> ListaVehiculos;
    ConexionSQLiteHelper conn;
    EditText placa,marca,conductor, nombre, apellido;
   ArrayList<Vehiculo> VehiculosLista;
    private ArrayList<Usuario> UsuarioLista;
    private ArrayList<String> ListaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_conductor);
        IdPropietario= getIntent().getExtras();
        s= IdPropietario.getString("IdPropietario");
        Log.d("prueba",s);

        placa=findViewById(R.id.EditPlacaAsignacion);
        marca= findViewById(R.id.EditMarcaAsignacion);
        conductor=findViewById(R.id.EditConductorAsignacion);

        nombre=findViewById(R.id.editTextNombre);
        apellido=findViewById(R.id.editTextApellido);

        asignar=findViewById(R.id.button10);

        SpinerListaVehiculos=findViewById(R.id.ListaVehiculos);
        SpinerUsuarios=findViewById(R.id.spinnerConductores);

        listvehiculos(IdPropietario.getString("IdPropietario"));
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaVehiculos);
        SpinerListaVehiculos.setAdapter(adapter);

        SpinerListaVehiculos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position != 0){
                    placa.setText(VehiculosLista.get(position-1).getPlaca());
                    marca.setText(VehiculosLista.get(position-1).getMarca());
                    conductor.setText(VehiculosLista.get(position-1).getIdconductor());
                    PLACAP=VehiculosLista.get(position-1).getPlaca();
                }else{
                    placa.setText("");
                    marca.setText("");
                    conductor.setText("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listUsuarios(IdPropietario.getString("IdPropietario"));
        ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaUsuario);
        SpinerUsuarios.setAdapter(adapter2);

        SpinerUsuarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position != 0){
                    nombre.setText(UsuarioLista.get(position-1).getNombre());
                    apellido.setText(UsuarioLista.get(position-1).getApellido());
                    usuario=UsuarioLista.get(position-1).getIdusuario();
                }else{
                    nombre.setText("");
                    apellido.setText("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    asignar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            asignarConducor();
        }
    });


    }

    public void listvehiculos(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_vehiculos",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        Vehiculo envio=null;
        VehiculosLista= new ArrayList<Vehiculo>();
        //
        Cursor cursor=dbs.rawQuery("SELECT * FROM VEHICULOS WHERE IDPROPIETARIO=? ", new String[]{name});
        while (cursor.moveToNext()){
            envio=new Vehiculo();
            envio.setIdvehiculo(cursor.getString(0));
            envio.setPlaca(cursor.getString(1));
            envio.setMarca(cursor.getString(2));
            envio.setIdpropietario(cursor.getString(3));
            envio.setIdconductor(cursor.getString(4));
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


    public void listUsuarios(String name){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        Usuario envio=null;
        UsuarioLista= new ArrayList<Usuario>();
        //
        Cursor cursor=dbs.rawQuery("SELECT * FROM USUARIO WHERE IDPROPIETARIO=? ", new String[]{name});
        while (cursor.moveToNext()){
            envio=new Usuario();
            envio.setIdusuario(cursor.getString(0));
            envio.setNombre(cursor.getString(1));
            envio.setApellido(cursor.getString(2));
            envio.setEmail(cursor.getString(3));
            envio.setPassword(cursor.getString(4));
            envio.setRol(cursor.getString(5));
            envio.setIdpropietario(cursor.getString(6));
            UsuarioLista.add(envio);

        }
        obtenerLista2();
    }
    private void obtenerLista2() {

        ListaUsuario=new ArrayList<String>();
        ListaUsuario.add("Slecciones");
        for (int i=0;i<UsuarioLista.size();i++){
            ListaUsuario.add("Nombre: "+UsuarioLista.get(i).getNombre());
        }
    }


    private void asignarConducor(){
        conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_vehiculos",null,1);
        SQLiteDatabase dbs = conn.getWritableDatabase();
        String[] parametro = {PLACAP};
        Log.d("prueba1",PLACAP);
        ContentValues values =new ContentValues();
        values.put(Utilidades.CAMPO_IDCONDUCTOR,usuario);
        dbs.update(Utilidades.TABLA_VEHICULO,values,Utilidades.CAMPO_PLACA+"=?",parametro);
        Toast.makeText(getApplicationContext(),"se actualizo",Toast.LENGTH_LONG).show();
       // dbs.close();


    }

}