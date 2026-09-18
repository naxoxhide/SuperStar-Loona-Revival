package com.kakao.adfit.h;

import com.kakao.adfit.k.b0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixDate.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/kakao/adfit/h/d;", "", "", "toString", "other", "", "equals", "", "hashCode", "a", "Ljava/lang/String;", "timestamp", "<init>", "(Ljava/lang/String;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String timestamp;

    /* JADX INFO: renamed from: com.kakao.adfit.h.d$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixDate.kt */
    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0003J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0003J\b\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/h/d$a;", "", "", "millis", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/text/SimpleDateFormat;", "timestamp", "", "Lcom/kakao/adfit/h/d;", "a", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final String b(long millis) {
            String str = b().format(Long.valueOf(millis));
            Intrinsics.checkNotNullExpressionValue(str, "getIsoFormat().format(millis)");
            return str;
        }

        @JvmStatic
        public final d a() {
            return new d(a(this, 0L, 1, null), null);
        }

        @JvmStatic
        private final SimpleDateFormat b() {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat;
        }

        @JvmStatic
        public final d a(long millis) {
            return new d(b(millis), null);
        }

        @JvmStatic
        public final d a(String timestamp) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (timestamp == null) {
                return null;
            }
            if ((d.INSTANCE.b(timestamp) ? timestamp : null) != null) {
                return new d(timestamp, defaultConstructorMarker);
            }
            return null;
        }

        static /* synthetic */ String a(Companion companion, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = b0.INSTANCE.a().getMillis();
            }
            return companion.b(j);
        }

        @JvmStatic
        private final boolean b(String timestamp) {
            try {
                b().parse(timestamp);
                return true;
            } catch (ParseException unused) {
                com.kakao.adfit.k.f.e("MatrixDate timestamp is not ISO format. [timestamp = " + timestamp + ']');
                return false;
            }
        }
    }

    private d(String str) {
        this.timestamp = str;
    }

    public /* synthetic */ d(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof d) {
            return Intrinsics.areEqual(((d) other).timestamp, this.timestamp);
        }
        return false;
    }

    public int hashCode() {
        return this.timestamp.hashCode();
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getTimestamp() {
        return this.timestamp;
    }
}
