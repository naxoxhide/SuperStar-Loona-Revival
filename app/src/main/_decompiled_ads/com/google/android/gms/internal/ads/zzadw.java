package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadw extends zzady {
    private long zzb;
    private long[] zzc;
    private long[] zzd;

    public zzadw() {
        super(new zzabl());
        this.zzb = -9223372036854775807L;
        this.zzc = new long[0];
        this.zzd = new long[0];
    }

    private static Double zzg(zzfb zzfbVar) {
        return Double.valueOf(Double.longBitsToDouble(zzfbVar.zzs()));
    }

    private static String zzi(zzfb zzfbVar) {
        int iZzp = zzfbVar.zzp();
        int iZzc = zzfbVar.zzc();
        zzfbVar.zzH(iZzp);
        return new String(zzfbVar.zzI(), iZzc, iZzp);
    }

    private static HashMap zzj(zzfb zzfbVar) {
        int iZzo = zzfbVar.zzo();
        HashMap map = new HashMap(iZzo);
        for (int i = 0; i < iZzo; i++) {
            String strZzi = zzi(zzfbVar);
            Object objZzh = zzh(zzfbVar, zzfbVar.zzl());
            if (objZzh != null) {
                map.put(strZzi, objZzh);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzady
    protected final boolean zza(zzfb zzfbVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzady
    protected final boolean zzb(zzfb zzfbVar, long j) {
        if (zzfbVar.zzl() != 2 || !"onMetaData".equals(zzi(zzfbVar)) || zzfbVar.zza() == 0 || zzfbVar.zzl() != 8) {
            return false;
        }
        HashMap mapZzj = zzj(zzfbVar);
        Object obj = mapZzj.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.zzb = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapZzj.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.zzc = new long[size];
                this.zzd = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.zzc = new long[0];
                        this.zzd = new long[0];
                        break;
                    }
                    this.zzc[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.zzd[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzd;
    }

    public final long[] zze() {
        return this.zzc;
    }

    private static Object zzh(zzfb zzfbVar, int i) {
        if (i == 0) {
            return zzg(zzfbVar);
        }
        if (i == 1) {
            return Boolean.valueOf(zzfbVar.zzl() == 1);
        }
        if (i == 2) {
            return zzi(zzfbVar);
        }
        if (i != 3) {
            if (i == 8) {
                return zzj(zzfbVar);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) zzg(zzfbVar).doubleValue());
                zzfbVar.zzH(2);
                return date;
            }
            int iZzo = zzfbVar.zzo();
            ArrayList arrayList = new ArrayList(iZzo);
            for (int i2 = 0; i2 < iZzo; i2++) {
                Object objZzh = zzh(zzfbVar, zzfbVar.zzl());
                if (objZzh != null) {
                    arrayList.add(objZzh);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strZzi = zzi(zzfbVar);
            int iZzl = zzfbVar.zzl();
            if (iZzl == 9) {
                return map;
            }
            Object objZzh2 = zzh(zzfbVar, iZzl);
            if (objZzh2 != null) {
                map.put(strZzi, objZzh2);
            }
        }
    }
}
