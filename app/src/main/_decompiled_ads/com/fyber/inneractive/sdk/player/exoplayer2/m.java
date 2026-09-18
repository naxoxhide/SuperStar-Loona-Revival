package com.fyber.inneractive.sdk.player.exoplayer2;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final m d = new m(1.0f, 1.0f);
    public final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1157b;
    public final int c;

    public m(float f, float f2) {
        this.a = f;
        this.f1157b = f2;
        this.c = Math.round(f * 1000.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.a == mVar.a && this.f1157b == mVar.f1157b;
    }

    public int hashCode() {
        return ((Float.floatToRawIntBits(this.a) + 527) * 31) + Float.floatToRawIntBits(this.f1157b);
    }
}
