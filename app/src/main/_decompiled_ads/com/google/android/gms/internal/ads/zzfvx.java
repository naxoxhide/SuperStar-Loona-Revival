package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfvx extends zzfvn implements Set {

    @CheckForNull
    private transient zzfvs zza;

    zzfvx() {
    }

    static int zzh(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzfsw.zzf(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzfvw zzj(int i) {
        return new zzfvw(i);
    }

    public static zzfvx zzl(Collection collection) {
        Object[] array = collection.toArray();
        return zzs(array.length, array);
    }

    public static zzfvx zzm() {
        return zzfxi.zza;
    }

    public static zzfvx zzn(Object obj) {
        return new zzfxp(obj);
    }

    public static zzfvx zzo(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzs(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzfvx zzp(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, 6);
        return zzs(12, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfvx) && zzr() && ((zzfvx) obj).zzr() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzfxo.zzc(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzfxo.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public zzfvs zzd() {
        zzfvs zzfvsVar = this.zza;
        if (zzfvsVar != null) {
            return zzfvsVar;
        }
        zzfvs zzfvsVarZzi = zzi();
        this.zza = zzfvsVarZzi;
        return zzfvsVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzfvn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public abstract zzfxs iterator();

    zzfvs zzi() {
        Object[] array = toArray();
        int i = zzfvs.zzd;
        return zzfvs.zzi(array, array.length);
    }

    boolean zzr() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfvx zzs(int i, Object... objArr) {
        if (i == 0) {
            return zzfxi.zza;
        }
        if (i == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new zzfxp(obj);
        }
        int iZzh = zzh(i);
        Object[] objArr2 = new Object[iZzh];
        int i2 = iZzh - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            zzfxa.zza(obj2, i5);
            int iHashCode = obj2.hashCode();
            int iZza = zzfvk.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iZza++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzfxp(obj4);
        }
        if (zzh(i4) < iZzh / 2) {
            return zzs(i4, objArr);
        }
        if (zzt(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzfxi(objArr, i3, objArr2, i2, i4);
    }
}
