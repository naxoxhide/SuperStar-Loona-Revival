package kotlin;

/* JADX INFO: renamed from: kotlin.UByte-$$ExternalSynthetic4, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
public /* synthetic */ class UByte$$ExternalSynthetic4 {
    public static /* synthetic */ long m0(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if ((j3 ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE)) {
            j2 = 0;
        }
        return j3 - j2;
    }
}
