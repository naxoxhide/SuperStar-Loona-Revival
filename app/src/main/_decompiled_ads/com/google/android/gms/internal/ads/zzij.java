package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzij implements zzkt {
    private final zzly zza;
    private final zzii zzb;
    private zzlr zzc;
    private zzkt zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzij(zzii zziiVar, zzdy zzdyVar) {
        this.zzb = zziiVar;
        this.zza = new zzly(zzdyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final long zza() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    public final long zzb(boolean z) {
        zzcg zzcgVarZzc;
        zzlr zzlrVar = this.zzc;
        if (zzlrVar == null || zzlrVar.zzT() || (!this.zzc.zzU() && (z || this.zzc.zzN()))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzkt zzktVar = this.zzd;
            Objects.requireNonNull(zzktVar);
            long jZza = zzktVar.zza();
            if (!this.zze) {
                this.zza.zzb(jZza);
                zzcgVarZzc = zzktVar.zzc();
                if (!zzcgVarZzc.equals(this.zza.zzc())) {
                    this.zza.zzg(zzcgVarZzc);
                    this.zzb.zza(zzcgVarZzc);
                }
            } else if (jZza < this.zza.zza()) {
                this.zza.zze();
            } else {
                this.zze = false;
                if (this.zzf) {
                    this.zza.zzd();
                }
                this.zza.zzb(jZza);
                zzcgVarZzc = zzktVar.zzc();
                if (!zzcgVarZzc.equals(this.zza.zzc())) {
                    this.zza.zzg(zzcgVarZzc);
                    this.zzb.zza(zzcgVarZzc);
                }
            }
        }
        if (this.zze) {
            return this.zza.zza();
        }
        zzkt zzktVar2 = this.zzd;
        Objects.requireNonNull(zzktVar2);
        return zzktVar2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final zzcg zzc() {
        zzkt zzktVar = this.zzd;
        return zzktVar != null ? zzktVar.zzc() : this.zza.zzc();
    }

    public final void zzd(zzlr zzlrVar) {
        if (zzlrVar == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzlr zzlrVar) throws zzil {
        zzkt zzktVar;
        zzkt zzktVarZzk = zzlrVar.zzk();
        if (zzktVarZzk == null || zzktVarZzk == (zzktVar = this.zzd)) {
            return;
        }
        if (zzktVar != null) {
            throw zzil.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.zzd = zzktVarZzk;
        this.zzc = zzlrVar;
        zzktVarZzk.zzg(this.zza.zzc());
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final void zzg(zzcg zzcgVar) {
        zzkt zzktVar = this.zzd;
        if (zzktVar != null) {
            zzktVar.zzg(zzcgVar);
            zzcgVar = this.zzd.zzc();
        }
        this.zza.zzg(zzcgVar);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }
}
