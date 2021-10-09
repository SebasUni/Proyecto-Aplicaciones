package unipiloto.edu.co;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class InicioPropietario extends AppCompatActivity {
    private Button salir1;
    Bundle correoPropietarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_propietario);
        salir1=(Button) findViewById(R.id.salir1);


        salir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(InicioPropietario.this);
                alerta.setMessage("Desea salir de la aplicacion")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                inicio();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog titulo=alerta.create();
                titulo.setTitle("Salida");
                titulo.show();
            }
        });
        correoPropietarios= getIntent().getExtras();

        Log.d("prueba2",correoPropietarios.getString("correoPropietario"));

    }
    public void Solicitud(View v){
        Intent intent = new Intent(this,AceptacionSolicitudesPropietario.class);
        startActivity(intent);
    }
    public void inicio(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    public void RegistrarCarro(View v){
        Intent intent = new Intent(this,AgregarVehiculoPropietario.class);
        intent.putExtra("correoPropietario2",correoPropietarios.getString("correoPropietario"));
        startActivity(intent);

    }
    public void AsignarVehiculo(View v){
        Intent intent = new Intent(this,AsignacionConductor.class);
        intent.putExtra("correoPropietario2",correoPropietarios.getString("correoPropietario"));
        startActivity(intent);

    }
}