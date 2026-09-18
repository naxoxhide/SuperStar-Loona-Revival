package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebj implements zzfgu {
    protected final Context zza;
    protected final String zzb;
    protected final zzbvs zzc;

    public zzebj(Context context, String str, zzbvs zzbvsVar, int i) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbvsVar;
    }

    /* JADX WARN: Code duplicated, block: B:88:0x0218 A[Catch: all -> 0x0227, TryCatch #3 {all -> 0x0227, blocks: (B:12:0x0094, B:86:0x0206, B:88:0x0218, B:90:0x0226, B:13:0x009a, B:15:0x00a2, B:16:0x00a7, B:18:0x00ab, B:21:0x00bd, B:25:0x00c5, B:26:0x00c8, B:27:0x00c9, B:28:0x00e1, B:30:0x00e7, B:32:0x00ff, B:33:0x0109, B:34:0x0113, B:36:0x0118, B:42:0x0138, B:44:0x0146, B:47:0x0159, B:48:0x015f, B:49:0x0160, B:56:0x0174, B:57:0x0177, B:61:0x017e, B:63:0x018a, B:67:0x01af, B:68:0x01bb, B:69:0x01bc, B:70:0x01c8, B:71:0x01c9, B:72:0x01ef), top: B:104:0x0094 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0226 A[Catch: all -> 0x0227, TRY_LEAVE, TryCatch #3 {all -> 0x0227, blocks: (B:12:0x0094, B:86:0x0206, B:88:0x0218, B:90:0x0226, B:13:0x009a, B:15:0x00a2, B:16:0x00a7, B:18:0x00ab, B:21:0x00bd, B:25:0x00c5, B:26:0x00c8, B:27:0x00c9, B:28:0x00e1, B:30:0x00e7, B:32:0x00ff, B:33:0x0109, B:34:0x0113, B:36:0x0118, B:42:0x0138, B:44:0x0146, B:47:0x0159, B:48:0x015f, B:49:0x0160, B:56:0x0174, B:57:0x0177, B:61:0x017e, B:63:0x018a, B:67:0x01af, B:68:0x01bb, B:69:0x01bc, B:70:0x01c8, B:71:0x01c9, B:72:0x01ef), top: B:104:0x0094 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r4v13, types: [com.google.android.gms.internal.ads.zzcas] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.net.HttpURLConnection] */
    @Override // com.google.android.gms.internal.ads.zzfgu
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzebi zza(zzebh zzebhVar) throws zzdwm {
        ?? r1;
        ?? r7;
        zzebi zzebiVar;
        ?? r8;
        InputStreamReader inputStreamReader;
        zzebj zzebjVar = this;
        String str = zzebhVar.zza;
        int i = zzebhVar.zzb;
        Map map = zzebhVar.zzc;
        byte[] bArr = zzebhVar.zzd;
        String str2 = zzebhVar.zze;
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        boolean z = true;
        z = true;
        try {
            zzebi zzebiVar2 = new zzebi();
            zzcat.zzi("SDK version: " + zzebjVar.zzb);
            zzcat.zze("AdRequestServiceImpl: Sending request: " + str);
            URL url = new URL(str);
            HashMap map2 = new HashMap();
            int i2 = 0;
            while (true) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    com.google.android.gms.ads.internal.util.zzt zztVarZzp = com.google.android.gms.ads.internal.zzt.zzp();
                    Context context = zzebjVar.zza;
                    String str3 = zzebjVar.zzb;
                    ?? r20 = httpURLConnection;
                    zzebi zzebiVar3 = zzebiVar2;
                    r1 = z ? 1 : 0;
                    try {
                        zztVarZzp.zzf(context, str3, false, httpURLConnection, false, i);
                        r20 = r20;
                        for (Map.Entry entry : map.entrySet()) {
                            r7 = r20;
                            try {
                                try {
                                    r7.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                    r20 = r7;
                                } catch (zzdwm e) {
                                    e = e;
                                    zzebiVar = zzebiVar3;
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzic)).booleanValue()) {
                                        throw e;
                                    }
                                    zzebiVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                    r8 = r7;
                                    r8.disconnect();
                                    return zzebiVar;
                                }
                            } catch (Throwable th) {
                                th = th;
                                r7.disconnect();
                                throw th;
                            }
                        }
                        r7 = r20;
                        if (!TextUtils.isEmpty(str2)) {
                            r7.setRequestProperty(HttpHeaders.CONTENT_TYPE, str2);
                        }
                        int length = bArr.length;
                        BufferedOutputStream bufferedOutputStream = null;
                        if (length > 0) {
                            r7.setDoOutput(r1);
                            r7.setFixedLengthStreamingMode(length);
                            try {
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(r7.getOutputStream());
                                try {
                                    bufferedOutputStream2.write(bArr);
                                    IOUtils.closeQuietly(bufferedOutputStream2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    IOUtils.closeQuietly(bufferedOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        ?? zzcasVar = new zzcas(null);
                        zzcasVar.zzc(r7, bArr);
                        int responseCode = r7.getResponseCode();
                        for (Map.Entry<String, List<String>> entry2 : r7.getHeaderFields().entrySet()) {
                            String key = entry2.getKey();
                            List<String> value = entry2.getValue();
                            if (map2.containsKey(key)) {
                                ((List) map2.get(key)).addAll(value);
                            } else {
                                map2.put(key, new ArrayList(value));
                            }
                        }
                        zzcasVar.zze(r7, responseCode);
                        zzebiVar = zzebiVar3;
                        try {
                            zzebiVar.zza = responseCode;
                            zzebiVar.zzb = map2;
                            zzebiVar.zzc = "";
                            if (responseCode >= 200 && responseCode < 300) {
                                try {
                                    inputStreamReader = new InputStreamReader(r7.getInputStream());
                                    try {
                                        com.google.android.gms.ads.internal.zzt.zzp();
                                        String strZzM = com.google.android.gms.ads.internal.util.zzt.zzM(inputStreamReader);
                                        IOUtils.closeQuietly(inputStreamReader);
                                        zzcasVar.zzg(strZzM);
                                        zzebiVar.zzc = strZzM;
                                        if (TextUtils.isEmpty(strZzM)) {
                                            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfq)).booleanValue()) {
                                                throw new zzdwm(3);
                                            }
                                        }
                                        zzebiVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                        r8 = r7;
                                        break;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        IOUtils.closeQuietly(inputStreamReader);
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    inputStreamReader = null;
                                }
                            } else {
                                if (responseCode < 300 || responseCode >= 400) {
                                    zzcat.zzj("Received error HTTP response code: " + responseCode);
                                    throw new zzdwm(r1 == true ? 1 : 0, "Received error HTTP response code: " + responseCode);
                                }
                                String headerField = r7.getHeaderField(HttpHeaders.LOCATION);
                                if (TextUtils.isEmpty(headerField)) {
                                    zzcat.zzj("No location header to follow redirect.");
                                    throw new zzdwm(r1 == true ? 1 : 0, "No location header to follow redirect");
                                }
                                URL url2 = new URL(headerField);
                                int i3 = i2 + 1;
                                if (i3 > ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeR)).intValue()) {
                                    zzcat.zzj("Too many redirects.");
                                    throw new zzdwm(r1 == true ? 1 : 0, "Too many redirects");
                                }
                                try {
                                    r7.disconnect();
                                    z = r1 == true ? 1 : 0;
                                    i2 = i3;
                                    zzebiVar2 = zzebiVar;
                                    url = url2;
                                    zzebjVar = this;
                                } catch (IOException e2) {
                                    e = e2;
                                    String strConcat = "Error while connecting to ad server: ".concat(String.valueOf(e.getMessage()));
                                    zzcat.zzj(strConcat);
                                    throw new zzdwm(r1, strConcat, e);
                                }
                            }
                        } catch (zzdwm e3) {
                            e = e3;
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzic)).booleanValue()) {
                                throw e;
                            }
                            zzebiVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                            r8 = r7;
                        }
                    } catch (zzdwm e4) {
                        e = e4;
                        r7 = r20;
                    } catch (Throwable th6) {
                        th = th6;
                        r7 = r20;
                    }
                } catch (zzdwm e5) {
                    e = e5;
                    r7 = httpURLConnection;
                    zzebiVar = zzebiVar2;
                    boolean z2 = z ? 1 : 0;
                } catch (Throwable th7) {
                    th = th7;
                    r7 = httpURLConnection;
                    boolean z3 = z ? 1 : 0;
                }
            }
            r8.disconnect();
            return zzebiVar;
        } catch (IOException e6) {
            e = e6;
            r1 = z;
        }
    }
}
