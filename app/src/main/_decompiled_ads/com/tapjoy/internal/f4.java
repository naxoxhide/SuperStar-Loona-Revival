package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class f4 {
    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "BEGIN_ARRAY";
        }
        if (i == 2) {
            return "END_ARRAY";
        }
        if (i == 3) {
            return "BEGIN_OBJECT";
        }
        if (i == 4) {
            return "END_OBJECT";
        }
        if (i == 5) {
            return "NAME";
        }
        if (i == 6) {
            return "STRING";
        }
        if (i == 7) {
            return "NUMBER";
        }
        if (i == 8) {
            return "BOOLEAN";
        }
        if (i == 9) {
            return "NULL";
        }
        return i == 10 ? "END_DOCUMENT" : "null";
    }
}
