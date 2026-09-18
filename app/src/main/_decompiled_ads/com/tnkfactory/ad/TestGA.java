package com.tnkfactory.ad;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TestGA {
    public static LogEventListener listener;

    public static void logEvent(String str, Map<String, String> map) {
        LogEventListener logEventListener = listener;
        if (logEventListener != null) {
            logEventListener.logEvent(str, map);
        }
    }
}
