package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.adxcorp.ads.mediation.util.ReportUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzecs implements zzfzp {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzect zzb;

    zzecs(zzect zzectVar, boolean z) {
        this.zzb = zzectVar;
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        zzcat.zzg("Failed to get signals bundle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0074  */
    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x007e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0080  */
    /* JADX WARN: Code duplicated, block: B:33:0x0088  */
    /* JADX WARN: Code duplicated, block: B:34:0x008a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0092  */
    /* JADX WARN: Code duplicated, block: B:37:0x0094  */
    /* JADX WARN: Code duplicated, block: B:39:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a9  */
    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List listEmptyList;
        List listAsList;
        final ArrayList arrayList;
        Iterator it;
        byte b2;
        zzayt zzaytVar;
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzf()) {
            return;
        }
        Object obj2 = bundle.get("ad_types");
        if (!(obj2 instanceof List)) {
            if (obj2 instanceof String[]) {
                listAsList = Arrays.asList((String[]) obj2);
            } else {
                listEmptyList = Collections.emptyList();
            }
            arrayList = new ArrayList();
            it = listEmptyList.iterator();
            while (it.hasNext()) {
                switch ((String) it.next()) {
                    case "banner":
                        b2 = 0;
                        break;
                    case "native":
                        b2 = 2;
                        break;
                    case "rewarded":
                        b2 = 3;
                        break;
                    case "interstitial":
                        b2 = 1;
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                if (b2 != 0) {
                    zzaytVar = zzayt.BANNER;
                } else if (b2 != 1) {
                    zzaytVar = zzayt.INTERSTITIAL;
                } else if (b2 != 2) {
                    zzaytVar = zzayt.NATIVE_APP_INSTALL;
                } else if (b2 != 3) {
                    zzaytVar = zzayt.AD_FORMAT_TYPE_UNSPECIFIED;
                } else {
                    zzaytVar = zzayt.REWARD_BASED_VIDEO_AD;
                }
                arrayList.add(zzaytVar);
            }
            final zzbai zzbaiVarZzb = zzect.zzb(this.zzb, bundle);
            final zzazz zzazzVarZza = zzect.zza(this.zzb, bundle);
            zzect zzectVar = this.zzb;
            final boolean z = this.zza;
            zzectVar.zza.zza(new zzfgu() { // from class: com.google.android.gms.internal.ads.zzecr
                @Override // com.google.android.gms.internal.ads.zzfgu
                public final Object zza(Object obj3) {
                    zzecs zzecsVar = this.zza;
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj3;
                    if (zzecsVar.zzb.zzf()) {
                        return null;
                    }
                    zzbai zzbaiVar = zzbaiVarZzb;
                    zzazz zzazzVar = zzazzVarZza;
                    ArrayList arrayList2 = arrayList;
                    boolean z2 = z;
                    byte[] bArrZze = zzect.zze(zzecsVar.zzb, z2, arrayList2, zzazzVar, zzbaiVar);
                    zzecw.zzg(sQLiteDatabase, z2, true);
                    zzecw.zzd(sQLiteDatabase, zzecsVar.zzb.zzf.zzd(), bArrZze);
                    return null;
                }
            });
        }
        listAsList = (List) obj2;
        ArrayList arrayList2 = new ArrayList(listAsList.size());
        for (Object obj3 : listAsList) {
            if (obj3 instanceof String) {
                arrayList2.add((String) obj3);
            }
        }
        listEmptyList = Collections.unmodifiableList(arrayList2);
        arrayList = new ArrayList();
        it = listEmptyList.iterator();
        while (it.hasNext()) {
            switch ((String) it.next()) {
                case -1396342996:
                    if (!r1.equals(ReportUtil.INVENTORY_TYPE_BANNER)) {
                        b2 = 0;
                    } else {
                        b2 = -1;
                    }
                    break;
                case -1052618729:
                    if (!r1.equals("native")) {
                        b2 = 2;
                    } else {
                        b2 = -1;
                    }
                    break;
                case -239580146:
                    if (!r1.equals("rewarded")) {
                        b2 = 3;
                    } else {
                        b2 = -1;
                    }
                    break;
                case 604727084:
                    if (!r1.equals(ReportUtil.INVENTORY_TYPE_INTERSTITIAL)) {
                        b2 = 1;
                    } else {
                        b2 = -1;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 != 0) {
                zzaytVar = zzayt.BANNER;
            } else if (b2 != 1) {
                zzaytVar = zzayt.INTERSTITIAL;
            } else if (b2 != 2) {
                zzaytVar = zzayt.NATIVE_APP_INSTALL;
            } else if (b2 != 3) {
                zzaytVar = zzayt.AD_FORMAT_TYPE_UNSPECIFIED;
            } else {
                zzaytVar = zzayt.REWARD_BASED_VIDEO_AD;
            }
            arrayList.add(zzaytVar);
        }
        final zzbai zzbaiVarZzb2 = zzect.zzb(this.zzb, bundle);
        final zzazz zzazzVarZza2 = zzect.zza(this.zzb, bundle);
        zzect zzectVar2 = this.zzb;
        final boolean z2 = this.zza;
        zzectVar2.zza.zza(new zzfgu() { // from class: com.google.android.gms.internal.ads.zzecr
            @Override // com.google.android.gms.internal.ads.zzfgu
            public final Object zza(Object obj4) {
                zzecs zzecsVar = this.zza;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj4;
                if (zzecsVar.zzb.zzf()) {
                    return null;
                }
                zzbai zzbaiVar = zzbaiVarZzb2;
                zzazz zzazzVar = zzazzVarZza2;
                ArrayList arrayList3 = arrayList;
                boolean z3 = z2;
                byte[] bArrZze = zzect.zze(zzecsVar.zzb, z3, arrayList3, zzazzVar, zzbaiVar);
                zzecw.zzg(sQLiteDatabase, z3, true);
                zzecw.zzd(sQLiteDatabase, zzecsVar.zzb.zzf.zzd(), bArrZze);
                return null;
            }
        });
    }
}
