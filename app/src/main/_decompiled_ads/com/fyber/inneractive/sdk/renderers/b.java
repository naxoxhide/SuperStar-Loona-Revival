package com.fyber.inneractive.sdk.renderers;

import android.graphics.Rect;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.flow.b0;
import com.fyber.inneractive.sdk.network.j0;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.response.e f1317b;
    public final RelativeLayout c;
    public final c j;
    public float d = 0.0f;
    public int e = 1;
    public float f = 0.0f;
    public long g = 0;
    public boolean h = false;
    public boolean i = false;
    public final Runnable k = new a();
    public com.fyber.inneractive.sdk.util.i<Rect> a = new com.fyber.inneractive.sdk.util.i<>(4, new C0304b(this));

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a();
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.renderers.b$b, reason: collision with other inner class name */
    public class C0304b implements com.fyber.inneractive.sdk.util.i.a<Rect> {
        public C0304b(b bVar) {
        }

        @Override // com.fyber.inneractive.sdk.util.i.a
        public Rect a() {
            return new Rect();
        }
    }

    public interface c {
    }

    public b(com.fyber.inneractive.sdk.response.e eVar, RelativeLayout relativeLayout, c cVar) {
        this.f1317b = eVar;
        this.c = relativeLayout;
        this.j = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006e  */
    public void a() {
        boolean z;
        String str;
        IAlog.a("IAVisibilityTracker: onCheckVisibility", new Object[0]);
        float f = this.e / 100.0f;
        Rect rectA = this.a.a();
        RelativeLayout relativeLayout = this.c;
        float fHeight = (relativeLayout.getParent() != null && relativeLayout.isShown() && relativeLayout.hasWindowFocus() && relativeLayout.getGlobalVisibleRect(rectA)) ? (rectA.height() * rectA.width()) / (relativeLayout.getHeight() * relativeLayout.getWidth()) : 0.0f;
        this.a.a.offer(rectA);
        this.d = fHeight;
        if (fHeight >= f) {
            float f2 = this.f * 1000.0f;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.g;
            if (f2 >= jCurrentTimeMillis - j || j == 0) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        IAlog.a("BannerVisibilityTracker | visible = %s, minVis = %f", Boolean.valueOf(z), Float.valueOf(f));
        if (!z || !this.h) {
            if (this.h) {
                float f3 = this.d;
                if (f3 < f) {
                    this.g = 0L;
                } else if (f3 >= f && this.g == 0) {
                    this.g = System.currentTimeMillis();
                }
                Handler handler = com.fyber.inneractive.sdk.util.m.f1343b;
                handler.removeCallbacks(this.k);
                handler.postDelayed(this.k, 50L);
                return;
            }
            return;
        }
        if (this.j == null || this.i) {
            return;
        }
        this.i = true;
        IAlog.a("BannerVisibilityTracker | firing viewable", new Object[0]);
        g gVar = ((d) this.j).a;
        gVar.getClass();
        try {
            AdContent adcontent = gVar.f928b;
            if (adcontent == 0 || ((b0) adcontent).f927b == 0 || (str = ((com.fyber.inneractive.sdk.response.f) ((b0) adcontent).f927b).v) == null || str.trim().length() <= 0) {
                return;
            }
            IAlog.d("%sfiring banner mrc visibility impression!", IAlog.a(gVar));
            int i = IAlog.a;
            IAlog.a(1, null, "MRC_VISIBILITY_IMPRESSION", new Object[0]);
            j0.b(str);
        } catch (Exception unused) {
        }
    }

    public void b() {
        if (this.i || this.h || this.g == 0) {
            return;
        }
        this.g = 0L;
        this.h = true;
        a();
    }

    public void c() {
        this.h = false;
        com.fyber.inneractive.sdk.util.m.f1343b.removeCallbacks(this.k);
    }
}
