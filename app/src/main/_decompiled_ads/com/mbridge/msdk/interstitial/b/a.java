package com.mbridge.msdk.interstitial.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: InterstitialCamapignCache.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String a = "com.mbridge.msdk.interstitial.b.a";
    private static a c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f2239b;

    private a() {
        try {
            Context contextG = b.d().g();
            if (contextG != null) {
                this.f2239b = f.a(h.a(contextG));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public final List<CampaignEx> a(String str, int i) {
        List<CampaignEx> listA;
        ArrayList arrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (listA = this.f2239b.a(str, i, 0, 1)) == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                Iterator<CampaignEx> it = listA.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return arrayList;
    }

    public final void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f2239b.a(campaignEx.getId(), str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(List<CampaignEx> list, String str) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<CampaignEx> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), str);
        }
    }

    public final void b(CampaignEx campaignEx, String str) {
        try {
            if (this.f2239b == null || campaignEx == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f2239b.a(campaignEx, str, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final synchronized void a(long j, String str) {
        try {
            if (this.f2239b != null && j != 0 && !TextUtils.isEmpty(str)) {
                this.f2239b.b(j, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            aa.d(a, e.getMessage());
        }
    }
}
