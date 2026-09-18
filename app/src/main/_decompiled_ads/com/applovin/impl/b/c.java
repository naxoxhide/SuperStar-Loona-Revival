package com.applovin.impl.b;

import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final List<b> aXa;

    private c(List<b> list) {
        this.aXa = list;
    }

    public static c a(y yVar, c cVar, e eVar, com.applovin.impl.sdk.n nVar) {
        try {
            List<b> listMk = cVar != null ? cVar.Mk() : new ArrayList<>();
            Iterator<y> it = yVar.dN("Verification").iterator();
            while (it.hasNext()) {
                b bVarA = b.a(it.next(), eVar, nVar);
                if (bVarA != null) {
                    listMk.add(bVarA);
                }
            }
            return new c(listMk);
        } catch (Throwable th) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().c("VastAdVerifications", "Error occurred while initializing", th);
            }
            nVar.Cq().g("VastAdVerifications", th);
            return null;
        }
    }

    public List<b> Mk() {
        return this.aXa;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.aXa.equals(((c) obj).aXa);
        }
        return false;
    }

    public int hashCode() {
        return this.aXa.hashCode();
    }

    public String toString() {
        return "VastAdVerification{verifications='" + this.aXa + "'}";
    }
}
