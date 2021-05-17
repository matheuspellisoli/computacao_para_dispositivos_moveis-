package br.pro.pellisoli.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public static void inserir(Task task, Context context){
        ContentValues valores = new ContentValues();
        valores.put("titulo", task.titulo );
        valores.put("obs", task.obs );
        valores.put("dateTime", task.dateTime.toString() );

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.insert("tarefa", null, valores);
    }

    public static void editar(Task task, Context context){
        ContentValues valores = new ContentValues();
        valores.put("titulo", task.titulo );
        valores.put("obs", task.obs );
        valores.put("dateTime", task.dateTime.toString() );

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.update("filme", valores, " id = " + task.id , null );
    }

    public static void excluir(int id, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("filme", " id = " + id , null);
    }

    public static List<Task> getFilmes(Context context){
        List<Task> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, titulo, obs, dateTime FROM tarefa ORDER BY nome", null );
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Task task = new Task();
                task.id = cursor.getInt( 0);
                task.titulo = cursor.getString(1);
                task.obs = cursor.getString(2);
                task.dateTime = LocalDateTime.parse(cursor.getString(3));
                lista.add(task);
            }while( cursor.moveToNext() );
        }
        return lista;
    }

    public static Task getFilmeById(Context context, int id){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, nome, ano FROM filme WHERE id = " + id, null );
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            Task task = new Task();
            task.id = cursor.getInt( 0);
            task.titulo = cursor.getString(1);
            task.obs = cursor.getString(2);
            task.dateTime = LocalDateTime.parse(cursor.getString(3));
            return task;
        }else{
            return null;
        }
    }



}
