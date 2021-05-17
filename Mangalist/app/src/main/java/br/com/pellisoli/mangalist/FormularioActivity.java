package br.com.pellisoli.mangalist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private Button btnvoltar, btnsalvar;
    TextView tvTitulo, tvLinkImg, tvLinkManga, tvUtCAP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        btnvoltar = findViewById( R.id.btnvoltar );
        btnsalvar = findViewById(R.id.btnSalvar);
        tvTitulo = findViewById(R.id.form_titulo);
        tvLinkImg = findViewById(R.id.form_link_imagem);
        tvLinkManga = findViewById(R.id.form_link_titulo);
        tvUtCAP = findViewById(R.id.form_ultimo_cap);

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioActivity.this, MainActivity.class);
                startActivity( intent );
            }
        });

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormularioActivity.this, MainActivity.class);
                startActivity( intent );
            }
        });
    }

    private void salvar(){
        Manga manga = new Manga();
        if( tvTitulo.getText().toString().isEmpty() || tvLinkImg.getText().toString().isEmpty() ||  tvLinkManga.getText().toString().isEmpty() ||  tvUtCAP.getText().toString().isEmpty() ){
            Toast.makeText(this, "Todos campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();

        }else{
            manga.setTitulo(tvTitulo.getText().toString());
            manga.setLinkImg(tvLinkImg.getText().toString());
            manga.setLinkTitulo(tvLinkManga.getText().toString());
            manga.setUltimoCap(Integer.parseInt(tvUtCAP.getText().toString()));

            MangaDAO.inserir(manga, this);
        }
    }
}