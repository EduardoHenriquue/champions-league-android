package com.eduardo.android.rodadadazoeira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnGolBarcelona;
    private Button btnGolReal;
    private Button btnLimparPlacar;
    private TextView placarBarcelona;
    private TextView placarReal;
    private TextView resultado;
    private int contadorBarcelona;
    private int contadorReal;

    private String barWins = "Barcelona Ganhando";
    private String realWins = "Real Madrid Ganhando";
    private String empate = "EMPATE";
    private String champLeague = "Champions League";
    private String placarZerado = "Placar zerado!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getViewId();
        this.onClicks();

    }

    public void getViewId(){
        this.btnGolBarcelona = (Button)findViewById(R.id.btn_gol_barcelona);
        this.btnGolReal = (Button)findViewById(R.id.btn_gol_real);
        this.placarBarcelona = (TextView)findViewById(R.id.text_placar_barcelona);
        this.placarReal = (TextView)findViewById(R.id.text_placar_real);
        this.btnLimparPlacar = (Button)findViewById(R.id.btn_limpar_placar);
        this.resultado = (TextView)findViewById(R.id.text_resultado);
    }

    public void onClicks(){
        this.btnGolBarcelona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.contadorBarcelona++;
                MainActivity.this.placarBarcelona.setText(String.valueOf(MainActivity.this.contadorBarcelona));
                MainActivity.this.exibeResultado();
            }
        });
        this.btnGolReal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.contadorReal++;
                MainActivity.this.placarReal.setText(String.valueOf(MainActivity.this.contadorReal));
                MainActivity.this.exibeResultado();
            }
        });
        this.btnLimparPlacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.contadorBarcelona = 0;
                MainActivity.this.contadorReal = 0;
                MainActivity.this.placarBarcelona.setText(String.valueOf(MainActivity.this.contadorBarcelona));
                MainActivity.this.placarReal.setText(String.valueOf(MainActivity.this.contadorReal));
                MainActivity.this.resultado.setText(MainActivity.this.champLeague);

                Toast.makeText(getApplicationContext(), placarZerado, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void exibeResultado(){
        if(this.contadorBarcelona > this.contadorReal){
            this.resultado.setText(this.barWins);
        } else if(this.contadorBarcelona < this.contadorReal){
            this.resultado.setText(this.realWins);
        }else {
            this.resultado.setText(this.empate);
        }
    }


}
