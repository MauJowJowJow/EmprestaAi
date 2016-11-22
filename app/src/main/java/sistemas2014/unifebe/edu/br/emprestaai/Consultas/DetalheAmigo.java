package sistemas2014.unifebe.edu.br.emprestaai.Consultas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import sistemas2014.unifebe.edu.br.emprestaai.Modelos.Amigo;
import sistemas2014.unifebe.edu.br.emprestaai.Modelos.DAO.AmigoDAO;
import sistemas2014.unifebe.edu.br.emprestaai.Modelos.DAO.EmprestimoDAO;
import sistemas2014.unifebe.edu.br.emprestaai.Modelos.Emprestimo;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class DetalheAmigo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_amigo);

        if (getIntent().getExtras() != null){
            AmigoDAO amigoDAO = new AmigoDAO(getApplicationContext());
            Amigo amigo = amigoDAO.getById(getIntent().getExtras().getInt("id"));

            TextView txtNome = (TextView)findViewById(R.id.txtNome);
            txtNome.setText(amigo.getNome());

            TextView txtEmail = (TextView)findViewById(R.id.txtEmail);
            txtEmail.setText(amigo.getEmail());

            TextView txtCidade = (TextView)findViewById(R.id.txtCidade);
            txtCidade.setText(amigo.getCidade());

            TextView txtResidencial = (TextView)findViewById(R.id.txtTelefoneResidencial);
            txtResidencial.setText(amigo.getTelefoneResidencial());

            TextView txtCelular = (TextView)findViewById(R.id.txtTelefoneCelular);
            txtCelular.setText(amigo.getTelefoneCelular());
        }
    }
}
