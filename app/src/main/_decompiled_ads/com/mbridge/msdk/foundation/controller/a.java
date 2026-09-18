package com.mbridge.msdk.foundation.controller;

import com.mbridge.msdk.foundation.b.d;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: CandidateController.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public volatile boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, d> f2066b;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.controller.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CandidateController.java */
    static class C0479a {
        static a a = new a();
    }

    private a() {
        this.f2066b = new HashMap<>();
        this.a = false;
    }

    public static a a() {
        return C0479a.a;
    }

    public final d a(String str, JSONArray jSONArray) {
        if (this.f2066b == null) {
            this.f2066b = new HashMap<>();
        }
        if (this.f2066b.containsKey(str)) {
            return this.f2066b.get(str);
        }
        if (this.f2066b == null) {
            this.f2066b = new HashMap<>();
        }
        if (this.f2066b.containsKey(str)) {
            return this.f2066b.get(str);
        }
        d dVar = new d(str, jSONArray);
        this.f2066b.put(str, dVar);
        return dVar;
    }
}
