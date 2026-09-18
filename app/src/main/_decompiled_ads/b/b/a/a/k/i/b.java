package b.b.a.a.k.i;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.y;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: HandlerWapper.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends y implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f254b;

    b(HandlerThread handlerThread, y.a aVar) {
        super(handlerThread.getLooper(), aVar);
        this.f254b = handlerThread;
    }

    @Override // b.b.a.a.k.i.c
    public void a() {
        removeCallbacksAndMessages(null);
        WeakReference<y.a> weakReference = this.a;
        if (weakReference != null) {
            weakReference.clear();
            this.a = null;
        }
    }

    public void b() {
        HandlerThread handlerThread = this.f254b;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public void a(y.a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    public void a(String str) {
        HandlerThread handlerThread = this.f254b;
        if (handlerThread != null) {
            handlerThread.setName(str);
        }
    }
}
