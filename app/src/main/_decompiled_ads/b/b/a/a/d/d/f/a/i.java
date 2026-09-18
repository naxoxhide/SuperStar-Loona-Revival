package b.b.a.a.d.d.f.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: RubInAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends d {
    private b e;
    private float f;
    private float g;

    /* JADX INFO: compiled from: RubInAnimation.java */
    class a implements Animator.AnimatorListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.e.a(this.a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z) {
        }
    }

    /* JADX INFO: compiled from: RubInAnimation.java */
    private class b {
        private View a;

        public b(View view) {
            this.a = view;
        }

        public void a(int i) {
            if (!"top".equals(i.this.f74b.k())) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = i;
                this.a.setLayoutParams(layoutParams);
                this.a.requestLayout();
                return;
            }
            if (i.this.d instanceof ViewGroup) {
                for (int i2 = 0; i2 < ((ViewGroup) i.this.d).getChildCount(); i2++) {
                    ((ViewGroup) i.this.d).getChildAt(i2).setTranslationY(i - i.this.f);
                }
            }
            i iVar = i.this;
            iVar.d.setTranslationY(iVar.f - i);
        }
    }

    public i(View view, b.b.a.a.d.d.h.a aVar) {
        super(view, aVar);
    }

    @Override // b.b.a.a.d.d.f.a.d
    List<ObjectAnimator> a() {
        int i;
        String str;
        View view = this.d;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicBaseWidget)) {
            this.d = (View) this.d.getParent();
        }
        this.d.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f).setDuration((int) (this.f74b.d() * 1000.0d));
        View view2 = this.d;
        this.e = new b(view2);
        int i2 = view2.getLayoutParams().height;
        this.f = i2;
        this.g = this.d.getLayoutParams().width;
        if ("left".equals(this.f74b.k()) || "right".equals(this.f74b.k())) {
            i = (int) this.g;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.e, str, 0, i).setDuration((int) (this.f74b.d() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        arrayList.add(a(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new a(i2));
        return arrayList;
    }
}
