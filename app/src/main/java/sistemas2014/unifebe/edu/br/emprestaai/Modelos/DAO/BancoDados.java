package sistemas2014.unifebe.edu.br.emprestaai.Modelos.DAO;

/**
 * Created by mauma on 19/07/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class BancoDados extends SQLiteOpenHelper {

    private static String DB_NAME = "unifebe.db";

    private SQLiteDatabase checkDB;

    private static final int VERSION_DATABASE = 3;

    public void onCreate(SQLiteDatabase db) {
        Log.i("Unifebe", "Chamou metodo oncreate");

        String sql[] = new String[]{
                "CREATE TABLE amigos(" +
                        "_id INTEGER NOT NULL, " +
                        "nome VARCHAR( 50 ), " +
                        "email VARCHAR( 50 ), " +
                        "cidade VARCHAR( 100 ), " +
                        "telefone VARCHAR(50), " +
                        "celular VARCHAR(50), " +
                        "PRIMARY KEY (_id ));",

                "CREATE TABLE emprestimos(" +
                        "_id INTEGER NOT NULL, " +
                        "id_amigo INTEGER, " +
                        "item VARCHAR( 200 ), " +
                        "PRIMARY KEY (_id ));"

        };

        for (int i = 0; i < sql.length; i++) {
            db.execSQL(sql[i]);
            Log.i("Unifebe", sql[i]);
        }

    }

    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        Log.i("Unifebe", "OnUpgrade");
        String sql[] = new String[]{};

        for (int i = 0; i < sql.length; i++) {
            Log.i("Unifebe", "Upgrade : " + sql[i]);
            db.execSQL(sql[i]);
        }
    }

    public BancoDados(Context context) {
        super(context, DB_NAME, null, VERSION_DATABASE);
    }

    public SQLiteDatabase getConnection() {
        try {
            if (checkDB == null) {
                checkDB = this.getWritableDatabase();
            }
            if (checkDB.isOpen() == false) {
                checkDB = this.getWritableDatabase();
            }
        } catch (SQLiteException e) {
            Log.e("Unifebe", "erro =" + e.getMessage());

            throw new Error(e);
        }
        return checkDB;
    }

    @Override
    public synchronized void close() {
        if (checkDB != null) {
            checkDB.close();
        }
        super.close();
    }
}