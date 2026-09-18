package com.kakao.adfit.d;

import android.graphics.drawable.Drawable;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageTypeMediaAdViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R.\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\u0003\u0010\n\"\u0004\b\u0003\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\b\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/kakao/adfit/d/n;", "Lcom/kakao/adfit/d/h;", "Lcom/kakao/adfit/d/f;", "a", "Lcom/kakao/adfit/d/f;", "view", "Landroid/graphics/drawable/Drawable;", "value", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "imageDrawable", "", "c", "I", "()I", "imageWidth", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "imageHeight", "Lcom/kakao/adfit/d/p$c;", "image", "<init>", "(Lcom/kakao/adfit/d/f;Lcom/kakao/adfit/d/p$c;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class n implements h {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final f view;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Drawable imageDrawable;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int imageWidth;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int imageHeight;

    public n(f view, p.c image) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(image, "image");
        this.view = view;
        this.imageWidth = image.getWidth();
        this.imageHeight = image.getHeight();
    }

    @Override // com.kakao.adfit.d.g
    /* JADX INFO: renamed from: a, reason: from getter */
    public Drawable getImageDrawable() {
        return this.imageDrawable;
    }

    @Override // com.kakao.adfit.d.g
    /* JADX INFO: renamed from: b, reason: from getter */
    public int getImageHeight() {
        return this.imageHeight;
    }

    @Override // com.kakao.adfit.d.g
    /* JADX INFO: renamed from: c, reason: from getter */
    public int getImageWidth() {
        return this.imageWidth;
    }

    @Override // com.kakao.adfit.d.i
    public int j() {
        return h.a.a(this);
    }

    public void a(Drawable drawable) {
        if (Intrinsics.areEqual(this.imageDrawable, drawable)) {
            return;
        }
        this.imageDrawable = drawable;
        this.view.updateImageAdImage();
    }
}
