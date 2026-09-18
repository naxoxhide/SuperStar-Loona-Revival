package com.bytedance.sdk.openadsdk.d;

import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: AdEventRepertoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static String a() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0 , encrypt INTEGER default 0)";
    }
}
