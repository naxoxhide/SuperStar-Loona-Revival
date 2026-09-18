package com.fyber.inneractive.sdk.config.global;

/* JADX INFO: loaded from: classes2.dex */
public class f implements d {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f877b;

    public f(String str, boolean z) {
        this.a = str;
        this.f877b = z;
    }

    @Override // com.fyber.inneractive.sdk.config.global.d
    public boolean a(e eVar) {
        String str = this.a;
        if (str != null) {
            return str.equalsIgnoreCase("android") ? !this.f877b : this.f877b;
        }
        return false;
    }

    public String toString() {
        return String.format("%s - %s include: %b", "os", this.a, Boolean.valueOf(this.f877b));
    }
}
