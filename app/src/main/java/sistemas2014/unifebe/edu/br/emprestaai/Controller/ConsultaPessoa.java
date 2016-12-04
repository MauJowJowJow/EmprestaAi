package sistemas2014.unifebe.edu.br.emprestaai.Controller;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import sistemas2014.unifebe.edu.br.emprestaai.Model.Pessoa;
import sistemas2014.unifebe.edu.br.emprestaai.R;

/**
 * Created by dougl on 04/12/2016.
 */

public class ConsultaPessoa extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_pessoa);





      //  //List <Pessoa> pessoas = Pessoa.listAll(Pessoa.class);

       // List<Pessoa> pessoas = Pessoa.findWithQuery(Pessoa.class,"Select nome from pessoa");

      //  list.setAdapter(new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, pessoas));




    }
}

