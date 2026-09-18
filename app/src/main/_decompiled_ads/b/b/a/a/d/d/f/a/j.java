package b.b.a.a.d.d.f.a;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ScaleAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends d {
    public j(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        float f;
        float fM = (float) this.f74b.m();
        float fN = (float) this.f74b.n();
        String strC = this.f74b.c();
        float f2 = 1.0f;
        if ("reverse".equals(strC) || "alternate-reverse".equals(strC)) {
            f = 1.0f;
        } else {
            f = fN;
            fN = 1.0f;
            f2 = fM;
            fM = 1.0f;
        }
        this.d.setTag(b.b.a.a.d.d.a.d, this.f74b.l());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "scaleX", fM, f2).setDuration((int) (this.f74b.d() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.d, "scaleY", fN, f).setDuration((int) (this.f74b.d() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        arrayList.add(a(duration2));
        return arrayList;
    }
}
