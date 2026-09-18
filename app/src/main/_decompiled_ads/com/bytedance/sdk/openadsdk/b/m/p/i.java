package com.bytedance.sdk.openadsdk.b.m.p;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: RewardFullScreenManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private final com.bytedance.sdk.openadsdk.b.m.p.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f502b = true;
    protected int c;

    /* JADX INFO: compiled from: RewardFullScreenManager.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (i.this.a.V == null) {
                    return;
                }
                i.this.a.V.getWindow().getDecorView().findViewById(R.id.statusBarBackground).setVisibility(8);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullScreenManager.java */
    class b implements Runnable {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f503b;

        b(boolean z, boolean z2) {
            this.a = z;
            this.f503b = z2;
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00ff A[Catch: all -> 0x0104, TRY_LEAVE, TryCatch #0 {all -> 0x0104, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x001f, B:9:0x006c, B:11:0x0097, B:13:0x00ab, B:24:0x00e0, B:25:0x00e2, B:27:0x00e8, B:29:0x00ee, B:30:0x00f1, B:32:0x00ff, B:14:0x00b0, B:16:0x00ba, B:18:0x00ce, B:20:0x00d2, B:21:0x00d8, B:23:0x00dc, B:7:0x0045), top: B:35:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        public void run() {
            int iAbs;
            float fB;
            try {
                if (i.this.a.j == 2 && i.this.a.V.getResources().getConfiguration().orientation == 2) {
                    iAbs = Math.abs(b0.d((Context) i.this.a.V) - i.this.a.V.getWindow().getDecorView().getWidth());
                } else {
                    iAbs = Math.abs(b0.c((Context) i.this.a.V) - i.this.a.V.getWindow().getDecorView().getHeight());
                }
                if (iAbs == 0) {
                    View decorView = i.this.a.V.getWindow().getDecorView();
                    int paddingLeft = decorView.getPaddingLeft();
                    int paddingTop = decorView.getPaddingTop();
                    int paddingRight = decorView.getPaddingRight();
                    int paddingBottom = decorView.getPaddingBottom();
                    if (i.this.a.j != 1 || i.this.a.V.getResources().getConfiguration().orientation != 1) {
                        if (i.this.a.j == 2 && i.this.a.V.getResources().getConfiguration().orientation == 2) {
                            if (this.a) {
                                paddingLeft += (int) b0.b();
                            }
                            if (this.f503b) {
                                fB = b0.b();
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 19 && decorView.isAttachedToWindow()) {
                            decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                        }
                        if (i.this.a.k == 100.0f) {
                            decorView.setBackgroundColor(-16777216);
                        }
                    }
                    fB = b0.b();
                    paddingTop += (int) fB;
                    if (Build.VERSION.SDK_INT >= 19) {
                        decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                    if (i.this.a.k == 100.0f) {
                        decorView.setBackgroundColor(-16777216);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: RewardFullScreenManager.java */
    class c implements View.OnSystemUiVisibilityChangeListener {

        /* JADX INFO: compiled from: RewardFullScreenManager.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b0.b((Activity) i.this.a.V);
            }
        }

        c() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if (i == 0) {
                try {
                    if (i.this.a.V.isFinishing()) {
                        return;
                    }
                    i.this.a.V.getWindow().getDecorView().postDelayed(new a(), 2500L);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.m.b("TTAD.RFSM", e.getMessage());
                }
            }
        }
    }

    public i(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.c = 0;
        this.a = aVar;
        d();
        try {
            this.c = b0.b(aVar.V, b0.b());
            aVar.V.requestWindowFeature(1);
            aVar.V.getWindow().addFlags(16777344);
            if (aVar.j == 2 || !b0.a((Activity) aVar.V)) {
                aVar.V.getWindow().addFlags(1024);
            }
        } catch (Throwable th) {
            Log.e("TTAD.RFSM", "init: ", th);
        }
    }

    private void d() {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        aVar.k = aVar.a.o();
        if (26 != Build.VERSION.SDK_INT) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
            aVar2.j = aVar2.a.j0();
        } else if (this.a.V.getResources().getConfiguration().orientation == 1) {
            this.a.j = 1;
        } else {
            this.a.j = 2;
        }
    }

    private void e() {
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        if (aVar.j != 2) {
            aVar.V.setRequestedOrientation(1);
        } else if (aVar.n) {
            aVar.V.setRequestedOrientation(8);
        } else {
            aVar.V.setRequestedOrientation(0);
        }
    }

    public void b(y yVar) {
        if (yVar == null) {
            return;
        }
        yVar.postDelayed(new a(), 300L);
    }

    public void c() {
        b0.b((Activity) this.a.V);
        this.a.V.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new c());
    }

    private float[] b(int i) {
        float fA = a();
        float fB = b();
        int i2 = this.a.j;
        if ((i2 == 1) != (fA > fB)) {
            float f = fA + fB;
            fB = f - fB;
            fA = f - fB;
        }
        float f2 = i;
        if (i2 == 1) {
            fA -= f2;
        } else {
            fB -= f2;
        }
        return new float[]{fB, fA};
    }

    public void a(boolean z) {
        float fMin;
        float fMax;
        int iMax;
        int iMax2;
        int i = Build.VERSION.SDK_INT;
        if (i != 26) {
            if (i == 27) {
                try {
                    e();
                } catch (Throwable unused) {
                }
            } else {
                e();
            }
        }
        float fB = b();
        float fA = a();
        if (this.a.j == 2) {
            fMin = Math.max(fB, fA);
            fMax = Math.min(fB, fA);
        } else {
            fMin = Math.min(fB, fA);
            fMax = Math.max(fB, fA);
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
        int iB = b0.b(tTBaseVideoActivity, b0.b());
        if (this.a.j != 2) {
            if (b0.a((Activity) tTBaseVideoActivity)) {
                fMax -= iB;
            }
        } else if (b0.a((Activity) tTBaseVideoActivity)) {
            fMin -= iB;
        }
        if (z) {
            com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
            aVar.l = (int) fMin;
            aVar.m = (int) fMax;
            return;
        }
        com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
        int i2 = 20;
        int i3 = 0;
        if (aVar2.j == 2) {
            float f = aVar2.k;
            if (f != 0.0f && f != 100.0f) {
                float f2 = 20;
                iMax = (int) Math.max((fMin - (((fMax - f2) - f2) * f)) / 2.0f, 0.0f);
                i3 = iMax;
                iMax2 = 20;
            }
            com.bytedance.sdk.openadsdk.b.m.p.a aVar3 = this.a;
            float f3 = iMax;
            float f4 = i3;
            aVar3.l = (int) ((fMin - f3) - f4);
            float f5 = i2;
            float f6 = iMax2;
            aVar3.m = (int) ((fMax - f5) - f6);
            tTBaseVideoActivity.getWindow().getDecorView().setPadding(b0.a(tTBaseVideoActivity, f3), b0.a(tTBaseVideoActivity, f5), b0.a(tTBaseVideoActivity, f4), b0.a(tTBaseVideoActivity, f6));
        }
        float f7 = aVar2.k;
        if (f7 != 0.0f && f7 != 100.0f) {
            float f8 = 20;
            iMax2 = (int) Math.max((fMax - (((fMin - f8) - f8) / f7)) / 2.0f, 0.0f);
            i3 = 20;
            iMax = 20;
        }
        i2 = iMax2;
        com.bytedance.sdk.openadsdk.b.m.p.a aVar4 = this.a;
        float f9 = iMax;
        float f10 = i3;
        aVar4.l = (int) ((fMin - f9) - f10);
        float f11 = i2;
        float f12 = iMax2;
        aVar4.m = (int) ((fMax - f11) - f12);
        tTBaseVideoActivity.getWindow().getDecorView().setPadding(b0.a(tTBaseVideoActivity, f9), b0.a(tTBaseVideoActivity, f11), b0.a(tTBaseVideoActivity, f10), b0.a(tTBaseVideoActivity, f12));
        iMax = 0;
        iMax2 = 0;
        i2 = iMax2;
        com.bytedance.sdk.openadsdk.b.m.p.a aVar5 = this.a;
        float f13 = iMax;
        float f14 = i3;
        aVar5.l = (int) ((fMin - f13) - f14);
        float f15 = i2;
        float f16 = iMax2;
        aVar5.m = (int) ((fMax - f15) - f16);
        tTBaseVideoActivity.getWindow().getDecorView().setPadding(b0.a(tTBaseVideoActivity, f13), b0.a(tTBaseVideoActivity, f15), b0.a(tTBaseVideoActivity, f14), b0.a(tTBaseVideoActivity, f16));
    }

    private float b() {
        return b0.b(this.a.V, b0.d((Context) this.a.V));
    }

    public void a(y yVar) {
        try {
            boolean z = true;
            boolean z2 = this.f502b && o.d().a0() == 1;
            if (!this.f502b || !b0.a((Activity) this.a.V) || Build.VERSION.SDK_INT < 19) {
                z = false;
            }
            if (z || z2) {
                yVar.post(new b(z, z2));
            }
            this.f502b = false;
        } catch (Exception unused) {
        }
    }

    public float[] a(int i) {
        TTBaseVideoActivity tTBaseVideoActivity = this.a.V;
        View decorView = tTBaseVideoActivity.getWindow().getDecorView();
        float[] fArrB = {decorView.getWidth() - (decorView.getPaddingLeft() * 2), decorView.getHeight() - (decorView.getPaddingTop() * 2)};
        fArrB[0] = b0.b(tTBaseVideoActivity, fArrB[0]);
        fArrB[1] = b0.b(tTBaseVideoActivity, fArrB[1]);
        if (fArrB[0] < 10.0f || fArrB[1] < 10.0f) {
            com.bytedance.sdk.component.utils.m.a("TTAD.RFSM", "get root view size error, so run backup");
            fArrB = b(this.c);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 != 26 && i2 != 27 && tTBaseVideoActivity.getResources() != null && tTBaseVideoActivity.getResources().getConfiguration() != null) {
            if ((tTBaseVideoActivity.getResources().getConfiguration().orientation == 2 ? 2 : 1) != i) {
                if (i == 2) {
                    if (fArrB[0] < fArrB[1]) {
                        float f = fArrB[1];
                        fArrB[1] = fArrB[0];
                        fArrB[0] = f;
                    }
                } else if (fArrB[0] > fArrB[1]) {
                    float f2 = fArrB[1];
                    fArrB[1] = fArrB[0];
                    fArrB[0] = f2;
                }
            }
        }
        return fArrB;
    }

    private float a() {
        return b0.b(this.a.V, b0.c((Context) this.a.V));
    }
}
