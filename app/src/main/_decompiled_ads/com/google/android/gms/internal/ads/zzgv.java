package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.webkit.ProxyConfig;
import com.facebook.ads.AdError;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgv extends zzgc implements zzhf {
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzhe zzf;
    private final zzhe zzg;
    private zzgn zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;

    @Deprecated
    public zzgv() {
        this(null, 8000, 8000, false, null, null, false);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0073  */
    private final HttpURLConnection zzk(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) throws IOException {
        StringBuilder sb;
        String string;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzc);
        httpURLConnection.setReadTimeout(this.zzd);
        HashMap map2 = new HashMap();
        map2.putAll(this.zzf.zza());
        map2.putAll(this.zzg.zza());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j != 0) {
            sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        } else if (j2 == -1) {
            string = null;
        } else {
            j = 0;
            sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        }
        if (string != null) {
            httpURLConnection.setRequestProperty("Range", string);
        }
        String str = this.zze;
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, true != z ? "identity" : "gzip");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(false);
        int i2 = zzgn.zzj;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final URL zzl(URL url, String str, zzgn zzgnVar) throws zzhb {
        if (str == null) {
            throw new zzhb("Null location redirect", zzgnVar, AdError.INTERNAL_ERROR_CODE, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                throw new zzhb("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzgnVar, AdError.INTERNAL_ERROR_CODE, 1);
            }
            if (this.zzb || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new zzhb("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", zzgnVar, AdError.INTERNAL_ERROR_CODE, 1);
        } catch (MalformedURLException e) {
            throw new zzhb(e, zzgnVar, AdError.INTERNAL_ERROR_CODE, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzer.zzd("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i, int i2) throws zzhb {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzm;
            if (j != -1) {
                long j2 = j - this.zzn;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j2);
            }
            InputStream inputStream = this.zzj;
            int i3 = zzfk.zza;
            int i4 = inputStream.read(bArr, i, i2);
            if (i4 == -1) {
                return -1;
            }
            this.zzn += (long) i4;
            zzg(i4);
            return i4;
        } catch (IOException e) {
            zzgn zzgnVar = this.zzh;
            int i5 = zzfk.zza;
            throw zzhb.zza(e, zzgnVar, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    @Override // com.google.android.gms.internal.ads.zzgi
    public final long zzb(zzgn zzgnVar) throws zzhb {
        int i;
        HttpURLConnection httpURLConnectionZzk;
        byte[] byteArray;
        long j;
        this.zzh = zzgnVar;
        this.zzn = 0L;
        this.zzm = 0L;
        zzi(zzgnVar);
        try {
            URL url = new URL(zzgnVar.zza.toString());
            int i2 = zzgnVar.zzb;
            byte[] bArr = zzgnVar.zzc;
            long j2 = zzgnVar.zzf;
            long j3 = zzgnVar.zzg;
            boolean zZza = zzgnVar.zza(1);
            try {
                if (this.zzb) {
                    URL urlZzl = url;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        if (i3 > 20) {
                            i = 1;
                            throw new zzhb(new NoRouteToHostException("Too many redirects: " + i4), zzgnVar, AdError.INTERNAL_ERROR_CODE, 1);
                        }
                        long j4 = j3;
                        long j5 = j2;
                        URL url2 = urlZzl;
                        HttpURLConnection httpURLConnectionZzk2 = zzk(urlZzl, 1, null, j2, j3, zZza, false, zzgnVar.zzd);
                        int responseCode = httpURLConnectionZzk2.getResponseCode();
                        String headerField = httpURLConnectionZzk2.getHeaderField(HttpHeaders.LOCATION);
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                            httpURLConnectionZzk = httpURLConnectionZzk2;
                            break;
                        }
                        i = 1;
                        try {
                            httpURLConnectionZzk2.disconnect();
                            urlZzl = zzl(url2, headerField, zzgnVar);
                            i3 = i4;
                            j3 = j4;
                            j2 = j5;
                        } catch (IOException e) {
                            e = e;
                        }
                        e = e;
                        zzm();
                        throw zzhb.zza(e, zzgnVar, i);
                    }
                }
                httpURLConnectionZzk = zzk(url, 1, null, j2, j3, zZza, true, zzgnVar.zzd);
                this.zzi = httpURLConnectionZzk;
                this.zzl = httpURLConnectionZzk.getResponseCode();
                String responseMessage = httpURLConnectionZzk.getResponseMessage();
                int i5 = this.zzl;
                if (i5 < 200 || i5 > 299) {
                    Map<String, List<String>> headerFields = httpURLConnectionZzk.getHeaderFields();
                    if (this.zzl == 416) {
                        if (zzgnVar.zzf == zzhg.zzb(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                            this.zzk = true;
                            zzj(zzgnVar);
                            long j6 = zzgnVar.zzg;
                            if (j6 != -1) {
                                return j6;
                            }
                            return 0L;
                        }
                    }
                    InputStream errorStream = httpURLConnectionZzk.getErrorStream();
                    try {
                        if (errorStream != null) {
                            int i6 = zzfk.zza;
                            byte[] bArr2 = new byte[4096];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                int i7 = errorStream.read(bArr2);
                                if (i7 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i7);
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                        } else {
                            byteArray = zzfk.zzf;
                        }
                    } catch (IOException unused) {
                        byteArray = zzfk.zzf;
                    }
                    zzm();
                    throw new zzhd(this.zzl, responseMessage, this.zzl == 416 ? new zzgj(AdError.REMOTE_ADS_SERVICE_ERROR) : null, headerFields, zzgnVar, byteArray);
                }
                httpURLConnectionZzk.getContentType();
                if (this.zzl == 200) {
                    j = zzgnVar.zzf;
                    if (j == 0) {
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                if (zEqualsIgnoreCase) {
                    this.zzm = zzgnVar.zzg;
                } else {
                    long j7 = zzgnVar.zzg;
                    if (j7 != -1) {
                        this.zzm = j7;
                    } else {
                        long jZza = zzhg.zza(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE));
                        this.zzm = jZza != -1 ? jZza - j : -1L;
                    }
                }
                try {
                    this.zzj = httpURLConnectionZzk.getInputStream();
                    if (zEqualsIgnoreCase) {
                        this.zzj = new GZIPInputStream(this.zzj);
                    }
                    this.zzk = true;
                    zzj(zzgnVar);
                    if (j != 0) {
                        try {
                            byte[] bArr3 = new byte[4096];
                            while (j > 0) {
                                int iMin = (int) Math.min(j, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                                InputStream inputStream = this.zzj;
                                int i8 = zzfk.zza;
                                int i9 = inputStream.read(bArr3, 0, iMin);
                                if (Thread.currentThread().isInterrupted()) {
                                    throw new zzhb(new InterruptedIOException(), zzgnVar, 2000, 1);
                                }
                                if (i9 == -1) {
                                    throw new zzhb(zzgnVar, AdError.REMOTE_ADS_SERVICE_ERROR, 1);
                                }
                                j -= (long) i9;
                                zzg(i9);
                            }
                        } catch (IOException e2) {
                            zzm();
                            if (e2 instanceof zzhb) {
                                throw ((zzhb) e2);
                            }
                            throw new zzhb(e2, zzgnVar, 2000, 1);
                        }
                    }
                    return this.zzm;
                } catch (IOException e3) {
                    zzm();
                    throw new zzhb(e3, zzgnVar, 2000, 1);
                }
            } catch (IOException e4) {
                e = e4;
                i = 1;
            }
        } catch (IOException e5) {
            e = e5;
            i = 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x008c */
    /* JADX WARN: Code duplicated, block: B:27:0x004f A[Catch: Exception -> 0x006b, all -> 0x008c, TRY_LEAVE, TryCatch #0 {Exception -> 0x006b, blocks: (B:15:0x0020, B:17:0x0028, B:23:0x0037, B:25:0x0047, B:27:0x004f, B:29:0x005a), top: B:45:0x0020 }] */
    @Override // com.google.android.gms.internal.ads.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd() throws com.google.android.gms.internal.ads.zzhb {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r10.zzj     // Catch: java.lang.Throwable -> L8c
            if (r2 == 0) goto L7d
            long r3 = r10.zzm     // Catch: java.lang.Throwable -> L8c
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L10
            r3 = r5
            goto L13
        L10:
            long r7 = r10.zzn     // Catch: java.lang.Throwable -> L8c
            long r3 = r3 - r7
        L13:
            java.net.HttpURLConnection r7 = r10.zzi     // Catch: java.lang.Throwable -> L8c
            if (r7 == 0) goto L6b
            int r8 = com.google.android.gms.internal.ads.zzfk.zza     // Catch: java.lang.Throwable -> L8c
            int r8 = com.google.android.gms.internal.ads.zzfk.zza     // Catch: java.lang.Throwable -> L8c
            r9 = 20
            if (r8 <= r9) goto L20
            goto L6b
        L20:
            java.io.InputStream r7 = r7.getInputStream()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L30
            int r3 = r7.read()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            r4 = -1
            if (r3 == r4) goto L6b
            goto L37
        L30:
            r5 = 2048(0x800, double:1.012E-320)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L37
            goto L6b
        L37:
            java.lang.Class r3 = r7.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r4.equals(r3)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            if (r4 != 0) goto L4f
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            if (r3 == 0) goto L6b
        L4f:
            java.lang.Class r3 = r7.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            java.util.Objects.requireNonNull(r3)
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
            r3.invoke(r7, r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8c
        L6b:
            r2.close()     // Catch: java.io.IOException -> L6f java.lang.Throwable -> L8c
            goto L7d
        L6f:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzhb r3 = new com.google.android.gms.internal.ads.zzhb     // Catch: java.lang.Throwable -> L8c
            com.google.android.gms.internal.ads.zzgn r4 = r10.zzh     // Catch: java.lang.Throwable -> L8c
            int r5 = com.google.android.gms.internal.ads.zzfk.zza     // Catch: java.lang.Throwable -> L8c
            r5 = 2000(0x7d0, float:2.803E-42)
            r6 = 3
            r3.<init>(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L8c
            throw r3     // Catch: java.lang.Throwable -> L8c
        L7d:
            r10.zzj = r0
            r10.zzm()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L8b
            r10.zzk = r1
            r10.zzh()
        L8b:
            return
        L8c:
            r2 = move-exception
            r10.zzj = r0
            r10.zzm()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L9b
            r10.zzk = r1
            r10.zzh()
        L9b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgv.zzd():void");
    }

    @Override // com.google.android.gms.internal.ads.zzgc, com.google.android.gms.internal.ads.zzgi
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        return httpURLConnection == null ? zzfvv.zzd() : new zzgt(httpURLConnection.getHeaderFields());
    }

    private zzgv(String str, int i, int i2, boolean z, zzhe zzheVar, zzfsx zzfsxVar, boolean z2) {
        super(true);
        this.zze = str;
        this.zzc = i;
        this.zzd = i2;
        this.zzb = z;
        this.zzf = zzheVar;
        this.zzg = new zzhe();
    }
}
