package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfmh extends zzfmd {
    public zzfmh(zzflw zzflwVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzflwVar, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfku zzfkuVarZza = zzfku.zza();
        if (zzfkuVarZza != null) {
            for (zzfkg zzfkgVar : zzfkuVarZza.zzc()) {
                if (this.zza.contains(zzfkgVar.zzh())) {
                    zzfkgVar.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfme, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfme
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
