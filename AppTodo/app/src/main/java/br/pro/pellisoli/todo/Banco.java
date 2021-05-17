package br.pro.pellisoli.todo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME = "todo";

    public Banco(Context context){
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS tarefa ( " +
                "     id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ," +
                "     titulo TEXT NOT NULL ," +
                "     obs TEXT ," +
                "     dataTime TEXT  ) "  );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
}
