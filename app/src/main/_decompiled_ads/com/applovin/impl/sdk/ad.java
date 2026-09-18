package com.applovin.impl.sdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class ad {
    private final Runnable aFJ;
    private final WeakReference<View> aFK;
    private final long aFL;
    private int aFO;
    private float aFP;
    private float aFQ;
    private long aFR;
    private final ViewTreeObserver.OnPreDrawListener auV;
    private final x logger;
    private final Object rT = new Object();
    private final Rect aFI = new Rect();
    private WeakReference<ViewTreeObserver> aFM = new WeakReference<>(null);
    private WeakReference<View> aFN = new WeakReference<>(null);
    private long startTimeMillis = Long.MIN_VALUE;
    private final Handler auS = new Handler(Looper.getMainLooper());

    public interface a {
        void onLogVisibilityImpression();
    }

    public ad(final View view, n nVar, a aVar) {
        this.logger = nVar.BL();
        this.aFL = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aMy)).longValue();
        this.aFK = new WeakReference<>(view);
        final WeakReference weakReference = new WeakReference(aVar);
        this.aFJ = new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$ad$aTArqI2umHfb7YKipWvZ6CIgBp8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(weakReference);
            }
        };
        this.auV = new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.impl.sdk.-$$Lambda$ad$ThXHlVoQqpZNIYqoGGs3pG5m9Oc
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f$0.h(view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(WeakReference weakReference) {
        View view = this.aFK.get();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        View view2 = this.aFN.get();
        if (viewGroup == null || view2 == null) {
            return;
        }
        if (b(viewGroup, view2)) {
            if (x.Fk()) {
                this.logger.f("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
            }
            Fu();
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.onLogVisibilityImpression();
                return;
            }
            return;
        }
        yO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h(View view) {
        yO();
        w(view);
        return true;
    }

    public void b(com.applovin.impl.mediation.b.e eVar) {
        View viewYk;
        if (eVar instanceof com.applovin.impl.mediation.b.b) {
            viewYk = eVar.getAdView();
        } else if (!(eVar instanceof com.applovin.impl.mediation.b.d)) {
            return;
        } else {
            viewYk = ((com.applovin.impl.mediation.b.d) eVar).yk();
        }
        a(eVar.ys(), eVar.yt(), eVar.yu(), eVar.yw(), viewYk);
    }

    public void a(int i, float f, float f2, long j, View view) {
        synchronized (this.rT) {
            if (x.Fk()) {
                this.logger.f("VisibilityTracker", "Tracking visibility for " + view);
            }
            Fu();
            WeakReference<View> weakReference = new WeakReference<>(view);
            this.aFN = weakReference;
            this.aFO = i;
            this.aFP = f;
            this.aFQ = f2;
            this.aFR = j;
            v(weakReference.get());
        }
    }

    public void Fu() {
        synchronized (this.rT) {
            this.auS.removeMessages(0);
            w(this.aFK.get());
            this.startTimeMillis = Long.MIN_VALUE;
            this.aFN.clear();
        }
    }

    private void v(View view) {
        View viewA = com.applovin.impl.sdk.utils.u.A(this.aFK.get());
        if (viewA == null) {
            viewA = com.applovin.impl.sdk.utils.u.A(view);
        }
        if (viewA == null) {
            if (x.Fk()) {
                this.logger.f("VisibilityTracker", "Unable to set view tree observer due to no root view.");
                return;
            }
            return;
        }
        ViewTreeObserver viewTreeObserver = viewA.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            if (x.Fk()) {
                this.logger.h("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
            }
        } else {
            this.aFM = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnPreDrawListener(this.auV);
        }
    }

    private void yO() {
        this.auS.postDelayed(this.aFJ, this.aFL);
    }

    private boolean a(View view, View view2) {
        if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWidth() <= 0 || view2.getHeight() <= 0 || !view2.getGlobalVisibleRect(this.aFI)) {
            return false;
        }
        long jPxToDp = AppLovinSdkUtils.pxToDp(view2.getContext(), this.aFI.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.aFI.height());
        if (jPxToDp < this.aFO) {
            return false;
        }
        if ((jPxToDp / (AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getWidth()) * AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getHeight()))) * 100.0f < this.aFP) {
            return false;
        }
        return (((float) ((long) (this.aFI.width() * this.aFI.height()))) / ((float) ((long) (view2.getWidth() * view2.getHeight())))) * 100.0f >= this.aFQ;
    }

    private boolean b(View view, View view2) {
        if (!a(view, view2)) {
            return false;
        }
        if (this.startTimeMillis == Long.MIN_VALUE) {
            this.startTimeMillis = SystemClock.uptimeMillis();
        }
        return SystemClock.uptimeMillis() - this.startTimeMillis >= this.aFR;
    }

    private void w(View view) {
        ViewTreeObserver viewTreeObserver = this.aFM.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.auV);
        } else if (view != null) {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnPreDrawListener(this.auV);
            } else if (x.Fk()) {
                this.logger.f("VisibilityTracker", "Could not remove on pre-draw listener. View tree observer is not alive.");
            }
        } else if (x.Fk()) {
            this.logger.f("VisibilityTracker", "Could not remove on pre-draw listener. Root view is null.");
        }
        this.aFM.clear();
    }
}
