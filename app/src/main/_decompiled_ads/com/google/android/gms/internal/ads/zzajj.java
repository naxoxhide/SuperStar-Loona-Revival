package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajj implements zzaje {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzakt zzb;
    private final zzfb zzc;
    private final boolean[] zzd;
    private final zzajh zze;
    private final zzajt zzf;
    private zzaji zzg;
    private long zzh;
    private String zzi;
    private zzacs zzj;
    private boolean zzk;
    private long zzl;

    public zzajj() {
        this(null);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x010e  */
    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzfb zzfbVar) {
        int i;
        int i2;
        zzdx.zzb(this.zzg);
        zzdx.zzb(this.zzj);
        int iZzc = zzfbVar.zzc();
        int iZzd = zzfbVar.zzd();
        byte[] bArrZzI = zzfbVar.zzI();
        this.zzh += (long) zzfbVar.zza();
        this.zzj.zzr(zzfbVar, zzfbVar.zza());
        while (true) {
            int iZza = zzfy.zza(bArrZzI, iZzc, iZzd, this.zzd);
            if (iZza == iZzd) {
                break;
            }
            int i3 = iZza + 3;
            int i4 = zzfbVar.zzI()[i3] & 255;
            int i5 = iZza - iZzc;
            if (!this.zzk) {
                if (i5 > 0) {
                    this.zze.zza(bArrZzI, iZzc, iZza);
                }
                if (this.zze.zzc(i4, i5 < 0 ? -i5 : 0)) {
                    zzacs zzacsVar = this.zzj;
                    zzajh zzajhVar = this.zze;
                    int i6 = zzajhVar.zzb;
                    String str = this.zzi;
                    Objects.requireNonNull(str);
                    byte[] bArrCopyOf = Arrays.copyOf(zzajhVar.zzc, zzajhVar.zza);
                    zzfa zzfaVar = new zzfa(bArrCopyOf, bArrCopyOf.length);
                    zzfaVar.zzm(i6);
                    zzfaVar.zzm(4);
                    zzfaVar.zzk();
                    zzfaVar.zzl(8);
                    if (zzfaVar.zzn()) {
                        zzfaVar.zzl(4);
                        zzfaVar.zzl(3);
                    }
                    int iZzd2 = zzfaVar.zzd(4);
                    float f = 1.0f;
                    if (iZzd2 == 15) {
                        int iZzd3 = zzfaVar.zzd(8);
                        int iZzd4 = zzfaVar.zzd(8);
                        if (iZzd4 == 0) {
                            zzer.zzf("H263Reader", "Invalid aspect ratio");
                        } else {
                            f = iZzd3 / iZzd4;
                        }
                    } else if (iZzd2 < 7) {
                        f = zza[iZzd2];
                    } else {
                        zzer.zzf("H263Reader", "Invalid aspect ratio");
                    }
                    float f2 = f;
                    if (zzfaVar.zzn()) {
                        zzfaVar.zzl(2);
                        zzfaVar.zzl(1);
                        if (zzfaVar.zzn()) {
                            zzfaVar.zzl(15);
                            zzfaVar.zzk();
                            zzfaVar.zzl(15);
                            zzfaVar.zzk();
                            zzfaVar.zzl(15);
                            zzfaVar.zzk();
                            zzfaVar.zzl(3);
                            zzfaVar.zzl(11);
                            zzfaVar.zzk();
                            zzfaVar.zzl(15);
                            zzfaVar.zzk();
                            i2 = 2;
                        } else {
                            i2 = 2;
                        }
                    } else {
                        i2 = 2;
                    }
                    if (zzfaVar.zzd(i2) != 0) {
                        zzer.zzf("H263Reader", "Unhandled video object layer shape");
                    }
                    zzfaVar.zzk();
                    int iZzd5 = zzfaVar.zzd(16);
                    zzfaVar.zzk();
                    if (zzfaVar.zzn()) {
                        if (iZzd5 == 0) {
                            zzer.zzf("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            int i7 = iZzd5 - 1;
                            int i8 = 0;
                            while (i7 > 0) {
                                i7 >>= 1;
                                i8++;
                            }
                            zzfaVar.zzl(i8);
                        }
                    }
                    zzfaVar.zzk();
                    int iZzd6 = zzfaVar.zzd(13);
                    zzfaVar.zzk();
                    int iZzd7 = zzfaVar.zzd(13);
                    zzfaVar.zzk();
                    zzfaVar.zzk();
                    zzak zzakVar = new zzak();
                    zzakVar.zzJ(str);
                    zzakVar.zzU("video/mp4v-es");
                    zzakVar.zzab(iZzd6);
                    zzakVar.zzH(iZzd7);
                    zzakVar.zzR(f2);
                    zzakVar.zzK(Collections.singletonList(bArrCopyOf));
                    zzacsVar.zzl(zzakVar.zzac());
                    this.zzk = true;
                }
            }
            this.zzg.zza(bArrZzI, iZzc, iZza);
            zzajt zzajtVar = this.zzf;
            if (i5 > 0) {
                zzajtVar.zza(bArrZzI, iZzc, iZza);
                i = 0;
            } else {
                i = -i5;
            }
            if (this.zzf.zzd(i)) {
                zzajt zzajtVar2 = this.zzf;
                int iZzb = zzfy.zzb(zzajtVar2.zza, zzajtVar2.zzb);
                zzfb zzfbVar2 = this.zzc;
                int i9 = zzfk.zza;
                zzfbVar2.zzE(this.zzf.zza, iZzb);
                this.zzb.zza(this.zzl, this.zzc);
            }
            if (i4 == 178) {
                if (zzfbVar.zzI()[iZza + 2] == 1) {
                    this.zzf.zzc(178);
                }
                i4 = 178;
            }
            int i10 = iZzd - iZza;
            this.zzg.zzb(this.zzh - ((long) i10), i10, this.zzk);
            this.zzg.zzc(i4, this.zzl);
            iZzc = i3;
        }
        if (!this.zzk) {
            this.zze.zza(bArrZzI, iZzc, iZzd);
        }
        this.zzg.zza(bArrZzI, iZzc, iZzd);
        this.zzf.zza(bArrZzI, iZzc, iZzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzb(zzabp zzabpVar, zzakq zzakqVar) {
        zzakqVar.zzc();
        this.zzi = zzakqVar.zzb();
        this.zzj = zzabpVar.zzw(zzakqVar.zza(), 2);
        this.zzg = new zzaji(this.zzj);
        this.zzb.zzb(zzabpVar, zzakqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzc(boolean z) {
        zzdx.zzb(this.zzg);
        if (z) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzd(long j, int i) {
        if (j != -9223372036854775807L) {
            this.zzl = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zze() {
        zzfy.zzf(this.zzd);
        this.zze.zzb();
        zzaji zzajiVar = this.zzg;
        if (zzajiVar != null) {
            zzajiVar.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    zzajj(zzakt zzaktVar) {
        this.zzb = zzaktVar;
        this.zzd = new boolean[4];
        this.zze = new zzajh(128);
        this.zzl = -9223372036854775807L;
        this.zzf = new zzajt(178, 128);
        this.zzc = new zzfb();
    }
}
