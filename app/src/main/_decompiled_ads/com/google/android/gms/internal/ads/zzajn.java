package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajn implements zzaje {
    private final zzakf zza;
    private long zze;
    private String zzg;
    private zzacs zzh;
    private zzajm zzi;
    private boolean zzj;
    private boolean zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzajt zzb = new zzajt(7, 128);
    private final zzajt zzc = new zzajt(8, 128);
    private final zzajt zzd = new zzajt(6, 128);
    private long zzk = -9223372036854775807L;
    private final zzfb zzm = new zzfb();

    public zzajn(zzakf zzakfVar, boolean z, boolean z2) {
        this.zza = zzakfVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i, i2);
            this.zzc.zza(bArr, i, i2);
        }
        this.zzd.zza(bArr, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0052  */
    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) {
        int i;
        int i2;
        zzdx.zzb(this.zzh);
        int i3 = zzfk.zza;
        int iZzc = zzfbVar.zzc();
        int iZzd = zzfbVar.zzd();
        byte[] bArrZzI = zzfbVar.zzI();
        this.zze += (long) zzfbVar.zza();
        this.zzh.zzr(zzfbVar, zzfbVar.zza());
        while (true) {
            int iZza = zzfy.zza(bArrZzI, iZzc, iZzd, this.zzf);
            if (iZza == iZzd) {
                zzf(bArrZzI, iZzc, iZzd);
                return;
            }
            int i4 = iZza + 3;
            int i5 = bArrZzI[i4] & 31;
            int i6 = iZza - iZzc;
            if (i6 > 0) {
                zzf(bArrZzI, iZzc, iZza);
            }
            int i7 = iZzd - iZza;
            long j = this.zze - ((long) i7);
            int i8 = i6 < 0 ? -i6 : 0;
            long j2 = this.zzk;
            if (this.zzj) {
                i = iZzd;
                i2 = i4;
            } else {
                this.zzb.zzd(i8);
                this.zzc.zzd(i8);
                if (this.zzj) {
                    i = iZzd;
                    i2 = i4;
                    zzajt zzajtVar = this.zzb;
                    if (zzajtVar.zze()) {
                        this.zzi.zzc(zzfy.zze(zzajtVar.zza, 4, zzajtVar.zzb));
                        this.zzb.zzb();
                    } else {
                        zzajt zzajtVar2 = this.zzc;
                        if (zzajtVar2.zze()) {
                            this.zzi.zzb(zzfy.zzd(zzajtVar2.zza, 4, zzajtVar2.zzb));
                            this.zzc.zzb();
                        }
                    }
                } else if (this.zzb.zze() && this.zzc.zze()) {
                    ArrayList arrayList = new ArrayList();
                    zzajt zzajtVar3 = this.zzb;
                    arrayList.add(Arrays.copyOf(zzajtVar3.zza, zzajtVar3.zzb));
                    zzajt zzajtVar4 = this.zzc;
                    arrayList.add(Arrays.copyOf(zzajtVar4.zza, zzajtVar4.zzb));
                    zzajt zzajtVar5 = this.zzb;
                    zzfx zzfxVarZze = zzfy.zze(zzajtVar5.zza, 4, zzajtVar5.zzb);
                    zzajt zzajtVar6 = this.zzc;
                    zzfw zzfwVarZzd = zzfy.zzd(zzajtVar6.zza, 4, zzajtVar6.zzb);
                    i2 = i4;
                    String strZza = zzdz.zza(zzfxVarZze.zza, zzfxVarZze.zzb, zzfxVarZze.zzc);
                    zzacs zzacsVar = this.zzh;
                    zzak zzakVar = new zzak();
                    i = iZzd;
                    zzakVar.zzJ(this.zzg);
                    zzakVar.zzU("video/avc");
                    zzakVar.zzz(strZza);
                    zzakVar.zzab(zzfxVarZze.zze);
                    zzakVar.zzH(zzfxVarZze.zzf);
                    zzakVar.zzR(zzfxVarZze.zzg);
                    zzakVar.zzK(arrayList);
                    zzacsVar.zzl(zzakVar.zzac());
                    this.zzj = true;
                    this.zzi.zzc(zzfxVarZze);
                    this.zzi.zzb(zzfwVarZzd);
                    this.zzb.zzb();
                    this.zzc.zzb();
                } else {
                    i = iZzd;
                    i2 = i4;
                }
            }
            if (this.zzd.zzd(i8)) {
                zzajt zzajtVar7 = this.zzd;
                this.zzm.zzE(this.zzd.zza, zzfy.zzb(zzajtVar7.zza, zzajtVar7.zzb));
                this.zzm.zzG(4);
                this.zza.zza(j2, this.zzm);
            }
            if (this.zzi.zzf(j, i7, this.zzj, this.zzl)) {
                this.zzl = false;
            }
            long j3 = this.zzk;
            if (!this.zzj) {
                this.zzb.zzc(i5);
                this.zzc.zzc(i5);
            }
            this.zzd.zzc(i5);
            this.zzi.zze(j, i5, j3);
            iZzc = i2;
            iZzd = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        this.zzg = zzakqVar.zzb();
        this.zzh = zzabpVar.zzw(zzakqVar.zza(), 2);
        this.zzi = new zzajm(this.zzh, false, false);
        this.zza.zzb(zzabpVar, zzakqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzc(boolean z) {
        zzdx.zzb(this.zzh);
        int i = zzfk.zza;
        if (z) {
            this.zzi.zza(this.zze);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzd(long j, int i) {
        if (j != -9223372036854775807L) {
            this.zzk = j;
        }
        this.zzl |= (i & 2) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zze() {
        this.zze = 0L;
        this.zzl = false;
        this.zzk = -9223372036854775807L;
        zzfy.zzf(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzajm zzajmVar = this.zzi;
        if (zzajmVar != null) {
            zzajmVar.zzd();
        }
    }
}
