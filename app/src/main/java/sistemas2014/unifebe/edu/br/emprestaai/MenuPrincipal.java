package sistemas2014.unifebe.edu.br.emprestaai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import sistemas2014.unifebe.edu.br.emprestaai.Controller.CadastroEmprestimo;
import sistemas2014.unifebe.edu.br.emprestaai.Controller.CadastroItens;
import sistemas2014.unifebe.edu.br.emprestaai.Controller.CadastroPesssoa;
import sistemas2014.unifebe.edu.br.emprestaai.Controller.ConsultaEmprestimo;
import sistemas2014.unifebe.edu.br.emprestaai.Controller.ConsultaPessoa;


public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        ImageButton btnCadastraAmigo = (ImageButton) findViewById(R.id.btnCadastroPessoa);
        btnCadastraAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CadastroPesssoa.class);
                startActivity(i);
            }
        });

        ImageButton btnItens = (ImageButton) findViewById(R.id.btnItens);
        btnItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CadastroItens.class);
                startActivity(i);
            }
        });

        ImageButton btnEmprestimos = (ImageButton) findViewById(R.id.btnEmprestimo);
        btnEmprestimos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CadastroEmprestimo.class);
                startActivity(i);
            }
        });

        ImageButton btnConsultaAmigo = (ImageButton) findViewById(R.id.btnConsultaPessoa);
        btnConsultaAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ConsultaPessoa.class);
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
    }
}
