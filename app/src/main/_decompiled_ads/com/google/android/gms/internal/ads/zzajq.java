package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajq implements zzaje {
    private zzacs zzb;
    private boolean zzc;
    private int zze;
    private int zzf;
    private final zzfb zza = new zzfb(10);
    private long zzd = -9223372036854775807L;

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) {
        zzdx.zzb(this.zzb);
        if (this.zzc) {
            int iZza = zzfbVar.zza();
            int i = this.zzf;
            if (i < 10) {
                int iMin = Math.min(iZza, 10 - i);
                System.arraycopy(zzfbVar.zzI(), zzfbVar.zzc(), this.zza.zzI(), this.zzf, iMin);
                if (this.zzf + iMin == 10) {
                    this.zza.zzG(0);
                    if (this.zza.zzl() != 73 || this.zza.zzl() != 68 || this.zza.zzl() != 51) {
                        zzer.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    } else {
                        this.zza.zzH(3);
                        this.zze = this.zza.zzk() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iZza, this.zze - this.zzf);
            this.zzb.zzr(zzfbVar, iMin2);
            this.zzf += iMin2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        zzacs zzacsVarZzw = zzabpVar.zzw(zzakqVar.zza(), 5);
        this.zzb = zzacsVarZzw;
        zzak zzakVar = new zzak();
        zzakVar.zzJ(zzakqVar.zzb());
        zzakVar.zzU("application/id3");
        zzacsVarZzw.zzl(zzakVar.zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzc(boolean z) {
        int i;
        zzdx.zzb(this.zzb);
        if (this.zzc && (i = this.zze) != 0 && this.zzf == i) {
            long j = this.zzd;
            if (j != -9223372036854775807L) {
                this.zzb.zzt(j, 1, i, 0, null);
            }
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzd(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.zzc = true;
        if (j != -9223372036854775807L) {
            this.zzd = j;
        }
        this.zze = 0;
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zze() {
        this.zzc = false;
        this.zzd = -9223372036854775807L;
    }
}
