package com.kakao.adfit.e;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MatrixId.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/e/i;", "", "", "toString", "other", "", "equals", "", "hashCode", "Ljava/util/UUID;", "a", "Ljava/util/UUID;", "uuid", "<init>", "(Ljava/util/UUID;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final i c = new i(new UUID(0, 0));

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final UUID uuid;

    /* JADX INFO: renamed from: com.kakao.adfit.e.i$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixId.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007R\u001a\u0010\u0007\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/kakao/adfit/e/i$a;", "", "Lcom/kakao/adfit/e/i;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "", "uuid", "EMPTY_ID", "Lcom/kakao/adfit/e/i;", "getEMPTY_ID$annotations", "()V", "<init>", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final i a() {
            return i.c;
        }

        @JvmStatic
        public final i b() {
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            return new i(uuidRandomUUID, null);
        }

        @JvmStatic
        public final i a(String uuid) {
            String string;
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            if (uuid.length() == 32) {
                string = new StringBuilder(uuid).insert(8, "-").insert(13, "-").insert(18, "-").insert(23, "-").toString();
                Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(id)\n      …              .toString()");
            } else {
                string = uuid;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            try {
                if (string.length() == 36) {
                    UUID uuidFromString = UUID.fromString(string);
                    Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(id)");
                    return new i(uuidFromString, defaultConstructorMarker);
                }
            } catch (Exception unused) {
            }
            com.kakao.adfit.k.f.e("String representation of MatrixId has either 32 (UUID no dashes) or 36 characters long (completed UUID). [UUID = " + uuid + ']');
            return null;
        }
    }

    private i(UUID uuid) {
        this.uuid = uuid;
    }

    public /* synthetic */ i(UUID uuid, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid);
    }

    public boolean equals(Object other) {
        return other == this || ((other instanceof i) && this.uuid.compareTo(((i) other).uuid) == 0);
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }

    public String toString() {
        String string = this.uuid.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uuid.toString()");
        return StringsKt.replace$default(string, "-", "", false, 4, (Object) null);
    }
}
