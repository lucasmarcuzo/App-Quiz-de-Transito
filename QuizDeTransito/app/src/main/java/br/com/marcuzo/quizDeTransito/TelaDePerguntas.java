package br.com.marcuzo.quizDeTransito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TelaDePerguntas extends AppCompatActivity {

    private AtomicInteger respostasCorretas;
    private AtomicInteger idPlacaAtual;
    private Partidas partida;
    private ArrayList<Integer> idPlacas;
    private TextView tv_alternativaA;
    private TextView tv_alternativaB;
    private TextView tv_alternativaC;
    private TextView tv_alternativaD;
    private ImageView iv_bandeira;
    private String alternativaCorreta;
    private Button btn_responder;
    private String respostaDoUsuario = "";
    private TextView tv_numeroDaPergunta;
    private final Timer timer = new Timer();
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_perguntas);

        //Esconder a ActionBar
        getSupportActionBar().hide();

        //Desabilitar totalmente a translucidez ou qualquer cor colocada na barra de status:
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        //Inicialização dos objetos
        this.btn_responder = findViewById(R.id.btn_responder);
        this.tv_alternativaA = findViewById(R.id.tv_alternativaA);
        this.tv_alternativaB = findViewById(R.id.tv_alternativaB);
        this.tv_alternativaC = findViewById(R.id.tv_alternativaC);
        this.tv_alternativaD = findViewById(R.id.tv_alternativaD);
        this.iv_bandeira = findViewById(R.id.iv_bandeira);
        this.tv_numeroDaPergunta = findViewById(R.id.tv_numeroDaPergunta);

        //Iniciar nova partida.
        this.zerarPartida();

        //Carregar primeira pergunta.
        //btn_responder.post(() -> btn_responder.performClick());
        btn_responder.post(() -> carregarProximaPergunta());

        //Disparar evento de resposta do usuário.
        this.tv_alternativaA.setOnClickListener(v -> {
            marcarResposta(this.tv_alternativaA);
        });

        this.tv_alternativaB.setOnClickListener(v -> {
            marcarResposta(this.tv_alternativaB);
        });

        this.tv_alternativaC.setOnClickListener(v -> {
            marcarResposta(this.tv_alternativaC);
        });

        this.tv_alternativaD.setOnClickListener(v -> {
            marcarResposta(this.tv_alternativaD);
        });

        //Carregar próxima pergunta
        btn_responder.setOnClickListener(v -> {

            //Verificar se resposta enviada está correta
            if(respostaDoUsuario.equals(alternativaCorreta)){
                respostasCorretas.getAndIncrement();
                //Toast.makeText(getApplicationContext(), "CERTA RESPOSTA!", Toast.LENGTH_SHORT).show();
                //emitirSomDeResposta(R.raw.certa_resposta);
                MediaPlayer mediaPlayer = MediaPlayer.create(TelaDePerguntas.this, R.raw.certa_resposta);
                mediaPlayer.setOnCompletionListener(mp -> {
                    mp.reset();
                    mp.release();
                });
                mediaPlayer.start();

                switch (alternativaCorreta){
                    case "A":
                        tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.verde));
                        tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.white));
                        tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.white));
                        tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.white));
                        break;
                    case "B":
                        tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.verde));
                        tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.white));
                        tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.white));
                        tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.white));
                        break;
                    case "C":
                        tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.verde));
                        tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.white));
                        tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.white));
                        tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.white));
                        break;
                    case "D":
                        tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.verde));
                        tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.white));
                        tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.white));
                        tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.white));
                        break;
                }
            }
            else {
                if(respostasCorretas.get() <= 0){
                    respostasCorretas.set(0);
                }else{

                    switch (respostaDoUsuario){
                        case "A":
                            tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.vermelho));
                            tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.white));
                            tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.white));
                            tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.white));
                            break;
                        case "B":
                            tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.vermelho));
                            tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.white));
                            tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.white));
                            tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.white));
                            break;
                        case "C":
                            tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.vermelho));
                            tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.white));
                            tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.white));
                            tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.white));
                            break;
                        case "D":
                            tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.vermelho));
                            tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.white));
                            tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.white));
                            tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.white));
                            break;
                    }

                    switch (alternativaCorreta){
                        case "A":
                            tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.verde));
                            break;
                        case "B":
                            tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.verde));
                            break;
                        case "C":
                            tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.verde));
                            break;
                        case "D":
                            tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.verde));
                            break;
                    }
                    //emitirSomDeResposta(R.raw.que_pena_voce_errou);
                    MediaPlayer mediaPlayer = MediaPlayer.create(TelaDePerguntas.this, R.raw.que_pena_voce_errou);
                    mediaPlayer.setOnCompletionListener(mp -> {
                        mp.reset();
                        mp.release();
                    });
                    mediaPlayer.start();
                }
            }

            timerTask = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(() -> {
                        carregarProximaPergunta();
                    });
                }
            };
            timer.schedule(timerTask, 1600);

        });


    }

    private void carregarProximaPergunta(){
        //Limpar resposta selecionada e bloquear botão de resposta.
        btn_responder.setEnabled(false);
        btn_responder.setText("Escolha uma alternativa");
        btn_responder.setBackgroundTintList(getColorStateList(R.color.black));
        tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
        tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
        tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
        tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));

        //Verificar se ainda há perguntas a serem respondidas.
        try {
            EnumPlacas pais = partida.retornarPlacas(idPlacas.get(idPlacaAtual.get()));
            Arrays.asList(pais).forEach(p -> {

                tv_alternativaA.setText(p.getAlternativas()[0]);
                tv_alternativaB.setText(p.getAlternativas()[1]);
                tv_alternativaC.setText(p.getAlternativas()[2]);
                tv_alternativaD.setText(p.getAlternativas()[3]);
                iv_bandeira.setImageResource(p.getCodImgPais());

                alternativaCorreta = p.getRespostaCorreta();
            });
            idPlacaAtual.getAndIncrement();
            tv_numeroDaPergunta.setText(idPlacaAtual.get() + "/40");
        }
        catch (Exception e){
            finish();
            Intent intent = new Intent(TelaDePerguntas.this, Ranking.class);
            intent.putExtra("pontuacao", String.valueOf(respostasCorretas.get()));
            intent.putExtra("nomeJogador", partida.getNomeJogador());
            startActivity(intent);
        }
    }

    //Iniciar partida zerada.
    public void zerarPartida(){
        this.respostasCorretas = new AtomicInteger();
        this.idPlacaAtual = new AtomicInteger();
        this.partida = (Partidas) getIntent().getSerializableExtra("partida");
        this.idPlacas = getIntent().getIntegerArrayListExtra("idPlacas");

    }

    //Voltar para a tela inicial.
    @Override
    public void onBackPressed() {
        this.finish();
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(it);
    }

    //Marcar resposta selecionada.
    public void marcarResposta(TextView tv){
        btn_responder.setEnabled(true);
        btn_responder.setBackgroundTintList(getColorStateList(R.color.ic_my_icone_background));
        btn_responder.setText("Responder");
        switch (tv.getId()){
            case R.id.tv_alternativaA:
                respostaDoUsuario = "A";
                tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.verde));
                tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                break;
            case R.id.tv_alternativaB:
                respostaDoUsuario = "B";
                tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.verde));
                tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                break;
            case R.id.tv_alternativaC:
                respostaDoUsuario = "C";
                tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.verde));
                tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                break;
            case R.id.tv_alternativaD:
                respostaDoUsuario = "D";
                tv_alternativaA.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                tv_alternativaB.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                tv_alternativaC.setBackgroundTintList(getColorStateList(R.color.amarelo_placa));
                tv_alternativaD.setBackgroundTintList(getColorStateList(R.color.verde));
                break;
        }
    }

    //Emitir som de resposta.
//    public void emitirSomDeResposta(int idSom){
//        MediaPlayer mediaPlayer = MediaPlayer.create(TelaDePerguntas.this, idSom);
//        mediaPlayer.setOnCompletionListener(mp -> {
//            mp.reset();
//            mp.release();
//        });
//        mediaPlayer.start();
//    }

}