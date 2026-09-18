package com.kakao.adfit.l;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.kakao.adfit.l.a, reason: from toString */
/* JADX INFO: compiled from: ProgressTracking.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0004\n\u000e\u0019\u001aB\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013B\u0019\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/kakao/adfit/l/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/kakao/adfit/l/a$d;", "a", "Lcom/kakao/adfit/l/a$d;", "()Lcom/kakao/adfit/l/a$d;", "offset", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "()Ljava/lang/String;", "url", "<init>", "(Lcom/kakao/adfit/l/a$d;Ljava/lang/String;)V", "millisOffset", "(ILjava/lang/String;)V", "", "percentageOffset", "(FLjava/lang/String;)V", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class ProgressTracking {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final d offset;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* JADX INFO: renamed from: com.kakao.adfit.l.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: ProgressTracking.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"Lcom/kakao/adfit/l/a$a;", "", "", "a", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Void a() {
            throw new UninitializedPropertyAccessException("property \"duration\" has not been initialized");
        }
    }

    /* JADX INFO: renamed from: com.kakao.adfit.l.a$b, reason: from toString */
    /* JADX INFO: compiled from: ProgressTracking.kt */
    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001a\u0010\r\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR*\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\n\u0010\u0011R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138V@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/kakao/adfit/l/a$b;", "Lcom/kakao/adfit/l/a$d;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "millis", "value", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getDuration", "(I)V", "duration", "", "<set-?>", "c", "F", "getPercentage", "()F", "percentage", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Z", "initialized", "<init>", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final /* data */ class MillisTimeOffset implements d {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int millis;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int duration;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private float percentage;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private boolean initialized;

        public MillisTimeOffset(int i) {
            this.millis = i;
        }

        @Override // com.kakao.adfit.l.ProgressTracking.d
        /* JADX INFO: renamed from: a, reason: from getter */
        public int getMillis() {
            return this.millis;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MillisTimeOffset) && getMillis() == ((MillisTimeOffset) other).getMillis();
        }

        public int hashCode() {
            return Integer.hashCode(getMillis());
        }

        public String toString() {
            return "MillisTimeOffset(millis=" + getMillis() + ')';
        }

        @Override // com.kakao.adfit.l.ProgressTracking.d
        public void a(int i) {
            this.duration = i;
            this.percentage = (getMillis() * 100) / i;
            this.initialized = true;
        }
    }

    /* JADX INFO: renamed from: com.kakao.adfit.l.a$d */
    /* JADX INFO: compiled from: ProgressTracking.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0004\"\u0004\b\u0003\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/kakao/adfit/l/a$d;", "", "", "a", "()I", "millis", "getDuration", "(I)V", "duration", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public interface d {
        /* JADX INFO: renamed from: a */
        int getMillis();

        void a(int i);
    }

    public ProgressTracking(d offset, String url) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(url, "url");
        this.offset = offset;
        this.url = url;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final d getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProgressTracking)) {
            return false;
        }
        ProgressTracking progressTracking = (ProgressTracking) other;
        return Intrinsics.areEqual(this.offset, progressTracking.offset) && Intrinsics.areEqual(this.url, progressTracking.url);
    }

    public int hashCode() {
        return (this.offset.hashCode() * 31) + this.url.hashCode();
    }

    public String toString() {
        return "ProgressTracking(offset=" + this.offset + ", url=" + this.url + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressTracking(int i, String url) {
        this(new MillisTimeOffset(i), url);
        Intrinsics.checkNotNullParameter(url, "url");
    }

    /* JADX INFO: renamed from: com.kakao.adfit.l.a$c, reason: from toString */
    /* JADX INFO: compiled from: ProgressTracking.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u000b\u0010\u0014R$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00048V@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u000b\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/kakao/adfit/l/a$c;", "Lcom/kakao/adfit/l/a$d;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "F", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()F", "percentage", "value", "I", "getDuration", "()I", "(I)V", "duration", "<set-?>", "c", "millis", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Z", "initialized", "<init>", "(F)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final /* data */ class PercentageTimeOffset implements d {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final float percentage;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int duration;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private int millis;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private boolean initialized;

        public PercentageTimeOffset(float f) {
            this.percentage = f;
        }

        @Override // com.kakao.adfit.l.ProgressTracking.d
        public void a(int i) {
            this.duration = i;
            this.millis = (int) (((double) (i * getPercentage())) / 100.0d);
            this.initialized = true;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public float getPercentage() {
            return this.percentage;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PercentageTimeOffset) && Intrinsics.areEqual((Object) Float.valueOf(getPercentage()), (Object) Float.valueOf(((PercentageTimeOffset) other).getPercentage()));
        }

        public int hashCode() {
            return Float.hashCode(getPercentage());
        }

        public String toString() {
            return "PercentageTimeOffset(percentage=" + getPercentage() + ')';
        }

        @Override // com.kakao.adfit.l.ProgressTracking.d
        /* JADX INFO: renamed from: a */
        public int getMillis() {
            Integer numValueOf = Integer.valueOf(this.millis);
            numValueOf.intValue();
            if (!this.initialized) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
            ProgressTracking.INSTANCE.a();
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressTracking(float f, String url) {
        this(new PercentageTimeOffset(f), url);
        Intrinsics.checkNotNullParameter(url, "url");
    }
}
