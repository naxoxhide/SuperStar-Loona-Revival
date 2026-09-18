package com.tapjoy;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tapjoy.internal.f8;
import com.tapjoy.internal.i8;
import com.tapjoy.internal.q6;
import com.tapjoy.internal.s6;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class TJAdUnitActivity extends TJActivity {
    public static TJAdUnitActivity l;
    public TJAdUnit g;
    public TJPlacementData h;
    public final Handler f = new Handler(Looper.getMainLooper());
    public TJAdUnitSaveStateData i = new TJAdUnitSaveStateData();
    public boolean j = false;
    public boolean k = false;

    @Override // com.tapjoy.TJActivity
    public final void a() {
        a(false);
    }

    public final void b() {
        l = null;
        this.j = true;
        TJAdUnit tJAdUnit = this.g;
        if (tJAdUnit != null) {
            tJAdUnit.destroy();
        }
        TJPlacementData tJPlacementData = this.h;
        if (tJPlacementData != null) {
            if (tJPlacementData.getContentViewId() != null) {
                TapjoyConnectCore.viewDidClose(this.h.getContentViewId());
            }
            TJCorePlacement tJCorePlacementA = TJPlacementManager.a(this.h.getKey());
            if (tJCorePlacementA != null) {
                if (i8.e) {
                    HashMap map = new HashMap();
                    map.put("sdkCloseBtn", String.valueOf(this.k));
                    this.g.getTjBeacon().a("dismiss", map);
                }
                TJPlacement tJPlacementA = tJCorePlacementA.a("SHOW");
                if (tJPlacementA == null || tJPlacementA.getListener() == null) {
                    return;
                }
                TapjoyLog.i("TJCorePlacement", "Content dismissed for placement " + tJCorePlacementA.d.getPlacementName());
                TJPlacementListener tJPlacementListener = tJPlacementA.c;
                if (tJPlacementListener != null) {
                    tJPlacementListener.onContentDismiss(tJPlacementA);
                }
            }
        }
    }

    @Override // com.tapjoy.TJActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        a(false);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TJAdUnit tJAdUnit = this.g;
        if (tJAdUnit != null) {
            tJAdUnit.notifyOrientationChanged();
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00db  */
    @Override // com.tapjoy.TJActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i;
        TapjoyLog.d("TJAdUnitActivity", "TJAdUnitActivity onCreate: " + bundle);
        super.onCreate(bundle);
        l = this;
        if (bundle != null) {
            TJAdUnitSaveStateData tJAdUnitSaveStateData = (TJAdUnitSaveStateData) bundle.getSerializable("ad_unit_bundle");
            this.i = tJAdUnitSaveStateData;
            if (tJAdUnitSaveStateData != null && tJAdUnitSaveStateData.isVideoComplete) {
                TapjoyLog.d("TJAdUnitActivity", "finishing TJAdUnitActivity");
                finish();
                return;
            }
        }
        Bundle extras = getIntent().getExtras();
        PackageInfo packageInfo = null;
        String string = extras != null ? extras.getString(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_NAME) : null;
        TJPlacementData tJPlacementData = string != null ? (TJPlacementData) TJMemoryDataStorage.getInstance().get(string) : null;
        this.h = tJPlacementData;
        if (tJPlacementData == null) {
            TapjoyLog.e("TJAdUnitActivity", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Failed to launch AdUnit Activity"));
            finish();
            return;
        }
        if (tJPlacementData.getContentViewId() != null) {
            TapjoyConnectCore.viewWillOpen(this.h.getContentViewId(), 1);
        }
        if (TJPlacementManager.a(this.h.getKey()) != null) {
            this.g = TJPlacementManager.a(this.h.getKey()).getAdUnit();
        } else {
            this.g = new TJAdUnit();
        }
        if (!this.g.hasCalledLoad()) {
            TapjoyLog.d("TJAdUnitActivity", "No content loaded for ad unit -- loading now");
            this.g.load(this.h, false, this);
        }
        this.g.setAdUnitActivity(this);
        try {
            try {
                packageInfo = getPackageManager().getPackageInfo(getPackageName(), 1);
            } catch (PackageManager.NameNotFoundException e) {
                TapjoyLog.e("TJDevice", e.getMessage());
            }
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                if (activityInfoArr.length > 0) {
                    i = activityInfoArr[0].screenOrientation;
                } else {
                    i = -1;
                }
            } else {
                i = -1;
            }
            setRequestedOrientation(i);
            View backgroundView = this.g.getBackgroundView();
            backgroundView.setLayoutParams(this.f2682b);
            if (backgroundView.getParent() != null) {
                ((ViewGroup) backgroundView.getParent()).removeView(backgroundView);
            }
            TJWebView webView = this.g.getWebView();
            webView.setLayoutParams(this.f2682b);
            if (webView.getParent() != null) {
                ((ViewGroup) webView.getParent()).removeView(webView);
            }
            VideoView videoView = this.g.getVideoView();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (videoView.getParent() != null) {
                ((ViewGroup) videoView.getParent()).removeView(videoView);
            }
            this.a.addView(backgroundView);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setGravity(17);
            linearLayout.addView(videoView, new LinearLayout.LayoutParams(-1, -1));
            this.a.addView(linearLayout, layoutParams);
            this.a.addView(webView);
            if (this.h.hasProgressSpinner()) {
                setProgressSpinnerVisibility(true);
            } else {
                setProgressSpinnerVisibility(false);
            }
            this.a.addView(this.d);
            this.a.addView(this.c);
            setContentView(this.a);
            this.g.setVisible(true);
        } catch (Exception e2) {
            TapjoyLog.e("TJAdUnitActivity", e2.getMessage());
        }
        TJCorePlacement tJCorePlacementA = TJPlacementManager.a(this.h.getKey());
        if (tJCorePlacementA != null) {
            TapjoyLog.i("TJCorePlacement", "Content shown for placement " + tJCorePlacementA.d.getPlacementName());
            TJPlacement tJPlacementA = tJCorePlacementA.a("SHOW");
            if (tJPlacementA != null && tJPlacementA.getListener() != null) {
                tJPlacementA.getListener().onContentShow(tJPlacementA);
            }
            if (this.g.getSdkBeacon() != null) {
                s6 sdkBeacon = this.g.getSdkBeacon();
                if (!TextUtils.isEmpty(sdkBeacon.c) && !sdkBeacon.f) {
                    sdkBeacon.f = true;
                    new q6(sdkBeacon, new HashMap(sdkBeacon.f2811b)).start();
                }
            }
        }
        TJAdUnit tJAdUnit = this.g;
        tJAdUnit.a.postDelayed(tJAdUnit.G, 5000L);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (!this.j) {
            b();
        }
        l = null;
    }

    @Override // android.app.Activity
    public final void onPause() {
        TJPlacementData tJPlacementData;
        super.onPause();
        TapjoyLog.d("TJAdUnitActivity", "onPause");
        TJAdUnit tJAdUnit = this.g;
        if (tJAdUnit != null) {
            tJAdUnit.pause();
        } else {
            finish();
        }
        if (isFinishing() && (tJPlacementData = this.h) != null && tJPlacementData.shouldHandleDismissOnPause()) {
            TapjoyLog.d("TJAdUnitActivity", "is Finishing");
            b();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        TapjoyLog.d("TJAdUnitActivity", "onResume");
        super.onResume();
        TJAdUnit tJAdUnit = this.g;
        if (tJAdUnit != null) {
            tJAdUnit.resume(this.i);
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TapjoyLog.d("TJAdUnitActivity", "onSaveInstanceState");
        TJAdUnit tJAdUnit = this.g;
        if (tJAdUnit != null) {
            this.i.seekTime = tJAdUnit.getVideoSeekTime();
            this.i.isVideoComplete = this.g.isVideoComplete();
            this.i.isVideoMuted = this.g.isMuted();
            bundle.putSerializable("ad_unit_bundle", this.i);
        }
    }

    @Override // com.tapjoy.TJActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        TapjoyLog.d("TJAdUnitActivity", "onStart");
    }

    @Override // com.tapjoy.TJActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        TapjoyLog.d("TJAdUnitActivity", "onStop");
    }

    public void setSdkCloseButtonClicked(boolean z) {
        this.k = z;
    }

    public final void a(boolean z) {
        TJAdUnit tJAdUnit = this.g;
        if (tJAdUnit == null) {
            finish();
        } else if (!tJAdUnit.getCloseRequested()) {
            TapjoyLog.d("TJAdUnitActivity", TJAdUnitConstants.String.CLOSE_REQUESTED);
            this.g.closeRequested(z);
            this.f.postDelayed(new f8(this), 1000L);
        }
        if (this.h != null) {
            TJMemoryDataStorage.getInstance().remove(this.h.getPlacementName());
        }
    }
}
