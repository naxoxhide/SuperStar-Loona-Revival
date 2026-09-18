package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaco {
    private int zza;
    private int zzb;
    private zzabp zzc;
    private zzacs zzd;

    public static final boolean zzd(zzabn zzabnVar, int i, int i2) throws IOException {
        zzfb zzfbVar = new zzfb(2);
        ((zzabc) zzabnVar).zzm(zzfbVar.zzI(), 0, 2, false);
        return zzfbVar.zzp() == i;
    }

    public final int zza(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        int i = this.zzb;
        if (i != 1) {
            if (i == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        zzacs zzacsVar = this.zzd;
        Objects.requireNonNull(zzacsVar);
        int iZza = zzacq.zza(zzacsVar, zzabnVar, 1024, true);
        if (iZza == -1) {
            this.zzb = 2;
            this.zzd.zzt(0L, 1, this.zza, 0, null);
            this.zza = 0;
        } else {
            this.zza += iZza;
        }
        return 0;
    }

    public final void zzb(zzabp zzabpVar, String str) {
        this.zzc = zzabpVar;
        zzacs zzacsVarZzw = zzabpVar.zzw(1024, 4);
        this.zzd = zzacsVarZzw;
        zzak zzakVar = new zzak();
        zzakVar.zzB(str);
        zzakVar.zzZ(1);
        zzakVar.zzaa(1);
        zzacsVarZzw.zzl(zzakVar.zzac());
        this.zzc.zzD();
        this.zzc.zzO(new zzacp(-9223372036854775807L));
        this.zzb = 1;
    }

    public final void zzc(long j) {
        if (j == 0 || this.zzb == 1) {
            this.zzb = 1;
            this.zza = 0;
        }
    }
}
