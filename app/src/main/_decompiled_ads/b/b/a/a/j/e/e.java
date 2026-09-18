package b.b.a.a.j.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.n;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: TNCManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.j.e.a f241b;
    private boolean c;
    private b d;
    private Context f;
    private d g;
    private int r;
    private long a = 0;
    private boolean e = false;
    private int h = 0;
    private long i = 19700101000L;
    private int j = 0;
    private HashMap<String, Integer> k = new HashMap<>();
    private HashMap<String, Integer> l = new HashMap<>();
    private int m = 0;
    private HashMap<String, Integer> n = new HashMap<>();
    private HashMap<String, Integer> o = new HashMap<>();
    private boolean p = true;
    private Map<String, Integer> q = new HashMap();
    Handler s = new a(Looper.getMainLooper());

    /* JADX INFO: compiled from: TNCManager.java */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            e.this.a(message.arg1 != 0);
        }
    }

    private e() {
    }

    private boolean b(int i) {
        return i >= 200 && i < 400;
    }

    private void h() {
        SharedPreferences sharedPreferences = this.f.getSharedPreferences(f(), 0);
        this.h = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.i = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    private void j() {
        b.b.a.a.j.f.b.a("TNCManager", "resetTNCControlState");
        this.j = 0;
        this.k.clear();
        this.l.clear();
        this.m = 0;
        this.n.clear();
        this.o.clear();
    }

    public void b(boolean z) {
        this.c = z;
    }

    public c c() {
        d dVar = this.g;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public d d() {
        return this.g;
    }

    public Map<String, String> e() {
        c cVarC = c();
        if (cVarC != null) {
            return cVarC.d;
        }
        return null;
    }

    public String f() {
        return "ttnet_tnc_config" + this.r;
    }

    public boolean g() {
        return this.c;
    }

    public void i() {
        this.q.clear();
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && this.q.containsKey(str)) {
            this.q.put(str, 0);
        }
    }

    public b.b.a.a.j.e.a a() {
        return this.f241b;
    }

    public b b() {
        return this.d;
    }

    private boolean c(String str) {
        Map<String, String> mapE = e();
        if (mapE == null) {
            return false;
        }
        String str2 = mapE.get(str);
        if (TextUtils.isEmpty(str2) || this.q.get(str2) == null || this.q.get(str2).intValue() < 3) {
            return false;
        }
        b.b.a.a.j.f.b.a("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public String b(String str) {
        String protocol;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            String host = null;
            try {
                URL url = new URL(str);
                protocol = url.getProtocol();
                try {
                    host = url.getHost();
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                protocol = null;
            }
            if (!TextUtils.isEmpty(protocol) && ((ProxyConfig.MATCH_HTTP.equals(protocol) || "https".equals(protocol)) && !TextUtils.isEmpty(host))) {
                if (c(host)) {
                    b.b.a.a.j.f.b.a("TNCManager", "handleHostMapping, TNC host faild num over limit: " + host);
                    return str;
                }
                Map<String, String> mapE = e();
                if (mapE != null && mapE.containsKey(host)) {
                    String str2 = mapE.get(host);
                    if (TextUtils.isEmpty(str2)) {
                        return str;
                    }
                    b.b.a.a.j.f.b.a("TNCManager", "handleHostMapping, match, origin: " + str);
                    String str3 = protocol + "://" + host;
                    String str4 = protocol + "://" + str2;
                    if (str.startsWith(str3)) {
                        str = str.replaceFirst(str3, str4);
                    }
                    b.b.a.a.j.f.b.a("TNCManager", "handleHostMapping, target: " + str);
                    return str;
                }
                b.b.a.a.j.f.b.a("TNCManager", "handleHostMapping, nomatch: " + host);
            }
        }
        return str;
    }

    public synchronized void a(Context context, boolean z) {
        if (!this.e) {
            this.f = context;
            this.p = z;
            this.g = new d(context, z, this.r);
            if (z) {
                h();
            }
            b.b.a.a.j.f.b.a("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.h + " probeVersion: " + this.i);
            this.f241b = g.a().a(this.r, this.f);
            this.e = true;
        }
    }

    public synchronized void a(l lVar, n nVar) {
        if (lVar == null || nVar == null) {
            return;
        }
        if (this.p) {
            if (b.b.a.a.j.f.e.a(this.f)) {
                URL urlE = null;
                try {
                    urlE = lVar.g().e();
                } catch (Exception unused) {
                }
                if (urlE == null) {
                    return;
                }
                String protocol = urlE.getProtocol();
                String host = urlE.getHost();
                String path = urlE.getPath();
                String strA = a(lVar);
                int iB = nVar.b();
                if (ProxyConfig.MATCH_HTTP.equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(strA)) {
                        return;
                    }
                    b.b.a.a.j.f.b.a("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + strA + "#" + iB);
                    c cVarC = c();
                    if (cVarC != null && cVarC.f239b) {
                        a(nVar, host);
                    }
                    if (cVarC == null) {
                        return;
                    }
                    b.b.a.a.j.f.b.a("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + strA + "#" + iB + " " + this.j + "#" + this.k.size() + "#" + this.l.size() + " " + this.m + "#" + this.n.size() + "#" + this.o.size());
                    if (iB > 0) {
                        if (b(iB)) {
                            if (this.j > 0 || this.m > 0) {
                                j();
                            }
                            d(host);
                        } else if (!a(iB)) {
                            this.m++;
                            this.n.put(path, 0);
                            this.o.put(strA, 0);
                            if (this.m >= cVarC.h && this.n.size() >= cVarC.i && this.o.size() >= cVarC.j) {
                                b.b.a.a.j.f.b.a("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + strA + "#" + iB);
                                a(false, 0L);
                                j();
                            }
                            a(host);
                        }
                    }
                }
            }
        }
    }

    private String a(l lVar) {
        if (lVar == null || lVar.g() == null || lVar.g().e() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(lVar.g().e().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private void a(String str) {
        Map<String, String> mapE;
        if (TextUtils.isEmpty(str) || (mapE = e()) == null || !mapE.containsValue(str)) {
            return;
        }
        if (this.q.get(str) == null) {
            this.q.put(str, 1);
        } else {
            this.q.put(str, Integer.valueOf(this.q.get(str).intValue() + 1));
        }
    }

    public synchronized void a(l lVar, Exception exc) {
        if (lVar != null) {
            if (lVar.g() != null && exc != null) {
                if (this.p) {
                    if (b.b.a.a.j.f.e.a(this.f)) {
                        URL urlE = null;
                        try {
                            urlE = lVar.g().e();
                        } catch (Exception unused) {
                        }
                        if (urlE == null) {
                            return;
                        }
                        String protocol = urlE.getProtocol();
                        String host = urlE.getHost();
                        String path = urlE.getPath();
                        String strA = a(lVar);
                        if (ProxyConfig.MATCH_HTTP.equals(protocol) || "https".equals(protocol)) {
                            c cVarC = c();
                            if (cVarC == null) {
                                return;
                            }
                            b.b.a.a.j.f.b.a("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + strA + "# " + this.j + "#" + this.k.size() + "#" + this.l.size() + " " + this.m + "#" + this.n.size() + "#" + this.o.size());
                            this.j++;
                            this.k.put(path, 0);
                            this.l.put(strA, 0);
                            if (this.j >= cVarC.e && this.k.size() >= cVarC.f && this.l.size() >= cVarC.g) {
                                b.b.a.a.j.f.b.a("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + strA);
                                a(false, 0L);
                                j();
                            }
                            a(host);
                        }
                    }
                }
            }
        }
    }

    private void a(n nVar, String str) {
        int i;
        long j;
        c cVarC;
        if (nVar != null && this.p) {
            String strA = nVar.a("tnc-cmd", null);
            if (TextUtils.isEmpty(strA)) {
                b.b.a.a.j.f.b.a("TNCManager", "handleTncProbe, no probeProto, " + str);
                return;
            }
            String[] strArrSplit = strA.split("@");
            if (strArrSplit != null && strArrSplit.length == 2) {
                try {
                    i = Integer.parseInt(strArrSplit[0]);
                    try {
                        j = Long.parseLong(strArrSplit[1]);
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        b.b.a.a.j.f.b.a("TNCManager", "handleTncProbe, probeProto except, " + str);
                        j = 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 0;
                }
                b.b.a.a.j.f.b.a("TNCManager", "handleTncProbe, local: " + this.h + "@" + this.i + " svr: " + i + "@" + j + " " + str);
                if (j <= this.i) {
                    return;
                }
                this.h = i;
                this.i = j;
                this.f.getSharedPreferences(f(), 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
                if (this.h != 10000 || (cVarC = c()) == null) {
                    return;
                }
                Random random = new Random(System.currentTimeMillis());
                int i2 = cVarC.l;
                long jNextInt = i2 > 0 ? ((long) random.nextInt(i2)) * 1000 : 0L;
                b.b.a.a.j.f.b.a("TNCManager", "handleTncProbe, updateConfig delay: " + jNextInt + " " + str);
                a(true, jNextInt);
                return;
            }
            b.b.a.a.j.f.b.a("TNCManager", "handleTncProbe, probeProto err, " + str);
        }
    }

    private void a(boolean z, long j) {
        if (this.s.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.s.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.s.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.s.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        c cVarC = c();
        if (cVarC == null) {
            return;
        }
        b.b.a.a.j.f.b.a("TNCManager", "doUpdateRemote, " + z);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.a + (((long) cVarC.k) * 1000) > jElapsedRealtime) {
            b.b.a.a.j.f.b.a("TNCManager", "doUpdateRemote, time limit");
        } else {
            this.a = jElapsedRealtime;
            g.a().a(this.r, this.f).a();
        }
    }

    private boolean a(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        c cVarC = c();
        return (cVarC == null || TextUtils.isEmpty(cVarC.m) || !cVarC.m.contains(new StringBuilder().append("").append(i).toString())) ? false : true;
    }

    public e(int i) {
        this.r = i;
    }
}
