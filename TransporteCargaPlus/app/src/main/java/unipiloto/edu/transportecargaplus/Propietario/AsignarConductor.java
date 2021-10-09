package unipiloto.edu.transportecargaplus.Propietario;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import unipiloto.edu.transportecargaplus.Controlador.ConexionSQLiteHelper;
import unipiloto.edu.transportecargaplus.Entidades.Usuario;
import unipiloto.edu.transportecargaplus.Entidades.Vehiculo;
import unipiloto.edu.transportecargaplus.R;

public class AsignarConductor extends AppCompatActivity {

    String s;
    Bundle  IdPropietario;
    Spinner SpinerListaVehiculos,SpinerUsuarios;
    ArrayList<String> ListaVehiculos;
    ConexionSQLiteHelper conn;
    EditText placa,marca,conductor;
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
                }else{

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listUsuarios(IdPropietario.getString("IdPropietario"));
        ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaUsuario);
        SpinerUsuarios.setAdapter(adapter2);


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
            ListaUsuario.add("Nombre: "+UsuarioLista.get(i).getNombre()+" Apellido: "+UsuarioLista.get(i).getApellido());
        }
    }

}