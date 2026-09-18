package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import android.graphics.Point;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.source.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d {
    public static final int[] e = new int[0];
    public final e.a c = null;
    public final AtomicReference<C0297b> d = new AtomicReference<>(new C0297b());

    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1195b;
        public final String c;

        public a(int i, int i2, String str) {
            this.a = i;
            this.f1195b = i2;
            this.c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f1195b == aVar.f1195b && TextUtils.equals(this.c, aVar.c);
        }

        public int hashCode() {
            int i = ((this.a * 31) + this.f1195b) * 31;
            String str = this.c;
            return i + (str != null ? str.hashCode() : 0);
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b$b, reason: collision with other inner class name */
    public static final class C0297b {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1196b;
        public final boolean c;
        public final boolean d;
        public final int e;
        public final int f;
        public final int g;
        public final boolean h;
        public final boolean i;
        public final int j;
        public final int k;
        public final boolean l;

        public C0297b() {
            this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0297b.class != obj.getClass()) {
                return false;
            }
            C0297b c0297b = (C0297b) obj;
            return this.c == c0297b.c && this.d == c0297b.d && this.e == c0297b.e && this.f == c0297b.f && this.h == c0297b.h && this.i == c0297b.i && this.l == c0297b.l && this.j == c0297b.j && this.k == c0297b.k && this.g == c0297b.g && TextUtils.equals(this.a, c0297b.a) && TextUtils.equals(this.f1196b, c0297b.f1196b);
        }

        public int hashCode() {
            return (((((((((((((((((((((this.a.hashCode() * 31) + this.f1196b.hashCode()) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + this.j) * 31) + this.k;
        }

        public C0297b(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
            this.a = null;
            this.f1196b = null;
            this.c = z;
            this.d = z2;
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.h = z3;
            this.i = z4;
            this.j = i4;
            this.k = i5;
            this.l = z5;
        }
    }

    public b(e.a aVar) {
    }

    public static int a(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    public static boolean a(int i, boolean z) {
        int i2 = i & 3;
        return i2 == 3 || (z && i2 == 2);
    }

    public static boolean a(i iVar, String str, int i, int i2, int i3, int i4, int i5) {
        if (!a(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !u.a(iVar.f, str)) {
            return false;
        }
        int i6 = iVar.j;
        if (i6 != -1 && i6 > i3) {
            return false;
        }
        int i7 = iVar.k;
        if (i7 != -1 && i7 > i4) {
            return false;
        }
        int i8 = iVar.f1156b;
        return i8 == -1 || i8 <= i5;
    }

    public static boolean a(i iVar, int i, a aVar) {
        if (!a(i, false) || iVar.r != aVar.a || iVar.s != aVar.f1195b) {
            return false;
        }
        String str = aVar.c;
        return str == null || TextUtils.equals(str, iVar.f);
    }

    public static boolean a(i iVar, String str) {
        if (str != null) {
            String str2 = iVar.y;
            int i = u.a;
            if (TextUtils.equals(str, str2 == null ? null : new Locale(str2).getLanguage())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0043  */
    public static List<Integer> a(r rVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        Point point;
        ArrayList arrayList = new ArrayList(rVar.a);
        for (int i6 = 0; i6 < rVar.a; i6++) {
            arrayList.add(Integer.valueOf(i6));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i7 = 0;
            int i8 = Integer.MAX_VALUE;
            while (true) {
                if (i7 >= rVar.a) {
                    break;
                }
                i iVar = rVar.f1191b[i7];
                int i9 = iVar.j;
                if (i9 > 0 && (i3 = iVar.k) > 0) {
                    if (!z) {
                        i4 = i;
                        i5 = i2;
                    } else if ((i9 > i3) != (i > i2)) {
                        i5 = i;
                        i4 = i2;
                    } else {
                        i4 = i;
                        i5 = i2;
                    }
                    int i10 = i9 * i5;
                    int i11 = i3 * i4;
                    if (i10 >= i11) {
                        point = new Point(i4, u.a(i11, i9));
                    } else {
                        point = new Point(u.a(i10, i3), i5);
                    }
                    int i12 = iVar.j;
                    int i13 = iVar.k;
                    int i14 = i12 * i13;
                    if (i12 >= ((int) (point.x * 0.98f)) && i13 >= ((int) (point.y * 0.98f)) && i14 < i8) {
                        i8 = i14;
                    }
                }
                i7++;
            }
            if (i8 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int iB = rVar.f1191b[((Integer) arrayList.get(size)).intValue()].b();
                    if (iB == -1 || iB > i8) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }
}
