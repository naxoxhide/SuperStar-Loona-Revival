package com.bykv.vk.openvk.component.video.api.renderview;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

/* JADX INFO: compiled from: IRenderCallback.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2);

    boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);

    void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2);

    void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);

    void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    void surfaceCreated(SurfaceHolder surfaceHolder);

    void surfaceDestroyed(SurfaceHolder surfaceHolder);
}
