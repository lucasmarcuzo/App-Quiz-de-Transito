package br.com.marcuzo.quizDeTransito;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SomDeTema  extends AppCompatActivity {

    private static MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void tocarSomDeFundo(Context context) {
        if (mp != null) {
            mp.reset();
            mp.release();
        } else {
            mp = MediaPlayer.create(context, R.raw.loop);
            mp.start();
            mp.setLooping(true);
        }
    }

    public static void pararSomDeFundo() {
        if (mp != null) {
            mp.stop();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mp != null) {
            mp.stop();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.release();
        }

    }
}
