package sistemas2014.unifebe.edu.br.emprestaai.Controller;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sistemas2014.unifebe.edu.br.emprestaai.Model.Pessoa;
import sistemas2014.unifebe.edu.br.emprestaai.R;


public class ConsultaPessoa extends ListActivity {

    private List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_consulta_pessoa);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,
                        getListaPessoas());
        setListAdapter(dataAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        super.onListItemClick(l, v, position, id);

        //Fazer tela de detalhes da Pessoa recebendo o ID por parametro e carregando os dados.

        Intent i = new Intent(getApplicationContext(), DetalhePessoa.class);
        i.putExtra("id", listaPessoas.get(position).getId());
        startActivity(i);
    }

    private List<String> getListaPessoas(){
        Iterator<Pessoa> listDB = Pessoa.findAll(Pessoa.class);
        List<String> listaNome = new ArrayList<String>();
        listaPessoas = new ArrayList<Pessoa>();

        Pessoa pessoa;
        while (listDB.hasNext()) {
            pessoa = listDB.next();
            listaNome.add(pessoa.getNome());
            listaPessoas.add(pessoa);
        }

        return listaNome;
    }
}

