package b.b.a.a.j.e;

import java.util.Map;

/* JADX INFO: compiled from: TNCConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f239b = true;
    public Map<String, Integer> c = null;
    public Map<String, String> d = null;
    public int e = 10;
    public int f = 1;
    public int g = 1;
    public int h = 10;
    public int i = 1;
    public int j = 1;
    public int k = 900;
    public int l = 120;
    public String m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ").append(this.a);
        sb.append(" probeEnable: ").append(this.f239b);
        StringBuilder sbAppend = sb.append(" hostFilter: ");
        Map<String, Integer> map = this.c;
        sbAppend.append(map != null ? map.size() : 0);
        StringBuilder sbAppend2 = sb.append(" hostMap: ");
        Map<String, String> map2 = this.d;
        sbAppend2.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ").append(this.e).append("#").append(this.f).append("#").append(this.g);
        sb.append(" reqErr: ").append(this.h).append("#").append(this.i).append("#").append(this.j);
        sb.append(" updateInterval: ").append(this.k);
        sb.append(" updateRandom: ").append(this.l);
        sb.append(" httpBlack: ").append(this.m);
        return sb.toString();
    }
}
