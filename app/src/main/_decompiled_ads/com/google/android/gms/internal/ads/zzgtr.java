package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzgtr {
    DOUBLE(0, 1, zzgun.DOUBLE),
    FLOAT(1, 1, zzgun.FLOAT),
    INT64(2, 1, zzgun.LONG),
    UINT64(3, 1, zzgun.LONG),
    INT32(4, 1, zzgun.INT),
    FIXED64(5, 1, zzgun.LONG),
    FIXED32(6, 1, zzgun.INT),
    BOOL(7, 1, zzgun.BOOLEAN),
    STRING(8, 1, zzgun.STRING),
    MESSAGE(9, 1, zzgun.MESSAGE),
    BYTES(10, 1, zzgun.BYTE_STRING),
    UINT32(11, 1, zzgun.INT),
    ENUM(12, 1, zzgun.ENUM),
    SFIXED32(13, 1, zzgun.INT),
    SFIXED64(14, 1, zzgun.LONG),
    SINT32(15, 1, zzgun.INT),
    SINT64(16, 1, zzgun.LONG),
    GROUP(17, 1, zzgun.MESSAGE),
    DOUBLE_LIST(18, 2, zzgun.DOUBLE),
    FLOAT_LIST(19, 2, zzgun.FLOAT),
    INT64_LIST(20, 2, zzgun.LONG),
    UINT64_LIST(21, 2, zzgun.LONG),
    INT32_LIST(22, 2, zzgun.INT),
    FIXED64_LIST(23, 2, zzgun.LONG),
    FIXED32_LIST(24, 2, zzgun.INT),
    BOOL_LIST(25, 2, zzgun.BOOLEAN),
    STRING_LIST(26, 2, zzgun.STRING),
    MESSAGE_LIST(27, 2, zzgun.MESSAGE),
    BYTES_LIST(28, 2, zzgun.BYTE_STRING),
    UINT32_LIST(29, 2, zzgun.INT),
    ENUM_LIST(30, 2, zzgun.ENUM),
    SFIXED32_LIST(31, 2, zzgun.INT),
    SFIXED64_LIST(32, 2, zzgun.LONG),
    SINT32_LIST(33, 2, zzgun.INT),
    SINT64_LIST(34, 2, zzgun.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzgun.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzgun.FLOAT),
    INT64_LIST_PACKED(37, 3, zzgun.LONG),
    UINT64_LIST_PACKED(38, 3, zzgun.LONG),
    INT32_LIST_PACKED(39, 3, zzgun.INT),
    FIXED64_LIST_PACKED(40, 3, zzgun.LONG),
    FIXED32_LIST_PACKED(41, 3, zzgun.INT),
    BOOL_LIST_PACKED(42, 3, zzgun.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzgun.INT),
    ENUM_LIST_PACKED(44, 3, zzgun.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzgun.INT),
    SFIXED64_LIST_PACKED(46, 3, zzgun.LONG),
    SINT32_LIST_PACKED(47, 3, zzgun.INT),
    SINT64_LIST_PACKED(48, 3, zzgun.LONG),
    GROUP_LIST(49, 2, zzgun.MESSAGE),
    MAP(50, 4, zzgun.VOID);

    private static final zzgtr[] zzZ;
    private final zzgun zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzgtr[] zzgtrVarArrValues = values();
        zzZ = new zzgtr[zzgtrVarArrValues.length];
        for (zzgtr zzgtrVar : zzgtrVarArrValues) {
            zzZ[zzgtrVar.zzac] = zzgtrVar;
        }
    }

    zzgtr(int i, int i2, zzgun zzgunVar) {
        this.zzac = i;
        this.zzab = zzgunVar;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            this.zzad = zzgunVar.zza();
        } else {
            this.zzad = null;
        }
        if (i2 == 1) {
            zzgun zzgunVar2 = zzgun.VOID;
            zzgunVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
