package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbfh extends NativeAd.AdChoicesInfo {
    private final zzbfg zza;
    private final List zzb = new ArrayList();
    private String zzc;

    public zzbfh(zzbfg zzbfgVar) {
        IBinder iBinder;
        this.zza = zzbfgVar;
        try {
            this.zzc = zzbfgVar.zzg();
        } catch (RemoteException e) {
            zzcat.zzh("", e);
            this.zzc = "";
        }
        try {
            for (Object obj : zzbfgVar.zzh()) {
                zzbfo zzbfmVar = null;
                if ((obj instanceof IBinder) && (iBinder = (IBinder) obj) != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzbfmVar = iInterfaceQueryLocalInterface instanceof zzbfo ? (zzbfo) iInterfaceQueryLocalInterface : new zzbfm(iBinder);
                }
                if (zzbfmVar != null) {
                    this.zzb.add(new zzbfp(zzbfmVar));
                }
            }
        } catch (RemoteException e2) {
            zzcat.zzh("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzc;
    }
}
