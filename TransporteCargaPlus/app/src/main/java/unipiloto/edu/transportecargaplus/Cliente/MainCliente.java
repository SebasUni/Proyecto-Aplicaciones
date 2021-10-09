package unipiloto.edu.transportecargaplus.Cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import unipiloto.edu.transportecargaplus.Propietario.AgregarCarro;
import unipiloto.edu.transportecargaplus.R;

public class MainCliente extends AppCompatActivity {
    String s;
    Bundle IdCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cliente);
        IdCliente= getIntent().getExtras();
        s=IdCliente.getString("IdCliente");
        Log.d("prueba",s);

    }

    public void ButonSolicitartransportecarga(View v){
        Intent intent = new Intent(this, SolicitarTransporte.class);
        intent.putExtra("IdCliente",IdCliente.getString("IdCliente"));
        startActivity(intent);

    }
    public void Butoninformacion(View v){
        Intent intent = new Intent(this, InformacionCarga.class);
        intent.putExtra("IdCliente",IdCliente.getString("IdCliente"));
        startActivity(intent);

    }
    public void Butonhistorial(View v){
        Intent intent = new Intent(this, HistorialCarga.class);
        intent.putExtra("IdCliente",IdCliente.getString("IdCliente"));
        startActivity(intent);

    }
}