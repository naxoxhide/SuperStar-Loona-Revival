package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class ca {
    public static final ca c = new ca();
    public final t6 a = new t6();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f2739b;

    public static t6 a() {
        return c.a;
    }

    public final synchronized void a(Context context) {
        if (context != null) {
            if (this.f2739b == null) {
                this.f2739b = context;
                SharedPreferences sharedPreferences = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
                String string = this.f2739b.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).getString(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS, null);
                if (string != null) {
                    try {
                        d4 d4VarA = b4.a(string);
                        try {
                            LinkedHashMap linkedHashMapK = d4VarA.k();
                            d4VarA.close();
                            t6 t6Var = this.a;
                            t6Var.getClass();
                            Map map = (Map) linkedHashMapK.get("final");
                            Map map2 = (Map) linkedHashMapK.get("default");
                            t6Var.f2816b.a = map;
                            t6Var.e.a = map2;
                            t6Var.setChanged();
                        } catch (Throwable th) {
                            d4VarA.close();
                            throw th;
                        }
                    } catch (Exception unused) {
                        sharedPreferences.edit().remove(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS).apply();
                    }
                }
            }
        }
    }

    public final void a(Object obj) {
        Map map;
        Map map2;
        if (!(obj instanceof Map)) {
            if (obj == null) {
                t6 t6Var = this.a;
                t6Var.f2816b.a = null;
                t6Var.e.a = null;
                t6Var.setChanged();
                this.f2739b.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit().remove(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS).apply();
                return;
            }
            return;
        }
        try {
            t6 t6Var2 = this.a;
            Map map3 = (Map) obj;
            if (map3 != null) {
                t6Var2.getClass();
                map2 = (Map) map3.get("final");
                map = (Map) map3.get("default");
            } else {
                map = null;
                map2 = null;
            }
            t6Var2.f2816b.a = map2;
            t6Var2.e.a = map;
            t6Var2.setChanged();
            StringWriter stringWriter = new StringWriter();
            g4 g4Var = new g4(stringWriter);
            try {
                g4Var.a(obj);
                try {
                    g4Var.a.flush();
                    this.f2739b.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit().putString(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS, stringWriter.toString()).apply();
                } catch (IOException e) {
                    s9.a(e);
                    throw null;
                }
            } catch (IOException e2) {
                s9.a(e2);
                throw null;
            }
        } catch (Exception unused) {
        }
    }
}
