package com.carrera.dbandroid.androiddatabase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Francisco Junior on 30/06/2017.
 */

public class CriaBanco extends SQLiteOpenHelper{
    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "livros";
    private static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String EDITORA = "editora";
    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase bancoDeDados) {
        String sql = "CREATE TABLE"+TABELA+"("
                + ID + "integer primary key autoincrement,"
                + TITULO + "text,"
                + AUTOR + "text,"
                + EDITORA + "text"
                +")";
        bancoDeDados.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bancoDeDados, int versaoAntiga, int novaVersao) {
        bancoDeDados.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(bancoDeDados);
    }
}
