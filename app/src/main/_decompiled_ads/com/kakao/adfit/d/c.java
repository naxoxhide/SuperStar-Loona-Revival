package com.kakao.adfit.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.ads.R;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ViewBindings.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010\n\u001a\u0004\u0018\u00010 \u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0014R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015¨\u0006#"}, d2 = {"Lcom/kakao/adfit/d/c;", "Lcom/kakao/adfit/d/y;", "Lcom/kakao/adfit/d/r$c;", "", "url", "Lcom/kakao/adfit/k/k;", "loadingDisposer", "", "a", "Landroid/graphics/Bitmap;", "image", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "g", "Landroid/widget/ImageView;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/widget/ImageView;", "view", "", "c", "I", "defaultResId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "errorResId", "Lcom/kakao/adfit/k/k;", "disposer", InneractiveMediationDefs.GENDER_FEMALE, "imageWidth", "imageHeight", "Lcom/kakao/adfit/d/r;", "loader", "Lcom/kakao/adfit/d/p$c;", "<init>", "(Landroid/widget/ImageView;Lcom/kakao/adfit/d/r;Lcom/kakao/adfit/d/p$c;II)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class c extends y implements r.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ImageView view;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int defaultResId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int errorResId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private com.kakao.adfit.k.k disposer;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final int imageWidth;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final int imageHeight;

    /* JADX INFO: compiled from: ViewBindings.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/kakao/adfit/d/c$a", "Landroid/graphics/drawable/BitmapDrawable;", "", "getIntrinsicWidth", "getIntrinsicHeight", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class a extends BitmapDrawable {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1740b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Bitmap bitmap, int i, int i2, Resources resources) {
            super(resources, bitmap);
            this.a = i;
            this.f1740b = i2;
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.f1740b;
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.a;
        }
    }

    public c(ImageView view, r loader, p.c cVar, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.view = view;
        this.defaultResId = i;
        this.errorResId = i2;
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription == null || StringsKt.isBlank(contentDescription)) {
            view.setContentDescription(view.getResources().getString(R.string.adfit_ad_info_description));
        }
        if (cVar != null) {
            this.imageWidth = cVar.getWidth();
            this.imageHeight = cVar.getHeight();
            loader.a(cVar.getUrl(), this);
        } else {
            this.imageWidth = 0;
            this.imageHeight = 0;
            if (i != 0) {
                view.setImageResource(i);
            }
        }
    }

    @Override // com.kakao.adfit.d.r.c
    public void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // com.kakao.adfit.d.r.c
    public void a(String url, com.kakao.adfit.k.k loadingDisposer) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(loadingDisposer, "loadingDisposer");
        this.disposer = loadingDisposer;
        int i = this.defaultResId;
        if (i != 0) {
            this.view.setImageResource(i);
        }
    }

    @Override // com.kakao.adfit.d.y
    protected void g() {
        com.kakao.adfit.k.k kVar = this.disposer;
        if (kVar != null) {
            kVar.a();
        }
        this.disposer = null;
    }

    @Override // com.kakao.adfit.d.r.c
    public void a(String url, Bitmap image) {
        int i;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(image, "image");
        this.disposer = null;
        int i2 = this.imageWidth;
        if (i2 > 0 && (i = this.imageHeight) > 0) {
            if (((float) i2) / ((float) i) == ((float) image.getWidth()) / ((float) image.getHeight())) {
                float f = this.view.getContext().getResources().getDisplayMetrics().density;
                this.view.setImageDrawable(new a(image, MathKt.roundToInt(this.imageWidth * f), MathKt.roundToInt(this.imageHeight * f), this.view.getResources()));
                return;
            }
        }
        this.view.setImageBitmap(image);
    }

    @Override // com.kakao.adfit.d.r.c
    public void a(String url, Exception e) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(e, "e");
        this.disposer = null;
        int i = this.errorResId;
        if (i != 0) {
            this.view.setImageResource(i);
        }
    }
}
