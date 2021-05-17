package br.com.pellisoli.appswipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout = findViewById(R.id.layoutfundo);
        tvText = findViewById(R.id.tv_text);

        layout.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();

                tvText.setText("para baixo");
                layout.setBackgroundColor(Color.RED);
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();

                tvText.setText("para cima");
                layout.setBackgroundColor(Color.BLUE);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();

                tvText.setText("para esquerda");
                layout.setBackgroundColor(Color.YELLOW);
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();

                tvText.setText("para direita");
                layout.setBackgroundColor(Color.MAGENTA);
            }

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                tvText.setText("só tocou");
                layout.setBackgroundColor(Color.WHITE);
                return super.onTouch(v, event);
            }
        });
    }
}