package com.bytedance.sdk.openadsdk.core.i0.m;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: VastMacroHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private final List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<b, String> f629b;

    public c(List<String> list) {
        this.a = list;
        HashMap map = new HashMap();
        this.f629b = map;
        map.put(b.CACHEBUSTING, a());
    }

    public c a(com.bytedance.sdk.openadsdk.core.i0.k.a aVar) {
        if (aVar != null) {
            this.f629b.put(b.ERRORCODE, aVar.b());
        }
        return this;
    }

    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        for (String strReplaceAll : this.a) {
            if (!TextUtils.isEmpty(strReplaceAll)) {
                for (b bVar : b.values()) {
                    String str = this.f629b.get(bVar);
                    if (str == null) {
                        str = "";
                    }
                    strReplaceAll = strReplaceAll.replaceAll("\\[" + bVar.name() + "\\]", str);
                }
                arrayList.add(strReplaceAll);
            }
        }
        return arrayList;
    }

    public c a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (Throwable unused) {
            }
            this.f629b.put(b.ASSETURI, str);
        }
        return this;
    }

    private String a() {
        return String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d)));
    }

    private String a(long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format("%02d:%02d:%02d.%03d", Long.valueOf(timeUnit.toHours(j)), Long.valueOf(timeUnit.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(timeUnit.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % 1000));
    }

    public c b(long j) {
        if (j >= 0) {
            String strA = a(j);
            if (!TextUtils.isEmpty(strA)) {
                this.f629b.put(b.CONTENTPLAYHEAD, strA);
            }
        }
        return this;
    }
}
