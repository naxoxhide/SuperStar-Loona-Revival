package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzfzd extends zzfys {

    @CheckForNull
    private List zza;

    zzfzd(zzfvn zzfvnVar, boolean z) {
        super(zzfvnVar, z, true);
        List listEmptyList = zzfvnVar.isEmpty() ? Collections.emptyList() : zzfwg.zza(zzfvnVar.size());
        for (int i = 0; i < zzfvnVar.size(); i++) {
            listEmptyList.add(null);
        }
        this.zza = listEmptyList;
    }

    abstract Object zzG(List list);

    @Override // com.google.android.gms.internal.ads.zzfys
    final void zzf(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzfzc(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfys
    final void zzu() {
        List list = this.zza;
        if (list != null) {
            zzc(zzG(list));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfys
    final void zzy(int i) {
        super.zzy(i);
        this.zza = null;
    }
}
