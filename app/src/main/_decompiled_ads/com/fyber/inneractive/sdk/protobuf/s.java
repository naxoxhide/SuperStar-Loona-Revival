package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends r<GeneratedMessageLite.d> {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.b.values().length];
            a = iArr;
            try {
                iArr[r1.b.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r1.b.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r1.b.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r1.b.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r1.b.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r1.b.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r1.b.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r1.b.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r1.b.UINT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r1.b.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r1.b.SFIXED64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r1.b.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[r1.b.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[r1.b.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[r1.b.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[r1.b.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[r1.b.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[r1.b.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.r
    public boolean a(o0 o0Var) {
        return o0Var instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.r
    public u<GeneratedMessageLite.d> b(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).ensureExtensionsAreMutable();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.r
    public void c(Object obj) {
        ((GeneratedMessageLite.ExtendableMessage) obj).extensions.g();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.r
    public u<GeneratedMessageLite.d> a(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    /* JADX WARN: Code duplicated, block: B:61:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a9  */
    @Override // com.fyber.inneractive.sdk.protobuf.r
    public <UT, UB> UB a(c1 c1Var, Object obj, q qVar, u<GeneratedMessageLite.d> uVar, UB ub, k1<UT, UB> k1Var) throws IOException {
        Object objValueOf;
        GeneratedMessageLite.d dVar;
        int i;
        Object objA;
        ArrayList arrayList;
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        GeneratedMessageLite.d dVar2 = eVar.d;
        int i2 = dVar2.f1273b;
        if (dVar2.d && dVar2.e) {
            switch (a.a[dVar2.c.ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    c1Var.j(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    c1Var.d(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    c1Var.k(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    c1Var.a(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    c1Var.o(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    c1Var.n(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    c1Var.e(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    c1Var.l(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    c1Var.i(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    c1Var.f(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    c1Var.m(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    c1Var.c(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    c1Var.g(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    c1Var.p(arrayList);
                    ub = (UB) f1.a(i2, arrayList, eVar.d.a, ub, k1Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.d.c);
            }
            uVar.c(eVar.d, arrayList);
        } else {
            Object objA2 = null;
            r1.b bVar = dVar2.c;
            if (bVar == r1.b.ENUM) {
                int iD = c1Var.d();
                if (eVar.d.a.a(iD) == null) {
                    Class<?> cls = f1.a;
                    if (ub == null) {
                        ub = k1Var.a();
                    }
                    k1Var.b(ub, i2, iD);
                    return ub;
                }
                objValueOf = Integer.valueOf(iD);
            } else {
                switch (a.a[bVar.ordinal()]) {
                    case 1:
                        objValueOf = Double.valueOf(c1Var.h());
                        break;
                    case 2:
                        objValueOf = Float.valueOf(c1Var.k());
                        break;
                    case 3:
                        objValueOf = Long.valueOf(c1Var.o());
                        break;
                    case 4:
                        objValueOf = Long.valueOf(c1Var.f());
                        break;
                    case 5:
                        objValueOf = Integer.valueOf(c1Var.d());
                        break;
                    case 6:
                        objValueOf = Long.valueOf(c1Var.g());
                        break;
                    case 7:
                        objValueOf = Integer.valueOf(c1Var.q());
                        break;
                    case 8:
                        objValueOf = Boolean.valueOf(c1Var.r());
                        break;
                    case 9:
                        objValueOf = Integer.valueOf(c1Var.c());
                        break;
                    case 10:
                        objValueOf = Integer.valueOf(c1Var.m());
                        break;
                    case 11:
                        objValueOf = Long.valueOf(c1Var.t());
                        break;
                    case 12:
                        objValueOf = Integer.valueOf(c1Var.j());
                        break;
                    case 13:
                        objValueOf = Long.valueOf(c1Var.l());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        objValueOf = c1Var.a();
                        break;
                    case 16:
                        objValueOf = c1Var.n();
                        break;
                    case 17:
                        objValueOf = c1Var.a(eVar.c.getClass(), qVar);
                        break;
                    case 18:
                        objValueOf = c1Var.b(eVar.c.getClass(), qVar);
                        break;
                    default:
                        dVar = eVar.d;
                        if (dVar.d) {
                            uVar.a(dVar, objA2);
                        } else {
                            i = a.a[dVar.c.ordinal()];
                            if ((i != 17 || i == 18) && (objA = uVar.a(eVar.d)) != null) {
                            }
                            uVar.c(eVar.d, objA2);
                        }
                        break;
                }
            }
            objA2 = objValueOf;
            dVar = eVar.d;
            if (dVar.d) {
                uVar.a(dVar, objA2);
            } else {
                i = a.a[dVar.c.ordinal()];
                objA2 = i != 17 ? y.a(objA, objA2) : y.a(objA, objA2);
                uVar.c(eVar.d, objA2);
            }
        }
        return ub;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.r
    public Object a(q qVar, o0 o0Var, int i) {
        return qVar.a.get(new q.a(o0Var, i));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.r
    public int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.d) entry.getKey()).f1273b;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.r
    public void a(s1 s1Var, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) entry.getKey();
        if (dVar.d) {
            switch (a.a[dVar.c.ordinal()]) {
                case 1:
                    f1.b(dVar.f1273b, (List<Double>) entry.getValue(), s1Var, dVar.e);
                    break;
                case 2:
                    f1.f(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 3:
                    f1.h(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 4:
                    f1.n(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 5:
                    f1.g(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 6:
                    f1.e(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 7:
                    f1.d(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 8:
                    f1.a(dVar.f1273b, (List<Boolean>) entry.getValue(), s1Var, dVar.e);
                    break;
                case 9:
                    f1.m(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 10:
                    f1.i(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 11:
                    f1.j(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 12:
                    f1.k(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 13:
                    f1.l(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 14:
                    f1.g(dVar.f1273b, (List) entry.getValue(), s1Var, dVar.e);
                    break;
                case 15:
                    f1.a(dVar.f1273b, (List<i>) entry.getValue(), s1Var);
                    break;
                case 16:
                    f1.b(dVar.f1273b, (List<String>) entry.getValue(), s1Var);
                    break;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        f1.a(dVar.f1273b, (List<?>) entry.getValue(), s1Var, z0.c.a(list.get(0).getClass()));
                        break;
                    }
                    break;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        f1.b(dVar.f1273b, (List<?>) entry.getValue(), s1Var, z0.c.a(list2.get(0).getClass()));
                        break;
                    }
                    break;
            }
        }
        switch (a.a[dVar.c.ordinal()]) {
            case 1:
                ((m) s1Var).a(dVar.f1273b, ((Double) entry.getValue()).doubleValue());
                break;
            case 2:
                ((m) s1Var).a(dVar.f1273b, ((Float) entry.getValue()).floatValue());
                break;
            case 3:
                ((m) s1Var).a.g(dVar.f1273b, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                ((m) s1Var).a.g(dVar.f1273b, ((Long) entry.getValue()).longValue());
                break;
            case 5:
                ((m) s1Var).a.h(dVar.f1273b, ((Integer) entry.getValue()).intValue());
                break;
            case 6:
                ((m) s1Var).a.f(dVar.f1273b, ((Long) entry.getValue()).longValue());
                break;
            case 7:
                ((m) s1Var).a.g(dVar.f1273b, ((Integer) entry.getValue()).intValue());
                break;
            case 8:
                ((m) s1Var).a.b(dVar.f1273b, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 9:
                ((m) s1Var).a.j(dVar.f1273b, ((Integer) entry.getValue()).intValue());
                break;
            case 10:
                ((m) s1Var).a.g(dVar.f1273b, ((Integer) entry.getValue()).intValue());
                break;
            case 11:
                ((m) s1Var).a.f(dVar.f1273b, ((Long) entry.getValue()).longValue());
                break;
            case 12:
                ((m) s1Var).a(dVar.f1273b, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                ((m) s1Var).a(dVar.f1273b, ((Long) entry.getValue()).longValue());
                break;
            case 14:
                ((m) s1Var).a.h(dVar.f1273b, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                ((m) s1Var).a.b(dVar.f1273b, (i) entry.getValue());
                break;
            case 16:
                ((m) s1Var).a.b(dVar.f1273b, (String) entry.getValue());
                break;
            case 17:
                ((m) s1Var).a(dVar.f1273b, entry.getValue(), z0.c.a(entry.getValue().getClass()));
                break;
            case 18:
                ((m) s1Var).b(dVar.f1273b, entry.getValue(), z0.c.a(entry.getValue().getClass()));
                break;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.r
    public void a(c1 c1Var, Object obj, q qVar, u<GeneratedMessageLite.d> uVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        uVar.c(eVar.d, c1Var.b(eVar.c.getClass(), qVar));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.r
    public void a(i iVar, Object obj, q qVar, u<GeneratedMessageLite.d> uVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        GeneratedMessageLite generatedMessageLiteB = ((GeneratedMessageLite.b) eVar.c.newBuilderForType()).b();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(iVar.h());
        if (byteBufferWrap.hasArray()) {
            f.b bVar = new f.b(byteBufferWrap, true);
            z0 z0Var = z0.c;
            z0Var.getClass();
            z0Var.a(generatedMessageLiteB.getClass()).a(generatedMessageLiteB, bVar, qVar);
            uVar.c(eVar.d, generatedMessageLiteB);
            if (bVar.s() != Integer.MAX_VALUE) {
                throw z.a();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
