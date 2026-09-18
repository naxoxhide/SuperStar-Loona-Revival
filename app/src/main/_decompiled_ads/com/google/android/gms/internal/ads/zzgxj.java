package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzgxj {
    DOUBLE(zzgxk.DOUBLE, 1),
    FLOAT(zzgxk.FLOAT, 5),
    INT64(zzgxk.LONG, 0),
    UINT64(zzgxk.LONG, 0),
    INT32(zzgxk.INT, 0),
    FIXED64(zzgxk.LONG, 1),
    FIXED32(zzgxk.INT, 5),
    BOOL(zzgxk.BOOLEAN, 0),
    STRING(zzgxk.STRING, 2),
    GROUP(zzgxk.MESSAGE, 3),
    MESSAGE(zzgxk.MESSAGE, 2),
    BYTES(zzgxk.BYTE_STRING, 2),
    UINT32(zzgxk.INT, 0),
    ENUM(zzgxk.ENUM, 0),
    SFIXED32(zzgxk.INT, 5),
    SFIXED64(zzgxk.LONG, 1),
    SINT32(zzgxk.INT, 0),
    SINT64(zzgxk.LONG, 0);

    private final zzgxk zzt;

    zzgxj(zzgxk zzgxkVar, int i) {
        this.zzt = zzgxkVar;
    }

    public final zzgxk zza() {
        return this.zzt;
    }
}
