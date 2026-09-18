package com.bytedance.sdk.openadsdk.core.settings;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ISettingsDataRepository.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {
    public static final d<JSONObject> a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d<Set<String>> f672b = new b();

    /* JADX INFO: compiled from: ISettingsDataRepository.java */
    static class a implements d<JSONObject> {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject a(String str) {
            try {
                return new JSONObject(str);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("ISettingsDataRepository", "", e);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: ISettingsDataRepository.java */
    static class b implements d<Set<String>> {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Set<String> a(String str) {
            HashSet hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    hashSet.add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("ISettingsDataRepository", "", e);
            }
            return hashSet;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.settings.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ISettingsDataRepository.java */
    public interface InterfaceC0213c {
        void commit();

        InterfaceC0213c putBoolean(String str, boolean z);

        InterfaceC0213c putFloat(String str, float f);

        InterfaceC0213c putInt(String str, int i);

        InterfaceC0213c putLong(String str, long j);

        InterfaceC0213c putString(String str, String str2);

        InterfaceC0213c remove(String str);
    }

    /* JADX INFO: compiled from: ISettingsDataRepository.java */
    public interface d<T> {
        T a(String str);
    }

    void a(JSONObject jSONObject);
}
