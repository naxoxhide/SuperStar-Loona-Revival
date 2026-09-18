package com.tapjoy;

import com.tapjoy.internal.q9;

/* JADX INFO: loaded from: classes4.dex */
public enum TJStatus {
    FALSE,
    TRUE,
    UNKNOWN;

    TJStatus() {
    }

    public int getValue() {
        int i = q9.a[ordinal()];
        if (i != 1) {
            return i != 2 ? 2 : 1;
        }
        return 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(getValue());
    }

    public static TJStatus valueOf(int i) {
        if (i != 0) {
            return i != 1 ? UNKNOWN : TRUE;
        }
        return FALSE;
    }
}
