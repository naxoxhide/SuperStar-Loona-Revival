package com.bytedance.sdk.openadsdk.d;

import org.json.JSONObject;

/* JADX INFO: compiled from: AdShowTime.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f718b;
    private long c;
    private long d;
    private long e;

    public void a(long j) {
        if (this.f718b <= 0) {
            this.f718b = j;
        }
    }

    public void b(long j) {
        if (this.e <= 0) {
            this.e = j;
        }
    }

    public void c(long j) {
        if (this.c <= 0) {
            this.c = j;
        }
    }

    public void d(long j) {
        if (this.a <= 0) {
            this.a = j;
        }
    }

    public void e(long j) {
        if (this.d <= 0) {
            this.d = j;
        }
    }

    public void a(long j, float f) {
        if (f > 0.0f) {
            d(j);
        }
        double d = f;
        if (d >= 0.25d) {
            d(j);
            a(j);
        }
        if (d >= 0.5d) {
            d(j);
            a(j);
            c(j);
        }
        if (d >= 0.75d) {
            d(j);
            a(j);
            c(j);
            e(j);
        }
        if (f >= 1.0f) {
            d(j);
            a(j);
            c(j);
            e(j);
            b(j);
        }
    }

    public boolean b() {
        return this.a > 0;
    }

    public JSONObject a() {
        return a((JSONObject) null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    /* JADX WARN: Code duplicated, block: B:15:0x0026  */
    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    /* JADX WARN: Code duplicated, block: B:23:0x003c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0010  */
    public JSONObject a(JSONObject jSONObject) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
                j = this.a;
                if (j > 0) {
                    jSONObject.put("show_start", j);
                    j2 = this.f718b;
                    if (j2 > 0) {
                        jSONObject.put("show_firstQuartile", j2);
                        j3 = this.c;
                        if (j3 > 0) {
                            jSONObject.put("show_mid", j3);
                            j4 = this.d;
                            if (j4 > 0) {
                                jSONObject.put("show_thirdQuartile", j4);
                                j5 = this.e;
                                if (j5 > 0) {
                                    jSONObject.put("show_full", j5);
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        } else {
            j = this.a;
            if (j > 0) {
                jSONObject.put("show_start", j);
                j2 = this.f718b;
                if (j2 > 0) {
                    jSONObject.put("show_firstQuartile", j2);
                    j3 = this.c;
                    if (j3 > 0) {
                        jSONObject.put("show_mid", j3);
                        j4 = this.d;
                        if (j4 > 0) {
                            jSONObject.put("show_thirdQuartile", j4);
                            j5 = this.e;
                            if (j5 > 0) {
                                jSONObject.put("show_full", j5);
                            }
                        }
                    }
                }
            }
        }
        return jSONObject;
    }
}
