package id.persijap.jepara;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.CookieManager;

public class Home extends Fragment
{

    private WebView viewHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home, container, false);

        viewHome = (WebView) view.findViewById(R.id.viewhome);
        viewHome.loadUrl("http://persijap.co.id");

        WebSettings webSettings = viewHome.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.getDomStorageEnabled();

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);

        viewHome.getSettings().setAppCacheEnabled(true);
        viewHome.getSettings().setAppCachePath("/data/data/id.persijap.jepara/cache");
        viewHome.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        viewHome.setWebViewClient(new WebViewClient());

        return view;
    }

}
