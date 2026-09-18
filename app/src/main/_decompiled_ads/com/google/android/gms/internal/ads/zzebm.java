package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebm implements zzfgu {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfit zzc;
    private final zzfje zzd;

    public zzebm(String str, zzfje zzfjeVar, zzfit zzfitVar) {
        this.zzb = str;
        this.zzd = zzfjeVar;
        this.zzc = zzfitVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfgu
    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzdwm zzdwmVar;
        String strConcat;
        zzebl zzeblVar = (zzebl) obj;
        int iOptInt = zzeblVar.zza.optInt("http_timeout_millis", 60000);
        zzbvj zzbvjVar = zzeblVar.zzb;
        String strJoin = "";
        if (zzbvjVar.zza() != -2) {
            if (zzbvjVar.zza() == 1) {
                if (zzbvjVar.zzf() != null) {
                    strJoin = TextUtils.join(", ", zzbvjVar.zzf());
                    zzcat.zzg(strJoin);
                }
                zzdwmVar = new zzdwm(2, "Error building request URL: ".concat(String.valueOf(strJoin)));
            } else {
                zzdwmVar = new zzdwm(1);
            }
            zzfje zzfjeVar = this.zzd;
            zzfit zzfitVar = this.zzc;
            zzfitVar.zzg(zzdwmVar);
            zzfitVar.zzf(false);
            zzfjeVar.zza(zzfitVar);
            throw zzdwmVar;
        }
        HashMap map = new HashMap();
        if (zzeblVar.zzb.zzh() && !TextUtils.isEmpty(this.zzb)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaN)).booleanValue()) {
                String str = this.zzb;
                if (TextUtils.isEmpty(str)) {
                    strConcat = "";
                } else {
                    Matcher matcher = zza.matcher(str);
                    strConcat = "";
                    while (matcher.find()) {
                        String strGroup = matcher.group(1);
                        if (strGroup != null && (strGroup.toLowerCase(Locale.ROOT).startsWith("id=") || strGroup.toLowerCase(Locale.ROOT).startsWith("ide="))) {
                            if (!TextUtils.isEmpty(strConcat)) {
                                strConcat = strConcat.concat("; ");
                            }
                            strConcat = strConcat.concat(strGroup);
                        }
                    }
                }
                if (!TextUtils.isEmpty(strConcat)) {
                    map.put(HttpHeaders.COOKIE, strConcat);
                }
            } else {
                map.put(HttpHeaders.COOKIE, this.zzb);
            }
        }
        if (zzeblVar.zzb.zzi()) {
            zzebn.zza(map, zzeblVar.zza);
        }
        if (zzeblVar.zzb != null && !TextUtils.isEmpty(zzeblVar.zzb.zzd())) {
            strJoin = zzeblVar.zzb.zzd();
        }
        zzfje zzfjeVar2 = this.zzd;
        zzfit zzfitVar2 = this.zzc;
        zzfitVar2.zzf(true);
        zzfjeVar2.zza(zzfitVar2);
        return new zzebh(zzeblVar.zzb.zze(), iOptInt, map, strJoin.getBytes(zzfsi.zzc), "", zzeblVar.zzb.zzi());
    }
}
