package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbtk;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzfzp;
import java.util.ArrayList;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzx implements zzfzp {
    final /* synthetic */ zzbtk zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;

    zzx(zzaa zzaaVar, zzbtk zzbtkVar, boolean z) {
        this.zzc = zzaaVar;
        this.zza = zzbtkVar;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        try {
            this.zza.zze("Internal error: " + th.getMessage());
        } catch (RemoteException e) {
            zzcat.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        ArrayList<Uri> arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (this.zzc.zzt || this.zzb) {
                for (Uri uri : arrayList) {
                    if (this.zzc.zzO(uri)) {
                        this.zzc.zzs.zzc(zzaa.zzX(uri, this.zzc.zzC, "1").toString(), null);
                    } else {
                        if (((Boolean) zzba.zzc().zzb(zzbci.zzhu)).booleanValue()) {
                            this.zzc.zzs.zzc(uri.toString(), null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            zzcat.zzh("", e);
        }
    }
}
