package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeip {
    private final zzfed zza;
    private final zzdqg zzb;
    private final zzdso zzc;
    private final zzfib zzd;

    public zzeip(zzfed zzfedVar, zzdqg zzdqgVar, zzdso zzdsoVar, zzfib zzfibVar) {
        this.zza = zzfedVar;
        this.zzb = zzdqgVar;
        this.zzc = zzdsoVar;
        this.zzd = zzfibVar;
    }

    public final void zza(zzfcv zzfcvVar, zzfcr zzfcrVar, int i, @Nullable zzeey zzeeyVar, long j) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzir)).booleanValue()) {
            zzfia zzfiaVarZzb = zzfia.zzb("adapter_status");
            zzfiaVarZzb.zzg(zzfcvVar);
            zzfiaVarZzb.zzf(zzfcrVar);
            zzfiaVarZzb.zza("adapter_l", String.valueOf(j));
            zzfiaVarZzb.zza("sc", Integer.toString(i));
            if (zzeeyVar != null) {
                zzfiaVarZzb.zza("arec", Integer.toString(zzeeyVar.zzb().zza));
                String strZza = this.zza.zza(zzeeyVar.getMessage());
                if (strZza != null) {
                    zzfiaVarZzb.zza("areec", strZza);
                }
            }
            zzdqf zzdqfVarZzb = this.zzb.zzb(zzfcrVar.zzv);
            if (zzdqfVarZzb != null) {
                zzfiaVarZzb.zza("ancn", zzdqfVarZzb.zza);
                zzbrj zzbrjVar = zzdqfVarZzb.zzb;
                if (zzbrjVar != null) {
                    zzfiaVarZzb.zza("adapter_v", zzbrjVar.toString());
                }
                zzbrj zzbrjVar2 = zzdqfVarZzb.zzc;
                if (zzbrjVar2 != null) {
                    zzfiaVarZzb.zza("adapter_sv", zzbrjVar2.toString());
                }
            }
            this.zzd.zzb(zzfiaVarZzb);
            return;
        }
        zzdsn zzdsnVarZza = this.zzc.zza();
        zzdsnVarZza.zze(zzfcvVar);
        zzdsnVarZza.zzd(zzfcrVar);
        zzdsnVarZza.zzb("action", "adapter_status");
        zzdsnVarZza.zzb("adapter_l", String.valueOf(j));
        zzdsnVarZza.zzb("sc", Integer.toString(i));
        if (zzeeyVar != null) {
            zzdsnVarZza.zzb("arec", Integer.toString(zzeeyVar.zzb().zza));
            String strZza2 = this.zza.zza(zzeeyVar.getMessage());
            if (strZza2 != null) {
                zzdsnVarZza.zzb("areec", strZza2);
            }
        }
        zzdqf zzdqfVarZzb2 = this.zzb.zzb(zzfcrVar.zzv);
        if (zzdqfVarZzb2 != null) {
            zzdsnVarZza.zzb("ancn", zzdqfVarZzb2.zza);
            zzbrj zzbrjVar3 = zzdqfVarZzb2.zzb;
            if (zzbrjVar3 != null) {
                zzdsnVarZza.zzb("adapter_v", zzbrjVar3.toString());
            }
            zzbrj zzbrjVar4 = zzdqfVarZzb2.zzc;
            if (zzbrjVar4 != null) {
                zzdsnVarZza.zzb("adapter_sv", zzbrjVar4.toString());
            }
        }
        zzdsnVarZza.zzg();
    }
}
