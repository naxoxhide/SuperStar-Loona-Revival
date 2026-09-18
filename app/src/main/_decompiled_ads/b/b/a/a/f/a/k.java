package b.b.a.a.f.a;

/* JADX INFO: compiled from: Protocol.java */
/* JADX INFO: loaded from: classes.dex */
public enum k {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String a;

    k(String str) {
        this.a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
