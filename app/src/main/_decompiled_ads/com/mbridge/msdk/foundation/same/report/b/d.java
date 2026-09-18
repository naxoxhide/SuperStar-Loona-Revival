package com.mbridge.msdk.foundation.same.report.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashHandlerUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements Thread.UncaughtExceptionHandler {
    private static volatile d c;
    Handler a = new Handler() { // from class: com.mbridge.msdk.foundation.same.report.b.d.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Context context;
            HashMap map;
            super.handleMessage(message);
            if (message.what == 101 && (context = (Context) d.this.f2170b.get()) != null && (message.obj instanceof HashMap) && (map = (HashMap) message.obj) != null) {
                new p(context).a((String) map.get("crashinfo"), (File) map.get(ShareInternalUtility.STAGING_PARAM));
            }
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f2170b;
    private Thread.UncaughtExceptionHandler d;
    private Throwable e;

    private d(Context context) {
        this.f2170b = new WeakReference<>(context);
    }

    public static d a(Context context) {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d(context);
                }
            }
        }
        return c;
    }

    public final void a() {
        this.d = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private String a(Throwable th, String str) {
        try {
            JSONObject jSONObjectA = a(str);
            if (jSONObjectA == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            jSONObjectA.put("crashinfo", stringWriter.toString());
            String string = jSONObjectA.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000052");
            if (th != null) {
                stringBuffer.append("&").append("crash_first_index_from_mtg=").append(c.a(th.getStackTrace()));
            } else {
                stringBuffer.append("&").append("crash_first_index_from_mtg=0");
            }
            stringBuffer.append("&exception=" + string);
            return stringBuffer.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public final JSONObject a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Context context = this.f2170b.get();
        if (context == null) {
            return null;
        }
        float fMaxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float fFreeMemory = (float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        long usableSpace = externalStorageDirectory.getUsableSpace();
        long totalSpace = externalStorageDirectory.getTotalSpace();
        String fileSize = Formatter.formatFileSize(context, usableSpace);
        String fileSize2 = Formatter.formatFileSize(context, totalSpace);
        jSONObject.put("max_memory", String.valueOf(fMaxMemory));
        jSONObject.put("memoryby_app", String.valueOf(f));
        jSONObject.put("remaining_memory", fFreeMemory);
        jSONObject.put("sdcard_remainder", fileSize);
        jSONObject.put("totalspacestr", fileSize2);
        jSONObject.put("crashtime", str);
        String strB = com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.SDK_APP_ID);
        if (!TextUtils.isEmpty(strB)) {
            jSONObject.put(PangleConstants.APP_ID, strB);
        }
        try {
            jSONObject.put("osversion", Build.VERSION.SDK_INT);
            jSONObject.put("appversioncode", b(context));
            jSONObject.put("appversionname", c(context));
            jSONObject.put("appname", d(context));
        } catch (Exception unused) {
            jSONObject.put("osversion", 0);
            jSONObject.put("appversioncode", "-1");
            jSONObject.put("appversionname", "-1");
            jSONObject.put("appname", "");
        }
        return jSONObject;
    }

    private int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String c(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("", e.getMessage());
            return "";
        }
    }

    private String d(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m.a().b();
        try {
            this.e = th;
            String strB = b();
            List<String> listB = b(strB);
            if (listB.size() > 0) {
                for (int i = 0; i < listB.size(); i++) {
                    a(a(th), listB.get(i), th, thread);
                }
                return;
            }
            a(a(th), strB, th, thread);
        } catch (Exception e) {
            a(thread, th);
            e.printStackTrace();
        }
    }

    public static List<String> b(String str) {
        try {
            List<String> listA = a(str, "<mvpackage>(.*?)</mvpackage>");
            return listA == null ? new ArrayList() : listA;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static String b() {
        try {
            com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (cVarB == null) {
                cVarB = com.mbridge.msdk.c.d.a().b();
            }
            String strN = cVarB.N();
            return TextUtils.isEmpty(strN) ? "<mvpackage>mbridge</mvpackage>" : strN;
        } catch (Exception unused) {
            return "<mvpackage>mbridge</mvpackage>";
        }
    }

    private String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString() + "\n");
        }
        return sb.toString();
    }

    private void a(String str, String str2, Throwable th, Thread thread) {
        if (str.contains(str2)) {
            HashMap<String, Object> mapC = c();
            if (mapC == null || mapC.get(ShareInternalUtility.STAGING_PARAM) == null) {
                return;
            }
            Message messageObtain = Message.obtain();
            HashMap map = new HashMap();
            map.put("crashinfo", a(th, (String) mapC.get("time")));
            map.put(ShareInternalUtility.STAGING_PARAM, mapC.get(ShareInternalUtility.STAGING_PARAM));
            messageObtain.obj = map;
            messageObtain.what = 101;
            this.a.sendMessage(messageObtain);
            a(thread, th);
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private void a(Thread thread, Throwable th) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Process.killProcess(Process.myPid());
    }

    private HashMap<String, Object> c() {
        HashMap<String, Object> map = new HashMap<>();
        if (this.e == null) {
            return null;
        }
        String strB = e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO);
        File file = new File(strB + RemoteSettings.FORWARD_SLASH_STRING);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        File file2 = new File(strB + RemoteSettings.FORWARD_SLASH_STRING + "sdkcrash" + str + ".txt");
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
            printWriter.println(a(this.e, str));
            printWriter.println("====");
            this.e.printStackTrace(printWriter);
            printWriter.close();
            map.put(ShareInternalUtility.STAGING_PARAM, file2);
            map.put("time", str);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
