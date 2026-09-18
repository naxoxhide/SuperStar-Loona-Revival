package com.kakao.adfit.l;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.kakao.adfit.l.e, reason: from toString */
/* JADX INFO: compiled from: VastModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tB;\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/kakao/adfit/l/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "duration", "", "Lcom/kakao/adfit/l/d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "c", "()Ljava/util/List;", "mediaFiles", "Lcom/kakao/adfit/l/b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "trackings", "errorUrl", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class VastModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String duration;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<VastMediaFile> mediaFiles;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final List<Tracking> trackings;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final String errorUrl;

    /* JADX INFO: renamed from: com.kakao.adfit.l.e$a */
    /* JADX INFO: compiled from: VastModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0004\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0016\u0010\b\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0004\u001a\u00020\tR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000e¨\u0006 "}, d2 = {"Lcom/kakao/adfit/l/e$a;", "", "", "value", "a", "", "Lcom/kakao/adfit/l/d;", "Lcom/kakao/adfit/l/b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/l/e;", "Ljava/lang/String;", "getDuration", "()Ljava/lang/String;", "setDuration", "(Ljava/lang/String;)V", "duration", "Ljava/util/List;", "getMediaFiles", "()Ljava/util/List;", "setMediaFiles", "(Ljava/util/List;)V", "mediaFiles", "c", "getTrackings", "setTrackings", "trackings", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getErrorUrl", "setErrorUrl", "errorUrl", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private String duration;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private List<VastMediaFile> mediaFiles;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private List<Tracking> trackings;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private String errorUrl;

        public final a a(String value) {
            this.duration = value;
            return this;
        }

        public final a b(List<Tracking> value) {
            this.trackings = value;
            return this;
        }

        public final a a(List<VastMediaFile> value) {
            this.mediaFiles = value;
            return this;
        }

        public final a b(String value) {
            this.errorUrl = value;
            return this;
        }

        public final VastModel a() {
            return new VastModel(this.duration, this.mediaFiles, this.trackings, this.errorUrl);
        }
    }

    public VastModel(String str, List<VastMediaFile> list, List<Tracking> list2, String str2) {
        this.duration = str;
        this.mediaFiles = list;
        this.trackings = list2;
        this.errorUrl = str2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getErrorUrl() {
        return this.errorUrl;
    }

    public final List<VastMediaFile> c() {
        return this.mediaFiles;
    }

    public final List<Tracking> d() {
        return this.trackings;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastModel)) {
            return false;
        }
        VastModel vastModel = (VastModel) other;
        return Intrinsics.areEqual(this.duration, vastModel.duration) && Intrinsics.areEqual(this.mediaFiles, vastModel.mediaFiles) && Intrinsics.areEqual(this.trackings, vastModel.trackings) && Intrinsics.areEqual(this.errorUrl, vastModel.errorUrl);
    }

    public int hashCode() {
        String str = this.duration;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<VastMediaFile> list = this.mediaFiles;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Tracking> list2 = this.trackings;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.errorUrl;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastModel(duration=" + this.duration + ", mediaFiles=" + this.mediaFiles + ", trackings=" + this.trackings + ", errorUrl=" + this.errorUrl + ')';
    }
}
