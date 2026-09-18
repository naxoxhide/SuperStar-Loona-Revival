package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcet extends zzcen implements zzhk {
    private String zzd;
    private final zzcdb zze;
    private boolean zzf;
    private final zzces zzg;
    private final zzcdy zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk;
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcet(zzcdc zzcdcVar, zzcdb zzcdbVar) {
        super(zzcdcVar);
        this.zze = zzcdbVar;
        this.zzg = new zzces();
        this.zzh = new zzcdy();
        this.zzk = new Object();
        this.zzl = (String) zzfss.zzd(zzcdcVar != null ? zzcdcVar.zzbl() : null).zzb("");
        this.zzm = zzcdcVar != null ? zzcdcVar.zzf() : 0;
    }

    protected static final String zzm(String str) {
        return "cache:".concat(String.valueOf(zzcam.zze(str)));
    }

    private final void zzv() {
        int iZza = (int) this.zzg.zza();
        int iZza2 = (int) this.zzh.zza(this.zzi);
        int iPosition = this.zzi.position();
        int iRound = Math.round(iZza2 * (iPosition / iZza));
        int iZzs = zzcct.zzs();
        int iZzu = zzcct.zzu();
        String str = this.zzd;
        zzn(str, zzm(str), iPosition, iZza, iRound, iZza2, iRound > 0, iZzs, iZzu);
    }

    @Override // com.google.android.gms.internal.ads.zzhk
    public final void zza(zzgi zzgiVar, zzgn zzgnVar, boolean z, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzhk
    public final void zzb(zzgi zzgiVar, zzgn zzgnVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhk
    public final void zzc(zzgi zzgiVar, zzgn zzgnVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhk
    public final void zzd(zzgi zzgiVar, zzgn zzgnVar, boolean z) {
        if (zzgiVar instanceof zzgv) {
            this.zzg.zzb((zzgv) zzgiVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcen
    public final void zzf() {
        this.zzf = true;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final ByteBuffer zzk() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }

    public final boolean zzl() {
        return this.zzn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:? -> B:45:0x0142). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzcen
    public final boolean zzt(String str) throws Throwable {
        String str2;
        this.zzd = str;
        String str3 = "error";
        String strZzm = zzm(str);
        int i = 0;
        try {
            zzgq zzgqVar = new zzgq();
            zzgqVar.zzf(this.zzb);
            zzgqVar.zzc(this.zze.zzd);
            zzgqVar.zzd(this.zze.zzf);
            zzgqVar.zzb(true);
            zzgqVar.zze(this);
            zzgi zzgiVarZza = zzgqVar.zza();
            if (this.zze.zzj) {
                zzgiVarZza = new zzcdw(this.zza, zzgiVarZza, this.zzl, this.zzm, null, null);
            }
            zzgiVarZza.zzb(new zzgn(Uri.parse(str)));
            zzcdc zzcdcVar = (zzcdc) this.zzc.get();
            if (zzcdcVar != null) {
                zzcdcVar.zzt(strZzm, this);
            }
            Clock clockZzB = com.google.android.gms.ads.internal.zzt.zzB();
            long jCurrentTimeMillis = clockZzB.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzy)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzx)).longValue();
            this.zzi = ByteBuffer.allocate(this.zze.zzc);
            int i2 = 8192;
            byte[] bArr = new byte[8192];
            long j = jCurrentTimeMillis;
            while (true) {
                int iZza = zzgiVarZza.zza(bArr, i, Math.min(this.zzi.remaining(), i2));
                if (iZza == -1) {
                    this.zzn = true;
                    zzj(str, strZzm, (int) this.zzh.zza(this.zzi));
                    break;
                }
                synchronized (this.zzk) {
                    try {
                        if (!this.zzf) {
                            try {
                                this.zzi.put(bArr, 0, iZza);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.zzi.remaining() <= 0) {
                                zzv();
                                break;
                            }
                            str2 = 1;
                            try {
                                if (this.zzf) {
                                    throw new IOException("Precache abort at " + this.zzi.limit() + " bytes");
                                }
                                long jCurrentTimeMillis2 = clockZzB.currentTimeMillis();
                                if (jCurrentTimeMillis2 - j >= jLongValue) {
                                    zzv();
                                    j = jCurrentTimeMillis2;
                                }
                                if (jCurrentTimeMillis2 - jCurrentTimeMillis > 1000 * jLongValue2) {
                                    throw new IOException("Timeout exceeded. Limit: " + jLongValue2 + " sec");
                                }
                                str3 = str3;
                                i = 0;
                                i2 = 8192;
                            } catch (Exception e) {
                                e = e;
                                String str4 = e.getClass().getCanonicalName() + CertificateUtil.DELIMITER + e.getMessage();
                                zzcat.zzj("Failed to preload url " + str + " Exception: " + str4);
                                zzg(str, strZzm, str2, str4);
                                return false;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str2 = str3;
                            String str5 = e.getClass().getCanonicalName() + CertificateUtil.DELIMITER + e.getMessage();
                            zzcat.zzj("Failed to preload url " + str + " Exception: " + str5);
                            zzg(str, strZzm, str2, str5);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
            return true;
        } catch (Exception e3) {
            e = e3;
            str3 = str3;
        }
    }
}
