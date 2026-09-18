package com.bytedance.sdk.openadsdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: ImageBytesHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: compiled from: ImageBytesHelper.java */
    public interface b {
        void a();

        void a(com.bytedance.sdk.openadsdk.n.d.b bVar);

        void b();
    }

    public static void a(com.bytedance.sdk.openadsdk.n.a aVar, int i, int i2, b bVar, String str) {
        a(aVar, i, i2, bVar, str, 0);
    }

    public static void a(com.bytedance.sdk.openadsdk.n.a aVar, int i, int i2, b bVar, String str, int i3) {
        com.bytedance.sdk.component.utils.m.b("splashLoadAd", " getImageBytes url " + aVar);
        com.bytedance.sdk.openadsdk.n.c.b().c().a(aVar, new a(bVar), i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3, null);
    }

    public static Drawable a(byte[] bArr, int i) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }
        return new ColorDrawable(0);
    }

    /* JADX INFO: compiled from: ImageBytesHelper.java */
    static class a implements com.bytedance.sdk.openadsdk.n.d.a.c {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.bytedance.sdk.openadsdk.n.d.a.c
        public void a(String str, com.bytedance.sdk.openadsdk.n.d.b bVar) {
            b bVar2;
            if (bVar.b() && (bVar2 = this.a) != null) {
                bVar2.a(bVar);
                return;
            }
            b bVar3 = this.a;
            if (bVar3 != null) {
                bVar3.b();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.n.d.a.c
        public void a(int i, String str, Throwable th) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.n.d.a.c
        public void a() {
            b bVar = this.a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }
}
