package com.fyber.inneractive.sdk.activities;

import android.R;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.r;
import com.fyber.inneractive.sdk.flow.z;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.ui.CloseButtonFlowManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.l;
import com.fyber.inneractive.sdk.util.m;

/* JADX INFO: loaded from: classes2.dex */
public class InneractiveFullscreenAdActivity extends InneractiveBaseActivity implements com.fyber.inneractive.sdk.interfaces.c.a {
    public static final String EXTRA_KEY_SPOT_ID = "spotId";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f838b;
    public InneractiveAdSpot c;
    public com.fyber.inneractive.sdk.interfaces.c d;
    public CloseButtonFlowManager i;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public boolean h = false;
    public final Runnable mHideNavigationBarTask = new a();

    public interface FullScreenRendererProvider {
        com.fyber.inneractive.sdk.interfaces.c getFullscreenRenderer();
    }

    public interface OnInneractiveFullscreenAdDestroyListener {
        void onActivityDestroyed(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity);
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InneractiveFullscreenAdActivity.this.isFinishing()) {
                return;
            }
            InneractiveFullscreenAdActivity.this.hideNavigationBar();
        }
    }

    public class b implements View.OnSystemUiVisibilityChangeListener {
        public b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if ((i & 2) == 0) {
                m.f1343b.postDelayed(InneractiveFullscreenAdActivity.this.mHideNavigationBarTask, 3000L);
            }
        }
    }

    public void cancelHideNavigationBarTask() {
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
        m.f1343b.removeCallbacks(this.mHideNavigationBarTask);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public void destroy() {
        if (isFinishing() || this.f838b == null) {
            return;
        }
        finish();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public void disableCloseButton() {
        CloseButtonFlowManager closeButtonFlowManager = this.i;
        closeButtonFlowManager.c.setVisibility(8);
        closeButtonFlowManager.a.setVisibility(8);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public void dismissAd(boolean z) {
        this.h = z;
        cancelHideNavigationBarTask();
        com.fyber.inneractive.sdk.interfaces.c cVar = this.d;
        if (cVar != null) {
            cVar.b(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public View getCloseButton() {
        return this.i.e;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public ViewGroup getLayout() {
        return this.f838b;
    }

    public void hideNavigationBar() {
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            if ((decorView.getSystemUiVisibility() & 2) == 0) {
                decorView.setSystemUiVisibility(2818);
            }
            decorView.setOnSystemUiVisibilityChangeListener(new b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initWindowFeatures(com.fyber.inneractive.sdk.interfaces.c cVar) {
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        getWindow().addFlags(128);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            getWindow().addFlags(2);
        }
        if (cVar != 0 && (((r) cVar) instanceof com.fyber.inneractive.sdk.renderers.k)) {
            setTheme(R.style.Theme.NoTitleBar.Fullscreen);
            if (i >= 19) {
                requestWindowFeature(67108864);
                requestWindowFeature(134217728);
            }
            if (i >= 21) {
                requestWindowFeature(Integer.MIN_VALUE);
            }
        }
        hideNavigationBar();
        a0 a0Var = (a0) this.c.getAdContent().d;
        if (a0Var.f != null) {
            Orientation orientation = a0Var.f.e;
            setActivityOrientation(orientation.allowOrientationChange, orientation);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public boolean isCloseButtonDisplay() {
        return this.i.d.getVisibility() == 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.fyber.inneractive.sdk.interfaces.c cVar = this.d;
        if (cVar == null || !cVar.v()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.fyber.inneractive.sdk.interfaces.c cVar = this.d;
        if (cVar != null) {
            int i = configuration.orientation;
            if (i != this.e) {
                this.e = i;
                cVar.b();
                return;
            }
            int i2 = this.f;
            int i3 = configuration.screenHeightDp;
            if (i2 == i3 && this.g == configuration.screenWidthDp) {
                return;
            }
            this.f = i3;
            this.g = configuration.screenWidthDp;
            cVar.b();
        }
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [AdContent extends com.fyber.inneractive.sdk.flow.q, com.fyber.inneractive.sdk.flow.q] */
    /* JADX WARN: Type inference failed for: r2v7, types: [EventsListener extends com.fyber.inneractive.sdk.external.InneractiveUnitController$EventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController$EventsListener] */
    @Override // com.fyber.inneractive.sdk.activities.InneractiveBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("spotId");
        InneractiveAdSpot inneractiveAdSpot = null;
        if (TextUtils.isEmpty(stringExtra)) {
            IAlog.e("%sSpot id must be provided as an extra before calling createActivity with InneractiveInterstitialAdActivty", IAlog.a(this));
        } else {
            InneractiveAdSpot spot = InneractiveAdSpotManager.get().getSpot(stringExtra);
            if (spot == null) {
                IAlog.b("%sSpot id %s cannot be found in spot manager!", IAlog.a(this), stringExtra);
            }
            if (spot != null && spot.getAdContent() == null) {
                IAlog.a("%sSpot does not have a content. Cannot start activity", IAlog.a(this));
            }
            if (spot != null && spot.getAdContent() != null) {
                inneractiveAdSpot = spot;
            }
        }
        this.c = inneractiveAdSpot;
        if (inneractiveAdSpot == null || inneractiveAdSpot.getAdContent() == null || this.c.getAdContent().d == null) {
            super.onCreate(bundle);
            finish();
            return;
        }
        InneractiveUnitController selectedUnitController = this.c.getSelectedUnitController();
        if (selectedUnitController == null || !(selectedUnitController instanceof FullScreenRendererProvider)) {
            IAlog.e("%sno appropriate unit controller found for full screen ad. Aborting", IAlog.a(this));
            super.onCreate(bundle);
            finish();
            return;
        }
        com.fyber.inneractive.sdk.interfaces.c fullscreenRenderer = ((FullScreenRendererProvider) selectedUnitController).getFullscreenRenderer();
        this.d = fullscreenRenderer;
        initWindowFeatures(fullscreenRenderer);
        super.onCreate(bundle);
        IAlog.a("%sInterstitial for spot id %s created", IAlog.a(this), this.c.getLocalUniqueId());
        this.e = getResources().getConfiguration().orientation;
        this.f = getResources().getConfiguration().screenHeightDp;
        this.g = getResources().getConfiguration().screenWidthDp;
        if (this.d == null) {
            IAlog.e("Interstitial Activity: Could not find an appropriate full screen ad renderer for content!", new Object[0]);
            finish();
            return;
        }
        try {
            setContentView(com.fyber.inneractive.sdk.R.layout.ia_fullscreen_activity);
            this.f838b = (ViewGroup) findViewById(com.fyber.inneractive.sdk.R.id.ia_ad_content);
            this.i = new CloseButtonFlowManager(this);
            com.fyber.inneractive.sdk.interfaces.c cVar = this.d;
            InneractiveAdSpot inneractiveAdSpot2 = this.c;
            z zVar = (z) cVar;
            zVar.a = inneractiveAdSpot2;
            zVar.f928b = inneractiveAdSpot2.getAdContent();
            zVar.c = inneractiveAdSpot2.getSelectedUnitController().getEventsListener();
            zVar.v.a = inneractiveAdSpot2;
            try {
                this.d.a(this, this);
                this.c.getAdContent().e = true;
            } catch (Resources.NotFoundException e) {
                IAlog.e("Interstitial Activity: %s", e.getMessage());
                finish();
            } catch (InneractiveUnitController.AdDisplayError e2) {
                IAlog.e("Interstitial Activity: %s", e2.getMessage());
                finish();
            }
        } catch (Throwable th) {
            t.a(th, this.c.getAdContent().a, this.c.getAdContent().d());
            finish();
        }
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveBaseActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup = this.f838b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f838b = null;
        }
        InneractiveAdSpot inneractiveAdSpot = this.c;
        InneractiveUnitController selectedUnitController = inneractiveAdSpot == null ? null : inneractiveAdSpot.getSelectedUnitController();
        if (selectedUnitController != null && (selectedUnitController instanceof OnInneractiveFullscreenAdDestroyListener)) {
            ((OnInneractiveFullscreenAdDestroyListener) selectedUnitController).onActivityDestroyed(this);
        }
        com.fyber.inneractive.sdk.interfaces.c cVar = this.d;
        if (cVar != null) {
            cVar.m();
            this.d.destroy();
            this.d = null;
        }
        super.onDestroy();
        InneractiveAdSpot inneractiveAdSpot2 = this.c;
        if (inneractiveAdSpot2 != null) {
            inneractiveAdSpot2.destroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (!isFinishing()) {
            com.fyber.inneractive.sdk.interfaces.c cVar = this.d;
            if (cVar != null) {
                cVar.t();
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.interfaces.c cVar2 = this.d;
        if (cVar2 != null) {
            cVar2.m();
            this.d.destroy();
            this.d = null;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.fyber.inneractive.sdk.interfaces.c cVar = this.d;
        if (cVar != null) {
            cVar.o();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            com.fyber.inneractive.sdk.interfaces.c cVar = this.d;
            if (cVar != null) {
                cVar.t();
                return;
            }
            return;
        }
        hideNavigationBar();
        com.fyber.inneractive.sdk.interfaces.c cVar2 = this.d;
        if (cVar2 != null) {
            cVar2.o();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public void secondEndCardWasDisplayed() {
        this.i.f = true;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public void setActivityOrientation(boolean z, Orientation orientation) {
        if (z && orientation.equals(Orientation.USER)) {
            setRequestedOrientation(13);
            return;
        }
        if (z && orientation.equals(Orientation.NONE)) {
            setRequestedOrientation(getRequestedOrientation());
            return;
        }
        if (orientation.equals(Orientation.LANDSCAPE)) {
            setRequestedOrientation(6);
            return;
        }
        if (orientation.equals(Orientation.PORTRAIT)) {
            setRequestedOrientation(7);
            return;
        }
        int i = getResources().getConfiguration().orientation;
        if (i == 1) {
            setRequestedOrientation(7);
        } else if (i == 2) {
            setRequestedOrientation(6);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public void showCloseButton(boolean z, int i, int i2) {
        int i3;
        int i4;
        CloseButtonFlowManager closeButtonFlowManager = this.i;
        if (!z || closeButtonFlowManager.f) {
            closeButtonFlowManager.a.setAlpha(1.0f);
            closeButtonFlowManager.d.setAlpha(1.0f);
        } else {
            closeButtonFlowManager.a.setAlpha(0.0f);
            closeButtonFlowManager.d.setAlpha(0.0f);
        }
        closeButtonFlowManager.f1324b.setText("");
        closeButtonFlowManager.f1324b.setVisibility(8);
        if (i >= 5) {
            int iA = l.a(i);
            closeButtonFlowManager.d.getLayoutParams().width = iA;
            closeButtonFlowManager.d.getLayoutParams().height = iA;
        }
        if (i2 >= 5) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) closeButtonFlowManager.d.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) closeButtonFlowManager.a.getLayoutParams();
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) closeButtonFlowManager.c.getLayoutParams();
            int iA2 = l.a(i2);
            int i5 = layoutParams.width;
            int i6 = iA2 - i5;
            if (iA2 <= i5 || i6 <= (i4 = layoutParams2.rightMargin)) {
                layoutParams3.width = iA2;
                layoutParams3.height = iA2;
                i3 = layoutParams2.rightMargin;
                if (i6 < i3) {
                    i3 -= i6 / 2;
                }
            } else {
                int i7 = (iA2 / 2) + (i5 / 2) + i4;
                layoutParams3.width = i7;
                layoutParams3.height = i7;
                layoutParams2.gravity = 53;
                i3 = 0;
            }
            layoutParams3.setMargins(i3, i3, i3, i3);
            layoutParams3.gravity = 17;
        }
        closeButtonFlowManager.a.setVisibility(0);
        closeButtonFlowManager.d.setVisibility(0);
        closeButtonFlowManager.c.setVisibility(0);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public void showCloseCountdown() {
        CloseButtonFlowManager closeButtonFlowManager = this.i;
        closeButtonFlowManager.f1324b.setBackgroundResource(com.fyber.inneractive.sdk.R.drawable.ia_round_overlay_bg);
        closeButtonFlowManager.a.setVisibility(0);
        closeButtonFlowManager.f1324b.setVisibility(0);
        closeButtonFlowManager.d.setVisibility(8);
        closeButtonFlowManager.c.setVisibility(8);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public void updateCloseCountdown(int i) {
        CloseButtonFlowManager closeButtonFlowManager = this.i;
        closeButtonFlowManager.getClass();
        if (i > 0) {
            closeButtonFlowManager.f1324b.setText(Integer.toString(i));
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c.a
    public boolean wasDismissedByUser() {
        return this.h;
    }
}
