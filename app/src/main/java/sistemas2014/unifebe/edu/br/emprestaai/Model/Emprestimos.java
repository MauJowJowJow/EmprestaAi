package sistemas2014.unifebe.edu.br.emprestaai.Model;

import android.content.ClipData;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by dougl on 29/11/2016.
 */

public class Emprestimos extends SugarRecord {

    Long id;
    Pessoa pessoa;
    Date data_devolucao;
    Date data_emprestimo;
    String objeto;
    String status;
    Itens itens;

    public Emprestimos (){}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Itens getItens() {
        return itens;
    }

    public void setItens(Itens itens) {
        this.itens = itens;
    }
}
