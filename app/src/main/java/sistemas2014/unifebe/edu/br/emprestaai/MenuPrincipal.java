package sistemas2014.unifebe.edu.br.emprestaai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import sistemas2014.unifebe.edu.br.emprestaai.Controller.CadastroPesssoa;


public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        ImageButton btnCadastraAmigo = (ImageButton) findViewById(R.id.btnCadastraAmigo);
        btnCadastraAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CadastroPesssoa.class);
                startActivity(i);
            }
        });

       /* ImageButton btnConsultaAmigo = (ImageButton) findViewById(R.id.btnConsultaAmigo);
        btnConsultaAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ConsultaAmigo.class);
                startActivity(i);
            }
        });

        ImageButton btnEmprestimo = (ImageButton) findViewById(R.id.btnEmprestimo);
        btnEmprestimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CadastroEmprestimo.class);
                startActivity(i);
            }
        });

        ImageButton btnConsultaEmprestimo = (ImageButton) findViewById(R.id.btnConsultaEmprestimo);
        btnConsultaEmprestimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ConsultaEmprestimo.class);
                startActivity(i);
            }
        });

        ImageButton btnInformacoes = (ImageButton) findViewById(R.id.btnInformacoes);
        btnInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Informacoes.class);
                startActivity(i);
            }
        }); */
    }
}
