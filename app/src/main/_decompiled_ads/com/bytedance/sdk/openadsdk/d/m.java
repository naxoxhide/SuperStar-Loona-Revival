package com.bytedance.sdk.openadsdk.d;

import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: StatsBatchEventRepertoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static String a() {
        return "ALTER TABLE logstatsbatch ADD COLUMN encrypt INTEGER default 0";
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS logstatsbatch (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0 , encrypt INTEGER default 0)";
    }
}
