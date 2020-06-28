package cl.org.gestion_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.org.gestion_usuario.model.RamStorage;

public class MostrarUsuario extends AppCompatActivity {
    private TextView lblMostrarNombre;
    private TextView lblMostrarApellido;
    private TextView lblMostrarRun;
    private TextView lblMostrarEdad;
    private TextView lblMostrarSexo;
    private TextView lblMostrarGeneroJuego;
    private TextView lblPrimerRegistro;
    private TextView lblRegistroActual;
    private TextView lblUltimoRegistro;
    private Button btnVolverMain2;
    private Button btnBotonAnterior;
    private Button btnBotonSiguiente;
    private int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuario);

        lblMostrarNombre = findViewById(R.id.lblMostrarNombre);
        lblMostrarApellido = findViewById(R.id.lblMostrarApellido);
        lblMostrarRun = findViewById(R.id.lblMostrarRun);
        lblMostrarEdad = findViewById(R.id.lblMostrarEdad);
        lblMostrarSexo = findViewById(R.id.lblMostrarSexo);
        lblMostrarGeneroJuego = findViewById(R.id.lblMostrarGeneroJuego);
        lblPrimerRegistro = findViewById(R.id.lblPrimerRegistro);
        lblRegistroActual = findViewById(R.id.lblRegistroActual);
        lblUltimoRegistro = findViewById(R.id.lblUltimoRegistro);
        btnVolverMain2 = findViewById(R.id.btnVolverMain2);
        btnBotonAnterior = findViewById(R.id.btnBotonAnterior);
        btnBotonSiguiente = findViewById(R.id.btnBotonSiguiente);
        cont = 0;

        int ultimoReg = RamStorage.listaUsuarios.size();
        lblUltimoRegistro.setText(""+ultimoReg);

        if(RamStorage.listaUsuarios.size() > 0){
            lblPrimerRegistro.setText("1");
            lblRegistroActual.setText("1");

            lblMostrarNombre.setText(RamStorage.listaUsuarios.get(0).getNombre());
            lblMostrarApellido.setText(RamStorage.listaUsuarios.get(0).getApellido());
            lblMostrarRun.setText(RamStorage.listaUsuarios.get(0).getRun());
            lblMostrarSexo.setText(RamStorage.listaUsuarios.get(0).getSexo());
            lblMostrarEdad.setText(""+RamStorage.listaUsuarios.get(0).getEdad());
            lblMostrarGeneroJuego.setText(RamStorage.listaUsuarios.get(0).getGenero_jf());
        }else if (RamStorage.listaUsuarios.size() == 0){
            lblPrimerRegistro.setText("N/A");
            lblRegistroActual.setText("N/A");

            lblMostrarNombre.setText("N/A");
            lblMostrarApellido.setText("N/A");
            lblMostrarRun.setText("N/A");
            lblMostrarSexo.setText("N/A");
            lblMostrarEdad.setText("N/A");
            lblMostrarGeneroJuego.setText("N/A");
        }
        
        volver();
        nextReg();
        prevReg();
    }

    private void nextReg() {
        btnBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambUsuario(1);
            }
        });
    }

    private void prevReg() {
        btnBotonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambUsuario(-1);
            }
        });
    }

    private void volver() {
        btnVolverMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainMenu);
                finish();
            }
        });
    }

    private void cambUsuario(int index) {
        cont = cont + index;

        if((cont >= 0) && (cont <= RamStorage.listaUsuarios.size()-1)){

            if(cont > RamStorage.listaUsuarios.size()){
                cont = cont + index - 1;
                lblMostrarNombre.setText(RamStorage.listaUsuarios.get(cont).getNombre());
                lblMostrarApellido.setText(RamStorage.listaUsuarios.get(cont).getApellido());
                lblMostrarRun.setText(RamStorage.listaUsuarios.get(cont).getRun());
                lblMostrarSexo.setText(RamStorage.listaUsuarios.get(cont).getSexo());
                lblMostrarEdad.setText(""+RamStorage.listaUsuarios.get(cont).getEdad());
                lblMostrarGeneroJuego.setText(RamStorage.listaUsuarios.get(cont).getGenero_jf());
                lblRegistroActual.setText(""+cont);
            }

            int ncont = cont+=1;
            lblRegistroActual.setText(""+ncont);

            lblMostrarNombre.setText(RamStorage.listaUsuarios.get(cont).getNombre());
            lblMostrarApellido.setText(RamStorage.listaUsuarios.get(cont).getApellido());
            lblMostrarRun.setText(RamStorage.listaUsuarios.get(cont).getRun());
            lblMostrarSexo.setText(RamStorage.listaUsuarios.get(cont).getSexo());
            lblMostrarEdad.setText(""+RamStorage.listaUsuarios.get(cont).getEdad());
            lblMostrarGeneroJuego.setText(RamStorage.listaUsuarios.get(cont).getGenero_jf());
        }
    }
}
