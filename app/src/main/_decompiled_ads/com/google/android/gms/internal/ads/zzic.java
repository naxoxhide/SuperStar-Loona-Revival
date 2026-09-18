package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzic implements zzlr, zzlt {
    private final int zzb;
    private zzlu zzd;
    private int zze;
    private zzol zzf;
    private zzdy zzg;
    private int zzh;
    private zzvo zzi;
    private zzam[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;
    private zzls zzp;
    private final Object zza = new Object();
    private final zzkn zzc = new zzkn();
    private long zzm = Long.MIN_VALUE;

    public zzic(int i) {
        this.zzb = i;
    }

    private final void zzW(long j, boolean z) throws zzil {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzy(j, z);
    }

    protected void zzA() {
    }

    protected void zzB() throws zzil {
    }

    protected void zzC() {
    }

    protected void zzD(zzam[] zzamVarArr, long j, long j2) throws zzil {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzE() {
        zzdx.zzf(this.zzh == 0);
        zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzF(zzam[] zzamVarArr, zzvo zzvoVar, long j, long j2) throws zzil {
        zzdx.zzf(!this.zzn);
        this.zzi = zzvoVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzamVarArr;
        this.zzk = j2;
        zzD(zzamVarArr, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzG() {
        zzdx.zzf(this.zzh == 0);
        zzkn zzknVar = this.zzc;
        zzknVar.zzb = null;
        zzknVar.zza = null;
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzH(long j) throws zzil {
        zzW(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzI() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlt
    public final void zzJ(zzls zzlsVar) {
        synchronized (this.zza) {
            this.zzp = zzlsVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public /* synthetic */ void zzK(float f, float f2) {
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzL() throws zzil {
        zzdx.zzf(this.zzh == 1);
        this.zzh = 2;
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzM() {
        zzdx.zzf(this.zzh == 2);
        this.zzh = 1;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final boolean zzN() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final boolean zzO() {
        return this.zzn;
    }

    protected final zzam[] zzQ() {
        zzam[] zzamVarArr = this.zzj;
        Objects.requireNonNull(zzamVarArr);
        return zzamVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzlr, com.google.android.gms.internal.ads.zzlt
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final int zzbc() {
        return this.zzh;
    }

    protected final int zzbd(zzkn zzknVar, zzht zzhtVar, int i) {
        zzvo zzvoVar = this.zzi;
        Objects.requireNonNull(zzvoVar);
        int iZza = zzvoVar.zza(zzknVar, zzhtVar, i);
        if (iZza == -4) {
            if (zzhtVar.zzf()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzhtVar.zze + this.zzk;
            zzhtVar.zze = j;
            this.zzm = Math.max(this.zzm, j);
        } else if (iZza == -5) {
            zzam zzamVar = zzknVar.zza;
            Objects.requireNonNull(zzamVar);
            long j2 = zzamVar.zzq;
            if (j2 != Long.MAX_VALUE) {
                zzak zzakVarZzb = zzamVar.zzb();
                zzakVarZzb.zzY(j2 + this.zzk);
                zzknVar.zza = zzakVarZzb.zzac();
                return -5;
            }
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final long zzbe() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzlt
    public int zze() throws zzil {
        return 0;
    }

    protected final long zzf() {
        return this.zzl;
    }

    protected final zzdy zzh() {
        zzdy zzdyVar = this.zzg;
        Objects.requireNonNull(zzdyVar);
        return zzdyVar;
    }

    protected final zzil zzi(Throwable th, zzam zzamVar, boolean z, int i) {
        int iZzV = 4;
        if (zzamVar != null && !this.zzo) {
            this.zzo = true;
            try {
                iZzV = zzV(zzamVar) & 7;
            } catch (zzil unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzil.zzb(th, zzR(), this.zze, zzamVar, iZzV, z, i);
    }

    protected final zzkn zzj() {
        zzkn zzknVar = this.zzc;
        zzknVar.zzb = null;
        zzknVar.zza = null;
        return zzknVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public zzkt zzk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final zzlt zzl() {
        return this;
    }

    protected final zzlu zzm() {
        zzlu zzluVar = this.zzd;
        Objects.requireNonNull(zzluVar);
        return zzluVar;
    }

    protected final zzol zzn() {
        zzol zzolVar = this.zzf;
        Objects.requireNonNull(zzolVar);
        return zzolVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final zzvo zzo() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzlt
    public final void zzp() {
        synchronized (this.zza) {
            this.zzp = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzq() {
        zzdx.zzf(this.zzh == 1);
        zzkn zzknVar = this.zzc;
        zzknVar.zzb = null;
        zzknVar.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzr(zzlu zzluVar, zzam[] zzamVarArr, zzvo zzvoVar, long j, boolean z, boolean z2, long j2, long j3) throws zzil {
        zzdx.zzf(this.zzh == 0);
        this.zzd = zzluVar;
        this.zzh = 1;
        zzx(z, z2);
        zzF(zzamVarArr, zzvoVar, j2, j3);
        zzW(j2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public /* synthetic */ void zzs() {
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public void zzt(int i, Object obj) throws zzil {
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzu(int i, zzol zzolVar, zzdy zzdyVar) {
        this.zze = i;
        this.zzf = zzolVar;
        this.zzg = zzdyVar;
    }

    protected void zzw() {
        throw null;
    }

    protected void zzx(boolean z, boolean z2) throws zzil {
    }

    protected void zzy(long j, boolean z) throws zzil {
        throw null;
    }

    protected void zzz() {
    }

    protected final boolean zzP() {
        if (zzN()) {
            return this.zzn;
        }
        zzvo zzvoVar = this.zzi;
        Objects.requireNonNull(zzvoVar);
        return zzvoVar.zze();
    }

    protected final int zzd(long j) {
        zzvo zzvoVar = this.zzi;
        Objects.requireNonNull(zzvoVar);
        return zzvoVar.zzb(j - this.zzk);
    }

    @Override // com.google.android.gms.internal.ads.zzlr
    public final void zzv() throws IOException {
        zzvo zzvoVar = this.zzi;
        Objects.requireNonNull(zzvoVar);
        zzvoVar.zzd();
    }
}
