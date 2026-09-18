package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzez {
    private static zzez zza;
    private final Handler zzb = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList zzc = new CopyOnWriteArrayList();
    private final Object zzd = new Object();
    private int zze = 0;

    private zzez(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new zzey(this, null), intentFilter);
    }

    public static synchronized zzez zzb(Context context) {
        if (zza == null) {
            zza = new zzez(context);
        }
        return zza;
    }

    static /* synthetic */ void zzc(zzez zzezVar, int i) {
        synchronized (zzezVar.zzd) {
            if (zzezVar.zze == i) {
                return;
            }
            zzezVar.zze = i;
            for (WeakReference weakReference : zzezVar.zzc) {
                zzya zzyaVar = (zzya) weakReference.get();
                if (zzyaVar != null) {
                    zzyaVar.zza.zzk(i);
                } else {
                    zzezVar.zzc.remove(weakReference);
                }
            }
        }
    }

    public final int zza() {
        int i;
        synchronized (this.zzd) {
            i = this.zze;
        }
        return i;
    }

    public final void zzd(final zzya zzyaVar) {
        for (WeakReference weakReference : this.zzc) {
            if (weakReference.get() == null) {
                this.zzc.remove(weakReference);
            }
        }
        this.zzc.add(new WeakReference(zzyaVar));
        this.zzb.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzev
            @Override // java.lang.Runnable
            public final void run() {
                zzyaVar.zza.zzk(this.zza.zza());
            }
        });
    }
}
