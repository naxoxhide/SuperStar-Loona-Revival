package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzect extends zzecu {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcwp zzd;
    private final TelephonyManager zze;
    private final zzecl zzf;
    private int zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbai.CONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbai.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbai.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbai.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbai.DISCONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbai.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbai.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbai.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbai.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbai.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbai.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbai.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbai.CONNECTING);
    }

    zzect(Context context, zzcwp zzcwpVar, zzecl zzeclVar, zzech zzechVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzechVar, zzgVar);
        this.zzc = context;
        this.zzd = zzcwpVar;
        this.zzf = zzeclVar;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    static /* bridge */ /* synthetic */ zzazz zza(zzect zzectVar, Bundle bundle) {
        zzazs zzazsVarZza = zzazz.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        int i3 = 2;
        if (i == -1) {
            zzectVar.zzg = 2;
        } else {
            zzectVar.zzg = 1;
            if (i == 0) {
                zzazsVarZza.zzb(2);
            } else if (i != 1) {
                zzazsVarZza.zzb(1);
            } else {
                zzazsVarZza.zzb(3);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    i3 = 3;
                    break;
                case 13:
                    i3 = 5;
                    break;
                default:
                    i3 = 1;
                    break;
            }
            zzazsVarZza.zza(i3);
        }
        return (zzazz) zzazsVarZza.zzal();
    }

    static /* bridge */ /* synthetic */ zzbai zzb(zzect zzectVar, Bundle bundle) {
        return (zzbai) zzb.get(zzfdz.zza(zzfdz.zza(bundle, DeviceRequestsHelper.DEVICE_INFO_DEVICE), "network").getInt("active_network_state", -1), zzbai.UNSPECIFIED);
    }

    static /* bridge */ /* synthetic */ byte[] zze(zzect zzectVar, boolean z, ArrayList arrayList, zzazz zzazzVar, zzbai zzbaiVar) {
        zzbad zzbadVarZzg = zzbae.zzg();
        zzbadVarZzg.zza(arrayList);
        zzbadVarZzg.zzi(zzg(Settings.Global.getInt(zzectVar.zzc.getContentResolver(), "airplane_mode_on", 0) != 0));
        zzbadVarZzg.zzj(com.google.android.gms.ads.internal.zzt.zzq().zzj(zzectVar.zzc, zzectVar.zze));
        zzbadVarZzg.zzf(zzectVar.zzf.zze());
        zzbadVarZzg.zze(zzectVar.zzf.zzb());
        zzbadVarZzg.zzb(zzectVar.zzf.zza());
        zzbadVarZzg.zzc(zzbaiVar);
        zzbadVarZzg.zzd(zzazzVar);
        zzbadVarZzg.zzk(zzectVar.zzg);
        zzbadVarZzg.zzl(zzg(z));
        zzbadVarZzg.zzh(zzectVar.zzf.zzd());
        zzbadVarZzg.zzg(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
        zzbadVarZzg.zzm(zzg(Settings.Global.getInt(zzectVar.zzc.getContentResolver(), "wifi_on", 0) != 0));
        return ((zzbae) zzbadVarZzg.zzal()).zzax();
    }

    private static final int zzg(boolean z) {
        return z ? 2 : 1;
    }

    public final void zzd(boolean z) {
        zzfzt.zzr(this.zzd.zzb(), new zzecs(this, z), zzcbg.zzf);
    }
}
