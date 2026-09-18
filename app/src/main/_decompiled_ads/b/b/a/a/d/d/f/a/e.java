package b.b.a.a.d.d.f.a;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CutInAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends d {
    public e(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        float f = this.d.getLayoutParams().width;
        this.d.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationX", f, 0.0f).setDuration((int) (this.f74b.d() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f).setDuration((int) (this.f74b.d() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        arrayList.add(a(duration2));
        return arrayList;
    }
}
