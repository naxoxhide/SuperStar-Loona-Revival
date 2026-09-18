package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private static final int[] aVC = {7, 4, 2, 1, 11};
    private static final int[] aVD = {5, 6, 12, 10, 3, 9, 8, 14};
    private static final int[] aVE = {15, 13};
    private static final int[] aVF = {20};

    public static String c(String str, com.applovin.impl.sdk.n nVar) {
        return a((String) nVar.a(com.applovin.impl.sdk.c.b.aLr), str, nVar);
    }

    public static String d(String str, com.applovin.impl.sdk.n nVar) {
        return a((String) nVar.a(com.applovin.impl.sdk.c.b.aLs), str, nVar);
    }

    public static Map<String, String> F(com.applovin.impl.sdk.n nVar) {
        HashMap map = new HashMap();
        String str = (String) nVar.a(com.applovin.impl.sdk.c.b.aKk);
        if (StringUtils.isValidString(str)) {
            map.put("device_token", str);
        } else if (!((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()) {
            map.put("api_key", nVar.getSdkKey());
        }
        if (nVar.BT() != null) {
            map.putAll(u.s(nVar.BT().Db()));
        } else {
            map.putAll(u.s(nVar.BQ().Db()));
        }
        return map;
    }

    public static void a(JSONObject jSONObject, boolean z, com.applovin.impl.sdk.n nVar) {
        nVar.Cf().a(jSONObject, z);
    }

    public static void b(int i, com.applovin.impl.sdk.n nVar) {
        if (i == 401) {
            com.applovin.impl.sdk.x.H("AppLovinSdk", "SDK key \"" + nVar.getSdkKey() + "\" is rejected by AppLovin. Please make sure the SDK key is correct.");
            return;
        }
        if (i == 418) {
            nVar.BN().a((com.applovin.impl.sdk.c.b<?>) com.applovin.impl.sdk.c.b.aKg, (Object) true);
            nVar.BN().JD();
        } else if (i >= 400 && i < 500) {
            if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aKi)).booleanValue()) {
                nVar.Bv();
            }
        } else if (i == -1 && ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aKi)).booleanValue()) {
            nVar.Bv();
        }
    }

    public static String a(String str, String str2, com.applovin.impl.sdk.n nVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        return str + str2;
    }

    public static void i(JSONObject jSONObject, com.applovin.impl.sdk.n nVar) {
        String string = JsonUtils.getString(jSONObject, "persisted_data", null);
        if (StringUtils.isValidString(string)) {
            nVar.a(com.applovin.impl.sdk.c.d.aRH, string);
            nVar.BL();
            if (com.applovin.impl.sdk.x.Fk()) {
                nVar.BL().g("ConnectionUtils", "Updated persisted data");
            }
        }
    }

    public static void j(JSONObject jSONObject, com.applovin.impl.sdk.n nVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        try {
            if (jSONObject.has("settings")) {
                com.applovin.impl.sdk.c.c cVarBN = nVar.BN();
                if (jSONObject.isNull("settings")) {
                    return;
                }
                cVarBN.M(jSONObject.getJSONObject("settings"));
                cVarBN.JD();
            }
        } catch (JSONException e) {
            nVar.BL();
            if (com.applovin.impl.sdk.x.Fk()) {
                nVar.BL().c("ConnectionUtils", "Unable to parse settings out of API response", e);
            }
        }
    }

    public static void k(JSONObject jSONObject, com.applovin.impl.sdk.n nVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "filesystem_values", (JSONObject) null);
        if (jSONObject2 != null) {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.n.getApplicationContext()).edit();
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object object = JsonUtils.getObject(jSONObject2, next, null);
                if (object != null) {
                    com.applovin.impl.sdk.c.e.a(next, object, (SharedPreferences) null, editorEdit);
                }
            }
            editorEdit.apply();
        }
    }

    public static byte[] a(InputStream inputStream, com.applovin.impl.sdk.n nVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNO)).intValue()];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String G(com.applovin.impl.sdk.n nVar) {
        NetworkInfo networkInfoZ = Z(com.applovin.impl.sdk.n.getApplicationContext());
        if (networkInfoZ == null) {
            return "unknown";
        }
        int type = networkInfoZ.getType();
        int subtype = networkInfoZ.getSubtype();
        if (type == 1) {
            return TapjoyConstants.TJC_CONNECTION_TYPE_WIFI;
        }
        if (type != 0) {
            return "unknown";
        }
        if (a(subtype, aVC)) {
            return "2g";
        }
        if (a(subtype, aVD)) {
            return "3g";
        }
        if (a(subtype, aVE)) {
            return "4g";
        }
        return a(subtype, aVF) ? "5g" : TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE;
    }

    public static int H(com.applovin.impl.sdk.n nVar) {
        NetworkInfo networkInfoZ = Z(com.applovin.impl.sdk.n.getApplicationContext());
        if (networkInfoZ != null) {
            int type = networkInfoZ.getType();
            int subtype = networkInfoZ.getSubtype();
            if (type == 1) {
                return 2;
            }
            if (type == 0) {
                if (a(subtype, aVC)) {
                    return 4;
                }
                if (a(subtype, aVD)) {
                    return 5;
                }
                if (a(subtype, aVE)) {
                    return 6;
                }
                return a(subtype, aVF) ? 7 : 3;
            }
        }
        return 0;
    }

    public static boolean Y(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo networkInfoZ = Z(context);
        if (networkInfoZ != null) {
            return networkInfoZ.isConnected();
        }
        return false;
    }

    private static NetworkInfo Z(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    private static boolean a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static String b(com.applovin.impl.sdk.n nVar) {
        return a((String) nVar.a(com.applovin.impl.sdk.c.b.aLp), ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNV)).booleanValue() ? "5.0/ad" : "4.0/ad", nVar);
    }

    public static String c(com.applovin.impl.sdk.n nVar) {
        return a((String) nVar.a(com.applovin.impl.sdk.c.b.aLq), ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNV)).booleanValue() ? "5.0/ad" : "4.0/ad", nVar);
    }

    public static String I(com.applovin.impl.sdk.n nVar) {
        return a((String) nVar.a(com.applovin.impl.sdk.c.b.aLp), "4.0/ad", nVar);
    }

    public static String J(com.applovin.impl.sdk.n nVar) {
        return a((String) nVar.a(com.applovin.impl.sdk.c.b.aLq), "4.0/ad", nVar);
    }

    public static Long K(com.applovin.impl.sdk.n nVar) {
        com.applovin.impl.sdk.network.b.c cVarHI = nVar.BO().HI();
        if (cVarHI == null) {
            return null;
        }
        double dCb = u.cb(cVarHI.HM());
        double dBY = u.bY(cVarHI.HN());
        if (dBY == 0.0d) {
            return null;
        }
        return Long.valueOf((long) (dCb / dBY));
    }
}
