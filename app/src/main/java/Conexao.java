

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by android on 28/08/2018.
 */

public class Conexao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "appNotas";
    private static final int VERSAO_BANCO = 1;

    public Conexao(Context contexto){
        super(contexto, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Notas ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL)"

        );



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antigaVersao, int novaVersao) {

    }
}

