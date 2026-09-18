package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzba extends zzbb {
    zzba(zzbc zzbcVar, com.google.android.play.core.tasks.zzi zziVar) {
        super(zzbcVar, zziVar);
    }

    @Override // com.google.android.play.core.splitinstall.zzbb, com.google.android.play.core.internal.zzcc
    public final void zzi(int i, Bundle bundle) throws RemoteException {
        super.zzi(i, bundle);
        this.zza.zze(Integer.valueOf(i));
    }
}
