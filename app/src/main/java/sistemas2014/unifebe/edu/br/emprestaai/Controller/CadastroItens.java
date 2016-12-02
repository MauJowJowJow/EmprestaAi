package sistemas2014.unifebe.edu.br.emprestaai.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sistemas2014.unifebe.edu.br.emprestaai.Model.Itens;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class CadastroItens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_itens);

        Button bntSalvar = (Button) findViewById(R.id.btnSalvar);
        bntSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText descricao = (EditText) findViewById(R.id.txtNomeItem);

                Itens item = new Itens();
                item.setDescricao(descricao.getText().toString());

                item.save();

                descricao.setText("");

                if(item.getId() != 0){
                    Toast.makeText(getApplicationContext(), "Item salvo com sucesso!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Erro ao salvar o item!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
