package sistemas2014.unifebe.edu.br.emprestaai.Modelos;

/**
 * Created by mauma on 19/07/2016.
 */

public class Emprestimo {
    private int _id;
    private Amigo amigo;
    private String item;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
