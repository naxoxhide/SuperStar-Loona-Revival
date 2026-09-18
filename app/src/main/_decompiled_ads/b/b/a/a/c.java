package b.b.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: TTQueuedWork.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f72b;
    private static final Object a = new Object();
    private static final LinkedList<Runnable> c = new LinkedList<>();
    private static Object d = new Object();

    /* JADX INFO: compiled from: TTQueuedWork.java */
    private static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                c.c();
            }
        }
    }

    private static Handler b() {
        Handler handler;
        synchronized (a) {
            if (f72b == null) {
                HandlerThread handlerThread = new HandlerThread("queued-work-looper", -2);
                handlerThread.start();
                f72b = new a(handlerThread.getLooper());
            }
            handler = f72b;
        }
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        LinkedList linkedList;
        synchronized (d) {
            synchronized (a) {
                LinkedList<Runnable> linkedList2 = c;
                linkedList = (LinkedList) linkedList2.clone();
                linkedList2.clear();
                b().removeMessages(1);
            }
            if (linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }
    }

    public static void a(Runnable runnable, boolean z) {
        Handler handlerB = b();
        synchronized (a) {
            c.add(runnable);
            if (z) {
                handlerB.sendEmptyMessageDelayed(1, 100L);
            } else {
                handlerB.sendEmptyMessage(1);
            }
        }
    }
}
