package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.mbbanner.common.b.d;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.videocommon.download.g;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: BannerLoader.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static final String a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2262b;
    private com.mbridge.msdk.mbbanner.common.a.c d;
    private com.mbridge.msdk.mbbanner.common.util.a e;
    private com.mbridge.msdk.mbbanner.common.b.b f;
    private d g;
    private int c = 0;
    private volatile boolean h = false;
    private Timer i = new Timer();
    private volatile List<String> j = new ArrayList();
    private volatile boolean k = false;
    private volatile boolean l = false;
    private volatile boolean m = false;

    public b(Context context, com.mbridge.msdk.mbbanner.common.a.c cVar, com.mbridge.msdk.mbbanner.common.b.b bVar, com.mbridge.msdk.mbbanner.common.util.a aVar) {
        this.f2262b = context.getApplicationContext();
        this.d = cVar;
        this.f = bVar;
        this.e = aVar;
    }

    private void a(String str) {
        if (this.m) {
            return;
        }
        if ((this.k || this.l) && this.j.size() == 0) {
            this.h = true;
            this.m = true;
            this.i.cancel();
            this.e.a(this.f, str);
            this.g.a(str);
        }
    }

    public final void a(String str, int i, String str2, boolean z, CampaignEx campaignEx) {
        if (!z) {
            this.i.cancel();
            this.h = true;
            this.e.a(this.f, str, campaignEx);
            this.g.a(str);
            return;
        }
        if (i == 1) {
            synchronized (this) {
                this.j.remove(str2);
                if (this.j.size() == 0) {
                    a(str);
                }
            }
            return;
        }
        if (i == 2) {
            this.l = true;
            a(str);
        } else if (i == 3) {
            this.k = true;
            a(str);
        }
    }

    public final void a(String str, String str2, final com.mbridge.msdk.mbbanner.common.a.b bVar, d dVar) {
        boolean z;
        try {
            this.g = dVar;
            com.mbridge.msdk.mbbanner.common.f.a aVar = new com.mbridge.msdk.mbbanner.common.f.a() { // from class: com.mbridge.msdk.mbbanner.common.c.b.2
                @Override // com.mbridge.msdk.mbbanner.common.f.a
                public final void a(CampaignUnit campaignUnit) throws Throwable {
                    try {
                        HashMap map = new HashMap();
                        map.put("result", "1");
                        campaignUnit.setLocalRequestId(bVar.e());
                        m.a().a("2000126", campaignUnit.getAds(), map);
                    } catch (Exception unused) {
                    }
                    try {
                        b.this.e.a(b.this.f, campaignUnit, this.unitId);
                        b.a(b.this, this.unitId, campaignUnit);
                    } catch (Exception e) {
                        b.this.e.a(b.this.f, new e(3, e.getMessage()), this.unitId, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.ads.get(0));
                        b.this.g.a(this.unitId);
                    }
                }

                @Override // com.mbridge.msdk.mbbanner.common.f.a
                public final void a(int i, String str3) {
                    try {
                        String strE = bVar.e();
                        new HashMap().put("result", "2");
                        m.a().a("2000126", strE, new HashMap());
                    } catch (Exception unused) {
                    }
                    b.this.e.a(b.this.f, new e(3, str3), this.unitId, null);
                    b.this.g.a(this.unitId);
                }
            };
            aVar.setUnitId(str2);
            aVar.setPlacementId(str);
            aVar.setAdType(296);
            com.mbridge.msdk.mbbanner.common.e.a aVar2 = new com.mbridge.msdk.mbbanner.common.e.a(this.f2262b);
            this.c = b(str2);
            com.mbridge.msdk.foundation.same.net.g.d dVarA = com.mbridge.msdk.mbbanner.common.a.d.a(false, this.f2262b, str2, this.d.a(), this.c, bVar);
            String strH = af.h(str2);
            if (!TextUtils.isEmpty(strH)) {
                dVarA.a("j", strH);
            }
            String strC = bVar.c();
            if (TextUtils.isEmpty(strC)) {
                z = false;
            } else {
                aVar.a(strC);
                z = true;
            }
            this.e.a(z);
            try {
                HashMap map = new HashMap();
                map.put("auto_load", (bVar.f() ? 1 : 2) + "");
                m.a().a("2000125", bVar.e(), map);
            } catch (Exception unused) {
            }
            aVar2.choiceV3OrV5BySetting(1, dVarA, aVar, strC);
        } catch (Exception e) {
            e.printStackTrace();
            this.e.a(this.f, new e(1, e.getMessage()), str2, null);
            this.g.a(str2);
        }
    }

    private List<CampaignEx> a(String str, CampaignUnit campaignUnit) {
        ArrayList arrayList = new ArrayList();
        if (campaignUnit != null) {
            try {
                if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    for (int i = 0; i < ads.size(); i++) {
                        CampaignEx campaignEx = ads.get(i);
                        if (campaignEx != null && campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getBannerUrl()) || !TextUtils.isEmpty(campaignEx.getBannerHtml()) || !TextUtils.isEmpty(campaignEx.getImageUrl()))) {
                            if (af.b(campaignEx)) {
                                campaignEx.setRtinsType(af.c(this.f2262b, campaignEx.getPackageName()) ? 1 : 2);
                            }
                            if (campaignEx.getWtick() == 1 || !af.c(this.f2262b, campaignEx.getPackageName())) {
                                arrayList.add(campaignEx);
                            } else if (af.b(campaignEx)) {
                                arrayList.add(campaignEx);
                            } else {
                                af.a(str, campaignEx, com.mbridge.msdk.foundation.same.a.w);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private void a(String str, List<CampaignEx> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                this.j.add(campaignEx.getImageUrl());
                com.mbridge.msdk.foundation.same.c.b.a(this.f2262b).a(campaignEx.getImageUrl(), new a(this, str, campaignEx));
            }
        }
    }

    /* JADX INFO: compiled from: BannerLoader.java */
    private static class a implements com.mbridge.msdk.foundation.same.c.c {
        private b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2266b;
        private CampaignEx c;

        public a(b bVar, String str, CampaignEx campaignEx) {
            this.a = bVar;
            this.f2266b = str;
            this.c = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(Bitmap bitmap, String str) {
            if (MBridgeConstans.DEBUG) {
                aa.b(b.a, "DownloadImageListener campaign image success");
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(this.f2266b, 1, str, true, this.c);
            }
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                aa.b(b.a, "DownloadImageListener campaign image fail");
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(this.f2266b, 1, str2, false, this.c);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x008a  */
    private String a(String str, String str2, CampaignEx campaignEx) throws Throwable {
        Throwable th;
        File file;
        String absolutePath = "";
        if (!TextUtils.isEmpty(str2)) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        String strB = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
                        String md5 = SameMD5.getMD5(al.a(str2));
                        if (TextUtils.isEmpty(md5)) {
                            md5 = String.valueOf(System.currentTimeMillis());
                        }
                        File file2 = new File(strB, md5.concat(".html"));
                        Uri.parse(str2).getPath();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            fileOutputStream2.write(str2.getBytes());
                            fileOutputStream2.flush();
                            absolutePath = file2.getAbsolutePath();
                            fileOutputStream2.close();
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            } else {
                                file = new File(absolutePath);
                                if (file.exists()) {
                                    a(str, 2, str2, false, campaignEx);
                                } else {
                                    a(str, 2, str2, false, campaignEx);
                                }
                            }
                            return absolutePath;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            file = new File(absolutePath);
            if (file.exists() || !file.isFile() || !file.canRead()) {
                a(str, 2, str2, false, campaignEx);
            } else {
                a(str, 2, str2, true, campaignEx);
            }
        }
        return absolutePath;
    }

    private int b(String str) {
        try {
            int iB = this.d.b();
            if (iB > this.d.c()) {
                return 0;
            }
            return iB;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0069  */
    /* JADX WARN: Code duplicated, block: B:20:0x0070 A[Catch: Exception -> 0x0076, TRY_LEAVE, TryCatch #1 {Exception -> 0x0076, blocks: (B:12:0x0056, B:14:0x005c, B:15:0x0061, B:18:0x006a, B:20:0x0070), top: B:65:0x0056 }] */
    static /* synthetic */ void a(b bVar, final String str, final CampaignUnit campaignUnit) throws Throwable {
        CampaignEx campaignEx = null;
        if (campaignUnit == null) {
            bVar.e.a(bVar.f, new e(3, "campaignUnit is NULL!"), str, null);
            bVar.g.a(str);
            return;
        }
        List<CampaignEx> listA = bVar.a(str, campaignUnit);
        new Thread(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.b.3
            @Override // java.lang.Runnable
            public final void run() {
                k.a(h.a(b.this.f2262b)).b();
                CampaignUnit campaignUnit2 = campaignUnit;
                if (campaignUnit2 == null || campaignUnit2.getAds() == null || campaignUnit.getAds().size() <= 0) {
                    return;
                }
                BannerUtils.uisList(b.this.f2262b, campaignUnit.getAds());
            }
        }).start();
        if (listA == null || listA.size() == 0) {
            e eVar = new e(11, "Need show campaign list is NULL!");
            com.mbridge.msdk.mbbanner.common.util.a aVar = bVar.e;
            com.mbridge.msdk.mbbanner.common.b.b bVar2 = bVar.f;
            if (campaignUnit.getAds() != null && campaignUnit.getAds().size() != 0) {
                campaignEx = campaignUnit.getAds().get(0);
            }
            aVar.a(bVar2, eVar, str, campaignEx);
            bVar.g.a(str);
            try {
                com.mbridge.msdk.mbbanner.common.util.a aVar2 = bVar.e;
                q.a(com.mbridge.msdk.foundation.controller.b.d().g(), eVar, str, aVar2 != null ? aVar2.a() : false, campaignUnit);
                return;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        final CampaignEx campaignEx2 = listA.get(0);
        bVar.i.schedule(new TimerTask() { // from class: com.mbridge.msdk.mbbanner.common.c.b.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                if (b.this.h) {
                    return;
                }
                b.this.h = true;
                b.this.a(str, -1, "", false, campaignEx2);
            }
        }, 60000);
        bVar.d.a(campaignUnit.getSessionId());
        int size = bVar.c;
        if (listA != null) {
            try {
                if (listA.size() > 0) {
                    size += listA.size();
                }
                if (size > bVar.d.c()) {
                    size = 0;
                }
                if (ak.b(str)) {
                    bVar.d.a(size);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            if (size > bVar.d.c()) {
                size = 0;
            }
            if (ak.b(str)) {
                bVar.d.a(size);
            }
        }
        String strTrim = campaignEx2.getBannerUrl().trim();
        if (TextUtils.isEmpty(strTrim)) {
            String strTrim2 = campaignEx2.getBannerHtml().trim();
            if (!TextUtils.isEmpty(strTrim2)) {
                String strA = bVar.a(str, strTrim2, campaignEx2);
                if (listA != null && listA.size() > 0) {
                    for (int i = 0; i < listA.size(); i++) {
                        listA.get(i).setBannerHtml(strA);
                        listA.get(i).setHasMBTplMark(strTrim2.contains("<MBTPLMARK>"));
                    }
                }
            } else {
                bVar.l = true;
                bVar.k = true;
            }
        } else {
            if (!TextUtils.isEmpty(strTrim)) {
                g.a().a(strTrim, new com.mbridge.msdk.mbbanner.common.b.e(bVar, str, campaignEx2));
            }
            if (listA != null && listA.size() > 0) {
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    listA.get(i2).setBannerUrl(campaignEx2.getBannerUrl());
                    listA.get(i2).setHasMBTplMark(true);
                }
            }
        }
        bVar.a(str, listA);
    }
}
