package sistemas2014.unifebe.edu.br.emprestaai.Model;

import com.orm.SugarRecord;

/**
 * Created by dougl on 29/11/2016.
 */

public class Itens extends SugarRecord{

    Long id;
    String descricao;

    public Itens(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
