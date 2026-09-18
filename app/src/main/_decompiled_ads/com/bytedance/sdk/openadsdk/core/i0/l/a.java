package com.bytedance.sdk.openadsdk.core.i0.l;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VastAbsoluteProgressTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends c implements Comparable<a> {
    public long f;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.i0.l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VastAbsoluteProgressTracker.java */
    public static class C0201a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f618b;
        private c.f c = c.f.TRACKING_URL;
        private boolean d = false;

        public C0201a(String str, long j) {
            this.a = str;
            this.f618b = j;
        }

        public a a() {
            return new a(this.f618b, this.a, this.c, Boolean.valueOf(this.d));
        }
    }

    protected a(long j, String str, c.f fVar, Boolean bool) {
        super(str, fVar, bool);
        this.f = j;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        String[] strArrSplit = str.split(CertificateUtil.DELIMITER);
        if (strArrSplit.length == 3) {
            try {
                return (int) ((Integer.parseInt(strArrSplit[0]) * 60 * 60 * 1000) + (Integer.parseInt(strArrSplit[1]) * 60 * 1000) + (Float.parseFloat(strArrSplit[2]) * 1000.0f));
            } catch (Throwable unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    public JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", c());
        jSONObject.put("trackingMilliseconds", this.f);
        return jSONObject;
    }

    public boolean a(long j) {
        return this.f <= j && !e();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return 1;
        }
        long j = this.f;
        long j2 = aVar.f;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }
}
