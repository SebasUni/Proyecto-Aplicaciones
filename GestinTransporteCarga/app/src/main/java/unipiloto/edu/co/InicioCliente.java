package unipiloto.edu.co;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class InicioCliente extends AppCompatActivity {
    String s;
    Bundle correoCliente;
    private Button salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_cliente);
        correoCliente= getIntent().getExtras();
        salir=(Button) findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(InicioCliente.this);
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
        s=correoCliente.getString("correoCliente");
        Log.d("prueba",s);
    }
    public void SolicitudTrasporte(View v){
        Intent intent = new Intent(this,SolicituTransporteCliente.class);
        intent.putExtra("correoCliente2",s);
        startActivity(intent);

    }
    public void inicio(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}