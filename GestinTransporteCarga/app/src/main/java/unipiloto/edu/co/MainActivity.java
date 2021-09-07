package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import unipiloto.edu.co.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {
EditText correo,password;
    String CorreoUsuario;
    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      conn = new ConexionSQLiteHelper(this,"bd_usuarios", null,1);
        correo= (EditText) findViewById(R.id.informacionCorreo);
        password= (EditText) findViewById(R.id.informacionPassword);

    }
    public void CrearUsuario(View v){
        Intent intent = new Intent(this,CrearUsuario.class);
        startActivity(intent);

    }
    public void Login(View v){
        consultar();
    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={correo.getText().toString()};
        String[] campos={Utilidades.CAMPO_CORREO,Utilidades.CAMPO_PASSWORD,Utilidades.CAMPO_ROL};
        Cursor cursor= db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_CORREO+"=?", parametros, null,null,null);
        cursor.moveToFirst();
        try {
            if (correo.getText().toString().equals(cursor.getString(0))){
                if (password.getText().toString().equals(cursor.getString(1))){
                    if (cursor.getString(2).equals("Cliente")){
                        CorreoUsuario=cursor.getString(0);
                        cursor.close();
                        Intent intent = new Intent(this,InicioCliente.class);
                        startActivity(intent);
                    }else{
                        if (cursor.getString(2).equals("Conductor")){}
                        else{
                            if (cursor.getString(2).equals("Conductor")){}
                        }
                    }

                }
            }
            cursor.close();
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "CORREO O PASSWORD INCORRECTO", Toast.LENGTH_LONG).show();
        }

    }

}
