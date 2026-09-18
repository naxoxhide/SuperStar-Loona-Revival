package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdvh {
    private final zzdur zza;
    private final zzdqg zzb;
    private final Object zzc = new Object();
    private final List zzd = new ArrayList();
    private boolean zze;

    zzdvh(zzdur zzdurVar, zzdqg zzdqgVar) {
        this.zza = zzdurVar;
        this.zzb = zzdqgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(List list) {
        zzdqf zzdqfVarZza;
        zzdqf zzdqfVarZza2;
        zzbrj zzbrjVar;
        synchronized (this.zzc) {
            if (this.zze) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzblg zzblgVar = (zzblg) it.next();
                String string = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjb)).booleanValue() || (zzdqfVarZza2 = this.zzb.zza(zzblgVar.zza)) == null || (zzbrjVar = zzdqfVarZza2.zzc) == null) ? "" : zzbrjVar.toString();
                String str = string;
                boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjc)).booleanValue() && (zzdqfVarZza = this.zzb.zza(zzblgVar.zza)) != null && zzdqfVarZza.zzd;
                List list2 = this.zzd;
                String str2 = zzblgVar.zza;
                list2.add(new zzdvg(str2, str, this.zzb.zzc(str2), zzblgVar.zzb ? 1 : 0, zzblgVar.zzd, zzblgVar.zzc, z));
            }
            this.zze = true;
        }
    }

    public final JSONArray zza() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (!this.zza.zzt()) {
                    zzc();
                    return jSONArray;
                }
                zzd(this.zza.zzg());
            }
            Iterator it = this.zzd.iterator();
            while (it.hasNext()) {
                jSONArray.put(((zzdvg) it.next()).zza());
            }
            return jSONArray;
        }
    }

    public final void zzc() {
        this.zza.zzs(new zzdvf(this));
    }
}
