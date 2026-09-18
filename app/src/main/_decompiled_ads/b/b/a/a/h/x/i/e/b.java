package b.b.a.a.h.x.i.e;

import android.graphics.Bitmap;
import android.os.Build;
import b.b.a.a.h.q;

/* JADX INFO: compiled from: LruCountBitmapCache.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements q {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.h.x.i.c<String, Bitmap> f185b;

    /* JADX INFO: compiled from: LruCountBitmapCache.java */
    class a extends b.b.a.a.h.x.i.c<String, Bitmap> {
        a(b bVar, int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // b.b.a.a.h.x.i.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int c(String str, Bitmap bitmap) {
            if (bitmap == null) {
                return 0;
            }
            return b.a(bitmap);
        }
    }

    public b(int i, int i2) {
        this.a = i2;
        this.f185b = new a(this, i);
    }

    @Override // b.b.a.a.h.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap get(String str) {
        return this.f185b.b(str);
    }

    @Override // b.b.a.a.h.a
    public boolean a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.f185b.a(str, bitmap);
        return true;
    }

    public static int a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (i >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}
