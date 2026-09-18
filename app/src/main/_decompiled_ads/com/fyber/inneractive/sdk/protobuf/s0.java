package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class s0<T> implements d1<T> {
    public final o0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k1<?, ?> f1307b;
    public final boolean c;
    public final r<?> d;

    public s0(k1<?, ?> k1Var, r<?> rVar, o0 o0Var) {
        this.f1307b = k1Var;
        this.c = rVar.a(o0Var);
        this.d = rVar;
        this.a = o0Var;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public T a() {
        return (T) ((GeneratedMessageLite.b) this.a.newBuilderForType()).b();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public boolean b(T t, T t2) {
        if (!this.f1307b.b(t).equals(this.f1307b.b(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a(t).equals(this.d.a(t2));
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void c(T t) {
        this.f1307b.e(t);
        this.d.c(t);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public int d(T t) {
        int iHashCode = this.f1307b.b(t).hashCode();
        return this.c ? (iHashCode * 53) + this.d.a(t).a.hashCode() : iHashCode;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void a(T t, T t2) {
        k1<?, ?> k1Var = this.f1307b;
        Class<?> cls = f1.a;
        k1Var.c(t, k1Var.a(k1Var.b(t), k1Var.b(t2)));
        if (this.c) {
            r<?> rVar = this.d;
            u<T> uVarA = rVar.a(t2);
            if (uVarA.a.isEmpty()) {
                return;
            }
            rVar.b(t).a((u) uVarA);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public int b(T t) {
        k1<?, ?> k1Var = this.f1307b;
        int iD = k1Var.d(k1Var.b(t)) + 0;
        return this.c ? iD + this.d.a(t).c() : iD;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void a(T t, s1 s1Var) throws IOException {
        Iterator itF = this.d.a(t).f();
        while (itF.hasNext()) {
            Map.Entry entry = (Map.Entry) itF.next();
            u.b bVar = (u.b) entry.getKey();
            if (bVar.d() == r1.c.MESSAGE && !bVar.b() && !bVar.isPacked()) {
                if (entry instanceof a0.a) {
                    ((m) s1Var).a(bVar.a(), ((a0.a) entry).a.getValue().a());
                } else {
                    ((m) s1Var).a(bVar.a(), entry.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        k1<?, ?> k1Var = this.f1307b;
        k1Var.a(k1Var.b(t), s1Var);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b9 A[EDGE_INSN: B:58:0x00b9->B:34:0x00b9 BREAK  A[LOOP:1: B:18:0x0063->B:61:0x0063], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void a(T t, byte[] bArr, int i, int i2, e.b bVar) throws IOException {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
        l1 l1VarC = generatedMessageLite.unknownFields;
        if (l1VarC == l1.f) {
            l1VarC = l1.c();
            generatedMessageLite.unknownFields = l1VarC;
        }
        u<GeneratedMessageLite.d> uVarEnsureExtensionsAreMutable = ((GeneratedMessageLite.ExtendableMessage) t).ensureExtensionsAreMutable();
        GeneratedMessageLite.e eVar = null;
        while (i < i2) {
            int iD = e.d(bArr, i, bVar);
            int i3 = bVar.a;
            if (i3 == r1.a) {
                int i4 = 0;
                i iVar = null;
                while (iD < i2) {
                    iD = e.d(bArr, iD, bVar);
                    int i5 = bVar.a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (eVar != null) {
                                iD = e.a(z0.c.a(eVar.c.getClass()), bArr, iD, i2, bVar);
                                uVarEnsureExtensionsAreMutable.c(eVar.d, bVar.c);
                            } else if (i7 == 2) {
                                iD = e.a(bArr, iD, bVar);
                                iVar = (i) bVar.c;
                            }
                        }
                        if (i5 == r1.f1306b) {
                            break;
                        } else {
                            iD = e.a(i5, bArr, iD, i2, bVar);
                        }
                    } else if (i7 == 0) {
                        iD = e.d(bArr, iD, bVar);
                        i4 = bVar.a;
                        eVar = (GeneratedMessageLite.e) this.d.a(bVar.d, this.a, i4);
                    } else {
                        if (i5 == r1.f1306b) {
                            break;
                            break;
                        }
                        iD = e.a(i5, bArr, iD, i2, bVar);
                    }
                }
                if (iVar != null) {
                    l1VarC.a(r1.a(i4, 2), iVar);
                }
                i = iD;
            } else if ((i3 & 7) == 2) {
                GeneratedMessageLite.e eVar2 = (GeneratedMessageLite.e) this.d.a(bVar.d, this.a, i3 >>> 3);
                if (eVar2 != null) {
                    i = e.a(z0.c.a(eVar2.c.getClass()), bArr, iD, i2, bVar);
                    uVarEnsureExtensionsAreMutable.c(eVar2.d, bVar.c);
                } else {
                    i = e.a(i3, bArr, iD, i2, l1VarC, bVar);
                }
                eVar = eVar2;
            } else {
                i = e.a(i3, bArr, iD, i2, bVar);
            }
        }
        if (i != i2) {
            throw z.g();
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public void a(T t, c1 c1Var, q qVar) throws IOException {
        k1<?, ?> k1Var = this.f1307b;
        r<?> rVar = this.d;
        Object objA = k1Var.a(t);
        u uVarB = rVar.b(t);
        while (c1Var.s() != Integer.MAX_VALUE && a(c1Var, qVar, rVar, uVarB, k1Var, objA)) {
            try {
            } finally {
                k1Var.b(t, (Object) objA);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <UT, UB, ET extends u.b<ET>> boolean a(c1 c1Var, q qVar, r<ET> rVar, u<ET> uVar, k1<UT, UB> k1Var, UB ub) throws IOException {
        int iE = c1Var.e();
        if (iE != r1.a) {
            if ((iE & 7) == 2) {
                Object objA = rVar.a(qVar, this.a, iE >>> 3);
                if (objA != null) {
                    rVar.a(c1Var, objA, qVar, uVar);
                    return true;
                }
                return k1Var.a(ub, c1Var);
            }
            return c1Var.i();
        }
        int iC = 0;
        Object objA2 = null;
        i iVarA = null;
        while (c1Var.s() != Integer.MAX_VALUE) {
            int iE2 = c1Var.e();
            if (iE2 == r1.c) {
                iC = c1Var.c();
                objA2 = rVar.a(qVar, this.a, iC);
            } else if (iE2 == r1.d) {
                if (objA2 != null) {
                    rVar.a(c1Var, objA2, qVar, uVar);
                } else {
                    iVarA = c1Var.a();
                }
            } else if (!c1Var.i()) {
                break;
            }
        }
        if (c1Var.e() != r1.f1306b) {
            throw z.a();
        }
        if (iVarA != null) {
            if (objA2 != null) {
                rVar.a(iVarA, objA2, qVar, uVar);
            } else {
                k1Var.a(ub, iC, iVarA);
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public final boolean a(T t) {
        return this.d.a(t).e();
    }
}
