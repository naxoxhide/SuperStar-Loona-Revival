package b.b.a.a.d.d.f.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: BaseAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    b.b.a.a.d.d.h.a f74b;
    public View d;
    private Set<ScheduledFuture<?>> c = new HashSet();
    public List<ObjectAnimator> a = a();

    /* JADX INFO: compiled from: BaseAnimation.java */
    class a implements Animator.AnimatorListener {
        final /* synthetic */ ObjectAnimator a;

        a(ObjectAnimator objectAnimator) {
            this.a = objectAnimator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.a.pause();
            c cVar = d.this.new c(this.a);
            ScheduledFuture<?> scheduledFutureSchedule = b.b.a.a.k.e.h().schedule(cVar, (long) (d.this.f74b.h() * 1000.0d), TimeUnit.MILLISECONDS);
            cVar.a(scheduledFutureSchedule);
            d.this.c.add(scheduledFutureSchedule);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: BaseAnimation.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ObjectAnimator a;

        b(ObjectAnimator objectAnimator) {
            this.a = objectAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getCurrentPlayTime() > 0) {
                d.this.d.setVisibility(0);
                if (d.this.d.getParent() instanceof DynamicBaseWidgetImp) {
                    ((View) d.this.d.getParent()).setVisibility(0);
                }
                this.a.removeAllUpdateListeners();
            }
        }
    }

    /* JADX INFO: compiled from: BaseAnimation.java */
    public class c implements Runnable {
        ObjectAnimator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ScheduledFuture<?> f77b;

        /* JADX INFO: compiled from: BaseAnimation.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a.resume();
            }
        }

        c(ObjectAnimator objectAnimator) {
            this.a = objectAnimator;
        }

        public void a(ScheduledFuture<?> scheduledFuture) {
            this.f77b = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT < 19 || b.b.a.a.d.e.a.a.d().b() == null) {
                return;
            }
            b.b.a.a.d.e.a.a.d().b().j().post(new a());
            if (this.f77b != null) {
                d.this.c.remove(this.f77b);
            }
        }
    }

    public d(View view, b.b.a.a.d.d.h.a aVar) {
        this.d = view;
        this.f74b = aVar;
    }

    abstract List<ObjectAnimator> a();

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.e
    public void b() {
        List<ObjectAnimator> list = this.a;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public void c() {
        List<ObjectAnimator> list = this.a;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.f74b.h() > 0.0d && Build.VERSION.SDK_INT >= 19) {
                objectAnimator.addListener(new a(objectAnimator));
            }
        }
    }

    ObjectAnimator a(ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.f74b.b() * 1000.0d));
        if (this.f74b.i() > 0) {
            objectAnimator.setRepeatCount(this.f74b.i() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!"normal".equals(this.f74b.c())) {
            if ("alternate".equals(this.f74b.c()) || "alternate-reverse".equals(this.f74b.c())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.f74b.p())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.f74b.c())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.f74b.c())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new b(objectAnimator));
        return objectAnimator;
    }
}
