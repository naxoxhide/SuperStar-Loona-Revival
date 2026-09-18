package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: compiled from: VideoOnTouchLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private final b a;
    private float d;
    private float e;
    private int f;
    private int g;
    private boolean k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f702b = false;
    private boolean c = false;
    private boolean h = true;
    private boolean i = false;
    private final View.OnTouchListener j = new a();

    /* JADX INFO: compiled from: VideoOnTouchLayout.java */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.a.f()) {
                return d.this.f702b || !d.this.c;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                d dVar = d.this;
                dVar.k = dVar.a(motionEvent);
                d.this.d = x;
                d.this.e = y;
                d.this.f = (int) x;
                d.this.g = (int) y;
                d.this.h = true;
                if (d.this.a != null && d.this.c && !d.this.f702b) {
                    d.this.a.a(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - d.this.f) > 20.0f || Math.abs(y - d.this.g) > 20.0f) {
                    d.this.h = false;
                }
                if (!d.this.f702b) {
                    d.this.h = true;
                }
                d.this.i = false;
                d.this.d = 0.0f;
                d.this.e = 0.0f;
                d.this.f = 0;
                if (d.this.a != null) {
                    d.this.a.a(view, d.this.h);
                }
                d.this.k = false;
            } else if (action != 2) {
                if (action == 3) {
                    d.this.k = false;
                }
            } else if (d.this.f702b && !d.this.k) {
                float f = x - d.this.d;
                float f2 = y - d.this.e;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (!d.this.i) {
                    if (fAbs <= 20.0f && fAbs2 <= 20.0f) {
                        return true;
                    }
                    d.this.i = true;
                }
                if (d.this.a != null) {
                    d.this.a.b();
                }
                d.this.d = x;
                d.this.e = y;
            }
            return d.this.f702b || !d.this.c;
        }
    }

    /* JADX INFO: compiled from: VideoOnTouchLayout.java */
    public interface b {
        void a(View view, boolean z);

        void b();

        boolean f();
    }

    public d(b bVar) {
        this.a = bVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.j);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int i = b0.i(o.a().getApplicationContext());
        int iG = b0.g(o.a().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = i;
        if (rawX > f * 0.01f && rawX < f * 0.99f) {
            float f2 = iG;
            if (rawY > 0.01f * f2 && rawY < f2 * 0.99f) {
                return false;
            }
        }
        return true;
    }
}
