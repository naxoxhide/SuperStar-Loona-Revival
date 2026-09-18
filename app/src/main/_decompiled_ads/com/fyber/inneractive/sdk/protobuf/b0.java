package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {
    public volatile o0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile i f1276b;

    static {
        q.a();
    }

    public i a() {
        if (this.f1276b != null) {
            return this.f1276b;
        }
        synchronized (this) {
            if (this.f1276b != null) {
                return this.f1276b;
            }
            if (this.a == null) {
                this.f1276b = i.f1293b;
            } else {
                this.f1276b = this.a.toByteString();
            }
            return this.f1276b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        o0 o0Var = this.a;
        o0 o0Var2 = b0Var.a;
        if (o0Var == null && o0Var2 == null) {
            return a().equals(b0Var.a());
        }
        if (o0Var == null || o0Var2 == null) {
            return o0Var != null ? o0Var.equals(b0Var.a(o0Var.getDefaultInstanceForType())) : a(o0Var2.getDefaultInstanceForType()).equals(o0Var2);
        }
        return o0Var.equals(o0Var2);
    }

    public int hashCode() {
        return 1;
    }

    public o0 a(o0 o0Var) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    try {
                        this.a = o0Var;
                        this.f1276b = i.f1293b;
                    } catch (z unused) {
                        this.a = o0Var;
                        this.f1276b = i.f1293b;
                    }
                }
            }
        }
        return this.a;
    }
}
