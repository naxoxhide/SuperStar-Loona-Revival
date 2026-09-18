package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetApi.java */
/* JADX INFO: loaded from: classes2.dex */
public interface p<T> {

    /* JADX INFO: compiled from: NetApi.java */
    public interface a {
        void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, com.bytedance.sdk.openadsdk.core.f0.b bVar);

        void onError(int i, String str);
    }

    /* JADX INFO: compiled from: NetApi.java */
    public interface b {
        void a(q.k kVar);

        void onError(int i, String str);
    }

    b.b.a.a.d.e.c.a a();

    com.bytedance.sdk.openadsdk.d.e a(JSONObject jSONObject);

    com.bytedance.sdk.openadsdk.d.e a(JSONObject jSONObject, String str, boolean z);

    void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar, int i, a aVar);

    void a(String str);

    void a(String str, List<FilterWord> list);

    void a(JSONObject jSONObject, b bVar);

    void a(JSONObject jSONObject, String str);
}
