package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzsz implements zzup {
    private final zzabt zza;
    private zzabm zzb;
    private zzabn zzc;

    public zzsz(zzabt zzabtVar) {
        this.zza = zzabtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzb() {
        zzabn zzabnVar = this.zzc;
        if (zzabnVar != null) {
            return zzabnVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzc() {
        zzabm zzabmVar = this.zzb;
        if (zzabmVar != null && (zzabmVar instanceof zzagr)) {
            ((zzagr) zzabmVar).zza();
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzd(zzt zztVar, Uri uri, Map map, long j, long j2, zzabp zzabpVar) throws IOException {
        zzabc zzabcVar = new zzabc(zztVar, j, j2);
        this.zzc = zzabcVar;
        if (this.zzb != null) {
            return;
        }
        zzabm[] zzabmVarArrZza = this.zza.zza(uri, map);
        int i = 0;
        boolean z = true;
        if (zzabmVarArrZza.length == 1) {
            this.zzb = zzabmVarArrZza[0];
        } else {
            for (zzabm zzabmVar : zzabmVarArrZza) {
                try {
                    if (zzabmVar.zze(zzabcVar)) {
                        this.zzb = zzabmVar;
                        if (zzabmVar == null && zzabcVar.zzf() != j) {
                            z = false;
                        }
                        zzdx.zzf(z);
                        zzabcVar.zzj();
                        break;
                    }
                    boolean z2 = this.zzb != null || zzabcVar.zzf() == j;
                    zzdx.zzf(z2);
                    zzabcVar.zzj();
                } catch (EOFException unused) {
                    if (this.zzb != null || zzabcVar.zzf() == j) {
                    }
                } catch (Throwable th) {
                    zzdx.zzf(this.zzb != null || zzabcVar.zzf() == j);
                    zzabcVar.zzj();
                    throw th;
                }
                zzdx.zzf(z2);
                zzabcVar.zzj();
            }
            if (this.zzb == null) {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int length = zzabmVarArrZza.length;
                    if (i >= length) {
                        throw new zzvy("None of the available extractors (" + sb.toString() + ") could read the stream.", uri);
                    }
                    sb.append(zzabmVarArrZza[i].getClass().getSimpleName());
                    if (i < length - 1) {
                        sb.append(", ");
                    }
                    i++;
                }
            }
        }
        this.zzb.zzc(zzabpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final int zza(zzacj zzacjVar) throws IOException {
        zzabm zzabmVar = this.zzb;
        Objects.requireNonNull(zzabmVar);
        zzabn zzabnVar = this.zzc;
        Objects.requireNonNull(zzabnVar);
        return zzabmVar.zzb(zzabnVar, zzacjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzf(long j, long j2) {
        zzabm zzabmVar = this.zzb;
        Objects.requireNonNull(zzabmVar);
        zzabmVar.zzd(j, j2);
    }
}
