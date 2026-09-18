package com.mbridge.msdk.mbnative.a;

import android.text.TextUtils;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.Campaign;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: APICache.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends b<String, List<Campaign>> {
    private f a = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2286b;

    @Override // com.mbridge.msdk.mbnative.a.b
    public final /* synthetic */ List<Campaign> a(String str, int i) {
        String str2 = str;
        List<CampaignEx> listA = this.a.a(str2, i, 2, this.f2286b);
        if (listA == null) {
            return null;
        }
        if (a(listA, 2)) {
            this.a.a(str2, 2, this.f2286b);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listA);
        return arrayList;
    }

    @Override // com.mbridge.msdk.mbnative.a.b
    public final /* synthetic */ void a(String str, List<Campaign> list) {
        String str2 = str;
        List<Campaign> list2 = list;
        if (TextUtils.isEmpty(str2) || list2 == null || list2.size() <= 0) {
            return;
        }
        this.a.a(str2, 1, this.f2286b, false);
        this.a.a(str2, 2, this.f2286b, false);
        for (int i = 0; i < list2.size(); i++) {
            CampaignEx campaignEx = (CampaignEx) list2.get(i);
            campaignEx.setCacheLevel(1);
            this.a.a(campaignEx, str2, 1);
        }
    }

    @Override // com.mbridge.msdk.mbnative.a.b
    public final /* synthetic */ void a(String str, List<Campaign> list, String str2) {
        final String str3 = str;
        final List<Campaign> list2 = list;
        boolean z = !TextUtils.isEmpty(str2);
        if (TextUtils.isEmpty(str3) || list2 == null || list2.size() <= 0) {
            return;
        }
        this.a.a(str3, 1, this.f2286b, z);
        this.a.a(str3, 2, this.f2286b, z);
        com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.mbnative.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                for (int i = 0; i < list2.size(); i++) {
                    CampaignEx campaignEx = (CampaignEx) list2.get(i);
                    campaignEx.setCacheLevel(1);
                    a.this.a.a(campaignEx, str3, 1);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.mbnative.a.b
    public final /* synthetic */ List<Campaign> b(String str, int i) {
        String str2 = str;
        List<CampaignEx> listA = this.a.a(str2, i, 1, this.f2286b);
        if (listA == null) {
            return null;
        }
        if (!a(listA, 1)) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(listA);
            return arrayList;
        }
        for (int i2 = 0; i2 < listA.size(); i2++) {
            CampaignEx campaignEx = listA.get(i2);
            campaignEx.setCacheLevel(2);
            this.a.a(campaignEx, str2, 1);
        }
        return null;
    }

    public a(int i) {
        this.f2286b = i;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0065 A[RETURN] */
    private boolean a(List<CampaignEx> list, int i) {
        long jW;
        if (list != null && list.size() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long timestamp = list.get(0).getTimestamp();
            long j = 0;
            if (i != 1) {
                if (i == 2) {
                    com.mbridge.msdk.c.c cVarB = d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                    if (cVarB == null) {
                        cVarB = d.a().b();
                    }
                    jW = cVarB.Q();
                }
                if (jCurrentTimeMillis - timestamp > j) {
                    return true;
                }
            } else {
                com.mbridge.msdk.c.c cVarB2 = d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                if (cVarB2 == null) {
                    cVarB2 = d.a().b();
                }
                jW = cVarB2.W();
            }
            j = jW * 1000;
            if (jCurrentTimeMillis - timestamp > j) {
                return true;
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.mbnative.a.b
    public final void a(String str, Campaign campaign, String str2) {
        boolean z = !TextUtils.isEmpty(str2);
        if (campaign == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (this.a.a(campaignEx.getId(), campaignEx.getTab(), str, campaignEx.getCacheLevel(), campaignEx.getType(), z)) {
                this.a.a(campaignEx.getId(), str, campaignEx.getCacheLevel(), this.f2286b, z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
