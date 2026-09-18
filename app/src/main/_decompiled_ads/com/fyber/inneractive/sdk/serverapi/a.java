package com.fyber.inneractive.sdk.serverapi;

import android.app.NotificationManager;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.config.t;
import com.fyber.inneractive.sdk.config.z;
import com.fyber.inneractive.sdk.util.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final HashMap<String, Integer> a = new C0305a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f1322b = Arrays.asList("POWER_SAVE_MODE_OPEN", "SmartModeStatus");

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.serverapi.a$a, reason: collision with other inner class name */
    public class C0305a extends HashMap<String, Integer> {
        public C0305a() {
            put("HUAWEI", 4);
            put("XIAOMI", 1);
        }
    }

    public static String a() {
        try {
            Intent intentRegisterReceiver = l.a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return "";
            }
            return a((intentRegisterReceiver.getIntExtra("level", -1) * 100) / intentRegisterReceiver.getIntExtra("scale", -1));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(float f) {
        if (f < 5.0f) {
            return "1";
        }
        if (f <= 9.0f) {
            return "2";
        }
        if (f <= 24.0f) {
            return "3";
        }
        if (f <= 39.0f) {
            return "4";
        }
        if (f <= 54.0f) {
            return CampaignEx.CLICKMODE_ON;
        }
        if (f <= 69.0f) {
            return "6";
        }
        if (f <= 84.0f) {
            return "7";
        }
        return f <= 100.0f ? "8" : "";
    }

    public static Long b() {
        long j;
        f0 f0Var = IAConfigManager.M.x;
        f0Var.getClass();
        try {
            String str = "";
            String str2 = f0Var.c.get("SESSION_STAMP");
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j = Long.parseLong(str);
        } catch (Exception unused) {
            j = 0;
        }
        return Long.valueOf(TimeUnit.SECONDS.convert(SystemClock.elapsedRealtime() - j, TimeUnit.MILLISECONDS));
    }

    public static Long d() {
        try {
            return Long.valueOf(TimeUnit.MINUTES.convert(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()), TimeUnit.MILLISECONDS));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean e() {
        if (Build.VERSION.SDK_INT < 17) {
            return null;
        }
        try {
            return Boolean.valueOf(Settings.System.getInt(l.a.getContentResolver(), "airplane_mode_on", 0) != 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean f() {
        if (l.b("android.permission.BLUETOOTH") && Build.VERSION.SDK_INT >= 18) {
            try {
                BluetoothManager bluetoothManager = (BluetoothManager) l.a.getSystemService("bluetooth");
                if (bluetoothManager.getAdapter().getProfileConnectionState(1) != 2 && bluetoothManager.getAdapter().getProfileConnectionState(2) != 2) {
                    return null;
                }
                return Boolean.TRUE;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Boolean g() {
        return Boolean.valueOf((l.a.getResources().getConfiguration().uiMode & 48) == 32);
    }

    public static Boolean h() {
        int intExtra;
        try {
            Intent intentRegisterReceiver = l.a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            boolean z = true;
            if (intentRegisterReceiver == null || ((intExtra = intentRegisterReceiver.getIntExtra("plugged", -1)) != 1 && intExtra != 2 && intExtra != 4)) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean i() {
        try {
            boolean z = false;
            int ringerMode = ((AudioManager) l.a.getSystemService("audio")).getRingerMode();
            if (ringerMode == 0 || ringerMode == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean j() {
        try {
            NotificationManager notificationManager = (NotificationManager) l.a.getSystemService("notification");
            if (Build.VERSION.SDK_INT < 23) {
                return null;
            }
            int currentInterruptionFilter = notificationManager.getCurrentInterruptionFilter();
            return Boolean.valueOf(currentInterruptionFilter >= 2 && currentInterruptionFilter <= 4);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean k() {
        boolean zIsWiredHeadsetOn;
        try {
            AudioManager audioManager = (AudioManager) l.a.getSystemService("audio");
            if (Build.VERSION.SDK_INT >= 23) {
                zIsWiredHeadsetOn = false;
                for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                    if (audioDeviceInfo.getType() == 22 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 12 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                        zIsWiredHeadsetOn = true;
                    }
                }
            } else {
                zIsWiredHeadsetOn = audioManager.isWiredHeadsetOn();
            }
            return Boolean.valueOf(zIsWiredHeadsetOn);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean l() {
        Integer num;
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
            if (TextUtils.isEmpty(upperCase) || !a.containsKey(upperCase)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return Boolean.valueOf(((PowerManager) l.a.getSystemService("power")).isPowerSaveMode());
                }
                return null;
            }
            try {
                Iterator<String> it = f1322b.iterator();
                while (it.hasNext()) {
                    int i = Settings.System.getInt(l.a.getContentResolver(), it.next(), -1);
                    if (i != -1 && (num = a.get(upperCase)) != null) {
                        return Boolean.valueOf(num.intValue() == i);
                    }
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String c() {
        try {
            Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
            return "unity3d";
        } catch (Throwable unused) {
            return "native";
        }
    }

    public static UnitDisplayType a(String str) {
        a0 a0VarC;
        UnitDisplayType unitDisplayType = UnitDisplayType.INTERSTITIAL;
        z zVarA = com.fyber.inneractive.sdk.config.a.a(str);
        if (zVarA == null || zVarA.a.size() <= 0 || (a0VarC = zVarA.c(0)) == null) {
            return unitDisplayType;
        }
        c0 c0Var = a0VarC.f;
        t tVar = a0VarC.c;
        if (c0Var != null) {
            return c0Var.j;
        }
        return tVar != null ? tVar.f899b : unitDisplayType;
    }
}
