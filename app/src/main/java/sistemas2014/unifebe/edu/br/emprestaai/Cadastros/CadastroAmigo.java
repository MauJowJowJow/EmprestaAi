package sistemas2014.unifebe.edu.br.emprestaai.Cadastros;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sistemas2014.unifebe.edu.br.emprestaai.Model.DAO.BancoDados;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class CadastroAmigo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);

        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText)findViewById(R.id.txtNome);
                EditText email = (EditText)findViewById(R.id.txtEmail);
                EditText cidade = (EditText)findViewById(R.id.txtCidade);
                EditText telefone = (EditText)findViewById(R.id.txtTelefoneResidencial);
                EditText celular = (EditText)findViewById(R.id.txtTelefoneCelular);

                BancoDados db = new BancoDados
                        (getApplicationContext());

                ContentValues hs = new ContentValues();
                hs.put("nome", nome.getText().toString());
                hs.put("email", email.getText().toString());
                hs.put("cidade", cidade.getText().toString());
                hs.put("telefone", telefone.getText().toString());
                hs.put("celular", celular.getText().toString());

                db.getConnection().insert("amigos", null, hs);

                db.getConnection().close();
                Toast.makeText(getApplicationContext(),
                        "Dados Salvos com sucesso", Toast.LENGTH_LONG).show();

                nome.setText("");
                email.setText("");
                cidade.setText("");
                telefone.setText("");
                celular.setText("");
            }
        });
    }
}
