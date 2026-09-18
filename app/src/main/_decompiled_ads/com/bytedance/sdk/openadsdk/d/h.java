package com.bytedance.sdk.openadsdk.d;

import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: HighPriorityEventRepertoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends d {
    public static String a() {
        return "ALTER TABLE loghighpriority ADD COLUMN encrypt INTEGER default 0";
    }

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS loghighpriority (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0 , encrypt INTEGER default 0)";
    }
}
