package sistemas2014.unifebe.edu.br.emprestaai.Cadastros;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sistemas2014.unifebe.edu.br.emprestaai.Modelos.Amigo;
import sistemas2014.unifebe.edu.br.emprestaai.Modelos.DAO.AmigoDAO;
import sistemas2014.unifebe.edu.br.emprestaai.Modelos.DAO.BancoDados;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class CadastroEmprestimo extends AppCompatActivity {

    private List<Amigo> listaAmigos =
            new ArrayList<Amigo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_emprestimo);

        Spinner spiAmigo = (Spinner)findViewById(R.id.spiAmigo);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                getListaAmigos(getApplicationContext()));
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiAmigo.setAdapter(spinnerArrayAdapter);

        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spiAmigo = (Spinner)findViewById(R.id.spiAmigo);
                EditText item = (EditText)findViewById(R.id.txtItem);

                BancoDados db = new BancoDados
                        (getApplicationContext());

                Amigo amigo = null;

                try{
                    amigo = listaAmigos.get((int)spiAmigo.getSelectedItemId());
                }catch(Exception ex){
                    System.out.print(ex.getStackTrace());
                }

                if(amigo == null){
                    Toast.makeText(getApplicationContext(),
                            "Amigo não cadastrado!", Toast.LENGTH_LONG).show();
                }else {
                    ContentValues hs = new ContentValues();
                    hs.put("id_amigo", amigo.get_id());
                    hs.put("item", item.getText().toString());

                    db.getConnection().insert("emprestimos", null, hs);
                    db.getConnection().close();
                    Toast.makeText(getApplicationContext(),
                            "Dados Salvos com sucesso", Toast.LENGTH_LONG).show();

                    spiAmigo.setSelection(0);
                    item.setText("");
                }
            }
        });
    }

    private List<String> getListaAmigos(Context context){
        AmigoDAO amigos = new AmigoDAO(context);
        listaAmigos = amigos.getListaAmigos();
        List<String> listaNome = new ArrayList<String>();

        for(Amigo amigo :listaAmigos){
            listaNome.add(amigo.getNome());
        }

        return listaNome;
    }
}
