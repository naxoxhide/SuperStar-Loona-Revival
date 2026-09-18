package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements TJTaskHandler {
    public final /* synthetic */ i a;

    public h(i iVar) {
        this.a = iVar;
    }

    @Override // com.tapjoy.TJTaskHandler
    public final void onComplete(Object obj) {
        i iVar = this.a;
        iVar.f2727b.invokeJSCallback(iVar.a, (Float) obj);
    }
}
