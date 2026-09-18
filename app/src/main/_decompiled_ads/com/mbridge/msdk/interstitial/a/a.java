package com.mbridge.msdk.interstitial.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.c;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.n;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: IntersAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2237b;
    private String c;
    private int d;
    private boolean e;
    private int f;
    private String g;
    private com.mbridge.msdk.interstitial.c.a.C0490a h;
    private f i;
    private Handler j;

    public a(Context context, String str, String str2, String str3, boolean z) {
        this.a = context;
        this.f2237b = str;
        this.c = str2;
        this.g = str3;
        this.e = z;
        f fVarE = d.a().e(b.d().h(), str);
        this.i = fVarE;
        if (fVarE == null) {
            this.i = f.f(this.f2237b);
        }
        this.j = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.interstitial.a.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                try {
                    int i = message.what;
                    if (i != 3) {
                        if (i == 4 && a.this.h != null && message.obj != null && (message.obj instanceof String)) {
                            a.this.h.b(a.this.e, (String) message.obj);
                        }
                    } else if (a.this.h != null && message.obj != null && (message.obj instanceof String)) {
                        a.this.h.a(a.this.e, (String) message.obj);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public final CampaignEx a() {
        try {
            if (TextUtils.isEmpty(this.f2237b)) {
                return null;
            }
            e();
            List<CampaignEx> listF = f();
            if (listF != null && listF.size() > 0) {
                for (int i = 0; i < listF.size(); i++) {
                    CampaignEx campaignEx = listF.get(i);
                    if (campaignEx != null && (!TextUtils.isEmpty(campaignEx.getHtmlUrl()) || !TextUtils.isEmpty(campaignEx.getMraid()))) {
                        return campaignEx;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public final void b() {
        if (this.a == null) {
            b("context is null");
            return;
        }
        if (TextUtils.isEmpty(this.f2237b)) {
            b("unitid is null");
            return;
        }
        f fVar = this.i;
        if (fVar == null) {
            b("unitSetting is null please call load");
            return;
        }
        if (fVar.p() <= 0) {
            b("controller don't request ad");
            return;
        }
        e();
        List<CampaignEx> listF = f();
        if (listF != null && listF.size() > 0) {
            CampaignEx campaignEx = listF.get(0);
            a(campaignEx != null ? campaignEx.getRequestId() : "");
            return;
        }
        try {
            if (this.a == null) {
                b("context is null");
                return;
            }
            if (TextUtils.isEmpty(this.f2237b)) {
                b("unitid is null");
                return;
            }
            if (this.i == null) {
                b("unitSetting is null please call load");
                return;
            }
            String strH = b.d().h();
            String md5 = SameMD5.getMD5(b.d().h() + b.d().j());
            int i = this.e ? 3 : 2;
            this.f = 1;
            if (this.i.q() > 0) {
                this.f = this.i.q();
            }
            int iP = this.i.p() > 0 ? this.i.p() : 1;
            String strA = com.mbridge.msdk.foundation.same.a.d.a(this.f2237b, ReportUtil.INVENTORY_TYPE_INTERSTITIAL);
            this.d = h();
            String strJ = j();
            if (TextUtils.isEmpty(this.g)) {
                this.g = "0";
            }
            com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "app_id", strH);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f2237b);
            if (!TextUtils.isEmpty(this.c)) {
                com.mbridge.msdk.foundation.same.net.f.b.a(dVar, MBridgeConstans.PLACEMENT_ID, this.c);
            }
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "sign", md5);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "category", this.g);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "req_type", i + "");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_num", iP + "");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "tnum", this.f + "");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "only_impression", "1");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ping_mode", "1");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.f2148b, strA);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.c, d());
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, "1");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, com.mbridge.msdk.foundation.same.net.g.d.a, strJ);
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "ad_type", "279");
            com.mbridge.msdk.foundation.same.net.f.b.a(dVar, "offset", this.d + "");
            String strH2 = af.h(this.f2237b);
            if (!TextUtils.isEmpty(strH2)) {
                dVar.a("j", strH2);
            }
            com.mbridge.msdk.interstitial.d.a aVar = new com.mbridge.msdk.interstitial.d.a(this.a);
            com.mbridge.msdk.interstitial.d.b bVar = new com.mbridge.msdk.interstitial.d.b() { // from class: com.mbridge.msdk.interstitial.a.a.2
                @Override // com.mbridge.msdk.interstitial.d.b
                public final void a(CampaignUnit campaignUnit) {
                    try {
                        a.a(a.this, campaignUnit);
                    } catch (Exception e) {
                        e.printStackTrace();
                        a.this.b("can't show because unknow error");
                        a.this.i();
                    }
                }

                @Override // com.mbridge.msdk.interstitial.d.b
                public final void a(int i2, String str) {
                    aa.d("IntersAdapter", str);
                    a.this.b(str);
                    a.this.i();
                }
            };
            bVar.setUnitId(this.f2237b);
            bVar.setPlacementId(this.c);
            bVar.setAdType(279);
            aVar.choiceV3OrV5BySetting(1, dVar, bVar, "");
        } catch (Exception e) {
            e.printStackTrace();
            b("can't show because unknow error");
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.j != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = str;
            messageObtain.what = 3;
            this.j.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.j != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 4;
                this.j.sendMessage(messageObtain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String d() {
        String strA = "";
        try {
            JSONArray jSONArrayA = af.a(this.a, this.f2237b);
            strA = jSONArrayA.length() > 0 ? af.a(jSONArrayA) : "";
            aa.b("IntersAdapter", "get excludes:" + strA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strA;
    }

    private void e() {
        try {
            if (com.mbridge.msdk.interstitial.b.a.a() != null) {
                c cVarB = d.a().b(b.d().h());
                if (cVarB == null) {
                    cVarB = d.a().b();
                }
                com.mbridge.msdk.interstitial.b.a.a().a(cVarB.W() * 1000, this.f2237b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<CampaignEx> f() {
        try {
            if (com.mbridge.msdk.interstitial.b.a.a() != null) {
                return com.mbridge.msdk.interstitial.b.a.a().a(this.f2237b, 1);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void a(com.mbridge.msdk.interstitial.c.a.C0490a c0490a) {
        this.h = c0490a;
    }

    private List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int iQ = this.i.q();
                    for (int i = 0; i < list.size() && i < this.f && arrayList.size() < iQ; i++) {
                        CampaignEx campaignEx = list.get(i);
                        if ((campaignEx == null || campaignEx.getOfferType() != 1 || !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) && campaignEx != null && ((!TextUtils.isEmpty(campaignEx.getHtmlUrl()) || campaignEx.isMraid()) && campaignEx.getOfferType() != 99)) {
                            if (af.b(campaignEx)) {
                                campaignEx.setRtinsType(af.c(this.a, campaignEx.getPackageName()) ? 1 : 2);
                            }
                            if (campaignEx.getWtick() == 1 || !af.c(this.a, campaignEx.getPackageName())) {
                                arrayList.add(campaignEx);
                            } else if (af.b(campaignEx)) {
                                arrayList.add(campaignEx);
                            } else {
                                af.a(this.f2237b, campaignEx, com.mbridge.msdk.foundation.same.a.w);
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

    /* JADX INFO: Access modifiers changed from: private */
    public List<CampaignEx> b(List<CampaignEx> list) throws Throwable {
        ArrayList arrayList = new ArrayList(list.size());
        for (CampaignEx campaignEx : list) {
            if (campaignEx.isMraid() && !TextUtils.isEmpty(campaignEx.getMraid())) {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        String strB = e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
                        String md5 = SameMD5.getMD5(al.a(campaignEx.getMraid()));
                        if (TextUtils.isEmpty(md5)) {
                            md5 = String.valueOf(System.currentTimeMillis());
                        }
                        File file = new File(strB, md5.concat(".html"));
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            StringBuilder sb = new StringBuilder();
                            String strB2 = com.mbridge.msdk.c.b.a.a().b();
                            if (!TextUtils.isEmpty(strB2)) {
                                sb.append("<script>").append(strB2).append("</script>");
                            }
                            sb.append(campaignEx.getMraid());
                            fileOutputStream2.write(sb.toString().getBytes());
                            fileOutputStream2.flush();
                            campaignEx.setMraid(file.getAbsolutePath());
                            n.a(campaignEx, "", this.f2237b, CampaignEx.CLICKMODE_ON);
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            campaignEx.setMraid("");
                            n.a(campaignEx, e.getMessage(), this.f2237b, CampaignEx.CLICKMODE_ON);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                File file2 = new File(campaignEx.getMraid());
                if (!file2.exists() || !file2.isFile() || !file2.canRead()) {
                    b("mraid resource write fail");
                }
            }
            arrayList.add(campaignEx);
        }
        return arrayList;
    }

    private int g() {
        try {
            Map<String, Integer> map = com.mbridge.msdk.interstitial.c.a.d;
            int iIntValue = (TextUtils.isEmpty(this.f2237b) || map == null || !map.containsKey(this.f2237b)) ? 1 : map.get(this.f2237b).intValue();
            if (iIntValue <= 0) {
                return 1;
            }
            return iIntValue;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    private int h() {
        int i = 0;
        try {
            int iA = !TextUtils.isEmpty(this.f2237b) ? com.mbridge.msdk.interstitial.c.a.a(this.f2237b) : 0;
            if (iA <= g()) {
                i = iA;
            }
            aa.b("IntersAdapter", "getCurrentOffset:" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (TextUtils.isEmpty(this.f2237b)) {
                return;
            }
            com.mbridge.msdk.interstitial.c.a.a(this.f2237b, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String j() {
        try {
            return !TextUtils.isEmpty(com.mbridge.msdk.interstitial.c.a.a) ? com.mbridge.msdk.interstitial.c.a.a : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final boolean c() {
        return this.e;
    }

    static /* synthetic */ void a(a aVar, CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
            aVar.b("no server ads available");
            return;
        }
        final ArrayList<CampaignEx> ads = campaignUnit.getAds();
        final List<CampaignEx> listA = aVar.a(ads);
        if (campaignUnit != null) {
            String sessionId = campaignUnit.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                aa.b("IntersAdapter", "onload sessionId:" + sessionId);
                com.mbridge.msdk.interstitial.c.a.a = sessionId;
            }
        }
        try {
            aVar.d += aVar.f;
            if (aVar.d > aVar.g()) {
                aVar.d = 0;
            }
            if (!TextUtils.isEmpty(aVar.f2237b)) {
                com.mbridge.msdk.interstitial.c.a.a(aVar.f2237b, aVar.d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() { // from class: com.mbridge.msdk.interstitial.a.a.3
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                List list = listA;
                if (list == null || list.size() <= 0) {
                    a.this.b("no ads available");
                } else {
                    String str = a.this.f2237b;
                    List listB = a.this.b((List<CampaignEx>) listA);
                    if (com.mbridge.msdk.interstitial.b.a.a() != null) {
                        com.mbridge.msdk.interstitial.b.a aVarA = com.mbridge.msdk.interstitial.b.a.a();
                        try {
                            if (!TextUtils.isEmpty(str) && listB != null && listB.size() > 0) {
                                Iterator it = listB.iterator();
                                while (it.hasNext()) {
                                    aVarA.b((CampaignEx) it.next(), str);
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    CampaignEx campaignEx = (CampaignEx) listA.get(0);
                    a.this.a(campaignEx != null ? campaignEx.getRequestId() : "");
                }
                k.a(h.a(a.this.a)).b();
                List list2 = ads;
                if (list2 == null || list2.size() <= 0) {
                    return;
                }
                a.b(a.this, ads);
            }
        }).start();
    }

    static /* synthetic */ void b(a aVar, List list) {
        if (aVar.a == null || list == null || list.size() == 0) {
            return;
        }
        k kVarA = k.a(h.a(aVar.a));
        for (int i = 0; i < list.size(); i++) {
            CampaignEx campaignEx = (CampaignEx) list.get(i);
            if (campaignEx != null && kVarA != null && !kVarA.a(campaignEx.getId())) {
                g gVar = new g();
                gVar.a(campaignEx.getId());
                gVar.a(campaignEx.getFca());
                gVar.b(campaignEx.getFcb());
                gVar.d(0);
                gVar.c(0);
                gVar.a(System.currentTimeMillis());
                kVarA.a(gVar);
            }
        }
    }
}
