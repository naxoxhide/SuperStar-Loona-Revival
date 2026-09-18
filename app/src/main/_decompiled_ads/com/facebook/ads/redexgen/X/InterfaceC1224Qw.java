package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1224Qw {
    boolean ABK(C1222Qu c1222Qu);

    HttpURLConnection ADe(String str, Proxy proxy) throws IOException;

    InputStream ADf(HttpURLConnection httpURLConnection) throws IOException;

    OutputStream ADg(HttpURLConnection httpURLConnection) throws IOException;

    void ADw(HttpURLConnection httpURLConnection, EnumC1220Qs enumC1220Qs, String str) throws IOException;

    byte[] AEG(InputStream inputStream) throws IOException;

    void AGV(OutputStream outputStream, byte[] bArr) throws IOException;
}
