package b.b.a.a.d.d.f.a;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AlphaAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends d {
    public a(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        float fG = this.f74b.g() / 100.0f;
        float f = this.f74b.f() / 100.0f;
        if ("reverse".equals(this.f74b.c()) && this.f74b.b() <= 0.0d) {
            f = fG;
            fG = f;
        }
        this.d.setAlpha(fG);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "alpha", fG, f).setDuration((int) (this.f74b.d() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
