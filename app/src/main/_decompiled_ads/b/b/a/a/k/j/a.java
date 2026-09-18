package b.b.a.a.k.j;

import org.json.JSONObject;

/* JADX INFO: compiled from: ThreadLogModel.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f256b;
    public int c;
    public int d;

    public a(int i, int i2, int i3, int i4) {
        this.a = i;
        this.f256b = i2;
        this.c = i3;
        this.d = i4;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_thread_num", this.a);
            jSONObject.put("sdk_max_thread_num", this.f256b);
            jSONObject.put("app_thread_num", this.c);
            jSONObject.put("app_max_thread_num", this.d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
