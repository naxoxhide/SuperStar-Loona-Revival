package com.tnkfactory.ad.pub.a;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes4.dex */
public final class a1 extends GestureDetector {
    public b a;

    public static class b extends GestureDetector.SimpleOnGestureListener {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f2862b;

        public b() {
            this.a = 0L;
            this.f2862b = null;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            this.a = 0L;
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.a <= 1500) {
                return false;
            }
            this.a = jCurrentTimeMillis;
            c cVar = this.f2862b;
            if (cVar == null) {
                return false;
            }
            j.a(((k) cVar).a);
            return false;
        }
    }

    public interface c {
    }

    public a1(Context context) {
        this(context, new b());
    }

    public a1(Context context, b bVar) {
        super(context, bVar);
        this.a = bVar;
    }

    public final boolean a() {
        b bVar = this.a;
        bVar.getClass();
        boolean z = System.currentTimeMillis() - bVar.a < 500;
        bVar.a = 0L;
        return z;
    }
}
