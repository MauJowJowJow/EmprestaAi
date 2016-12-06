package sistemas2014.unifebe.edu.br.emprestaai.Controller;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sistemas2014.unifebe.edu.br.emprestaai.Model.Emprestimos;
import sistemas2014.unifebe.edu.br.emprestaai.Model.Pessoa;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class ConsultaEmprestimo extends ListActivity {

    private List<Emprestimos> listaEmprestimos = new ArrayList<Emprestimos>();
    private List<String> listaPessoas = new ArrayList<String>();
    private Switch swiStatus;
    private ArrayAdapter<String> dataAdapter;
    private int posicaoClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_consulta_emprestimo);
        swiStatus = (Switch) (findViewById(R.id.swiStatus));

        dataAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,
                        listaPessoas);

        setListAdapter(dataAdapter);

        swiStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizaListView();
            }
        });

        atualizaListView();
    }

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        super.onListItemClick(l, v, position, id);
        posicaoClick = position;

        AlertDialog.Builder builder = new AlertDialog.Builder(ConsultaEmprestimo.this);
        builder
                .setMessage("Deseja finalizar este empréstimo?")
                .setPositiveButton("Sim",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Emprestimos emprestimo = listaEmprestimos.get(posicaoClick);
                        emprestimo.setStatus("F");

                        emprestimo.save();
                        atualizaListView();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    private void atualizaListView(){
        atualizaListaEmprestimos();
        dataAdapter.notifyDataSetChanged();
    }

    private void atualizaListaEmprestimos(){
        Iterator<Emprestimos> listDB;

        if(swiStatus.isChecked()){
            listDB = Emprestimos.find(Emprestimos.class, "status = ?", "A").listIterator();
        }else{
            listDB = Emprestimos.findAll(Emprestimos.class);
        }

        listaPessoas.clear();
        listaEmprestimos.clear();

        Emprestimos emprestimos;
        while (listDB.hasNext()) {
            emprestimos = listDB.next();
            listaPessoas.add(emprestimos.getPessoa().getNome());
            listaEmprestimos.add(emprestimos);
        }
    }
}
