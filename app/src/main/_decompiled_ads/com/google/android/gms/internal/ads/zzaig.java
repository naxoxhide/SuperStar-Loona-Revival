package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaig {
    private final zzaih zza = new zzaih();
    private final zzfb zzb = new zzfb(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    zzaig() {
    }

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzaih zzaihVar = this.zza;
            if (i5 >= zzaihVar.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzaihVar.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzfb zza() {
        return this.zzb;
    }

    public final zzaih zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzD(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzfb zzfbVar = this.zzb;
        if (zzfbVar.zzI().length == 65025) {
            return;
        }
        zzfbVar.zzE(Arrays.copyOf(zzfbVar.zzI(), Math.max(65025, zzfbVar.zzd())), this.zzb.zzd());
    }

    public final boolean zze(zzabn zzabnVar) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzD(0);
        }
        while (true) {
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                if (!this.zza.zzc(zzabnVar, -1L) || !this.zza.zzb(zzabnVar, true)) {
                    return false;
                }
                zzaih zzaihVar = this.zza;
                int iZzf = zzaihVar.zzd;
                if ((zzaihVar.zza & 1) == 1 && this.zzb.zzd() == 0) {
                    iZzf += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzabq.zze(zzabnVar, iZzf)) {
                    return false;
                }
                this.zzc = i;
            }
            int iZzf2 = zzf(i);
            int i2 = this.zzc + this.zzd;
            if (iZzf2 > 0) {
                zzfb zzfbVar = this.zzb;
                zzfbVar.zzA(zzfbVar.zzd() + iZzf2);
                zzfb zzfbVar2 = this.zzb;
                if (!zzabq.zzd(zzabnVar, zzfbVar2.zzI(), zzfbVar2.zzd(), iZzf2)) {
                    return false;
                }
                zzfb zzfbVar3 = this.zzb;
                zzfbVar3.zzF(zzfbVar3.zzd() + iZzf2);
                this.zze = this.zza.zzf[i2 + (-1)] != 255;
            }
            if (i2 == this.zza.zzc) {
                i2 = -1;
            }
            this.zzc = i2;
        }
    }
}
