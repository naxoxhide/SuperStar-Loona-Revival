package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.c;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SDKAuthorityController.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f2067b = null;
    private static boolean e = true;
    private static boolean f = true;
    public ArrayList<String> a = new ArrayList<>();
    private int d = 3;
    private AuthorityInfoBean c = new AuthorityInfoBean();

    private a() {
        try {
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
                this.c.b(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
                this.c.c(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
                this.c.d(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_OTHER).equals("")) {
                this.c.e(1);
            }
            this.a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static a a() {
        if (f2067b == null) {
            synchronized (a.class) {
                if (f2067b == null) {
                    f2067b = new a();
                }
            }
        }
        return f2067b;
    }

    public final void a(String str, int i) {
        if (this.c != null) {
            if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                this.c.b(i);
                return;
            }
            if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                this.c.c(i);
                return;
            }
            if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
                this.c.a(i);
            } else if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
                this.c.d(i);
            } else if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
                this.c.e(i);
            }
        }
    }

    public final AuthorityInfoBean b() {
        AuthorityInfoBean authorityInfoBean = this.c;
        return authorityInfoBean != null ? authorityInfoBean : new AuthorityInfoBean().a(1);
    }

    private int b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strB = com.mbridge.msdk.foundation.a.a.a.a().b(str);
                if (TextUtils.isEmpty(strB)) {
                    return 0;
                }
                return Integer.parseInt(strB);
            }
        } catch (Exception e2) {
            aa.d("SDKAuthorityController", e2.getMessage());
        }
        return 0;
    }

    private int c(String str) {
        c cVarB = d.a().b(b.d().h());
        if (cVarB == null) {
            cVarB = d.a().b();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return cVarB.H();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return cVarB.I();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return cVarB.G();
        }
        return -1;
    }

    public final boolean a(String str) {
        boolean z;
        c cVarB = d.a().b(b.d().h());
        boolean z2 = false;
        if (cVarB == null) {
            cVarB = d.a().b();
            z = true;
        } else {
            z = false;
        }
        int iJ = cVarB.J();
        boolean z3 = iJ != 0 ? iJ == 1 && c(str) == 1 : b(str) == 1 && c(str) == 1;
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z3 = b(str) == 1;
        }
        if (!str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) || a().d != 2) {
            return z3;
        }
        if (!cVarB.aB() && !z && b(str) == 1) {
            z2 = true;
        }
        return z2;
    }

    public final String c() {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.a.size(); i++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.a.get(i)));
                jSONObject.put("client_status", b(this.a.get(i)));
                jSONObject.put("server_status", c(this.a.get(i)));
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final void a(int i) {
        if (this.c != null) {
            this.d = i != 1 ? 2 : 1;
        }
    }

    public final boolean d() {
        int i = this.d;
        return i == 1 || i == 3;
    }

    public final void b(int i) {
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DNT, i);
    }

    public final int e() {
        return com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_COPPA, 0);
    }

    public final int f() {
        return this.d;
    }

    public static boolean g() {
        return e;
    }

    public static void a(boolean z) {
        e = z;
    }

    public static boolean h() {
        return f;
    }

    public static void b(boolean z) {
        f = z;
    }
}
