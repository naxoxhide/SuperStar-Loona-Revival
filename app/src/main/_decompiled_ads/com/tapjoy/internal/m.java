package com.tapjoy.internal;

import android.util.Base64;
import com.tapjoy.TapjoyUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes4.dex */
public final class m {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2780b;
    public final String c;
    public final String d;
    public final String e;

    public m(String str) {
        int length = str.length();
        if (!str.matches("[A-Za-z0-9\\-_]*") || length < 60 || (length & 3) != 0) {
            throw new IllegalArgumentException("The given API key was malformed.");
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 8);
            int length2 = bArrDecode.length;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrDecode);
            byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
            int length3 = bArrDecode.length - 4;
            int i = byteBufferWrap.getInt(length3);
            CRC32 crc32 = new CRC32();
            crc32.update(bArrDecode, 0, length3);
            if (i != ((int) crc32.getValue())) {
                throw new IllegalArgumentException("The given API key was invalid.");
            }
            this.a = str;
            this.c = new UUID(byteBufferWrap.getLong(0), byteBufferWrap.getLong(8)).toString();
            byte b2 = byteBufferWrap.get(16);
            int iA = l.a(byteBufferWrap.get(17));
            this.f2780b = iA;
            this.d = str.substring(24, 44);
            if (b2 == 1) {
                this.e = null;
                return;
            }
            if (b2 != 2 || iA != 1) {
                throw new IllegalArgumentException("The given API key was not supported.");
            }
            if (length2 < 57) {
                throw new IllegalArgumentException("The given API key was invalid.");
            }
            byte[] bArr = new byte[12];
            System.arraycopy(bArrDecode, 33, bArr, 0, 12);
            this.e = TapjoyUtil.convertToHex(bArr);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The given API key was malformed.", e);
        }
    }

    public static String a(String str) {
        if (str.regionMatches(13, "-8000-8000-", 0, 11)) {
            return new StringBuffer().append(str.substring(0, 8)).append(str.substring(24, 30)).append(str.substring(9, 13)).append(str.substring(30)).toString();
        }
        throw new IllegalArgumentException("The given UUID did not come from 5Rocks.");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.a.equals(((m) obj).a);
        }
        return false;
    }

    public final String toString() {
        return this.a;
    }
}
