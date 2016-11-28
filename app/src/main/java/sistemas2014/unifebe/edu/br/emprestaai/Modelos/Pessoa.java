package sistemas2014.unifebe.edu.br.emprestaai.Modelos;

import com.orm.SugarRecord;

/**
 * Created by dougl on 28/11/2016.
 */

public class Pessoa extends SugarRecord {

    String nome;

    public Pessoa(){}

    public Pessoa(String nome){
        this.nome = nome;
    }

}
