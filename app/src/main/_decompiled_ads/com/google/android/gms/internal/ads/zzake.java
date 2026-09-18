package com.google.android.gms.internal.ads;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzake implements zzakr {
    private final zzakd zza;
    private final zzfb zzb = new zzfb(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzake(zzakd zzakdVar) {
        this.zza = zzakdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(zzfb zzfbVar, int i) {
        int iZzc;
        int i2 = i & 1;
        if (i2 != 0) {
            iZzc = zzfbVar.zzc() + zzfbVar.zzl();
        } else {
            iZzc = -1;
        }
        if (this.zzf) {
            if (i2 == 0) {
                return;
            }
            this.zzf = false;
            zzfbVar.zzG(iZzc);
            this.zzd = 0;
        }
        while (zzfbVar.zza() > 0) {
            int i3 = this.zzd;
            if (i3 < 3) {
                if (i3 == 0) {
                    int iZzl = zzfbVar.zzl();
                    zzfbVar.zzG(zzfbVar.zzc() - 1);
                    if (iZzl == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int iMin = Math.min(zzfbVar.zza(), 3 - this.zzd);
                zzfbVar.zzC(this.zzb.zzI(), this.zzd, iMin);
                int i4 = this.zzd + iMin;
                this.zzd = i4;
                if (i4 == 3) {
                    this.zzb.zzG(0);
                    this.zzb.zzF(3);
                    this.zzb.zzH(1);
                    zzfb zzfbVar2 = this.zzb;
                    int iZzl2 = zzfbVar2.zzl();
                    boolean z = (iZzl2 & 128) != 0;
                    int iZzl3 = zzfbVar2.zzl();
                    this.zze = z;
                    this.zzc = (iZzl3 | ((iZzl2 & 15) << 8)) + 3;
                    int iZzb = this.zzb.zzb();
                    int i5 = this.zzc;
                    if (iZzb < i5) {
                        int iZzb2 = this.zzb.zzb();
                        this.zzb.zzA(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i5, iZzb2 + iZzb2)));
                    }
                }
            } else {
                int iMin2 = Math.min(zzfbVar.zza(), this.zzc - i3);
                zzfbVar.zzC(this.zzb.zzI(), this.zzd, iMin2);
                int i6 = this.zzd + iMin2;
                this.zzd = i6;
                int i7 = this.zzc;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzF(i7);
                    } else {
                        if (zzfk.zzd(this.zzb.zzI(), 0, i7, -1) != 0) {
                            this.zzf = true;
                            return;
                        }
                        this.zzb.zzF(this.zzc - 4);
                    }
                    this.zzb.zzG(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zzb(zzfi zzfiVar, zzabp zzabpVar, zzakq zzakqVar) {
        this.zza.zzb(zzfiVar, zzabpVar, zzakqVar);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zzc() {
        this.zzf = true;
    }
}
