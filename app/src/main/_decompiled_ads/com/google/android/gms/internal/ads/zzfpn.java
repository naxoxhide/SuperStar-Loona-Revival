package com.google.android.gms.internal.ads;

import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfpn extends zzfpb {
    private zzftm<Integer> zza;
    private zzftm<Integer> zzb;
    private zzfpm zzc;
    private HttpURLConnection zzd;

    zzfpn() {
        this(new zzftm() { // from class: com.google.android.gms.internal.ads.zzfpd
            @Override // com.google.android.gms.internal.ads.zzftm
            public final Object zza() {
                return zzfpn.zzf();
            }
        }, new zzftm() { // from class: com.google.android.gms.internal.ads.zzfpe
            @Override // com.google.android.gms.internal.ads.zzftm
            public final Object zza() {
                return zzfpn.zzg();
            }
        }, null);
    }

    zzfpn(zzftm<Integer> zzftmVar, zzftm<Integer> zzftmVar2, zzfpm zzfpmVar) {
        this.zza = zzftmVar;
        this.zzb = zzftmVar2;
        this.zzc = zzfpmVar;
    }

    static /* synthetic */ Integer zzf() {
        return -1;
    }

    static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzfpc.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfpc.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfpm zzfpmVar = this.zzc;
        Objects.requireNonNull(zzfpmVar);
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfpmVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzfpm zzfpmVar, final int i, final int i2) throws IOException {
        this.zza = new zzftm() { // from class: com.google.android.gms.internal.ads.zzfpf
            @Override // com.google.android.gms.internal.ads.zzftm
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzb = new zzftm() { // from class: com.google.android.gms.internal.ads.zzfpg
            @Override // com.google.android.gms.internal.ads.zzftm
            public final Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = zzfpmVar;
        return zzm();
    }

    public HttpURLConnection zzo(final Network network, final URL url, final int i, final int i2) throws IOException {
        this.zza = new zzftm() { // from class: com.google.android.gms.internal.ads.zzfph
            @Override // com.google.android.gms.internal.ads.zzftm
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzb = new zzftm() { // from class: com.google.android.gms.internal.ads.zzfpi
            @Override // com.google.android.gms.internal.ads.zzftm
            public final Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = new zzfpm() { // from class: com.google.android.gms.internal.ads.zzfpj
            @Override // com.google.android.gms.internal.ads.zzfpm
            public final URLConnection zza() {
                return network.openConnection(url);
            }
        };
        return zzm();
    }

    public URLConnection zzr(final URL url, final int i) throws IOException {
        this.zza = new zzftm() { // from class: com.google.android.gms.internal.ads.zzfpk
            @Override // com.google.android.gms.internal.ads.zzftm
            public final Object zza() {
                return Integer.valueOf(i);
            }
        };
        this.zzc = new zzfpm() { // from class: com.google.android.gms.internal.ads.zzfpl
            @Override // com.google.android.gms.internal.ads.zzfpm
            public final URLConnection zza() {
                return url.openConnection();
            }
        };
        return zzm();
    }
}
