package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvn implements zzgwc {
    private final zzgvj zza;
    private final zzgwt zzb;
    private final boolean zzc;
    private final zzgtm zzd;

    private zzgvn(zzgwt zzgwtVar, zzgtm zzgtmVar, zzgvj zzgvjVar) {
        this.zzb = zzgwtVar;
        this.zzc = zzgtmVar.zzh(zzgvjVar);
        this.zzd = zzgtmVar;
        this.zza = zzgvjVar;
    }

    static zzgvn zzc(zzgwt zzgwtVar, zzgtm zzgtmVar, zzgvj zzgvjVar) {
        return new zzgvn(zzgwtVar, zzgtmVar, zzgvjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final int zza(Object obj) {
        zzgwt zzgwtVar = this.zzb;
        int iZzb = zzgwtVar.zzb(zzgwtVar.zzd(obj));
        if (!this.zzc) {
            return iZzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return iHashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final Object zze() {
        zzgvj zzgvjVar = this.zza;
        return zzgvjVar instanceof zzgtz ? ((zzgtz) zzgvjVar).zzaD() : zzgvjVar.zzaP().zzan();
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzg(Object obj, Object obj2) {
        zzgwe.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzh(Object obj, zzgvu zzgvuVar, zzgtl zzgtlVar) throws IOException {
        boolean zZzO;
        zzgwt zzgwtVar = this.zzb;
        Object objZzc = zzgwtVar.zzc(obj);
        zzgtm zzgtmVar = this.zzd;
        zzgtq zzgtqVarZzb = zzgtmVar.zzb(obj);
        while (zzgvuVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzgvuVar.zzd();
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZzc2 = zzgtmVar.zzc(zzgtlVar, this.zza, iZzd >>> 3);
                        if (objZzc2 != null) {
                            zzgtmVar.zzf(zzgvuVar, objZzc2, zzgtlVar, zzgtqVarZzb);
                        } else {
                            zZzO = zzgwtVar.zzp(objZzc, zzgvuVar);
                        }
                    } else {
                        zZzO = zzgvuVar.zzO();
                    }
                    if (!zZzO) {
                        zzgwtVar.zzn(obj, objZzc);
                        return;
                    }
                } else {
                    int iZzj = 0;
                    Object objZzc3 = null;
                    zzgsr zzgsrVarZzp = null;
                    while (zzgvuVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzgvuVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzgvuVar.zzj();
                            objZzc3 = zzgtmVar.zzc(zzgtlVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZzc3 != null) {
                                zzgtmVar.zzf(zzgvuVar, objZzc3, zzgtlVar, zzgtqVarZzb);
                            } else {
                                zzgsrVarZzp = zzgvuVar.zzp();
                            }
                        } else if (!zzgvuVar.zzO()) {
                            break;
                        }
                    }
                    if (zzgvuVar.zzd() != 12) {
                        throw zzgul.zzb();
                    }
                    if (zzgsrVarZzp != null) {
                        if (objZzc3 != null) {
                            zzgtmVar.zzg(zzgsrVarZzp, objZzc3, zzgtlVar, zzgtqVarZzb);
                        } else {
                            zzgwtVar.zzk(objZzc, iZzj, zzgsrVarZzp);
                        }
                    }
                }
            } catch (Throwable th) {
                zzgwtVar.zzn(obj, objZzc);
                throw th;
            }
        }
        zzgwtVar.zzn(obj, objZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgsd zzgsdVar) throws IOException {
        zzgtz zzgtzVar = (zzgtz) obj;
        if (zzgtzVar.zzc == zzgwu.zzc()) {
            zzgtzVar.zzc = zzgwu.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final boolean zzj(Object obj, Object obj2) {
        zzgwt zzgwtVar = this.zzb;
        if (!zzgwtVar.zzd(obj).equals(zzgwtVar.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzm(Object obj, zzgth zzgthVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
