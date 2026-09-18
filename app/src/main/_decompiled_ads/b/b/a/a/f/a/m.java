package b.b.a.a.f.a;

/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f151b;
    public byte[] c;
    public a d;

    /* JADX INFO: compiled from: RequestBody.java */
    public enum a {
        STRING_TYPE,
        BYTE_ARRAY_TYPE
    }

    public m() {
    }

    public String a() {
        return this.f151b;
    }

    public m(i iVar, String str, a aVar) {
        this.a = iVar;
        this.f151b = str;
        this.d = aVar;
    }

    public static m a(i iVar, String str) {
        return new m(iVar, str, a.STRING_TYPE);
    }

    public static m a(i iVar, byte[] bArr) {
        return new m(iVar, bArr, a.BYTE_ARRAY_TYPE);
    }

    public m(i iVar, byte[] bArr, a aVar) {
        this.a = iVar;
        this.c = bArr;
        this.d = aVar;
    }
}
