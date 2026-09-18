package com.kakao.adfit.common.matrix;

import com.kakao.adfit.k.f;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixLevel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/kakao/adfit/common/matrix/MatrixLevel;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "LOG", "DEBUG", "INFO", "WARNING", "ERROR", "FATAL", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public enum MatrixLevel {
    LOG,
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.kakao.adfit.common.matrix.MatrixLevel$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixLevel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/kakao/adfit/common/matrix/MatrixLevel$a;", "", "", "level", "Lcom/kakao/adfit/common/matrix/MatrixLevel;", "a", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MatrixLevel a(String level) {
            Intrinsics.checkNotNullParameter(level, "level");
            try {
                Locale ENGLISH = Locale.ENGLISH;
                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                String upperCase = level.toUpperCase(ENGLISH);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                return MatrixLevel.valueOf(upperCase);
            } catch (IllegalArgumentException unused) {
                f.e("Unknown level: " + level);
                return null;
            }
        }
    }
}
