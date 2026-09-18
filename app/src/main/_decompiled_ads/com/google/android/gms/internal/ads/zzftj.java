package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzftj {
    private final zzfsh zza;
    private final zzfti zzb;

    private zzftj(zzfti zzftiVar) {
        zzfsg zzfsgVar = zzfsg.zza;
        this.zzb = zzftiVar;
        this.zza = zzfsgVar;
    }

    public static zzftj zzb(int i) {
        return new zzftj(new zzftf(4000));
    }

    public static zzftj zzc(zzfsh zzfshVar) {
        return new zzftj(new zzftd(zzfshVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator zzg(CharSequence charSequence) {
        return this.zzb.zza(this, charSequence);
    }

    public final Iterable zzd(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        return new zzftg(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Iterator itZzg = zzg(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itZzg.hasNext()) {
            arrayList.add((String) itZzg.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
