package com.bytedance.sdk.openadsdk.n;

import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import java.util.Map;

/* JADX INFO: compiled from: TTAdNetDepend.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements b.b.a.a.j.e.b {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f807b = "sp_multi_ttadnet_config";

    public b(Context context) {
        this.a = context;
    }

    @Override // b.b.a.a.j.e.b
    public Address a(Context context) {
        return null;
    }

    @Override // b.b.a.a.j.e.b
    public String a(Context context, String str, String str2) {
        return com.bytedance.sdk.openadsdk.m.i.a.a(this.f807b, str, str2);
    }

    @Override // b.b.a.a.j.e.b
    public int b() {
        return BuildConfig.VERSION_CODE;
    }

    @Override // b.b.a.a.j.e.b
    public String c() {
        return j.c(this.a);
    }

    @Override // b.b.a.a.j.e.b
    public String d() {
        return "android";
    }

    @Override // b.b.a.a.j.e.b
    public int e() {
        return Integer.parseInt("1371");
    }

    @Override // b.b.a.a.j.e.b
    public String f() {
        return "pangle_sdk";
    }

    @Override // b.b.a.a.j.e.b
    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        com.bytedance.sdk.openadsdk.m.i.a.a(this.f807b, entry.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        com.bytedance.sdk.openadsdk.m.i.a.a(this.f807b, entry.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        com.bytedance.sdk.openadsdk.m.i.a.a(this.f807b, entry.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        com.bytedance.sdk.openadsdk.m.i.a.a(this.f807b, entry.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        com.bytedance.sdk.openadsdk.m.i.a.b(this.f807b, entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // b.b.a.a.j.e.b
    public String[] a() {
        String[] strArr = {"tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com", "tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com"};
        String strJ = o.d().j();
        if (!TextUtils.isEmpty(strJ)) {
            return ("SG".equals(strJ) || "CN".equals(strJ)) ? new String[]{"tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com", "tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com"} : strArr;
        }
        int iL = a0.l();
        return (iL == 2 || iL == 1) ? new String[]{"tnc16-alisg.isnssdk.com", "tnc16-alisg.byteoversea.com", "tnc16-useast1a.isnssdk.com", "tnc16-useast1a.byteoversea.com"} : strArr;
    }
}
