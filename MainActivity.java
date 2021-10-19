package com.packagename;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private AdRequest adRequest;
    UnifiedNativeAd adobj;
    private AdView mAdview;
    /* access modifiers changed from: private */
    public InterstitialAd mInterstitialAd;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize((Context) this, getString(R.string.admob_app_id));
        this.mAdview = (AdView) findViewById(R.id.adView);
        this.adRequest = new Builder().build();
        this.mAdview.loadAd(this.adRequest);
        this.mInterstitialAd = new InterstitialAd(this);
        this.mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));
        this.mInterstitialAd.loadAd(this.adRequest);
        this.adRequest = new Builder().build();

        MobileAds.initialize(MainActivity.this, new OnInitializationCompleteListener()
        {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus)
            {

            }
        });
        AdLoader.Builder builder = new AdLoader.Builder(MainActivity.this,getString(R.string.admob_native_id));
        builder.withAdListener(new AdListener(){
            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError)
            {
                super.onAdFailedToLoad(loadAdError);
                Toast.makeText(MainActivity.this, loadAdError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener()
        {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd)
            {
                adobj = unifiedNativeAd;
                Toast.makeText(MainActivity.this, "Ad loaded", Toast.LENGTH_SHORT).show();
            }
        });
        AdLoader adLoader =builder.build();
        adLoader.loadAd(new AdRequest.Builder().build());

        //TextView foo = (TextView)findViewById(R.id.foo);
        //foo.setText(Html.fromHtml(getString(R.string.nice_html)));


        // TextView c1 = (TextView)findViewById(R.id.c1);
        //   c1.setText(Html.fromHtml(getString(R.string.warning)));

    }


    public void p1(View view) {
        if (this.mInterstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    super.onAdClosed();
                    MainActivity.this.mInterstitialAd.loadAd(new Builder().build());
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.startActivity(new Intent(mainActivity, PageOne.class));
                    MainActivity.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });
            return;
        }
        startActivity(new Intent(this, PageOne.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    public void p2(View view) {
        if (this.mInterstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    super.onAdClosed();
                    MainActivity.this.mInterstitialAd.loadAd(new Builder().build());
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.startActivity(new Intent(mainActivity, PageTwo.class));
                    MainActivity.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });
            return;
        }
        startActivity(new Intent(this, PageTwo.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    public void p3(View view) {
        if (this.mInterstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    super.onAdClosed();
                    MainActivity.this.mInterstitialAd.loadAd(new Builder().build());
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.startActivity(new Intent(mainActivity, PageThree.class));
                    MainActivity.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });
            return;
        }
        startActivity(new Intent(this, PageThree.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void p4(View view) {
        if (this.mInterstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    super.onAdClosed();
                    MainActivity.this.mInterstitialAd.loadAd(new Builder().build());
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.startActivity(new Intent(mainActivity, PageFour.class));
                    MainActivity.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });
            return;
        }
        startActivity(new Intent(this, PageFour.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void p5(View view) {
        if (this.mInterstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    super.onAdClosed();
                    MainActivity.this.mInterstitialAd.loadAd(new Builder().build());
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.startActivity(new Intent(mainActivity, PageFive.class));
                    MainActivity.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });
            return;
        }
        startActivity(new Intent(this, PageFive.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void p6(View view) {
        if (this.mInterstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    super.onAdClosed();
                    MainActivity.this.mInterstitialAd.loadAd(new Builder().build());
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.startActivity(new Intent(mainActivity, PageSix.class));
                    MainActivity.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });
            return;
        }
        startActivity(new Intent(this, PageSix.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }



    public static void update(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(activity.getPackageName());
        String str = "android.intent.action.VIEW";
        try {
            activity.startActivity(new Intent(str, Uri.parse(sb.toString())));
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http://play.google.com/store/apps/details?id=");
            sb2.append(activity.getPackageName());
            activity.startActivity(new Intent(str, Uri.parse(sb2.toString())));
        }
    }

    public static void rateAction(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(activity.getPackageName());
        String str = "android.intent.action.VIEW";
        try {
            activity.startActivity(new Intent(str, Uri.parse(sb.toString())));
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http://play.google.com/store/apps/details?id=");
            sb2.append(activity.getPackageName());
            activity.startActivity(new Intent(str, Uri.parse(sb2.toString())));
        }
    }

    @Override
    public void onBackPressed()
    {
        ExitDialog exitDialog = new ExitDialog(MainActivity.this, this.adobj);
        exitDialog.show();
        Window window = exitDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
    }


}
