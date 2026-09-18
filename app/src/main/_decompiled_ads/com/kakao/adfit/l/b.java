package com.kakao.adfit.l;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.kakao.adfit.l.b, reason: from toString */
/* JADX INFO: compiled from: Tracking.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0002\t\rB'\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/kakao/adfit/l/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "event", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "offset", "c", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class Tracking {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String event;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String offset;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final String url;

    /* JADX INFO: renamed from: com.kakao.adfit.l.b$a */
    /* JADX INFO: compiled from: Tracking.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0004\u001a\u00020\u0007R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/kakao/adfit/l/b$a;", "", "", "value", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "Lcom/kakao/adfit/l/b;", "Ljava/lang/String;", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "event", "getOffset", "setOffset", "offset", "getUrl", "setUrl", "url", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private String event;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String offset;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private String url;

        public final a a(String value) {
            this.event = value;
            return this;
        }

        public final a b(String value) {
            this.offset = value;
            return this;
        }

        public final a c(String value) {
            this.url = value;
            return this;
        }

        public final Tracking a() {
            return new Tracking(this.event, this.offset, this.url);
        }
    }

    public Tracking(String str, String str2, String str3) {
        this.event = str;
        this.offset = str2;
        this.url = str3;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tracking)) {
            return false;
        }
        Tracking tracking = (Tracking) other;
        return Intrinsics.areEqual(this.event, tracking.event) && Intrinsics.areEqual(this.offset, tracking.offset) && Intrinsics.areEqual(this.url, tracking.url);
    }

    public int hashCode() {
        String str = this.event;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.offset;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Tracking(event=" + this.event + ", offset=" + this.offset + ", url=" + this.url + ')';
    }
}
