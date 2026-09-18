package b.b.a.a.d.d.f.a;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: WaggleAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends d {
    public o(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationX", 0.0f, b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), 20.0f), 0.0f, -b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), 20.0f), 0.0f).setDuration((int) (this.f74b.d() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
