package com.bytedance.sdk.openadsdk.d.p;

import android.content.Context;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: OverSeaLogDepend.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements b.b.a.a.i.a.f {
    private String a = "[5411]";

    @Override // b.b.a.a.i.a.f
    public b.b.a.a.i.a.m.a a(JSONObject jSONObject) {
        return null;
    }

    @Override // b.b.a.a.i.a.f
    public boolean a(Context context) {
        return p.a(context);
    }

    @Override // b.b.a.a.i.a.f
    public String b(String str) {
        return b.b.a.a.g.a.b(str, com.bytedance.sdk.openadsdk.core.a.b());
    }

    @Override // b.b.a.a.i.a.f
    public boolean c() {
        return false;
    }

    @Override // b.b.a.a.i.a.f
    public int d() {
        return 1;
    }

    @Override // b.b.a.a.i.a.f
    public boolean e() {
        return false;
    }

    @Override // b.b.a.a.i.a.f
    public boolean f() {
        return true;
    }

    @Override // b.b.a.a.i.a.f
    public boolean g() {
        return true;
    }

    @Override // b.b.a.a.i.a.f
    public b.b.a.a.i.a.h h() {
        return null;
    }

    @Override // b.b.a.a.i.a.f
    public b.b.a.a.i.a.n.c i() {
        return new g();
    }

    @Override // b.b.a.a.i.a.f
    public void j() {
        a.a(a.f);
    }

    @Override // b.b.a.a.i.a.f
    public String k() {
        return a0.t();
    }

    @Override // b.b.a.a.i.a.f
    public boolean l() {
        return false;
    }

    @Override // b.b.a.a.i.a.f
    public b.b.a.a.i.a.g m() {
        b.b.a.a.i.a.g gVarA;
        synchronized (this) {
            gVarA = com.bytedance.sdk.openadsdk.m.f.a.a(o.a());
        }
        return gVarA;
    }

    @Override // b.b.a.a.i.a.f
    public boolean n() {
        return BinderPoolService.f796b;
    }

    @Override // b.b.a.a.i.a.f
    public String o() {
        return this.a;
    }

    @Override // b.b.a.a.i.a.f
    public String a(String str) {
        return b.b.a.a.g.a.a(str, com.bytedance.sdk.openadsdk.core.a.b());
    }

    @Override // b.b.a.a.i.a.f
    public Executor b() {
        return y.b();
    }

    @Override // b.b.a.a.i.a.f
    public Executor a() {
        return y.d();
    }

    @Override // b.b.a.a.i.a.f
    public void a(boolean z, int i, long j) {
        a.a(a.c, z, i, j);
    }

    @Override // b.b.a.a.i.a.f
    public void a(boolean z) {
        a.a(a.f, z);
    }
}
