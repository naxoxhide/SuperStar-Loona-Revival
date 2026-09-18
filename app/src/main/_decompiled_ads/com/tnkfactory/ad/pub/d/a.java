package com.tnkfactory.ad.pub.d;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a {
    public static final String a(int i) {
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            return "Success.";
        }
        if (i2 == 1) {
            return "Not supported action.";
        }
        if (i2 == 2) {
            return "Parameter url is not given.";
        }
        if (i2 == 3) {
            return "String encoding or decoding error.";
        }
        if (i2 != 4) {
            return i2 != 5 ? "" : "System error.";
        }
        return "Video player not installed.";
    }
}
