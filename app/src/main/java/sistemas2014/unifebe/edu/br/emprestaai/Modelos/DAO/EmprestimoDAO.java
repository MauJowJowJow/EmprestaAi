package sistemas2014.unifebe.edu.br.emprestaai.Modelos.DAO;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import sistemas2014.unifebe.edu.br.emprestaai.Modelos.Amigo;
import sistemas2014.unifebe.edu.br.emprestaai.Modelos.Emprestimo;

/**
 * Created by mauma on 19/07/2016.
 */
public class EmprestimoDAO extends BancoDados {
    private String SQLGeral = "select _id, id_amigo, item from emprestimos";
    private Context context;

    public EmprestimoDAO(Context context) {
        super(context);
        this.context = context;
    }

    public Emprestimo getById(int _id){
        AmigoDAO amigoDAO = new AmigoDAO(context);

        Emprestimo emprestimo = new Emprestimo();
        Cursor retorno =  getConnection().rawQuery(SQLGeral + " where _id = ?", new String [] { Integer.toString(_id) });

        if(retorno != null) {
            retorno.moveToFirst();

            emprestimo.set_id(retorno.getInt(0));
            emprestimo.setAmigo(amigoDAO.getById(retorno.getInt(1)));
            emprestimo.setItem(retorno.getString(2));

            retorno.close();
        }

        return emprestimo;
    }

    public boolean deleteById(int _id){
        return getConnection().delete("emprestimos", "_id = " + _id, null) > 0;

    }

    public List<Emprestimo> getListaEmprestimos(){
        AmigoDAO amigoDAO = new AmigoDAO(context);

        List<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>();
        Cursor retorno =  getConnection().rawQuery(SQLGeral, null);

        retorno.moveToFirst();
        while (retorno.moveToNext()) {
            Emprestimo emprestimo = new Emprestimo();

            emprestimo.set_id(retorno.getInt(0));
            emprestimo.setAmigo(amigoDAO.getById(retorno.getInt(1)));
            emprestimo.setItem(retorno.getString(2));

            listaEmprestimos.add(emprestimo);
        }

        return listaEmprestimos;
    }
}