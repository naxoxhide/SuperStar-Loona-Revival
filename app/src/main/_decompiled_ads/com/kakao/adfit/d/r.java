package com.kakao.adfit.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.common.volley.VolleyError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: NativeAdImageLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0006\u0005\r\u0012!\"#B/\b\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001b\u0010\u001cB\u0019\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001b\u0010\u001fB#\b\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001b\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0016¨\u0006$"}, d2 = {"Lcom/kakao/adfit/d/r;", "", "Lcom/kakao/adfit/d/r$e;", "callback", "", "a", "", "url", "Lcom/kakao/adfit/d/r$c;", "Ljava/lang/String;", "mediaImageUrl", "", "Lcom/kakao/adfit/d/r$b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/Map;", "holders", "Lcom/kakao/adfit/n/h;", "kotlin.jvm.PlatformType", "c", "Lcom/kakao/adfit/n/h;", "loader", "", "()Z", "isPrepared", "isMediaImagePrepared", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/kakao/adfit/d/p;", "nativeAd", "(Landroid/content/Context;Lcom/kakao/adfit/d/p;)V", "(Landroid/content/Context;Ljava/lang/String;Lcom/kakao/adfit/d/p;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "e", InneractiveMediationDefs.GENDER_FEMALE, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class r {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String mediaImageUrl;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, b> holders;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final com.kakao.adfit.n.h loader;

    /* JADX INFO: compiled from: NativeAdImageLoader.kt */
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0007\u0010\u000f\"\u0004\b\u0007\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/kakao/adfit/d/r$b;", "", "Lcom/kakao/adfit/n/h;", "loader", "Lcom/kakao/adfit/d/r$c;", "callback", "", "a", "", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/lang/String;", "url", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "image", "", "c", "()Z", "isImageLoaded", "<init>", "(Ljava/lang/String;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class b {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final String url;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private Bitmap image;

        /* JADX INFO: compiled from: Disposable.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\n"}, d2 = {"com/kakao/adfit/d/r$b$a", "Lcom/kakao/adfit/k/k;", "", "a", "", "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "()Z", "isDisposed", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
        public static final class a implements com.kakao.adfit.k.k {

            /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
            private boolean isDisposed;
            final /* synthetic */ com.kakao.adfit.n.h.f c;
            final /* synthetic */ d d;
            final /* synthetic */ b e;

            public a(com.kakao.adfit.n.h.f fVar, d dVar, b bVar) {
                this.c = fVar;
                this.d = dVar;
                this.e = bVar;
            }

            @Override // com.kakao.adfit.k.k
            public void a() {
                if (getIsDisposed()) {
                    return;
                }
                this.isDisposed = true;
                this.c.a();
                this.d.a(this.e.getUrl());
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public boolean getIsDisposed() {
                return this.isDisposed;
            }
        }

        public b(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final Bitmap getImage() {
            return this.image;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final boolean c() {
            return this.image != null;
        }

        public final void a(Bitmap bitmap) {
            this.image = bitmap;
        }

        public final void a(com.kakao.adfit.n.h loader, c callback) {
            Intrinsics.checkNotNullParameter(loader, "loader");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Bitmap bitmap = this.image;
            if (bitmap != null) {
                callback.a(this.url, bitmap);
                return;
            }
            d dVar = new d(callback);
            com.kakao.adfit.n.h.f fVarA = loader.a(this.url, new C0454b(dVar));
            if (fVarA.b() == null) {
                String str = this.url;
                com.kakao.adfit.k.k.Companion companion = com.kakao.adfit.k.k.INSTANCE;
                dVar.a(str, new a(fVarA, dVar, this));
            }
        }

        /* JADX INFO: renamed from: com.kakao.adfit.d.r$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NativeAdImageLoader.kt */
        @Metadata(bv = {}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"com/kakao/adfit/d/r$b$b", "Lcom/kakao/adfit/n/h$g;", "Lcom/kakao/adfit/n/h$f;", "Lcom/kakao/adfit/n/h;", "response", "", "isImmediate", "", "a", "Lcom/kakao/adfit/common/volley/VolleyError;", "error", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
        public static final class C0454b implements com.kakao.adfit.n.h.g {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f1763b;

            C0454b(d dVar) {
                this.f1763b = dVar;
            }

            @Override // com.kakao.adfit.n.h.g
            public void a(com.kakao.adfit.n.h.f response, boolean isImmediate) {
                Intrinsics.checkNotNullParameter(response, "response");
                Bitmap bitmapB = response.b();
                if (bitmapB == null) {
                    return;
                }
                b.this.a(bitmapB);
                this.f1763b.a(b.this.getUrl(), bitmapB);
            }

            @Override // com.kakao.adfit.common.volley.g.a
            public void a(VolleyError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Bitmap image = b.this.getImage();
                if (image != null) {
                    this.f1763b.a(b.this.getUrl(), image);
                } else {
                    this.f1763b.a(b.this.getUrl(), error);
                }
            }
        }
    }

    /* JADX INFO: compiled from: NativeAdImageLoader.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\f\u001a\u00060\nj\u0002`\u000bH&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/d/r$c;", "", "", "url", "Lcom/kakao/adfit/k/k;", "loadingDisposer", "", "a", "Landroid/graphics/Bitmap;", "image", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public interface c {

        /* JADX INFO: compiled from: NativeAdImageLoader.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            public static void a(c cVar, String url) {
                Intrinsics.checkNotNullParameter(url, "url");
            }

            public static void a(c cVar, String url, com.kakao.adfit.k.k loadingDisposer) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(loadingDisposer, "loadingDisposer");
            }
        }

        void a(String url);

        void a(String url, Bitmap image);

        void a(String url, com.kakao.adfit.k.k loadingDisposer);

        void a(String url, Exception e);
    }

    /* JADX INFO: compiled from: NativeAdImageLoader.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/kakao/adfit/d/r$d;", "Lcom/kakao/adfit/d/r$c;", "", "url", "Lcom/kakao/adfit/k/k;", "loadingDisposer", "", "a", "Landroid/graphics/Bitmap;", "image", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Lcom/kakao/adfit/d/r$c;", "src", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "J", "startTime", "callback", "<init>", "(Lcom/kakao/adfit/d/r$c;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class d implements c {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private c src;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long startTime;

        public d(c callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.src = callback;
            this.startTime = SystemClock.elapsedRealtime();
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, com.kakao.adfit.k.k loadingDisposer) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(loadingDisposer, "loadingDisposer");
            c cVar = this.src;
            if (cVar != null) {
                cVar.a(url, loadingDisposer);
            }
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, Bitmap image) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(image, "image");
            c cVar = this.src;
            if (cVar != null) {
                this.src = null;
                cVar.a(url, image);
            }
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, Exception e) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(e, "e");
            c cVar = this.src;
            if (cVar != null) {
                this.src = null;
                cVar.a(url, e);
            }
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            c cVar = this.src;
            if (cVar != null) {
                this.src = null;
                cVar.a(url);
            }
        }
    }

    /* JADX INFO: compiled from: NativeAdImageLoader.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/kakao/adfit/d/r$e;", "", "Lcom/kakao/adfit/k/k;", "preparingDisposer", "", "a", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public interface e {

        /* JADX INFO: compiled from: NativeAdImageLoader.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            public static void a(e eVar) {
            }

            public static void a(e eVar, com.kakao.adfit.k.k preparingDisposer) {
                Intrinsics.checkNotNullParameter(preparingDisposer, "preparingDisposer");
            }
        }

        void a();

        void a(com.kakao.adfit.k.k preparingDisposer);

        void b();

        void c();
    }

    /* JADX INFO: compiled from: NativeAdImageLoader.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/d/r$f;", "Lcom/kakao/adfit/d/r$e;", "Lcom/kakao/adfit/k/k;", "preparingDisposer", "", "a", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/d/r$e;", "src", "", "J", "startTime", "callback", "<init>", "(Lcom/kakao/adfit/d/r$e;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    private static final class f implements e {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private e src;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long startTime;

        public f(e callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.src = callback;
            this.startTime = SystemClock.elapsedRealtime();
        }

        @Override // com.kakao.adfit.d.r.e
        public void a(com.kakao.adfit.k.k preparingDisposer) {
            Intrinsics.checkNotNullParameter(preparingDisposer, "preparingDisposer");
            e eVar = this.src;
            if (eVar != null) {
                eVar.a(preparingDisposer);
            }
        }

        @Override // com.kakao.adfit.d.r.e
        public void b() {
            e eVar = this.src;
            if (eVar != null) {
                this.src = null;
                eVar.b();
            }
        }

        @Override // com.kakao.adfit.d.r.e
        public void c() {
            e eVar = this.src;
            if (eVar != null) {
                this.src = null;
                eVar.c();
            }
        }

        @Override // com.kakao.adfit.d.r.e
        public void a() {
            e eVar = this.src;
            if (eVar != null) {
                this.src = null;
                eVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: Disposable.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\n"}, d2 = {"com/kakao/adfit/d/r$g", "Lcom/kakao/adfit/k/k;", "", "a", "", "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "()Z", "isDisposed", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class g implements com.kakao.adfit.k.k {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isDisposed;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ f d;

        public g(ArrayList arrayList, f fVar) {
            this.c = arrayList;
            this.d = fVar;
        }

        @Override // com.kakao.adfit.k.k
        public void a() {
            if (getIsDisposed()) {
                return;
            }
            this.isDisposed = true;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((com.kakao.adfit.k.k) it.next()).a();
            }
            this.d.b();
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public boolean getIsDisposed() {
            return this.isDisposed;
        }
    }

    /* JADX INFO: compiled from: NativeAdImageLoader.kt */
    @Metadata(bv = {}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"com/kakao/adfit/d/r$h", "Lcom/kakao/adfit/d/r$c;", "", "a", "", "url", "Lcom/kakao/adfit/k/k;", "loadingDisposer", "Landroid/graphics/Bitmap;", "image", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class h implements c {
        final /* synthetic */ ArrayList<com.kakao.adfit.k.k> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ r f1767b;
        final /* synthetic */ f c;
        final /* synthetic */ Ref.IntRef d;

        h(ArrayList<com.kakao.adfit.k.k> arrayList, r rVar, f fVar, Ref.IntRef intRef) {
            this.a = arrayList;
            this.f1767b = rVar;
            this.c = fVar;
            this.d = intRef;
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, com.kakao.adfit.k.k loadingDisposer) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(loadingDisposer, "loadingDisposer");
            this.a.add(loadingDisposer);
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, Bitmap image) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(image, "image");
            a();
        }

        @Override // com.kakao.adfit.d.r.c
        public void a(String url, Exception e) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(e, "e");
            if (Intrinsics.areEqual(url, this.f1767b.mediaImageUrl)) {
                this.c.c();
            } else {
                a();
            }
        }

        private final void a() {
            Ref.IntRef intRef = this.d;
            int i = intRef.element - 1;
            intRef.element = i;
            if (i == 0) {
                if (this.f1767b.a()) {
                    this.c.a();
                } else {
                    this.c.c();
                }
            }
        }
    }

    private r(Context context, String str, Map<String, b> map) {
        this.mediaImageUrl = str;
        this.holders = map;
        this.loader = com.kakao.adfit.a.g.a(context).a();
    }

    public final boolean b() {
        Collection<b> collectionValues = this.holders.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (!((b) it.next()).c()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean a() {
        b bVar = this.holders.get(this.mediaImageUrl);
        return !((bVar == null || bVar.c()) ? false : true);
    }

    public final void a(e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (b()) {
            callback.a();
            return;
        }
        f fVar = new f(callback);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = this.holders.size();
        ArrayList arrayList = new ArrayList(intRef.element);
        h hVar = new h(arrayList, this, fVar, intRef);
        Iterator<Map.Entry<String, b>> it = this.holders.entrySet().iterator();
        while (it.hasNext()) {
            b value = it.next().getValue();
            com.kakao.adfit.n.h loader = this.loader;
            Intrinsics.checkNotNullExpressionValue(loader, "loader");
            value.a(loader, hVar);
        }
        if (intRef.element > 0) {
            com.kakao.adfit.k.k.Companion companion = com.kakao.adfit.k.k.INSTANCE;
            fVar.a(new g(arrayList, fVar));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public r(Context context, p nativeAd) {
        String url;
        p.c image;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        p.f fVar = nativeAd.getCom.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MEDIA java.lang.String();
        if (fVar instanceof p.c) {
            url = ((p.c) nativeAd.getCom.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MEDIA java.lang.String()).getUrl();
        } else {
            url = (!(fVar instanceof p.k) || (image = ((p.k) nativeAd.getCom.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MEDIA java.lang.String()).getImage()) == null) ? null : image.getUrl();
        }
        this(context, url, nativeAd);
    }

    private r(Context context, String str, p pVar) {
        HashMap map = new HashMap();
        if (str != null) {
            map.put(str, new b(str));
        }
        p.c profileIcon = pVar.getProfileIcon();
        String url = profileIcon != null ? profileIcon.getUrl() : null;
        if (url != null) {
            map.put(url, new b(url));
        }
        p.c adInfoIcon = pVar.getAdInfoIcon();
        String url2 = adInfoIcon != null ? adInfoIcon.getUrl() : null;
        if (url2 != null) {
            map.put(url2, new b(url2));
        }
        Unit unit = Unit.INSTANCE;
        this(context, str, map);
    }

    public final void a(final String url, final c callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b bVar = this.holders.get(url);
        if (bVar != null) {
            com.kakao.adfit.n.h loader = this.loader;
            Intrinsics.checkNotNullExpressionValue(loader, "loader");
            bVar.a(loader, callback);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.kakao.adfit.d.-$$Lambda$r$Phx8nCwR9ytKb44opuBz01ht4lU
            @Override // java.lang.Runnable
            public final void run() {
                r.a(callback, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(c callback, String url) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(url, "$url");
        callback.a(url, new RuntimeException("Image url is not initialized. [url = " + url + ']'));
    }
}
