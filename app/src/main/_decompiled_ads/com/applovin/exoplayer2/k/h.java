package com.applovin.exoplayer2.k;

import android.net.Uri;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.exoplayer2.l.ai;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes.dex */
public final class h extends e {
    private int Nd;
    private int Zt;
    private byte[] tf;
    private l tw;

    public h() {
        super(false);
    }

    @Override // com.applovin.exoplayer2.k.i
    public long a(l lVar) throws IOException {
        b(lVar);
        this.tw = lVar;
        Uri uri = lVar.ef;
        String scheme = uri.getScheme();
        com.applovin.exoplayer2.l.a.checkArgument("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrL = ai.l(uri.getSchemeSpecificPart(), ",");
        if (strArrL.length != 2) {
            throw com.applovin.exoplayer2.ai.b("Unexpected URI format: " + uri, null);
        }
        String str = strArrL[1];
        if (strArrL[0].contains(";base64")) {
            try {
                this.tf = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw com.applovin.exoplayer2.ai.b("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.tf = ai.bk(URLDecoder.decode(str, Charsets.US_ASCII.name()));
        }
        if (lVar.uc > this.tf.length) {
            this.tf = null;
            throw new j(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        int i = (int) lVar.uc;
        this.Nd = i;
        this.Zt = this.tf.length - i;
        if (lVar.wC != -1) {
            this.Zt = (int) Math.min(this.Zt, lVar.wC);
        }
        c(lVar);
        return lVar.wC != -1 ? lVar.wC : this.Zt;
    }

    @Override // com.applovin.exoplayer2.k.g
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.Zt;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        System.arraycopy(ai.R(this.tf), this.Nd, bArr, i, iMin);
        this.Nd += iMin;
        this.Zt -= iMin;
        fe(iMin);
        return iMin;
    }

    @Override // com.applovin.exoplayer2.k.i
    public Uri getUri() {
        l lVar = this.tw;
        if (lVar != null) {
            return lVar.ef;
        }
        return null;
    }

    @Override // com.applovin.exoplayer2.k.i
    public void close() {
        if (this.tf != null) {
            this.tf = null;
            oe();
        }
        this.tw = null;
    }
}
