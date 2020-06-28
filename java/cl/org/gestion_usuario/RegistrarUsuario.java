package cl.org.gestion_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import cl.org.gestion_usuario.model.RamStorage;
import cl.org.gestion_usuario.model.Usuario;

public class RegistrarUsuario extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtRun;
    private EditText txtEdad;
    private Switch swiSexo;
    private Spinner spiGeneroFavorito;
    private Button btnRegistrar;
    private Button btnVolver;
    private TextView lblCantidadUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtRun = findViewById(R.id.txtRun);
        txtEdad = findViewById(R.id.txtEdad);
        swiSexo = findViewById(R.id.swiSexo);
        spiGeneroFavorito = findViewById(R.id.spiGeneroJuego);
        btnRegistrar = findViewById(R.id.btnRegistrarUsuario);
        btnVolver = findViewById(R.id.btnVolverMain);
        lblCantidadUsuarios = findViewById(R.id.lblCantidadUsuarios);

        main();
        volver();
    }

    private void main() {
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre;
                String apellido;
                String run;
                String genero_favorito;
                String sexo;
                int edad;

                nombre = txtNombre.getText().toString();
                apellido = txtApellido.getText().toString();
                run = txtRun.getText().toString();
                edad = Integer.valueOf(txtEdad.getText().toString());

                if(swiSexo.isChecked()){
                    sexo = "Femenino";
                }else{
                    sexo = "Masculino";
                }

                genero_favorito = spiGeneroFavorito.getSelectedItem().toString();

                Usuario usr = new Usuario(nombre,apellido,run,edad,sexo,genero_favorito);

                RamStorage.listaUsuarios.add(usr);

                lblCantidadUsuarios.setText(""+RamStorage.listaUsuarios.size());
            }
        });
    }

    private void volver() {
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainMenu);
                finish();
            }
        });
    }

}
