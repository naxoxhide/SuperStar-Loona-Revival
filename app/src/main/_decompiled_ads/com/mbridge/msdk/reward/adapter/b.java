package com.mbridge.msdk.reward.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, a> f2354b;
    private final h a;
    private boolean c;
    private final String d;
    private final String e;
    private volatile List<WindVaneWebView> f;

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    public interface c {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList);

        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.entity.e eVar);
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    public interface i {
        void a(String str, String str2, String str3, String str4);

        void a(String str, String str2, String str3, String str4, com.mbridge.msdk.foundation.entity.e eVar);
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    public interface j {
        void a(String str, String str2, String str3, String str4, String str5, com.mbridge.msdk.videocommon.a.C0524a c0524a);

        void a(String str, String str2, String str3, String str4, String str5, com.mbridge.msdk.videocommon.a.C0524a c0524a, com.mbridge.msdk.foundation.entity.e eVar);
    }

    private b() {
        this.d = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
        this.e = "down_type";
        this.f = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        f2354b = new ConcurrentHashMap<>();
        handlerThread.start();
        this.a = new h(handlerThread.getLooper());
    }

    public static b a() {
        return m.a;
    }

    public final synchronized void a(final Context context, boolean z, int i2, boolean z2, final int i3, final String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, c cVar, final i iVar) {
        String str4 = str2 + "_" + str3;
        f2354b.put(str4, new a(z, z2, i2, copyOnWriteArrayList.size(), str2, str3, i3, copyOnWriteArrayList));
        this.a.a(str, str2, str3, cVar);
        this.a.a(context);
        this.a.a(str4, copyOnWriteArrayList);
        this.a.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.1
            /* JADX WARN: Code duplicated, block: B:122:0x0337  */
            /* JADX WARN: Code duplicated, block: B:145:0x0280 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:149:0x024c A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:151:0x02c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:157:0x02f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:50:0x0157  */
            /* JADX WARN: Code duplicated, block: B:61:0x01b8 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:62:0x01ba  */
            /* JADX WARN: Code duplicated, block: B:63:0x01ce A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:64:0x01d0  */
            /* JADX WARN: Code duplicated, block: B:65:0x01e4  */
            /* JADX WARN: Code duplicated, block: B:74:0x0222  */
            /* JADX WARN: Code duplicated, block: B:97:0x02ac  */
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it;
                String str5;
                String str6;
                CharSequence charSequence;
                CampaignEx campaignEx;
                CampaignEx.c cVar2;
                String str7;
                boolean zIsDynamicView;
                boolean zJ;
                CampaignEx campaignEx2;
                String iconUrl;
                String imageUrl;
                String strD;
                List<CampaignEx.c.a> listF;
                int i4;
                CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
                if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) {
                    return;
                }
                try {
                    com.mbridge.msdk.videocommon.download.i.a().a(copyOnWriteArrayList);
                    com.mbridge.msdk.videocommon.download.c.getInstance().createUnitCache(context, str2, copyOnWriteArrayList, i3, new f(b.this.a, str, str2, str3));
                    com.mbridge.msdk.videocommon.download.c.getInstance().load(str2);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                    }
                }
                Iterator it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    CampaignEx campaignEx3 = (CampaignEx) it2.next();
                    if (campaignEx3 != null) {
                        com.mbridge.msdk.foundation.same.report.m.a().a(campaignEx3);
                        String currentLRid = campaignEx3.getCurrentLRid();
                        try {
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 106;
                            Bundle bundle = new Bundle();
                            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                            bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                            bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str3);
                            messageObtain.setData(bundle);
                            b.this.a.sendMessage(messageObtain);
                        } catch (Exception unused) {
                        }
                        CampaignEx.c rewardTemplateMode = campaignEx3.getRewardTemplateMode();
                        if (rewardTemplateMode != null) {
                            String strE = rewardTemplateMode.e();
                            int iB = rewardTemplateMode.b();
                            if (campaignEx3.isDynamicView() && af.b(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, strE)) {
                                b.this.a(1, campaignEx3, iB + "", strE);
                            } else {
                                HashMap map = new HashMap();
                                try {
                                    map.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, currentLRid);
                                    map.put("down_type", "2");
                                } catch (Exception unused2) {
                                }
                                if (!TextUtils.isEmpty(strE) && !strE.contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                                    if (strE.contains(".zip")) {
                                        try {
                                            com.mbridge.msdk.videocommon.download.g gVarA = com.mbridge.msdk.videocommon.download.g.a();
                                            Context context2 = context;
                                            String str8 = str;
                                            String str9 = str2;
                                            String str10 = str3;
                                            it = it2;
                                            try {
                                                h hVar = b.this.a;
                                                i iVar2 = iVar;
                                                CopyOnWriteArrayList copyOnWriteArrayList3 = copyOnWriteArrayList;
                                                cVar2 = rewardTemplateMode;
                                                campaignEx = campaignEx3;
                                                str5 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                                str6 = "";
                                                charSequence = ".zip";
                                                try {
                                                    gVarA.a((Map<String, String>) map, strE, (com.mbridge.msdk.videocommon.download.g.a) new g(context2, str8, str9, str10, campaignEx3, 859, hVar, iVar2, copyOnWriteArrayList3));
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (MBridgeConstans.DEBUG) {
                                                        aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                                    }
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                str5 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                                str6 = "";
                                                charSequence = ".zip";
                                                campaignEx = campaignEx3;
                                                cVar2 = rewardTemplateMode;
                                                if (MBridgeConstans.DEBUG) {
                                                    aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                                }
                                                str7 = campaignEx.getendcard_url();
                                                zIsDynamicView = campaignEx.isDynamicView();
                                                zJ = af.j(str7);
                                                if (TextUtils.isEmpty(str7)) {
                                                    campaignEx2 = campaignEx;
                                                } else {
                                                    if (!zIsDynamicView) {
                                                        b.a(b.this, context, str, str2, str3, campaignEx, str7, iVar, copyOnWriteArrayList);
                                                    } else if (zJ) {
                                                        b.a(b.this, context, str, str2, str3, campaignEx, str7, iVar, copyOnWriteArrayList);
                                                    } else if (TextUtils.isEmpty(str7)) {
                                                    }
                                                    campaignEx2 = campaignEx;
                                                }
                                                if (!TextUtils.isEmpty(campaignEx2.getEndScreenUrl())) {
                                                    com.mbridge.msdk.videocommon.download.g.a().a(campaignEx2.getEndScreenUrl(), (com.mbridge.msdk.videocommon.download.g.b) null);
                                                }
                                                iconUrl = campaignEx2.getIconUrl();
                                                if (!TextUtils.isEmpty(iconUrl)) {
                                                    try {
                                                        com.mbridge.msdk.foundation.same.c.b.a(context).a(iconUrl, new e(b.this.a, 0, str, str2, str3, campaignEx2));
                                                    } catch (Exception e5) {
                                                        if (MBridgeConstans.DEBUG) {
                                                            aa.d("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                                                        }
                                                    }
                                                }
                                                imageUrl = campaignEx2.getImageUrl();
                                                if (!TextUtils.isEmpty(imageUrl)) {
                                                    try {
                                                        com.mbridge.msdk.foundation.same.c.b.a(context).a(imageUrl, new e(b.this.a, 0, str, str2, str3, campaignEx2));
                                                    } catch (Exception e6) {
                                                        if (MBridgeConstans.DEBUG) {
                                                            aa.d("RewardCampaignsResourceManager", e6.getLocalizedMessage());
                                                        }
                                                    }
                                                }
                                                if (cVar2 != null) {
                                                    strD = cVar2.d();
                                                    if (!TextUtils.isEmpty(strD)) {
                                                        if (strD.contains(charSequence)) {
                                                            try {
                                                                com.mbridge.msdk.videocommon.download.g.a().b(strD, new g(context, str, str2, str3, campaignEx2, 313, b.this.a, iVar, copyOnWriteArrayList));
                                                            } catch (Exception e7) {
                                                                if (MBridgeConstans.DEBUG) {
                                                                    aa.d("RewardCampaignsResourceManager", e7.getLocalizedMessage());
                                                                }
                                                            }
                                                        } else {
                                                            try {
                                                                com.mbridge.msdk.videocommon.download.g.a().b(strD, new d(313, str, str2, str3, campaignEx2, iVar, b.this.a, copyOnWriteArrayList));
                                                            } catch (Exception e8) {
                                                                if (MBridgeConstans.DEBUG) {
                                                                    aa.d("RewardCampaignsResourceManager", e8.getLocalizedMessage());
                                                                }
                                                            }
                                                        }
                                                    }
                                                    listF = cVar2.f();
                                                    if (listF != null) {
                                                        while (r11.hasNext()) {
                                                            if (aVar == null) {
                                                            }
                                                        }
                                                    }
                                                }
                                                it2 = it;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            it = it2;
                                        }
                                    } else {
                                        it = it2;
                                        str5 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                        str6 = "";
                                        charSequence = ".zip";
                                        campaignEx = campaignEx3;
                                        cVar2 = rewardTemplateMode;
                                        try {
                                            com.mbridge.msdk.videocommon.download.g.a().a(map, strE, new d(859, str, str2, str3, campaignEx, iVar, b.this.a, copyOnWriteArrayList));
                                        } catch (Exception e10) {
                                            if (MBridgeConstans.DEBUG) {
                                                aa.d("RewardCampaignsResourceManager", e10.getLocalizedMessage());
                                            }
                                        }
                                    }
                                }
                            }
                            it = it2;
                            str5 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                            str6 = "";
                            charSequence = ".zip";
                            campaignEx = campaignEx3;
                            cVar2 = rewardTemplateMode;
                        } else {
                            it = it2;
                            str5 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                            str6 = "";
                            charSequence = ".zip";
                            campaignEx = campaignEx3;
                            cVar2 = rewardTemplateMode;
                        }
                        str7 = campaignEx.getendcard_url();
                        zIsDynamicView = campaignEx.isDynamicView();
                        zJ = af.j(str7);
                        if (TextUtils.isEmpty(str7)) {
                            campaignEx2 = campaignEx;
                        } else {
                            if (!zIsDynamicView) {
                                b.a(b.this, context, str, str2, str3, campaignEx, str7, iVar, copyOnWriteArrayList);
                            } else if (zJ) {
                                b.a(b.this, context, str, str2, str3, campaignEx, str7, iVar, copyOnWriteArrayList);
                            } else if (TextUtils.isEmpty(str7) && af.b(str5, str7)) {
                                try {
                                    i4 = Integer.parseInt(al.a(str7, "ecid"));
                                } catch (Throwable th) {
                                    aa.d("RewardCampaignsResourceManager", th.getMessage());
                                    i4 = 404;
                                }
                                String str11 = i4 + str6;
                                campaignEx2 = campaignEx;
                                b.this.a(2, campaignEx2, str11, str7);
                            }
                            campaignEx2 = campaignEx;
                        }
                        if (!TextUtils.isEmpty(campaignEx2.getEndScreenUrl()) && !campaignEx2.isDynamicView()) {
                            com.mbridge.msdk.videocommon.download.g.a().a(campaignEx2.getEndScreenUrl(), (com.mbridge.msdk.videocommon.download.g.b) null);
                        }
                        iconUrl = campaignEx2.getIconUrl();
                        if (!TextUtils.isEmpty(iconUrl)) {
                            com.mbridge.msdk.foundation.same.c.b.a(context).a(iconUrl, new e(b.this.a, 0, str, str2, str3, campaignEx2));
                        }
                        imageUrl = campaignEx2.getImageUrl();
                        if (!TextUtils.isEmpty(imageUrl)) {
                            com.mbridge.msdk.foundation.same.c.b.a(context).a(imageUrl, new e(b.this.a, 0, str, str2, str3, campaignEx2));
                        }
                        if (cVar2 != null) {
                            strD = cVar2.d();
                            if (!TextUtils.isEmpty(strD) && !campaignEx2.isDynamicView()) {
                                if (strD.contains(charSequence)) {
                                    com.mbridge.msdk.videocommon.download.g.a().b(strD, new g(context, str, str2, str3, campaignEx2, 313, b.this.a, iVar, copyOnWriteArrayList));
                                } else {
                                    com.mbridge.msdk.videocommon.download.g.a().b(strD, new d(313, str, str2, str3, campaignEx2, iVar, b.this.a, copyOnWriteArrayList));
                                }
                            }
                            listF = cVar2.f();
                            if (listF != null && listF.size() > 0) {
                                for (CampaignEx.c.a aVar : listF) {
                                    if (aVar == null && aVar.f2084b != null && aVar.f2084b.size() > 0) {
                                        for (String str12 : aVar.f2084b) {
                                            if (!TextUtils.isEmpty(str12)) {
                                                try {
                                                    com.mbridge.msdk.foundation.same.c.b.a(context).a(str12, new e(b.this.a, 1, str, str2, str3, campaignEx2));
                                                } catch (Exception e11) {
                                                    if (MBridgeConstans.DEBUG) {
                                                        aa.d("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        it2 = it;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i2, final CampaignEx campaignEx, String str, String str2) {
        com.mbridge.msdk.foundation.tools.k.a(i2, str, str2, new com.mbridge.msdk.foundation.tools.k.a() { // from class: com.mbridge.msdk.reward.adapter.b.2
            @Override // com.mbridge.msdk.foundation.tools.k.a
            public final void a(String str3, String str4, String str5, boolean z) {
                if (z) {
                    return;
                }
                try {
                    n nVar = new n();
                    int i3 = i2;
                    if (i3 == 0) {
                        nVar.a(1);
                        nVar.e(1);
                        nVar.r("2000045");
                    } else if (i3 == 1) {
                        nVar.a(2);
                        nVar.e(1);
                        nVar.r("2000045");
                    } else if (i3 == 2) {
                        nVar.e(14);
                        nVar.r("2000043");
                        nVar.b(campaignEx.isMraid() ? n.a : n.f2098b);
                        nVar.g("1");
                    }
                    b.a(nVar, campaignEx);
                    nVar.q(campaignEx.getId());
                    nVar.f(str3);
                    nVar.m(campaignEx.getRequestId());
                    nVar.n(campaignEx.getCurrentLRid());
                    nVar.o(campaignEx.getRequestIdNotice());
                    com.mbridge.msdk.foundation.same.report.m.a().a(nVar, campaignEx);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }

            @Override // com.mbridge.msdk.foundation.tools.k.a
            public final void a(String str3, DownloadError downloadError) {
                String message = "";
                if (downloadError != null) {
                    try {
                        if (downloadError.getException() != null) {
                            message = downloadError.getException().getMessage();
                        }
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                n nVar = new n();
                int i3 = i2;
                if (i3 == 0) {
                    nVar.a(1);
                    nVar.e(3);
                    nVar.r("2000045");
                } else if (i3 == 1) {
                    nVar.a(2);
                    nVar.e(3);
                    nVar.r("2000045");
                } else if (i3 == 2) {
                    nVar.a(3);
                    nVar.e(3);
                    nVar.r("2000043");
                    nVar.b(campaignEx.isMraid() ? n.a : n.f2098b);
                    nVar.g("1");
                }
                b.a(nVar, campaignEx);
                nVar.q(campaignEx.getId());
                nVar.f(str3);
                nVar.m(campaignEx.getRequestId());
                nVar.n(campaignEx.getCurrentLRid());
                nVar.o(campaignEx.getRequestIdNotice());
                nVar.s(message);
                com.mbridge.msdk.foundation.same.report.m.a().a(nVar, campaignEx);
            }
        }, campaignEx);
    }

    public final synchronized void a(final Context context, final CampaignEx campaignEx, final String str, final String str2, final String str3, final i iVar) {
        try {
            this.a.a(context);
            if (campaignEx != null) {
                String cMPTEntryUrl = campaignEx.getCMPTEntryUrl();
                if (campaignEx.isDynamicView()) {
                    if (af.b(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, cMPTEntryUrl)) {
                        a(0, campaignEx, campaignEx.getMof_tplid() + "", cMPTEntryUrl);
                    }
                    com.mbridge.msdk.videocommon.download.i.a().b(cMPTEntryUrl, true);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 105;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str3);
                    bundle.putString("url", cMPTEntryUrl);
                    messageObtain.setData(bundle);
                    this.a.sendMessage(messageObtain);
                    if (iVar != null) {
                        iVar.a(str, str2, str3, cMPTEntryUrl);
                    }
                    return;
                }
            }
            if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                try {
                    HashMap map = new HashMap();
                    try {
                        map.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, campaignEx.getCurrentLRid());
                        map.put("down_type", "1");
                    } catch (Exception unused) {
                    }
                    com.mbridge.msdk.videocommon.download.g.a().a((Map<String, String>) map, campaignEx.getCMPTEntryUrl(), (com.mbridge.msdk.videocommon.download.g.a) new com.mbridge.msdk.videocommon.download.g.d() { // from class: com.mbridge.msdk.reward.adapter.b.3
                        @Override // com.mbridge.msdk.videocommon.download.g.a
                        public final void a(String str4, boolean z) {
                            try {
                                com.mbridge.msdk.videocommon.download.i.a().b(str4, true);
                                Message messageObtain2 = Message.obtain();
                                messageObtain2.what = 105;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                bundle2.putString(MBridgeConstans.PLACEMENT_ID, str);
                                bundle2.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str3);
                                bundle2.putString("url", str4);
                                messageObtain2.setData(bundle2);
                                b.this.a.sendMessage(messageObtain2);
                                i iVar2 = iVar;
                                if (iVar2 != null) {
                                    iVar2.a(str, str2, str3, str4);
                                }
                                if (z) {
                                    return;
                                }
                                b.a(b.this, context, 1, campaignEx, str4, "", str2);
                            } catch (Exception e2) {
                                com.mbridge.msdk.videocommon.download.i.a().b(str4, false);
                                Message messageObtain3 = Message.obtain();
                                messageObtain3.what = 205;
                                Bundle bundle3 = new Bundle();
                                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                bundle3.putString(MBridgeConstans.PLACEMENT_ID, str);
                                bundle3.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str3);
                                bundle3.putString("url", str4);
                                messageObtain3.setData(bundle3);
                                b.this.a.sendMessage(messageObtain3);
                                if (iVar != null) {
                                    try {
                                        iVar.a(str, str2, str3, str4, new com.mbridge.msdk.foundation.entity.e(5, e2.getLocalizedMessage()));
                                    } catch (Exception unused2) {
                                    }
                                }
                                b.a(b.this, context, 3, campaignEx, str4, e2.getLocalizedMessage(), str2);
                                if (MBridgeConstans.DEBUG) {
                                    aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                                }
                            }
                        }

                        @Override // com.mbridge.msdk.videocommon.download.g.a
                        public final void a(String str4, String str5) {
                            try {
                                com.mbridge.msdk.videocommon.download.i.a().b(str5, false);
                                Message messageObtain2 = Message.obtain();
                                messageObtain2.what = 205;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                bundle2.putString(MBridgeConstans.PLACEMENT_ID, str);
                                bundle2.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str3);
                                bundle2.putString("url", str5);
                                bundle2.putString("message", str4);
                                messageObtain2.setData(bundle2);
                                b.this.a.sendMessage(messageObtain2);
                                if (iVar != null) {
                                    try {
                                        iVar.a(str, str2, str3, str5, new com.mbridge.msdk.foundation.entity.e(5, str4));
                                    } catch (Exception unused2) {
                                    }
                                }
                                try {
                                    b.a(b.this, context, 3, campaignEx, str5, str4, str2);
                                } catch (Exception e2) {
                                    e = e2;
                                    com.mbridge.msdk.videocommon.download.i.a().b(str5, false);
                                    Message messageObtain3 = Message.obtain();
                                    messageObtain3.what = 105;
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                    bundle3.putString(MBridgeConstans.PLACEMENT_ID, str);
                                    bundle3.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, str3);
                                    bundle3.putString("url", str5);
                                    bundle3.putString("message", e.getMessage());
                                    messageObtain3.setData(bundle3);
                                    b.this.a.sendMessage(messageObtain3);
                                    if (iVar != null) {
                                        try {
                                            iVar.a(str, str2, str3, str5, new com.mbridge.msdk.foundation.entity.e(5, str4));
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    if (MBridgeConstans.DEBUG) {
                                        aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                            }
                        }
                    });
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class e implements com.mbridge.msdk.foundation.same.c.c {
        private Handler a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2364b;
        private String c;
        private String d;
        private String e;
        private CampaignEx f;

        public e(Handler handler, int i, String str, String str2, String str3, CampaignEx campaignEx) {
            this.a = handler;
            this.f2364b = i;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(Bitmap bitmap, String str) {
            com.mbridge.msdk.videocommon.download.i.a().c(str, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = this.f2364b == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
            messageObtain.setData(bundle);
            this.a.sendMessage(messageObtain);
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(final String str, String str2) {
            Message messageObtain = Message.obtain();
            messageObtain.what = this.f2364b == 0 ? 202 : 204;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
            messageObtain.setData(bundle);
            this.a.sendMessage(messageObtain);
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (e.this.f != null) {
                        try {
                            q qVarA = q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                            aa.a("RewardCampaignsResourceManager", "campaign is null");
                            n nVar = new n();
                            nVar.r("2000044");
                            nVar.d(w.r(com.mbridge.msdk.foundation.controller.b.d().g()));
                            nVar.q(e.this.f.getId());
                            nVar.d(e.this.f.getImageUrl());
                            nVar.m(e.this.f.getRequestId());
                            nVar.o(e.this.f.getRequestIdNotice());
                            nVar.p(e.this.c);
                            nVar.s(str);
                            qVarA.a(nVar);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                            }
                        }
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.c.a();
            com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class f implements com.mbridge.msdk.videocommon.listener.a {
        private Handler a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2366b;
        private final String c;
        private final String d;

        public f(Handler handler, String str, String str2, String str3) {
            this.a = handler;
            this.c = str;
            this.f2366b = str2;
            this.d = str3;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str) {
            com.mbridge.msdk.videocommon.download.i.a().a(str, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f2366b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.d);
            bundle.putString("url", str);
            messageObtain.setData(bundle);
            this.a.sendMessage(messageObtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().a(str2, false);
            Message messageObtain = Message.obtain();
            messageObtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f2366b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.d);
            bundle.putString("url", str2);
            bundle.putString("message", str);
            messageObtain.setData(bundle);
            this.a.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class g implements com.mbridge.msdk.videocommon.download.g.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f2367b;
        private String c;
        private String d;
        private String e;
        private CampaignEx f;
        private int g;
        private Handler h;
        private i i;
        private CopyOnWriteArrayList<CampaignEx> j;
        private boolean a = false;
        private long k = System.currentTimeMillis();

        public g(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i, Handler handler, i iVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f2367b = context;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = i;
            this.h = handler;
            this.i = iVar;
            this.j = copyOnWriteArrayList;
        }

        public final void a(boolean z) {
            this.a = z;
        }

        @Override // com.mbridge.msdk.videocommon.download.g.a
        public final void a(String str, boolean z) {
            com.mbridge.msdk.videocommon.download.i.a().b(str, true);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
            int i = this.g;
            if (i == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.a) {
                    a(14, jCurrentTimeMillis, str, "");
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 103;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle3.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
            messageObtain3.setData(bundle3);
            this.h.sendMessage(messageObtain3);
            i iVar = this.i;
            if (iVar != null) {
                iVar.a(this.d, this.c, this.e, str);
            }
            if (z) {
                return;
            }
            a(1, str, "");
        }

        private void a(final int i, final String str, final String str2) {
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.f == null || g.this.f2367b == null) {
                        return;
                    }
                    try {
                        n nVar = new n();
                        nVar.r("2000045");
                        if (g.this.f2367b != null) {
                            nVar.d(w.r(g.this.f2367b.getApplicationContext()));
                        }
                        nVar.e(i);
                        if (g.this.f != null) {
                            nVar.q(g.this.f.getId());
                            nVar.m(g.this.f.getRequestId());
                            nVar.n(g.this.f.getCurrentLRid());
                            nVar.o(g.this.f.getRequestIdNotice());
                        }
                        nVar.i(str);
                        nVar.s(str2);
                        nVar.p(g.this.c);
                        if (ac.a().a("r_l_b_m_t_r_i", true)) {
                            nVar.a(2);
                            b.a(nVar, g.this.f);
                            com.mbridge.msdk.foundation.same.report.m.a().a(nVar, g.this.f);
                            return;
                        }
                        q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(nVar);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                }
            });
        }

        private void a(final int i, final long j, final String str, final String str2) {
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.f == null) {
                        return;
                    }
                    try {
                        n nVar = new n("2000043", i, j + "", str, g.this.f.getId(), g.this.c, str2, "1");
                        nVar.m(g.this.f.getRequestId());
                        nVar.n(g.this.f.getCurrentLRid());
                        nVar.o(g.this.f.getRequestIdNotice());
                        nVar.q(g.this.f.getId());
                        nVar.c(g.this.f.getAdSpaceT());
                        if (g.this.f.getAdType() != 287) {
                            if (g.this.f.getAdType() == 94) {
                                nVar.h("1");
                            }
                        } else {
                            nVar.h("3");
                        }
                        b.a(nVar, g.this.f);
                        com.mbridge.msdk.foundation.same.report.n.a(nVar, g.this.c, g.this.f);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                }
            });
        }

        @Override // com.mbridge.msdk.videocommon.download.g.a
        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().b(str2, false);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
            int i = this.g;
            if (i == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
                bundle.putString("url", str2);
                bundle.putString("message", str);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
                bundle2.putString("url", str2);
                bundle2.putString("message", str);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.a) {
                    a(3, jCurrentTimeMillis, str2, "zip download failed");
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 203;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle3.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
            bundle3.putString("url", str2);
            bundle3.putString("message", str);
            messageObtain3.setData(bundle3);
            this.h.sendMessage(messageObtain3);
            if (this.i != null) {
                try {
                    this.i.a(this.d, this.c, this.e, str2, new com.mbridge.msdk.foundation.entity.e(6, str));
                } catch (Exception unused) {
                }
            }
            a(3, str2, str);
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class d implements com.mbridge.msdk.videocommon.download.g.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2362b;
        private final String c;
        private final String d;
        private final String e;
        private CampaignEx f;
        private i g;
        private Handler h;
        private CopyOnWriteArrayList<CampaignEx> i;
        private boolean a = false;
        private final long j = System.currentTimeMillis();

        public d(int i, String str, String str2, String str3, CampaignEx campaignEx, i iVar, Handler handler, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f2362b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = iVar;
            this.h = handler;
            this.i = copyOnWriteArrayList;
        }

        public final void a(boolean z) {
            this.a = z;
        }

        @Override // com.mbridge.msdk.videocommon.download.g.a
        public final void a(String str, boolean z) {
            com.mbridge.msdk.videocommon.download.i.a().b(str, true);
            int i = this.f2362b;
            if (i == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.a) {
                    a(20, System.currentTimeMillis() - this.j, str, "");
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 105;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle3.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
            messageObtain3.setData(bundle3);
            this.h.sendMessage(messageObtain3);
            i iVar = this.g;
            if (iVar != null) {
                iVar.a(this.c, this.d, this.e, str);
            }
        }

        private void a(final int i, final long j, final String str, final String str2) {
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.f == null) {
                        return;
                    }
                    try {
                        n nVar = new n("2000043", i, j + "", str, d.this.f.getId(), d.this.d, str2, "2");
                        nVar.m(d.this.f.getRequestId());
                        nVar.n(d.this.f.getCurrentLRid());
                        nVar.o(d.this.f.getRequestIdNotice());
                        nVar.q(d.this.f.getId());
                        nVar.c(d.this.f.getAdSpaceT());
                        if (d.this.f.getAdType() != 287) {
                            if (d.this.f.getAdType() == 94) {
                                nVar.h("1");
                            }
                        } else {
                            nVar.h("3");
                        }
                        b.a(nVar, d.this.f);
                        com.mbridge.msdk.foundation.same.report.n.a(nVar, d.this.d, d.this.f);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                }
            });
        }

        @Override // com.mbridge.msdk.videocommon.download.g.a
        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().b(str, false);
            int i = this.f2362b;
            if (i == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
                bundle.putString("url", str);
                bundle.putString("message", str2);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
                bundle2.putString("url", str);
                bundle2.putString("message", str2);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.a) {
                    a(21, System.currentTimeMillis() - this.j, str, "url download failed");
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 205;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle3.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.e);
            bundle3.putString("message", str2);
            messageObtain3.setData(bundle3);
            this.h.sendMessage(messageObtain3);
            if (this.g != null) {
                try {
                    this.g.a(this.c, this.d, this.e, str, new com.mbridge.msdk.foundation.entity.e(6, str2));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class h extends Handler {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ConcurrentHashMap<String, c> f2370b;
        private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> c;

        public h(Looper looper) {
            super(looper);
            this.f2370b = new ConcurrentHashMap<>();
            this.c = new ConcurrentHashMap<>();
        }

        public final void a(String str, String str2, String str3, c cVar) {
            this.f2370b.put(str2 + "_" + str3, cVar);
        }

        public final void a(Context context) {
            this.a = context;
        }

        public final void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.c.put(str, copyOnWriteArrayList);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean zA;
            Bundle data = message.getData();
            String string = data.getString(MBridgeConstans.PLACEMENT_ID);
            String string2 = data.getString(MBridgeConstans.PROPERTIES_UNIT_ID);
            String string3 = data.getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
            String str = string2 + "_" + string3;
            a aVar = (a) b.f2354b.get(str);
            c cVar = this.f2370b.get(str);
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.c.get(str);
            int i = message.what;
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                    break;
                default:
                    switch (i) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (aVar != null && cVar != null) {
                                String string4 = data.getString("message");
                                if (string4 == null) {
                                    string4 = "";
                                }
                                com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e(message.what, "resource download failed " + b.b(message.what) + " " + string4, true);
                                CampaignEx campaignEx = null;
                                if (aVar.h != null && aVar.h.size() > 0) {
                                    campaignEx = aVar.h.get(0);
                                }
                                try {
                                    try {
                                        if (aVar.a && aVar.i != null) {
                                            if (aVar.c == 1) {
                                                if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                                                    int i2 = message.what;
                                                    if (i2 != 200) {
                                                        if (i2 != 201) {
                                                            if (i2 != 203) {
                                                                if (i2 == 205) {
                                                                    if (!campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                        if (aVar.h != null && aVar.h.size() > 0) {
                                                                            CampaignEx campaignEx2 = aVar.h.get(0);
                                                                            if (campaignEx2.getCMPTEntryUrl().equals(campaignEx2.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                            }
                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                        }
                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                    }
                                                }
                                                cVar.a(string, string2, string3, aVar.h, eVar);
                                                this.f2370b.remove(str);
                                                b.f2354b.remove(str);
                                                this.c.remove(str);
                                            } else {
                                                String string5 = data.getString("url");
                                                int i3 = message.what;
                                                if (i3 == 200) {
                                                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                        aa.b("RewardCampaignsResourceManager", "Is TPL but  video download fail but hit ignoreCheckRule");
                                                    } else {
                                                        for (int i4 = 0; i4 < aVar.i.size(); i4++) {
                                                            if (aVar.i.get(i4).getVideoUrlEncode().equals(string5)) {
                                                                aVar.i.remove(i4);
                                                            }
                                                        }
                                                        b.f2354b.remove(str);
                                                        b.f2354b.put(str, aVar);
                                                    }
                                                    break;
                                                } else if (i3 == 201) {
                                                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                        aa.b("RewardCampaignsResourceManager", "Is TPL but download endcard fail but hit ignoreCheckRule");
                                                    } else {
                                                        for (int i5 = 0; i5 < aVar.i.size(); i5++) {
                                                            CampaignEx campaignEx3 = aVar.i.get(i5);
                                                            if (campaignEx3.getRewardTemplateMode() != null && campaignEx3.getRewardTemplateMode().d().equals(string5)) {
                                                                aVar.i.remove(i5);
                                                            }
                                                            if (!TextUtils.isEmpty(campaignEx3.getendcard_url()) && campaignEx3.getendcard_url().equals(string5)) {
                                                                aVar.i.remove(i5);
                                                            }
                                                        }
                                                        b.f2354b.remove(str);
                                                        b.f2354b.put(str, aVar);
                                                    }
                                                    break;
                                                } else if (i3 == 203) {
                                                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                        aa.b("RewardCampaignsResourceManager", "Is TPL but download template fail but hit ignoreCheckRule");
                                                    } else {
                                                        for (int i6 = 0; i6 < aVar.i.size(); i6++) {
                                                            CampaignEx campaignEx4 = aVar.i.get(i6);
                                                            if (campaignEx4.getRewardTemplateMode() != null && campaignEx4.getRewardTemplateMode().e().equals(string5)) {
                                                                aVar.i.remove(i6);
                                                            }
                                                        }
                                                        b.f2354b.remove(str);
                                                        b.f2354b.put(str, aVar);
                                                    }
                                                    break;
                                                } else if (i3 == 205) {
                                                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                        aa.b("RewardCampaignsResourceManager", "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                    } else {
                                                        aVar.i.clear();
                                                        b.f2354b.remove(str);
                                                        b.f2354b.put(str, aVar);
                                                    }
                                                    break;
                                                }
                                                if (com.mbridge.msdk.videocommon.download.c.getInstance().a(94, aVar.e, aVar.f2360b, aVar.d, aVar.a, aVar.c, copyOnWriteArrayList)) {
                                                    cVar.a(string, string2, string3, aVar.h);
                                                    this.f2370b.remove(str);
                                                    b.f2354b.remove(str);
                                                    this.c.remove(str);
                                                } else if (aVar.i.size() == 0) {
                                                    cVar.a(string, string2, string3, aVar.h, eVar);
                                                    this.f2370b.remove(str);
                                                    b.f2354b.remove(str);
                                                    this.c.remove(str);
                                                }
                                            }
                                        } else {
                                            if (com.mbridge.msdk.videocommon.download.c.getInstance().a(94, aVar.e, aVar.f2360b, aVar.d, aVar.a, aVar.c, copyOnWriteArrayList)) {
                                                cVar.a(string, string2, string3, aVar.h);
                                            } else {
                                                if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                                                    int i7 = message.what;
                                                    if (i7 != 200) {
                                                        if (i7 != 201) {
                                                            if (i7 == 203) {
                                                                if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                                }
                                                            } else if (i7 == 205 && campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                            }
                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                        }
                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                    }
                                                }
                                                cVar.a(string, string2, string3, aVar.h, eVar);
                                            }
                                            this.f2370b.remove(str);
                                            b.f2354b.remove(str);
                                            this.c.remove(str);
                                        }
                                    } catch (Exception unused) {
                                        cVar.a(string, string2, string3, aVar.h, eVar);
                                        return;
                                    }
                                    break;
                                } catch (Exception unused2) {
                                }
                            }
                            break;
                    }
                    return;
            }
            if (aVar == null || cVar == null) {
                return;
            }
            try {
                zA = com.mbridge.msdk.videocommon.download.c.getInstance().a(94, aVar.e, aVar.f2360b, aVar.d, aVar.a, aVar.c, copyOnWriteArrayList);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                }
                zA = false;
            }
            if (zA) {
                cVar.a(string, string2, string3, aVar.h);
                this.f2370b.remove(str);
                b.f2354b.remove(str);
                this.c.remove(str);
            }
        }
    }

    public final synchronized void a(boolean z, Handler handler, boolean z2, boolean z3, WindVaneWebView windVaneWebView, String str, int i2, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str2, String str3, String str4, String str5, String str6, com.mbridge.msdk.videocommon.d.c cVar, j jVar) {
        WindVaneWebView windVaneWebView2;
        com.mbridge.msdk.video.signal.a.j jVar2;
        String str7 = str4 + "_" + str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (af.i(str)) {
                if (jVar != null) {
                    jVar.a(str7, str3, str4, str5, str, null);
                }
                return;
            }
            try {
                com.mbridge.msdk.reward.c.a.a(campaignEx, com.mbridge.msdk.foundation.controller.b.d().g(), "start preload template ", str4, z3, str5, str6, System.currentTimeMillis() - jCurrentTimeMillis);
            } catch (Exception unused) {
            }
            HashMap map = new HashMap();
            map.put("type", "2");
            com.mbridge.msdk.foundation.same.report.m.a().a("2000154", campaignEx, map);
            com.mbridge.msdk.videocommon.a.C0524a c0524a = new com.mbridge.msdk.videocommon.a.C0524a();
            WindVaneWebView windVaneWebViewA = m.a.a(false);
            if (windVaneWebViewA == null) {
                try {
                    WindVaneWebView windVaneWebView3 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
                    if (campaignEx != null) {
                        windVaneWebView3.setLocalRequestId(campaignEx.getCurrentLRid());
                    }
                    windVaneWebView3.setTempTypeForMetrics(2);
                    windVaneWebView2 = windVaneWebView3;
                } catch (Exception e2) {
                    if (jVar != null) {
                        c0524a.a(true);
                        com.mbridge.msdk.videocommon.download.i.a().d(str4 + "_" + str5 + "_" + str, true);
                        try {
                            com.mbridge.msdk.reward.c.a.a(campaignEx, com.mbridge.msdk.foundation.controller.b.d().g(), "WebView exception: " + e2.getMessage(), str4, z3, str5, str6, System.currentTimeMillis() - jCurrentTimeMillis);
                        } catch (Exception unused2) {
                        }
                        jVar.a(str4 + "_" + str, str3, str4, str5, str, c0524a);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (jVar != null) {
                        c0524a.a(true);
                        com.mbridge.msdk.videocommon.download.i.a().d(str4 + "_" + str5 + "_" + str, true);
                        try {
                            com.mbridge.msdk.reward.c.a.a(campaignEx, com.mbridge.msdk.foundation.controller.b.d().g(), "WebView exception: " + th.getMessage(), str4, z3, str5, str6, System.currentTimeMillis() - jCurrentTimeMillis);
                        } catch (Exception unused3) {
                        }
                        jVar.a(str4 + "_" + str, str3, str4, str5, str, c0524a);
                        return;
                    }
                    return;
                }
            } else {
                windVaneWebView2 = windVaneWebViewA;
            }
            c0524a.a(windVaneWebView2);
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                jVar2 = new com.mbridge.msdk.video.signal.a.j(null, campaignEx, copyOnWriteArrayList);
            } else {
                jVar2 = new com.mbridge.msdk.video.signal.a.j(null, campaignEx);
            }
            com.mbridge.msdk.video.signal.a.j jVar3 = jVar2;
            jVar3.a(i2);
            jVar3.a(str4);
            jVar3.a(cVar);
            jVar3.d(z);
            WindVaneWebView windVaneWebView4 = windVaneWebView2;
            try {
                windVaneWebView4.setWebViewListener(new k(handler, null, z2, z3, str5, jVar, windVaneWebView, str, str3, str4, c0524a, campaignEx, copyOnWriteArrayList, jCurrentTimeMillis));
                windVaneWebView4.setObject(jVar3);
                windVaneWebView4.loadUrl(str2);
                try {
                    windVaneWebView4.setRid(str5);
                } catch (Exception e3) {
                    e = e3;
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                    if (jVar != null) {
                        jVar.a(str7, str3, str4, str5, str, null, new com.mbridge.msdk.foundation.entity.e(9, e.getLocalizedMessage()));
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized String b(int i2) {
        if (i2 == 200) {
            return "video";
        }
        if (i2 == 201) {
            return "zip/html";
        }
        if (i2 != 203) {
            return i2 != 205 ? "unknown" : "tpl";
        }
        return "temp";
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static class k extends com.mbridge.msdk.mbsignalcommon.b.b {
        private Handler a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Runnable f2371b;
        private final boolean c;
        private final boolean d;
        private String e;
        private final j f;
        private final WindVaneWebView g;
        private final String h;
        private final String i;
        private final String j;
        private final com.mbridge.msdk.videocommon.a.C0524a k;
        private final CampaignEx l;
        private CopyOnWriteArrayList<CampaignEx> m;
        private long n;
        private boolean o;
        private boolean p;
        private final Runnable q;
        private final Runnable r;

        public k(Handler handler, Runnable runnable, boolean z, final boolean z2, final String str, final j jVar, WindVaneWebView windVaneWebView, final String str2, final String str3, final String str4, final com.mbridge.msdk.videocommon.a.C0524a c0524a, final CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, final long j) {
            this.a = handler;
            this.f2371b = runnable;
            this.c = z;
            this.d = z2;
            this.e = str;
            this.f = jVar;
            this.g = windVaneWebView;
            this.h = str2;
            this.i = str4;
            this.j = str3;
            this.k = c0524a;
            this.l = campaignEx;
            this.m = copyOnWriteArrayList;
            this.n = j;
            Runnable runnable2 = new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.k.1
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView windVaneWebViewA;
                    com.mbridge.msdk.videocommon.a.C0524a c0524a2;
                    if (jVar != null && (c0524a2 = c0524a) != null) {
                        c0524a2.a(true);
                        com.mbridge.msdk.videocommon.download.i.a().d(str4 + "_" + str + "_" + str2, true);
                        try {
                            com.mbridge.msdk.reward.c.a.a(campaignEx, com.mbridge.msdk.foundation.controller.b.d().g(), "WebView onPageFinish timeout exception after 5s", str4, z2, str, campaignEx.getRequestIdNotice(), System.currentTimeMillis() - j);
                        } catch (Exception unused) {
                        }
                        jVar.a(str4 + "_" + str2, str3, str4, str, str2, c0524a);
                    }
                    com.mbridge.msdk.videocommon.a.C0524a c0524a3 = c0524a;
                    if (c0524a3 == null || (windVaneWebViewA = c0524a3.a()) == null) {
                        return;
                    }
                    try {
                        windVaneWebViewA.release();
                    } catch (Exception unused2) {
                    }
                }
            };
            this.r = runnable2;
            this.q = new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.k.2
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView windVaneWebViewA;
                    com.mbridge.msdk.videocommon.a.C0524a c0524a2;
                    if (jVar != null && (c0524a2 = c0524a) != null) {
                        c0524a2.a(true);
                        com.mbridge.msdk.videocommon.download.i.a().d(str4 + "_" + str + "_" + str2, true);
                        try {
                            com.mbridge.msdk.reward.c.a.a(campaignEx, com.mbridge.msdk.foundation.controller.b.d().g(), "WebView readyState timeout exception after 5s", str4, z2, str, campaignEx.getRequestIdNotice(), System.currentTimeMillis() - j);
                        } catch (Exception unused) {
                        }
                        jVar.a(str4 + "_" + str2, str3, str4, str, str2, c0524a);
                    }
                    com.mbridge.msdk.videocommon.a.C0524a c0524a3 = c0524a;
                    if (c0524a3 == null || (windVaneWebViewA = c0524a3.a()) == null) {
                        return;
                    }
                    try {
                        windVaneWebViewA.release();
                    } catch (Exception unused2) {
                    }
                }
            };
            if (handler != null) {
                handler.postDelayed(runnable2, 5000L);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i);
            Handler handler2 = this.a;
            if (handler2 != null && (runnable2 = this.q) != null) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.a;
            if (handler3 != null && (runnable = this.r) != null) {
                handler3.removeCallbacks(runnable);
            }
            try {
                HashMap map = new HashMap();
                map.put("result", i + "");
                map.put("type", "2");
                com.mbridge.msdk.foundation.same.report.m.a().a("2000155", this.l, map);
            } catch (Throwable th) {
                aa.d("WindVaneWebView", th.getMessage());
            }
            if (this.p) {
                return;
            }
            try {
                com.mbridge.msdk.reward.c.a.a(this.l, com.mbridge.msdk.foundation.controller.b.d().g(), "preload temp readState: " + i, this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
            } catch (Exception unused) {
            }
            String str = this.i + "_" + this.h;
            if (i == 1) {
                Runnable runnable3 = this.f2371b;
                if (runnable3 != null && (handler = this.a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, true);
                com.mbridge.msdk.videocommon.a.C0524a c0524a = this.k;
                if (c0524a != null) {
                    c0524a.a(true);
                }
                if (this.c) {
                    if (this.d) {
                        com.mbridge.msdk.videocommon.a.a(287, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(287, this.l.getRequestIdNotice(), this.k);
                    }
                } else if (this.d) {
                    com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                }
                j jVar = this.f;
                if (jVar != null) {
                    jVar.a(str, this.j, this.i, this.e, this.h, this.k);
                }
            } else if (this.f != null) {
                this.f.a(str, this.j, this.i, this.e, this.h, this.k, new com.mbridge.msdk.foundation.entity.e(9, "state " + i));
            }
            this.p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, false);
            try {
                com.mbridge.msdk.reward.c.a.a(this.l, com.mbridge.msdk.foundation.controller.b.d().g(), "WebView onReceivedError exception: " + str, this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
            } catch (Exception unused) {
            }
            Handler handler = this.a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                String str3 = this.i + "_" + this.h;
                com.mbridge.msdk.videocommon.a.C0524a c0524a = this.k;
                if (c0524a != null) {
                    c0524a.a(false);
                }
                if (this.f != null) {
                    this.f.a(str3, this.j, this.i, this.e, str2, this.k, new com.mbridge.msdk.foundation.entity.e(8, str));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, false);
            try {
                com.mbridge.msdk.reward.c.a.a(this.l, com.mbridge.msdk.foundation.controller.b.d().g(), "WebView onReceivedSslError exception: " + (sslError == null ? "SSLError" : Integer.toString(sslError.getPrimaryError())), this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
            } catch (Exception unused) {
            }
            Handler handler = this.a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                String str = this.i + "_" + this.h;
                com.mbridge.msdk.videocommon.a.C0524a c0524a = this.k;
                if (c0524a != null) {
                    c0524a.a(false);
                }
                if (this.f != null) {
                    this.f.a(str, this.j, this.i, this.e, this.h, this.k, new com.mbridge.msdk.foundation.entity.e(8, sslError == null ? "" : Integer.toString(sslError.getPrimaryError())));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.a;
            if (handler2 != null && (runnable2 = this.r) != null) {
                handler2.removeCallbacks(runnable2);
            }
            if (this.o) {
                return;
            }
            try {
                com.mbridge.msdk.reward.c.a.a(this.l, com.mbridge.msdk.foundation.controller.b.d().g(), "preload temp onPageFinish", this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
            } catch (Exception unused) {
            }
            if (!str.contains("wfr=1")) {
                String str2 = this.i + "_" + this.h;
                com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, true);
                Runnable runnable3 = this.f2371b;
                if (runnable3 != null && (handler = this.a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                com.mbridge.msdk.videocommon.a.C0524a c0524a = this.k;
                if (c0524a != null) {
                    c0524a.a(true);
                }
                if (this.c) {
                    if (this.l.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(287, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(287, this.l.getRequestIdNotice(), this.k);
                    }
                } else if (this.l.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                }
                j jVar = this.f;
                if (jVar != null) {
                    jVar.a(str2, this.j, this.i, this.e, this.h, this.k);
                }
            } else {
                Handler handler3 = this.a;
                if (handler3 != null && (runnable = this.q) != null) {
                    handler3.postDelayed(runnable, 5000L);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
            this.o = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x01f7 A[Catch: all -> 0x0225, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x000d, B:7:0x0036, B:10:0x004a, B:11:0x0067, B:13:0x008c, B:15:0x009b, B:16:0x00a2, B:17:0x00a5, B:19:0x00be, B:21:0x00c4, B:23:0x00ce, B:26:0x00d5, B:28:0x00db, B:29:0x00e5, B:31:0x00eb, B:33:0x00ff, B:35:0x010d, B:37:0x0116, B:38:0x011a, B:40:0x0127, B:42:0x0178, B:44:0x018e, B:46:0x01ae, B:58:0x01f7, B:59:0x0216, B:61:0x021a, B:39:0x0121), top: B:70:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:61:0x021a A[Catch: all -> 0x0225, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x000d, B:7:0x0036, B:10:0x004a, B:11:0x0067, B:13:0x008c, B:15:0x009b, B:16:0x00a2, B:17:0x00a5, B:19:0x00be, B:21:0x00c4, B:23:0x00ce, B:26:0x00d5, B:28:0x00db, B:29:0x00e5, B:31:0x00eb, B:33:0x00ff, B:35:0x010d, B:37:0x0116, B:38:0x011a, B:40:0x0127, B:42:0x0178, B:44:0x018e, B:46:0x01ae, B:58:0x01f7, B:59:0x0216, B:61:0x021a, B:39:0x0121), top: B:70:0x000d }] */
    public final synchronized void a(boolean z, Handler handler, boolean z2, boolean z3, String str, String str2, String str3, String str4, String str5, int i2, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str6, String str7, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z4) {
        com.mbridge.msdk.video.signal.a.j jVar2;
        this.c = z4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str8 = str4 + "_" + str5;
        this.c = z4;
        if (af.i(str5)) {
            if (jVar != null) {
                jVar.a(str8, str3, str4, str, str5, null);
            }
            return;
        }
        try {
            com.mbridge.msdk.reward.c.a.a(campaignEx, com.mbridge.msdk.foundation.controller.b.d().g(), "start preload tpl", str7, z3, str, str2, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception unused) {
        }
        try {
            HashMap map = new HashMap();
            map.put("type", "1");
            com.mbridge.msdk.foundation.same.report.m.a().a("2000154", campaignEx, map);
            com.mbridge.msdk.videocommon.a.C0524a c0524a = new com.mbridge.msdk.videocommon.a.C0524a();
            WindVaneWebView windVaneWebViewA = m.a.a(true);
            if (windVaneWebViewA == null) {
                windVaneWebViewA = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
                if (campaignEx != null) {
                    windVaneWebViewA.setLocalRequestId(campaignEx.getCurrentLRid());
                }
                windVaneWebViewA.setTempTypeForMetrics(1);
            }
            WindVaneWebView windVaneWebView = windVaneWebViewA;
            c0524a.a(windVaneWebView);
            String strB = com.mbridge.msdk.video.bt.a.c.a().b();
            String strB2 = com.mbridge.msdk.video.bt.a.c.a().b();
            c0524a.a(strB2);
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.c.getInstance().a(str4);
                if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                    for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                        CampaignEx campaignEx2 = copyOnWriteArrayList.get(i3);
                        for (CampaignEx campaignEx3 : copyOnWriteArrayListA) {
                            if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                campaignEx2.setReady(true);
                                copyOnWriteArrayList.set(i3, campaignEx2);
                            }
                        }
                    }
                }
                jVar2 = new com.mbridge.msdk.video.signal.a.j(null, campaignEx, copyOnWriteArrayList);
            } else {
                jVar2 = new com.mbridge.msdk.video.signal.a.j(null, campaignEx);
            }
            com.mbridge.msdk.video.signal.a.j jVar3 = jVar2;
            jVar3.a(i2);
            jVar3.a(str7);
            jVar3.c(strB2);
            jVar3.d(strB);
            jVar3.c(true);
            jVar3.a(cVar);
            jVar3.d(z);
            try {
                windVaneWebView.setWebViewListener(new C0501b(z, handler, null, z2, z3, i2, str5, str3, str4, str, c0524a, campaignEx, copyOnWriteArrayList, cVar, jVar, z4, jCurrentTimeMillis));
                windVaneWebView.setObject(jVar3);
                windVaneWebView.loadUrl(str6);
                try {
                    windVaneWebView.setRid(str);
                    MBridgeBTRootLayout mBridgeBTRootLayout = new MBridgeBTRootLayout(com.mbridge.msdk.foundation.controller.b.d().g());
                    mBridgeBTRootLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    mBridgeBTRootLayout.setInstanceId(strB);
                    try {
                        mBridgeBTRootLayout.setUnitId(str4);
                        MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.b.d().g());
                        mBridgeBTLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        mBridgeBTLayout.setInstanceId(strB2);
                        mBridgeBTLayout.setUnitId(str4);
                        mBridgeBTLayout.setWebView(windVaneWebView);
                        LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.c.a().b(str4, str);
                        linkedHashMapB.put(strB2, mBridgeBTLayout);
                        linkedHashMapB.put(strB, mBridgeBTRootLayout);
                        mBridgeBTRootLayout.addView(mBridgeBTLayout, new FrameLayout.LayoutParams(-1, -1));
                    } catch (Exception e2) {
                        e = e2;
                        if (jVar != null) {
                            jVar.a(str8, str3, str4, str, str5, null, new com.mbridge.msdk.foundation.entity.e(8, e.getMessage()));
                        }
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    if (jVar != null) {
                        jVar.a(str8, str3, str4, str, str5, null, new com.mbridge.msdk.foundation.entity.e(8, e.getMessage()));
                    }
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static class C0501b extends com.mbridge.msdk.mbsignalcommon.b.a {
        private final Handler a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f2361b;
        private final boolean c;
        private final boolean d;
        private int e;
        private String f;
        private String g;
        private String h;
        private String i;
        private com.mbridge.msdk.videocommon.a.C0524a j;
        private CampaignEx k;
        private CopyOnWriteArrayList<CampaignEx> l;
        private com.mbridge.msdk.videocommon.d.c m;
        private final j n;
        private boolean o;
        private boolean p;
        private boolean q;
        private int r = 0;
        private boolean s;
        private long t;

        public C0501b(boolean z, Handler handler, Runnable runnable, boolean z2, boolean z3, int i, String str, String str2, String str3, String str4, com.mbridge.msdk.videocommon.a.C0524a c0524a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z4, long j) {
            this.a = handler;
            this.f2361b = runnable;
            this.c = z2;
            this.d = z3;
            this.e = i;
            this.f = str;
            this.h = str2;
            this.g = str3;
            this.i = str4;
            this.j = c0524a;
            this.k = campaignEx;
            this.l = copyOnWriteArrayList;
            this.m = cVar;
            this.n = jVar;
            this.o = z4;
            this.s = z;
            this.t = j;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i) {
            Runnable runnable;
            try {
                HashMap map = new HashMap();
                map.put("result", i + "");
                map.put("type", "1");
                com.mbridge.msdk.foundation.same.report.m.a().a("2000155", this.k, map);
            } catch (Throwable th) {
                aa.d("RVWindVaneWebView", th.getMessage());
            }
            if (this.q) {
                return;
            }
            try {
                com.mbridge.msdk.reward.c.a.a(this.k, com.mbridge.msdk.foundation.controller.b.d().g(), "preload tpl readyState: " + i, this.g, this.d, this.i, this.k.getRequestIdNotice(), System.currentTimeMillis() - this.t);
            } catch (Exception unused) {
            }
            String str = this.g + "_" + this.f;
            if (i == 1) {
                if (this.o) {
                    com.mbridge.msdk.videocommon.a.e(this.g + "_" + this.i);
                } else {
                    com.mbridge.msdk.videocommon.a.d(this.g + "_" + this.i);
                }
                com.mbridge.msdk.videocommon.a.a(this.g + "_" + this.i + "_" + this.f, this.j, true, this.o);
                Handler handler = this.a;
                if (handler != null && (runnable = this.f2361b) != null) {
                    handler.removeCallbacks(runnable);
                }
                com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, true);
                com.mbridge.msdk.videocommon.a.C0524a c0524a = this.j;
                if (c0524a != null) {
                    c0524a.a(true);
                }
                j jVar = this.n;
                if (jVar != null) {
                    jVar.a(str, this.h, this.g, this.i, this.f, this.j);
                }
            } else {
                com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, false);
                com.mbridge.msdk.videocommon.a.C0524a c0524a2 = this.j;
                if (c0524a2 != null) {
                    c0524a2.a(false);
                }
                if (this.n != null) {
                    this.n.a(str, this.h, this.g, this.i, this.f, this.j, new com.mbridge.msdk.foundation.entity.e(8, "state 2"));
                }
            }
            this.q = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a
        public final void a(WebView webView, String str, String str2, int i, int i2) {
            boolean z = true;
            if (i == 1) {
                try {
                    com.mbridge.msdk.reward.b.a aVar = new com.mbridge.msdk.reward.b.a();
                    aVar.b(false);
                    if (i2 != 2) {
                        z = false;
                    }
                    aVar.a(z);
                    aVar.b(str, str2);
                    aVar.a(new com.mbridge.msdk.video.bt.module.b.a(null));
                    aVar.a(false, (Map<String, String>) new HashMap());
                } catch (Exception unused) {
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:36:0x00fa A[Catch: all -> 0x0133, TRY_LEAVE, TryCatch #1 {all -> 0x0133, blocks: (B:16:0x0069, B:18:0x006f, B:21:0x0077, B:23:0x0085, B:24:0x008a, B:27:0x00b3, B:29:0x00b7, B:30:0x00c0, B:32:0x00ce, B:34:0x00de, B:35:0x00e4, B:36:0x00fa, B:37:0x00ff, B:40:0x0127, B:42:0x012b), top: B:55:0x0069, inners: #2, #3 }] */
        @Override // com.mbridge.msdk.mbsignalcommon.b.a
        public final void a(Object obj, String str) {
            if (obj != null) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    final String strOptString = new JSONObject(str).optString("id");
                    com.mbridge.msdk.video.bt.a.c.a().a(obj, strOptString);
                    final String strC = com.mbridge.msdk.video.bt.a.c.a().c(strOptString);
                    final CampaignEx campaignExA = com.mbridge.msdk.video.bt.a.c.a().a(strOptString);
                    final com.mbridge.msdk.videocommon.d.c cVarB = com.mbridge.msdk.video.bt.a.c.a().b(strOptString);
                    final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(campaignExA);
                    com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                    if (aVar.a instanceof WindVaneWebView) {
                        final WindVaneWebView windVaneWebView = aVar.a;
                        final b bVar = m.a;
                        final boolean z = this.s;
                        int i = this.r == 0 ? 3 : 6;
                        if (windVaneWebView != null) {
                            if (campaignExA != null && cVarB != null) {
                                try {
                                    if (campaignExA.getRewardTemplateMode() == null || TextUtils.isEmpty(strC)) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("id", strOptString);
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("result", 2);
                                        jSONObject2.put("error", "data is null");
                                        jSONObject.put("data", jSONObject2);
                                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                                    } else if (TextUtils.isEmpty(campaignExA.getRewardTemplateMode().e())) {
                                        JSONObject jSONObject3 = new JSONObject();
                                        try {
                                            jSONObject3.put("id", strOptString);
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("result", 1);
                                            jSONObject4.put("error", "data is null");
                                            jSONObject3.put("data", jSONObject4);
                                            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                                        } catch (Exception e) {
                                            if (MBridgeConstans.DEBUG) {
                                                aa.d("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                            }
                                        }
                                    } else if (!TextUtils.isEmpty(campaignExA.getRewardTemplateMode().e()) && campaignExA.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                                        aa.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                                    } else {
                                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.5
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                b.a(b.this, z, windVaneWebView, campaignExA.getRewardTemplateMode().e(), 0, campaignExA, copyOnWriteArrayList, com.mbridge.msdk.videocommon.download.g.a().b(campaignExA.getRewardTemplateMode().e()), strC, cVarB, strOptString, b.this.c);
                                            }
                                        }, i * 1000);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } else {
                                JSONObject jSONObject5 = new JSONObject();
                                try {
                                    jSONObject5.put("id", strOptString);
                                    JSONObject jSONObject6 = new JSONObject();
                                    jSONObject6.put("result", 2);
                                    jSONObject6.put("error", "data is null");
                                    jSONObject5.put("data", jSONObject6);
                                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject5.toString().getBytes(), 2));
                                } catch (Exception e2) {
                                    if (MBridgeConstans.DEBUG) {
                                        aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                                    }
                                }
                            }
                        }
                        this.r++;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
                aa.d("RVWindVaneWebView", th.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (this.p) {
                return;
            }
            try {
                com.mbridge.msdk.reward.c.a.a(this.k, com.mbridge.msdk.foundation.controller.b.d().g(), "preload tpl onPageFinish", this.g, this.d, this.i, this.k.getRequestIdNotice(), System.currentTimeMillis() - this.t);
            } catch (Exception unused) {
            }
            String str2 = this.g + "_" + this.f;
            if (!str.contains("wfr=1")) {
                com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, true);
                Handler handler = this.a;
                if (handler != null && (runnable = this.f2361b) != null) {
                    handler.removeCallbacks(runnable);
                }
                com.mbridge.msdk.videocommon.a.C0524a c0524a = this.j;
                if (c0524a != null) {
                    c0524a.a(true);
                }
                j jVar = this.n;
                if (jVar != null) {
                    jVar.a(str2, this.h, this.g, this.i, this.f, this.j);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
            this.p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, false);
            if (this.n != null) {
                String str3 = this.g + "_" + this.f;
                com.mbridge.msdk.videocommon.a.C0524a c0524a = this.j;
                if (c0524a != null) {
                    c0524a.a(false);
                }
                this.n.a(str3, this.h, this.g, this.i, this.f, this.j, new com.mbridge.msdk.foundation.entity.e(8, str));
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView) {
            if (webView != null) {
                try {
                    try {
                        LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.c.a().b(this.g, this.i);
                        if (linkedHashMapB != null && !linkedHashMapB.isEmpty()) {
                            for (View view : linkedHashMapB.values()) {
                                if (view instanceof MBridgeBTContainer) {
                                    ((MBridgeBTContainer) view).addNativeCloseButtonWhenWebViewCrash();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        aa.d("OperateViews", th.getMessage());
                    }
                } catch (Throwable th2) {
                    aa.d("RVWindVaneWebView", th2.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    static final class m {
        private static final b a = new b();
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static class l extends com.mbridge.msdk.mbsignalcommon.b.b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f2374b;
        private final WindVaneWebView c;
        private final String d;
        private final String e;
        private final com.mbridge.msdk.videocommon.a.C0524a f;
        private final CampaignEx g;
        private boolean h;
        private String i;
        private boolean j;
        private boolean k;

        public l(String str, boolean z, WindVaneWebView windVaneWebView, String str2, String str3, com.mbridge.msdk.videocommon.a.C0524a c0524a, CampaignEx campaignEx, boolean z2, String str4) {
            this.f2374b = z;
            this.c = windVaneWebView;
            this.d = str2;
            this.e = str3;
            this.f = c0524a;
            this.g = campaignEx;
            this.a = str;
            this.h = z2;
            this.i = str4;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i) {
            try {
                HashMap map = new HashMap();
                map.put("result", i + "");
                map.put("type", "2");
                com.mbridge.msdk.foundation.same.report.m.a().a("2000155", this.g, map);
            } catch (Throwable th) {
                aa.d("WindVaneWebView", th.getMessage());
            }
            if (this.k) {
                return;
            }
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject2.put("error", "");
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
            String str = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
            if (i == 1) {
                com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, true);
                com.mbridge.msdk.videocommon.a.C0524a c0524a = this.f;
                if (c0524a != null) {
                    c0524a.a(true);
                }
                if (this.f2374b) {
                    if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    }
                } else if (this.g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                }
            } else {
                com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, false);
                com.mbridge.msdk.videocommon.a.C0524a c0524a2 = this.f;
                if (c0524a2 != null) {
                    c0524a2.a(false);
                }
            }
            this.k = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i, String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, false);
            com.mbridge.msdk.videocommon.a.C0524a c0524a = this.f;
            if (c0524a != null) {
                c0524a.a(false);
            }
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            if (this.j) {
                return;
            }
            if (!str.contains("wfr=1")) {
                if (this.c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "");
                        jSONObject.put("data", jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("WindVaneWebView", e.getLocalizedMessage());
                        }
                    }
                }
                com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, true);
                com.mbridge.msdk.videocommon.a.C0524a c0524a = this.f;
                if (c0524a != null) {
                    c0524a.a(true);
                }
                String str2 = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
                if (this.f2374b) {
                    if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(287, this.g.getRequestIdNotice(), this.f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                    }
                } else if (this.g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.g.getRequestIdNotice(), this.f);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
            this.j = true;
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static class a {
        boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f2360b;
        int c;
        int d;
        String e;
        String f;
        int g;
        CopyOnWriteArrayList<CampaignEx> h;
        CopyOnWriteArrayList<CampaignEx> i;

        public a(boolean z, boolean z2, int i, int i2, String str, String str2, int i3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.a = z;
            this.f2360b = z2;
            this.c = i;
            this.d = i2;
            this.e = str;
            this.f = str2;
            this.g = i3;
            this.h = copyOnWriteArrayList;
            this.i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    private synchronized WindVaneWebView a(boolean z) {
        return null;
    }

    static /* synthetic */ void a(b bVar, Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, i iVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        if (TextUtils.isEmpty(str4) || campaignEx.isMraid()) {
            return;
        }
        HashMap map = new HashMap();
        try {
            map.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, campaignEx.getCurrentLRid());
            map.put("down_type", "3");
        } catch (Exception unused) {
        }
        if (str4.contains(".zip") && str4.contains("md5filename")) {
            boolean zIsEmpty = TextUtils.isEmpty(com.mbridge.msdk.videocommon.download.g.a().b(str4));
            try {
                g gVar = new g(context, str, str2, str3, campaignEx, 497, bVar.a, iVar, copyOnWriteArrayList);
                gVar.a(zIsEmpty);
                com.mbridge.msdk.videocommon.download.g.a().a((Map<String, String>) map, str4, (com.mbridge.msdk.videocommon.download.g.a) gVar);
                return;
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean zIsEmpty2 = TextUtils.isEmpty(com.mbridge.msdk.videocommon.download.h.a().b(str4));
        try {
            d dVar = new d(497, str, str2, str3, campaignEx, iVar, bVar.a, copyOnWriteArrayList);
            dVar.a(zIsEmpty2);
            com.mbridge.msdk.videocommon.download.g.a().a(map, str4, dVar);
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardCampaignsResourceManager", e3.getLocalizedMessage());
            }
        }
    }

    static /* synthetic */ void a(n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), campaignEx.getCampaignUnitId());
            if (cVarA != null) {
                nVar.l(cVarA.l());
            }
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB != null) {
                nVar.k(aVarB.c());
            }
        } catch (Exception e2) {
            aa.d("RewardCampaignsResourceManager", e2.getMessage());
        }
    }

    static /* synthetic */ void a(b bVar, final Context context, final int i2, final CampaignEx campaignEx, final String str, final String str2, final String str3) {
        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.4
            @Override // java.lang.Runnable
            public final void run() {
                if (campaignEx == null || context == null) {
                    return;
                }
                try {
                    n nVar = new n();
                    nVar.r("2000045");
                    Context context2 = context;
                    if (context2 != null) {
                        nVar.d(w.r(context2.getApplicationContext()));
                    }
                    nVar.e(i2);
                    CampaignEx campaignEx2 = campaignEx;
                    if (campaignEx2 != null) {
                        nVar.q(campaignEx2.getId());
                        nVar.m(campaignEx.getRequestId());
                        nVar.n(campaignEx.getCurrentLRid());
                        nVar.o(campaignEx.getRequestIdNotice());
                    }
                    nVar.i(str);
                    nVar.s(str2);
                    nVar.p(str3);
                    if (ac.a().a("r_l_b_m_t_r_i", true)) {
                        nVar.a(1);
                        b.a(nVar, campaignEx);
                        com.mbridge.msdk.foundation.same.report.m.a().a(nVar, campaignEx);
                        return;
                    }
                    q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(nVar);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                    }
                }
            }
        });
    }

    static /* synthetic */ void a(b bVar, boolean z, WindVaneWebView windVaneWebView, String str, int i2, CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar, String str4, boolean z2) {
        com.mbridge.msdk.video.signal.a.j jVar;
        String requestId;
        try {
            HashMap map = new HashMap();
            map.put("type", "2");
            com.mbridge.msdk.foundation.same.report.m.a().a(campaignEx);
            com.mbridge.msdk.foundation.same.report.m.a().a("2000154", campaignEx, map);
            com.mbridge.msdk.videocommon.a.C0524a c0524a = new com.mbridge.msdk.videocommon.a.C0524a();
            WindVaneWebView windVaneWebViewA = m.a.a(false);
            if (windVaneWebViewA == null) {
                windVaneWebViewA = new WindVaneWebView(com.mbridge.msdk.foundation.controller.b.d().g());
                if (campaignEx != null) {
                    windVaneWebViewA.setLocalRequestId(campaignEx.getCurrentLRid());
                    windVaneWebViewA.setTempTypeForMetrics(2);
                }
            }
            WindVaneWebView windVaneWebView2 = windVaneWebViewA;
            c0524a.a(windVaneWebView2);
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.c.getInstance().a(str3);
                if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                    for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                        CampaignEx campaignEx2 = (CampaignEx) copyOnWriteArrayList.get(i3);
                        for (CampaignEx campaignEx3 : copyOnWriteArrayListA) {
                            if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                campaignEx2.setReady(true);
                                copyOnWriteArrayList.set(i3, campaignEx2);
                            }
                        }
                    }
                }
                jVar = new com.mbridge.msdk.video.signal.a.j(null, campaignEx, copyOnWriteArrayList);
                requestId = ((CampaignEx) copyOnWriteArrayList.get(0)).getRequestId();
            } else {
                jVar = new com.mbridge.msdk.video.signal.a.j(null, campaignEx);
                requestId = campaignEx.getRequestId();
            }
            String str5 = requestId;
            com.mbridge.msdk.video.signal.a.j jVar2 = jVar;
            jVar2.a(i2);
            jVar2.a(str3);
            jVar2.c(str4);
            jVar2.a(cVar);
            jVar2.d(z);
            windVaneWebView2.setWebViewListener(new l(str4, false, windVaneWebView, str, str3, c0524a, campaignEx, z2, str5));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(str5);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
            }
        }
    }
}
