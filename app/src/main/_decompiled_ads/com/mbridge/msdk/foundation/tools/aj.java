package com.mbridge.msdk.foundation.tools;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: StringSetEncoder.java */
/* JADX INFO: loaded from: classes4.dex */
final class aj implements FastKV.a<Set<String>> {
    static final aj a = new aj();

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final String a() {
        return "StringSet";
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final /* synthetic */ byte[] a(Set<String> set) {
        int i;
        Set<String> set2 = set;
        if (set2.isEmpty()) {
            return new byte[0];
        }
        int size = set2.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i2 = 0;
        int i3 = 0;
        for (String str : set2) {
            if (str == null) {
                i2 += 5;
                iArr[i3] = -1;
            } else {
                int iB = m.b(str);
                strArr[i3] = str;
                iArr[i3] = iB;
                if ((iB >> 7) == 0) {
                    i = 1;
                } else if ((iB >> 14) == 0) {
                    i = 2;
                } else if ((iB >> 21) == 0) {
                    i = 3;
                } else {
                    i = (iB >> 28) == 0 ? 4 : 5;
                }
                i2 += i + iB;
            }
            i3++;
        }
        m mVar = new m(i2);
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = iArr[i4];
            int i6 = mVar.f2218b;
            int i7 = i5;
            while ((i7 & (-128)) != 0) {
                mVar.a[i6] = (byte) ((i7 & WorkQueueKt.MASK) | 128);
                i7 >>>= 7;
                i6++;
            }
            mVar.a[i6] = (byte) i7;
            mVar.f2218b = i6 + 1;
            if (i5 >= 0) {
                mVar.a(strArr[i4]);
            }
        }
        return mVar.a;
    }

    private aj() {
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.a
    public final /* synthetic */ Set<String> a(byte[] bArr, int i, int i2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            m mVar = new m(bArr, i);
            int i3 = i + i2;
            while (mVar.f2218b < i3) {
                byte[] bArr2 = mVar.a;
                int i4 = mVar.f2218b;
                mVar.f2218b = i4 + 1;
                int i5 = bArr2[i4];
                if ((i5 >> 7) != 0) {
                    int i6 = i5 & WorkQueueKt.MASK;
                    byte[] bArr3 = mVar.a;
                    int i7 = mVar.f2218b;
                    mVar.f2218b = i7 + 1;
                    i5 = i6 | (bArr3[i7] << 7);
                    if ((i5 >> 14) != 0) {
                        byte[] bArr4 = mVar.a;
                        int i8 = mVar.f2218b;
                        mVar.f2218b = i8 + 1;
                        i5 = (i5 & 16383) | (bArr4[i8] << 14);
                        if ((i5 >> 21) != 0) {
                            byte[] bArr5 = mVar.a;
                            int i9 = mVar.f2218b;
                            mVar.f2218b = i9 + 1;
                            i5 = (i5 & 2097151) | (bArr5[i9] << 21);
                            if ((i5 >> 28) != 0) {
                                byte[] bArr6 = mVar.a;
                                int i10 = mVar.f2218b;
                                mVar.f2218b = i10 + 1;
                                i5 = (i5 & 268435455) | (bArr6[i10] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(mVar.b(i5));
            }
            if (mVar.f2218b != i3) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
