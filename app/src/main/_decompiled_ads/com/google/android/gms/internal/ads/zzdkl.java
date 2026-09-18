package com.google.android.gms.internal.ads;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdkl implements GestureDetector.OnGestureListener {
    private final zzdje zza;
    private final zzdkf zzb;

    zzdkl(zzdje zzdjeVar, zzdkf zzdkfVar) {
        this.zza = zzdjeVar;
        this.zzb = zzdkfVar;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0061  */
    @Override // android.view.GestureDetector.OnGestureListener
    public final synchronized boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int y;
        if (this.zza == null) {
            return false;
        }
        int i = -1;
        if (Math.abs(f) > Math.abs(f2)) {
            if (f > 0.0f) {
                y = (int) (((motionEvent2.getX() - motionEvent.getX()) / f) * 1000.0f);
                i = 1;
            } else if (f < 0.0f) {
                y = (int) (((motionEvent2.getX() - motionEvent.getX()) / f) * 1000.0f);
                i = 2;
            } else {
                y = 0;
            }
        } else if (f2 > 0.0f) {
            y = (int) (((motionEvent2.getY() - motionEvent.getY()) / f2) * 1000.0f);
            i = 8;
        } else if (f2 < 0.0f) {
            y = (int) (((motionEvent2.getY() - motionEvent.getY()) / f2) * 1000.0f);
            i = 4;
        } else {
            y = 0;
        }
        if (i != this.zza.zza()) {
            return false;
        }
        this.zza.zzC(this.zzb.zzr(), y);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final synchronized boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
