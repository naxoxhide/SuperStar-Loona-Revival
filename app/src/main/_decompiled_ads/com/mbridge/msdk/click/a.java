package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.igaworks.adpopcorn.nativead.custom.ApCustomRewardCPMError;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: CommonClickControl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, Long> f1921b = new HashMap();
    public static Set<String> c = new HashSet();
    private String d;
    private long e;
    private com.mbridge.msdk.foundation.db.h f;
    private Context g;
    private CommonJumpLoader h;
    private p j;
    private com.mbridge.msdk.c.c k;
    private boolean l;
    private boolean o;
    private g p;
    private NativeListener.NativeTrackingListener i = null;
    private boolean m = false;
    private boolean n = true;

    static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "2000136";
        }
        if (i == 2) {
            return "2000137";
        }
        if (i != 3) {
            return i != 4 ? "" : "2000138";
        }
        return "2000139";
    }

    public a(Context context, String str) {
        this.f = null;
        this.g = null;
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(str);
        this.k = cVarB;
        if (cVarB == null) {
            this.k = com.mbridge.msdk.c.d.a().b();
        }
        this.l = this.k.T();
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.d = str;
        if (this.f == null) {
            this.f = com.mbridge.msdk.foundation.db.h.a(applicationContext);
        }
        this.j = new p(this.g);
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.i = nativeTrackingListener;
    }

    public final void a(g gVar) {
        this.p = gVar;
    }

    public final void a(boolean z) {
        this.n = z;
    }

    public final void a() {
        try {
            this.i = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (nativeAdListener != null && campaignEx != null) {
            nativeAdListener.onAdClick(campaignEx);
        }
        a(campaignEx);
    }

    private boolean b(CampaignEx campaignEx) {
        Long l;
        if (campaignEx == null) {
            return true;
        }
        try {
            if (2 != campaignEx.getLinkType() && 3 != campaignEx.getLinkType()) {
                return true;
            }
            String id = campaignEx.getId();
            Map<String, Long> map = f1921b;
            if (map == null) {
                return true;
            }
            if (map.containsKey(id) && (l = f1921b.get(id)) != null) {
                if (l.longValue() > System.currentTimeMillis() || c.contains(campaignEx.getId())) {
                    return false;
                }
            }
            f1921b.put(campaignEx.getId(), Long.valueOf(System.currentTimeMillis() + ((long) (campaignEx.getClickTimeOutInterval() * 1000))));
            return true;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            e.printStackTrace();
            return true;
        }
    }

    private void a(CampaignEx campaignEx, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(this.g, campaignEx, this.d, str, true, false, com.mbridge.msdk.click.a.a.i);
    }

    public final void a(CampaignEx campaignEx) {
        try {
            if (b(campaignEx)) {
                HashMap map = new HashMap();
                map.put("update", "1");
                m.a().a("2000149", campaignEx, map);
                String noticeUrl = campaignEx.getNoticeUrl();
                com.mbridge.msdk.foundation.db.d dVarA = com.mbridge.msdk.foundation.db.d.a(this.f);
                dVarA.a();
                CommonJumpLoader.JumpLoaderResult jumpLoaderResultB = dVarA.b(campaignEx.getId(), this.d);
                if (jumpLoaderResultB != null) {
                    if (jumpLoaderResultB.getNoticeurl() != null) {
                        jumpLoaderResultB.setNoticeurl(null);
                    }
                    campaignEx.setJumpResult(jumpLoaderResultB);
                    dVarA.a(campaignEx, this.d);
                }
                AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
                if (af.a(campaignEx)) {
                    q.a().a(campaignEx);
                    HashMap map2 = new HashMap();
                    map2.put("type", "3");
                    if (b.d(this.g, campaignEx.getDeepLinkURL())) {
                        NativeListener.NativeTrackingListener nativeTrackingListener = this.i;
                        if (nativeTrackingListener != null) {
                            nativeTrackingListener.onStartRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        a(campaignEx, noticeUrl + "&opdptype=1");
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.i;
                        if (nativeTrackingListener2 != null) {
                            nativeTrackingListener2.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        try {
                            map2.put("result", "1");
                            m.a().a("2000150", campaignEx, map2);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    try {
                        map2.put("result", "2");
                        m.a().a("2000150", campaignEx, map2);
                    } catch (Exception unused2) {
                    }
                    noticeUrl = noticeUrl + "&opdptype=0";
                    q.a().b(campaignEx);
                }
                if (campaignEx.getLinkType() == 12) {
                    NativeListener.NativeTrackingListener nativeTrackingListener3 = this.i;
                    if (nativeTrackingListener3 != null) {
                        nativeTrackingListener3.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    a(campaignEx, noticeUrl);
                    a(this.g, campaignEx);
                    NativeListener.NativeTrackingListener nativeTrackingListener4 = this.i;
                    if (nativeTrackingListener4 != null) {
                        nativeTrackingListener4.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        return;
                    }
                    return;
                }
                if (appletsModel != null && appletsModel.isSupportWxScheme()) {
                    if (appletsModel.isRequestSuccess()) {
                        if (b.d(this.g, appletsModel.getDeepLink())) {
                            NativeListener.NativeTrackingListener nativeTrackingListener5 = this.i;
                            if (nativeTrackingListener5 != null) {
                                nativeTrackingListener5.onStartRedirection(campaignEx, campaignEx.getClickURL());
                            }
                            if (this.g != null) {
                                Intent intent = new Intent();
                                intent.setAction("mb_dp_close_broadcast_receiver");
                                try {
                                    this.g.sendBroadcast(intent);
                                } catch (Exception unused3) {
                                }
                            }
                            a(campaignEx, noticeUrl + "&opdptype=1");
                            NativeListener.NativeTrackingListener nativeTrackingListener6 = this.i;
                            if (nativeTrackingListener6 != null) {
                                nativeTrackingListener6.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                                return;
                            }
                            return;
                        }
                        noticeUrl = noticeUrl + "&opdptype=0";
                    } else {
                        if (appletsModel.isRequesting()) {
                            NativeListener.NativeTrackingListener nativeTrackingListener7 = this.i;
                            if (nativeTrackingListener7 != null) {
                                nativeTrackingListener7.onStartRedirection(campaignEx, campaignEx.getClickURL());
                            }
                            appletsModel.setAppletSchemeCallBack(a(this.i, campaignEx, appletsModel, this));
                            return;
                        }
                        if (appletsModel.can(1)) {
                            if (appletsModel.isRequestTimesMaxPerDay()) {
                                if (campaignEx != null && appletsModel != null && !TextUtils.isEmpty(appletsModel.getReBuildClickUrl())) {
                                    campaignEx.setClickURL(appletsModel.getReBuildClickUrl());
                                }
                            } else {
                                NativeListener.NativeTrackingListener nativeTrackingListener8 = this.i;
                                if (nativeTrackingListener8 != null) {
                                    nativeTrackingListener8.onStartRedirection(campaignEx, campaignEx.getClickURL());
                                }
                                appletsModel.requestWxAppletsScheme(1, a(this.i, campaignEx, appletsModel, this));
                                return;
                            }
                        }
                    }
                }
                a(campaignEx, noticeUrl);
                if (!campaignEx.getUserActivation() && b.c(this.g, campaignEx.getPackageName())) {
                    b.e(this.g, campaignEx.getPackageName());
                    NativeListener.NativeTrackingListener nativeTrackingListener9 = this.i;
                    if (nativeTrackingListener9 != null) {
                        nativeTrackingListener9.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    a(campaignEx, true);
                    NativeListener.NativeTrackingListener nativeTrackingListener10 = this.i;
                    if (nativeTrackingListener10 != null) {
                        nativeTrackingListener10.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        ae.a(this.i);
                        return;
                    }
                    return;
                }
                int linkType = campaignEx.getLinkType();
                int iB = b();
                boolean z = linkType == 8 || linkType == 9 || linkType == 4;
                String clickURL = campaignEx.getClickURL();
                if (!TextUtils.isEmpty(clickURL) && (clickURL.startsWith("market://") || clickURL.startsWith("https://play.google.com/"))) {
                    NativeListener.NativeTrackingListener nativeTrackingListener11 = this.i;
                    if (nativeTrackingListener11 != null) {
                        nativeTrackingListener11.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    if (ae.a.a(this.g, campaignEx.getClickURL(), this.i)) {
                        a(jumpLoaderResultB, campaignEx, false);
                        aa.b("MBridge SDK M", "不用做302跳转 最终地址已经是gp了：" + campaignEx.getClickURL());
                        NativeListener.NativeTrackingListener nativeTrackingListener12 = this.i;
                        if (nativeTrackingListener12 != null) {
                            nativeTrackingListener12.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        try {
                            HashMap map3 = new HashMap();
                            map3.put("type", "1");
                            map3.put("result", "1");
                            m.a().a("2000150", campaignEx, map3);
                            return;
                        } catch (Exception unused4) {
                            return;
                        }
                    }
                    try {
                        HashMap map4 = new HashMap();
                        map4.put("type", "1");
                        map4.put("result", "2");
                        m.a().a("2000150", campaignEx, map4);
                    } catch (Exception unused5) {
                    }
                    a(iB, campaignEx.getClickURL(), campaignEx, this.i);
                    a(jumpLoaderResultB, campaignEx, false);
                    aa.b("MBridge SDK M", "最终地址是gp, 但是打开失败了：" + campaignEx.getClickURL());
                    NativeListener.NativeTrackingListener nativeTrackingListener13 = this.i;
                    if (nativeTrackingListener13 != null) {
                        nativeTrackingListener13.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        return;
                    }
                    return;
                }
                if (!z) {
                    if (linkType == 2) {
                        a(campaignEx, false);
                        return;
                    }
                    if (linkType == 3) {
                        try {
                            HashMap map5 = new HashMap();
                            map5.put("type", "2");
                            map5.put("result", "1");
                            m.a().a("2000150", campaignEx, map5);
                        } catch (Exception unused6) {
                        }
                        a(campaignEx, false);
                        return;
                    }
                    String clickURL2 = campaignEx.getClickURL();
                    NativeListener.NativeTrackingListener nativeTrackingListener14 = this.i;
                    if (nativeTrackingListener14 != null) {
                        nativeTrackingListener14.onStartRedirection(campaignEx, clickURL2);
                    }
                    if (TextUtils.isEmpty(clickURL2)) {
                        NativeListener.NativeTrackingListener nativeTrackingListener15 = this.i;
                        if (nativeTrackingListener15 != null) {
                            nativeTrackingListener15.onRedirectionFailed(campaignEx, clickURL2);
                        }
                        a(jumpLoaderResultB, campaignEx, true);
                        return;
                    }
                    NativeListener.NativeTrackingListener nativeTrackingListener16 = this.i;
                    if (nativeTrackingListener16 != null) {
                        nativeTrackingListener16.onFinishRedirection(campaignEx, clickURL2);
                    }
                    ae.a(this.g, clickURL2, this.i, campaignEx.getCurrentLRid());
                    a(jumpLoaderResultB, campaignEx, true);
                    return;
                }
                String clickURL3 = campaignEx.getClickURL();
                NativeListener.NativeTrackingListener nativeTrackingListener17 = this.i;
                if (nativeTrackingListener17 != null) {
                    nativeTrackingListener17.onStartRedirection(campaignEx, clickURL3);
                }
                if (TextUtils.isEmpty(clickURL3)) {
                    NativeListener.NativeTrackingListener nativeTrackingListener18 = this.i;
                    if (nativeTrackingListener18 != null) {
                        nativeTrackingListener18.onRedirectionFailed(campaignEx, clickURL3);
                    }
                    a(jumpLoaderResultB, campaignEx, true);
                    return;
                }
                if (linkType == 8) {
                    if (campaignEx.getAabEntity() != null && campaignEx.getAabEntity().getHlp() == 1) {
                        BaseTrackingListener baseTrackingListener = this.i;
                        if (baseTrackingListener == null && (baseTrackingListener = this.p) != null) {
                            baseTrackingListener.onStartRedirection(campaignEx, clickURL3);
                        }
                        ae.a(this.g, clickURL3, campaignEx, this, baseTrackingListener);
                    } else {
                        ae.a(this.g, clickURL3, campaignEx, this.i);
                        NativeListener.NativeTrackingListener nativeTrackingListener19 = this.i;
                        if (nativeTrackingListener19 != null) {
                            nativeTrackingListener19.onFinishRedirection(campaignEx, clickURL3);
                        }
                    }
                    a(jumpLoaderResultB, campaignEx, false);
                    return;
                }
                if (linkType == 9) {
                    ae.a(this.g, clickURL3, this.i, campaignEx.getCurrentLRid());
                    a(jumpLoaderResultB, campaignEx, false);
                    NativeListener.NativeTrackingListener nativeTrackingListener20 = this.i;
                    if (nativeTrackingListener20 != null) {
                        nativeTrackingListener20.onFinishRedirection(campaignEx, clickURL3);
                        return;
                    }
                    return;
                }
                if (linkType == 4) {
                    if (iB == 2) {
                        ae.a(this.g, clickURL3, campaignEx, this.i);
                    } else {
                        ae.a(this.g, clickURL3, this.i, campaignEx.getCurrentLRid());
                    }
                }
                NativeListener.NativeTrackingListener nativeTrackingListener21 = this.i;
                if (nativeTrackingListener21 != null) {
                    nativeTrackingListener21.onFinishRedirection(campaignEx, clickURL3);
                }
                a(jumpLoaderResultB, campaignEx, false);
            }
        } catch (Throwable th) {
            aa.b("MBridge SDK M", th.getMessage(), th);
        }
    }

    private AppletSchemeCallBack a(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        return new e(nativeTrackingListener, campaignEx, appletsModel, aVar);
    }

    private void a(Context context, CampaignEx campaignEx) {
        if (context == null) {
            com.mbridge.msdk.foundation.same.report.q.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, 2, "context is null", this.d);
            return;
        }
        boolean z = w.g() == 1;
        boolean z2 = w.f(context) == 1;
        if (!z || !z2) {
            com.mbridge.msdk.foundation.same.report.q.a(context, campaignEx, 2, "integrated:" + z + "-hasWx:" + z2, this.d);
            c(campaignEx);
            return;
        }
        String ghId = campaignEx.getGhId();
        String ghPath = campaignEx.getGhPath();
        String bindId = campaignEx.getBindId();
        String strI = com.mbridge.msdk.foundation.controller.b.d().i();
        if (!TextUtils.isEmpty(ghId)) {
            try {
                if (!TextUtils.isEmpty(strI)) {
                    bindId = strI;
                }
                Object objB = w.b(bindId);
                Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
                Object objNewInstance = cls.newInstance();
                cls.getField("userName").set(objNewInstance, ghId);
                cls.getField(MBridgeConstans.DYNAMIC_VIEW_WX_PATH).set(objNewInstance, ghPath);
                cls.getField("miniprogramType").set(objNewInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
                Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")).invoke(objB, objNewInstance);
                com.mbridge.msdk.foundation.same.report.q.a(context, campaignEx, 1, "", this.d);
                return;
            } catch (Throwable th) {
                com.mbridge.msdk.foundation.same.report.q.a(context, campaignEx, 2, th.getMessage(), this.d);
                c(campaignEx);
                return;
            }
        }
        c(campaignEx);
        com.mbridge.msdk.foundation.same.report.q.a(context, campaignEx, 2, "ghid is empty", this.d);
    }

    private void c(CampaignEx campaignEx) {
        if (b() == 2) {
            ae.a(this.g, campaignEx.getClickURL(), campaignEx, this.i);
        } else {
            ae.a(this.g, campaignEx.getClickURL(), this.i, campaignEx.getCurrentLRid());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z, boolean z2) {
        if (context == null) {
            return;
        }
        new CommonJumpLoader(context.getApplicationContext()).a(str, campaignEx, null, str2, z, z2, com.mbridge.msdk.click.a.a.f);
    }

    public static void a(Context context, final CampaignEx campaignEx, String str, String str2, boolean z, boolean z2, final int i) {
        if (context == null) {
            return;
        }
        new CommonJumpLoader(context.getApplicationContext()).a(str, campaignEx, new d() { // from class: com.mbridge.msdk.click.a.1
            @Override // com.mbridge.msdk.click.d
            public final void a(Object obj) {
            }

            @Override // com.mbridge.msdk.click.d
            public final void b(Object obj) {
                try {
                    HashMap map = new HashMap();
                    map.put("result", "2");
                    if (obj != null && (obj instanceof CommonJumpLoader.JumpLoaderResult) && (((CommonJumpLoader.JumpLoaderResult) obj).getStatusCode() + "").startsWith("2")) {
                        map.put("result", "1");
                    }
                    String strA = a.a(i);
                    map.put("update", "1");
                    m.a().a(strA, campaignEx, map);
                } catch (Exception e) {
                    aa.d("MBridge SDK M", e.getMessage());
                }
            }

            @Override // com.mbridge.msdk.click.d
            public final void a(Object obj, String str3) {
                try {
                    String strA = a.a(i);
                    HashMap map = new HashMap();
                    map.put("result", "2");
                    map.put("code", "");
                    map.put("reason", str3);
                    map.put("failing", "");
                    map.put("update", "1");
                    m.a().a(strA, campaignEx, map);
                } catch (Exception e) {
                    aa.d("MBridge SDK M", e.getMessage());
                }
            }
        }, str2, z, z2, i);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z, boolean z2) {
        if (context == null || campaignEx == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        CommonJumpLoader commonJumpLoader = new CommonJumpLoader(context.getApplicationContext());
        for (String str2 : strArr) {
            commonJumpLoader.a(str, campaignEx, new d() { // from class: com.mbridge.msdk.click.a.2
                @Override // com.mbridge.msdk.click.d
                public final void a(Object obj) {
                }

                @Override // com.mbridge.msdk.click.d
                public final void a(Object obj, String str3) {
                }

                @Override // com.mbridge.msdk.click.d
                public final void b(Object obj) {
                }
            }, str2, z, z2, com.mbridge.msdk.click.a.a.f);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0076 A[PHI: r3
      0x0076: PHI (r3v6 boolean) = (r3v3 boolean), (r3v2 boolean) binds: [B:36:0x00c7, B:21:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    private void a(final CampaignEx campaignEx, final boolean z) {
        final boolean z2;
        boolean z3;
        try {
            this.e = System.currentTimeMillis();
            NativeListener.NativeTrackingListener nativeTrackingListener = this.i;
            if (nativeTrackingListener == null || z) {
                z2 = true;
            } else {
                nativeTrackingListener.onStartRedirection(campaignEx, campaignEx.getClickURL());
                z2 = !this.i.onInterceptDefaultLoadingDialog();
            }
            final boolean z4 = false;
            this.o = false;
            if (campaignEx.getJumpResult() != null) {
                if (!z) {
                    a(campaignEx, campaignEx.getJumpResult(), true, this.m);
                }
                this.o = true;
                this.m = false;
                z3 = false;
            } else {
                z3 = true;
            }
            if (!com.mbridge.msdk.foundation.db.d.a(this.f).a(campaignEx.getId(), this.d) || campaignEx.getJumpResult() == null) {
                com.mbridge.msdk.foundation.db.d dVarA = com.mbridge.msdk.foundation.db.d.a(this.f);
                dVarA.a();
                CommonJumpLoader.JumpLoaderResult jumpLoaderResultB = dVarA.b(campaignEx.getId(), this.d);
                if (jumpLoaderResultB != null && !z) {
                    campaignEx.setJumpResult(jumpLoaderResultB);
                    if (z3) {
                        a(campaignEx, jumpLoaderResultB, z3, this.m);
                        this.o = true;
                        this.m = false;
                    } else {
                        z4 = z3;
                    }
                } else {
                    if (campaignEx.getClick_mode().equals("6") && !campaignEx.getPackageName().isEmpty() && campaignEx.getLinkType() == 2 && !z) {
                        ae.a.a(this.g, "market://details?id=" + campaignEx.getPackageName(), this.i);
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.i;
                        if (nativeTrackingListener2 != null && z3) {
                            nativeTrackingListener2.onDismissLoading(campaignEx);
                            this.i.onFinishRedirection(campaignEx, null);
                        }
                        this.o = true;
                        z3 = false;
                    }
                    if (z) {
                        this.o = true;
                        this.m = false;
                    } else {
                        z4 = z3;
                    }
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.click.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (z2 && !a.a && !a.this.o && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER && !z) {
                            a.a(a.this, campaignEx);
                        }
                        if (z2 || a.this.i == null || a.a || a.this.o || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                            return;
                        }
                        a.this.i.onShowLoading(campaignEx);
                    }
                });
                CommonJumpLoader commonJumpLoader = this.h;
                if (commonJumpLoader != null) {
                    commonJumpLoader.a();
                }
                Set<String> set = c;
                if (set != null && set.contains(campaignEx.getId())) {
                    NativeListener.NativeTrackingListener nativeTrackingListener3 = this.i;
                    if (nativeTrackingListener3 != null) {
                        nativeTrackingListener3.onDismissLoading(campaignEx);
                        this.i.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        return;
                    }
                    return;
                }
                Set<String> set2 = c;
                if (set2 != null) {
                    set2.add(campaignEx.getId());
                }
                CommonJumpLoader commonJumpLoader2 = new CommonJumpLoader(this.g);
                this.h = commonJumpLoader2;
                commonJumpLoader2.a(this.d, campaignEx, new d() { // from class: com.mbridge.msdk.click.a.4
                    @Override // com.mbridge.msdk.click.d
                    public final void a(Object obj) {
                    }

                    @Override // com.mbridge.msdk.click.d
                    public final void b(Object obj) {
                        if (a.c != null) {
                            a.c.remove(campaignEx.getId());
                        }
                        if (obj instanceof CommonJumpLoader.JumpLoaderResult) {
                            CommonJumpLoader.JumpLoaderResult jumpLoaderResult = (CommonJumpLoader.JumpLoaderResult) obj;
                            campaignEx.setJumpResult(jumpLoaderResult);
                            a aVar = a.this;
                            aVar.a(campaignEx, jumpLoaderResult, z4, aVar.m);
                            if (jumpLoaderResult.isjumpDone()) {
                                com.mbridge.msdk.foundation.db.d.a(a.this.f).a(campaignEx, a.this.d);
                            }
                            a.a(a.this, z2, campaignEx);
                        }
                        try {
                            HashMap map = new HashMap();
                            map.put("result", "1");
                            map.put("update", "1");
                            m.a().a("2000138", campaignEx, map);
                        } catch (Throwable th) {
                            aa.d("MBridge SDK M", th.getMessage());
                        }
                    }

                    @Override // com.mbridge.msdk.click.d
                    public final void a(Object obj, String str) {
                        if (a.c != null) {
                            a.c.remove(campaignEx.getId());
                        }
                        if (obj instanceof CommonJumpLoader.JumpLoaderResult) {
                            a.this.a((CommonJumpLoader.JumpLoaderResult) obj, campaignEx, true);
                        }
                        if (a.this.i != null) {
                            a.this.i.onRedirectionFailed(campaignEx, str);
                        }
                        a.a(a.this, z2, campaignEx);
                        try {
                            HashMap map = new HashMap();
                            map.put("result", "2");
                            map.put("update", "1");
                            m.a().a("2000138", campaignEx, map);
                        } catch (Throwable th) {
                            aa.d("MBridge SDK M", th.getMessage());
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(CommonJumpLoader.JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i, boolean z) {
        if (campaignEx == null || jumpLoaderResult == null) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.e;
            com.mbridge.msdk.foundation.entity.d dVar = new com.mbridge.msdk.foundation.entity.d();
            int iR = w.r(this.g);
            dVar.a(iR);
            dVar.a(w.a(this.g, iR));
            dVar.j(campaignEx.getRequestId());
            dVar.k(campaignEx.getRequestIdNotice());
            dVar.d(i);
            dVar.i(jCurrentTimeMillis + "");
            dVar.h(campaignEx.getId());
            dVar.f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                dVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            dVar.c((this.e / 1000) + "");
            dVar.b(Integer.parseInt(campaignEx.getLandingType()));
            dVar.c(campaignEx.getLinkType());
            dVar.b(this.d);
            dVar.f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                dVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            if (this.l) {
                dVar.e(jumpLoaderResult.getStatusCode());
                if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                    dVar.e(URLEncoder.encode(jumpLoaderResult.getHeader(), "utf-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                    dVar.f(URLEncoder.encode(jumpLoaderResult.getContent(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                    dVar.d(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), "utf-8"));
                }
            }
            if (z) {
                this.j.a("click_jump_error", dVar, this.d);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(dVar);
            String strA = com.mbridge.msdk.foundation.entity.d.a(arrayList);
            if (ak.b(strA)) {
                if (k.a().c()) {
                    k.a().a(strA);
                } else {
                    new p(this.g, 0).a("click_jump_success", strA, null, null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(Campaign campaign, String str) {
        try {
            if (!TextUtils.isEmpty(str) && campaign != null) {
                CampaignEx campaignEx = campaign instanceof CampaignEx ? (CampaignEx) campaign : null;
                if ((!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) || ae.a.a(this.g, str, this.i) || campaignEx == null) {
                    return;
                }
                if (!TextUtils.isEmpty(campaignEx.getPackageName())) {
                    ae.a.a(this.g, "market://details?id=" + campaignEx.getPackageName(), this.i);
                } else if (b() == 2) {
                    ae.a(this.g, campaignEx.getClickURL(), campaignEx, this.i);
                } else {
                    ae.a(this.g, campaignEx.getClickURL(), this.i, campaignEx.getCurrentLRid());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CommonJumpLoader.JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z) {
        a(jumpLoaderResult, campaignEx, 1, z);
    }

    private void a(int i, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (i == 2) {
                    ae.a(this.g, str, campaignEx, nativeTrackingListener);
                } else {
                    ae.a(this.g, str, nativeTrackingListener, campaignEx.getCurrentLRid());
                }
            }
        } catch (Throwable th) {
            aa.b("MBridge SDK M", th.getMessage(), th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006e A[Catch: all -> 0x006a, TryCatch #0 {all -> 0x006a, blocks: (B:4:0x0004, B:6:0x000e, B:9:0x0021, B:11:0x002e, B:13:0x0034, B:16:0x0056, B:17:0x0060, B:21:0x006e, B:23:0x0075, B:24:0x007d, B:27:0x0086), top: B:31:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0075 A[Catch: all -> 0x006a, TryCatch #0 {all -> 0x006a, blocks: (B:4:0x0004, B:6:0x000e, B:9:0x0021, B:11:0x002e, B:13:0x0034, B:16:0x0056, B:17:0x0060, B:21:0x006e, B:23:0x0075, B:24:0x007d, B:27:0x0086), top: B:31:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x007d A[Catch: all -> 0x006a, TryCatch #0 {all -> 0x006a, blocks: (B:4:0x0004, B:6:0x000e, B:9:0x0021, B:11:0x002e, B:13:0x0034, B:16:0x0056, B:17:0x0060, B:21:0x006e, B:23:0x0075, B:24:0x007d, B:27:0x0086), top: B:31:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0084 A[ADDED_TO_REGION] */
    private boolean a(CampaignEx campaignEx, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, boolean z, int i) {
        NativeListener.NativeTrackingListener nativeTrackingListener;
        NativeListener.NativeTrackingListener nativeTrackingListener2;
        boolean z2 = false;
        if (z) {
            try {
                int i2 = Integer.parseInt(campaignEx.getLandingType());
                if (i2 == 1) {
                    ae.a(this.g, jumpLoaderResult.getUrl(), this.i, campaignEx.getCurrentLRid());
                } else if (i2 == 2) {
                    ae.a(this.g, jumpLoaderResult.getUrl(), campaignEx, this.i);
                } else {
                    if (campaignEx.getPackageName() == null || !ae.a.a(this.g, "market://details?id=" + campaignEx.getPackageName(), this.i)) {
                        a(i, jumpLoaderResult.getUrl(), campaignEx, this.i);
                    }
                    if (z2) {
                        a(jumpLoaderResult, campaignEx, true);
                        nativeTrackingListener2 = this.i;
                        if (nativeTrackingListener2 != null) {
                            nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                        }
                    } else {
                        a(jumpLoaderResult, campaignEx, true);
                        nativeTrackingListener = this.i;
                        if (nativeTrackingListener != null && z) {
                            nativeTrackingListener.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
                        }
                    }
                }
                z2 = true;
                if (z2) {
                    a(jumpLoaderResult, campaignEx, true);
                    nativeTrackingListener2 = this.i;
                    if (nativeTrackingListener2 != null) {
                        nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                    }
                } else {
                    a(jumpLoaderResult, campaignEx, true);
                    nativeTrackingListener = this.i;
                    if (nativeTrackingListener != null) {
                        nativeTrackingListener.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
                    }
                }
            } catch (Throwable th) {
                aa.b("MBridge SDK M", th.getMessage(), th);
            }
        } else if (z2) {
            a(jumpLoaderResult, campaignEx, true);
            nativeTrackingListener2 = this.i;
            if (nativeTrackingListener2 != null) {
                nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else {
            a(jumpLoaderResult, campaignEx, true);
            nativeTrackingListener = this.i;
            if (nativeTrackingListener != null) {
                nativeTrackingListener.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z2;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0004, B:5:0x0014, B:7:0x0019, B:9:0x001d, B:10:0x0025, B:12:0x0029), top: B:17:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:12:0x0029 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0004, B:5:0x0014, B:7:0x0019, B:9:0x001d, B:10:0x0025, B:12:0x0029), top: B:17:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0004, B:5:0x0014, B:7:0x0019, B:9:0x001d, B:10:0x0025, B:12:0x0029), top: B:17:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x001d A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0004, B:5:0x0014, B:7:0x0019, B:9:0x001d, B:10:0x0025, B:12:0x0029), top: B:17:0x0004 }] */
    private boolean a(CampaignEx campaignEx, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, boolean z) {
        NativeListener.NativeTrackingListener nativeTrackingListener;
        NativeListener.NativeTrackingListener nativeTrackingListener2;
        boolean z2 = false;
        if (z) {
            try {
                ae.a(this.g, campaignEx.getClickURL(), this.i, campaignEx.getCurrentLRid());
                z2 = true;
                a(jumpLoaderResult, campaignEx, true);
                if (z2) {
                    nativeTrackingListener2 = this.i;
                    if (nativeTrackingListener2 != null) {
                        nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                    }
                } else {
                    nativeTrackingListener = this.i;
                    if (nativeTrackingListener != null) {
                        nativeTrackingListener.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
                    }
                }
            } catch (Throwable th) {
                aa.b("MBridge SDK M", th.getMessage(), th);
            }
        } else {
            a(jumpLoaderResult, campaignEx, true);
            if (z2) {
                nativeTrackingListener2 = this.i;
                if (nativeTrackingListener2 != null) {
                    nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                }
            } else {
                nativeTrackingListener = this.i;
                if (nativeTrackingListener != null) {
                    nativeTrackingListener.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
                }
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, boolean z, boolean z2) {
        try {
            if (this.n) {
                if (campaignEx != null && jumpLoaderResult != null) {
                    int iB = b();
                    int code = jumpLoaderResult.getCode();
                    if (TextUtils.isEmpty(jumpLoaderResult.getUrl()) && z) {
                        int linkType = campaignEx.getLinkType();
                        if (linkType == 2) {
                            a(campaignEx, jumpLoaderResult, z, b());
                            return;
                        }
                        if (linkType == 3) {
                            a(campaignEx, jumpLoaderResult, z);
                            return;
                        }
                        ae.a(this.g, campaignEx.getClickURL(), this.i, campaignEx.getCurrentLRid());
                        a(jumpLoaderResult, campaignEx, true);
                        NativeListener.NativeTrackingListener nativeTrackingListener = this.i;
                        if (nativeTrackingListener != null) {
                            nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                            return;
                        }
                        return;
                    }
                    if (code == 1) {
                        if (!TextUtils.isEmpty(campaignEx.getPackageName()) && !TextUtils.isEmpty(jumpLoaderResult.getUrl()) && jumpLoaderResult.getUrl().contains(campaignEx.getPackageName()) && z) {
                            if (!ae.a.a(this.g, jumpLoaderResult.getUrl(), this.i)) {
                                a(iB, jumpLoaderResult.getUrl(), campaignEx, this.i);
                            }
                        } else if (z && (TextUtils.isEmpty(campaignEx.getPackageName()) || !ae.a.a(this.g, "market://details?id=" + campaignEx.getPackageName(), this.i))) {
                            a(iB, jumpLoaderResult.getUrl(), campaignEx, this.i);
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.i;
                        if (nativeTrackingListener2 != null && z) {
                            nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                        }
                    } else if (code == 3) {
                        if (z) {
                            ae.a(this.g, jumpLoaderResult.getUrl(), this.i, campaignEx.getCurrentLRid());
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener3 = this.i;
                        if (nativeTrackingListener3 != null && z) {
                            nativeTrackingListener3.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                        }
                    } else if (z) {
                        if (3 == campaignEx.getLinkType()) {
                            a(campaignEx, jumpLoaderResult, z);
                            return;
                        } else {
                            if (2 == campaignEx.getLinkType()) {
                                a(campaignEx, jumpLoaderResult, z, b());
                                return;
                            }
                            ae.a(this.g, jumpLoaderResult.getUrl(), this.i, campaignEx.getCurrentLRid());
                            NativeListener.NativeTrackingListener nativeTrackingListener4 = this.i;
                            if (nativeTrackingListener4 != null) {
                                nativeTrackingListener4.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                            }
                        }
                    }
                    if (a(campaignEx.getLinkType(), jumpLoaderResult.getUrl())) {
                        a(jumpLoaderResult, campaignEx, false);
                    } else {
                        a(jumpLoaderResult, campaignEx, true);
                    }
                    NativeListener.NativeTrackingListener nativeTrackingListener5 = this.i;
                    if (nativeTrackingListener5 == null || z || !z2) {
                        return;
                    }
                    nativeTrackingListener5.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                    return;
                }
                if (z) {
                    a(jumpLoaderResult, campaignEx, true);
                    NativeListener.NativeTrackingListener nativeTrackingListener6 = this.i;
                    if (nativeTrackingListener6 != null) {
                        nativeTrackingListener6.onRedirectionFailed(null, null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int b() {
        try {
            com.mbridge.msdk.c.c cVar = this.k;
            if (cVar != null) {
                return cVar.O();
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0013  */
    private boolean a(int i, String str) {
        boolean z = true;
        boolean z2 = false;
        try {
            if (i == 2) {
                if (!ae.a.a(str)) {
                    z = false;
                }
            } else if (TextUtils.isEmpty(str)) {
                z = false;
            }
            z2 = z;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z2;
    }

    static /* synthetic */ void a(a aVar, CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(aVar.g, (Class<?>) LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            aVar.g.startActivity(intent);
        } catch (Exception e) {
            aa.b("MBridge SDK M", ApCustomRewardCPMError.EXCEPTION_MESSAGE, e);
        }
    }

    static /* synthetic */ void a(a aVar, final boolean z, final Campaign campaign) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.click.a.5
            @Override // java.lang.Runnable
            public final void run() {
                if (z && !a.a && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    a.f(a.this);
                }
                if (a.this.i == null || a.a || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    return;
                }
                a.this.i.onDismissLoading(campaign);
            }
        });
    }

    static /* synthetic */ void f(a aVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            aVar.g.sendBroadcast(intent);
        } catch (Exception e) {
            aa.b("MBridge SDK M", ApCustomRewardCPMError.EXCEPTION_MESSAGE, e);
        }
    }
}
