package com.bytedance.sdk.openadsdk.core.i0;

import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: ViewabilitySessionManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    final Set<Pair<View, FriendlyObstructionPurpose>> a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.i0.g f604b;

    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class a implements Runnable {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.a);
        }
    }

    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class b implements Runnable {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.a);
        }
    }

    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class c implements Runnable {
        final /* synthetic */ WebView a;

        c(WebView webView) {
            this.a = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.a);
        }
    }

    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class d implements Runnable {
        final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f608b;

        d(View view, Set set) {
            this.a = view;
            this.f608b = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.a, (Set<com.bytedance.sdk.openadsdk.core.i0.j>) this.f608b);
        }
    }

    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.i0.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class RunnableC0200f implements Runnable {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f609b;

        RunnableC0200f(boolean z, float f) {
            this.a = z;
            this.f609b = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.a, this.f609b);
        }
    }

    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.h();
        }
    }

    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.c();
        }
    }

    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class i implements Runnable {
        final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FriendlyObstructionPurpose f610b;

        i(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
            this.a = view;
            this.f610b = friendlyObstructionPurpose;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.a, this.f610b);
        }
    }

    /* JADX INFO: compiled from: ViewabilitySessionManager.java */
    class j implements Runnable {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f611b;

        j(long j, boolean z) {
            this.a = j;
            this.f611b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.a, this.f611b);
        }
    }

    private f() {
        com.bytedance.sdk.openadsdk.core.i0.e.b(o.a());
    }

    private Handler d() {
        return com.bytedance.sdk.component.utils.i.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f604b != null) {
            try {
                a((View) null, (FriendlyObstructionPurpose) null);
                this.f604b.b();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.bytedance.sdk.openadsdk.core.i0.g gVar = this.f604b;
        if (gVar != null) {
            try {
                gVar.d();
            } catch (Throwable unused) {
            }
        }
    }

    public void e() {
        if (b.a.a.a.a.a.b.d.a.b()) {
            f();
        } else {
            d().post(new e());
        }
    }

    public void g() {
        if (b.a.a.a.a.a.b.d.a.b()) {
            h();
        } else {
            d().post(new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(WebView webView) {
        try {
            if (this.f604b == null) {
                this.f604b = com.bytedance.sdk.openadsdk.core.i0.h.a(webView);
            }
        } catch (Throwable th) {
            m.b("createWebViewSession failed : " + th);
            HashMap map = new HashMap();
            map.put("scene", "createWebViewSession");
            map.put("message", th.getMessage());
            com.bytedance.sdk.openadsdk.core.i0.e.a(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.core.i0.g gVar = this.f604b;
        if (gVar != null) {
            try {
                gVar.c();
            } catch (Throwable unused) {
            }
        }
    }

    public static f a() {
        return new f();
    }

    public void a(WebView webView) {
        if (webView == null || this.f604b != null) {
            return;
        }
        if (b.a.a.a.a.a.b.d.a.b()) {
            b(webView);
        } else {
            d().post(new c(webView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, Set<com.bytedance.sdk.openadsdk.core.i0.j> set) {
        try {
            if (this.f604b == null) {
                this.f604b = com.bytedance.sdk.openadsdk.core.i0.h.a(view, set);
            }
        } catch (Throwable th) {
            m.b("createVideoSession failed : " + th);
            HashMap map = new HashMap();
            map.put("scene", "createVideoSession");
            map.put("message", th.getMessage());
            com.bytedance.sdk.openadsdk.core.i0.e.a(map);
        }
    }

    public void a(View view, Set<com.bytedance.sdk.openadsdk.core.i0.j> set) {
        if (this.f604b != null) {
            return;
        }
        if (view != null && set != null) {
            if (b.a.a.a.a.a.b.d.a.b()) {
                b(view, set);
                return;
            } else {
                d().post(new d(view, set));
                return;
            }
        }
        m.e("video view or view ability Vendors is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, float f) {
        if (this.f604b != null) {
            try {
                a((View) null, (FriendlyObstructionPurpose) null);
                this.f604b.a(z, f);
            } catch (Throwable unused) {
            }
        }
    }

    public void b() {
        if (b.a.a.a.a.a.b.d.a.b()) {
            c();
        } else {
            d().post(new h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        com.bytedance.sdk.openadsdk.core.i0.g gVar = this.f604b;
        try {
            if (gVar == null) {
                if (view == null || friendlyObstructionPurpose == null) {
                    return;
                }
                this.a.add(new Pair<>(view, friendlyObstructionPurpose));
                return;
            }
            if (view != null && friendlyObstructionPurpose != null) {
                gVar.a(view, friendlyObstructionPurpose);
            }
            if (this.a.size() > 0) {
                gVar.a(this.a);
                this.a.clear();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z, float f) {
        if (b.a.a.a.a.a.b.d.a.b()) {
            b(z, f);
        } else {
            d().post(new RunnableC0200f(z, f));
        }
    }

    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (b.a.a.a.a.a.b.d.a.b()) {
            b(view, friendlyObstructionPurpose);
        } else {
            d().post(new i(view, friendlyObstructionPurpose));
        }
    }

    public void a(long j2, boolean z) {
        if (b.a.a.a.a.a.b.d.a.b()) {
            b(j2, z);
        } else {
            d().post(new j(j2, z));
        }
    }

    public void a(boolean z) {
        if (b.a.a.a.a.a.b.d.a.b()) {
            b(z);
        } else {
            d().post(new a(z));
        }
    }

    public void b(long j2, boolean z) {
        com.bytedance.sdk.openadsdk.core.i0.g gVar = this.f604b;
        if (gVar != null) {
            try {
                gVar.a(j2 / 1000.0f, z);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.bytedance.sdk.openadsdk.core.i0.g gVar = this.f604b;
        if (gVar != null) {
            try {
                gVar.a(z);
            } catch (Throwable unused) {
            }
        }
    }

    public void a(int i2) {
        if (b.a.a.a.a.a.b.d.a.b()) {
            b(i2);
        } else {
            d().post(new b(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        com.bytedance.sdk.openadsdk.core.i0.g gVar = this.f604b;
        if (gVar != null) {
            try {
                gVar.b(i2);
            } catch (Throwable unused) {
            }
        }
    }
}
