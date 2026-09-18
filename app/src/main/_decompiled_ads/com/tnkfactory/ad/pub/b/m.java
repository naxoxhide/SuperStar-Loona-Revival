package com.tnkfactory.ad.pub.b;

import java.io.DataInputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes4.dex */
public final class m extends DataInputStream implements ObjectInput {
    public List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Object> f2908b;
    public List<p> c;
    public byte[] d;

    public m(InputStream inputStream) {
        super(inputStream);
        this.a = null;
        this.f2908b = null;
        this.c = null;
        this.d = null;
        this.a = new ArrayList();
        this.f2908b = new ArrayList();
        this.c = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<java.lang.Object>] */
    public final Object a(int i) {
        if ((i & 1) == 0) {
            return this.f2908b.get(i >> 1);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    public final String a() throws IOException {
        int iB = b();
        String str = (iB & 1) == 0 ? (String) this.a.get(iB >> 1) : null;
        if (str != null) {
            return str;
        }
        int i = iB >> 1;
        if (i == 0) {
            return "";
        }
        byte[] bArr = this.d;
        if (bArr == null || bArr.length < i) {
            this.d = new byte[i * 2];
        }
        byte[] bArr2 = this.d;
        readFully(bArr2, 0, i);
        String str2 = new String(bArr2, 0, i, "utf-8");
        this.a.add(str2);
        return str2;
    }

    public final int b() {
        int i = readByte() & 255;
        if (i <= 127) {
            return i;
        }
        int i2 = readByte() & 255;
        if (i2 <= 127) {
            return ((i & WorkQueueKt.MASK) << 7) | i2;
        }
        int i3 = readByte() & 255;
        if (i3 <= 127) {
            return ((i & WorkQueueKt.MASK) << 14) | ((127 & i2) << 7) | i3;
        }
        return ((i & WorkQueueKt.MASK) << 22) | ((i2 & WorkQueueKt.MASK) << 15) | ((127 & i3) << 8) | (readByte() & 255);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.io.ObjectInput
    public final Object readObject() throws IOException, ClassNotFoundException {
        p pVar;
        byte b2 = readByte();
        int i = 0;
        switch (b2) {
            case 0:
            case 1:
                return null;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Boolean.TRUE;
            case 4:
                return Integer.valueOf((b() << 3) >> 3);
            case 5:
                return Double.valueOf(readDouble());
            case 6:
                return a();
            case 7:
                return Long.valueOf(readLong());
            case 8:
                Date date = (Date) a(b());
                if (date != null) {
                    return date;
                }
                Date date2 = new Date((long) readDouble());
                this.f2908b.add(date2);
                return date2;
            case 9:
                int iB = b();
                Object objA = a(iB);
                if (objA != null) {
                    return objA;
                }
                int i2 = iB >> 1;
                Object[] objArr = new Object[i2];
                this.f2908b.add(objArr);
                while (i < i2) {
                    objArr[i] = readObject();
                    i++;
                }
                return objArr;
            case 10:
                int iB2 = b();
                Object objA2 = a(iB2);
                if (objA2 != null) {
                    return objA2;
                }
                if ((iB2 & 3) == 1) {
                    pVar = this.c.get(iB2 >> 2);
                } else {
                    p pVar2 = new p(a(), (iB2 & 7) == 7);
                    this.c.add(pVar2);
                    int i3 = iB2 >> 3;
                    for (int i4 = 0; i4 < i3; i4++) {
                        pVar2.c.add(a());
                    }
                    pVar = pVar2;
                }
                String str = pVar.a;
                if (str == null || str.length() == 0) {
                    HashMap map = new HashMap();
                    this.f2908b.add(map);
                    int size = pVar.c.size();
                    while (i < size) {
                        map.put(pVar.c.get(i), readObject());
                        i++;
                    }
                    return map;
                }
                if (!pVar.f2911b) {
                    throw new IOException("not supported class. " + str);
                }
                try {
                    Object objNewInstance = m.class.getClassLoader().loadClass(str).newInstance();
                    this.f2908b.add(objNewInstance);
                    if (!(objNewInstance instanceof Externalizable)) {
                        throw new IOException(com.tnkfactory.ad.pub.a.a.a("Not externalizable class:").append(objNewInstance.getClass().getName()).toString());
                    }
                    ((Externalizable) objNewInstance).readExternal(this);
                    return objNewInstance;
                } catch (ClassNotFoundException e) {
                    throw e;
                } catch (Exception unused) {
                    throw new IOException("Cannot instantiate class: " + str);
                }
            case 11:
            default:
                throw new IOException("Unknown message type :" + ((int) b2));
            case 12:
                int iB3 = b();
                byte[] bArr = (byte[]) a(iB3);
                if (bArr != null) {
                    return bArr;
                }
                int i5 = iB3 >> 1;
                byte[] bArr2 = new byte[i5];
                this.f2908b.add(bArr2);
                readFully(bArr2, 0, i5);
                return bArr2;
            case 13:
                int iB4 = b();
                Object objA3 = a(iB4);
                if (objA3 != null) {
                    return (int[]) objA3;
                }
                int i6 = iB4 >> 1;
                int[] iArr = new int[i6];
                this.f2908b.add(iArr);
                while (i < i6) {
                    iArr[i] = b();
                    i++;
                }
                return iArr;
            case 14:
                int iB5 = b();
                Object objA4 = a(iB5);
                if (objA4 != null) {
                    return (long[]) objA4;
                }
                int i7 = iB5 >> 1;
                long[] jArr = new long[i7];
                this.f2908b.add(jArr);
                while (i < i7) {
                    jArr[i] = readLong();
                    i++;
                }
                return jArr;
            case 15:
                int iB6 = b();
                Object objA5 = a(iB6);
                if (objA5 != null) {
                    return (double[]) objA5;
                }
                int i8 = iB6 >> 1;
                double[] dArr = new double[i8];
                this.f2908b.add(dArr);
                while (i < i8) {
                    dArr[i] = readDouble();
                    i++;
                }
                return dArr;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList, java.util.List<java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList, java.util.List<com.tnkfactory.ad.pub.b.p>] */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        this.a.clear();
        this.f2908b.clear();
        this.c.clear();
    }
}
