package com.bytedance.sdk.openadsdk.core.g0;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.y;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MSSdkImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class a {
    private PglSSManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f594b;
    private volatile boolean c = true;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.g0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MSSdkImpl.java */
    class C0198a extends g {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0198a(String str, String str2) {
            super(str);
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a != null) {
                a.this.a.setDeviceId(this.c);
            }
        }
    }

    public a() {
        e();
    }

    private void b() {
        if (this.a == null) {
            this.a = PglSSManager.getInstance();
        }
    }

    private Class f() {
        Class<?> cls;
        try {
            cls = Class.forName("com.pgl.ssdk.ces.out.PglSSManager");
            try {
                this.c = true;
                m.d("mssdk", "class found");
            } catch (Throwable unused) {
                m.d("mssdk", "class not found ");
                this.c = false;
            }
        } catch (Throwable unused2) {
            cls = null;
        }
        return cls;
    }

    public String c() {
        if (!a()) {
            return "";
        }
        b();
        PglSSManager pglSSManager = this.a;
        return pglSSManager != null ? pglSSManager.getToken() : "";
    }

    public String d() {
        try {
            Context contextA = o.a();
            return a(MessageDigest.getInstance("SHA1").digest(contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 64).signatures[0].toByteArray())).toUpperCase();
        } catch (Throwable unused) {
            return "0000000000000000000000000000000000000000";
        }
    }

    public synchronized void e() {
        if (!this.f594b) {
            try {
                Context contextA = o.a();
                String strD = h.a().d();
                if (TextUtils.isEmpty(strD)) {
                    strD = h.a("app_id", Long.MAX_VALUE);
                }
                if (TextUtils.isEmpty(strD)) {
                    return;
                }
                String strC = j.c(contextA);
                PglSSManager.init(contextA, PglSSConfig.builder().setAppId(strD).setOVRegionType(0).build());
                b();
                PglSSManager pglSSManager = this.a;
                if (pglSSManager != null) {
                    pglSSManager.setDeviceId(strC);
                }
                m.d("mssdk", "init: success");
                this.f594b = true;
            } catch (Throwable th) {
                m.d("mssdk", "init: fail");
                m.c("MSSdkImpl", "appid is empty, initialization failed! or without the mssdk module", th);
                f();
                this.f594b = false;
            }
        }
    }

    public boolean g() {
        return this.f594b;
    }

    private boolean a() {
        if (!this.f594b && this.c) {
            e();
        }
        return this.f594b;
    }

    public void b(String str) {
        if (a()) {
            b();
            if (this.a != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    y.c(new C0198a("updateDid", str));
                } else {
                    this.a.setDeviceId(str);
                }
            }
        }
    }

    public void a(String str) {
        if (a()) {
            b();
            PglSSManager pglSSManager = this.a;
            if (pglSSManager != null) {
                pglSSManager.reportNow(str);
            }
        }
    }

    public Map<String, String> a(String str, byte[] bArr) {
        Map<String, String> featureHash;
        return (!a() || (featureHash = this.a.getFeatureHash(str, bArr)) == null) ? new HashMap() : featureHash;
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[bArr.length * 2];
        for (byte b2 = 0; b2 < bArr.length; b2 = (byte) (b2 + 1)) {
            int i = bArr[b2] & 255;
            int i2 = b2 * 2;
            cArr[i2] = charArray[i >>> 4];
            cArr[i2 + 1] = charArray[i & 15];
        }
        return new String(cArr);
    }
}
