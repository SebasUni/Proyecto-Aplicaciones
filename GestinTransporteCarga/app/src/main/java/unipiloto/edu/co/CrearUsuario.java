package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import unipiloto.edu.co.utilidades.Utilidades;

public class CrearUsuario extends AppCompatActivity {
    EditText nombre,apellido,correo,password,id;
     CheckBox rol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        nombre=(EditText) findViewById(R.id.editTextNombre);
        apellido=(EditText) findViewById(R.id.editTextTextApellido);
        correo=(EditText) findViewById(R.id.editTextTextCorreo);
        password=(EditText) findViewById(R.id.editTextTextPassword);
        rol=findViewById(R.id.checkBox2);

    }
    public void cre(){
        registrarUsuario();

    }
    public void registrarUsuario(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios", null,1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.NOMBRE,nombre.getText().toString());
        values.put(Utilidades.APELLIDO,apellido.getText().toString());
        values.put(Utilidades.CORREO,correo.getText().toString());
        values.put(Utilidades.PASSWORD,password.getText().toString());
        values.put(Utilidades.ROL,rol.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CORREO,values);

        Toast.makeText( getApplicationContext(),"Id Registro:"+ idResultante, Toast.LENGTH_SHORT).show();

    }
}