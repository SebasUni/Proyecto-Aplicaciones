package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import unipiloto.edu.co.utilidades.Utilidades;

public class CrearUsuario extends AppCompatActivity {
    EditText nombre,apellido,correo,password, infoplacas,infoidpropietario;
    TextView placas,idpropietario;
    String rol;
    Spinner roles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        roles=findViewById(R.id.spinnerRoles);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.roles, android.R.layout.simple_spinner_item);
        roles.setAdapter(adapter);

        idpropietario =findViewById(R.id.textViewIdPropietario);

        infoidpropietario=findViewById(R.id.editTextIdPropietario);

        roles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //rol.setText(parent.getItemAtPosition(position).toString());
                rol=parent.getItemAtPosition(position).toString();
                if (position==1){

                    idpropietario.setVisibility(View.VISIBLE);
                    infoidpropietario.setVisibility(View.VISIBLE);

                }else{

                    idpropietario.setVisibility(View.INVISIBLE);
                    infoidpropietario.setVisibility(View.INVISIBLE);
                    infoidpropietario.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        nombre=(EditText) findViewById(R.id.editTextNombre);
        apellido=(EditText) findViewById(R.id.editTextTextApellido);
        correo=(EditText) findViewById(R.id.editTextTextCorreo);
        password=(EditText) findViewById(R.id.editTextTextPassword);
        roles=(Spinner) findViewById(R.id.spinnerRoles);




    }
    public void onClick(View v){
        registrarUsuario();


    }
    public void registrarUsuario(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios", null,1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_NOMBRE,nombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDO,apellido.getText().toString());
        values.put(Utilidades.CAMPO_CORREO,correo.getText().toString());
        values.put(Utilidades.CAMPO_PASSWORD,password.getText().toString());
        values.put(Utilidades.CAMPO_ROL,rol);
        values.put(Utilidades.CAMPO_IDPROPIETARIO,infoidpropietario.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_CORREO,values);

        Toast.makeText( getApplicationContext(),"Id Registro:"+ idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}