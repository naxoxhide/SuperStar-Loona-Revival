package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzob {
    private final zzcs zza;
    private zzfvs zzb = zzfvs.zzl();
    private zzfvv zzc = zzfvv.zzd();
    private zztw zzd;
    private zztw zze;
    private zztw zzf;

    public zzob(zzcs zzcsVar) {
        this.zza = zzcsVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static zztw zzj(zzco zzcoVar, zzfvs zzfvsVar, zztw zztwVar, zzcs zzcsVar) {
        zzcv zzcvVarZzn = zzcoVar.zzn();
        int iZze = zzcoVar.zze();
        Object objZzf = zzcvVarZzn.zzo() ? null : zzcvVarZzn.zzf(iZze);
        int iZzc = (zzcoVar.zzx() || zzcvVarZzn.zzo()) ? -1 : zzcvVarZzn.zzd(iZze, zzcsVar, false).zzc(zzfk.zzq(zzcoVar.zzk()));
        for (int i = 0; i < zzfvsVar.size(); i++) {
            zztw zztwVar2 = (zztw) zzfvsVar.get(i);
            if (zzm(zztwVar2, objZzf, zzcoVar.zzx(), zzcoVar.zzb(), zzcoVar.zzc(), iZzc)) {
                return zztwVar2;
            }
        }
        if (zzfvsVar.isEmpty() && zztwVar != null) {
            if (zzm(zztwVar, objZzf, zzcoVar.zzx(), zzcoVar.zzb(), zzcoVar.zzc(), iZzc)) {
                return zztwVar;
            }
        }
        return null;
    }

    private final void zzk(zzfvu zzfvuVar, zztw zztwVar, zzcv zzcvVar) {
        if (zztwVar == null) {
            return;
        }
        if (zzcvVar.zza(zztwVar.zza) != -1) {
            zzfvuVar.zza(zztwVar, zzcvVar);
            return;
        }
        zzcv zzcvVar2 = (zzcv) this.zzc.get(zztwVar);
        if (zzcvVar2 != null) {
            zzfvuVar.zza(zztwVar, zzcvVar2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzl(zzcv zzcvVar) {
        zzfvu zzfvuVar = new zzfvu();
        if (this.zzb.isEmpty()) {
            zzk(zzfvuVar, this.zze, zzcvVar);
            if (!zzfsr.zza(this.zzf, this.zze)) {
                zzk(zzfvuVar, this.zzf, zzcvVar);
            }
            if (!zzfsr.zza(this.zzd, this.zze) && !zzfsr.zza(this.zzd, this.zzf)) {
                zzk(zzfvuVar, this.zzd, zzcvVar);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzfvuVar, (zztw) this.zzb.get(i), zzcvVar);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfvuVar, this.zzd, zzcvVar);
            }
        }
        this.zzc = zzfvuVar.zzc();
    }

    private static boolean zzm(zztw zztwVar, Object obj, boolean z, int i, int i2, int i3) {
        if (!zztwVar.zza.equals(obj)) {
            return false;
        }
        if (z) {
            if (zztwVar.zzb != i || zztwVar.zzc != i2) {
                return false;
            }
        } else if (zztwVar.zzb != -1 || zztwVar.zze != i3) {
            return false;
        }
        return true;
    }

    public final zzcv zza(zztw zztwVar) {
        return (zzcv) this.zzc.get(zztwVar);
    }

    public final zztw zzb() {
        return this.zzd;
    }

    public final zztw zzc() {
        Object next;
        Object obj;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfvs zzfvsVar = this.zzb;
        if (!(zzfvsVar instanceof List)) {
            Iterator<E> it = zzfvsVar.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else {
            if (zzfvsVar.isEmpty()) {
                throw new NoSuchElementException();
            }
            obj = zzfvsVar.get(zzfvsVar.size() - 1);
        }
        return (zztw) obj;
    }

    public final zztw zzd() {
        return this.zze;
    }

    public final zztw zze() {
        return this.zzf;
    }

    public final void zzg(zzco zzcoVar) {
        this.zzd = zzj(zzcoVar, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zztw zztwVar, zzco zzcoVar) {
        this.zzb = zzfvs.zzj(list);
        if (!list.isEmpty()) {
            this.zze = (zztw) list.get(0);
            Objects.requireNonNull(zztwVar);
            this.zzf = zztwVar;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzcoVar, this.zzb, this.zze, this.zza);
        }
        zzl(zzcoVar.zzn());
    }

    public final void zzi(zzco zzcoVar) {
        this.zzd = zzj(zzcoVar, this.zzb, this.zze, this.zza);
        zzl(zzcoVar.zzn());
    }
}
