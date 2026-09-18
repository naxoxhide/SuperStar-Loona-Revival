package com.mbridge.msdk.dycreator.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;

/* JADX INFO: compiled from: InflaterUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {
    private static volatile f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.a.b f2006b;

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private f(Context context) {
        this.f2006b = null;
        com.mbridge.msdk.dycreator.a.b bVarA = com.mbridge.msdk.dycreator.a.b.a();
        this.f2006b = bVarA;
        bVarA.a(context, "");
    }

    public final View a(String str) {
        if (new File(str).exists()) {
            return this.f2006b.f(str);
        }
        return null;
    }

    public final View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null && !TextUtils.isEmpty(str)) {
            if (viewGroup.getId() == str.hashCode()) {
                return viewGroup;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getId() == str.hashCode()) {
                    return childAt;
                }
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, str);
                }
            }
        }
        return null;
    }
}
