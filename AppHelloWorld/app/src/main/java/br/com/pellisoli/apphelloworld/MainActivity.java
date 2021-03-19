package br.com.pellisoli.apphelloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText editValor;
    private Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.etValor);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular(){
        String valor = editValor.getText().toString();


        if(!valor.isEmpty()){
            double n = Double.valueOf(valor);
            n = n * 2;

            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setMessage(valor + "x 2 = " + n);
            alerta.setPositiveButton("ok", null);
            alerta.show();
        }
    }
}