

/**
 * Created by android on 28/08/2018.
 */


public class NotasDao
{


    public static void inserir(Context contexto, Nota notas) {
        ContentValues valores = new ContentValues();
        valores.put("nome", notas.getNome());
        com.tamiresvvieira.notas.Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getWritableDatabase();
        banco.insert("notas", null, valores);


    }

    public static List<Nota> getNotas(Context contexto) {
        List<Nota> listaDenotas = new ArrayList<>();

        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getReadableDatabase();

        String sql = "SELECT * FROM notas ORDER BY nome ";

        Cursor tabela = banco.rawQuery(sql, null);
        if (tabela.getCount() > 0) {
            tabela.moveToFirst();
            do {
                Nota not = new Nota();
                not.setId(tabela.getInt(0));
                not.setNome(tabela.getString(1));

                listaDenotas.add(not);

            } while (tabela.moveToNext());

        }


        return listaDenotas;

    }

}