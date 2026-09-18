package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.facebook.ads.AdError;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcey extends zzgc implements zzhf {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzc = new AtomicReference();
    private final SSLSocketFactory zzd;
    private final int zze;
    private final int zzf;
    private final String zzg;
    private final zzhe zzh;
    private zzgn zzi;
    private HttpURLConnection zzj;
    private InputStream zzk;
    private boolean zzl;
    private int zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private int zzr;
    private final Set zzs;

    zzcey(String str, zzhk zzhkVar, int i, int i2, int i3) {
        super(true);
        this.zzd = new zzcex(this);
        this.zzs = new HashSet();
        zzdx.zzc(str);
        this.zzg = str;
        this.zzh = new zzhe();
        this.zze = i;
        this.zzf = i2;
        this.zzr = i3;
        if (zzhkVar != null) {
            zzf(zzhkVar);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzcat.zzh("Unexpected error while disconnecting", e);
            }
            this.zzj = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0273 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x00b9 A[Catch: IOException -> 0x0292, TryCatch #3 {IOException -> 0x0292, blocks: (B:3:0x000e, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:19:0x007f, B:21:0x0099, B:22:0x00ab, B:23:0x00b0, B:25:0x00b9, B:26:0x00c0, B:39:0x00e8, B:93:0x0237, B:95:0x0242, B:97:0x0253, B:100:0x025c, B:101:0x026b, B:103:0x0273, B:104:0x027a, B:105:0x027b, B:106:0x0291), top: B:116:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0104  */
    /* JADX WARN: Code duplicated, block: B:87:0x0209  */
    /* JADX WARN: Code duplicated, block: B:95:0x0242 A[Catch: IOException -> 0x0292, TryCatch #3 {IOException -> 0x0292, blocks: (B:3:0x000e, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:19:0x007f, B:21:0x0099, B:22:0x00ab, B:23:0x00b0, B:25:0x00b9, B:26:0x00c0, B:39:0x00e8, B:93:0x0237, B:95:0x0242, B:97:0x0253, B:100:0x025c, B:101:0x026b, B:103:0x0273, B:104:0x027a, B:105:0x027b, B:106:0x0291), top: B:116:0x000e }] */
    @Override // com.google.android.gms.internal.ads.zzgi
    public final long zzb(zzgn zzgnVar) throws zzhb {
        int responseCode;
        String headerField;
        String protocol;
        int responseCode2;
        zzhd zzhdVar;
        long j;
        long jMax;
        this.zzi = zzgnVar;
        long j2 = 0;
        this.zzq = 0L;
        this.zzp = 0L;
        try {
            URL url = new URL(zzgnVar.zza.toString());
            byte[] bArr = zzgnVar.zzc;
            long j3 = zzgnVar.zzf;
            long j4 = zzgnVar.zzg;
            boolean zZza = zzgnVar.zza(1);
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i > 20) {
                    throw new NoRouteToHostException("Too many redirects: " + i2);
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.zzd);
                }
                httpURLConnection.setConnectTimeout(this.zze);
                httpURLConnection.setReadTimeout(this.zzf);
                for (Map.Entry entry : this.zzh.zza().entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (j3 == j2) {
                    if (j4 != -1) {
                    }
                    httpURLConnection.setRequestProperty("User-Agent", this.zzg);
                    if (!zZza) {
                        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
                    }
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                        this.zzj = httpURLConnection;
                        try {
                            responseCode2 = httpURLConnection.getResponseCode();
                            this.zzm = responseCode2;
                            if (responseCode2 >= 200 || responseCode2 > 299) {
                                Map<String, List<String>> headerFields = this.zzj.getHeaderFields();
                                zzn();
                                zzhdVar = new zzhd(this.zzm, null, null, headerFields, zzgnVar, zzfk.zzf);
                                if (this.zzm == 416) {
                                    throw zzhdVar;
                                }
                                zzhdVar.initCause(new zzgj(AdError.REMOTE_ADS_SERVICE_ERROR));
                                throw zzhdVar;
                            }
                            if (responseCode2 == 200) {
                                j = zzgnVar.zzf;
                                if (j == 0) {
                                    j = 0;
                                }
                            } else {
                                j = 0;
                            }
                            this.zzn = j;
                            if (zzgnVar.zza(1)) {
                                this.zzo = zzgnVar.zzg;
                            } else {
                                long j5 = zzgnVar.zzg;
                                if (j5 != -1) {
                                    this.zzo = j5;
                                } else {
                                    HttpURLConnection httpURLConnection2 = this.zzj;
                                    String headerField2 = httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_LENGTH);
                                    if (TextUtils.isEmpty(headerField2)) {
                                        jMax = -1;
                                    } else {
                                        try {
                                            jMax = Long.parseLong(headerField2);
                                        } catch (NumberFormatException unused) {
                                            zzcat.zzg("Unexpected Content-Length [" + headerField2 + "]");
                                            jMax = -1;
                                        }
                                    }
                                    String headerField3 = httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_RANGE);
                                    if (!TextUtils.isEmpty(headerField3)) {
                                        Matcher matcher = zzb.matcher(headerField3);
                                        if (matcher.find()) {
                                            try {
                                                long j6 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                                if (jMax < 0) {
                                                    jMax = j6;
                                                } else if (jMax != j6) {
                                                    zzcat.zzj("Inconsistent headers [" + headerField2 + "] [" + headerField3 + "]");
                                                    jMax = Math.max(jMax, j6);
                                                }
                                            } catch (NumberFormatException unused2) {
                                                zzcat.zzg("Unexpected Content-Range [" + headerField3 + "]");
                                            }
                                        }
                                    }
                                    this.zzo = jMax != -1 ? jMax - this.zzn : -1L;
                                }
                            }
                            try {
                                this.zzk = this.zzj.getInputStream();
                                this.zzl = true;
                                zzj(zzgnVar);
                                return this.zzo;
                            } catch (IOException e) {
                                zzn();
                                throw new zzhb(e, zzgnVar, 2000, 1);
                            }
                        } catch (IOException e2) {
                            zzn();
                            throw new zzhb("Unable to connect to ".concat(String.valueOf(zzgnVar.zza.toString())), e2, zzgnVar, 2000, 1);
                        }
                    }
                    headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    httpURLConnection.disconnect();
                    if (headerField != null) {
                        throw new ProtocolException("Null location redirect");
                    }
                    URL url2 = new URL(url, headerField);
                    protocol = url2.getProtocol();
                    if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                        throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                    }
                    url = url2;
                    i = i2;
                    j2 = 0;
                } else {
                    j2 = j3;
                }
                String string = "bytes=" + j2 + "-";
                if (j4 != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append((j2 + j4) - 1);
                    string = sb.toString();
                }
                httpURLConnection.setRequestProperty("Range", string);
                httpURLConnection.setRequestProperty("User-Agent", this.zzg);
                if (!zZza) {
                    httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
                }
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 300) {
                    this.zzj = httpURLConnection;
                    responseCode2 = httpURLConnection.getResponseCode();
                    this.zzm = responseCode2;
                    if (responseCode2 >= 200) {
                    }
                    Map<String, List<String>> headerFields2 = this.zzj.getHeaderFields();
                    zzn();
                    zzhdVar = new zzhd(this.zzm, null, null, headerFields2, zzgnVar, zzfk.zzf);
                    if (this.zzm == 416) {
                        throw zzhdVar;
                    }
                    zzhdVar.initCause(new zzgj(AdError.REMOTE_ADS_SERVICE_ERROR));
                    throw zzhdVar;
                }
                headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                httpURLConnection.disconnect();
                if (headerField != null) {
                    throw new ProtocolException("Null location redirect");
                }
                URL url3 = new URL(url, headerField);
                protocol = url3.getProtocol();
                if (!"https".equals(protocol)) {
                    throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                }
                url = url3;
                i = i2;
                j2 = 0;
            }
        } catch (IOException e3) {
            throw new zzhb("Unable to connect to ".concat(String.valueOf(zzgnVar.zza.toString())), e3, zzgnVar, 2000, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0050 A[Catch: Exception -> 0x0069, all -> 0x008f, TRY_LEAVE, TryCatch #0 {Exception -> 0x0069, blocks: (B:15:0x0021, B:17:0x0029, B:23:0x0038, B:25:0x0048, B:27:0x0050), top: B:45:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0099  */
    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzd() throws zzhb {
        String name;
        try {
            if (this.zzk != null) {
                HttpURLConnection httpURLConnection = this.zzj;
                long j = this.zzo;
                if (j != -1) {
                    j -= this.zzq;
                }
                if (zzfk.zza == 19 || zzfk.zza == 20) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (j == -1) {
                            if (inputStream.read() != -1) {
                                name = inputStream.getClass().getName();
                                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                    declaredMethod.setAccessible(true);
                                    declaredMethod.invoke(inputStream, new Object[0]);
                                }
                            }
                            this.zzk = null;
                            zzn();
                            if (this.zzl) {
                                this.zzl = false;
                                zzh();
                            }
                            this.zzs.clear();
                            throw th;
                        }
                        if (j > PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                            name = inputStream.getClass().getName();
                            if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) {
                                Method declaredMethod2 = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod2.setAccessible(true);
                                declaredMethod2.invoke(inputStream, new Object[0]);
                            } else {
                                Method declaredMethod3 = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod3.setAccessible(true);
                                declaredMethod3.invoke(inputStream, new Object[0]);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                try {
                    this.zzk.close();
                } catch (IOException e) {
                    throw new zzhb(e, this.zzi, 2000, 3);
                }
            }
            this.zzk = null;
            zzn();
            if (this.zzl) {
                this.zzl = false;
                zzh();
            }
            this.zzs.clear();
        } catch (Throwable th) {
            this.zzk = null;
            zzn();
            if (this.zzl) {
                this.zzl = false;
                zzh();
            }
            this.zzs.clear();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgc, com.google.android.gms.internal.ads.zzgi
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final void zzm(int i) {
        this.zzr = i;
        for (Socket socket : this.zzs) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzr);
                } catch (SocketException e) {
                    zzcat.zzk("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0077 A[Catch: IOException -> 0x008e, TryCatch #0 {IOException -> 0x008e, blocks: (B:2:0x0000, B:21:0x0056, B:23:0x005e, B:26:0x0069, B:27:0x006f, B:29:0x0077, B:32:0x007e, B:33:0x0083, B:34:0x0084, B:5:0x000b, B:7:0x0016, B:8:0x001a, B:10:0x0022, B:13:0x0038, B:14:0x0042, B:15:0x0047, B:16:0x0048, B:17:0x004d, B:18:0x004e), top: B:39:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007d  */
    /* JADX WARN: Code duplicated, block: B:32:0x007e A[Catch: IOException -> 0x008e, TryCatch #0 {IOException -> 0x008e, blocks: (B:2:0x0000, B:21:0x0056, B:23:0x005e, B:26:0x0069, B:27:0x006f, B:29:0x0077, B:32:0x007e, B:33:0x0083, B:34:0x0084, B:5:0x000b, B:7:0x0016, B:8:0x001a, B:10:0x0022, B:13:0x0038, B:14:0x0042, B:15:0x0047, B:16:0x0048, B:17:0x004d, B:18:0x004e), top: B:39:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0084 A[Catch: IOException -> 0x008e, TRY_LEAVE, TryCatch #0 {IOException -> 0x008e, blocks: (B:2:0x0000, B:21:0x0056, B:23:0x005e, B:26:0x0069, B:27:0x006f, B:29:0x0077, B:32:0x007e, B:33:0x0083, B:34:0x0084, B:5:0x000b, B:7:0x0016, B:8:0x001a, B:10:0x0022, B:13:0x0038, B:14:0x0042, B:15:0x0047, B:16:0x0048, B:17:0x004d, B:18:0x004e), top: B:39:0x0000 }] */
    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i, int i2) throws zzhb {
        int i3;
        try {
            if (this.zzp != this.zzn) {
                byte[] bArr2 = (byte[]) zzc.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j = this.zzp;
                    long j2 = this.zzn;
                    if (j == j2) {
                        zzc.set(bArr2);
                        break;
                    }
                    int i4 = this.zzk.read(bArr2, 0, (int) Math.min(j2 - j, bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.zzp += (long) i4;
                    zzg(i4);
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzo;
            if (j3 != -1) {
                long j4 = j3 - this.zzq;
                if (j4 != 0) {
                    i2 = (int) Math.min(i2, j4);
                    i3 = this.zzk.read(bArr, i, i2);
                    if (i3 == -1) {
                        this.zzq += (long) i3;
                        zzg(i3);
                        return i3;
                    }
                    if (this.zzo == -1) {
                        throw new EOFException();
                    }
                }
            } else {
                i3 = this.zzk.read(bArr, i, i2);
                if (i3 == -1) {
                    this.zzq += (long) i3;
                    zzg(i3);
                    return i3;
                }
                if (this.zzo == -1) {
                    throw new EOFException();
                }
            }
            return -1;
        } catch (IOException e) {
            throw new zzhb(e, this.zzi, 2000, 2);
        }
    }
}
