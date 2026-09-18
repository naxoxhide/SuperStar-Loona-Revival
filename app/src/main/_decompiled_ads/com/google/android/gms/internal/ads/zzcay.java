package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcay implements zzcal {
    private final String zza;

    public zzcay() {
        this.zza = null;
    }

    public zzcay(String str) {
        this.zza = str;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00bf  */
    @Override // com.google.android.gms.internal.ads.zzcal
    public final boolean zza(String str) {
        boolean z = false;
        try {
            try {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.setThreadStatsTag(263);
                }
                zzcat.zze("Pinging URL: " + str);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    com.google.android.gms.ads.internal.client.zzay.zzb();
                    String str2 = this.zza;
                    httpURLConnection.setConnectTimeout(60000);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setReadTimeout(60000);
                    if (str2 != null) {
                        httpURLConnection.setRequestProperty("User-Agent", str2);
                    }
                    httpURLConnection.setUseCaches(false);
                    zzcas zzcasVar = new zzcas(null);
                    zzcasVar.zzc(httpURLConnection, null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzcasVar.zze(httpURLConnection, responseCode);
                    if (responseCode < 200 || responseCode >= 300) {
                        zzcat.zzj("Received non-success response code " + responseCode + " from pinging URL: " + str);
                    } else {
                        z = true;
                    }
                    httpURLConnection.disconnect();
                    if (ClientLibraryUtils.isPackageSide()) {
                        TrafficStats.clearThreadStatsTag();
                        return z;
                    }
                    return z;
                } catch (Throwable th) {
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                zzcat.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                    return false;
                }
            } catch (IndexOutOfBoundsException e2) {
                zzcat.zzj("Error while parsing ping URL: " + str + ". " + e2.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                    return false;
                }
            } catch (RuntimeException e3) {
                e = e3;
                zzcat.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                    return false;
                }
            }
        } catch (Throwable th2) {
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th2;
        }
    }
}
