package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzecx implements zzfhs {
    private final zzecl zza;
    private final zzecp zzb;

    zzecx(zzecl zzeclVar, zzecp zzecpVar) {
        this.zza = zzeclVar;
        this.zzb = zzecpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzbG(zzfhl zzfhlVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzbH(zzfhl zzfhlVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgf)).booleanValue() && zzfhl.RENDERER == zzfhlVar && this.zza.zzc() != 0) {
            this.zza.zzf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzbI(zzfhl zzfhlVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgf)).booleanValue()) {
            if (zzfhl.RENDERER == zzfhlVar) {
                this.zza.zzg(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime());
                return;
            }
            if (zzfhl.PRELOADED_LOADER == zzfhlVar || zzfhl.SERVER_TRANSACTION == zzfhlVar) {
                this.zza.zzh(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime());
                final zzecp zzecpVar = this.zzb;
                final long jZzd = this.zza.zzd();
                zzecpVar.zza.zza(new zzfgu() { // from class: com.google.android.gms.internal.ads.zzeco
                    @Override // com.google.android.gms.internal.ads.zzfgu
                    public final Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzecpVar.zzf()) {
                            return null;
                        }
                        long j = jZzd;
                        zzbad zzbadVarZzg = zzbae.zzg();
                        zzbadVarZzg.zzh(j);
                        byte[] bArrZzax = ((zzbae) zzbadVarZzg.zzal()).zzax();
                        zzecw.zzg(sQLiteDatabase, false, false);
                        zzecw.zzd(sQLiteDatabase, j, bArrZzax);
                        return null;
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zzd(zzfhl zzfhlVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgf)).booleanValue() && zzfhl.RENDERER == zzfhlVar && this.zza.zzc() != 0) {
            this.zza.zzf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }
}
