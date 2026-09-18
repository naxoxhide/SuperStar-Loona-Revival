package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TJKeyValueStorage {
    public static SharedPreferences a;

    public TJKeyValueStorage(Context context) {
        a = context.getSharedPreferences("tjJSSharedPreference", 0);
    }

    public boolean contains(String str) {
        return a.contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return a.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        return a.getInt(str, i);
    }

    public int getSize() {
        return a.getAll().size();
    }

    public String getString(String str, String str2) {
        return a.getString(str, str2);
    }

    public Object getValue(String str) {
        Object obj = a.getAll().get(str);
        if (obj == null) {
            return null;
        }
        if (obj.getClass() != String.class) {
            return obj.getClass() == Long.class ? Double.valueOf(Double.longBitsToDouble(((Long) obj).longValue())) : obj;
        }
        String str2 = (String) obj;
        if (str2.contains("tjJSON@")) {
            return new JSONObject(str2.replace("tjJSON@", ""));
        }
        return str2.contains("tjJSONArray@") ? new JSONArray(str2.replace("tjJSONArray@", "")) : obj;
    }

    public Object getValueType(String str) {
        Object obj = a.getAll().get(str);
        if (obj == null) {
            return null;
        }
        return obj.getClass();
    }

    public void remove(String str) {
        a.edit().remove(str).apply();
    }

    public void reset() {
        a.getAll().clear();
    }

    public void setValue(String str, Object obj) {
        if (obj == JSONObject.NULL) {
            a.edit().remove(str).apply();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            a.edit().putString(str, ((String) obj).replace("\"", "\\\"")).apply();
            return;
        }
        if (cls == Integer.class) {
            a.edit().putInt(str, ((Integer) obj).intValue()).apply();
            return;
        }
        if (cls == JSONObject.class) {
            a.edit().putString(str, "tjJSON@" + obj).apply();
            return;
        }
        if (cls == JSONArray.class) {
            a.edit().putString(str, "tjJSONArray@" + obj).apply();
        } else if (cls == Double.class) {
            a.edit().putLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue())).apply();
        } else {
            if (cls != Boolean.class) {
                throw new IllegalArgumentException("Unknown value type.");
            }
            a.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
        }
    }

    public TJKeyValueStorage(Context context, String str) {
        a = context.getSharedPreferences(str, 0);
    }
}
