package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'n' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public final class l1 {
    public static final l1 c;
    public static final l1 d;
    public static final l1 e;
    public static final l1 f;
    public static final l1 g;
    public static final l1 h;
    public static final l1 i;
    public static final l1 j;
    public static final l1 k;
    public static final l1 l;
    public static final l1 m;
    public static final l1 n;
    public static final l1 o;
    public static final l1 p;
    public static final l1 q;
    public static final /* synthetic */ l1[] r;
    public final l1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l1 f2777b;

    /* JADX INFO: Fake field, exist only in values array */
    l1 EF6;

    static {
        l1 l1Var = new l1(0, "UNSPECIFIED");
        c = l1Var;
        l1 l1Var2 = new l1(1, "PORTRAIT");
        d = l1Var2;
        l1 l1Var3 = new l1(2, "LANDSCAPE");
        e = l1Var3;
        l1 l1Var4 = new l1(3, "SQUARE");
        l1 l1Var5 = new l1("NATURAL_PORTRAIT", 4, l1Var2);
        f = l1Var5;
        l1 l1Var6 = new l1("RIGHT_LANDSCAPE", 5, l1Var3, l1Var5);
        g = l1Var6;
        l1 l1Var7 = new l1("REVERSE_PORTRAIT", 6, l1Var2, l1Var5);
        h = l1Var7;
        l1 l1Var8 = new l1("LEFT_LANDSCAPE", 7, l1Var3, l1Var5);
        i = l1Var8;
        l1 l1Var9 = new l1("NATURAL_LANDSCAPE", 8, l1Var3);
        j = l1Var9;
        l1 l1Var10 = new l1("RIGHT_PORTRAIT", 9, l1Var2, l1Var9);
        k = l1Var10;
        l1 l1Var11 = new l1("REVERSE_LANDSCAPE", 10, l1Var3, l1Var9);
        l = l1Var11;
        l1 l1Var12 = new l1("LEFT_PORTRAIT", 11, l1Var2, l1Var9);
        m = l1Var12;
        l1 l1Var13 = new l1("NATURAL_SQUARE", 12, l1Var4);
        n = l1Var13;
        l1 l1Var14 = new l1("RIGHT_SQUARE", 13, l1Var4, l1Var13);
        o = l1Var14;
        l1 l1Var15 = new l1("REVERSE_SQUARE", 14, l1Var4, l1Var13);
        p = l1Var15;
        l1 l1Var16 = new l1("LEFT_SQUARE", 15, l1Var4, l1Var13);
        q = l1Var16;
        r = new l1[]{l1Var, l1Var2, l1Var3, l1Var4, l1Var5, l1Var6, l1Var7, l1Var8, l1Var9, l1Var10, l1Var11, l1Var12, l1Var13, l1Var14, l1Var15, l1Var16};
    }

    public l1(int i2, String str) {
        super(str, i2);
        this.a = this;
        this.f2777b = null;
    }

    public static l1 a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        Point point = new Point();
        k1.a(defaultDisplay, point);
        int i2 = point.x;
        int i3 = point.y;
        if (i2 < i3) {
            int i4 = rotation & 3;
            if (i4 == 1) {
                return k;
            }
            if (i4 != 2) {
                return i4 != 3 ? f : m;
            }
            return h;
        }
        if (i2 > i3) {
            int i5 = rotation & 3;
            if (i5 == 1) {
                return g;
            }
            if (i5 != 2) {
                return i5 != 3 ? j : i;
            }
            return l;
        }
        int i6 = rotation & 3;
        if (i6 == 1) {
            return o;
        }
        if (i6 != 2) {
            return i6 != 3 ? n : q;
        }
        return p;
    }

    public static l1 valueOf(String str) {
        return (l1) Enum.valueOf(l1.class, str);
    }

    public static l1[] values() {
        return (l1[]) r.clone();
    }

    public l1(String str, int i2, l1 l1Var) {
        super(str, i2);
        this.a = l1Var;
        this.f2777b = this;
    }

    public l1(String str, int i2, l1 l1Var, l1 l1Var2) {
        super(str, i2);
        this.a = l1Var;
        this.f2777b = l1Var2;
    }
}
