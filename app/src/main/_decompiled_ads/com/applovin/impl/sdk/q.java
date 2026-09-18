package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.security.CertificateUtil;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class q {
    private static final AtomicReference<com.applovin.impl.sdk.utils.d.a> aDH = new AtomicReference<>();
    private static final AtomicReference<b> aDI = new AtomicReference<>();
    private static final AtomicReference<Integer> aDJ = new AtomicReference<>();
    private final Context E;
    private boolean aCY;
    private e aDA;
    private final int aDB;
    private final int aDC;
    private final int aDD;
    private final int aDE;
    private final int aDF;
    private final int aDG;
    private final h aDh;
    private final i aDi;
    private final c aDj;
    private final d aDk;
    private final f aDl;
    private final g aDm;
    private final String aDn;
    private final String aDo;
    private final double aDp;
    private final boolean aDq;
    private String aDr;
    private long aDs;
    private final a aDt;
    private e aDu;
    private e aDv;
    private e aDw;
    private e aDx;
    private e aDy;
    private e aDz;
    private final n sdk;

    public h DU() {
        return this.aDh;
    }

    public i DV() {
        return this.aDi;
    }

    public c DW() {
        return this.aDj;
    }

    public d DX() {
        return this.aDk;
    }

    public f DY() {
        return this.aDl;
    }

    public g DZ() {
        return this.aDm;
    }

    public String Ea() {
        return this.aDn;
    }

    public String Eb() {
        return this.aDo;
    }

    public double Ec() {
        return this.aDp;
    }

    public boolean Ed() {
        return this.aDq;
    }

    public String Ee() {
        return this.aDr;
    }

    public long Ef() {
        return this.aDs;
    }

    public a Eg() {
        return this.aDt;
    }

    public boolean CX() {
        return this.aCY;
    }

    protected q(n nVar) {
        this.sdk = nVar;
        Context applicationContext = n.getApplicationContext();
        this.E = applicationContext;
        this.aDB = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aOZ)).intValue();
        this.aDC = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPa)).intValue();
        this.aDD = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPb)).intValue();
        this.aDE = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPc)).intValue();
        this.aDF = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPd)).intValue();
        this.aDG = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPe)).intValue();
        this.aDh = new h();
        this.aDi = new i();
        this.aDj = new c();
        this.aDk = new d();
        this.aDl = new f();
        this.aDm = new g();
        this.aDn = AppLovinSdkUtils.isFireOS(applicationContext) ? "fireos" : "android";
        int orientation = AppLovinSdkUtils.getOrientation(applicationContext);
        if (orientation == 1) {
            this.aDo = TJAdUnitConstants.String.PORTRAIT;
        } else if (orientation == 2) {
            this.aDo = TJAdUnitConstants.String.LANDSCAPE;
        } else {
            this.aDo = IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        this.aDp = Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d) / 10.0d;
        SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
        this.aDq = (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
        if (com.applovin.impl.sdk.utils.h.KX()) {
            LocaleList locales = applicationContext.getResources().getConfiguration().getLocales();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < locales.size(); i2++) {
                sb.append(locales.get(i2));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            this.aDr = sb.toString();
        }
        try {
            this.aDs = Environment.getDataDirectory().getTotalSpace();
        } catch (Throwable th) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().c("DataProvider", "Unable to collect total disk space.", th);
            }
        }
        this.aDt = new a();
    }

    public b DG() {
        return aDI.get();
    }

    public static void a(b bVar) {
        aDI.set(bVar);
    }

    protected com.applovin.impl.sdk.utils.d.a DH() {
        return aDH.get();
    }

    protected Integer DI() {
        return aDJ.get();
    }

    public com.applovin.impl.sdk.utils.d.a DJ() {
        com.applovin.impl.sdk.utils.d.a aVarS = com.applovin.impl.sdk.utils.d.S(this.E);
        if (aVarS == null) {
            return new com.applovin.impl.sdk.utils.d.a();
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOm)).booleanValue()) {
            if (aVarS.KO() && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOl)).booleanValue()) {
                aVarS.dB("");
            }
            aDH.set(aVarS);
        } else {
            aVarS = new com.applovin.impl.sdk.utils.d.a();
        }
        boolean z = false;
        if (StringUtils.isValidString(aVarS.KP())) {
            List<String> testDeviceAdvertisingIds = this.sdk.getSettings().getTestDeviceAdvertisingIds();
            if (testDeviceAdvertisingIds != null && testDeviceAdvertisingIds.contains(aVarS.KP())) {
                z = true;
            }
            this.aCY = z;
        } else {
            this.aCY = false;
        }
        return aVarS;
    }

    public static void a(com.applovin.impl.sdk.utils.d.a aVar) {
        aDH.set(aVar);
    }

    protected void DK() {
        this.sdk.BM().a(new com.applovin.impl.sdk.e.i(this.sdk, new com.applovin.impl.sdk.e.i.a() { // from class: com.applovin.impl.sdk.q.1
            @Override // com.applovin.impl.sdk.e.i.a
            public void b(com.applovin.impl.sdk.utils.d.a aVar) {
                q.aDH.set(aVar);
            }
        }), com.applovin.impl.sdk.e.q.b.ADVERTISING_INFO_COLLECTION);
        this.sdk.BM().a(new com.applovin.impl.sdk.e.ab(this.sdk, true, "setDeviceVolume", new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$q$F5-0yqLUvZsbLYfYFLRFEt5UgPY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Eh();
            }
        }), com.applovin.impl.sdk.e.q.b.CACHING_OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eh() {
        aDJ.set(this.aDj.Es());
    }

    protected String DL() {
        e eVar = this.aDz;
        if (eVar == null || eVar.isExpired()) {
            e eVar2 = new e(com.applovin.impl.sdk.utils.i.G(this.sdk), this.aDG);
            this.aDz = eVar2;
            return (String) eVar2.aEb;
        }
        return (String) this.aDz.aEb;
    }

    protected Long DM() {
        e eVar = this.aDv;
        if (eVar == null || eVar.isExpired()) {
            try {
                e eVar2 = new e(Long.valueOf(Environment.getDataDirectory().getFreeSpace()), this.aDE);
                this.aDv = eVar2;
                return Long.valueOf(((Long) eVar2.aEb).longValue());
            } catch (Throwable th) {
                this.sdk.BL();
                if (!x.Fk()) {
                    return null;
                }
                this.sdk.BL().c("DataProvider", "Unable to collect free space.", th);
                return null;
            }
        }
        return Long.valueOf(((Long) this.aDv.aEb).longValue());
    }

    protected Float DN() {
        e eVar = this.aDx;
        if (eVar == null || eVar.isExpired()) {
            if (this.sdk.Cg() == null) {
                return null;
            }
            e eVar2 = new e(Float.valueOf(this.sdk.Cg().Lq()), this.aDB);
            this.aDx = eVar2;
            return Float.valueOf(((Float) eVar2.aEb).floatValue());
        }
        return Float.valueOf(((Float) this.aDx.aEb).floatValue());
    }

    protected Float DO() {
        e eVar = this.aDy;
        if (eVar == null || eVar.isExpired()) {
            if (this.sdk.Cg() == null) {
                return null;
            }
            e eVar2 = new e(Float.valueOf(this.sdk.Cg().Lp()), this.aDB);
            this.aDy = eVar2;
            return Float.valueOf(((Float) eVar2.aEb).floatValue());
        }
        return Float.valueOf(((Float) this.aDy.aEb).floatValue());
    }

    protected Integer DP() {
        e eVar = this.aDA;
        if (eVar == null || eVar.isExpired()) {
            try {
                e eVar2 = new e(Integer.valueOf((int) ((Settings.System.getInt(this.E.getContentResolver(), "screen_brightness") / 255.0f) * 100.0f)), this.aDC);
                this.aDA = eVar2;
                return Integer.valueOf(((Integer) eVar2.aEb).intValue());
            } catch (Settings.SettingNotFoundException e2) {
                this.sdk.BL();
                if (!x.Fk()) {
                    return null;
                }
                this.sdk.BL().c("DataProvider", "Unable to collect screen brightness", e2);
                return null;
            }
        }
        return Integer.valueOf(((Integer) this.aDA.aEb).intValue());
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:108:0x01b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:118:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:120:0x01df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x01aa, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:112:0x01c1, please report this as an issue */
    protected long DQ() {
        long j;
        int iCI;
        int iCI2;
        int iCI3;
        long j2;
        long j3;
        long j4;
        List listAsList = Arrays.asList(StringUtils.emptyIfNull(Settings.Secure.getString(this.E.getContentResolver(), "enabled_accessibility_services")).split(CertificateUtil.DELIMITER));
        long j5 = listAsList.contains("AccessibilityMenuService") ? 256L : 0L;
        if (listAsList.contains("SelectToSpeakService")) {
            j5 |= 512;
        }
        if (listAsList.contains("SoundAmplifierService")) {
            j5 |= 2;
        }
        if (listAsList.contains("SpeechToTextAccessibilityService")) {
            j5 |= 128;
        }
        if (listAsList.contains("SwitchAccessService")) {
            j5 |= 4;
        }
        if ((this.E.getResources().getConfiguration().uiMode & 48) == 32) {
            j5 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        if (cH("accessibility_enabled")) {
            j5 |= 8;
        }
        if (cH("touch_exploration_enabled")) {
            j5 |= 16;
        }
        if (com.applovin.impl.sdk.utils.h.KV()) {
            if (cH("accessibility_display_inversion_enabled")) {
                j5 |= 32;
            }
            if (cH("skip_first_use_hints")) {
                j5 |= 64;
            }
        }
        if (cH("lock_screen_allow_remote_input")) {
            j5 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        if (cH("enabled_accessibility_audio_description_by_default")) {
            j5 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        if (cH("accessibility_shortcut_on_lock_screen")) {
            j5 |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        if (cH("wear_talkback_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_PREPARE;
        }
        if (cH("hush_gesture_used")) {
            j5 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        if (cH("high_text_contrast_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        if (cH("accessibility_display_magnification_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        if (cH("accessibility_display_magnification_navbar_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        if (cH("accessibility_captioning_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        if (cH("accessibility_display_daltonizer_enabled")) {
            j5 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        if (cH("accessibility_autoclick_enabled")) {
            j5 |= 2097152;
        }
        if (cH("accessibility_large_pointer_icon")) {
            j5 |= 4194304;
        }
        if (cH("reduce_bright_colors_activated")) {
            j5 |= 8388608;
        }
        if (cH("reduce_bright_colors_persist_across_reboots")) {
            j5 |= 16777216;
        }
        if (cH("tty_mode_enabled")) {
            j5 |= 33554432;
        }
        if (cH("rtt_calling_mode")) {
            j5 |= 67108864;
        }
        if (cH("accessibility_floating_menu_fade_enabled")) {
            j5 |= 134217728;
        }
        if (cH("accessibility_show_window_magnification_prompt")) {
            j5 |= 268435456;
        }
        if (cH("accessibility_floating_menu_migration_tooltip_prompt")) {
            j5 |= 536870912;
        }
        int iCI4 = cI("accessibility_magnification_mode");
        if (iCI4 == 0) {
            j = 1073741824;
        } else if (iCI4 == 1) {
            j = 2147483648L;
        } else {
            if (iCI4 != 2) {
                if (iCI4 == 3) {
                    j = 8589934592L;
                }
                iCI = cI("accessibility_button_mode");
                if (iCI == 0) {
                    j4 = iCI == 1 ? 34359738368L : 17179869184L;
                    iCI2 = cI("accessibility_floating_menu_size");
                    if (iCI2 == 0) {
                        j3 = iCI2 == 1 ? 137438953472L : 68719476736L;
                        iCI3 = cI("accessibility_floating_menu_icon_type");
                        if (iCI3 == 0) {
                            j2 = 274877906944L;
                        } else {
                            if (iCI3 == 1) {
                                return j5;
                            }
                            j2 = 549755813888L;
                        }
                        return j5 | j2;
                    }
                    j5 |= j3;
                    iCI3 = cI("accessibility_floating_menu_icon_type");
                    if (iCI3 == 0) {
                        j2 = 274877906944L;
                    } else {
                        if (iCI3 == 1) {
                            return j5;
                        }
                        j2 = 549755813888L;
                    }
                    return j5 | j2;
                }
                j5 |= j4;
                iCI2 = cI("accessibility_floating_menu_size");
                if (iCI2 == 0) {
                    if (iCI2 == 1) {
                    }
                    iCI3 = cI("accessibility_floating_menu_icon_type");
                    if (iCI3 == 0) {
                        j2 = 274877906944L;
                    } else {
                        if (iCI3 == 1) {
                            return j5;
                        }
                        j2 = 549755813888L;
                    }
                    return j5 | j2;
                }
                j5 |= j3;
                iCI3 = cI("accessibility_floating_menu_icon_type");
                if (iCI3 == 0) {
                    j2 = 274877906944L;
                } else {
                    if (iCI3 == 1) {
                        return j5;
                    }
                    j2 = 549755813888L;
                }
                return j5 | j2;
            }
            j = 4294967296L;
        }
        j5 |= j;
        iCI = cI("accessibility_button_mode");
        if (iCI == 0) {
            if (iCI == 1) {
            }
            iCI2 = cI("accessibility_floating_menu_size");
            if (iCI2 == 0) {
                if (iCI2 == 1) {
                }
                iCI3 = cI("accessibility_floating_menu_icon_type");
                if (iCI3 == 0) {
                    j2 = 274877906944L;
                } else {
                    if (iCI3 == 1) {
                        return j5;
                    }
                    j2 = 549755813888L;
                }
                return j5 | j2;
            }
            j5 |= j3;
            iCI3 = cI("accessibility_floating_menu_icon_type");
            if (iCI3 == 0) {
                j2 = 274877906944L;
            } else {
                if (iCI3 == 1) {
                    return j5;
                }
                j2 = 549755813888L;
            }
            return j5 | j2;
        }
        j5 |= j4;
        iCI2 = cI("accessibility_floating_menu_size");
        if (iCI2 == 0) {
            if (iCI2 == 1) {
            }
            iCI3 = cI("accessibility_floating_menu_icon_type");
            if (iCI3 == 0) {
                j2 = 274877906944L;
            } else {
                if (iCI3 == 1) {
                    return j5;
                }
                j2 = 549755813888L;
            }
            return j5 | j2;
        }
        j5 |= j3;
        iCI3 = cI("accessibility_floating_menu_icon_type");
        if (iCI3 == 0) {
            j2 = 274877906944L;
        } else {
            if (iCI3 == 1) {
                return j5;
            }
            j2 = 549755813888L;
        }
        return j5 | j2;
    }

    protected float DR() {
        try {
            return Settings.System.getFloat(this.E.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e2) {
            this.sdk.BL();
            if (!x.Fk()) {
                return -1.0f;
            }
            this.sdk.BL().c("DataProvider", "Error collecting font scale", e2);
            return -1.0f;
        }
    }

    protected boolean DS() {
        e eVar = this.aDw;
        if (eVar == null || eVar.isExpired()) {
            e eVar2 = new e(Boolean.valueOf(com.applovin.impl.sdk.utils.u.Lx()), this.aDE);
            this.aDw = eVar2;
            return ((Boolean) eVar2.aEb).booleanValue();
        }
        return ((Boolean) this.aDw.aEb).booleanValue();
    }

    protected boolean De() {
        ConnectivityManager connectivityManager;
        if (!com.applovin.impl.sdk.utils.h.KX() || (connectivityManager = (ConnectivityManager) this.E.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            return connectivityManager.getRestrictBackgroundStatus() == 3;
        } catch (Throwable th) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("DataProvider", "Unable to collect constrained network info.", th);
            }
            return false;
        }
    }

    protected boolean Dv() {
        try {
            return Dy() || Dz();
        } catch (Throwable unused) {
            return false;
        }
    }

    protected boolean DT() {
        return (this.E.getResources().getConfiguration().keyboard == 2) && (this.E.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE") || this.E.getPackageManager().hasSystemFeature("android.hardware.type.pc"));
    }

    protected String[] Dx() {
        if (com.applovin.impl.sdk.utils.h.KV()) {
            return Build.SUPPORTED_ABIS;
        }
        return null;
    }

    private boolean Dy() {
        String str = Build.TAGS;
        return str != null && str.contains(cJ("lz}$blpz"));
    }

    private boolean Dz() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i2 = 0; i2 < 9; i2++) {
            if (new File(cJ(strArr[i2])).exists()) {
                return true;
            }
        }
        return false;
    }

    private String cJ(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = str.charAt(i2);
            for (int i3 = 9; i3 >= 0; i3--) {
                cArr[i2] = (char) (cArr[i2] ^ iArr[i3]);
            }
        }
        return new String(cArr);
    }

    private boolean cH(String str) {
        return cI(str) == 1;
    }

    private int cI(String str) {
        try {
            return Settings.Secure.getInt(this.E.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static class b {
        private final int aDd;

        /* JADX INFO: renamed from: do, reason: not valid java name */
        private final String f12do;

        public b(String str, int i) {
            this.f12do = str;
            this.aDd = i;
        }

        public String mQ() {
            return this.f12do;
        }

        public int Eq() {
            return this.aDd;
        }
    }

    protected class h {
        private final PowerManager iT;

        private h() {
            this.iT = (PowerManager) q.this.E.getSystemService("power");
        }

        protected Integer EM() {
            if (q.this.aDu == null || q.this.aDu.isExpired()) {
                if (this.iT == null || !com.applovin.impl.sdk.utils.h.KV()) {
                    return null;
                }
                q.this.aDu = new e(Integer.valueOf(this.iT.isPowerSaveMode() ? 1 : 0), q.this.aDD);
                return Integer.valueOf(((Integer) q.this.aDu.aEb).intValue());
            }
            return Integer.valueOf(((Integer) q.this.aDu.aEb).intValue());
        }
    }

    protected class i {
        private final TelephonyManager aEp;
        private String aEq;
        private String aEr;
        private String aEs;
        private String aEt;
        private String aEu;
        private e aEv;

        public String getCountryCode() {
            return this.aEr;
        }

        public String EO() {
            return this.aEs;
        }

        public String EP() {
            return this.aEt;
        }

        public String EQ() {
            return this.aEu;
        }

        private i() {
            TelephonyManager telephonyManager = (TelephonyManager) q.this.E.getSystemService("phone");
            this.aEp = telephonyManager;
            if (telephonyManager == null) {
                return;
            }
            this.aEr = telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH);
            try {
                this.aEs = telephonyManager.getNetworkOperatorName();
            } catch (Throwable th) {
                q.this.sdk.BL();
                if (x.Fk()) {
                    q.this.sdk.BL().c("DataProvider", "Unable to collect carrier", th);
                }
            }
            try {
                this.aEq = this.aEp.getNetworkOperator();
            } catch (Throwable th2) {
                q.this.sdk.BL();
                if (x.Fk()) {
                    q.this.sdk.BL().c("DataProvider", "Unable to collect get network operator", th2);
                }
            }
            String str = this.aEq;
            if (str == null) {
                return;
            }
            int iMin = Math.min(3, str.length());
            this.aEt = this.aEq.substring(0, iMin);
            this.aEu = this.aEq.substring(iMin);
        }

        protected Integer EN() {
            e eVar = this.aEv;
            if (eVar == null || eVar.isExpired()) {
                if (!com.applovin.impl.sdk.utils.h.d("android.permission.READ_PHONE_STATE", q.this.E) || this.aEp == null || !com.applovin.impl.sdk.utils.h.KX()) {
                    return null;
                }
                e eVar2 = new e(Integer.valueOf(this.aEp.getDataNetworkType()), q.this.aDG);
                this.aEv = eVar2;
                return Integer.valueOf(((Integer) eVar2.aEb).intValue());
            }
            return Integer.valueOf(((Integer) this.aEv.aEb).intValue());
        }
    }

    protected class d {
        private e aDW;
        private e aDX;
        private e aDY;
        private final Intent aDZ;
        private BatteryManager aEa;

        private d() {
            this.aDZ = q.this.E.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (com.applovin.impl.sdk.utils.h.KV()) {
                this.aEa = (BatteryManager) q.this.E.getSystemService("batterymanager");
            }
        }

        protected Integer Ew() {
            int intProperty;
            BatteryManager batteryManager;
            e eVar = this.aDW;
            if (eVar == null || eVar.isExpired()) {
                if (com.applovin.impl.sdk.utils.h.KV() && (batteryManager = this.aEa) != null) {
                    intProperty = batteryManager.getIntProperty(4);
                } else {
                    Intent intent = this.aDZ;
                    if (intent == null) {
                        return null;
                    }
                    int intExtra = intent.getIntExtra("level", -1);
                    int intExtra2 = this.aDZ.getIntExtra("scale", -1);
                    if (intExtra < 0 || intExtra2 < 0) {
                        return null;
                    }
                    intProperty = (int) ((intExtra / intExtra2) * 100.0f);
                }
                e eVar2 = new e(Integer.valueOf(intProperty), q.this.aDD);
                this.aDW = eVar2;
                return Integer.valueOf(((Integer) eVar2.aEb).intValue());
            }
            return Integer.valueOf(((Integer) this.aDW.aEb).intValue());
        }

        protected Integer Ex() {
            int intExtra;
            BatteryManager batteryManager;
            e eVar = this.aDX;
            if (eVar == null || eVar.isExpired()) {
                if (com.applovin.impl.sdk.utils.h.KY() && (batteryManager = this.aEa) != null) {
                    intExtra = batteryManager.getIntProperty(6);
                } else {
                    Intent intent = this.aDZ;
                    if (intent == null || (intExtra = intent.getIntExtra("status", -1)) < 0) {
                        return null;
                    }
                }
                e eVar2 = new e(Integer.valueOf(intExtra), q.this.aDD);
                this.aDX = eVar2;
                return Integer.valueOf(((Integer) eVar2.aEb).intValue());
            }
            return Integer.valueOf(((Integer) this.aDX.aEb).intValue());
        }

        protected Boolean Ey() {
            e eVar = this.aDY;
            if (eVar == null || eVar.isExpired()) {
                if (com.applovin.impl.sdk.utils.h.KT()) {
                    this.aDY = new e(Boolean.valueOf(Settings.Global.getInt(q.this.E.getContentResolver(), "stay_on_while_plugged_in", -1) > 0), q.this.aDD);
                } else {
                    Intent intent = this.aDZ;
                    if (intent == null) {
                        return null;
                    }
                    this.aDY = new e(Boolean.valueOf(((((intent.getIntExtra("plugged", -1) & 1) | 2) | 4) | 8) > 0), q.this.aDD);
                }
                return Boolean.valueOf(((Boolean) this.aDY.aEb).booleanValue());
            }
            return Boolean.valueOf(((Boolean) this.aDY.aEb).booleanValue());
        }
    }

    protected class c {
        private final AudioManager K;
        private e aDR;
        private e aDS;
        private e aDT;
        private e aDU;
        private e aDV;

        private c() {
            this.K = (AudioManager) q.this.E.getSystemService("audio");
        }

        protected int Er() {
            e eVar = this.aDT;
            if (eVar == null || eVar.isExpired()) {
                q qVar = q.this;
                e eVar2 = new e(Integer.valueOf(qVar.sdk.Ch().AT()), q.this.aDD);
                this.aDT = eVar2;
                return ((Integer) eVar2.aEb).intValue();
            }
            return ((Integer) this.aDT.aEb).intValue();
        }

        protected Integer Es() {
            e eVar = this.aDR;
            if (eVar == null || eVar.isExpired()) {
                if (this.K == null) {
                    return null;
                }
                try {
                    e eVar2 = new e(Integer.valueOf((int) (this.K.getStreamVolume(3) * ((Float) q.this.sdk.a(com.applovin.impl.sdk.c.b.aOL)).floatValue())), q.this.aDC);
                    this.aDR = eVar2;
                    return Integer.valueOf(((Integer) eVar2.aEb).intValue());
                } catch (Throwable th) {
                    q.this.sdk.BL();
                    if (x.Fk()) {
                        q.this.sdk.BL().c("DataProvider", "Unable to collect device volume", th);
                    }
                    return null;
                }
            }
            return Integer.valueOf(((Integer) this.aDR.aEb).intValue());
        }

        protected String Et() {
            e eVar = this.aDS;
            if (eVar == null || eVar.isExpired()) {
                if (this.K == null) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                if (com.applovin.impl.sdk.utils.h.KW()) {
                    for (AudioDeviceInfo audioDeviceInfo : this.K.getDevices(2)) {
                        sb.append(audioDeviceInfo.getType()).append(",");
                    }
                } else {
                    if (this.K.isWiredHeadsetOn()) {
                        sb.append(3).append(",");
                    }
                    if (this.K.isBluetoothScoOn()) {
                        sb.append(7).append(",");
                    }
                    if (this.K.isBluetoothA2dpOn()) {
                        sb.append(8);
                    }
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    q.this.sdk.BL();
                    if (x.Fk()) {
                        q.this.sdk.BL().f("DataProvider", "No sound outputs detected");
                    }
                }
                q qVar = q.this;
                e eVar2 = new e(string, qVar.aDE);
                this.aDS = eVar2;
                return (String) eVar2.aEb;
            }
            return (String) this.aDS.aEb;
        }

        protected Boolean Eu() {
            e eVar = this.aDU;
            if (eVar == null || eVar.isExpired()) {
                if (this.K == null) {
                    return null;
                }
                e eVar2 = new e(Boolean.valueOf(this.K.isMusicActive()), q.this.aDE);
                this.aDU = eVar2;
                return Boolean.valueOf(((Boolean) eVar2.aEb).booleanValue());
            }
            return Boolean.valueOf(((Boolean) this.aDU.aEb).booleanValue());
        }

        protected Boolean Ev() {
            e eVar = this.aDV;
            if (eVar == null || eVar.isExpired()) {
                if (this.K == null) {
                    return null;
                }
                e eVar2 = new e(Boolean.valueOf(this.K.isSpeakerphoneOn()), q.this.aDE);
                this.aDV = eVar2;
                return Boolean.valueOf(((Boolean) eVar2.aEb).booleanValue());
            }
            return Boolean.valueOf(((Boolean) this.aDV.aEb).booleanValue());
        }
    }

    protected class f {
        private float Wy;
        private int aEd;
        private int aEe;
        private int aEf;
        private float aEg;
        private float aEh;
        private double aEi;
        private final Boolean aEj;

        public int EA() {
            return this.aEd;
        }

        public int EB() {
            return this.aEe;
        }

        public int EC() {
            return this.aEf;
        }

        public float ED() {
            return this.aEg;
        }

        public float EE() {
            return this.aEh;
        }

        public float EF() {
            return this.Wy;
        }

        public double EG() {
            return this.aEi;
        }

        public Boolean EH() {
            return this.aEj;
        }

        private f() {
            this.aEj = com.applovin.impl.sdk.utils.h.KY() ? Boolean.valueOf(q.this.E.getResources().getConfiguration().isScreenHdr()) : null;
            DisplayMetrics displayMetrics = q.this.E.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                return;
            }
            this.Wy = displayMetrics.density;
            this.aEg = displayMetrics.xdpi;
            this.aEh = displayMetrics.ydpi;
            this.aEf = displayMetrics.densityDpi;
            Point pointW = com.applovin.impl.sdk.utils.h.W(q.this.E);
            this.aEd = pointW.x;
            this.aEe = pointW.y;
            this.aEi = Math.sqrt(Math.pow(this.aEd, 2.0d) + Math.pow(this.aEe, 2.0d)) / ((double) this.aEg);
        }
    }

    protected class g {
        private long aEk;
        private e aEl;
        private e aEm;
        private e aEn;
        private final ActivityManager aEo;

        public long EL() {
            return this.aEk;
        }

        private g() {
            ActivityManager activityManager = (ActivityManager) q.this.E.getSystemService("activity");
            this.aEo = activityManager;
            if (activityManager == null) {
                return;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            try {
                activityManager.getMemoryInfo(memoryInfo);
                this.aEk = memoryInfo.totalMem;
            } catch (Throwable th) {
                q.this.sdk.BL();
                if (x.Fk()) {
                    q.this.sdk.BL().c("DataProvider", "Unable to collect memory info.", th);
                }
            }
        }

        protected Long EI() {
            e eVar = this.aEl;
            if (eVar == null || eVar.isExpired()) {
                if (this.aEo == null) {
                    return null;
                }
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                try {
                    this.aEo.getMemoryInfo(memoryInfo);
                    e eVar2 = new e(Long.valueOf(memoryInfo.availMem), q.this.aDB);
                    this.aEl = eVar2;
                    return Long.valueOf(((Long) eVar2.aEb).longValue());
                } catch (Throwable th) {
                    q.this.sdk.BL();
                    if (x.Fk()) {
                        q.this.sdk.BL().c("DataProvider", "Unable to collect available memory.", th);
                    }
                    return null;
                }
            }
            return Long.valueOf(((Long) this.aEl.aEb).longValue());
        }

        protected Long EJ() {
            e eVar = this.aEm;
            if (eVar == null || eVar.isExpired()) {
                if (this.aEo == null) {
                    return null;
                }
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                try {
                    this.aEo.getMemoryInfo(memoryInfo);
                    e eVar2 = new e(Long.valueOf(memoryInfo.threshold), q.this.aDB);
                    this.aEm = eVar2;
                    return Long.valueOf(((Long) eVar2.aEb).longValue());
                } catch (Throwable th) {
                    q.this.sdk.BL();
                    if (x.Fk()) {
                        q.this.sdk.BL().c("DataProvider", "Unable to collect low memory threshold.", th);
                    }
                    return null;
                }
            }
            return Long.valueOf(((Long) this.aEm.aEb).longValue());
        }

        protected Boolean EK() {
            e eVar = this.aEn;
            if (eVar == null || eVar.isExpired()) {
                if (this.aEo == null) {
                    return null;
                }
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                try {
                    this.aEo.getMemoryInfo(memoryInfo);
                    e eVar2 = new e(Boolean.valueOf(memoryInfo.lowMemory), q.this.aDB);
                    this.aEn = eVar2;
                    return Boolean.valueOf(((Boolean) eVar2.aEb).booleanValue());
                } catch (Throwable th) {
                    q.this.sdk.BL();
                    if (x.Fk()) {
                        q.this.sdk.BL().c("DataProvider", "Unable to collect has low memory.", th);
                    }
                    return null;
                }
            }
            return Boolean.valueOf(((Boolean) this.aEn.aEb).booleanValue());
        }
    }

    public class a {
        private final String aDL;
        private final String aDM;
        private final Long aDN;
        private final long aDO;
        private final int aDP;
        private final int aDQ;
        private final String abm;
        private final String name;
        private final String version;

        public String getName() {
            return this.name;
        }

        public String getVersion() {
            return this.version;
        }

        public String Ek() {
            return this.abm;
        }

        public String El() {
            return this.aDL;
        }

        public String Em() {
            return this.aDM;
        }

        public Long En() {
            return this.aDN;
        }

        public long Eo() {
            return this.aDO;
        }

        public int getVersionCode() {
            return this.aDP;
        }

        public int Ep() {
            return this.aDQ;
        }

        private a() {
            PackageManager packageManager = q.this.E.getPackageManager();
            ApplicationInfo applicationInfo = q.this.E.getApplicationInfo();
            File file = new File(applicationInfo.sourceDir);
            PackageInfo packageInfo = packageManager.getPackageInfo(q.this.E.getPackageName(), 0);
            this.name = packageManager.getApplicationLabel(applicationInfo).toString();
            this.version = packageInfo.versionName;
            this.aDP = packageInfo.versionCode;
            String str = applicationInfo.packageName;
            this.abm = str;
            this.aDL = StringUtils.toShortSHA1Hash(str);
            this.aDO = file.lastModified();
            this.aDN = Long.valueOf(packageInfo.firstInstallTime);
            this.aDQ = applicationInfo.targetSdkVersion;
            this.aDM = packageManager.getInstallerPackageName(str);
        }

        protected Long Ej() {
            Long l = (Long) q.this.sdk.a(com.applovin.impl.sdk.c.d.aRf);
            if (l != null) {
                return l;
            }
            q.this.sdk.a(com.applovin.impl.sdk.c.d.aRf, Long.valueOf(this.aDO));
            return null;
        }
    }

    private class e {
        private final Object aEb;
        private final long aEc;

        private e(Object obj, long j) {
            this.aEb = obj;
            this.aEc = Ez() + j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isExpired() {
            return !((Boolean) q.this.sdk.a(com.applovin.impl.sdk.c.b.aOk)).booleanValue() || this.aEc - Ez() <= 0;
        }

        private long Ez() {
            return System.currentTimeMillis() / 1000;
        }
    }
}
