package br.pro.pellisoli.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class FormularioActivity extends AppCompatActivity {

    private EditText etTitulo, etObs, etData, etTime;
    private Button btnSalvar;
    private String acao;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etTitulo = findViewById( R.id.etTitulo);
        etObs = findViewById( R.id.etObs);
        etData = findViewById( R.id.etDate);
        etTime = findViewById( R.id.etTime);


        acao = getIntent().getStringExtra("acao");
        if( acao.equals("editar")){
            carregarFormulario();
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    private void carregarFormulario(){
        int idFilme = getIntent().getIntExtra("idFilme", 0);
        if( idFilme != 0) {
            task = TarefaDAO.getFilmeById(this, idFilme);

            etTitulo.setText( task.titulo );
            etObs.setText(task.obs);
            etData.setText(convertLocalDateTimeToDateUsingInstant( task.dateTime).toString());
            etTime.setText(task.dateTime.toLocalTime().toString());
        }
    }
    private Date convertLocalDateTimeToDateUsingInstant(LocalDateTime dateToConvert) {
        return java.util.Date
                .from(dateToConvert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }

    private void salvar(){
        if( etTitulo.getText().toString().isEmpty() || etObs.getText().toString().isEmpty() || etData.getText().toString().isEmpty() || etTime.getText().toString().isEmpty()) {
            Toast.makeText(this, "Todos campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();
        }else{

            if (acao.equals("novo")) {
                task = new Task();
            }

            task.titulo = etTitulo.getText().toString();
            task.obs = etObs.getText().toString();
            task.dateTime = LocalDateTime.parse(etData.getText() + " " + etTime.getText());

            if( acao.equals("editar")){
                TarefaDAO.editar(task, this);
                finish();
            }else {
                TarefaDAO.inserir(task, this);
                etTitulo.setText("");
                etObs.setText("");
                etData.setText("");
            }
        }
    }



}