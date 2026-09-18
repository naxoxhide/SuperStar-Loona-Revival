package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzof implements zzoj {
    public static final zzftm zza = new zzftm() { // from class: com.google.android.gms.internal.ads.zzod
        @Override // com.google.android.gms.internal.ads.zzftm
        public final Object zza() {
            return zzof.zzn();
        }
    };
    private static final Random zzb = new Random();
    private final zzcu zzc;
    private final zzcs zzd;
    private final HashMap zze;
    private final zzftm zzf;
    private zzoi zzg;
    private zzcv zzh;
    private String zzi;
    private long zzj;

    public zzof() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzl() {
        zzoe zzoeVar = (zzoe) this.zze.get(this.zzi);
        return (zzoeVar == null || zzoeVar.zzd == -1) ? this.zzj + 1 : zzoeVar.zzd;
    }

    private final zzoe zzm(int i, zztw zztwVar) {
        long j = Long.MAX_VALUE;
        zzoe zzoeVar = null;
        for (zzoe zzoeVar2 : this.zze.values()) {
            zzoeVar2.zzg(i, zztwVar);
            if (zzoeVar2.zzj(i, zztwVar)) {
                long j2 = zzoeVar2.zzd;
                if (j2 == -1 || j2 < j) {
                    zzoeVar = zzoeVar2;
                    j = j2;
                } else if (j2 == j) {
                    int i2 = zzfk.zza;
                    if (zzoeVar.zze != null && zzoeVar2.zze != null) {
                        zzoeVar = zzoeVar2;
                    }
                }
            }
        }
        if (zzoeVar != null) {
            return zzoeVar;
        }
        String strZzn = zzn();
        zzoe zzoeVar3 = new zzoe(this, strZzn, i, zztwVar);
        this.zze.put(strZzn, zzoeVar3);
        return zzoeVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzoe zzoeVar) {
        if (zzoeVar.zzd != -1) {
            this.zzj = zzoeVar.zzd;
        }
        this.zzi = null;
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    private final void zzp(zzmc zzmcVar) {
        if (zzmcVar.zzb.zzo()) {
            String str = this.zzi;
            if (str != null) {
                zzoe zzoeVar = (zzoe) this.zze.get(str);
                Objects.requireNonNull(zzoeVar);
                zzo(zzoeVar);
                return;
            }
            return;
        }
        zzoe zzoeVar2 = (zzoe) this.zze.get(this.zzi);
        zzoe zzoeVarZzm = zzm(zzmcVar.zzc, zzmcVar.zzd);
        this.zzi = zzoeVarZzm.zzb;
        zzi(zzmcVar);
        zztw zztwVar = zzmcVar.zzd;
        if (zztwVar == null || !zztwVar.zzb()) {
            return;
        }
        if (zzoeVar2 != null) {
            if (zzoeVar2.zzd == zztwVar.zzd && zzoeVar2.zze != null && zzoeVar2.zze.zzb == zzmcVar.zzd.zzb && zzoeVar2.zze.zzc == zzmcVar.zzd.zzc) {
                return;
            }
        }
        zztw zztwVar2 = zzmcVar.zzd;
        String unused = zzm(zzmcVar.zzc, new zztw(zztwVar2.zza, zztwVar2.zzd)).zzb;
        String unused2 = zzoeVarZzm.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzoj
    public final synchronized String zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzoj
    public final synchronized String zzf(zzcv zzcvVar, zztw zztwVar) {
        return zzm(zzcvVar.zzn(zztwVar.zza, this.zzd).zzd, zztwVar).zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzoj
    public final synchronized void zzg(zzmc zzmcVar) {
        zzoi zzoiVar;
        String str = this.zzi;
        if (str != null) {
            zzoe zzoeVar = (zzoe) this.zze.get(str);
            Objects.requireNonNull(zzoeVar);
            zzo(zzoeVar);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoe zzoeVar2 = (zzoe) it.next();
            it.remove();
            if (zzoeVar2.zzf && (zzoiVar = this.zzg) != null) {
                zzoiVar.zzd(zzmcVar, zzoeVar2.zzb, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoj
    public final void zzh(zzoi zzoiVar) {
        this.zzg = zzoiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzoj
    public final synchronized void zzi(zzmc zzmcVar) {
        Objects.requireNonNull(this.zzg);
        if (zzmcVar.zzb.zzo()) {
            return;
        }
        zztw zztwVar = zzmcVar.zzd;
        if (zztwVar != null) {
            if (zztwVar.zzd < zzl()) {
                return;
            }
            zzoe zzoeVar = (zzoe) this.zze.get(this.zzi);
            if (zzoeVar != null && zzoeVar.zzd == -1 && zzoeVar.zzc != zzmcVar.zzc) {
                return;
            }
        }
        zzoe zzoeVarZzm = zzm(zzmcVar.zzc, zzmcVar.zzd);
        if (this.zzi == null) {
            this.zzi = zzoeVarZzm.zzb;
        }
        zztw zztwVar2 = zzmcVar.zzd;
        if (zztwVar2 != null && zztwVar2.zzb()) {
            zzoe zzoeVarZzm2 = zzm(zzmcVar.zzc, new zztw(zztwVar2.zza, zztwVar2.zzd, zztwVar2.zzb));
            if (!zzoeVarZzm2.zzf) {
                zzoeVarZzm2.zzf = true;
                zzcv zzcvVar = zzmcVar.zzb;
                zztw zztwVar3 = zzmcVar.zzd;
                zzcvVar.zzn(zztwVar3.zza, this.zzd);
                this.zzd.zzi(zzmcVar.zzd.zzb);
                Math.max(0L, zzfk.zzs(0L) + zzfk.zzs(0L));
                String unused = zzoeVarZzm2.zzb;
            }
        }
        if (!zzoeVarZzm.zzf) {
            zzoeVarZzm.zzf = true;
            String unused2 = zzoeVarZzm.zzb;
        }
        if (!zzoeVarZzm.zzb.equals(this.zzi) || zzoeVarZzm.zzg) {
            return;
        }
        zzoeVarZzm.zzg = true;
        this.zzg.zzc(zzmcVar, zzoeVarZzm.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzoj
    public final synchronized void zzj(zzmc zzmcVar, int i) {
        Objects.requireNonNull(this.zzg);
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoe zzoeVar = (zzoe) it.next();
            if (zzoeVar.zzk(zzmcVar)) {
                it.remove();
                if (zzoeVar.zzf) {
                    boolean zEquals = zzoeVar.zzb.equals(this.zzi);
                    boolean z = false;
                    if (i == 0 && zEquals && zzoeVar.zzg) {
                        z = true;
                    }
                    if (zEquals) {
                        zzo(zzoeVar);
                    }
                    this.zzg.zzd(zzmcVar, zzoeVar.zzb, z);
                }
            }
        }
        zzp(zzmcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzoj
    public final synchronized void zzk(zzmc zzmcVar) {
        Objects.requireNonNull(this.zzg);
        zzcv zzcvVar = this.zzh;
        this.zzh = zzmcVar.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoe zzoeVar = (zzoe) it.next();
            if (!zzoeVar.zzl(zzcvVar, this.zzh) || zzoeVar.zzk(zzmcVar)) {
                it.remove();
                if (zzoeVar.zzf) {
                    if (zzoeVar.zzb.equals(this.zzi)) {
                        zzo(zzoeVar);
                    }
                    this.zzg.zzd(zzmcVar, zzoeVar.zzb, false);
                }
            }
        }
        zzp(zzmcVar);
    }

    public zzof(zzftm zzftmVar) {
        this.zzf = zzftmVar;
        this.zzc = new zzcu();
        this.zzd = new zzcs();
        this.zze = new HashMap();
        this.zzh = zzcv.zza;
        this.zzj = -1L;
    }
}
