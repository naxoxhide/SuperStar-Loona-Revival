package b.b.a.a.d.d.f.a;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: StretchAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends d {
    public l(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        View view = this.d;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicImageView)) {
            View view2 = (View) this.d.getParent();
            this.d = view2;
            ((ViewGroup) view2).setClipChildren(true);
            ((ViewGroup) this.d.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.f74b.d() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
