package sistemas2014.unifebe.edu.br.emprestaai.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sistemas2014.unifebe.edu.br.emprestaai.Model.Pessoa;

import sistemas2014.unifebe.edu.br.emprestaai.R;

/**
 * Created by dougl on 29/11/2016.
 */

public class CadastroPesssoa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);

        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText txtNome = (EditText) findViewById(R.id.txtNome);
                EditText txtBairro = (EditText) findViewById(R.id.txtBairro);
                EditText txtCep = (EditText) findViewById(R.id.txtCEP);
                EditText txtCidade = (EditText) findViewById(R.id.txtCidade);
                EditText txtEstado = (EditText) findViewById(R.id.txtEstado);
                EditText txtRua = (EditText) findViewById(R.id.txtRua);
                EditText txtTelefone = (EditText) findViewById(R.id.txtTelefone);
                EditText txtEmail = (EditText) findViewById(R.id.txtEmail);

                Pessoa pessoa = new Pessoa();

                pessoa.setNome(txtNome.getText().toString());
                pessoa.setBairro(txtBairro.getText().toString());
                pessoa.setCep(txtCep.getText().toString());
                pessoa.setCidade(txtCidade.getText().toString());
                pessoa.setEstado(txtEstado.getText().toString());
                pessoa.setRua(txtRua.getText().toString());
                pessoa.setTelefone(txtTelefone.getText().toString());
                pessoa.setEmail(txtEmail.getText().toString());

                pessoa.save();

                txtNome.setText("");
                txtBairro.setText("");
                txtCep.setText("");
                txtCidade.setText("");
                txtEstado.setText("");
                txtRua.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");

                if (pessoa.getId() != 0){
                    Toast.makeText(getApplicationContext(), "Cadastro salvo com sucesso!", Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Erro no cadastro!", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
