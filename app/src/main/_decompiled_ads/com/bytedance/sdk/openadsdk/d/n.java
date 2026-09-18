package com.bytedance.sdk.openadsdk.d;

import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: StatsEventRepertoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static String a() {
        return "ALTER TABLE logstats ADD COLUMN encrypt INTEGER default 0";
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS logstats (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , encrypt INTEGER default 0 , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0)";
    }
}
