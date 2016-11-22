package sistemas2014.unifebe.edu.br.emprestaai.Consultas;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import sistemas2014.unifebe.edu.br.emprestaai.Modelos.Amigo;
import sistemas2014.unifebe.edu.br.emprestaai.Modelos.DAO.AmigoDAO;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class ConsultaAmigo extends ListActivity {

    private List<Amigo> listaAmigos =
            new ArrayList<Amigo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_amigo);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,
                        getListaAmigos(getApplicationContext()));
        setListAdapter(dataAdapter);
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

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent i = new Intent(getApplicationContext(), DetalheAmigo.class);
        i.putExtra("id", listaAmigos.get(position).get_id());
        startActivity(i);
    }
}
