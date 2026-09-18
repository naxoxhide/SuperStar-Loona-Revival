package com.tapjoy.internal;

import com.tapjoy.TapjoyURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class i8 {
    public static String c;
    public static Map d;
    public static boolean e;
    public static Map f;
    public final String a = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TapjoyURLConnection f2770b = new TapjoyURLConnection();

    public static void a(Map map, Map map2) {
        String str = (String) map2.get("url");
        if (str == null) {
            str = "";
        }
        c = str;
        e = true;
        d = map;
        f = map2;
    }

    public final void a(String str, HashMap map) {
        Map map2 = f;
        if (map2 == null || map2.get(str) == null) {
            return;
        }
        HashMap map3 = new HashMap(d);
        map3.put("sdk_beacon_id", this.a);
        if (map != null) {
            map3.putAll(map);
        }
        new h8(this, str, map3).start();
    }
}
