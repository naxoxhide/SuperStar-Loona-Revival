package com.bytedance.sdk.openadsdk.core.i0.m;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: ResourceHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final Set<String> a = new C0204a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set<String> f625b = new b();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.i0.m.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ResourceHelper.java */
    static class C0204a extends HashSet<String> {
        C0204a() {
            add("image/jpeg");
            add("image/png");
            add("image/bmp");
            add("image/gif");
            add("image/jpg");
        }
    }

    /* JADX INFO: compiled from: ResourceHelper.java */
    static class b extends HashSet<String> {
        b() {
            add("application/x-javascript");
        }
    }

    /* JADX INFO: compiled from: ResourceHelper.java */
    public enum c {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    /* JADX INFO: compiled from: ResourceHelper.java */
    public enum d {
        HTML_RESOURCE,
        STATIC_RESOURCE,
        IFRAME_RESOURCE
    }

    public static Point a(Context context, int i, int i2, d dVar) {
        if (context == null) {
            context = o.a();
        }
        Point point = new Point(i, i2);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int iA = b0.a(context, i);
        int iA2 = b0.a(context, i2);
        if (iA <= width && iA2 <= height) {
            return point;
        }
        Point point2 = new Point();
        if (d.HTML_RESOURCE == dVar) {
            point2.x = Math.min(width, iA);
            point2.y = Math.min(height, iA2);
        } else {
            float f = iA;
            float f2 = f / width;
            float f3 = iA2;
            float f4 = f3 / height;
            if (f2 >= f4) {
                point2.x = width;
                point2.y = (int) (f3 / f2);
            } else {
                point2.x = (int) (f / f4);
                point2.y = height;
            }
        }
        int i3 = point2.x;
        if (i3 < 0 || point2.y < 0) {
            return point;
        }
        point2.x = b0.b(context, i3);
        point2.y = b0.b(context, point2.y);
        return point2;
    }
}
