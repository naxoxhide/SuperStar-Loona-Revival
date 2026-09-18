package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzxi extends zzxn implements zzls {
    public static final /* synthetic */ int zzb = 0;
    private static final zzfxb zzc = zzfxb.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzwh
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int i = zzxi.zzb;
            if (num.intValue() == -1) {
                return num2.intValue() == -1 ? 0 : -1;
            }
            if (num2.intValue() == -1) {
                return 1;
            }
            return num.intValue() - num2.intValue();
        }
    });
    private static final zzfxb zzd = zzfxb.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzwi
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i = zzxi.zzb;
            return 0;
        }
    });
    public final Context zza;
    private final Object zze;
    private final boolean zzf;
    private zzww zzg;
    private zzxb zzh;
    private zzk zzi;
    private final zzwd zzj;

    public zzxi(Context context) {
        zzwd zzwdVar = new zzwd();
        zzww zzwwVarZzd = zzww.zzd(context);
        this.zze = new Object();
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzwdVar;
        this.zzg = zzwwVarZzd;
        this.zzi = zzk.zza;
        boolean z = false;
        if (context != null && zzfk.zzH(context)) {
            z = true;
        }
        this.zzf = z;
        if (!z && context != null && zzfk.zza >= 32) {
            this.zzh = zzxb.zza(context);
        }
        if (this.zzg.zzQ && context == null) {
            zzer.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    protected static int zza(zzam zzamVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzamVar.zzd)) {
            return 4;
        }
        String strZzg = zzg(str);
        String strZzg2 = zzg(zzamVar.zzd);
        if (strZzg2 == null || strZzg == null) {
            return (z && strZzg2 == null) ? 1 : 0;
        }
        if (strZzg2.startsWith(strZzg) || strZzg.startsWith(strZzg2)) {
            return 3;
        }
        int i = zzfk.zza;
        return strZzg2.split("-", 2)[0].equals(strZzg.split("-", 2)[0]) ? 2 : 0;
    }

    protected static String zzg(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x004c  */
    /* JADX WARN: Code duplicated, block: B:54:0x008b  */
    public static /* synthetic */ boolean zzl(zzxi zzxiVar, zzam zzamVar) {
        boolean z;
        byte b2;
        zzxb zzxbVar;
        zzxb zzxbVar2;
        synchronized (zzxiVar.zze) {
            z = false;
            if (!zzxiVar.zzg.zzQ || zzxiVar.zzf || zzamVar.zzz <= 2) {
                z = true;
            } else {
                String str = zzamVar.zzm;
                if (str != null) {
                    switch (str) {
                        case "audio/eac3-joc":
                            b2 = 2;
                            break;
                        case "audio/ac3":
                            b2 = 0;
                            break;
                        case "audio/ac4":
                            b2 = 3;
                            break;
                        case "audio/eac3":
                            b2 = 1;
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    if ((b2 == 0 || b2 == 1 || b2 == 2 || b2 == 3) && (zzfk.zza < 32 || (zzxbVar = zzxiVar.zzh) == null || !zzxbVar.zzg())) {
                        z = true;
                    }
                }
                if (zzfk.zza >= 32 && (zzxbVar2 = zzxiVar.zzh) != null && zzxbVar2.zzg() && zzxbVar2.zze() && zzxiVar.zzh.zzf() && zzxiVar.zzh.zzd(zzxiVar.zzi, zzamVar)) {
                    z = true;
                }
            }
        }
        return z;
    }

    protected static boolean zzn(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    private static void zzt(zzvx zzvxVar, zzdc zzdcVar, Map map) {
        for (int i = 0; i < zzvxVar.zzc; i++) {
            if (((zzcz) zzdcVar.zzC.get(zzvxVar.zzb(i))) != null) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzu() {
        boolean z;
        zzxb zzxbVar;
        synchronized (this.zze) {
            z = false;
            if (this.zzg.zzQ && !this.zzf && zzfk.zza >= 32 && (zzxbVar = this.zzh) != null && zzxbVar.zzg()) {
                z = true;
            }
        }
        if (z) {
            zzs();
        }
    }

    private static final Pair zzv(int i, zzxm zzxmVar, int[][][] iArr, zzxd zzxdVar, Comparator comparator) {
        int i2;
        List arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < 2; i3++) {
            if (i == zzxmVar.zzc(i3)) {
                zzvx zzvxVarZzd = zzxmVar.zzd(i3);
                for (int i4 = 0; i4 < zzvxVarZzd.zzc; i4++) {
                    zzcx zzcxVarZzb = zzvxVarZzd.zzb(i4);
                    List listZza = zzxdVar.zza(i3, zzcxVarZzb, iArr[i3][i4]);
                    int i5 = zzcxVarZzb.zzb;
                    int i6 = 1;
                    boolean[] zArr = new boolean[1];
                    int i7 = 0;
                    while (true) {
                        int i8 = zzcxVarZzb.zzb;
                        if (i7 <= 0) {
                            int i9 = i7 + 1;
                            zzxe zzxeVar = (zzxe) listZza.get(i7);
                            int iZzb = zzxeVar.zzb();
                            if (zArr[i7] || iZzb == 0) {
                                i2 = i6;
                            } else {
                                if (iZzb == i6) {
                                    arrayList = zzfvs.zzm(zzxeVar);
                                    i2 = i6;
                                } else {
                                    arrayList = new ArrayList();
                                    arrayList.add(zzxeVar);
                                    int i10 = i9;
                                    while (true) {
                                        int i11 = zzcxVarZzb.zzb;
                                        if (i10 > 0) {
                                            break;
                                        }
                                        zzxe zzxeVar2 = (zzxe) listZza.get(i10);
                                        if (zzxeVar2.zzb() == 2 && zzxeVar.zzc(zzxeVar2)) {
                                            arrayList.add(zzxeVar2);
                                            zArr[i10] = true;
                                        }
                                        i10++;
                                    }
                                    i2 = 1;
                                }
                                arrayList2.add(arrayList);
                            }
                            i6 = i2;
                            i7 = i9;
                        }
                    }
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList2, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i12 = 0; i12 < list.size(); i12++) {
            iArr2[i12] = ((zzxe) list.get(i12)).zzc;
        }
        zzxe zzxeVar3 = (zzxe) list.get(0);
        return Pair.create(new zzxj(zzxeVar3.zzb, iArr2, 0), Integer.valueOf(zzxeVar3.zza));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzxn
    protected final Pair zzb(zzxm zzxmVar, int[][][] iArr, final int[] iArr2, zztw zztwVar, zzcv zzcvVar) throws zzil {
        final zzww zzwwVar;
        int i;
        final boolean z;
        int[] iArr3;
        int length;
        zzxb zzxbVar;
        synchronized (this.zze) {
            zzwwVar = this.zzg;
            if (zzwwVar.zzQ && zzfk.zza >= 32 && (zzxbVar = this.zzh) != null) {
                Looper looperMyLooper = Looper.myLooper();
                zzdx.zzb(looperMyLooper);
                zzxbVar.zzb(this, looperMyLooper);
            }
        }
        int i2 = 2;
        zzxj[] zzxjVarArr = new zzxj[2];
        int i3 = zzwwVar.zzv;
        Pair pairZzv = zzv(2, zzxmVar, iArr, new zzxd() { // from class: com.google.android.gms.internal.ads.zzwm
            /* JADX WARN: Code duplicated, block: B:22:0x0040  */
            @Override // com.google.android.gms.internal.ads.zzxd
            public final List zza(int i4, zzcx zzcxVar, int[] iArr4) {
                int i5;
                int i6;
                int i7;
                Point point;
                int i8 = zzxi.zzb;
                zzww zzwwVar2 = zzwwVar;
                int i9 = iArr2[i4];
                int i10 = zzwwVar2.zzl;
                int i11 = zzwwVar2.zzm;
                boolean z2 = zzwwVar2.zzn;
                int i12 = -1;
                int i13 = Integer.MAX_VALUE;
                int i14 = 0;
                if (i10 == Integer.MAX_VALUE) {
                    i13 = Integer.MAX_VALUE;
                } else if (i11 != Integer.MAX_VALUE) {
                    int i15 = Integer.MAX_VALUE;
                    char c = 0;
                    while (true) {
                        int i16 = zzcxVar.zzb;
                        if (c > 0) {
                            break;
                        }
                        zzam zzamVarZzb = zzcxVar.zzb(i14);
                        int i17 = zzamVarZzb.zzr;
                        if (i17 > 0 && (i5 = zzamVarZzb.zzs) > 0) {
                            if (z2) {
                                if ((i17 <= i5 ? i14 : 1) != (i10 <= i11 ? i14 : 1)) {
                                    i7 = i10;
                                    i6 = i11;
                                } else {
                                    i6 = i10;
                                    i7 = i11;
                                }
                            } else {
                                i6 = i10;
                                i7 = i11;
                            }
                            int i18 = i17 * i7;
                            int i19 = i5 * i6;
                            if (i18 >= i19) {
                                int i20 = zzfk.zza;
                                point = new Point(i6, ((i19 + i17) - 1) / i17);
                            } else {
                                int i21 = zzfk.zza;
                                point = new Point(((i18 + i5) - 1) / i5, i7);
                            }
                            int i22 = zzamVarZzb.zzr;
                            int i23 = zzamVarZzb.zzs * i22;
                            if (i22 >= ((int) (point.x * 0.98f)) && zzamVarZzb.zzs >= ((int) (point.y * 0.98f)) && i23 < i15) {
                                i15 = i23;
                            }
                        }
                        c = 1;
                        i14 = 0;
                    }
                    i13 = i15;
                }
                zzfvp zzfvpVar = new zzfvp();
                char c2 = 0;
                while (true) {
                    int i24 = zzcxVar.zzb;
                    if (c2 > 0) {
                        return zzfvpVar.zzi();
                    }
                    int iZza = zzcxVar.zzb(0).zza();
                    zzfvpVar.zzf(new zzxh(i4, zzcxVar, 0, zzwwVar2, iArr4[0], i9, i13 == Integer.MAX_VALUE || (iZza != i12 && iZza <= i13)));
                    c2 = 1;
                    i12 = -1;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwn
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                List list = (List) obj;
                List list2 = (List) obj2;
                return zzfvh.zzj().zzc((zzxh) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxf
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxh.zzd((zzxh) obj3, (zzxh) obj4);
                    }
                }), (zzxh) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxf
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxh.zzd((zzxh) obj3, (zzxh) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzxf
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxh.zzd((zzxh) obj3, (zzxh) obj4);
                    }
                }).zzb(list.size(), list2.size()).zzc((zzxh) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxg
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxh.zza((zzxh) obj3, (zzxh) obj4);
                    }
                }), (zzxh) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxg
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxh.zza((zzxh) obj3, (zzxh) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzxg
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzxh.zza((zzxh) obj3, (zzxh) obj4);
                    }
                }).zza();
            }
        });
        if (pairZzv != null) {
            zzxjVarArr[((Integer) pairZzv.second).intValue()] = (zzxj) pairZzv.first;
        }
        int i4 = 0;
        while (true) {
            i = 1;
            if (i4 >= 2) {
                z = false;
                break;
            }
            if (zzxmVar.zzc(i4) == 2 && zzxmVar.zzd(i4).zzc > 0) {
                z = true;
                break;
            }
            i4++;
        }
        Pair pairZzv2 = zzv(1, zzxmVar, iArr, new zzxd() { // from class: com.google.android.gms.internal.ads.zzwk
            @Override // com.google.android.gms.internal.ads.zzxd
            public final List zza(int i5, zzcx zzcxVar, int[] iArr4) {
                final zzxi zzxiVar = this.zza;
                zzfsx zzfsxVar = new zzfsx() { // from class: com.google.android.gms.internal.ads.zzwj
                    @Override // com.google.android.gms.internal.ads.zzfsx
                    public final boolean zza(Object obj) {
                        return zzxi.zzl(zzxiVar, (zzam) obj);
                    }
                };
                zzfvp zzfvpVar = new zzfvp();
                int i6 = 0;
                while (true) {
                    int i7 = zzcxVar.zzb;
                    if (i6 > 0) {
                        return zzfvpVar.zzi();
                    }
                    zzfvpVar.zzf(new zzwq(i5, zzcxVar, i6, zzwwVar, iArr4[i6], z, zzfsxVar));
                    i6++;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwl
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzwq) Collections.max((List) obj)).zza((zzwq) Collections.max((List) obj2));
            }
        });
        if (pairZzv2 != null) {
            zzxjVarArr[((Integer) pairZzv2.second).intValue()] = (zzxj) pairZzv2.first;
        }
        final String str = pairZzv2 == null ? null : ((zzxj) pairZzv2.first).zza.zzb(((zzxj) pairZzv2.first).zzb[0]).zzd;
        int i5 = zzwwVar.zzv;
        int i6 = 3;
        Pair pairZzv3 = zzv(3, zzxmVar, iArr, new zzxd() { // from class: com.google.android.gms.internal.ads.zzwo
            @Override // com.google.android.gms.internal.ads.zzxd
            public final List zza(int i7, zzcx zzcxVar, int[] iArr4) {
                int i8 = zzxi.zzb;
                zzfvp zzfvpVar = new zzfvp();
                int i9 = 0;
                while (true) {
                    int i10 = zzcxVar.zzb;
                    if (i9 > 0) {
                        return zzfvpVar.zzi();
                    }
                    int i11 = i9;
                    zzfvpVar.zzf(new zzxc(i7, zzcxVar, i11, zzwwVar, iArr4[i9], str));
                    i9++;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwp
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzxc) ((List) obj).get(0)).zza((zzxc) ((List) obj2).get(0));
            }
        });
        if (pairZzv3 != null) {
            zzxjVarArr[((Integer) pairZzv3.second).intValue()] = (zzxj) pairZzv3.first;
        }
        int i7 = 0;
        while (i7 < i2) {
            int iZzc = zzxmVar.zzc(i7);
            if (iZzc != i2 && iZzc != i && iZzc != i6) {
                zzvx zzvxVarZzd = zzxmVar.zzd(i7);
                int[][] iArr4 = iArr[i7];
                int i8 = zzwwVar.zzv;
                zzcx zzcxVar = null;
                zzwr zzwrVar = null;
                for (int i9 = 0; i9 < zzvxVarZzd.zzc; i9++) {
                    zzcx zzcxVarZzb = zzvxVarZzd.zzb(i9);
                    int[] iArr5 = iArr4[i9];
                    char c = 0;
                    while (true) {
                        int i10 = zzcxVarZzb.zzb;
                        if (c <= 0) {
                            if (zzn(iArr5[0], zzwwVar.zzR)) {
                                zzwr zzwrVar2 = new zzwr(zzcxVarZzb.zzb(0), iArr5[0]);
                                if (zzwrVar == null || zzwrVar2.compareTo(zzwrVar) > 0) {
                                    zzwrVar = zzwrVar2;
                                    zzcxVar = zzcxVarZzb;
                                }
                            }
                            c = 1;
                        }
                    }
                }
                zzxjVarArr[i7] = zzcxVar == null ? null : new zzxj(zzcxVar, new int[]{0}, 0);
            }
            i7++;
            i2 = 2;
            i = 1;
            i6 = 3;
        }
        HashMap map = new HashMap();
        int i11 = 2;
        for (int i12 = 0; i12 < 2; i12++) {
            zzt(zzxmVar.zzd(i12), zzwwVar, map);
        }
        zzt(zzxmVar.zze(), zzwwVar, map);
        for (int i13 = 0; i13 < 2; i13++) {
            if (((zzcz) map.get(Integer.valueOf(zzxmVar.zzc(i13)))) != null) {
                throw null;
            }
        }
        int[] iArr6 = null;
        int i14 = 0;
        while (i14 < i11) {
            zzvx zzvxVarZzd2 = zzxmVar.zzd(i14);
            if (zzwwVar.zzg(i14, zzvxVarZzd2)) {
                zzxjVarArr[i14] = (zzwwVar.zze(i14, zzvxVarZzd2) == null || iArr6.length == 0) ? null : new zzxj(zzvxVarZzd2.zzb(0), iArr6, 0);
            }
            i14++;
            iArr6 = null;
            i11 = 2;
        }
        int i15 = 0;
        for (int i16 = i11; i15 < i16; i16 = 2) {
            int iZzc2 = zzxmVar.zzc(i15);
            if (zzwwVar.zzf(i15) || zzwwVar.zzD.contains(Integer.valueOf(iZzc2))) {
                zzxjVarArr[i15] = null;
            }
            i15++;
        }
        zzwd zzwdVar = this.zzj;
        zzxy zzxyVarZzq = zzq();
        zzfvs zzfvsVarZzf = zzwe.zzf(zzxjVarArr);
        int i17 = 2;
        zzxk[] zzxkVarArr = new zzxk[2];
        int i18 = 0;
        while (i18 < i17) {
            zzxj zzxjVar = zzxjVarArr[i18];
            if (zzxjVar == null || (length = (iArr3 = zzxjVar.zzb).length) == 0) {
                i18 = i18;
            } else {
                zzxkVarArr[i18] = length == 1 ? new zzxl(zzxjVar.zza, iArr3[0], 0, 0, null) : zzwdVar.zza(zzxjVar.zza, iArr3, 0, zzxyVarZzq, (zzfvs) zzfvsVarZzf.get(i18));
            }
            i18++;
            i17 = 2;
        }
        zzlu[] zzluVarArr = new zzlu[i17];
        for (int i19 = 0; i19 < i17; i19++) {
            zzluVarArr[i19] = (zzwwVar.zzf(i19) || zzwwVar.zzD.contains(Integer.valueOf(zzxmVar.zzc(i19))) || (zzxmVar.zzc(i19) != -2 && zzxkVarArr[i19] == null)) ? null : zzlu.zza;
        }
        boolean z2 = zzwwVar.zzS;
        int i20 = zzwwVar.zzv;
        return Pair.create(zzluVarArr, zzxkVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzls zzc() {
        return this;
    }

    public final zzww zzd() {
        zzww zzwwVar;
        synchronized (this.zze) {
            zzwwVar = this.zzg;
        }
        return zzwwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzi() {
        zzxb zzxbVar;
        synchronized (this.zze) {
            if (zzfk.zza >= 32 && (zzxbVar = this.zzh) != null) {
                zzxbVar.zzc();
            }
        }
        super.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzj(zzk zzkVar) {
        boolean z;
        synchronized (this.zze) {
            z = !this.zzi.equals(zzkVar);
            this.zzi = zzkVar;
        }
        if (z) {
            zzu();
        }
    }

    public final void zzk(zzwu zzwuVar) {
        boolean z;
        zzww zzwwVar = new zzww(zzwuVar);
        synchronized (this.zze) {
            z = !this.zzg.equals(zzwwVar);
            this.zzg = zzwwVar;
        }
        if (z) {
            if (zzwwVar.zzQ && this.zza == null) {
                zzer.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean zzm() {
        return true;
    }
}
