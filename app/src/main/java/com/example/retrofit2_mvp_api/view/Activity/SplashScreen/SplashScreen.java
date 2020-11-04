package com.example.retrofit2_mvp_api.view.Activity.SplashScreen;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.example.retrofit2_mvp_api.R;
import com.example.retrofit2_mvp_api.view.Fragment.OnBoardingFragment1;
import com.example.retrofit2_mvp_api.view.Fragment.OnBoardingFragment2;
import com.example.retrofit2_mvp_api.view.Fragment.OnBoardingFragment3;

public class SplashScreen extends AppCompatActivity implements ISplashView {
    ImageView logo, appName, splashImg;
    LottieAnimationView lottieAnimationView;
    private View decorView;

    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;

    Animation anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.appname);
        splashImg = findViewById(R.id.bg);
        lottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-4000).setDuration(1000).setStartDelay(6000);
        logo.animate().translationY(4000).setDuration(1000).setStartDelay(6000);
        appName.animate().translationY(4000).setDuration(1000).setStartDelay(6000);
        lottieAnimationView.animate().translationY(4000).setDuration(1000).setStartDelay(6000);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        anim = AnimationUtils.loadAnimation(this, R.anim.o_b_anim);
        viewPager.startAnimation(anim);


    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {


        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                    return tab1;
                case 1:
                    OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                    return tab2;
                case 2:
                    OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}