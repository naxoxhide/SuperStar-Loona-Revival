package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzhc;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@21.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zze implements zza {
    final Set zza;
    private final AnalyticsConnector.AnalyticsConnectorListener zzb;
    private final AppMeasurementSdk zzc;
    private final zzd zzd;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurementSdk;
        zzd zzdVar = new zzd(this);
        this.zzd = zzdVar;
        appMeasurementSdk.registerOnMeasurementEventListener(zzdVar);
        this.zza = new HashSet();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d A[EDGE_INSN: B:10:0x002d->B:28:0x0062 BREAK  A[LOOP:2: B:20:0x004c->B:26:0x005b]] */
    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0061 A[SYNTHETIC] */
    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb(Set set) {
        int length;
        int iCharCount;
        boolean z;
        int iCodePointAt;
        this.zza.clear();
        Set set2 = this.zza;
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (hashSet.size() >= 50) {
                break;
            }
            int i = zzc.zza;
            if (str == null || str.length() == 0) {
                z = false;
                break;
            }
            int iCodePointAt2 = str.codePointAt(0);
            if (Character.isLetter(iCodePointAt2)) {
                length = str.length();
                iCharCount = Character.charCount(iCodePointAt2);
                while (true) {
                    if (iCharCount < length) {
                        iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 95 && !Character.isLetterOrDigit(iCodePointAt)) {
                            z = false;
                            break;
                        }
                        iCharCount += Character.charCount(iCodePointAt);
                    } else {
                        z = true;
                        break;
                    }
                }
            } else {
                if (iCodePointAt2 != 95) {
                    z = false;
                    break;
                }
                iCodePointAt2 = 95;
                length = str.length();
                iCharCount = Character.charCount(iCodePointAt2);
                while (true) {
                    if (iCharCount < length) {
                        z = true;
                        break;
                    } else {
                        iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 95) {
                        }
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
            }
            if (z && str.length() != 0) {
                int iCodePointAt3 = str.codePointAt(0);
                if (Character.isLetter(iCodePointAt3)) {
                    int length2 = str.length();
                    int iCharCount2 = Character.charCount(iCodePointAt3);
                    while (true) {
                        if (iCharCount2 < length2) {
                            int iCodePointAt4 = str.codePointAt(iCharCount2);
                            if (iCodePointAt4 != 95 && !Character.isLetterOrDigit(iCodePointAt4)) {
                                break;
                            } else {
                                iCharCount2 += Character.charCount(iCodePointAt4);
                            }
                        } else {
                            String strZzb = zzhc.zzb(str);
                            if (strZzb != null) {
                                str = strZzb;
                            }
                            Preconditions.checkNotNull(str);
                            hashSet.add(str);
                            break;
                        }
                    }
                }
            }
        }
        set2.addAll(hashSet);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
        this.zza.clear();
    }
}
