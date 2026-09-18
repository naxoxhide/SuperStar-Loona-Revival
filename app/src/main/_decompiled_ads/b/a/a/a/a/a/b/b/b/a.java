package b.a.a.a.a.a.b.b.b;

import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: MediaCacheDirImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.a.a.a.a.a.a.d.b {
    private String a = "video_reward_full";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29b = "video_brand";
    private String c = "video_splash";
    private String d = "video_default";
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;

    /* JADX INFO: renamed from: b.a.a.a.a.a.b.b.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MediaCacheDirImpl.java */
    static class C0010a implements Comparator<File> {
        C0010a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file2.lastModified() - file.lastModified();
            if (jLastModified == 0) {
                return 0;
            }
            return jLastModified < 0 ? -1 : 1;
        }
    }

    private List<b.a.a.a.a.a.a.d.a> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b.a.a.a.a.a.a.d.a(new File(b()).listFiles(), b.a.a.a.a.a.b.a.d()));
        arrayList.add(new b.a.a.a.a.a.a.d.a(new File(a()).listFiles(), b.a.a.a.a.a.b.a.e()));
        arrayList.add(new b.a.a.a.a.a.a.d.a(new File(e()).listFiles(), b.a.a.a.a.a.b.a.b()));
        arrayList.add(new b.a.a.a.a.a.a.d.a(new File(d()).listFiles(), b.a.a.a.a.a.b.a.c()));
        return arrayList;
    }

    private Set<String> g() {
        HashSet hashSet = new HashSet();
        for (b.a.a.a.a.a.b.b.a aVar : b.a.a.a.a.a.b.b.a.e.values()) {
            if (aVar != null && aVar.a() != null) {
                b.a.a.a.a.a.a.f.c cVarA = aVar.a();
                hashSet.add(b.a.a.a.a.a.b.f.b.c(cVarA.b(), cVarA.e()).getAbsolutePath());
                hashSet.add(b.a.a.a.a.a.b.f.b.b(cVarA.b(), cVarA.e()).getAbsolutePath());
            }
        }
        for (b.a.a.a.a.a.b.b.c.b bVar : b.a.a.a.a.a.b.b.c.c.a.values()) {
            if (bVar != null && bVar.d() != null) {
                b.a.a.a.a.a.a.f.c cVarD = bVar.d();
                hashSet.add(b.a.a.a.a.a.b.f.b.c(cVarD.b(), cVarD.e()).getAbsolutePath());
                hashSet.add(b.a.a.a.a.a.b.f.b.b(cVarD.b(), cVarD.e()).getAbsolutePath());
            }
        }
        return hashSet;
    }

    @Override // b.a.a.a.a.a.a.d.b
    public void a(String str) {
        this.e = str;
    }

    @Override // b.a.a.a.a.a.a.d.b
    public String b() {
        if (this.f == null) {
            this.f = this.e + File.separator + this.a;
            File file = new File(this.f);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f;
    }

    @Override // b.a.a.a.a.a.a.d.b
    public synchronized void c() {
        b.a.a.a.a.a.a.i.c.b("Exec clear video cache ");
        b.a.a.a.a.a.a.i.c.b(this.e);
        List<b.a.a.a.a.a.a.d.a> listF = f();
        if (Build.VERSION.SDK_INT >= 23) {
            Set<String> setG = null;
            for (b.a.a.a.a.a.a.d.a aVar : listF) {
                File[] fileArrA = aVar.a();
                if (fileArrA != null && fileArrA.length >= aVar.b()) {
                    if (setG == null) {
                        setG = g();
                    }
                    int iB = aVar.b() - 2;
                    if (iB < 0) {
                        iB = 0;
                    }
                    a(aVar.a(), iB, setG);
                }
            }
        }
    }

    @Override // b.a.a.a.a.a.a.d.b
    public String d() {
        if (this.i == null) {
            this.i = this.e + File.separator + this.d;
            File file = new File(this.i);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.i;
    }

    public String e() {
        if (this.g == null) {
            this.g = this.e + File.separator + this.f29b;
            File file = new File(this.g);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.g;
    }

    @Override // b.a.a.a.a.a.a.d.b
    public String a() {
        if (this.h == null) {
            this.h = this.e + File.separator + this.c;
            File file = new File(this.h);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.h;
    }

    @Override // b.a.a.a.a.a.a.d.b
    public long b(b.a.a.a.a.a.a.f.c cVar) {
        if (TextUtils.isEmpty(cVar.b()) || TextUtils.isEmpty(cVar.e())) {
            return 0L;
        }
        return b.a.a.a.a.a.b.f.b.a(cVar.b(), cVar.e());
    }

    @Override // b.a.a.a.a.a.a.d.b
    public boolean a(b.a.a.a.a.a.a.f.c cVar) {
        if (TextUtils.isEmpty(cVar.b()) || TextUtils.isEmpty(cVar.e())) {
            return false;
        }
        return new File(cVar.b(), cVar.e()).exists();
    }

    private static void a(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List listAsList = Arrays.asList(fileArr);
                    Collections.sort(listAsList, new C0010a());
                    while (i < listAsList.size()) {
                        File file = (File) listAsList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) listAsList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
