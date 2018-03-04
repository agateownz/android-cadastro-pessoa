package com.agateownz.testapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by luisg on 04/03/2018.
 */

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;

    private static final String DB_NOME = "teste_application.db";

    public SQLiteDatabaseHelper(Context context) {
        super(context, DB_NOME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
            "CREATE TABLE pessoa (\n" +
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "nome VARCHAR(128) NOT NULL,\n" +
            "email VARCHAR(128) NOT NULL,\n" +
            "telefone VARCHAR(60) NOT NULL,\n" +
            "endereco VARCHAR(128) NOT NULL,\n" +
            "observacoes VARCHAR(128) NOT NULL\n" +
            ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
