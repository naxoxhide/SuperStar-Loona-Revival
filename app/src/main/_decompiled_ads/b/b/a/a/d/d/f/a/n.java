package b.b.a.a.d.d.f.a;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TranslateAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends d {
    public n(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        float f;
        float fA = b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.f74b.q());
        float fA2 = b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), this.f74b.r());
        float f2 = 0.0f;
        if ("reverse".equals(this.f74b.c())) {
            f = 0.0f;
        } else {
            f = fA2;
            fA2 = 0.0f;
            f2 = fA;
            fA = 0.0f;
        }
        if (b.b.a.a.d.g.b.a(this.d.getContext())) {
            f2 = -f2;
            fA = -fA;
        }
        this.d.setTranslationX(f2);
        this.d.setTranslationY(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationX", f2, fA).setDuration((int) (this.f74b.d() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.d, "translationY", f, fA2).setDuration((int) (this.f74b.d() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        arrayList.add(a(duration2));
        return arrayList;
    }
}
