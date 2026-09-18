package com.applovin.impl.mediation.debugger;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.applovin.impl.mediation.debugger.c.a.InterfaceC0124a, com.applovin.impl.mediation.debugger.c.b.a {
    private final InterfaceC0121a anP;
    private com.applovin.impl.mediation.debugger.b.b.a anQ;
    private String anR;
    private final n sdk;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.a$a, reason: collision with other inner class name */
    public interface InterfaceC0121a {
        void a(com.applovin.impl.mediation.debugger.b.b.a aVar, String str);

        void b(b bVar, String str);
    }

    public enum b {
        DEVELOPER_URI_NOT_FOUND,
        APPADSTXT_NOT_FOUND,
        MISSING_APPLOVIN_ENTRIES,
        MISSING_NON_APPLOVIN_ENTRIES
    }

    public a(n nVar, InterfaceC0121a interfaceC0121a) {
        this.sdk = nVar;
        this.anP = interfaceC0121a;
    }

    public void uA() {
        com.applovin.impl.mediation.debugger.b.b.a aVar = this.anQ;
        if (aVar != null) {
            this.anP.a(aVar, this.anR);
        } else {
            this.sdk.BM().b(new com.applovin.impl.mediation.debugger.c.b(this.sdk, this));
        }
    }

    @Override // com.applovin.impl.mediation.debugger.c.b.a
    public void bG(String str) {
        this.sdk.BM().b(new com.applovin.impl.mediation.debugger.c.a(this.sdk, str, this));
    }

    @Override // com.applovin.impl.mediation.debugger.c.b.a
    public void a(b bVar) {
        this.anP.b(bVar, null);
    }

    @Override // com.applovin.impl.mediation.debugger.c.a.InterfaceC0124a
    public void t(String str, String str2) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split("\n");
        int length = strArrSplit.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            com.applovin.impl.mediation.debugger.b.b.b bVar = new com.applovin.impl.mediation.debugger.b.b.b(strArrSplit[i2], i);
            if (bVar.vi()) {
                String strVd = bVar.vd();
                List arrayList2 = map.containsKey(strVd) ? (List) map.get(strVd) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(bVar);
                    map.put(strVd, arrayList2);
                }
            } else {
                arrayList.add(bVar);
            }
            i2++;
            i = i3;
        }
        this.anQ = new com.applovin.impl.mediation.debugger.b.b.a(map, arrayList);
        this.anR = str2;
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AppAdsTxtService", "app-ads.txt fetched: " + this.anQ);
        }
        this.anP.a(this.anQ, str2);
    }

    @Override // com.applovin.impl.mediation.debugger.c.a.InterfaceC0124a
    public void a(b bVar, String str) {
        this.anP.b(bVar, str);
    }
}
