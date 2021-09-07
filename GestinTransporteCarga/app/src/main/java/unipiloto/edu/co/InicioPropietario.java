package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicioPropietario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_propietario);
    }
    public void Solicitud(View v){
        Intent intent = new Intent(this,AceptacionSolicitudesPropietario.class);
        startActivity(intent);
    }
}