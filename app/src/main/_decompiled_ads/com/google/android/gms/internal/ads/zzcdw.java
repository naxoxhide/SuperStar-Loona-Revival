package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcdw implements zzgi {
    private final Context zza;
    private final zzgi zzb;
    private final String zzc;
    private final int zzd;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzaxh zzi;
    private zzgn zzm;
    private boolean zzj = false;
    private boolean zzk = false;
    private final AtomicLong zzl = new AtomicLong(-1);
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbO)).booleanValue();

    public zzcdw(Context context, zzgi zzgiVar, String str, int i, zzhk zzhkVar, zzcdv zzcdvVar) {
        this.zza = context;
        this.zzb = zzgiVar;
        this.zzc = str;
        this.zzd = i;
    }

    private final boolean zzg() {
        if (!this.zze) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzei)).booleanValue() || this.zzj) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzej)).booleanValue() && !this.zzk;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        return inputStream != null ? inputStream.read(bArr, i, i2) : this.zzb.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final long zzb(zzgn zzgnVar) throws IOException {
        Long l;
        if (this.zzg) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.zzg = true;
        this.zzh = zzgnVar.zza;
        this.zzm = zzgnVar;
        this.zzi = zzaxh.zza(zzgnVar.zza);
        zzaxe zzaxeVarZzb = null;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzef)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzgnVar.zzf;
                this.zzi.zzi = zzftl.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzaxeVarZzb = com.google.android.gms.ads.internal.zzt.zzc().zzb(this.zzi);
            }
            if (zzaxeVarZzb != null && zzaxeVarZzb.zze()) {
                this.zzj = zzaxeVarZzb.zzg();
                this.zzk = zzaxeVarZzb.zzf();
                if (!zzg()) {
                    this.zzf = zzaxeVarZzb.zzc();
                    return -1L;
                }
            }
        } else if (this.zzi != null) {
            this.zzi.zzh = zzgnVar.zzf;
            this.zzi.zzi = zzftl.zzc(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeh);
            } else {
                l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeg);
            }
            long jLongValue = l.longValue();
            com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
            com.google.android.gms.ads.internal.zzt.zzd();
            Future futureZza = zzaxs.zza(this.zza, this.zzi);
            try {
                try {
                    zzaxt zzaxtVar = (zzaxt) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                    zzaxtVar.zzd();
                    this.zzj = zzaxtVar.zzf();
                    this.zzk = zzaxtVar.zze();
                    zzaxtVar.zza();
                    if (zzg()) {
                        com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                        throw null;
                    }
                    this.zzf = zzaxtVar.zzc();
                    com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                    throw null;
                } catch (InterruptedException unused) {
                    futureZza.cancel(false);
                    Thread.currentThread().interrupt();
                    com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                    throw null;
                } catch (ExecutionException | TimeoutException unused2) {
                    futureZza.cancel(false);
                    com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                    throw null;
                }
            } catch (Throwable unused3) {
                com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                throw null;
            }
        }
        if (this.zzi != null) {
            Uri uri = Uri.parse(this.zzi.zza);
            byte[] bArr = zzgnVar.zzc;
            long j = zzgnVar.zze;
            long j2 = zzgnVar.zzf;
            long j3 = zzgnVar.zzg;
            String str = zzgnVar.zzh;
            this.zzm = new zzgn(uri, null, j, j2, j3, null, zzgnVar.zzi);
        }
        return this.zzb.zzb(this.zzm);
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        InputStream inputStream = this.zzf;
        if (inputStream == null) {
            this.zzb.zzd();
        } else {
            IOUtils.closeQuietly(inputStream);
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.ads.zzgi
    public final void zzf(zzhk zzhkVar) {
    }
}
