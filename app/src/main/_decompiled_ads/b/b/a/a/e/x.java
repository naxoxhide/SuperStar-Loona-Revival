package b.b.a.a.e;

/* JADX INFO: compiled from: PermissionGroup.java */
/* JADX INFO: loaded from: classes.dex */
public enum x {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    @Override // java.lang.Enum
    public String toString() {
        if (this == PRIVATE) {
            return "private";
        }
        return this == PROTECTED ? "protected" : "public";
    }
}
