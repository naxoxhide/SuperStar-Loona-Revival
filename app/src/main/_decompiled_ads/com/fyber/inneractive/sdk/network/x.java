package com.fyber.inneractive.sdk.network;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static final x c = new x();
    public final g a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f998b;

    public static x a() {
        return c;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0024  */
    public g b() {
        String property;
        boolean z;
        boolean z2;
        if (this.f998b == null) {
            try {
                property = System.getProperty("fyber.marketplace.http_executor_stack_name");
            } catch (Throwable unused) {
                property = "hurl";
            }
            if (property != null && property.equals("okhttp")) {
                try {
                    Class.forName("okhttp3.OkHttpClient");
                    z2 = true;
                } catch (ClassNotFoundException unused2) {
                    z2 = false;
                }
                z = z2;
            }
            if (z) {
                this.f998b = new v0();
            }
        }
        g gVar = this.f998b;
        return gVar != null ? gVar : this.a;
    }
}
