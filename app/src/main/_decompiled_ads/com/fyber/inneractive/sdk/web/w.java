package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements View.OnTouchListener {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f1373b;
    public float c;
    public float d;

    public interface a {
    }

    public w(a aVar, Context context) {
        this.a = aVar;
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a != null) {
            if (motionEvent.getActionMasked() == 0) {
                ((d) this.a).j();
                this.f1373b = motionEvent.getX();
                this.c = motionEvent.getY();
            } else if (motionEvent.getActionMasked() == 3) {
                ((d) this.a).j();
                this.c = -1.0f;
                this.f1373b = -1.0f;
            } else if (motionEvent.getActionMasked() == 1) {
                float f = this.f1373b;
                if (f >= 0.0f && this.c >= 0.0f) {
                    float fRound = Math.round(Math.abs(f - motionEvent.getX()));
                    float fRound2 = Math.round(Math.abs(this.c - motionEvent.getY()));
                    float f2 = this.d;
                    if (fRound < f2 && fRound2 < f2) {
                        d dVar = (d) this.a;
                        dVar.getClass();
                        IAlog.a("IAWebViewController onClicked()", new Object[0]);
                        if (dVar.l != null) {
                            IAlog.d("Native click detected in time. Processing pending click", new Object[0]);
                            dVar.l.d();
                            Runnable runnable = dVar.m;
                            if (runnable != null) {
                                com.fyber.inneractive.sdk.util.m.f1343b.removeCallbacks(runnable);
                            }
                            dVar.l = null;
                            dVar.j();
                        } else {
                            if (dVar.n != null) {
                                com.fyber.inneractive.sdk.util.m.f1343b.postDelayed(dVar.n, IAConfigManager.M.u.f886b.a("click_timeout", 1000, 1000));
                            }
                            dVar.j = true;
                        }
                    }
                    this.f1373b = -1.0f;
                    this.c = -1.0f;
                }
            }
        }
        return false;
    }
}
