package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcfr extends zzgc implements zzhf {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzhe zzf;
    private zzgn zzg;
    private HttpURLConnection zzh;
    private final Queue zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    zzcfr(String str, zzhk zzhkVar, int i, int i2, long j, long j2) {
        super(true);
        zzdx.zzc(str);
        this.zze = str;
        this.zzf = new zzhe();
        this.zzc = i;
        this.zzd = i2;
        this.zzi = new ArrayDeque();
        this.zzr = j;
        this.zzs = j2;
        if (zzhkVar != null) {
            zzf(zzhkVar);
        }
    }

    private final void zzl() {
        while (!this.zzi.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzi.remove()).disconnect();
            } catch (Exception e) {
                zzcat.zzh("Unexpected error while disconnecting", e);
            }
        }
        this.zzh = null;
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i, int i2) throws zzhb {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzm;
            long j2 = this.zzn;
            if (j - j2 == 0) {
                return -1;
            }
            long j3 = this.zzo + j2;
            long j4 = i2;
            long j5 = this.zzs;
            long j6 = j3 + j4 + j5;
            long j7 = this.zzq;
            long j8 = j7 + 1;
            if (j6 > j8) {
                long j9 = this.zzp;
                if (j7 < j9) {
                    long jMin = Math.min(j9, Math.max(((this.zzr + j8) - j5) - 1, (-1) + j8 + j4));
                    zzk(j8, jMin, 2);
                    this.zzq = jMin;
                    j7 = jMin;
                }
            }
            int i3 = this.zzj.read(bArr, i, (int) Math.min(j4, ((j7 + 1) - this.zzo) - this.zzn));
            if (i3 == -1) {
                throw new EOFException();
            }
            this.zzn += (long) i3;
            zzg(i3);
            return i3;
        } catch (IOException e) {
            throw new zzhb(e, this.zzg, 2000, 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final long zzb(zzgn zzgnVar) throws zzhb {
        this.zzg = zzgnVar;
        this.zzn = 0L;
        long j = zzgnVar.zzf;
        long j2 = zzgnVar.zzg;
        long jMin = j2 == -1 ? this.zzr : Math.min(this.zzr, j2);
        this.zzo = j;
        HttpURLConnection httpURLConnectionZzk = zzk(j, (jMin + j) - 1, 1);
        this.zzh = httpURLConnectionZzk;
        String headerField = httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long j3 = Long.parseLong(matcher.group(2));
                    long j4 = Long.parseLong(matcher.group(3));
                    long j5 = zzgnVar.zzg;
                    if (j5 != -1) {
                        this.zzm = j5;
                        this.zzp = Math.max(j3, (this.zzo + j5) - 1);
                    } else {
                        this.zzm = j4 - this.zzo;
                        this.zzp = j4 - 1;
                    }
                    this.zzq = j3;
                    this.zzk = true;
                    zzj(zzgnVar);
                    return this.zzm;
                } catch (NumberFormatException unused) {
                    zzcat.zzg("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzcfp(headerField, zzgnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzd() throws zzhb {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new zzhb(e, this.zzg, 2000, 3);
                }
            }
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
        } catch (Throwable th) {
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgc, com.google.android.gms.internal.ads.zzgi
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final HttpURLConnection zzk(long j, long j2, int i) throws zzhb {
        String string = this.zzg.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(this.zzc);
            httpURLConnection.setReadTimeout(this.zzd);
            for (Map.Entry entry : this.zzf.zza().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-" + j2);
            httpURLConnection.setRequestProperty("User-Agent", this.zze);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzi.add(httpURLConnection);
            String string2 = this.zzg.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzl = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzcfq(this.zzl, headerFields, this.zzg, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzj != null) {
                        inputStream = new SequenceInputStream(this.zzj, inputStream);
                    }
                    this.zzj = inputStream;
                    return httpURLConnection;
                } catch (IOException e) {
                    zzl();
                    throw new zzhb(e, this.zzg, 2000, i);
                }
            } catch (IOException e2) {
                zzl();
                throw new zzhb("Unable to connect to ".concat(String.valueOf(string2)), e2, this.zzg, 2000, i);
            }
        } catch (IOException e3) {
            throw new zzhb("Unable to connect to ".concat(String.valueOf(string)), e3, this.zzg, 2000, i);
        }
    }
}
