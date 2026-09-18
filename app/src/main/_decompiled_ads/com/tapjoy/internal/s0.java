package com.tapjoy.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes4.dex */
public final class s0 implements View.OnClickListener {
    public final /* synthetic */ u2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RelativeLayout f2810b;
    public final /* synthetic */ u2 c;
    public final /* synthetic */ f0 d;
    public final /* synthetic */ t0 e;

    public s0(t0 t0Var, u2 u2Var, RelativeLayout relativeLayout, u2 u2Var2, f0 f0Var) {
        this.e = t0Var;
        this.a = u2Var;
        this.f2810b = relativeLayout;
        this.c = u2Var2;
        this.d = f0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        u2 u2Var = this.a;
        if (u2Var != null) {
            u2Var.b();
            this.f2810b.removeView(this.a);
        }
        u2 u2Var2 = this.c;
        if (u2Var2 != null) {
            u2Var2.b();
            this.f2810b.removeView(this.c);
        }
        v0 v0Var = this.e.f2814b;
        f0 f0Var = this.d;
        v0Var.getClass();
        if (!TextUtils.isEmpty(f0Var.h)) {
            v0Var.c.f2755b.a(v0Var.a, f0Var.h, r9.a(f0Var.i));
            v0Var.c.a = true;
        } else if (!TextUtils.isEmpty(f0Var.g)) {
            Activity activity = v0Var.a;
            String str = f0Var.g;
            if (!TextUtils.isEmpty(str)) {
                try {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception unused) {
                }
            }
        }
        v0Var.f2823b.a(v0Var.c.e, null);
        if (f0Var.j) {
            v0Var.c.c();
        }
    }
}
