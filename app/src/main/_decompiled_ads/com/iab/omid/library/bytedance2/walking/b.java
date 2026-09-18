package com.iab.omid.library.bytedance2.walking;

import com.iab.omid.library.bytedance2.walking.async.d;
import com.iab.omid.library.bytedance2.walking.async.e;
import com.iab.omid.library.bytedance2.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0388b {
    private JSONObject a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.walking.async.c f1434b;

    public b(com.iab.omid.library.bytedance2.walking.async.c cVar) {
        this.f1434b = cVar;
    }

    @Override // com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0388b
    public JSONObject a() {
        return this.a;
    }

    @Override // com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0388b
    public void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f1434b.b(new e(this, hashSet, jSONObject, j));
    }

    public void b() {
        this.f1434b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f1434b.b(new f(this, hashSet, jSONObject, j));
    }
}
