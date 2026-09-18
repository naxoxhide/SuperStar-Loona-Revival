package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfos {
    final zzfov zza;
    final boolean zzb;

    private zzfos(zzfov zzfovVar) {
        this.zza = zzfovVar;
        this.zzb = zzfovVar != null;
    }

    public static zzfos zzb(Context context, String str, String str2) {
        zzfov zzfotVar;
        try {
            try {
                try {
                    IBinder iBinderInstantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderInstantiate == null) {
                        zzfotVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfotVar = iInterfaceQueryLocalInterface instanceof zzfov ? (zzfov) iInterfaceQueryLocalInterface : new zzfot(iBinderInstantiate);
                    }
                    zzfotVar.zze(ObjectWrapper.wrap(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfos(zzfotVar);
                } catch (RemoteException | zzfnu | NullPointerException | SecurityException unused) {
                    Log.d("GASS", "Cannot dynamite load clearcut");
                    return new zzfos(new zzfow());
                }
            } catch (Exception e) {
                throw new zzfnu(e);
            }
        } catch (Exception e2) {
            throw new zzfnu(e2);
        }
    }

    public static zzfos zzc() {
        zzfow zzfowVar = new zzfow();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfos(zzfowVar);
    }

    public final zzfor zza(byte[] bArr) {
        return new zzfor(this, bArr, null);
    }
}
