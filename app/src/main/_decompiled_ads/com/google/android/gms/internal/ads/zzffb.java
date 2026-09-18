package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzffb implements zzffa {
    private final ConcurrentHashMap zza;
    private final zzffh zzb;
    private final zzffd zzc = new zzffd();

    public zzffb(zzffh zzffhVar) {
        this.zza = new ConcurrentHashMap(zzffhVar.zzd);
        this.zzb = zzffhVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzffh> creator = zzffh.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgo)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzffk) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfez) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int iZzb = ((zzfez) entry.getValue()).zzb(); iZzb < this.zzb.zzd; iZzb++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfez) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzcat.zze(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzffa
    public final zzffh zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzffa
    public final synchronized zzffj zzb(zzffk zzffkVar) {
        zzffj zzffjVarZze;
        zzfez zzfezVar = (zzfez) this.zza.get(zzffkVar);
        if (zzfezVar != null) {
            zzffjVarZze = zzfezVar.zze();
            if (zzffjVarZze == null) {
                this.zzc.zze();
            }
            zzffx zzffxVarZzf = zzfezVar.zzf();
            if (zzffjVarZze != null) {
                zzayk zzaykVarZza = zzayq.zza();
                zzayi zzayiVarZza = zzayj.zza();
                zzayiVarZza.zzd(2);
                zzaym zzaymVarZza = zzayn.zza();
                zzaymVarZza.zza(zzffxVarZzf.zza);
                zzaymVarZza.zzb(zzffxVarZzf.zzb);
                zzayiVarZza.zza(zzaymVarZza);
                zzaykVarZza.zza(zzayiVarZza);
                zzffjVarZze.zza.zzb().zzc().zzi((zzayq) zzaykVarZza.zzal());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzffjVarZze = null;
        }
        return zzffjVarZze;
    }

    @Override // com.google.android.gms.internal.ads.zzffa
    @Deprecated
    public final zzffk zzc(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, com.google.android.gms.ads.internal.client.zzw zzwVar) {
        return new zzffl(zzlVar, str, new zzbvk(this.zzb.zza).zza().zzk, this.zzb.zzf, zzwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzffa
    public final synchronized boolean zzd(zzffk zzffkVar, zzffj zzffjVar) {
        boolean zZzh;
        zzfez zzfezVar = (zzfez) this.zza.get(zzffkVar);
        zzffjVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        if (zzfezVar == null) {
            zzffh zzffhVar = this.zzb;
            zzfez zzfezVar2 = new zzfez(zzffhVar.zzd, zzffhVar.zze * 1000);
            if (this.zza.size() == this.zzb.zzc) {
                int i = this.zzb.zzg;
                int i2 = i - 1;
                zzffk zzffkVar2 = null;
                if (i == 0) {
                    throw null;
                }
                long jZzc = Long.MAX_VALUE;
                if (i2 == 0) {
                    for (Map.Entry entry : this.zza.entrySet()) {
                        if (((zzfez) entry.getValue()).zzc() < jZzc) {
                            jZzc = ((zzfez) entry.getValue()).zzc();
                            zzffkVar2 = (zzffk) entry.getKey();
                        }
                    }
                    if (zzffkVar2 != null) {
                        this.zza.remove(zzffkVar2);
                    }
                } else if (i2 == 1) {
                    for (Map.Entry entry2 : this.zza.entrySet()) {
                        if (((zzfez) entry2.getValue()).zzd() < jZzc) {
                            jZzc = ((zzfez) entry2.getValue()).zzd();
                            zzffkVar2 = (zzffk) entry2.getKey();
                        }
                    }
                    if (zzffkVar2 != null) {
                        this.zza.remove(zzffkVar2);
                    }
                } else if (i2 == 2) {
                    int iZza = Integer.MAX_VALUE;
                    for (Map.Entry entry3 : this.zza.entrySet()) {
                        if (((zzfez) entry3.getValue()).zza() < iZza) {
                            iZza = ((zzfez) entry3.getValue()).zza();
                            zzffkVar2 = (zzffk) entry3.getKey();
                        }
                    }
                    if (zzffkVar2 != null) {
                        this.zza.remove(zzffkVar2);
                    }
                }
                this.zzc.zzg();
            }
            this.zza.put(zzffkVar, zzfezVar2);
            this.zzc.zzd();
            zzfezVar = zzfezVar2;
        }
        zZzh = zzfezVar.zzh(zzffjVar);
        this.zzc.zzc();
        zzffc zzffcVarZza = this.zzc.zza();
        zzffx zzffxVarZzf = zzfezVar.zzf();
        if (zzffjVar != null) {
            zzayk zzaykVarZza = zzayq.zza();
            zzayi zzayiVarZza = zzayj.zza();
            zzayiVarZza.zzd(2);
            zzayo zzayoVarZza = zzayp.zza();
            zzayoVarZza.zza(zzffcVarZza.zza);
            zzayoVarZza.zzb(zzffcVarZza.zzb);
            zzayoVarZza.zzc(zzffxVarZzf.zzb);
            zzayiVarZza.zzc(zzayoVarZza);
            zzaykVarZza.zza(zzayiVarZza);
            zzffjVar.zza.zzb().zzc().zzj((zzayq) zzaykVarZza.zzal());
        }
        zzf();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzffa
    public final synchronized boolean zze(zzffk zzffkVar) {
        zzfez zzfezVar = (zzfez) this.zza.get(zzffkVar);
        if (zzfezVar != null) {
            return zzfezVar.zzb() < this.zzb.zzd;
        }
        return true;
    }
}
