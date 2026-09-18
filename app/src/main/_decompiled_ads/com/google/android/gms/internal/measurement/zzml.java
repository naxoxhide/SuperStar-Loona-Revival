package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzml<T> implements zzmt<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zznu.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzmi zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzlw zzm;
    private final zznk zzn;
    private final zzko zzo;
    private final zzmn zzp;
    private final zzmd zzq;

    private zzml(int[] iArr, Object[] objArr, int i, int i2, zzmi zzmiVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzmn zzmnVar, zzlw zzlwVar, zznk zznkVar, zzko zzkoVar, zzmd zzmdVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zzkoVar != null && zzkoVar.zzc(zzmiVar)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzmnVar;
        this.zzm = zzlwVar;
        this.zzn = zznkVar;
        this.zzo = zzkoVar;
        this.zzg = zzmiVar;
        this.zzq = zzmdVar;
    }

    private final zzlf zzA(int i) {
        int i2 = i / 3;
        return (zzlf) this.zzd[i2 + i2 + 1];
    }

    private final zzmt zzB(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzmt zzmtVar = (zzmt) this.zzd[i3];
        if (zzmtVar != null) {
            return zzmtVar;
        }
        zzmt zzmtVarZzb = zzmq.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzmtVarZzb;
        return zzmtVarZzb;
    }

    private final Object zzC(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzD(Object obj, int i) {
        zzmt zzmtVarZzB = zzB(i);
        int iZzy = zzy(i) & 1048575;
        if (!zzP(obj, i)) {
            return zzmtVarZzB.zze();
        }
        Object object = zzb.getObject(obj, iZzy);
        if (zzS(object)) {
            return object;
        }
        Object objZze = zzmtVarZzB.zze();
        if (object != null) {
            zzmtVarZzB.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzE(Object obj, int i, int i2) {
        zzmt zzmtVarZzB = zzB(i2);
        if (!zzT(obj, i, i2)) {
            return zzmtVarZzB.zze();
        }
        Object object = zzb.getObject(obj, zzy(i2) & 1048575);
        if (zzS(object)) {
            return object;
        }
        Object objZze = zzmtVarZzB.zze();
        if (object != null) {
            zzmtVarZzB.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzF(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzG(Object obj) {
        if (!zzS(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        if (zzP(obj2, i)) {
            int iZzy = zzy(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzy;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzmt zzmtVarZzB = zzB(i);
            if (!zzP(obj, i)) {
                if (zzS(object)) {
                    Object objZze = zzmtVarZzB.zze();
                    zzmtVarZzB.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzJ(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzS(object2)) {
                Object objZze2 = zzmtVarZzB.zze();
                zzmtVarZzB.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzmtVarZzB.zzg(object2, object);
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzT(obj2, i2, i)) {
            int iZzy = zzy(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzy;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzmt zzmtVarZzB = zzB(i);
            if (!zzT(obj, i2, i)) {
                if (zzS(object)) {
                    Object objZze = zzmtVarZzB.zze();
                    zzmtVarZzB.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzK(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzS(object2)) {
                Object objZze2 = zzmtVarZzB.zze();
                zzmtVarZzB.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzmtVarZzB.zzg(object2, object);
        }
    }

    private final void zzJ(Object obj, int i) {
        int iZzv = zzv(i);
        long j = 1048575 & iZzv;
        if (j == 1048575) {
            return;
        }
        zznu.zzq(obj, j, (1 << (iZzv >>> 20)) | zznu.zzc(obj, j));
    }

    private final void zzK(Object obj, int i, int i2) {
        zznu.zzq(obj, zzv(i2) & 1048575, i);
    }

    private final void zzL(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzy(i) & 1048575, obj2);
        zzJ(obj, i);
    }

    private final void zzM(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzy(i2) & 1048575, obj2);
        zzK(obj, i, i2);
    }

    private final void zzN(zzoc zzocVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private final boolean zzO(Object obj, Object obj2, int i) {
        return zzP(obj, i) == zzP(obj2, i);
    }

    private final boolean zzP(Object obj, int i) {
        int iZzv = zzv(i);
        long j = iZzv & 1048575;
        if (j != 1048575) {
            return (zznu.zzc(obj, j) & (1 << (iZzv >>> 20))) != 0;
        }
        int iZzy = zzy(i);
        long j2 = iZzy & 1048575;
        switch (zzx(iZzy)) {
            case 0:
                return Double.doubleToRawLongBits(zznu.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zznu.zzb(obj, j2)) != 0;
            case 2:
                return zznu.zzd(obj, j2) != 0;
            case 3:
                return zznu.zzd(obj, j2) != 0;
            case 4:
                return zznu.zzc(obj, j2) != 0;
            case 5:
                return zznu.zzd(obj, j2) != 0;
            case 6:
                return zznu.zzc(obj, j2) != 0;
            case 7:
                return zznu.zzw(obj, j2);
            case 8:
                Object objZzf = zznu.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzka) {
                    return !zzka.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zznu.zzf(obj, j2) != null;
            case 10:
                return !zzka.zzb.equals(zznu.zzf(obj, j2));
            case 11:
                return zznu.zzc(obj, j2) != 0;
            case 12:
                return zznu.zzc(obj, j2) != 0;
            case 13:
                return zznu.zzc(obj, j2) != 0;
            case 14:
                return zznu.zzd(obj, j2) != 0;
            case 15:
                return zznu.zzc(obj, j2) != 0;
            case 16:
                return zznu.zzd(obj, j2) != 0;
            case 17:
                return zznu.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzQ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzP(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzR(Object obj, int i, zzmt zzmtVar) {
        return zzmtVar.zzk(zznu.zzf(obj, i & 1048575));
    }

    private static boolean zzS(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzlb) {
            return ((zzlb) obj).zzbR();
        }
        return true;
    }

    private final boolean zzT(Object obj, int i, int i2) {
        return zznu.zzc(obj, (long) (zzv(i2) & 1048575)) == i;
    }

    private static boolean zzU(Object obj, long j) {
        return ((Boolean) zznu.zzf(obj, j)).booleanValue();
    }

    private static final void zzV(int i, Object obj, zzoc zzocVar) throws IOException {
        if (obj instanceof String) {
            zzocVar.zzF(i, (String) obj);
        } else {
            zzocVar.zzd(i, (zzka) obj);
        }
    }

    static zznl zzd(Object obj) {
        zzlb zzlbVar = (zzlb) obj;
        zznl zznlVar = zzlbVar.zzc;
        if (zznlVar != zznl.zzc()) {
            return zznlVar;
        }
        zznl zznlVarZzf = zznl.zzf();
        zzlbVar.zzc = zznlVarZzf;
        return zznlVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x026d  */
    /* JADX WARN: Code duplicated, block: B:125:0x0270  */
    /* JADX WARN: Code duplicated, block: B:128:0x0285  */
    /* JADX WARN: Code duplicated, block: B:129:0x0288  */
    /* JADX WARN: Code duplicated, block: B:178:0x0372  */
    static zzml zzl(Class cls, zzmf zzmfVar, zzmn zzmnVar, zzlw zzlwVar, zznk zznkVar, zzko zzkoVar, zzmd zzmdVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i17;
        int i18;
        Field fieldZzF;
        char cCharAt9;
        int i19;
        int i20;
        int i21;
        int i22;
        Object obj;
        Field fieldZzF2;
        int i23;
        Object obj2;
        Field fieldZzF3;
        int i24;
        char cCharAt10;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        if (!(zzmfVar instanceof zzms)) {
            throw null;
        }
        zzms zzmsVar = (zzms) zzmfVar;
        int iZzc = zzmsVar.zzc();
        String strZzd = zzmsVar.zzd();
        int length = strZzd.length();
        int i28 = 0;
        int i29 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i30 = 1;
            while (true) {
                i = i30 + 1;
                if (strZzd.charAt(i30) < 55296) {
                    break;
                }
                i30 = i;
            }
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i32 = iCharAt3 & 8191;
            int i33 = 13;
            while (true) {
                i27 = i31 + 1;
                cCharAt13 = strZzd.charAt(i31);
                if (cCharAt13 < 55296) {
                    break;
                }
                i32 |= (cCharAt13 & 8191) << i33;
                i33 += 13;
                i31 = i27;
            }
            iCharAt3 = i32 | (cCharAt13 << i33);
            i31 = i27;
        }
        if (iCharAt3 == 0) {
            i3 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i5 = 0;
            i4 = 0;
            iArr = zza;
            i2 = 0;
        } else {
            int i34 = i31 + 1;
            int iCharAt4 = strZzd.charAt(i31);
            if (iCharAt4 >= 55296) {
                int i35 = iCharAt4 & 8191;
                int i36 = 13;
                while (true) {
                    i13 = i34 + 1;
                    cCharAt8 = strZzd.charAt(i34);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt8 & 8191) << i36;
                    i36 += 13;
                    i34 = i13;
                }
                iCharAt4 = i35 | (cCharAt8 << i36);
                i34 = i13;
            }
            int i37 = i34 + 1;
            int iCharAt5 = strZzd.charAt(i34);
            if (iCharAt5 >= 55296) {
                int i38 = iCharAt5 & 8191;
                int i39 = 13;
                while (true) {
                    i12 = i37 + 1;
                    cCharAt7 = strZzd.charAt(i37);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt7 & 8191) << i39;
                    i39 += 13;
                    i37 = i12;
                }
                iCharAt5 = i38 | (cCharAt7 << i39);
                i37 = i12;
            }
            int i40 = i37 + 1;
            int iCharAt6 = strZzd.charAt(i37);
            if (iCharAt6 >= 55296) {
                int i41 = iCharAt6 & 8191;
                int i42 = 13;
                while (true) {
                    i11 = i40 + 1;
                    cCharAt6 = strZzd.charAt(i40);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt6 & 8191) << i42;
                    i42 += 13;
                    i40 = i11;
                }
                iCharAt6 = i41 | (cCharAt6 << i42);
                i40 = i11;
            }
            int i43 = i40 + 1;
            int iCharAt7 = strZzd.charAt(i40);
            if (iCharAt7 >= 55296) {
                int i44 = iCharAt7 & 8191;
                int i45 = 13;
                while (true) {
                    i10 = i43 + 1;
                    cCharAt5 = strZzd.charAt(i43);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt5 & 8191) << i45;
                    i45 += 13;
                    i43 = i10;
                }
                iCharAt7 = i44 | (cCharAt5 << i45);
                i43 = i10;
            }
            int i46 = i43 + 1;
            iCharAt = strZzd.charAt(i43);
            if (iCharAt >= 55296) {
                int i47 = iCharAt & 8191;
                int i48 = 13;
                while (true) {
                    i9 = i46 + 1;
                    cCharAt4 = strZzd.charAt(i46);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt4 & 8191) << i48;
                    i48 += 13;
                    i46 = i9;
                }
                iCharAt = i47 | (cCharAt4 << i48);
                i46 = i9;
            }
            int i49 = i46 + 1;
            iCharAt2 = strZzd.charAt(i46);
            if (iCharAt2 >= 55296) {
                int i50 = iCharAt2 & 8191;
                int i51 = 13;
                while (true) {
                    i8 = i49 + 1;
                    cCharAt3 = strZzd.charAt(i49);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt3 & 8191) << i51;
                    i51 += 13;
                    i49 = i8;
                }
                iCharAt2 = i50 | (cCharAt3 << i51);
                i49 = i8;
            }
            int i52 = i49 + 1;
            int iCharAt8 = strZzd.charAt(i49);
            if (iCharAt8 >= 55296) {
                int i53 = iCharAt8 & 8191;
                int i54 = 13;
                while (true) {
                    i7 = i52 + 1;
                    cCharAt2 = strZzd.charAt(i52);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt2 & 8191) << i54;
                    i54 += 13;
                    i52 = i7;
                }
                iCharAt8 = i53 | (cCharAt2 << i54);
                i52 = i7;
            }
            int i55 = i52 + 1;
            int iCharAt9 = strZzd.charAt(i52);
            if (iCharAt9 >= 55296) {
                int i56 = iCharAt9 & 8191;
                int i57 = i55;
                int i58 = 13;
                while (true) {
                    i6 = i57 + 1;
                    cCharAt = strZzd.charAt(i57);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i56 |= (cCharAt & 8191) << i58;
                    i58 += 13;
                    i57 = i6;
                }
                iCharAt9 = i56 | (cCharAt << i58);
                i55 = i6;
            }
            int i59 = iCharAt9 + iCharAt2 + iCharAt8;
            int i60 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[i59];
            i28 = iCharAt4;
            iArr = iArr2;
            i2 = iCharAt6;
            i3 = i60;
            i4 = iCharAt9;
            i31 = i55;
            i5 = iCharAt7;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzmsVar.zze();
        Class<?> cls2 = zzmsVar.zza().getClass();
        int i61 = i4 + iCharAt2;
        int i62 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i62];
        int i63 = i4;
        int i64 = i61;
        int i65 = 0;
        int i66 = 0;
        while (true) {
            boolean z = iZzc == 2;
            if (i31 >= length) {
                return new zzml(iArr3, objArr, i2, i5, zzmsVar.zza(), z, false, iArr, i4, i61, zzmnVar, zzlwVar, zznkVar, zzkoVar, zzmdVar);
            }
            int i67 = i31 + 1;
            int iCharAt10 = strZzd.charAt(i31);
            if (iCharAt10 >= i29) {
                int i68 = iCharAt10 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i26 = i69 + 1;
                    cCharAt12 = strZzd.charAt(i69);
                    i14 = iZzc;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i68 |= (cCharAt12 & 8191) << i70;
                    i70 += 13;
                    i69 = i26;
                    iZzc = i14;
                }
                iCharAt10 = i68 | (cCharAt12 << i70);
                i15 = i26;
            } else {
                i14 = iZzc;
                i15 = i67;
            }
            int i71 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            int i72 = length;
            char c = 55296;
            if (iCharAt11 >= 55296) {
                int i73 = iCharAt11 & 8191;
                int i74 = 13;
                while (true) {
                    i25 = i71 + 1;
                    cCharAt11 = strZzd.charAt(i71);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i74;
                    i74 += 13;
                    i71 = i25;
                    c = 55296;
                }
                iCharAt11 = i73 | (cCharAt11 << i74);
                i71 = i25;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i65] = i66;
                i65++;
            }
            int i75 = iCharAt11 & 255;
            int i76 = i5;
            if (i75 >= 51) {
                int i77 = i71 + 1;
                int iCharAt12 = strZzd.charAt(i71);
                if (iCharAt12 >= 55296) {
                    int i78 = iCharAt12 & 8191;
                    int i79 = i77;
                    int i80 = 13;
                    while (true) {
                        i24 = i79 + 1;
                        cCharAt10 = strZzd.charAt(i79);
                        i16 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i78 |= (cCharAt10 & 8191) << i80;
                        i80 += 13;
                        i79 = i24;
                        i2 = i16;
                    }
                    iCharAt12 = i78 | (cCharAt10 << i80);
                    i20 = i24;
                } else {
                    i16 = i2;
                    i20 = i77;
                }
                int i81 = i75 - 51;
                int i82 = i20;
                if (i81 == 9 || i81 == 17) {
                    int i83 = i66 / 3;
                    i21 = i3 + 1;
                    objArr[i83 + i83 + 1] = objArrZze[i3];
                } else {
                    if (i81 == 12 && !z) {
                        int i84 = i66 / 3;
                        i21 = i3 + 1;
                        objArr[i84 + i84 + 1] = objArrZze[i3];
                    }
                    i22 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i22];
                    if (obj instanceof Field) {
                        fieldZzF2 = (Field) obj;
                    } else {
                        fieldZzF2 = zzF(cls2, (String) obj);
                        objArrZze[i22] = fieldZzF2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzF2);
                    i23 = i22 + 1;
                    obj2 = objArrZze[i23];
                    if (obj2 instanceof Field) {
                        fieldZzF3 = (Field) obj2;
                    } else {
                        fieldZzF3 = zzF(cls2, (String) obj2);
                        objArrZze[i23] = fieldZzF3;
                    }
                    iObjectFieldOffset = iObjectFieldOffset3;
                    objArrZze = objArrZze;
                    i17 = i82;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzF3);
                    i18 = 0;
                }
                i3 = i21;
                i22 = iCharAt12 + iCharAt12;
                obj = objArrZze[i22];
                if (obj instanceof Field) {
                    fieldZzF2 = (Field) obj;
                } else {
                    fieldZzF2 = zzF(cls2, (String) obj);
                    objArrZze[i22] = fieldZzF2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzF2);
                i23 = i22 + 1;
                obj2 = objArrZze[i23];
                if (obj2 instanceof Field) {
                    fieldZzF3 = (Field) obj2;
                } else {
                    fieldZzF3 = zzF(cls2, (String) obj2);
                    objArrZze[i23] = fieldZzF3;
                }
                iObjectFieldOffset = iObjectFieldOffset4;
                objArrZze = objArrZze;
                i17 = i82;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzF3);
                i18 = 0;
            } else {
                i16 = i2;
                int i85 = i3 + 1;
                Field fieldZzF4 = zzF(cls2, (String) objArrZze[i3]);
                if (i75 == 9 || i75 == 17) {
                    int i86 = i66 / 3;
                    objArr[i86 + i86 + 1] = fieldZzF4.getType();
                } else {
                    if (i75 == 27 || i75 == 49) {
                        int i87 = i66 / 3;
                        i19 = i85 + 1;
                        objArr[i87 + i87 + 1] = objArrZze[i85];
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        if (!z) {
                            int i88 = i66 / 3;
                            i19 = i85 + 1;
                            objArr[i88 + i88 + 1] = objArrZze[i85];
                        }
                    } else if (i75 == 50) {
                        int i89 = i63 + 1;
                        iArr[i63] = i66;
                        int i90 = i66 / 3;
                        int i91 = i85 + 1;
                        int i92 = i90 + i90;
                        objArr[i92] = objArrZze[i85];
                        if ((iCharAt11 & 2048) != 0) {
                            i85 = i91 + 1;
                            objArr[i92 + 1] = objArrZze[i91];
                            i63 = i89;
                        } else {
                            i85 = i91;
                            i63 = i89;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzF4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) == 4096 || i75 > 17) {
                            i17 = i71;
                            i18 = 0;
                        } else {
                            int i93 = i71 + 1;
                            int iCharAt13 = strZzd.charAt(i71);
                            if (iCharAt13 >= 55296) {
                                int i94 = iCharAt13 & 8191;
                                int i95 = 13;
                                while (true) {
                                    i17 = i93 + 1;
                                    cCharAt9 = strZzd.charAt(i93);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i94 |= (cCharAt9 & 8191) << i95;
                                    i95 += 13;
                                    i93 = i17;
                                }
                                iCharAt13 = i94 | (cCharAt9 << i95);
                            } else {
                                i17 = i93;
                            }
                            int i96 = i28 + i28 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i96];
                            if (obj3 instanceof Field) {
                                fieldZzF = (Field) obj3;
                            } else {
                                fieldZzF = zzF(cls2, (String) obj3);
                                objArrZze[i96] = fieldZzF;
                            }
                            i18 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzF);
                        }
                        if (i75 >= 18 && i75 <= 49) {
                            iArr[i64] = iObjectFieldOffset;
                            i64++;
                        }
                        i3 = i85;
                    }
                    i85 = i19;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzF4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) == 4096) {
                    i17 = i71;
                    i18 = 0;
                } else {
                    i17 = i71;
                    i18 = 0;
                }
                if (i75 >= 18) {
                    iArr[i64] = iObjectFieldOffset;
                    i64++;
                }
                i3 = i85;
            }
            int i97 = i66 + 1;
            iArr3[i66] = iCharAt10;
            int i98 = i97 + 1;
            iArr3[i97] = ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i75 << 20) | iObjectFieldOffset;
            i66 = i98 + 1;
            iArr3[i98] = (i18 << 20) | iObjectFieldOffset2;
            objArrZze = objArrZze;
            length = i72;
            i31 = i17;
            i5 = i76;
            iZzc = i14;
            i2 = i16;
            i29 = 55296;
        }
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zznu.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zznu.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzo(Object obj) {
        int i;
        int iZzx;
        int iZzx2;
        int iZzy;
        int iZzx3;
        int iZzx4;
        int iZzx5;
        int iZzx6;
        int iZzt;
        boolean z;
        int iZzc;
        int iZzh;
        int iZzx7;
        int iZzx8;
        int iZzx9;
        int iZzx10;
        int iZzx11;
        int iZzx12;
        int iZzx13;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int iZzx14 = 0;
        int i5 = 0;
        while (i4 < this.zzc.length) {
            int iZzy2 = zzy(i4);
            int[] iArr = this.zzc;
            int i6 = iArr[i4];
            int iZzx15 = zzx(iZzy2);
            if (iZzx15 <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                int i9 = i7 >>> 20;
                if (i8 != i3) {
                    i5 = unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << i9;
            } else {
                i = 0;
            }
            long j = iZzy2 & i2;
            switch (iZzx15) {
                case 0:
                    if ((i5 & i) != 0) {
                        iZzx = zzki.zzx(i6 << 3);
                        iZzx4 = iZzx + 8;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 1:
                    if ((i5 & i) != 0) {
                        iZzx2 = zzki.zzx(i6 << 3);
                        iZzx4 = iZzx2 + 4;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 2:
                    if ((i5 & i) != 0) {
                        iZzy = zzki.zzy(unsafe.getLong(obj, j));
                        iZzx3 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 3:
                    if ((i5 & i) != 0) {
                        iZzy = zzki.zzy(unsafe.getLong(obj, j));
                        iZzx3 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 4:
                    if ((i5 & i) != 0) {
                        iZzy = zzki.zzu(unsafe.getInt(obj, j));
                        iZzx3 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 5:
                    if ((i5 & i) != 0) {
                        iZzx = zzki.zzx(i6 << 3);
                        iZzx4 = iZzx + 8;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 6:
                    if ((i5 & i) != 0) {
                        iZzx2 = zzki.zzx(i6 << 3);
                        iZzx4 = iZzx2 + 4;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 7:
                    if ((i5 & i) != 0) {
                        iZzx4 = zzki.zzx(i6 << 3) + 1;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 8:
                    if ((i5 & i) != 0) {
                        Object object = unsafe.getObject(obj, j);
                        if (!(object instanceof zzka)) {
                            iZzy = zzki.zzw((String) object);
                            iZzx3 = zzki.zzx(i6 << 3);
                            iZzx14 += iZzx3 + iZzy;
                        } else {
                            int i10 = zzki.zzb;
                            int iZzd = ((zzka) object).zzd();
                            iZzx5 = zzki.zzx(iZzd) + iZzd;
                            iZzx6 = zzki.zzx(i6 << 3);
                            iZzx4 = iZzx6 + iZzx5;
                            iZzx14 += iZzx4;
                        }
                    }
                    break;
                case 9:
                    if ((i5 & i) != 0) {
                        iZzx4 = zzmv.zzn(i6, unsafe.getObject(obj, j), zzB(i4));
                        iZzx14 += iZzx4;
                    }
                    break;
                case 10:
                    if ((i5 & i) != 0) {
                        zzka zzkaVar = (zzka) unsafe.getObject(obj, j);
                        int i11 = zzki.zzb;
                        int iZzd2 = zzkaVar.zzd();
                        iZzx5 = zzki.zzx(iZzd2) + iZzd2;
                        iZzx6 = zzki.zzx(i6 << 3);
                        iZzx4 = iZzx6 + iZzx5;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 11:
                    if ((i5 & i) != 0) {
                        iZzy = zzki.zzx(unsafe.getInt(obj, j));
                        iZzx3 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 12:
                    if ((i5 & i) != 0) {
                        iZzy = zzki.zzu(unsafe.getInt(obj, j));
                        iZzx3 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 13:
                    if ((i5 & i) != 0) {
                        iZzx2 = zzki.zzx(i6 << 3);
                        iZzx4 = iZzx2 + 4;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 14:
                    if ((i5 & i) != 0) {
                        iZzx = zzki.zzx(i6 << 3);
                        iZzx4 = iZzx + 8;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 15:
                    if ((i5 & i) != 0) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzx3 = zzki.zzx(i6 << 3);
                        iZzy = zzki.zzx((i12 >> 31) ^ (i12 + i12));
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 16:
                    if ((i & i5) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzx14 += zzki.zzx(i6 << 3) + zzki.zzy((j2 >> 63) ^ (j2 + j2));
                    }
                    break;
                case 17:
                    if ((i5 & i) != 0) {
                        iZzx4 = zzki.zzt(i6, (zzmi) unsafe.getObject(obj, j), zzB(i4));
                        iZzx14 += iZzx4;
                    }
                    break;
                case 18:
                    iZzx4 = zzmv.zzg(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 19:
                    iZzx4 = zzmv.zze(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 20:
                    iZzx4 = zzmv.zzl(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 21:
                    iZzx4 = zzmv.zzw(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 22:
                    iZzx4 = zzmv.zzj(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 23:
                    iZzx4 = zzmv.zzg(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 24:
                    iZzx4 = zzmv.zze(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 25:
                    iZzx4 = zzmv.zza(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 26:
                    iZzt = zzmv.zzt(i6, (List) unsafe.getObject(obj, j));
                    iZzx14 += iZzt;
                    break;
                case 27:
                    iZzt = zzmv.zzo(i6, (List) unsafe.getObject(obj, j), zzB(i4));
                    iZzx14 += iZzt;
                    break;
                case 28:
                    iZzt = zzmv.zzb(i6, (List) unsafe.getObject(obj, j));
                    iZzx14 += iZzt;
                    break;
                case 29:
                    iZzt = zzmv.zzu(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzt;
                    break;
                case 30:
                    z = false;
                    iZzc = zzmv.zzc(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 31:
                    z = false;
                    iZzc = zzmv.zze(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 32:
                    z = false;
                    iZzc = zzmv.zzg(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 33:
                    z = false;
                    iZzc = zzmv.zzp(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 34:
                    z = false;
                    iZzc = zzmv.zzr(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 35:
                    iZzh = zzmv.zzh((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 36:
                    iZzh = zzmv.zzf((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 37:
                    iZzh = zzmv.zzm((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 38:
                    iZzh = zzmv.zzx((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 39:
                    iZzh = zzmv.zzk((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 40:
                    iZzh = zzmv.zzh((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 41:
                    iZzh = zzmv.zzf((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzmv.zza;
                    iZzh = list.size();
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 43:
                    iZzh = zzmv.zzv((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 44:
                    iZzh = zzmv.zzd((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 45:
                    iZzh = zzmv.zzf((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 46:
                    iZzh = zzmv.zzh((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 47:
                    iZzh = zzmv.zzq((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 48:
                    iZzh = zzmv.zzs((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzki.zzx(iZzh);
                        iZzx8 = zzki.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 49:
                    iZzt = zzmv.zzi(i6, (List) unsafe.getObject(obj, j), zzB(i4));
                    iZzx14 += iZzt;
                    break;
                case 50:
                    zzmd.zza(i6, unsafe.getObject(obj, j), zzC(i4));
                    break;
                case 51:
                    if (zzT(obj, i6, i4)) {
                        iZzx10 = zzki.zzx(i6 << 3);
                        iZzt = iZzx10 + 8;
                        iZzx14 += iZzt;
                    }
                    break;
                case 52:
                    if (zzT(obj, i6, i4)) {
                        iZzx11 = zzki.zzx(i6 << 3);
                        iZzt = iZzx11 + 4;
                        iZzx14 += iZzt;
                    }
                    break;
                case 53:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzki.zzy(zzz(obj, j));
                        iZzx9 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 54:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzki.zzy(zzz(obj, j));
                        iZzx9 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 55:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzki.zzu(zzp(obj, j));
                        iZzx9 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 56:
                    if (zzT(obj, i6, i4)) {
                        iZzx10 = zzki.zzx(i6 << 3);
                        iZzt = iZzx10 + 8;
                        iZzx14 += iZzt;
                    }
                    break;
                case 57:
                    if (zzT(obj, i6, i4)) {
                        iZzx11 = zzki.zzx(i6 << 3);
                        iZzt = iZzx11 + 4;
                        iZzx14 += iZzt;
                    }
                    break;
                case 58:
                    if (zzT(obj, i6, i4)) {
                        iZzt = zzki.zzx(i6 << 3) + 1;
                        iZzx14 += iZzt;
                    }
                    break;
                case 59:
                    if (zzT(obj, i6, i4)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzka) {
                            int i14 = zzki.zzb;
                            int iZzd3 = ((zzka) object2).zzd();
                            iZzx12 = zzki.zzx(iZzd3) + iZzd3;
                            iZzx13 = zzki.zzx(i6 << 3);
                            iZzt = iZzx13 + iZzx12;
                            iZzx14 += iZzt;
                        } else {
                            iZzh = zzki.zzw((String) object2);
                            iZzx9 = zzki.zzx(i6 << 3);
                            iZzx14 += iZzx9 + iZzh;
                        }
                    }
                    break;
                case 60:
                    if (zzT(obj, i6, i4)) {
                        iZzt = zzmv.zzn(i6, unsafe.getObject(obj, j), zzB(i4));
                        iZzx14 += iZzt;
                    }
                    break;
                case 61:
                    if (zzT(obj, i6, i4)) {
                        zzka zzkaVar2 = (zzka) unsafe.getObject(obj, j);
                        int i15 = zzki.zzb;
                        int iZzd4 = zzkaVar2.zzd();
                        iZzx12 = zzki.zzx(iZzd4) + iZzd4;
                        iZzx13 = zzki.zzx(i6 << 3);
                        iZzt = iZzx13 + iZzx12;
                        iZzx14 += iZzt;
                    }
                    break;
                case 62:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzki.zzx(zzp(obj, j));
                        iZzx9 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 63:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzki.zzu(zzp(obj, j));
                        iZzx9 = zzki.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 64:
                    if (zzT(obj, i6, i4)) {
                        iZzx11 = zzki.zzx(i6 << 3);
                        iZzt = iZzx11 + 4;
                        iZzx14 += iZzt;
                    }
                    break;
                case 65:
                    if (zzT(obj, i6, i4)) {
                        iZzx10 = zzki.zzx(i6 << 3);
                        iZzt = iZzx10 + 8;
                        iZzx14 += iZzt;
                    }
                    break;
                case 66:
                    if (zzT(obj, i6, i4)) {
                        int iZzp = zzp(obj, j);
                        iZzx9 = zzki.zzx(i6 << 3);
                        iZzh = zzki.zzx((iZzp >> 31) ^ (iZzp + iZzp));
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 67:
                    if (zzT(obj, i6, i4)) {
                        long jZzz = zzz(obj, j);
                        iZzx14 += zzki.zzx(i6 << 3) + zzki.zzy((jZzz >> 63) ^ (jZzz + jZzz));
                    }
                    break;
                case 68:
                    if (zzT(obj, i6, i4)) {
                        iZzt = zzki.zzt(i6, (zzmi) unsafe.getObject(obj, j), zzB(i4));
                        iZzx14 += iZzt;
                    }
                    break;
                default:
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        zznk zznkVar = this.zzn;
        int iZza = iZzx14 + zznkVar.zza(zznkVar.zzd(obj));
        if (!this.zzh) {
            return iZza;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zznu.zzf(obj, j)).intValue();
    }

    private final int zzq(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzjn zzjnVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzC = zzC(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzmc) object).zze()) {
            zzmc zzmcVarZzb = zzmc.zza().zzb();
            zzmd.zzb(zzmcVarZzb, object);
            unsafe.putObject(obj, j, zzmcVarZzb);
        }
        throw null;
    }

    private final int zzr(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzjn zzjnVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzjo.zzp(bArr, i))));
                int i9 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzjo.zzb(bArr, i))));
                int i10 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iZzm = zzjo.zzm(bArr, i, zzjnVar);
                unsafe.putObject(obj, j, Long.valueOf(zzjnVar.zzb));
                unsafe.putInt(obj, j2, i4);
                return iZzm;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iZzj = zzjo.zzj(bArr, i, zzjnVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzjnVar.zza));
                unsafe.putInt(obj, j2, i4);
                return iZzj;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(zzjo.zzp(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(zzjo.zzb(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iZzm2 = zzjo.zzm(bArr, i, zzjnVar);
                unsafe.putObject(obj, j, Boolean.valueOf(zzjnVar.zzb != 0));
                unsafe.putInt(obj, j2, i4);
                return iZzm2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZzj2 = zzjo.zzj(bArr, i, zzjnVar);
                int i13 = zzjnVar.zza;
                if (i13 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zznz.zze(bArr, iZzj2, iZzj2 + i13)) {
                        throw zzll.zzc();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iZzj2, i13, zzlj.zzb));
                    iZzj2 += i13;
                }
                unsafe.putInt(obj, j2, i4);
                return iZzj2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                Object objZzE = zzE(obj, i4, i8);
                int iZzo = zzjo.zzo(objZzE, zzB(i8), bArr, i, i2, zzjnVar);
                zzM(obj, i4, i8, objZzE);
                return iZzo;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzjo.zza(bArr, i, zzjnVar);
                unsafe.putObject(obj, j, zzjnVar.zzc);
                unsafe.putInt(obj, j2, i4);
                return iZza;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZzj3 = zzjo.zzj(bArr, i, zzjnVar);
                int i14 = zzjnVar.zza;
                zzlf zzlfVarZzA = zzA(i8);
                if (zzlfVarZzA == null || zzlfVarZzA.zza(i14)) {
                    unsafe.putObject(obj, j, Integer.valueOf(i14));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    zzd(obj).zzj(i3, Long.valueOf(i14));
                }
                return iZzj3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iZzj4 = zzjo.zzj(bArr, i, zzjnVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzke.zzb(zzjnVar.zza)));
                unsafe.putInt(obj, j2, i4);
                return iZzj4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iZzm3 = zzjo.zzm(bArr, i, zzjnVar);
                unsafe.putObject(obj, j, Long.valueOf(zzke.zzc(zzjnVar.zzb)));
                unsafe.putInt(obj, j2, i4);
                return iZzm3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                Object objZzE2 = zzE(obj, i4, i8);
                int iZzn = zzjo.zzn(objZzE2, zzB(i8), bArr, i, i2, (i3 & (-8)) | 4, zzjnVar);
                zzM(obj, i4, i8, objZzE2);
                return iZzn;
            default:
                return i;
        }
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzjn zzjnVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzl;
        int iZzj = i;
        Unsafe unsafe = zzb;
        zzli zzliVarZzd = (zzli) unsafe.getObject(obj, j2);
        if (!zzliVarZzd.zzc()) {
            int size = zzliVarZzd.size();
            zzliVarZzd = zzliVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzliVarZzd);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzkk zzkkVar = (zzkk) zzliVarZzd;
                    int iZzj2 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i12 = zzjnVar.zza + iZzj2;
                    while (iZzj2 < i12) {
                        zzkkVar.zze(Double.longBitsToDouble(zzjo.zzp(bArr, iZzj2)));
                        iZzj2 += 8;
                    }
                    if (iZzj2 == i12) {
                        return iZzj2;
                    }
                    throw zzll.zzf();
                }
                if (i5 == 1) {
                    zzkk zzkkVar2 = (zzkk) zzliVarZzd;
                    zzkkVar2.zze(Double.longBitsToDouble(zzjo.zzp(bArr, i)));
                    while (true) {
                        i8 = iZzj + 8;
                        if (i8 < i2) {
                            iZzj = zzjo.zzj(bArr, i8, zzjnVar);
                            if (i3 == zzjnVar.zza) {
                                zzkkVar2.zze(Double.longBitsToDouble(zzjo.zzp(bArr, iZzj)));
                            }
                        }
                    }
                    return i8;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzku zzkuVar = (zzku) zzliVarZzd;
                    int iZzj3 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i13 = zzjnVar.zza + iZzj3;
                    while (iZzj3 < i13) {
                        zzkuVar.zze(Float.intBitsToFloat(zzjo.zzb(bArr, iZzj3)));
                        iZzj3 += 4;
                    }
                    if (iZzj3 == i13) {
                        return iZzj3;
                    }
                    throw zzll.zzf();
                }
                if (i5 == 5) {
                    zzku zzkuVar2 = (zzku) zzliVarZzd;
                    zzkuVar2.zze(Float.intBitsToFloat(zzjo.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj + 4;
                        if (i9 < i2) {
                            iZzj = zzjo.zzj(bArr, i9, zzjnVar);
                            if (i3 == zzjnVar.zza) {
                                zzkuVar2.zze(Float.intBitsToFloat(zzjo.zzb(bArr, iZzj)));
                            }
                        }
                    }
                    return i9;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzlx zzlxVar = (zzlx) zzliVarZzd;
                    int iZzj4 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i14 = zzjnVar.zza + iZzj4;
                    while (iZzj4 < i14) {
                        iZzj4 = zzjo.zzm(bArr, iZzj4, zzjnVar);
                        zzlxVar.zzg(zzjnVar.zzb);
                    }
                    if (iZzj4 == i14) {
                        return iZzj4;
                    }
                    throw zzll.zzf();
                }
                if (i5 == 0) {
                    zzlx zzlxVar2 = (zzlx) zzliVarZzd;
                    int iZzm = zzjo.zzm(bArr, iZzj, zzjnVar);
                    zzlxVar2.zzg(zzjnVar.zzb);
                    while (iZzm < i2) {
                        int iZzj5 = zzjo.zzj(bArr, iZzm, zzjnVar);
                        if (i3 != zzjnVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzjo.zzm(bArr, iZzj5, zzjnVar);
                        zzlxVar2.zzg(zzjnVar.zzb);
                    }
                    return iZzm;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzjo.zzf(bArr, iZzj, zzliVarZzd, zzjnVar);
                }
                if (i5 == 0) {
                    return zzjo.zzl(i3, bArr, i, i2, zzliVarZzd, zzjnVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzlx zzlxVar3 = (zzlx) zzliVarZzd;
                    int iZzj6 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i15 = zzjnVar.zza + iZzj6;
                    while (iZzj6 < i15) {
                        zzlxVar3.zzg(zzjo.zzp(bArr, iZzj6));
                        iZzj6 += 8;
                    }
                    if (iZzj6 == i15) {
                        return iZzj6;
                    }
                    throw zzll.zzf();
                }
                if (i5 == 1) {
                    zzlx zzlxVar4 = (zzlx) zzliVarZzd;
                    zzlxVar4.zzg(zzjo.zzp(bArr, i));
                    while (true) {
                        i10 = iZzj + 8;
                        if (i10 < i2) {
                            iZzj = zzjo.zzj(bArr, i10, zzjnVar);
                            if (i3 == zzjnVar.zza) {
                                zzlxVar4.zzg(zzjo.zzp(bArr, iZzj));
                            }
                        }
                    }
                    return i10;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzlc zzlcVar = (zzlc) zzliVarZzd;
                    int iZzj7 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i16 = zzjnVar.zza + iZzj7;
                    while (iZzj7 < i16) {
                        zzlcVar.zzh(zzjo.zzb(bArr, iZzj7));
                        iZzj7 += 4;
                    }
                    if (iZzj7 == i16) {
                        return iZzj7;
                    }
                    throw zzll.zzf();
                }
                if (i5 == 5) {
                    zzlc zzlcVar2 = (zzlc) zzliVarZzd;
                    zzlcVar2.zzh(zzjo.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj + 4;
                        if (i11 < i2) {
                            iZzj = zzjo.zzj(bArr, i11, zzjnVar);
                            if (i3 == zzjnVar.zza) {
                                zzlcVar2.zzh(zzjo.zzb(bArr, iZzj));
                            }
                        }
                    }
                    return i11;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzjp zzjpVar = (zzjp) zzliVarZzd;
                    int iZzj8 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i17 = zzjnVar.zza + iZzj8;
                    while (iZzj8 < i17) {
                        iZzj8 = zzjo.zzm(bArr, iZzj8, zzjnVar);
                        zzjpVar.zze(zzjnVar.zzb != 0);
                    }
                    if (iZzj8 == i17) {
                        return iZzj8;
                    }
                    throw zzll.zzf();
                }
                if (i5 == 0) {
                    zzjp zzjpVar2 = (zzjp) zzliVarZzd;
                    int iZzm2 = zzjo.zzm(bArr, iZzj, zzjnVar);
                    zzjpVar2.zze(zzjnVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj9 = zzjo.zzj(bArr, iZzm2, zzjnVar);
                        if (i3 != zzjnVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzjo.zzm(bArr, iZzj9, zzjnVar);
                        zzjpVar2.zze(zzjnVar.zzb != 0);
                    }
                    return iZzm2;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzjo.zzj(bArr, iZzj, zzjnVar);
                        int i18 = zzjnVar.zza;
                        if (i18 < 0) {
                            throw zzll.zzd();
                        }
                        if (i18 == 0) {
                            zzliVarZzd.add("");
                        } else {
                            zzliVarZzd.add(new String(bArr, iZzj10, i18, zzlj.zzb));
                            iZzj10 += i18;
                        }
                        while (iZzj10 < i2) {
                            int iZzj11 = zzjo.zzj(bArr, iZzj10, zzjnVar);
                            if (i3 != zzjnVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzjo.zzj(bArr, iZzj11, zzjnVar);
                            int i19 = zzjnVar.zza;
                            if (i19 < 0) {
                                throw zzll.zzd();
                            }
                            if (i19 == 0) {
                                zzliVarZzd.add("");
                            } else {
                                zzliVarZzd.add(new String(bArr, iZzj10, i19, zzlj.zzb));
                                iZzj10 += i19;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i20 = zzjnVar.zza;
                    if (i20 < 0) {
                        throw zzll.zzd();
                    }
                    if (i20 == 0) {
                        zzliVarZzd.add("");
                    } else {
                        int i21 = iZzj12 + i20;
                        if (!zznz.zze(bArr, iZzj12, i21)) {
                            throw zzll.zzc();
                        }
                        zzliVarZzd.add(new String(bArr, iZzj12, i20, zzlj.zzb));
                        iZzj12 = i21;
                    }
                    while (iZzj12 < i2) {
                        int iZzj13 = zzjo.zzj(bArr, iZzj12, zzjnVar);
                        if (i3 != zzjnVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzjo.zzj(bArr, iZzj13, zzjnVar);
                        int i22 = zzjnVar.zza;
                        if (i22 < 0) {
                            throw zzll.zzd();
                        }
                        if (i22 == 0) {
                            zzliVarZzd.add("");
                        } else {
                            int i23 = iZzj12 + i22;
                            if (!zznz.zze(bArr, iZzj12, i23)) {
                                throw zzll.zzc();
                            }
                            zzliVarZzd.add(new String(bArr, iZzj12, i22, zzlj.zzb));
                            iZzj12 = i23;
                        }
                    }
                    return iZzj12;
                }
                break;
            case 27:
                if (i5 == 2) {
                    return zzjo.zze(zzB(i6), i3, bArr, i, i2, zzliVarZzd, zzjnVar);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iZzj14 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i24 = zzjnVar.zza;
                    if (i24 < 0) {
                        throw zzll.zzd();
                    }
                    if (i24 > bArr.length - iZzj14) {
                        throw zzll.zzf();
                    }
                    if (i24 == 0) {
                        zzliVarZzd.add(zzka.zzb);
                    } else {
                        zzliVarZzd.add(zzka.zzl(bArr, iZzj14, i24));
                        iZzj14 += i24;
                    }
                    while (iZzj14 < i2) {
                        int iZzj15 = zzjo.zzj(bArr, iZzj14, zzjnVar);
                        if (i3 != zzjnVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzjo.zzj(bArr, iZzj15, zzjnVar);
                        int i25 = zzjnVar.zza;
                        if (i25 < 0) {
                            throw zzll.zzd();
                        }
                        if (i25 > bArr.length - iZzj14) {
                            throw zzll.zzf();
                        }
                        if (i25 == 0) {
                            zzliVarZzd.add(zzka.zzb);
                        } else {
                            zzliVarZzd.add(zzka.zzl(bArr, iZzj14, i25));
                            iZzj14 += i25;
                        }
                    }
                    return iZzj14;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iZzl = zzjo.zzf(bArr, iZzj, zzliVarZzd, zzjnVar);
                } else if (i5 == 0) {
                    iZzl = zzjo.zzl(i3, bArr, i, i2, zzliVarZzd, zzjnVar);
                }
                zzlf zzlfVarZzA = zzA(i6);
                zznk zznkVar = this.zzn;
                int i26 = zzmv.zza;
                if (zzlfVarZzA != null) {
                    Object objZzA = null;
                    if (zzliVarZzd instanceof RandomAccess) {
                        int size2 = zzliVarZzd.size();
                        int i27 = 0;
                        for (int i28 = 0; i28 < size2; i28++) {
                            int iIntValue = ((Integer) zzliVarZzd.get(i28)).intValue();
                            if (zzlfVarZzA.zza(iIntValue)) {
                                if (i28 != i27) {
                                    zzliVarZzd.set(i27, Integer.valueOf(iIntValue));
                                }
                                i27++;
                            } else {
                                objZzA = zzmv.zzA(obj, i4, iIntValue, objZzA, zznkVar);
                            }
                        }
                        if (i27 != size2) {
                            zzliVarZzd.subList(i27, size2).clear();
                            return iZzl;
                        }
                    } else {
                        Iterator it = zzliVarZzd.iterator();
                        while (it.hasNext()) {
                            int iIntValue2 = ((Integer) it.next()).intValue();
                            if (!zzlfVarZzA.zza(iIntValue2)) {
                                objZzA = zzmv.zzA(obj, i4, iIntValue2, objZzA, zznkVar);
                                it.remove();
                            }
                        }
                    }
                }
                return iZzl;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzlc zzlcVar3 = (zzlc) zzliVarZzd;
                    int iZzj16 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i29 = zzjnVar.zza + iZzj16;
                    while (iZzj16 < i29) {
                        iZzj16 = zzjo.zzj(bArr, iZzj16, zzjnVar);
                        zzlcVar3.zzh(zzke.zzb(zzjnVar.zza));
                    }
                    if (iZzj16 == i29) {
                        return iZzj16;
                    }
                    throw zzll.zzf();
                }
                if (i5 == 0) {
                    zzlc zzlcVar4 = (zzlc) zzliVarZzd;
                    int iZzj17 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    zzlcVar4.zzh(zzke.zzb(zzjnVar.zza));
                    while (iZzj17 < i2) {
                        int iZzj18 = zzjo.zzj(bArr, iZzj17, zzjnVar);
                        if (i3 != zzjnVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzjo.zzj(bArr, iZzj18, zzjnVar);
                        zzlcVar4.zzh(zzke.zzb(zzjnVar.zza));
                    }
                    return iZzj17;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzlx zzlxVar5 = (zzlx) zzliVarZzd;
                    int iZzj19 = zzjo.zzj(bArr, iZzj, zzjnVar);
                    int i30 = zzjnVar.zza + iZzj19;
                    while (iZzj19 < i30) {
                        iZzj19 = zzjo.zzm(bArr, iZzj19, zzjnVar);
                        zzlxVar5.zzg(zzke.zzc(zzjnVar.zzb));
                    }
                    if (iZzj19 == i30) {
                        return iZzj19;
                    }
                    throw zzll.zzf();
                }
                if (i5 == 0) {
                    zzlx zzlxVar6 = (zzlx) zzliVarZzd;
                    int iZzm3 = zzjo.zzm(bArr, iZzj, zzjnVar);
                    zzlxVar6.zzg(zzke.zzc(zzjnVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj20 = zzjo.zzj(bArr, iZzm3, zzjnVar);
                        if (i3 != zzjnVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzjo.zzm(bArr, iZzj20, zzjnVar);
                        zzlxVar6.zzg(zzke.zzc(zzjnVar.zzb));
                    }
                    return iZzm3;
                }
                break;
            default:
                if (i5 == 3) {
                    zzmt zzmtVarZzB = zzB(i6);
                    int i31 = (i3 & (-8)) | 4;
                    int iZzc = zzjo.zzc(zzmtVarZzB, bArr, i, i2, i31, zzjnVar);
                    zzliVarZzd.add(zzjnVar.zzc);
                    while (iZzc < i2) {
                        int iZzj21 = zzjo.zzj(bArr, iZzc, zzjnVar);
                        if (i3 != zzjnVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzjo.zzc(zzmtVarZzB, bArr, iZzj21, i2, i31, zzjnVar);
                        zzliVarZzd.add(zzjnVar.zzc);
                    }
                    return iZzc;
                }
                break;
        }
        return iZzj;
    }

    private final int zzt(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzw(i, 0);
    }

    private final int zzu(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzw(i, i2);
    }

    private final int zzv(int i) {
        return this.zzc[i + 2];
    }

    private final int zzw(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzx(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzy(int i) {
        return this.zzc[i + 1];
    }

    private static long zzz(Object obj, long j) {
        return ((Long) zznu.zzf(obj, j)).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final int zza(Object obj) {
        int iZzx;
        int iZzx2;
        int iZzy;
        int iZzx3;
        int iZzx4;
        int iZzx5;
        int iZzx6;
        int iZzn;
        int iZzx7;
        int iZzy2;
        int iZzx8;
        int iZzx9;
        if (!this.zzi) {
            return zzo(obj);
        }
        Unsafe unsafe = zzb;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.length; i2 += 3) {
            int iZzy3 = zzy(i2);
            int iZzx10 = zzx(iZzy3);
            int i3 = this.zzc[i2];
            int i4 = iZzy3 & 1048575;
            if (iZzx10 >= zzkt.DOUBLE_LIST_PACKED.zza() && iZzx10 <= zzkt.SINT64_LIST_PACKED.zza()) {
                int i5 = this.zzc[i2 + 2];
            }
            long j = i4;
            switch (iZzx10) {
                case 0:
                    if (zzP(obj, i2)) {
                        iZzx = zzki.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 1:
                    if (zzP(obj, i2)) {
                        iZzx2 = zzki.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 2:
                    if (zzP(obj, i2)) {
                        iZzy = zzki.zzy(zznu.zzd(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 3:
                    if (zzP(obj, i2)) {
                        iZzy = zzki.zzy(zznu.zzd(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 4:
                    if (zzP(obj, i2)) {
                        iZzy = zzki.zzu(zznu.zzc(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 5:
                    if (zzP(obj, i2)) {
                        iZzx = zzki.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 6:
                    if (zzP(obj, i2)) {
                        iZzx2 = zzki.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 7:
                    if (zzP(obj, i2)) {
                        iZzx4 = zzki.zzx(i3 << 3);
                        iZzn = iZzx4 + 1;
                        i += iZzn;
                    }
                    break;
                case 8:
                    if (zzP(obj, i2)) {
                        Object objZzf = zznu.zzf(obj, j);
                        if (objZzf instanceof zzka) {
                            int i6 = i3 << 3;
                            int i7 = zzki.zzb;
                            int iZzd = ((zzka) objZzf).zzd();
                            iZzx5 = zzki.zzx(iZzd) + iZzd;
                            iZzx6 = zzki.zzx(i6);
                            iZzn = iZzx6 + iZzx5;
                            i += iZzn;
                        } else {
                            iZzy = zzki.zzw((String) objZzf);
                            iZzx3 = zzki.zzx(i3 << 3);
                            i += iZzx3 + iZzy;
                        }
                    }
                    break;
                case 9:
                    if (zzP(obj, i2)) {
                        iZzn = zzmv.zzn(i3, zznu.zzf(obj, j), zzB(i2));
                        i += iZzn;
                    }
                    break;
                case 10:
                    if (zzP(obj, i2)) {
                        zzka zzkaVar = (zzka) zznu.zzf(obj, j);
                        int i8 = i3 << 3;
                        int i9 = zzki.zzb;
                        int iZzd2 = zzkaVar.zzd();
                        iZzx5 = zzki.zzx(iZzd2) + iZzd2;
                        iZzx6 = zzki.zzx(i8);
                        iZzn = iZzx6 + iZzx5;
                        i += iZzn;
                    }
                    break;
                case 11:
                    if (zzP(obj, i2)) {
                        iZzy = zzki.zzx(zznu.zzc(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 12:
                    if (zzP(obj, i2)) {
                        iZzy = zzki.zzu(zznu.zzc(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 13:
                    if (zzP(obj, i2)) {
                        iZzx2 = zzki.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 14:
                    if (zzP(obj, i2)) {
                        iZzx = zzki.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 15:
                    if (zzP(obj, i2)) {
                        int iZzc = zznu.zzc(obj, j);
                        iZzx3 = zzki.zzx(i3 << 3);
                        iZzy = zzki.zzx((iZzc >> 31) ^ (iZzc + iZzc));
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 16:
                    if (zzP(obj, i2)) {
                        long jZzd = zznu.zzd(obj, j);
                        iZzx7 = zzki.zzx(i3 << 3);
                        iZzy2 = zzki.zzy((jZzd + jZzd) ^ (jZzd >> 63));
                        iZzn = iZzx7 + iZzy2;
                        i += iZzn;
                    }
                    break;
                case 17:
                    if (zzP(obj, i2)) {
                        iZzn = zzki.zzt(i3, (zzmi) zznu.zzf(obj, j), zzB(i2));
                        i += iZzn;
                    }
                    break;
                case 18:
                    iZzn = zzmv.zzg(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 19:
                    iZzn = zzmv.zze(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 20:
                    iZzn = zzmv.zzl(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 21:
                    iZzn = zzmv.zzw(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 22:
                    iZzn = zzmv.zzj(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 23:
                    iZzn = zzmv.zzg(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 24:
                    iZzn = zzmv.zze(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 25:
                    iZzn = zzmv.zza(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 26:
                    iZzn = zzmv.zzt(i3, (List) zznu.zzf(obj, j));
                    i += iZzn;
                    break;
                case 27:
                    iZzn = zzmv.zzo(i3, (List) zznu.zzf(obj, j), zzB(i2));
                    i += iZzn;
                    break;
                case 28:
                    iZzn = zzmv.zzb(i3, (List) zznu.zzf(obj, j));
                    i += iZzn;
                    break;
                case 29:
                    iZzn = zzmv.zzu(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 30:
                    iZzn = zzmv.zzc(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 31:
                    iZzn = zzmv.zze(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 32:
                    iZzn = zzmv.zzg(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 33:
                    iZzn = zzmv.zzp(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 34:
                    iZzn = zzmv.zzr(i3, (List) zznu.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 35:
                    iZzy = zzmv.zzh((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i10 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i10);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 36:
                    iZzy = zzmv.zzf((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i11 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i11);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 37:
                    iZzy = zzmv.zzm((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i12 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i12);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 38:
                    iZzy = zzmv.zzx((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i13 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i13);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 39:
                    iZzy = zzmv.zzk((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i14 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i14);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 40:
                    iZzy = zzmv.zzh((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i15 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i15);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 41:
                    iZzy = zzmv.zzf((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i16 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i16);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j);
                    int i17 = zzmv.zza;
                    iZzy = list.size();
                    if (iZzy > 0) {
                        int i18 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i18);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 43:
                    iZzy = zzmv.zzv((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i19 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i19);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 44:
                    iZzy = zzmv.zzd((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i20 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i20);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 45:
                    iZzy = zzmv.zzf((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i21 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i21);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 46:
                    iZzy = zzmv.zzh((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i22 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i22);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 47:
                    iZzy = zzmv.zzq((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i23 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i23);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 48:
                    iZzy = zzmv.zzs((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i24 = i3 << 3;
                        iZzx8 = zzki.zzx(iZzy);
                        iZzx9 = zzki.zzx(i24);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 49:
                    iZzn = zzmv.zzi(i3, (List) zznu.zzf(obj, j), zzB(i2));
                    i += iZzn;
                    break;
                case 50:
                    zzmd.zza(i3, zznu.zzf(obj, j), zzC(i2));
                    break;
                case 51:
                    if (zzT(obj, i3, i2)) {
                        iZzx = zzki.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 52:
                    if (zzT(obj, i3, i2)) {
                        iZzx2 = zzki.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 53:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzki.zzy(zzz(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 54:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzki.zzy(zzz(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 55:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzki.zzu(zzp(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 56:
                    if (zzT(obj, i3, i2)) {
                        iZzx = zzki.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 57:
                    if (zzT(obj, i3, i2)) {
                        iZzx2 = zzki.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 58:
                    if (zzT(obj, i3, i2)) {
                        iZzx4 = zzki.zzx(i3 << 3);
                        iZzn = iZzx4 + 1;
                        i += iZzn;
                    }
                    break;
                case 59:
                    if (zzT(obj, i3, i2)) {
                        Object objZzf2 = zznu.zzf(obj, j);
                        if (objZzf2 instanceof zzka) {
                            int i25 = i3 << 3;
                            int i26 = zzki.zzb;
                            int iZzd3 = ((zzka) objZzf2).zzd();
                            iZzx5 = zzki.zzx(iZzd3) + iZzd3;
                            iZzx6 = zzki.zzx(i25);
                            iZzn = iZzx6 + iZzx5;
                            i += iZzn;
                        } else {
                            iZzy = zzki.zzw((String) objZzf2);
                            iZzx3 = zzki.zzx(i3 << 3);
                            i += iZzx3 + iZzy;
                        }
                    }
                    break;
                case 60:
                    if (zzT(obj, i3, i2)) {
                        iZzn = zzmv.zzn(i3, zznu.zzf(obj, j), zzB(i2));
                        i += iZzn;
                    }
                    break;
                case 61:
                    if (zzT(obj, i3, i2)) {
                        zzka zzkaVar2 = (zzka) zznu.zzf(obj, j);
                        int i27 = i3 << 3;
                        int i28 = zzki.zzb;
                        int iZzd4 = zzkaVar2.zzd();
                        iZzx5 = zzki.zzx(iZzd4) + iZzd4;
                        iZzx6 = zzki.zzx(i27);
                        iZzn = iZzx6 + iZzx5;
                        i += iZzn;
                    }
                    break;
                case 62:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzki.zzx(zzp(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 63:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzki.zzu(zzp(obj, j));
                        iZzx3 = zzki.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 64:
                    if (zzT(obj, i3, i2)) {
                        iZzx2 = zzki.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 65:
                    if (zzT(obj, i3, i2)) {
                        iZzx = zzki.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 66:
                    if (zzT(obj, i3, i2)) {
                        int iZzp = zzp(obj, j);
                        iZzx3 = zzki.zzx(i3 << 3);
                        iZzy = zzki.zzx((iZzp >> 31) ^ (iZzp + iZzp));
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 67:
                    if (zzT(obj, i3, i2)) {
                        long jZzz = zzz(obj, j);
                        iZzx7 = zzki.zzx(i3 << 3);
                        iZzy2 = zzki.zzy((jZzz + jZzz) ^ (jZzz >> 63));
                        iZzn = iZzx7 + iZzy2;
                        i += iZzn;
                    }
                    break;
                case 68:
                    if (zzT(obj, i3, i2)) {
                        iZzn = zzki.zzt(i3, (zzmi) zznu.zzf(obj, j), zzB(i2));
                        i += iZzn;
                    }
                    break;
            }
        }
        zznk zznkVar = this.zzn;
        return i + zznkVar.zza(zznkVar.zzd(obj));
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzy = zzy(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzy;
            int iHashCode = 37;
            switch (zzx(iZzy)) {
                case 0:
                    i = i2 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zznu.zza(obj, j));
                    byte[] bArr = zzlj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zznu.zzb(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    jDoubleToLongBits = zznu.zzd(obj, j);
                    byte[] bArr2 = zzlj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    jDoubleToLongBits = zznu.zzd(obj, j);
                    byte[] bArr3 = zzlj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    iFloatToIntBits = zznu.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    jDoubleToLongBits = zznu.zzd(obj, j);
                    byte[] bArr4 = zzlj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    iFloatToIntBits = zznu.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    iFloatToIntBits = zzlj.zza(zznu.zzw(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    iFloatToIntBits = ((String) zznu.zzf(obj, j)).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 9:
                    Object objZzf = zznu.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iFloatToIntBits = zznu.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    iFloatToIntBits = zznu.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    iFloatToIntBits = zznu.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    iFloatToIntBits = zznu.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    jDoubleToLongBits = zznu.zzd(obj, j);
                    byte[] bArr5 = zzlj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    iFloatToIntBits = zznu.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    jDoubleToLongBits = zznu.zzd(obj, j);
                    byte[] bArr6 = zzlj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 17:
                    Object objZzf2 = zznu.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iFloatToIntBits = zznu.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    iFloatToIntBits = zznu.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzlj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr8 = zzlj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr9 = zzlj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr10 = zzlj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzlj.zza(zzU(obj, j));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = ((String) zznu.zzf(obj, j)).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zznu.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zznu.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr11 = zzlj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr12 = zzlj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zznu.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0310 A[PHI: r0 r19 r22 r27 r31
      0x0310: PHI (r0v81 int) = (r0v75 int), (r0v78 int), (r0v83 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
      0x0310: PHI (r19v5 int) = (r19v3 int), (r19v3 int), (r19v6 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
      0x0310: PHI (r22v6 int) = (r22v4 int), (r22v4 int), (r22v8 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
      0x0310: PHI (r27v8 sun.misc.Unsafe) = (r27v6 sun.misc.Unsafe), (r27v6 sun.misc.Unsafe), (r27v9 sun.misc.Unsafe) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
      0x0310: PHI (r31v6 int) = (r31v4 int), (r31v4 int), (r31v7 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:112:0x032c A[PHI: r0 r19 r22 r27 r31
      0x032c: PHI (r0v79 int) = (r0v75 int), (r0v78 int), (r0v83 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
      0x032c: PHI (r19v4 int) = (r19v3 int), (r19v3 int), (r19v6 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
      0x032c: PHI (r22v5 int) = (r22v4 int), (r22v4 int), (r22v8 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
      0x032c: PHI (r27v7 sun.misc.Unsafe) = (r27v6 sun.misc.Unsafe), (r27v6 sun.misc.Unsafe), (r27v9 sun.misc.Unsafe) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
      0x032c: PHI (r31v5 int) = (r31v4 int), (r31v4 int), (r31v7 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]] */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzjn zzjnVar) throws IOException {
        Unsafe unsafe;
        int i4;
        Object obj2;
        zzml<T> zzmlVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        zzjn zzjnVar2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        zzml<T> zzmlVar2 = this;
        Object obj3 = obj;
        bArr = bArr;
        i2 = i2;
        int i24 = i3;
        zzjn zzjnVar3 = zzjnVar;
        zzG(obj);
        Unsafe unsafe2 = zzb;
        int i25 = -1;
        int iZzi = i;
        int i26 = -1;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 1048575;
        while (true) {
            if (iZzi < i2) {
                int i31 = iZzi + 1;
                byte b2 = bArr[iZzi];
                if (b2 < 0) {
                    int iZzk = zzjo.zzk(b2, bArr, i31, zzjnVar3);
                    i5 = zzjnVar3.zza;
                    i31 = iZzk;
                } else {
                    i5 = b2;
                }
                int i32 = i5 >>> 3;
                int iZzu = i32 > i26 ? zzmlVar2.zzu(i32, i27 / 3) : zzmlVar2.zzt(i32);
                if (iZzu == i25) {
                    i6 = i32;
                    i7 = i31;
                    i8 = i5;
                    i9 = i29;
                    i10 = i25;
                    unsafe = unsafe2;
                    i11 = i24;
                    i12 = 0;
                } else {
                    int i33 = i5 & 7;
                    int[] iArr = zzmlVar2.zzc;
                    int i34 = iArr[iZzu + 1];
                    int iZzx = zzx(i34);
                    int i35 = i31;
                    int i36 = i5;
                    long j = i34 & 1048575;
                    if (iZzx <= 17) {
                        int i37 = iArr[iZzu + 2];
                        int i38 = 1 << (i37 >>> 20);
                        int i39 = i37 & 1048575;
                        if (i39 != i30) {
                            if (i30 != 1048575) {
                                unsafe2.putInt(obj3, i30, i29);
                            }
                            i30 = i39;
                            i13 = unsafe2.getInt(obj3, i39);
                        } else {
                            i13 = i29;
                            i30 = i30;
                        }
                        switch (iZzx) {
                            case 0:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 1) {
                                    zznu.zzo(obj3, j, Double.longBitsToDouble(zzjo.zzp(bArr, i16)));
                                    iZzi = i16 + 8;
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 1:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 5) {
                                    zznu.zzp(obj3, j, Float.intBitsToFloat(zzjo.zzb(bArr, i16)));
                                    iZzi = i16 + 4;
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 2:
                            case 3:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 0) {
                                    int iZzm = zzjo.zzm(bArr, i16, zzjnVar3);
                                    unsafe2.putLong(obj, j, zzjnVar3.zzb);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    iZzi = iZzm;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 4:
                            case 11:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 0) {
                                    iZzi = zzjo.zzj(bArr, i16, zzjnVar3);
                                    unsafe2.putInt(obj3, j, zzjnVar3.zza);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 5:
                            case 14:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 1) {
                                    i16 = i17;
                                    unsafe2.putLong(obj, j, zzjo.zzp(bArr, i17));
                                    iZzi = i16 + 8;
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 6:
                            case 13:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 5) {
                                    unsafe2.putInt(obj3, j, zzjo.zzb(bArr, i17));
                                    iZzi = i17 + 4;
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 7:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 0) {
                                    iZzi = zzjo.zzm(bArr, i17, zzjnVar3);
                                    zznu.zzm(obj3, j, zzjnVar3.zzb != 0);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 8:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 2) {
                                    iZzi = (i34 & 536870912) == 0 ? zzjo.zzg(bArr, i17, zzjnVar3) : zzjo.zzh(bArr, i17, zzjnVar3);
                                    unsafe2.putObject(obj3, j, zzjnVar3.zzc);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 9:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 2) {
                                    Object objZzD = zzmlVar2.zzD(obj3, i14);
                                    i36 = i36;
                                    iZzi = zzjo.zzo(objZzD, zzmlVar2.zzB(i14), bArr, i17, i2, zzjnVar);
                                    zzmlVar2.zzL(obj3, i14, objZzD);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i36 = i36;
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 10:
                                i18 = iZzu;
                                i15 = i32;
                                i19 = i36;
                                i20 = i35;
                                if (i33 == 2) {
                                    iZzi = zzjo.zza(bArr, i20, zzjnVar3);
                                    unsafe2.putObject(obj3, j, zzjnVar3.zzc);
                                    i29 = i13 | i38;
                                    i27 = i18;
                                    i26 = i15;
                                    i28 = i19;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i18;
                                    i36 = i19;
                                    i16 = i20;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 12:
                                i18 = iZzu;
                                i15 = i32;
                                i19 = i36;
                                i20 = i35;
                                if (i33 == 0) {
                                    iZzi = zzjo.zzj(bArr, i20, zzjnVar3);
                                    int i40 = zzjnVar3.zza;
                                    zzlf zzlfVarZzA = zzmlVar2.zzA(i18);
                                    if (zzlfVarZzA == null || zzlfVarZzA.zza(i40)) {
                                        unsafe2.putInt(obj3, j, i40);
                                        i29 = i13 | i38;
                                        i27 = i18;
                                    } else {
                                        zzd(obj).zzj(i19, Long.valueOf(i40));
                                        i27 = i18;
                                        i29 = i13;
                                    }
                                    i26 = i15;
                                    i28 = i19;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i18;
                                    i36 = i19;
                                    i16 = i20;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 15:
                                i18 = iZzu;
                                i15 = i32;
                                i19 = i36;
                                i20 = i35;
                                if (i33 == 0) {
                                    iZzi = zzjo.zzj(bArr, i20, zzjnVar3);
                                    unsafe2.putInt(obj3, j, zzke.zzb(zzjnVar3.zza));
                                    i29 = i13 | i38;
                                    i27 = i18;
                                    i26 = i15;
                                    i28 = i19;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i18;
                                    i36 = i19;
                                    i16 = i20;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 16:
                                if (i33 == 0) {
                                    int iZzm2 = zzjo.zzm(bArr, i35, zzjnVar3);
                                    unsafe2.putLong(obj, j, zzke.zzc(zzjnVar3.zzb));
                                    i29 = i13 | i38;
                                    i27 = iZzu;
                                    i26 = i32;
                                    i28 = i36;
                                    iZzi = iZzm2;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i15 = i32;
                                    i21 = iZzu;
                                    i16 = i35;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            default:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 3) {
                                    Object objZzD2 = zzmlVar2.zzD(obj3, i14);
                                    iZzi = zzjo.zzn(objZzD2, zzmlVar2.zzB(i14), bArr, i16, i2, (i15 << 3) | 4, zzjnVar);
                                    zzmlVar2.zzL(obj3, i14, objZzD2);
                                    i29 = i13 | i38;
                                    i26 = i15;
                                    i27 = i14;
                                    i28 = i36;
                                    i25 = -1;
                                    bArr = bArr;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                        }
                    } else {
                        if (iZzx != 27) {
                            i9 = i29;
                            i22 = i30;
                            if (iZzx <= 49) {
                                i6 = i32;
                                i10 = -1;
                                unsafe = unsafe2;
                                i12 = iZzu;
                                iZzi = zzs(obj, bArr, i35, i2, i36, i32, i33, iZzu, i34, iZzx, j, zzjnVar);
                                if (iZzi != i35) {
                                    zzmlVar2 = this;
                                    obj3 = obj;
                                    i26 = i6;
                                    i24 = i3;
                                    zzjnVar3 = zzjnVar;
                                    i25 = i10;
                                    i29 = i9;
                                    i28 = i36;
                                    i27 = i12;
                                    i30 = i22;
                                } else {
                                    i7 = iZzi;
                                    i8 = i36;
                                    i30 = i22;
                                    i11 = i3;
                                }
                                unsafe2 = unsafe;
                            } else {
                                i6 = i32;
                                unsafe = unsafe2;
                                i12 = iZzu;
                                i23 = i35;
                                i10 = -1;
                                if (iZzx != 50) {
                                    iZzi = zzr(obj, bArr, i23, i2, i36, i6, i33, i34, iZzx, j, i12, zzjnVar);
                                    if (iZzi != i23) {
                                        zzmlVar2 = this;
                                        obj3 = obj;
                                        i26 = i6;
                                        i24 = i3;
                                        zzjnVar3 = zzjnVar;
                                        i25 = i10;
                                        i29 = i9;
                                        i28 = i36;
                                        i27 = i12;
                                        i30 = i22;
                                    } else {
                                        i7 = iZzi;
                                        i8 = i36;
                                        i30 = i22;
                                        i11 = i3;
                                    }
                                    unsafe2 = unsafe;
                                } else if (i33 == 2) {
                                    iZzi = zzq(obj, bArr, i23, i2, i12, j, zzjnVar);
                                    if (iZzi != i23) {
                                        zzmlVar2 = this;
                                        obj3 = obj;
                                        i26 = i6;
                                        i24 = i3;
                                        zzjnVar3 = zzjnVar;
                                        i25 = i10;
                                        i29 = i9;
                                        i28 = i36;
                                        i27 = i12;
                                        i30 = i22;
                                    } else {
                                        i7 = iZzi;
                                        i8 = i36;
                                        i30 = i22;
                                        i11 = i3;
                                    }
                                    unsafe2 = unsafe;
                                }
                            }
                        } else if (i33 == 2) {
                            zzli zzliVarZzd = (zzli) unsafe2.getObject(obj3, j);
                            if (!zzliVarZzd.zzc()) {
                                int size = zzliVarZzd.size();
                                zzliVarZzd = zzliVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj3, j, zzliVarZzd);
                            }
                            iZzi = zzjo.zze(zzmlVar2.zzB(iZzu), i36, bArr, i35, i2, zzliVarZzd, zzjnVar);
                            i2 = i2;
                            i24 = i3;
                            i26 = i32;
                            i27 = iZzu;
                            i29 = i29;
                            i28 = i36;
                            i30 = i30;
                            i25 = -1;
                            bArr = bArr;
                        } else {
                            i9 = i29;
                            i22 = i30;
                            i6 = i32;
                            unsafe = unsafe2;
                            i12 = iZzu;
                            i23 = i35;
                            i10 = -1;
                        }
                        i11 = i3;
                        i7 = i23;
                        i8 = i36;
                        i30 = i22;
                    }
                }
                if (i8 != i11 || i11 == 0) {
                    int i41 = i11;
                    if (this.zzh) {
                        zzjnVar2 = zzjnVar;
                        zzkn zzknVar = zzjnVar2.zzd;
                        if (zzknVar != zzkn.zza) {
                            i6 = i6;
                            if (zzknVar.zzb(this.zzg, i6) != null) {
                                throw null;
                            }
                            iZzi = zzjo.zzi(i8, bArr, i7, i2, zzd(obj), zzjnVar);
                            obj = obj;
                        }
                        i28 = i8;
                        zzmlVar2 = this;
                        i26 = i6;
                        obj3 = obj;
                        i25 = i10;
                        i29 = i9;
                        i27 = i12;
                        i24 = i41;
                        zzjnVar3 = zzjnVar2;
                        unsafe2 = unsafe;
                    } else {
                        zzjnVar2 = zzjnVar;
                    }
                    iZzi = zzjo.zzi(i8, bArr, i7, i2, zzd(obj), zzjnVar);
                    i28 = i8;
                    zzmlVar2 = this;
                    i26 = i6;
                    obj3 = obj;
                    i25 = i10;
                    i29 = i9;
                    i27 = i12;
                    i24 = i41;
                    zzjnVar3 = zzjnVar2;
                    unsafe2 = unsafe;
                } else {
                    zzmlVar = this;
                    obj2 = obj;
                    i4 = i11;
                    iZzi = i7;
                    i28 = i8;
                    i29 = i9;
                }
            } else {
                unsafe = unsafe2;
                i4 = i24;
                obj2 = obj3;
                zzmlVar = zzmlVar2;
            }
        }
        if (i30 != 1048575) {
            unsafe.putInt(obj2, i30, i29);
        }
        for (int i42 = zzmlVar.zzk; i42 < zzmlVar.zzl; i42++) {
            int i43 = zzmlVar.zzj[i42];
            int i44 = zzmlVar.zzc[i43];
            Object objZzf = zznu.zzf(obj2, zzmlVar.zzy(i43) & 1048575);
            if (objZzf != null && zzmlVar.zzA(i43) != null) {
                throw null;
            }
        }
        if (i4 == 0) {
            if (iZzi != i2) {
                throw zzll.zze();
            }
        } else if (iZzi > i2 || i28 != i4) {
            throw zzll.zze();
        }
        return iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final Object zze() {
        return ((zzlb) this.zzg).zzbD();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x007f A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzmt
    public final void zzf(Object obj) {
        if (zzS(obj)) {
            if (obj instanceof zzlb) {
                zzlb zzlbVar = (zzlb) obj;
                zzlbVar.zzbP(Integer.MAX_VALUE);
                zzlbVar.zzb = 0;
                zzlbVar.zzbN();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzy = zzy(i);
                int i2 = 1048575 & iZzy;
                int iZzx = zzx(iZzy);
                long j = i2;
                if (iZzx != 9) {
                    if (iZzx != 60 && iZzx != 68) {
                        switch (iZzx) {
                            case 17:
                                if (zzP(obj, i)) {
                                    zzB(i).zzf(zzb.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzm.zza(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzmc) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzT(obj, this.zzc[i], i)) {
                        zzB(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzP(obj, i)) {
                    zzB(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzn.zzg(obj);
            if (this.zzh) {
                this.zzo.zzb(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final void zzg(Object obj, Object obj2) {
        zzG(obj);
        Objects.requireNonNull(obj2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzy = zzy(i);
            int i2 = this.zzc[i];
            long j = 1048575 & iZzy;
            switch (zzx(iZzy)) {
                case 0:
                    if (zzP(obj2, i)) {
                        zznu.zzo(obj, j, zznu.zza(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 1:
                    if (zzP(obj2, i)) {
                        zznu.zzp(obj, j, zznu.zzb(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 2:
                    if (zzP(obj2, i)) {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 3:
                    if (zzP(obj2, i)) {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 4:
                    if (zzP(obj2, i)) {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 5:
                    if (zzP(obj2, i)) {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 6:
                    if (zzP(obj2, i)) {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 7:
                    if (zzP(obj2, i)) {
                        zznu.zzm(obj, j, zznu.zzw(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 8:
                    if (zzP(obj2, i)) {
                        zznu.zzs(obj, j, zznu.zzf(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (zzP(obj2, i)) {
                        zznu.zzs(obj, j, zznu.zzf(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 11:
                    if (zzP(obj2, i)) {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 12:
                    if (zzP(obj2, i)) {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 13:
                    if (zzP(obj2, i)) {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 14:
                    if (zzP(obj2, i)) {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 15:
                    if (zzP(obj2, i)) {
                        zznu.zzq(obj, j, zznu.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 16:
                    if (zzP(obj2, i)) {
                        zznu.zzr(obj, j, zznu.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 17:
                    zzH(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzmv.zza;
                    zznu.zzs(obj, j, zzmd.zzb(zznu.zzf(obj, j), zznu.zzf(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzT(obj2, i2, i)) {
                        zznu.zzs(obj, j, zznu.zzf(obj2, j));
                        zzK(obj, i2, i);
                    }
                    break;
                case 60:
                    zzI(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzT(obj2, i2, i)) {
                        zznu.zzs(obj, j, zznu.zzf(obj2, j));
                        zzK(obj, i2, i);
                    }
                    break;
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzmv.zzB(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02ea A[PHI: r0 r18 r25 r26 r29
      0x02ea: PHI (r0v59 int) = (r0v54 int), (r0v57 int), (r0v61 int) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]
      0x02ea: PHI (r18v5 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]
      0x02ea: PHI (r25v3 int) = (r25v1 int), (r25v1 int), (r25v4 int) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]
      0x02ea: PHI (r26v2 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]
      0x02ea: PHI (r29v7 sun.misc.Unsafe) = (r29v5 sun.misc.Unsafe), (r29v5 sun.misc.Unsafe), (r29v8 sun.misc.Unsafe) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:103:0x02fd A[PHI: r0 r18 r25 r26 r29
      0x02fd: PHI (r0v58 int) = (r0v54 int), (r0v57 int), (r0v61 int) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]
      0x02fd: PHI (r18v4 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]
      0x02fd: PHI (r25v2 int) = (r25v1 int), (r25v1 int), (r25v4 int) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]
      0x02fd: PHI (r26v1 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]
      0x02fd: PHI (r29v6 sun.misc.Unsafe) = (r29v5 sun.misc.Unsafe), (r29v5 sun.misc.Unsafe), (r29v8 sun.misc.Unsafe) binds: [B:114:0x034c, B:109:0x0329, B:101:0x02e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0095. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzmt
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzjn zzjnVar) throws IOException {
        int i3;
        int iZzk;
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        Unsafe unsafe2;
        int i8;
        Unsafe unsafe3;
        Unsafe unsafe4;
        int i9;
        int i10;
        int i11;
        zzml<T> zzmlVar = this;
        obj = obj;
        bArr = bArr;
        i2 = i2;
        zzjnVar = zzjnVar;
        if (!zzmlVar.zzi) {
            zzc(obj, bArr, i, i2, 0, zzjnVar);
            return;
        }
        zzG(obj);
        Unsafe unsafe5 = zzb;
        int i12 = -1;
        int i13 = 1048575;
        int iZzi = i;
        int i14 = 1048575;
        int i15 = -1;
        int i16 = 0;
        int i17 = 0;
        while (iZzi < i2) {
            int i18 = iZzi + 1;
            byte b2 = bArr[iZzi];
            if (b2 < 0) {
                iZzk = zzjo.zzk(b2, bArr, i18, zzjnVar);
                i3 = zzjnVar.zza;
            } else {
                i3 = b2;
                iZzk = i18;
            }
            int i19 = i3 >>> 3;
            int iZzu = i19 > i15 ? zzmlVar.zzu(i19, i16 / 3) : zzmlVar.zzt(i19);
            if (iZzu == i12) {
                i4 = iZzk;
                i5 = i19;
                unsafe = unsafe5;
                i6 = i12;
                i7 = 0;
            } else {
                int i20 = i3 & 7;
                int[] iArr = zzmlVar.zzc;
                int i21 = iArr[iZzu + 1];
                int iZzx = zzx(i21);
                Unsafe unsafe6 = unsafe5;
                long j = i21 & i13;
                if (iZzx <= 17) {
                    int i22 = iArr[iZzu + 2];
                    int i23 = 1 << (i22 >>> 20);
                    int i24 = 1048575;
                    int i25 = i22 & 1048575;
                    if (i25 != i14) {
                        if (i14 != 1048575) {
                            long j2 = i14;
                            unsafe4 = unsafe6;
                            unsafe4.putInt(obj, j2, i17);
                        } else {
                            unsafe4 = unsafe6;
                        }
                        if (i25 != 1048575) {
                            i17 = unsafe4.getInt(obj, i25);
                        }
                        unsafe2 = unsafe4;
                        i14 = i25;
                    } else {
                        unsafe2 = unsafe6;
                    }
                    switch (iZzx) {
                        case 0:
                            this = this;
                            i5 = i19;
                            i24 = 1048575;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 != 1) {
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                zznu.zzo(obj, j, Double.longBitsToDouble(zzjo.zzp(bArr, iZzk)));
                                iZzi = iZzk + 8;
                                i17 |= i23;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i13 = i24;
                                i14 = i8;
                                i15 = i5;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        case 1:
                            i5 = i19;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 != 5) {
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                zznu.zzp(obj, j, Float.intBitsToFloat(zzjo.zzb(bArr, iZzk)));
                                iZzi = iZzk + 4;
                                i17 |= i23;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i13 = i24;
                                i14 = i8;
                                i15 = i5;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        case 2:
                        case 3:
                            this = this;
                            i5 = i19;
                            i24 = 1048575;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 != 0) {
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                int iZzm = zzjo.zzm(bArr, iZzk, zzjnVar);
                                unsafe3.putLong(obj, j, zzjnVar.zzb);
                                i17 |= i23;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                iZzi = iZzm;
                                i13 = i24;
                                i14 = i8;
                                i15 = i5;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        case 4:
                        case 11:
                            this = this;
                            i5 = i19;
                            i24 = 1048575;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 != 0) {
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                iZzi = zzjo.zzj(bArr, iZzk, zzjnVar);
                                unsafe3.putInt(obj, j, zzjnVar.zza);
                                i17 |= i23;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i13 = i24;
                                i14 = i8;
                                i15 = i5;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        case 5:
                        case 14:
                            this = this;
                            i5 = i19;
                            i24 = 1048575;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 != 1) {
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                unsafe3.putLong(obj, j, zzjo.zzp(bArr, iZzk));
                                iZzi = iZzk + 8;
                                i17 |= i23;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i13 = i24;
                                i14 = i8;
                                i15 = i5;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        case 6:
                        case 13:
                            i5 = i19;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 != 5) {
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                unsafe3.putInt(obj, j, zzjo.zzb(bArr, iZzk));
                                iZzi = iZzk + 4;
                                i17 |= i23;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i13 = i24;
                                i14 = i8;
                                i15 = i5;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        case 7:
                            this = this;
                            i5 = i19;
                            i24 = 1048575;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 != 0) {
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                iZzi = zzjo.zzm(bArr, iZzk, zzjnVar);
                                zznu.zzm(obj, j, zzjnVar.zzb != 0);
                                i17 |= i23;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i13 = i24;
                                i14 = i8;
                                i15 = i5;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        case 8:
                            this = this;
                            i5 = i19;
                            i24 = 1048575;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 != 2) {
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                iZzi = (i21 & 536870912) == 0 ? zzjo.zzg(bArr, iZzk, zzjnVar) : zzjo.zzh(bArr, iZzk, zzjnVar);
                                unsafe3.putObject(obj, j, zzjnVar.zzc);
                                i17 |= i23;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i13 = i24;
                                i14 = i8;
                                i15 = i5;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        case 9:
                            i5 = i19;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 != 2) {
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                this = this;
                                i24 = 1048575;
                                Object objZzD = this.zzD(obj, i7);
                                iZzi = zzjo.zzo(objZzD, this.zzB(i7), bArr, iZzk, i2, zzjnVar);
                                this.zzL(obj, i7, objZzD);
                                i17 |= i23;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i13 = i24;
                                i14 = i8;
                                i15 = i5;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        case 10:
                            i5 = i19;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 == 2) {
                                iZzi = zzjo.zza(bArr, iZzk, zzjnVar);
                                unsafe3.putObject(obj, j, zzjnVar.zzc);
                                i17 |= i23;
                                i2 = i2;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i14 = i8;
                                i15 = i5;
                                i13 = 1048575;
                                i12 = -1;
                                zzmlVar = this;
                            }
                            i4 = iZzk;
                            unsafe = unsafe3;
                            i14 = i8;
                            i6 = -1;
                            break;
                        case 12:
                            i5 = i19;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 == 0) {
                                iZzi = zzjo.zzj(bArr, iZzk, zzjnVar);
                                unsafe3.putInt(obj, j, zzjnVar.zza);
                                i17 |= i23;
                                i2 = i2;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i14 = i8;
                                i15 = i5;
                                i13 = 1048575;
                                i12 = -1;
                                zzmlVar = this;
                            }
                            i4 = iZzk;
                            unsafe = unsafe3;
                            i14 = i8;
                            i6 = -1;
                            break;
                        case 15:
                            i5 = i19;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            if (i20 == 0) {
                                iZzi = zzjo.zzj(bArr, iZzk, zzjnVar);
                                unsafe3.putInt(obj, j, zzke.zzb(zzjnVar.zza));
                                i17 |= i23;
                                i2 = i2;
                                unsafe5 = unsafe3;
                                i16 = i7;
                                i14 = i8;
                                i15 = i5;
                                i13 = 1048575;
                                i12 = -1;
                                zzmlVar = this;
                            }
                            i4 = iZzk;
                            unsafe = unsafe3;
                            i14 = i8;
                            i6 = -1;
                            break;
                        case 16:
                            if (i20 != 0) {
                                i5 = i19;
                                i7 = iZzu;
                                i8 = i14;
                                unsafe3 = unsafe2;
                                i4 = iZzk;
                                unsafe = unsafe3;
                                i14 = i8;
                                i6 = -1;
                            } else {
                                int iZzm2 = zzjo.zzm(bArr, iZzk, zzjnVar);
                                unsafe2.putLong(obj, j, zzke.zzc(zzjnVar.zzb));
                                i17 |= i23;
                                unsafe5 = unsafe2;
                                iZzi = iZzm2;
                                i16 = iZzu;
                                i14 = i14;
                                i15 = i19;
                                i13 = 1048575;
                                i12 = -1;
                                zzmlVar = this;
                                i2 = i2;
                            }
                            break;
                        default:
                            i5 = i19;
                            i7 = iZzu;
                            i8 = i14;
                            unsafe3 = unsafe2;
                            i4 = iZzk;
                            unsafe = unsafe3;
                            i14 = i8;
                            i6 = -1;
                            break;
                    }
                } else {
                    i5 = i19;
                    int i26 = i14;
                    zzml<T> zzmlVar2 = zzmlVar;
                    i7 = iZzu;
                    if (iZzx != 27) {
                        if (iZzx <= 49) {
                            int i27 = iZzk;
                            i10 = i17;
                            i11 = i26;
                            unsafe = unsafe6;
                            i6 = -1;
                            iZzi = zzs(obj, bArr, iZzk, i2, i3, i5, i20, i7, i21, iZzx, j, zzjnVar);
                            if (iZzi != i27) {
                                i16 = i7;
                                i12 = i6;
                                i15 = i5;
                                i17 = i10;
                                i14 = i11;
                            } else {
                                i4 = iZzi;
                                i17 = i10;
                                i14 = i11;
                            }
                            unsafe5 = unsafe;
                            i13 = 1048575;
                        } else {
                            i9 = iZzk;
                            i10 = i17;
                            unsafe = unsafe6;
                            i11 = i26;
                            i6 = -1;
                            if (iZzx == 50) {
                                if (i20 == 2) {
                                    iZzi = zzq(obj, bArr, i9, i2, i7, j, zzjnVar);
                                    if (iZzi != i9) {
                                        i16 = i7;
                                        i12 = i6;
                                        i15 = i5;
                                        i17 = i10;
                                        i14 = i11;
                                    } else {
                                        i4 = iZzi;
                                    }
                                    unsafe5 = unsafe;
                                    i13 = 1048575;
                                }
                                i17 = i10;
                                i14 = i11;
                            } else {
                                iZzi = zzr(obj, bArr, i9, i2, i3, i5, i20, i21, iZzx, j, i7, zzjnVar);
                                if (iZzi != i9) {
                                    i16 = i7;
                                    i12 = i6;
                                    i15 = i5;
                                    i17 = i10;
                                    i14 = i11;
                                } else {
                                    i4 = iZzi;
                                    i17 = i10;
                                    i14 = i11;
                                }
                                unsafe5 = unsafe;
                                i13 = 1048575;
                            }
                        }
                        zzmlVar = this;
                    } else if (i20 == 2) {
                        zzli zzliVarZzd = (zzli) unsafe6.getObject(obj, j);
                        if (!zzliVarZzd.zzc()) {
                            int size = zzliVarZzd.size();
                            zzliVarZzd = zzliVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe6.putObject(obj, j, zzliVarZzd);
                        }
                        iZzi = zzjo.zze(zzmlVar2.zzB(i7), i3, bArr, iZzk, i2, zzliVarZzd, zzjnVar);
                        i2 = i2;
                        unsafe5 = unsafe6;
                        i17 = i17;
                        i16 = i7;
                        i13 = 1048575;
                        i14 = i26;
                        i15 = i5;
                        zzmlVar = zzmlVar2;
                        i12 = -1;
                    } else {
                        i9 = iZzk;
                        i10 = i17;
                        unsafe = unsafe6;
                        i11 = i26;
                        i6 = -1;
                    }
                    i4 = i9;
                    i17 = i10;
                    i14 = i11;
                }
            }
            iZzi = zzjo.zzi(i3, bArr, i4, i2, zzd(obj), zzjnVar);
            i16 = i7;
            i12 = i6;
            i15 = i5;
            unsafe5 = unsafe;
            i13 = 1048575;
            zzmlVar = this;
        }
        int i28 = i17;
        Unsafe unsafe7 = unsafe5;
        if (i14 != i13) {
            unsafe7.putInt(obj, i14, i28);
        }
        if (iZzi != i2) {
            throw zzll.zze();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzV;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzy = zzy(i);
            long j = iZzy & 1048575;
            switch (zzx(iZzy)) {
                case 0:
                    if (!zzO(obj, obj2, i) || Double.doubleToLongBits(zznu.zza(obj, j)) != Double.doubleToLongBits(zznu.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzO(obj, obj2, i) || Float.floatToIntBits(zznu.zzb(obj, j)) != Float.floatToIntBits(zznu.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzO(obj, obj2, i) || zznu.zzd(obj, j) != zznu.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzO(obj, obj2, i) || zznu.zzd(obj, j) != zznu.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzO(obj, obj2, i) || zznu.zzc(obj, j) != zznu.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzO(obj, obj2, i) || zznu.zzd(obj, j) != zznu.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzO(obj, obj2, i) || zznu.zzc(obj, j) != zznu.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzO(obj, obj2, i) || zznu.zzw(obj, j) != zznu.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzO(obj, obj2, i) || !zzmv.zzV(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzO(obj, obj2, i) || !zzmv.zzV(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzO(obj, obj2, i) || !zzmv.zzV(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzO(obj, obj2, i) || zznu.zzc(obj, j) != zznu.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzO(obj, obj2, i) || zznu.zzc(obj, j) != zznu.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzO(obj, obj2, i) || zznu.zzc(obj, j) != zznu.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzO(obj, obj2, i) || zznu.zzd(obj, j) != zznu.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzO(obj, obj2, i) || zznu.zzc(obj, j) != zznu.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzO(obj, obj2, i) || zznu.zzd(obj, j) != zznu.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzO(obj, obj2, i) || !zzmv.zzV(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzV = zzmv.zzV(zznu.zzf(obj, j), zznu.zzf(obj2, j));
                    break;
                case 50:
                    zZzV = zzmv.zzV(zznu.zzf(obj, j), zznu.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzv = zzv(i) & 1048575;
                    if (zznu.zzc(obj, jZzv) != zznu.zzc(obj2, jZzv) || !zzmv.zzV(zznu.zzf(obj, j), zznu.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzV) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c3 A[LOOP:1: B:45:0x00b2->B:50:0x00c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e1 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzmt
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzmt zzmtVarZzB;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzk) {
            int i7 = this.zzj[i6];
            int i8 = this.zzc[i7];
            int iZzy = zzy(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzy) != 0 && !zzQ(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzx = zzx(iZzy);
            if (iZzx == 9 || iZzx == 17) {
                if (zzQ(obj, i7, i, i2, i11) && !zzR(obj, iZzy, zzB(i7))) {
                    return false;
                }
            } else if (iZzx == 27) {
                list = (List) zznu.zzf(obj, iZzy & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzmtVarZzB = zzB(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzmtVarZzB.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzx == 60 || iZzx == 68) {
                if (zzT(obj, i8, i7) && !zzR(obj, iZzy, zzB(i7))) {
                    return false;
                }
            } else if (iZzx == 49) {
                list = (List) zznu.zzf(obj, iZzy & 1048575);
                if (list.isEmpty()) {
                    zzmtVarZzB = zzB(i7);
                    while (i3 < list.size()) {
                        if (!zzmtVarZzB.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzx == 50 && !((zzmc) zznu.zzf(obj, iZzy & 1048575)).isEmpty()) {
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzmt
    public final void zzi(Object obj, zzoc zzocVar) throws IOException {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 1048575;
        if (this.zzi) {
            if (this.zzh) {
                this.zzo.zza(obj);
                throw null;
            }
            int length = this.zzc.length;
            for (int i6 = 0; i6 < length; i6 += 3) {
                int iZzy = zzy(i6);
                int i7 = this.zzc[i6];
                switch (zzx(iZzy)) {
                    case 0:
                        if (zzP(obj, i6)) {
                            zzocVar.zzf(i7, zznu.zza(obj, iZzy & 1048575));
                        }
                        break;
                    case 1:
                        if (zzP(obj, i6)) {
                            zzocVar.zzo(i7, zznu.zzb(obj, iZzy & 1048575));
                        }
                        break;
                    case 2:
                        if (zzP(obj, i6)) {
                            zzocVar.zzt(i7, zznu.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 3:
                        if (zzP(obj, i6)) {
                            zzocVar.zzJ(i7, zznu.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 4:
                        if (zzP(obj, i6)) {
                            zzocVar.zzr(i7, zznu.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 5:
                        if (zzP(obj, i6)) {
                            zzocVar.zzm(i7, zznu.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 6:
                        if (zzP(obj, i6)) {
                            zzocVar.zzk(i7, zznu.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 7:
                        if (zzP(obj, i6)) {
                            zzocVar.zzb(i7, zznu.zzw(obj, iZzy & 1048575));
                        }
                        break;
                    case 8:
                        if (zzP(obj, i6)) {
                            zzV(i7, zznu.zzf(obj, iZzy & 1048575), zzocVar);
                        }
                        break;
                    case 9:
                        if (zzP(obj, i6)) {
                            zzocVar.zzv(i7, zznu.zzf(obj, iZzy & 1048575), zzB(i6));
                        }
                        break;
                    case 10:
                        if (zzP(obj, i6)) {
                            zzocVar.zzd(i7, (zzka) zznu.zzf(obj, iZzy & 1048575));
                        }
                        break;
                    case 11:
                        if (zzP(obj, i6)) {
                            zzocVar.zzH(i7, zznu.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 12:
                        if (zzP(obj, i6)) {
                            zzocVar.zzi(i7, zznu.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 13:
                        if (zzP(obj, i6)) {
                            zzocVar.zzw(i7, zznu.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 14:
                        if (zzP(obj, i6)) {
                            zzocVar.zzy(i7, zznu.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 15:
                        if (zzP(obj, i6)) {
                            zzocVar.zzA(i7, zznu.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 16:
                        if (zzP(obj, i6)) {
                            zzocVar.zzC(i7, zznu.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 17:
                        if (zzP(obj, i6)) {
                            zzocVar.zzq(i7, zznu.zzf(obj, iZzy & 1048575), zzB(i6));
                        }
                        break;
                    case 18:
                        zzmv.zzF(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 19:
                        zzmv.zzJ(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 20:
                        zzmv.zzM(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 21:
                        zzmv.zzU(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 22:
                        zzmv.zzL(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 23:
                        zzmv.zzI(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 24:
                        zzmv.zzH(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 25:
                        zzmv.zzD(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 26:
                        zzmv.zzS(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar);
                        break;
                    case 27:
                        zzmv.zzN(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, zzB(i6));
                        break;
                    case 28:
                        zzmv.zzE(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar);
                        break;
                    case 29:
                        zzmv.zzT(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 30:
                        zzmv.zzG(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 31:
                        zzmv.zzO(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 32:
                        zzmv.zzP(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 33:
                        zzmv.zzQ(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 34:
                        zzmv.zzR(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, false);
                        break;
                    case 35:
                        zzmv.zzF(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 36:
                        zzmv.zzJ(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 37:
                        zzmv.zzM(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 38:
                        zzmv.zzU(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 39:
                        zzmv.zzL(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 40:
                        zzmv.zzI(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 41:
                        zzmv.zzH(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 42:
                        zzmv.zzD(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 43:
                        zzmv.zzT(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 44:
                        zzmv.zzG(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 45:
                        zzmv.zzO(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 46:
                        zzmv.zzP(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 47:
                        zzmv.zzQ(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 48:
                        zzmv.zzR(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, true);
                        break;
                    case 49:
                        zzmv.zzK(i7, (List) zznu.zzf(obj, iZzy & 1048575), zzocVar, zzB(i6));
                        break;
                    case 50:
                        zzN(zzocVar, i7, zznu.zzf(obj, iZzy & 1048575), i6);
                        break;
                    case 51:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzf(i7, zzm(obj, iZzy & 1048575));
                        }
                        break;
                    case 52:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzo(i7, zzn(obj, iZzy & 1048575));
                        }
                        break;
                    case 53:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzt(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case 54:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzJ(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case 55:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzr(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 56:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzm(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case 57:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzk(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 58:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzb(i7, zzU(obj, iZzy & 1048575));
                        }
                        break;
                    case 59:
                        if (zzT(obj, i7, i6)) {
                            zzV(i7, zznu.zzf(obj, iZzy & 1048575), zzocVar);
                        }
                        break;
                    case 60:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzv(i7, zznu.zzf(obj, iZzy & 1048575), zzB(i6));
                        }
                        break;
                    case 61:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzd(i7, (zzka) zznu.zzf(obj, iZzy & 1048575));
                        }
                        break;
                    case 62:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzH(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 63:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzi(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 64:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzw(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 65:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzy(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case 66:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzA(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 67:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzC(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case 68:
                        if (zzT(obj, i7, i6)) {
                            zzocVar.zzq(i7, zznu.zzf(obj, iZzy & 1048575), zzB(i6));
                        }
                        break;
                }
            }
            zznk zznkVar = this.zzn;
            zznkVar.zzi(zznkVar.zzd(obj), zzocVar);
            return;
        }
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int length2 = this.zzc.length;
        Unsafe unsafe = zzb;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (i8 < length2) {
            int iZzy2 = zzy(i8);
            int[] iArr = this.zzc;
            int i11 = iArr[i8];
            int iZzx = zzx(iZzy2);
            if (iZzx <= 17) {
                int i12 = iArr[i8 + 2];
                int i13 = i12 & i5;
                if (i13 != i10) {
                    i9 = unsafe.getInt(obj, i13);
                    i10 = i13;
                }
                i = 1 << (i12 >>> 20);
            } else {
                i = i4;
            }
            long j = iZzy2 & i5;
            switch (iZzx) {
                case 0:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzf(i11, zznu.zza(obj, j));
                    }
                    break;
                case 1:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzo(i11, zznu.zzb(obj, j));
                    }
                    break;
                case 2:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzt(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzJ(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzr(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzm(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzk(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzb(i11, zznu.zzw(obj, j));
                    }
                    break;
                case 8:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzV(i11, unsafe.getObject(obj, j), zzocVar);
                    }
                    break;
                case 9:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzv(i11, unsafe.getObject(obj, j), zzB(i8));
                    }
                    break;
                case 10:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzd(i11, (zzka) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzH(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzi(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzw(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzy(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzA(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzC(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzocVar.zzq(i11, unsafe.getObject(obj, j), zzB(i8));
                    }
                    break;
                case 18:
                    i2 = 0;
                    zzmv.zzF(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    break;
                case 19:
                    i2 = 0;
                    zzmv.zzJ(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    break;
                case 20:
                    i2 = 0;
                    zzmv.zzM(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    break;
                case 21:
                    i2 = 0;
                    zzmv.zzU(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    break;
                case 22:
                    i2 = 0;
                    zzmv.zzL(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    break;
                case 23:
                    i2 = 0;
                    zzmv.zzI(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    break;
                case 24:
                    i2 = 0;
                    zzmv.zzH(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    break;
                case 25:
                    i2 = 0;
                    zzmv.zzD(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    break;
                case 26:
                    zzmv.zzS(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar);
                    i2 = 0;
                    break;
                case 27:
                    zzmv.zzN(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, zzB(i8));
                    i2 = 0;
                    break;
                case 28:
                    zzmv.zzE(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar);
                    i2 = 0;
                    break;
                case 29:
                    i3 = 0;
                    zzmv.zzT(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    i2 = i3;
                    break;
                case 30:
                    i3 = 0;
                    zzmv.zzG(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    i2 = i3;
                    break;
                case 31:
                    i3 = 0;
                    zzmv.zzO(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    i2 = i3;
                    break;
                case 32:
                    i3 = 0;
                    zzmv.zzP(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    i2 = i3;
                    break;
                case 33:
                    i3 = 0;
                    zzmv.zzQ(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    i2 = i3;
                    break;
                case 34:
                    i3 = 0;
                    zzmv.zzR(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, false);
                    i2 = i3;
                    break;
                case 35:
                    zzmv.zzF(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 36:
                    zzmv.zzJ(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 37:
                    zzmv.zzM(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 38:
                    zzmv.zzU(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 39:
                    zzmv.zzL(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 40:
                    zzmv.zzI(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 41:
                    zzmv.zzH(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 42:
                    zzmv.zzD(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 43:
                    zzmv.zzT(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 44:
                    zzmv.zzG(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 45:
                    zzmv.zzO(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 46:
                    zzmv.zzP(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 47:
                    zzmv.zzQ(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 48:
                    zzmv.zzR(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, true);
                    i2 = 0;
                    break;
                case 49:
                    zzmv.zzK(this.zzc[i8], (List) unsafe.getObject(obj, j), zzocVar, zzB(i8));
                    i2 = 0;
                    break;
                case 50:
                    zzN(zzocVar, i11, unsafe.getObject(obj, j), i8);
                    i2 = 0;
                    break;
                case 51:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzf(i11, zzm(obj, j));
                    }
                    i2 = 0;
                    break;
                case 52:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzo(i11, zzn(obj, j));
                    }
                    i2 = 0;
                    break;
                case 53:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzt(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case 54:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzJ(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case 55:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzr(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 56:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzm(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case 57:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzk(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 58:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzb(i11, zzU(obj, j));
                    }
                    i2 = 0;
                    break;
                case 59:
                    if (zzT(obj, i11, i8)) {
                        zzV(i11, unsafe.getObject(obj, j), zzocVar);
                    }
                    i2 = 0;
                    break;
                case 60:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzv(i11, unsafe.getObject(obj, j), zzB(i8));
                    }
                    i2 = 0;
                    break;
                case 61:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzd(i11, (zzka) unsafe.getObject(obj, j));
                    }
                    i2 = 0;
                    break;
                case 62:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzH(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 63:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzi(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 64:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzw(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 65:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzy(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case 66:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzA(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 67:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzC(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case 68:
                    if (zzT(obj, i11, i8)) {
                        zzocVar.zzq(i11, unsafe.getObject(obj, j), zzB(i8));
                    }
                    i2 = 0;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            i8 += 3;
            i4 = i2;
            i5 = 1048575;
        }
        zznk zznkVar2 = this.zzn;
        zznkVar2.zzi(zznkVar2.zzd(obj), zzocVar);
    }
}
