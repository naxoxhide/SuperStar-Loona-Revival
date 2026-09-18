package b.b.a.a.f.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FormBody.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends m {
    e(List<String> list, List<String> list2) {
    }

    /* JADX INFO: compiled from: FormBody.java */
    public static final class a {
        private final List<String> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f142b = new ArrayList();

        public a a(String str, String str2) {
            this.a.add(str);
            this.f142b.add(str2);
            return this;
        }

        public e a() {
            return new e(this.a, this.f142b);
        }
    }
}
