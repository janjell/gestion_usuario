package cl.org.gestion_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import cl.org.gestion_usuario.model.RamStorage;
import cl.org.gestion_usuario.model.Usuario;

public class ListarUsuario extends AppCompatActivity {
    private ListView lsvUsuariosRegistrados;
    private Button btnVolverMain3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);

        btnVolverMain3 = findViewById(R.id.btnVolverMain3);
        lsvUsuariosRegistrados = findViewById(R.id.lsvUsuariosRegistrados);
        volver();

        ArrayAdapter adu = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RamStorage.listaUsuarios);
        lsvUsuariosRegistrados.setAdapter(adu);
    }

    private void volver() {
        btnVolverMain3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainMenu);
                finish();
            }
        });
    }

}
