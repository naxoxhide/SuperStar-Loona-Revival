package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzamz {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    zzamz(String str, zzalp zzalpVar) {
        String str2 = zzalpVar.zzb;
        long j = zzalpVar.zzc;
        long j2 = zzalpVar.zzd;
        long j3 = zzalpVar.zze;
        long j4 = zzalpVar.zzf;
        List arrayList = zzalpVar.zzh;
        if (arrayList == null) {
            Map map = zzalpVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzaly((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }

    static zzamz zza(zzana zzanaVar) throws IOException {
        if (zzanc.zze(zzanaVar) != 538247942) {
            throw new IOException();
        }
        String strZzh = zzanc.zzh(zzanaVar);
        String strZzh2 = zzanc.zzh(zzanaVar);
        long jZzf = zzanc.zzf(zzanaVar);
        long jZzf2 = zzanc.zzf(zzanaVar);
        long jZzf3 = zzanc.zzf(zzanaVar);
        long jZzf4 = zzanc.zzf(zzanaVar);
        int iZze = zzanc.zze(zzanaVar);
        if (iZze < 0) {
            throw new IOException("readHeaderList size=" + iZze);
        }
        List listEmptyList = iZze == 0 ? Collections.emptyList() : new ArrayList();
        for (int i = 0; i < iZze; i++) {
            listEmptyList.add(new zzaly(zzanc.zzh(zzanaVar).intern(), zzanc.zzh(zzanaVar).intern()));
        }
        return new zzamz(strZzh, strZzh2, jZzf, jZzf2, jZzf3, jZzf4, listEmptyList);
    }

    private zzamz(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
