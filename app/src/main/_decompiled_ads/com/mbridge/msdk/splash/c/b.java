package com.mbridge.msdk.splash.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.videocommon.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: ResManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2426b = "ResManager";
    private static int c = 1;
    public static f a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
    private static ConcurrentHashMap<String, Boolean> d = new ConcurrentHashMap<>();

    public static CampaignEx a(MBSplashView mBSplashView, String str, String str2, String str3, boolean z, int i, boolean z2, boolean z3) {
        if (a == null) {
            a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (cVarB == null) {
            cVarB = com.mbridge.msdk.c.d.a().b();
        }
        long jW = cVarB.W() * 1000;
        long jQ = cVarB.Q() * 1000;
        if (a == null) {
            a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        a.b(jQ, str2);
        List<CampaignEx> listA = a.a(str2, 0, 0, c, !TextUtils.isEmpty(str3));
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = listA.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - jW;
        if (!z2) {
            if (((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < jCurrentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j)) || !a(mBSplashView, campaignEx, str, str2, z, i, z3)) {
                return null;
            }
            return a(campaignEx);
        }
        if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= jCurrentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j)) {
            if (a(mBSplashView, campaignEx, str, str2, z, i, z3)) {
                return a(campaignEx);
            }
            return null;
        }
        if (a(mBSplashView, campaignEx, str, str2, z, i, z3) && campaignEx.isSpareOffer(jW, jQ)) {
            return a(campaignEx);
        }
        return null;
    }

    private static CampaignEx a(CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || (!TextUtils.isEmpty(campaignEx.getAdHtml()) && campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        } else {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        }
        return campaignEx;
    }

    private static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx, String str, String str2, boolean z, int i, boolean z2) {
        boolean z3;
        boolean zBooleanValue = false;
        if (campaignEx != null) {
            mBSplashView.clearResState();
            if (TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                z3 = true;
            } else {
                boolean z4 = mBSplashView.isVideoReady() || com.mbridge.msdk.videocommon.download.c.getInstance().a(297, str2, campaignEx.isBidCampaign());
                if (!z4) {
                    a(mBSplashView, campaignEx, str2);
                } else {
                    mBSplashView.setVideoReady(true);
                }
                z3 = z4;
            }
            if (!TextUtils.isEmpty(campaignEx.getAdZip()) && !mBSplashView.isH5Ready()) {
                String strB = g.a().b(campaignEx.getAdZip());
                if (TextUtils.isEmpty(strB)) {
                    z3 = false;
                } else if (!z2) {
                    a(mBSplashView, strB, campaignEx, str, str2, z, i);
                }
            }
            if (!TextUtils.isEmpty(campaignEx.getAdZip()) || TextUtils.isEmpty(campaignEx.getAdHtml()) || mBSplashView.isH5Ready()) {
                zBooleanValue = z3;
            } else {
                String strC = c(campaignEx.getAdHtml());
                if (!TextUtils.isEmpty(strC)) {
                    if (!z2) {
                        a(mBSplashView, strC, campaignEx, str, str2, z, i);
                    }
                    zBooleanValue = z3;
                }
            }
            if (campaignEx.isDynamicView()) {
                Boolean bool = d.get(campaignEx.getImageUrl());
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                }
                if (!zBooleanValue) {
                    a(mBSplashView, campaignEx, (com.mbridge.msdk.splash.view.nativeview.a) null);
                } else {
                    mBSplashView.setImageReady(true);
                }
            }
        }
        return zBooleanValue;
    }

    private static void a(final MBSplashView mBSplashView, CampaignEx campaignEx, String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.splash.c.b.1
            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str2) {
                mBSplashView.setVideoReady(true);
            }

            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str2, String str3) {
                mBSplashView.setVideoReady(false);
            }
        };
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.c.getInstance().createUnitCache(com.mbridge.msdk.foundation.controller.b.d().g(), str, copyOnWriteArrayList, 297, aVar);
        if (!com.mbridge.msdk.videocommon.download.c.getInstance().a(297, str, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.c.getInstance().load(str);
        } else {
            mBSplashView.setVideoReady(true);
        }
    }

    public static void a(final MBSplashView mBSplashView, final CampaignEx campaignEx, final com.mbridge.msdk.splash.view.nativeview.a aVar) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.c.b.2
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                b.d.put(campaignEx.getImageUrl(), true);
                com.mbridge.msdk.splash.view.nativeview.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
                MBSplashView mBSplashView2 = mBSplashView;
                if (mBSplashView2 != null) {
                    mBSplashView2.setImageReady(true);
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
                b.d.put(campaignEx.getImageUrl(), false);
                com.mbridge.msdk.splash.view.nativeview.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
                MBSplashView mBSplashView2 = mBSplashView;
                if (mBSplashView2 != null) {
                    mBSplashView2.setImageReady(false);
                }
            }
        });
        if (TextUtils.isEmpty(campaignEx.getIconUrl())) {
            return;
        }
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(campaignEx.getIconUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.c.b.3
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
            }
        });
    }

    private static void a(MBSplashView mBSplashView, String str, CampaignEx campaignEx, String str2, String str3, boolean z, int i) {
        e.c cVar = new e.c();
        cVar.c(str3);
        cVar.b(str2);
        cVar.a(campaignEx);
        cVar.a(str);
        cVar.a(z);
        cVar.a(i);
        e.a.a.a(mBSplashView, cVar, null);
    }

    private static String c(String str) {
        try {
            File file = new File(str);
            return file.exists() ? "file:///" + file.getAbsolutePath() : "";
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Exception e) {
                e.getMessage();
                return "";
            }
        }
    }

    public static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx) {
        if (mBSplashView == null) {
            return false;
        }
        boolean zIsVideoReady = TextUtils.isEmpty(campaignEx.getVideoUrlEncode()) ? true : mBSplashView.isVideoReady();
        if (zIsVideoReady && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            zIsVideoReady = mBSplashView.isH5Ready();
        }
        if (zIsVideoReady && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            zIsVideoReady = mBSplashView.isH5Ready();
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            zIsVideoReady = false;
        }
        if (!campaignEx.isDynamicView()) {
            return zIsVideoReady;
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return false;
        }
        return mBSplashView.isImageReady();
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (a == null) {
            a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        a.b(arrayList, str);
    }

    public static void a(String str) {
        if (a == null) {
            a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
        }
        a.a(str, 0, c);
    }

    public static void b(String str) {
        d.remove(str);
    }
}
