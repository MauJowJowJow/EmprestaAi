package sistemas2014.unifebe.edu.br.emprestaai.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import sistemas2014.unifebe.edu.br.emprestaai.Model.Pessoa;
import sistemas2014.unifebe.edu.br.emprestaai.R;

/**
 * Created by dougl on 05/12/2016.
 */

public class DetalhePessoa extends Activity {

    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pessoa);

        if(getIntent().getExtras() != null){
            pessoa = pessoa.findById(Pessoa.class, getIntent().getExtras().getLong("id"));

            TextView txtnome = (TextView)findViewById(R.id.txtNomeDet);
            TextView txtBairro = (TextView) findViewById(R.id.txtBairroDet);
            TextView txtCep = (TextView) findViewById(R.id.txtCEPDet);
            TextView txtCidade = (TextView) findViewById(R.id.txtCidadeDet);
            TextView txtEstado = (TextView) findViewById(R.id.txtEstadoDet);
            TextView txtRua = (TextView) findViewById(R.id.txtRuaDet);
            TextView txtTelefone = (TextView) findViewById(R.id.txtTelefoneDet);
            TextView txtEmail = (TextView) findViewById(R.id.txtEmailDet);

            txtnome.setText(pessoa.getNome());
            txtEmail.setText(pessoa.getEmail());
            txtBairro.setText(pessoa.getBairro());
            txtCep.setText(pessoa.getCep());
            txtCidade.setText(pessoa.getCidade());
            txtEstado.setText(pessoa.getEstado());
            txtRua.setText(pessoa.getRua());
            txtTelefone.setText(pessoa.getTelefone());

        }
    }

}
