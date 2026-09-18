package b.b.a.a.d.d.h;

import java.util.Arrays;

/* JADX INFO: compiled from: DynamicPoint.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f92b;

    public i(float f, float f2) {
        this.a = f;
        this.f92b = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return Float.compare(iVar.a, this.a) == 0 && Float.compare(iVar.f92b, this.f92b) == 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a), Float.valueOf(this.f92b)});
    }
}
