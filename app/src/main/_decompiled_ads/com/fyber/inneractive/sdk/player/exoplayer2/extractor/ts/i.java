package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements h {
    public static final double[] n = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n f1125b;
    public boolean c;
    public long d;
    public final boolean[] e = new boolean[4];
    public final a f = new a(128);
    public boolean g;
    public long h;
    public long i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;

    public static final class a {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1126b;
        public int c;
        public byte[] d;

        public a(int i) {
            this.d = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i4 = this.f1126b + i3;
                if (length < i4) {
                    this.d = Arrays.copyOf(bArr2, i4 * 2);
                }
                System.arraycopy(bArr, i, this.d, this.f1126b, i3);
                this.f1126b += i3;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(this.e);
        a aVar = this.f;
        aVar.a = false;
        aVar.f1126b = 0;
        aVar.c = 0;
        this.j = false;
        this.g = false;
        this.h = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        dVar.a();
        this.a = dVar.b();
        this.f1125b = hVar.a(dVar.c(), 2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(long j, boolean z) {
        boolean z2 = j != -9223372036854775807L;
        this.j = z2;
        if (z2) {
            this.i = j;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0071  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:48:0x0102  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        boolean z;
        byte b2;
        byte[] bArrCopyOf;
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        float f2;
        int i5;
        long j;
        double[] dArr;
        double d;
        int i6;
        int i7;
        int i8 = kVar.f1236b;
        int i9 = kVar.c;
        byte[] bArr = kVar.a;
        this.h += (long) kVar.a();
        this.f1125b.a(kVar, kVar.a());
        int i10 = i8;
        while (true) {
            int iA = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(bArr, i8, i9, this.e);
            if (iA == i9) {
                break;
            }
            int i11 = iA + 3;
            int i12 = kVar.a[i11] & 255;
            if (!this.c) {
                int i13 = iA - i10;
                if (i13 > 0) {
                    this.f.a(bArr, i10, iA);
                }
                int i14 = i13 < 0 ? -i13 : 0;
                a aVar = this.f;
                if (aVar.a) {
                    if (aVar.c == 0 && i12 == 181) {
                        aVar.c = aVar.f1126b;
                    } else {
                        aVar.f1126b -= i14;
                        aVar.a = false;
                        b2 = true;
                    }
                    if (b2 != false) {
                        String str = this.a;
                        bArrCopyOf = Arrays.copyOf(aVar.d, aVar.f1126b);
                        int i15 = bArrCopyOf[4] & 255;
                        int i16 = bArrCopyOf[5] & 255;
                        i = (i15 << 4) | (i16 >> 4);
                        i2 = ((i16 & 15) << 8) | (bArrCopyOf[6] & 255);
                        i3 = (bArrCopyOf[7] & 240) >> 4;
                        if (i3 != 2) {
                            f = i2 * 4;
                            i4 = i * 3;
                        } else if (i3 != 3) {
                            if (i3 != 4) {
                                f2 = 1.0f;
                            } else {
                                f = i2 * 121;
                                i4 = i * 100;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.i iVarA = com.fyber.inneractive.sdk.player.exoplayer2.i.a(str, "video/mpeg2", (String) null, -1, -1, i, i2, -1.0f, (List<byte[]>) Collections.singletonList(bArrCopyOf), -1, f2, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null);
                            i5 = (bArrCopyOf[7] & 15) - 1;
                            if (i5 >= 0) {
                                dArr = n;
                                if (i5 < dArr.length) {
                                    d = dArr[i5];
                                    int i17 = aVar.c + 9;
                                    i6 = (bArrCopyOf[i17] & 96) >> 5;
                                    i7 = bArrCopyOf[i17] & 31;
                                    if (i6 != i7) {
                                        d *= (((double) i6) + 1.0d) / ((double) (i7 + 1));
                                    }
                                    j = (long) (1000000.0d / d);
                                } else {
                                    j = 0;
                                }
                            } else {
                                j = 0;
                            }
                            Pair pairCreate = Pair.create(iVarA, Long.valueOf(j));
                            this.f1125b.a((com.fyber.inneractive.sdk.player.exoplayer2.i) pairCreate.first);
                            this.d = ((Long) pairCreate.second).longValue();
                            this.c = true;
                        } else {
                            f = i2 * 16;
                            i4 = i * 9;
                        }
                        f2 = f / i4;
                        com.fyber.inneractive.sdk.player.exoplayer2.i iVarA2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(str, "video/mpeg2", (String) null, -1, -1, i, i2, -1.0f, (List<byte[]>) Collections.singletonList(bArrCopyOf), -1, f2, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null);
                        i5 = (bArrCopyOf[7] & 15) - 1;
                        if (i5 >= 0) {
                            dArr = n;
                            if (i5 < dArr.length) {
                                d = dArr[i5];
                                int i18 = aVar.c + 9;
                                i6 = (bArrCopyOf[i18] & 96) >> 5;
                                i7 = bArrCopyOf[i18] & 31;
                                if (i6 != i7) {
                                    d *= (((double) i6) + 1.0d) / ((double) (i7 + 1));
                                }
                                j = (long) (1000000.0d / d);
                            } else {
                                j = 0;
                            }
                        } else {
                            j = 0;
                        }
                        Pair pairCreate2 = Pair.create(iVarA2, Long.valueOf(j));
                        this.f1125b.a((com.fyber.inneractive.sdk.player.exoplayer2.i) pairCreate2.first);
                        this.d = ((Long) pairCreate2.second).longValue();
                        this.c = true;
                    }
                } else if (i12 == 179) {
                    aVar.a = true;
                }
                b2 = false;
                if (b2 != false) {
                    String str2 = this.a;
                    bArrCopyOf = Arrays.copyOf(aVar.d, aVar.f1126b);
                    int i19 = bArrCopyOf[4] & 255;
                    int i110 = bArrCopyOf[5] & 255;
                    i = (i19 << 4) | (i110 >> 4);
                    i2 = ((i110 & 15) << 8) | (bArrCopyOf[6] & 255);
                    i3 = (bArrCopyOf[7] & 240) >> 4;
                    if (i3 != 2) {
                        f = i2 * 4;
                        i4 = i * 3;
                    } else if (i3 != 3) {
                        if (i3 != 4) {
                            f2 = 1.0f;
                        } else {
                            f = i2 * 121;
                            i4 = i * 100;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.i iVarA3 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(str2, "video/mpeg2", (String) null, -1, -1, i, i2, -1.0f, (List<byte[]>) Collections.singletonList(bArrCopyOf), -1, f2, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null);
                        i5 = (bArrCopyOf[7] & 15) - 1;
                        if (i5 >= 0) {
                            dArr = n;
                            if (i5 < dArr.length) {
                                d = dArr[i5];
                                int i111 = aVar.c + 9;
                                i6 = (bArrCopyOf[i111] & 96) >> 5;
                                i7 = bArrCopyOf[i111] & 31;
                                if (i6 != i7) {
                                    d *= (((double) i6) + 1.0d) / ((double) (i7 + 1));
                                }
                                j = (long) (1000000.0d / d);
                            } else {
                                j = 0;
                            }
                        } else {
                            j = 0;
                        }
                        Pair pairCreate3 = Pair.create(iVarA3, Long.valueOf(j));
                        this.f1125b.a((com.fyber.inneractive.sdk.player.exoplayer2.i) pairCreate3.first);
                        this.d = ((Long) pairCreate3.second).longValue();
                        this.c = true;
                    } else {
                        f = i2 * 16;
                        i4 = i * 9;
                    }
                    f2 = f / i4;
                    com.fyber.inneractive.sdk.player.exoplayer2.i iVarA4 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(str2, "video/mpeg2", (String) null, -1, -1, i, i2, -1.0f, (List<byte[]>) Collections.singletonList(bArrCopyOf), -1, f2, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null);
                    i5 = (bArrCopyOf[7] & 15) - 1;
                    if (i5 >= 0) {
                        dArr = n;
                        if (i5 < dArr.length) {
                            d = dArr[i5];
                            int i112 = aVar.c + 9;
                            i6 = (bArrCopyOf[i112] & 96) >> 5;
                            i7 = bArrCopyOf[i112] & 31;
                            if (i6 != i7) {
                                d *= (((double) i6) + 1.0d) / ((double) (i7 + 1));
                            }
                            j = (long) (1000000.0d / d);
                        } else {
                            j = 0;
                        }
                    } else {
                        j = 0;
                    }
                    Pair pairCreate4 = Pair.create(iVarA4, Long.valueOf(j));
                    this.f1125b.a((com.fyber.inneractive.sdk.player.exoplayer2.i) pairCreate4.first);
                    this.d = ((Long) pairCreate4.second).longValue();
                    this.c = true;
                }
            }
            if (this.c && (i12 == 184 || i12 == 0)) {
                int i20 = i9 - iA;
                if (this.g) {
                    this.f1125b.a(this.m, this.k ? 1 : 0, ((int) (this.h - this.l)) - i20, i20, null);
                    z = false;
                    this.k = false;
                } else {
                    z = false;
                }
                if (i12 == 184) {
                    this.g = z;
                    this.k = true;
                } else {
                    this.m = this.j ? this.i : this.m + this.d;
                    this.l = this.h - ((long) i20);
                    this.j = false;
                    this.g = true;
                }
            }
            i10 = iA;
            i8 = i11;
        }
        if (this.c) {
            return;
        }
        this.f.a(bArr, i10, i9);
    }
}
