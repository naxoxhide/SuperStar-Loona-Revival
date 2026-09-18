package com.tnkfactory.ad.pub;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.pub.a.a0;
import com.tnkfactory.ad.pub.a.b0;
import com.tnkfactory.ad.pub.a.c0;
import com.tnkfactory.ad.pub.a.j;
import com.tnkfactory.ad.pub.a.k0;
import com.tnkfactory.ad.pub.a.l;
import com.tnkfactory.ad.pub.a.l0;
import com.tnkfactory.ad.pub.a.u;
import com.tnkfactory.ad.pub.a.x;
import com.tnkfactory.ad.pub.a.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends RelativeLayout {
    public List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f2898b;
    public List<String> c;
    public List<String> d;
    public Set<k0> e;
    public Map<String, Integer> f;
    public Map<String, String> g;
    public ArrayList<View> h;
    public Handler i;
    public View j;
    public c k;

    public class a implements com.tnkfactory.ad.pub.d.k {
        public a() {
        }

        public final void a(int i) {
            Logger.d("##### on Progress " + i);
            Handler handler = b.this.i;
            if (handler != null) {
                handler.sendEmptyMessage(i + 100);
            }
        }
    }

    /* JADX INFO: renamed from: com.tnkfactory.ad.pub.b$b, reason: collision with other inner class name */
    public class C0531b implements f.d {
        public C0531b() {
        }

        public final void a(int i) {
            Handler handler = b.this.i;
            if (handler != null) {
                handler.sendEmptyMessage(i + 100);
            }
        }
    }

    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            View view = b.this.j;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public class d implements View.OnTouchListener {
        public GestureDetector a;

        public class a extends GestureDetector.SimpleOnGestureListener {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                b.a(b.this, this.a);
                return true;
            }
        }

        public d(View view) {
            if (!view.isClickable()) {
                view.setClickable(true);
            }
            this.a = new GestureDetector(view.getContext(), new a(view));
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

    public b(Context context, View view, Set<View> set, Set<View> set2, Set<View> set3, Set<View> set4, Set<View> set5, Set<k0> set6, Map<String, String> map, Map<String, Integer> map2, Map<String, String> map3, com.tnkfactory.ad.pub.a aVar) {
        super(context);
        this.a = null;
        this.f2898b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = new c(Looper.getMainLooper());
        a(view, set, set2, set3, set4, set5, set6, map, map2, map3, aVar);
    }

    public static void a(b bVar, int i) {
        Handler handler = bVar.i;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }

    public static void b(b bVar, View view) {
        bVar.getClass();
        String str = (String) view.getTag();
        if (str == null) {
            return;
        }
        bVar.b(str);
    }

    public final View a(String str) {
        Integer num = this.f.get(str);
        if (num != null) {
            return findViewById(num.intValue());
        }
        return null;
    }

    public final void a(Handler handler) {
        this.i = handler;
        Iterator it = ((ArrayList) l0.a(this, j.class)).iterator();
        while (it.hasNext()) {
            ((j) it.next()).setHandler(this.i);
        }
        Iterator it2 = ((ArrayList) l0.a(this, com.tnkfactory.ad.pub.d.b.class)).iterator();
        while (it2.hasNext()) {
            ((com.tnkfactory.ad.pub.d.b) it2.next()).setHandler(this.i);
        }
    }

    public final void a(String str, int i) {
        View viewA = a(str);
        if (viewA != null) {
            viewA.setBackgroundColor(i);
        }
    }

    public static void a(b bVar, View view) {
        int i;
        bVar.getClass();
        if (view != null) {
            try {
                i = Integer.parseInt((String) view.getTag());
            } catch (Exception unused) {
                i = 0;
            }
        } else {
            i = 0;
        }
        Handler handler = bVar.i;
        if (handler != null) {
            bVar.i.sendMessage(handler.obtainMessage(1, i, 0));
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00a9  */
    public final void b(String str) {
        Animation animationA;
        View viewA = a(str);
        if (viewA == null) {
            return;
        }
        if (viewA instanceof com.tnkfactory.ad.pub.d) {
            com.tnkfactory.ad.pub.d dVar = (com.tnkfactory.ad.pub.d) viewA;
            if (dVar.f2912b == null) {
                return;
            }
            com.tnkfactory.ad.pub.d.i iVar = dVar.s;
            if (iVar != null && dVar.A) {
                b(((com.tnkfactory.ad.pub.c) iVar).a, dVar);
            }
            dVar.m = true;
            dVar.r = true;
            dVar.f2912b.d();
            ToggleButton toggleButton = dVar.d;
            if (toggleButton != null) {
                toggleButton.setChecked(true);
                dVar.a(700L);
                return;
            }
            return;
        }
        if (viewA.getVisibility() == 4) {
            viewA.setVisibility(0);
            animationA = l.a(this.g.get(str));
            if (animationA == null) {
                return;
            }
        } else {
            if (viewA.getVisibility() != 0) {
                return;
            }
            viewA.setVisibility(4);
            String str2 = this.g.get(str);
            if (str2 != null) {
                String strTrim = str2.trim();
                strTrim.getClass();
                strTrim.hashCode();
                switch (strTrim) {
                    case "bottom":
                        animationA = l.a();
                        break;
                    case "top":
                        animationA = l.h();
                        break;
                    case "left":
                        animationA = l.d();
                        break;
                    case "right":
                        animationA = l.f();
                        break;
                    default:
                        animationA = null;
                        break;
                }
            } else {
                animationA = null;
            }
            if (animationA == null) {
                return;
            }
        }
        viewA.startAnimation(animationA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Iterator<View> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(0);
        }
    }

    public final void a(long j) {
        if (j < 0) {
            return;
        }
        long j2 = (j + 1) * 1000;
        Iterator<View> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tnkfactory.ad.pub.-$$Lambda$b$DCCr8Oga9cVWQXu7mRy-BFW1TZg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        }, j2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    public final void a(View view, Set<View> set, Set<View> set2, Set<View> set3, Set<View> set4, Set<View> set5, Set<k0> set6, Map<String, String> map, Map<String, Integer> map2, Map<String, String> map3, com.tnkfactory.ad.pub.a aVar) {
        ?? r3;
        this.f = map2;
        this.g = map;
        this.e = set6;
        this.h = new ArrayList<>(set);
        addView(view);
        for (View view2 : set) {
            if (findViewById(view2.getId()) != null) {
                view2.setVisibility(0);
                this.j = view2;
                view2.setOnClickListener(new z(this));
                if (aVar.n0 == null) {
                    this.k.sendEmptyMessageDelayed(0, 10000L);
                }
            }
        }
        for (View view3 : set2) {
            if (findViewById(view3.getId()) != null) {
                view3.setOnClickListener(new a0(this));
            }
        }
        int i = aVar.W;
        for (View view4 : set3) {
            if (findViewById(view4.getId()) != null) {
                if (i == 0) {
                    view4.setOnClickListener(new b0(this));
                } else {
                    view4.setOnTouchListener(new d(view4));
                }
            }
        }
        for (View view5 : set4) {
            if (findViewById(view5.getId()) != null) {
                if (view5 instanceof com.tnkfactory.ad.pub.d) {
                    ((com.tnkfactory.ad.pub.d) view5).setVideoActionListener(new com.tnkfactory.ad.pub.c(this));
                } else {
                    view5.setOnClickListener(new c0(this));
                }
            }
        }
        for (View view6 : set5) {
            if (findViewById(view6.getId()) != null) {
                view6.setOnClickListener(new x(this));
            }
        }
        if (map3.size() > 0) {
            this.a = new ArrayList();
            this.f2898b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            for (String str : map3.keySet()) {
                String str2 = map3.get(str);
                if (str2 != null && str2.length() != 0) {
                    if (str2.startsWith("l")) {
                        r3 = this.a;
                    } else if (str2.startsWith(CampaignEx.JSON_KEY_AD_R)) {
                        r3 = this.f2898b;
                    } else if (str2.startsWith("t")) {
                        r3 = this.c;
                    } else if (str2.startsWith(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        r3 = this.d;
                    }
                    r3.add(str);
                }
            }
        }
        View viewA = a(u.a("c77c179fed549e"));
        if (viewA instanceof com.tnkfactory.ad.pub.d) {
            ((com.tnkfactory.ad.pub.d) viewA).setVideoProgressListener(new a());
        }
        View viewA2 = a(u.a("c77c1899fc458469f6"));
        if (viewA2 instanceof f) {
            ((f) viewA2).setVideoProgressListener(new C0531b());
        }
    }
}
