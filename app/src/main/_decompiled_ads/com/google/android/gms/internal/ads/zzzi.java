package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzzi extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzzg zzd;
    private boolean zze;

    /* synthetic */ zzzi(zzzg zzzgVar, SurfaceTexture surfaceTexture, boolean z, zzzh zzzhVar) {
        super(surfaceTexture);
        this.zzd = zzzgVar;
        this.zza = z;
    }

    public static zzzi zza(Context context, boolean z) {
        boolean z2 = true;
        if (z && !zzb(context)) {
            z2 = false;
        }
        zzdx.zzf(z2);
        return new zzzg().zza(z ? zzb : 0);
    }

    public static synchronized boolean zzb(Context context) {
        int i;
        if (!zzc) {
            if (zzeg.zzc(context)) {
                i = zzeg.zzd() ? 1 : 2;
            } else {
                i = 0;
            }
            zzb = i;
            zzc = true;
        }
        return zzb != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.zzd) {
            if (!this.zze) {
                this.zzd.zzb();
                this.zze = true;
            }
        }
    }
}
