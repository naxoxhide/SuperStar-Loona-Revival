package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfqa {
    public static ListenableFuture zza(Task task) {
        final zzfpz zzfpzVar = new zzfpz(task);
        task.addOnCompleteListener(zzgaj.zzb(), new OnCompleteListener() { // from class: com.google.android.gms.internal.ads.zzfpy
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                zzfpz zzfpzVar2 = zzfpzVar;
                if (task2.isCanceled()) {
                    zzfpzVar2.cancel(false);
                    return;
                }
                if (task2.isSuccessful()) {
                    zzfpzVar2.zzc(task2.getResult());
                    return;
                }
                Exception exception = task2.getException();
                if (exception == null) {
                    throw new IllegalStateException();
                }
                zzfpzVar2.zzd(exception);
            }
        });
        return zzfpzVar;
    }
}
