package com.google.android.gms.internal.ads;

import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajp implements zzaje {
    private final zzakf zza;
    private String zzb;
    private zzacs zzc;
    private zzajo zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzajt zzg = new zzajt(32, 128);
    private final zzajt zzh = new zzajt(33, 128);
    private final zzajt zzi = new zzajt(34, 128);
    private final zzajt zzj = new zzajt(39, 128);
    private final zzajt zzk = new zzajt(40, 128);
    private long zzm = -9223372036854775807L;
    private final zzfb zzn = new zzfb();

    public zzajp(zzakf zzakfVar) {
        this.zza = zzakfVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        this.zzd.zzc(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zza(bArr, i, i2);
            this.zzh.zza(bArr, i, i2);
            this.zzi.zza(bArr, i, i2);
        }
        this.zzj.zza(bArr, i, i2);
        this.zzk.zza(bArr, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0110  */
    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) {
        zzdx.zzb(this.zzc);
        int i = zzfk.zza;
        while (zzfbVar.zza() > 0) {
            int iZzc = zzfbVar.zzc();
            int iZzd = zzfbVar.zzd();
            byte[] bArrZzI = zzfbVar.zzI();
            this.zzl += (long) zzfbVar.zza();
            this.zzc.zzr(zzfbVar, zzfbVar.zza());
            while (iZzc < iZzd) {
                int iZza = zzfy.zza(bArrZzI, iZzc, iZzd, this.zzf);
                if (iZza == iZzd) {
                    zzf(bArrZzI, iZzc, iZzd);
                    return;
                }
                int i2 = iZza + 3;
                int i3 = bArrZzI[i2] & 126;
                int i4 = iZza - iZzc;
                if (i4 > 0) {
                    zzf(bArrZzI, iZzc, iZza);
                }
                int i5 = iZzd - iZza;
                long j = this.zzl - ((long) i5);
                int i6 = i4 < 0 ? -i4 : 0;
                long j2 = this.zzm;
                this.zzd.zzb(j, i5, this.zze);
                if (!this.zze) {
                    this.zzg.zzd(i6);
                    this.zzh.zzd(i6);
                    this.zzi.zzd(i6);
                    zzajt zzajtVar = this.zzg;
                    if (zzajtVar.zze()) {
                        zzajt zzajtVar2 = this.zzh;
                        if (zzajtVar2.zze()) {
                            zzajt zzajtVar3 = this.zzi;
                            if (zzajtVar3.zze()) {
                                zzacs zzacsVar = this.zzc;
                                String str = this.zzb;
                                int i7 = zzajtVar.zzb;
                                byte[] bArr = new byte[zzajtVar2.zzb + i7 + zzajtVar3.zzb];
                                System.arraycopy(zzajtVar.zza, 0, bArr, 0, i7);
                                System.arraycopy(zzajtVar2.zza, 0, bArr, zzajtVar.zzb, zzajtVar2.zzb);
                                System.arraycopy(zzajtVar3.zza, 0, bArr, zzajtVar.zzb + zzajtVar2.zzb, zzajtVar3.zzb);
                                zzfv zzfvVarZzc = zzfy.zzc(zzajtVar2.zza, 5, zzajtVar2.zzb);
                                String strZzb = zzdz.zzb(zzfvVarZzc.zza, zzfvVarZzc.zzb, zzfvVarZzc.zzc, zzfvVarZzc.zzd, zzfvVarZzc.zze, zzfvVarZzc.zzf);
                                zzak zzakVar = new zzak();
                                zzakVar.zzJ(str);
                                zzakVar.zzU("video/hevc");
                                zzakVar.zzz(strZzb);
                                zzakVar.zzab(zzfvVarZzc.zzg);
                                zzakVar.zzH(zzfvVarZzc.zzh);
                                zzakVar.zzR(zzfvVarZzc.zzi);
                                zzakVar.zzK(Collections.singletonList(bArr));
                                zzacsVar.zzl(zzakVar.zzac());
                                this.zze = true;
                            }
                        }
                    }
                }
                if (this.zzj.zzd(i6)) {
                    zzajt zzajtVar4 = this.zzj;
                    this.zzn.zzE(this.zzj.zza, zzfy.zzb(zzajtVar4.zza, zzajtVar4.zzb));
                    this.zzn.zzH(5);
                    this.zza.zza(j2, this.zzn);
                }
                if (this.zzk.zzd(i6)) {
                    zzajt zzajtVar5 = this.zzk;
                    this.zzn.zzE(this.zzk.zza, zzfy.zzb(zzajtVar5.zza, zzajtVar5.zzb));
                    this.zzn.zzH(5);
                    this.zza.zza(j2, this.zzn);
                }
                int i8 = i3 >> 1;
                this.zzd.zze(j, i5, i8, this.zzm, this.zze);
                if (!this.zze) {
                    this.zzg.zzc(i8);
                    this.zzh.zzc(i8);
                    this.zzi.zzc(i8);
                }
                this.zzj.zzc(i8);
                this.zzk.zzc(i8);
                iZzc = i2;
                iZzd = iZzd;
                bArrZzI = bArrZzI;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        this.zzb = zzakqVar.zzb();
        this.zzc = zzabpVar.zzw(zzakqVar.zza(), 2);
        this.zzd = new zzajo(this.zzc);
        this.zza.zzb(zzabpVar, zzakqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzc(boolean z) {
        zzdx.zzb(this.zzc);
        int i = zzfk.zza;
        if (z) {
            this.zzd.zza(this.zzl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzd(long j, int i) {
        if (j != -9223372036854775807L) {
            this.zzm = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zze() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzfy.zzf(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        zzajo zzajoVar = this.zzd;
        if (zzajoVar != null) {
            zzajoVar.zzd();
        }
    }
}
