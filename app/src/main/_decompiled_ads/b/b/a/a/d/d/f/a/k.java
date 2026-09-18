package b.b.a.a.d.d.f.a;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ShineAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends d {
    public k(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        int i;
        int i2;
        this.d.setTag(b.b.a.a.d.d.a.f73b, Integer.valueOf(this.f74b.e()));
        View view = this.d;
        if (view == null || !b.b.a.a.d.g.b.a(view.getContext())) {
            i = 1;
            i2 = 0;
        } else {
            i2 = 1;
            i = 0;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "shineValue", i2, i).setDuration((int) (this.f74b.d() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
