package com.applovin.exoplayer2.e.g;

import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class a {
    public final int bs;

    public static int cf(int i) {
        return (i >> 24) & 255;
    }

    public static int cg(int i) {
        return i & ViewCompat.MEASURED_SIZE_MASK;
    }

    public a(int i) {
        this.bs = i;
    }

    public String toString() {
        return ch(this.bs);
    }

    static final class b extends a {
        public final y zo;

        public b(int i, y yVar) {
            super(i);
            this.zo = yVar;
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.e.g.a$a, reason: collision with other inner class name */
    static final class C0089a extends a {
        public final long zl;
        public final List<b> zm;
        public final List<C0089a> zn;

        public C0089a(int i, long j) {
            super(i);
            this.zl = j;
            this.zm = new ArrayList();
            this.zn = new ArrayList();
        }

        public void a(b bVar) {
            this.zm.add(bVar);
        }

        public void a(C0089a c0089a) {
            this.zn.add(c0089a);
        }

        public b ci(int i) {
            int size = this.zm.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.zm.get(i2);
                if (bVar.bs == i) {
                    return bVar;
                }
            }
            return null;
        }

        public C0089a cj(int i) {
            int size = this.zn.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0089a c0089a = this.zn.get(i2);
                if (c0089a.bs == i) {
                    return c0089a;
                }
            }
            return null;
        }

        @Override // com.applovin.exoplayer2.e.g.a
        public String toString() {
            return ch(this.bs) + " leaves: " + Arrays.toString(this.zm.toArray()) + " containers: " + Arrays.toString(this.zn.toArray());
        }
    }

    public static String ch(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
