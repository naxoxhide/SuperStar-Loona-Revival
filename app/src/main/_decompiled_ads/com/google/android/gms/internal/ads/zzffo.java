package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzffo {
    private final HashMap zza = new HashMap();

    public final zzffn zza(zzffe zzffeVar, Context context, zzfew zzfewVar, zzffu zzffuVar) {
        zzffn zzffnVar = (zzffn) this.zza.get(zzffeVar);
        if (zzffnVar != null) {
            return zzffnVar;
        }
        zzffb zzffbVar = new zzffb(zzffh.zza(zzffeVar, context));
        zzffn zzffnVar2 = new zzffn(zzffbVar, new zzffw(zzffbVar, zzfewVar, zzffuVar));
        this.zza.put(zzffeVar, zzffnVar2);
        return zzffnVar2;
    }
}
