package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Pair;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaky implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzaku
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzaky.zza;
            return new zzabm[]{new zzaky()};
        }
    };
    private zzabp zzb;
    private zzacs zzc;
    private zzakw zzf;
    private int zzd = 0;
    private long zze = -1;
    private int zzg = -1;
    private long zzh = -1;

    /* JADX WARN: Code duplicated, block: B:47:0x00f3  */
    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        int i;
        zzdx.zzb(this.zzc);
        int i2 = zzfk.zza;
        int i3 = this.zzd;
        int iZzk = 4;
        if (i3 == 0) {
            zzdx.zzf(zzabnVar.zzf() == 0);
            int i4 = this.zzg;
            if (i4 != -1) {
                ((zzabc) zzabnVar).zzo(i4, false);
                this.zzd = 4;
            } else {
                if (!zzalb.zzc(zzabnVar)) {
                    throw zzcc.zza("Unsupported or unrecognized wav file type.", null);
                }
                ((zzabc) zzabnVar).zzo((int) (zzabnVar.zze() - zzabnVar.zzf()), false);
                this.zzd = 1;
            }
            return 0;
        }
        long jZzq = -1;
        if (i3 == 1) {
            zzfb zzfbVar = new zzfb(8);
            zzala zzalaVarZza = zzala.zza(zzabnVar, zzfbVar);
            if (zzalaVarZza.zza != 1685272116) {
                zzabnVar.zzj();
            } else {
                zzabc zzabcVar = (zzabc) zzabnVar;
                zzabcVar.zzl(8, false);
                zzfbVar.zzG(0);
                zzabcVar.zzm(zzfbVar.zzI(), 0, 8, false);
                jZzq = zzfbVar.zzq();
                zzabcVar.zzo(((int) zzalaVarZza.zzb) + 8, false);
            }
            this.zze = jZzq;
            this.zzd = 2;
            return 0;
        }
        if (i3 == 2) {
            zzakz zzakzVarZzb = zzalb.zzb(zzabnVar);
            int i5 = zzakzVarZzb.zza;
            if (i5 == 17) {
                this.zzf = new zzakv(this.zzb, this.zzc, zzakzVarZzb);
            } else if (i5 == 6) {
                this.zzf = new zzakx(this.zzb, this.zzc, zzakzVarZzb, "audio/g711-alaw", -1);
            } else if (i5 == 7) {
                this.zzf = new zzakx(this.zzb, this.zzc, zzakzVarZzb, "audio/g711-mlaw", -1);
            } else {
                int i6 = zzakzVarZzb.zze;
                if (i5 == 1) {
                    iZzk = zzfk.zzk(i6);
                    i = iZzk;
                } else {
                    if (i5 != 3) {
                        if (i5 == 65534) {
                            iZzk = zzfk.zzk(i6);
                            i = iZzk;
                        }
                    } else if (i6 == 32) {
                        i = iZzk;
                    }
                    i = 0;
                }
                if (i == 0) {
                    throw zzcc.zzc("Unsupported WAV format type: " + i5);
                }
                this.zzf = new zzakx(this.zzb, this.zzc, zzakzVarZzb, "audio/raw", i);
            }
            this.zzd = 3;
            return 0;
        }
        if (i3 != 3) {
            zzdx.zzf(this.zzh != -1);
            long jZzf = this.zzh - zzabnVar.zzf();
            zzakw zzakwVar = this.zzf;
            Objects.requireNonNull(zzakwVar);
            return zzakwVar.zzc(zzabnVar, jZzf) ? -1 : 0;
        }
        Pair pairZza = zzalb.zza(zzabnVar);
        this.zzg = ((Long) pairZza.first).intValue();
        long jLongValue = ((Long) pairZza.second).longValue();
        long j = this.zze;
        if (j != -1 && jLongValue == 4294967295L) {
            jLongValue = j;
        }
        long j2 = ((long) this.zzg) + jLongValue;
        this.zzh = j2;
        long jZzd = zzabnVar.zzd();
        if (jZzd != -1 && j2 > jZzd) {
            zzer.zzf("WavExtractor", "Data exceeds input length: " + j2 + ", " + jZzd);
            this.zzh = jZzd;
            j2 = jZzd;
        }
        zzakw zzakwVar2 = this.zzf;
        Objects.requireNonNull(zzakwVar2);
        zzakwVar2.zza(this.zzg, j2);
        this.zzd = 4;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzb = zzabpVar;
        this.zzc = zzabpVar.zzw(0, 1);
        zzabpVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        this.zzd = j == 0 ? 0 : 4;
        zzakw zzakwVar = this.zzf;
        if (zzakwVar != null) {
            zzakwVar.zzb(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        return zzalb.zzc(zzabnVar);
    }
}
