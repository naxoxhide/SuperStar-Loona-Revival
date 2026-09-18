package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabi {
    public final String zza;

    private zzabi(int i, int i2, String str) {
        this.zza = str;
    }

    public static zzabi zza(zzfb zzfbVar) {
        String str;
        zzfbVar.zzH(2);
        int iZzl = zzfbVar.zzl();
        int i = iZzl >> 1;
        int i2 = iZzl & 1;
        int iZzl2 = zzfbVar.zzl() >> 3;
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        int i3 = iZzl2 | (i2 << 5);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(i3 >= 10 ? "." : ".0");
        sb.append(i3);
        return new zzabi(i, i3, sb.toString());
    }
}
