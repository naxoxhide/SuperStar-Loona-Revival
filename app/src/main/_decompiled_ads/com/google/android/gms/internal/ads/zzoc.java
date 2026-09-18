package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzoc implements zzmb {
    private final zzdy zza;
    private final zzcs zzb;
    private final zzcu zzc;
    private final zzob zzd;
    private final SparseArray zze;
    private zzeo zzf;
    private zzco zzg;
    private zzei zzh;
    private boolean zzi;

    public static /* synthetic */ void zzT(zzoc zzocVar) {
        final zzmc zzmcVarZzR = zzocVar.zzR();
        zzocVar.zzW(zzmcVarZzR, 1028, new zzel() { // from class: com.google.android.gms.internal.ads.zzmg
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
        zzocVar.zzf.zze();
    }

    private final zzmc zzY(int i, zztw zztwVar) {
        zzco zzcoVar = this.zzg;
        Objects.requireNonNull(zzcoVar);
        if (zztwVar != null) {
            return this.zzd.zza(zztwVar) != null ? zzX(zztwVar) : zzS(zzcv.zza, i, zztwVar);
        }
        zzcv zzcvVarZzn = zzcoVar.zzn();
        if (i >= zzcvVarZzn.zzc()) {
            zzcvVarZzn = zzcv.zza;
        }
        return zzS(zzcvVarZzn, i, null);
    }

    private final zzmc zzZ() {
        return zzX(this.zzd.zzd());
    }

    private final zzmc zzaa() {
        return zzX(this.zzd.zze());
    }

    private final zzmc zzab(zzce zzceVar) {
        zztw zztwVar;
        return (!(zzceVar instanceof zzil) || (zztwVar = ((zzil) zzceVar).zzj) == null) ? zzR() : zzX(zztwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzA(final zzam zzamVar, final zzie zzieVar) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_VERTICAL_TEXT, new zzel() { // from class: com.google.android.gms.internal.ads.zznr
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zze(zzmcVarZzaa, zzamVar, zzieVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzB(final long j) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_ALIAS, new zzel(j) { // from class: com.google.android.gms.internal.ads.zzmw
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzC(final Exception exc) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new zzel() { // from class: com.google.android.gms.internal.ads.zzny
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzD(final int i, final long j, final long j2) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_COPY, new zzel(i, j, j2) { // from class: com.google.android.gms.internal.ads.zzms
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzE(final int i, final long j) {
        final zzmc zzmcVarZzZ = zzZ();
        zzW(zzmcVarZzZ, PointerIconCompat.TYPE_ZOOM_IN, new zzel() { // from class: com.google.android.gms.internal.ads.zznc
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zzh(zzmcVarZzZ, i, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzF(final Object obj, final long j) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, 26, new zzel() { // from class: com.google.android.gms.internal.ads.zznv
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj2) {
                ((zzme) obj2).zzn(zzmcVarZzaa, obj, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzG(final Exception exc) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, 1030, new zzel() { // from class: com.google.android.gms.internal.ads.zzmr
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzH(final String str, final long j, final long j2) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new zzel(str, j2, j) { // from class: com.google.android.gms.internal.ads.zznx
            public final /* synthetic */ String zzb;

            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzI(final String str) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_ZOOM_OUT, new zzel() { // from class: com.google.android.gms.internal.ads.zznb
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzJ(final zzid zzidVar) {
        final zzmc zzmcVarZzZ = zzZ();
        zzW(zzmcVarZzZ, PointerIconCompat.TYPE_GRAB, new zzel() { // from class: com.google.android.gms.internal.ads.zzno
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zzo(zzmcVarZzZ, zzidVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzK(final zzid zzidVar) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, new zzel() { // from class: com.google.android.gms.internal.ads.zznt
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzL(final long j, final int i) {
        final zzmc zzmcVarZzZ = zzZ();
        zzW(zzmcVarZzZ, PointerIconCompat.TYPE_GRABBING, new zzel(j, i) { // from class: com.google.android.gms.internal.ads.zzng
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzM(final zzam zzamVar, final zzie zzieVar) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new zzel() { // from class: com.google.android.gms.internal.ads.zznn
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zzp(zzmcVarZzaa, zzamVar, zzieVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzN() {
        zzei zzeiVar = this.zzh;
        zzdx.zzb(zzeiVar);
        zzeiVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zznu
            @Override // java.lang.Runnable
            public final void run() {
                zzoc.zzT(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzO(zzme zzmeVar) {
        this.zzf.zzf(zzmeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzP(final zzco zzcoVar, Looper looper) {
        boolean z = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z = false;
        }
        zzdx.zzf(z);
        Objects.requireNonNull(zzcoVar);
        this.zzg = zzcoVar;
        this.zzh = this.zza.zzb(looper, null);
        this.zzf = this.zzf.zza(looper, new zzem() { // from class: com.google.android.gms.internal.ads.zzmu
            @Override // com.google.android.gms.internal.ads.zzem
            public final void zza(Object obj, zzah zzahVar) {
                this.zza.zzU(zzcoVar, (zzme) obj, zzahVar);
            }
        });
    }

    protected final zzmc zzR() {
        return zzX(this.zzd.zzb());
    }

    @RequiresNonNull({"player"})
    protected final zzmc zzS(zzcv zzcvVar, int i, zztw zztwVar) {
        zztw zztwVar2 = true == zzcvVar.zzo() ? null : zztwVar;
        long jZza = this.zza.zza();
        boolean z = zzcvVar.equals(this.zzg.zzn()) && i == this.zzg.zzd();
        long jZzs = 0;
        if (zztwVar2 == null || !zztwVar2.zzb()) {
            if (z) {
                jZzs = this.zzg.zzj();
            } else if (!zzcvVar.zzo()) {
                long j = zzcvVar.zze(i, this.zzc, 0L).zzn;
                jZzs = zzfk.zzs(0L);
            }
        } else if (z && this.zzg.zzb() == zztwVar2.zzb && this.zzg.zzc() == zztwVar2.zzc) {
            jZzs = this.zzg.zzk();
        }
        return new zzmc(jZza, zzcvVar, i, zztwVar2, jZzs, this.zzg.zzn(), this.zzg.zzd(), this.zzd.zzb(), this.zzg.zzk(), this.zzg.zzm());
    }

    final /* synthetic */ void zzU(zzco zzcoVar, zzme zzmeVar, zzah zzahVar) {
        zzmeVar.zzi(zzcoVar, new zzmd(zzahVar, this.zze));
    }

    @Override // com.google.android.gms.internal.ads.zzxx
    public final void zzV(final int i, final long j, final long j2) {
        final zzmc zzmcVarZzX = zzX(this.zzd.zzc());
        zzW(zzmcVarZzX, PointerIconCompat.TYPE_CELL, new zzel() { // from class: com.google.android.gms.internal.ads.zzmp
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zzf(zzmcVarZzX, i, j, j2);
            }
        });
    }

    protected final void zzW(zzmc zzmcVar, int i, zzel zzelVar) {
        this.zze.put(i, zzmcVar);
        zzeo zzeoVar = this.zzf;
        zzeoVar.zzd(i, zzelVar);
        zzeoVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zza(final zzck zzckVar) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 13, new zzel() { // from class: com.google.android.gms.internal.ads.zzml
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzac(int i, zztw zztwVar, final zzts zztsVar) {
        final zzmc zzmcVarZzY = zzY(i, zztwVar);
        zzW(zzmcVarZzY, PointerIconCompat.TYPE_WAIT, new zzel() { // from class: com.google.android.gms.internal.ads.zznh
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zzg(zzmcVarZzY, zztsVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzad(int i, zztw zztwVar, final zztn zztnVar, final zzts zztsVar) {
        final zzmc zzmcVarZzY = zzY(i, zztwVar);
        zzW(zzmcVarZzY, 1002, new zzel() { // from class: com.google.android.gms.internal.ads.zzni
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzae(int i, zztw zztwVar, final zztn zztnVar, final zzts zztsVar) {
        final zzmc zzmcVarZzY = zzY(i, zztwVar);
        zzW(zzmcVarZzY, 1001, new zzel() { // from class: com.google.android.gms.internal.ads.zznm
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzaf(int i, zztw zztwVar, final zztn zztnVar, final zzts zztsVar, final IOException iOException, final boolean z) {
        final zzmc zzmcVarZzY = zzY(i, zztwVar);
        zzW(zzmcVarZzY, PointerIconCompat.TYPE_HELP, new zzel() { // from class: com.google.android.gms.internal.ads.zzmt
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zzj(zzmcVarZzY, zztnVar, zztsVar, iOException, z);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzag(int i, zztw zztwVar, final zztn zztnVar, final zzts zztsVar) {
        final zzmc zzmcVarZzY = zzY(i, zztwVar);
        zzW(zzmcVarZzY, 1000, new zzel() { // from class: com.google.android.gms.internal.ads.zzmk
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzb(final boolean z) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 3, new zzel(z) { // from class: com.google.android.gms.internal.ads.zzmi
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzc(final boolean z) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 7, new zzel(z) { // from class: com.google.android.gms.internal.ads.zzmx
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzd(final zzbp zzbpVar, final int i) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 1, new zzel(zzbpVar, i) { // from class: com.google.android.gms.internal.ads.zzmn
            public final /* synthetic */ zzbp zzb;

            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zze(final zzbv zzbvVar) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 14, new zzel() { // from class: com.google.android.gms.internal.ads.zzoa
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzf(final boolean z, final int i) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 5, new zzel(z, i) { // from class: com.google.android.gms.internal.ads.zzne
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzg(final zzcg zzcgVar) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 12, new zzel() { // from class: com.google.android.gms.internal.ads.zzmf
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzh(final int i) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 4, new zzel() { // from class: com.google.android.gms.internal.ads.zznl
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zzk(zzmcVarZzR, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzi(final int i) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 6, new zzel(i) { // from class: com.google.android.gms.internal.ads.zzna
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzj(final zzce zzceVar) {
        final zzmc zzmcVarZzab = zzab(zzceVar);
        zzW(zzmcVarZzab, 10, new zzel() { // from class: com.google.android.gms.internal.ads.zznj
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zzl(zzmcVarZzab, zzceVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzk(final zzce zzceVar) {
        final zzmc zzmcVarZzab = zzab(zzceVar);
        zzW(zzmcVarZzab, 10, new zzel() { // from class: com.google.android.gms.internal.ads.zznd
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzl(final boolean z, final int i) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, -1, new zzel(z, i) { // from class: com.google.android.gms.internal.ads.zzmv
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzn(final boolean z) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, 23, new zzel(z) { // from class: com.google.android.gms.internal.ads.zzmo
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzo(final int i, final int i2) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, 24, new zzel(i, i2) { // from class: com.google.android.gms.internal.ads.zznz
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzq(final zzdg zzdgVar) {
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 2, new zzel() { // from class: com.google.android.gms.internal.ads.zzmy
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzr(final zzdm zzdmVar) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, 25, new zzel() { // from class: com.google.android.gms.internal.ads.zznp
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                zzmc zzmcVar = zzmcVarZzaa;
                zzdm zzdmVar2 = zzdmVar;
                ((zzme) obj).zzq(zzmcVar, zzdmVar2);
                int i = zzdmVar2.zzc;
                int i2 = zzdmVar2.zzd;
                int i3 = zzdmVar2.zze;
                float f = zzdmVar2.zzf;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzs(final float f) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, 22, new zzel(f) { // from class: com.google.android.gms.internal.ads.zzmq
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzt(zzme zzmeVar) {
        this.zzf.zzb(zzmeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzu() {
        if (this.zzi) {
            return;
        }
        final zzmc zzmcVarZzR = zzR();
        this.zzi = true;
        zzW(zzmcVarZzR, -1, new zzel() { // from class: com.google.android.gms.internal.ads.zznq
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzv(final Exception exc) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, 1029, new zzel() { // from class: com.google.android.gms.internal.ads.zznw
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzw(final String str, final long j, final long j2) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_TEXT, new zzel(str, j2, j) { // from class: com.google.android.gms.internal.ads.zzmz
            public final /* synthetic */ String zzb;

            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzx(final String str) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_NO_DROP, new zzel() { // from class: com.google.android.gms.internal.ads.zzmj
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzy(final zzid zzidVar) {
        final zzmc zzmcVarZzZ = zzZ();
        zzW(zzmcVarZzZ, PointerIconCompat.TYPE_ALL_SCROLL, new zzel() { // from class: com.google.android.gms.internal.ads.zznk
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzz(final zzid zzidVar) {
        final zzmc zzmcVarZzaa = zzaa();
        zzW(zzmcVarZzaa, PointerIconCompat.TYPE_CROSSHAIR, new zzel() { // from class: com.google.android.gms.internal.ads.zzmh
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    private final zzmc zzX(zztw zztwVar) {
        Objects.requireNonNull(this.zzg);
        zzcv zzcvVarZza = zztwVar == null ? null : this.zzd.zza(zztwVar);
        if (zztwVar != null && zzcvVarZza != null) {
            return zzS(zzcvVarZza, zzcvVarZza.zzn(zztwVar.zza, this.zzb).zzd, zztwVar);
        }
        int iZzd = this.zzg.zzd();
        zzcv zzcvVarZzn = this.zzg.zzn();
        if (iZzd >= zzcvVarZzn.zzc()) {
            zzcvVarZzn = zzcv.zza;
        }
        return zzS(zzcvVarZzn, iZzd, null);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzQ(List list, zztw zztwVar) {
        zzco zzcoVar = this.zzg;
        Objects.requireNonNull(zzcoVar);
        this.zzd.zzh(list, zztwVar, zzcoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzm(final zzcn zzcnVar, final zzcn zzcnVar2, final int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zzob zzobVar = this.zzd;
        zzco zzcoVar = this.zzg;
        Objects.requireNonNull(zzcoVar);
        zzobVar.zzg(zzcoVar);
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 11, new zzel() { // from class: com.google.android.gms.internal.ads.zzns
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                ((zzme) obj).zzm(zzmcVarZzR, zzcnVar, zzcnVar2, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcl
    public final void zzp(zzcv zzcvVar, final int i) {
        zzco zzcoVar = this.zzg;
        Objects.requireNonNull(zzcoVar);
        this.zzd.zzi(zzcoVar);
        final zzmc zzmcVarZzR = zzR();
        zzW(zzmcVarZzR, 0, new zzel(i) { // from class: com.google.android.gms.internal.ads.zzmm
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
            }
        });
    }

    public zzoc(zzdy zzdyVar) {
        Objects.requireNonNull(zzdyVar);
        this.zza = zzdyVar;
        this.zzf = new zzeo(zzfk.zzw(), zzdyVar, new zzem() { // from class: com.google.android.gms.internal.ads.zznf
            @Override // com.google.android.gms.internal.ads.zzem
            public final void zza(Object obj, zzah zzahVar) {
            }
        });
        zzcs zzcsVar = new zzcs();
        this.zzb = zzcsVar;
        this.zzc = new zzcu();
        this.zzd = new zzob(zzcsVar);
        this.zze = new SparseArray();
    }
}
