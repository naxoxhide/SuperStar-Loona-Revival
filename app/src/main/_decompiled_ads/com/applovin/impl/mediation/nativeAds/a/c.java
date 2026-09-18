package com.applovin.impl.mediation.nativeAds.a;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final WeakHashMap<View, Integer> auQ = new WeakHashMap<>();
    private final Object auR = new Object();
    private final Handler auS = new Handler();
    private boolean auT = false;
    private final WeakReference<View> auU;
    private final ViewTreeObserver.OnPreDrawListener auV;
    private a auW;

    public interface a {
        void S(int i, int i2);
    }

    public c(View view) {
        this.auU = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.impl.mediation.nativeAds.a.-$$Lambda$c$tLOYhF_bCzlQB2obC8m-l8ZT6fk
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    return this.f$0.yQ();
                }
            };
            this.auV = onPreDrawListener;
            viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
            return;
        }
        this.auV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean yQ() {
        yO();
        return true;
    }

    public void destroy() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener;
        this.auW = null;
        View view = this.auU.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive() && (onPreDrawListener = this.auV) != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            }
            this.auU.clear();
        }
    }

    public void a(a aVar) {
        this.auW = aVar;
    }

    public void a(View view, int i) {
        synchronized (this.auR) {
            this.auQ.put(view, Integer.valueOf(i));
            yO();
        }
    }

    public void k(View view) {
        synchronized (this.auR) {
            this.auQ.remove(view);
        }
    }

    private void yO() {
        if (this.auT) {
            return;
        }
        this.auT = true;
        this.auS.postDelayed(new Runnable() { // from class: com.applovin.impl.mediation.nativeAds.a.-$$Lambda$c$a9apLfpfdfhZD-KKutrHkB6NOx0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.yP();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yP() {
        synchronized (this.auR) {
            this.auT = false;
            int iMin = -1;
            int iMax = -1;
            for (Map.Entry<View, Integer> entry : this.auQ.entrySet()) {
                if (t(entry.getKey())) {
                    Integer value = entry.getValue();
                    if (iMin == -1 && iMax == -1) {
                        iMin = value.intValue();
                        iMax = value.intValue();
                    } else {
                        iMin = Math.min(iMin, entry.getValue().intValue());
                        iMax = Math.max(iMax, entry.getValue().intValue());
                    }
                }
            }
            a aVar = this.auW;
            if (aVar != null) {
                aVar.S(iMin, iMax);
            }
        }
    }

    private boolean t(View view) {
        return (view == null || view.getVisibility() != 0 || view.getParent() == null) ? false : true;
    }
}
