package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzavq {
    private final Object zza = new Object();
    private zzavo zzb = null;
    private boolean zzc = false;

    public final Activity zza() {
        synchronized (this.zza) {
            zzavo zzavoVar = this.zzb;
            if (zzavoVar == null) {
                return null;
            }
            return zzavoVar.zza();
        }
    }

    public final Context zzb() {
        synchronized (this.zza) {
            zzavo zzavoVar = this.zzb;
            if (zzavoVar == null) {
                return null;
            }
            return zzavoVar.zzb();
        }
    }

    public final void zzc(zzavp zzavpVar) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new zzavo();
            }
            this.zzb.zzf(zzavpVar);
        }
    }

    public final void zzd(Context context) {
        synchronized (this.zza) {
            if (!this.zzc) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzcat.zzj("Can not cast Context to Application");
                    return;
                }
                if (this.zzb == null) {
                    this.zzb = new zzavo();
                }
                this.zzb.zzg(application, context);
                this.zzc = true;
            }
        }
    }

    public final void zze(zzavp zzavpVar) {
        synchronized (this.zza) {
            zzavo zzavoVar = this.zzb;
            if (zzavoVar == null) {
                return;
            }
            zzavoVar.zzh(zzavpVar);
        }
    }
}
