package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlp extends zzhu {
    public static final /* synthetic */ int zzc = 0;
    private final int zzd;
    private final int zze;
    private final int[] zzf;
    private final int[] zzg;
    private final zzcv[] zzh;
    private final Object[] zzi;
    private final HashMap zzj;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzlp(Collection collection, zzvr zzvrVar) {
        zzcv[] zzcvVarArr = new zzcv[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            zzcvVarArr[i2] = ((zzky) it.next()).zza();
            i2++;
        }
        Object[] objArr = new Object[collection.size()];
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            objArr[i] = ((zzky) it2.next()).zzb();
            i++;
        }
        this(zzcvVarArr, objArr, zzvrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcv
    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    protected final int zzp(Object obj) {
        Integer num = (Integer) this.zzj.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    protected final int zzq(int i) {
        return zzfk.zzb(this.zzf, i + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    protected final int zzr(int i) {
        return zzfk.zzb(this.zzg, i + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    protected final int zzs(int i) {
        return this.zzf[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    protected final int zzt(int i) {
        return this.zzg[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    protected final zzcv zzu(int i) {
        return this.zzh[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    protected final Object zzv(int i) {
        return this.zzi[i];
    }

    final List zzw() {
        return Arrays.asList(this.zzh);
    }

    public final zzlp zzx(zzvr zzvrVar) {
        zzcv[] zzcvVarArr = new zzcv[this.zzh.length];
        int i = 0;
        while (true) {
            zzcv[] zzcvVarArr2 = this.zzh;
            if (i >= zzcvVarArr2.length) {
                return new zzlp(zzcvVarArr, this.zzi, zzvrVar);
            }
            zzcvVarArr[i] = new zzlo(this, zzcvVarArr2[i]);
            i++;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzlp(zzcv[] zzcvVarArr, Object[] objArr, zzvr zzvrVar) {
        super(false, zzvrVar);
        int i = 0;
        this.zzh = zzcvVarArr;
        int length = zzcvVarArr.length;
        this.zzf = new int[length];
        this.zzg = new int[length];
        this.zzi = objArr;
        this.zzj = new HashMap();
        int iZzc = 0;
        int iZzb = 0;
        int i2 = 0;
        while (i < zzcvVarArr.length) {
            zzcv zzcvVar = zzcvVarArr[i];
            this.zzh[i2] = zzcvVar;
            this.zzg[i2] = iZzc;
            this.zzf[i2] = iZzb;
            iZzc += zzcvVar.zzc();
            iZzb += this.zzh[i2].zzb();
            this.zzj.put(objArr[i2], Integer.valueOf(i2));
            i++;
            i2++;
        }
        this.zzd = iZzc;
        this.zze = iZzb;
    }
}
