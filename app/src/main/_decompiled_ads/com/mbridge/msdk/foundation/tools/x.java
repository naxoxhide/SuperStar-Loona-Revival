package com.mbridge.msdk.foundation.tools;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SameFileMD5.java */
/* JADX INFO: loaded from: classes4.dex */
public class x {
    protected static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static MessageDigest f2230b = null;
    private static String c = "SameFileMD5";

    static {
        f2230b = null;
        try {
            f2230b = MessageDigest.getInstance(SameMD5.TAG);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(x.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
            e.printStackTrace();
        }
    }

    public static String a(File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    f2230b.update(fileInputStream2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                    byte[] bArrDigest = f2230b.digest();
                    String strA = a(bArrDigest, 0, bArrDigest.length);
                    fileInputStream2.close();
                    return strA;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    aa.b(c, "FILE EXCEPTION", e);
                    if (fileInputStream == null) {
                        return "";
                    }
                    fileInputStream.close();
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            byte b2 = bArr[i];
            char[] cArr = a;
            char c2 = cArr[(b2 & 240) >> 4];
            char c3 = cArr[b2 & 15];
            stringBuffer.append(c2);
            stringBuffer.append(c3);
            i++;
        }
        return stringBuffer.toString();
    }
}
