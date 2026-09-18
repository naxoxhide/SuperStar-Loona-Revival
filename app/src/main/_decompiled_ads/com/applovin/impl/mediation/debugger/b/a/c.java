package com.applovin.impl.mediation.debugger.b.a;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c implements Comparable<c> {
    private final String aou;
    private final boolean aov;
    private final com.applovin.impl.mediation.debugger.b.c.b aow;
    private final String name;

    c(String str, String str2, boolean z, com.applovin.impl.mediation.debugger.b.c.b bVar) {
        this.name = str;
        this.aou = str2;
        this.aov = z;
        this.aow = bVar;
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.aou;
    }

    public List<String> uO() {
        List<String> listVv = this.aow.vv();
        return (listVv == null || listVv.isEmpty()) ? Collections.singletonList(this.name) : listVv;
    }

    public com.applovin.impl.mediation.debugger.b.c.b uP() {
        return this.aow;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return this.aou.compareToIgnoreCase(cVar.aou);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.name;
        if (str == null ? cVar.name != null : !str.equals(cVar.name)) {
            return false;
        }
        String str2 = this.aou;
        if (str2 == null ? cVar.aou == null : str2.equals(cVar.aou)) {
            return this.aov == cVar.aov;
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.aou;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.aov ? 1 : 0);
    }
}
