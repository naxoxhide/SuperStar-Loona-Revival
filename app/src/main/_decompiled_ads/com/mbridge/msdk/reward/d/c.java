package com.mbridge.msdk.reward.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.Frame;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardResponseHandler.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c extends f<JSONObject> {
    private static final String a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2411b;
    private String c;

    public abstract void a(List<Frame> list);

    public abstract void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit);

    public abstract void b(int i, String str, int i2);

    public final void a(String str) {
        this.c = str;
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onSuccess(k<JSONObject> kVar) {
        CampaignUnit campaignUnit;
        super.onSuccess(kVar);
        if (kVar == null || kVar.c == null) {
            return;
        }
        int i = this.f2411b;
        if (i == 0) {
            final List<com.mbridge.msdk.foundation.same.net.c.b> list = kVar.c.d;
            final JSONObject jSONObject = kVar.a;
            final int iOptInt = jSONObject.optInt("status");
            if (1 == iOptInt) {
                calcRequestTime(System.currentTimeMillis());
                final String strOptString = jSONObject.optString("version");
                com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.reward.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        final CampaignUnit v5CampaignUnit = "v5".equals(strOptString) ? CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject("data"), c.this.c) : CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject("data"), c.this.c);
                        com.mbridge.msdk.foundation.same.f.b.h().post(new Runnable() { // from class: com.mbridge.msdk.reward.d.c.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                CampaignUnit campaignUnit2 = v5CampaignUnit;
                                if (campaignUnit2 != null && campaignUnit2.getAds() != null && v5CampaignUnit.getAds().size() > 0) {
                                    c.this.a(list, v5CampaignUnit);
                                    c.this.saveRequestTime(v5CampaignUnit.getAds().size());
                                    return;
                                }
                                CampaignUnit campaignUnit3 = v5CampaignUnit;
                                String msg = campaignUnit3 != null ? campaignUnit3.getMsg() : null;
                                if (TextUtils.isEmpty(msg)) {
                                    msg = jSONObject.optString("msg");
                                }
                                c.this.b(iOptInt, msg, 2);
                            }
                        });
                    }
                });
                return;
            }
            a(list, jSONObject, iOptInt);
            return;
        }
        if (i == 1) {
            List<com.mbridge.msdk.foundation.same.net.c.b> list2 = kVar.c.d;
            JSONObject jSONObject2 = kVar.a;
            int iOptInt2 = jSONObject2.optInt("status");
            if (1 == iOptInt2) {
                calcRequestTime(System.currentTimeMillis());
                if ("v5".equals(jSONObject2.optString("version"))) {
                    campaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject2.optJSONObject("data"), this.c);
                } else {
                    campaignUnit = CampaignUnit.parseCampaignUnit(jSONObject2.optJSONObject("data"), this.c);
                }
                if (campaignUnit != null && campaignUnit.getListFrames() != null && campaignUnit.getListFrames().size() > 0) {
                    List<Frame> listFrames = campaignUnit.getListFrames();
                    a(listFrames);
                    saveRequestTime(listFrames.size());
                    return;
                } else {
                    String msg = campaignUnit != null ? campaignUnit.getMsg() : null;
                    if (TextUtils.isEmpty(msg)) {
                        msg = jSONObject2.optString("msg");
                    }
                    b(iOptInt2, msg, 2);
                    return;
                }
            }
            a(list2, jSONObject2, iOptInt2);
        }
    }

    private void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, JSONObject jSONObject, int i) {
        String strB = "";
        if (list != null && list.size() > 0) {
            for (com.mbridge.msdk.foundation.same.net.c.b bVar : list) {
                if (bVar != null) {
                    String strA = bVar.a();
                    if (!TextUtils.isEmpty(strA) && strA.equals("data_res_type")) {
                        strB = bVar.b();
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(strB) && strB.equals("1")) {
            b(i, jSONObject.optString("msg"), 3);
        } else {
            b(i, jSONObject.optString("msg"), 2);
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        aa.d(a, "errorCode = " + aVar.a);
        b(aVar.a, com.mbridge.msdk.foundation.same.net.f.a.a(aVar), 1);
    }
}
