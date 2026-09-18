package com.applovin.impl.mediation.a;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.v;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;

/* JADX INFO: loaded from: classes.dex */
public class b extends Activity implements a.InterfaceC0116a {
    protected a aum;
    protected c aun = new c(null);
    private MaxAdapterListener auo;
    protected n sdk;

    protected void a(c cVar, n nVar, MaxAdapterListener maxAdapterListener) {
        this.sdk = nVar;
        this.aun = cVar;
        this.auo = maxAdapterListener;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.setBackgroundColor(this.aun.mN());
        n nVar = this.sdk;
        com.applovin.impl.sdk.utils.b.a(nVar != null ? ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNn)).booleanValue() : true, this);
        a aVar = new a(this.aun, this);
        this.aum = aVar;
        aVar.setListener(this);
        this.aum.setVisibility(4);
        viewGroup.addView(this.aum);
        v.a(this.aum, this.aun.xq());
    }

    @Override // com.applovin.impl.mediation.a.a.InterfaceC0116a
    public void a(a aVar) {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        MaxAdapterListener maxAdapterListener = this.auo;
        if (maxAdapterListener != null) {
            if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
                ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdHidden();
            } else if (maxAdapterListener instanceof MaxAppOpenAdapterListener) {
                ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdHidden();
            } else {
                throw new IllegalStateException("Failed to fire hidden callback (" + this.auo + "): neither interstitial nor app open ad");
            }
        }
        super.onDestroy();
    }

    protected void a(View view, String str) {
        if (view == null) {
            bU(str);
            return;
        }
        ((ViewGroup) findViewById(R.id.content)).addView(view);
        this.aum.bringToFront();
        MaxAdapterListener maxAdapterListener = this.auo;
        if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayed();
        } else {
            if (maxAdapterListener instanceof MaxAppOpenAdapterListener) {
                ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayed();
                return;
            }
            throw new IllegalStateException("Failed to fire display callback (" + this.auo + "): neither interstitial nor app open ad");
        }
    }

    private void bU(String str) {
        MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Null hybrid ad view (" + str + ")");
        MaxAdapterListener maxAdapterListener = this.auo;
        if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayFailed(maxAdapterError);
        } else if (maxAdapterListener instanceof MaxAppOpenAdapterListener) {
            ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayFailed(maxAdapterError);
        } else {
            throw new IllegalStateException("Failed to fire display failed callback (" + this.auo + "): neither interstitial nor app open ad");
        }
        finish();
    }
}
