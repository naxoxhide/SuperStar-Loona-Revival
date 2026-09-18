package com.tnkfactory.ad.pub.b;

import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes4.dex */
public final class n extends DataOutputStream implements ObjectOutput {
    public Map<String, Integer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Object, Integer> f2909b;
    public Map<p, Integer> c;
    public byte[] d;

    public n(OutputStream outputStream) {
        super(outputStream);
        this.a = null;
        this.f2909b = null;
        this.c = null;
        this.d = null;
        this.a = new HashMap();
        this.f2909b = new IdentityHashMap();
        this.c = new HashMap();
    }

    public final void a(int i) throws IOException {
        if (i >= 128) {
            if (i < 16384) {
                write(128 | ((i >> 7) & WorkQueueKt.MASK));
                i &= WorkQueueKt.MASK;
            } else if (i < 2097152) {
                write(((i >> 14) & WorkQueueKt.MASK) | 128);
                write(128 | ((i >> 7) & WorkQueueKt.MASK));
                i &= WorkQueueKt.MASK;
            } else {
                if (i >= 1073741824) {
                    throw new IOException("U29 out of range: " + i);
                }
                write(((i >> 22) & WorkQueueKt.MASK) | 128);
                write(((i >> 15) & WorkQueueKt.MASK) | 128);
                write(128 | ((i >> 8) & WorkQueueKt.MASK));
                i &= 255;
            }
        }
        write(i);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    public final void a(String str, boolean z) throws IOException {
        boolean z2;
        if (z) {
            write(6);
        }
        if (str == null || str.length() == 0) {
            a(1);
            return;
        }
        Integer num = (Integer) this.a.get(str);
        if (num != null) {
            a(num.intValue() << 1);
            z2 = true;
        } else {
            ?? r0 = this.a;
            r0.put(str, Integer.valueOf(r0.size()));
            z2 = false;
        }
        if (z2) {
            return;
        }
        int length = str.length() * 3;
        byte[] bArr = this.d;
        if (bArr == null || bArr.length < length) {
            this.d = new byte[length * 2];
        }
        byte[] bArr2 = this.d;
        int length2 = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length2; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                bArr2[i] = (byte) cCharAt;
                i++;
            } else if (cCharAt < 2048) {
                int i3 = i + 1;
                bArr2[i] = (byte) (((cCharAt >> 6) & 31) | 192);
                i = i3 + 1;
                bArr2[i3] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt < 0) {
                int i4 = i + 1;
                bArr2[i] = (byte) (((cCharAt >> '\f') & 15) | 224);
                int i5 = i4 + 1;
                bArr2[i4] = (byte) (((cCharAt >> 6) & 63) | 128);
                bArr2[i5] = (byte) ((cCharAt & '?') | 128);
                i = i5 + 1;
            } else {
                int i6 = i + 1;
                bArr2[i] = (byte) (((cCharAt >> 18) & 7) | 240);
                int i7 = i6 + 1;
                bArr2[i6] = (byte) (((cCharAt >> '\f') & 63) | 128);
                int i8 = i7 + 1;
                bArr2[i7] = (byte) (((cCharAt >> 6) & 63) | 128);
                i = i8 + 1;
                bArr2[i8] = (byte) ((cCharAt & '?') | 128);
            }
        }
        a((i << 1) | 1);
        write(bArr2, 0, i);
    }

    public final void a(Object[] objArr) throws IOException {
        write(9);
        if (a((Object) objArr)) {
            return;
        }
        a((objArr.length << 1) | 1);
        for (Object obj : objArr) {
            writeObject(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<com.tnkfactory.ad.pub.b.p, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashMap, java.util.Map<com.tnkfactory.ad.pub.b.p, java.lang.Integer>] */
    public final boolean a(p pVar) throws IOException {
        Integer num = (Integer) this.c.get(pVar);
        if (num != null) {
            a((num.intValue() << 2) | 1);
            return true;
        }
        ?? r0 = this.c;
        r0.put(pVar, Integer.valueOf(r0.size()));
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.IdentityHashMap, java.util.Map<java.lang.Object, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.IdentityHashMap, java.util.Map<java.lang.Object, java.lang.Integer>] */
    public final boolean a(Object obj) throws IOException {
        Integer num = (Integer) this.f2909b.get(obj);
        if (num != null) {
            a(num.intValue() << 1);
            return true;
        }
        ?? r0 = this.f2909b;
        r0.put(obj, Integer.valueOf(r0.size()));
        return false;
    }

    @Override // java.io.ObjectOutput
    public final void writeObject(Object obj) throws IOException {
        String string;
        if (obj == null) {
            write(1);
            return;
        }
        if (obj instanceof String) {
            string = (String) obj;
        } else {
            if (!(obj instanceof Character)) {
                if (obj instanceof Number) {
                    Number number = (Number) obj;
                    if (number instanceof BigDecimal) {
                        a(number.toString(), true);
                        return;
                    }
                    if ((number instanceof Double) || (number instanceof Float)) {
                        double dDoubleValue = number.doubleValue();
                        write(5);
                        writeDouble(dDoubleValue);
                        return;
                    }
                    if (number.longValue() < -268435456 || number.longValue() > 268435455) {
                        long jLongValue = number.longValue();
                        write(7);
                        writeLong(jLongValue);
                        return;
                    }
                    int iIntValue = number.intValue();
                    long j = iIntValue;
                    if (j < -268435456 || j > 268435455) {
                        write(7);
                        writeLong(j);
                        return;
                    } else {
                        write(4);
                        a(iIntValue & 536870911);
                        return;
                    }
                }
                if (obj instanceof Boolean) {
                    if (((Boolean) obj).booleanValue()) {
                        write(3);
                        return;
                    } else {
                        write(2);
                        return;
                    }
                }
                if (obj instanceof Date) {
                    Date date = (Date) obj;
                    write(8);
                    if (a(date)) {
                        return;
                    }
                    a(1);
                    writeDouble(date.getTime());
                    return;
                }
                if (obj instanceof char[]) {
                    a(new String((char[]) obj), true);
                    return;
                }
                int i = 0;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    write(12);
                    if (a(bArr)) {
                        return;
                    }
                    int length = bArr.length;
                    a(1 | (length << 1));
                    write(bArr, 0, length);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    write(13);
                    if (a(iArr)) {
                        return;
                    }
                    a(1 | (iArr.length << 1));
                    while (i < iArr.length) {
                        a(iArr[i] & 536870911);
                        i++;
                    }
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    write(13);
                    if (a(sArr)) {
                        return;
                    }
                    a(1 | (sArr.length << 1));
                    while (i < sArr.length) {
                        a(sArr[i] & 536870911);
                        i++;
                    }
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    write(14);
                    if (a(jArr)) {
                        return;
                    }
                    a(1 | (jArr.length << 1));
                    while (i < jArr.length) {
                        writeLong(jArr[i]);
                        i++;
                    }
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    write(15);
                    if (a(fArr)) {
                        return;
                    }
                    a(1 | (fArr.length << 1));
                    while (i < fArr.length) {
                        writeDouble(fArr[i]);
                        i++;
                    }
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    write(15);
                    if (a(dArr)) {
                        return;
                    }
                    a(1 | (dArr.length << 1));
                    while (i < dArr.length) {
                        writeDouble(dArr[i]);
                        i++;
                    }
                    return;
                }
                if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    write(9);
                    if (a(zArr)) {
                        return;
                    }
                    a(1 | (zArr.length << 1));
                    while (i < zArr.length) {
                        if (zArr[i]) {
                            write(3);
                        } else {
                            write(2);
                        }
                        i++;
                    }
                    return;
                }
                if (obj instanceof Object[]) {
                    a((Object[]) obj);
                    return;
                }
                if (obj instanceof Externalizable) {
                    Externalizable externalizable = (Externalizable) obj;
                    write(10);
                    if (a(externalizable)) {
                        return;
                    }
                    String name = externalizable.getClass().getName();
                    if (!a(new p(name, true))) {
                        a(7);
                        a(name, false);
                    }
                    externalizable.writeExternal(this);
                    return;
                }
                if (obj instanceof Collection) {
                    Collection collection = (Collection) obj;
                    a(collection.toArray(new Object[collection.size()]));
                    return;
                }
                if (!(obj instanceof Map)) {
                    throw new IOException(com.tnkfactory.ad.pub.a.a.a("Not supported object type: ").append(obj.getClass().getName()).toString());
                }
                Map map = (Map) obj;
                write(10);
                if (a(map)) {
                    return;
                }
                p pVar = new p();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : map.keySet().toArray(new Object[map.size()])) {
                    arrayList.add(String.valueOf(obj2));
                }
                int size = arrayList.size();
                pVar.c = arrayList;
                if (!a(pVar)) {
                    a((size << 3) | 3);
                    a(pVar.a, false);
                    for (int i2 = 0; i2 < size; i2++) {
                        a((String) arrayList.get(i2), false);
                    }
                }
                if (size > 0) {
                    while (i < size) {
                        writeObject(map.get((String) arrayList.get(i)));
                        i++;
                    }
                    return;
                }
                return;
            }
            string = obj.toString();
        }
        a(string, true);
    }
}
