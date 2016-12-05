package sistemas2014.unifebe.edu.br.emprestaai.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sistemas2014.unifebe.edu.br.emprestaai.Model.Emprestimos;
import sistemas2014.unifebe.edu.br.emprestaai.Model.Itens;
import sistemas2014.unifebe.edu.br.emprestaai.Model.Pessoa;
import sistemas2014.unifebe.edu.br.emprestaai.R;

/**
 * Created by mauma on 29/11/2016.
 */
public class CadastroEmprestimo extends AppCompatActivity {

    private List<Pessoa> listaPessoas;

    private List<Itens> listaItens;

    EditText txtObjeto = (EditText) findViewById(R.id.txtItem);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_emprestimo);

        Spinner spiAmigo = (Spinner)findViewById(R.id.spiAmigo);

        ArrayAdapter<String> spinnerPessoaArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                getListaPessoas());

        spinnerPessoaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiAmigo.setAdapter(spinnerPessoaArrayAdapter);

        Spinner spiItem = (Spinner)findViewById(R.id.spiItem);

        ArrayAdapter<String> spinnerItemArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                getListaItens());

        spinnerItemArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiItem.setAdapter(spinnerItemArrayAdapter);


        Button bntSalvar = (Button) findViewById(R.id.btnSalvar);
        bntSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emprestimos emprestimo = new Emprestimos();
                //emprestimo.setStatus("A");
                //emprestimo.setObjeto("A");
                emprestimo.setObjeto(txtObjeto.getText().toString());


                emprestimo.save();

                if(emprestimo.getId() != 0){
                    Toast.makeText(getApplicationContext(), "Emprestimo salvo com sucesso!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Erro ao salvar o emprestimo!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<String> getListaPessoas(){
        Iterator<Pessoa> listDB = Pessoa.findAll(Pessoa.class);
        List<String> listaNome = new ArrayList<String>();
        listaPessoas = new ArrayList<Pessoa>();

        Pessoa pessoa;
        while(listDB.hasNext()){
            pessoa = listDB.next();
            listaNome.add(pessoa.getNome());
            listaPessoas.add(pessoa);
        }

        return listaNome;
    }

    private List<String> getListaItens(){
        Iterator<Itens> listDB = Itens.findAll(Itens.class);
        List<String> listaNome = new ArrayList<String>();
        listaItens = new ArrayList<Itens>();

        Itens item;
        while(listDB.hasNext()){
            item = listDB.next();
            listaNome.add(item.getDescricao());

            listaItens.add(item);
        }

        return listaNome;
    }
}
