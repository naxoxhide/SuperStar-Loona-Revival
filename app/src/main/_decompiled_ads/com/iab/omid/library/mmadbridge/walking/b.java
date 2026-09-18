package com.iab.omid.library.mmadbridge.walking;

import com.iab.omid.library.mmadbridge.walking.async.d;
import com.iab.omid.library.mmadbridge.walking.async.e;
import com.iab.omid.library.mmadbridge.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.iab.omid.library.mmadbridge.walking.async.b.InterfaceC0394b {
    private JSONObject a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.mmadbridge.walking.async.c f1482b;

    public b(com.iab.omid.library.mmadbridge.walking.async.c cVar) {
        this.f1482b = cVar;
    }

    @Override // com.iab.omid.library.mmadbridge.walking.async.b.InterfaceC0394b
    public JSONObject a() {
        return this.a;
    }

    @Override // com.iab.omid.library.mmadbridge.walking.async.b.InterfaceC0394b
    public void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f1482b.b(new e(this, hashSet, jSONObject, j));
    }

    public void b() {
        this.f1482b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f1482b.b(new f(this, hashSet, jSONObject, j));
    }
}
