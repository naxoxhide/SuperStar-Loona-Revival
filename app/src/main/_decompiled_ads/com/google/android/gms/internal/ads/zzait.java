package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzait implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzais
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzait.zza;
            return new zzabm[]{new zzait()};
        }
    };
    private final zzaiu zzb = new zzaiu(null);
    private final zzfb zzc = new zzfb(2786);
    private boolean zzd;

    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        int iZza = zzabnVar.zza(this.zzc.zzI(), 0, 2786);
        if (iZza == -1) {
            return -1;
        }
        this.zzc.zzG(0);
        this.zzc.zzF(iZza);
        if (!this.zzd) {
            this.zzb.zzd(0L, 4);
            this.zzd = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzb.zzb(zzabpVar, new zzakq(Integer.MIN_VALUE, 0, 1));
        zzabpVar.zzD();
        zzabpVar.zzO(new zzacl(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        this.zzd = false;
        this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        zzabc zzabcVar;
        zzfb zzfbVar = new zzfb(10);
        int i = 0;
        while (true) {
            zzabcVar = (zzabc) zzabnVar;
            zzabcVar.zzm(zzfbVar.zzI(), 0, 10, false);
            zzfbVar.zzG(0);
            if (zzfbVar.zzn() != 4801587) {
                break;
            }
            zzfbVar.zzH(3);
            int iZzk = zzfbVar.zzk();
            i += iZzk + 10;
            zzabcVar.zzl(iZzk, false);
        }
        zzabnVar.zzj();
        zzabcVar.zzl(i, false);
        int i2 = 0;
        int i3 = i;
        while (true) {
            zzabcVar.zzm(zzfbVar.zzI(), 0, 6, false);
            zzfbVar.zzG(0);
            if (zzfbVar.zzp() != 2935) {
                zzabnVar.zzj();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                zzabcVar.zzl(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iZzb = zzaan.zzb(zzfbVar.zzI());
                if (iZzb == -1) {
                    return false;
                }
                zzabcVar.zzl(iZzb - 6, false);
            }
        }
    }
}
