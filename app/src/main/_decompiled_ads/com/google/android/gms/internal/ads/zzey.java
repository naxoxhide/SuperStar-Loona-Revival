package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzey extends BroadcastReceiver {
    final /* synthetic */ zzez zza;

    /* synthetic */ zzey(zzez zzezVar, zzex zzexVar) {
        this.zza = zzezVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0036  */
    /* JADX WARN: Code duplicated, block: B:20:0x0038  */
    /* JADX WARN: Code duplicated, block: B:22:0x003f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Code duplicated, block: B:4:0x0012  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 2;
        if (connectivityManager == null) {
            i = 0;
        } else {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    i = 1;
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                                i = 3;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 14:
                            case 15:
                            case 17:
                                i = 4;
                                break;
                            case 13:
                                i = 5;
                                break;
                            case 16:
                            case 19:
                            default:
                                i = 6;
                                break;
                            case 18:
                                break;
                            case 20:
                                if (zzfk.zza >= 29) {
                                    i = 0;
                                } else {
                                    i = 9;
                                }
                                break;
                        }
                    } else if (type != 1) {
                        if (type == 4 || type == 5) {
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                    i = 3;
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 14:
                                case 15:
                                case 17:
                                    i = 4;
                                    break;
                                case 13:
                                    i = 5;
                                    break;
                                case 16:
                                case 19:
                                default:
                                    i = 6;
                                    break;
                                case 18:
                                    break;
                                case 20:
                                    if (zzfk.zza >= 29) {
                                        i = 0;
                                    } else {
                                        i = 9;
                                    }
                                    break;
                            }
                        } else if (type != 6) {
                            i = type != 9 ? 8 : 7;
                        } else {
                            i = 5;
                        }
                    }
                }
            } catch (SecurityException unused) {
            }
        }
        if (zzfk.zza < 31 || i != 5) {
            zzez.zzc(this.zza, i);
            return;
        }
        zzez zzezVar = this.zza;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Objects.requireNonNull(telephonyManager);
            zzew zzewVar = new zzew(zzezVar);
            telephonyManager.registerTelephonyCallback(context.getMainExecutor(), zzewVar);
            telephonyManager.unregisterTelephonyCallback(zzewVar);
        } catch (RuntimeException unused2) {
            zzez.zzc(zzezVar, 5);
        }
    }
}
