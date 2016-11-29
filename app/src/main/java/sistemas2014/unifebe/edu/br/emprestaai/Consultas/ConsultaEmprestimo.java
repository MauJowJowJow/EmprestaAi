package sistemas2014.unifebe.edu.br.emprestaai.Consultas;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import sistemas2014.unifebe.edu.br.emprestaai.Model.DAO.EmprestimoDAO;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class ConsultaEmprestimo extends ListActivity {

    private List<Emprestimo> listaEmprestimo =
            new ArrayList<Emprestimo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_emprestimo);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,
                        getListaEmprestimo(getApplicationContext()));
        setListAdapter(dataAdapter);
    }

    private List<String> getListaEmprestimo(Context context){
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(context);
        listaEmprestimo = emprestimoDAO.getListaEmprestimos();
        List<String> listaItem = new ArrayList<String>();

        for(Emprestimo emprestimo : listaEmprestimo){
            listaItem.add(emprestimo.getItem());
        }

        return listaItem;
    }

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i = new Intent(getApplicationContext(), DetalheEmprestimo.class);
        i.putExtra("id", listaEmprestimo.get(position).get_id());
        startActivity (i);
    }
}