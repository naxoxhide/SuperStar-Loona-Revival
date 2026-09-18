package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaif implements zzabm {
    public static final zzabt zza = new zzabt() { // from class: com.google.android.gms.internal.ads.zzaie
        @Override // com.google.android.gms.internal.ads.zzabt
        public final /* synthetic */ zzabm[] zza(Uri uri, Map map) {
            int i = zzabs.zza;
            zzabt zzabtVar = zzaif.zza;
            return new zzabm[]{new zzaif()};
        }
    };
    private zzabp zzb;
    private zzain zzc;
    private boolean zzd;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zza(zzabn zzabnVar) throws IOException {
        zzaih zzaihVar = new zzaih();
        if (zzaihVar.zzb(zzabnVar, true) && (zzaihVar.zza & 2) == 2) {
            int iMin = Math.min(zzaihVar.zze, 8);
            zzfb zzfbVar = new zzfb(iMin);
            ((zzabc) zzabnVar).zzm(zzfbVar.zzI(), 0, iMin, false);
            zzfbVar.zzG(0);
            if (zzfbVar.zza() >= 5 && zzfbVar.zzl() == 127 && zzfbVar.zzt() == 1179402563) {
                this.zzc = new zzaid();
            } else {
                zzfbVar.zzG(0);
                try {
                    if (zzacy.zzd(1, zzfbVar, true)) {
                        this.zzc = new zzaip();
                    } else {
                        zzfbVar.zzG(0);
                        if (zzaij.zzd(zzfbVar)) {
                            this.zzc = new zzaij();
                        }
                    }
                } catch (zzcc unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final int zzb(zzabn zzabnVar, zzacj zzacjVar) throws IOException {
        zzdx.zzb(this.zzb);
        if (this.zzc == null) {
            if (!zza(zzabnVar)) {
                throw zzcc.zza("Failed to determine bitstream type", null);
            }
            zzabnVar.zzj();
        }
        if (!this.zzd) {
            zzacs zzacsVarZzw = this.zzb.zzw(0, 1);
            this.zzb.zzD();
            this.zzc.zzh(this.zzb, zzacsVarZzw);
            this.zzd = true;
        }
        return this.zzc.zze(zzabnVar, zzacjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzc(zzabp zzabpVar) {
        this.zzb = zzabpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final void zzd(long j, long j2) {
        zzain zzainVar = this.zzc;
        if (zzainVar != null) {
            zzainVar.zzj(j, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final boolean zze(zzabn zzabnVar) throws IOException {
        try {
            return zza(zzabnVar);
        } catch (zzcc unused) {
            return false;
        }
    }
}
