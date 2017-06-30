package com.carrera.dbandroid.androiddatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Francisco Junior on 30/06/2017.
 */

public class BancoController {

    private SQLiteDatabase bancoDeDados;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;

        bancoDeDados = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.TITULO, titulo);
        valores.put(CriaBanco.AUTOR, autor);
        valores.put(CriaBanco.EDITORA, editora);

        resultado = bancoDeDados.insert(CriaBanco.TABELA, null, valores);
        bancoDeDados.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com Sucesso";
    }
}

