package com.bytedance.sdk.openadsdk.h;

import android.os.SystemClock;
import android.text.TextUtils;
import b.b.a.a.h.k;
import b.b.a.a.h.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.d.g;
import com.bytedance.sdk.openadsdk.utils.a0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ImageLoaderLogListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class b<T> implements o<T> {
    private final long a = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f770b;
    private final o<T> c;
    private final q d;

    /* JADX INFO: compiled from: ImageLoaderLogListenerWrapper.java */
    class a implements com.bytedance.sdk.openadsdk.d.q.a {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f771b;
        final /* synthetic */ int c;

        a(long j, int i, int i2) {
            this.a = j;
            this.f771b = i;
            this.c = i2;
        }

        @Override // com.bytedance.sdk.openadsdk.d.q.a
        public void a(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("duration", this.a);
            jSONObject2.put("url", b.this.f770b);
            jSONObject2.put("preload_size", this.f771b);
            jSONObject2.put("local_cache", this.c);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.put("duration", this.a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.h.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageLoaderLogListenerWrapper.java */
    class C0236b implements com.bytedance.sdk.openadsdk.d.q.a {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f772b;
        final /* synthetic */ long c;

        C0236b(int i, String str, long j) {
            this.a = i;
            this.f772b = str;
            this.c = j;
        }

        @Override // com.bytedance.sdk.openadsdk.d.q.a
        public void a(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error_code", this.a);
            jSONObject2.put("error_message", this.f772b);
            jSONObject2.put("duration", this.c);
            jSONObject2.put("url", b.this.f770b);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.put("duration", this.c);
        }
    }

    public b(q qVar, String str, o<T> oVar) {
        this.c = oVar;
        this.d = qVar;
        this.f770b = str;
    }

    @Override // b.b.a.a.h.o
    public void a(k<T> kVar) {
        o<T> oVar = this.c;
        if (oVar != null) {
            oVar.a(kVar);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.a;
        String strA = a0.a(this.d);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        com.bytedance.sdk.openadsdk.d.c.a(System.currentTimeMillis(), this.d, strA, "load_image_success", (JSONObject) null, (g) null, new a(jElapsedRealtime, kVar.d() / 1024, kVar.f() ? 1 : 0));
    }

    @Override // b.b.a.a.h.o
    public void a(int i, String str, Throwable th) {
        o<T> oVar = this.c;
        if (oVar != null) {
            oVar.a(i, str, th);
        }
        q qVar = this.d;
        if (qVar != null) {
            String strA = a0.a(qVar);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            com.bytedance.sdk.openadsdk.d.c.a(System.currentTimeMillis(), this.d, strA, "load_image_error", (JSONObject) null, (g) null, new C0236b(i, str, SystemClock.elapsedRealtime() - this.a));
        }
    }
}
