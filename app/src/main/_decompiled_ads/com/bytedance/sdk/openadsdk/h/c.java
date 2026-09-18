package com.bytedance.sdk.openadsdk.h;

import android.graphics.Bitmap;
import android.widget.ImageView;
import b.b.a.a.h.k;
import b.b.a.a.h.o;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.utils.y;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ImageLoaderToViewWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements o<Bitmap> {
    private WeakReference<ImageView> a;

    /* JADX INFO: compiled from: ImageLoaderToViewWrapper.java */
    class a implements Runnable {
        final /* synthetic */ ImageView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f773b;

        a(c cVar, ImageView imageView, Bitmap bitmap) {
            this.a = imageView;
            this.f773b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setImageBitmap(this.f773b);
        }
    }

    private c(ImageView imageView) {
        this.a = new WeakReference<>(imageView);
    }

    public static o a(q qVar, String str, ImageView imageView) {
        return new b(qVar, str, new c(imageView));
    }

    @Override // b.b.a.a.h.o
    public void a(int i, String str, Throwable th) {
    }

    @Override // b.b.a.a.h.o
    public void a(k<Bitmap> kVar) {
        ImageView imageView = this.a.get();
        if (imageView == null || !(kVar.c() instanceof Bitmap)) {
            return;
        }
        Bitmap bitmapC = kVar.c();
        if (y.g()) {
            imageView.setImageBitmap(bitmapC);
        } else {
            l.c().post(new a(this, imageView, bitmapC));
        }
    }
}
