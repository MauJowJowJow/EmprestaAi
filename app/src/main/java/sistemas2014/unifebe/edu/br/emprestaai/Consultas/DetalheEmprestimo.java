package sistemas2014.unifebe.edu.br.emprestaai.Consultas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import sistemas2014.unifebe.edu.br.emprestaai.MenuPrincipal;
import sistemas2014.unifebe.edu.br.emprestaai.Model.DAO.EmprestimoDAO;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class DetalheEmprestimo extends AppCompatActivity {
    Emprestimo emprestimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_emprestimo);

        Button btnDelete = (Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmprestimoDAO emprestimoDAO = new EmprestimoDAO(getApplicationContext());
                emprestimoDAO.deleteById(emprestimo.get_id());

                Toast.makeText(getApplicationContext(),
                        "Registro excluído com sucesso", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity (i);
                finish();
            }
        });

        if (getIntent().getExtras() != null){
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO(getApplicationContext());
            emprestimo = emprestimoDAO.getById(getIntent().getExtras().getInt("id"));

            TextView txtAmigo = (TextView)findViewById(R.id.txtAmigo);
            txtAmigo.setText(emprestimo.getAmigo().getNome());

            TextView txtItem = (TextView)findViewById(R.id.txtItem);
            txtItem.setText(emprestimo.getItem());
        }
    }
}
