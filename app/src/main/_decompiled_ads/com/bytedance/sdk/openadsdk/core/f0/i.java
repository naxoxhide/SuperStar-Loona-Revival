package com.bytedance.sdk.openadsdk.core.f0;

import android.util.SparseArray;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClickEventModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private final int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f578b;
    private final int[] c;
    private final int[] d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final long i;
    private final long j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> o;
    private final int p;
    private final JSONObject q;
    private final String r;

    /* JADX INFO: compiled from: ClickEventModel.java */
    public static class b {
        private long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f579b;
        private float c;
        private float d;
        private float e;
        private float f;
        private int[] g;
        private int[] h;
        private int[] i;
        private int[] j;
        private int k;
        private int l;
        private int m;
        private SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> n;
        private int o;
        private String p;
        private int q;
        private JSONObject r;

        public b a(float f) {
            return this;
        }

        public b b(int i) {
            return this;
        }

        public b d(float f) {
            return this;
        }

        public b a(int i) {
            this.q = i;
            return this;
        }

        public b b(long j) {
            this.a = j;
            return this;
        }

        public b c(float f) {
            this.e = f;
            return this;
        }

        public b d(int i) {
            this.o = i;
            return this;
        }

        public b e(float f) {
            this.d = f;
            return this;
        }

        public b f(float f) {
            this.c = f;
            return this;
        }

        public b a(JSONObject jSONObject) {
            this.r = jSONObject;
            return this;
        }

        public b b(float f) {
            this.f = f;
            return this;
        }

        public b c(int[] iArr) {
            this.h = iArr;
            return this;
        }

        public b d(int[] iArr) {
            this.i = iArr;
            return this;
        }

        public b e(int i) {
            this.m = i;
            return this;
        }

        public b f(int i) {
            this.k = i;
            return this;
        }

        public b a(SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray) {
            this.n = sparseArray;
            return this;
        }

        public b b(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public b c(int i) {
            this.l = i;
            return this;
        }

        public b a(long j) {
            this.f579b = j;
            return this;
        }

        public b a(int[] iArr) {
            this.g = iArr;
            return this;
        }

        public b a(String str) {
            this.p = str;
            return this;
        }

        public i a() {
            return new i(this);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.a;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.a[1]));
            }
            int[] iArr2 = this.f578b;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.f578b[1]));
            }
            int[] iArr3 = this.c;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.c[1]));
            }
            int[] iArr4 = this.d;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.d[1]));
            }
            jSONObject.putOpt("down_x", Float.toString(this.e)).putOpt("down_y", Float.toString(this.f)).putOpt("up_x", Float.toString(this.g)).putOpt("up_y", Float.toString(this.h)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.j)).putOpt("toolType", Integer.valueOf(this.k)).putOpt("deviceId", Integer.valueOf(this.l)).putOpt("source", Integer.valueOf(this.m)).putOpt("ft", a(this.o, this.n)).putOpt("click_area_type", this.r);
            int i = this.p;
            if (i > 0) {
                jSONObject.putOpt("areaType", Integer.valueOf(i));
            }
            JSONObject jSONObject2 = this.q;
            if (jSONObject2 != null) {
                jSONObject.putOpt("rectInfo", jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private i(b bVar) {
        this.a = bVar.h;
        this.f578b = bVar.i;
        this.d = bVar.j;
        this.c = bVar.g;
        this.e = bVar.f;
        this.f = bVar.e;
        this.g = bVar.d;
        this.h = bVar.c;
        this.i = bVar.f579b;
        this.j = bVar.a;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.n = bVar.o;
        this.o = bVar.n;
        this.r = bVar.p;
        this.p = bVar.q;
        this.q = bVar.r;
    }

    public static JSONObject a(SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (sparseArray != null) {
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    com.bytedance.sdk.openadsdk.core.c0.c.a aVarValueAt = sparseArray.valueAt(i2);
                    if (aVarValueAt != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("force", Double.valueOf(aVarValueAt.c)).putOpt("mr", Double.valueOf(aVarValueAt.f565b)).putOpt("phase", Integer.valueOf(aVarValueAt.a)).putOpt(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(aVarValueAt.d));
                        jSONArray.put(jSONObject2);
                        jSONObject.putOpt("ftc", Integer.valueOf(i)).putOpt(TJAdUnitConstants.String.VIDEO_INFO, jSONArray);
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
