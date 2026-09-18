package b.a.a.a.a.a.b.d;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import b.a.a.a.a.a.b.c.e;
import b.a.a.a.a.a.b.c.i;
import b.a.a.a.a.a.b.c.m.c;
import b.b.a.a.k.g;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final Handler a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f58b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b.a.a.a.a.a.b.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Util.java */
    static class C0018a implements FilenameFilter {
        private Pattern a = Pattern.compile("^cpu[0-9]+$");

        C0018a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.a.matcher(str).matches();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + "-" + i2;
        }
        if (i > 0) {
            return i + "-";
        }
        if (i >= 0 || i2 <= 0) {
            return null;
        }
        return "-" + i2;
    }

    public static int c(String str) {
        return a(str, 0);
    }

    public static void a(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(String str) {
        return str != null && (str.startsWith("http://") || str.startsWith("https://"));
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static boolean b(String str) {
        return str != null && (str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str));
    }

    public static boolean b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static String a(b.a.a.a.a.a.b.c.p.a aVar, int i) {
        int iA;
        if (aVar == null || !aVar.e()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.g().toUpperCase()).append(' ').append(aVar.a()).append(' ').append(aVar.f()).append("\r\n");
        if (e.d) {
            Log.i("TAG_PROXY_headers", aVar.g().toUpperCase() + " " + aVar.a() + " " + aVar.f());
        }
        List<i.b> listA = a(aVar.d());
        boolean z = true;
        if (listA != null) {
            int size = listA.size();
            for (int i2 = 0; i2 < size; i2++) {
                i.b bVar = listA.get(i2);
                if (bVar != null) {
                    String str = bVar.a;
                    String str2 = bVar.f44b;
                    sb.append(str).append(": ").append(str2).append("\r\n");
                    if (HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(str) || (HttpHeaders.ACCEPT_RANGES.equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z = false;
                    }
                }
            }
        }
        if (z && (iA = a(aVar)) > 0) {
            sb.append("Content-Range: bytes ").append(Math.max(i, 0)).append("-").append(iA - 1).append(RemoteSettings.FORWARD_SLASH_STRING).append(iA).append("\r\n");
        }
        sb.append("Connection: close").append("\r\n");
        sb.append("\r\n");
        String string = sb.toString();
        if (e.d) {
            Log.i("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static String b(List<i.b> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            i.b bVar = list.get(0);
            if (bVar != null) {
                sb.append(bVar.a).append(": ").append(bVar.f44b).append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String b(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey()).append(": ").append((Object) entry.getValue()).append("\r\n");
        }
        return sb.toString();
    }

    public static String a(int i, int i2) {
        String strB = b(i, i2);
        if (strB == null) {
            return null;
        }
        return "bytes=" + strB;
    }

    public static List<String> a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (a(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String a(b.a.a.a.a.a.b.c.m.a aVar, int i) {
        StringBuilder sb = new StringBuilder();
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK").append("\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content").append("\r\n");
        }
        sb.append("Accept-Ranges: bytes").append("\r\n");
        sb.append("Content-Type: ").append(aVar.f50b).append("\r\n");
        if (i <= 0) {
            sb.append("Content-Length: ").append(aVar.c).append("\r\n");
        } else {
            sb.append("Content-Range: bytes ").append(i).append("-").append(aVar.c - 1).append(RemoteSettings.FORWARD_SLASH_STRING).append(aVar.c).append("\r\n");
            sb.append("Content-Length: ").append(aVar.c - i).append("\r\n");
        }
        sb.append("Connection: close").append("\r\n");
        sb.append("\r\n");
        String string = sb.toString();
        if (e.d) {
            Log.i("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static int a() {
        File[] fileArrListFiles;
        if (Build.VERSION.SDK_INT >= 17) {
            return Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (!file.exists() || (fileArrListFiles = file.listFiles(new C0018a())) == null) {
                return 1;
            }
            return Math.max(fileArrListFiles.length, 1);
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static int a(b.a.a.a.a.a.b.c.p.a aVar) {
        int iLastIndexOf;
        if (aVar == null) {
            return -1;
        }
        if (aVar.a() == 200) {
            return a(aVar.a(HttpHeaders.CONTENT_LENGTH, null), -1);
        }
        if (aVar.a() == 206) {
            String strA = aVar.a(HttpHeaders.CONTENT_RANGE, null);
            if (!TextUtils.isEmpty(strA) && (iLastIndexOf = strA.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING)) >= 0 && iLastIndexOf < strA.length() - 1) {
                return a(strA.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String a(b.a.a.a.a.a.b.c.p.a aVar, boolean z, boolean z2) {
        String strA;
        if (aVar == null) {
            if (e.d) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!aVar.e()) {
            if (e.d) {
                Log.e("TAG_PROXY_Response", "response code: " + aVar.a());
            }
            return "response code: " + aVar.a();
        }
        String strA2 = aVar.a(HttpHeaders.CONTENT_TYPE, null);
        if (!b(strA2)) {
            if (e.d) {
                Log.e("TAG_PROXY_Response", "Content-Type: " + strA2);
            }
            return "Content-Type: " + strA2;
        }
        int iA = a(aVar);
        if (iA <= 0) {
            if (e.d) {
                Log.e("TAG_PROXY_Response", "Content-Length: " + iA);
            }
            return "Content-Length: " + iA;
        }
        if (z && ((strA = aVar.a(HttpHeaders.ACCEPT_RANGES, null)) == null || !strA.contains("bytes"))) {
            if (e.d) {
                Log.e("TAG_PROXY_Response", "Accept-Ranges: " + strA);
            }
            return "Accept-Ranges: " + strA;
        }
        if (!z2 || aVar.b() != null) {
            return null;
        }
        if (e.d) {
            Log.e("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static void a(g gVar) {
        if (gVar != null) {
            if (b()) {
                b.b.a.a.k.e.c(gVar);
                if (e.d) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            gVar.run();
            if (e.d) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            if (b()) {
                runnable.run();
            } else {
                a.post(runnable);
            }
        }
    }

    public static List<i.b> a(List<i.b> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (e.d) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                i.b bVar = list.get(i);
                if (bVar != null) {
                    Log.i("TAG_PROXY_PRE_FILTER", bVar.a + ": " + bVar.a);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (i.b bVar2 : list) {
            if (HttpHeaders.HOST.equals(bVar2.a) || HttpHeaders.KEEP_ALIVE.equals(bVar2.a) || HttpHeaders.CONNECTION.equals(bVar2.a) || "Proxy-Connection".equals(bVar2.a)) {
                arrayList.add(bVar2);
            }
        }
        list.removeAll(arrayList);
        if (e.d) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i.b bVar3 = list.get(i2);
                if (bVar3 != null) {
                    Log.i("TAG_PROXY_POST_FILTER", bVar3.a + ": " + bVar3.f44b);
                }
            }
        }
        return list;
    }

    public static List<i.b> a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : setEntrySet) {
                    arrayList.add(new i.b(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static b.a.a.a.a.a.b.c.m.a a(b.a.a.a.a.a.b.c.p.a aVar, c cVar, String str, int i) {
        String strB;
        String str2;
        String string;
        b.a.a.a.a.a.b.c.m.a aVarA = cVar.a(str, i);
        if (aVarA != null) {
            return aVarA;
        }
        int iA = a(aVar);
        String strA = aVar.a(HttpHeaders.CONTENT_TYPE, null);
        if (iA <= 0 || TextUtils.isEmpty(strA)) {
            return aVarA;
        }
        b.a.a.a.a.a.b.c.p.e eVarC = aVar.c();
        if (eVarC != null) {
            str2 = eVarC.a;
            strB = b(eVarC.f55b);
        } else {
            strB = "";
            str2 = strB;
        }
        String strB2 = b(aVar.d());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str2);
            jSONObject.put("requestHeaders", strB);
            jSONObject.put("responseHeaders", strB2);
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = "";
        }
        b.a.a.a.a.a.b.c.m.a aVar2 = new b.a.a.a.a.a.b.c.m.a(str, strA, iA, i, string);
        cVar.a(aVar2);
        return aVar2;
    }
}
