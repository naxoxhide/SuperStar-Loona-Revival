package com.bytedance.sdk.openadsdk.n;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import b.b.a.a.f.a.d;
import b.b.a.a.h.u;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TTNetClient.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static volatile c d;
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b.b.a.a.j.a f808b;
    private com.bytedance.sdk.openadsdk.n.d.c c;

    /* JADX INFO: compiled from: TTNetClient.java */
    class a implements View.OnClickListener {
        final /* synthetic */ ImageView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f809b;

        a(c cVar, ImageView imageView, q qVar) {
            this.a = imageView;
            this.f809b = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a.getDrawable() != null) {
                Intent intent = new Intent();
                String strF = this.f809b.F();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(strF));
                try {
                    com.bytedance.sdk.component.utils.b.a(o.a(), intent, null);
                } catch (Exception unused) {
                }
            }
        }
    }

    private c(Context context) {
        this.a = context == null ? o.a() : context.getApplicationContext();
        b.b.a.a.j.a.b bVar = new b.b.a.a.j.a.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        b.b.a.a.j.a aVarA = bVar.a(10000L, timeUnit).b(10000L, timeUnit).c(10000L, timeUnit).a(true).a();
        this.f808b = aVarA;
        d dVarA = aVarA.c().a();
        if (dVarA != null) {
            dVarA.a(32);
        }
    }

    public static c b() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c(o.a());
                }
            }
        }
        return d;
    }

    public void a(String str, int i, int i2, ImageView imageView, q qVar) {
        com.bytedance.sdk.openadsdk.h.d.a(str).b(i).a(i2).d(b0.g(o.a())).c(b0.i(o.a())).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.h.c.a(qVar, str, imageView));
    }

    public com.bytedance.sdk.openadsdk.n.d.c c() {
        a();
        return this.c;
    }

    public b.b.a.a.j.a d() {
        return this.f808b;
    }

    public void a(int i, ImageView imageView, q qVar) {
        com.bytedance.sdk.openadsdk.h.d.a(qVar.E()).b(i).a(i).d(b0.g(o.a())).c(b0.i(o.a())).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.h.c.a(qVar, qVar.E(), imageView));
        if (imageView != null) {
            imageView.setOnClickListener(new a(this, imageView, qVar));
        }
    }

    public void a(n nVar, ImageView imageView, q qVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.d()) || imageView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.d.a(nVar).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.h.c.a(qVar, nVar.d(), imageView));
    }

    private void a() {
        if (this.c == null) {
            this.c = new com.bytedance.sdk.openadsdk.n.d.c();
        }
    }
}
