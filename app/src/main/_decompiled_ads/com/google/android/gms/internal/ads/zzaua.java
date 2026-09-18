package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaua extends zzaud {
    private final View zzi;

    public zzaua(zzasp zzaspVar, String str, String str2, zzaom zzaomVar, int i, int i2, View view) {
        super(zzaspVar, "0+zdyC6VPJhTjPaEoqOWHTMOFQN+wcQzU7Oc0uK1pdETw1P+GgKsW//19LiWUDiB", "beFEMZ/YBSUug4MSXb2BKymKiM6ZxOOlxExWa37jMlM=", zzaomVar, i, 57);
        this.zzi = view;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdh);
            Boolean bool2 = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzka);
            zzast zzastVar = new zzast((String) this.zzf.invoke(null, this.zzi, this.zzb.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzaph zzaphVarZza = zzapi.zza();
            zzaphVarZza.zzb(zzastVar.zza.longValue());
            zzaphVarZza.zzd(zzastVar.zzb.longValue());
            zzaphVarZza.zze(zzastVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zzaphVarZza.zzc(zzastVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zzaphVarZza.zza(zzastVar.zzd.longValue());
            }
            this.zze.zzY((zzapi) zzaphVarZza.zzal());
        }
    }
}
