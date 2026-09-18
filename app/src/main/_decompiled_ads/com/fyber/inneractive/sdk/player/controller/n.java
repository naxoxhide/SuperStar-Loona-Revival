package com.fyber.inneractive.sdk.player.controller;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.player.controller.w;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;
import com.fyber.inneractive.sdk.util.x;
import com.fyber.inneractive.sdk.util.y;
import com.fyber.inneractive.sdk.web.c0;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.fyber.adsession.media.InteractionType;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n<ListenerT extends w> implements com.fyber.inneractive.sdk.player.controller.b<ListenerT>, g.f, g.e, com.fyber.inneractive.sdk.player.ui.i {
    public Skip A;
    public boolean B;
    public com.fyber.inneractive.sdk.player.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f1023b;
    public com.fyber.inneractive.sdk.config.global.s c;
    public com.fyber.inneractive.sdk.player.ui.l d;
    public g.InterfaceC0279g e;
    public int f;
    public ListenerT g;
    public boolean h;
    public float i;
    public Runnable j;
    public boolean k;
    public boolean l;
    public Application.ActivityLifecycleCallbacks m;
    public boolean n;
    public boolean o;
    public Bitmap p;
    public AsyncTask<?, ?, ?> q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public com.fyber.inneractive.sdk.ignite.k w;
    public com.fyber.inneractive.sdk.player.ui.f x;
    public String y;
    public boolean z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.fyber.inneractive.sdk.player.enums.b.values().length];
            a = iArr;
            try {
                iArr[com.fyber.inneractive.sdk.player.enums.b.Prepared.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Buffering.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Playing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Paused.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Completed.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Error.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Preparing.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Seeking.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b(n nVar) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return true;
        }
    }

    public class c implements f {
        public c() {
        }

        @Override // com.fyber.inneractive.sdk.player.controller.n.f
        public void a(Bitmap bitmap) {
            n nVar = n.this;
            nVar.a(nVar.d, bitmap, true, true);
        }
    }

    public class d extends AsyncTask<Integer, Void, Bitmap> {
        public d() {
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Integer[] numArr) {
            Integer[] numArr2 = numArr;
            int iIntValue = numArr2[0].intValue();
            int iIntValue2 = numArr2[1].intValue();
            n.this.getClass();
            Application application = com.fyber.inneractive.sdk.util.l.a;
            Bitmap bitmapCreateBitmap = null;
            if (application != null && application.getResources() != null && application.getResources().getDisplayMetrics() != null) {
                DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
                try {
                    bitmapCreateBitmap = Bitmap.createBitmap(iIntValue, iIntValue2, Bitmap.Config.ARGB_8888);
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.setDensity(displayMetrics.densityDpi);
                    }
                } catch (Throwable unused) {
                }
            }
            return bitmapCreateBitmap;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            super.onPostExecute(bitmap2);
            n nVar = n.this;
            nVar.p = bitmap2;
            nVar.q = null;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f1024b;

        public class a implements Runnable {
            public final /* synthetic */ Bitmap a;

            public a(Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = e.this.f1024b;
                if (fVar != null) {
                    fVar.a(this.a);
                }
            }
        }

        public e(boolean z, f fVar) {
            this.a = z;
            this.f1024b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.fyber.inneractive.sdk.player.c cVar;
            g gVar;
            n nVar = n.this;
            boolean z = this.a;
            Bitmap bitmap = null;
            if (nVar.p != null && (cVar = nVar.a) != null && (gVar = cVar.f1002b) != null) {
                if (nVar.o) {
                    bitmap = cVar.k;
                } else {
                    TextureView textureView = gVar.j;
                    Object[] objArr = new Object[3];
                    objArr[0] = IAlog.a(nVar);
                    objArr[1] = textureView;
                    objArr[2] = Boolean.valueOf(textureView != null && textureView.isAvailable());
                    IAlog.a("%sSave snapshot entered: tv = %s avail = %s", objArr);
                    if (textureView != null && textureView.isAvailable()) {
                        try {
                            IAlog.d("creating bitmap on object - %s", nVar.p);
                            Bitmap bitmap2 = textureView.getBitmap(nVar.p);
                            if (nVar.d.getVideoWidth() > 0 && nVar.d.getVideoHeight() > 0) {
                                nVar.p = null;
                                nVar.a(nVar.d.getVideoWidth(), nVar.d.getVideoHeight());
                            }
                            if (z) {
                                com.fyber.inneractive.sdk.util.c cVar2 = new com.fyber.inneractive.sdk.util.c();
                                cVar2.c = 20;
                                cVar2.d = 1;
                                cVar2.a = bitmap2.getWidth();
                                cVar2.f1333b = bitmap2.getHeight();
                                nVar.a.a(com.fyber.inneractive.sdk.util.b.a(nVar.d.getContext(), bitmap2, cVar2));
                                nVar.o = true;
                            } else {
                                nVar.a.a(bitmap2);
                            }
                            IAlog.d("%ssave snapshot succeeded", IAlog.a(nVar));
                            bitmap = nVar.a.k;
                        } catch (Exception unused) {
                            IAlog.d("%ssave snapshot failed with exception", IAlog.a(nVar));
                        }
                    }
                }
            }
            com.fyber.inneractive.sdk.util.m.f1343b.post(new a(bitmap));
        }
    }

    public interface f {
        void a(Bitmap bitmap);
    }

    public n(com.fyber.inneractive.sdk.player.c cVar, com.fyber.inneractive.sdk.player.ui.l lVar, b0 b0Var, com.fyber.inneractive.sdk.config.global.s sVar, boolean z, String str, boolean z2) {
        this(cVar, lVar, b0Var, sVar, z, null, str, z2);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0070  */
    public void A() {
        g gVar;
        this.d.a(false);
        this.d.c(false);
        com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
        com.fyber.inneractive.sdk.player.ui.c cVar = new com.fyber.inneractive.sdk.player.ui.c();
        cVar.f1265b = false;
        lVar.d(new com.fyber.inneractive.sdk.player.ui.b(cVar));
        j();
        if (this.a != null && B() && !this.h) {
            int iD = this.a.f1002b.d();
            com.fyber.inneractive.sdk.player.c cVar2 = this.a;
            if (com.fyber.inneractive.sdk.player.c.a(iD, ((com.fyber.inneractive.sdk.player.e) cVar2).y, com.fyber.inneractive.sdk.player.c.a(cVar2))) {
                if (this.f <= 0) {
                    this.d.d(true);
                    n();
                } else {
                    com.fyber.inneractive.sdk.player.c cVar3 = this.a;
                    if (cVar3 == null || (gVar = cVar3.f1002b) == null) {
                        if (!this.s) {
                            this.d.d(true);
                            c(this.f);
                            this.s = true;
                        }
                    } else if (this.f >= gVar.d() / 1000) {
                        this.d.d(false);
                    } else if (!this.s) {
                        this.d.d(true);
                        c(this.f);
                        this.s = true;
                    }
                }
            }
        }
        ListenerT listenert = this.g;
        if (listenert != null && !this.k) {
            this.k = true;
            listenert.l();
        }
        this.o = false;
        this.t = false;
    }

    public abstract boolean B();

    public void C() {
        com.fyber.inneractive.sdk.config.global.s sVar;
        com.fyber.inneractive.sdk.config.global.s sVar2 = this.c;
        String str = null;
        com.fyber.inneractive.sdk.config.global.features.r rVar = sVar2 != null ? (com.fyber.inneractive.sdk.config.global.features.r) sVar2.a(com.fyber.inneractive.sdk.config.global.features.r.class) : null;
        boolean zA = rVar != null ? rVar.a("show_cta", true) : true;
        ListenerT listenert = this.g;
        if (listenert != null) {
            this.w = listenert.q();
        }
        com.fyber.inneractive.sdk.ignite.k kVar = this.w;
        boolean z = kVar == com.fyber.inneractive.sdk.ignite.k.NONE ? zA : true;
        com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
        if (lVar.k != null) {
            lVar.k.setAllCaps((!z || (sVar = lVar.K) == null || sVar.a(com.fyber.inneractive.sdk.config.global.features.r.class) == null) ? false : ((com.fyber.inneractive.sdk.config.global.features.r) lVar.K.a(com.fyber.inneractive.sdk.config.global.features.r.class)).d());
            com.fyber.inneractive.sdk.config.global.s sVar3 = lVar.K;
            com.fyber.inneractive.sdk.config.global.features.c cVar = sVar3 != null ? (com.fyber.inneractive.sdk.config.global.features.c) sVar3.a(com.fyber.inneractive.sdk.config.global.features.c.class) : null;
            if (cVar != null) {
                cVar.e(IAConfigManager.M.p);
                com.fyber.inneractive.sdk.model.vast.a aVar = cVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.a;
                }
            }
            if (IAConfigManager.M.E.d() && kVar.e()) {
                lVar.k.setText(R.string.ia_video_instant_install_text);
            } else if (TextUtils.isEmpty(str)) {
                lVar.k.setText(R.string.ia_video_install_now_text);
            } else {
                lVar.k.setText(str);
            }
            if (!TextUtils.isEmpty(lVar.N)) {
                lVar.k.setText(lVar.N);
            }
            lVar.k.setVisibility(z ? 0 : 4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:147:0x01fe  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v47 */
    public void D() {
        ListenerT listenert;
        com.fyber.inneractive.sdk.flow.m mVar;
        g gVar;
        g gVar2;
        com.fyber.inneractive.sdk.measurement.d dVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && ((((gVar2 = cVar.f1002b) != null && gVar2.e.equals(com.fyber.inneractive.sdk.player.enums.b.Completed)) || this.t) && (dVar = this.a.h) != null)) {
            dVar.a();
        }
        IAConfigManager iAConfigManager = IAConfigManager.M;
        boolean z = false;
        boolean zA = iAConfigManager.u.f886b.a(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD).a("dsos", false);
        com.fyber.inneractive.sdk.player.c cVar2 = this.a;
        if (((cVar2 != null && (gVar = cVar2.f1002b) != null && gVar.e.equals(com.fyber.inneractive.sdk.player.enums.b.Completed)) == true || (this.t && !zA) || this.u) != true) {
            if (!this.t || !zA) {
                this.d.c(true);
                return;
            } else {
                this.d.b(false);
                this.d.c(false);
                return;
            }
        }
        com.fyber.inneractive.sdk.player.c cVar3 = this.a;
        View viewB = cVar3 != null ? cVar3.b() : null;
        ?? r5 = viewB != null;
        this.d.d();
        com.fyber.inneractive.sdk.config.global.s sVar = this.c;
        com.fyber.inneractive.sdk.config.global.features.r rVar = sVar != null ? (com.fyber.inneractive.sdk.config.global.features.r) sVar.a(com.fyber.inneractive.sdk.config.global.features.r.class) : null;
        if (r5 == true) {
            if (viewB instanceof com.fyber.inneractive.sdk.web.g) {
                com.fyber.inneractive.sdk.player.c cVar4 = this.a;
                com.fyber.inneractive.sdk.player.controller.c cVar5 = (cVar4 == null || (mVar = ((com.fyber.inneractive.sdk.player.e) cVar4).z) == null) ? null : mVar.m;
                if (cVar5 != null) {
                    s sVar2 = new s(this);
                    c0 c0Var = cVar5.a;
                    if (c0Var != null) {
                        c0Var.setListener(sVar2);
                    }
                    c0 c0Var2 = cVar5.a;
                    if (c0Var2 != null) {
                        y.a(cVar5.c);
                        c0Var2.n();
                    }
                    c0 c0Var3 = cVar5.a;
                    if (c0Var3 != null) {
                        c0Var3.a(true);
                    }
                }
                if (cVar5 != null) {
                    c0 c0Var4 = cVar5.a;
                    if ((c0Var4 != null && c0Var4.o()) != false) {
                        return;
                    }
                }
            }
            l();
            this.d.b(false);
            ViewGroup viewGroup = this.d.j;
            if (viewGroup != null) {
                viewGroup.setVisibility(4);
            }
            this.d.c(false);
            com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
            com.fyber.inneractive.sdk.player.c cVar6 = this.a;
            com.fyber.inneractive.sdk.model.vast.c cVarC = cVar6 != null ? cVar6.c() : null;
            com.fyber.inneractive.sdk.player.ui.c cVar7 = new com.fyber.inneractive.sdk.player.ui.c();
            cVar7.f1265b = true;
            cVar7.g = viewB;
            cVar7.h = cVarC != null ? cVarC.a : null;
            cVar7.c = rVar != null && rVar.d();
            com.fyber.inneractive.sdk.config.global.features.r.c cVarB = b(rVar);
            int iA = a(rVar);
            cVar7.i = cVarB;
            cVar7.j = iA;
            if (d(rVar)) {
                com.fyber.inneractive.sdk.flow.vast.e eVarC = c();
                if (((eVarC == null || !eVarC.a || eVarC.f933b == null) ? false : true) == false) {
                    z = true;
                }
            }
            Integer numValueOf = Integer.valueOf(c(rVar));
            if (z) {
                cVar7.f = numValueOf;
            }
            lVar.a(new com.fyber.inneractive.sdk.player.ui.b(cVar7));
            a(com.fyber.inneractive.sdk.model.vast.h.Other, 1);
            viewB.requestFocus();
            return;
        }
        if (!this.z && (listenert = this.g) != null) {
            listenert.k();
            return;
        }
        if (this.x != null) {
            a(true, (f) new p(this));
        } else {
            com.fyber.inneractive.sdk.player.c cVar8 = this.a;
            a(this.d, cVar8 != null ? cVar8.k : null, false, false);
        }
        com.fyber.inneractive.sdk.flow.vast.e eVarC2 = c();
        if (((eVarC2 == null || !eVarC2.a || eVarC2.f933b == null) ? false : true) == true) {
            com.fyber.inneractive.sdk.player.controller.c cVar9 = eVarC2.g;
            s sVar3 = new s(this);
            c0 c0Var5 = cVar9.a;
            if (c0Var5 != null) {
                c0Var5.setListener(sVar3);
            }
            com.fyber.inneractive.sdk.player.ui.l lVar2 = this.d;
            com.fyber.inneractive.sdk.player.ui.c cVar10 = new com.fyber.inneractive.sdk.player.ui.c();
            cVar10.f1265b = true;
            cVar10.g = eVarC2.f933b;
            com.fyber.inneractive.sdk.model.vast.h hVar = com.fyber.inneractive.sdk.model.vast.h.FMP_End_Card;
            cVar10.h = hVar;
            boolean zD = d(rVar);
            Integer numValueOf2 = Integer.valueOf(c(rVar));
            if (zD) {
                cVar10.f = numValueOf2;
            }
            lVar2.a(new com.fyber.inneractive.sdk.player.ui.b(cVar10));
            a(hVar, 1);
            return;
        }
        this.d.b(true);
        this.d.c(false);
        com.fyber.inneractive.sdk.player.ui.c cVar11 = new com.fyber.inneractive.sdk.player.ui.c();
        cVar11.f1265b = this.z;
        cVar11.c = rVar != null && rVar.d();
        String str = this.y;
        if (str == null) {
            com.fyber.inneractive.sdk.config.global.s sVar4 = this.c;
            if (sVar4 != null) {
                com.fyber.inneractive.sdk.config.global.features.c cVar12 = (com.fyber.inneractive.sdk.config.global.features.c) sVar4.a(com.fyber.inneractive.sdk.config.global.features.c.class);
                cVar12.e(iAConfigManager.p);
                com.fyber.inneractive.sdk.model.vast.a aVar = cVar12.e;
                if (aVar == null || !aVar.d) {
                    str = null;
                } else {
                    str = aVar.a;
                }
            } else {
                str = null;
            }
        }
        cVar11.e = str;
        boolean zD2 = d(rVar);
        Integer numValueOf3 = Integer.valueOf(c(rVar));
        if (zD2) {
            cVar11.f = numValueOf3;
        }
        com.fyber.inneractive.sdk.config.global.features.r.c cVarB2 = b(rVar);
        int iA2 = a(rVar);
        cVar11.i = cVarB2;
        cVar11.j = iA2;
        com.fyber.inneractive.sdk.config.global.s sVar5 = this.c;
        com.fyber.inneractive.sdk.config.global.features.h hVar2 = sVar5 != null ? (com.fyber.inneractive.sdk.config.global.features.h) sVar5.a(com.fyber.inneractive.sdk.config.global.features.h.class) : null;
        if (hVar2 != null) {
            cVar11.a = hVar2.a("should_show_hand", false);
            Double dA = hVar2.a("scale_up_to");
            float fDoubleValue = (float) (dA != null ? dA.doubleValue() : 1.2999999523162842d);
            if (fDoubleValue > 1.7f || fDoubleValue < 1.1f) {
                fDoubleValue = 1.3f;
            }
            cVar11.d = fDoubleValue;
        }
        com.fyber.inneractive.sdk.player.c cVar13 = this.a;
        if (cVar13 != null && cVar13.a(this.c, this.w)) {
            z = true;
        }
        cVar11.l = z;
        com.fyber.inneractive.sdk.config.global.s sVar6 = this.c;
        com.fyber.inneractive.sdk.config.global.features.n nVar = sVar6 != null ? (com.fyber.inneractive.sdk.config.global.features.n) sVar6.a(com.fyber.inneractive.sdk.config.global.features.n.class) : null;
        cVar11.m = nVar != null ? nVar.d() : this.d.getContext().getString(R.string.ia_video_app_info_text);
        ListenerT listenert2 = this.g;
        if (listenert2 != null) {
            cVar11.k = listenert2.q();
        }
        this.d.d(new com.fyber.inneractive.sdk.player.ui.b(cVar11));
        a(com.fyber.inneractive.sdk.model.vast.h.Default_End_Card, 1);
    }

    public void E() {
        com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
        if (lVar.u != null) {
            lVar.setMuteButtonState(t());
        }
    }

    public final int a(com.fyber.inneractive.sdk.config.global.features.r rVar) {
        if (rVar == null) {
            return 500;
        }
        Integer numB = rVar.b("endcard_animation_duration");
        int iIntValue = numB != null ? numB.intValue() : 500;
        if (iIntValue < 500 || iIntValue > 3000) {
            return 500;
        }
        return iIntValue;
    }

    public abstract void a(k0 k0Var);

    @Override // com.fyber.inneractive.sdk.player.controller.g.f
    public void a(Exception exc) {
    }

    public final com.fyber.inneractive.sdk.config.global.features.r.c b(com.fyber.inneractive.sdk.config.global.features.r rVar) {
        if (rVar == null) {
            return com.fyber.inneractive.sdk.config.global.features.r.f;
        }
        String strA = rVar.a("endcard_animation_type", com.fyber.inneractive.sdk.config.global.features.r.f.mKey);
        for (com.fyber.inneractive.sdk.config.global.features.r.c cVar : com.fyber.inneractive.sdk.config.global.features.r.c.values()) {
            if (strA.equalsIgnoreCase(cVar.mKey)) {
                return cVar;
            }
        }
        return com.fyber.inneractive.sdk.config.global.features.r.c.NONE;
    }

    public void b() {
    }

    public final int c(com.fyber.inneractive.sdk.config.global.features.r rVar) {
        if (rVar == null) {
            return 3;
        }
        Integer numB = rVar.b("autoClickDelay");
        int iIntValue = numB != null ? numB.intValue() : 3;
        if (iIntValue < 0 || iIntValue > 10) {
            return 3;
        }
        return iIntValue;
    }

    public final boolean d(com.fyber.inneractive.sdk.config.global.features.r rVar) {
        return rVar != null && rVar.a("shouldEnableEndCardAutoClick", false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void destroy() {
        g gVar;
        Application application;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.m;
        if (activityLifecycleCallbacks != null && (application = com.fyber.inneractive.sdk.util.l.a) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        IAlog.a("%sdestroy called", IAlog.a(this));
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && (gVar = cVar.f1002b) != null) {
            gVar.f1018b.remove(this);
            this.a.f1002b.c.remove(this);
        }
        l();
        j();
        AsyncTask<?, ?, ?> asyncTask = this.q;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        this.g = null;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g.f
    public void e(boolean z) {
    }

    /* JADX WARN: Code duplicated, block: B:23:0x002f  */
    @Override // com.fyber.inneractive.sdk.player.controller.b
    public boolean e() {
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null) {
            return false;
        }
        if (!this.h) {
            if (cVar.f1002b != null) {
                com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
                if (lVar == null) {
                    int iD = this.a.f1002b.d();
                    com.fyber.inneractive.sdk.player.c cVar2 = this.a;
                    if (com.fyber.inneractive.sdk.player.c.a(iD, ((com.fyber.inneractive.sdk.player.e) cVar2).y, com.fyber.inneractive.sdk.player.c.a(cVar2)) || this.h || this.f != 0) {
                        return false;
                    }
                } else {
                    TextView textView = lVar.o;
                    if (!(textView != null && textView.getVisibility() == 0 && lVar.o.isEnabled())) {
                        int iD2 = this.a.f1002b.d();
                        com.fyber.inneractive.sdk.player.c cVar3 = this.a;
                        return com.fyber.inneractive.sdk.player.c.a(iD2, ((com.fyber.inneractive.sdk.player.e) cVar3).y, com.fyber.inneractive.sdk.player.c.a(cVar3)) ? false : false;
                    }
                }
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g.f
    public void g() {
        if (this.r && !this.l) {
            this.l = true;
            this.d.b(false);
        }
    }

    public void h(boolean z) {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null) {
            if (!cVar.j) {
                D();
            } else if (!z || (gVar = cVar.f1002b) == null) {
                cVar.d();
            } else {
                gVar.a(0, true);
            }
        }
    }

    public void i() {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || (gVar = cVar.f1002b) == null) {
            return;
        }
        if (!gVar.f1018b.contains(this)) {
            gVar.f1018b.add(this);
        }
        g gVar2 = this.a.f1002b;
        if (gVar2.c.contains(this)) {
            return;
        }
        gVar2.c.add(this);
    }

    public final void j() {
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
    }

    public boolean k() {
        g gVar;
        g gVar2;
        com.fyber.inneractive.sdk.player.ui.f fVar;
        TextureView textureView;
        com.fyber.inneractive.sdk.measurement.d dVar;
        if (this.x == null) {
            com.fyber.inneractive.sdk.player.ui.f fVar2 = new com.fyber.inneractive.sdk.player.ui.f(this.d);
            this.x = fVar2;
            com.fyber.inneractive.sdk.player.c cVar = this.a;
            if (cVar != null && (dVar = cVar.h) != null) {
                View[] trackingFriendlyView = this.d.getTrackingFriendlyView();
                AdSession adSession = dVar.a;
                if (adSession != null) {
                    try {
                        adSession.registerAdView(fVar2);
                    } catch (Throwable th) {
                        dVar.a(th);
                    }
                }
                if (dVar.a != null && trackingFriendlyView != null) {
                    for (View view : trackingFriendlyView) {
                        if (view != null) {
                            try {
                                dVar.a.addFriendlyObstruction(view, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
                            } catch (Throwable th2) {
                                dVar.a(th2);
                            }
                        }
                    }
                }
                View[] trackingFriendlyViewObstructionPurposeOther = this.d.getTrackingFriendlyViewObstructionPurposeOther();
                if (dVar.a != null) {
                    for (View view2 : trackingFriendlyViewObstructionPurposeOther) {
                        if (view2 != null) {
                            try {
                                dVar.a.addFriendlyObstruction(view2, FriendlyObstructionPurpose.OTHER, null);
                            } catch (Throwable th3) {
                                dVar.a(th3);
                            }
                        }
                    }
                }
            }
        }
        IAlog.a("%sconnectToTextureView called %s", IAlog.a(this), this.d.getTextureHost());
        if (this.x == null || !this.d.getTextureHost().equals(this.x.getParent())) {
            com.fyber.inneractive.sdk.player.c cVar2 = this.a;
            if (cVar2 != null && (gVar2 = cVar2.f1002b) != null && (textureView = gVar2.j) != (fVar = this.x)) {
                if (textureView != null) {
                    textureView.setSurfaceTextureListener(null);
                }
                gVar2.j = fVar;
                if (gVar2.m == null) {
                    gVar2.m = new com.fyber.inneractive.sdk.player.controller.f(gVar2);
                }
                if (fVar != null) {
                    fVar.setSurfaceTextureListener(gVar2.m);
                }
                if (gVar2.k != null) {
                    IAlog.a("%scalling setSurfaceTexture with cached texture", IAlog.a(gVar2));
                    if (gVar2.j.getSurfaceTexture() == null || !gVar2.j.getSurfaceTexture().equals(gVar2.k)) {
                        IAlog.a("%scalling setSurfaceTexture with cached texture success", IAlog.a(gVar2));
                        gVar2.j.setSurfaceTexture(gVar2.k);
                    } else {
                        IAlog.a("%scalling setSurfaceTexture with cached texture failed", IAlog.a(gVar2));
                    }
                }
            }
            com.fyber.inneractive.sdk.player.ui.f fVar3 = this.x;
            if (fVar3 != null) {
                fVar3.setId(R.id.inn_texture_view);
            }
            IAlog.a("%supdateView adding texture to parent", IAlog.a(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.gravity = 17;
            if (this.x.getParent() == null) {
                this.d.getTextureHost().addView(this.x, layoutParams);
            }
            this.l = false;
            m mVar = new m(this);
            this.e = mVar;
            com.fyber.inneractive.sdk.player.c cVar3 = this.a;
            if (cVar3 != null && (gVar = cVar3.f1002b) != null) {
                gVar.d = mVar;
            }
        } else {
            IAlog.a("%sconnectToTextureView called but already connected", IAlog.a(this));
        }
        return true;
    }

    public void l() {
        if (this.x != null) {
            IAlog.a("%sdestroyTextureView", IAlog.a(this));
            if (this.p != null) {
                a(false, (f) new c());
            }
        }
    }

    public final void m() {
        com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
        if (lVar != null) {
            lVar.g();
            lVar.H = true;
        }
    }

    public void n() {
        if (B()) {
            com.fyber.inneractive.sdk.config.global.s sVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.c cVar = sVar != null ? (com.fyber.inneractive.sdk.config.global.features.c) sVar.a(com.fyber.inneractive.sdk.config.global.features.c.class) : null;
            if (cVar != null) {
                cVar.e(IAConfigManager.M.p);
                com.fyber.inneractive.sdk.model.vast.a aVar = cVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.f958b;
                }
            }
            if (!TextUtils.isEmpty(this.y) || str == null) {
                com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
                lVar.setSkipText(lVar.getContext().getString(R.string.ia_video_skip_text));
            } else {
                this.d.setSkipText(str);
            }
            this.d.c();
            this.f = 0;
            ListenerT listenert = this.g;
            if (listenert != null) {
                listenert.e();
            }
        }
    }

    public abstract int o();

    public com.fyber.inneractive.sdk.config.global.features.b p() {
        com.fyber.inneractive.sdk.config.global.s sVar = this.c;
        if ((sVar == null || sVar.a(com.fyber.inneractive.sdk.config.global.features.b.class) == null || ((ArrayList) ((com.fyber.inneractive.sdk.config.global.features.b) this.c.a(com.fyber.inneractive.sdk.config.global.features.b.class)).c()).size() <= 0) ? false : true) {
            return (com.fyber.inneractive.sdk.config.global.features.b) this.c.a(com.fyber.inneractive.sdk.config.global.features.b.class);
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void pauseVideo() {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || (gVar = cVar.f1002b) == null) {
            return;
        }
        if (gVar.e == com.fyber.inneractive.sdk.player.enums.b.Paused) {
            IAlog.a("%spauseVideo called in bad state! %s", IAlog.a(this), this.a.f1002b.e);
            return;
        }
        IAlog.a("%spauseVideo %s", IAlog.a(this), this.d);
        TextureView textureView = this.a.f1002b.j;
        if (textureView == null || textureView.getParent() == null || !textureView.getParent().equals(this.d.getTextureHost())) {
            return;
        }
        this.a.f1002b.k();
    }

    public int q() {
        int i;
        com.fyber.inneractive.sdk.config.i iVar = IAConfigManager.M.u.f886b;
        String string = Integer.toString(30);
        if (iVar.a.containsKey("max_rv_tsec")) {
            string = iVar.a.get("max_rv_tsec");
        }
        try {
            i = Integer.parseInt(string);
        } catch (Throwable unused) {
            i = 30;
        }
        if (i < 1) {
            return 30;
        }
        return i;
    }

    public final float r() {
        try {
            return ((AudioManager) this.d.getContext().getSystemService("audio")).getStreamVolume(3);
        } catch (Throwable unused) {
            return 1.0f;
        }
    }

    public abstract int s();

    public boolean t() {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || (gVar = cVar.f1002b) == null) {
            return false;
        }
        return gVar.i() || r() == 0.0f;
    }

    public abstract void u();

    public void v() {
        if (this.d.f()) {
            return;
        }
        this.d.a(false);
        j();
        D();
        this.k = false;
        this.h = true;
    }

    public abstract void w();

    public void x() {
        j();
        this.d.a(false);
        D();
    }

    public abstract void y();

    public void z() {
    }

    public n(com.fyber.inneractive.sdk.player.c cVar, com.fyber.inneractive.sdk.player.ui.l lVar, b0 b0Var, com.fyber.inneractive.sdk.config.global.s sVar, boolean z, Skip skip, String str, boolean z2) {
        this.f = 0;
        this.h = false;
        this.i = -0.1f;
        this.l = false;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = com.fyber.inneractive.sdk.ignite.k.NONE;
        this.A = null;
        this.B = false;
        this.A = skip;
        this.a = cVar;
        this.f1023b = b0Var;
        this.c = sVar;
        this.d = lVar;
        this.n = z;
        this.y = str;
        this.z = z2;
        lVar.setListener(this);
        i();
        new GestureDetector(lVar.getContext(), new b(this));
    }

    public void f() {
        IAlog.a("%sonVideoViewDetachedFromWindow", IAlog.a(this));
        l();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void d(boolean z) {
        IAlog.a("%sinitUI", IAlog.a(this));
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || cVar.f1002b == null) {
            return;
        }
        this.d.setUnitConfig(this.f1023b);
        com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
        int iH = this.a.f1002b.h();
        int iG = this.a.f1002b.g();
        boolean z2 = this.n;
        lVar.r = iH;
        lVar.s = iG;
        lVar.t = z2;
        if (this.a.f1002b.h() > 0 && this.a.f1002b.g() > 0) {
            a(this.a.f1002b.h(), this.a.f1002b.g());
        }
        if (B()) {
            this.f = s();
        } else {
            this.d.d(false);
        }
        if (!z) {
            a(this.a.f1002b.c());
            a(this.a.f1002b.e, false);
        }
        E();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void a(ListenerT listenert) {
        this.g = listenert;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void c(boolean z) {
        com.fyber.inneractive.sdk.player.c cVar;
        g gVar;
        com.fyber.inneractive.sdk.config.c0 c0Var;
        b0 b0Var = this.f1023b;
        boolean z2 = true;
        boolean z3 = (b0Var == null || (c0Var = ((a0) b0Var).f) == null || c0Var.j != UnitDisplayType.REWARDED) ? false : true;
        if (!InneractiveAdManager.isCurrentUserAChild() || !z3 || this.d == null || (cVar = this.a) == null || (gVar = cVar.f1002b) == null) {
            z2 = false;
        } else {
            int iC = gVar.c() / 1000;
            int iQ = q();
            if ((this.a.f1002b.d() / 1000) - iC > 0 && iC >= iQ) {
                z2 = false;
            }
        }
        if (z2) {
            new v(this.d.getContext(), p(), new r(this, z)).c.show();
        } else {
            f(z);
        }
    }

    public final void a(int i, int i2) {
        Bitmap bitmap = this.p;
        if (!(bitmap != null && bitmap.getWidth() == i && this.p.getHeight() == i2) && i2 > 0 && i > 0) {
            AsyncTask<?, ?, ?> asyncTask = this.q;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            this.p = null;
            d dVar = new d();
            this.q = dVar;
            dVar.executeOnExecutor(com.fyber.inneractive.sdk.util.m.a, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public final void f(boolean z) {
        com.fyber.inneractive.sdk.player.c cVar;
        g gVar;
        com.fyber.inneractive.sdk.config.c0 c0Var;
        ListenerT listenert;
        com.fyber.inneractive.sdk.player.c cVar2;
        g gVar2;
        g gVar3;
        com.fyber.inneractive.sdk.measurement.d dVar;
        b0 b0Var;
        com.fyber.inneractive.sdk.config.c0 c0Var2;
        this.t = true;
        f0 f0Var = IAConfigManager.M.x;
        if (z && f0Var != null && (b0Var = this.f1023b) != null && (c0Var2 = ((a0) b0Var).f) != null) {
            f0Var.a(c0Var2.j, "LAST_VAST_SKIPED", "1");
        }
        com.fyber.inneractive.sdk.player.c cVar3 = this.a;
        if (cVar3 != null && (gVar3 = cVar3.f1002b) != null) {
            gVar3.m();
            this.a.f1002b.k();
            if (z && (dVar = this.a.h) != null && dVar.c != null) {
                IAlog.a("%s skipped", "OMVideo");
                try {
                    dVar.c.skipped();
                } catch (Throwable th) {
                    dVar.a(th);
                }
            }
        }
        if (!this.d.f()) {
            this.d.a(false);
            j();
            D();
            this.k = false;
            this.h = true;
            b0 b0Var2 = this.f1023b;
            if (b0Var2 != null && (c0Var = ((a0) b0Var2).f) != null && c0Var.j == UnitDisplayType.REWARDED && (listenert = this.g) != null) {
                if (this.t && (cVar2 = this.a) != null && (gVar2 = cVar2.f1002b) != null) {
                    int iC = gVar2.c();
                    if (gVar2.d() - iC <= 0 || iC >= q() * 1000) {
                        this.g.onCompleted();
                    } else {
                        this.B = true;
                    }
                } else {
                    listenert.onCompleted();
                }
            }
        }
        if (this.g != null && (this.f <= 0 || this.h || ((cVar = this.a) != null && (gVar = cVar.f1002b) != null && gVar.e.equals(com.fyber.inneractive.sdk.player.enums.b.Completed)))) {
            this.g.a(z);
        }
        l();
    }

    public void g(boolean z) {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && (gVar = cVar.f1002b) != null) {
            gVar.b(z);
        }
        this.d.setMuteButtonState(true);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void h() {
        com.fyber.inneractive.sdk.player.ui.f fVar;
        com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
        if (lVar != null) {
            lVar.j();
        }
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && cVar.f1002b != null && (fVar = this.x) != null) {
            fVar.invalidate();
            this.x.requestLayout();
        }
        com.fyber.inneractive.sdk.player.ui.l lVar2 = this.d;
        if (lVar2 != null) {
            lVar2.invalidate();
            this.d.requestLayout();
        }
    }

    public void i(boolean z) {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar != null && (gVar = cVar.f1002b) != null) {
            gVar.d(z);
        }
        this.d.setMuteButtonState(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public com.fyber.inneractive.sdk.flow.vast.e c() {
        com.fyber.inneractive.sdk.flow.m mVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || (mVar = ((com.fyber.inneractive.sdk.player.e) cVar).z) == null) {
            return null;
        }
        return mVar.l;
    }

    public final void c(int i) {
        if (this.d != null) {
            com.fyber.inneractive.sdk.config.global.s sVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.c cVar = sVar != null ? (com.fyber.inneractive.sdk.config.global.features.c) sVar.a(com.fyber.inneractive.sdk.config.global.features.c.class) : null;
            if (cVar != null) {
                cVar.e(IAConfigManager.M.p);
                com.fyber.inneractive.sdk.model.vast.a aVar = cVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.c;
                }
            }
            if (TextUtils.isEmpty(this.y) && str != null) {
                this.d.setSkipText(str.replaceFirst("\\[TIME\\]", Integer.toString(i)));
            } else {
                this.d.setSkipText(String.valueOf(i));
            }
        }
    }

    public void a(boolean z, f fVar) {
        com.fyber.inneractive.sdk.util.m.a(new e(z, fVar));
    }

    public final void a(String str) {
        f0 f0Var = IAConfigManager.M.x;
        b0 b0Var = this.f1023b;
        if (b0Var != null) {
            a0 a0Var = (a0) b0Var;
            if (a0Var.f != null) {
                f0Var.a(a0Var.f.j, "LAST_VAST_CLICKED_TYPE", str);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g.f
    public void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("%sonPlayerStateChanged with %s", IAlog.a(this), bVar);
        a(bVar, true);
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar, boolean z) {
        ListenerT listenert;
        switch (a.a[bVar.ordinal()]) {
            case 1:
                if (this.r) {
                    this.d.b(true);
                    D();
                    z();
                }
                break;
            case 2:
                if (this.r) {
                    this.d.a(true);
                    this.d.c(false);
                    Runnable runnable = this.j;
                    if (runnable == null) {
                        if (runnable == null) {
                            this.j = new o(this);
                        }
                        int iO = o();
                        IAlog.a("%s Starting buffering timeout with %d", IAlog.a(this), Integer.valueOf(iO));
                        this.d.postDelayed(this.j, iO);
                    }
                }
                break;
            case 3:
                if (this.r) {
                    A();
                }
                break;
            case 4:
                x();
                break;
            case 5:
                if (this.r || (!this.z && !this.v)) {
                    this.v = true;
                    v();
                    if (z && (listenert = this.g) != null) {
                        listenert.onCompleted();
                        break;
                    }
                }
                break;
            case 6:
                if (this.r) {
                    c(false);
                }
                break;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public boolean d() {
        return this.z;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00b9  */
    @Override // com.fyber.inneractive.sdk.player.controller.g.e
    public void a(int i) {
        b0 b0Var;
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || cVar.f1002b == null) {
            return;
        }
        float fR = r();
        com.fyber.inneractive.sdk.player.c cVar2 = this.a;
        if (cVar2 != null && (gVar = cVar2.f1002b) != null && gVar.j()) {
            float f2 = this.i;
            if (fR != f2) {
                if (fR > 0.0f && f2 >= 0.0f && t()) {
                    i(true);
                } else if (fR == 0.0f && !t()) {
                    g(true);
                }
            }
            E();
        }
        this.i = fR;
        int iD = this.a.f1002b.d();
        int iC = this.a.f1002b.c();
        int i2 = iC / 1000;
        int i3 = iD / 1000;
        int i4 = i3 - i2;
        if (i4 < 0 || (!this.a.f1002b.j() && iC == iD)) {
            i4 = 0;
        }
        com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
        if (lVar.n == null && lVar.w == null) {
            return;
        }
        lVar.setRemainingTime(Integer.toString(i4));
        if (this.f < i3) {
            if (B()) {
                int iD2 = this.a.f1002b.d();
                com.fyber.inneractive.sdk.player.c cVar3 = this.a;
                if (com.fyber.inneractive.sdk.player.c.a(iD2, ((com.fyber.inneractive.sdk.player.e) cVar3).y, com.fyber.inneractive.sdk.player.c.a(cVar3)) && !this.h) {
                    int i5 = this.f;
                    if (i2 < i5) {
                        c(i5 - i2);
                    } else {
                        this.f = 0;
                        n();
                    }
                    this.d.d(true);
                } else {
                    this.d.d(false);
                }
            } else {
                this.d.d(false);
            }
        } else {
            this.d.d(false);
            c(i4);
        }
        if (this.a.f1002b.e != com.fyber.inneractive.sdk.player.enums.b.Paused) {
            com.fyber.inneractive.sdk.player.ui.l lVar2 = this.d;
            if (lVar2.w != null) {
                Runnable runnable = lVar2.F;
                if (runnable != null) {
                    lVar2.removeCallbacks(runnable);
                    lVar2.F = null;
                }
                int i6 = i3 * 1000;
                lVar2.w.setMax(i6);
                int i7 = i6 - (i4 * 1000);
                int i8 = i7 + 1000;
                lVar2.E = i8;
                int i9 = i7 + 200;
                if (i8 > 0 && i8 <= i6) {
                    int i10 = lVar2.D;
                    if (i9 < i10 && i10 > 0) {
                        lVar2.w.setProgress(i8);
                    } else {
                        lVar2.D = i9;
                        lVar2.w.setProgress(i9);
                        com.fyber.inneractive.sdk.player.ui.n nVar = new com.fyber.inneractive.sdk.player.ui.n(lVar2);
                        lVar2.F = nVar;
                        lVar2.postDelayed(nVar, 200L);
                    }
                }
            }
            int iQ = q();
            if (i3 > iQ && i2 > iQ && (b0Var = this.f1023b) != null) {
                a0 a0Var = (a0) b0Var;
                if (a0Var.f != null && a0Var.f.j == UnitDisplayType.REWARDED) {
                    n();
                    this.d.d(true);
                }
            }
        }
        ListenerT listenert = this.g;
        if (listenert != null) {
            listenert.onProgress(iD, iC);
        }
    }

    public void a(boolean z) {
        com.fyber.inneractive.sdk.player.c cVar;
        g gVar;
        g.InterfaceC0279g interfaceC0279g;
        com.fyber.inneractive.sdk.player.ui.l lVar;
        Application application;
        if (this.r == z || (cVar = this.a) == null || cVar.f1002b == null) {
            return;
        }
        IAlog.a("%sonVisibilityChanged: %s my video view is%s", IAlog.a(this), Boolean.valueOf(z), this.d);
        if (z) {
            this.r = true;
            com.fyber.inneractive.sdk.player.enums.b bVar = this.a.f1002b.e;
            if (!bVar.equals(com.fyber.inneractive.sdk.player.enums.b.Completed) && !this.d.f()) {
                if (!bVar.equals(com.fyber.inneractive.sdk.player.enums.b.Error)) {
                    if (!bVar.equals(com.fyber.inneractive.sdk.player.enums.b.Idle)) {
                        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Start_in_progress || bVar == com.fyber.inneractive.sdk.player.enums.b.Playing) {
                            A();
                        }
                        com.fyber.inneractive.sdk.player.c cVar2 = this.a;
                        if (!cVar2.p) {
                            com.fyber.inneractive.sdk.player.e eVar = (com.fyber.inneractive.sdk.player.e) cVar2;
                            eVar.a(eVar.v, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.t.EVENT_CREATIVE_VIEW);
                            cVar2.p = true;
                        }
                        k();
                        if (this.m != null || (application = com.fyber.inneractive.sdk.util.l.a) == null) {
                            return;
                        }
                        q qVar = new q(this);
                        this.m = qVar;
                        application.registerActivityLifecycleCallbacks(qVar);
                        return;
                    }
                    this.a.getClass();
                }
                c(false);
                return;
            }
            if (!this.v) {
                this.v = true;
                if (!this.B) {
                    v();
                    ListenerT listenert = this.g;
                    if (listenert != null) {
                        listenert.onCompleted();
                    }
                }
            }
            com.fyber.inneractive.sdk.player.ui.l lVar2 = this.d;
            if (lVar2 == null || lVar2.G == null) {
                return;
            }
            IAlog.a("Autoclick resumed", new Object[0]);
            lVar2.G.b();
            return;
        }
        this.r = false;
        com.fyber.inneractive.sdk.player.c cVar3 = this.a;
        if (cVar3 != null && (gVar = cVar3.f1002b) != null && (interfaceC0279g = gVar.d) != null && interfaceC0279g.equals(this.e)) {
            IAlog.a("%sonVisibilityChanged pausing video", IAlog.a(this));
            pauseVideo();
            if (this.a.f1002b.e == com.fyber.inneractive.sdk.player.enums.b.Completed || ((lVar = this.d) != null && lVar.f())) {
                com.fyber.inneractive.sdk.player.ui.l lVar3 = this.d;
                if (lVar3.G != null) {
                    IAlog.a("Autoclick paused", new Object[0]);
                    lVar3.G.a();
                }
            }
        }
        l();
    }

    public void a(int i, k0 k0Var) {
        String str;
        IAlog.a("onClicked called with %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                if (t()) {
                    i(true);
                    com.fyber.inneractive.sdk.player.c cVar = this.a;
                    if (cVar != null) {
                        com.fyber.inneractive.sdk.player.e eVar = (com.fyber.inneractive.sdk.player.e) cVar;
                        eVar.a(eVar.v, VideoClickOrigin.MUTE, com.fyber.inneractive.sdk.model.vast.t.EVENT_UNMUTE);
                    }
                } else {
                    g(true);
                    com.fyber.inneractive.sdk.player.c cVar2 = this.a;
                    if (cVar2 != null) {
                        com.fyber.inneractive.sdk.player.e eVar2 = (com.fyber.inneractive.sdk.player.e) cVar2;
                        eVar2.a(eVar2.v, VideoClickOrigin.MUTE, com.fyber.inneractive.sdk.model.vast.t.EVENT_MUTE);
                    }
                }
                E();
                break;
            case 2:
                y();
                break;
            case 3:
                a(f0.b.CTA_BUTTON.value);
                a(false, VideoClickOrigin.CTA, k0Var);
                break;
            case 4:
                a(f0.b.COMPANION.value);
                com.fyber.inneractive.sdk.player.c cVar3 = this.a;
                com.fyber.inneractive.sdk.model.vast.c cVarC = cVar3 != null ? cVar3.c() : null;
                if (cVarC == null || cVarC.a != com.fyber.inneractive.sdk.model.vast.h.Static) {
                    str = null;
                } else {
                    str = cVarC.g;
                    com.fyber.inneractive.sdk.player.c cVar4 = this.a;
                    if (cVar4 != null) {
                        cVar4.a(cVarC, VideoClickOrigin.COMPANION, com.fyber.inneractive.sdk.model.vast.t.EVENT_CLICK);
                    }
                }
                m();
                ListenerT listenert = this.g;
                if (listenert != null) {
                    listenert.a(str, k0Var, null, false);
                }
                break;
            case 5:
                w();
                break;
            case 6:
                c(true);
                break;
            case 7:
                a(k0Var);
                break;
            case 8:
                a(f0.b.COMPANION.value);
                a(true, VideoClickOrigin.COMPANION, k0Var);
                break;
            case 9:
                com.fyber.inneractive.sdk.player.c cVar5 = this.a;
                if (cVar5 != null && !this.d.h) {
                    cVar5.j = true;
                    h(false);
                    break;
                }
                break;
            case 10:
                a(f0.b.APP_INFO.value);
                a(false, VideoClickOrigin.APP_INFO, k0Var);
                break;
        }
    }

    public boolean a(boolean z, VideoClickOrigin videoClickOrigin, k0 k0Var) {
        com.fyber.inneractive.sdk.util.e eVar;
        m();
        ListenerT listenert = this.g;
        boolean z2 = true;
        if (listenert == null) {
            z2 = false;
        } else {
            if (z) {
                com.fyber.inneractive.sdk.player.c cVar = this.a;
                if (cVar != null) {
                    com.fyber.inneractive.sdk.model.vast.b bVar = ((com.fyber.inneractive.sdk.player.e) cVar).v;
                    listenert.a(bVar != null ? bVar.f959b : null, k0Var, null, true);
                    com.fyber.inneractive.sdk.player.e eVar2 = (com.fyber.inneractive.sdk.player.e) this.a;
                    eVar2.a(eVar2.v, videoClickOrigin, com.fyber.inneractive.sdk.model.vast.t.EVENT_CLICK);
                }
            } else {
                if (videoClickOrigin == VideoClickOrigin.VIDEO) {
                    eVar = com.fyber.inneractive.sdk.util.e.VIDEO_CLICK;
                } else {
                    eVar = videoClickOrigin == VideoClickOrigin.APP_INFO ? com.fyber.inneractive.sdk.util.e.VIDEO_APP_INFO : com.fyber.inneractive.sdk.util.e.VIDEO_CTA;
                }
                x.a aVarA = listenert.a(k0Var, eVar);
                com.fyber.inneractive.sdk.player.c cVar2 = this.a;
                if (cVar2 != null) {
                    com.fyber.inneractive.sdk.player.e eVar3 = (com.fyber.inneractive.sdk.player.e) cVar2;
                    eVar3.a(eVar3.v, videoClickOrigin, com.fyber.inneractive.sdk.model.vast.t.EVENT_CLICK);
                    com.fyber.inneractive.sdk.measurement.d dVar = this.a.h;
                    if (dVar != null && dVar.c != null) {
                        IAlog.a("%s click", "OMVideo");
                        try {
                            dVar.c.adUserInteraction(InteractionType.CLICK);
                        } catch (Throwable th) {
                            dVar.a(th);
                        }
                    }
                }
                if (aVarA.a == x.d.FAILED) {
                }
            }
            z2 = false;
        }
        if (videoClickOrigin == VideoClickOrigin.VIDEO) {
            a(f0.b.VIDEO.value);
        }
        return z2;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void a(com.fyber.inneractive.sdk.model.vast.h hVar, int i) {
        com.fyber.inneractive.sdk.config.global.s sVar;
        com.fyber.inneractive.sdk.flow.vast.c cVar;
        com.fyber.inneractive.sdk.web.b bVar;
        com.fyber.inneractive.sdk.flow.m mVar;
        com.fyber.inneractive.sdk.model.vast.c cVar2;
        com.fyber.inneractive.sdk.player.c cVar3 = this.a;
        if (cVar3 != null) {
            com.fyber.inneractive.sdk.player.e eVar = (com.fyber.inneractive.sdk.player.e) cVar3;
            eVar.getClass();
            IAlog.a("notifyCompanionDisplayed", new Object[0]);
            int i2 = com.fyber.inneractive.sdk.player.e.b.a[hVar.ordinal()];
            if (i2 == 1) {
                if (eVar.A) {
                    return;
                }
                com.fyber.inneractive.sdk.network.r rVar = com.fyber.inneractive.sdk.network.r.VAST_DEFAULT_COMPANION_DISPLAYED;
                InneractiveAdRequest inneractiveAdRequest = eVar.f;
                com.fyber.inneractive.sdk.flow.f0 f0Var = eVar.e;
                new com.fyber.inneractive.sdk.network.s.a(rVar, inneractiveAdRequest, f0Var != null ? (com.fyber.inneractive.sdk.response.g) f0Var.f927b : null, (f0Var == null || (sVar = f0Var.c) == null) ? null : sVar.c()).a((String) null);
                eVar.A = true;
                return;
            }
            if (i2 != 2) {
                if (eVar.b() == null || (mVar = eVar.z) == null || mVar.g || (cVar2 = eVar.v.h) == null) {
                    return;
                }
                eVar.a(cVar2, VideoClickOrigin.COMPANION, com.fyber.inneractive.sdk.model.vast.t.EVENT_CREATIVE_VIEW);
                com.fyber.inneractive.sdk.flow.m mVar2 = eVar.z;
                if (!mVar2.g) {
                    com.fyber.inneractive.sdk.network.r rVar2 = com.fyber.inneractive.sdk.network.r.VAST_COMPANION_DISPLAYED;
                    InneractiveAdRequest inneractiveAdRequest2 = mVar2.f924b;
                    com.fyber.inneractive.sdk.response.g gVar = mVar2.c;
                    com.fyber.inneractive.sdk.config.global.s sVar2 = mVar2.d;
                    com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(rVar2, inneractiveAdRequest2, gVar, sVar2 == null ? null : sVar2.c());
                    aVar.a("companion_data", mVar2.e.h.a());
                    aVar.a((String) null);
                }
                mVar2.g = true;
                return;
            }
            com.fyber.inneractive.sdk.flow.m mVar3 = eVar.z;
            if (mVar3 == null || (cVar = mVar3.l) == null) {
                return;
            }
            cVar.c = true;
            InneractiveAdRequest inneractiveAdRequest3 = mVar3.f924b;
            com.fyber.inneractive.sdk.response.g gVar2 = mVar3.c;
            com.fyber.inneractive.sdk.config.global.s sVar3 = mVar3.d;
            cVar.d = i;
            c0 c0Var = cVar.g.a;
            cVar.e = (!(c0Var instanceof com.fyber.inneractive.sdk.web.c) || (bVar = ((com.fyber.inneractive.sdk.web.c) c0Var).N) == null) ? null : bVar.f1355b;
            if (cVar.h) {
                return;
            }
            com.fyber.inneractive.sdk.network.s.a aVar2 = new com.fyber.inneractive.sdk.network.s.a(com.fyber.inneractive.sdk.network.r.FMP_COMPANION_SUCCESSFULLY_SHOWN, inneractiveAdRequest3, gVar2, sVar3 == null ? null : sVar3.c());
            cVar.a(aVar2);
            aVar2.a((String) null);
            cVar.h = true;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void a(com.fyber.inneractive.sdk.player.controller.c cVar) {
        s sVar = new s(this);
        c0 c0Var = cVar.a;
        if (c0Var != null) {
            c0Var.setListener(sVar);
        }
    }

    public static boolean a(n nVar) {
        return nVar.c() != null && nVar.c().c;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void a(Bitmap bitmap) {
        g gVar;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        if (cVar == null || (gVar = cVar.f1002b) == null || gVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed) {
            return;
        }
        this.d.a(cVar.j);
        this.d.b(true);
        this.d.setLastFrameBitmap(bitmap);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void a(long j) {
        View view;
        com.fyber.inneractive.sdk.player.c cVar = this.a;
        View viewB = cVar != null ? cVar.b() : null;
        com.fyber.inneractive.sdk.player.ui.l lVar = this.d;
        boolean z = viewB == null;
        ObjectAnimator objectAnimator = lVar.L;
        if (objectAnimator != null) {
            if (objectAnimator.getDuration() <= j) {
                ViewGroup viewGroup = lVar.z;
                if (viewGroup != null) {
                    lVar.a((View) viewGroup.getParent(), 4);
                }
                lVar.L.start();
                lVar.L.addListener(new com.fyber.inneractive.sdk.player.ui.m(lVar));
            } else {
                lVar.M = true;
                lVar.L = null;
                ViewGroup viewGroup2 = lVar.z;
                if (viewGroup2 != null && viewGroup2.getParent() != null) {
                    ((View) lVar.z.getParent()).setOnTouchListener(null);
                }
            }
            if (z && (view = lVar.y) != null) {
                view.setVisibility(0);
                return;
            }
            ViewGroup viewGroup3 = lVar.z;
            if (viewGroup3 != null) {
                viewGroup3.setVisibility(0);
            }
        }
    }

    public void a(com.fyber.inneractive.sdk.player.ui.l lVar, Bitmap bitmap, boolean z, boolean z2) {
        if (bitmap == null) {
            IAlog.a("IAVideoUIControllerBase : Unable set bitmap it is null", new Object[0]);
            return;
        }
        if (lVar == null) {
            IAlog.a("IAVideoUIControllerBase : Unable set last frame", new Object[0]);
            return;
        }
        lVar.setLastFrameBitmap(bitmap);
        if (z) {
            lVar.b(z2);
        }
    }
}
