package com.example.mockup;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.ContactsContract.Intents.Insert.EMAIL;

public class criaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO="banco.db";
    public static final String TABELA="usuarios";
    public static final String ID="id";
    public static final String NOME="nome";
    public static final String EMAIL="email";
    public static final String SENHA="senha";
    public static final String SENHACONFERE="senhaconfere";

    private static final int VERSAO=2;

    public criaBanco(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql= "CREATE TABLE "+TABELA+"("
                +ID+" integer primary key autoincrement,"
                +NOME+" text,"
                +EMAIL+" text,"
                +SENHA+" text,"
                +SENHACONFERE+" text"
                +")";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}