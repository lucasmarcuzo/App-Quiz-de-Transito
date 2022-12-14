package br.com.marcuzo.quizDeTransito;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Ranking extends AppCompatActivity {

    TextView tv_nomeJogador;
    TextView tv_pontuacao;
    TextView tv_pontuacaoDoJogador;
    Button btn_jogarNovamente;
    Button btn_telaPrincipal;


    private final Timer timer = new Timer();
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        //Esconder a ActionBar
        getSupportActionBar().hide();

        //Parar o som de fundo.
        SomDeTema.pararSomDeFundo();

        //Desabilitar totalmente a translucidez ou qualquer cor colocada na barra de status:
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        tv_nomeJogador = findViewById(R.id.tv_nomeJogador);
        tv_pontuacao = findViewById(R.id.tv_pontuacao);
        tv_pontuacaoDoJogador = findViewById(R.id.tv_pontuacaoDoJogador);
        btn_jogarNovamente = findViewById(R.id.btn_jogarNovamente);
        btn_telaPrincipal = findViewById(R.id.btn_telaPrincipal);

        tv_nomeJogador.setText(getIntent().getStringExtra("nomeJogador"));
        tv_pontuacaoDoJogador.setText(getIntent().getStringExtra("pontuacao"));

        //Tocar som de fundo.
        int pontuacaoFinal = Integer.parseInt(tv_pontuacaoDoJogador.getText().toString());
        if(pontuacaoFinal <= 10) {
            emitirSomDeResposta(R.raw.reprovado);
        }
        else if(pontuacaoFinal > 10 && pontuacaoFinal <= 30){
            emitirSomDeResposta(R.raw.e_ta_bom);
        }
        else{
            emitirSomDeResposta(R.raw.vitoria);
        }

        btn_jogarNovamente.setOnClickListener(view -> {
            SomDeTema.tocarSomDeFundo(this);
            Partidas partida = new Partidas(tv_nomeJogador.getText().toString(), 0);
            ArrayList<Integer> idPlacas = partida.gerarOrdemPerguntas();
            this.finish();
            Intent it = new Intent(getApplicationContext(), TelaDePerguntas.class);
            it.putExtra("partida", partida);
            it.putIntegerArrayListExtra("idPlacas", idPlacas);
            startActivity(it);

        });

        btn_telaPrincipal.setOnClickListener(view -> {
            this.finish();
            Intent it = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(it);
        });

       //Voltar para a tela inicial se for clicado no botão de voltar no celular.
       getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
            }
        });
    }

    //Emitir som de resposta.
    public void emitirSomDeResposta(int idSom){
        timerTask = new TimerTask() {
            @Override
            public void run() {
            runOnUiThread(() -> {
                MediaPlayer mp = MediaPlayer.create(Ranking.this, idSom);
                mp.setOnCompletionListener(mp1 -> mp1.release());
                mp.start();
            });
            }
        };
        timer.schedule(timerTask, 1500);

    }
}