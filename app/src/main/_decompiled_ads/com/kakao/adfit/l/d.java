package com.kakao.adfit.l;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.kakao.adfit.l.d, reason: from toString */
/* JADX INFO: compiled from: VastMediaFile.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tB)\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0010\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/kakao/adfit/l/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "()I", "width", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "height", "c", "bitrate", "Ljava/lang/String;", "()Ljava/lang/String;", "url", "<init>", "(IIILjava/lang/String;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class VastMediaFile {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final int width;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final int bitrate;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final String url;

    /* JADX INFO: renamed from: com.kakao.adfit.l.d$a */
    /* JADX INFO: compiled from: VastMediaFile.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0006\u001a\u00020\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR$\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/kakao/adfit/l/d$a;", "", "", "value", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "", "Lcom/kakao/adfit/l/d;", "I", "getWidth", "()I", "setWidth", "(I)V", "width", "getHeight", "setHeight", "height", "getBitrate", "setBitrate", "bitrate", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "url", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private int width;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int height;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private int bitrate;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private String url;

        public final a a(int value) {
            this.bitrate = value;
            return this;
        }

        public final a b(int value) {
            this.height = value;
            return this;
        }

        public final a c(int value) {
            this.width = value;
            return this;
        }

        public final a a(String value) {
            this.url = value;
            return this;
        }

        public final VastMediaFile a() {
            return new VastMediaFile(this.width, this.height, this.bitrate, this.url);
        }
    }

    public VastMediaFile(int i, int i2, int i3, String str) {
        this.width = i;
        this.height = i2;
        this.bitrate = i3;
        this.url = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getBitrate() {
        return this.bitrate;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastMediaFile)) {
            return false;
        }
        VastMediaFile vastMediaFile = (VastMediaFile) other;
        return this.width == vastMediaFile.width && this.height == vastMediaFile.height && this.bitrate == vastMediaFile.bitrate && Intrinsics.areEqual(this.url, vastMediaFile.url);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.bitrate)) * 31;
        String str = this.url;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "VastMediaFile(width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", url=" + this.url + ')';
    }
}
