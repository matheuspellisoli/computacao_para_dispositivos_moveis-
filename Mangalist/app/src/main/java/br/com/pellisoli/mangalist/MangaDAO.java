package br.com.pellisoli.mangalist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MangaDAO {

    public static void inserir(Manga manga, Context context){
        ContentValues valores = new ContentValues();
        valores.put("titulo", manga.getTitulo());
        valores.put("linkImg", manga.getLinkImg());
        valores.put("linkTitulo", manga.getLinkTitulo());
        valores.put("ultimoCap", manga.getUltimoCap());

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("manga", null, valores);
    }
    public static List<Manga> getManga(Context context){
        List<Manga> lista = new ArrayList<Manga>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, titulo, linkImg, linkTitulo , ultimoCap FROM manga ORDER BY nome", null );
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Manga manga = new Manga();
                manga.setTitulo(cursor.getString( 1));
                manga.setLinkImg(cursor.getString( 2));
                manga.setLinkTitulo(cursor.getString( 3));
                manga.setUltimoCap(cursor.getInt( 4));
                lista.add( manga );
            }while( cursor.moveToNext() );
        }
        return lista;
    }

}