package b.b.a.a.d.d.f.a;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MarqueeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends d {
    public f(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        this.d.setTag(b.b.a.a.d.d.a.c, Integer.valueOf(this.f74b.a()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.f74b.d() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
