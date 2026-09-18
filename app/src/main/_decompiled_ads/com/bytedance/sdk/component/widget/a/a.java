package com.bytedance.sdk.component.widget.a;

/* JADX INFO: compiled from: BaseAdapterInstance.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f365b;
    private volatile b a;

    private a() {
    }

    public static a a() {
        if (f365b == null) {
            synchronized (a.class) {
                if (f365b == null) {
                    f365b = new a();
                }
            }
        }
        return f365b;
    }

    public b b() {
        return this.a;
    }

    public void a(b bVar) {
        this.a = bVar;
    }
}
