package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Base64;
import com.gomfactory.adpie.sdk.security.Crypto;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: AESCBCUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static byte[] a = new byte[32];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f2195b = new byte[16];

    static {
        if (TextUtils.isEmpty("ebmclXzZOhtU2sRlZxGL8A")) {
            return;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("sha-384").digest("ebmclXzZOhtU2sRlZxGL8A".getBytes());
            System.arraycopy(bArrDigest, 0, a, 0, 32);
            System.arraycopy(bArrDigest, 32, f2195b, 0, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(String str) {
        return a(str, a, f2195b);
    }

    private static String a(String str, byte[] bArr, byte[] bArr2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Security.addProvider(new C0487a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.tools.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AESCBCUtil.java */
    public static class C0487a extends Provider {
        public C0487a() {
            super(Crypto.TAG, 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }
}
