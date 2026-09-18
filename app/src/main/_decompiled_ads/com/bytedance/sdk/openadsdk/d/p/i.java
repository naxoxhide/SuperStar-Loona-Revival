package com.bytedance.sdk.openadsdk.d.p;

/* JADX INFO: compiled from: NetResponseWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements b.b.a.a.i.a.n.d {
    private b.b.a.a.j.b a;

    public i(b.b.a.a.j.b bVar) {
        this.a = bVar;
    }

    @Override // b.b.a.a.i.a.n.d
    public int a() {
        b.b.a.a.j.b bVar = this.a;
        if (bVar != null) {
            return bVar.b();
        }
        return -1;
    }

    @Override // b.b.a.a.i.a.n.d
    public boolean b() {
        b.b.a.a.j.b bVar = this.a;
        if (bVar != null) {
            return bVar.g();
        }
        return false;
    }
}
