package com.igaworks.adpopcorn.renewal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import com.igaworks.adpopcorn.a.b;
import com.igaworks.adpopcorn.a.d;
import com.igaworks.adpopcorn.cores.common.h;
import com.igaworks.adpopcorn.renewal.layout.ApRewardOfferWallLayout;
import com.igaworks.adpopcorn.style.APOfferwallTabInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ApRewardOfferWallActivity extends Activity {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f1641b;
    private boolean c;
    private boolean d;
    private ApRewardOfferWallLayout e;
    private int f;
    private APOfferwallTabInfo g;

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        try {
            d dVar = this.f1641b;
            if (dVar != null) {
                dVar.c((String) null);
            }
            overridePendingTransition(0, 0);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            if (this.e != null) {
                this.d = this.f1641b.c((Activity) this);
                h.a(this.a, "ApRewardOfferWallActivity", "onConfigurationChanged landscapeMode : " + this.d, 3);
                this.e.setApOfferWallOrientation(this.d);
                this.e.onCustomConfigurationChanged(configuration);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = false;
        this.a = this;
        if (bundle != null) {
            try {
                this.c = bundle.getBoolean("app_restart", false);
                h.a(this.a, "ApRewardOfferWallActivity", "savedInstanceState >> app_restart : " + this.c, 3);
            } catch (Exception unused) {
                h.a(this.a, "ApRewardOfferWallActivity", "onCreate Exception", 3);
                return;
            }
        }
        if (!this.c) {
            Intent intent = getIntent();
            this.f = intent.getIntExtra("offerwallType", 0);
            this.g = (APOfferwallTabInfo) intent.getSerializableExtra("offerwallTabInfo");
            getWindow().getDecorView().setBackgroundColor(0);
            if (Build.VERSION.SDK_INT >= 11) {
                getWindow().setFlags(16777216, 16777216);
            }
            this.f1641b = d.a(this.a);
            d.b((Activity) this);
            this.d = this.f1641b.c((Activity) this);
            ApRewardOfferWallLayout apRewardOfferWallLayout = new ApRewardOfferWallLayout(this.a);
            this.e = apRewardOfferWallLayout;
            apRewardOfferWallLayout.setApOfferWallOrientation(this.d);
            this.e.setTabOfferwallInfo(this.g);
            this.e.setOfferwallType(this.f);
            this.e.setOfferwallActivity(this);
            setContentView(this.e);
            this.e.setCustomViewMode(false);
            this.e.initOfferwallLayout(false, false);
        }
        if (b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
            getWindow().addFlags(524288);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d dVar;
        super.onDestroy();
        try {
            if (!this.c && (dVar = this.f1641b) != null) {
                dVar.c(false);
            }
            ApRewardOfferWallLayout apRewardOfferWallLayout = this.e;
            if (apRewardOfferWallLayout != null) {
                apRewardOfferWallLayout.destroy();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            this.f1641b.d();
            this.e.pause();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (this.c) {
                finish();
            } else {
                this.e.resume(false);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        try {
            bundle.putBoolean("app_restart", true);
        } catch (Exception unused) {
        }
    }
}
