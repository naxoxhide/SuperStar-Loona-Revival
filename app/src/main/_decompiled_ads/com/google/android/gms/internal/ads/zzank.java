package com.google.android.gms.internal.ads;

import com.google.common.net.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzank extends zzamg {
    private final Object zza;
    private final zzaml zzb;

    public zzank(int i, String str, zzaml zzamlVar, zzamk zzamkVar) {
        super(i, str, zzamkVar);
        this.zza = new Object();
        this.zzb = zzamlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    protected final zzamm zzh(zzamc zzamcVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzamcVar.zzb;
            Map map = zzamcVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get(HttpHeaders.CONTENT_TYPE)) != null) {
                String[] strArrSplit = str2.split(";", 0);
                for (int i = 1; i < strArrSplit.length; i++) {
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzamcVar.zzb);
        }
        return zzamm.zzb(str, zzand.zzb(zzamcVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzamg
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzo(String str) {
        zzaml zzamlVar;
        synchronized (this.zza) {
            zzamlVar = this.zzb;
        }
        zzamlVar.zza(str);
    }
}
