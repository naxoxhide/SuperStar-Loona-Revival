package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.g {
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1065b;
    public final byte[] c;
    public CipherInputStream d;

    public a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.g gVar, byte[] bArr, byte[] bArr2) {
        this.a = gVar;
        this.f1065b = bArr;
        this.c = bArr2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.f1065b, "AES"), new IvParameterSpec(this.c));
                this.d = new CipherInputStream(new com.fyber.inneractive.sdk.player.exoplayer2.upstream.i(this.a, jVar), cipher);
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public void close() throws IOException {
        this.d = null;
        this.a.close();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public int a(byte[] bArr, int i, int i2) throws IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.d != null);
        int i3 = this.d.read(bArr, i, i2);
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public Uri a() {
        return this.a.a();
    }
}
