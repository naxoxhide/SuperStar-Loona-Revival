package com.kakao.adfit.b;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerAd.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00052\u00020\u0001:\u0004\u0003\t\u000f\u0013B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/kakao/adfit/b/a;", "Lcom/kakao/adfit/a/a;", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "content", "Lcom/kakao/adfit/b/a$d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/b/a$d;", "g", "()Lcom/kakao/adfit/b/a$d;", "size", "Lcom/kakao/adfit/a/e;", "c", "Lcom/kakao/adfit/a/e;", "()Lcom/kakao/adfit/a/e;", "tracker", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, InneractiveMediationDefs.GENDER_FEMALE, "name", "<init>", "(Ljava/lang/String;Lcom/kakao/adfit/b/a$d;Lcom/kakao/adfit/a/e;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class a implements com.kakao.adfit.a.a {
    private static final AtomicInteger f = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String content;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final d size;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final com.kakao.adfit.a.e tracker;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: compiled from: BannerAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/kakao/adfit/b/a$b;", "Lcom/kakao/adfit/b/a$d;", "", "a", "I", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()I", "width", "height", "<init>", "(II)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int width;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int height;

        public b(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getWidth() {
            return this.width;
        }
    }

    /* JADX INFO: compiled from: BannerAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/b/a$c;", "Lcom/kakao/adfit/b/a$d;", "", "a", "I", "c", "()I", "width", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "height", "minWidth", "<init>", "(III)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int width;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int height;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final int minWidth;

        public c(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.minWidth = i3;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getMinWidth() {
            return this.minWidth;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getWidth() {
            return this.width;
        }
    }

    /* JADX INFO: compiled from: BannerAd.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/kakao/adfit/b/a$d;", "", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public interface d {
    }

    public a(String content, d size, com.kakao.adfit.a.e tracker) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.content = content;
        this.size = size;
        this.tracker = tracker;
        this.name = "BannerAd-" + f.getAndIncrement();
    }

    @Override // com.kakao.adfit.a.a
    /* JADX INFO: renamed from: a, reason: from getter */
    public com.kakao.adfit.a.e getTracker() {
        return this.tracker;
    }

    @Override // com.kakao.adfit.a.a
    public ArrayList<String> b() {
        return com.kakao.adfit.a.a.C0442a.c(this);
    }

    @Override // com.kakao.adfit.a.a
    public ArrayList<String> c() {
        return com.kakao.adfit.a.a.C0442a.b(this);
    }

    @Override // com.kakao.adfit.a.a
    public ArrayList<String> d() {
        return com.kakao.adfit.a.a.C0442a.a(this);
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final d getSize() {
        return this.size;
    }
}
