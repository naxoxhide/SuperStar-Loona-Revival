package com.applovin.impl.sdk.utils;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.icu.util.VersionInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;
import com.applovin.exoplayer2.ak;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.e.ab;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.internal.AnalyticsEvents;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    private static final String[] aWi = {" second ago", " minute ago", " hour ago", " day ago", " week ago", " month ago"};
    private static final String[] aWj = {" seconds ago", " minutes ago", " hours ago", " days ago", " weeks ago", " months ago"};
    private static final String[] aWk = {"s", InneractiveMediationDefs.GENDER_MALE, "h", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "w", "mth"};
    private static final int[] aWl = {60, 60, 24, 7, 4, 12};
    private static final DecimalFormat aWm = new DecimalFormat();
    private static Boolean aWn;
    private static Boolean aWo;

    public interface a {
        void onCachedResourcesChecked(boolean z);
    }

    public static float A(float f) {
        return f * 1000.0f;
    }

    public static boolean E(long j, long j2) {
        return (j & j2) != 0;
    }

    public static int LA() {
        return 2015001;
    }

    public static void LC() {
    }

    public static void LD() {
    }

    public static double bY(long j) {
        return j / 1000.0d;
    }

    public static long bZ(long j) {
        return j * 8;
    }

    public static double ca(long j) {
        return j / 1024.0d;
    }

    public static int gV(int i) {
        return i * 1024;
    }

    public static boolean Lu() {
        Context applicationContext = com.applovin.impl.sdk.n.getApplicationContext();
        if (applicationContext != null) {
            return e.V(applicationContext).dC("applovin.sdk.verbose_logging");
        }
        return false;
    }

    public static boolean ac(Context context) {
        if (context == null) {
            context = com.applovin.impl.sdk.n.getApplicationContext();
        }
        if (context != null) {
            return e.V(context).e("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    public static String dH(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    public static String b(Map<String, String> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: com.applovin.impl.sdk.utils.u.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
                public int compare(String str, String str2) {
                    return str.compareToIgnoreCase(str2);
                }
            });
            treeMap.putAll(map);
            map = treeMap;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            String value = entry.getValue();
            if (value instanceof String) {
                String str = value;
                if (str.contains("&")) {
                    value = str.replace("&", "%26");
                }
            }
            sb.append((Object) entry.getKey()).append('=').append((Object) value);
        }
        return sb.toString();
    }

    public static Map<String, String> s(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                map2.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return map2;
    }

    public static boolean d(String str, List<String> list) {
        return StringUtils.startsWithAtLeastOnePrefix(str, list);
    }

    public static int U(JSONObject jSONObject) {
        int i = JsonUtils.getInt(jSONObject, "video_completion_percent", -1);
        if (i < 0 || i > 100) {
            return 95;
        }
        return i;
    }

    public static long N(com.applovin.impl.sdk.n nVar) {
        long jLongValue = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQb)).longValue();
        long jLongValue2 = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQc)).longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (jLongValue <= 0 || jLongValue2 <= 0) ? jCurrentTimeMillis : jCurrentTimeMillis + (jLongValue - jLongValue2);
    }

    public static void a(String str, String str2, Map<String, Object> map) {
        if (map.containsKey(str)) {
            map.put(str2, map.get(str));
            map.remove(str);
        }
    }

    private static long B(float f) {
        return Math.round(f);
    }

    public static long C(float f) {
        return B(A(f));
    }

    public static String i(long j, boolean z) {
        String[] strArr = z ? aWi : aWk;
        String[] strArr2 = z ? aWj : aWk;
        long jCurrentTimeMillis = (System.currentTimeMillis() - j) / 1000;
        for (int i = 0; i < strArr.length; i++) {
            int[] iArr = aWl;
            if (jCurrentTimeMillis < iArr[i]) {
                if (jCurrentTimeMillis <= 0) {
                    return z ? "just now" : "now";
                }
                return jCurrentTimeMillis == 1 ? String.format("%d%s", Long.valueOf(jCurrentTimeMillis), strArr[i]) : String.format("%d%s", Long.valueOf(jCurrentTimeMillis), strArr2[i]);
            }
            jCurrentTimeMillis /= (long) iArr[i];
        }
        return z ? "just now" : "now";
    }

    public static double a(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.x.e("Utils", "Failed to parse double from String: " + str, th);
            return d;
        }
    }

    public static String a(Uri uri, String str, com.applovin.impl.sdk.n nVar) {
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aLS)).booleanValue()) {
            List<String> listB = nVar.b(com.applovin.impl.sdk.c.b.aLJ);
            String lastPathSegment = uri.getLastPathSegment();
            if (listB.contains(lastPathSegment)) {
                return lastPathSegment;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = uri.getQueryParameterNames().iterator();
        while (it.hasNext()) {
            String queryParameter = uri.getQueryParameter(it.next());
            if (StringUtils.isValidString(queryParameter)) {
                arrayList.add(queryParameter);
            }
        }
        arrayList.addAll(uri.getPathSegments());
        String strEncodeUriString = StringUtils.encodeUriString(TextUtils.join("_", arrayList));
        Integer num = (Integer) nVar.a(com.applovin.impl.sdk.c.b.aLK);
        int length = StringUtils.emptyIfNull(strEncodeUriString).length() + StringUtils.emptyIfNull(str).length();
        if (length > num.intValue() && StringUtils.isValidString(strEncodeUriString)) {
            strEncodeUriString = strEncodeUriString.substring(length - num.intValue());
        }
        return (StringUtils.isValidString(strEncodeUriString) && StringUtils.isValidString(str)) ? str + strEncodeUriString : strEncodeUriString;
    }

    public static void N(String str, String str2) {
        if (str == null || str.length() <= gV(8)) {
            return;
        }
        com.applovin.impl.sdk.x.F(str2, "Provided custom data parameter longer than supported (" + str.length() + " bytes, " + gV(8) + " maximum)");
    }

    public static double cb(long j) {
        return ca(bZ(j));
    }

    public static Activity a(View view, com.applovin.impl.sdk.n nVar) {
        if (view == null) {
            return null;
        }
        int i = 0;
        while (i < 1000) {
            i++;
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().c("Utils", "Encountered error while retrieving activity from view", th);
                }
            }
        }
        return null;
    }

    public static void a(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, com.applovin.impl.sdk.n nVar) {
        if (jSONObject.has("no_fill_reason")) {
            String str2 = "\n**************************************************\nNO FILL received:\n..ID: \"" + str + "\"\n..FORMAT: \"" + (maxAdFormat != null ? maxAdFormat.getLabel() : "None") + "\"\n..SDK KEY: \"" + nVar.getSdkKey() + "\"\n..PACKAGE NAME: \"" + com.applovin.impl.sdk.n.getApplicationContext().getPackageName() + "\"\n..Reason: " + JsonUtils.getObject(jSONObject, "no_fill_reason", new Object()) + "\n**************************************************\n";
            nVar.BL();
            if (com.applovin.impl.sdk.x.Fk()) {
                nVar.BL().i("AppLovinSdk", str2);
            }
        }
    }

    public static AppLovinAd a(AppLovinAd appLovinAd, com.applovin.impl.sdk.n nVar) {
        if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.f)) {
            return appLovinAd;
        }
        com.applovin.impl.sdk.ad.f fVar = (com.applovin.impl.sdk.ad.f) appLovinAd;
        AppLovinAd appLovinAdDequeueAd = nVar.BB().dequeueAd(fVar.getAdZone());
        nVar.BL();
        if (com.applovin.impl.sdk.x.Fk()) {
            nVar.BL().f("Utils", "Dequeued ad for dummy ad: " + appLovinAdDequeueAd);
        }
        if (appLovinAdDequeueAd != null) {
            fVar.e(appLovinAdDequeueAd);
            ((AppLovinAdImpl) appLovinAdDequeueAd).setDummyAd(fVar);
            return appLovinAdDequeueAd;
        }
        return fVar.Hz();
    }

    public static com.applovin.impl.sdk.ad.d l(JSONObject jSONObject, com.applovin.impl.sdk.n nVar) {
        return com.applovin.impl.sdk.ad.d.a(AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", null)), AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", null)), JsonUtils.getString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, null), true, JsonUtils.getBoolean(jSONObject, "is_direct_sold", false).booleanValue());
    }

    public static Field b(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return b(superclass, str);
        }
    }

    public static String c(Class cls, String str) {
        try {
            Field fieldB = b(cls, str);
            fieldB.setAccessible(true);
            return (String) fieldB.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<com.applovin.impl.sdk.d.a> a(String str, JSONObject jSONObject, String str2, String str3, com.applovin.impl.sdk.n nVar) {
        return a(str, jSONObject, str2, null, str3, nVar);
    }

    public static List<com.applovin.impl.sdk.d.a> a(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, com.applovin.impl.sdk.n nVar) {
        return a(str, jSONObject, str2, map, str3, null, false, nVar);
    }

    public static List<com.applovin.impl.sdk.d.a> a(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, Map<String, String> map2, boolean z, com.applovin.impl.sdk.n nVar) {
        if (map == null) {
            map = new HashMap<>(1);
        }
        Map<String, String> map3 = map;
        map3.put("{CLCODE}", str2);
        return a(str, jSONObject, map3, str3, map2, z, nVar);
    }

    public static List<com.applovin.impl.sdk.d.a> a(String str, JSONObject jSONObject, Map<String, String> map, String str2, Map<String, String> map2, boolean z, com.applovin.impl.sdk.n nVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, str, new JSONObject());
        ArrayList arrayList = new ArrayList(jSONObject2.length() + 1);
        if (StringUtils.isValidString(str2)) {
            arrayList.add(new com.applovin.impl.sdk.d.a(str2, null, map2, z));
        }
        if (jSONObject2.length() > 0) {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String strOptString = jSONObject2.optString(next);
                        String strReplace = StringUtils.replace(next, map);
                        if (!TextUtils.isEmpty(strOptString)) {
                            strOptString = StringUtils.replace(strOptString, map);
                        }
                        arrayList.add(new com.applovin.impl.sdk.d.a(strReplace, strOptString, map2, z));
                    }
                } catch (Throwable th) {
                    nVar.BL();
                    if (com.applovin.impl.sdk.x.Fk()) {
                        nVar.BL().c("Utils", "Failed to create and add postback url.", th);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean a(View view, Activity activity) {
        if (activity != null && view != null) {
            Window window = activity.getWindow();
            if (window != null) {
                return c(view, window.getDecorView());
            }
            View viewFindViewById = activity.findViewById(R.id.content);
            if (viewFindViewById != null) {
                return c(view, viewFindViewById.getRootView());
            }
        }
        return false;
    }

    public static boolean c(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (c(view, viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static View A(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        return viewFindViewById != null ? viewFindViewById : rootView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(AppLovinAd appLovinAd, com.applovin.impl.sdk.n nVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            String sdkKey = nVar.getSdkKey();
            String sdkKey2 = ((AppLovinAdBase) appLovinAd).getSdk().getSdkKey();
            if (sdkKey.equals(sdkKey2)) {
                return;
            }
            com.applovin.impl.sdk.x.H("AppLovinAd", "Ad was loaded from sdk with key: " + sdkKey2 + ", but is being rendered from sdk with key: " + sdkKey);
            nVar.BP().a(com.applovin.impl.sdk.d.f.aTa);
        }
    }

    public static Map<String, String> a(Map<String, String> map, com.applovin.impl.sdk.n nVar) {
        Map<String, String> map2 = CollectionUtils.map(map);
        for (String str : map2.keySet()) {
            String str2 = map2.get(str);
            if (str2 != null) {
                map2.put(str, StringUtils.encodeUriString(str2));
            }
        }
        return map2;
    }

    public static boolean a(Object obj, List<String> list, com.applovin.impl.sdk.n nVar) {
        if (list == null) {
            return false;
        }
        Iterator<Class> it = b(list, nVar).iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(obj)) {
                if (obj instanceof Map) {
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        if (!(entry.getKey() instanceof String)) {
                            nVar.BL();
                            if (com.applovin.impl.sdk.x.Fk()) {
                                nVar.BL().f("Utils", "Invalid key type used. Map keys should be of type String.");
                            }
                            return false;
                        }
                        if (!a(entry.getValue(), list, nVar)) {
                            return false;
                        }
                    }
                    return true;
                }
                if (!(obj instanceof List)) {
                    return true;
                }
                Iterator it2 = ((List) obj).iterator();
                while (it2.hasNext()) {
                    if (!a(it2.next(), list, nVar)) {
                        return false;
                    }
                }
                return true;
            }
        }
        nVar.BL();
        if (com.applovin.impl.sdk.x.Fk()) {
            nVar.BL().f("Utils", "Object '" + obj + "' does not match any of the required types '" + list + "'.");
        }
        return false;
    }

    private static List<Class> b(List<String> list, com.applovin.impl.sdk.n nVar) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            try {
                arrayList.add(Class.forName(str));
            } catch (ClassNotFoundException unused) {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().i("Utils", "Failed to create class for name: " + str);
                }
            }
        }
        return arrayList;
    }

    public static Object a(Object obj, com.applovin.impl.sdk.n nVar) {
        int iIntValue;
        String strValueOf;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            HashMap map2 = new HashMap(map.size());
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    strValueOf = (String) key;
                } else {
                    strValueOf = String.valueOf(key);
                }
                map2.put(strValueOf, a(entry.getValue(), nVar));
            }
            return map2;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next(), nVar));
            }
            return arrayList;
        }
        if (obj instanceof Date) {
            return String.valueOf(((Date) obj).getTime());
        }
        String strValueOf2 = String.valueOf(obj);
        if (!(obj instanceof String)) {
            return (!(obj instanceof Uri) || (iIntValue = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aLB)).intValue()) <= 0 || strValueOf2.length() <= iIntValue) ? strValueOf2 : strValueOf2.substring(0, iIntValue);
        }
        int iIntValue2 = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aLA)).intValue();
        return (iIntValue2 <= 0 || strValueOf2.length() <= iIntValue2) ? strValueOf2 : strValueOf2.substring(0, iIntValue2);
    }

    public static String ad(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.isEmpty()) {
            return null;
        }
        return listQueryIntentActivities.get(0).activityInfo.name;
    }

    public static int ae(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    public static boolean dI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean M(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (dI(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean Lv() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean a(com.applovin.impl.sdk.c.b<Boolean> bVar, com.applovin.impl.sdk.n nVar) {
        String str = nVar.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.ENABLE_BLACK_SCREEN_FIXES);
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return ((Boolean) nVar.a(bVar)).booleanValue();
    }

    public static void k(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        thread.start();
    }

    public static long dJ(String str) {
        if (!StringUtils.isValidString(str)) {
            return Long.MAX_VALUE;
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    public static void a(Closeable closeable, com.applovin.impl.sdk.n nVar) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            if (nVar != null) {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().c("Utils", "Unable to close stream: " + closeable, th);
                }
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection, com.applovin.impl.sdk.n nVar) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (nVar != null) {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().c("Utils", "Unable to disconnect connection: " + httpURLConnection, th);
                }
            }
        }
    }

    public static boolean Lw() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th) {
            com.applovin.impl.sdk.x.e("Utils", "Exception thrown while getting memory state.", th);
        }
        return runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200;
    }

    public static int dK(String str) {
        int i = 0;
        for (String str2 : str.replaceAll("-beta", ".").split("\\.")) {
            if (str2.length() > 2) {
                com.applovin.impl.sdk.x.H("Utils", "Version number components cannot be longer than two digits -> " + str);
                return i;
            }
            i = (i * 100) + Integer.parseInt(str2);
        }
        return !str.contains("-beta") ? (i * 100) + 99 : i;
    }

    public static boolean Lx() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                String displayName = networkInterfaces.nextElement().getDisplayName();
                if (displayName.contains("tun") || displayName.contains("ppp") || displayName.contains("ipsec")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.applovin.impl.sdk.x.e("Utils", "Unable to check Network Interfaces", th);
            return false;
        }
    }

    public static boolean b(Context context, com.applovin.impl.sdk.n nVar) {
        String str = nVar.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.RUN_IN_RELEASE_MODE);
        return ((StringUtils.isValidString(str) && Boolean.parseBoolean(str)) || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static void e(final String str, final Context context) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$u$0_no5vLMDtnG8Qa356bT5qHl5N8
            @Override // java.lang.Runnable
            public final void run() {
                u.c(context, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, String str) {
        Toast toastMakeText = Toast.makeText(context, str, 0);
        toastMakeText.setMargin(0.0f, 0.1f);
        toastMakeText.show();
    }

    public static void a(String str, MaxAd maxAd, Context context) {
        Toast.makeText(context, maxAd.getFormat().getLabel() + ": " + str, 1).show();
    }

    public static boolean b(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER || appLovinAdSize == AppLovinAdSize.CROSS_PROMO;
    }

    public static String Ly() {
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt(null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th) {
            com.applovin.impl.sdk.x.e("Utils", "Unable to get Android SDK codename", th);
            return "";
        }
    }

    public static String Lz() {
        try {
            return Build.VERSION.RELEASE + " (" + Ly() + " - API " + Build.VERSION.SDK_INT + ")";
        } catch (Throwable th) {
            com.applovin.impl.sdk.x.e("Utils", "Unable to get Android OS info", th);
            return "";
        }
    }

    public static String ah(Object obj) {
        if (obj instanceof com.applovin.impl.mediation.b.a) {
            return ((com.applovin.impl.mediation.b.a) obj).xz();
        }
        if (com.applovin.impl.mediation.e.c.Z(obj)) {
            return ((com.applovin.impl.sdk.ad.e) obj).Gz();
        }
        return null;
    }

    public static List<Uri> a(boolean z, com.applovin.impl.sdk.ad.e eVar, com.applovin.impl.sdk.n nVar, Context context) {
        if (eVar instanceof com.applovin.impl.b.a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Uri uri : new ArrayList(eVar.Gl())) {
            if (!nVar.Ca().c(uri.getLastPathSegment(), context)) {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().i("Utils", "Cached HTML asset missing: " + uri);
                }
                arrayList.add(uri);
            }
        }
        if (z) {
            Uri uriFG = eVar.FG();
            if (!nVar.Ca().c(uriFG.getLastPathSegment(), context)) {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().i("Utils", "Cached video missing: " + uriFG);
                }
                arrayList.add(uriFG);
            }
        }
        return arrayList;
    }

    public static void a(final boolean z, final com.applovin.impl.sdk.ad.e eVar, final com.applovin.impl.sdk.n nVar, final Context context, a aVar) {
        final WeakReference weakReference = new WeakReference(aVar);
        nVar.BM().b(new ab(nVar, "checkIfAdContainsUnavailableCachedResources", new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$u$DUCWCCF2BNa-3rRGbjVYCYJ9dJk
            @Override // java.lang.Runnable
            public final void run() {
                u.a(weakReference, eVar, nVar, context, z);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(WeakReference weakReference, com.applovin.impl.sdk.ad.e eVar, com.applovin.impl.sdk.n nVar, Context context, boolean z) {
        final a aVar = (a) weakReference.get();
        if (aVar == null) {
            return;
        }
        if (eVar instanceof com.applovin.impl.b.a) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$u$Vo1ZyTvi3ZNpEmXmliiMZNUUwBM
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.onCachedResourcesChecked(true);
                }
            });
            return;
        }
        for (Uri uri : new ArrayList(eVar.Gl())) {
            if (!nVar.Ca().b(uri.getLastPathSegment(), context)) {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().i("Utils", "Cached HTML asset unavailable: " + uri);
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$u$Vx95eiuCZo1yhOmKceJ-a3MkLNU
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.onCachedResourcesChecked(false);
                    }
                });
                return;
            }
        }
        if (z) {
            Uri uriFG = eVar.FG();
            if (!nVar.Ca().b(uriFG.getLastPathSegment(), context)) {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().i("Utils", "Cached video unavailable: " + uriFG);
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$u$evLt6blTfuWl3XRM4iRfUvkV4nY
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.onCachedResourcesChecked(false);
                    }
                });
                return;
            }
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$u$LXWlapBvxpwfTnJBKIpLyVyRh3U
            @Override // java.lang.Runnable
            public final void run() {
                aVar.onCachedResourcesChecked(true);
            }
        });
    }

    public static void a(MaxError maxError, String str, Context context) {
        StringBuilder sb = new StringBuilder();
        if (maxError.getCode() == -5001) {
            for (MaxNetworkResponseInfo maxNetworkResponseInfo : maxError.getWaterfall().getNetworkResponses()) {
                MaxError error = maxNetworkResponseInfo.getError();
                String name = maxNetworkResponseInfo.getMediatedNetwork().getName();
                sb.append("\nFailed to load " + str + " from " + name + ":\n");
                sb.append("\nMAX Error " + error.getCode() + ": " + error.getMessage() + "\n");
                sb.append("\n" + name + " Error " + error.getMediatedNetworkErrorCode() + ": " + error.getMediatedNetworkErrorMessage() + "\n\n");
            }
        } else {
            sb.append("Failed to load " + str + " with error " + maxError.getCode() + ": " + maxError.getMessage());
        }
        a("", sb.toString(), context);
    }

    public static void a(String str, String str2, Context context) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(R.string.ok, (DialogInterface.OnClickListener) null).create().show();
    }

    public static boolean gW(int i) {
        return i > 0 && i <= 100 && ((int) (Math.random() * 100.0d)) + 1 <= i;
    }

    public static boolean af(Context context) {
        return e.V(context).dC("applovin.sdk.is_test_environment");
    }

    public static Map<String, String> a(AppLovinSdkSettings appLovinSdkSettings) {
        try {
            Field fieldB = b(appLovinSdkSettings.getClass(), "metaData");
            if (fieldB != null) {
                fieldB.setAccessible(true);
            }
            return (Map) fieldB.get(appLovinSdkSettings);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean LB() {
        try {
            Class.forName("com.applovin.sdk.AppLovinSdk");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        }
    }

    public static boolean Q(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 31 && bArr[1] == -117;
    }

    public static byte[] R(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] S(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0 || !Q(bArr)) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i = gZIPInputStream.read(bArr2);
            if (i > 0) {
                byteArrayOutputStream.write(bArr2, 0, i);
            } else {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static long T(byte[] bArr) {
        return n(bArr, 0);
    }

    public static long n(byte[] bArr, int i) {
        int i2 = i + 8;
        if (bArr.length < i2) {
            throw new IllegalArgumentException("byte array must be at least 8 bytes long");
        }
        long j = 0;
        while (i < i2) {
            j |= (((long) bArr[i]) & 255) << (i * 8);
            i++;
        }
        return j;
    }

    public static int ag(Context context) {
        h.KT();
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
    }

    public static boolean O(com.applovin.impl.sdk.n nVar) {
        if (!h.KU()) {
            return true;
        }
        try {
            JSONObject.wrap(JSONObject.NULL);
            return true;
        } catch (Throwable th) {
            nVar.BL();
            if (!com.applovin.impl.sdk.x.Fk()) {
                return false;
            }
            nVar.BL().b("Utils", "Failed to wrap JSONObject with exception", th);
            return false;
        }
    }

    public static boolean ah(Context context) {
        String packageName = context.getPackageName();
        return "com.revolverolver.fliptrickster".equals(packageName) || "com.mindstormstudios.idlemakeover".equals(packageName);
    }

    public static boolean ai(Context context) {
        if (aWn == null) {
            aWn = Boolean.valueOf("com.applovin.apps.dspdemo".equals(context.getPackageName()));
        }
        return aWn.booleanValue();
    }

    public static boolean aj(Context context) {
        if (aWo == null) {
            aWo = Boolean.valueOf("com.applovin.apps.playables".equals(context.getPackageName()));
        }
        return aWo.booleanValue();
    }

    public static String dL(String str) {
        return str.replace("ALPlayableAnalytics.trackEvent = ", "ALPlayableAnalytics.trackEvent = function (eventName) {const SDK_URL = 'applovin://com.applovin.sdk/playable_event';if (!Object.values(ALPlayableEvent).includes(eventName)) {var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=0&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();return;}var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=1&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();}; ALPlayableAnalytics.trackEvent_ignore = ");
    }

    public static boolean N(List<String> list) {
        Context applicationContext = com.applovin.impl.sdk.n.getApplicationContext();
        if (applicationContext == null) {
            com.applovin.impl.sdk.x.H("Utils", "Failed to check whether or not app is member of package names");
            return false;
        }
        return list.contains(applicationContext.getPackageName());
    }

    public static String a(double d, int i) {
        DecimalFormat decimalFormat = aWm;
        decimalFormat.setMaximumFractionDigits(i);
        return decimalFormat.format(d);
    }

    public static boolean P(com.applovin.impl.sdk.n nVar) {
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNd)).booleanValue()) {
            return nVar.getSettings().isMuted();
        }
        return ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNb)).booleanValue();
    }

    public static int M(String str, String str2) {
        String digitsOnlyVersionString = StringUtils.toDigitsOnlyVersionString(str);
        String digitsOnlyVersionString2 = StringUtils.toDigitsOnlyVersionString(str2);
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                int iCompareTo = VersionInfo.getInstance(digitsOnlyVersionString).compareTo(VersionInfo.getInstance(digitsOnlyVersionString2));
                if (iCompareTo == 0) {
                    return iCompareTo;
                }
                return iCompareTo > 0 ? 1 : -1;
            }
            String[] strArrSplit = digitsOnlyVersionString.split("\\.");
            String[] strArrSplit2 = digitsOnlyVersionString2.split("\\.");
            int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
            int i = 0;
            while (i < iMax) {
                String str3 = StringUtils.isValidString(strArrSplit[i]) ? strArrSplit[i] : "0";
                String str4 = StringUtils.isValidString(strArrSplit2[i]) ? strArrSplit2[i] : "0";
                int i2 = i < strArrSplit.length ? Integer.parseInt(str3) : 0;
                int i3 = i < strArrSplit2.length ? Integer.parseInt(str4) : 0;
                if (i2 < i3) {
                    return -1;
                }
                if (i2 > i3) {
                    return 1;
                }
                i++;
            }
            return 0;
        } catch (Throwable th) {
            com.applovin.impl.sdk.x.e("Utils", "Failed to process version string.", th);
            return 0;
        }
    }

    public static WebView b(Context context, String str) {
        return a(context, str, false);
    }

    public static WebView a(Context context, String str, boolean z) {
        try {
            WebView webView = new WebView(context);
            if (z) {
                webView.setWebViewClient(new com.applovin.impl.sdk.ab());
            }
            return webView;
        } catch (Throwable th) {
            com.applovin.impl.sdk.x.e("Utils", "Failed to initialize WebView for " + str + ".", th);
            return null;
        }
    }

    public static boolean Q(com.applovin.impl.sdk.n nVar) {
        String str = nVar.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.USER_AGENT_COLLECTION_ENABLED);
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public static void a(Uri uri, Activity activity, com.applovin.impl.sdk.n nVar) {
        if (activity == null) {
            activity = nVar.CD();
        }
        Intent intent = new Intent(activity, (Class<?>) AppLovinWebViewActivity.class);
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, nVar.getSdkKey());
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_LOAD_URL, uri.toString());
        activity.startActivity(intent);
    }

    public static String a(int i, Context context, com.applovin.impl.sdk.n nVar) {
        if (i == 0) {
            return "";
        }
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            try {
                byte[] bArr = new byte[inputStreamOpenRawResource.available()];
                inputStreamOpenRawResource.read(bArr);
                return new String(bArr);
            } catch (IOException e) {
                if (nVar != null) {
                    nVar.BL();
                    if (com.applovin.impl.sdk.x.Fk()) {
                        nVar.BL().c("Utils", "Opening raw resource file threw exception", e);
                    }
                }
                return "";
            } finally {
                a((Closeable) inputStreamOpenRawResource, nVar);
            }
        } catch (Throwable th) {
            if (nVar != null) {
                nVar.BL();
                if (com.applovin.impl.sdk.x.Fk()) {
                    nVar.BL().c("Utils", "Failed to retrieve resource " + i, th);
                }
            }
            return "";
        }
    }

    public static void LE() {
        com.applovin.impl.sdk.x.D("AppLovinSdk", "Java version 8 supported.");
    }

    public static String a(ak akVar, com.applovin.impl.sdk.n nVar) {
        if (akVar == null) {
            return "Unknown error";
        }
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aQK)).booleanValue()) {
            Throwable cause = akVar.getCause();
            return "Code: " + akVar.errorCode + ", Name: " + akVar.cA() + ", Message: " + akVar.getMessage() + ", Cause Class: " + (cause != null ? cause.getClass().getName() : "") + ", Cause Message: " + (cause != null ? cause.getMessage() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
        }
        return akVar.toString();
    }

    public static boolean a(MaxAdFormat maxAdFormat, MaxAdFormat maxAdFormat2) {
        return (maxAdFormat == null || maxAdFormat2 == null || (maxAdFormat != maxAdFormat2 && (!maxAdFormat.isBannerOrLeaderAd() || !maxAdFormat2.isBannerOrLeaderAd()))) ? false : true;
    }

    public static boolean ak(Context context) {
        if (context == null) {
            return false;
        }
        try {
            context.getResources();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Context al(Context context) {
        return ak(context) ? context : com.applovin.impl.sdk.n.getApplicationContext();
    }

    public static boolean dM(String str) {
        return str != null && (str.contains("applovin.com") || str.contains("applvn.com"));
    }
}
