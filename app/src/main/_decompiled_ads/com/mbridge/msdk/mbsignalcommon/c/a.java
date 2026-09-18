package com.mbridge.msdk.mbsignalcommon.c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: Mapping.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static InterfaceC0496a a;

    /* JADX INFO: renamed from: com.mbridge.msdk.mbsignalcommon.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Mapping.java */
    public interface InterfaceC0496a {
        boolean a(b.C0497a c0497a);
    }

    /* JADX INFO: compiled from: Mapping.java */
    public static abstract class b {

        /* JADX INFO: renamed from: com.mbridge.msdk.mbsignalcommon.c.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Mapping.java */
        public static class C0497a extends Throwable {
            private Class<?> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f2324b;

            public C0497a(String str) {
                super(str);
            }

            public C0497a(Exception exc) {
                super(exc);
            }

            @Override // java.lang.Throwable
            public final String toString() {
                return getCause() != null ? getClass().getName() + ": " + getCause() : super.toString();
            }

            public final void a(Class<?> cls) {
                this.a = cls;
            }

            public final void a(String str) {
                this.f2324b = str;
            }
        }
    }

    /* JADX INFO: compiled from: Mapping.java */
    public static class d {
        protected final Method a;

        public final Object a(Object obj, Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            try {
                return this.a.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        d(Class<?> cls, String str, Class<?>[] clsArr, int i) throws b.C0497a {
            Method declaredMethod = null;
            if (cls != null) {
                while (cls != Object.class) {
                    try {
                        declaredMethod = cls.getDeclaredMethod(str, clsArr);
                        break;
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                        cls = cls.getSuperclass();
                    } catch (SecurityException e2) {
                        try {
                            try {
                                e2.printStackTrace();
                                cls = cls.getSuperclass();
                            } catch (Exception e3) {
                                b.C0497a c0497a = new b.C0497a(e3);
                                c0497a.a(cls);
                                c0497a.a(str);
                                a.b(c0497a);
                                return;
                            }
                        } finally {
                            this.a = declaredMethod;
                        }
                    }
                }
                if (i > 0 && (declaredMethod.getModifiers() & i) != i) {
                    a.b(new b.C0497a(declaredMethod + " does not match modifiers: " + i));
                }
                declaredMethod.setAccessible(true);
                return;
            }
            this.a = null;
        }

        public final Method a() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: Mapping.java */
    public static class c<C> {
        protected Class<C> a;

        public final d a(String str, Class<?>... clsArr) throws b.C0497a {
            return new d(this.a, str, clsArr, 0);
        }

        public c(Class<C> cls) {
            this.a = cls;
        }
    }

    public static <T> c<T> a(ClassLoader classLoader, String str) throws b.C0497a {
        try {
            return new c<>(classLoader.loadClass(str));
        } catch (Exception e) {
            b(new b.C0497a(e));
            return new c<>(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b.C0497a c0497a) throws b.C0497a {
        InterfaceC0496a interfaceC0496a = a;
        if (interfaceC0496a == null || !interfaceC0496a.a(c0497a)) {
            throw c0497a;
        }
    }
}
