package sistemas2014.unifebe.edu.br.emprestaai.Model;

import com.orm.SugarRecord;

/**
 * Created by dougl on 29/11/2016.
 */

public class Itens extends SugarRecord{

    Long id;
    String descrica;

    public Itens(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrica() {
        return descrica;
    }

    public void setDescrica(String descrica) {
        this.descrica = descrica;
    }
}
