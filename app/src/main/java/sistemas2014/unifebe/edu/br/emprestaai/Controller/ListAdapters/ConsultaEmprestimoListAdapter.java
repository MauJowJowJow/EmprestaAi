package sistemas2014.unifebe.edu.br.emprestaai.Controller.ListAdapters;

/**
 * Created by mauma on 05/12/2016.
 */

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import sistemas2014.unifebe.edu.br.emprestaai.Model.Emprestimos;
import sistemas2014.unifebe.edu.br.emprestaai.R;

public class ConsultaEmprestimoListAdapter extends ArrayAdapter<Emprestimos> {

    private final Context context;
    private final ArrayList<Emprestimos> itemsArrayList;

    public ConsultaEmprestimoListAdapter(Context context, ArrayList<Emprestimos> itemsArrayList) {

        super(context, R.layout.listview_consulta_emprestimo, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.listview_consulta_emprestimo, parent, false);

        // 3. Get the two text view from the rowView
        TextView txtPessoa = (TextView) rowView.findViewById(R.id.txtPessoa);
        TextView txtItem = (TextView) rowView.findViewById(R.id.txtItem);

        // 4. Set the text for textView
        Emprestimos emprestimo = itemsArrayList.get(position);
        txtPessoa.setText(emprestimo.getPessoa().getNome());

        if(emprestimo.getItens() == null)
            txtItem.setText(emprestimo.getObjeto());
        else
            txtItem.setText(emprestimo.getItens().getDescricao());

        if(emprestimo.getStatus().equals("F"))
            rowView.setBackgroundColor(Color.argb(0x210, 0x210, 0x210, 0x210));

        // 5. retrn rowView
        return rowView;
    }
}
