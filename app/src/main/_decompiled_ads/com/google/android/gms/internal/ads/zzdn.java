package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdn {
    private final zzfvs zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private zzdo zzd = zzdo.zza;
    private zzdo zze = zzdo.zza;
    private boolean zzf = false;

    public zzdn(zzfvs zzfvsVar) {
        this.zza = zzfvsVar;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        boolean z;
        ByteBuffer byteBuffer2;
        do {
            int i = 0;
            z = false;
            while (i <= zzi()) {
                int i2 = i + 1;
                if (!this.zzc[i].hasRemaining()) {
                    zzdq zzdqVar = (zzdq) this.zzb.get(i);
                    if (!zzdqVar.zzh()) {
                        if (i > 0) {
                            byteBuffer2 = this.zzc[i - 1];
                        } else {
                            byteBuffer2 = byteBuffer.hasRemaining() ? byteBuffer : zzdq.zza;
                        }
                        long jRemaining = byteBuffer2.remaining();
                        zzdqVar.zze(byteBuffer2);
                        this.zzc[i] = zzdqVar.zzb();
                        long jRemaining2 = jRemaining - ((long) byteBuffer2.remaining());
                        boolean z2 = true;
                        if (jRemaining2 <= 0 && !this.zzc[i].hasRemaining()) {
                            z2 = false;
                        }
                        z |= z2;
                    } else if (!this.zzc[i].hasRemaining() && i < zzi()) {
                        ((zzdq) this.zzb.get(i2)).zzd();
                    }
                }
                i = i2;
            }
        } while (z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdn)) {
            return false;
        }
        zzdn zzdnVar = (zzdn) obj;
        if (this.zza.size() != zzdnVar.zza.size()) {
            return false;
        }
        for (int i = 0; i < this.zza.size(); i++) {
            if (this.zza.get(i) != zzdnVar.zza.get(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzdo zza(zzdo zzdoVar) throws zzdp {
        if (zzdoVar.equals(zzdo.zza)) {
            throw new zzdp("Unhandled input format:", zzdoVar);
        }
        for (int i = 0; i < this.zza.size(); i++) {
            zzdq zzdqVar = (zzdq) this.zza.get(i);
            zzdo zzdoVarZza = zzdqVar.zza(zzdoVar);
            if (zzdqVar.zzg()) {
                zzdx.zzf(!zzdoVarZza.equals(zzdo.zza));
                zzdoVar = zzdoVarZza;
            }
        }
        this.zze = zzdoVar;
        return zzdoVar;
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzdq.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzj(zzdq.zza);
        return this.zzc[zzi()];
    }

    public final void zzc() {
        this.zzb.clear();
        this.zzd = this.zze;
        this.zzf = false;
        for (int i = 0; i < this.zza.size(); i++) {
            zzdq zzdqVar = (zzdq) this.zza.get(i);
            zzdqVar.zzc();
            if (zzdqVar.zzg()) {
                this.zzb.add(zzdqVar);
            }
        }
        this.zzc = new ByteBuffer[this.zzb.size()];
        for (int i2 = 0; i2 <= zzi(); i2++) {
            this.zzc[i2] = ((zzdq) this.zzb.get(i2)).zzb();
        }
    }

    public final void zzd() {
        if (!zzh() || this.zzf) {
            return;
        }
        this.zzf = true;
        ((zzdq) this.zzb.get(0)).zzd();
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (!zzh() || this.zzf) {
            return;
        }
        zzj(byteBuffer);
    }

    public final void zzf() {
        for (int i = 0; i < this.zza.size(); i++) {
            zzdq zzdqVar = (zzdq) this.zza.get(i);
            zzdqVar.zzc();
            zzdqVar.zzf();
        }
        this.zzc = new ByteBuffer[0];
        this.zzd = zzdo.zza;
        this.zze = zzdo.zza;
        this.zzf = false;
    }

    public final boolean zzg() {
        return this.zzf && ((zzdq) this.zzb.get(zzi())).zzh() && !this.zzc[zzi()].hasRemaining();
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }
}
