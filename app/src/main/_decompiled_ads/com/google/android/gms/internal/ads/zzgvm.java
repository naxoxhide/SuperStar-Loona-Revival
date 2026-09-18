package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvm<T> implements zzgwc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgxd.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgvj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzgux zzm;
    private final zzgwt zzn;
    private final zzgtm zzo;
    private final zzgvo zzp;
    private final zzgve zzq;

    private zzgvm(int[] iArr, Object[] objArr, int i, int i2, zzgvj zzgvjVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzgvo zzgvoVar, zzgux zzguxVar, zzgwt zzgwtVar, zzgtm zzgtmVar, zzgve zzgveVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgvjVar instanceof zzgtz;
        boolean z2 = false;
        if (zzgtmVar != null && zzgtmVar.zzh(zzgvjVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i4;
        this.zzl = i5;
        this.zzp = zzgvoVar;
        this.zzm = zzguxVar;
        this.zzn = zzgwtVar;
        this.zzo = zzgtmVar;
        this.zzg = zzgvjVar;
        this.zzq = zzgveVar;
    }

    private final Object zzA(Object obj, int i) {
        zzgwc zzgwcVarZzx = zzx(i);
        int iZzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzgwcVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzgwcVarZzx.zze();
        if (object != null) {
            zzgwcVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzgwc zzgwcVarZzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzgwcVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzgwcVarZzx.zze();
        if (object != null) {
            zzgwcVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
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

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgwc zzgwcVarZzx = zzx(i);
            if (!zzN(obj, i)) {
                if (zzQ(object)) {
                    Object objZze = zzgwcVarZzx.zze();
                    zzgwcVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzgwcVarZzx.zze();
                zzgwcVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgwcVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzR(obj2, i2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgwc zzgwcVarZzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (zzQ(object)) {
                    Object objZze = zzgwcVarZzx.zze();
                    zzgwcVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzgwcVarZzx.zze();
                zzgwcVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgwcVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzgvu zzgvuVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzgxd.zzv(obj, j, zzgvuVar.zzs());
        } else if (this.zzi) {
            zzgxd.zzv(obj, j, zzgvuVar.zzr());
        } else {
            zzgxd.zzv(obj, j, zzgvuVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int iZzr = zzr(i);
        long j = 1048575 & iZzr;
        if (j == 1048575) {
            return;
        }
        zzgxd.zzt(obj, j, (1 << (iZzr >>> 20)) | zzgxd.zzd(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzgxd.zzt(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzr = zzr(i);
        long j = iZzr & 1048575;
        if (j != 1048575) {
            return (zzgxd.zzd(obj, j) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i);
        long j2 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzgxd.zzb(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzgxd.zzc(obj, j2)) != 0;
            case 2:
                return zzgxd.zzf(obj, j2) != 0;
            case 3:
                return zzgxd.zzf(obj, j2) != 0;
            case 4:
                return zzgxd.zzd(obj, j2) != 0;
            case 5:
                return zzgxd.zzf(obj, j2) != 0;
            case 6:
                return zzgxd.zzd(obj, j2) != 0;
            case 7:
                return zzgxd.zzz(obj, j2);
            case 8:
                Object objZzh = zzgxd.zzh(obj, j2);
                if (objZzh instanceof String) {
                    return !((String) objZzh).isEmpty();
                }
                if (objZzh instanceof zzgsr) {
                    return !zzgsr.zzb.equals(objZzh);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgxd.zzh(obj, j2) != null;
            case 10:
                return !zzgsr.zzb.equals(zzgxd.zzh(obj, j2));
            case 11:
                return zzgxd.zzd(obj, j2) != 0;
            case 12:
                return zzgxd.zzd(obj, j2) != 0;
            case 13:
                return zzgxd.zzd(obj, j2) != 0;
            case 14:
                return zzgxd.zzf(obj, j2) != 0;
            case 15:
                return zzgxd.zzd(obj, j2) != 0;
            case 16:
                return zzgxd.zzf(obj, j2) != 0;
            case 17:
                return zzgxd.zzh(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzgwc zzgwcVar) {
        return zzgwcVar.zzk(zzgxd.zzh(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgtz) {
            return ((zzgtz) obj).zzaY();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzgxd.zzd(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzgxd.zzh(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzgth zzgthVar) throws IOException {
        if (obj instanceof String) {
            zzgthVar.zzF(i, (String) obj);
        } else {
            zzgthVar.zzd(i, (zzgsr) obj);
        }
    }

    static zzgwu zzd(Object obj) {
        zzgtz zzgtzVar = (zzgtz) obj;
        zzgwu zzgwuVar = zzgtzVar.zzc;
        if (zzgwuVar != zzgwu.zzc()) {
            return zzgwuVar;
        }
        zzgwu zzgwuVarZzf = zzgwu.zzf();
        zzgtzVar.zzc = zzgwuVarZzf;
        return zzgwuVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    static zzgvm zzl(Class cls, zzgvg zzgvgVar, zzgvo zzgvoVar, zzgux zzguxVar, zzgwt zzgwtVar, zzgtm zzgtmVar, zzgve zzgveVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int iObjectFieldOffset;
        int i17;
        int i18;
        int iObjectFieldOffset2;
        Field fieldZzC;
        char cCharAt9;
        int i19;
        int i20;
        int i21;
        int i22;
        Object obj;
        Field fieldZzC2;
        int i23;
        Object obj2;
        Field fieldZzC3;
        int i24;
        char cCharAt10;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        if (!(zzgvgVar instanceof zzgvt)) {
            throw null;
        }
        zzgvt zzgvtVar = (zzgvt) zzgvgVar;
        String strZzd = zzgvtVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i28 = 1;
            while (true) {
                i = i28 + 1;
                if (strZzd.charAt(i28) < 55296) {
                    break;
                }
                i28 = i;
            }
        } else {
            i = 1;
        }
        int i29 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i30 = iCharAt3 & 8191;
            int i31 = 13;
            while (true) {
                i27 = i29 + 1;
                cCharAt13 = strZzd.charAt(i29);
                if (cCharAt13 < 55296) {
                    break;
                }
                i30 |= (cCharAt13 & 8191) << i31;
                i31 += 13;
                i29 = i27;
            }
            iCharAt3 = i30 | (cCharAt13 << i31);
            i29 = i27;
        }
        if (iCharAt3 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            i3 = 0;
            i6 = 0;
            i2 = 0;
            i4 = 0;
            iArr = zza;
            i5 = 0;
        } else {
            int i32 = i29 + 1;
            int iCharAt4 = strZzd.charAt(i29);
            if (iCharAt4 >= 55296) {
                int i33 = iCharAt4 & 8191;
                int i34 = 13;
                while (true) {
                    i14 = i32 + 1;
                    cCharAt8 = strZzd.charAt(i32);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i33 |= (cCharAt8 & 8191) << i34;
                    i34 += 13;
                    i32 = i14;
                }
                iCharAt4 = i33 | (cCharAt8 << i34);
                i32 = i14;
            }
            int i35 = i32 + 1;
            int iCharAt5 = strZzd.charAt(i32);
            if (iCharAt5 >= 55296) {
                int i36 = iCharAt5 & 8191;
                int i37 = 13;
                while (true) {
                    i13 = i35 + 1;
                    cCharAt7 = strZzd.charAt(i35);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt7 & 8191) << i37;
                    i37 += 13;
                    i35 = i13;
                }
                iCharAt5 = i36 | (cCharAt7 << i37);
                i35 = i13;
            }
            int i38 = i35 + 1;
            int iCharAt6 = strZzd.charAt(i35);
            if (iCharAt6 >= 55296) {
                int i39 = iCharAt6 & 8191;
                int i40 = 13;
                while (true) {
                    i12 = i38 + 1;
                    cCharAt6 = strZzd.charAt(i38);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt6 & 8191) << i40;
                    i40 += 13;
                    i38 = i12;
                }
                iCharAt6 = i39 | (cCharAt6 << i40);
                i38 = i12;
            }
            int i41 = i38 + 1;
            int iCharAt7 = strZzd.charAt(i38);
            if (iCharAt7 >= 55296) {
                int i42 = iCharAt7 & 8191;
                int i43 = 13;
                while (true) {
                    i11 = i41 + 1;
                    cCharAt5 = strZzd.charAt(i41);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt5 & 8191) << i43;
                    i43 += 13;
                    i41 = i11;
                }
                iCharAt7 = i42 | (cCharAt5 << i43);
                i41 = i11;
            }
            int i44 = i41 + 1;
            iCharAt = strZzd.charAt(i41);
            if (iCharAt >= 55296) {
                int i45 = iCharAt & 8191;
                int i46 = 13;
                while (true) {
                    i10 = i44 + 1;
                    cCharAt4 = strZzd.charAt(i44);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt4 & 8191) << i46;
                    i46 += 13;
                    i44 = i10;
                }
                iCharAt = i45 | (cCharAt4 << i46);
                i44 = i10;
            }
            int i47 = i44 + 1;
            iCharAt2 = strZzd.charAt(i44);
            if (iCharAt2 >= 55296) {
                int i48 = iCharAt2 & 8191;
                int i49 = 13;
                while (true) {
                    i9 = i47 + 1;
                    cCharAt3 = strZzd.charAt(i47);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt3 & 8191) << i49;
                    i49 += 13;
                    i47 = i9;
                }
                iCharAt2 = i48 | (cCharAt3 << i49);
                i47 = i9;
            }
            int i50 = i47 + 1;
            int iCharAt8 = strZzd.charAt(i47);
            if (iCharAt8 >= 55296) {
                int i51 = iCharAt8 & 8191;
                int i52 = 13;
                while (true) {
                    i8 = i50 + 1;
                    cCharAt2 = strZzd.charAt(i50);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt2 & 8191) << i52;
                    i52 += 13;
                    i50 = i8;
                }
                iCharAt8 = i51 | (cCharAt2 << i52);
                i50 = i8;
            }
            int i53 = i50 + 1;
            int iCharAt9 = strZzd.charAt(i50);
            if (iCharAt9 >= 55296) {
                int i54 = iCharAt9 & 8191;
                int i55 = 13;
                while (true) {
                    i7 = i53 + 1;
                    cCharAt = strZzd.charAt(i53);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i54 |= (cCharAt & 8191) << i55;
                    i55 += 13;
                    i53 = i7;
                }
                iCharAt9 = i54 | (cCharAt << i55);
                i53 = i7;
            }
            i2 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i3 = iCharAt6;
            i4 = iCharAt9;
            i5 = iCharAt4;
            i6 = iCharAt7;
            i29 = i53;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzgvtVar.zze();
        Class<?> cls2 = zzgvtVar.zza().getClass();
        int i56 = i4 + iCharAt2;
        int i57 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i57];
        int i58 = 0;
        int i59 = 0;
        int i60 = i4;
        int i61 = i56;
        while (i29 < length) {
            int i62 = i29 + 1;
            int iCharAt10 = strZzd.charAt(i29);
            if (iCharAt10 >= c) {
                int i63 = iCharAt10 & 8191;
                int i64 = i62;
                int i65 = 13;
                while (true) {
                    i26 = i64 + 1;
                    cCharAt12 = strZzd.charAt(i64);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i63 |= (cCharAt12 & 8191) << i65;
                    i65 += 13;
                    i64 = i26;
                }
                iCharAt10 = i63 | (cCharAt12 << i65);
                i15 = i26;
            } else {
                i15 = i62;
            }
            int i66 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i67 = iCharAt11 & 8191;
                int i68 = i66;
                int i69 = 13;
                while (true) {
                    i25 = i68 + 1;
                    cCharAt11 = strZzd.charAt(i68);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i67 |= (cCharAt11 & 8191) << i69;
                    i69 += 13;
                    i68 = i25;
                }
                iCharAt11 = i67 | (cCharAt11 << i69);
                i16 = i25;
            } else {
                i16 = i66;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i58] = i59;
                i58++;
            }
            int i70 = iCharAt11 & 255;
            int i71 = iCharAt11 & 2048;
            int i72 = length;
            if (i70 >= 51) {
                int i73 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i74 = 13;
                    int i75 = iCharAt12 & 8191;
                    int i76 = i73;
                    while (true) {
                        i24 = i76 + 1;
                        cCharAt10 = strZzd.charAt(i76);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i75 |= (cCharAt10 & 8191) << i74;
                        i74 += 13;
                        i76 = i24;
                        c2 = 55296;
                    }
                    iCharAt12 = i75 | (cCharAt10 << i74);
                    i20 = i24;
                } else {
                    i20 = i73;
                }
                int i77 = i20;
                int i78 = i70 - 51;
                if (i78 == 9 || i78 == 17) {
                    i21 = i2 + 1;
                    int i79 = i59 / 3;
                    objArr[i79 + i79 + 1] = objArrZze[i2];
                } else {
                    if (i78 == 12) {
                        if (zzgvtVar.zzc() == 1 || i71 != 0) {
                            i21 = i2 + 1;
                            int i80 = i59 / 3;
                            objArr[i80 + i80 + 1] = objArrZze[i2];
                        } else {
                            i71 = 0;
                        }
                    }
                    i22 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i22];
                    if (obj instanceof Field) {
                        fieldZzC2 = (Field) obj;
                    } else {
                        fieldZzC2 = zzC(cls2, (String) obj);
                        objArrZze[i22] = fieldZzC2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC2);
                    i23 = i22 + 1;
                    obj2 = objArrZze[i23];
                    if (obj2 instanceof Field) {
                        fieldZzC3 = (Field) obj2;
                    } else {
                        fieldZzC3 = zzC(cls2, (String) obj2);
                        objArrZze[i23] = fieldZzC3;
                    }
                    strZzd = strZzd;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC3);
                    i17 = i77;
                    i18 = 0;
                    zzgvtVar = zzgvtVar;
                }
                i2 = i21;
                i22 = iCharAt12 + iCharAt12;
                obj = objArrZze[i22];
                if (obj instanceof Field) {
                    fieldZzC2 = (Field) obj;
                } else {
                    fieldZzC2 = zzC(cls2, (String) obj);
                    objArrZze[i22] = fieldZzC2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC2);
                i23 = i22 + 1;
                obj2 = objArrZze[i23];
                if (obj2 instanceof Field) {
                    fieldZzC3 = (Field) obj2;
                } else {
                    fieldZzC3 = zzC(cls2, (String) obj2);
                    objArrZze[i23] = fieldZzC3;
                }
                strZzd = strZzd;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC3);
                i17 = i77;
                i18 = 0;
                zzgvtVar = zzgvtVar;
            } else {
                int i81 = i2 + 1;
                Field fieldZzC4 = zzC(cls2, (String) objArrZze[i2]);
                if (i70 == 9 || i70 == 17) {
                    zzgvtVar = zzgvtVar;
                    int i82 = i59 / 3;
                    objArr[i82 + i82 + 1] = fieldZzC4.getType();
                } else if (i70 == 27 || i70 == 49) {
                    i19 = i81 + 1;
                    int i83 = i59 / 3;
                    objArr[i83 + i83 + 1] = objArrZze[i81];
                    i81 = i19;
                } else if (i70 == 12 || i70 == 30 || i70 == 44) {
                    zzgvtVar = zzgvtVar;
                    if (zzgvtVar.zzc() == 1 || i71 != 0) {
                        i19 = i81 + 1;
                        int i84 = i59 / 3;
                        objArr[i84 + i84 + 1] = objArrZze[i81];
                        i81 = i19;
                    } else {
                        i71 = 0;
                    }
                } else {
                    if (i70 == 50) {
                        int i85 = i81 + 1;
                        int i86 = i60 + 1;
                        iArr[i60] = i59;
                        int i87 = i59 / 3;
                        int i88 = i87 + i87;
                        objArr[i88] = objArrZze[i81];
                        if (i71 != 0) {
                            i81 = i85 + 1;
                            objArr[i88 + 1] = objArrZze[i85];
                            i60 = i86;
                        } else {
                            i81 = i85;
                            i60 = i86;
                            i71 = 0;
                        }
                    }
                    zzgvtVar = zzgvtVar;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzC4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i70 > 17) {
                    i17 = i16;
                    i18 = 0;
                } else {
                    int i89 = i16 + 1;
                    int iCharAt13 = strZzd.charAt(i16);
                    if (iCharAt13 >= 55296) {
                        int i90 = iCharAt13 & 8191;
                        int i91 = 13;
                        while (true) {
                            i17 = i89 + 1;
                            cCharAt9 = strZzd.charAt(i89);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i90 |= (cCharAt9 & 8191) << i91;
                            i91 += 13;
                            i89 = i17;
                        }
                        iCharAt13 = i90 | (cCharAt9 << i91);
                    } else {
                        i17 = i89;
                    }
                    int i92 = i5 + i5 + (iCharAt13 / 32);
                    Object obj3 = objArrZze[i92];
                    if (obj3 instanceof Field) {
                        fieldZzC = (Field) obj3;
                    } else {
                        fieldZzC = zzC(cls2, (String) obj3);
                        objArrZze[i92] = fieldZzC;
                    }
                    i18 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC);
                }
                if (i70 >= 18 && i70 <= 49) {
                    iArr[i61] = iObjectFieldOffset3;
                    i61++;
                }
                i2 = i81;
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i93 = i59 + 1;
            iArr2[i59] = iCharAt10;
            int i94 = i93 + 1;
            iArr2[i93] = iObjectFieldOffset2 | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i71 != 0 ? Integer.MIN_VALUE : 0) | (i70 << 20);
            i59 = i94 + 1;
            iArr2[i94] = (i18 << 20) | iObjectFieldOffset;
            i29 = i17;
            length = i72;
            zzgvtVar = zzgvtVar;
            strZzd = strZzd;
            i6 = i6;
            i3 = i3;
            c = 55296;
        }
        zzgvt zzgvtVar2 = zzgvtVar;
        return new zzgvm(iArr2, objArr, i3, i6, zzgvtVar2.zza(), zzgvtVar2.zzc(), false, iArr, i4, i56, zzgvoVar, zzguxVar, zzgwtVar, zzgtmVar, zzgveVar);
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzgxd.zzh(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzgxd.zzh(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzgxd.zzh(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
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

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzgxd.zzh(obj, j)).longValue();
    }

    private final zzgud zzw(int i) {
        int i2 = i / 3;
        return (zzgud) this.zzd[i2 + i2 + 1];
    }

    private final zzgwc zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgwc zzgwcVar = (zzgwc) objArr[i3];
        if (zzgwcVar != null) {
            return zzgwcVar;
        }
        zzgwc zzgwcVarZzb = zzgvr.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzgwcVarZzb;
        return zzgwcVarZzb;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzgwt zzgwtVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzh = zzgxd.zzh(obj, zzu(i) & 1048575);
        if (objZzh == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Code duplicated, block: B:137:0x038f  */
    /* JADX WARN: Code duplicated, block: B:207:0x0551  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v108, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v109, types: [com.google.android.gms.internal.ads.zzgur] */
    /* JADX WARN: Type inference failed for: r0v111, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v113, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v178, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v248, types: [int] */
    /* JADX WARN: Type inference failed for: r0v256 */
    /* JADX WARN: Type inference failed for: r0v258 */
    /* JADX WARN: Type inference failed for: r0v259 */
    /* JADX WARN: Type inference failed for: r0v260 */
    /* JADX WARN: Type inference failed for: r0v261 */
    /* JADX WARN: Type inference failed for: r0v262 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v8, types: [int] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v110, types: [int] */
    /* JADX WARN: Type inference failed for: r1v113, types: [int] */
    /* JADX WARN: Type inference failed for: r1v149 */
    /* JADX WARN: Type inference failed for: r1v152 */
    /* JADX WARN: Type inference failed for: r1v153 */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v156 */
    /* JADX WARN: Type inference failed for: r1v157 */
    /* JADX WARN: Type inference failed for: r1v70, types: [int] */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [int] */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzgwc
    public final int zza(Object obj) {
        int i;
        ?? r15;
        ?? r5;
        int iZzA;
        int iZzA2;
        int iZzB;
        int iZzA3;
        int iZzA4;
        int iZzA5;
        int iZzA6;
        ?? Zzg;
        int size;
        int iZzA7;
        int iZzz;
        int iZzz2;
        ?? r3;
        int iZzy;
        ?? ZzA;
        ?? Zzh;
        int iZze;
        int iZzA8;
        int iZzA9;
        ?? r4;
        ?? r6;
        ?? r1;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        boolean z = false;
        int i3 = 1048575;
        ?? r2 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.zzc.length) {
            int iZzu = zzu(i4);
            int iZzt = zzt(iZzu);
            int[] iArr = this.zzc;
            int i6 = iArr[i4];
            int i7 = iArr[i4 + 2];
            int i8 = i7 & i2;
            if (iZzt <= 17) {
                if (i8 != i3) {
                    r1 = i8 == i2 ? z : unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = i3;
                r15 = r1;
                r5 = 1 << (i7 >>> 20);
            } else {
                r1 = r2;
                i = i3;
                r15 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i9 = iZzu & i2;
            if (iZzt >= zzgtr.DOUBLE_LIST_PACKED.zza()) {
                zzgtr.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzt) {
                case 0:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzA = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 1:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzA2 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 2:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzgtg.zzB(unsafe.getLong(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 3:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzgtg.zzB(unsafe.getLong(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 4:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzgtg.zzx(unsafe.getInt(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 5:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzA = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 6:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzA2 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 7:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzA4 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 8:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzgsr) {
                            int i11 = zzgtg.zzf;
                            int iZzd = ((zzgsr) object).zzd();
                            iZzA5 = zzgtg.zzA(iZzd) + iZzd;
                            iZzA6 = zzgtg.zzA(i10);
                            Zzh = iZzA6 + iZzA5;
                            i5 += Zzh;
                        } else {
                            iZzB = zzgtg.zzz((String) object);
                            iZzA3 = zzgtg.zzA(i10);
                            Zzh = iZzA3 + iZzB;
                            i5 += Zzh;
                        }
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 9:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        Zzh = zzgwe.zzh(i6, unsafe.getObject(obj, j), zzx(i4));
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 10:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        zzgsr zzgsrVar = (zzgsr) unsafe.getObject(obj, j);
                        int i12 = zzgtg.zzf;
                        int iZzd2 = zzgsrVar.zzd();
                        iZzA5 = zzgtg.zzA(iZzd2) + iZzd2;
                        iZzA6 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA6 + iZzA5;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 11:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzgtg.zzA(unsafe.getInt(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 12:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzB = zzgtg.zzx(unsafe.getInt(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 13:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzA2 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 14:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        iZzA = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 15:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        iZzB = zzgtg.zzA((i13 >> 31) ^ (i13 + i13));
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 16:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        iZzB = zzgtg.zzB((j2 >> 63) ^ (j2 + j2));
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 17:
                    if (zzO(obj, i4, i, r15 == true ? 1 : 0, r5)) {
                        Zzh = zzgtg.zzw(i6, (zzgvj) unsafe.getObject(obj, j), zzx(i4));
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 18:
                    Zzh = zzgwe.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 19:
                    Zzh = zzgwe.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzgwe.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zzgwe.zzg(list) + (list.size() * zzgtg.zzA(i6 << 3));
                    }
                    i5 += Zzg;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zzgwe.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgwe.zzl(list2);
                        iZzA7 = zzgtg.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzgwe.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgwe.zzf(list3);
                        iZzA7 = zzgtg.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 23:
                    Zzh = zzgwe.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 24:
                    Zzh = zzgwe.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgwe.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzgtg.zzA(i6 << 3) + 1);
                    }
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i18 = zzgwe.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        boolean z2 = r0 instanceof zzgur;
                        int iZzA10 = zzgtg.zzA(i6 << 3) * size3;
                        if (z2) {
                            ?? r7 = (zzgur) r0;
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object objZzf = r7.zzf(r8);
                                if (objZzf instanceof zzgsr) {
                                    Zzg = iZzA10;
                                    int iZzd3 = ((zzgsr) objZzf).zzd();
                                    iZzz2 = Zzg + zzgtg.zzA(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzA10;
                                    iZzz2 = Zzg + zzgtg.zzz((String) objZzf);
                                }
                                Zzg = iZzz2;
                            }
                            Zzg = iZzA10;
                        } else {
                            for (?? r9 = z; r9 < size3; r9++) {
                                Object obj2 = r0.get(r9);
                                if (obj2 instanceof zzgsr) {
                                    Zzg = iZzA10;
                                    int iZzd4 = ((zzgsr) obj2).zzd();
                                    iZzz = Zzg + zzgtg.zzA(iZzd4) + iZzd4;
                                } else {
                                    Zzg = iZzA10;
                                    iZzz = Zzg + zzgtg.zzz((String) obj2);
                                }
                                Zzg = iZzz;
                            }
                            Zzg = iZzA10;
                        }
                    }
                    i5 += Zzg;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 27:
                    ?? r10 = (List) unsafe.getObject(obj, j);
                    zzgwc zzgwcVarZzx = zzx(i4);
                    int i19 = zzgwe.zza;
                    int size4 = r10.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzA11 = zzgtg.zzA(i6 << 3) * size4;
                        for (?? r11 = z; r11 < size4; r11++) {
                            Object obj3 = r10.get(r11);
                            if (obj3 instanceof zzgup) {
                                r3 = iZzA11;
                                int iZza = ((zzgup) obj3).zza();
                                iZzy = (r3 == true ? 1 : 0) + zzgtg.zzA(iZza) + iZza;
                            } else {
                                r3 = iZzA11;
                                iZzy = (r3 == true ? 1 : 0) + zzgtg.zzy((zzgvj) obj3, zzgwcVarZzx);
                            }
                            r3 = iZzy;
                        }
                        r3 = iZzA11;
                    }
                    i5 += r3;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 28:
                    ?? r12 = (List) unsafe.getObject(obj, j);
                    int i20 = zzgwe.zza;
                    int size5 = r12.size();
                    if (size5 == 0) {
                        ZzA = z;
                    } else {
                        ZzA = size5 * zzgtg.zzA(i6 << 3);
                        for (?? r13 = z; r13 < r12.size(); r13++) {
                            int iZzd5 = ((zzgsr) r12.get(r13)).zzd();
                            ZzA += zzgtg.zzA(iZzd5) + iZzd5;
                        }
                    }
                    i5 += ZzA;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zzgwe.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgwe.zzk(list5);
                        iZzA7 = zzgtg.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zzgwe.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgwe.zza(list6);
                        iZzA7 = zzgtg.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 31:
                    Zzh = zzgwe.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 32:
                    Zzh = zzgwe.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzgwe.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgwe.zzi(list7);
                        iZzA7 = zzgtg.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzgwe.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgwe.zzj(list8);
                        iZzA7 = zzgtg.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i5 += Zzh;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 35:
                    iZze = zzgwe.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 36:
                    iZze = zzgwe.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 37:
                    iZze = zzgwe.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 38:
                    iZze = zzgwe.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 39:
                    iZze = zzgwe.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 40:
                    iZze = zzgwe.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 41:
                    iZze = zzgwe.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzgwe.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 43:
                    iZze = zzgwe.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 44:
                    iZze = zzgwe.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 45:
                    iZze = zzgwe.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 46:
                    iZze = zzgwe.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 47:
                    iZze = zzgwe.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 48:
                    iZze = zzgwe.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzgtg.zzA(iZze);
                        iZzA9 = zzgtg.zzA(i6 << 3);
                        ZzA = iZzA9 + iZzA8 + iZze;
                        i5 += ZzA;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 49:
                    ?? r14 = (List) unsafe.getObject(obj, j);
                    zzgwc zzgwcVarZzx2 = zzx(i4);
                    int i26 = zzgwe.zza;
                    int size6 = r14.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z3 = z;
                        r4 = z3;
                        while (r6 < size6) {
                            r6 = z3;
                            int iZzw = zzgtg.zzw(i6, (zzgvj) r14.get(r6), zzgwcVarZzx2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzw;
                        }
                        r6 = z3;
                    }
                    i5 += r4;
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 50:
                    zzgvd zzgvdVar = (zzgvd) unsafe.getObject(obj, j);
                    if (zzgvdVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzgvdVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                case 51:
                    if (zzR(obj, i6, i4)) {
                        iZzA = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 52:
                    if (zzR(obj, i6, i4)) {
                        iZzA2 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 53:
                    if (zzR(obj, i6, i4)) {
                        iZzB = zzgtg.zzB(zzv(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 54:
                    if (zzR(obj, i6, i4)) {
                        iZzB = zzgtg.zzB(zzv(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 55:
                    if (zzR(obj, i6, i4)) {
                        iZzB = zzgtg.zzx(zzp(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 56:
                    if (zzR(obj, i6, i4)) {
                        iZzA = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 57:
                    if (zzR(obj, i6, i4)) {
                        iZzA2 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 58:
                    if (zzR(obj, i6, i4)) {
                        iZzA4 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 59:
                    if (zzR(obj, i6, i4)) {
                        int i27 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzgsr) {
                            int i28 = zzgtg.zzf;
                            int iZzd6 = ((zzgsr) object2).zzd();
                            iZzA5 = zzgtg.zzA(iZzd6) + iZzd6;
                            iZzA6 = zzgtg.zzA(i27);
                            Zzh = iZzA6 + iZzA5;
                            i5 += Zzh;
                        } else {
                            iZzB = zzgtg.zzz((String) object2);
                            iZzA3 = zzgtg.zzA(i27);
                            Zzh = iZzA3 + iZzB;
                            i5 += Zzh;
                        }
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 60:
                    if (zzR(obj, i6, i4)) {
                        Zzh = zzgwe.zzh(i6, unsafe.getObject(obj, j), zzx(i4));
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 61:
                    if (zzR(obj, i6, i4)) {
                        zzgsr zzgsrVar2 = (zzgsr) unsafe.getObject(obj, j);
                        int i29 = zzgtg.zzf;
                        int iZzd7 = zzgsrVar2.zzd();
                        iZzA5 = zzgtg.zzA(iZzd7) + iZzd7;
                        iZzA6 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA6 + iZzA5;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 62:
                    if (zzR(obj, i6, i4)) {
                        iZzB = zzgtg.zzA(zzp(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 63:
                    if (zzR(obj, i6, i4)) {
                        iZzB = zzgtg.zzx(zzp(obj, j));
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 64:
                    if (zzR(obj, i6, i4)) {
                        iZzA2 = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 65:
                    if (zzR(obj, i6, i4)) {
                        iZzA = zzgtg.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 66:
                    if (zzR(obj, i6, i4)) {
                        int iZzp = zzp(obj, j);
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        iZzB = zzgtg.zzA((iZzp >> 31) ^ (iZzp + iZzp));
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 67:
                    if (zzR(obj, i6, i4)) {
                        long jZzv = zzv(obj, j);
                        iZzA3 = zzgtg.zzA(i6 << 3);
                        iZzB = zzgtg.zzB((jZzv >> 63) ^ (jZzv + jZzv));
                        Zzh = iZzA3 + iZzB;
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                case 68:
                    if (zzR(obj, i6, i4)) {
                        Zzh = zzgtg.zzw(i6, (zzgvj) unsafe.getObject(obj, j), zzx(i4));
                        i5 += Zzh;
                    }
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
                default:
                    i4 += 3;
                    i3 = i;
                    r2 = r15;
                    i2 = 1048575;
                    z = false;
                    break;
            }
        }
        zzgwt zzgwtVar = this.zzn;
        int iZza2 = i5 + zzgwtVar.zza(zzgwtVar.zzd(obj));
        if (!this.zzh) {
            return iZza2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzu = zzu(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzt) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzgxd.zzb(obj, j));
                    byte[] bArr = zzguj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzgxd.zzc(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgxd.zzf(obj, j);
                    byte[] bArr2 = zzguj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgxd.zzf(obj, j);
                    byte[] bArr3 = zzguj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzgxd.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgxd.zzf(obj, j);
                    byte[] bArr4 = zzguj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzgxd.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zzguj.zza(zzgxd.zzz(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzgxd.zzh(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzh = zzgxd.zzh(obj, j);
                    if (objZzh != null) {
                        iHashCode = objZzh.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzgxd.zzh(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzgxd.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzgxd.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzgxd.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgxd.zzf(obj, j);
                    byte[] bArr5 = zzguj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzgxd.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgxd.zzf(obj, j);
                    byte[] bArr6 = zzguj.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzh2 = zzgxd.zzh(obj, j);
                    if (objZzh2 != null) {
                        iHashCode = objZzh2.hashCode();
                    }
                    i3 = i2 + iHashCode;
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
                    i = i3 * 53;
                    iFloatToIntBits = zzgxd.zzh(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zzgxd.zzh(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzguj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzguj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzguj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzguj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzguj.zza(zzS(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzgxd.zzh(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzgxd.zzh(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzgxd.zzh(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzguj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzguj.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzgxd.zzh(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:379:0x0833 A[PHI: r7 r8 r9 r10 r11 r14
      0x0833: PHI (r7v24 int) = (r7v6 int), (r7v8 int), (r7v9 int), (r7v14 int), (r7v18 int), (r7v22 int), (r7v28 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x0833: PHI (r8v98 int) = (r8v41 int), (r8v43 int), (r8v44 int), (r8v73 int), (r8v89 int), (r8v96 int), (r8v101 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x0833: PHI (r9v63 int) = (r9v35 int), (r9v37 int), (r9v38 int), (r9v51 int), (r9v59 int), (r9v61 int), (r9v66 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x0833: PHI (r10v72 int) = (r10v40 int), (r10v42 int), (r10v43 int), (r10v45 int), (r10v57 int), (r10v64 int), (r10v76 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x0833: PHI (r11v42 int) = (r11v20 int), (r11v22 int), (r11v23 int), (r11v25 int), (r11v34 int), (r11v40 int), (r11v46 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x0833: PHI (r14v44 sun.misc.Unsafe) = 
      (r14v23 sun.misc.Unsafe)
      (r14v25 sun.misc.Unsafe)
      (r14v26 sun.misc.Unsafe)
      (r14v28 sun.misc.Unsafe)
      (r14v36 sun.misc.Unsafe)
      (r14v42 sun.misc.Unsafe)
      (r14v47 sun.misc.Unsafe)
     binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:465:0x0ae0 A[PHI: r8 r10 r11 r12 r36
      0x0ae0: PHI (r8v123 com.google.android.gms.internal.ads.zzgsd) = 
      (r8v104 com.google.android.gms.internal.ads.zzgsd)
      (r8v105 com.google.android.gms.internal.ads.zzgsd)
      (r8v106 com.google.android.gms.internal.ads.zzgsd)
      (r8v107 com.google.android.gms.internal.ads.zzgsd)
      (r8v108 com.google.android.gms.internal.ads.zzgsd)
      (r8v109 com.google.android.gms.internal.ads.zzgsd)
      (r8v110 com.google.android.gms.internal.ads.zzgsd)
      (r8v111 com.google.android.gms.internal.ads.zzgsd)
      (r8v112 com.google.android.gms.internal.ads.zzgsd)
      (r8v116 com.google.android.gms.internal.ads.zzgsd)
      (r8v124 com.google.android.gms.internal.ads.zzgsd)
     binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]
      0x0ae0: PHI (r10v101 int) = 
      (r10v80 int)
      (r10v81 int)
      (r10v82 int)
      (r10v83 int)
      (r10v84 int)
      (r10v85 int)
      (r10v86 int)
      (r10v87 int)
      (r10v88 int)
      (r10v94 int)
      (r10v102 int)
     binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]
      0x0ae0: PHI (r11v64 int) = 
      (r11v48 int)
      (r11v49 int)
      (r11v50 int)
      (r11v51 int)
      (r11v52 int)
      (r11v53 int)
      (r11v54 int)
      (r11v55 int)
      (r11v56 int)
      (r11v59 int)
      (r11v65 int)
     binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]
      0x0ae0: PHI (r12v34 int) = 
      (r12v15 int)
      (r12v16 int)
      (r12v17 int)
      (r12v18 int)
      (r12v19 int)
      (r12v20 int)
      (r12v21 int)
      (r12v22 int)
      (r12v23 int)
      (r12v27 int)
      (r12v35 int)
     binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]
      0x0ae0: PHI (r36v21 int) = 
      (r36v3 int)
      (r36v4 int)
      (r36v5 int)
      (r36v6 int)
      (r36v7 int)
      (r36v8 int)
      (r36v9 int)
      (r36v10 int)
      (r36v14 int)
      (r36v16 int)
      (r36v22 int)
     binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:537:0x0836 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:540:0x0ae3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x0847 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x0af6 A[SYNTHETIC] */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzgsd zzgsdVar) throws IOException {
        zzgvm<T> zzgvmVar;
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Unsafe unsafe2;
        zzgsd zzgsdVar2;
        int i14;
        int i15;
        int i16;
        zzgtl zzgtlVar;
        int i17;
        int i18;
        int i19;
        int i20;
        int iZzk;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Unsafe unsafe3;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        Unsafe unsafe4;
        int i36;
        int iZzf;
        Object obj2;
        int i37;
        int iZzj;
        int i38;
        int i39;
        int i40;
        zzgvm<T> zzgvmVar2 = this;
        Object obj3 = obj;
        i2 = i2;
        i3 = i3;
        zzgsd zzgsdVar3 = zzgsdVar;
        zzD(obj);
        Unsafe unsafe5 = zzb;
        int i41 = -1;
        int iZzg = i;
        int i42 = -1;
        int i43 = 0;
        int i44 = 0;
        int i45 = 0;
        int i46 = 1048575;
        while (true) {
            if (iZzg < i2) {
                int i47 = iZzg + 1;
                int i48 = bArr[iZzg];
                if (i48 < 0) {
                    int iZzi = zzgse.zzi(i48, bArr, i47, zzgsdVar3);
                    i9 = zzgsdVar3.zza;
                    i47 = iZzi;
                } else {
                    i9 = i48;
                }
                int i49 = i9 >>> 3;
                int iZzs = i49 > i42 ? (i49 < zzgvmVar2.zze || i49 > zzgvmVar2.zzf) ? i41 : zzgvmVar2.zzs(i49, i43 / 3) : zzgvmVar2.zzq(i49);
                if (iZzs != i41) {
                    int i50 = i9 & 7;
                    int[] iArr = zzgvmVar2.zzc;
                    int i51 = iArr[iZzs + 1];
                    int i52 = i49;
                    int iZzt = zzt(i51);
                    long j = i51 & 1048575;
                    int i53 = i9;
                    if (iZzt <= 17) {
                        int i54 = iArr[iZzs + 2];
                        int i55 = 1 << (i54 >>> 20);
                        int i56 = 1048575;
                        int i57 = i54 & 1048575;
                        if (i57 != i46) {
                            if (i46 != 1048575) {
                                unsafe5.putInt(obj3, i46, i45);
                                i56 = 1048575;
                            }
                            i45 = i57 == i56 ? 0 : unsafe5.getInt(obj3, i57);
                            i12 = i57;
                        } else {
                            i12 = i46;
                        }
                        switch (iZzt) {
                            case 0:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 1) {
                                    iZzg = i47 + 8;
                                    i45 |= i55;
                                    zzgxd.zzr(obj3, j, Double.longBitsToDouble(zzgse.zzn(bArr, i47)));
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i58 = i47;
                                    i44 = i23;
                                    i10 = i58;
                                }
                                break;
                            case 1:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 5) {
                                    iZzg = i47 + 4;
                                    i45 |= i55;
                                    zzgxd.zzs(obj3, j, Float.intBitsToFloat(zzgse.zzb(bArr, i47)));
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i59 = i47;
                                    i44 = i23;
                                    i10 = i59;
                                }
                                break;
                            case 2:
                            case 3:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 0) {
                                    i20 = i45 | i55;
                                    iZzk = zzgse.zzk(bArr, i47, zzgsdVar3);
                                    unsafe5.putLong(obj, j, zzgsdVar3.zzb);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i45 = i20;
                                    iZzg = iZzk;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i510 = i47;
                                    i44 = i23;
                                    i10 = i510;
                                }
                                break;
                            case 4:
                            case 11:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 0) {
                                    i45 |= i55;
                                    iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                    unsafe5.putInt(obj3, j, zzgsdVar3.zza);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i511 = i47;
                                    i44 = i23;
                                    i10 = i511;
                                }
                                break;
                            case 5:
                            case 14:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 1) {
                                    iZzk = i47 + 8;
                                    i20 = i45 | i55;
                                    unsafe5.putLong(obj, j, zzgse.zzn(bArr, i47));
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i45 = i20;
                                    iZzg = iZzk;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i512 = i47;
                                    i44 = i23;
                                    i10 = i512;
                                }
                                break;
                            case 6:
                            case 13:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 5) {
                                    iZzg = i47 + 4;
                                    i45 |= i55;
                                    unsafe5.putInt(obj3, j, zzgse.zzb(bArr, i47));
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i513 = i47;
                                    i44 = i23;
                                    i10 = i513;
                                }
                                break;
                            case 7:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 0) {
                                    i45 |= i55;
                                    iZzg = zzgse.zzk(bArr, i47, zzgsdVar3);
                                    zzgxd.zzp(obj3, j, zzgsdVar3.zzb != 0);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i514 = i47;
                                    i44 = i23;
                                    i10 = i514;
                                }
                                break;
                            case 8:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 2) {
                                    if (zzM(i51)) {
                                        iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                        i21 = zzgsdVar3.zza;
                                        if (i21 < 0) {
                                            throw zzgul.zzf();
                                        }
                                        i22 = i45 | i55;
                                        if (i21 == 0) {
                                            zzgsdVar3.zzc = "";
                                        } else {
                                            zzgsdVar3.zzc = zzgxi.zzh(bArr, iZzg, i21);
                                            iZzg += i21;
                                        }
                                    } else {
                                        iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                        i21 = zzgsdVar3.zza;
                                        if (i21 < 0) {
                                            throw zzgul.zzf();
                                        }
                                        i22 = i45 | i55;
                                        if (i21 == 0) {
                                            zzgsdVar3.zzc = "";
                                        } else {
                                            zzgsdVar3.zzc = new String(bArr, iZzg, i21, zzguj.zzb);
                                            iZzg += i21;
                                        }
                                    }
                                    i45 = i22;
                                    unsafe5.putObject(obj3, j, zzgsdVar3.zzc);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i515 = i47;
                                    i44 = i23;
                                    i10 = i515;
                                }
                                break;
                            case 9:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 2) {
                                    Object objZzA = zzgvmVar2.zzA(obj3, i17);
                                    iZzg = zzgse.zzm(objZzA, zzgvmVar2.zzx(i17), bArr, i47, i2, zzgsdVar);
                                    zzgvmVar2.zzJ(obj3, i17, objZzA);
                                    i2 = i2;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i45 |= i55;
                                    i46 = i12;
                                    i41 = -1;
                                    i3 = i3;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i516 = i47;
                                    i44 = i23;
                                    i10 = i516;
                                }
                                break;
                            case 10:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 2) {
                                    i45 |= i55;
                                    iZzg = zzgse.zza(bArr, i47, zzgsdVar3);
                                    unsafe5.putObject(obj3, j, zzgsdVar3.zzc);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i517 = i47;
                                    i44 = i23;
                                    i10 = i517;
                                }
                                break;
                            case 12:
                                i17 = iZzs;
                                i18 = i52;
                                if (i50 == 0) {
                                    iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                    int i60 = zzgsdVar3.zza;
                                    zzgud zzgudVarZzw = zzgvmVar2.zzw(i17);
                                    if ((i51 & Integer.MIN_VALUE) == 0 || zzgudVarZzw == null || zzgudVarZzw.zza(i60)) {
                                        i19 = i53;
                                        i45 |= i55;
                                        unsafe5.putInt(obj3, j, i60);
                                    } else {
                                        i19 = i53;
                                        zzd(obj).zzj(i19, Long.valueOf(i60));
                                    }
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i52 = i18;
                                    i24 = i17;
                                    i23 = i53;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i518 = i47;
                                    i44 = i23;
                                    i10 = i518;
                                }
                                break;
                            case 15:
                                i17 = iZzs;
                                i18 = i52;
                                if (i50 == 0) {
                                    i45 |= i55;
                                    iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                    unsafe5.putInt(obj3, j, zzgsz.zzF(zzgsdVar3.zza));
                                    i42 = i18;
                                    i43 = i17;
                                    i44 = i53;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i52 = i18;
                                    i24 = i17;
                                    i23 = i53;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i519 = i47;
                                    i44 = i23;
                                    i10 = i519;
                                }
                                break;
                            case 16:
                                if (i50 == 0) {
                                    int i61 = i45 | i55;
                                    int iZzk2 = zzgse.zzk(bArr, i47, zzgsdVar3);
                                    i18 = i52;
                                    i17 = iZzs;
                                    unsafe5.putLong(obj, j, zzgsz.zzG(zzgsdVar3.zzb));
                                    iZzg = iZzk2;
                                    i45 = i61;
                                    i42 = i18;
                                    i43 = i17;
                                    i44 = i53;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i24 = iZzs;
                                    i23 = i53;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i5110 = i47;
                                    i44 = i23;
                                    i10 = i5110;
                                }
                                break;
                            default:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 3) {
                                    int i62 = i45 | i55;
                                    Object objZzA2 = zzgvmVar2.zzA(obj3, i17);
                                    int iZzl = zzgse.zzl(objZzA2, zzgvmVar2.zzx(i17), bArr, i47, i2, (i18 << 3) | 4, zzgsdVar);
                                    zzgvmVar2.zzJ(obj3, i17, objZzA2);
                                    i3 = i3;
                                    zzgsdVar3 = zzgsdVar3;
                                    i2 = i2;
                                    unsafe5 = unsafe5;
                                    iZzg = iZzl;
                                    i41 = -1;
                                    i46 = i12;
                                    i45 = i62;
                                    i44 = i19;
                                    i43 = i17;
                                    i42 = i18;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgsdVar2 = zzgsdVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i5111 = i47;
                                    i44 = i23;
                                    i10 = i5111;
                                }
                                break;
                        }
                    } else {
                        i11 = i45;
                        i12 = i46;
                        Unsafe unsafe6 = unsafe5;
                        i13 = -1;
                        int i63 = i2;
                        if (iZzt != 27) {
                            unsafe2 = unsafe6;
                            if (iZzt <= 49) {
                                long j2 = i51;
                                Unsafe unsafe7 = zzb;
                                zzgui zzguiVarZzd = (zzgui) unsafe7.getObject(obj3, j);
                                if (!zzguiVarZzd.zzc()) {
                                    int size = zzguiVarZzd.size();
                                    zzguiVarZzd = zzguiVarZzd.zzd(size != 0 ? size + size : 10);
                                    unsafe7.putObject(obj3, j, zzguiVarZzd);
                                }
                                zzgui zzguiVar = zzguiVarZzd;
                                switch (iZzt) {
                                    case 18:
                                    case 35:
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (i50 == 2) {
                                            zzgti zzgtiVar = (zzgti) zzguiVar;
                                            iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                            int i64 = zzgsdVar3.zza + iZzg;
                                            while (iZzg < i64) {
                                                zzgtiVar.zze(Double.longBitsToDouble(zzgse.zzn(bArr, iZzg)));
                                                iZzg += 8;
                                            }
                                            if (iZzg != i64) {
                                                throw zzgul.zzj();
                                            }
                                        } else if (i50 == 1) {
                                            i32 = i47 + 8;
                                            zzgti zzgtiVar2 = (zzgti) zzguiVar;
                                            zzgtiVar2.zze(Double.longBitsToDouble(zzgse.zzn(bArr, i47)));
                                            while (i32 < i31) {
                                                int iZzh = zzgse.zzh(bArr, i32, zzgsdVar3);
                                                if (i28 == zzgsdVar3.zza) {
                                                    zzgtiVar2.zze(Double.longBitsToDouble(zzgse.zzn(bArr, iZzh)));
                                                    i32 = iZzh + 8;
                                                } else {
                                                    iZzg = i32;
                                                }
                                            }
                                            iZzg = i32;
                                        } else {
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (i50 == 2) {
                                            zzgts zzgtsVar = (zzgts) zzguiVar;
                                            iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                            int i65 = zzgsdVar3.zza + iZzg;
                                            while (iZzg < i65) {
                                                zzgtsVar.zze(Float.intBitsToFloat(zzgse.zzb(bArr, iZzg)));
                                                iZzg += 4;
                                            }
                                            if (iZzg != i65) {
                                                throw zzgul.zzj();
                                            }
                                        } else if (i50 == 5) {
                                            i32 = i47 + 4;
                                            zzgts zzgtsVar2 = (zzgts) zzguiVar;
                                            zzgtsVar2.zze(Float.intBitsToFloat(zzgse.zzb(bArr, i47)));
                                            while (i32 < i31) {
                                                int iZzh2 = zzgse.zzh(bArr, i32, zzgsdVar3);
                                                if (i28 == zzgsdVar3.zza) {
                                                    zzgtsVar2.zze(Float.intBitsToFloat(zzgse.zzb(bArr, iZzh2)));
                                                    i32 = iZzh2 + 4;
                                                } else {
                                                    iZzg = i32;
                                                }
                                            }
                                            iZzg = i32;
                                        } else {
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (i50 == 2) {
                                            zzguy zzguyVar = (zzguy) zzguiVar;
                                            iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                            int i66 = zzgsdVar3.zza + iZzg;
                                            while (iZzg < i66) {
                                                iZzg = zzgse.zzk(bArr, iZzg, zzgsdVar3);
                                                zzguyVar.zzg(zzgsdVar3.zzb);
                                            }
                                            if (iZzg != i66) {
                                                throw zzgul.zzj();
                                            }
                                        } else if (i50 == 0) {
                                            zzguy zzguyVar2 = (zzguy) zzguiVar;
                                            iZzg = zzgse.zzk(bArr, i47, zzgsdVar3);
                                            zzguyVar2.zzg(zzgsdVar3.zzb);
                                            while (iZzg < i31) {
                                                int iZzh3 = zzgse.zzh(bArr, iZzg, zzgsdVar3);
                                                if (i28 == zzgsdVar3.zza) {
                                                    iZzg = zzgse.zzk(bArr, iZzh3, zzgsdVar3);
                                                    zzguyVar2.zzg(zzgsdVar3.zzb);
                                                }
                                            }
                                        } else {
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 == 2) {
                                            iZzf = zzgse.zzf(bArr, i33, zzguiVar, zzgsdVar3);
                                            i47 = i33;
                                            iZzg = iZzf;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                        } else if (i50 == 0) {
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = zzgse.zzj(i28, bArr, i47, i2, zzguiVar, zzgsdVar);
                                        } else {
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 != 2) {
                                            if (i50 == 1) {
                                                iZzf = i33 + 8;
                                                zzguy zzguyVar3 = (zzguy) zzguiVar;
                                                zzguyVar3.zzg(zzgse.zzn(bArr, i33));
                                                while (iZzf < i34) {
                                                    int iZzh4 = zzgse.zzh(bArr, iZzf, zzgsdVar3);
                                                    if (i28 == zzgsdVar3.zza) {
                                                        zzguyVar3.zzg(zzgse.zzn(bArr, iZzh4));
                                                        iZzf = iZzh4 + 8;
                                                    }
                                                }
                                            }
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgsdVar2 = zzgsdVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzguy zzguyVar4 = (zzguy) zzguiVar;
                                            iZzf = zzgse.zzh(bArr, i33, zzgsdVar3);
                                            int i67 = zzgsdVar3.zza + iZzf;
                                            while (iZzf < i67) {
                                                zzguyVar4.zzg(zzgse.zzn(bArr, iZzf));
                                                iZzf += 8;
                                            }
                                            if (iZzf != i67) {
                                                throw zzgul.zzj();
                                            }
                                        }
                                        i47 = i33;
                                        iZzg = iZzf;
                                        i30 = i36;
                                        i31 = i34;
                                        i29 = i35;
                                        unsafe3 = unsafe4;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 != 2) {
                                            if (i50 == 5) {
                                                iZzf = i33 + 4;
                                                zzgua zzguaVar = (zzgua) zzguiVar;
                                                zzguaVar.zzh(zzgse.zzb(bArr, i33));
                                                while (iZzf < i34) {
                                                    int iZzh5 = zzgse.zzh(bArr, iZzf, zzgsdVar3);
                                                    if (i28 == zzgsdVar3.zza) {
                                                        zzguaVar.zzh(zzgse.zzb(bArr, iZzh5));
                                                        iZzf = iZzh5 + 4;
                                                    }
                                                }
                                            }
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgsdVar2 = zzgsdVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzgua zzguaVar2 = (zzgua) zzguiVar;
                                            iZzf = zzgse.zzh(bArr, i33, zzgsdVar3);
                                            int i68 = zzgsdVar3.zza + iZzf;
                                            while (iZzf < i68) {
                                                zzguaVar2.zzh(zzgse.zzb(bArr, iZzf));
                                                iZzf += 4;
                                            }
                                            if (iZzf != i68) {
                                                throw zzgul.zzj();
                                            }
                                        }
                                        i47 = i33;
                                        iZzg = iZzf;
                                        i30 = i36;
                                        i31 = i34;
                                        i29 = i35;
                                        unsafe3 = unsafe4;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 != 2) {
                                            if (i50 == 0) {
                                                zzgsf zzgsfVar = (zzgsf) zzguiVar;
                                                iZzf = zzgse.zzk(bArr, i33, zzgsdVar3);
                                                zzgsfVar.zze(zzgsdVar3.zzb != 0);
                                                while (iZzf < i34) {
                                                    int iZzh6 = zzgse.zzh(bArr, iZzf, zzgsdVar3);
                                                    if (i28 == zzgsdVar3.zza) {
                                                        iZzf = zzgse.zzk(bArr, iZzh6, zzgsdVar3);
                                                        zzgsfVar.zze(zzgsdVar3.zzb != 0);
                                                    }
                                                }
                                            }
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgsdVar2 = zzgsdVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzgsf zzgsfVar2 = (zzgsf) zzguiVar;
                                            iZzf = zzgse.zzh(bArr, i33, zzgsdVar3);
                                            int i69 = zzgsdVar3.zza + iZzf;
                                            while (iZzf < i69) {
                                                iZzf = zzgse.zzk(bArr, iZzf, zzgsdVar3);
                                                zzgsfVar2.zze(zzgsdVar3.zzb != 0);
                                            }
                                            if (iZzf != i69) {
                                                throw zzgul.zzj();
                                            }
                                        }
                                        i47 = i33;
                                        iZzg = iZzf;
                                        i30 = i36;
                                        i31 = i34;
                                        i29 = i35;
                                        unsafe3 = unsafe4;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 26:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 == 2) {
                                            if ((j2 & 536870912) == 0) {
                                                iZzf = zzgse.zzh(bArr, i33, zzgsdVar3);
                                                int i70 = zzgsdVar3.zza;
                                                if (i70 < 0) {
                                                    throw zzgul.zzf();
                                                }
                                                if (i70 == 0) {
                                                    obj2 = "";
                                                    zzguiVar.add(obj2);
                                                } else {
                                                    obj2 = "";
                                                    zzguiVar.add(new String(bArr, iZzf, i70, zzguj.zzb));
                                                    iZzf += i70;
                                                }
                                                while (iZzf < i34) {
                                                    int iZzh7 = zzgse.zzh(bArr, iZzf, zzgsdVar3);
                                                    if (i28 == zzgsdVar3.zza) {
                                                        iZzf = zzgse.zzh(bArr, iZzh7, zzgsdVar3);
                                                        int i71 = zzgsdVar3.zza;
                                                        if (i71 < 0) {
                                                            throw zzgul.zzf();
                                                        }
                                                        if (i71 == 0) {
                                                            zzguiVar.add(obj2);
                                                        } else {
                                                            zzguiVar.add(new String(bArr, iZzf, i71, zzguj.zzb));
                                                            iZzf += i71;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZzf = zzgse.zzh(bArr, i33, zzgsdVar3);
                                                int i72 = zzgsdVar3.zza;
                                                if (i72 < 0) {
                                                    throw zzgul.zzf();
                                                }
                                                if (i72 == 0) {
                                                    zzguiVar.add("");
                                                } else {
                                                    int i73 = iZzf + i72;
                                                    if (!zzgxi.zzj(bArr, iZzf, i73)) {
                                                        throw zzgul.zzd();
                                                    }
                                                    zzguiVar.add(new String(bArr, iZzf, i72, zzguj.zzb));
                                                    iZzf = i73;
                                                }
                                                while (iZzf < i34) {
                                                    int iZzh8 = zzgse.zzh(bArr, iZzf, zzgsdVar3);
                                                    if (i28 == zzgsdVar3.zza) {
                                                        iZzf = zzgse.zzh(bArr, iZzh8, zzgsdVar3);
                                                        int i74 = zzgsdVar3.zza;
                                                        if (i74 < 0) {
                                                            throw zzgul.zzf();
                                                        }
                                                        if (i74 == 0) {
                                                            zzguiVar.add("");
                                                        } else {
                                                            int i75 = iZzf + i74;
                                                            if (!zzgxi.zzj(bArr, iZzf, i75)) {
                                                                throw zzgul.zzd();
                                                            }
                                                            zzguiVar.add(new String(bArr, iZzf, i74, zzguj.zzb));
                                                            iZzf = i75;
                                                        }
                                                    }
                                                }
                                            }
                                            i47 = i33;
                                            iZzg = iZzf;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgsdVar2 = zzgsdVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        }
                                        i47 = i33;
                                        i30 = i36;
                                        i31 = i34;
                                        i29 = i35;
                                        unsafe3 = unsafe4;
                                        iZzg = i47;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 27:
                                        i37 = i53;
                                        i47 = i47;
                                        i63 = i63;
                                        unsafe2 = unsafe2;
                                        if (i50 == 2) {
                                            i28 = i37;
                                            int iZze = zzgse.zze(zzgvmVar2.zzx(iZzs), i37, bArr, i47, i2, zzguiVar, zzgsdVar);
                                            zzgsdVar3 = zzgsdVar3;
                                            i31 = i63;
                                            i29 = iZzs;
                                            unsafe3 = unsafe2;
                                            iZzg = iZze;
                                            i30 = i52;
                                        } else {
                                            i28 = i37;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            int i76 = i63;
                                            i29 = iZzs;
                                            i31 = i76;
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 28:
                                        i37 = i53;
                                        i47 = i47;
                                        i63 = i63;
                                        unsafe2 = unsafe2;
                                        if (i50 == 2) {
                                            iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                            int i77 = zzgsdVar3.zza;
                                            if (i77 < 0) {
                                                throw zzgul.zzf();
                                            }
                                            if (i77 > bArr.length - iZzg) {
                                                throw zzgul.zzj();
                                            }
                                            if (i77 == 0) {
                                                zzguiVar.add(zzgsr.zzb);
                                            } else {
                                                zzguiVar.add(zzgsr.zzv(bArr, iZzg, i77));
                                                iZzg += i77;
                                            }
                                            while (iZzg < i63) {
                                                int iZzh9 = zzgse.zzh(bArr, iZzg, zzgsdVar3);
                                                if (i37 != zzgsdVar3.zza) {
                                                    i28 = i37;
                                                    unsafe3 = unsafe2;
                                                    i30 = i52;
                                                    int i78 = i63;
                                                    i29 = iZzs;
                                                    i31 = i78;
                                                    if (iZzg != i47) {
                                                        i3 = i3;
                                                        i44 = i28;
                                                        i42 = i30;
                                                        i43 = i29;
                                                        unsafe5 = unsafe3;
                                                        i41 = -1;
                                                        i45 = i11;
                                                        i46 = i12;
                                                        obj3 = obj;
                                                        i2 = i31;
                                                    } else {
                                                        i10 = iZzg;
                                                        i44 = i28;
                                                        i15 = i30;
                                                        i14 = i29;
                                                        zzgsdVar2 = zzgsdVar3;
                                                        unsafe2 = unsafe3;
                                                        obj3 = obj;
                                                        i5 = i31;
                                                        i4 = i3;
                                                    }
                                                    break;
                                                } else {
                                                    iZzg = zzgse.zzh(bArr, iZzh9, zzgsdVar3);
                                                    int i79 = zzgsdVar3.zza;
                                                    if (i79 < 0) {
                                                        throw zzgul.zzf();
                                                    }
                                                    if (i79 > bArr.length - iZzg) {
                                                        throw zzgul.zzj();
                                                    }
                                                    if (i79 == 0) {
                                                        zzguiVar.add(zzgsr.zzb);
                                                    } else {
                                                        zzguiVar.add(zzgsr.zzv(bArr, iZzg, i79));
                                                        iZzg += i79;
                                                    }
                                                }
                                            }
                                            i28 = i37;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            int i710 = i63;
                                            i29 = iZzs;
                                            i31 = i710;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgsdVar2 = zzgsdVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        }
                                        i28 = i37;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        int i711 = i63;
                                        i29 = iZzs;
                                        i31 = i711;
                                        iZzg = i47;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        if (i50 != 2) {
                                            if (i50 == 0) {
                                                iZzj = zzgse.zzj(i53, bArr, i47, i2, zzguiVar, zzgsdVar);
                                            }
                                            i28 = i53;
                                            i47 = i47;
                                            i29 = iZzs;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            i31 = i63;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgsdVar2 = zzgsdVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            iZzj = zzgse.zzf(bArr, i47, zzguiVar, zzgsdVar3);
                                        }
                                        int i80 = iZzj;
                                        zzgwe.zzo(obj, i52, zzguiVar, zzgvmVar2.zzw(iZzs), null, zzgvmVar2.zzn);
                                        i28 = i53;
                                        iZzg = i80;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        int i712 = i63;
                                        i29 = iZzs;
                                        i31 = i712;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        if (i50 != 2) {
                                            if (i50 == 0) {
                                                zzgua zzguaVar3 = (zzgua) zzguiVar;
                                                iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                                zzguaVar3.zzh(zzgsz.zzF(zzgsdVar3.zza));
                                                while (iZzg < i63) {
                                                    int iZzh10 = zzgse.zzh(bArr, iZzg, zzgsdVar3);
                                                    if (i53 == zzgsdVar3.zza) {
                                                        iZzg = zzgse.zzh(bArr, iZzh10, zzgsdVar3);
                                                        zzguaVar3.zzh(zzgsz.zzF(zzgsdVar3.zza));
                                                    }
                                                }
                                            }
                                            i28 = i53;
                                            i47 = i47;
                                            i29 = iZzs;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            i31 = i63;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgsdVar2 = zzgsdVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzgua zzguaVar4 = (zzgua) zzguiVar;
                                            iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                            int i81 = zzgsdVar3.zza + iZzg;
                                            while (iZzg < i81) {
                                                iZzg = zzgse.zzh(bArr, iZzg, zzgsdVar3);
                                                zzguaVar4.zzh(zzgsz.zzF(zzgsdVar3.zza));
                                            }
                                            if (iZzg != i81) {
                                                throw zzgul.zzj();
                                            }
                                        }
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        if (i50 != 2) {
                                            if (i50 == 0) {
                                                zzguy zzguyVar5 = (zzguy) zzguiVar;
                                                iZzg = zzgse.zzk(bArr, i47, zzgsdVar3);
                                                zzguyVar5.zzg(zzgsz.zzG(zzgsdVar3.zzb));
                                                while (iZzg < i63) {
                                                    int iZzh11 = zzgse.zzh(bArr, iZzg, zzgsdVar3);
                                                    if (i53 == zzgsdVar3.zza) {
                                                        iZzg = zzgse.zzk(bArr, iZzh11, zzgsdVar3);
                                                        zzguyVar5.zzg(zzgsz.zzG(zzgsdVar3.zzb));
                                                    }
                                                }
                                            }
                                            i28 = i53;
                                            i47 = i47;
                                            i29 = iZzs;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            i31 = i63;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgsdVar2 = zzgsdVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzguy zzguyVar6 = (zzguy) zzguiVar;
                                            iZzg = zzgse.zzh(bArr, i47, zzgsdVar3);
                                            int i82 = zzgsdVar3.zza + iZzg;
                                            while (iZzg < i82) {
                                                iZzg = zzgse.zzk(bArr, iZzg, zzgsdVar3);
                                                zzguyVar6.zzg(zzgsz.zzG(zzgsdVar3.zzb));
                                            }
                                            if (iZzg != i82) {
                                                throw zzgul.zzj();
                                            }
                                        }
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    default:
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (i50 == 3) {
                                            int i83 = (i28 & (-8)) | 4;
                                            zzgwc zzgwcVarZzx = zzgvmVar2.zzx(i29);
                                            iZzg = zzgse.zzc(zzgwcVarZzx, bArr, i47, i2, i83, zzgsdVar);
                                            zzguiVar.add(zzgsdVar3.zzc);
                                            while (iZzg < i31) {
                                                int iZzh12 = zzgse.zzh(bArr, iZzg, zzgsdVar3);
                                                if (i28 == zzgsdVar3.zza) {
                                                    iZzg = zzgse.zzc(zzgwcVarZzx, bArr, iZzh12, i2, i83, zzgsdVar);
                                                    zzguiVar.add(zzgsdVar3.zzc);
                                                }
                                            }
                                        } else {
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgsdVar2 = zzgsdVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                }
                            } else {
                                i27 = iZzs;
                                i26 = i52;
                                i25 = i47;
                                if (iZzt != 50) {
                                    i44 = i53;
                                    obj3 = obj;
                                    Unsafe unsafe8 = zzb;
                                    long j3 = iArr[i27 + 2] & 1048575;
                                    switch (iZzt) {
                                        case 51:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 1) {
                                                iZzg = i39 + 8;
                                                unsafe8.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzgse.zzn(bArr, i39))));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 52:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 5) {
                                                iZzg = i39 + 4;
                                                unsafe8.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzgse.zzb(bArr, i39))));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgse.zzk(bArr, i39, zzgsdVar2);
                                                unsafe8.putObject(obj3, j, Long.valueOf(zzgsdVar2.zzb));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgse.zzh(bArr, i39, zzgsdVar2);
                                                unsafe8.putObject(obj3, j, Integer.valueOf(zzgsdVar2.zza));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 1) {
                                                iZzg = i39 + 8;
                                                unsafe8.putObject(obj3, j, Long.valueOf(zzgse.zzn(bArr, i39)));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 5) {
                                                iZzg = i39 + 4;
                                                unsafe8.putObject(obj3, j, Integer.valueOf(zzgse.zzb(bArr, i39)));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 58:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgse.zzk(bArr, i39, zzgsdVar2);
                                                unsafe8.putObject(obj3, j, Boolean.valueOf(zzgsdVar2.zzb != 0));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 59:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 2) {
                                                int iZzh13 = zzgse.zzh(bArr, i39, zzgsdVar2);
                                                int i84 = zzgsdVar2.zza;
                                                if (i84 == 0) {
                                                    unsafe8.putObject(obj3, j, "");
                                                } else {
                                                    int i85 = iZzh13 + i84;
                                                    if ((i51 & 536870912) != 0 && !zzgxi.zzj(bArr, iZzh13, i85)) {
                                                        throw zzgul.zzd();
                                                    }
                                                    unsafe8.putObject(obj3, j, new String(bArr, iZzh13, i84, zzguj.zzb));
                                                    iZzh13 = i85;
                                                }
                                                unsafe8.putInt(obj3, j3, i15);
                                                iZzg = iZzh13;
                                            } else {
                                                i38 = i38;
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 60:
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 2) {
                                                Object objZzB = zzB(obj3, i26, i27);
                                                i15 = i26;
                                                iZzg = zzgse.zzm(objZzB, zzx(i27), bArr, i39, i2, zzgsdVar);
                                                zzK(obj3, i15, i27, objZzB);
                                                i38 = i27;
                                                i5 = i2;
                                            } else {
                                                i15 = i26;
                                                i5 = i2;
                                                i38 = i27;
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 61:
                                            i40 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 2) {
                                                iZzg = zzgse.zza(bArr, i39, zzgsdVar2);
                                                unsafe8.putObject(obj3, j, zzgsdVar2.zzc);
                                                unsafe8.putInt(obj3, j3, i40);
                                                i5 = i2;
                                                i38 = i27;
                                                i15 = i40;
                                                if (iZzg == i39) {
                                                    i44 = i44;
                                                    zzgvmVar2 = this;
                                                    i43 = i38;
                                                    i3 = i3;
                                                    zzgsdVar3 = zzgsdVar2;
                                                    i2 = i5;
                                                    i42 = i15;
                                                    i41 = -1;
                                                    i45 = i11;
                                                    unsafe5 = unsafe2;
                                                    i46 = i12;
                                                } else {
                                                    i44 = i44;
                                                    i14 = i38;
                                                    i4 = i3;
                                                    i10 = iZzg;
                                                }
                                            }
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i40;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 63:
                                            i40 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgse.zzh(bArr, i39, zzgsdVar2);
                                                int i86 = zzgsdVar2.zza;
                                                zzgud zzgudVarZzw2 = zzw(i27);
                                                if (zzgudVarZzw2 == null || zzgudVarZzw2.zza(i86)) {
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(i86));
                                                    unsafe8.putInt(obj3, j3, i40);
                                                } else {
                                                    zzd(obj).zzj(i44, Long.valueOf(i86));
                                                }
                                                i5 = i2;
                                                i38 = i27;
                                                i15 = i40;
                                                if (iZzg == i39) {
                                                    i44 = i44;
                                                    zzgvmVar2 = this;
                                                    i43 = i38;
                                                    i3 = i3;
                                                    zzgsdVar3 = zzgsdVar2;
                                                    i2 = i5;
                                                    i42 = i15;
                                                    i41 = -1;
                                                    i45 = i11;
                                                    unsafe5 = unsafe2;
                                                    i46 = i12;
                                                } else {
                                                    i44 = i44;
                                                    i14 = i38;
                                                    i4 = i3;
                                                    i10 = iZzg;
                                                }
                                            }
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i40;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 66:
                                            i40 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgse.zzh(bArr, i39, zzgsdVar2);
                                                unsafe8.putObject(obj3, j, Integer.valueOf(zzgsz.zzF(zzgsdVar2.zza)));
                                                unsafe8.putInt(obj3, j3, i40);
                                                i5 = i2;
                                                i38 = i27;
                                                i15 = i40;
                                                if (iZzg == i39) {
                                                    i44 = i44;
                                                    zzgvmVar2 = this;
                                                    i43 = i38;
                                                    i3 = i3;
                                                    zzgsdVar3 = zzgsdVar2;
                                                    i2 = i5;
                                                    i42 = i15;
                                                    i41 = -1;
                                                    i45 = i11;
                                                    unsafe5 = unsafe2;
                                                    i46 = i12;
                                                } else {
                                                    i44 = i44;
                                                    i14 = i38;
                                                    i4 = i3;
                                                    i10 = iZzg;
                                                }
                                            }
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i40;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 67:
                                            i40 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                int iZzk3 = zzgse.zzk(bArr, i39, zzgsdVar2);
                                                unsafe8.putObject(obj3, j, Long.valueOf(zzgsz.zzG(zzgsdVar2.zzb)));
                                                unsafe8.putInt(obj3, j3, i40);
                                                iZzg = iZzk3;
                                                i5 = i2;
                                                i38 = i27;
                                                i15 = i40;
                                                if (iZzg == i39) {
                                                    i44 = i44;
                                                    zzgvmVar2 = this;
                                                    i43 = i38;
                                                    i3 = i3;
                                                    zzgsdVar3 = zzgsdVar2;
                                                    i2 = i5;
                                                    i42 = i15;
                                                    i41 = -1;
                                                    i45 = i11;
                                                    unsafe5 = unsafe2;
                                                    i46 = i12;
                                                } else {
                                                    i44 = i44;
                                                    i14 = i38;
                                                    i4 = i3;
                                                    i10 = iZzg;
                                                }
                                            }
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i40;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 68:
                                            if (i50 != 3) {
                                                break;
                                            } else {
                                                Object objZzB2 = zzB(obj3, i26, i27);
                                                zzgsd zzgsdVar4 = zzgsdVar3;
                                                int iZzl2 = zzgse.zzl(objZzB2, zzx(i27), bArr, i25, i2, (i44 & (-8)) | 4, zzgsdVar);
                                                zzK(obj3, i26, i27, objZzB2);
                                                i5 = i2;
                                                i39 = i25;
                                                i38 = i27;
                                                i15 = i26;
                                                iZzg = iZzl2;
                                                zzgsdVar2 = zzgsdVar4;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                                break;
                                            } else {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                                break;
                                            }
                                        default:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgsdVar2 = zzgsdVar3;
                                            i39 = i25;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzgvmVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgsdVar3 = zzgsdVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i50 == 2) {
                                        Unsafe unsafe9 = zzb;
                                        Object objZzz = zzgvmVar2.zzz(i27);
                                        Object object = unsafe9.getObject(obj, j);
                                        if (zzgve.zza(object)) {
                                            zzgvd zzgvdVarZzb = zzgvd.zza().zzb();
                                            zzgve.zzb(zzgvdVarZzb, object);
                                            unsafe9.putObject(obj, j, zzgvdVarZzb);
                                        }
                                        throw null;
                                    }
                                    i44 = i53;
                                    obj3 = obj;
                                    i4 = i3;
                                    i14 = i27;
                                    i5 = i63;
                                    i10 = i25;
                                    i15 = i26;
                                    zzgsdVar2 = zzgsdVar3;
                                }
                            }
                        } else if (i50 == 2) {
                            zzgui zzguiVarZzd2 = (zzgui) unsafe6.getObject(obj3, j);
                            if (!zzguiVarZzd2.zzc()) {
                                int size2 = zzguiVarZzd2.size();
                                zzguiVarZzd2 = zzguiVarZzd2.zzd(size2 != 0 ? size2 + size2 : 10);
                                unsafe6.putObject(obj3, j, zzguiVarZzd2);
                            }
                            i42 = i52;
                            int iZze2 = zzgse.zze(zzgvmVar2.zzx(iZzs), i53, bArr, i47, i2, zzguiVarZzd2, zzgsdVar);
                            i3 = i3;
                            zzgsdVar3 = zzgsdVar3;
                            i2 = i63;
                            unsafe5 = unsafe6;
                            i41 = -1;
                            i45 = i11;
                            i46 = i12;
                            i44 = i53;
                            i43 = iZzs;
                            iZzg = iZze2;
                        } else {
                            i25 = i47;
                            i26 = i52;
                            i44 = i53;
                            unsafe2 = unsafe6;
                            i27 = iZzs;
                            i4 = i3;
                            i14 = i27;
                            i5 = i63;
                            i10 = i25;
                            i15 = i26;
                            zzgsdVar2 = zzgsdVar3;
                        }
                    }
                } else {
                    i10 = i47;
                    i11 = i45;
                    i12 = i46;
                    i44 = i9;
                    i13 = i41;
                    unsafe2 = unsafe5;
                    zzgsdVar2 = zzgsdVar3;
                    i4 = i3;
                    i5 = i2;
                    i14 = 0;
                    i15 = i49;
                }
                if (i44 != i4 || i4 == 0) {
                    if (!this.zzh || (zzgtlVar = zzgsdVar2.zzd) == zzgtl.zza) {
                        i16 = i44;
                        iZzg = zzgse.zzg(i16, bArr, i10, i2, zzd(obj), zzgsdVar);
                    } else {
                        if (zzgtlVar.zzc(this.zzg, i15) != null) {
                            throw null;
                        }
                        i16 = i44;
                        iZzg = zzgse.zzg(i44, bArr, i10, i2, zzd(obj), zzgsdVar);
                    }
                    i43 = i14;
                    i42 = i15;
                    zzgvmVar2 = this;
                    i44 = i16;
                    unsafe5 = unsafe2;
                    i45 = i11;
                    i46 = i12;
                    zzgsdVar3 = zzgsdVar2;
                    i3 = i4;
                    i2 = i5;
                    i41 = i13;
                } else {
                    i8 = 1048575;
                    zzgvmVar = this;
                    i6 = i10;
                    i7 = i44;
                    i45 = i11;
                    unsafe = unsafe2;
                    i46 = i12;
                }
            } else {
                zzgvmVar = zzgvmVar2;
                i4 = i3;
                i5 = i2;
                unsafe = unsafe5;
                i6 = iZzg;
                i7 = i44;
                i8 = 1048575;
            }
        }
        if (i46 != i8) {
            unsafe.putInt(obj3, i46, i45);
        }
        for (int i87 = zzgvmVar.zzk; i87 < zzgvmVar.zzl; i87++) {
            zzy(obj, zzgvmVar.zzj[i87], null, zzgvmVar.zzn, obj);
        }
        if (i4 == 0) {
            if (i6 != i5) {
                throw zzgul.zzg();
            }
        } else if (i6 > i5 || i7 != i4) {
            throw zzgul.zzg();
        }
        return i6;
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final Object zze() {
        return ((zzgtz) this.zzg).zzaD();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x007f A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzgtz) {
                zzgtz zzgtzVar = (zzgtz) obj;
                zzgtzVar.zzaV(Integer.MAX_VALUE);
                zzgtzVar.zza = 0;
                zzgtzVar.zzaT();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzu = zzu(i);
                int i2 = 1048575 & iZzu;
                int iZzt = zzt(iZzu);
                long j = i2;
                if (iZzt != 9) {
                    if (iZzt != 60 && iZzt != 68) {
                        switch (iZzt) {
                            case 17:
                                if (zzN(obj, i)) {
                                    zzx(i).zzf(zzb.getObject(obj, j));
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
                                this.zzm.zzb(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzgvd) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzR(obj, this.zzc[i], i)) {
                        zzx(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        Objects.requireNonNull(obj2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            int i2 = 1048575 & iZzu;
            int[] iArr = this.zzc;
            int iZzt = zzt(iZzu);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzgxd.zzr(obj, j, zzgxd.zzb(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzgxd.zzs(obj, j, zzgxd.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzgxd.zzu(obj, j, zzgxd.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzgxd.zzu(obj, j, zzgxd.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzgxd.zzt(obj, j, zzgxd.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzgxd.zzu(obj, j, zzgxd.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzgxd.zzt(obj, j, zzgxd.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzgxd.zzp(obj, j, zzgxd.zzz(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzgxd.zzv(obj, j, zzgxd.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzgxd.zzv(obj, j, zzgxd.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzgxd.zzt(obj, j, zzgxd.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzgxd.zzt(obj, j, zzgxd.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzgxd.zzt(obj, j, zzgxd.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzgxd.zzu(obj, j, zzgxd.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzgxd.zzt(obj, j, zzgxd.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzgxd.zzu(obj, j, zzgxd.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 17:
                    zzE(obj, obj2, i);
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
                    this.zzm.zzc(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzgwe.zza;
                    zzgxd.zzv(obj, j, zzgve.zzb(zzgxd.zzh(obj, j), zzgxd.zzh(obj2, j)));
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
                    if (zzR(obj2, i3, i)) {
                        zzgxd.zzv(obj, j, zzgxd.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 60:
                    zzF(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i3, i)) {
                        zzgxd.zzv(obj, j, zzgxd.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
        }
        zzgwe.zzq(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:169:0x061d A[Catch: all -> 0x0612, TryCatch #1 {all -> 0x0612, blocks: (B:153:0x05eb, B:167:0x0618, B:169:0x061d, B:170:0x0622), top: B:193:0x05eb }] */
    /* JADX WARN: Code duplicated, block: B:175:0x062e A[LOOP:2: B:173:0x062a->B:175:0x062e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:177:0x0642  */
    /* JADX WARN: Code duplicated, block: B:187:0x0655 A[LOOP:3: B:185:0x0651->B:187:0x0655, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:189:0x0669  */
    /* JADX WARN: Code duplicated, block: B:215:0x0628 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzh(Object obj, zzgvu zzgvuVar, zzgtl zzgtlVar) throws Throwable {
        Object obj2;
        zzgwt zzgwtVar;
        int i;
        zzgwt zzgwtVar2;
        Object obj3;
        zzgtm zzgtmVar;
        zzgtl zzgtlVar2;
        int i2;
        Object obj4;
        Object obj5 = obj;
        zzgtl zzgtlVar3 = zzgtlVar;
        Objects.requireNonNull(zzgtlVar);
        zzD(obj);
        zzgwt zzgwtVar3 = this.zzn;
        zzgtm zzgtmVar2 = this.zzo;
        Object objZzy = null;
        zzgtq zzgtqVarZzb = null;
        while (true) {
            try {
                int iZzc = zzgvuVar.zzc();
                int iZzq = zzq(iZzc);
                if (iZzq >= 0) {
                    zzgwtVar = zzgwtVar3;
                    obj5 = obj5;
                    try {
                        int iZzu = zzu(iZzq);
                        try {
                            switch (zzt(iZzu)) {
                                case 0:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzr(obj5, iZzu & 1048575, zzgvuVar.zza());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 1:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzs(obj5, iZzu & 1048575, zzgvuVar.zzb());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 2:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzu(obj5, iZzu & 1048575, zzgvuVar.zzl());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 3:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzu(obj5, iZzu & 1048575, zzgvuVar.zzo());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 4:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzt(obj5, iZzu & 1048575, zzgvuVar.zzg());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 5:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzu(obj5, iZzu & 1048575, zzgvuVar.zzk());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 6:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzt(obj5, iZzu & 1048575, zzgvuVar.zzf());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 7:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzp(obj5, iZzu & 1048575, zzgvuVar.zzN());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 8:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzG(obj5, iZzu, zzgvuVar);
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 9:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvj zzgvjVar = (zzgvj) zzA(obj5, iZzq);
                                    zzgvuVar.zzu(zzgvjVar, zzx(iZzq), zzgtlVar2);
                                    zzJ(obj5, iZzq, zzgvjVar);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 10:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzv(obj5, iZzu & 1048575, zzgvuVar.zzp());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 11:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzt(obj5, iZzu & 1048575, zzgvuVar.zzj());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 12:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    int iZze = zzgvuVar.zze();
                                    zzgud zzgudVarZzw = zzw(iZzq);
                                    if (zzgudVarZzw != null && !zzgudVarZzw.zza(iZze)) {
                                        objZzy = zzgwe.zzp(obj5, iZzc, iZze, obj4, zzgwtVar);
                                        zzgtmVar2 = zzgtmVar;
                                        zzgtlVar3 = zzgtlVar2;
                                        zzgwtVar3 = zzgwtVar;
                                    }
                                    zzgxd.zzt(obj5, iZzu & 1048575, iZze);
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 13:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzt(obj5, iZzu & 1048575, zzgvuVar.zzh());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 14:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzu(obj5, iZzu & 1048575, zzgvuVar.zzm());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 15:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzt(obj5, iZzu & 1048575, zzgvuVar.zzi());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 16:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgxd.zzu(obj5, iZzu & 1048575, zzgvuVar.zzn());
                                    zzH(obj5, iZzq);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 17:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvj zzgvjVar2 = (zzgvj) zzA(obj5, iZzq);
                                    zzgvuVar.zzt(zzgvjVar2, zzx(iZzq), zzgtlVar2);
                                    zzJ(obj5, iZzq, zzgvjVar2);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 18:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzx(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 19:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzB(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 20:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzE(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 21:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzM(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 22:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzD(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 23:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzA(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 24:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzz(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 25:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzv(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 26:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    if (zzM(iZzu)) {
                                        ((zzgta) zzgvuVar).zzK(this.zzm.zza(obj5, iZzu & 1048575), true);
                                    } else {
                                        ((zzgta) zzgvuVar).zzK(this.zzm.zza(obj5, iZzu & 1048575), false);
                                    }
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 27:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzF(this.zzm.zza(obj5, iZzu & 1048575), zzx(iZzq), zzgtlVar2);
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 28:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzw(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 29:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzL(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 30:
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    List listZza = this.zzm.zza(obj5, iZzu & 1048575);
                                    zzgvuVar.zzy(listZza);
                                    objZzy = zzgwe.zzo(obj, iZzc, listZza, zzw(iZzq), objZzy, zzgwtVar);
                                    zzgtmVar2 = zzgtmVar;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 31:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzG(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 32:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzH(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 33:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzI(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 34:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzJ(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 35:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzx(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 36:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzB(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 37:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzE(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 38:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzM(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 39:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzD(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 40:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzA(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 41:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzz(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 42:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzv(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 43:
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgvuVar.zzL(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 44:
                                    List listZza2 = this.zzm.zza(obj5, iZzu & 1048575);
                                    zzgvuVar.zzy(listZza2);
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    objZzy = zzgwe.zzo(obj, iZzc, listZza2, zzw(iZzq), objZzy, zzgwtVar);
                                    zzgtmVar2 = zzgtmVar;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 45:
                                    zzgvuVar.zzG(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 46:
                                    zzgvuVar.zzH(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 47:
                                    zzgvuVar.zzI(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 48:
                                    zzgvuVar.zzJ(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 49:
                                    zzgvuVar.zzC(this.zzm.zza(obj5, iZzu & 1048575), zzx(iZzq), zzgtlVar3);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 50:
                                    Object objZzz = zzz(iZzq);
                                    long jZzu = zzu(iZzq) & 1048575;
                                    Object objZzh = zzgxd.zzh(obj5, jZzu);
                                    if (objZzh == null) {
                                        objZzh = zzgvd.zza().zzb();
                                        zzgxd.zzv(obj5, jZzu, objZzh);
                                    } else if (zzgve.zza(objZzh)) {
                                        Object objZzb = zzgvd.zza().zzb();
                                        zzgve.zzb(objZzb, objZzh);
                                        zzgxd.zzv(obj5, jZzu, objZzb);
                                        objZzh = objZzb;
                                    }
                                    throw null;
                                case 51:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Double.valueOf(zzgvuVar.zza()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 52:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Float.valueOf(zzgvuVar.zzb()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 53:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Long.valueOf(zzgvuVar.zzl()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 54:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Long.valueOf(zzgvuVar.zzo()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 55:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzgvuVar.zzg()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 56:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Long.valueOf(zzgvuVar.zzk()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 57:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzgvuVar.zzf()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 58:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Boolean.valueOf(zzgvuVar.zzN()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 59:
                                    zzG(obj5, iZzu, zzgvuVar);
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 60:
                                    zzgvj zzgvjVar3 = (zzgvj) zzB(obj5, iZzc, iZzq);
                                    zzgvuVar.zzu(zzgvjVar3, zzx(iZzq), zzgtlVar3);
                                    zzK(obj5, iZzc, iZzq, zzgvjVar3);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 61:
                                    zzgxd.zzv(obj5, iZzu & 1048575, zzgvuVar.zzp());
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 62:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzgvuVar.zzj()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 63:
                                    int iZze2 = zzgvuVar.zze();
                                    zzgud zzgudVarZzw2 = zzw(iZzq);
                                    if (zzgudVarZzw2 == null || zzgudVarZzw2.zza(iZze2)) {
                                        zzgxd.zzv(obj5, iZzu & 1048575, Integer.valueOf(iZze2));
                                        zzI(obj5, iZzc, iZzq);
                                        obj4 = objZzy;
                                        zzgtmVar = zzgtmVar2;
                                        zzgtlVar2 = zzgtlVar3;
                                        zzgtmVar2 = zzgtmVar;
                                        objZzy = obj4;
                                        zzgtlVar3 = zzgtlVar2;
                                    } else {
                                        objZzy = zzgwe.zzp(obj5, iZzc, iZze2, objZzy, zzgwtVar);
                                        obj5 = obj5;
                                    }
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 64:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzgvuVar.zzh()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 65:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Long.valueOf(zzgvuVar.zzm()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 66:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzgvuVar.zzi()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 67:
                                    zzgxd.zzv(obj5, iZzu & 1048575, Long.valueOf(zzgvuVar.zzn()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                case 68:
                                    zzgvj zzgvjVar4 = (zzgvj) zzB(obj5, iZzc, iZzq);
                                    zzgvuVar.zzt(zzgvjVar4, zzx(iZzq), zzgtlVar3);
                                    zzK(obj5, iZzc, iZzq, zzgvjVar4);
                                    obj4 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    zzgtmVar2 = zzgtmVar;
                                    objZzy = obj4;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                                default:
                                    obj2 = objZzy;
                                    zzgtmVar = zzgtmVar2;
                                    zzgtlVar2 = zzgtlVar3;
                                    if (obj2 == null) {
                                        try {
                                            objZzy = zzgwtVar.zzc(obj5);
                                        } catch (zzguk unused) {
                                            objZzy = obj2;
                                            zzgwtVar.zzq(zzgvuVar);
                                            if (objZzy == null) {
                                                objZzy = zzgwtVar.zzc(obj5);
                                            }
                                            if (!zzgwtVar.zzp(objZzy, zzgvuVar)) {
                                                for (i2 = this.zzk; i2 < this.zzl; i2++) {
                                                    objZzy = zzy(obj, this.zzj[i2], objZzy, zzgwtVar, obj);
                                                }
                                                if (objZzy != null) {
                                                    zzgwtVar.zzn(obj5, objZzy);
                                                    return;
                                                }
                                                return;
                                            }
                                            zzgtmVar2 = zzgtmVar;
                                            zzgtlVar3 = zzgtlVar2;
                                            zzgwtVar3 = zzgwtVar;
                                        } catch (Throwable th) {
                                            th = th;
                                            objZzy = obj2;
                                        }
                                    } else {
                                        objZzy = obj2;
                                    }
                                    try {
                                        try {
                                            if (!zzgwtVar.zzp(objZzy, zzgvuVar)) {
                                                for (int i3 = this.zzk; i3 < this.zzl; i3++) {
                                                    objZzy = zzy(obj, this.zzj[i3], objZzy, zzgwtVar, obj);
                                                }
                                                if (objZzy != null) {
                                                    zzgwtVar.zzn(obj5, objZzy);
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (zzguk unused2) {
                                        zzgwtVar.zzq(zzgvuVar);
                                        if (objZzy == null) {
                                            objZzy = zzgwtVar.zzc(obj5);
                                        }
                                        if (!zzgwtVar.zzp(objZzy, zzgvuVar)) {
                                            while (i2 < this.zzl) {
                                                objZzy = zzy(obj, this.zzj[i2], objZzy, zzgwtVar, obj);
                                            }
                                            if (objZzy != null) {
                                                zzgwtVar.zzn(obj5, objZzy);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    zzgtmVar2 = zzgtmVar;
                                    zzgtlVar3 = zzgtlVar2;
                                    zzgwtVar3 = zzgwtVar;
                                    break;
                            }
                        } catch (zzguk unused3) {
                            obj2 = objZzy;
                            zzgtmVar = zzgtmVar2;
                            zzgtlVar2 = zzgtlVar3;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = objZzy;
                    }
                } else {
                    if (iZzc == Integer.MAX_VALUE) {
                        for (int i4 = this.zzk; i4 < this.zzl; i4++) {
                            objZzy = zzy(obj, this.zzj[i4], objZzy, zzgwtVar3, obj);
                        }
                        if (objZzy != null) {
                            zzgwtVar3.zzn(obj5, objZzy);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objZzc = !this.zzh ? null : zzgtmVar2.zzc(zzgtlVar3, this.zzg, iZzc);
                        if (objZzc != null) {
                            if (zzgtqVarZzb == null) {
                                zzgtqVarZzb = zzgtmVar2.zzb(obj5);
                            }
                            zzgtq zzgtqVar = zzgtqVarZzb;
                            zzgwtVar2 = zzgwtVar3;
                            obj3 = obj5;
                            try {
                                objZzy = zzgtmVar2.zzd(obj, zzgvuVar, objZzc, zzgtlVar, zzgtqVar, objZzy, zzgwtVar2);
                                zzgtqVarZzb = zzgtqVar;
                            } catch (Throwable th4) {
                                th = th4;
                                obj5 = obj3;
                                zzgwtVar = zzgwtVar2;
                                obj2 = objZzy;
                                objZzy = obj2;
                                for (i = this.zzk; i < this.zzl; i++) {
                                    objZzy = zzy(obj, this.zzj[i], objZzy, zzgwtVar, obj);
                                }
                                if (objZzy != null) {
                                    zzgwtVar.zzn(obj5, objZzy);
                                }
                                throw th;
                            }
                        } else {
                            zzgwtVar2 = zzgwtVar3;
                            obj3 = obj5;
                            zzgwtVar2.zzq(zzgvuVar);
                            if (objZzy == null) {
                                objZzy = zzgwtVar2.zzc(obj3);
                            }
                            try {
                                if (!zzgwtVar2.zzp(objZzy, zzgvuVar)) {
                                    int i5 = this.zzk;
                                    while (i5 < this.zzl) {
                                        zzgwt zzgwtVar4 = zzgwtVar2;
                                        objZzy = zzy(obj, this.zzj[i5], objZzy, zzgwtVar4, obj);
                                        i5++;
                                        obj3 = obj3;
                                        zzgwtVar2 = zzgwtVar4;
                                    }
                                    Object obj6 = obj3;
                                    zzgwt zzgwtVar5 = zzgwtVar2;
                                    if (objZzy != null) {
                                        zzgwtVar5.zzn(obj6, objZzy);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                obj5 = obj3;
                                zzgwtVar = zzgwtVar2;
                            }
                        }
                        obj5 = obj3;
                        zzgwtVar3 = zzgwtVar2;
                    } catch (Throwable th6) {
                        th = th6;
                        zzgwtVar = zzgwtVar3;
                        obj5 = obj5;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                obj2 = objZzy;
                zzgwtVar = zzgwtVar3;
                obj5 = obj5;
            }
            objZzy = obj2;
            while (i < this.zzl) {
                objZzy = zzy(obj, this.zzj[i], objZzy, zzgwtVar, obj);
            }
            if (objZzy != null) {
                zzgwtVar.zzn(obj5, objZzy);
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgsd zzgsdVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzgsdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzs;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            long j = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzgxd.zzb(obj, j)) != Double.doubleToLongBits(zzgxd.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzgxd.zzc(obj, j)) != Float.floatToIntBits(zzgxd.zzc(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzgxd.zzf(obj, j) != zzgxd.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzgxd.zzf(obj, j) != zzgxd.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzgxd.zzd(obj, j) != zzgxd.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzgxd.zzf(obj, j) != zzgxd.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzgxd.zzd(obj, j) != zzgxd.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzgxd.zzz(obj, j) != zzgxd.zzz(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzgwe.zzs(zzgxd.zzh(obj, j), zzgxd.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzgwe.zzs(zzgxd.zzh(obj, j), zzgxd.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzgwe.zzs(zzgxd.zzh(obj, j), zzgxd.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzgxd.zzd(obj, j) != zzgxd.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzgxd.zzd(obj, j) != zzgxd.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzgxd.zzd(obj, j) != zzgxd.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzgxd.zzf(obj, j) != zzgxd.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzgxd.zzd(obj, j) != zzgxd.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzgxd.zzf(obj, j) != zzgxd.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzgwe.zzs(zzgxd.zzh(obj, j), zzgxd.zzh(obj2, j))) {
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
                    zZzs = zzgwe.zzs(zzgxd.zzh(obj, j), zzgxd.zzh(obj2, j));
                    break;
                case 50:
                    zZzs = zzgwe.zzs(zzgxd.zzh(obj, j), zzgxd.zzh(obj2, j));
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
                    long jZzr = zzr(i) & 1048575;
                    if (zzgxd.zzd(obj, jZzr) != zzgxd.zzd(obj2, jZzr) || !zzgwe.zzs(zzgxd.zzh(obj, j), zzgxd.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzs) {
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
    @Override // com.google.android.gms.internal.ads.zzgwc
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzgwc zzgwcVarZzx;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i6];
            int i8 = iArr2[i7];
            int iZzu = zzu(i7);
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
            if ((268435456 & iZzu) != 0 && !zzO(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzt = zzt(iZzu);
            if (iZzt == 9 || iZzt == 17) {
                if (zzO(obj, i7, i, i2, i11) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 27) {
                list = (List) zzgxd.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgwcVarZzx = zzx(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzgwcVarZzx.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzt == 60 || iZzt == 68) {
                if (zzR(obj, i8, i7) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 49) {
                list = (List) zzgxd.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    zzgwcVarZzx = zzx(i7);
                    while (i3 < list.size()) {
                        if (!zzgwcVarZzx.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzt == 50 && !((zzgvd) zzgxd.zzh(obj, iZzu & 1048575)).isEmpty()) {
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

    @Override // com.google.android.gms.internal.ads.zzgwc
    public final void zzm(Object obj, zzgth zzgthVar) throws IOException {
        int i;
        int i2;
        int i3;
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr.length) {
            int iZzu = zzu(i7);
            int[] iArr2 = this.zzc;
            int iZzt = zzt(iZzu);
            int i8 = iArr2[i7];
            if (iZzt <= 17) {
                int i9 = iArr2[i7 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            long j = iZzu & i4;
            switch (iZzt) {
                case 0:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzf(i8, zzgxd.zzb(obj, j));
                    }
                    break;
                case 1:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzo(i8, zzgxd.zzc(obj, j));
                    }
                    break;
                case 2:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzt(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzJ(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzr(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzm(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzk(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzb(i8, zzgxd.zzz(obj, j));
                    }
                    break;
                case 8:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzT(i8, unsafe.getObject(obj, j), zzgthVar);
                    }
                    break;
                case 9:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    break;
                case 10:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzd(i8, (zzgsr) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzH(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzi(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzw(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzy(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzA(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzC(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgthVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    break;
                case 18:
                    zzgwe.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 19:
                    zzgwe.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 20:
                    zzgwe.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 21:
                    zzgwe.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 22:
                    zzgwe.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 23:
                    zzgwe.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 24:
                    zzgwe.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 25:
                    zzgwe.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 26:
                    int i11 = this.zzc[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzgwe.zza;
                    if (list != null && !list.isEmpty()) {
                        zzgthVar.zzG(i11, list);
                    }
                    break;
                case 27:
                    int i13 = this.zzc[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzgwc zzgwcVarZzx = zzx(i7);
                    int i14 = zzgwe.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            zzgthVar.zzv(i13, list2.get(i15), zzgwcVarZzx);
                        }
                    }
                    break;
                case 28:
                    int i16 = this.zzc[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgwe.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzgthVar.zze(i16, list3);
                    }
                    break;
                case 29:
                    zzgwe.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 30:
                    zzgwe.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 31:
                    zzgwe.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 32:
                    zzgwe.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 33:
                    zzgwe.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 34:
                    zzgwe.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, false);
                    break;
                case 35:
                    zzgwe.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 36:
                    zzgwe.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 37:
                    zzgwe.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 38:
                    zzgwe.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 39:
                    zzgwe.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 40:
                    zzgwe.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 41:
                    zzgwe.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 42:
                    zzgwe.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 43:
                    zzgwe.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 44:
                    zzgwe.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 45:
                    zzgwe.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 46:
                    zzgwe.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 47:
                    zzgwe.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 48:
                    zzgwe.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgthVar, true);
                    break;
                case 49:
                    int i18 = this.zzc[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzgwc zzgwcVarZzx2 = zzx(i7);
                    int i19 = zzgwe.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            zzgthVar.zzq(i18, list4.get(i20), zzgwcVarZzx2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                    break;
                case 51:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzf(i8, zzn(obj, j));
                    }
                    break;
                case 52:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzo(i8, zzo(obj, j));
                    }
                    break;
                case 53:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzt(i8, zzv(obj, j));
                    }
                    break;
                case 54:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzJ(i8, zzv(obj, j));
                    }
                    break;
                case 55:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzr(i8, zzp(obj, j));
                    }
                    break;
                case 56:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzm(i8, zzv(obj, j));
                    }
                    break;
                case 57:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzk(i8, zzp(obj, j));
                    }
                    break;
                case 58:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzb(i8, zzS(obj, j));
                    }
                    break;
                case 59:
                    if (zzR(obj, i8, i7)) {
                        zzT(i8, unsafe.getObject(obj, j), zzgthVar);
                    }
                    break;
                case 60:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    break;
                case 61:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzd(i8, (zzgsr) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzH(i8, zzp(obj, j));
                    }
                    break;
                case 63:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzi(i8, zzp(obj, j));
                    }
                    break;
                case 64:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzw(i8, zzp(obj, j));
                    }
                    break;
                case 65:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzy(i8, zzv(obj, j));
                    }
                    break;
                case 66:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzA(i8, zzp(obj, j));
                    }
                    break;
                case 67:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzC(i8, zzv(obj, j));
                    }
                    break;
                case 68:
                    if (zzR(obj, i8, i7)) {
                        zzgthVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    break;
            }
            i7 += 3;
            i5 = i;
            i6 = i2;
            i4 = 1048575;
        }
        zzgwt zzgwtVar = this.zzn;
        zzgwtVar.zzr(zzgwtVar.zzd(obj), zzgthVar);
    }
}
