package jp.ac.it_college.std.s15011.jinrou;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class GameActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    TabLayout tabLayout;

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
        day_or_night.setText("ひる");

        Typeface typeface = Typeface.createFromAsset(getAssets(), "JKG-L_3.ttf");
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "03SmartFontUI.otf");
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
    }

    private void changeTabsFont() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "JKG-L_3.ttf");
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


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

//    public static class TestFragment extends Fragment {
//        public TestFragment() {
//        }
//
//        public static TestFragment newInstance(int page) {
//            Bundle args = new Bundle();
//            args.putInt("page", page);
//            TestFragment fragment = new TestFragment();
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Nullable
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState) {
//            int page = getArguments().getInt("page", 1);
//            View view;
//            switch (page) {
//                case 2:
//                    view = inflater.inflate(R.layout.chat_tab, group, false);
//                    break;
//                default:
//                    view = inflater.inflate(R.layout.member_tab, group, false);
//                    break;
//            }
//            return view;
//        }
//    }


}
