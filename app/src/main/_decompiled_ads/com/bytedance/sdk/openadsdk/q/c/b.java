package com.bytedance.sdk.openadsdk.q.c;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.sdk.openadsdk.core.f0.q;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PAGBaseMrcTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    private final AtomicLong a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f818b;
    protected WeakReference<View> c;
    protected q d;
    protected final AtomicBoolean e;
    private final int f;
    private final Integer g;
    private volatile boolean h = false;
    private final int i;

    public b(Integer num, View view, q qVar, int i, int i2) {
        this.g = num;
        this.f = i;
        this.d = qVar;
        this.i = i2;
        a(view);
        this.e = new AtomicBoolean(false);
        this.a = new AtomicLong(-1L);
        this.f818b = new AtomicBoolean(false);
    }

    public static b a(boolean z, Integer num, View view, q qVar, int i) {
        return z ? new h(num, view, qVar, i) : new c(num, view, qVar, i);
    }

    protected abstract void a(int i);

    protected abstract boolean a();

    public void b() {
        if (h()) {
            return;
        }
        if (!this.e.get()) {
            j();
        } else if (!this.a.compareAndSet(-1L, System.currentTimeMillis()) && System.currentTimeMillis() - this.a.get() >= this.f) {
            c();
        }
    }

    protected void c() {
        if (this.f818b.compareAndSet(false, true)) {
            d.a(this.d, e(), this.i);
        }
    }

    public boolean d() {
        return this.e.get();
    }

    protected a e() {
        WeakReference<View> weakReference = this.c;
        if (weakReference == null) {
            return new a(-1, -1, -1.0f);
        }
        View view = weakReference.get();
        return view == null ? new a(0, 0, 0.0f) : new a(view.getWidth(), view.getHeight(), view.getAlpha());
    }

    public abstract int f();

    public Integer g() {
        return this.g;
    }

    public boolean h() {
        return this.f818b.get();
    }

    public void i() {
        this.e.set(false);
        j();
    }

    public void j() {
        this.a.set(-1L);
    }

    public void k() {
        if (this.e.compareAndSet(false, true)) {
            g.a(this);
        }
    }

    public int l() {
        if (h()) {
            return 1;
        }
        WeakReference<View> weakReference = this.c;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || this.h) {
            return 3;
        }
        if (g().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI))) {
            return g().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI)) && a() ? 1 : 2;
        }
        m();
        e.b(g());
        return 3;
    }

    public void m() {
        this.h = true;
        g.b(this);
    }

    public void a(View view) {
        if (view != null) {
            view.setTag(InputDeviceCompat.SOURCE_HDMI, g());
        }
        this.c = new WeakReference<>(view);
    }

    public void b(int i) {
        if (i == 4) {
            k();
            return;
        }
        if (i == 8) {
            i();
        } else if (i == 9) {
            c();
        } else {
            a(i);
        }
    }
}
