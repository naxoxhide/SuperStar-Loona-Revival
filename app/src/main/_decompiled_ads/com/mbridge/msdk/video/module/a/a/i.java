package com.mbridge.msdk.video.module.a.a;

/* JADX INFO: compiled from: ProxyOnNotifyListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class i extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.mbridge.msdk.video.module.a.a f2547b;

    public i(com.mbridge.msdk.video.module.a.a aVar) {
        this.f2547b = aVar;
    }

    @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i, Object obj) {
        super.a(i, obj);
        com.mbridge.msdk.video.module.a.a aVar = this.f2547b;
        if (aVar != null) {
            aVar.a(i, obj);
        }
    }
}
