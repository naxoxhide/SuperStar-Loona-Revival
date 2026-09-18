package com.applovin.impl.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    protected final Context E;
    private final Map<String, Object> aRa = new HashMap();
    private final Object aRb = new Object();
    protected final SharedPreferences ays;
    protected final n sdk;

    public c(n nVar) {
        this.sdk = nVar;
        Context applicationContext = n.getApplicationContext();
        this.E = applicationContext;
        this.ays = applicationContext.getSharedPreferences("com.applovin.sdk.1", 0);
        try {
            Class.forName(b.class.getName());
            Class.forName(a.class.getName());
        } catch (Throwable unused) {
        }
        JE();
    }

    public <T> T a(b<T> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        synchronized (this.aRb) {
            Object obj = this.aRa.get(bVar.getName());
            if (obj == null) {
                return bVar.JB();
            }
            return bVar.af(obj);
        }
    }

    public List<String> b(b<String> bVar) {
        return CollectionUtils.explode((String) a(bVar));
    }

    public List<MaxAdFormat> c(b<String> bVar) {
        ArrayList arrayList = new ArrayList(6);
        Iterator<String> it = b(bVar).iterator();
        while (it.hasNext()) {
            arrayList.add(MaxAdFormat.formatFromString(it.next()));
        }
        return arrayList;
    }

    public <T> void a(b<?> bVar, Object obj) {
        if (bVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        if (obj == null) {
            throw new IllegalArgumentException("No new value specified");
        }
        synchronized (this.aRb) {
            this.aRa.put(bVar.getName(), obj);
        }
    }

    public void JD() {
        String strJG = JG();
        synchronized (this.aRb) {
            SharedPreferences.Editor editorEdit = this.ays.edit();
            for (b<?> bVar : b.JC()) {
                Object obj = this.aRa.get(bVar.getName());
                if (obj != null) {
                    this.sdk.a(strJG + bVar.getName(), obj, editorEdit);
                }
            }
            editorEdit.apply();
        }
    }

    public void JE() {
        String strJG = JG();
        synchronized (this.aRb) {
            for (b<?> bVar : b.JC()) {
                try {
                    Object objA = this.sdk.a(strJG + bVar.getName(), null, bVar.JB().getClass(), this.ays);
                    if (objA != null) {
                        this.aRa.put(bVar.getName(), objA);
                    }
                } catch (Throwable th) {
                    x.e("SettingsManager", "Unable to load \"" + bVar.getName() + "\"", th);
                    this.sdk.Cq().d("SettingsManager", "initSettings", th);
                }
            }
        }
    }

    public void M(JSONObject jSONObject) {
        synchronized (this.aRb) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && next.length() > 0) {
                    try {
                        b<Long> bVarA = a(next, (b) null);
                        if (bVarA != null) {
                            this.aRa.put(bVarA.getName(), a(next, jSONObject, bVarA.JB()));
                            if (bVarA == b.aQb) {
                                this.aRa.put(b.aQc.getName(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                    } catch (JSONException e) {
                        x.e("SettingsManager", "Unable to parse JSON settingsValues array", e);
                        this.sdk.Cq().d("SettingsManager", "loadSettings", e);
                    } catch (Throwable th) {
                        x.e("SettingsManager", "Unable to convert setting object ", th);
                        this.sdk.Cq().d("SettingsManager", "loadSettings", th);
                    }
                }
            }
        }
    }

    public void JF() {
        synchronized (this.aRb) {
            this.aRa.clear();
        }
        this.sdk.a(this.ays);
    }

    private String JG() {
        return "com.applovin.sdk." + u.dH(this.sdk.getSdkKey()) + ".";
    }

    private static Object a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    public <T> b<T> a(String str, b<T> bVar) {
        synchronized (this.aRb) {
            Iterator<b<?>> it = b.JC().iterator();
            while (it.hasNext()) {
                b<T> bVar2 = (b) it.next();
                if (bVar2.getName().equals(str)) {
                    return bVar2;
                }
            }
            return bVar;
        }
    }

    public boolean isVerboseLoggingEnabled() {
        return this.sdk.getSettings().isVerboseLoggingEnabled() || ((Boolean) a(b.aKm)).booleanValue();
    }
}
