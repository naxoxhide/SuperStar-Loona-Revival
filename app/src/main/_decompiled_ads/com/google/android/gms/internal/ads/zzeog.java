package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeog implements zzetw {
    private final Set zza;

    zzeog(Set set) {
        this.zza = set;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return zzfzt.zzh(new zzetv() { // from class: com.google.android.gms.internal.ads.zzeof
            @Override // com.google.android.gms.internal.ads.zzetv
            public final void zzj(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", arrayList);
            }
        });
    }
}
