package b.b.a.a.d.d.f.a;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: RippleAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends d {
    public g(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.f74b.d() * 1000.0d));
        ((ViewGroup) this.d.getParent()).setClipChildren(false);
        ((ViewGroup) this.d.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.d.getParent().getParent().getParent()).setClipChildren(false);
        this.d.setTag(b.b.a.a.d.d.a.e, this.f74b.j());
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
