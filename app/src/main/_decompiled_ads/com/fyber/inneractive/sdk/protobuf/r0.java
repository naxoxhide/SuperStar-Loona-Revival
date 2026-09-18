package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class r0<T> implements d1<T> {
    public static final int[] r = new int[0];
    public static final Unsafe s;
    public final int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f1305b;
    public final int c;
    public final int d;
    public final o0 e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final t0 m;
    public final e0 n;
    public final k1<?, ?> o;
    public final r<?> p;
    public final j0 q;

    static {
        Unsafe unsafe;
        Unsafe unsafe2 = p1.a;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new o1());
        } catch (Throwable unused) {
            unsafe = null;
        }
        s = unsafe;
    }

    public r0(int[] iArr, Object[] objArr, int i, int i2, o0 o0Var, boolean z, boolean z2, int[] iArr2, int i3, int i4, t0 t0Var, e0 e0Var, k1<?, ?> k1Var, r<?> rVar, j0 j0Var) {
        this.a = iArr;
        this.f1305b = objArr;
        this.c = i;
        this.d = i2;
        this.g = o0Var instanceof GeneratedMessageLite;
        this.h = z;
        this.f = rVar != null && rVar.a(o0Var);
        this.i = z2;
        this.j = iArr2;
        this.k = i3;
        this.l = i4;
        this.m = t0Var;
        this.n = e0Var;
        this.o = k1Var;
        this.p = rVar;
        this.e = o0Var;
        this.q = j0Var;
    }

    /* JADX WARN: Code duplicated, block: B:128:0x0274  */
    /* JADX WARN: Code duplicated, block: B:129:0x0277  */
    /* JADX WARN: Code duplicated, block: B:132:0x028f  */
    /* JADX WARN: Code duplicated, block: B:133:0x0292  */
    /* JADX WARN: Code duplicated, block: B:166:0x033b  */
    /* JADX WARN: Code duplicated, block: B:167:0x033e  */
    /* JADX WARN: Code duplicated, block: B:184:0x0392  */
    public static r0 a(m0 m0Var, t0 t0Var, e0 e0Var, k1 k1Var, r rVar, j0 j0Var) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int iCharAt5;
        int i2;
        int[] iArr;
        int i3;
        char cCharAt;
        int i4;
        char cCharAt2;
        int i5;
        char cCharAt3;
        int i6;
        char cCharAt4;
        int i7;
        char cCharAt5;
        int i8;
        char cCharAt6;
        int i9;
        char cCharAt7;
        int i10;
        char cCharAt8;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z;
        int iObjectFieldOffset;
        boolean z2;
        int iObjectFieldOffset2;
        int i17;
        int iObjectFieldOffset3;
        int iObjectFieldOffset4;
        int i18;
        Field fieldA;
        char cCharAt9;
        int i19;
        int i20;
        int i21;
        Object obj;
        Field fieldA2;
        int i22;
        Object obj2;
        Field fieldA3;
        int i23;
        char cCharAt10;
        int i24;
        char cCharAt11;
        int i25;
        char cCharAt12;
        int i26;
        char cCharAt13;
        if (!(m0Var instanceof b1)) {
            throw null;
        }
        b1 b1Var = (b1) m0Var;
        int i27 = 0;
        boolean z3 = ((b1Var.d & 1) == 1 ? y0.PROTO2 : y0.PROTO3) == y0.PROTO3;
        String str = b1Var.f1277b;
        int length = str.length();
        if (str.charAt(0) >= 55296) {
            int i28 = 1;
            while (true) {
                i = i28 + 1;
                if (str.charAt(i28) < 55296) {
                    break;
                }
                i28 = i;
            }
        } else {
            i = 1;
        }
        int i29 = i + 1;
        int iCharAt6 = str.charAt(i);
        if (iCharAt6 >= 55296) {
            int i30 = iCharAt6 & 8191;
            int i31 = 13;
            while (true) {
                i26 = i29 + 1;
                cCharAt13 = str.charAt(i29);
                if (cCharAt13 < 55296) {
                    break;
                }
                i30 |= (cCharAt13 & 8191) << i31;
                i31 += 13;
                i29 = i26;
            }
            iCharAt6 = i30 | (cCharAt13 << i31);
            i29 = i26;
        }
        if (iCharAt6 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            iCharAt4 = 0;
            iCharAt5 = 0;
            iArr = r;
            i2 = 0;
        } else {
            int i32 = i29 + 1;
            int iCharAt7 = str.charAt(i29);
            if (iCharAt7 >= 55296) {
                int i33 = iCharAt7 & 8191;
                int i34 = 13;
                while (true) {
                    i10 = i32 + 1;
                    cCharAt8 = str.charAt(i32);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i33 |= (cCharAt8 & 8191) << i34;
                    i34 += 13;
                    i32 = i10;
                }
                iCharAt7 = i33 | (cCharAt8 << i34);
                i32 = i10;
            }
            int i35 = i32 + 1;
            int iCharAt8 = str.charAt(i32);
            if (iCharAt8 >= 55296) {
                int i36 = iCharAt8 & 8191;
                int i37 = 13;
                while (true) {
                    i9 = i35 + 1;
                    cCharAt7 = str.charAt(i35);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt7 & 8191) << i37;
                    i37 += 13;
                    i35 = i9;
                }
                iCharAt8 = i36 | (cCharAt7 << i37);
                i35 = i9;
            }
            int i38 = i35 + 1;
            iCharAt = str.charAt(i35);
            if (iCharAt >= 55296) {
                int i39 = iCharAt & 8191;
                int i40 = 13;
                while (true) {
                    i8 = i38 + 1;
                    cCharAt6 = str.charAt(i38);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt6 & 8191) << i40;
                    i40 += 13;
                    i38 = i8;
                }
                iCharAt = i39 | (cCharAt6 << i40);
                i38 = i8;
            }
            int i41 = i38 + 1;
            iCharAt2 = str.charAt(i38);
            if (iCharAt2 >= 55296) {
                int i42 = iCharAt2 & 8191;
                int i43 = 13;
                while (true) {
                    i7 = i41 + 1;
                    cCharAt5 = str.charAt(i41);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt5 & 8191) << i43;
                    i43 += 13;
                    i41 = i7;
                }
                iCharAt2 = i42 | (cCharAt5 << i43);
                i41 = i7;
            }
            int i44 = i41 + 1;
            iCharAt3 = str.charAt(i41);
            if (iCharAt3 >= 55296) {
                int i45 = iCharAt3 & 8191;
                int i46 = 13;
                while (true) {
                    i6 = i44 + 1;
                    cCharAt4 = str.charAt(i44);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt4 & 8191) << i46;
                    i46 += 13;
                    i44 = i6;
                }
                iCharAt3 = i45 | (cCharAt4 << i46);
                i44 = i6;
            }
            int i47 = i44 + 1;
            iCharAt4 = str.charAt(i44);
            if (iCharAt4 >= 55296) {
                int i48 = iCharAt4 & 8191;
                int i49 = 13;
                while (true) {
                    i5 = i47 + 1;
                    cCharAt3 = str.charAt(i47);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt3 & 8191) << i49;
                    i49 += 13;
                    i47 = i5;
                }
                iCharAt4 = i48 | (cCharAt3 << i49);
                i47 = i5;
            }
            int i50 = i47 + 1;
            int iCharAt9 = str.charAt(i47);
            if (iCharAt9 >= 55296) {
                int i51 = iCharAt9 & 8191;
                int i52 = 13;
                while (true) {
                    i4 = i50 + 1;
                    cCharAt2 = str.charAt(i50);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt2 & 8191) << i52;
                    i52 += 13;
                    i50 = i4;
                }
                iCharAt9 = i51 | (cCharAt2 << i52);
                i50 = i4;
            }
            int i53 = i50 + 1;
            iCharAt5 = str.charAt(i50);
            if (iCharAt5 >= 55296) {
                int i54 = iCharAt5 & 8191;
                int i55 = i53;
                int i56 = 13;
                while (true) {
                    i3 = i55 + 1;
                    cCharAt = str.charAt(i55);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i54 |= (cCharAt & 8191) << i56;
                    i56 += 13;
                    i55 = i3;
                }
                iCharAt5 = i54 | (cCharAt << i56);
                i53 = i3;
            }
            i2 = (iCharAt7 * 2) + iCharAt8;
            iArr = new int[iCharAt5 + iCharAt4 + iCharAt9];
            i27 = iCharAt7;
            i29 = i53;
        }
        Unsafe unsafe = s;
        Object[] objArr = b1Var.c;
        Class<?> cls = b1Var.a.getClass();
        int i57 = i29;
        int[] iArr2 = new int[iCharAt3 * 3];
        Object[] objArr2 = new Object[iCharAt3 * 2];
        int i58 = iCharAt5 + iCharAt4;
        int i59 = i2;
        int i60 = iCharAt5;
        int i61 = i57;
        int i62 = i58;
        int i63 = 0;
        int i64 = 0;
        while (i61 < length) {
            int i65 = i61 + 1;
            int iCharAt10 = str.charAt(i61);
            int i66 = length;
            if (iCharAt10 >= 55296) {
                int i67 = iCharAt10 & 8191;
                int i68 = i65;
                int i69 = 13;
                while (true) {
                    i25 = i68 + 1;
                    cCharAt12 = str.charAt(i68);
                    i11 = iCharAt5;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i67 |= (cCharAt12 & 8191) << i69;
                    i69 += 13;
                    i68 = i25;
                    iCharAt5 = i11;
                }
                iCharAt10 = i67 | (cCharAt12 << i69);
                i12 = i25;
            } else {
                i11 = iCharAt5;
                i12 = i65;
            }
            int i70 = i12 + 1;
            int iCharAt11 = str.charAt(i12);
            if (iCharAt11 >= 55296) {
                int i71 = iCharAt11 & 8191;
                int i72 = i70;
                int i73 = 13;
                while (true) {
                    i24 = i72 + 1;
                    cCharAt11 = str.charAt(i72);
                    i13 = iCharAt2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i71 |= (cCharAt11 & 8191) << i73;
                    i73 += 13;
                    i72 = i24;
                    iCharAt2 = i13;
                }
                iCharAt11 = i71 | (cCharAt11 << i73);
                i14 = i24;
            } else {
                i13 = iCharAt2;
                i14 = i70;
            }
            int i74 = iCharAt11 & 255;
            int i75 = iCharAt;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i63] = i64;
                i63++;
            }
            b1 b1Var2 = b1Var;
            if (i74 >= 51) {
                int i76 = i14 + 1;
                int iCharAt12 = str.charAt(i14);
                char c = 55296;
                if (iCharAt12 >= 55296) {
                    int i77 = iCharAt12 & 8191;
                    int i78 = 13;
                    while (true) {
                        i23 = i76 + 1;
                        cCharAt10 = str.charAt(i76);
                        if (cCharAt10 < c) {
                            break;
                        }
                        i77 |= (cCharAt10 & 8191) << i78;
                        i78 += 13;
                        i76 = i23;
                        c = 55296;
                    }
                    iCharAt12 = i77 | (cCharAt10 << i78);
                    i76 = i23;
                }
                int i79 = i74 - 51;
                int i80 = i76;
                if (i79 == 9 || i79 == 17) {
                    i20 = i59 + 1;
                    objArr2[((i64 / 3) * 2) + 1] = objArr[i59];
                } else {
                    if (i79 == 12 && !z3) {
                        i20 = i59 + 1;
                        objArr2[((i64 / 3) * 2) + 1] = objArr[i59];
                    }
                    i21 = iCharAt12 * 2;
                    obj = objArr[i21];
                    if (obj instanceof Field) {
                        fieldA2 = (Field) obj;
                    } else {
                        fieldA2 = a(cls, (String) obj);
                        objArr[i21] = fieldA2;
                    }
                    i15 = i27;
                    iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldA2);
                    i22 = i21 + 1;
                    obj2 = objArr[i22];
                    if (obj2 instanceof Field) {
                        fieldA3 = (Field) obj2;
                    } else {
                        fieldA3 = a(cls, (String) obj2);
                        objArr[i22] = fieldA3;
                    }
                    iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldA3);
                    str = str;
                    i16 = i59;
                    i14 = i80;
                    cls = cls;
                    i17 = 0;
                }
                i59 = i20;
                i21 = iCharAt12 * 2;
                obj = objArr[i21];
                if (obj instanceof Field) {
                    fieldA2 = (Field) obj;
                } else {
                    fieldA2 = a(cls, (String) obj);
                    objArr[i21] = fieldA2;
                }
                i15 = i27;
                iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldA2);
                i22 = i21 + 1;
                obj2 = objArr[i22];
                if (obj2 instanceof Field) {
                    fieldA3 = (Field) obj2;
                } else {
                    fieldA3 = a(cls, (String) obj2);
                    objArr[i22] = fieldA3;
                }
                iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldA3);
                str = str;
                i16 = i59;
                i14 = i80;
                cls = cls;
                i17 = 0;
            } else {
                i15 = i27;
                i16 = i59 + 1;
                Field fieldA4 = a(cls, (String) objArr[i59]);
                if (i74 == 9 || i74 == 17) {
                    z = true;
                    objArr2[((i64 / 3) * 2) + 1] = fieldA4.getType();
                } else {
                    if (i74 == 27 || i74 == 49) {
                        z = true;
                        i19 = i16 + 1;
                        objArr2[((i64 / 3) * 2) + 1] = objArr[i16];
                    } else {
                        if (i74 == 12 || i74 == 30 || i74 == 44) {
                            if (!z3) {
                                z = true;
                                i19 = i16 + 1;
                                objArr2[((i64 / 3) * 2) + 1] = objArr[i16];
                            }
                        } else if (i74 == 50) {
                            int i81 = i60 + 1;
                            iArr[i60] = i64;
                            int i82 = (i64 / 3) * 2;
                            int i83 = i16 + 1;
                            objArr2[i82] = objArr[i16];
                            if ((iCharAt11 & 2048) != 0) {
                                i16 = i83 + 1;
                                objArr2[i82 + 1] = objArr[i83];
                                i60 = i81;
                            } else {
                                i60 = i81;
                                i16 = i83;
                            }
                        }
                        z = true;
                    }
                    i16 = i19;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldA4);
                    if ((iCharAt11 & 4096) == 4096) {
                        z2 = z;
                    } else {
                        z2 = false;
                    }
                    if (z2 || i74 > 17) {
                        iObjectFieldOffset2 = 1048575;
                        i17 = 0;
                    } else {
                        int i84 = i14 + 1;
                        int iCharAt13 = str.charAt(i14);
                        if (iCharAt13 >= 55296) {
                            int i85 = iCharAt13 & 8191;
                            int i86 = 13;
                            while (true) {
                                i18 = i84 + 1;
                                cCharAt9 = str.charAt(i84);
                                if (cCharAt9 < 55296) {
                                    break;
                                }
                                i85 |= (cCharAt9 & 8191) << i86;
                                i86 += 13;
                                i84 = i18;
                            }
                            iCharAt13 = i85 | (cCharAt9 << i86);
                        } else {
                            i18 = i84;
                        }
                        int i87 = (i15 * 2) + (iCharAt13 / 32);
                        Object obj3 = objArr[i87];
                        if (obj3 instanceof Field) {
                            fieldA = (Field) obj3;
                        } else {
                            fieldA = a(cls, (String) obj3);
                            objArr[i87] = fieldA;
                        }
                        i17 = iCharAt13 % 32;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldA);
                        i14 = i18;
                    }
                    if (i74 >= 18 && i74 <= 49) {
                        iArr[i62] = iObjectFieldOffset;
                        i62++;
                    }
                    iObjectFieldOffset3 = iObjectFieldOffset;
                    iObjectFieldOffset4 = iObjectFieldOffset2;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldA4);
                if ((iCharAt11 & 4096) == 4096) {
                    z2 = z;
                } else {
                    z2 = false;
                }
                if (z2) {
                    iObjectFieldOffset2 = 1048575;
                    i17 = 0;
                } else {
                    iObjectFieldOffset2 = 1048575;
                    i17 = 0;
                }
                if (i74 >= 18) {
                    iArr[i62] = iObjectFieldOffset;
                    i62++;
                }
                iObjectFieldOffset3 = iObjectFieldOffset;
                iObjectFieldOffset4 = iObjectFieldOffset2;
            }
            int i88 = i64 + 1;
            iArr2[i64] = iCharAt10;
            int i89 = i88 + 1;
            Object[] objArr3 = objArr;
            iArr2[i88] = iObjectFieldOffset3 | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i74 << 20);
            int i90 = i89 + 1;
            iArr2[i89] = (i17 << 20) | iObjectFieldOffset4;
            str = str;
            i27 = i15;
            cls = cls;
            i61 = i14;
            objArr = objArr3;
            iCharAt = i75;
            length = i66;
            iCharAt5 = i11;
            iCharAt2 = i13;
            i59 = i16;
            iArr2 = iArr2;
            i64 = i90;
            b1Var = b1Var2;
        }
        return new r0(iArr2, objArr2, iCharAt, iCharAt2, b1Var.a, z3, false, iArr, iCharAt5, i58, t0Var, e0Var, k1Var, rVar, j0Var);
    }

    public static long d(int i) {
        return i & 1048575;
    }

    public static l1 e(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        l1 l1Var = generatedMessageLite.unknownFields;
        if (l1Var != l1.f) {
            return l1Var;
        }
        l1 l1VarC = l1.c();
        generatedMessageLite.unknownFields = l1VarC;
        return l1VarC;
    }

    public static int f(int i) {
        return (i & 267386880) >>> 20;
    }

    /* JADX WARN: Code duplicated, block: B:162:0x0276  */
    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public boolean b(T t, T t2) {
        int length = this.a.length;
        int i = 0;
        while (true) {
            boolean zA = true;
            if (i >= length) {
                if (!this.o.b(t).equals(this.o.b(t2))) {
                    return false;
                }
                if (this.f) {
                    return this.p.a(t).equals(this.p.a(t2));
                }
                return true;
            }
            int i2 = this.a[i + 1];
            long jD = d(i2);
            switch (f(i2)) {
                case 0:
                    if (!(a((Object) t, i) == a((Object) t2, i))) {
                        zA = false;
                    } else {
                        p1.d dVar = p1.e;
                        if (Double.doubleToLongBits(dVar.c(t, jD)) != Double.doubleToLongBits(dVar.c(t2, jD))) {
                            zA = false;
                        }
                    }
                    break;
                case 1:
                    if (!(a((Object) t, i) == a((Object) t2, i))) {
                        zA = false;
                    } else {
                        p1.d dVar2 = p1.e;
                        if (Float.floatToIntBits(dVar2.d(t, jD)) != Float.floatToIntBits(dVar2.d(t2, jD))) {
                            zA = false;
                        }
                    }
                    break;
                case 2:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.f(t, jD) != p1.f(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 3:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.f(t, jD) != p1.f(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 4:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.e(t, jD) != p1.e(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 5:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.f(t, jD) != p1.f(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 6:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.e(t, jD) != p1.e(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 7:
                    if (!(a((Object) t, i) == a((Object) t2, i))) {
                        zA = false;
                    } else {
                        p1.d dVar3 = p1.e;
                        if (dVar3.a(t, jD) != dVar3.a(t2, jD)) {
                            zA = false;
                        }
                    }
                    break;
                case 8:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || !f1.a(p1.g(t, jD), p1.g(t2, jD))) {
                        zA = false;
                    }
                    break;
                case 9:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || !f1.a(p1.g(t, jD), p1.g(t2, jD))) {
                        zA = false;
                    }
                    break;
                case 10:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || !f1.a(p1.g(t, jD), p1.g(t2, jD))) {
                        zA = false;
                    }
                    break;
                case 11:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.e(t, jD) != p1.e(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 12:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.e(t, jD) != p1.e(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 13:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.e(t, jD) != p1.e(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 14:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.f(t, jD) != p1.f(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 15:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.e(t, jD) != p1.e(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 16:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || p1.f(t, jD) != p1.f(t2, jD)) {
                        zA = false;
                    }
                    break;
                case 17:
                    if (!(a((Object) t, i) == a((Object) t2, i)) || !f1.a(p1.g(t, jD), p1.g(t2, jD))) {
                        zA = false;
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
                    zA = f1.a(p1.g(t, jD), p1.g(t2, jD));
                    break;
                case 50:
                    zA = f1.a(p1.g(t, jD), p1.g(t2, jD));
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
                    long j = this.a[i + 2] & 1048575;
                    if (!(p1.e(t, j) == p1.e(t2, j)) || !f1.a(p1.g(t, jD), p1.g(t2, jD))) {
                        zA = false;
                    }
                    break;
            }
            if (!zA) {
                return false;
            }
            i += 3;
        }
    }

    public final d1 c(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.f1305b;
        d1 d1Var = (d1) objArr[i2];
        if (d1Var != null) {
            return d1Var;
        }
        d1<T> d1VarA = z0.c.a((Class) objArr[i2 + 1]);
        this.f1305b[i2] = d1VarA;
        return d1VarA;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public int d(T t) {
        int i;
        int iA;
        int length = this.a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iG = g(i3);
            int i4 = this.a[i3];
            long jD = d(iG);
            int iHashCode = 37;
            switch (f(iG)) {
                case 0:
                    i = i2 * 53;
                    iA = y.a(Double.doubleToLongBits(p1.e.c(t, jD)));
                    i2 = i + iA;
                    break;
                case 1:
                    i = i2 * 53;
                    iA = Float.floatToIntBits(p1.e.d(t, jD));
                    i2 = i + iA;
                    break;
                case 2:
                    i = i2 * 53;
                    iA = y.a(p1.f(t, jD));
                    i2 = i + iA;
                    break;
                case 3:
                    i = i2 * 53;
                    iA = y.a(p1.f(t, jD));
                    i2 = i + iA;
                    break;
                case 4:
                    i = i2 * 53;
                    iA = p1.e(t, jD);
                    i2 = i + iA;
                    break;
                case 5:
                    i = i2 * 53;
                    iA = y.a(p1.f(t, jD));
                    i2 = i + iA;
                    break;
                case 6:
                    i = i2 * 53;
                    iA = p1.e(t, jD);
                    i2 = i + iA;
                    break;
                case 7:
                    i = i2 * 53;
                    iA = y.a(p1.e.a(t, jD));
                    i2 = i + iA;
                    break;
                case 8:
                    i = i2 * 53;
                    iA = ((String) p1.g(t, jD)).hashCode();
                    i2 = i + iA;
                    break;
                case 9:
                    Object objG = p1.g(t, jD);
                    if (objG != null) {
                        iHashCode = objG.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iA = p1.g(t, jD).hashCode();
                    i2 = i + iA;
                    break;
                case 11:
                    i = i2 * 53;
                    iA = p1.e(t, jD);
                    i2 = i + iA;
                    break;
                case 12:
                    i = i2 * 53;
                    iA = p1.e(t, jD);
                    i2 = i + iA;
                    break;
                case 13:
                    i = i2 * 53;
                    iA = p1.e(t, jD);
                    i2 = i + iA;
                    break;
                case 14:
                    i = i2 * 53;
                    iA = y.a(p1.f(t, jD));
                    i2 = i + iA;
                    break;
                case 15:
                    i = i2 * 53;
                    iA = p1.e(t, jD);
                    i2 = i + iA;
                    break;
                case 16:
                    i = i2 * 53;
                    iA = y.a(p1.f(t, jD));
                    i2 = i + iA;
                    break;
                case 17:
                    Object objG2 = p1.g(t, jD);
                    if (objG2 != null) {
                        iHashCode = objG2.hashCode();
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
                    iA = p1.g(t, jD).hashCode();
                    i2 = i + iA;
                    break;
                case 50:
                    i = i2 * 53;
                    iA = p1.g(t, jD).hashCode();
                    i2 = i + iA;
                    break;
                case 51:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = y.a(Double.doubleToLongBits(b(t, jD)));
                        i2 = i + iA;
                    }
                    break;
                case 52:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = Float.floatToIntBits(c(t, jD));
                        i2 = i + iA;
                    }
                    break;
                case 53:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = y.a(e(t, jD));
                        i2 = i + iA;
                    }
                    break;
                case 54:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = y.a(e(t, jD));
                        i2 = i + iA;
                    }
                    break;
                case 55:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = d(t, jD);
                        i2 = i + iA;
                    }
                    break;
                case 56:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = y.a(e(t, jD));
                        i2 = i + iA;
                    }
                    break;
                case 57:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = d(t, jD);
                        i2 = i + iA;
                    }
                    break;
                case 58:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = y.a(a(t, jD));
                        i2 = i + iA;
                    }
                    break;
                case 59:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = ((String) p1.g(t, jD)).hashCode();
                        i2 = i + iA;
                    }
                    break;
                case 60:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = p1.g(t, jD).hashCode();
                        i2 = i + iA;
                    }
                    break;
                case 61:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = p1.g(t, jD).hashCode();
                        i2 = i + iA;
                    }
                    break;
                case 62:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = d(t, jD);
                        i2 = i + iA;
                    }
                    break;
                case 63:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = d(t, jD);
                        i2 = i + iA;
                    }
                    break;
                case 64:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = d(t, jD);
                        i2 = i + iA;
                    }
                    break;
                case 65:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = y.a(e(t, jD));
                        i2 = i + iA;
                    }
                    break;
                case 66:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = d(t, jD);
                        i2 = i + iA;
                    }
                    break;
                case 67:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = y.a(e(t, jD));
                        i2 = i + iA;
                    }
                    break;
                case 68:
                    if (a(t, i4, i3)) {
                        i = i2 * 53;
                        iA = p1.g(t, jD).hashCode();
                        i2 = i + iA;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.o.b(t).hashCode();
        return this.f ? (iHashCode2 * 53) + this.p.a(t).a.hashCode() : iHashCode2;
    }

    public final int g(int i) {
        return this.a[i + 1];
    }

    public static <T> long e(T t, long j) {
        return ((Long) p1.g(t, j)).longValue();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void c(T t) {
        int i;
        int i2 = this.k;
        while (true) {
            i = this.l;
            if (i2 >= i) {
                break;
            }
            long jD = d(g(this.j[i2]));
            Object objG = p1.g(t, jD);
            if (objG != null) {
                p1.a(t, jD, this.q.e(objG));
            }
            i2++;
        }
        int length = this.j.length;
        while (i < length) {
            this.n.a(t, this.j[i]);
            i++;
        }
        this.o.e(t);
        if (this.f) {
            this.p.c(t);
        }
    }

    public final int e(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return a(i, 0);
    }

    public static <T> float c(T t, long j) {
        return ((Float) p1.g(t, j)).floatValue();
    }

    /* JADX WARN: Code duplicated, block: B:465:0x0a25 A[PHI: r13
      0x0a25: PHI (r13v84 int) = 
      (r13v3 int)
      (r13v12 int)
      (r13v13 int)
      (r13v14 int)
      (r13v15 int)
      (r13v16 int)
      (r13v17 int)
      (r13v18 int)
      (r13v19 int)
      (r13v20 int)
      (r13v21 int)
      (r13v22 int)
      (r13v42 int)
      (r13v43 int)
      (r13v44 int)
      (r13v45 int)
      (r13v46 int)
      (r13v47 int)
      (r13v48 int)
      (r13v49 int)
      (r13v50 int)
      (r13v51 int)
      (r13v52 int)
      (r13v53 int)
      (r13v54 int)
      (r13v58 int)
      (r13v60 int)
      (r13v62 int)
      (r13v64 int)
      (r13v65 int)
      (r13v66 int)
      (r13v67 int)
      (r13v68 int)
      (r13v70 int)
      (r13v72 int)
      (r13v73 int)
      (r13v74 int)
      (r13v75 int)
      (r13v76 int)
      (r13v80 int)
      (r13v81 int)
      (r13v82 int)
      (r13v83 int)
      (r13v89 int)
     binds: [B:570:?, B:463:0x0a1b, B:457:0x09fe, B:454:0x09eb, B:451:0x09da, B:448:0x09cb, B:445:0x09bc, B:442:0x09af, B:439:0x09a4, B:436:0x0995, B:433:0x0986, B:430:0x0971, B:401:0x0869, B:395:0x084b, B:389:0x082d, B:383:0x080f, B:377:0x07f0, B:371:0x07d1, B:365:0x07b2, B:359:0x0793, B:353:0x0772, B:347:0x0753, B:341:0x0734, B:335:0x0715, B:329:0x06f6, B:569:?, B:568:?, B:567:?, B:566:?, B:565:?, B:564:?, B:563:?, B:562:?, B:561:?, B:560:?, B:559:?, B:558:?, B:557:?, B:556:?, B:555:?, B:554:?, B:553:?, B:552:?, B:327:0x06e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:489:0x0a94 A[PHI: r3 r13
      0x0a94: PHI (r3v20 int) = (r3v14 int), (r3v15 int), (r3v16 int), (r3v17 int), (r3v18 int), (r3v19 int), (r3v21 int) binds: [B:486:0x0a8a, B:483:0x0a7a, B:479:0x0a68, B:476:0x0a58, B:473:0x0a48, B:470:0x0a3c, B:467:0x0a30] A[DONT_GENERATE, DONT_INLINE]
      0x0a94: PHI (r13v10 int) = (r13v4 int), (r13v5 int), (r13v6 int), (r13v7 int), (r13v8 int), (r13v9 int), (r13v11 int) binds: [B:486:0x0a8a, B:483:0x0a7a, B:479:0x0a68, B:476:0x0a58, B:473:0x0a48, B:470:0x0a3c, B:467:0x0a30] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:256:0x0579. Please report as an issue. */
    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public int b(T t) {
        int iC;
        int iD;
        int i;
        int i2;
        int i3;
        int iA;
        int iB;
        int iA2;
        int iD2;
        int iC2;
        int iB2;
        int iC3;
        int iA3;
        boolean z;
        int iA4;
        int iA5;
        int iC4;
        int iB3;
        int iC5;
        int i4 = 1048575;
        int i5 = 1;
        if (this.h) {
            Unsafe unsafe = s;
            iC = 0;
            for (int i6 = 0; i6 < this.a.length; i6 += 3) {
                int iG = g(i6);
                int iF = f(iG);
                int i7 = this.a[i6];
                long jD = d(iG);
                int i8 = (iF < FieldType.DOUBLE_LIST_PACKED.id() || iF > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.a[i6 + 2] & 1048575;
                switch (iF) {
                    case 0:
                        if (a((Object) t, i6)) {
                            iA4 = l.a(i7, 0.0d);
                            iA5 = iA4;
                            iC += iA5;
                        }
                        break;
                    case 1:
                        if (a((Object) t, i6)) {
                            iA5 = l.a(i7, 0.0f);
                            iC += iA5;
                        }
                        break;
                    case 2:
                        if (a((Object) t, i6)) {
                            iA5 = l.b(i7, p1.f(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 3:
                        if (a((Object) t, i6)) {
                            iA5 = l.e(i7, p1.f(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 4:
                        if (a((Object) t, i6)) {
                            iA5 = l.c(i7, p1.e(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 5:
                        if (a((Object) t, i6)) {
                            iA5 = l.a(i7, 0L);
                            iC += iA5;
                        }
                        break;
                    case 6:
                        if (a((Object) t, i6)) {
                            iA5 = l.b(i7, 0);
                            iC += iA5;
                        }
                        break;
                    case 7:
                        if (a((Object) t, i6)) {
                            iA5 = l.a(i7, true);
                            iC += iA5;
                        }
                        break;
                    case 8:
                        if (a((Object) t, i6)) {
                            Object objG = p1.g(t, jD);
                            if (objG instanceof i) {
                                iA5 = l.a(i7, (i) objG);
                            } else {
                                iA5 = l.a(i7, (String) objG);
                            }
                            iC += iA5;
                        }
                        break;
                    case 9:
                        if (a((Object) t, i6)) {
                            iA5 = f1.a(i7, p1.g(t, jD), c(i6));
                            iC += iA5;
                        }
                        break;
                    case 10:
                        if (a((Object) t, i6)) {
                            iA5 = l.a(i7, (i) p1.g(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 11:
                        if (a((Object) t, i6)) {
                            iA5 = l.f(i7, p1.e(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 12:
                        if (a((Object) t, i6)) {
                            iA5 = l.a(i7, p1.e(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 13:
                        if (a((Object) t, i6)) {
                            iA5 = l.d(i7, 0);
                            iC += iA5;
                        }
                        break;
                    case 14:
                        if (a((Object) t, i6)) {
                            iA5 = l.c(i7, 0L);
                            iC += iA5;
                        }
                        break;
                    case 15:
                        if (a((Object) t, i6)) {
                            iA5 = l.e(i7, p1.e(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 16:
                        if (a((Object) t, i6)) {
                            iA5 = l.d(i7, p1.f(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 17:
                        if (a((Object) t, i6)) {
                            iA5 = l.a(i7, (o0) p1.g(t, jD), c(i6));
                            iC += iA5;
                        }
                        break;
                    case 18:
                        iA5 = f1.d(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 19:
                        iA5 = f1.c(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 20:
                        iA5 = f1.f(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 21:
                        iA5 = f1.j(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 22:
                        iA5 = f1.e(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 23:
                        iA5 = f1.d(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 24:
                        iA5 = f1.c(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 25:
                        iA5 = f1.a(i7, (List<?>) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 26:
                        iA5 = f1.b(i7, (List) p1.g(t, jD));
                        iC += iA5;
                        break;
                    case 27:
                        iA5 = f1.b(i7, (List<?>) p1.g(t, jD), c(i6));
                        iC += iA5;
                        break;
                    case 28:
                        iA5 = f1.a(i7, (List<i>) p1.g(t, jD));
                        iC += iA5;
                        break;
                    case 29:
                        iA5 = f1.i(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 30:
                        iA5 = f1.b(i7, (List<Integer>) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 31:
                        iA5 = f1.c(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 32:
                        iA5 = f1.d(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 33:
                        iA5 = f1.g(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 34:
                        iA5 = f1.h(i7, (List) p1.g(t, jD), false);
                        iC += iA5;
                        break;
                    case 35:
                        iC4 = f1.c((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 36:
                        iC4 = f1.b((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 37:
                        iC4 = f1.e((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 38:
                        iC4 = f1.i((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 39:
                        iC4 = f1.d((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 40:
                        iC4 = f1.c((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 41:
                        iC4 = f1.b((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 42:
                        List list = (List) unsafe.getObject(t, jD);
                        Class<?> cls = f1.a;
                        iC4 = list.size();
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 43:
                        iC4 = f1.h((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 44:
                        iC4 = f1.a((List<Integer>) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 45:
                        iC4 = f1.b((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 46:
                        iC4 = f1.c((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 47:
                        iC4 = f1.f((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 48:
                        iC4 = f1.g((List) unsafe.getObject(t, jD));
                        if (iC4 > 0) {
                            if (this.i) {
                                unsafe.putInt(t, i8, iC4);
                            }
                            iB3 = l.b(i7);
                            iC5 = l.c(iC4);
                            iA5 = iC4 + iB3 + iC5;
                            iC += iA5;
                        }
                        break;
                    case 49:
                        iA5 = f1.a(i7, (List<o0>) p1.g(t, jD), c(i6));
                        iC += iA5;
                        break;
                    case 50:
                        iA5 = this.q.a(i7, p1.g(t, jD), b(i6));
                        iC += iA5;
                        break;
                    case 51:
                        if (a(t, i7, i6)) {
                            iA4 = l.a(i7, 0.0d);
                            iA5 = iA4;
                            iC += iA5;
                        }
                        break;
                    case 52:
                        if (a(t, i7, i6)) {
                            iA5 = l.a(i7, 0.0f);
                            iC += iA5;
                        }
                        break;
                    case 53:
                        if (a(t, i7, i6)) {
                            iA5 = l.b(i7, e(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 54:
                        if (a(t, i7, i6)) {
                            iA5 = l.e(i7, e(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 55:
                        if (a(t, i7, i6)) {
                            iA5 = l.c(i7, d(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 56:
                        if (a(t, i7, i6)) {
                            iA5 = l.a(i7, 0L);
                            iC += iA5;
                        }
                        break;
                    case 57:
                        if (a(t, i7, i6)) {
                            iA5 = l.b(i7, 0);
                            iC += iA5;
                        }
                        break;
                    case 58:
                        if (a(t, i7, i6)) {
                            iA5 = l.a(i7, true);
                            iC += iA5;
                        }
                        break;
                    case 59:
                        if (a(t, i7, i6)) {
                            Object objG2 = p1.g(t, jD);
                            if (objG2 instanceof i) {
                                iA5 = l.a(i7, (i) objG2);
                            } else {
                                iA5 = l.a(i7, (String) objG2);
                            }
                            iC += iA5;
                        }
                        break;
                    case 60:
                        if (a(t, i7, i6)) {
                            iA5 = f1.a(i7, p1.g(t, jD), c(i6));
                            iC += iA5;
                        }
                        break;
                    case 61:
                        if (a(t, i7, i6)) {
                            iA5 = l.a(i7, (i) p1.g(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 62:
                        if (a(t, i7, i6)) {
                            iA5 = l.f(i7, d(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 63:
                        if (a(t, i7, i6)) {
                            iA5 = l.a(i7, d(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 64:
                        if (a(t, i7, i6)) {
                            iA5 = l.d(i7, 0);
                            iC += iA5;
                        }
                        break;
                    case 65:
                        if (a(t, i7, i6)) {
                            iA5 = l.c(i7, 0L);
                            iC += iA5;
                        }
                        break;
                    case 66:
                        if (a(t, i7, i6)) {
                            iA5 = l.e(i7, d(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 67:
                        if (a(t, i7, i6)) {
                            iA5 = l.d(i7, e(t, jD));
                            iC += iA5;
                        }
                        break;
                    case 68:
                        if (a(t, i7, i6)) {
                            iA5 = l.a(i7, (o0) p1.g(t, jD), c(i6));
                            iC += iA5;
                        }
                        break;
                }
            }
            k1<?, ?> k1Var = this.o;
            iD = k1Var.c(k1Var.b(t));
        } else {
            Unsafe unsafe2 = s;
            int i9 = 1048575;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i10 < this.a.length) {
                int iG2 = g(i10);
                int i13 = this.a[i10];
                int iF2 = f(iG2);
                if (iF2 <= 17) {
                    i = this.a[i10 + 2];
                    int i14 = i & i4;
                    i2 = i5 << (i >>> 20);
                    if (i14 != i9) {
                        i12 = unsafe2.getInt(t, i14);
                        i9 = i14;
                    }
                } else {
                    i = (!this.i || iF2 < FieldType.DOUBLE_LIST_PACKED.id() || iF2 > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.a[i10 + 2] & i4;
                    i2 = 0;
                }
                long jD2 = d(iG2);
                switch (iF2) {
                    case 0:
                        i9 = i9;
                        i3 = 1;
                        if ((i12 & i2) != 0) {
                            iA = l.a(i13, 0.0d);
                            i11 += iA;
                        }
                        break;
                    case 1:
                        i9 = i9;
                        i3 = 1;
                        if ((i12 & i2) != 0) {
                            iA = l.a(i13, 0.0f);
                            i11 += iA;
                        }
                        break;
                    case 2:
                        i9 = i9;
                        i3 = 1;
                        if ((i12 & i2) != 0) {
                            iB = l.b(i13, unsafe2.getLong(t, jD2));
                            iA = iB;
                            i11 += iA;
                        }
                        break;
                    case 3:
                        i9 = i9;
                        i3 = 1;
                        if ((i12 & i2) != 0) {
                            iB = l.e(i13, unsafe2.getLong(t, jD2));
                            iA = iB;
                            i11 += iA;
                        }
                        break;
                    case 4:
                        i9 = i9;
                        i3 = 1;
                        if ((i12 & i2) != 0) {
                            iB = l.c(i13, unsafe2.getInt(t, jD2));
                            iA = iB;
                            i11 += iA;
                        }
                        break;
                    case 5:
                        i9 = i9;
                        i3 = 1;
                        if ((i12 & i2) != 0) {
                            iB = l.a(i13, 0L);
                            iA = iB;
                            i11 += iA;
                        }
                        break;
                    case 6:
                        i9 = i9;
                        i3 = 1;
                        if ((i12 & i2) != 0) {
                            iB = l.b(i13, 0);
                            iA = iB;
                            i11 += iA;
                        }
                        break;
                    case 7:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            i3 = 1;
                            iA = l.a(i13, true);
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 8:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            Object object = unsafe2.getObject(t, jD2);
                            if (object instanceof i) {
                                iA2 = l.a(i13, (i) object);
                            } else {
                                iA2 = l.a(i13, (String) object);
                            }
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 9:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            iA2 = f1.a(i13, unsafe2.getObject(t, jD2), c(i10));
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 10:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            iA2 = l.a(i13, (i) unsafe2.getObject(t, jD2));
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 11:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            iA2 = l.f(i13, unsafe2.getInt(t, jD2));
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 12:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            iA2 = l.a(i13, unsafe2.getInt(t, jD2));
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 13:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            iA = l.d(i13, 0);
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 14:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            iA2 = l.c(i13, 0L);
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 15:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            iA2 = l.e(i13, unsafe2.getInt(t, jD2));
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 16:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            iA2 = l.d(i13, unsafe2.getLong(t, jD2));
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 17:
                        i9 = i9;
                        if ((i12 & i2) != 0) {
                            iA2 = l.a(i13, (o0) unsafe2.getObject(t, jD2), c(i10));
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 18:
                        iD2 = f1.d(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 19:
                        iD2 = f1.c(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 20:
                        iD2 = f1.f(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 21:
                        iD2 = f1.j(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 22:
                        iD2 = f1.e(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 23:
                        iD2 = f1.d(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 24:
                        iD2 = f1.c(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 25:
                        iD2 = f1.a(i13, (List<?>) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 26:
                        i9 = i9;
                        iA2 = f1.b(i13, (List) unsafe2.getObject(t, jD2));
                        iA = iA2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 27:
                        i9 = i9;
                        iA2 = f1.b(i13, (List<?>) unsafe2.getObject(t, jD2), c(i10));
                        iA = iA2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 28:
                        i9 = i9;
                        iA2 = f1.a(i13, (List<i>) unsafe2.getObject(t, jD2));
                        iA = iA2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 29:
                        iD2 = f1.i(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 30:
                        iD2 = f1.b(i13, (List<Integer>) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 31:
                        iD2 = f1.c(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 32:
                        iD2 = f1.d(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 33:
                        iD2 = f1.g(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 34:
                        iD2 = f1.h(i13, (List) unsafe2.getObject(t, jD2), false);
                        iA = iD2;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 35:
                        i9 = i9;
                        iC2 = f1.c((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 36:
                        i9 = i9;
                        iC2 = f1.b((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 37:
                        i9 = i9;
                        iC2 = f1.e((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 38:
                        i9 = i9;
                        iC2 = f1.i((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 39:
                        i9 = i9;
                        iC2 = f1.d((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 40:
                        i9 = i9;
                        iC2 = f1.c((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 41:
                        i9 = i9;
                        iC2 = f1.b((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 42:
                        i9 = i9;
                        List list2 = (List) unsafe2.getObject(t, jD2);
                        Class<?> cls2 = f1.a;
                        iC2 = list2.size();
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 43:
                        i9 = i9;
                        iC2 = f1.h((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 44:
                        i9 = i9;
                        iC2 = f1.a((List<Integer>) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 45:
                        i9 = i9;
                        iC2 = f1.b((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 46:
                        i9 = i9;
                        iC2 = f1.c((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 47:
                        i9 = i9;
                        iC2 = f1.f((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i3 = 1;
                        }
                        break;
                    case 48:
                        iC2 = f1.g((List) unsafe2.getObject(t, jD2));
                        if (iC2 > 0) {
                            i9 = i9;
                            if (this.i) {
                                unsafe2.putInt(t, i, iC2);
                            }
                            iB2 = l.b(i13);
                            iC3 = l.c(iC2);
                            iA2 = iB2 + iC3 + iC2;
                            iA = iA2;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 49:
                        iA3 = f1.a(i13, (List<o0>) unsafe2.getObject(t, jD2), c(i10));
                        iA = iA3;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 50:
                        iA3 = this.q.a(i13, unsafe2.getObject(t, jD2), b(i10));
                        iA = iA3;
                        i3 = 1;
                        i11 += iA;
                        break;
                    case 51:
                        if (a(t, i13, i10)) {
                            iA3 = l.a(i13, 0.0d);
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 52:
                        if (a(t, i13, i10)) {
                            iB = l.a(i13, 0.0f);
                            i3 = 1;
                            iA = iB;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 53:
                        if (a(t, i13, i10)) {
                            iA3 = l.b(i13, e(t, jD2));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 54:
                        if (a(t, i13, i10)) {
                            iA3 = l.e(i13, e(t, jD2));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 55:
                        if (a(t, i13, i10)) {
                            iA3 = l.c(i13, d(t, jD2));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 56:
                        if (a(t, i13, i10)) {
                            iA3 = l.a(i13, 0L);
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 57:
                        if (a(t, i13, i10)) {
                            z = false;
                            iB = l.b(i13, 0);
                            i9 = i9;
                            i3 = 1;
                            iA = iB;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 58:
                        if (a(t, i13, i10)) {
                            i3 = 1;
                            iB = l.a(i13, true);
                            iA = iB;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 59:
                        if (a(t, i13, i10)) {
                            Object object2 = unsafe2.getObject(t, jD2);
                            if (object2 instanceof i) {
                                iA3 = l.a(i13, (i) object2);
                            } else {
                                iA3 = l.a(i13, (String) object2);
                            }
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 60:
                        if (a(t, i13, i10)) {
                            iA3 = f1.a(i13, unsafe2.getObject(t, jD2), c(i10));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 61:
                        if (a(t, i13, i10)) {
                            iA3 = l.a(i13, (i) unsafe2.getObject(t, jD2));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 62:
                        if (a(t, i13, i10)) {
                            iA3 = l.f(i13, d(t, jD2));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 63:
                        if (a(t, i13, i10)) {
                            iA3 = l.a(i13, d(t, jD2));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 64:
                        if (a(t, i13, i10)) {
                            z = false;
                            iB = l.d(i13, 0);
                            i9 = i9;
                            i3 = 1;
                            iA = iB;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 65:
                        if (a(t, i13, i10)) {
                            iA3 = l.c(i13, 0L);
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 66:
                        if (a(t, i13, i10)) {
                            iA3 = l.e(i13, d(t, jD2));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 67:
                        if (a(t, i13, i10)) {
                            iA3 = l.d(i13, e(t, jD2));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    case 68:
                        if (a(t, i13, i10)) {
                            iA3 = l.a(i13, (o0) unsafe2.getObject(t, jD2), c(i10));
                            iA = iA3;
                            i3 = 1;
                            i11 += iA;
                        } else {
                            i9 = i9;
                            i3 = 1;
                        }
                        break;
                    default:
                        i9 = i9;
                        i3 = 1;
                        break;
                }
                i10 += 3;
                i5 = i3;
                i9 = i9;
                i4 = 1048575;
            }
            k1<?, ?> k1Var2 = this.o;
            iC = i11 + k1Var2.c(k1Var2.b(t));
            if (!this.f) {
                return iC;
            }
            iD = this.p.a(t).d();
        }
        return iC + iD;
    }

    public static Field a(Class<?> cls, String str) {
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

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public T a() {
        return (T) this.m.a(this.e);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void a(T t, T t2) {
        t2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i < iArr.length) {
                int i2 = iArr[i + 1];
                long jD = d(i2);
                int i3 = this.a[i];
                switch (f(i2)) {
                    case 0:
                        if (a((Object) t2, i)) {
                            p1.d dVar = p1.e;
                            dVar.a(t, jD, dVar.c(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 1:
                        if (a((Object) t2, i)) {
                            p1.d dVar2 = p1.e;
                            dVar2.a((Object) t, jD, dVar2.d(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 2:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.f(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 3:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.f(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 4:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.e(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 5:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.f(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 6:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.e(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 7:
                        if (a((Object) t2, i)) {
                            p1.d dVar3 = p1.e;
                            dVar3.a(t, jD, dVar3.a(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 8:
                        if (a((Object) t2, i)) {
                            p1.a(t, jD, p1.g(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 9:
                        a(t, t2, i);
                        break;
                    case 10:
                        if (a((Object) t2, i)) {
                            p1.a(t, jD, p1.g(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 11:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.e(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 12:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.e(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 13:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.e(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 14:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.f(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 15:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.e(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 16:
                        if (a((Object) t2, i)) {
                            p1.a((Object) t, jD, p1.f(t2, jD));
                            b((Object) t, i);
                        }
                        break;
                    case 17:
                        a(t, t2, i);
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
                        this.n.a(t, t2, jD);
                        break;
                    case 50:
                        j0 j0Var = this.q;
                        Class<?> cls = f1.a;
                        p1.a(t, jD, j0Var.a(p1.g(t, jD), p1.g(t2, jD)));
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
                        if (a(t2, i3, i)) {
                            p1.a(t, jD, p1.g(t2, jD));
                            b(t, i3, i);
                        }
                        break;
                    case 60:
                        b(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (a(t2, i3, i)) {
                            p1.a(t, jD, p1.g(t2, jD));
                            b(t, i3, i);
                        }
                        break;
                    case 68:
                        b(t, t2, i);
                        break;
                }
                i += 3;
            } else {
                k1<?, ?> k1Var = this.o;
                Class<?> cls2 = f1.a;
                k1Var.c(t, k1Var.a(k1Var.b(t), k1Var.b(t2)));
                if (this.f) {
                    r<?> rVar = this.p;
                    u<T> uVarA = rVar.a(t2);
                    if (uVarA.a.isEmpty()) {
                        return;
                    }
                    rVar.b(t).a((u) uVarA);
                    return;
                }
                return;
            }
        }
    }

    public static <T> int d(T t, long j) {
        return ((Integer) p1.g(t, j)).intValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:188:0x063f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0066  */
    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void a(T t, s1 s1Var) throws IOException {
        Iterator itF;
        Map.Entry<?, ?> entry;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        Map.Entry<?, ?> entry2;
        Iterator it;
        m mVar = (m) s1Var;
        mVar.getClass();
        if (s1.a.ASCENDING == s1.a.DESCENDING) {
            k1<?, ?> k1Var = this.o;
            k1Var.b(k1Var.b(t), s1Var);
            if (this.f) {
                u<T> uVarA = this.p.a(t);
                if (uVarA.a.isEmpty()) {
                    entry2 = null;
                    it = null;
                } else {
                    if (uVarA.c) {
                        g1<T, Object> g1Var = uVarA.a;
                        if (g1Var.g == null) {
                            g1Var.g = new g1.c();
                        }
                        it = new a0.b(g1Var.g.iterator());
                    } else {
                        g1<T, Object> g1Var2 = uVarA.a;
                        if (g1Var2.g == null) {
                            g1Var2.g = new g1.c();
                        }
                        it = g1Var2.g.iterator();
                    }
                    entry2 = (Map.Entry) it.next();
                }
            } else {
                entry2 = null;
                it = null;
            }
            for (int length = this.a.length - 3; length >= 0; length -= 3) {
                int iG = g(length);
                int i2 = this.a[length];
                while (entry2 != null && this.p.a(entry2) > i2) {
                    this.p.a(s1Var, entry2);
                    entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                switch (f(iG)) {
                    case 0:
                        if (a((Object) t, length)) {
                            mVar.a(i2, p1.e.c(t, d(iG)));
                        }
                        break;
                    case 1:
                        if (a((Object) t, length)) {
                            mVar.a(i2, p1.e.d(t, d(iG)));
                        }
                        break;
                    case 2:
                        if (a((Object) t, length)) {
                            mVar.a.g(i2, p1.f(t, d(iG)));
                        }
                        break;
                    case 3:
                        if (a((Object) t, length)) {
                            mVar.a.g(i2, p1.f(t, d(iG)));
                        }
                        break;
                    case 4:
                        if (a((Object) t, length)) {
                            mVar.a.h(i2, p1.e(t, d(iG)));
                        }
                        break;
                    case 5:
                        if (a((Object) t, length)) {
                            mVar.a.f(i2, p1.f(t, d(iG)));
                        }
                        break;
                    case 6:
                        if (a((Object) t, length)) {
                            mVar.a.g(i2, p1.e(t, d(iG)));
                        }
                        break;
                    case 7:
                        if (a((Object) t, length)) {
                            mVar.a.b(i2, p1.e.a(t, d(iG)));
                        }
                        break;
                    case 8:
                        if (a((Object) t, length)) {
                            a(i2, p1.g(t, d(iG)), s1Var);
                        }
                        break;
                    case 9:
                        if (a((Object) t, length)) {
                            mVar.b(i2, p1.g(t, d(iG)), c(length));
                        }
                        break;
                    case 10:
                        if (a((Object) t, length)) {
                            mVar.a.b(i2, (i) p1.g(t, d(iG)));
                        }
                        break;
                    case 11:
                        if (a((Object) t, length)) {
                            mVar.a.j(i2, p1.e(t, d(iG)));
                        }
                        break;
                    case 12:
                        if (a((Object) t, length)) {
                            mVar.a.h(i2, p1.e(t, d(iG)));
                        }
                        break;
                    case 13:
                        if (a((Object) t, length)) {
                            mVar.a.g(i2, p1.e(t, d(iG)));
                        }
                        break;
                    case 14:
                        if (a((Object) t, length)) {
                            mVar.a.f(i2, p1.f(t, d(iG)));
                        }
                        break;
                    case 15:
                        if (a((Object) t, length)) {
                            mVar.a(i2, p1.e(t, d(iG)));
                        }
                        break;
                    case 16:
                        if (a((Object) t, length)) {
                            mVar.a(i2, p1.f(t, d(iG)));
                        }
                        break;
                    case 17:
                        if (a((Object) t, length)) {
                            mVar.a(i2, p1.g(t, d(iG)), c(length));
                        }
                        break;
                    case 18:
                        f1.b(this.a[length], (List<Double>) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 19:
                        f1.f(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 20:
                        f1.h(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 21:
                        f1.n(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 22:
                        f1.g(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 23:
                        f1.e(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 24:
                        f1.d(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 25:
                        f1.a(this.a[length], (List<Boolean>) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 26:
                        f1.b(this.a[length], (List<String>) p1.g(t, d(iG)), s1Var);
                        break;
                    case 27:
                        f1.b(this.a[length], (List<?>) p1.g(t, d(iG)), s1Var, c(length));
                        break;
                    case 28:
                        f1.a(this.a[length], (List<i>) p1.g(t, d(iG)), s1Var);
                        break;
                    case 29:
                        f1.m(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 30:
                        f1.c(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 31:
                        f1.i(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 32:
                        f1.j(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 33:
                        f1.k(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 34:
                        f1.l(this.a[length], (List) p1.g(t, d(iG)), s1Var, false);
                        break;
                    case 35:
                        f1.b(this.a[length], (List<Double>) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 36:
                        f1.f(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 37:
                        f1.h(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 38:
                        f1.n(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 39:
                        f1.g(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 40:
                        f1.e(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 41:
                        f1.d(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 42:
                        f1.a(this.a[length], (List<Boolean>) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 43:
                        f1.m(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 44:
                        f1.c(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 45:
                        f1.i(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 46:
                        f1.j(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 47:
                        f1.k(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 48:
                        f1.l(this.a[length], (List) p1.g(t, d(iG)), s1Var, true);
                        break;
                    case 49:
                        f1.a(this.a[length], (List<?>) p1.g(t, d(iG)), s1Var, c(length));
                        break;
                    case 50:
                        a(s1Var, i2, p1.g(t, d(iG)), length);
                        break;
                    case 51:
                        if (a(t, i2, length)) {
                            mVar.a(i2, b(t, d(iG)));
                        }
                        break;
                    case 52:
                        if (a(t, i2, length)) {
                            mVar.a(i2, c(t, d(iG)));
                        }
                        break;
                    case 53:
                        if (a(t, i2, length)) {
                            mVar.a.g(i2, e(t, d(iG)));
                        }
                        break;
                    case 54:
                        if (a(t, i2, length)) {
                            mVar.a.g(i2, e(t, d(iG)));
                        }
                        break;
                    case 55:
                        if (a(t, i2, length)) {
                            mVar.a.h(i2, d(t, d(iG)));
                        }
                        break;
                    case 56:
                        if (a(t, i2, length)) {
                            mVar.a.f(i2, e(t, d(iG)));
                        }
                        break;
                    case 57:
                        if (a(t, i2, length)) {
                            mVar.a.g(i2, d(t, d(iG)));
                        }
                        break;
                    case 58:
                        if (a(t, i2, length)) {
                            mVar.a.b(i2, a(t, d(iG)));
                        }
                        break;
                    case 59:
                        if (a(t, i2, length)) {
                            a(i2, p1.g(t, d(iG)), s1Var);
                        }
                        break;
                    case 60:
                        if (a(t, i2, length)) {
                            mVar.b(i2, p1.g(t, d(iG)), c(length));
                        }
                        break;
                    case 61:
                        if (a(t, i2, length)) {
                            mVar.a.b(i2, (i) p1.g(t, d(iG)));
                        }
                        break;
                    case 62:
                        if (a(t, i2, length)) {
                            mVar.a.j(i2, d(t, d(iG)));
                        }
                        break;
                    case 63:
                        if (a(t, i2, length)) {
                            mVar.a.h(i2, d(t, d(iG)));
                        }
                        break;
                    case 64:
                        if (a(t, i2, length)) {
                            mVar.a.g(i2, d(t, d(iG)));
                        }
                        break;
                    case 65:
                        if (a(t, i2, length)) {
                            mVar.a.f(i2, e(t, d(iG)));
                        }
                        break;
                    case 66:
                        if (a(t, i2, length)) {
                            mVar.a(i2, d(t, d(iG)));
                        }
                        break;
                    case 67:
                        if (a(t, i2, length)) {
                            mVar.a(i2, e(t, d(iG)));
                        }
                        break;
                    case 68:
                        if (a(t, i2, length)) {
                            mVar.a(i2, p1.g(t, d(iG)), c(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.p.a(s1Var, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            return;
        }
        if (this.h) {
            b((Object) t, s1Var);
            return;
        }
        if (this.f) {
            u<T> uVarA2 = this.p.a(t);
            if (uVarA2.a.isEmpty()) {
                itF = null;
                entry = null;
            } else {
                itF = uVarA2.f();
                entry = (Map.Entry) itF.next();
            }
        } else {
            itF = null;
            entry = null;
        }
        int length2 = this.a.length;
        Unsafe unsafe = s;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < length2) {
            int iG2 = g(i4);
            int i7 = this.a[i4];
            int iF = f(iG2);
            if (iF <= 17) {
                int i8 = this.a[i4 + 2];
                Map.Entry<?, ?> entry3 = entry;
                int i9 = i8 & i3;
                if (i9 != i6) {
                    i5 = unsafe.getInt(t, i9);
                    i6 = i9;
                }
                i = 1 << (i8 >>> 20);
                entry = entry3;
            } else {
                i = 0;
            }
            while (entry != null && this.p.a(entry) <= i7) {
                this.p.a(s1Var, entry);
                entry = itF.hasNext() ? (Map.Entry) itF.next() : null;
            }
            Iterator it2 = itF;
            Map.Entry<?, ?> entry4 = entry;
            long jD = d(iG2);
            switch (iF) {
                case 0:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a(i7, p1.e.c(t, jD));
                    }
                    break;
                case 1:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a(i7, p1.e.d(t, jD));
                    }
                    break;
                case 2:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.g(i7, unsafe.getLong(t, jD));
                    }
                    break;
                case 3:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.g(i7, unsafe.getLong(t, jD));
                    }
                    break;
                case 4:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.h(i7, unsafe.getInt(t, jD));
                    }
                    break;
                case 5:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.f(i7, unsafe.getLong(t, jD));
                    }
                    break;
                case 6:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.g(i7, unsafe.getInt(t, jD));
                    }
                    break;
                case 7:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.b(i7, p1.e.a(t, jD));
                    }
                    break;
                case 8:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        a(i7, unsafe.getObject(t, jD), s1Var);
                    }
                    break;
                case 9:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.b(i7, unsafe.getObject(t, jD), c(i4));
                    }
                    break;
                case 10:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.b(i7, (i) unsafe.getObject(t, jD));
                    }
                    break;
                case 11:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.j(i7, unsafe.getInt(t, jD));
                    }
                    break;
                case 12:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.h(i7, unsafe.getInt(t, jD));
                    }
                    break;
                case 13:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.g(i7, unsafe.getInt(t, jD));
                    }
                    break;
                case 14:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a.f(i7, unsafe.getLong(t, jD));
                    }
                    break;
                case 15:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a(i7, unsafe.getInt(t, jD));
                    }
                    break;
                case 16:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a(i7, unsafe.getLong(t, jD));
                    }
                    break;
                case 17:
                    z = true;
                    z2 = false;
                    if ((i & i5) != 0) {
                        mVar.a(i7, unsafe.getObject(t, jD), c(i4));
                    }
                    break;
                case 18:
                    z = true;
                    z2 = false;
                    f1.b(this.a[i4], (List<Double>) unsafe.getObject(t, jD), s1Var, false);
                    break;
                case 19:
                    z = true;
                    z2 = false;
                    f1.f(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    break;
                case 20:
                    z = true;
                    z2 = false;
                    f1.h(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    break;
                case 21:
                    z = true;
                    z2 = false;
                    f1.n(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    break;
                case 22:
                    z = true;
                    z2 = false;
                    f1.g(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    break;
                case 23:
                    z = true;
                    z2 = false;
                    f1.e(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    break;
                case 24:
                    z = true;
                    z2 = false;
                    f1.d(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    break;
                case 25:
                    z = true;
                    z2 = false;
                    f1.a(this.a[i4], (List<Boolean>) unsafe.getObject(t, jD), s1Var, false);
                    break;
                case 26:
                    z = true;
                    f1.b(this.a[i4], (List<String>) unsafe.getObject(t, jD), s1Var);
                    z2 = false;
                    break;
                case 27:
                    z = true;
                    f1.b(this.a[i4], (List<?>) unsafe.getObject(t, jD), s1Var, c(i4));
                    z2 = false;
                    break;
                case 28:
                    z = true;
                    f1.a(this.a[i4], (List<i>) unsafe.getObject(t, jD), s1Var);
                    z2 = false;
                    break;
                case 29:
                    z3 = false;
                    z = true;
                    f1.m(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    z2 = z3;
                    break;
                case 30:
                    z3 = false;
                    z = true;
                    f1.c(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    z2 = z3;
                    break;
                case 31:
                    z3 = false;
                    z = true;
                    f1.i(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    z2 = z3;
                    break;
                case 32:
                    z3 = false;
                    z = true;
                    f1.j(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    z2 = z3;
                    break;
                case 33:
                    z3 = false;
                    z = true;
                    f1.k(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    z2 = z3;
                    break;
                case 34:
                    z = true;
                    z3 = false;
                    f1.l(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, false);
                    z2 = z3;
                    break;
                case 35:
                    z = true;
                    f1.b(this.a[i4], (List<Double>) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 36:
                    z = true;
                    f1.f(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 37:
                    z = true;
                    f1.h(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 38:
                    z = true;
                    f1.n(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 39:
                    z = true;
                    f1.g(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 40:
                    z = true;
                    f1.e(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 41:
                    z = true;
                    f1.d(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 42:
                    z = true;
                    f1.a(this.a[i4], (List<Boolean>) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 43:
                    z = true;
                    f1.m(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 44:
                    z = true;
                    f1.c(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 45:
                    z = true;
                    f1.i(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 46:
                    z = true;
                    f1.j(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 47:
                    z = true;
                    f1.k(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 48:
                    z = true;
                    f1.l(this.a[i4], (List) unsafe.getObject(t, jD), s1Var, true);
                    z2 = false;
                    break;
                case 49:
                    f1.a(this.a[i4], (List<?>) unsafe.getObject(t, jD), s1Var, c(i4));
                    z = true;
                    z2 = false;
                    break;
                case 50:
                    a(s1Var, i7, unsafe.getObject(t, jD), i4);
                    z = true;
                    z2 = false;
                    break;
                case 51:
                    if (a(t, i7, i4)) {
                        mVar.a(i7, b(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 52:
                    if (a(t, i7, i4)) {
                        mVar.a(i7, c(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 53:
                    if (a(t, i7, i4)) {
                        mVar.a.g(i7, e(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 54:
                    if (a(t, i7, i4)) {
                        mVar.a.g(i7, e(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 55:
                    if (a(t, i7, i4)) {
                        mVar.a.h(i7, d(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 56:
                    if (a(t, i7, i4)) {
                        mVar.a.f(i7, e(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 57:
                    if (a(t, i7, i4)) {
                        mVar.a.g(i7, d(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 58:
                    if (a(t, i7, i4)) {
                        mVar.a.b(i7, a(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 59:
                    if (a(t, i7, i4)) {
                        a(i7, unsafe.getObject(t, jD), s1Var);
                    }
                    z = true;
                    z2 = false;
                    break;
                case 60:
                    if (a(t, i7, i4)) {
                        mVar.b(i7, unsafe.getObject(t, jD), c(i4));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 61:
                    if (a(t, i7, i4)) {
                        mVar.a.b(i7, (i) unsafe.getObject(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 62:
                    if (a(t, i7, i4)) {
                        mVar.a.j(i7, d(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 63:
                    if (a(t, i7, i4)) {
                        mVar.a.h(i7, d(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 64:
                    if (a(t, i7, i4)) {
                        mVar.a.g(i7, d(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 65:
                    if (a(t, i7, i4)) {
                        mVar.a.f(i7, e(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 66:
                    if (a(t, i7, i4)) {
                        mVar.a(i7, d(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 67:
                    if (a(t, i7, i4)) {
                        mVar.a(i7, e(t, jD));
                    }
                    z = true;
                    z2 = false;
                    break;
                case 68:
                    if (a(t, i7, i4)) {
                        mVar.a(i7, unsafe.getObject(t, jD), c(i4));
                    }
                    z = true;
                    z2 = false;
                    break;
                default:
                    z = true;
                    z2 = false;
                    break;
            }
            i4 += 3;
            itF = it2;
            entry = entry4;
            i3 = 1048575;
        }
        Iterator it3 = itF;
        while (entry != null) {
            this.p.a(s1Var, entry);
            entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
        }
        k1<?, ?> k1Var2 = this.o;
        k1Var2.b(k1Var2.b(t), s1Var);
    }

    public final <K, V> void a(s1 s1Var, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            this.q.f(this.f1305b[(i2 / 3) * 2]);
            Map<?, ?> mapA = this.q.a(obj);
            m mVar = (m) s1Var;
            mVar.a.getClass();
            Iterator<Map.Entry<?, ?>> it = mapA.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                mVar.a.i(i, 2);
                next.getKey();
                next.getValue();
                throw null;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void a(T t, c1 c1Var, q qVar) throws IOException {
        qVar.getClass();
        a(this.o, this.p, t, c1Var, qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <UT, UB, ET extends u.b<ET>> void a(k1<UT, UB> k1Var, r<ET> rVar, T t, c1 c1Var, q qVar) throws IOException {
        Object objA;
        Object objA2 = null;
        Object objB = null;
        while (true) {
            try {
                int iS = c1Var.s();
                int iE = e(iS);
                if (iE < 0) {
                    if (iS == Integer.MAX_VALUE) {
                        for (int i = this.k; i < this.l; i++) {
                            objA2 = a(t, this.j[i], objA2, k1Var);
                        }
                        if (objA2 != null) {
                            k1Var.b(t, objA2);
                            return;
                        }
                        return;
                    }
                    Object objA3 = !this.f ? null : rVar.a(qVar, this.e, iS);
                    if (objA3 != null) {
                        if (objB == null) {
                            objB = rVar.b(t);
                        }
                        objA = rVar.a(c1Var, objA3, qVar, objB, objA2, k1Var);
                        objA2 = objA;
                    } else if (k1Var.a(c1Var)) {
                        if (c1Var.i()) {
                        }
                    } else {
                        if (objA2 == null) {
                            objA2 = k1Var.a(t);
                        }
                        if (k1Var.a(objA2, c1Var)) {
                        }
                    }
                } else {
                    int iG = g(iE);
                    try {
                        switch (f(iG)) {
                            case 0:
                                p1.a(t, d(iG), c1Var.h());
                                b((Object) t, iE);
                                continue;
                            case 1:
                                p1.a((Object) t, d(iG), c1Var.k());
                                b((Object) t, iE);
                                continue;
                            case 2:
                                p1.a((Object) t, d(iG), c1Var.o());
                                b((Object) t, iE);
                                continue;
                            case 3:
                                p1.a((Object) t, d(iG), c1Var.f());
                                b((Object) t, iE);
                                continue;
                            case 4:
                                p1.a((Object) t, d(iG), c1Var.d());
                                b((Object) t, iE);
                                continue;
                            case 5:
                                p1.a((Object) t, d(iG), c1Var.g());
                                b((Object) t, iE);
                                continue;
                            case 6:
                                p1.a((Object) t, d(iG), c1Var.q());
                                b((Object) t, iE);
                                continue;
                            case 7:
                                p1.a(t, d(iG), c1Var.r());
                                b((Object) t, iE);
                                continue;
                            case 8:
                                a(t, iG, c1Var);
                                b((Object) t, iE);
                                continue;
                            case 9:
                                if (a((Object) t, iE)) {
                                    p1.a(t, d(iG), y.a(p1.g(t, d(iG)), c1Var.b(c(iE), qVar)));
                                } else {
                                    p1.a(t, d(iG), c1Var.b(c(iE), qVar));
                                    b((Object) t, iE);
                                    continue;
                                }
                                break;
                            case 10:
                                p1.a(t, d(iG), c1Var.a());
                                b((Object) t, iE);
                                continue;
                            case 11:
                                p1.a((Object) t, d(iG), c1Var.c());
                                b((Object) t, iE);
                                continue;
                            case 12:
                                int iB = c1Var.b();
                                y.e eVarA = a(iE);
                                if (eVarA != null && !eVarA.a(iB)) {
                                    objA = f1.a(iS, iB, objA2, k1Var);
                                } else {
                                    p1.a((Object) t, d(iG), iB);
                                    b((Object) t, iE);
                                }
                                break;
                            case 13:
                                p1.a((Object) t, d(iG), c1Var.m());
                                b((Object) t, iE);
                                continue;
                            case 14:
                                p1.a((Object) t, d(iG), c1Var.t());
                                b((Object) t, iE);
                                continue;
                            case 15:
                                p1.a((Object) t, d(iG), c1Var.j());
                                b((Object) t, iE);
                                continue;
                            case 16:
                                p1.a((Object) t, d(iG), c1Var.l());
                                b((Object) t, iE);
                                continue;
                            case 17:
                                if (a((Object) t, iE)) {
                                    p1.a(t, d(iG), y.a(p1.g(t, d(iG)), c1Var.a(c(iE), qVar)));
                                } else {
                                    p1.a(t, d(iG), c1Var.a(c(iE), qVar));
                                    b((Object) t, iE);
                                    continue;
                                }
                                break;
                            case 18:
                                c1Var.j(this.n.b(t, d(iG)));
                                continue;
                            case 19:
                                c1Var.d(this.n.b(t, d(iG)));
                                continue;
                            case 20:
                                c1Var.k(this.n.b(t, d(iG)));
                                continue;
                            case 21:
                                c1Var.a(this.n.b(t, d(iG)));
                                continue;
                            case 22:
                                c1Var.o(this.n.b(t, d(iG)));
                                continue;
                            case 23:
                                c1Var.n(this.n.b(t, d(iG)));
                                continue;
                            case 24:
                                c1Var.e(this.n.b(t, d(iG)));
                                continue;
                            case 25:
                                c1Var.l(this.n.b(t, d(iG)));
                                continue;
                            case 26:
                                b(t, iG, c1Var);
                                continue;
                            case 27:
                                a((Object) t, iG, c1Var, (d1) c(iE), qVar);
                                continue;
                            case 28:
                                c1Var.h(this.n.b(t, d(iG)));
                                continue;
                            case 29:
                                c1Var.i(this.n.b(t, d(iG)));
                                continue;
                            case 30:
                                List<Integer> listB = this.n.b(t, d(iG));
                                c1Var.p(listB);
                                objA = f1.a(iS, listB, a(iE), objA2, k1Var);
                                break;
                            case 31:
                                c1Var.f(this.n.b(t, d(iG)));
                                continue;
                            case 32:
                                c1Var.m(this.n.b(t, d(iG)));
                                continue;
                            case 33:
                                c1Var.c(this.n.b(t, d(iG)));
                                continue;
                            case 34:
                                c1Var.g(this.n.b(t, d(iG)));
                                continue;
                            case 35:
                                c1Var.j(this.n.b(t, d(iG)));
                                continue;
                            case 36:
                                c1Var.d(this.n.b(t, d(iG)));
                                continue;
                            case 37:
                                c1Var.k(this.n.b(t, d(iG)));
                                continue;
                            case 38:
                                c1Var.a(this.n.b(t, d(iG)));
                                continue;
                            case 39:
                                c1Var.o(this.n.b(t, d(iG)));
                                continue;
                            case 40:
                                c1Var.n(this.n.b(t, d(iG)));
                                continue;
                            case 41:
                                c1Var.e(this.n.b(t, d(iG)));
                                continue;
                            case 42:
                                c1Var.l(this.n.b(t, d(iG)));
                                continue;
                            case 43:
                                c1Var.i(this.n.b(t, d(iG)));
                                continue;
                            case 44:
                                List<Integer> listB2 = this.n.b(t, d(iG));
                                c1Var.p(listB2);
                                objA = f1.a(iS, listB2, a(iE), objA2, k1Var);
                                break;
                            case 45:
                                c1Var.f(this.n.b(t, d(iG)));
                                continue;
                            case 46:
                                c1Var.m(this.n.b(t, d(iG)));
                                continue;
                            case 47:
                                c1Var.c(this.n.b(t, d(iG)));
                                continue;
                            case 48:
                                c1Var.g(this.n.b(t, d(iG)));
                                continue;
                            case 49:
                                a(t, d(iG), c1Var, c(iE), qVar);
                                continue;
                            case 50:
                                a(t, iE, b(iE), qVar, c1Var);
                                continue;
                            case 51:
                                p1.a(t, d(iG), Double.valueOf(c1Var.h()));
                                b(t, iS, iE);
                                continue;
                            case 52:
                                p1.a(t, d(iG), Float.valueOf(c1Var.k()));
                                b(t, iS, iE);
                                continue;
                            case 53:
                                p1.a(t, d(iG), Long.valueOf(c1Var.o()));
                                b(t, iS, iE);
                                continue;
                            case 54:
                                p1.a(t, d(iG), Long.valueOf(c1Var.f()));
                                b(t, iS, iE);
                                continue;
                            case 55:
                                p1.a(t, d(iG), Integer.valueOf(c1Var.d()));
                                b(t, iS, iE);
                                continue;
                            case 56:
                                p1.a(t, d(iG), Long.valueOf(c1Var.g()));
                                b(t, iS, iE);
                                continue;
                            case 57:
                                p1.a(t, d(iG), Integer.valueOf(c1Var.q()));
                                b(t, iS, iE);
                                continue;
                            case 58:
                                p1.a(t, d(iG), Boolean.valueOf(c1Var.r()));
                                b(t, iS, iE);
                                continue;
                            case 59:
                                a(t, iG, c1Var);
                                b(t, iS, iE);
                                continue;
                            case 60:
                                if (a(t, iS, iE)) {
                                    p1.a(t, d(iG), y.a(p1.g(t, d(iG)), c1Var.b(c(iE), qVar)));
                                } else {
                                    p1.a(t, d(iG), c1Var.b(c(iE), qVar));
                                    b((Object) t, iE);
                                }
                                b(t, iS, iE);
                                continue;
                            case 61:
                                p1.a(t, d(iG), c1Var.a());
                                b(t, iS, iE);
                                continue;
                            case 62:
                                p1.a(t, d(iG), Integer.valueOf(c1Var.c()));
                                b(t, iS, iE);
                                continue;
                            case 63:
                                int iB2 = c1Var.b();
                                y.e eVarA2 = a(iE);
                                if (eVarA2 != null && !eVarA2.a(iB2)) {
                                    objA = f1.a(iS, iB2, objA2, k1Var);
                                } else {
                                    p1.a(t, d(iG), Integer.valueOf(iB2));
                                    b(t, iS, iE);
                                }
                                break;
                            case 64:
                                p1.a(t, d(iG), Integer.valueOf(c1Var.m()));
                                b(t, iS, iE);
                                continue;
                            case 65:
                                p1.a(t, d(iG), Long.valueOf(c1Var.t()));
                                b(t, iS, iE);
                                continue;
                            case 66:
                                p1.a(t, d(iG), Integer.valueOf(c1Var.j()));
                                b(t, iS, iE);
                                continue;
                            case 67:
                                p1.a(t, d(iG), Long.valueOf(c1Var.l()));
                                b(t, iS, iE);
                                continue;
                            case 68:
                                p1.a(t, d(iG), c1Var.a(c(iE), qVar));
                                b(t, iS, iE);
                                continue;
                            default:
                                if (objA2 == null) {
                                    objA2 = k1Var.a();
                                }
                                if (!k1Var.a(objA2, c1Var)) {
                                    for (int i2 = this.k; i2 < this.l; i2++) {
                                        objA2 = a(t, this.j[i2], objA2, k1Var);
                                    }
                                    if (objA2 != null) {
                                        k1Var.b(t, objA2);
                                        return;
                                    }
                                    return;
                                }
                                continue;
                                break;
                        }
                        objA2 = objA;
                    } catch (z.a unused) {
                        if (k1Var.a(c1Var)) {
                            if (!c1Var.i()) {
                                for (int i3 = this.k; i3 < this.l; i3++) {
                                    objA2 = a(t, this.j[i3], objA2, k1Var);
                                }
                                if (objA2 != null) {
                                    k1Var.b(t, objA2);
                                    return;
                                }
                                return;
                            }
                        } else {
                            if (objA2 == null) {
                                objA2 = k1Var.a(t);
                            }
                            if (!k1Var.a(objA2, c1Var)) {
                                for (int i4 = this.k; i4 < this.l; i4++) {
                                    objA2 = a(t, this.j[i4], objA2, k1Var);
                                }
                                if (objA2 != null) {
                                    k1Var.b(t, objA2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.k; i5 < this.l; i5++) {
                    objA2 = a(t, this.j[i5], objA2, k1Var);
                }
                if (objA2 != null) {
                    k1Var.b(t, objA2);
                }
                throw th;
            }
        }
        for (int i6 = this.k; i6 < this.l; i6++) {
            objA2 = a(t, this.j[i6], objA2, k1Var);
        }
        if (objA2 != null) {
            k1Var.b(t, objA2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    public final void b(T t, s1 s1Var) throws IOException {
        Iterator itF;
        Map.Entry<?, ?> entry;
        if (this.f) {
            u<T> uVarA = this.p.a(t);
            if (uVarA.a.isEmpty()) {
                itF = null;
                entry = null;
            } else {
                itF = uVarA.f();
                entry = (Map.Entry) itF.next();
            }
        } else {
            itF = null;
            entry = null;
        }
        int length = this.a.length;
        for (int i = 0; i < length; i += 3) {
            int iG = g(i);
            int i2 = this.a[i];
            while (entry != null && this.p.a(entry) <= i2) {
                this.p.a(s1Var, entry);
                entry = itF.hasNext() ? (Map.Entry) itF.next() : null;
            }
            switch (f(iG)) {
                case 0:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a(i2, p1.e.c(t, d(iG)));
                    }
                    break;
                case 1:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a(i2, p1.e.d(t, d(iG)));
                    }
                    break;
                case 2:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.g(i2, p1.f(t, d(iG)));
                    }
                    break;
                case 3:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.g(i2, p1.f(t, d(iG)));
                    }
                    break;
                case 4:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.h(i2, p1.e(t, d(iG)));
                    }
                    break;
                case 5:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.f(i2, p1.f(t, d(iG)));
                    }
                    break;
                case 6:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.g(i2, p1.e(t, d(iG)));
                    }
                    break;
                case 7:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.b(i2, p1.e.a(t, d(iG)));
                    }
                    break;
                case 8:
                    if (a((Object) t, i)) {
                        a(i2, p1.g(t, d(iG)), s1Var);
                    }
                    break;
                case 9:
                    if (a((Object) t, i)) {
                        ((m) s1Var).b(i2, p1.g(t, d(iG)), c(i));
                    }
                    break;
                case 10:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.b(i2, (i) p1.g(t, d(iG)));
                    }
                    break;
                case 11:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.j(i2, p1.e(t, d(iG)));
                    }
                    break;
                case 12:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.h(i2, p1.e(t, d(iG)));
                    }
                    break;
                case 13:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.g(i2, p1.e(t, d(iG)));
                    }
                    break;
                case 14:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a.f(i2, p1.f(t, d(iG)));
                    }
                    break;
                case 15:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a(i2, p1.e(t, d(iG)));
                    }
                    break;
                case 16:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a(i2, p1.f(t, d(iG)));
                    }
                    break;
                case 17:
                    if (a((Object) t, i)) {
                        ((m) s1Var).a(i2, p1.g(t, d(iG)), c(i));
                    }
                    break;
                case 18:
                    f1.b(this.a[i], (List<Double>) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 19:
                    f1.f(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 20:
                    f1.h(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 21:
                    f1.n(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 22:
                    f1.g(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 23:
                    f1.e(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 24:
                    f1.d(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 25:
                    f1.a(this.a[i], (List<Boolean>) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 26:
                    f1.b(this.a[i], (List<String>) p1.g(t, d(iG)), s1Var);
                    break;
                case 27:
                    f1.b(this.a[i], (List<?>) p1.g(t, d(iG)), s1Var, c(i));
                    break;
                case 28:
                    f1.a(this.a[i], (List<i>) p1.g(t, d(iG)), s1Var);
                    break;
                case 29:
                    f1.m(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 30:
                    f1.c(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 31:
                    f1.i(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 32:
                    f1.j(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 33:
                    f1.k(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 34:
                    f1.l(this.a[i], (List) p1.g(t, d(iG)), s1Var, false);
                    break;
                case 35:
                    f1.b(this.a[i], (List<Double>) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 36:
                    f1.f(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 37:
                    f1.h(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 38:
                    f1.n(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 39:
                    f1.g(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 40:
                    f1.e(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 41:
                    f1.d(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 42:
                    f1.a(this.a[i], (List<Boolean>) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 43:
                    f1.m(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 44:
                    f1.c(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 45:
                    f1.i(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 46:
                    f1.j(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 47:
                    f1.k(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 48:
                    f1.l(this.a[i], (List) p1.g(t, d(iG)), s1Var, true);
                    break;
                case 49:
                    f1.a(this.a[i], (List<?>) p1.g(t, d(iG)), s1Var, c(i));
                    break;
                case 50:
                    a(s1Var, i2, p1.g(t, d(iG)), i);
                    break;
                case 51:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a(i2, b(t, d(iG)));
                    }
                    break;
                case 52:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a(i2, c(t, d(iG)));
                    }
                    break;
                case 53:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.g(i2, e(t, d(iG)));
                    }
                    break;
                case 54:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.g(i2, e(t, d(iG)));
                    }
                    break;
                case 55:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.h(i2, d(t, d(iG)));
                    }
                    break;
                case 56:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.f(i2, e(t, d(iG)));
                    }
                    break;
                case 57:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.g(i2, d(t, d(iG)));
                    }
                    break;
                case 58:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.b(i2, a(t, d(iG)));
                    }
                    break;
                case 59:
                    if (a(t, i2, i)) {
                        a(i2, p1.g(t, d(iG)), s1Var);
                    }
                    break;
                case 60:
                    if (a(t, i2, i)) {
                        ((m) s1Var).b(i2, p1.g(t, d(iG)), c(i));
                    }
                    break;
                case 61:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.b(i2, (i) p1.g(t, d(iG)));
                    }
                    break;
                case 62:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.j(i2, d(t, d(iG)));
                    }
                    break;
                case 63:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.h(i2, d(t, d(iG)));
                    }
                    break;
                case 64:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.g(i2, d(t, d(iG)));
                    }
                    break;
                case 65:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a.f(i2, e(t, d(iG)));
                    }
                    break;
                case 66:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a(i2, d(t, d(iG)));
                    }
                    break;
                case 67:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a(i2, e(t, d(iG)));
                    }
                    break;
                case 68:
                    if (a(t, i2, i)) {
                        ((m) s1Var).a(i2, p1.g(t, d(iG)), c(i));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.p.a(s1Var, entry);
            entry = itF.hasNext() ? (Map.Entry) itF.next() : null;
        }
        k1<?, ?> k1Var = this.o;
        k1Var.b(k1Var.b(t), s1Var);
    }

    public final Object b(int i) {
        return this.f1305b[(i / 3) * 2];
    }

    public final void b(Object obj, int i, c1 c1Var) throws IOException {
        if ((536870912 & i) != 0) {
            c1Var.b(this.n.b(obj, d(i)));
        } else {
            c1Var.q(this.n.b(obj, d(i)));
        }
    }

    public final void b(T t, T t2, int i) {
        int[] iArr = this.a;
        int i2 = iArr[i + 1];
        int i3 = iArr[i];
        long jD = d(i2);
        if (a(t2, i3, i)) {
            Object objG = a(t, i3, i) ? p1.g(t, jD) : null;
            Object objG2 = p1.g(t2, jD);
            if (objG != null && objG2 != null) {
                p1.a(t, jD, y.a(objG, objG2));
                b(t, i3, i);
            } else if (objG2 != null) {
                p1.a(t, jD, objG2);
                b(t, i3, i);
            }
        }
    }

    public final void b(T t, int i) {
        int i2 = this.a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        p1.a((Object) t, j, (1 << (i2 >>> 20)) | p1.e(t, j));
    }

    public final void b(T t, int i, int i2) {
        p1.a((Object) t, this.a[i2 + 2] & 1048575, i);
    }

    public static <T> double b(T t, long j) {
        return ((Double) p1.g(t, j)).doubleValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, e.b bVar) throws IOException {
        int iA;
        int iD = i;
        Unsafe unsafe = s;
        y.j jVarB = (y.j) unsafe.getObject(t, j2);
        if (!jVarB.d()) {
            int size = jVarB.size();
            jVarB = jVarB.b(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j2, jVarB);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return e.b(bArr, iD, jVarB, bVar);
                }
                if (i5 == 1) {
                    n nVar = (n) jVarB;
                    nVar.a(Double.longBitsToDouble(e.b(bArr, i)));
                    while (true) {
                        int i8 = iD + 8;
                        if (i8 >= i2) {
                            return i8;
                        }
                        iD = e.d(bArr, i8, bVar);
                        if (i3 != bVar.a) {
                            return i8;
                        }
                        nVar.a(Double.longBitsToDouble(e.b(bArr, iD)));
                    }
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    return e.e(bArr, iD, jVarB, bVar);
                }
                if (i5 == 5) {
                    v vVar = (v) jVarB;
                    vVar.a(Float.intBitsToFloat(e.a(bArr, i)));
                    while (true) {
                        int i9 = iD + 4;
                        if (i9 >= i2) {
                            return i9;
                        }
                        iD = e.d(bArr, i9, bVar);
                        if (i3 != bVar.a) {
                            return i9;
                        }
                        vVar.a(Float.intBitsToFloat(e.a(bArr, iD)));
                    }
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return e.i(bArr, iD, jVarB, bVar);
                }
                if (i5 == 0) {
                    f0 f0Var = (f0) jVarB;
                    int iE = e.e(bArr, iD, bVar);
                    f0Var.a(bVar.f1280b);
                    while (iE < i2) {
                        int iD2 = e.d(bArr, iE, bVar);
                        if (i3 != bVar.a) {
                            return iE;
                        }
                        iE = e.e(bArr, iD2, bVar);
                        f0Var.a(bVar.f1280b);
                    }
                    return iE;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return e.h(bArr, iD, jVarB, bVar);
                }
                if (i5 == 0) {
                    return e.a(i3, bArr, i, i2, (y.j<?>) jVarB, bVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return e.d(bArr, iD, jVarB, bVar);
                }
                if (i5 == 1) {
                    f0 f0Var2 = (f0) jVarB;
                    f0Var2.a(e.b(bArr, i));
                    while (true) {
                        int i10 = iD + 8;
                        if (i10 >= i2) {
                            return i10;
                        }
                        iD = e.d(bArr, i10, bVar);
                        if (i3 != bVar.a) {
                            return i10;
                        }
                        f0Var2.a(e.b(bArr, iD));
                    }
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return e.c(bArr, iD, jVarB, bVar);
                }
                if (i5 == 5) {
                    x xVar = (x) jVarB;
                    xVar.c(e.a(bArr, i));
                    while (true) {
                        int i11 = iD + 4;
                        if (i11 >= i2) {
                            return i11;
                        }
                        iD = e.d(bArr, i11, bVar);
                        if (i3 != bVar.a) {
                            return i11;
                        }
                        xVar.c(e.a(bArr, iD));
                    }
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    return e.a(bArr, iD, (y.j<?>) jVarB, bVar);
                }
                if (i5 == 0) {
                    g gVar = (g) jVarB;
                    int iE2 = e.e(bArr, iD, bVar);
                    gVar.a(bVar.f1280b != 0);
                    while (iE2 < i2) {
                        int iD3 = e.d(bArr, iE2, bVar);
                        if (i3 != bVar.a) {
                            return iE2;
                        }
                        iE2 = e.e(bArr, iD3, bVar);
                        gVar.a(bVar.f1280b != 0);
                    }
                    return iE2;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iD4 = e.d(bArr, iD, bVar);
                        int i12 = bVar.a;
                        if (i12 < 0) {
                            throw z.f();
                        }
                        if (i12 == 0) {
                            jVarB.add("");
                        } else {
                            jVarB.add(new String(bArr, iD4, i12, y.a));
                            iD4 += i12;
                        }
                        while (iD4 < i2) {
                            int iD5 = e.d(bArr, iD4, bVar);
                            if (i3 != bVar.a) {
                                return iD4;
                            }
                            iD4 = e.d(bArr, iD5, bVar);
                            int i13 = bVar.a;
                            if (i13 < 0) {
                                throw z.f();
                            }
                            if (i13 == 0) {
                                jVarB.add("");
                            } else {
                                jVarB.add(new String(bArr, iD4, i13, y.a));
                                iD4 += i13;
                            }
                        }
                        return iD4;
                    }
                    int iD6 = e.d(bArr, iD, bVar);
                    int i14 = bVar.a;
                    if (i14 < 0) {
                        throw z.f();
                    }
                    if (i14 == 0) {
                        jVarB.add("");
                    } else {
                        int i15 = iD6 + i14;
                        if (q1.b(bArr, iD6, i15)) {
                            jVarB.add(new String(bArr, iD6, i14, y.a));
                            iD6 = i15;
                        } else {
                            throw z.c();
                        }
                    }
                    while (iD6 < i2) {
                        int iD7 = e.d(bArr, iD6, bVar);
                        if (i3 != bVar.a) {
                            return iD6;
                        }
                        iD6 = e.d(bArr, iD7, bVar);
                        int i16 = bVar.a;
                        if (i16 < 0) {
                            throw z.f();
                        }
                        if (i16 == 0) {
                            jVarB.add("");
                        } else {
                            int i17 = iD6 + i16;
                            if (q1.b(bArr, iD6, i17)) {
                                jVarB.add(new String(bArr, iD6, i16, y.a));
                                iD6 = i17;
                            } else {
                                throw z.c();
                            }
                        }
                    }
                    return iD6;
                }
                break;
            case 27:
                if (i5 == 2) {
                    return e.a(c(i6), i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iD8 = e.d(bArr, iD, bVar);
                    int i18 = bVar.a;
                    if (i18 >= 0) {
                        if (i18 > bArr.length - iD8) {
                            throw z.i();
                        }
                        if (i18 == 0) {
                            jVarB.add(i.f1293b);
                        } else {
                            jVarB.add(i.a(bArr, iD8, i18));
                            iD8 += i18;
                        }
                        while (iD8 < i2) {
                            int iD9 = e.d(bArr, iD8, bVar);
                            if (i3 != bVar.a) {
                                return iD8;
                            }
                            iD8 = e.d(bArr, iD9, bVar);
                            int i19 = bVar.a;
                            if (i19 >= 0) {
                                if (i19 > bArr.length - iD8) {
                                    throw z.i();
                                }
                                if (i19 == 0) {
                                    jVarB.add(i.f1293b);
                                } else {
                                    jVarB.add(i.a(bArr, iD8, i19));
                                    iD8 += i19;
                                }
                            } else {
                                throw z.f();
                            }
                        }
                        return iD8;
                    }
                    throw z.f();
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iA = e.h(bArr, iD, jVarB, bVar);
                } else if (i5 == 0) {
                    iA = e.a(i3, bArr, i, i2, (y.j<?>) jVarB, bVar);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                l1 l1Var = generatedMessageLite.unknownFields;
                if (l1Var == l1.f) {
                    l1Var = null;
                }
                l1 l1Var2 = (l1) f1.a(i4, (List<Integer>) jVarB, a(i6), l1Var, (k1<UT, l1>) this.o);
                if (l1Var2 != null) {
                    generatedMessageLite.unknownFields = l1Var2;
                }
                return iA;
            case 33:
            case 47:
                if (i5 == 2) {
                    return e.f(bArr, iD, jVarB, bVar);
                }
                if (i5 == 0) {
                    x xVar2 = (x) jVarB;
                    int iD10 = e.d(bArr, iD, bVar);
                    xVar2.c(j.b(bVar.a));
                    while (iD10 < i2) {
                        int iD11 = e.d(bArr, iD10, bVar);
                        if (i3 != bVar.a) {
                            return iD10;
                        }
                        iD10 = e.d(bArr, iD11, bVar);
                        xVar2.c(j.b(bVar.a));
                    }
                    return iD10;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    return e.g(bArr, iD, jVarB, bVar);
                }
                if (i5 == 0) {
                    f0 f0Var3 = (f0) jVarB;
                    int iE3 = e.e(bArr, iD, bVar);
                    f0Var3.a(j.a(bVar.f1280b));
                    while (iE3 < i2) {
                        int iD12 = e.d(bArr, iE3, bVar);
                        if (i3 != bVar.a) {
                            return iE3;
                        }
                        iE3 = e.e(bArr, iD12, bVar);
                        f0Var3.a(j.a(bVar.f1280b));
                    }
                    return iE3;
                }
                break;
            case 49:
                if (i5 == 3) {
                    d1 d1VarC = c(i6);
                    int i20 = (i3 & (-8)) | 4;
                    iD = e.a(d1VarC, bArr, i, i2, i20, bVar);
                    jVarB.add(bVar.c);
                    while (iD < i2) {
                        int iD13 = e.d(bArr, iD, bVar);
                        if (i3 == bVar.a) {
                            iD = e.a(d1VarC, bArr, iD13, i2, i20, bVar);
                            jVarB.add(bVar.c);
                        }
                    }
                }
                break;
        }
        return iD;
    }

    public final <K, V> int a(T t, byte[] bArr, int i, int i2, int i3, long j, e.b bVar) throws IOException {
        Unsafe unsafe = s;
        Object obj = this.f1305b[(i3 / 3) * 2];
        Object object = unsafe.getObject(t, j);
        if (this.q.d(object)) {
            Object objB = this.q.b(obj);
            this.q.a(objB, object);
            unsafe.putObject(t, j, objB);
            object = objB;
        }
        this.q.f(obj);
        this.q.c(object);
        int iD = e.d(bArr, i, bVar);
        int i4 = bVar.a;
        if (i4 >= 0 && i4 <= i2 - iD) {
            throw null;
        }
        throw z.i();
    }

    public final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, e.b bVar) throws IOException {
        Unsafe unsafe = s;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(Double.longBitsToDouble(e.b(bArr, i))));
                int i9 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(Float.intBitsToFloat(e.a(bArr, i))));
                int i10 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iE = e.e(bArr, i, bVar);
                unsafe.putObject(t, j, Long.valueOf(bVar.f1280b));
                unsafe.putInt(t, j2, i4);
                return iE;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iD = e.d(bArr, i, bVar);
                unsafe.putObject(t, j, Integer.valueOf(bVar.a));
                unsafe.putInt(t, j2, i4);
                return iD;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(e.b(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(e.a(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iE2 = e.e(bArr, i, bVar);
                unsafe.putObject(t, j, Boolean.valueOf(bVar.f1280b != 0));
                unsafe.putInt(t, j2, i4);
                return iE2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iD2 = e.d(bArr, i, bVar);
                int i13 = bVar.a;
                if (i13 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !q1.b(bArr, iD2, iD2 + i13)) {
                        throw z.c();
                    }
                    unsafe.putObject(t, j, new String(bArr, iD2, i13, y.a));
                    iD2 += i13;
                }
                unsafe.putInt(t, j2, i4);
                return iD2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iA = e.a(c(i8), bArr, i, i2, bVar);
                Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, bVar.c);
                } else {
                    unsafe.putObject(t, j, y.a(object, bVar.c));
                }
                unsafe.putInt(t, j2, i4);
                return iA;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iA2 = e.a(bArr, i, bVar);
                unsafe.putObject(t, j, bVar.c);
                unsafe.putInt(t, j2, i4);
                return iA2;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iD3 = e.d(bArr, i, bVar);
                int i14 = bVar.a;
                y.e eVarA = a(i8);
                if (eVarA != null && !eVarA.a(i14)) {
                    e(t).a(i3, Long.valueOf(i14));
                } else {
                    unsafe.putObject(t, j, Integer.valueOf(i14));
                    unsafe.putInt(t, j2, i4);
                }
                return iD3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iD4 = e.d(bArr, i, bVar);
                unsafe.putObject(t, j, Integer.valueOf(j.b(bVar.a)));
                unsafe.putInt(t, j2, i4);
                return iD4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iE3 = e.e(bArr, i, bVar);
                unsafe.putObject(t, j, Long.valueOf(j.a(bVar.f1280b)));
                unsafe.putInt(t, j2, i4);
                return iE3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                int iA3 = e.a(c(i8), bArr, i, i2, (i3 & (-8)) | 4, bVar);
                Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object2 == null) {
                    unsafe.putObject(t, j, bVar.c);
                } else {
                    unsafe.putObject(t, j, y.a(object2, bVar.c));
                }
                unsafe.putInt(t, j2, i4);
                return iA3;
            default:
                return i;
        }
    }

    public final y.e a(int i) {
        return (y.e) this.f1305b[((i / 3) * 2) + 1];
    }

    /* JADX WARN: Code duplicated, block: B:136:0x03dd A[PHI: r0 r21 r24 r27 r33
      0x03dd: PHI (r0v14 int) = (r0v11 int), (r0v18 int) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x03dd: PHI (r21v2 int) = (r21v1 int), (r21v4 int) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x03dd: PHI (r24v1 int) = (r24v0 int), (r24v3 int) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x03dd: PHI (r27v3 sun.misc.Unsafe) = (r27v2 sun.misc.Unsafe), (r27v5 sun.misc.Unsafe) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x03dd: PHI (r33v2 int) = (r33v1 int), (r33v4 int) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:137:0x03f1 A[PHI: r0 r21 r24 r27 r33
      0x03f1: PHI (r0v15 int) = (r0v11 int), (r0v18 int) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x03f1: PHI (r21v3 int) = (r21v1 int), (r21v4 int) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x03f1: PHI (r24v2 int) = (r24v0 int), (r24v3 int) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x03f1: PHI (r27v4 sun.misc.Unsafe) = (r27v2 sun.misc.Unsafe), (r27v5 sun.misc.Unsafe) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]
      0x03f1: PHI (r33v3 int) = (r33v1 int), (r33v4 int) binds: [B:135:0x03db, B:124:0x038f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v44, types: [com.fyber.inneractive.sdk.protobuf.p1$d] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v46 */
    /* JADX WARN: Type inference failed for: r13v47 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r1v25, types: [com.fyber.inneractive.sdk.protobuf.p1$d] */
    /* JADX WARN: Type inference failed for: r31v1, types: [T] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public int a(T t, byte[] bArr, int i, int i2, int i3, e.b bVar) throws IOException {
        ?? r13;
        r0<T> r0Var;
        int i4;
        int iE;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        T t2;
        e.b bVar2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        r0<T> r0Var2 = this;
        ?? r14 = t;
        int i20 = i3;
        e.b bVar3 = bVar;
        Unsafe unsafe = s;
        int iA = i;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        int i25 = 1048575;
        while (true) {
            if (iA < i2) {
                int i26 = iA + 1;
                int i27 = bArr[iA];
                if (i27 < 0) {
                    int iA2 = e.a(i27, bArr, i26, bVar3);
                    i4 = bVar3.a;
                    i26 = iA2;
                } else {
                    i4 = i27;
                }
                int i28 = i4 >>> 3;
                int i29 = i4 & 7;
                if (i28 > i24) {
                    iE = (i28 < r0Var2.c || i28 > r0Var2.d) ? -1 : r0Var2.a(i28, i21 / 3);
                } else {
                    iE = r0Var2.e(i28);
                }
                int i30 = iE;
                if (i30 == -1) {
                    i9 = i28;
                    i13 = i26;
                    i12 = i4;
                    i6 = i23;
                    i7 = i25;
                    unsafe = unsafe;
                    i3 = i20;
                    i11 = 0;
                } else {
                    int i31 = r0Var2.a[i30 + 1];
                    int iF = f(i31);
                    long jD = d(i31);
                    int i32 = i4;
                    if (iF <= 17) {
                        int i33 = r0Var2.a[i30 + 2];
                        int i34 = 1 << (i33 >>> 20);
                        int i35 = i33 & 1048575;
                        if (i35 != i25) {
                            if (i25 != 1048575) {
                                unsafe.putInt((Object) r14, i25, i23);
                            }
                            i23 = unsafe.getInt((Object) r14, i35);
                            i14 = i35;
                        } else {
                            i14 = i25;
                        }
                        int i36 = i23;
                        switch (iF) {
                            case 0:
                                i15 = i28;
                                i16 = i26;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 1) {
                                    i18 = i16;
                                    p1.e.a(t, jD, Double.longBitsToDouble(e.b(bArr, i16)));
                                    iA = i18 + 8;
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i16;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 1:
                                i15 = i28;
                                i16 = i26;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 5) {
                                    p1.e.a(r14, jD, Float.intBitsToFloat(e.a(bArr, i16)));
                                    iA = i16 + 4;
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i16;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 2:
                            case 3:
                                i15 = i28;
                                i16 = i26;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 0) {
                                    int iE2 = e.e(bArr, i16, bVar3);
                                    unsafe.putLong(t, jD, bVar3.f1280b);
                                    iA = iE2;
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i16;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 4:
                            case 11:
                                i15 = i28;
                                i16 = i26;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 0) {
                                    iA = e.d(bArr, i16, bVar3);
                                    unsafe.putInt((Object) r14, jD, bVar3.a);
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i16;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 5:
                            case 14:
                                i15 = i28;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 1) {
                                    i18 = i26;
                                    unsafe.putLong(t, jD, e.b(bArr, i26));
                                    iA = i18 + 8;
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i26;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 6:
                            case 13:
                                i15 = i28;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 5) {
                                    unsafe.putInt((Object) r14, jD, e.a(bArr, i26));
                                    iA = i26 + 4;
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i26;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 7:
                                i15 = i28;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 0) {
                                    int iE3 = e.e(bArr, i26, bVar3);
                                    p1.e.a(r14, jD, bVar3.f1280b != 0);
                                    iA = iE3;
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i26;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 8:
                                i15 = i28;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 2) {
                                    if ((i31 & 536870912) == 0) {
                                        iA = e.b(bArr, i26, bVar3);
                                    } else {
                                        iA = e.c(bArr, i26, bVar3);
                                    }
                                    unsafe.putObject((Object) r14, jD, bVar3.c);
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i26;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 9:
                                i15 = i28;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 2) {
                                    iA = e.a(r0Var2.c(i17), bArr, i26, i2, bVar3);
                                    if ((i36 & i34) == 0) {
                                        unsafe.putObject((Object) r14, jD, bVar3.c);
                                    } else {
                                        unsafe.putObject((Object) r14, jD, y.a(unsafe.getObject((Object) r14, jD), bVar3.c));
                                    }
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                } else {
                                    i19 = i26;
                                    i6 = i36;
                                    i13 = i19;
                                    i9 = i15;
                                    unsafe = unsafe;
                                    i11 = i17;
                                    i12 = i5;
                                    i7 = i14;
                                    i3 = i3;
                                }
                                break;
                            case 10:
                                i15 = i28;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 2) {
                                    iA = e.a(bArr, i26, bVar3);
                                    unsafe.putObject((Object) r14, jD, bVar3.c);
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i26;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 12:
                                i15 = i28;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 0) {
                                    iA = e.d(bArr, i26, bVar3);
                                    int i37 = bVar3.a;
                                    y.e eVarA = r0Var2.a(i17);
                                    if (eVarA != null && !eVarA.a(i37)) {
                                        e(t).a(i5, Long.valueOf(i37));
                                        i23 = i36;
                                    } else {
                                        unsafe.putInt((Object) r14, jD, i37);
                                        i23 = i36 | i34;
                                    }
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i26;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 15:
                                i15 = i28;
                                i17 = i30;
                                i5 = i32;
                                if (i29 == 0) {
                                    iA = e.d(bArr, i26, bVar3);
                                    unsafe.putInt((Object) r14, jD, j.b(bVar3.a));
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                }
                                i19 = i26;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                            case 16:
                                i15 = i28;
                                i5 = i32;
                                if (i29 == 0) {
                                    int iE4 = e.e(bArr, i26, bVar3);
                                    i17 = i30;
                                    unsafe.putLong(t, jD, j.a(bVar3.f1280b));
                                    iA = iE4;
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                } else {
                                    i17 = i30;
                                    i19 = i26;
                                    i6 = i36;
                                    i13 = i19;
                                    i9 = i15;
                                    unsafe = unsafe;
                                    i11 = i17;
                                    i12 = i5;
                                    i7 = i14;
                                    i3 = i3;
                                }
                                break;
                            case 17:
                                if (i29 == 3) {
                                    i15 = i28;
                                    i5 = i32;
                                    iA = e.a(r0Var2.c(i30), bArr, i26, i2, (i28 << 3) | 4, bVar);
                                    if ((i36 & i34) == 0) {
                                        unsafe.putObject((Object) r14, jD, bVar3.c);
                                    } else {
                                        unsafe.putObject((Object) r14, jD, y.a(unsafe.getObject((Object) r14, jD), bVar3.c));
                                    }
                                    i17 = i30;
                                    i23 = i36 | i34;
                                    i9 = i15;
                                    i21 = i17;
                                    i25 = i14;
                                    i3 = i3;
                                    bVar2 = bVar3;
                                    i12 = i5;
                                    t2 = r14;
                                } else {
                                    i15 = i28;
                                    i5 = i32;
                                    i17 = i30;
                                    i19 = i26;
                                    i6 = i36;
                                    i13 = i19;
                                    i9 = i15;
                                    unsafe = unsafe;
                                    i11 = i17;
                                    i12 = i5;
                                    i7 = i14;
                                    i3 = i3;
                                }
                                break;
                            default:
                                i15 = i28;
                                i19 = i26;
                                i17 = i30;
                                i5 = i32;
                                i6 = i36;
                                i13 = i19;
                                i9 = i15;
                                unsafe = unsafe;
                                i11 = i17;
                                i12 = i5;
                                i7 = i14;
                                i3 = i3;
                                break;
                        }
                    } else {
                        int i38 = i26;
                        i5 = i32;
                        if (iF != 27) {
                            i6 = i23;
                            i7 = i25;
                            if (iF <= 49) {
                                i9 = i28;
                                unsafe = unsafe;
                                i11 = i30;
                                i10 = i5;
                                iA = a(t, bArr, i38, i2, i5, i28, i29, i30, i31, iF, jD, bVar);
                                if (iA != i38) {
                                    r0Var2 = this;
                                    t2 = t;
                                    i9 = i9;
                                    i3 = i3;
                                    bVar2 = bVar;
                                    i23 = i6;
                                    i21 = i11;
                                    i25 = i7;
                                    i12 = i10;
                                } else {
                                    i13 = iA;
                                    i12 = i10;
                                }
                            } else {
                                i8 = i38;
                                i9 = i28;
                                unsafe = unsafe;
                                i10 = i5;
                                i11 = i30;
                                if (iF != 50) {
                                    iA = a(t, bArr, i8, i2, i10, i9, i29, i31, iF, jD, i11, bVar);
                                    if (iA != i8) {
                                        r0Var2 = this;
                                        t2 = t;
                                        i9 = i9;
                                        i3 = i3;
                                        bVar2 = bVar;
                                        i23 = i6;
                                        i21 = i11;
                                        i25 = i7;
                                        i12 = i10;
                                    } else {
                                        i13 = iA;
                                        i12 = i10;
                                    }
                                } else if (i29 == 2) {
                                    a(t, bArr, i8, i2, i11, jD, bVar);
                                    throw null;
                                }
                            }
                        } else if (i29 == 2) {
                            y.j jVarB = (y.j) unsafe.getObject((Object) r14, jD);
                            if (!jVarB.d()) {
                                int size = jVarB.size();
                                jVarB = jVarB.b(size == 0 ? 10 : size * 2);
                                unsafe.putObject((Object) r14, jD, jVarB);
                            }
                            iA = e.a(r0Var2.c(i30), i5, bArr, i38, i2, jVarB, bVar);
                            i9 = i28;
                            i21 = i30;
                            i23 = i23;
                            i25 = i25;
                            i3 = i3;
                            bVar2 = bVar3;
                            i12 = i5;
                            t2 = r14;
                        } else {
                            i6 = i23;
                            i7 = i25;
                            i8 = i38;
                            i9 = i28;
                            unsafe = unsafe;
                            i11 = i30;
                            i10 = i5;
                        }
                        i13 = i8;
                        i12 = i10;
                    }
                    i22 = i12;
                    r0Var2 = r0Var2;
                    bVar3 = bVar2;
                    i24 = i9;
                    r14 = t2;
                    unsafe = unsafe;
                    i20 = i3;
                }
                if (i12 != i3 || i3 == 0) {
                    r0Var2 = this;
                    if (r0Var2.f) {
                        bVar2 = bVar;
                        if (bVar2.d != q.a()) {
                            o0 o0Var = r0Var2.e;
                            k1<?, ?> k1Var = r0Var2.o;
                            i9 = i9;
                            GeneratedMessageLite.e<?, ?> eVar = bVar2.d.a.get(new q.a(o0Var, i9));
                            if (eVar == null) {
                                iA = e.a(i12, bArr, i13, i2, e(t), bVar);
                                t2 = t;
                            } else {
                                T t3 = t;
                                GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) t3;
                                extendableMessage.ensureExtensionsAreMutable();
                                iA = e.a(i12, bArr, i13, i2, extendableMessage, eVar, k1Var, bVar);
                                t2 = t3;
                            }
                        }
                        i23 = i6;
                        i21 = i11;
                        i25 = i7;
                        i22 = i12;
                        r0Var2 = r0Var2;
                        bVar3 = bVar2;
                        i24 = i9;
                        r14 = t2;
                        unsafe = unsafe;
                        i20 = i3;
                    } else {
                        bVar2 = bVar;
                    }
                    iA = e.a(i12, bArr, i13, i2, e(t), bVar);
                    t2 = t;
                    i23 = i6;
                    i21 = i11;
                    i25 = i7;
                    i22 = i12;
                    r0Var2 = r0Var2;
                    bVar3 = bVar2;
                    i24 = i9;
                    r14 = t2;
                    unsafe = unsafe;
                    i20 = i3;
                } else {
                    r0Var = this;
                    r13 = t;
                    iA = i13;
                    i22 = i12;
                    i23 = i6;
                    i25 = i7;
                }
            } else {
                unsafe = unsafe;
                i3 = i20;
                r13 = r14;
                r0Var = r0Var2;
            }
        }
        if (i25 != 1048575) {
            unsafe.putInt((Object) r13, i25, i23);
        }
        l1 l1Var = null;
        for (int i39 = r0Var.k; i39 < r0Var.l; i39++) {
            l1Var = (l1) r0Var.a((Object) r13, r0Var.j[i39], l1Var, (k1<UT, l1>) r0Var.o);
        }
        if (l1Var != null) {
            r0Var.o.b((Object) r13, l1Var);
        }
        if (i3 == 0) {
            if (iA != i2) {
                throw z.g();
            }
        } else if (iA > i2 || i22 != i3) {
            throw z.g();
        }
        return iA;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0302 A[PHI: r0 r18 r20 r24 r25 r28
      0x0302: PHI (r0v16 int) = (r0v12 int), (r0v19 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0302: PHI (r18v3 int) = (r18v2 int), (r18v5 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0302: PHI (r20v1 int) = (r20v0 int), (r20v3 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0302: PHI (r24v2 int) = (r24v1 int), (r24v4 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0302: PHI (r25v1 int) = (r25v0 int), (r25v3 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0302: PHI (r28v2 sun.misc.Unsafe) = (r28v1 sun.misc.Unsafe), (r28v4 sun.misc.Unsafe) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:124:0x0309 A[PHI: r0 r18 r20 r24 r25 r28
      0x0309: PHI (r0v17 int) = (r0v12 int), (r0v19 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0309: PHI (r18v4 int) = (r18v2 int), (r18v5 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0309: PHI (r20v2 int) = (r20v0 int), (r20v3 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0309: PHI (r24v3 int) = (r24v1 int), (r24v4 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0309: PHI (r25v2 int) = (r25v0 int), (r25v3 int) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]
      0x0309: PHI (r28v3 sun.misc.Unsafe) = (r28v1 sun.misc.Unsafe), (r28v4 sun.misc.Unsafe) binds: [B:122:0x0300, B:111:0x02aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x00a0. Please report as an issue. */
    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void a(T t, byte[] bArr, int i, int i2, e.b bVar) throws IOException {
        int i3;
        int iA;
        int iE;
        int i4;
        int i5;
        int i6;
        int i7;
        Unsafe unsafe;
        int i8;
        int i9;
        int i10;
        Unsafe unsafe2;
        int i11;
        int iE2;
        int iC;
        Unsafe unsafe3;
        r0<T> r0Var = this;
        T t2 = t;
        int i12 = i2;
        if (r0Var.h) {
            Unsafe unsafe4 = s;
            int i13 = -1;
            int iA2 = i;
            int i14 = -1;
            int i15 = 0;
            int i16 = 0;
            int i17 = 1048575;
            while (iA2 < i12) {
                int i18 = iA2 + 1;
                int i19 = bArr[iA2];
                if (i19 < 0) {
                    iA = e.a(i19, bArr, i18, bVar);
                    i3 = bVar.a;
                } else {
                    i3 = i19;
                    iA = i18;
                }
                int i20 = i3 >>> 3;
                int i21 = i3 & 7;
                if (i20 > i14) {
                    iE = (i20 < r0Var.c || i20 > r0Var.d) ? i13 : r0Var.a(i20, i15 / 3);
                } else {
                    iE = r0Var.e(i20);
                }
                int i22 = iE;
                if (i22 == i13) {
                    i10 = iA;
                    i4 = i20;
                    unsafe = unsafe4;
                    i9 = i13;
                    i8 = 0;
                } else {
                    int i23 = r0Var.a[i22 + 1];
                    int iF = f(i23);
                    Unsafe unsafe5 = unsafe4;
                    long jD = d(i23);
                    if (iF <= 17) {
                        int i24 = r0Var.a[i22 + 2];
                        int i25 = 1 << (i24 >>> 20);
                        int i26 = i24 & 1048575;
                        if (i26 != i17) {
                            if (i17 != 1048575) {
                                long j = i17;
                                unsafe3 = unsafe5;
                                unsafe3.putInt(t2, j, i16);
                            } else {
                                unsafe3 = unsafe5;
                            }
                            if (i26 != 1048575) {
                                i16 = unsafe3.getInt(t2, i26);
                            }
                            unsafe2 = unsafe3;
                            i17 = i26;
                        } else {
                            unsafe2 = unsafe5;
                        }
                        switch (iF) {
                            case 0:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 1) {
                                    p1.e.a(t, jD, Double.longBitsToDouble(e.b(bArr, iA)));
                                    iE2 = iA + 8;
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 1:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 5) {
                                    p1.e.a((Object) t2, jD, Float.intBitsToFloat(e.a(bArr, iA)));
                                    iE2 = iA + 4;
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 2:
                            case 3:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 0) {
                                    iE2 = e.e(bArr, iA, bVar);
                                    unsafe2.putLong(t, jD, bVar.f1280b);
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 4:
                            case 11:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 0) {
                                    iE2 = e.d(bArr, iA, bVar);
                                    unsafe2.putInt(t2, jD, bVar.a);
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 5:
                            case 14:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 1) {
                                    unsafe2.putLong(t, jD, e.b(bArr, iA));
                                    iE2 = iA + 8;
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 6:
                            case 13:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 5) {
                                    unsafe2.putInt(t2, jD, e.a(bArr, iA));
                                    iE2 = iA + 4;
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 7:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 0) {
                                    iE2 = e.e(bArr, iA, bVar);
                                    p1.e.a(t2, jD, bVar.f1280b != 0);
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 8:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 2) {
                                    if ((i23 & 536870912) == 0) {
                                        iC = e.b(bArr, iA, bVar);
                                    } else {
                                        iC = e.c(bArr, iA, bVar);
                                    }
                                    iE2 = iC;
                                    unsafe2.putObject(t2, jD, bVar.c);
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 9:
                                i11 = i22;
                                i4 = i20;
                                if (i21 != 2) {
                                    i10 = iA;
                                    unsafe = unsafe2;
                                    i8 = i11;
                                    i9 = -1;
                                } else {
                                    iE2 = e.a(r0Var.c(i11), bArr, iA, i2, bVar);
                                    Object object = unsafe2.getObject(t2, jD);
                                    if (object == null) {
                                        unsafe2.putObject(t2, jD, bVar.c);
                                    } else {
                                        unsafe2.putObject(t2, jD, y.a(object, bVar.c));
                                    }
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                break;
                            case 10:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 2) {
                                    iE2 = e.a(bArr, iA, bVar);
                                    unsafe2.putObject(t2, jD, bVar.c);
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 12:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 0) {
                                    iE2 = e.d(bArr, iA, bVar);
                                    unsafe2.putInt(t2, jD, bVar.a);
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 15:
                                i11 = i22;
                                i4 = i20;
                                if (i21 == 0) {
                                    iE2 = e.d(bArr, iA, bVar);
                                    unsafe2.putInt(t2, jD, j.b(bVar.a));
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                            case 16:
                                if (i21 != 0) {
                                    i11 = i22;
                                    i4 = i20;
                                    i10 = iA;
                                    unsafe = unsafe2;
                                    i8 = i11;
                                    i9 = -1;
                                } else {
                                    iE2 = e.e(bArr, iA, bVar);
                                    i11 = i22;
                                    i4 = i20;
                                    unsafe2.putLong(t, jD, j.a(bVar.f1280b));
                                    i16 |= i25;
                                    unsafe = unsafe2;
                                    i15 = i11;
                                    iA2 = iE2;
                                    i9 = -1;
                                }
                                break;
                            default:
                                i11 = i22;
                                i4 = i20;
                                i10 = iA;
                                unsafe = unsafe2;
                                i8 = i11;
                                i9 = -1;
                                break;
                        }
                    } else {
                        i4 = i20;
                        int i27 = iA;
                        if (iF == 27) {
                            if (i21 == 2) {
                                y.j jVarB = (y.j) unsafe5.getObject(t2, jD);
                                if (!jVarB.d()) {
                                    int size = jVarB.size();
                                    jVarB = jVarB.b(size == 0 ? 10 : size * 2);
                                    unsafe5.putObject(t2, jD, jVarB);
                                }
                                iA2 = e.a(r0Var.c(i22), i3, bArr, i27, i2, jVarB, bVar);
                                i16 = i16;
                                unsafe = unsafe5;
                                i15 = i22;
                                i9 = -1;
                            } else {
                                i5 = i27;
                                i6 = i16;
                                i7 = i17;
                                unsafe = unsafe5;
                                i8 = i22;
                                i9 = -1;
                            }
                        } else if (iF <= 49) {
                            i6 = i16;
                            i7 = i17;
                            unsafe = unsafe5;
                            i9 = -1;
                            i8 = i22;
                            iA2 = a(t, bArr, i27, i2, i3, i4, i21, i22, i23, iF, jD, bVar);
                            if (iA2 != i27) {
                                i15 = i8;
                                i16 = i6;
                                i17 = i7;
                            } else {
                                i10 = iA2;
                                i16 = i6;
                                i17 = i7;
                            }
                        } else {
                            i5 = i27;
                            i6 = i16;
                            i7 = i17;
                            unsafe = unsafe5;
                            i8 = i22;
                            i9 = -1;
                            if (iF != 50) {
                                iA2 = a(t, bArr, i5, i2, i3, i4, i21, i23, iF, jD, i8, bVar);
                                if (iA2 != i5) {
                                    i15 = i8;
                                    i16 = i6;
                                    i17 = i7;
                                } else {
                                    i10 = iA2;
                                    i16 = i6;
                                    i17 = i7;
                                }
                            } else if (i21 == 2) {
                                a(t, bArr, i5, i2, i8, jD, bVar);
                                throw null;
                            }
                        }
                        i10 = i5;
                        i16 = i6;
                        i17 = i7;
                    }
                    r0Var = this;
                    t2 = t;
                    i12 = i2;
                    i13 = i9;
                    i14 = i4;
                    unsafe4 = unsafe;
                }
                iA2 = e.a(i3, bArr, i10, i2, e(t), bVar);
                i15 = i8;
                r0Var = this;
                t2 = t;
                i12 = i2;
                i13 = i9;
                i14 = i4;
                unsafe4 = unsafe;
            }
            int i28 = i16;
            Unsafe unsafe6 = unsafe4;
            if (i17 != 1048575) {
                unsafe6.putInt(t, i17, i28);
            }
            if (iA2 != i2) {
                throw z.g();
            }
            return;
        }
        a(t, bArr, i, i2, 0, bVar);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d3 A[LOOP:1: B:52:0x00c1->B:57:0x00d3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:81:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public final boolean a(T t) {
        List list;
        d1 d1VarC;
        int i;
        boolean zA;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean zA2 = true;
            if (i3 >= this.k) {
                return !this.f || this.p.a(t).e();
            }
            int i5 = this.j[i3];
            int i6 = this.a[i5];
            int iG = g(i5);
            int i7 = this.a[i5 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i2) {
                if (i8 != 1048575) {
                    i4 = s.getInt(t, i8);
                }
                i2 = i8;
            }
            if ((268435456 & iG) != 0) {
                if (i2 == 1048575) {
                    zA = a((Object) t, i5);
                } else {
                    zA = (i4 & i9) != 0;
                }
                if (!zA) {
                    return false;
                }
            }
            int iF = f(iG);
            if (iF == 9 || iF == 17) {
                if (i2 == 1048575) {
                    zA2 = a((Object) t, i5);
                } else if ((i4 & i9) == 0) {
                    zA2 = false;
                }
                if (zA2 && !c(i5).a(p1.g(t, d(iG)))) {
                    return false;
                }
            } else if (iF == 27) {
                list = (List) p1.g(t, d(iG));
                if (!list.isEmpty()) {
                    d1VarC = c(i5);
                    for (i = 0; i < list.size(); i++) {
                        if (!d1VarC.a(list.get(i))) {
                            zA2 = false;
                            break;
                        }
                    }
                }
                if (!zA2) {
                    return false;
                }
            } else if (iF == 60 || iF == 68) {
                if (a(t, i6, i5) && !c(i5).a(p1.g(t, d(iG)))) {
                    return false;
                }
            } else if (iF != 49) {
                if (iF == 50 && !this.q.a(p1.g(t, d(iG))).isEmpty()) {
                    this.q.f(this.f1305b[(i5 / 3) * 2]);
                    throw null;
                }
            } else {
                list = (List) p1.g(t, d(iG));
                if (!list.isEmpty()) {
                    d1VarC = c(i5);
                    while (i < list.size()) {
                        if (!d1VarC.a(list.get(i))) {
                            zA2 = false;
                            break;
                        }
                    }
                }
                if (!zA2) {
                    return false;
                }
            }
            i3++;
        }
    }

    public final void a(int i, Object obj, s1 s1Var) throws IOException {
        if (obj instanceof String) {
            ((m) s1Var).a.b(i, (String) obj);
        } else {
            ((m) s1Var).a.b(i, (i) obj);
        }
    }

    public final void a(Object obj, int i, c1 c1Var) throws IOException {
        if ((536870912 & i) != 0) {
            p1.a(obj, d(i), c1Var.p());
        } else if (this.g) {
            p1.a(obj, d(i), c1Var.n());
        } else {
            p1.a(obj, d(i), c1Var.a());
        }
    }

    public final <E> void a(Object obj, int i, c1 c1Var, d1<E> d1Var, q qVar) throws IOException {
        c1Var.b(this.n.b(obj, d(i)), d1Var, qVar);
    }

    public final <E> void a(Object obj, long j, c1 c1Var, d1<E> d1Var, q qVar) throws IOException {
        c1Var.a(this.n.b(obj, j), d1Var, qVar);
    }

    public final <UT, UB> UB a(Object obj, int i, UB ub, k1<UT, UB> k1Var) {
        y.e eVarA;
        int[] iArr = this.a;
        int i2 = iArr[i];
        Object objG = p1.g(obj, d(iArr[i + 1]));
        if (objG == null || (eVarA = a(i)) == null) {
            return ub;
        }
        Map<?, ?> mapC = this.q.c(objG);
        this.q.f(this.f1305b[(i / 3) * 2]);
        for (Map.Entry<?, ?> entry : mapC.entrySet()) {
            if (!eVarA.a(((Integer) entry.getValue()).intValue())) {
                if (ub == null) {
                    k1Var.a();
                }
                entry.getKey();
                entry.getValue();
                throw null;
            }
        }
        return ub;
    }

    public final <K, V> void a(Object obj, int i, Object obj2, q qVar, c1 c1Var) throws IOException {
        long jD = d(this.a[i + 1]);
        Object objG = p1.g(obj, jD);
        if (objG == null) {
            objG = this.q.b(obj2);
            p1.a(obj, jD, objG);
        } else if (this.q.d(objG)) {
            Object objB = this.q.b(obj2);
            this.q.a(objB, objG);
            p1.a(obj, jD, objB);
            objG = objB;
        }
        Map<?, ?> mapC = this.q.c(objG);
        this.q.f(obj2);
        c1Var.a(mapC, (h0.a) null, qVar);
    }

    public final void a(T t, T t2, int i) {
        long jD = d(this.a[i + 1]);
        if (a((Object) t2, i)) {
            Object objG = p1.g(t, jD);
            Object objG2 = p1.g(t2, jD);
            if (objG != null && objG2 != null) {
                p1.a(t, jD, y.a(objG, objG2));
                b((Object) t, i);
            } else if (objG2 != null) {
                p1.a(t, jD, objG2);
                b((Object) t, i);
            }
        }
    }

    public final boolean a(T t, int i) {
        int[] iArr = this.a;
        int i2 = iArr[i + 2];
        long j = 1048575 & i2;
        if (j != 1048575) {
            return (p1.e(t, j) & (1 << (i2 >>> 20))) != 0;
        }
        int i3 = iArr[i + 1];
        long jD = d(i3);
        switch (f(i3)) {
            case 0:
                return p1.e.c(t, jD) != 0.0d;
            case 1:
                return p1.e.d(t, jD) != 0.0f;
            case 2:
                return p1.f(t, jD) != 0;
            case 3:
                return p1.f(t, jD) != 0;
            case 4:
                return p1.e(t, jD) != 0;
            case 5:
                return p1.f(t, jD) != 0;
            case 6:
                return p1.e(t, jD) != 0;
            case 7:
                return p1.e.a(t, jD);
            case 8:
                Object objG = p1.g(t, jD);
                if (objG instanceof String) {
                    return !((String) objG).isEmpty();
                }
                if (objG instanceof i) {
                    return !i.f1293b.equals(objG);
                }
                throw new IllegalArgumentException();
            case 9:
                return p1.g(t, jD) != null;
            case 10:
                return !i.f1293b.equals(p1.g(t, jD));
            case 11:
                return p1.e(t, jD) != 0;
            case 12:
                return p1.e(t, jD) != 0;
            case 13:
                return p1.e(t, jD) != 0;
            case 14:
                return p1.f(t, jD) != 0;
            case 15:
                return p1.e(t, jD) != 0;
            case 16:
                return p1.f(t, jD) != 0;
            case 17:
                return p1.g(t, jD) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean a(T t, int i, int i2) {
        return p1.e(t, (long) (this.a[i2 + 2] & 1048575)) == i;
    }

    public static <T> boolean a(T t, long j) {
        return ((Boolean) p1.g(t, j)).booleanValue();
    }

    public final int a(int i, int i2) {
        int length = (this.a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.a[i4];
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
}
