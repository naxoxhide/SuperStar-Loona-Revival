package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i3 {
    public static r4 a() {
        return new r4(Collections.emptyList());
    }

    public static List a(String str, AbstractList abstractList) {
        List list;
        if (abstractList == null) {
            throw new NullPointerException(str.concat(" == null"));
        }
        if (abstractList instanceof r4) {
            list = abstractList;
            list = ((r4) abstractList).f2807b;
        }
        list = abstractList;
        if (list == Collections.emptyList() || (list instanceof x2)) {
            return list;
        }
        x2 x2Var = new x2(list);
        if (x2Var.contains(null)) {
            throw new IllegalArgumentException(str.concat(".contains(null)"));
        }
        return x2Var;
    }

    public static boolean a(Serializable serializable, Serializable serializable2) {
        return serializable == serializable2 || (serializable != null && serializable.equals(serializable2));
    }

    public static void a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        String str = "";
        for (int i = 0; i < length; i += 2) {
            if (objArr[i] == null) {
                if (sb.length() > 0) {
                    str = "s";
                }
                sb.append("\n  ");
                sb.append(objArr[i + 1]);
            }
        }
        throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
    }
}
