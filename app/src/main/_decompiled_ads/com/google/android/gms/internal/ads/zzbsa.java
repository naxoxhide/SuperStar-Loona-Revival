package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbsa extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbsa(zzbfg zzbfgVar) {
        try {
            this.zzb = zzbfgVar.zzg();
        } catch (RemoteException e) {
            zzcat.zzh("", e);
            this.zzb = "";
        }
        try {
            for (Object obj : zzbfgVar.zzh()) {
                zzbfo zzbfoVarZzg = obj instanceof IBinder ? zzbfn.zzg((IBinder) obj) : null;
                if (zzbfoVarZzg != null) {
                    this.zza.add(new zzbsc(zzbfoVarZzg));
                }
            }
        } catch (RemoteException e2) {
            zzcat.zzh("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzb;
    }
}
