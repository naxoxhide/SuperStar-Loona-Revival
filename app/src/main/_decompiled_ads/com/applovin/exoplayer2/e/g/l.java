package com.applovin.exoplayer2.e.g;

import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.q;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final boolean AV;
    public final int AW;
    public final byte[] AX;
    public final String tc;
    public final x.a xZ;

    public l(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        com.applovin.exoplayer2.l.a.checkArgument((bArr2 == null) ^ (i == 0));
        this.AV = z;
        this.tc = str;
        this.AW = i;
        this.AX = bArr2;
        this.xZ = new x.a(J(str), bArr, i2, i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int J(String str) {
        if (str == null) {
            return 1;
        }
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    b2 = 0;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    b2 = 1;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    b2 = 2;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    b2 = 3;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 1:
                return 2;
            default:
                q.h("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
