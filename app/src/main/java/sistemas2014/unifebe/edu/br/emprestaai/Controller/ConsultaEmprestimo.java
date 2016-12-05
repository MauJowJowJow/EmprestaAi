package sistemas2014.unifebe.edu.br.emprestaai.Controller;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sistemas2014.unifebe.edu.br.emprestaai.Model.Emprestimos;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class ConsultaEmprestimo extends ListActivity {

    private List<Emprestimos> listaEmprestimos = new ArrayList<Emprestimos>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_consulta_emprestimo);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,
                        getListaEmprestimos());
        setListAdapter(dataAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        super.onListItemClick(l, v, position, id);

        /* Fazer tela de detalhes da Pessoa recebendo o ID por parametro e carregando os dados.

        Intent i = new Intent(getApplicationContext(), DetalhePessoa.class);
        i.putExtra("id", listaPessoas.get(position).getId());
        startActivity(i);*/
    }


    private List<String> getListaEmprestimos(){
        Iterator<Emprestimos> listDB = Emprestimos.findAll(Emprestimos.class);
        List<String> listaObjeto = new ArrayList<String>();
        listaEmprestimos = new ArrayList<Emprestimos>();

        Emprestimos emprestimos;
        while (listDB.hasNext()) {
            emprestimos = listDB.next();
            listaObjeto.add(emprestimos.getObjeto());
            listaEmprestimos.add(emprestimos);
        }

        return listaObjeto;
    }

}
