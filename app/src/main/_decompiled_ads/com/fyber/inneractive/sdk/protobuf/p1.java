package com.fyber.inneractive.sdk.protobuf;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 {
    public static final Unsafe a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f1302b;
    public static final boolean c;
    public static final boolean d;
    public static final d e;
    public static final boolean f;
    public static final boolean g;
    public static final long h;
    public static final long i;
    public static final boolean j;

    public static abstract class d {
        public Unsafe a;

        public d(Unsafe unsafe) {
            this.a = unsafe;
        }

        public abstract byte a(long j);

        public abstract void a(long j, byte[] bArr, long j2, long j3);

        public abstract void a(Object obj, long j, byte b2);

        public abstract void a(Object obj, long j, double d);

        public abstract void a(Object obj, long j, float f);

        public abstract void a(Object obj, long j, boolean z);

        public boolean a() {
            Unsafe unsafe = this.a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                p1.a(th);
                return false;
            }
        }

        public abstract boolean a(Object obj, long j);

        public abstract byte b(Object obj, long j);

        public abstract boolean b();

        public abstract double c(Object obj, long j);

        public abstract float d(Object obj, long j);
    }

    static {
        Unsafe unsafe;
        d cVar = null;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new o1());
        } catch (Throwable unused) {
            unsafe = null;
        }
        a = unsafe;
        f1302b = com.fyber.inneractive.sdk.protobuf.d.a;
        boolean zC = c(Long.TYPE);
        c = zC;
        boolean zC2 = c(Integer.TYPE);
        d = zC2;
        if (unsafe != null) {
            if (!com.fyber.inneractive.sdk.protobuf.d.a()) {
                cVar = new c(unsafe);
            } else if (zC) {
                cVar = new b(unsafe);
            } else if (zC2) {
                cVar = new a(unsafe);
            }
        }
        e = cVar;
        f = cVar == null ? false : cVar.b();
        g = cVar == null ? false : cVar.a();
        h = a((Class<?>) byte[].class);
        a((Class<?>) boolean[].class);
        b(boolean[].class);
        a((Class<?>) int[].class);
        b(int[].class);
        a((Class<?>) long[].class);
        b(long[].class);
        a((Class<?>) float[].class);
        b(float[].class);
        a((Class<?>) double[].class);
        b(double[].class);
        a((Class<?>) Object[].class);
        b(Object[].class);
        Field fieldA = a();
        i = (fieldA == null || cVar == null) ? -1L : cVar.a.objectFieldOffset(fieldA);
        j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static int a(Class<?> cls) {
        if (g) {
            return e.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int b(Class<?> cls) {
        if (g) {
            return e.a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static boolean c(Class<?> cls) {
        if (!com.fyber.inneractive.sdk.protobuf.d.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f1302b;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte d(Object obj, long j2) {
        return (byte) ((e(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static int e(Object obj, long j2) {
        return e.a.getInt(obj, j2);
    }

    public static long f(Object obj, long j2) {
        return e.a.getLong(obj, j2);
    }

    public static Object g(Object obj, long j2) {
        return e.a.getObject(obj, j2);
    }

    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, byte b2) {
            if (p1.j) {
                p1.a(obj, j, b2);
            } else {
                p1.b(obj, j, b2);
            }
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public byte b(Object obj, long j) {
            return p1.j ? p1.c(obj, j) : p1.d(obj, j);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public boolean b() {
            return false;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public double c(Object obj, long j) {
            return Double.longBitsToDouble(this.a.getLong(obj, j));
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public float d(Object obj, long j) {
            return Float.intBitsToFloat(this.a.getInt(obj, j));
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public boolean a(Object obj, long j) {
            if (p1.j) {
                return p1.a(obj, j);
            }
            return p1.b(obj, j);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, boolean z) {
            if (p1.j) {
                p1.a(obj, j, z ? (byte) 1 : (byte) 0);
            } else {
                p1.b(obj, j, z ? (byte) 1 : (byte) 0);
            }
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, float f) {
            this.a.putInt(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, double d) {
            this.a.putLong(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public byte a(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, byte b2) {
            if (p1.j) {
                p1.a(obj, j, b2);
            } else {
                p1.b(obj, j, b2);
            }
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public byte b(Object obj, long j) {
            return p1.j ? p1.c(obj, j) : p1.d(obj, j);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public boolean b() {
            return false;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public double c(Object obj, long j) {
            return Double.longBitsToDouble(this.a.getLong(obj, j));
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public float d(Object obj, long j) {
            return Float.intBitsToFloat(this.a.getInt(obj, j));
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public boolean a(Object obj, long j) {
            if (p1.j) {
                return p1.a(obj, j);
            }
            return p1.b(obj, j);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, boolean z) {
            if (p1.j) {
                p1.a(obj, j, z ? (byte) 1 : (byte) 0);
            } else {
                p1.b(obj, j, z ? (byte) 1 : (byte) 0);
            }
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, float f) {
            this.a.putInt(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, double d) {
            this.a.putLong(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public byte a(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }
    }

    public static void a(Object obj, long j2, int i2) {
        e.a.putInt(obj, j2, i2);
    }

    public static void b(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (e(obj, j3) & (~(255 << i2))));
    }

    public static void a(Object obj, long j2, long j3) {
        e.a.putLong(obj, j2, j3);
    }

    public static void a(Object obj, long j2, boolean z) {
        e.a(obj, j2, z);
    }

    public static boolean b(Object obj, long j2) {
        return d(obj, j2) != 0;
    }

    public static void a(Object obj, long j2, float f2) {
        e.a(obj, j2, f2);
    }

    public static void a(Object obj, long j2, double d2) {
        e.a(obj, j2, d2);
    }

    public static void a(Object obj, long j2, Object obj2) {
        e.a.putObject(obj, j2, obj2);
    }

    public static byte a(byte[] bArr, long j2) {
        return e.b(bArr, h + j2);
    }

    public static void a(byte[] bArr, long j2, byte b2) {
        e.a((Object) bArr, h + j2, b2);
    }

    public static long a(ByteBuffer byteBuffer) {
        d dVar = e;
        return dVar.a.getLong(byteBuffer, i);
    }

    public static byte c(Object obj, long j2) {
        return (byte) ((e(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static Field a() {
        Field declaredField;
        Field declaredField2;
        if (com.fyber.inneractive.sdk.protobuf.d.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField(IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public boolean a() {
            if (!super.a()) {
                return false;
            }
            try {
                Class<?> cls = this.a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                p1.a(th);
                return false;
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x002e  */
        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public boolean b() {
            boolean z;
            Unsafe unsafe = this.a;
            if (unsafe == null) {
                z = false;
            } else {
                try {
                    Class<?> cls = unsafe.getClass();
                    cls.getMethod("objectFieldOffset", Field.class);
                    cls.getMethod("getLong", Object.class, Long.TYPE);
                    if (p1.a() == null) {
                        z = false;
                    } else {
                        z = true;
                    }
                } catch (Throwable th) {
                    p1.a(th);
                }
            }
            if (!z) {
                return false;
            }
            try {
                Class<?> cls2 = this.a.getClass();
                Class<?> cls3 = Long.TYPE;
                cls2.getMethod("getByte", cls3);
                cls2.getMethod("putByte", cls3, Byte.TYPE);
                cls2.getMethod("getInt", cls3);
                cls2.getMethod("putInt", cls3, Integer.TYPE);
                cls2.getMethod("getLong", cls3);
                cls2.getMethod("putLong", cls3, cls3);
                cls2.getMethod("copyMemory", cls3, cls3, cls3);
                cls2.getMethod("copyMemory", Object.class, cls3, Object.class, cls3, cls3);
                return true;
            } catch (Throwable th2) {
                p1.a(th2);
                return false;
            }
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public double c(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public float d(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, byte b2) {
            this.a.putByte(obj, j, b2);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public boolean a(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public byte a(long j) {
            return this.a.getByte(j);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public byte b(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.p1.d
        public void a(long j, byte[] bArr, long j2, long j3) {
            this.a.copyMemory((Object) null, j, bArr, p1.h + j2, j3);
        }
    }

    public static void a(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int iE = e(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (iE & (~(255 << i2))));
    }

    public static boolean a(Object obj, long j2) {
        return c(obj, j2) != 0;
    }

    public static void a(Throwable th) {
        Logger.getLogger(p1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }
}
