package com.mbridge.msdk.video.dynview.i.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.f.b;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.video.dynview.c;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ChoiceOneDrawBitBg.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static volatile a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f2496b;
    private Bitmap c;
    private Bitmap d;

    private a() {
    }

    public static a a() {
        a aVar;
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
                aVar = a;
            }
            return aVar;
        }
        return a;
    }

    public final void a(Map<String, Bitmap> map, c cVar, View view) {
        if (view == null || cVar == null || map == null || map.size() == 0 || map.size() < 2 || cVar.g() == null || cVar.g().size() < 2) {
            return;
        }
        this.f2496b = view;
        int iE = cVar.e();
        float fD = cVar.d();
        float fC = cVar.c();
        try {
            List<CampaignEx> listG = cVar.g();
            String md5 = listG.get(0) != null ? SameMD5.getMD5(listG.get(0).getImageUrl()) : "";
            String md6 = listG.get(1) != null ? SameMD5.getMD5(listG.get(1).getImageUrl()) : "";
            Bitmap bitmap = (TextUtils.isEmpty(md5) || !map.containsKey(md5)) ? null : map.get(md5);
            Bitmap bitmap2 = (TextUtils.isEmpty(md6) || !map.containsKey(md6)) ? null : map.get(md6);
            if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            a(iE, fD, fC, bitmap, bitmap2);
        } catch (Exception e) {
            aa.d("ChoiceOneDrawBitBg", e.getMessage());
        }
    }

    private synchronized void a(final int i, final float f, final float f2, final Bitmap bitmap, Bitmap bitmap2) {
        try {
            b.d().execute(new Runnable() { // from class: com.mbridge.msdk.video.dynview.i.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Bitmap bitmapA = l.a(bitmap, 10);
                        Bitmap bitmapA2 = l.a(bitmap, 10);
                        final com.mbridge.msdk.video.dynview.g.a.C0517a c0517aA = com.mbridge.msdk.video.dynview.g.a.a();
                        c0517aA.a(i).a(bitmapA).b(bitmapA2);
                        if (i == 2) {
                            float f3 = f;
                            float f4 = f2;
                            if (f3 > f4) {
                                c0517aA.a(f3).b(f2);
                            } else {
                                c0517aA.a(f4).b(f);
                            }
                        } else {
                            c0517aA.a(f).b(f2);
                        }
                        if (a.this.f2496b != null) {
                            a.this.f2496b.post(new Runnable() { // from class: com.mbridge.msdk.video.dynview.i.a.a.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (a.this.f2496b == null || c0517aA.a() == null) {
                                        return;
                                    }
                                    a.this.f2496b.setBackground(c0517aA.a());
                                }
                            });
                        }
                    } catch (Exception e) {
                        aa.d("ChoiceOneDrawBitBg", e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            aa.a("ChoiceOneDrawBitBg", e.getMessage());
        }
    }

    public final void b() {
        if (this.f2496b != null) {
            this.f2496b = null;
        }
        Bitmap bitmap = this.c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
        Bitmap bitmap2 = this.d;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.d.recycle();
        this.d = null;
    }
}
