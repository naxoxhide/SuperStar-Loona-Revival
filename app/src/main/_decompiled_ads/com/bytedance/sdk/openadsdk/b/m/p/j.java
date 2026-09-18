package com.bytedance.sdk.openadsdk.b.m.p;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: RewardFullTopProxyManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private final Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f504b;
    TopProxyLayout c;
    b.b.a.a.d.d.d d;
    private boolean e = false;

    public j(a aVar) {
        this.a = aVar.V;
        this.f504b = aVar;
    }

    public void a(boolean z) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setShowDislike(z);
        }
    }

    public void b(boolean z) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSkip(z);
        }
    }

    public void c() {
        if (this.e) {
            return;
        }
        this.e = true;
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.i1);
        this.c = topProxyLayout;
        if (topProxyLayout != null) {
            a aVar = this.f504b;
            topProxyLayout.a(aVar.f, aVar.a);
            if (this.f504b.a.k1()) {
                a(false);
            } else {
                a(this.f504b.a.g1());
            }
        }
    }

    public void d(boolean z) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setSkipEnable(z);
        }
    }

    public void e(boolean z) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setSoundMute(z);
        }
        b.b.a.a.d.d.d dVar = this.d;
        if (dVar != null) {
            dVar.setSoundMute(z);
        }
    }

    public void f() {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.a();
        }
    }

    public void a(String str, CharSequence charSequence) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.a(String.valueOf(str), charSequence);
        }
    }

    public void b() {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.e();
        }
    }

    public void d() {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.c();
        }
    }

    public void a(CharSequence charSequence) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setSkipText(charSequence);
        }
    }

    public void b(int i) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout == null || !(topProxyLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ((ViewGroup.MarginLayoutParams) this.c.getLayoutParams()).topMargin = i - b0.a(this.a, 20.0f);
    }

    public void e() {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.d();
        }
    }

    public void a() {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.b();
        }
    }

    public void a(com.bytedance.sdk.openadsdk.component.reward.top.b bVar) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setListener(bVar);
        }
    }

    public void a(b.b.a.a.d.d.d dVar) {
        this.d = dVar;
    }

    public void a(int i) {
        View viewFindViewById;
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout == null || topProxyLayout.getITopLayout() == null || i == 0 || (viewFindViewById = this.c.getITopLayout().findViewById(520093713)) == null || !(viewFindViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || viewFindViewById.getWidth() <= 0 || viewFindViewById.getVisibility() != 0) {
            return;
        }
        int[] iArr = new int[2];
        viewFindViewById.getLocationOnScreen(iArr);
        int width = i - (iArr[0] + viewFindViewById.getWidth());
        if (width < b0.a(this.a, 16.0f)) {
            ((ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams()).rightMargin += b0.a(this.a, 16.0f) - width;
            viewFindViewById.requestLayout();
        }
    }

    public void c(boolean z) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSound(z);
        }
    }
}
