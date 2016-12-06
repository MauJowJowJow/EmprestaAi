package sistemas2014.unifebe.edu.br.emprestaai.Controller;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter   ;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sistemas2014.unifebe.edu.br.emprestaai.Controller.ListAdapters.ConsultaEmprestimoListAdapter;
import sistemas2014.unifebe.edu.br.emprestaai.Model.Emprestimos;
import sistemas2014.unifebe.edu.br.emprestaai.Model.Pessoa;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class ConsultaEmprestimo extends ListActivity {

    private ArrayList<Emprestimos> listaEmprestimos = new ArrayList<Emprestimos>();
    private Switch swiStatus;
    private ConsultaEmprestimoListAdapter consultaEmprestimoListAdapter;
    private Emprestimos emprestimoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_consulta_emprestimo);
        swiStatus = (Switch) (findViewById(R.id.swiStatus));

        consultaEmprestimoListAdapter = new ConsultaEmprestimoListAdapter(this, listaEmprestimos);

        View header = (View)getLayoutInflater().inflate(R.layout.header_consulta_emprestimo,null);
        View footer = (View)getLayoutInflater().inflate(R.layout.footer_consulta_emprestimo,null);
        ListView listView = getListView();

        listView.addHeaderView(header);
        listView.addFooterView(footer);
        setListAdapter(consultaEmprestimoListAdapter);

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

        if(position > 0 && position <= listaEmprestimos.size()) {
            emprestimoSelecionado = listaEmprestimos.get(position - 1);

            if (emprestimoSelecionado.getStatus().equals("A")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ConsultaEmprestimo.this);
                builder
                        .setMessage("Deseja finalizar este empréstimo?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                emprestimoSelecionado.setStatus("F");

                                emprestimoSelecionado.save();
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
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(ConsultaEmprestimo.this);
                builder
                        .setMessage("Empréstimo já finalizado!")
                        .show();
            }
        }
    }

    private void atualizaListView(){
        atualizaListaEmprestimos();
        consultaEmprestimoListAdapter.notifyDataSetChanged();
    }

    private void atualizaListaEmprestimos(){
        Iterator<Emprestimos> listDB;

        if(swiStatus.isChecked()){
            listDB = Emprestimos.find(Emprestimos.class, "status = ?", "A").listIterator();
        }else{
            listDB = Emprestimos.findAll(Emprestimos.class);
        }

        listaEmprestimos.clear();
        Emprestimos emprestimos;
        while (listDB.hasNext()) {
            emprestimos = listDB.next();
            listaEmprestimos.add(emprestimos);
        }
    }
}
