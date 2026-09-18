package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.b.m.p.f;
import com.bytedance.sdk.openadsdk.b.m.p.h;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.j0.c.c;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.k.e;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTBaseVideoActivity extends TTBaseActivity implements y.a, com.bytedance.sdk.openadsdk.core.j0.c.b, c {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.b.m.p.a f400b;
    protected com.bytedance.sdk.openadsdk.b.m.q.b c;
    final y d;
    protected IListenerManager e;
    int f;
    boolean g;
    private boolean h;
    private int i;
    int j;
    private final AtomicBoolean k;
    protected e l;

    class a implements e {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.k.e
        public void a() {
            TTBaseVideoActivity.this.u();
        }
    }

    class b implements Runnable {
        b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = tTBaseVideoActivity.f400b;
            f fVar = aVar.M;
            float[] fArrA = aVar.K.a(tTBaseVideoActivity.j);
            TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
            fVar.a(fArrA, tTBaseVideoActivity2, tTBaseVideoActivity2.c);
        }
    }

    public TTBaseVideoActivity() {
        this.a = m() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.d = new y(Looper.getMainLooper(), this);
        this.h = false;
        this.i = 0;
        this.j = 1;
        this.k = new AtomicBoolean(false);
        this.l = new a();
    }

    private void a(q qVar, Bundle bundle) {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = new com.bytedance.sdk.openadsdk.b.m.p.a(this, this.d, qVar);
        this.f400b = aVar;
        com.bytedance.sdk.openadsdk.b.m.p.b.a(aVar, getIntent(), bundle);
        Intent intent = getIntent();
        if (intent != null) {
            a(intent);
            qVar.c(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.f400b.p) {
            p();
        }
        com.bytedance.sdk.openadsdk.b.m.q.b bVarA = com.bytedance.sdk.openadsdk.b.m.q.f.a(this.f400b);
        this.c = bVarA;
        this.f400b.Y = bVarA;
        m.a("TTAD.BVA", "init: mAdType = " + this.c);
    }

    private void j() {
        this.c.a(this.l);
        this.f = (int) this.f400b.G.o();
        i();
        s();
        if (this.f400b.a.M0() == null || this.f400b.a.M0().m() == null) {
            return;
        }
        this.f400b.a.M0().m().d(0L);
    }

    private void k() {
        setContentView(this.f400b.U);
        this.f400b.U.a(this.c);
        this.c.a(this, this.d);
        this.c.p();
    }

    private boolean q() {
        if (this.f400b.u.get() && this.f400b.s) {
            return false;
        }
        if ((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) {
            return this.f400b.u.get();
        }
        return true;
    }

    protected void a(Intent intent) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.b
    public void a(Bundle bundle) {
    }

    public void b(boolean z) {
        a(z, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.c
    public View c() {
        return this.f400b.G.g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.c
    public void e() {
        this.f400b.G.y();
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.c
    public void f() {
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.f400b != null && r.w()) {
            b0.d((Activity) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.c
    public void g() {
        com.bytedance.sdk.openadsdk.b.m.q.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        bVar.B();
    }

    protected void h() {
        if (l() && !this.h) {
            this.h = true;
            getWindow().getDecorView().post(new b());
        }
    }

    protected abstract void i();

    public boolean l() {
        return false;
    }

    public abstract boolean m();

    protected abstract void n();

    protected void o() {
        this.d.removeMessages(400);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        if (aVar == null) {
            return;
        }
        aVar.K.c();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.bytedance.sdk.openadsdk.b.m.q.b bVar;
        if (this.f400b == null || (bVar = this.c) == null) {
            super.onBackPressed();
        } else {
            bVar.s();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a(getApplicationContext());
        if (!l.e()) {
            finish();
            return;
        }
        q qVarA = com.bytedance.sdk.openadsdk.b.m.p.b.a(getIntent(), bundle, this);
        if (qVarA == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.utils.b.a(qVarA);
        this.j = qVarA.j0();
        a(qVarA, bundle);
        try {
            k();
            j();
        } catch (Throwable th) {
            m.b("TTAD.BVA", "onCreate: ", th);
            com.bytedance.sdk.openadsdk.d.c.b();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        if (aVar == null || this.c == null) {
            return;
        }
        if (aVar.r > 0 && aVar.x.get()) {
            String str = (SystemClock.elapsedRealtime() - this.f400b.r) + "";
            com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.f400b;
            com.bytedance.sdk.openadsdk.d.c.a(str, aVar2.a, this.a, aVar2.G.b());
            this.f400b.r = 0L;
        }
        this.f400b.N.a();
        this.d.removeCallbacksAndMessages(null);
        this.c.t();
        com.bytedance.sdk.openadsdk.q.c.e.c(this.f400b.a);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.b.m.q.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        bVar.u();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        com.bytedance.sdk.openadsdk.b.m.q.b bVar;
        m.a("TTAD.BVA", "onResume: ");
        super.onResume();
        if (this.f400b == null || (bVar = this.c) == null) {
            return;
        }
        bVar.w();
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        aVar.e = true;
        aVar.K.a(this.d);
        if (q()) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.f400b;
            aVar2.R.a(aVar2.a.g1());
        }
        this.f400b.T.l();
        this.f400b.Q.C();
        this.f400b.I.m();
        if (this.c.a()) {
            this.f400b.G.a(this.c);
            this.f400b.G.a(false, this, this.i != 0);
        }
        this.i++;
        h();
        com.bytedance.sdk.openadsdk.component.reward.view.c cVar = this.f400b.J;
        if (cVar != null) {
            cVar.k();
        }
        this.f400b.K.b(this.d);
        this.c.v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.b
    public abstract /* synthetic */ void onRewardBarClick(View view);

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        if (aVar == null) {
            super.onSaveInstanceState(bundle);
        } else {
            com.bytedance.sdk.openadsdk.b.m.p.b.a(aVar, bundle);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        if (aVar == null) {
            return;
        }
        aVar.Q.z();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.b.m.q.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        bVar.x();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        h hVar;
        super.onWindowFocusChanged(z);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.f400b;
        if (aVar == null || (hVar = aVar.L) == null) {
            return;
        }
        hVar.b(z);
        this.f400b.L.a(z);
    }

    protected abstract void p();

    public boolean r() {
        return false;
    }

    protected void s() {
        if (t.h(this.f400b.a)) {
            b(false);
            return;
        }
        com.bytedance.sdk.openadsdk.b.m.q.b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.f400b.T.e());
            this.c.d();
        }
    }

    protected void t() {
        Message message = new Message();
        message.what = 400;
        if (m()) {
            b(10000);
        }
        this.d.sendMessageDelayed(message, 2000L);
    }

    public void u() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.b
    public final void b() {
        if (this.k.compareAndSet(false, true)) {
            n();
        }
    }

    protected IListenerManager c(int i) {
        if (this.e == null) {
            this.e = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.c().a(i));
        }
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.core.j0.c.c
    public void a() {
        if (!this.f400b.y.getAndSet(true) || t.h(this.f400b.a)) {
            this.f400b.L.f();
        }
    }

    public void a(boolean z, boolean z2) {
        com.bytedance.sdk.openadsdk.b.m.q.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        bVar.a(z, z2, false);
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        com.bytedance.sdk.openadsdk.b.m.q.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        bVar.a(message);
    }
}
