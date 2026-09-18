package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcdy {
    private long zza;

    public final long zza(ByteBuffer byteBuffer) {
        zzanv zzanvVar;
        zzanu zzanuVar;
        long j = this.zza;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator it = new zzanq(new zzcdx(byteBufferDuplicate), zzcea.zzb).zze().iterator();
            while (true) {
                zzanvVar = null;
                if (!it.hasNext()) {
                    zzanuVar = null;
                    break;
                }
                zzans zzansVar = (zzans) it.next();
                if (zzansVar instanceof zzanu) {
                    zzanuVar = (zzanu) zzansVar;
                    break;
                }
            }
            for (zzans zzansVar2 : zzanuVar.zze()) {
                if (zzansVar2 instanceof zzanv) {
                    zzanvVar = (zzanv) zzansVar2;
                    break;
                }
            }
            long jZzd = (zzanvVar.zzd() * 1000) / zzanvVar.zze();
            this.zza = jZzd;
            return jZzd;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
