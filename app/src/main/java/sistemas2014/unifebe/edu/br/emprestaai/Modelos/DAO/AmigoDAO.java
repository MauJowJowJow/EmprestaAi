package sistemas2014.unifebe.edu.br.emprestaai.Modelos.DAO;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import sistemas2014.unifebe.edu.br.emprestaai.Modelos.Amigo;

/**
 * Created by mauma on 19/07/2016.
 */
public class AmigoDAO extends BancoDados {
    public AmigoDAO(Context context) {
        super(context);
    }
    private String SQLGeral = "select _id, nome, email, cidade, telefone, celular from amigos";

    public Amigo getById(int _id){
        Amigo amigo = new Amigo();
        Cursor retorno =  getConnection().rawQuery(SQLGeral + " where _id = ?", new String [] { Integer.toString(_id) });

        if(retorno != null) {
            retorno.moveToFirst();

            amigo.set_id(retorno.getInt(0));
            amigo.setNome(retorno.getString(1));
            amigo.setEmail(retorno.getString(2));
            amigo.setCidade(retorno.getString(3));
            amigo.setTelefoneResidencial(retorno.getString(4));
            amigo.setTelefoneCelular(retorno.getString(5));

            retorno.close();
        }

        return amigo;
    }

    public List<Amigo> getListaAmigos(){
        List<Amigo> listaAmigos = new ArrayList<Amigo>();
        Cursor retorno =  getConnection().rawQuery(SQLGeral, null);

        retorno.moveToFirst();
        while (retorno.moveToNext()) {
            Amigo amigo = new Amigo();

            amigo.set_id(retorno.getInt(0));
            amigo.setNome(retorno.getString(1));
            amigo.setEmail(retorno.getString(2));
            amigo.setCidade(retorno.getString(3));
            amigo.setTelefoneResidencial(retorno.getString(4));
            amigo.setTelefoneCelular(retorno.getString(5));

            listaAmigos.add(amigo);
        }

        return listaAmigos;
    }
}
