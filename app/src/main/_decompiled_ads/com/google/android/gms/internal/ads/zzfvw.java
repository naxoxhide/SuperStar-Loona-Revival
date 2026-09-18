package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfvw extends zzfvl {

    @CheckForNull
    Object[] zzd;
    private int zze;

    public zzfvw() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzfvl, com.google.android.gms.internal.ads.zzfvm
    public final /* bridge */ /* synthetic */ zzfvm zzb(Object obj) {
        zzf(obj);
        return this;
    }

    zzfvw(int i) {
        super(i);
        this.zzd = new Object[zzfvx.zzh(i)];
    }

    public final zzfvw zzg(Iterable iterable) {
        Objects.requireNonNull(iterable);
        if (this.zzd != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                zzf(it.next());
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    public final zzfvx zzh() {
        zzfvx zzfvxVarZzs;
        int i = this.zzb;
        if (i == 0) {
            return zzfxi.zza;
        }
        if (i == 1) {
            Object obj = this.zza[0];
            obj.getClass();
            return new zzfxp(obj);
        }
        if (this.zzd == null || zzfvx.zzh(i) != this.zzd.length) {
            zzfvxVarZzs = zzfvx.zzs(this.zzb, this.zza);
            this.zzb = zzfvxVarZzs.size();
        } else {
            int i2 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzfvx.zzt(i2, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            int i3 = this.zze;
            Object[] objArr = this.zzd;
            zzfvxVarZzs = new zzfxi(objArrCopyOf, i3, objArr, objArr.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzfvxVarZzs;
    }

    public final zzfvw zzf(Object obj) {
        Objects.requireNonNull(obj);
        if (this.zzd != null) {
            int iZzh = zzfvx.zzh(this.zzb);
            Object[] objArr = this.zzd;
            int length = objArr.length;
            if (iZzh <= length) {
                objArr.getClass();
                int iHashCode = obj.hashCode();
                int iZza = zzfvk.zza(iHashCode);
                while (true) {
                    Object[] objArr2 = this.zzd;
                    int i = iZza & (length - 1);
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iZza = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zze += iHashCode;
                        super.zza(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }
}
