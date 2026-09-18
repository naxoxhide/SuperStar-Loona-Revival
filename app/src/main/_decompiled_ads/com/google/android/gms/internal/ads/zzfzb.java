package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfzb extends zzfzd {
    zzfzb(zzfvn zzfvnVar, boolean z) {
        super(zzfvnVar, z);
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzfzd
    public final /* bridge */ /* synthetic */ Object zzG(List list) {
        ArrayList arrayListZza = zzfwg.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfzc zzfzcVar = (zzfzc) it.next();
            arrayListZza.add(zzfzcVar != null ? zzfzcVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZza);
    }
}
