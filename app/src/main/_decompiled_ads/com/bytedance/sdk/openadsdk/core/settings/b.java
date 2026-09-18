package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.w;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdSlotSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();

    public static void a(boolean z) {
        File fileB = b();
        if (!fileB.exists()) {
            String strA = com.bytedance.sdk.openadsdk.m.b.b() ? com.bytedance.sdk.openadsdk.m.i.a.a("tt_sdk_settings", "ad_slot_conf", (String) null) : w.a("tt_sdk_settings", o.a()).a("ad_slot_conf", (String) null);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            try {
                HashMap<String, a> mapA = a(new JSONArray(strA));
                if (mapA.isEmpty()) {
                    return;
                }
                ConcurrentHashMap<String, a> concurrentHashMap = a;
                concurrentHashMap.clear();
                concurrentHashMap.putAll(mapA);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            HashMap<String, a> mapA2 = a(new JSONArray(new String(com.bytedance.sdk.component.utils.g.d(fileB))));
            if (mapA2.isEmpty()) {
                return;
            }
            for (Map.Entry<String, a> entry : mapA2.entrySet()) {
                String key = entry.getKey();
                a value = entry.getValue();
                if (!value.F || z) {
                    a.put(key, value);
                } else {
                    a aVar = a.get(key);
                    if (aVar != null) {
                        aVar.L = value.K;
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    private static File b() {
        return new File(o.a().getFilesDir(), "tt_ads_conf");
    }

    private static a b(String str) {
        return new a(str, 1);
    }

    public static void b(JSONArray jSONArray) throws Throwable {
        FileWriter fileWriter;
        if (jSONArray == null) {
            return;
        }
        File fileB = b();
        File file = new File(fileB.getParent(), fileB.getName() + ".tmp");
        FileWriter fileWriter2 = null;
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                fileWriter = new FileWriter(file);
                try {
                    fileWriter.write(jSONArray.toString());
                    file.renameTo(fileB);
                    w.a("tt_sdk_settings", o.a()).a("ad_slot_conf");
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.g.a(fileWriter);
                } catch (Exception e) {
                    e = e;
                    fileWriter2 = fileWriter;
                    Log.e("SdkSettings.AdSlot", "saveAdSlotToLocal: ", e);
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.g.a(fileWriter2);
                } catch (Throwable th) {
                    th = th;
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.g.a(fileWriter);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            HashMap<String, a> mapA = a(jSONArray);
            if (mapA.isEmpty()) {
                return;
            }
            for (Map.Entry<String, a> entry : mapA.entrySet()) {
                String key = entry.getKey();
                a value = entry.getValue();
                if (value.F) {
                    a aVar = a.get(key);
                    if (aVar != null) {
                        aVar.L = value.K;
                    }
                } else {
                    a.put(key, value);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter = null;
        }
    }

    private static HashMap<String, a> a(JSONArray jSONArray) {
        HashMap<String, a> map = new HashMap<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                a aVarA = a(jSONArray.getJSONObject(i));
                if (aVarA != null) {
                    map.put(aVarA.a, aVarA);
                }
            } catch (Exception unused) {
            }
        }
        return map;
    }

    private static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject);
    }

    public static a a(String str) {
        a aVar = a.get(str);
        return aVar == null ? b(str) : aVar;
    }

    public static void a() {
        File fileB = b();
        if (fileB.exists()) {
            fileB.delete();
        }
    }
}
