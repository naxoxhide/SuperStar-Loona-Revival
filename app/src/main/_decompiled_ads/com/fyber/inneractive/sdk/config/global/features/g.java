package com.fyber.inneractive.sdk.config.global.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends com.fyber.inneractive.sdk.config.global.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f878b;
    public Map<String, com.fyber.inneractive.sdk.config.global.b> c = new HashMap();
    public Map<String, com.fyber.inneractive.sdk.config.global.k> d = new HashMap();

    public g(String str) {
        this.f878b = str;
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public String a(String str, String str2) {
        String strC;
        Iterator<String> it = this.d.keySet().iterator();
        do {
            if (!it.hasNext()) {
                strC = null;
                break;
            }
            strC = this.d.get(it.next()).c(str);
        } while (strC == null);
        if (strC != null) {
            return strC;
        }
        com.fyber.inneractive.sdk.config.global.n nVar = this.a;
        return nVar != null ? nVar.a(str, str2) : str2;
    }

    public abstract g b();

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public Integer b(String str) {
        Integer numB;
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            numB = this.d.get(it.next()).b(str);
            if (numB != null) {
                if (numB == null) {
                    return super.b(str);
                }
                return numB;
            }
        }
        numB = null;
        if (numB == null) {
            return super.b(str);
        }
        return numB;
    }

    public List<com.fyber.inneractive.sdk.config.global.b> c() {
        return new ArrayList(this.c.values());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public Boolean d(String str) {
        Boolean boolD;
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            boolD = this.d.get(it.next()).d(str);
            if (boolD != null) {
                if (boolD == null) {
                    return super.d(str);
                }
                return boolD;
            }
        }
        boolD = null;
        if (boolD == null) {
            return super.d(str);
        }
        return boolD;
    }

    public String toString() {
        return String.format("id: %s, params: %s exp: %s", this.f878b, this.a, this.c);
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public String c(String str) {
        return a(str, (String) null);
    }

    public int a(String str, int i) {
        Integer numB = b(str);
        return numB != null ? numB.intValue() : i;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public Double a(String str) {
        Double dA;
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            dA = this.d.get(it.next()).a(str);
            if (dA != null) {
                if (dA == null) {
                    return super.a(str);
                }
                return dA;
            }
        }
        dA = null;
        if (dA == null) {
            return super.a(str);
        }
        return dA;
    }

    public boolean a(String str, boolean z) {
        Boolean boolD = d(str);
        return boolD != null ? boolD.booleanValue() : z;
    }

    public void a(g gVar) {
        gVar.f878b = this.f878b;
        gVar.a = this.a;
        gVar.c = new HashMap(this.c);
        gVar.d = new HashMap(this.d);
    }
}
