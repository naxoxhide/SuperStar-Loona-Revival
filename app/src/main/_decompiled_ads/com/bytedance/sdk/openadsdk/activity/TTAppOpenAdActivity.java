package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.settings.n;
import com.bytedance.sdk.openadsdk.d.g;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTAppOpenAdActivity extends TTBaseActivity implements y.a {
    private static com.bytedance.sdk.openadsdk.a.e.b E;
    private boolean A;
    private com.bytedance.sdk.openadsdk.b.c B;
    private com.bytedance.sdk.openadsdk.b.n.b f;
    private ValueAnimator g;
    private TTAdDislikeDialog i;
    private TTAdDislikeToast j;
    private g m;
    private float n;
    private float o;
    private boolean p;
    private int q;
    private String r;
    private q s;
    private IListenerManager t;
    private com.bytedance.sdk.openadsdk.a.e.b u;
    private int x;
    private int y;
    private FrameLayout z;
    protected final AtomicBoolean a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final y f399b = new y(Looper.getMainLooper(), this);
    final AtomicBoolean c = new AtomicBoolean(false);
    final AtomicBoolean d = new AtomicBoolean(false);
    private final com.bytedance.sdk.openadsdk.b.p.a e = new com.bytedance.sdk.openadsdk.b.p.a();
    protected boolean h = false;
    private final AtomicBoolean k = new AtomicBoolean(false);
    private z l = z.a();
    private AtomicBoolean v = new AtomicBoolean(false);
    long w = 0;
    private final com.bytedance.sdk.openadsdk.b.a C = new a();
    private final Runnable D = new d();

    class a extends com.bytedance.sdk.openadsdk.b.a {
        a() {
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, int i) {
            m.a("TTAppOpenAdActivity", "open_ad", "onError() called with: totalPlayTime = [" + j + "], percent = [" + i + "]");
            TTAppOpenAdActivity.this.j();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.b.a, com.bytedance.sdk.openadsdk.b.n.a
        public void b(View view) {
            TTAppOpenAdActivity.this.x();
        }

        @Override // com.bytedance.sdk.openadsdk.b.a
        public void c() {
            TTAppOpenAdActivity.this.k();
        }

        @Override // com.bytedance.sdk.openadsdk.b.a
        public void d() {
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.b.a
        public void e() {
            TTAppOpenAdActivity.this.A();
            TTAppOpenAdActivity.this.l.e();
            TTAppOpenAdActivity.this.v();
            if (TTAppOpenAdActivity.this.p) {
                TTAppOpenAdActivity.this.s();
            }
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void h() {
            m.a("TTAppOpenAdActivity", "open_ad", "onTimeOut");
            TTAppOpenAdActivity.this.j();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.b.a
        public void b() {
            TTAppOpenAdActivity.this.h();
        }

        @Override // b.a.a.a.a.a.a.g.c.a
        public void a(long j, long j2) {
            TTAppOpenAdActivity.this.e.a(j);
            TTAppOpenAdActivity tTAppOpenAdActivity = TTAppOpenAdActivity.this;
            if (!tTAppOpenAdActivity.h && tTAppOpenAdActivity.B != null && TTAppOpenAdActivity.this.B.c() != null && TTAppOpenAdActivity.this.B.c().e()) {
                TTAppOpenAdActivity.this.B.c().g();
            }
            TTAppOpenAdActivity.this.t();
        }

        @Override // com.bytedance.sdk.openadsdk.b.a, com.bytedance.sdk.openadsdk.b.n.a
        public void a(View view) {
            TTAppOpenAdActivity.this.q();
        }

        @Override // com.bytedance.sdk.openadsdk.b.n.a
        public void a() {
            m.a("TTAppOpenAdActivity", "open_ad", "onCountDownFinish() called");
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                if (TTAppOpenAdActivity.this.u != null) {
                    TTAppOpenAdActivity.this.u.a();
                }
            } else {
                TTAppOpenAdActivity.this.a("onAdTimeOver");
            }
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.b.n.a
        public void a(int i, int i2, boolean z) {
            if (TTAppOpenAdActivity.this.B != null) {
                TTAppOpenAdActivity.this.B.a(i, i2, z);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int iY0 = TTAppOpenAdActivity.this.s.y0();
                TTAppOpenAdActivity tTAppOpenAdActivity = TTAppOpenAdActivity.this;
                tTAppOpenAdActivity.A = tTAppOpenAdActivity.s != null && TTAppOpenAdActivity.this.s.w0() == 2 && iY0 == 3;
                if (TTAppOpenAdActivity.this.A) {
                    TTAppOpenAdActivity tTAppOpenAdActivity2 = TTAppOpenAdActivity.this;
                    TTAppOpenAdActivity tTAppOpenAdActivity3 = TTAppOpenAdActivity.this;
                    tTAppOpenAdActivity2.B = new com.bytedance.sdk.openadsdk.b.b(tTAppOpenAdActivity3, tTAppOpenAdActivity3.s, TTAppOpenAdActivity.this.z, TTAppOpenAdActivity.this.C, TTAppOpenAdActivity.this.y, TTAppOpenAdActivity.this.p, TTAppOpenAdActivity.this.e);
                } else {
                    TTAppOpenAdActivity tTAppOpenAdActivity4 = TTAppOpenAdActivity.this;
                    TTAppOpenAdActivity tTAppOpenAdActivity5 = TTAppOpenAdActivity.this;
                    tTAppOpenAdActivity4.B = new com.bytedance.sdk.openadsdk.b.c(tTAppOpenAdActivity5, tTAppOpenAdActivity5.s, TTAppOpenAdActivity.this.z, TTAppOpenAdActivity.this.C, TTAppOpenAdActivity.this.y, TTAppOpenAdActivity.this.p, TTAppOpenAdActivity.this.e);
                    TTAppOpenAdActivity.this.B.a(TTAppOpenAdActivity.this.o, TTAppOpenAdActivity.this.n);
                }
                TTAppOpenAdActivity.this.B.a((ViewGroup) TTAppOpenAdActivity.this.z);
                TTAppOpenAdActivity.this.B.b();
                TTAppOpenAdActivity.this.B.g();
            } catch (Throwable th) {
                TTAppOpenAdActivity.this.finish();
                m.b("TTAppOpenAdActivity", th.getMessage());
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TTAppOpenAdActivity.this.k.get()) {
                return;
            }
            if (TTAppOpenAdActivity.this.s != null && TTAppOpenAdActivity.this.s.k1() && TTAppOpenAdActivity.this.s.M0() != null && TTAppOpenAdActivity.this.s.M0().m() != null) {
                TTAppOpenAdActivity.this.s.M0().m().d(0L);
            }
            TTAppOpenAdActivity.this.m = new g();
            TTAppOpenAdActivity.this.m.a(System.currentTimeMillis(), 1.0f);
            TTAppOpenAdActivity.this.l.e();
            if (TTAppOpenAdActivity.this.g != null && !TTAppOpenAdActivity.this.g.isStarted()) {
                TTAppOpenAdActivity.this.g.start();
            }
            TTAppOpenAdActivity.this.i();
            View viewFindViewById = TTAppOpenAdActivity.this.findViewById(R.id.content);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", viewFindViewById.getWidth());
                jSONObject.put("height", viewFindViewById.getHeight());
                jSONObject.put("alpha", viewFindViewById.getAlpha());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("root_view", jSONObject.toString());
                jSONObject2.put("ad_root", TTAppOpenAdActivity.this.x);
                jSONObject2.put("openad_creative_type", TTAppOpenAdActivity.this.p ? "video_normal_ad" : "image_normal_ad");
                if (com.bytedance.sdk.openadsdk.component.view.a.c() == null) {
                    jSONObject2.put("appicon_acquirefail", "1");
                }
                if (TTAppOpenAdActivity.this.A || TTAppOpenAdActivity.this.s.V0()) {
                    jSONObject2.put("dynamic_show_type", TTAppOpenAdActivity.this.l());
                }
                com.bytedance.sdk.openadsdk.d.c.b(TTAppOpenAdActivity.this.s, "open_ad", jSONObject2);
                com.bytedance.sdk.openadsdk.q.c.e.a(TTAppOpenAdActivity.this.findViewById(R.id.content), TTAppOpenAdActivity.this.s, TTAppOpenAdActivity.this.l());
                TTAppOpenAdActivity.this.k.set(true);
            } catch (JSONException e) {
                Log.e("TTAppOpenAdActivity", "run: ", e);
                TTAppOpenAdActivity.this.finish();
            }
        }
    }

    class e extends b.b.a.a.k.g {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTAppOpenAdActivity.this.m().executeAppOpenAdCallback(TTAppOpenAdActivity.this.r, this.c);
            } catch (Throwable th) {
                m.a("TTAppOpenAdActivity", "open_ad", "executeAppOpenAdCallback execute throw Exception : ", th);
            }
        }
    }

    class f implements View.OnSystemUiVisibilityChangeListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b0.b((Activity) TTAppOpenAdActivity.this);
            }
        }

        f() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if (i == 0) {
                try {
                    if (TTAppOpenAdActivity.this.isFinishing()) {
                        return;
                    }
                    TTAppOpenAdActivity.this.getWindow().getDecorView().postDelayed(new a(), 2500L);
                } catch (Exception e) {
                    m.b("TTAppOpenAdActivity", e.getMessage());
                }
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b0.b((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new f());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (o.d().u(String.valueOf(this.q)) == 1) {
            if (this.e.a() >= ((long) o.d().s(String.valueOf(this.q))) * 1000) {
                q();
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a(getApplicationContext());
        if (!c(bundle)) {
            finish();
            return;
        }
        if (!l.e()) {
            finish();
            return;
        }
        this.p = q.c(this.s);
        m.a("TTAppOpenAdActivity", "open_ad", "onCreate: isVideo is " + this.p);
        if (this.p) {
            this.e.a((float) this.s.N0().s());
        } else {
            this.e.a(o.d().y(String.valueOf(this.q)));
        }
        com.bytedance.sdk.openadsdk.b.n.b bVar = new com.bytedance.sdk.openadsdk.b.n.b(this.e);
        this.f = bVar;
        bVar.a(this.C);
        o();
        FrameLayout frameLayout = new FrameLayout(this);
        this.z = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        try {
            setContentView(this.z);
            this.z.post(new b());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.d.c.b();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f399b.removeCallbacksAndMessages(null);
        com.bytedance.sdk.openadsdk.q.c.e.c(this.s);
        if (this.p) {
            com.bytedance.sdk.openadsdk.b.k.a.a(this.s, this.e.a(), this.e.b(), true);
        } else {
            com.bytedance.sdk.openadsdk.b.k.a.a(this.s, -1L, this.e.b(), false);
        }
        if (this.l.b() && this.k.get()) {
            com.bytedance.sdk.openadsdk.d.c.a(String.valueOf(this.l.d()), this.s, "open_ad", this.m);
            this.l = z.a();
        }
        com.bytedance.sdk.openadsdk.b.c cVar = this.B;
        if (cVar != null) {
            cVar.e();
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("recycleRes");
        }
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.g.removeAllUpdateListeners();
        }
        E = null;
        this.u = null;
        TTAdDislikeDialog tTAdDislikeDialog = this.i;
        if (tTAdDislikeDialog != null) {
            tTAdDislikeDialog.setCallback(null);
        }
        if (n.j0().p(String.valueOf(this.q)) == 1) {
            com.bytedance.sdk.openadsdk.b.f.a(o.a()).b(new AdSlot.Builder().setCodeId(String.valueOf(this.q)).build());
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.h = false;
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        com.bytedance.sdk.openadsdk.b.c cVar;
        super.onResume();
        this.h = true;
        if (this.a.getAndSet(true)) {
            if (!this.v.get()) {
                u();
                return;
            }
            j();
            if (this.p && (cVar = this.B) != null && cVar.c() != null) {
                this.B.c().a(3);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            q qVar = this.s;
            bundle.putString("material_meta", qVar != null ? qVar.n1().toString() : null);
            bundle.putString(TTAdConstant.MULTI_PROCESS_META_MD5, this.r);
            bundle.putInt("ad_source", this.x);
            bundle.putLong("start_show_time", this.w);
        } catch (Throwable th) {
            m.b("TTAppOpenAdActivity", th.getMessage());
        }
        E = this.u;
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (!this.A) {
                this.l.e();
            }
            q qVar = this.s;
            if (qVar != null && qVar.Q0() && !this.s.R0()) {
                this.s.b(true);
                q qVar2 = this.s;
                com.bytedance.sdk.openadsdk.d.c.a(qVar2, "open_ad", qVar2.t());
            }
        } else if (this.k.get()) {
            if (this.l.b()) {
                com.bytedance.sdk.openadsdk.d.c.a(String.valueOf(this.l.d()), this.s, "open_ad", this.m);
            }
            this.l = z.a();
        }
        com.bytedance.sdk.openadsdk.q.c.e.a(this.s, z ? 4 : 8);
    }

    class c implements TTAdDislikeDialog.e {
        c() {
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void a(View view) {
            TTAppOpenAdActivity.this.c.set(true);
            TTAppOpenAdActivity.this.r();
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void b(View view) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void c(View view) {
            TTAppOpenAdActivity.this.c.set(false);
            TTAppOpenAdActivity.this.u();
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void a(int i, FilterWord filterWord) {
            if (TTAppOpenAdActivity.this.d.get() || filterWord == null || filterWord.hasSecondOptions()) {
                return;
            }
            TTAppOpenAdActivity.this.d.set(true);
            TTAppOpenAdActivity.this.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Log.d("TTAppOpenAdActivity", "startCountDownTimer() called");
        this.f.b(o.d().s(String.valueOf(this.q)));
        this.f.a(this.e.b());
        this.g = this.f.a();
        this.f.a(0);
    }

    private boolean c(Bundle bundle) {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.s = com.bytedance.sdk.openadsdk.core.b.f(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        m.a("TTAppOpenAdActivity", "open_ad", "initData MultiGlobalInfo throws ", e2);
                    }
                }
                this.r = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_META_MD5);
            }
        } else {
            this.s = s.g().e();
            this.u = s.g().c();
            s.g().a();
        }
        a(getIntent());
        b(bundle);
        q qVar = this.s;
        if (qVar == null) {
            m.a("TTAppOpenAdActivity", "open_ad", "mMaterialMeta is null , no data to display ,the TTOpenAdActivity finished !!");
            finish();
            return false;
        }
        qVar.c(this.w);
        this.q = this.s.S();
        com.bytedance.sdk.openadsdk.utils.b.a(this.s);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        m.a("TTAppOpenAdActivity", "open_ad", "callbackAdClick() called");
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdClicked");
        } else {
            com.bytedance.sdk.openadsdk.a.e.b bVar = this.u;
            if (bVar != null) {
                bVar.onAdClicked();
            }
        }
        if (n.j0().g(String.valueOf(this.q))) {
            this.v.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        m.a("TTAppOpenAdActivity", "open_ad", "callbackAdShow() called");
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdShow");
            return;
        }
        com.bytedance.sdk.openadsdk.a.e.b bVar = this.u;
        if (bVar != null) {
            bVar.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a("onAdSkip");
            return;
        }
        com.bytedance.sdk.openadsdk.a.e.b bVar = this.u;
        if (bVar != null) {
            bVar.onAdSkip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        int iMin;
        int iMax;
        m.a("TTAppOpenAdActivity", "open_ad", "changeScreenOrientation: mOrientation=" + this.y);
        int i = Build.VERSION.SDK_INT;
        if (i != 26) {
            if (i == 27) {
                try {
                    w();
                } catch (Throwable th) {
                    m.b("TTAppOpenAdActivity", th.getMessage());
                    return;
                }
            } else {
                w();
            }
        }
        Pair<Integer, Integer> pairE = b0.e(getApplicationContext());
        if (this.y == 2) {
            iMin = Math.max(((Integer) pairE.first).intValue(), ((Integer) pairE.second).intValue());
            iMax = Math.min(((Integer) pairE.first).intValue(), ((Integer) pairE.second).intValue());
        } else {
            iMin = Math.min(((Integer) pairE.first).intValue(), ((Integer) pairE.second).intValue());
            iMax = Math.max(((Integer) pairE.first).intValue(), ((Integer) pairE.second).intValue());
        }
        this.n = iMax;
        this.o = iMin;
        float fB = b0.b();
        if (b0.a((Activity) this)) {
            int i2 = this.y;
            if (i2 == 1) {
                this.n -= fB;
            } else if (i2 == 2) {
                this.o -= fB;
            }
        }
        com.bytedance.sdk.openadsdk.b.c cVar = this.B;
        if (cVar != null) {
            cVar.a(this.o, this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        if (this.s.V0()) {
            return 5;
        }
        if (this.A) {
            return this.B.d();
        }
        return -1;
    }

    private void n() {
        if (this.i == null) {
            TTAdDislikeDialog tTAdDislikeDialog = new TTAdDislikeDialog(this, this.s);
            this.i = tTAdDislikeDialog;
            tTAdDislikeDialog.setCallback(new c());
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
        frameLayout.addView(this.i);
        if (this.j == null) {
            TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this);
            this.j = tTAdDislikeToast;
            frameLayout.addView(tTAdDislikeToast);
        }
    }

    private void o() {
        if (26 != Build.VERSION.SDK_INT) {
            this.y = this.s.j0();
        } else if (getResources().getConfiguration().orientation == 1) {
            this.y = 1;
        } else {
            this.y = 2;
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.bytedance.sdk.openadsdk.b.c cVar;
        m.a("TTAppOpenAdActivity", "open_ad", "onUserWantSkip() called");
        r.a(this.q);
        j();
        if (this.p && (cVar = this.B) != null && cVar.c() != null) {
            this.B.c().a(4);
        }
        com.bytedance.sdk.openadsdk.b.k.a.a(this.s, (int) this.e.a(), this.f.b(), this.e.b());
        q qVar = this.s;
        if (qVar != null && qVar.k1() && this.s.M0() != null && this.s.M0().m() != null) {
            com.bytedance.sdk.openadsdk.core.i0.d dVarM = this.s.M0().m();
            long jB = 0;
            com.bytedance.sdk.openadsdk.b.c cVar2 = this.B;
            if (cVar2 != null && cVar2.c() != null) {
                jB = this.B.c().b();
            }
            dVarM.h(jB);
            dVarM.b(jB);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.p) {
            this.f399b.sendEmptyMessageDelayed(100, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.p) {
            this.f399b.removeMessages(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.k.get()) {
            return;
        }
        try {
            getWindow().getDecorView().post(this.D);
        } catch (Throwable unused) {
            finish();
        }
    }

    private void w() {
        if (this.y != 2) {
            setRequestedOrientation(1);
        } else if (p()) {
            setRequestedOrientation(8);
        } else {
            setRequestedOrientation(0);
        }
        if (this.y == 2 || !b0.a((Activity) this)) {
            getWindow().addFlags(1024);
        }
    }

    private void y() {
        this.j.a(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.j.a(TTAdDislikeToast.getDislikeSendTip());
    }

    protected void b(Bundle bundle) {
        if (bundle != null) {
            if (this.u == null) {
                this.u = E;
                E = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.r = bundle.getString(TTAdConstant.MULTI_PROCESS_META_MD5);
                this.x = bundle.getInt("ad_source", 0);
                this.w = bundle.getLong("start_show_time", 0L);
                this.s = com.bytedance.sdk.openadsdk.core.b.f(new JSONObject(string));
            } catch (Throwable th) {
                m.b("TTAppOpenAdActivity", th.getMessage());
            }
        }
    }

    protected IListenerManager m() {
        if (this.t == null) {
            this.t = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.c().a(7));
        }
        return this.t;
    }

    protected boolean p() {
        try {
            return getIntent().getIntExtra("orientation_angle", 0) == 3;
        } catch (Exception e2) {
            m.b("TTAppOpenAdActivity", e2.getMessage());
            return false;
        }
    }

    void r() {
        if (this.p) {
            com.bytedance.sdk.openadsdk.b.c cVar = this.B;
            if (cVar != null && cVar.c() != null && this.B.c().e()) {
                this.B.c().g();
            }
            t();
        }
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        valueAnimator.pause();
    }

    void u() {
        if (this.c.get()) {
            return;
        }
        if (this.p) {
            com.bytedance.sdk.openadsdk.b.c cVar = this.B;
            if (cVar != null && cVar.c() != null && this.B.c().d()) {
                this.B.c().i();
            }
            s();
        }
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        valueAnimator.resume();
    }

    protected void x() {
        if (isFinishing()) {
            return;
        }
        if (this.d.get()) {
            y();
            return;
        }
        if (this.i == null) {
            n();
        }
        this.i.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.openadsdk.utils.y.a(new e("AppOpenAd_executeMultiProcessCallback", str), 5);
    }

    protected void a(Intent intent) {
        if (intent != null) {
            this.x = intent.getIntExtra("ad_source", 0);
            this.w = intent.getLongExtra("start_show_time", 0L);
        }
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        com.bytedance.sdk.openadsdk.b.c cVar;
        if (message.what == 100) {
            if (this.p && (cVar = this.B) != null && cVar.c() != null) {
                this.B.c().a(1);
            }
            j();
            finish();
        }
    }
}
