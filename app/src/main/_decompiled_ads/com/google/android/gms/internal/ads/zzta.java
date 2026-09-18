package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzta implements zzvo {
    public final zzvo zza;
    final /* synthetic */ zztb zzb;
    private boolean zzc;

    public zzta(zztb zztbVar, zzvo zzvoVar) {
        this.zzb = zztbVar;
        this.zza = zzvoVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    @Override // com.google.android.gms.internal.ads.zzvo
    public final int zza(zzkn zzknVar, zzht zzhtVar, int i) {
        zztb zztbVar = this.zzb;
        if (zztbVar.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzhtVar.zzc(4);
            return -4;
        }
        long jZzb = zztbVar.zzb();
        int iZza = this.zza.zza(zzknVar, zzhtVar, i);
        if (iZza != -5) {
            long j = this.zzb.zzb;
            if (j == Long.MIN_VALUE || ((iZza != -4 || zzhtVar.zze < j) && !(iZza == -3 && jZzb == Long.MIN_VALUE && !zzhtVar.zzd))) {
                return iZza;
            }
            zzhtVar.zzb();
            zzhtVar.zzc(4);
            this.zzc = true;
            return -4;
        }
        zzam zzamVar = zzknVar.zza;
        Objects.requireNonNull(zzamVar);
        int i2 = zzamVar.zzC;
        if (i2 != 0) {
            int i3 = this.zzb.zzb == Long.MIN_VALUE ? zzamVar.zzD : 0;
            zzak zzakVarZzb = zzamVar.zzb();
            zzakVarZzb.zzE(i2);
            zzakVarZzb.zzF(i3);
            zzknVar.zza = zzakVarZzb.zzac();
        } else if (zzamVar.zzD != 0) {
            i2 = 0;
            if (this.zzb.zzb == Long.MIN_VALUE) {
            }
            zzak zzakVarZzb2 = zzamVar.zzb();
            zzakVarZzb2.zzE(i2);
            zzakVarZzb2.zzF(i3);
            zzknVar.zza = zzakVarZzb2.zzac();
        }
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzvo
    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzvo
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzvo
    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
