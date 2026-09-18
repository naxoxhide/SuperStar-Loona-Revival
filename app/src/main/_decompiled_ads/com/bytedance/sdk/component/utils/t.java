package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: ResourceHelp.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t {
    private static String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Resources f330b;
    private static Context c;

    public static void a(String str) {
        a = str;
    }

    public static void b(Context context) {
        c = context;
    }

    public static int c(Context context, String str) {
        return context.getResources().getColor(b(context, str));
    }

    public static int d(Context context, String str) {
        return a(context, str, "dimen");
    }

    public static int e(Context context, String str) {
        return a(context, str, "drawable");
    }

    public static Drawable f(Context context, String str) {
        return context.getResources().getDrawable(e(context, str));
    }

    public static int g(Context context, String str) {
        return a(context, str, "id");
    }

    public static int h(Context context, String str) {
        return a(context, str, "integer");
    }

    public static int i(Context context, String str) {
        return context.getResources().getInteger(h(context, str));
    }

    public static int j(Context context, String str) {
        return a(context, str, "string");
    }

    public static String k(Context context, String str) {
        Context context2 = c;
        return context2 == null ? context.getResources().getString(j(context, str)) : context2.getResources().getString(j(c, str));
    }

    public static int l(Context context, String str) {
        return a(context, str, "style");
    }

    private static String a(Context context) {
        if (a == null) {
            a = context.getPackageName();
        }
        return a;
    }

    public static int b(Context context, String str) {
        return a(context, str, "color");
    }

    private static int a(Context context, String str, String str2) {
        if (f330b == null) {
            f330b = context.getResources();
        }
        return f330b.getIdentifier(str, str2, a(context));
    }

    public static int a(Context context, String str) {
        return a(context, str, "anim");
    }
}
