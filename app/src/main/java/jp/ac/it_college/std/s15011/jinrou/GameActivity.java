package jp.ac.it_college.std.s15011.jinrou;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class GameActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    TabLayout tabLayout;
    private String GameFont =  "JKG-L_3.ttf";
    private String GameStatus = "night";
    private String IP = "172.16.43.39";
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        TextView player_name = (TextView) findViewById(R.id.player_name);
        TextView player_job = (TextView) findViewById(R.id.player_job);
        TextView day_or_night = (TextView) findViewById(R.id.day_or_night);
        TextView sec = (TextView) findViewById(R.id.sec);
        ToggleButton tb = (ToggleButton) findViewById(R.id.toggleButton);

        player_name.setText("なまえ");
        day_or_night.setText("よる");

        Typeface typeface = Typeface.createFromAsset(getAssets(), GameFont);
        player_name.setTypeface(typeface);
        player_job.setTypeface(typeface);
        day_or_night.setTypeface(typeface);
        sec.setTypeface(typeface);
        tb.setTypeface(typeface);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch(position) {
                    case 0:
                        return new MemberTab();
                    case 1:
                        return new ChatTab();
                }
                return null;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }
        };

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.tab_icon_selector1).setText("メンバー");
        tabLayout.getTabAt(1).setIcon(R.drawable.tab_icon_selector2).setText("チャット");
        changeTabsFont();
        CountDown countDown = new CountDown(182000, 1000);
        countDown.start();
        mp = MediaPlayer.create(GameActivity.this, R.raw.n24);
        mp.setVolume(0.8f, 0.8f);
        mp.start();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    // タブのフォント変更
    private void changeTabsFont() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), GameFont);
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(typeface);
                }
            }
        }
    }

    // ゲーム中の戻るキーの無効化
    public boolean dispatchKeyEvent(KeyEvent event) {
//        if (event.getAction() == KeyEvent.ACTION_DOWN) {
//            switch (event.getKeyCode()) {
//                case KeyEvent.KEYCODE_BACK:
//                    Toast.makeText(GameActivity.this, "ゲーム中に戻ることはできません", Toast.LENGTH_SHORT).show();
//                    return true;
//            }
//        }
        return super.dispatchKeyEvent(event);
    }

    // 残り秒数のカウントダウン
    public class CountDown extends CountDownTimer {

        TextView count_txt = (TextView) findViewById(R.id.sec);
        TextView d_or_n = (TextView) findViewById(R.id.day_or_night);
        private long GameTime = 0;

        public CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            count_txt.setText(String.valueOf((millisUntilFinished-1000)/1000));
        }

        @Override
        public void onFinish() {
            switch (GameStatus) {
                case "night":
                    d_or_n.setText("ひる");
                    GameStatus = "day";
                    GameTime = 302000;
                    break;
                case "day":
                    d_or_n.setText("処刑");
                    GameStatus = "execution";
                    GameTime = 62000;
                    break;
                case "execution":
                    d_or_n.setText("よる");
                    GameStatus = "night";
                    GameTime = 182000;
                    break;
            }
            CountDown countDown = new CountDown(GameTime, 1000);
            countDown.start();
        }
    }
}

