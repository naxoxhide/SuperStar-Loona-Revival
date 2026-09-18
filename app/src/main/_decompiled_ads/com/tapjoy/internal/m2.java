package com.tapjoy.internal;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentTransaction;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class m2 {
    public int[] a;
    public ByteBuffer c;
    public byte[] d;
    public byte[] e;
    public p2 h;
    public short[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public int[] m;
    public int n;
    public int o;
    public final b7 q;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f2781b = new int[256];
    public int f = 0;
    public int g = 0;
    public o2 p = new o2();

    public m2(b7 b7Var) {
        this.q = b7Var;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x009b A[Catch: all -> 0x0500, TryCatch #0 {all -> 0x0500, blocks: (B:4:0x0003, B:6:0x000a, B:9:0x0010, B:14:0x001a, B:16:0x002c, B:18:0x0038, B:22:0x0041, B:24:0x0045, B:27:0x0049, B:29:0x004d, B:30:0x005b, B:32:0x005f, B:35:0x0065, B:38:0x006b, B:40:0x006f, B:42:0x0077, B:49:0x0085, B:51:0x009b, B:53:0x00a0, B:54:0x00a5, B:45:0x007e, B:47:0x0082, B:56:0x00ab, B:58:0x00af, B:60:0x00c5, B:62:0x00ca, B:63:0x00cf, B:64:0x00d3, B:65:0x00ef, B:67:0x0103, B:70:0x010f, B:72:0x0115, B:73:0x0119, B:75:0x011d, B:76:0x0121, B:78:0x0125, B:80:0x012f, B:87:0x0158, B:90:0x0167, B:92:0x0174, B:98:0x019f, B:105:0x01c8, B:110:0x01da, B:112:0x01de, B:113:0x01e7, B:115:0x01ee, B:116:0x01fb, B:118:0x0204, B:119:0x0208, B:121:0x0215, B:122:0x0220, B:125:0x0248, B:129:0x024f, B:127:0x024b, B:101:0x01a6, B:103:0x01aa, B:104:0x01b3, B:131:0x0256, B:133:0x0273, B:137:0x0286, B:143:0x02a7, B:145:0x02bc, B:148:0x02ca, B:149:0x02df, B:151:0x02f5, B:154:0x0306, B:157:0x030e, B:107:0x01d5, B:162:0x0344, B:163:0x034c, B:169:0x0369, B:173:0x0370, B:182:0x0385, B:184:0x038c, B:186:0x0391, B:189:0x039c, B:191:0x03ab, B:193:0x03b4, B:221:0x0463, B:226:0x046f, B:222:0x0466, B:225:0x046c, B:194:0x03c9, B:195:0x03d8, B:197:0x03dd, B:200:0x03e6, B:202:0x03f1, B:204:0x040d, B:206:0x0416, B:207:0x041a, B:209:0x041f, B:212:0x0426, B:214:0x0431, B:215:0x0446, B:219:0x044f, B:227:0x0480, B:228:0x049c, B:230:0x04a0, B:234:0x04a7, B:236:0x04ab, B:238:0x04af, B:240:0x04b4, B:239:0x04b2, B:241:0x04c7, B:242:0x04d5, B:244:0x04d9, B:246:0x04de, B:245:0x04dc, B:83:0x0136, B:85:0x013a, B:86:0x0143, B:89:0x0164, B:69:0x0106, B:21:0x003d, B:8:0x000e), top: B:255:0x0003, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0 A[Catch: all -> 0x0500, LOOP:1: B:52:0x009e->B:53:0x00a0, LOOP_END, TryCatch #0 {all -> 0x0500, blocks: (B:4:0x0003, B:6:0x000a, B:9:0x0010, B:14:0x001a, B:16:0x002c, B:18:0x0038, B:22:0x0041, B:24:0x0045, B:27:0x0049, B:29:0x004d, B:30:0x005b, B:32:0x005f, B:35:0x0065, B:38:0x006b, B:40:0x006f, B:42:0x0077, B:49:0x0085, B:51:0x009b, B:53:0x00a0, B:54:0x00a5, B:45:0x007e, B:47:0x0082, B:56:0x00ab, B:58:0x00af, B:60:0x00c5, B:62:0x00ca, B:63:0x00cf, B:64:0x00d3, B:65:0x00ef, B:67:0x0103, B:70:0x010f, B:72:0x0115, B:73:0x0119, B:75:0x011d, B:76:0x0121, B:78:0x0125, B:80:0x012f, B:87:0x0158, B:90:0x0167, B:92:0x0174, B:98:0x019f, B:105:0x01c8, B:110:0x01da, B:112:0x01de, B:113:0x01e7, B:115:0x01ee, B:116:0x01fb, B:118:0x0204, B:119:0x0208, B:121:0x0215, B:122:0x0220, B:125:0x0248, B:129:0x024f, B:127:0x024b, B:101:0x01a6, B:103:0x01aa, B:104:0x01b3, B:131:0x0256, B:133:0x0273, B:137:0x0286, B:143:0x02a7, B:145:0x02bc, B:148:0x02ca, B:149:0x02df, B:151:0x02f5, B:154:0x0306, B:157:0x030e, B:107:0x01d5, B:162:0x0344, B:163:0x034c, B:169:0x0369, B:173:0x0370, B:182:0x0385, B:184:0x038c, B:186:0x0391, B:189:0x039c, B:191:0x03ab, B:193:0x03b4, B:221:0x0463, B:226:0x046f, B:222:0x0466, B:225:0x046c, B:194:0x03c9, B:195:0x03d8, B:197:0x03dd, B:200:0x03e6, B:202:0x03f1, B:204:0x040d, B:206:0x0416, B:207:0x041a, B:209:0x041f, B:212:0x0426, B:214:0x0431, B:215:0x0446, B:219:0x044f, B:227:0x0480, B:228:0x049c, B:230:0x04a0, B:234:0x04a7, B:236:0x04ab, B:238:0x04af, B:240:0x04b4, B:239:0x04b2, B:241:0x04c7, B:242:0x04d5, B:244:0x04d9, B:246:0x04de, B:245:0x04dc, B:83:0x0136, B:85:0x013a, B:86:0x0143, B:89:0x0164, B:69:0x0106, B:21:0x003d, B:8:0x000e), top: B:255:0x0003, inners: #3, #4 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v45, types: [short] */
    /* JADX WARN: Type inference failed for: r3v47 */
    public final synchronized Bitmap a() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        short s;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        try {
            o2 o2Var = this.p;
            int i16 = 1;
            if (o2Var.c <= 0 || this.n < 0) {
                this.t = 1;
            }
            int i17 = this.t;
            if (i17 != 1 && i17 != 2) {
                int i18 = 0;
                this.t = 0;
                n2 n2Var = (n2) o2Var.e.get(this.n);
                int i19 = this.n - 1;
                n2 n2Var2 = i19 >= 0 ? (n2) this.p.e.get(i19) : null;
                int[] iArr = n2Var.k;
                if (iArr == null) {
                    iArr = this.p.a;
                }
                this.a = iArr;
                if (iArr == null) {
                    this.t = 1;
                    return null;
                }
                if (n2Var.f) {
                    System.arraycopy(iArr, 0, this.f2781b, 0, iArr.length);
                    int[] iArr2 = this.f2781b;
                    this.a = iArr2;
                    iArr2[n2Var.h] = 0;
                }
                int[] iArr3 = this.m;
                if (n2Var2 == null) {
                    Arrays.fill(iArr3, 0);
                }
                if (n2Var2 != null && (i9 = n2Var2.g) > 0) {
                    if (i9 == 2) {
                        if (!n2Var.f) {
                            o2 o2Var2 = this.p;
                            i10 = o2Var2.k;
                            if (n2Var.k != null && o2Var2.j == n2Var.h) {
                            }
                            int i20 = n2Var2.d;
                            int i21 = this.u;
                            int i22 = i20 / i21;
                            int i23 = n2Var2.f2785b / i21;
                            i11 = n2Var2.c / i21;
                            int i24 = n2Var2.a / i21;
                            int i25 = this.w;
                            i12 = (i23 * i25) + i24;
                            i13 = (i22 * i25) + i12;
                            while (i12 < i13) {
                                i14 = i12 + i11;
                                for (i15 = i12; i15 < i14; i15++) {
                                    iArr3[i15] = i10;
                                }
                                i12 += this.w;
                            }
                        } else if (this.n == 0) {
                            this.x = true;
                        }
                        i10 = 0;
                        int i26 = n2Var2.d;
                        int i27 = this.u;
                        int i28 = i26 / i27;
                        int i29 = n2Var2.f2785b / i27;
                        i11 = n2Var2.c / i27;
                        int i210 = n2Var2.a / i27;
                        int i211 = this.w;
                        i12 = (i29 * i211) + i210;
                        i13 = (i28 * i211) + i12;
                        while (i12 < i13) {
                            i14 = i12 + i11;
                            while (i15 < i14) {
                                iArr3[i15] = i10;
                            }
                            i12 += this.w;
                        }
                    } else if (i9 == 3) {
                        Bitmap bitmap = this.r;
                        if (bitmap == null) {
                            int i30 = n2Var2.d;
                            int i31 = this.u;
                            int i32 = i30 / i31;
                            int i33 = n2Var2.f2785b / i31;
                            int i34 = n2Var2.c / i31;
                            int i35 = n2Var2.a / i31;
                            int i36 = this.w;
                            int i37 = (i33 * i36) + i35;
                            int i38 = (i32 * i36) + i37;
                            while (i37 < i38) {
                                int i39 = i37 + i34;
                                for (int i40 = i37; i40 < i39; i40++) {
                                    iArr3[i40] = 0;
                                }
                                i37 += this.w;
                            }
                        } else {
                            int i41 = n2Var2.d;
                            int i42 = this.u;
                            int i43 = n2Var2.f2785b / i42;
                            int i44 = n2Var2.c / i42;
                            int i45 = n2Var2.a / i42;
                            int i46 = this.w;
                            bitmap.getPixels(iArr3, (i43 * i46) + i45, i46, i45, i43, i44, i41 / i42);
                        }
                    }
                }
                this.f = 0;
                this.g = 0;
                this.c.position(n2Var.j);
                int i47 = n2Var.c * n2Var.d;
                byte[] bArr = this.l;
                if (bArr == null || bArr.length < i47) {
                    this.q.getClass();
                    this.l = new byte[i47];
                }
                if (this.i == null) {
                    this.i = new short[4096];
                }
                if (this.j == null) {
                    this.j = new byte[4096];
                }
                if (this.k == null) {
                    this.k = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
                }
                int i48 = 16384;
                int i49 = 255;
                try {
                    if (this.f <= this.g) {
                        if (this.e == null) {
                            this.q.getClass();
                            this.e = new byte[16384];
                        }
                        this.g = 0;
                        int iMin = Math.min(this.c.remaining(), 16384);
                        this.f = iMin;
                        this.c.get(this.e, 0, iMin);
                    }
                    byte[] bArr2 = this.e;
                    int i50 = this.g;
                    this.g = i50 + 1;
                    i = bArr2[i50] & 255;
                } catch (Exception unused) {
                    this.t = 1;
                    i = 0;
                }
                int i51 = 1 << i;
                int i52 = i51 + 1;
                int i53 = i51 + 2;
                int i54 = i + 1;
                int i55 = (1 << i54) - 1;
                for (int i56 = 0; i56 < i51; i56++) {
                    this.i[i56] = 0;
                    this.j[i56] = (byte) i56;
                }
                int i57 = 0;
                int i58 = 0;
                int i59 = 0;
                int i60 = 0;
                int i61 = 0;
                int i62 = 0;
                int i63 = 0;
                int i64 = 0;
                int i65 = i54;
                int i66 = i53;
                int i67 = i55;
                int i68 = -1;
                while (i57 < i47) {
                    if (i58 == 0) {
                        try {
                            if (this.f <= this.g) {
                                if (this.e == null) {
                                    this.q.getClass();
                                    this.e = new byte[i48];
                                }
                                this.g = i18;
                                int iMin2 = Math.min(this.c.remaining(), i48);
                                this.f = iMin2;
                                this.c.get(this.e, i18, iMin2);
                            }
                            byte[] bArr3 = this.e;
                            int i69 = this.g;
                            this.g = i69 + 1;
                            i58 = bArr3[i69] & i49;
                        } catch (Exception unused2) {
                            this.t = i16;
                            i58 = i18;
                        }
                        if (i58 > 0) {
                            try {
                                if (this.d == null) {
                                    this.q.getClass();
                                    this.d = new byte[i49];
                                }
                                int i70 = this.f;
                                int i71 = this.g;
                                int i72 = i70 - i71;
                                if (i72 >= i58) {
                                    System.arraycopy(this.e, i71, this.d, i18, i58);
                                    this.g += i58;
                                } else if (this.c.remaining() + i72 >= i58) {
                                    try {
                                        System.arraycopy(this.e, this.g, this.d, i18, i72);
                                        this.g = this.f;
                                        if (this.e == null) {
                                            this.q.getClass();
                                            this.e = new byte[16384];
                                        }
                                        this.g = i18;
                                        int iMin3 = Math.min(this.c.remaining(), 16384);
                                        this.f = iMin3;
                                        this.c.get(this.e, i18, iMin3);
                                        int i73 = i58 - i72;
                                        System.arraycopy(this.e, i18, this.d, i72, i73);
                                        this.g += i73;
                                    } catch (Exception unused3) {
                                        i16 = 1;
                                        this.t = i16;
                                    }
                                } else {
                                    this.t = i16;
                                }
                            } catch (Exception unused4) {
                            }
                        }
                        if (i58 <= 0) {
                            this.t = 3;
                            break;
                        }
                        i60 = i18;
                    }
                    i62 += (this.d[i60] & 255) << i61;
                    i60++;
                    i58--;
                    int i74 = i61 + 8;
                    i63 = i63;
                    i68 = i68;
                    i66 = i66;
                    i65 = i65;
                    while (true) {
                        if (i74 < i65) {
                            i61 = i74;
                            i18 = 0;
                            i16 = 1;
                            i48 = 16384;
                            i49 = 255;
                            break;
                        }
                        int i75 = i57;
                        int i76 = i62 & i67;
                        i62 >>= i65;
                        i74 -= i65;
                        if (i76 != i51) {
                            if (i76 > i66) {
                                i8 = i74;
                                this.t = 3;
                            } else {
                                i8 = i74;
                                if (i76 != i52) {
                                    if (i68 == -1) {
                                        this.k[i59] = this.j[i76];
                                        i63 = i76;
                                        i59++;
                                        i74 = i8;
                                        i68 = i63;
                                        i57 = i75;
                                    } else {
                                        if (i76 >= i66) {
                                            this.k[i59] = (byte) i63;
                                            s = i68;
                                            i59++;
                                        } else {
                                            s = i76;
                                        }
                                        while (s >= i51) {
                                            this.k[i59] = this.j[s];
                                            s = this.i[s];
                                            i59++;
                                            i76 = i76;
                                        }
                                        int i77 = i76;
                                        byte[] bArr4 = this.j;
                                        int i78 = bArr4[s] & 255;
                                        int i79 = i59 + 1;
                                        int i80 = i58;
                                        byte b2 = (byte) i78;
                                        this.k[i59] = b2;
                                        if (i66 < 4096) {
                                            this.i[i66] = (short) i68;
                                            bArr4[i66] = b2;
                                            i66++;
                                            if ((i66 & i67) == 0 && i66 < 4096) {
                                                i65++;
                                                i67 += i66;
                                            }
                                        }
                                        i59 = i79;
                                        while (i59 > 0) {
                                            i59--;
                                            this.l[i64] = this.k[i59];
                                            i75++;
                                            i64++;
                                        }
                                        i63 = i78;
                                        i57 = i75;
                                        i74 = i8;
                                        i68 = i77;
                                        i58 = i80;
                                    }
                                }
                            }
                            i57 = i75;
                            i61 = i8;
                            i18 = 0;
                            i16 = 1;
                            i49 = 255;
                            i48 = 16384;
                            break;
                        }
                        i65 = i54;
                        i66 = i53;
                        i67 = i55;
                        i57 = i75;
                        i68 = -1;
                    }
                }
                for (int i81 = i64; i81 < i47; i81++) {
                    this.l[i81] = 0;
                }
                int i82 = n2Var.d;
                int i83 = this.u;
                int i84 = i82 / i83;
                int i85 = n2Var.f2785b / i83;
                int i86 = n2Var.c / i83;
                int i87 = n2Var.a / i83;
                boolean z = this.n == 0;
                int i88 = 0;
                int i89 = 0;
                int i90 = 8;
                int i91 = 1;
                while (i89 < i84) {
                    if (n2Var.e) {
                        if (i88 >= i84) {
                            i91++;
                            if (i91 == 2) {
                                i88 = 4;
                            } else if (i91 == 3) {
                                i90 = 4;
                                i88 = 2;
                            } else if (i91 == 4) {
                                i90 = 2;
                                i88 = 1;
                            }
                        }
                        i3 = i88 + i90;
                    } else {
                        i3 = i88;
                        i88 = i89;
                    }
                    int i92 = i88 + i85;
                    if (i92 < this.v) {
                        int i93 = this.w;
                        int i94 = i92 * i93;
                        int i95 = i94 + i87;
                        int i96 = i95 + i86;
                        int i97 = i94 + i93;
                        if (i97 < i96) {
                            i96 = i97;
                        }
                        int i98 = this.u;
                        int i99 = i89 * i98 * n2Var.c;
                        int i100 = ((i96 - i95) * i98) + i99;
                        int i101 = i95;
                        while (i101 < i96) {
                            int i102 = i84;
                            int i103 = i85;
                            if (this.u == 1) {
                                i7 = this.a[this.l[i99] & 255];
                                i4 = i86;
                                i5 = i87;
                                i6 = i91;
                            } else {
                                int i104 = n2Var.c;
                                i4 = i86;
                                int i105 = i99;
                                int i106 = 0;
                                int i107 = 0;
                                int i108 = 0;
                                int i109 = 0;
                                int i110 = 0;
                                while (true) {
                                    if (i105 >= this.u + i99) {
                                        i5 = i87;
                                        break;
                                    }
                                    byte[] bArr5 = this.l;
                                    i5 = i87;
                                    if (i105 >= bArr5.length || i105 >= i100) {
                                        break;
                                    }
                                    int i111 = this.a[bArr5[i105] & 255];
                                    if (i111 != 0) {
                                        i109 += (i111 >> 24) & 255;
                                        i108 += (i111 >> 16) & 255;
                                        i107 += (i111 >> 8) & 255;
                                        i106 += i111 & 255;
                                        i110++;
                                    }
                                    i105++;
                                    i87 = i5;
                                    i91 = i91;
                                }
                                i6 = i91;
                                int i112 = i104 + i99;
                                for (int i113 = i112; i113 < this.u + i112; i113++) {
                                    byte[] bArr6 = this.l;
                                    if (i113 >= bArr6.length || i113 >= i100) {
                                        break;
                                    }
                                    int i114 = this.a[bArr6[i113] & 255];
                                    if (i114 != 0) {
                                        i109 += (i114 >> 24) & 255;
                                        i108 += (i114 >> 16) & 255;
                                        i107 += (i114 >> 8) & 255;
                                        i106 += i114 & 255;
                                        i110++;
                                    }
                                }
                                i7 = i110 == 0 ? 0 : ((i109 / i110) << 24) | ((i108 / i110) << 16) | ((i107 / i110) << 8) | (i106 / i110);
                            }
                            if (i7 != 0) {
                                iArr3[i101] = i7;
                            } else if (!this.x && z) {
                                this.x = true;
                            }
                            i99 += this.u;
                            i101++;
                            i84 = i102;
                            i85 = i103;
                            i86 = i4;
                            i87 = i5;
                            i91 = i6;
                        }
                    }
                    i89++;
                    i88 = i3;
                    i84 = i84;
                    i85 = i85;
                    i86 = i86;
                    i87 = i87;
                    i91 = i91;
                }
                if (this.s && ((i2 = n2Var.g) == 0 || i2 == 1)) {
                    if (this.r == null) {
                        Bitmap.Config config = this.x ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                        b7 b7Var = this.q;
                        int i115 = this.w;
                        int i116 = this.v;
                        b7Var.getClass();
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i115, i116, config);
                        bitmapCreateBitmap.setHasAlpha(true);
                        this.r = bitmapCreateBitmap;
                    }
                    Bitmap bitmap2 = this.r;
                    int i117 = this.w;
                    bitmap2.setPixels(iArr3, 0, i117, 0, 0, i117, this.v);
                }
                Bitmap.Config config2 = this.x ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                b7 b7Var2 = this.q;
                int i118 = this.w;
                int i119 = this.v;
                b7Var2.getClass();
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i118, i119, config2);
                bitmapCreateBitmap2.setHasAlpha(true);
                int i120 = this.w;
                bitmapCreateBitmap2.setPixels(iArr3, 0, i120, 0, 0, i120, this.v);
                return bitmapCreateBitmap2;
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(o2 o2Var, ByteBuffer byteBuffer) {
        int iHighestOneBit = Integer.highestOneBit(1);
        this.t = 0;
        this.p = o2Var;
        this.x = false;
        this.n = -1;
        this.o = 0;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.c = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.c.order(ByteOrder.LITTLE_ENDIAN);
        this.s = false;
        Iterator it = o2Var.e.iterator();
        while (it.hasNext()) {
            if (((n2) it.next()).g == 3) {
                this.s = true;
                break;
            }
        }
        this.u = iHighestOneBit;
        int i = o2Var.f;
        this.w = i / iHighestOneBit;
        int i2 = o2Var.g;
        this.v = i2 / iHighestOneBit;
        this.q.getClass();
        this.l = new byte[i * i2];
        b7 b7Var = this.q;
        int i3 = this.w * this.v;
        b7Var.getClass();
        this.m = new int[i3];
    }

    public final synchronized void a(o2 o2Var, byte[] bArr) {
        a(o2Var, ByteBuffer.wrap(bArr));
    }

    public final synchronized void a(o2 o2Var, ByteBuffer byteBuffer) {
        b(o2Var, byteBuffer);
    }
}
