package com.tnkfactory.framework.crypto;

/* JADX INFO: loaded from: classes4.dex */
public class EncryptUtils {
    public static final byte[] a = "adfjklq904rfgkl;anf".getBytes();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f2920b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final long[] c = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, 14, 15};

    public static String decryptRC4(String str) {
        byte[] hexBytes = toHexBytes(str);
        if (hexBytes == null) {
            return null;
        }
        new RC4Cryptor(a).init().decrypt(hexBytes, 0, hexBytes.length);
        return new String(hexBytes);
    }

    public static String md5Hex(String str) {
        MD5Hash mD5Hash = new MD5Hash();
        mD5Hash.update(str.getBytes());
        return toHexString(mD5Hash.getHash());
    }

    public static byte[] toHexBytes(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            long[] jArr = c;
            int i3 = i + 1;
            long j = (int) ((jArr[str.charAt(i) - '0'] << 4) & 240);
            i = i3 + 1;
            bArr[i2] = (byte) ((15 & jArr[str.charAt(i3) - '0']) | j);
        }
        return bArr;
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            char[] cArr = f2920b;
            sb.append(cArr[(b2 >> 4) & 15]).append(cArr[b2 & 15]);
        }
        return sb.toString();
    }
}
