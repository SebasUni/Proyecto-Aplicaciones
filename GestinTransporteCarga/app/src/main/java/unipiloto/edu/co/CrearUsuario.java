package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import unipiloto.edu.co.utilidades.Utilidades;

public class CrearUsuario extends AppCompatActivity {
    EditText nombre,apellido,correo,password,rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        nombre=(EditText) findViewById(R.id.editTextNombre);
        apellido=(EditText) findViewById(R.id.editTextTextApellido);
        correo=(EditText) findViewById(R.id.editTextTextCorreo);
        password=(EditText) findViewById(R.id.editTextTextPassword);
        rol=(EditText) findViewById(R.id.editTextTextTipo);


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
        values.put(Utilidades.CAMPO_ROL,rol.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_CORREO,values);

        Toast.makeText( getApplicationContext(),"Id Registro:"+ idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}