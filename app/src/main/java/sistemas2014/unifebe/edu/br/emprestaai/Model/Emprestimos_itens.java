package sistemas2014.unifebe.edu.br.emprestaai.Model;

import com.orm.SugarRecord;

/**
 * Created by dougl on 29/11/2016.
 */

public class Emprestimos_itens extends SugarRecord {

    Emprestimos emprestimos;
    Itens itens;


    public Emprestimos_itens (){}

    public Emprestimos getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(Emprestimos emprestimos) {
        this.emprestimos = emprestimos;
    }

    public Itens getItens() {
        return itens;
    }

    public void setItens(Itens itens) {
        this.itens = itens;
    }
}
