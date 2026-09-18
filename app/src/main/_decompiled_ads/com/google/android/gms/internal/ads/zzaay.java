package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzaay {
    protected final zzaas zza;
    protected final zzaax zzb;
    protected zzaau zzc;
    private final int zzd;

    protected zzaay(zzaav zzaavVar, zzaax zzaaxVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzaaxVar;
        this.zzd = i;
        this.zza = new zzaas(zzaavVar, j, 0L, j3, j4, j5, j6);
    }

    protected static final int zzf(zzabn zzabnVar, long j, zzacj zzacjVar) {
        if (j == zzabnVar.zzf()) {
            return 0;
        }
        zzacjVar.zza = j;
        return 1;
    }

    protected static final boolean zzg(zzabn zzabnVar, long j) throws IOException {
        long jZzf = j - zzabnVar.zzf();
        if (jZzf < 0 || jZzf > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        ((zzabc) zzabnVar).zzo((int) jZzf, false);
        return true;
    }

    public final int zza(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        while (true) {
            zzaau zzaauVar = this.zzc;
            zzdx.zzb(zzaauVar);
            long j = zzaauVar.zzf;
            long j2 = zzaauVar.zzg - j;
            int i = this.zzd;
            long j3 = zzaauVar.zzh;
            if (j2 <= i) {
                zzc(false, j);
                return zzf(zzabnVar, j, zzacjVar);
            }
            if (!zzg(zzabnVar, j3)) {
                return zzf(zzabnVar, j3, zzacjVar);
            }
            zzabnVar.zzj();
            zzaaw zzaawVarZza = this.zzb.zza(zzabnVar, zzaauVar.zzb);
            int i2 = zzaawVarZza.zzb;
            if (i2 == -3) {
                zzc(false, j3);
                return zzf(zzabnVar, j3, zzacjVar);
            }
            if (i2 == -2) {
                zzaau.zzh(zzaauVar, zzaawVarZza.zzc, zzaawVarZza.zzd);
            } else {
                if (i2 != -1) {
                    zzg(zzabnVar, zzaawVarZza.zzd);
                    zzc(true, zzaawVarZza.zzd);
                    return zzf(zzabnVar, zzaawVarZza.zzd, zzacjVar);
                }
                zzaau.zzg(zzaauVar, zzaawVarZza.zzc, zzaawVarZza.zzd);
            }
        }
    }

    public final zzacm zzb() {
        return this.zza;
    }

    protected final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        zzaau zzaauVar = this.zzc;
        if (zzaauVar == null || zzaauVar.zza != j) {
            zzaas zzaasVar = this.zza;
            this.zzc = new zzaau(j, zzaasVar.zzf(j), 0L, zzaasVar.zzc, zzaasVar.zzd, zzaasVar.zze, zzaasVar.zzf);
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
