package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhal extends zzhaj implements zzans {
    private int zza;

    protected zzhal(String str) {
        super("mvhd");
    }

    public final int zzh() {
        if (!this.zzc) {
            zzg();
        }
        return this.zza;
    }

    protected final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzanr.zzc(byteBuffer.get());
        zzanr.zzd(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
