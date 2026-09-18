package com.applovin.impl.privacy;

import android.content.Context;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.x;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final C0133a axj = new C0133a("Age Restricted User", d.aRm);
    private static final C0133a axk = new C0133a("Has User Consent", d.aRl);
    private static final C0133a axl = new C0133a("\"Do Not Sell\"", d.aRn);

    public static C0133a zM() {
        return axj;
    }

    public static C0133a zN() {
        return axk;
    }

    public static C0133a zO() {
        return axl;
    }

    public static boolean a(boolean z, Context context) {
        return a(d.aRm, Boolean.valueOf(z), context);
    }

    public static boolean b(boolean z, Context context) {
        return a(d.aRl, Boolean.valueOf(z), context);
    }

    public static boolean c(boolean z, Context context) {
        return a(d.aRn, Boolean.valueOf(z), context);
    }

    public static String A(Context context) {
        return a(axj, context) + a(axk, context) + a(axl, context);
    }

    private static boolean a(d<Boolean> dVar, Boolean bool, Context context) {
        if (context == null) {
            x.H("AppLovinSdk", "Failed to update compliance value for key: " + dVar);
            return false;
        }
        Boolean bool2 = (Boolean) e.b(dVar, (Object) null, context);
        e.a(dVar, bool, context);
        return bool2 == null || bool2 != bool;
    }

    private static String a(C0133a c0133a, Context context) {
        return "\n" + c0133a.name + " - " + c0133a.C(context);
    }

    /* JADX INFO: renamed from: com.applovin.impl.privacy.a$a, reason: collision with other inner class name */
    public static class C0133a {
        private final d<Boolean> axm;
        private final String name;

        C0133a(String str, d<Boolean> dVar) {
            this.name = str;
            this.axm = dVar;
        }

        public String getName() {
            return this.name;
        }

        public Boolean B(Context context) {
            if (context == null) {
                x.H("AppLovinSdk", "Failed to get value for key: " + this.axm);
                return null;
            }
            return (Boolean) e.b(this.axm, (Object) null, context);
        }

        public String C(Context context) {
            Boolean boolB = B(context);
            return boolB != null ? boolB.toString() : "No value set";
        }
    }
}
