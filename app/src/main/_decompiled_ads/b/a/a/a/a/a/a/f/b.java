package b.a.a.a.a.a.a.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX INFO: compiled from: VideoInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23b;
    private long c;
    private double d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private double k;
    private int l;
    private int m;
    private float n = -1.0f;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 307200;
    private int t = 1;

    public int a() {
        return this.a;
    }

    public void b(int i) {
        this.f23b = i;
    }

    public int c() {
        return this.f23b;
    }

    public String d() {
        return this.h;
    }

    public void e(int i) {
        this.l = i;
    }

    public void f(String str) {
        this.g = str;
    }

    public int g() {
        return this.l;
    }

    public String h() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = b.a.a.a.a.a.a.i.b.a(this.g);
        }
        return this.j;
    }

    public float i() {
        return this.n;
    }

    public void j(int i) {
        this.s = i;
    }

    public int k() {
        return this.o;
    }

    public String l() {
        return this.i;
    }

    public int m() {
        return this.t;
    }

    public String n() {
        return this.e;
    }

    public int o() {
        return this.q;
    }

    public long p() {
        return this.c;
    }

    public double q() {
        return this.k;
    }

    public int r() {
        if (this.s < 0) {
            this.s = 307200;
        }
        long j = this.s;
        long j2 = this.c;
        if (j > j2) {
            this.s = (int) j2;
        }
        return this.s;
    }

    public double s() {
        return this.d;
    }

    public String t() {
        return this.g;
    }

    public boolean u() {
        return this.q == 0;
    }

    public boolean v() {
        return this.r == 1;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", a());
            jSONObject.put("cover_url", b());
            jSONObject.put("cover_width", c());
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, d());
            jSONObject.put("file_hash", h());
            jSONObject.put("resolution", n());
            jSONObject.put("size", p());
            jSONObject.put("video_duration", s());
            jSONObject.put("video_url", t());
            jSONObject.put("playable_download_url", l());
            jSONObject.put("if_playable_loading_show", k());
            jSONObject.put("remove_loading_page_type", j());
            jSONObject.put("fallback_endcard_judge", g());
            jSONObject.put("video_preload_size", r());
            jSONObject.put("reward_video_cached_type", o());
            jSONObject.put("execute_cached_type", f());
            jSONObject.put("endcard_render", e());
            jSONObject.put("replay_time", m());
            jSONObject.put("play_speed_ratio", i());
            if (q() > 0.0d) {
                jSONObject.put("start", q());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void a(int i) {
        this.a = i;
    }

    public String b() {
        return this.f;
    }

    public void c(int i) {
        this.m = i;
    }

    public void d(String str) {
        this.i = str;
    }

    public int e() {
        return this.m;
    }

    public int f() {
        return this.r;
    }

    public void g(int i) {
        this.o = i;
    }

    public void i(int i) {
        this.q = i;
    }

    public int j() {
        return this.p;
    }

    public void a(long j) {
        this.c = j;
    }

    public void b(String str) {
        this.h = str;
    }

    public void c(String str) {
        this.j = str;
    }

    public void d(int i) {
        this.r = i;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(int i) {
        this.p = i;
    }

    public void a(double d) {
        this.d = d;
    }

    public void a(String str) {
        this.f = str;
    }

    public void h(int i) {
        this.t = Math.min(4, Math.max(1, i));
    }
}
