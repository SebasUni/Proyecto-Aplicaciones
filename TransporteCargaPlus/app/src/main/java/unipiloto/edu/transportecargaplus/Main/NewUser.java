package unipiloto.edu.transportecargaplus.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import unipiloto.edu.transportecargaplus.Controlador.ConexionSQLiteHelper;
import unipiloto.edu.transportecargaplus.Controlador.Utilidades;
import unipiloto.edu.transportecargaplus.Entidades.Usuario;
import unipiloto.edu.transportecargaplus.R;

public class NewUser extends AppCompatActivity {
    EditText nombre,apellido,correo,password,idpropietario;
    private ArrayList<Usuario> UsuarioLista;
    private ArrayList<String> ListaUsurio;
    Spinner roles;
    String rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        nombre= findViewById(R.id.NewEdiNombre);
        apellido= findViewById(R.id.NewEdiApellido);
        correo= findViewById(R.id.NewEdiEmail);
        password= findViewById(R.id.NewEdiPassword);
        idpropietario= findViewById(R.id.NewEdiIdpropietario);
        roles=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.roles, android.R.layout.simple_spinner_item);
        roles.setAdapter(adapter);


        roles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //rol.setText(parent.getItemAtPosition(position).toString());
                rol=parent.getItemAtPosition(position).toString();
                if (position==1){

                    //idpropietario.setVisibility(View.VISIBLE);
                    //infoidpropietario.setVisibility(View.VISIBLE);

                }else{

                   // idpropietario.setVisibility(View.INVISIBLE);
                    //infoidpropietario.setVisibility(View.INVISIBLE);
                   // infoidpropietario.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void registrarUsuario(View v){
        ListarUsuarios();
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios", null,1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_IDUSUARIO,UsuarioLista.size()+1);
        values.put(Utilidades.CAMPO_NOMBRE,nombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDO,apellido.getText().toString());
        values.put(Utilidades.CAMPO_CORREO,correo.getText().toString());
        values.put(Utilidades.CAMPO_PASSWORD,password.getText().toString());
        values.put(Utilidades.CAMPO_ROL,rol);
        values.put(Utilidades.CAMPO_IDPROPIETARIO,idpropietario.getText().toString());
        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_IDUSUARIO,values);

        Toast.makeText( getApplicationContext(),"Id Registro:"+ idResultante, Toast.LENGTH_SHORT).show();



    }
    public void ListarUsuarios(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_usuarios", null, 1);
        SQLiteDatabase dbs = conn.getReadableDatabase();
        Usuario envio=null;
        UsuarioLista= new ArrayList<Usuario>();

        Cursor cursor=dbs.rawQuery("SELECT * FROM USUARIO", null);
        while (cursor.moveToNext()){
           envio=new Usuario();
           envio.setIdusuario(cursor.getString(0));
           envio.setNombre(cursor.getString(1));
           envio.setApellido(cursor.getString(2));
           envio.setEmail(cursor.getString(3));
           envio.setPassword(cursor.getString(4));
           envio.setIdpropietario(cursor.getString(5));
           UsuarioLista.add(envio);

        }

    }


}
