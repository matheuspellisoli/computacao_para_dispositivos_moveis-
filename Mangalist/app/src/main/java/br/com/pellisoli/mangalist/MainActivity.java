package br.com.pellisoli.mangalist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button btnadd;
    private List<Manga> mangaList;
    private ListView mangaListView;
    private  AdapterManga adapterManga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd  = findViewById( R.id.btnadd );
        mangaListView = findViewById(R.id.list);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity( intent );
            }
        });


        carregarManga();

        configurarListView();

    }

    private void configurarListView(){

        mangaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Manga mangaSelecionado = mangaList.get(position);
                Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
                intent.putExtra("acao", "editar");
                intent.putExtra("idFilme", mangaSelecionado.getId() );
                startActivity( intent );
            }
        });
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        carregarManga();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void carregarManga(){
        mangaList = MangaDAO.getManga(this);
        adapterManga = new AdapterManga(this, mangaList);
        mangaListView.setAdapter( adapterManga );
    }
}