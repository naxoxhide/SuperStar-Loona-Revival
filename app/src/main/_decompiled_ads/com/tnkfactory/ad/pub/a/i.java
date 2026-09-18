package com.tnkfactory.ad.pub.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.google.android.gms.ads.RequestConfiguration;
import com.tnkfactory.ad.Logger;
import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    public static String a(Context context) {
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return "Y";
        }
        File[] fileArr = {new File("/system/bin/su"), new File("/system/xbin/su"), new File("/sbin/su"), new File("/system/su"), new File("/system/bin/.ext/.su"), new File("/system/usr/we-need-root/su-backup"), new File("/system/xbin/mu"), new File("/system/app/SuperUser.apk"), new File("/system/app/Superuser.apk"), new File("data/data/com.noshufou.android.su")};
        for (int i = 0; i < 10; i++) {
            File file = fileArr[i];
            if (file.exists() && file.isFile()) {
                return "Y";
            }
        }
        String[] strArr = {"com.noshufou.android.su", "com.speedsoftware.rootexplorer", "com.tegrak.lagfix", "com.devadvance.rootcloakplus", "com.devadvance.rootcloak", "eu.chainfire.supersu", "com.thirdparty.superuser", "com.koushikdutta.superuser", "com.zachspong.temprootremovejb", "com.ramdroid.appquarantine", "com.cyanogenmod.filemanager"};
        for (int i2 = 0; i2 < 11; i2++) {
            if (a(context, strArr[i2])) {
                return "Y";
            }
        }
        return "N";
    }

    public static String a(Context context, String str, boolean z) {
        if (str == null) {
            Logger.e("error #f007");
            return null;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.putExtra("com.android.browser.application_id", "com.tnkfactory.ad");
            if (str.startsWith("market://")) {
                intent.setPackage("com.android.vending");
            }
            if (z || !(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return str;
        } catch (Exception e) {
            if (!z) {
                return a(context, str, true);
            }
            Logger.e(a.a("goWebPage error : ").append(e.toString()).toString());
            Toast.makeText(context, m0.a().c, 1).show();
            return null;
        }
    }

    public static String a(String str, String str2, String str3, int i, Map<String, Object> map) {
        if (str2 == null) {
            return null;
        }
        if (map != null) {
            for (String str4 : map.keySet()) {
                Object obj = map.get(str4);
                String str5 = "${" + str4 + "}";
                if (str2.indexOf(str5) > 0) {
                    str2 = str2.replace(str5, String.valueOf(obj));
                }
                if (str.indexOf(str5) > 0) {
                    str = str.replace(str5, String.valueOf(obj));
                }
            }
        }
        if (str != null) {
            String strReplace = str.replace("${ADV_URL}", str2);
            try {
                str2 = URLEncoder.encode(str2, "utf-8");
            } catch (Exception unused) {
            }
            str2 = strReplace.replace("${ADV_URL:ENC}", str2);
        }
        return str2.replace("${ADV_ID}", str3).replace("${PAGE_INDEX}", String.valueOf(i));
    }

    public static boolean a(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            try {
                context.getPackageManager().getPackageInfo(str, 128);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (a(str)) {
            z = true;
            break;
        }
        String[] strArrSplit = str.split(",");
        int length = strArrSplit.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z = true;
                break;
            }
            String strTrim = strArrSplit[i3].trim();
            if (strTrim.length() < 2) {
                return false;
            }
            if (a(context, strTrim)) {
                z = false;
                break;
            }
            i3++;
        }
        if (z && !a(str2) && i > 0) {
            String[] strArrSplit2 = str2.split(",");
            int length2 = strArrSplit2.length;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= length2) {
                    z = false;
                    break;
                }
                String strTrim2 = strArrSplit2[i4].trim();
                if (strTrim2.length() < 2) {
                    return false;
                }
                if (a(context, strTrim2) && (i5 = i5 + 1) >= i) {
                    z = true;
                    break;
                }
                i4++;
            }
        }
        if (z && !a(str3) && i2 > 0) {
            String[] strArrSplit3 = str3.split(",");
            int length3 = strArrSplit3.length;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i6 >= length3) {
                    z2 = false;
                    break;
                }
                String strTrim3 = strArrSplit3[i6].trim();
                if (strTrim3.length() < 2) {
                    return false;
                }
                if (a(context, strTrim3) && (i7 = i7 + 1) >= i2) {
                    break;
                }
                i6++;
            }
        } else {
            z2 = z;
        }
        if (z2 && !a(str4)) {
            for (String str5 : str4.split(",")) {
                String strTrim4 = str5.trim();
                if (strTrim4.length() < 2 || !a(context, strTrim4)) {
                    return false;
                }
            }
        }
        return z2;
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String b(Context context) {
        String property = System.getProperty("os.version");
        String property2 = System.getProperty("os.arch");
        String str = Build.FINGERPRINT;
        String str2 = Build.MODEL;
        Map<String, String> map = u.a;
        if (str2.toLowerCase().contains("app runtime")) {
            return "C";
        }
        if (property != null && property.contains("bst+")) {
            return "B";
        }
        if (str != null && str.contains("generic")) {
            return "E";
        }
        if (a(context, "com.androVM.vmconfig")) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_G;
        }
        if (a(context, "com.bluestacks.setup") || a(context, "com.bluestacks.bstfolder") || a(context, "com.bluestacks.BstCommandProcessor") || ((property2.contains("x86") && a(context, "com.uncube.account")) || (property2.contains("x86") && a(context, "com.svox.pico")))) {
            return "B";
        }
        File[] fileArr = {new File("/system/app/BstCommandProcessor.apk"), new File("/system/app/BstFolder.apk"), new File("/system/priv-app/BstCommandProcessor.apk"), new File("/system/priv-app/BstFolder.apk")};
        for (int i = 0; i < 4; i++) {
            File file = fileArr[i];
            if (file.exists() && file.isFile()) {
                return "B";
            }
        }
        if (a(context, "org.greatfruit.andy") || a(context, "org.greatfruit.andy.ime") || a(context, "org.greatfruit.andy.appmonitor")) {
            return "A";
        }
        File[] fileArr2 = {new File("/system/app/ime.apk"), new File("/system/app/appmonitor.apk"), new File("/system/app/1clicksync.apk")};
        for (int i2 = 0; i2 < 3; i2++) {
            File file2 = fileArr2[i2];
            if (file2.exists() && file2.isFile()) {
                return "A";
            }
        }
        if (a(context, "com.bignox.app.noxservice")) {
            return "O";
        }
        File[] fileArr3 = {new File("/system/app/NoxService.apk")};
        for (int i3 = 0; i3 < 1; i3++) {
            File file3 = fileArr3[i3];
            if (file3.exists() && file3.isFile()) {
                return "O";
            }
        }
        if (property2.equals("i686") && str != null && str.contains("dream2ltexx")) {
            return "O";
        }
        if (a(context, "com.google.android.launcher.layouts.genymotion") || a(context, "com.genymotion.systempatcher") || a(context, "com.genymotion.tasklocker") || a(context, "com.genymotion.genyd") || a(context, "com.genymotion.superuser")) {
            return "E";
        }
        File file4 = new File("fstab.vbox86");
        if (file4.exists() && file4.isFile()) {
            return "E";
        }
        if (property != null && property.contains("genymotion")) {
            return "E";
        }
        if (a(context, "com.microvirt.installer") || a(context, "com.microvirt.guide") || a(context, "com.microvirt.tools") || a(context, "com.microvirt.memuime") || a(context, "com.microvirt.launcher2") || a(context, "com.microvirt.download")) {
            return "M";
        }
        if (a(context, "com.pk.peak.launcher3")) {
            return "P";
        }
        if (new File(u.a("897c0082e81e956ae77e2b473bb727bf88cc4d182a41da861953f9660feab53d3106ce5ebf9062ed41389002f71c07465acea090d6f2634c53c211fa510ecb78")).exists()) {
            return "X";
        }
        String property3 = System.getProperty("java.class.path");
        if (property3 != null && property3.toLowerCase().contains("xposed")) {
            return "X";
        }
        if (a(context, u.a("c5770cd8ff58876ef8316d4e3bf036b88bd4041c3655da86")) || a(context, u.a("c5770cd8ff58876ef8316d4e3bf036b88bd4041c36")) || a(context, u.a("c5770cd8e4509a6efa71624c70f038b583d90b182a42cd9b")) || a(context, u.a("c5770cd8e4509a6efa71624c70f038b583df0710304ada990258")) || a(context, u.a("c5770cd8e4509662f0316d4e3bf036b88bd4041c36")) || a(context, u.a("c5770cd8df659468fb716b7713b71c9daff32011254bcf8c02")) || a(context, u.a("c5770cd8df659468fb716b7713b71c9daff32011254bcf8c0267a571")) || a(context, u.a("c7760693e55e986fbd6961443fb73cbd8fd3"))) {
            return "I";
        }
        try {
            ClassLoader.getSystemClassLoader().loadClass(u.a("c27d4f84e6538725f271605131f031fe92ca0c0a214186b10058a47b1bc7b431314fc2"));
            return "X";
        } catch (ClassNotFoundException unused) {
            return ((property2.equals("i686") || property2.equals("x86")) && a(context, "com.cyanogenmod.filemanager")) ? "Y" : "N";
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030 A[Catch: Exception -> 0x0043, TryCatch #2 {Exception -> 0x0043, blocks: (B:15:0x0026, B:19:0x0036, B:17:0x0030), top: B:35:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0036 A[Catch: Exception -> 0x0043, TRY_LEAVE, TryCatch #2 {Exception -> 0x0043, blocks: (B:15:0x0026, B:19:0x0036, B:17:0x0030), top: B:35:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String[] c(Context context) {
        String networkCountryIso;
        String simOperatorName;
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (networkCountryIso != null) {
                    try {
                        if (networkCountryIso.trim().length() == 0) {
                            networkCountryIso = "";
                            simOperatorName = telephonyManager.getSimOperatorName();
                            if (simOperatorName != null) {
                                try {
                                    if (simOperatorName.trim().length() == 0) {
                                        simOperatorName = telephonyManager.getNetworkOperatorName();
                                    }
                                    if (simOperatorName != null && simOperatorName.trim().length() != 0) {
                                        str = simOperatorName;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    str = simOperatorName;
                                    Logger.e(a.a("error #f005 : ").append(e.toString()).toString());
                                }
                            } else {
                                simOperatorName = telephonyManager.getNetworkOperatorName();
                                if (simOperatorName != null) {
                                    str = simOperatorName;
                                }
                            }
                        } else {
                            simOperatorName = telephonyManager.getSimOperatorName();
                            if (simOperatorName != null) {
                                if (simOperatorName.trim().length() == 0) {
                                    simOperatorName = telephonyManager.getNetworkOperatorName();
                                }
                                if (simOperatorName != null) {
                                    str = simOperatorName;
                                }
                            } else {
                                simOperatorName = telephonyManager.getNetworkOperatorName();
                                if (simOperatorName != null) {
                                    str = simOperatorName;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Logger.e(a.a("error #f005 : ").append(e.toString()).toString());
                        return new String[]{str, networkCountryIso};
                    }
                } else {
                    networkCountryIso = "";
                    simOperatorName = telephonyManager.getSimOperatorName();
                    if (simOperatorName != null) {
                        if (simOperatorName.trim().length() == 0) {
                            simOperatorName = telephonyManager.getNetworkOperatorName();
                        }
                        if (simOperatorName != null) {
                            str = simOperatorName;
                        }
                    } else {
                        simOperatorName = telephonyManager.getNetworkOperatorName();
                        if (simOperatorName != null) {
                            str = simOperatorName;
                        }
                    }
                }
            } else {
                networkCountryIso = "";
            }
        } catch (Exception e3) {
            e = e3;
            networkCountryIso = "";
        }
        return new String[]{str, networkCountryIso};
    }

    public static boolean d(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & 15) < 3) {
            return false;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float f = displayMetrics.widthPixels / displayMetrics.xdpi;
            float f2 = displayMetrics.heightPixels / displayMetrics.ydpi;
            return Math.sqrt((double) ((f2 * f2) + (f * f))) >= 6.0d;
        } catch (Throwable unused) {
            return false;
        }
    }
}
