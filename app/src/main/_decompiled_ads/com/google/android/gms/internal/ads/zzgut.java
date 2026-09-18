package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgut extends zzgux {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgut() {
        super(null);
    }

    /* synthetic */ zzgut(zzgus zzgusVar) {
        super(null);
    }

    private static List zzf(Object obj, long j, int i) {
        List list;
        List listZzd;
        List list2 = (List) zzgxd.zzh(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof zzgur) {
                listZzd = new zzguq(i);
            } else {
                listZzd = ((list2 instanceof zzgvq) && (list2 instanceof zzgui)) ? ((zzgui) list2).zzd(i) : new ArrayList(i);
            }
            zzgxd.zzv(obj, j, listZzd);
            return listZzd;
        }
        if (zza.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList = new ArrayList(list2.size() + i);
            arrayList.addAll(list2);
            zzgxd.zzv(obj, j, arrayList);
            list = arrayList;
        } else {
            if (!(list2 instanceof zzgwy)) {
                if (!(list2 instanceof zzgvq) || !(list2 instanceof zzgui)) {
                    return list2;
                }
                zzgui zzguiVar = (zzgui) list2;
                if (zzguiVar.zzc()) {
                    return list2;
                }
                zzgui zzguiVarZzd = zzguiVar.zzd(list2.size() + i);
                zzgxd.zzv(obj, j, zzguiVarZzd);
                return zzguiVarZzd;
            }
            zzguq zzguqVar = new zzguq(list2.size() + i);
            zzguqVar.addAll(zzguqVar.size(), (zzgwy) list2);
            zzgxd.zzv(obj, j, zzguqVar);
            list = zzguqVar;
        }
        return list;
    }

    @Override // com.google.android.gms.internal.ads.zzgux
    final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzgux
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzgxd.zzh(obj, j);
        if (list instanceof zzgur) {
            objUnmodifiableList = ((zzgur) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzgvq) && (list instanceof zzgui)) {
                zzgui zzguiVar = (zzgui) list;
                if (zzguiVar.zzc()) {
                    zzguiVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzgxd.zzv(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.ads.zzgux
    final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzgxd.zzh(obj2, j);
        List listZzf = zzf(obj, j, list.size());
        int size = listZzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listZzf.addAll(list);
        }
        if (size > 0) {
            list = listZzf;
        }
        zzgxd.zzv(obj, j, list);
    }
}
