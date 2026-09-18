package com.kakao.adfit.k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0003¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/k/t;", "", "Landroid/content/Context;", "context", "", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "networkType", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class t {
    public static final t a = new t();

    private t() {
    }

    @JvmStatic
    private static final int a(int networkType) {
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 2;
            case 13:
            case 18:
                return 3;
            case 19:
            default:
                return 0;
            case 20:
                return 4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005a A[Catch: Exception -> 0x0083, TryCatch #1 {Exception -> 0x0083, blocks: (B:14:0x0030, B:16:0x0038, B:18:0x0042, B:40:0x0072, B:28:0x0054, B:30:0x005a, B:32:0x005e, B:38:0x006d, B:42:0x007b, B:43:0x0082), top: B:47:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x005e A[Catch: Exception -> 0x0083, TryCatch #1 {Exception -> 0x0083, blocks: (B:14:0x0030, B:16:0x0038, B:18:0x0042, B:40:0x0072, B:28:0x0054, B:30:0x005a, B:32:0x005e, B:38:0x006d, B:42:0x007b, B:43:0x0082), top: B:47:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d A[Catch: Exception -> 0x0083, LOOP:0: B:31:0x005c->B:38:0x006d, LOOP_END, TryCatch #1 {Exception -> 0x0083, blocks: (B:14:0x0030, B:16:0x0038, B:18:0x0042, B:40:0x0072, B:28:0x0054, B:30:0x005a, B:32:0x005e, B:38:0x006d, B:42:0x007b, B:43:0x0082), top: B:47:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x006b A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x005a, please report this as an issue */
    @JvmStatic
    public static final int a(Context context) {
        NetworkInfo[] allNetworkInfo;
        int i;
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("phone");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            return Build.VERSION.SDK_INT >= 24 ? a(telephonyManager.getDataNetworkType()) : a(telephonyManager.getNetworkType());
        } catch (Exception unused) {
            try {
                Object systemService2 = context.getSystemService("connectivity");
                if (systemService2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService2;
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                NetworkInfo networkInfo = null;
                if (activeNetworkInfo == null) {
                    allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        for (NetworkInfo networkInfo2 : allNetworkInfo) {
                            if (networkInfo2.getType() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                networkInfo = networkInfo2;
                                break;
                            }
                        }
                    }
                } else {
                    if (!(activeNetworkInfo.getType() == 0)) {
                        activeNetworkInfo = null;
                    }
                    if (activeNetworkInfo == null) {
                        allNetworkInfo = connectivityManager.getAllNetworkInfo();
                        if (allNetworkInfo != null) {
                            while (i < r1) {
                                if (networkInfo2.getType() == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    networkInfo = networkInfo2;
                                    break;
                                }
                            }
                        }
                    } else {
                        networkInfo = activeNetworkInfo;
                    }
                }
                if (networkInfo != null) {
                    return a(networkInfo.getSubtype());
                }
                return 0;
            } catch (Exception unused2) {
            }
        }
    }

    @JvmStatic
    public static final int b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                NetworkCapabilities networkCapabilities = activeNetwork != null ? connectivityManager.getNetworkCapabilities(activeNetwork) : null;
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(0)) {
                        return 1;
                    }
                    if (networkCapabilities.hasTransport(1)) {
                        return 2;
                    }
                    return networkCapabilities.hasTransport(3) ? 3 : 0;
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        return 1;
                    }
                    if (type != 1) {
                        return type != 9 ? 0 : 3;
                    }
                    return 2;
                }
            }
            return 0;
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final boolean c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final boolean d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT < 28) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return (activeNetworkInfo != null && activeNetworkInfo.isConnected()) && activeNetworkInfo.getType() == 1;
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(activeNetwork);
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkInfo != null && networkInfo.isConnected()) {
                    return networkCapabilities != null && networkCapabilities.hasTransport(1);
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
        }
    }
}
