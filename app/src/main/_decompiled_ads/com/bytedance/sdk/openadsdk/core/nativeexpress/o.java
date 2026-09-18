package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: ViewGestureDetector.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends GestureDetector {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.c0.f f660b;

    /* JADX INFO: compiled from: ViewGestureDetector.java */
    static class a extends GestureDetector.SimpleOnGestureListener {
        boolean a = false;

        a() {
        }

        boolean a() {
            return this.a;
        }

        void b() {
            this.a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }

    public o(Context context) {
        this(context, new a());
    }

    public boolean a() {
        return this.a.a();
    }

    void b() {
        this.a.b();
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f660b.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public o(Context context, a aVar) {
        super(context, aVar);
        this.a = aVar;
        this.f660b = new com.bytedance.sdk.openadsdk.core.c0.f();
        setIsLongpressEnabled(false);
    }

    public com.bytedance.sdk.openadsdk.core.f0.i a(Context context, View view, View view2) {
        com.bytedance.sdk.openadsdk.core.c0.f fVar = this.f660b;
        if (fVar == null) {
            return new com.bytedance.sdk.openadsdk.core.f0.i.b().a();
        }
        return new com.bytedance.sdk.openadsdk.core.f0.i.b().b(fVar.a).c(this.f660b.f566b).e(this.f660b.c).f(this.f660b.d).a(this.f660b.e).b(this.f660b.f).c(b0.a(view)).a(b0.a(view2)).d(b0.c(view)).b(b0.c(view2)).f(this.f660b.g).c(this.f660b.h).e(this.f660b.i).a(this.f660b.j).d(com.bytedance.sdk.openadsdk.core.h.a().s() ? 1 : 2).a("vessel").a(b0.a(context)).b(b0.b(context)).d(b0.f(context)).a();
    }
}
