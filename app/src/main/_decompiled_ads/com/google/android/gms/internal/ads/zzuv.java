package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzuv implements zzyi, zztl {
    final /* synthetic */ zzva zza;
    private final Uri zzc;
    private final zzhj zzd;
    private final zzup zze;
    private final zzabp zzf;
    private final zzea zzg;
    private volatile boolean zzi;
    private long zzk;
    private zzacs zzm;
    private boolean zzn;
    private final zzacj zzh = new zzacj();
    private boolean zzj = true;
    private final long zzb = zztn.zza();
    private zzgn zzl = zzi(0);

    public zzuv(zzva zzvaVar, Uri uri, zzgi zzgiVar, zzup zzupVar, zzabp zzabpVar, zzea zzeaVar) {
        this.zza = zzvaVar;
        this.zzc = uri;
        this.zzd = new zzhj(zzgiVar);
        this.zze = zzupVar;
        this.zzf = zzabpVar;
        this.zzg = zzeaVar;
    }

    static /* bridge */ /* synthetic */ void zzf(zzuv zzuvVar, long j, long j2) {
        zzuvVar.zzh.zza = j;
        zzuvVar.zzk = j2;
        zzuvVar.zzj = true;
        zzuvVar.zzn = false;
    }

    private final zzgn zzi(long j) {
        zzgl zzglVar = new zzgl();
        zzglVar.zzd(this.zzc);
        zzglVar.zzc(j);
        zzglVar.zza(6);
        zzglVar.zzb(zzva.zzb);
        return zzglVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:103:0x01fe  */
    @Override // com.google.android.gms.internal.ads.zzyi
    public final void zzh() throws Throwable {
        int i;
        int i2;
        zzup zzupVar;
        boolean z;
        int i3;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i4;
        zzt zztVar;
        int i5;
        int i6;
        int i7;
        while (!this.zzi) {
            try {
                long j = this.zzh.zza;
                zzgn zzgnVarZzi = zzi(j);
                this.zzl = zzgnVarZzi;
                long jZzb = this.zzd.zzb(zzgnVarZzi);
                if (jZzb != -1) {
                    jZzb += j;
                    zzva.zzC(this.zza);
                }
                long j2 = jZzb;
                zzva zzvaVar = this.zza;
                Map mapZze = this.zzd.zze();
                List list = (List) mapZze.get("icy-br");
                if (list != null) {
                    String str4 = (String) list.get(0);
                    try {
                        i7 = Integer.parseInt(str4) * 1000;
                        if (i7 > 0) {
                            i3 = i7;
                            z = true;
                        } else {
                            try {
                                zzer.zzf("IcyHeaders", "Invalid bitrate: " + str4);
                                z = false;
                                i3 = -1;
                            } catch (NumberFormatException unused) {
                                zzer.zzf("IcyHeaders", "Invalid bitrate header: ".concat(String.valueOf(str4)));
                                z = false;
                                i3 = i7;
                            }
                        }
                    } catch (NumberFormatException unused2) {
                        i7 = -1;
                    }
                } else {
                    z = false;
                    i3 = -1;
                }
                List list2 = (List) mapZze.get("icy-genre");
                if (list2 != null) {
                    str = (String) list2.get(0);
                    z = true;
                } else {
                    str = null;
                }
                List list3 = (List) mapZze.get("icy-name");
                if (list3 != null) {
                    str2 = (String) list3.get(0);
                    z = true;
                } else {
                    str2 = null;
                }
                List list4 = (List) mapZze.get("icy-url");
                if (list4 != null) {
                    str3 = (String) list4.get(0);
                    z = true;
                } else {
                    str3 = null;
                }
                List list5 = (List) mapZze.get("icy-pub");
                if (list5 != null) {
                    zEquals = ((String) list5.get(0)).equals("1");
                    z = true;
                } else {
                    zEquals = false;
                }
                List list6 = (List) mapZze.get("icy-metaint");
                if (list6 != null) {
                    String str5 = (String) list6.get(0);
                    try {
                        i6 = Integer.parseInt(str5);
                        if (i6 > 0) {
                            i4 = i6;
                            z = true;
                        } else {
                            try {
                                zzer.zzf("IcyHeaders", "Invalid metadata interval: " + str5);
                                i4 = -1;
                            } catch (NumberFormatException unused3) {
                                zzer.zzf("IcyHeaders", "Invalid metadata interval: ".concat(String.valueOf(str5)));
                                i4 = i6;
                            }
                        }
                    } catch (NumberFormatException unused4) {
                        i6 = -1;
                    }
                } else {
                    i4 = -1;
                }
                zzvaVar.zzs = z ? new zzaeq(i3, str, str2, str3, zEquals, i4) : null;
                zzhj zzhjVar = this.zzd;
                zzva zzvaVar2 = this.zza;
                if (zzvaVar2.zzs == null || zzvaVar2.zzs.zzf == -1) {
                    zztVar = zzhjVar;
                } else {
                    zztm zztmVar = new zztm(zzhjVar, zzvaVar2.zzs.zzf, this);
                    zzacs zzacsVarZzv = this.zza.zzv();
                    this.zzm = zzacsVarZzv;
                    zzacsVarZzv.zzl(zzva.zzc);
                    zztVar = zztmVar;
                }
                try {
                    this.zze.zzd(zztVar, this.zzc, this.zzd.zze(), j, j2, this.zzf);
                    if (this.zza.zzs != null) {
                        this.zze.zzc();
                    }
                    if (this.zzj) {
                        this.zze.zzf(j, this.zzk);
                        i = 0;
                        try {
                            this.zzj = false;
                        } catch (Throwable th) {
                            th = th;
                            i2 = i;
                            if (i2 != 1) {
                                zzupVar = this.zze;
                                if (zzupVar.zzb() != -1) {
                                    this.zzh.zza = zzupVar.zzb();
                                }
                            }
                            zzgk.zza(this.zzd);
                            throw th;
                        }
                    } else {
                        i = 0;
                    }
                    long j3 = j;
                    int iZza = i;
                    while (iZza == 0) {
                        try {
                            if (this.zzi) {
                                iZza = i;
                                break;
                            }
                            try {
                                this.zzg.zza();
                                iZza = this.zze.zza(this.zzh);
                                long jZzb2 = this.zze.zzb();
                                if (jZzb2 > this.zza.zzj + j3) {
                                    this.zzg.zzc();
                                    zzva zzvaVar3 = this.zza;
                                    zzvaVar3.zzp.post(zzvaVar3.zzo);
                                    j3 = jZzb2;
                                }
                            } catch (InterruptedException unused5) {
                                throw new InterruptedIOException();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            i2 = iZza;
                            if (i2 != 1) {
                                zzupVar = this.zze;
                                if (zzupVar.zzb() != -1) {
                                    this.zzh.zza = zzupVar.zzb();
                                }
                            }
                            zzgk.zza(this.zzd);
                            throw th;
                        }
                    }
                    if (iZza == 1) {
                        i5 = i;
                    } else {
                        zzup zzupVar2 = this.zze;
                        if (zzupVar2.zzb() != -1) {
                            this.zzh.zza = zzupVar2.zzb();
                        }
                        i5 = iZza;
                    }
                    zzgk.zza(this.zzd);
                    if (i5 != 0) {
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    i = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                i = 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zztl
    public final void zza(zzfb zzfbVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(zzva.zzr(this.zza, true), this.zzk);
        int iZza = zzfbVar.zza();
        zzacs zzacsVar = this.zzm;
        Objects.requireNonNull(zzacsVar);
        zzacq.zzb(zzacsVar, zzfbVar, iZza);
        zzacsVar.zzt(jMax, 1, iZza, 0, null);
        this.zzn = true;
    }
}
