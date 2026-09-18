package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfjt {
    private final zzeio zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfdf zzf;
    private final zzfdg zzg;
    private final Clock zzh;
    private final zzaro zzi;

    public zzfjt(zzeio zzeioVar, zzcaz zzcazVar, String str, String str2, Context context, zzfdf zzfdfVar, zzfdg zzfdgVar, Clock clock, zzaro zzaroVar) {
        this.zza = zzeioVar;
        this.zzb = zzcazVar.zza;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfdfVar;
        this.zzg = zzfdgVar;
        this.zzh = clock;
        this.zzi = zzaroVar;
    }

    public static final List zzf(int i, int i2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_mpe@", "2." + i2));
        }
        return arrayList;
    }

    public static final List zzg(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_adnetstatus@", str));
        }
        return arrayList;
    }

    public static final List zzh(List list, long j) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_ttr@", Long.toString(j, 10)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzi(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return zzcas.zzk() ? "fakeForAdDebugLog" : str;
    }

    private static String zzj(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final List zzc(zzfde zzfdeVar, zzfcr zzfcrVar, List list) {
        return zzd(zzfdeVar, zzfcrVar, false, "", "", list);
    }

    public final List zzd(zzfde zzfdeVar, zzfcr zzfcrVar, boolean z, String str, String str2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z2 = true;
            String strZzj = zzj(zzj(zzj((String) it.next(), "@gw_adlocid@", zzfdeVar.zza.zza.zzf), "@gw_adnetrefresh@", true != z ? "0" : "1"), "@gw_sdkver@", this.zzb);
            if (zzfcrVar != null) {
                strZzj = zzbza.zzc(zzj(zzj(zzj(strZzj, "@gw_qdata@", zzfcrVar.zzA), "@gw_adnetid@", zzfcrVar.zzz), "@gw_allocid@", zzfcrVar.zzy), this.zze, zzfcrVar.zzY);
            }
            String strZzj2 = zzj(zzj(zzj(zzj(strZzj, "@gw_adnetstatus@", this.zza.zzg()), "@gw_ttr@", Long.toString(this.zza.zza(), 10)), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z3 = false;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdm)).booleanValue() && !TextUtils.isEmpty(str)) {
                z3 = true;
            }
            boolean z4 = !TextUtils.isEmpty(str2);
            if (z3) {
                z2 = z4;
            } else {
                if (z4) {
                }
                arrayList.add(strZzj2);
            }
            if (this.zzi.zzf(Uri.parse(strZzj2))) {
                Uri.Builder builderBuildUpon = Uri.parse(strZzj2).buildUpon();
                if (z3) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("ms", str);
                }
                if (z2) {
                    builderBuildUpon = builderBuildUpon.appendQueryParameter("attok", str2);
                }
                strZzj2 = builderBuildUpon.build().toString();
            }
            arrayList.add(strZzj2);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005f A[LOOP:0: B:13:0x0059->B:15:0x005f, LOOP_END] */
    public final List zze(zzfcr zzfcrVar, List list, zzbvw zzbvwVar) {
        zzfdf zzfdfVar;
        zzfss zzfssVarZzd;
        String str;
        String str2;
        Iterator it;
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = this.zzh.currentTimeMillis();
        try {
            String strZzc = zzbvwVar.zzc();
            String string = Integer.toString(zzbvwVar.zzb());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdn)).booleanValue()) {
                zzfdg zzfdgVar = this.zzg;
                if (zzfdgVar == null) {
                    zzfssVarZzd = zzfss.zzc();
                } else {
                    zzfdfVar = zzfdgVar.zza;
                }
                str = (String) zzfssVarZzd.zza(new zzfsk() { // from class: com.google.android.gms.internal.ads.zzfjr
                    @Override // com.google.android.gms.internal.ads.zzfsk
                    public final Object apply(Object obj) {
                        return zzfjt.zzi(((zzfdf) obj).zza);
                    }
                }).zzb("");
                str2 = (String) zzfssVarZzd.zza(new zzfsk() { // from class: com.google.android.gms.internal.ads.zzfjs
                    @Override // com.google.android.gms.internal.ads.zzfsk
                    public final Object apply(Object obj) {
                        return zzfjt.zzi(((zzfdf) obj).zzb);
                    }
                }).zzb("");
                it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(zzbza.zzc(zzj(zzj(zzj(zzj(zzj(zzj((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(strZzc)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzb), this.zze, zzfcrVar.zzY));
                }
                return arrayList;
            }
            zzfdfVar = this.zzf;
            zzfssVarZzd = zzfss.zzd(zzfdfVar);
            str = (String) zzfssVarZzd.zza(new zzfsk() { // from class: com.google.android.gms.internal.ads.zzfjr
                @Override // com.google.android.gms.internal.ads.zzfsk
                public final Object apply(Object obj) {
                    return zzfjt.zzi(((zzfdf) obj).zza);
                }
            }).zzb("");
            str2 = (String) zzfssVarZzd.zza(new zzfsk() { // from class: com.google.android.gms.internal.ads.zzfjs
                @Override // com.google.android.gms.internal.ads.zzfsk
                public final Object apply(Object obj) {
                    return zzfjt.zzi(((zzfdf) obj).zzb);
                }
            }).zzb("");
            it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzbza.zzc(zzj(zzj(zzj(zzj(zzj(zzj((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(strZzc)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzb), this.zze, zzfcrVar.zzY));
            }
            return arrayList;
        } catch (RemoteException e) {
            zzcat.zzh("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }
}
