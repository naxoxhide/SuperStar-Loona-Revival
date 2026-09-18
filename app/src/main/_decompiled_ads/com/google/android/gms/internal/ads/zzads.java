package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzads implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzadr
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzads.zza;
            return new zzabm[]{new zzads(0)};
        }
    };
    private final byte[] zzb;
    private final zzfb zzc;
    private final zzabu zzd;
    private zzabp zze;
    private zzacs zzf;
    private int zzg;
    private zzby zzh;
    private zzabz zzi;
    private int zzj;
    private int zzk;
    private zzadq zzl;
    private int zzm;
    private long zzn;

    public zzads() {
        this(0);
    }

    private final long zza(zzfb zzfbVar, boolean z) {
        boolean zZzc;
        Objects.requireNonNull(this.zzi);
        int iZzc = zzfbVar.zzc();
        while (iZzc <= zzfbVar.zzd() - 16) {
            zzfbVar.zzG(iZzc);
            if (zzabv.zzc(zzfbVar, this.zzi, this.zzk, this.zzd)) {
                zzfbVar.zzG(iZzc);
                return this.zzd.zza;
            }
            iZzc++;
        }
        if (!z) {
            zzfbVar.zzG(iZzc);
            return -1L;
        }
        while (iZzc <= zzfbVar.zzd() - this.zzj) {
            zzfbVar.zzG(iZzc);
            try {
                zZzc = zzabv.zzc(zzfbVar, this.zzi, this.zzk, this.zzd);
            } catch (IndexOutOfBoundsException unused) {
                zZzc = false;
            }
            if (zzfbVar.zzc() <= zzfbVar.zzd() && zZzc) {
                zzfbVar.zzG(iZzc);
                return this.zzd.zza;
            }
            iZzc++;
        }
        zzfbVar.zzG(zzfbVar.zzd());
        return -1L;
    }

    private final void zzf() {
        long j = this.zzn * 1000000;
        zzabz zzabzVar = this.zzi;
        int i = zzfk.zza;
        this.zzf.zzt(j / ((long) zzabzVar.zze), 1, this.zzm, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zze = zzabpVar;
        this.zzf = zzabpVar.zzw(0, 1);
        zzabpVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws Throwable {
        zzabw.zza(zzabnVar, false);
        zzfb zzfbVar = new zzfb(4);
        ((zzabc) zzabnVar).zzm(zzfbVar.zzI(), 0, 4, false);
        return zzfbVar.zzt() == 1716281667;
    }

    public zzads(int i) {
        this.zzb = new byte[42];
        this.zzc = new zzfb(new byte[32768], 0);
        this.zzd = new zzabu();
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        if (j == 0) {
            this.zzg = 0;
        } else {
            zzadq zzadqVar = this.zzl;
            if (zzadqVar != null) {
                zzadqVar.zzd(j2);
            }
        }
        this.zzn = j2 != 0 ? -1L : 0L;
        this.zzm = 0;
        this.zzc.zzD(0);
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws Throwable {
        boolean zZzn;
        zzacm zzaclVar;
        boolean z;
        int i = this.zzg;
        if (i == 0) {
            zzabnVar.zzj();
            long jZze = zzabnVar.zze();
            zzby zzbyVarZza = zzabw.zza(zzabnVar, true);
            ((zzabc) zzabnVar).zzo((int) (zzabnVar.zze() - jZze), false);
            this.zzh = zzbyVarZza;
            this.zzg = 1;
            return 0;
        }
        if (i == 1) {
            ((zzabc) zzabnVar).zzm(this.zzb, 0, 42, false);
            zzabnVar.zzj();
            this.zzg = 2;
            return 0;
        }
        if (i == 2) {
            zzfb zzfbVar = new zzfb(4);
            ((zzabc) zzabnVar).zzn(zzfbVar.zzI(), 0, 4, false);
            if (zzfbVar.zzt() != 1716281667) {
                throw zzcc.zza("Failed to read FLAC stream marker.", null);
            }
            this.zzg = 3;
            return 0;
        }
        if (i == 3) {
            zzabz zzabzVarZze = this.zzi;
            do {
                zzabnVar.zzj();
                zzfa zzfaVar = new zzfa(new byte[4], 4);
                zzabc zzabcVar = (zzabc) zzabnVar;
                zzabcVar.zzm(zzfaVar.zza, 0, 4, false);
                zZzn = zzfaVar.zzn();
                int iZzd = zzfaVar.zzd(7);
                int iZzd2 = zzfaVar.zzd(24) + 4;
                if (iZzd == 0) {
                    byte[] bArr = new byte[38];
                    zzabcVar.zzn(bArr, 0, 38, false);
                    zzabzVarZze = new zzabz(bArr, 4);
                } else {
                    if (zzabzVarZze == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iZzd == 3) {
                        zzfb zzfbVar2 = new zzfb(iZzd2);
                        zzabcVar.zzn(zzfbVar2.zzI(), 0, iZzd2, false);
                        zzabzVarZze = zzabzVarZze.zzf(zzabw.zzb(zzfbVar2));
                    } else if (iZzd == 4) {
                        zzfb zzfbVar3 = new zzfb(iZzd2);
                        zzabcVar.zzn(zzfbVar3.zzI(), 0, iZzd2, false);
                        zzfbVar3.zzH(4);
                        zzabzVarZze = zzabzVarZze.zzg(Arrays.asList(zzacy.zzc(zzfbVar3, false, false).zzb));
                    } else if (iZzd == 6) {
                        zzfb zzfbVar4 = new zzfb(iZzd2);
                        zzabcVar.zzn(zzfbVar4.zzI(), 0, iZzd2, false);
                        zzfbVar4.zzH(4);
                        zzabzVarZze = zzabzVarZze.zze(zzfvs.zzm(zzaem.zzb(zzfbVar4)));
                    } else {
                        zzabcVar.zzo(iZzd2, false);
                    }
                }
                int i2 = zzfk.zza;
                this.zzi = zzabzVarZze;
            } while (!zZzn);
            Objects.requireNonNull(zzabzVarZze);
            this.zzj = Math.max(zzabzVarZze.zzc, 6);
            this.zzf.zzl(this.zzi.zzc(this.zzb, this.zzh));
            this.zzg = 4;
            return 0;
        }
        if (i == 4) {
            zzabnVar.zzj();
            zzfb zzfbVar5 = new zzfb(2);
            ((zzabc) zzabnVar).zzm(zzfbVar5.zzI(), 0, 2, false);
            int iZzp = zzfbVar5.zzp();
            if ((iZzp >> 2) != 16382) {
                zzabnVar.zzj();
                throw zzcc.zza("First frame does not start with sync code.", null);
            }
            zzabnVar.zzj();
            this.zzk = iZzp;
            zzabp zzabpVar = this.zze;
            int i3 = zzfk.zza;
            long jZzf = zzabnVar.zzf();
            long jZzd = zzabnVar.zzd();
            zzabz zzabzVar = this.zzi;
            Objects.requireNonNull(zzabzVar);
            if (zzabzVar.zzk != null) {
                zzaclVar = new zzabx(zzabzVar, jZzf);
            } else if (jZzd == -1 || zzabzVar.zzj <= 0) {
                zzaclVar = new zzacl(zzabzVar.zza(), 0L);
            } else {
                zzadq zzadqVar = new zzadq(zzabzVar, this.zzk, jZzf, jZzd);
                this.zzl = zzadqVar;
                zzaclVar = zzadqVar.zzb();
            }
            zzabpVar.zzO(zzaclVar);
            this.zzg = 5;
            return 0;
        }
        Objects.requireNonNull(this.zzf);
        zzabz zzabzVar2 = this.zzi;
        Objects.requireNonNull(zzabzVar2);
        zzadq zzadqVar2 = this.zzl;
        if (zzadqVar2 != null && zzadqVar2.zze()) {
            return zzadqVar2.zza(zzabnVar, zzacjVar);
        }
        if (this.zzn == -1) {
            this.zzn = zzabv.zzb(zzabnVar, zzabzVar2);
            return 0;
        }
        zzfb zzfbVar6 = this.zzc;
        int iZzd3 = zzfbVar6.zzd();
        if (iZzd3 < 32768) {
            int iZza = zzabnVar.zza(zzfbVar6.zzI(), iZzd3, 32768 - iZzd3);
            z = iZza == -1;
            if (!z) {
                this.zzc.zzF(iZzd3 + iZza);
            } else if (this.zzc.zza() == 0) {
                zzf();
                return -1;
            }
        } else {
            z = false;
        }
        zzfb zzfbVar7 = this.zzc;
        int iZzc = zzfbVar7.zzc();
        int i4 = this.zzm;
        int i5 = this.zzj;
        if (i4 < i5) {
            zzfbVar7.zzH(Math.min(i5 - i4, zzfbVar7.zza()));
        }
        long jZza = zza(this.zzc, z);
        zzfb zzfbVar8 = this.zzc;
        int iZzc2 = zzfbVar8.zzc() - iZzc;
        zzfbVar8.zzG(iZzc);
        zzacq.zzb(this.zzf, this.zzc, iZzc2);
        this.zzm += iZzc2;
        if (jZza != -1) {
            zzf();
            this.zzm = 0;
            this.zzn = jZza;
        }
        zzfb zzfbVar9 = this.zzc;
        if (zzfbVar9.zza() >= 16) {
            return 0;
        }
        int iZza2 = zzfbVar9.zza();
        System.arraycopy(zzfbVar9.zzI(), zzfbVar9.zzc(), zzfbVar9.zzI(), 0, iZza2);
        this.zzc.zzG(0);
        this.zzc.zzF(iZza2);
        return 0;
    }
}
