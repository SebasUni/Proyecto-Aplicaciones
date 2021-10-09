package unipiloto.edu.transportecargaplus.Conductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import unipiloto.edu.transportecargaplus.Propietario.AgregarCarro;
import unipiloto.edu.transportecargaplus.R;

public class MainConductor extends AppCompatActivity {
    String s;
    Bundle  IdConductor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_conductor);
        IdConductor= getIntent().getExtras();
        s= IdConductor.getString("IdConductor");
        Log.d("prueba",s);
    }
    public void Viajes(View v){
        Intent intent = new Intent(this, Viajes.class);
        intent.putExtra("IdConductor",IdConductor.getString("IdConductor"));
        startActivity(intent);

    }
}