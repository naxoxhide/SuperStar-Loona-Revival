package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.HandlerThread;
import android.os.Trace;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzrj implements zzrv {
    private final zzftm zzb;
    private final zzftm zzc;

    public zzrj(int i, boolean z) {
        zzrh zzrhVar = new zzrh(i);
        zzri zzriVar = new zzri(i);
        this.zzb = zzrhVar;
        this.zzc = zzriVar;
    }

    static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zzrl.zzs(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zzrl.zzs(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    public final zzrl zzc(zzru zzruVar) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        String str = zzruVar.zza.zza;
        zzrl zzrlVar = null;
        try {
            int i = zzfk.zza;
            Trace.beginSection("createCodec:" + str);
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                zzrl zzrlVar2 = new zzrl(mediaCodecCreateByCodecName, zza(((zzrh) this.zzb).zza), zzb(((zzri) this.zzc).zza), false, null);
                try {
                    Trace.endSection();
                    zzrl.zzh(zzrlVar2, zzruVar.zzb, zzruVar.zzd, null, 0);
                    return zzrlVar2;
                } catch (Exception e) {
                    e = e;
                    zzrlVar = zzrlVar2;
                    if (zzrlVar != null) {
                        zzrlVar.zzl();
                    } else if (mediaCodecCreateByCodecName != null) {
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodecCreateByCodecName = null;
        }
    }
}
