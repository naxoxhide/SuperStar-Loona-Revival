package com.stansassets.core.utility;

/* JADX INFO: loaded from: classes4.dex */
public class SA_IdFactory {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String RandomString() {
        StringBuilder sb = new StringBuilder();
        int i = 10;
        while (true) {
            int i2 = i - 1;
            if (i != 0) {
                sb.append(ALPHA_NUMERIC_STRING.charAt((int) (Math.random() * ((double) 36))));
                i = i2;
            } else {
                return sb.toString();
            }
        }
    }
}
