package com.kakao.adfit.d;

import kotlin.Metadata;

/* JADX INFO: compiled from: IImageAdView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/kakao/adfit/d/f;", "", "", "updateImageAdImage", "updateImageAdSize", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface f {

    /* JADX INFO: compiled from: IImageAdView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static void a(f fVar) {
            fVar.updateImageAdImage();
            fVar.updateImageAdSize();
        }
    }

    void updateImageAdImage();

    void updateImageAdSize();
}
