package br.com.marcuzo.quizDeTransito;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //Declaração dos objetos
    private EditText et_nomeJogador;
    private Button btn_sair;
    private Button btn_jogar;
    private String nomeJogador;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Esconder a ActionBar
        getSupportActionBar().hide();

        //Desabilitar totalmente a translucidez ou qualquer cor colocada na barra de status:
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        //Inicialização dos objetos
        this.et_nomeJogador = findViewById(R.id.et_nomeJogador);
        this.btn_sair = findViewById(R.id.btn_sair);
        this.btn_jogar = findViewById(R.id.btn_iniciarQuiz);

        //Tocar música de fundo.
        SomDeTema.tocarSomDeFundo(this);

        //Chamada dos métodos
        sairDoJogo(btn_sair);
        liberarQuiz(et_nomeJogador, btn_jogar);

        //Iniciar jogo.
        btn_jogar.setOnClickListener(v -> {
            if(!et_nomeJogador.getText().toString().equals("Digite o seu nome")) {
                nomeJogador = et_nomeJogador.getText().toString();
            }
            Partidas partida = new Partidas(nomeJogador, 0);
            ArrayList<Integer> idPlacas = partida.gerarOrdemPerguntas();

            this.finish();
            Intent it = new Intent(getApplicationContext(), TelaDePerguntas.class);
            it.putExtra("partida", partida);
            it.putIntegerArrayListExtra("idPlacas", idPlacas);
            startActivity(it);

            //Mensagem de boas vindas
            //Toast.makeText(getApplicationContext(), "Bem vindo ao Quiz, " + nomeJogador + "!", Toast.LENGTH_SHORT).show();

        });

        //Voltar para a tela inicial se for clicado no botão de voltar no celular.
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
                btn_sair.post(() -> btn_sair.performClick());
            }
        });
    }

    //Sair do jogo.
    private void sairDoJogo(Button btn) {
        btn.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }


    //Liberar o quiz.
    private void liberarQuiz(EditText et, Button btn){
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //sem uso
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn.setEnabled(!s.toString().trim().isEmpty());
            }
            @Override
            public void afterTextChanged(Editable e) {
                //sem uso
            }
        });
    }



}