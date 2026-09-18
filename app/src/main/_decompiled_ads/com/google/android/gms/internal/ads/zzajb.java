package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajb implements zzakp {
    private final List zza;

    public zzajb() {
        this(0);
    }

    public zzajb(int i, List list) {
        this.zza = list;
    }

    private final zzakf zzb(zzako zzakoVar) {
        return new zzakf(zzd(zzakoVar));
    }

    private final zzakt zzc(zzako zzakoVar) {
        return new zzakt(zzd(zzakoVar));
    }

    private final List zzd(zzako zzakoVar) {
        String str;
        int i;
        List listSingletonList;
        zzfb zzfbVar = new zzfb(zzakoVar.zzd);
        List arrayList = this.zza;
        while (zzfbVar.zza() > 0) {
            int iZzl = zzfbVar.zzl();
            int iZzc = zzfbVar.zzc() + zzfbVar.zzl();
            if (iZzl == 134) {
                arrayList = new ArrayList();
                int iZzl2 = zzfbVar.zzl() & 31;
                for (int i2 = 0; i2 < iZzl2; i2++) {
                    String strZzy = zzfbVar.zzy(3, zzfsi.zzc);
                    int iZzl3 = zzfbVar.zzl();
                    boolean z = (iZzl3 & 128) != 0;
                    if (z) {
                        i = iZzl3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bZzl = (byte) zzfbVar.zzl();
                    zzfbVar.zzH(1);
                    if (z) {
                        int i3 = bZzl & SignedBytes.MAX_POWER_OF_TWO;
                        int i4 = zzdz.zza;
                        listSingletonList = Collections.singletonList(i3 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzak zzakVar = new zzak();
                    zzakVar.zzU(str);
                    zzakVar.zzM(strZzy);
                    zzakVar.zzw(i);
                    zzakVar.zzK(listSingletonList);
                    arrayList.add(zzakVar.zzac());
                }
            }
            zzfbVar.zzG(iZzc);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final zzakr zza(int i, zzako zzakoVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzajv(new zzajs(zzakoVar.zzb));
            }
            if (i == 21) {
                return new zzajv(new zzajq());
            }
            if (i == 27) {
                return new zzajv(new zzajn(zzb(zzakoVar), false, false));
            }
            if (i == 36) {
                return new zzajv(new zzajp(zzb(zzakoVar)));
            }
            if (i == 89) {
                return new zzajv(new zzajd(zzakoVar.zzc));
            }
            if (i == 138) {
                return new zzajv(new zzajc(zzakoVar.zzb));
            }
            if (i == 172) {
                return new zzajv(new zzaix(zzakoVar.zzb));
            }
            if (i == 257) {
                return new zzake(new zzaju("application/vnd.dvb.ait"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i == 134) {
                        return new zzake(new zzaju("application/x-scte35"));
                    }
                    if (i != 135) {
                        switch (i) {
                            case 15:
                                return new zzajv(new zzaja(false, zzakoVar.zzb));
                            case 16:
                                return new zzajv(new zzajj(zzc(zzakoVar)));
                            case 17:
                                return new zzajv(new zzajr(zzakoVar.zzb));
                            default:
                                return null;
                        }
                    }
                }
                return new zzajv(new zzaiu(zzakoVar.zzb));
            }
        }
        return new zzajv(new zzajg(zzc(zzakoVar)));
    }

    public zzajb(int i) {
        this.zza = zzfvs.zzl();
    }
}
