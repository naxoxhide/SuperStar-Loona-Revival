package com.igaworks.adpopcorn.cores.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Pair;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    class a implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1614b;

        a(Context context, String str) {
            this.a = context;
            this.f1614b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                String strD = j.d(this.a);
                String strE = j.e(this.a);
                List<Pair<String, String>> listC = j.c(this.a, this.f1614b);
                for (String str : j.a()) {
                    File file = new File(absolutePath + str + strD);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, strE);
                    if (file2.exists()) {
                        h.a(this.a, "APSignatureManager", "createSignature > already exist file : " + str, 3);
                    } else {
                        h.a(this.a, "APSignatureManager", "createSignature > " + ((String) listC.get(0).second) + "\n" + ((String) listC.get(1).second), 3);
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        PrintWriter printWriter = new PrintWriter(fileOutputStream);
                        Iterator<Pair<String, String>> it = listC.iterator();
                        while (it.hasNext()) {
                            printWriter.println((String) it.next().second);
                        }
                        printWriter.flush();
                        printWriter.close();
                        fileOutputStream.close();
                    }
                }
            } catch (Exception e) {
                h.a(this.a, "APSignatureManager", e.toString(), 3);
            }
        }
    }

    class b implements com.igaworks.adpopcorn.cores.common.a.c {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // com.igaworks.adpopcorn.cores.common.a.c
        public void a(com.igaworks.adpopcorn.cores.common.a.d dVar) {
            j.b(this.a, dVar == null ? "" : dVar.a());
        }
    }

    public static List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("/Android/data/");
        arrayList.add("/System/data/");
        arrayList.add("/data/build/");
        return arrayList;
    }

    public static boolean a(Context context, String str) {
        String str2;
        List<Pair<String, String>> list;
        Iterator<String> it;
        String strReplace;
        Object obj;
        String str3 = "build.serial=";
        if (!c(context)) {
            return true;
        }
        try {
            List<Pair<String, String>> listC = c(context, str);
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            String strD = d(context);
            String strE = e(context);
            Iterator<String> it2 = a().iterator();
            boolean z = true;
            while (it2.hasNext()) {
                String next = it2.next();
                File file = new File(absolutePath + next + strD + RemoteSettings.FORWARD_SLASH_STRING + strE);
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            str2 = str3;
                            list = listC;
                            it = it2;
                            break;
                        }
                        String str4 = "build.version=";
                        if (line.contains(str3)) {
                            str4 = str3;
                        } else if (!line.contains("build.version=")) {
                            str4 = line.contains("build.sign=") ? "build.sign=" : null;
                        }
                        if (str4 == null) {
                            h.a(context, "APSignatureManager", "not valid sig > myFile.exists() is true but not valid key : " + line, 3);
                            str2 = str3;
                            list = listC;
                            it = it2;
                            z = false;
                            break;
                        }
                        Iterator<Pair<String, String>> it3 = listC.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                str2 = str3;
                                list = listC;
                                it = it2;
                                break;
                            }
                            str2 = str3;
                            Pair<String, String> next2 = it3.next();
                            list = listC;
                            try {
                                it = it2;
                                try {
                                    strReplace = line.replace(str4 + "=", "");
                                } catch (Exception unused) {
                                    strReplace = null;
                                }
                            } catch (Exception unused2) {
                                it = it2;
                            }
                            if (!str4.equals("build.sign=") || ((obj = next2.second) != null && !((String) obj).equals("") && strReplace != null && !strReplace.equals(""))) {
                                if (((String) next2.first).equals(str4) && !strReplace.equals(next2.second)) {
                                    h.a(context, "APSignatureManager", "not valid sig > myFile.exists() is true but key/value : nvp.getName() = " + ((String) next2.first) + ", nvp.getValue() = " + ((String) next2.second) + ", stored = " + strReplace, 3);
                                    z = false;
                                    break;
                                }
                            } else {
                                h.a(context, "APSignatureManager", "cannot find sign value.", 3);
                            }
                            listC = list;
                            str3 = str2;
                            it2 = it;
                        }
                        if (!z) {
                            break;
                        }
                        listC = list;
                        str3 = str2;
                        it2 = it;
                    }
                    fileInputStream.close();
                    bufferedReader.close();
                } else {
                    str2 = str3;
                    list = listC;
                    it = it2;
                    h.a(context, "APSignatureManager", "myFile.exists() is false : " + absolutePath + next + strD + RemoteSettings.FORWARD_SLASH_STRING + strE, 3);
                    b(context, str);
                }
                listC = list;
                str3 = str2;
                it2 = it;
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void b(Context context, String str) {
        if (c(context)) {
            new Thread(new a(context, str)).start();
        }
    }

    public static List<Pair<String, String>> c(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        String str2 = "build.serial=" + l.a(str);
        String str3 = "build.version=" + l.a(Build.PRODUCT);
        arrayList.add(new Pair("build.serial=", str2));
        arrayList.add(new Pair("build.version=", str3));
        try {
            arrayList.add(new Pair("build.sign=", "build.sign=" + l.a(str)));
        } catch (Exception e) {
            h.a(context, "APSignatureManager", e.toString(), 3);
        }
        return arrayList;
    }

    public static boolean c(Context context) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context) {
        String strB;
        try {
            strB = com.igaworks.adpopcorn.a.d.a(context).e().b();
        } catch (Exception unused) {
            strB = "";
        }
        return "com." + l.a(strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context) {
        String strC;
        try {
            strC = com.igaworks.adpopcorn.a.d.a(context).e().c();
        } catch (Exception unused) {
            strC = "";
        }
        return "data_" + l.a(strC + ".dat");
    }

    public static void f(Context context) {
        if (c(context)) {
            try {
                h.a(context, "APSignatureManager", "resetSgn called. ", 3);
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                String strD = d(context);
                String strE = e(context);
                Iterator<String> it = a().iterator();
                while (it.hasNext()) {
                    File file = new File(absolutePath + it.next() + strD + RemoteSettings.FORWARD_SLASH_STRING + strE);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                l.a(context).a(context, new b(context));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
