package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcec implements zzbjj {
    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcdc zzcdcVar = (zzcdc) obj;
        zzcgx zzcgxVarZzq = zzcdcVar.zzq();
        if (zzcgxVarZzq == null) {
            try {
                zzcgx zzcgxVar = new zzcgx(zzcdcVar, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzcdcVar.zzC(zzcgxVar);
                zzcgxVarZzq = zzcgxVar;
            } catch (NullPointerException e) {
                e = e;
                zzcat.zzh("Unable to parse videoMeta message.", e);
                com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                zzcat.zzh("Unable to parse videoMeta message.", e);
                com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float f = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = "1".equals(map.get("muted"));
        float f2 = Float.parseFloat((String) map.get(TJAdUnitConstants.String.VIDEO_CURRENT_TIME));
        int i = Integer.parseInt((String) map.get("playbackState"));
        int i2 = 0;
        if (i >= 0 && i <= 3) {
            i2 = i;
        }
        String str = (String) map.get("aspectRatio");
        float f3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
            zzcat.zze("Video Meta GMSG: currentTime : " + f2 + " , duration : " + f + " , isMuted : " + zEquals + " , playbackState : " + i2 + " , aspectRatio : " + str);
        }
        zzcgxVarZzq.zzc(f2, f, i2, zEquals, f3);
    }
}
