package com.fyber.inneractive.sdk.config.global;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class i implements d {
    public Set<Long> a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f880b;

    public i(JSONArray jSONArray, boolean z) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                long jOptLong = jSONArray.optLong(i);
                if (jOptLong != 0) {
                    this.a.add(Long.valueOf(jOptLong));
                }
            }
        }
        this.f880b = z;
    }

    @Override // com.fyber.inneractive.sdk.config.global.d
    public boolean a(e eVar) {
        if (this.a.isEmpty() || eVar == null || eVar.f876b == null) {
            return false;
        }
        Iterator<Long> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().equals(eVar.f876b)) {
                return !this.f880b;
            }
        }
        return this.f880b;
    }

    public String toString() {
        return String.format("%s - %s include: %b", "pub_id", this.a, Boolean.valueOf(this.f880b));
    }
}
