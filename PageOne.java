package com.packagename;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class PageOne extends AppCompatActivity {
    private AdRequest adRequest;
    /* access modifiers changed from: private */
    public String currentUrl;
    private AdView mAdview;
    private WebView mwebView;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout swipeRefreshLayout;
    private Toolbar toolbar;

    /* access modifiers changed from: protected */
    @SuppressLint("WrongConstant")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.page_one);

        MobileAds.initialize((Context) this, getString(R.string.admob_app_id));
        this.mAdview = (AdView) findViewById(R.id.adView);
        this.adRequest = new Builder().build();
        this.mAdview.loadAd(this.adRequest);
        this.progressBar = (ProgressBar) findViewById(R.id.psbar);
        this.progressBar.setMax(100);
        this.progressBar.setVisibility(0);
        webView();
        this.swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        this.swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                PageOne.this.refreshWebview();
            }
        });
    }



    //private void setupToolbar() {
    //      this.toolbar = (Toolbar) findViewById(R.id.toolbar);
    //   this.toolbar.setTitle((CharSequence) getString(R.string.OtherGuessings));
    // setSupportActionBar(this.toolbar);
    //    getSupportActionBar().setDisplayShowHomeEnabled(true);
    //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    // }

    public void webView() {
        this.mwebView = (WebView) findViewById(R.id.webview);
        this.mwebView.setWebViewClient(new WebViewClient() {
            @SuppressLint("WrongConstant")
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                PageOne.this.progressBar.setVisibility(0);
            }

            @SuppressLint("WrongConstant")
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                PageOne.this.progressBar.setVisibility(8);
                PageOne.this.currentUrl = str;
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        });
        this.mwebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                PageOne.this.progressBar.setProgress(i);
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        this.mwebView.loadUrl(getString(R.string.page_one_link));
        this.mwebView.getSettings().setBuiltInZoomControls(true);
        this.mwebView.getSettings().setDisplayZoomControls(false);
        this.mwebView.getSettings();
        this.mwebView.getSettings().setJavaScriptEnabled(true);
    }

    public void refreshWebview() {
        this.mwebView = (WebView) findViewById(R.id.webview);
        this.mwebView.setWebViewClient(new WebViewClient() {
            @SuppressLint("WrongConstant")
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                PageOne.this.progressBar.setVisibility(0);
            }

            @SuppressLint("WrongConstant")
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                PageOne.this.progressBar.setVisibility(8);
                PageOne.this.currentUrl = str;
                PageOne.this.swipeRefreshLayout.setRefreshing(false);
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        });
        this.mwebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                PageOne.this.progressBar.setProgress(i);
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        this.mwebView.loadUrl(this.currentUrl);
        this.mwebView.getSettings().setBuiltInZoomControls(true);
        this.mwebView.getSettings().setDisplayZoomControls(false);
        this.mwebView.getSettings();
        this.mwebView.getSettings().setJavaScriptEnabled(true);
    }

    public void onBackPressed() {
        if (this.mwebView.canGoBack()) {
            this.mwebView.goBack();
            return;
        }
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
