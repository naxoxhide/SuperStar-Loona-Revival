package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.iab.omid.library.mmadbridge.ScriptInjector;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.n;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.videocommon.download.g;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SplashLoadManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static String a = "SplashLoadManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2428b;
    private String c;
    private long d;
    private long e;
    private com.mbridge.msdk.splash.d.b f;
    private MBSplashView h;
    private f i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private String n;
    private int o;
    private boolean p;
    private volatile boolean q;
    private com.mbridge.msdk.videocommon.listener.a r;
    private g.d s;
    private String t;
    private int u;
    private int w;
    private String v = "";
    private Handler x = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.splash.c.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) throws Throwable {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                int i2 = message.arg1;
                if (obj instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) obj;
                    c.this.a(g.a().b(campaignEx.getAdZip()), campaignEx, i2);
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 instanceof CampaignEx) {
                    c cVar = c.this;
                    cVar.b((CampaignEx) obj2, cVar.o);
                    return;
                }
                return;
            }
            Object obj3 = message.obj;
            try {
                if (obj3 instanceof Bundle) {
                    String string = ((Bundle) obj3).getString("msg");
                    CampaignEx campaignEx2 = (CampaignEx) ((Bundle) obj3).getSerializable("campaignex");
                    com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(6, string);
                    c cVar2 = c.this;
                    cVar2.a(eVar, cVar2.n, c.this.o, campaignEx2);
                }
            } catch (Exception e) {
                com.mbridge.msdk.foundation.entity.e eVar2 = new com.mbridge.msdk.foundation.entity.e(6, e.getMessage());
                c cVar3 = c.this;
                cVar3.a(eVar2, cVar3.n, c.this.o, (CampaignEx) null);
            }
        }
    };
    private Runnable y = new Runnable() { // from class: com.mbridge.msdk.splash.c.c.2
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(2, "load timeout");
            c cVar = c.this;
            cVar.a(eVar, cVar.n, c.this.o, (CampaignEx) null);
        }
    };
    private Context g = com.mbridge.msdk.foundation.controller.b.d().g();

    public c(String str, String str2, long j) {
        this.c = str;
        this.f2428b = str2;
        this.e = j;
    }

    public final void a(f fVar) {
        this.i = fVar;
    }

    public final void a(MBSplashView mBSplashView) {
        this.h = mBSplashView;
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final void a(int i) {
        this.k = i;
    }

    public final void a(int i, int i2) {
        this.m = i;
        this.l = i2;
    }

    public final void b(int i) {
        this.w = i;
    }

    public final String a() {
        return this.v;
    }

    public final void a(String str, int i) throws Throwable {
        this.q = false;
        this.n = str;
        this.o = i;
        CampaignEx campaignExA = b.a(this.h, this.c, this.f2428b, str, this.j, this.k, false, false);
        long timestamp = campaignExA != null ? campaignExA.getTimestamp() : 0L;
        if (this.i.n() == 1 && i != 1 && campaignExA != null) {
            a(campaignExA, i);
            return;
        }
        this.p = true;
        if (i == 1) {
            List<Integer> listS = this.i.s();
            if (listS != null && listS.size() > 0) {
                this.d = listS.get(0).intValue() * 1000;
            } else {
                this.d = 30000L;
            }
        } else {
            long j = this.e;
            if (j <= 0) {
                this.d = this.i.o();
            } else {
                this.d = j;
            }
        }
        if (this.i == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
            a(this.d);
            a(this.g, str, i);
            return;
        }
        if (System.currentTimeMillis() - timestamp > this.i.x() * 1000) {
            a(this.d);
            a(this.g, str, i);
        } else {
            a(campaignExA, i);
        }
    }

    private void a(long j) {
        this.x.postDelayed(this.y, j);
    }

    private void a(Context context, final String str, final int i) throws Throwable {
        try {
            if (context == null) {
                a(new com.mbridge.msdk.foundation.entity.e(0, "Context is null"), str, i, (CampaignEx) null);
                return;
            }
            if (ak.a(this.f2428b)) {
                a(new com.mbridge.msdk.foundation.entity.e(0, "UnitId is null"), str, i, (CampaignEx) null);
                return;
            }
            com.mbridge.msdk.foundation.same.net.g.d dVarA = a(i, this.t);
            if (dVarA == null) {
                a(new com.mbridge.msdk.foundation.entity.e(0, "Load param is null"), str, i, (CampaignEx) null);
                return;
            }
            if (dVarA != null && !TextUtils.isEmpty(str)) {
                dVarA.a(BidResponsed.KEY_TOKEN, str);
            }
            String strH = af.h(this.f2428b);
            if (!TextUtils.isEmpty(strH)) {
                dVarA.a("j", strH);
            }
            com.mbridge.msdk.splash.f.b bVar = new com.mbridge.msdk.splash.f.b(context);
            com.mbridge.msdk.splash.f.a aVar = new com.mbridge.msdk.splash.f.a(i) { // from class: com.mbridge.msdk.splash.c.c.3
                @Override // com.mbridge.msdk.splash.f.a
                public final void a(CampaignUnit campaignUnit, int i2) throws Throwable {
                    try {
                        c cVar = c.this;
                        c.a(cVar, campaignUnit, i2, cVar.f2428b, str);
                        c.this.v = campaignUnit.getRequestId();
                    } catch (Exception e) {
                        e.printStackTrace();
                        c.this.a(new com.mbridge.msdk.foundation.entity.e(3, "Exception after load success"), str, i2, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
                        c.this.u = 0;
                    }
                }

                @Override // com.mbridge.msdk.splash.f.a
                public final void a(int i2, String str2) throws Throwable {
                    aa.d(c.a, str2);
                    c.this.a(new com.mbridge.msdk.foundation.entity.e(3, str2), str, i, (CampaignEx) null);
                    c.this.u = 0;
                }
            };
            aVar.a(str);
            aVar.setUnitId(this.f2428b);
            aVar.setPlacementId(this.c);
            aVar.setAdType(297);
            bVar.choiceV3OrV5BySetting(1, dVarA, aVar, str);
        } catch (Exception e) {
            e.printStackTrace();
            a(new com.mbridge.msdk.foundation.entity.e(1, e.getMessage()), str, i, (CampaignEx) null);
            this.u = 0;
        }
    }

    private com.mbridge.msdk.foundation.same.net.g.d a(int i, String str) {
        String strH = com.mbridge.msdk.foundation.controller.b.d().h();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.b.d().h() + com.mbridge.msdk.foundation.controller.b.d().j());
        com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
        String strA = com.mbridge.msdk.foundation.same.a.d.a(this.f2428b, "splash");
        String strB = af.b(this.g, this.f2428b);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "app_id", strH);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f2428b);
        if (!TextUtils.isEmpty(this.c)) {
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PLACEMENT_ID, this.c);
        }
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "req_type", i + "");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_num", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "tnum", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.f2148b, strA);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.c, strB);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.a, str);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_type", "297");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "offset", this.u + "");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, CampaignUnit.JSON_KEY_UNIT_SIZE, this.m + "x" + this.l);
        return dVar;
    }

    public final void a(com.mbridge.msdk.splash.d.b bVar) {
        this.f = bVar;
    }

    public final void b() {
        if (this.f != null) {
            this.f = null;
        }
        if (this.r != null) {
            this.r = null;
        }
        if (this.s != null) {
            this.s = null;
        }
    }

    private void a(CampaignEx campaignEx, int i) throws Throwable {
        MBSplashView mBSplashView = this.h;
        if (mBSplashView != null) {
            mBSplashView.setDynamicView(false);
        }
        if (campaignEx.isDynamicView()) {
            d(campaignEx, i);
        }
        if (b.a(this.h, campaignEx)) {
            b(campaignEx, i);
        } else {
            c(campaignEx, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx, int i) {
        if (!b.a(this.h, campaignEx) || this.q) {
            return;
        }
        d();
        if (this.p) {
            b.a(campaignEx, this.f2428b);
        }
        this.q = true;
        com.mbridge.msdk.splash.d.b bVar = this.f;
        if (bVar != null) {
            bVar.a(campaignEx, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.entity.e eVar, String str, int i, CampaignEx campaignEx) throws Throwable {
        if (this.p) {
            this.p = false;
            a(eVar, i, str, campaignEx);
        } else {
            a(eVar, i, campaignEx);
        }
    }

    private void a(com.mbridge.msdk.foundation.entity.e eVar, int i, String str, CampaignEx campaignEx) throws Throwable {
        CampaignEx campaignExA = b.a(this.h, this.c, this.f2428b, str, this.j, this.k, true, false);
        if (campaignExA != null) {
            a(campaignExA, i);
        } else {
            a(eVar, i, campaignEx);
        }
    }

    private void a(com.mbridge.msdk.foundation.entity.e eVar, int i, CampaignEx campaignEx) {
        if (this.q) {
            return;
        }
        d();
        this.q = true;
        com.mbridge.msdk.splash.d.b bVar = this.f;
        if (bVar != null) {
            bVar.a(eVar, i, campaignEx);
        }
    }

    private void d() {
        this.x.removeCallbacks(this.y);
    }

    private void c(CampaignEx campaignEx, int i) throws Throwable {
        this.h.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            f(campaignEx, i);
        }
        if (campaignEx.isDynamicView()) {
            return;
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            e(campaignEx, i);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            g(campaignEx, i);
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return;
        }
        d(campaignEx, i);
    }

    private void d(final CampaignEx campaignEx, final int i) {
        b.a(this.h, campaignEx, new com.mbridge.msdk.splash.view.nativeview.a() { // from class: com.mbridge.msdk.splash.c.c.4
            @Override // com.mbridge.msdk.splash.view.nativeview.a
            public final void a() {
                if (campaignEx.isDynamicView() && c.this.h != null) {
                    c.this.h.setImageReady(true);
                    c.b(c.this, campaignEx, i);
                }
                c.this.b(campaignEx, i);
            }

            @Override // com.mbridge.msdk.splash.view.nativeview.a
            public final void b() throws Throwable {
                if (!campaignEx.isDynamicView() || c.this.h == null) {
                    return;
                }
                c.this.h.setImageReady(false);
                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(4, "Image resource load faile");
                c cVar = c.this;
                cVar.a(eVar, cVar.n, i, campaignEx);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:25:0x009f A[Catch: Exception -> 0x0105, PHI: r3 r7
      0x009f: PHI (r3v2 java.io.FileOutputStream) = (r3v3 java.io.FileOutputStream), (r3v5 java.io.FileOutputStream) binds: [B:36:0x00bb, B:24:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x009f: PHI (r7v1 java.io.File) = (r7v3 java.io.File), (r7v7 java.io.File) binds: [B:36:0x00bb, B:24:0x009d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0105, blocks: (B:47:0x0101, B:48:0x0104, B:38:0x00be, B:40:0x00c4, B:42:0x00ca, B:44:0x00d0, B:45:0x00f2, B:25:0x009f), top: B:54:0x0006 }] */
    private void e(CampaignEx campaignEx, int i) throws Throwable {
        File file;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    File file2 = new File(campaignEx.getAdHtml());
                    try {
                        if (file2.exists()) {
                            file = file2;
                        } else {
                            String strB = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
                            String md5 = SameMD5.getMD5(al.a(campaignEx.getAdHtml()));
                            if (TextUtils.isEmpty(md5)) {
                                md5 = String.valueOf(System.currentTimeMillis());
                            }
                            file = new File(strB, md5.concat(".html"));
                            try {
                                if (!file.exists()) {
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("<script>").append(com.mbridge.msdk.c.b.a.a().b()).append("</script>");
                                        sb.append(campaignEx.getAdHtml());
                                        String strInjectScriptContentIntoHtml = ScriptInjector.injectScriptContentIntoHtml(MBridgeConstans.OMID_JS_SERVICE_CONTENT, sb.toString());
                                        if (campaignEx.isActiveOm()) {
                                            strInjectScriptContentIntoHtml = com.mbridge.msdk.a.b.c(strInjectScriptContentIntoHtml);
                                        }
                                        fileOutputStream2.write(strInjectScriptContentIntoHtml.getBytes());
                                        fileOutputStream2.flush();
                                        fileOutputStream = fileOutputStream2;
                                    } catch (Exception e) {
                                        e = e;
                                        fileOutputStream = fileOutputStream2;
                                        e.printStackTrace();
                                        campaignEx.setMraid("");
                                        n.a(campaignEx, e.getMessage(), this.f2428b, "6");
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        n.a(campaignEx, "", this.f2428b, "6");
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        file = file2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                file = null;
            }
            if (file.exists() && file.isFile() && file.canRead()) {
                campaignEx.setAdHtml(file.getAbsolutePath());
                a("file:////" + file.getAbsolutePath(), campaignEx, i);
            } else {
                a(new com.mbridge.msdk.foundation.entity.e(4, "html file write failed"), this.n, i, campaignEx);
            }
        } catch (Exception e5) {
            a(new com.mbridge.msdk.foundation.entity.e(4, e5.getMessage()), this.n, i, campaignEx);
        }
    }

    private void f(final CampaignEx campaignEx, final int i) {
        if (campaignEx.isDynamicView()) {
            k.a(campaignEx.getAdZip());
        } else {
            this.s = new g.d() { // from class: com.mbridge.msdk.splash.c.c.5
                @Override // com.mbridge.msdk.videocommon.download.g.a
                public final void a(String str, boolean z) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 1;
                    messageObtain.obj = campaignEx;
                    messageObtain.arg1 = i;
                    c.this.x.sendMessage(messageObtain);
                }

                @Override // com.mbridge.msdk.videocommon.download.g.a
                public final void a(String str, String str2) throws Throwable {
                    com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(6, str);
                    c cVar = c.this;
                    cVar.a(eVar, cVar.n, i, campaignEx);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 2;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("campaignex", campaignEx);
                    bundle.putString("msg", str);
                    messageObtain.obj = bundle;
                    c.this.x.sendMessage(messageObtain);
                }
            };
            g.a().b(campaignEx.getAdZip(), this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final CampaignEx campaignEx, final int i) {
        e.c cVar = new e.c();
        cVar.c(this.f2428b);
        cVar.b(this.c);
        cVar.a(campaignEx);
        cVar.a(str);
        cVar.a(this.j);
        cVar.a(this.k);
        e.a.a.a(this.h, cVar, new e.b() { // from class: com.mbridge.msdk.splash.c.c.7
            @Override // com.mbridge.msdk.splash.c.e.b
            public final void a() {
                if (campaignEx.isHasMBTplMark()) {
                    return;
                }
                c.c(c.this, campaignEx, i);
            }

            @Override // com.mbridge.msdk.splash.c.e.b
            public final void a(String str2) throws Throwable {
                c.a(c.this, str2, i, campaignEx);
            }

            @Override // com.mbridge.msdk.splash.c.e.b
            public final void a(int i2) throws Throwable {
                if (i2 == 1) {
                    c.c(c.this, campaignEx, i);
                } else {
                    c.a(c.this, "readyState 2", i, campaignEx);
                }
            }
        });
    }

    private void g(final CampaignEx campaignEx, int i) {
        this.r = new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.splash.c.c.8
            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str) {
                c.this.h.setVideoReady(true);
                Message messageObtain = Message.obtain();
                messageObtain.obj = campaignEx;
                messageObtain.what = 3;
                c.this.x.sendMessage(messageObtain);
            }

            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str, String str2) throws Throwable {
                c.this.h.setVideoReady(false);
                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(4, str);
                c cVar = c.this;
                cVar.a(eVar, cVar.n, c.this.o, campaignEx);
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putSerializable("campaignex", campaignEx);
                bundle.putString("msg", str);
                messageObtain.obj = bundle;
                messageObtain.what = 2;
                c.this.x.sendMessage(messageObtain);
            }
        };
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.c.getInstance().createUnitCache(this.g, this.f2428b, copyOnWriteArrayList, 297, this.r);
        if (!com.mbridge.msdk.videocommon.download.c.getInstance().a(297, this.f2428b, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.c.getInstance().load(this.f2428b);
        } else {
            this.h.setVideoReady(true);
            b(campaignEx, i);
        }
    }

    static /* synthetic */ void a(c cVar, CampaignUnit campaignUnit, int i, String str, String str2) throws Throwable {
        ArrayList arrayList;
        CampaignEx campaignEx = null;
        boolean z = true;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            CampaignEx campaignEx2 = campaignUnit.getAds().get(0);
            campaignEx2.setCampaignUnitId(cVar.f2428b);
            cVar.t = campaignUnit.getSessionId();
            if (campaignEx2.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx2.getAdZip()) || !TextUtils.isEmpty(campaignEx2.getAdHtml()))) {
                if (af.b(campaignEx2)) {
                    campaignEx2.setRtinsType(af.c(cVar.g, campaignEx2.getPackageName()) ? 1 : 2);
                }
                if (campaignEx2.getWtick() == 1 || !af.c(cVar.g, campaignEx2.getPackageName()) || af.b(campaignEx2)) {
                    arrayList.add(campaignEx2);
                } else {
                    af.a(cVar.f2428b, campaignEx2, com.mbridge.msdk.foundation.same.a.w);
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(11, "APP ALREADY INSTALLED");
            if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() != 0) {
                campaignEx = campaignUnit.getAds().get(0);
            }
            cVar.a(eVar, str2, i, campaignEx);
            try {
                if (TextUtils.isEmpty(str2)) {
                    z = false;
                }
                q.a(com.mbridge.msdk.foundation.controller.b.d().g(), eVar, str, z, campaignUnit);
                return;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        try {
            int i2 = cVar.u + 1;
            cVar.u = i2;
            f fVar = cVar.i;
            if (fVar == null || i2 > fVar.v()) {
                cVar.u = 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        CampaignEx campaignEx3 = (CampaignEx) arrayList.get(0);
        if (!TextUtils.isEmpty(campaignEx3.getAdZip()) || (!TextUtils.isEmpty(campaignEx3.getAdHtml()) && campaignEx3.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx3.setHasMBTplMark(true);
            campaignEx3.setIsMraid(false);
        } else {
            campaignEx3.setHasMBTplMark(false);
            campaignEx3.setIsMraid(true);
        }
        cVar.a(campaignEx3, i);
    }

    static /* synthetic */ void b(c cVar, final CampaignEx campaignEx, final int i) {
        if (campaignEx.isDynamicView()) {
            com.mbridge.msdk.splash.a.c.a aVar = new com.mbridge.msdk.splash.a.c.a();
            aVar.b(cVar.f2428b).a(cVar.c).a(cVar.j).a(campaignEx).a(cVar.k).h(cVar.w);
            try {
                if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
                    Uri uri = Uri.parse(campaignEx.getAdZip());
                    String queryParameter = uri.getQueryParameter("hdbtn");
                    String queryParameter2 = uri.getQueryParameter("alecfc");
                    String queryParameter3 = uri.getQueryParameter("hdinfo");
                    String queryParameter4 = uri.getQueryParameter("shake_show");
                    String queryParameter5 = uri.getQueryParameter("shake_strength");
                    String queryParameter6 = uri.getQueryParameter("shake_time");
                    String queryParameter7 = uri.getQueryParameter("n_logo");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        aVar.b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        aVar.c(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        aVar.d(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        aVar.e(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        aVar.f(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        aVar.g(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        aVar.i(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th) {
                aa.d(a, th.getMessage());
            }
            a.C0511a.a.a(cVar.h, new com.mbridge.msdk.splash.a.c(aVar), new com.mbridge.msdk.splash.b.a() { // from class: com.mbridge.msdk.splash.c.c.6
                @Override // com.mbridge.msdk.splash.b.a
                public final void a(View view) {
                    if (c.this.h != null) {
                        c.this.h.setDynamicView(true);
                        c.this.h.setSplashNativeView(view);
                        c.this.b(campaignEx, i);
                    }
                }

                @Override // com.mbridge.msdk.splash.b.a
                public final void a(String str) throws Throwable {
                    com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(9, str);
                    c cVar2 = c.this;
                    cVar2.a(eVar, cVar2.n, i, campaignEx);
                }
            });
        }
    }

    static /* synthetic */ void c(c cVar, CampaignEx campaignEx, int i) {
        if (cVar.h.isH5Ready()) {
            return;
        }
        cVar.h.setH5Ready(true);
        cVar.b(campaignEx, i);
    }

    static /* synthetic */ void a(c cVar, String str, int i, CampaignEx campaignEx) throws Throwable {
        cVar.a(new com.mbridge.msdk.foundation.entity.e(9, str), cVar.n, i, campaignEx);
    }
}
