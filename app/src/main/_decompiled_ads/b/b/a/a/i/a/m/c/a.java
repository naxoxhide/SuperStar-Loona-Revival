package b.b.a.a.i.a.m.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdLogEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.b.a.a.i.a.m.a {
    private b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte f223b;
    private byte c;
    private long d;
    private long e;
    private String f;
    private String g;
    protected JSONObject h;
    private byte i;
    private String j;

    public a(String str, JSONObject jSONObject) {
        this.g = str;
        this.h = jSONObject;
    }

    public static b.b.a.a.i.a.m.a c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt("priority");
            a aVar = new a();
            aVar.a((byte) iOptInt);
            aVar.b((byte) iOptInt2);
            aVar.a(jSONObject.optJSONObject("event"));
            aVar.a(jSONObject.optString("localId"));
            aVar.b(jSONObject.optString("genTime"));
            return aVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // b.b.a.a.i.a.m.a
    public void a(long j) {
    }

    @Override // b.b.a.a.i.a.m.a
    public void a(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    @Override // b.b.a.a.i.a.m.a
    public synchronized JSONObject b() {
        b bVar;
        if (this.h == null && (bVar = this.a) != null) {
            this.h = bVar.a(k());
        }
        return this.h;
    }

    @Override // b.b.a.a.i.a.m.a
    public b d() {
        return this.a;
    }

    @Override // b.b.a.a.i.a.m.a
    public long e() {
        return this.e;
    }

    @Override // b.b.a.a.i.a.m.a
    public byte f() {
        return this.f223b;
    }

    @Override // b.b.a.a.i.a.m.a
    public byte g() {
        return this.i;
    }

    @Override // b.b.a.a.i.a.m.a
    public String h() {
        if (TextUtils.isEmpty(this.g)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.g);
            jSONObject.put("event", b());
            jSONObject.put("genTime", j());
            jSONObject.put("priority", (int) this.c);
            jSONObject.put("type", (int) this.f223b);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // b.b.a.a.i.a.m.a
    public String i() {
        return this.g;
    }

    public String j() {
        return this.f;
    }

    public String k() {
        return this.j;
    }

    @Override // b.b.a.a.i.a.m.a
    public void a(byte b2) {
        this.f223b = b2;
    }

    @Override // b.b.a.a.i.a.m.a
    public void a(String str) {
        this.g = str;
    }

    public a(String str, b bVar) {
        this.g = str;
        this.a = bVar;
    }

    @Override // b.b.a.a.i.a.m.a
    public long a() {
        return this.d;
    }

    @Override // b.b.a.a.i.a.m.a
    public void b(String str) {
        this.f = str;
    }

    @Override // b.b.a.a.i.a.m.a
    public void b(long j) {
        this.e = j;
    }

    private a() {
    }

    @Override // b.b.a.a.i.a.m.a
    public void b(byte b2) {
        this.c = b2;
    }

    public void c(byte b2) {
        this.i = b2;
    }

    @Override // b.b.a.a.i.a.m.a
    public void c(long j) {
        this.d = j;
    }

    @Override // b.b.a.a.i.a.m.a
    public byte c() {
        return this.c;
    }
}
