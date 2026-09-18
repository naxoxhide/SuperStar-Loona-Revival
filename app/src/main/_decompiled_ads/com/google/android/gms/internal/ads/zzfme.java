package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfme extends AsyncTask {
    private zzfmf zza;
    protected final zzflw zzd;

    public zzfme(zzflw zzflwVar) {
        this.zzd = zzflwVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzfmf zzfmfVar = this.zza;
        if (zzfmfVar != null) {
            zzfmfVar.zza(this);
        }
    }

    public final void zzb(zzfmf zzfmfVar) {
        this.zza = zzfmfVar;
    }
}
