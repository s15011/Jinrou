package jp.ac.it_college.std.s15011.jinrou;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.run_title_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.b_069);
                mp.setVolume(0.8f, 0.8f);
                Intent intent = new Intent(getApplicationContext(), TitleActivity.class);
                mp.start();
                startActivity(intent);
            }
        });

        findViewById(R.id.run_game_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.b_069);
                mp.setVolume(0.8f, 0.8f);
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                mp.start();
                startActivity(intent);
            }
        });

        findViewById(R.id.socket_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.b_069);
                mp.setVolume(0.8f, 0.8f);
                Intent intent = new Intent(getApplicationContext(), SocketTest.class);
                mp.start();
                startActivity(intent);
            }
        });

    }
}
