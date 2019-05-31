package com.example.trabalhoswipe;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutContainer;
    private TextView tvRegiao;
    private TextView tvUF;
    private String[] regiao;
    private String[][] uf;
    private int cont, contUF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutContainer = (LinearLayout) findViewById(R.id.LayoutContainer);
        tvRegiao =  (TextView) findViewById(R.id.tvRegiao);
        tvUF = (TextView) findViewById(R.id.tvEstados);
        contUF = 0;
        cont = 0;


        regiao = new String[] {

                "Norte",
                "Nordeste",
                "Centro-Oeste",
                "Sudeste",
                "Sul",
        };


        uf = new String[][] {
                {"Acre",  "Amapá", "Amazonas","Pará"," Rondônia", "Roraima", "Tocantins"},
                {"Alagoas", "Bahia", "Ceará", "Maranhão", "Paraíba", "Pernambuco", "Piauí", "Rio Grande do Norte", "Sergipe"},
                {"Distrito Federal", "Goiás", "Mato Grosso", "Mato Grosso do Sul"},
                {"Espírito Santo", "Minas Gerais", "Rio de Janeiro", "São Paulo"},
                {"Paraná","Rio Grande do Sul", "Santa Catarina"},

        };

        tvUF.setText(uf[cont][contUF]);
        tvRegiao.setText( regiao[cont]);

        layoutContainer.setOnTouchListener( new br.pro.adalto.quiztouch.OnSwipeTouchListener(this){

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();

                cont ++;
                if (cont >= regiao.length){
                    cont = 0;
                }
                tvRegiao.setText(regiao[cont]);
                contUF = 0;
                tvUF.setText(uf[cont][contUF])
                ;
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                cont --;
                if(cont < 0 ){
                    cont = regiao.length-1;
                }
                tvRegiao.setText( regiao[cont]);
                contUF = 0;
                tvUF.setText(uf[cont][contUF]);
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                contUF ++;
                if (contUF >= uf[cont].length){
                    contUF = 0;
                }
                tvUF.setText(uf[cont][contUF]);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                contUF --;
                if(contUF < 0 ){
                    contUF = uf[cont].length-1;
                }
                tvUF.setText(uf[cont][contUF]);
            }
        });


    }
}
