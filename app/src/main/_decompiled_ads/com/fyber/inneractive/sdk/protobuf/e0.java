package com.fyber.inneractive.sdk.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {
    public static final e0 a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f1281b = new c();

    public abstract void a(Object obj, long j);

    public abstract <L> void a(Object obj, Object obj2, long j);

    public abstract <L> List<L> b(Object obj, long j);

    public static final class c extends e0 {
        public c() {
            super();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.e0
        public void a(Object obj, long j) {
            ((y.j) p1.g(obj, j)).b();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.e0
        public <L> List<L> b(Object obj, long j) {
            y.j jVar = (y.j) p1.g(obj, j);
            if (jVar.d()) {
                return jVar;
            }
            int size = jVar.size();
            y.j jVarB = jVar.b(size == 0 ? 10 : size * 2);
            p1.a(obj, j, jVarB);
            return jVarB;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.e0
        public <E> void a(Object obj, Object obj2, long j) {
            y.j jVarB = (y.j) p1.g(obj, j);
            y.j jVar = (y.j) p1.g(obj2, j);
            int size = jVarB.size();
            int size2 = jVar.size();
            if (size > 0 && size2 > 0) {
                if (!jVarB.d()) {
                    jVarB = jVarB.b(size2 + size);
                }
                jVarB.addAll(jVar);
            }
            if (size > 0) {
                jVar = jVarB;
            }
            p1.a(obj, j, jVar);
        }
    }

    public e0() {
    }

    public static final class b extends e0 {
        public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b() {
            super();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.e0
        public void a(Object obj, long j) {
            Object objUnmodifiableList;
            List list = (List) p1.g(obj, j);
            if (list instanceof d0) {
                objUnmodifiableList = ((d0) list).a();
            } else {
                if (c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof x0) && (list instanceof y.j)) {
                    y.j jVar = (y.j) list;
                    if (jVar.d()) {
                        jVar.b();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            p1.a(obj, j, objUnmodifiableList);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.e0
        public <L> List<L> b(Object obj, long j) {
            return a(obj, j, 10);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.e0
        public <E> void a(Object obj, Object obj2, long j) {
            List list = (List) p1.g(obj2, j);
            List listA = a(obj, j, list.size());
            int size = listA.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                listA.addAll(list);
            }
            if (size > 0) {
                list = listA;
            }
            p1.a(obj, j, list);
        }

        public static <L> List<L> a(Object obj, long j, int i) {
            Object obj2;
            List<L> arrayList;
            List<L> list = (List) p1.g(obj, j);
            if (list.isEmpty()) {
                if (list instanceof d0) {
                    arrayList = new c0(i);
                } else if ((list instanceof x0) && (list instanceof y.j)) {
                    arrayList = ((y.j) list).b(i);
                } else {
                    arrayList = new ArrayList<>(i);
                }
                p1.a(obj, j, arrayList);
                return arrayList;
            }
            if (c.isAssignableFrom(list.getClass())) {
                ArrayList arrayList2 = new ArrayList(list.size() + i);
                arrayList2.addAll(list);
                p1.a(obj, j, arrayList2);
                obj2 = arrayList2;
            } else if (list instanceof n1) {
                c0 c0Var = new c0(list.size() + i);
                c0Var.addAll(c0Var.f1278b.size(), (n1) list);
                p1.a(obj, j, c0Var);
                obj2 = c0Var;
            } else {
                if (!(list instanceof x0) || !(list instanceof y.j)) {
                    return list;
                }
                y.j jVar = (y.j) list;
                if (jVar.d()) {
                    return list;
                }
                y.j jVarB = jVar.b(list.size() + i);
                p1.a(obj, j, jVarB);
                return jVarB;
            }
            return (List<L>) obj2;
        }
    }
}
