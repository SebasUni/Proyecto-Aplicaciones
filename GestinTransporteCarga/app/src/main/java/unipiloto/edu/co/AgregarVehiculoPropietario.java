package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import unipiloto.edu.co.utilidades.Utilidades;

public class AgregarVehiculoPropietario extends AppCompatActivity {
    EditText placa, marca;
    Bundle correoPropietario;
    String propietariol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_vehiculo_propietario);
        correoPropietario= getIntent().getExtras();
        propietariol=correoPropietario.getString("correoPropietario2");
        Log.d("prueba",propietariol);
        placa= findViewById(R.id.editAgregarPlaca);
        marca=findViewById(R.id.editAgregarMarca);
    }
    public void AgendarCarro(View v){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_carros", null,1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        correoPropietario= getIntent().getExtras();
        values.put(Utilidades.CAMPO_PLACA,placa.getText().toString());
        values.put(Utilidades.CAMPO_MARCA,marca.getText().toString());
        values.put(Utilidades.CAMPO_CORREOCARROS,correoPropietario.getString("correoPropietario2"));

        Long idResultante=db.insert(Utilidades.TABLA_CARROS,Utilidades.CAMPO_CORREO,values);

        Toast.makeText( getApplicationContext(),"Id Registro:"+ idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}