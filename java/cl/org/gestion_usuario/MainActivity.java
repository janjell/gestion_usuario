package cl.org.gestion_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnVerRegistrarUsuario;
    private Button btnVerMostrarUsuario;
    private Button btnVerListarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVerListarUsuario = findViewById(R.id.btnVerListarUsuario);
        btnVerMostrarUsuario = findViewById(R.id.btnVerMostrarUsuario);
        btnVerRegistrarUsuario = findViewById(R.id.btnVerRegistrarUsuario);
        activityListarUsuario();
        activityMostrarUsuario();
        activityRegistrarUsuario();
    }

    private void activityRegistrarUsuario() {
        btnVerRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegistrarUsr = new Intent(getApplicationContext(), RegistrarUsuario.class);
                startActivity(RegistrarUsr);
                finish();
            }
        });
    }

    private void activityMostrarUsuario() {
        btnVerMostrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MostrarUsr = new Intent(getApplicationContext(), MostrarUsuario.class);
                startActivity(MostrarUsr);
                finish();
            }
        });
    }

    private void activityListarUsuario() {
        btnVerListarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ListarUsr = new Intent(getApplicationContext(), ListarUsuario.class);
                startActivity(ListarUsr);
                finish();
            }
        });
    }
}
