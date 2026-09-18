package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements b, SurfaceHolder.Callback {
    private static final ArrayList<c> d = new ArrayList<>();
    private WeakReference<a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f261b;
    private b.a c;

    public SSRenderSurfaceView(Context context) {
        super(context);
        b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_SurfaceView", "SSRenderSurfaceView: ");
        a();
    }

    private void a() {
        c cVar = new c(this);
        this.f261b = cVar;
        d.add(cVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.b
    public View getView() {
        return this;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b.a aVar = this.c;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.c = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_SurfaceView", "surfaceChanged: ");
        WeakReference<a> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().surfaceChanged(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().surfaceCreated(surfaceHolder);
        }
        b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_SurfaceView", "surfaceCreated: ");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b.a.a.a.a.a.a.i.c.c("CSJ_VIDEO_SurfaceView", "surfaceDestroyed: ");
        WeakReference<a> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().surfaceDestroyed(surfaceHolder);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.b
    public void a(a aVar) {
        this.a = new WeakReference<>(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<c> it = d.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.a() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.f261b);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.b
    public void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }
}
