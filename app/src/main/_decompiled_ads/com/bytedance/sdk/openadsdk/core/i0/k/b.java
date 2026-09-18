package com.bytedance.sdk.openadsdk.core.i0.k;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.i0.l.c;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: VastXmlParser.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f615b;
    protected int c;
    protected double d;
    public int e;
    public a f;

    /* JADX INFO: compiled from: VastXmlParser.java */
    public static class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f616b;
        public boolean c;
    }

    public b(Context context, int i, int i2) {
        this.c = 0;
        this.d = 0.0d;
        if (i2 > 0 && i > 0) {
            this.d = ((double) i) / ((double) i2);
        }
        float fA = b0.a(context);
        if (fA != 0.0f && i > 0) {
            this.c = (int) (i / fA);
        }
        this.f615b = context.getApplicationContext();
    }

    protected void a(Exception exc, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", exc.getMessage());
            jSONObject.put("error_code", i);
            com.bytedance.sdk.openadsdk.l.b.a().a("load_vast", jSONObject);
        } catch (Exception unused) {
        }
    }

    public abstract com.bytedance.sdk.openadsdk.core.i0.a b(String str, List<c> list);

    protected boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Integer.parseInt(str) < 2;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    protected String a(String str, List<c> list) {
        String strA;
        int i = this.a;
        if (i >= 5) {
            return null;
        }
        this.a = i + 1;
        if (str == null) {
            return null;
        }
        try {
            b.b.a.a.j.d.b bVarB = com.bytedance.sdk.openadsdk.n.c.b().d().b();
            bVarB.b(str);
            b.b.a.a.j.b bVarB2 = bVarB.b();
            strA = bVarB2.a();
            try {
                bVarB2.b();
            } catch (Exception e) {
                e = e;
                a(e, 0);
                if (!list.isEmpty()) {
                    c.a(list, com.bytedance.sdk.openadsdk.core.i0.k.a.WRAPPER_TIMEOUT, -1L, null);
                }
            }
        } catch (Exception e2) {
            e = e2;
            strA = null;
        }
        return strA;
    }
}
