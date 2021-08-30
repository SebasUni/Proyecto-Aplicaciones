package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicioCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_cliente);
    }
    public void SolicitudTrasporte(View v){
        Intent intent = new Intent(this,SolicituTransporteCliente.class);
        startActivity(intent);

    }
    public void inicio(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}