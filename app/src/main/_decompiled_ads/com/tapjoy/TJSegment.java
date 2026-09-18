package com.tapjoy;

import com.tapjoy.internal.g9;

/* JADX INFO: loaded from: classes4.dex */
public enum TJSegment {
    NON_PAYER,
    PAYER,
    VIP,
    UNKNOWN;

    TJSegment() {
    }

    public int getValue() {
        int i = g9.a[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? -1 : 2;
        }
        return 1;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(getValue());
    }

    public static TJSegment valueOf(int i) {
        if (i == 0) {
            return NON_PAYER;
        }
        if (i != 1) {
            return i != 2 ? UNKNOWN : VIP;
        }
        return PAYER;
    }
}
