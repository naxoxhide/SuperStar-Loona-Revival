package com.mbridge.msdk.advanced.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.ScriptInjector;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.n;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.videocommon.download.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static String a = "NativeAdvancedLoadManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1869b;
    private String c;
    private long d;
    private com.mbridge.msdk.advanced.b.b e;
    private MBNativeAdvancedView g;
    private f h;
    private CampaignEx i;
    private int j;
    private int k;
    private int l;
    private int m;
    private String n;
    private int o;
    private boolean p;
    private volatile boolean q;
    private com.mbridge.msdk.videocommon.listener.a r;
    private g.d s;
    private g.d t;
    private String u;
    private int v;
    private String w = "";
    private Handler x = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.advanced.a.a.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj2 = message.obj;
                int i2 = message.arg1;
                if (obj2 == null || !(obj2 instanceof CampaignEx)) {
                    return;
                }
                CampaignEx campaignEx = (CampaignEx) obj2;
                a.a(a.this, g.a().b(campaignEx.getAdZip()), campaignEx, i2);
                return;
            }
            if (i == 2) {
                Object obj3 = message.obj;
                try {
                    if (obj3 instanceof Bundle) {
                        String string = ((Bundle) obj3).getString("msg");
                        CampaignEx campaignEx2 = (CampaignEx) ((Bundle) obj3).getSerializable("campaignex");
                        e eVar = new e(6, string);
                        a aVar = a.this;
                        aVar.a(eVar, aVar.n, a.this.o, campaignEx2);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e eVar2 = new e(6, e.getMessage());
                    a aVar2 = a.this;
                    aVar2.a(eVar2, aVar2.n, a.this.o, (CampaignEx) null);
                    return;
                }
            }
            if (i == 3) {
                Object obj4 = message.obj;
                if (obj4 == null || !(obj4 instanceof CampaignEx)) {
                    return;
                }
                a aVar3 = a.this;
                aVar3.b((CampaignEx) obj4, aVar3.o);
                return;
            }
            if (i == 4) {
                Object obj5 = message.obj;
                if (obj5 == null || !(obj5 instanceof CampaignEx)) {
                    return;
                }
                if (a.this.g != null) {
                    a.this.g.setEndCardReady(true);
                }
                a aVar4 = a.this;
                aVar4.b((CampaignEx) obj5, aVar4.o);
                return;
            }
            if (i == 5 && (obj = message.obj) != null && (obj instanceof CampaignEx)) {
                if (a.this.g != null) {
                    a.this.g.setVideoReady(true);
                }
                a aVar5 = a.this;
                aVar5.b((CampaignEx) obj, aVar5.o);
            }
        }
    };
    private Runnable y = new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.5
        @Override // java.lang.Runnable
        public final void run() {
            e eVar = new e(2, "load timeout");
            a aVar = a.this;
            aVar.a(eVar, aVar.n, a.this.o, (CampaignEx) null);
        }
    };
    private Context f = com.mbridge.msdk.foundation.controller.b.d().g();

    public a(String str, String str2, long j) {
        this.c = str;
        this.f1869b = str2;
    }

    public final void a(f fVar) {
        this.h = fVar;
    }

    public final void a(MBNativeAdvancedView mBNativeAdvancedView) {
        this.g = mBNativeAdvancedView;
    }

    public final void a(int i) {
        this.j = i;
    }

    public final void a(int i, int i2) {
        this.m = i;
        this.l = i2;
    }

    public final void a(String str, int i) {
        CampaignEx campaignExA;
        List<Integer> listS;
        this.q = false;
        this.n = str;
        this.o = i;
        this.i = null;
        if (this.g == null) {
            a(new e(0, "MBAdvancedNativeView is null"), str, i, (CampaignEx) null);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            campaignExA = c.a(this.g, this.c, this.f1869b, str, this.j, false, false);
        } else {
            campaignExA = c.a(this.g, this.c, this.f1869b, str, this.j, false, true);
        }
        long timestamp = campaignExA != null ? campaignExA.getTimestamp() : 0L;
        f fVar = this.h;
        if (fVar != null && fVar.n() == 1 && this.g != null && campaignExA != null) {
            a(campaignExA, i);
            return;
        }
        this.p = false;
        f fVar2 = this.h;
        if (fVar2 != null && (listS = fVar2.s()) != null && listS.size() > 0) {
            this.d = listS.get(0).intValue() * 1000;
        } else {
            this.d = 30000L;
        }
        if (this.h == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
            a(this.d);
            a(this.f, str, i);
        } else if (System.currentTimeMillis() - timestamp > this.h.x() * 1000) {
            a(this.d);
            a(this.f, str, i);
        } else {
            a(campaignExA, i);
        }
    }

    private void a(long j) {
        this.x.postDelayed(this.y, j);
    }

    public final String a() {
        return this.w;
    }

    private void a(Context context, final String str, final int i) {
        try {
            if (context == null) {
                a(new e(0, "Context is null"), str, i, (CampaignEx) null);
                return;
            }
            if (ak.a(this.f1869b)) {
                a(new e(0, "UnitId is null"), str, i, (CampaignEx) null);
                return;
            }
            try {
                c.a(this.f1869b);
            } catch (Throwable th) {
                aa.d(a, th.getMessage());
            }
            d dVarA = a(i, this.u);
            if (dVarA == null) {
                a(new e(0, "Load param is null"), str, i, (CampaignEx) null);
                return;
            }
            if (dVarA != null && !TextUtils.isEmpty(str)) {
                dVarA.a(BidResponsed.KEY_TOKEN, str);
            }
            String strH = af.h(this.f1869b);
            if (!TextUtils.isEmpty(strH)) {
                dVarA.a("j", strH);
            }
            com.mbridge.msdk.advanced.d.a aVar = new com.mbridge.msdk.advanced.d.a(context);
            com.mbridge.msdk.advanced.d.c cVar = new com.mbridge.msdk.advanced.d.c(i) { // from class: com.mbridge.msdk.advanced.a.a.6
                @Override // com.mbridge.msdk.advanced.d.c
                public final void a(final CampaignUnit campaignUnit, final int i2) {
                    try {
                        a aVar2 = a.this;
                        a.a(aVar2, campaignUnit, i2, aVar2.f1869b, str);
                        a.this.w = campaignUnit.getRequestId();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (a.this.x != null) {
                            a.this.x.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.6.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    e eVar = new e(3, "Exception after load success");
                                    a aVar3 = a.this;
                                    String str2 = str;
                                    int i3 = i2;
                                    CampaignUnit campaignUnit2 = campaignUnit;
                                    aVar3.a(eVar, str2, i3, (campaignUnit2 == null || campaignUnit2.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
                                }
                            });
                        }
                        a.this.v = 0;
                    }
                }

                @Override // com.mbridge.msdk.advanced.d.c
                public final void a(int i2, final String str2) {
                    if (a.this.x != null) {
                        a.this.x.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.6.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                a.this.a(new e(3, str2), str, i, (CampaignEx) null);
                            }
                        });
                    }
                    a.this.v = 0;
                }
            };
            cVar.a(str);
            cVar.setUnitId(this.f1869b);
            cVar.setPlacementId(this.c);
            cVar.setAdType(298);
            aVar.choiceV3OrV5BySetting(1, dVarA, cVar, str);
        } catch (Exception e) {
            e.printStackTrace();
            a(new e(1, "Load exception"), str, i, (CampaignEx) null);
            this.v = 0;
        }
    }

    private d a(int i, String str) {
        String strH = com.mbridge.msdk.foundation.controller.b.d().h();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.b.d().h() + com.mbridge.msdk.foundation.controller.b.d().j());
        d dVar = new d();
        String strA = com.mbridge.msdk.foundation.same.a.d.a(this.f1869b, "h5_native");
        String strB = af.b(this.f, this.f1869b);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "app_id", strH);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f1869b);
        if (!TextUtils.isEmpty(this.c)) {
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PLACEMENT_ID, this.c);
        }
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "req_type", i + "");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_num", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "tnum", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, d.f2148b, strA);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, d.c, strB);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, d.a, str);
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_type", "298");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "offset", this.v + "");
        com.mbridge.msdk.foundation.same.net.f.b.a(dVar, CampaignUnit.JSON_KEY_UNIT_SIZE, this.m + "x" + this.l);
        return dVar;
    }

    public final void a(com.mbridge.msdk.advanced.b.b bVar) {
        this.e = bVar;
    }

    public final void b() {
        if (this.e != null) {
            this.e = null;
        }
        a(new e(3, "LoadManager release"), this.n, this.o, (CampaignEx) null);
        if (this.r != null) {
            this.r = null;
        }
        if (this.s != null) {
            this.s = null;
        }
    }

    private void a(CampaignEx campaignEx, int i) {
        this.i = campaignEx;
        if (c.a(this.g, campaignEx, this.c, this.f1869b)) {
            b(campaignEx, i);
        } else {
            c(campaignEx, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx, int i) {
        if (!c.a(this.g, campaignEx, this.c, this.f1869b) || this.q) {
            return;
        }
        c();
        c.a(campaignEx, this.f1869b);
        this.q = true;
        com.mbridge.msdk.advanced.b.b bVar = this.e;
        if (bVar != null) {
            bVar.a(campaignEx, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, String str, int i, CampaignEx campaignEx) {
        if (this.p) {
            this.p = false;
            a(eVar, i, str);
        } else {
            a(eVar, i, campaignEx);
        }
    }

    private void a(e eVar, int i, String str) {
        CampaignEx campaignExA = c.a(this.g, this.c, this.f1869b, str, this.j, true, true);
        if (campaignExA != null) {
            a(campaignExA, i);
        } else {
            a(eVar, i, campaignExA);
        }
    }

    private void a(e eVar, int i, CampaignEx campaignEx) {
        if (this.q) {
            return;
        }
        c();
        this.q = true;
        com.mbridge.msdk.advanced.b.b bVar = this.e;
        if (bVar != null) {
            bVar.a(eVar, i, campaignEx);
        }
    }

    private void c() {
        this.x.removeCallbacks(this.y);
    }

    private void c(CampaignEx campaignEx, int i) {
        MBNativeAdvancedView mBNativeAdvancedView = this.g;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            h(campaignEx, i);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            g(campaignEx, i);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            i(campaignEx, i);
        }
        if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
            f(campaignEx, i);
        }
        if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
            e(campaignEx, i);
        }
        if (TextUtils.isEmpty(campaignEx.getGifUrl())) {
            return;
        }
        d(campaignEx, i);
    }

    private void d(final CampaignEx campaignEx, final int i) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx.getGifUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.advanced.a.a.7
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                if (a.this.x != null) {
                    a.this.x.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.7.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.b(campaignEx, i);
                        }
                    });
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
                if (a.this.x != null) {
                    a.this.x.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.7.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.b(campaignEx, i);
                        }
                    });
                }
            }
        });
    }

    private void e(final CampaignEx campaignEx, final int i) {
        this.t = new g.d() { // from class: com.mbridge.msdk.advanced.a.a.8
            @Override // com.mbridge.msdk.videocommon.download.g.a
            public final void a(String str, boolean z) {
                if (a.this.x != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 4;
                    messageObtain.obj = campaignEx;
                    messageObtain.arg1 = i;
                    a.this.x.sendMessage(messageObtain);
                }
            }

            @Override // com.mbridge.msdk.videocommon.download.g.a
            public final void a(String str, String str2) {
                if (a.this.g != null) {
                    a.this.g.setEndCardReady(false);
                }
                e eVar = new e(7, str);
                a aVar = a.this;
                aVar.a(eVar, aVar.n, a.this.o, campaignEx);
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                Bundle bundle = new Bundle();
                bundle.putSerializable("campaignex", campaignEx);
                bundle.putString("msg", str);
                messageObtain.obj = bundle;
                a.this.x.sendMessage(messageObtain);
            }
        };
        g.a().b(campaignEx.getendcard_url(), this.t);
    }

    private void f(final CampaignEx campaignEx, final int i) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.advanced.a.a.9
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                if (a.this.x != null) {
                    a.this.x.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.9.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.b(campaignEx, i);
                        }
                    });
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
                if (a.this.x != null) {
                    a.this.x.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.9.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.b(campaignEx, i);
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:25:0x009f A[Catch: all -> 0x00fc, Exception -> 0x00fe, Merged into TryCatch #6 {all -> 0x00fc, Exception -> 0x00fe, blocks: (B:52:0x00f8, B:53:0x00fb, B:38:0x00be, B:40:0x00c4, B:42:0x00ca, B:44:0x00d0, B:46:0x00db, B:47:0x00e4, B:25:0x009f, B:57:0x00ff), top: B:74:0x0006 }, PHI: r3 r7
      0x009f: PHI (r3v2 java.io.FileOutputStream) = (r3v5 java.io.FileOutputStream), (r3v7 java.io.FileOutputStream) binds: [B:36:0x00bb, B:24:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x009f: PHI (r7v1 java.io.File) = (r7v3 java.io.File), (r7v7 java.io.File) binds: [B:36:0x00bb, B:24:0x009d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE] */
    private void g(final CampaignEx campaignEx, final int i) {
        final File file;
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
                                        n.a(campaignEx, e.getMessage(), this.f1869b, "8");
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
                        n.a(campaignEx, "", this.f1869b, "8");
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
                Handler handler = this.x;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.10
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.a(a.this, "file:////" + file.getAbsolutePath(), campaignEx, i);
                        }
                    });
                }
            } else {
                a(new e(6, "html file write failed"), this.n, i, campaignEx);
            }
            if (fileOutputStream == null) {
            }
        } catch (Exception e5) {
            a(new e(6, e5.getMessage()), this.n, i, campaignEx);
        } finally {
            if (0 != 0) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    private void h(final CampaignEx campaignEx, final int i) {
        this.s = new g.d() { // from class: com.mbridge.msdk.advanced.a.a.11
            @Override // com.mbridge.msdk.videocommon.download.g.a
            public final void a(String str, boolean z) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = campaignEx;
                messageObtain.arg1 = i;
                a.this.x.sendMessage(messageObtain);
            }

            @Override // com.mbridge.msdk.videocommon.download.g.a
            public final void a(String str, String str2) {
                e eVar = new e(6, str);
                a aVar = a.this;
                aVar.a(eVar, aVar.n, a.this.o, campaignEx);
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                Bundle bundle = new Bundle();
                bundle.putSerializable("campaignex", campaignEx);
                bundle.putString("msg", str);
                messageObtain.obj = bundle;
                a.this.x.sendMessage(messageObtain);
            }
        };
        g.a().b(campaignEx.getAdZip(), this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, int i) {
        a(new e(9, str), this.n, i, campaignEx);
        b(campaignEx, str, 2);
    }

    private void b(CampaignEx campaignEx, String str, int i) {
        com.mbridge.msdk.advanced.c.a.b(com.mbridge.msdk.advanced.common.c.a().c(campaignEx.getId()).b(this.f1869b).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).f(str).b(i).a(campaignEx.isBidCampaign()), this.f1869b);
    }

    private void i(final CampaignEx campaignEx, int i) {
        this.r = new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.advanced.a.a.4
            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = campaignEx;
                messageObtain.what = 5;
                a.this.x.sendMessage(messageObtain);
            }

            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str, String str2) {
                e eVar = new e(6, str);
                a aVar = a.this;
                aVar.a(eVar, aVar.n, a.this.o, campaignEx);
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putSerializable("campaignex", campaignEx);
                bundle.putString("msg", str);
                messageObtain.obj = bundle;
                messageObtain.what = 2;
                a.this.x.sendMessage(messageObtain);
            }
        };
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.c.getInstance().createUnitCache(this.f, this.f1869b, copyOnWriteArrayList, 298, this.r);
        if (!com.mbridge.msdk.videocommon.download.c.getInstance().a(298, this.f1869b, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.c.getInstance().load(this.f1869b);
        } else {
            this.g.setVideoReady(true);
            b(campaignEx, i);
        }
    }

    public final String a(String str) {
        if (this.i == null) {
            return "";
        }
        try {
            com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.f1869b, this.i.getId() + this.i.getVideoUrlEncode() + this.i.getBidToken());
            if (aVarA == null || aVarA.j() != 5) {
                return str;
            }
            String strH = aVarA.h();
            return new File(strH).exists() ? strH : str;
        } catch (Exception e) {
            aa.d(a, e.getMessage());
            return str;
        }
    }

    static /* synthetic */ void a(a aVar, final String str, final CampaignEx campaignEx, final int i) {
        MBNativeAdvancedView mBNativeAdvancedView = aVar.g;
        if (mBNativeAdvancedView == null || mBNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.advanced.common.c.a().c(campaignEx.getId()).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).b(aVar.f1869b).a(campaignEx.isBidCampaign()), aVar.f1869b);
        com.mbridge.msdk.advanced.js.b bVar = new com.mbridge.msdk.advanced.js.b(aVar.g.getContext(), aVar.c, aVar.f1869b);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        bVar.a(arrayList);
        bVar.a(aVar.j);
        bVar.b(aVar.k);
        aVar.g.setAdvancedNativeSignalCommunicationImpl(bVar);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final MBNativeAdvancedWebview advancedNativeWebview = aVar.g.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            aVar.a(campaignEx, "webview is null", i);
            return;
        }
        if (advancedNativeWebview != null && advancedNativeWebview.isDestoryed()) {
            aVar.a(campaignEx, "webview is destroyed", i);
            return;
        }
        advancedNativeWebview.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.advanced.a.a.2
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i2) {
                super.a(webView, i2);
                if (i2 == 1) {
                    a.this.g.setH5Ready(true);
                    com.mbridge.msdk.advanced.common.b.a(a.this.c + a.this.f1869b + campaignEx.getRequestId(), true);
                    a.b(a.this, campaignEx, i);
                    com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, a.this.f1869b, "", jCurrentTimeMillis, 1);
                    return;
                }
                a.this.a(campaignEx, "readyState 2", i);
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, a.this.f1869b, "readyState 2", jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i2, String str2, String str3) {
                super.a(webView, i2, str2, str3);
                a.this.a(campaignEx, str2, i);
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, a.this.f1869b, "error code:" + i2 + str2, jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                a.this.a(campaignEx, "onReceivedSslError:" + sslError.getUrl(), i);
                com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, a.this.f1869b, "error url:" + sslError.getUrl(), jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str2) {
                super.a(webView, str2);
                if (!campaignEx.isHasMBTplMark()) {
                    a.this.g.setH5Ready(true);
                    com.mbridge.msdk.advanced.common.b.a(a.this.c + a.this.f1869b + campaignEx.getRequestId(), true);
                    a.b(a.this, campaignEx, i);
                    com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, a.this.f1869b, "", jCurrentTimeMillis, 1);
                }
                com.mbridge.msdk.advanced.js.a.a(webView);
            }
        });
        if (!advancedNativeWebview.isDestoryed()) {
            Handler handler = aVar.x;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        advancedNativeWebview.loadUrl(str);
                    }
                });
                return;
            }
            return;
        }
        aVar.a(new e(9, "webview has destory"), aVar.n, i, campaignEx);
        com.mbridge.msdk.advanced.c.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, aVar.f1869b, "webview had destory", jCurrentTimeMillis, 3);
    }

    static /* synthetic */ void a(a aVar, CampaignUnit campaignUnit, int i, String str, String str2) {
        ArrayList arrayList;
        CampaignEx campaignEx = null;
        boolean z = true;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            CampaignEx campaignEx2 = campaignUnit.getAds().get(0);
            campaignEx2.setCampaignUnitId(aVar.f1869b);
            aVar.u = campaignUnit.getSessionId();
            if (campaignEx2.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx2.getAdZip()) || !TextUtils.isEmpty(campaignEx2.getAdHtml()))) {
                if (af.b(campaignEx2)) {
                    campaignEx2.setRtinsType(af.c(aVar.f, campaignEx2.getPackageName()) ? 1 : 2);
                }
                if (campaignEx2.getWtick() == 1 || !af.c(aVar.f, campaignEx2.getPackageName()) || af.b(campaignEx2)) {
                    arrayList.add(campaignEx2);
                } else {
                    af.a(aVar.f1869b, campaignEx2, com.mbridge.msdk.foundation.same.a.w);
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            e eVar = new e(3, "invalid  campaign");
            if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() != 0) {
                campaignEx = campaignUnit.getAds().get(0);
            }
            aVar.a(eVar, str2, i, campaignEx);
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
            int i2 = aVar.v + 1;
            aVar.v = i2;
            f fVar = aVar.h;
            if (fVar == null || i2 > fVar.v()) {
                aVar.v = 0;
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
        aVar.a(campaignEx3, i);
    }

    static /* synthetic */ void b(a aVar, CampaignEx campaignEx, int i) {
        if (aVar.g.isH5Ready()) {
            aVar.b(campaignEx, i);
            aVar.b(campaignEx, "", 1);
        }
    }
}
