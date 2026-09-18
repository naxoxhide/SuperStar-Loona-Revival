package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.l.ab;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.t;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f extends FrameLayout {
    private final ba.c U;
    private boolean WG;
    private long[] WJ;
    private boolean[] WK;
    private final b WL;
    private final CopyOnWriteArrayList<d> WM;
    private final View WN;
    private final View WO;
    private final View WP;
    private final View WQ;
    private final View WR;
    private final View WS;
    private final ImageView WT;
    private final ImageView WU;
    private final View WV;
    private final TextView WW;
    private final TextView WX;
    private final k WY;
    private final Runnable WZ;
    private final StringBuilder Wu;
    private final Formatter Wv;
    private long XA;
    private long[] XB;
    private boolean[] XC;
    private long XD;
    private long XE;
    private long XF;
    private final Runnable Xa;
    private final Drawable Xb;
    private final Drawable Xc;
    private final Drawable Xd;
    private final String Xe;
    private final String Xf;
    private final String Xg;
    private final Drawable Xh;
    private final Drawable Xi;
    private final float Xj;
    private final float Xk;
    private final String Xl;
    private final String Xm;
    private com.applovin.exoplayer2.i Xn;
    private c Xo;
    private boolean Xp;
    private boolean Xq;
    private boolean Xr;
    private int Xs;
    private int Xt;
    private int Xu;
    private boolean Xv;
    private boolean Xw;
    private boolean Xx;
    private boolean Xy;
    private boolean Xz;
    private final ba.a bI;
    private an jb;

    public interface c {
        void z(long j, long j2);
    }

    public interface d {
        void eZ(int i);
    }

    private static boolean eY(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    static {
        t.f("goog.exo.ui");
    }

    public f(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int resourceId = R.layout.applovin_exo_player_control_view;
        this.Xs = 5000;
        this.Xu = 0;
        this.Xt = 200;
        this.XA = -9223372036854775807L;
        this.Xv = true;
        this.Xw = true;
        this.Xx = true;
        this.Xy = true;
        this.Xz = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.AppLovinPlayerControlView, i, 0);
            try {
                this.Xs = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerControlView_al_show_timeout, this.Xs);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerControlView_al_controller_layout_id, resourceId);
                this.Xu = a(typedArrayObtainStyledAttributes, this.Xu);
                this.Xv = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_rewind_button, this.Xv);
                this.Xw = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_fastforward_button, this.Xw);
                this.Xx = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_previous_button, this.Xx);
                this.Xy = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_next_button, this.Xy);
                this.Xz = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_shuffle_button, this.Xz);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerControlView_al_time_bar_min_update_interval, this.Xt));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.WM = new CopyOnWriteArrayList<>();
        this.bI = new ba.a();
        this.U = new ba.c();
        StringBuilder sb = new StringBuilder();
        this.Wu = sb;
        this.Wv = new Formatter(sb, Locale.getDefault());
        this.WJ = new long[0];
        this.WK = new boolean[0];
        this.XB = new long[0];
        this.XC = new boolean[0];
        b bVar = new b();
        this.WL = bVar;
        this.Xn = new com.applovin.exoplayer2.j();
        this.WZ = new Runnable() { // from class: com.applovin.exoplayer2.ui.-$$Lambda$f$EK8zu3oPBYpFiTYi4xYCaEW7d94
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.nB();
            }
        };
        this.Xa = new Runnable() { // from class: com.applovin.exoplayer2.ui.-$$Lambda$QRbLTv1mZBKvnDuACVRV2diCbv8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.nt();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        k kVar = (k) findViewById(R.id.al_exo_progress);
        View viewFindViewById = findViewById(R.id.al_exo_progress_placeholder);
        if (kVar != null) {
            this.WY = kVar;
        } else if (viewFindViewById != null) {
            com.applovin.exoplayer2.ui.d dVar = new com.applovin.exoplayer2.ui.d(context, null, 0, attributeSet2);
            dVar.setId(R.id.al_exo_progress);
            dVar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(dVar, iIndexOfChild);
            this.WY = dVar;
        } else {
            this.WY = null;
        }
        this.WW = (TextView) findViewById(R.id.al_exo_duration);
        this.WX = (TextView) findViewById(R.id.al_exo_position);
        k kVar2 = this.WY;
        if (kVar2 != null) {
            kVar2.a(bVar);
        }
        View viewFindViewById2 = findViewById(R.id.al_exo_play);
        this.WP = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(bVar);
        }
        View viewFindViewById3 = findViewById(R.id.al_exo_pause);
        this.WQ = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(bVar);
        }
        View viewFindViewById4 = findViewById(R.id.al_exo_prev);
        this.WN = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(bVar);
        }
        View viewFindViewById5 = findViewById(R.id.al_exo_next);
        this.WO = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(bVar);
        }
        View viewFindViewById6 = findViewById(R.id.al_exo_rew);
        this.WS = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(bVar);
        }
        View viewFindViewById7 = findViewById(R.id.al_exo_ffwd);
        this.WR = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(bVar);
        }
        ImageView imageView = (ImageView) findViewById(R.id.al_exo_repeat_toggle);
        this.WT = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(bVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.al_exo_shuffle);
        this.WU = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(bVar);
        }
        View viewFindViewById8 = findViewById(R.id.al_exo_vr);
        this.WV = viewFindViewById8;
        setShowVrButton(false);
        a(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.Xj = resources.getInteger(R.integer.al_exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.Xk = resources.getInteger(R.integer.al_exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.Xb = resources.getDrawable(R.drawable.al_exo_controls_repeat_off);
        this.Xc = resources.getDrawable(R.drawable.al_exo_controls_repeat_one);
        this.Xd = resources.getDrawable(R.drawable.al_exo_controls_repeat_all);
        this.Xh = resources.getDrawable(R.drawable.al_exo_controls_shuffle_on);
        this.Xi = resources.getDrawable(R.drawable.al_exo_controls_shuffle_off);
        this.Xe = resources.getString(R.string.al_exo_controls_repeat_off_description);
        this.Xf = resources.getString(R.string.al_exo_controls_repeat_one_description);
        this.Xg = resources.getString(R.string.al_exo_controls_repeat_all_description);
        this.Xl = resources.getString(R.string.al_exo_controls_shuffle_on_description);
        this.Xm = resources.getString(R.string.al_exo_controls_shuffle_off_description);
    }

    public an getPlayer() {
        return this.jb;
    }

    public void setPlayer(an anVar) {
        boolean z = true;
        com.applovin.exoplayer2.l.a.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (anVar != null && anVar.az() != Looper.getMainLooper()) {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkArgument(z);
        an anVar2 = this.jb;
        if (anVar2 == anVar) {
            return;
        }
        if (anVar2 != null) {
            anVar2.b(this.WL);
        }
        this.jb = anVar;
        if (anVar != null) {
            anVar.a(this.WL);
        }
        nv();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.Xq = z;
        nA();
    }

    public void a(d dVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(dVar);
        this.WM.add(dVar);
    }

    public void b(d dVar) {
        this.WM.remove(dVar);
    }

    public void setProgressUpdateListener(c cVar) {
        this.Xo = cVar;
    }

    @Deprecated
    public void setControlDispatcher(com.applovin.exoplayer2.i iVar) {
        if (this.Xn != iVar) {
            this.Xn = iVar;
            nx();
        }
    }

    public void setShowRewindButton(boolean z) {
        this.Xv = z;
        nx();
    }

    public void setShowFastForwardButton(boolean z) {
        this.Xw = z;
        nx();
    }

    public void setShowPreviousButton(boolean z) {
        this.Xx = z;
        nx();
    }

    public void setShowNextButton(boolean z) {
        this.Xy = z;
        nx();
    }

    public int getShowTimeoutMs() {
        return this.Xs;
    }

    public void setShowTimeoutMs(int i) {
        this.Xs = i;
        if (mx()) {
            nu();
        }
    }

    public int getRepeatToggleModes() {
        return this.Xu;
    }

    public void setRepeatToggleModes(int i) {
        this.Xu = i;
        an anVar = this.jb;
        if (anVar != null) {
            int iAF = anVar.aF();
            if (i == 0 && iAF != 0) {
                this.Xn.a(this.jb, 0);
            } else if (i == 1 && iAF == 2) {
                this.Xn.a(this.jb, 1);
            } else if (i == 2 && iAF == 1) {
                this.Xn.a(this.jb, 2);
            }
        }
        ny();
    }

    public boolean getShowShuffleButton() {
        return this.Xz;
    }

    public void setShowShuffleButton(boolean z) {
        this.Xz = z;
        nz();
    }

    public boolean getShowVrButton() {
        View view = this.WV;
        return view != null && view.getVisibility() == 0;
    }

    public void setShowVrButton(boolean z) {
        View view = this.WV;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.WV;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            a(getShowVrButton(), onClickListener != null, this.WV);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.Xt = ai.k(i, 16, 1000);
    }

    public void show() {
        if (!mx()) {
            setVisibility(0);
            Iterator<d> it = this.WM.iterator();
            while (it.hasNext()) {
                it.next().eZ(getVisibility());
            }
            nv();
            nC();
            nD();
        }
        nu();
    }

    public void nt() {
        if (mx()) {
            setVisibility(8);
            Iterator<d> it = this.WM.iterator();
            while (it.hasNext()) {
                it.next().eZ(getVisibility());
            }
            removeCallbacks(this.WZ);
            removeCallbacks(this.Xa);
            this.XA = -9223372036854775807L;
        }
    }

    public boolean mx() {
        return getVisibility() == 0;
    }

    private void nu() {
        removeCallbacks(this.Xa);
        if (this.Xs > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            int i = this.Xs;
            this.XA = jUptimeMillis + ((long) i);
            if (this.Xp) {
                postDelayed(this.Xa, i);
                return;
            }
            return;
        }
        this.XA = -9223372036854775807L;
    }

    private void nv() {
        nw();
        nx();
        ny();
        nz();
        nA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw() {
        boolean z;
        boolean z2;
        boolean z3;
        if (mx() && this.Xp) {
            boolean zNE = nE();
            View view = this.WP;
            boolean z4 = true;
            if (view != null) {
                z = (zNE && view.isFocused()) | false;
                if (ai.acV < 21) {
                    z3 = z;
                } else {
                    z3 = zNE && a.g(this.WP);
                }
                z2 = z3 | false;
                this.WP.setVisibility(zNE ? 8 : 0);
            } else {
                z = false;
                z2 = false;
            }
            View view2 = this.WQ;
            if (view2 != null) {
                z |= !zNE && view2.isFocused();
                if (ai.acV < 21) {
                    z4 = z;
                } else if (zNE || !a.g(this.WQ)) {
                    z4 = false;
                }
                z2 |= z4;
                this.WQ.setVisibility(zNE ? 0 : 8);
            }
            if (z) {
                nC();
            }
            if (z2) {
                nD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nx() {
        boolean z;
        boolean zN;
        boolean z2;
        boolean z3;
        if (mx() && this.Xp) {
            an anVar = this.jb;
            boolean z4 = false;
            if (anVar != null) {
                boolean zN2 = anVar.n(4);
                boolean zN3 = anVar.n(6);
                z3 = anVar.n(10) && this.Xn.aj();
                if (anVar.n(11) && this.Xn.ak()) {
                    z4 = true;
                }
                zN = anVar.n(8);
                z = z4;
                z4 = zN3;
                z2 = zN2;
            } else {
                z = false;
                zN = false;
                z2 = false;
                z3 = false;
            }
            a(this.Xx, z4, this.WN);
            a(this.Xv, z3, this.WS);
            a(this.Xw, z, this.WR);
            a(this.Xy, zN, this.WO);
            k kVar = this.WY;
            if (kVar != null) {
                kVar.setEnabled(z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        ImageView imageView;
        if (mx() && this.Xp && (imageView = this.WT) != null) {
            if (this.Xu == 0) {
                a(false, false, (View) imageView);
                return;
            }
            an anVar = this.jb;
            if (anVar == null) {
                a(true, false, (View) imageView);
                this.WT.setImageDrawable(this.Xb);
                this.WT.setContentDescription(this.Xe);
                return;
            }
            a(true, true, (View) imageView);
            int iAF = anVar.aF();
            if (iAF == 0) {
                this.WT.setImageDrawable(this.Xb);
                this.WT.setContentDescription(this.Xe);
            } else if (iAF == 1) {
                this.WT.setImageDrawable(this.Xc);
                this.WT.setContentDescription(this.Xf);
            } else if (iAF == 2) {
                this.WT.setImageDrawable(this.Xd);
                this.WT.setContentDescription(this.Xg);
            }
            this.WT.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz() {
        ImageView imageView;
        String str;
        if (mx() && this.Xp && (imageView = this.WU) != null) {
            an anVar = this.jb;
            if (!this.Xz) {
                a(false, false, (View) imageView);
                return;
            }
            if (anVar == null) {
                a(true, false, (View) imageView);
                this.WU.setImageDrawable(this.Xi);
                this.WU.setContentDescription(this.Xm);
                return;
            }
            a(true, true, (View) imageView);
            this.WU.setImageDrawable(anVar.aG() ? this.Xh : this.Xi);
            ImageView imageView2 = this.WU;
            if (anVar.aG()) {
                str = this.Xl;
            } else {
                str = this.Xm;
            }
            imageView2.setContentDescription(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dc A[SYNTHETIC] */
    public void nA() {
        long j;
        int i;
        long jDf;
        long[] jArr;
        int length;
        an anVar = this.jb;
        if (anVar == null) {
            return;
        }
        boolean z = true;
        this.Xr = this.Xq && a(anVar.aX(), this.U);
        this.XD = 0L;
        ba baVarAX = anVar.aX();
        if (baVarAX.isEmpty()) {
            j = 0;
            i = 0;
        } else {
            int iAL = anVar.aL();
            boolean z2 = this.Xr;
            int i2 = z2 ? 0 : iAL;
            int iCP = z2 ? baVarAX.cP() - 1 : iAL;
            long j2 = 0;
            i = 0;
            while (i2 <= iCP) {
                if (i2 == iAL) {
                    this.XD = com.applovin.exoplayer2.h.f(j2);
                }
                baVarAX.a(i2, this.U);
                if (this.U.fH == -9223372036854775807L) {
                    com.applovin.exoplayer2.l.a.checkState(this.Xr ^ z);
                    break;
                }
                for (int i3 = this.U.iQ; i3 <= this.U.iR; i3++) {
                    baVarAX.a(i3, this.bI);
                    int iDg = this.bI.dg();
                    for (int iDh = this.bI.dh(); iDh < iDg; iDh++) {
                        long jAl = this.bI.al(iDh);
                        if (jAl != Long.MIN_VALUE) {
                            jDf = jAl + this.bI.df();
                            if (jDf >= 0) {
                                jArr = this.WJ;
                                if (i == jArr.length) {
                                    if (jArr.length == 0) {
                                        length = 1;
                                    } else {
                                        length = jArr.length * 2;
                                    }
                                    this.WJ = Arrays.copyOf(jArr, length);
                                    this.WK = Arrays.copyOf(this.WK, length);
                                }
                                this.WJ[i] = com.applovin.exoplayer2.h.f(j2 + jDf);
                                this.WK[i] = this.bI.an(iDh);
                                i++;
                            }
                        } else if (this.bI.fH != -9223372036854775807L) {
                            jAl = this.bI.fH;
                            jDf = jAl + this.bI.df();
                            if (jDf >= 0) {
                                jArr = this.WJ;
                                if (i == jArr.length) {
                                    if (jArr.length == 0) {
                                        length = 1;
                                    } else {
                                        length = jArr.length * 2;
                                    }
                                    this.WJ = Arrays.copyOf(jArr, length);
                                    this.WK = Arrays.copyOf(this.WK, length);
                                }
                                this.WJ[i] = com.applovin.exoplayer2.h.f(j2 + jDf);
                                this.WK[i] = this.bI.an(iDh);
                                i++;
                            }
                        }
                    }
                }
                j2 += this.U.fH;
                i2++;
                z = true;
            }
            j = j2;
        }
        long jF = com.applovin.exoplayer2.h.f(j);
        TextView textView = this.WW;
        if (textView != null) {
            textView.setText(ai.a(this.Wu, this.Wv, jF));
        }
        k kVar = this.WY;
        if (kVar != null) {
            kVar.setDuration(jF);
            int length2 = this.XB.length;
            int i4 = i + length2;
            long[] jArr2 = this.WJ;
            if (i4 > jArr2.length) {
                this.WJ = Arrays.copyOf(jArr2, i4);
                this.WK = Arrays.copyOf(this.WK, i4);
            }
            System.arraycopy(this.XB, 0, this.WJ, i, length2);
            System.arraycopy(this.XC, 0, this.WK, i, length2);
            this.WY.a(this.WJ, this.WK, i4);
        }
        nB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB() {
        long jAT;
        if (mx() && this.Xp) {
            an anVar = this.jb;
            long jAS = 0;
            if (anVar != null) {
                jAS = this.XD + anVar.aS();
                jAT = this.XD + anVar.aT();
            } else {
                jAT = 0;
            }
            boolean z = jAS != this.XE;
            boolean z2 = jAT != this.XF;
            this.XE = jAS;
            this.XF = jAT;
            TextView textView = this.WX;
            if (textView != null && !this.WG && z) {
                textView.setText(ai.a(this.Wu, this.Wv, jAS));
            }
            k kVar = this.WY;
            if (kVar != null) {
                kVar.setPosition(jAS);
                this.WY.setBufferedPosition(jAT);
            }
            c cVar = this.Xo;
            if (cVar != null && (z || z2)) {
                cVar.z(jAS, jAT);
            }
            removeCallbacks(this.WZ);
            int iAB = anVar == null ? 1 : anVar.aB();
            if (anVar == null || !anVar.v()) {
                if (iAB == 4 || iAB == 1) {
                    return;
                }
                postDelayed(this.WZ, 1000L);
                return;
            }
            k kVar2 = this.WY;
            long jMin = Math.min(kVar2 != null ? kVar2.getPreferredUpdateDelay() : 1000L, 1000 - (jAS % 1000));
            float f = anVar.av().gD;
            postDelayed(this.WZ, ai.b(f > 0.0f ? (long) (jMin / f) : 1000L, this.Xt, 1000L));
        }
    }

    private void nC() {
        View view;
        View view2;
        boolean zNE = nE();
        if (!zNE && (view2 = this.WP) != null) {
            view2.requestFocus();
        } else {
            if (!zNE || (view = this.WQ) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    private void nD() {
        View view;
        View view2;
        boolean zNE = nE();
        if (!zNE && (view2 = this.WP) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!zNE || (view = this.WQ) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    private void a(boolean z, boolean z2, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        view.setAlpha(z2 ? this.Xj : this.Xk);
        view.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(an anVar, long j) {
        int iAL;
        ba baVarAX = anVar.aX();
        if (this.Xr && !baVarAX.isEmpty()) {
            int iCP = baVarAX.cP();
            iAL = 0;
            while (true) {
                long jDl = baVarAX.a(iAL, this.U).dl();
                if (j < jDl) {
                    break;
                }
                if (iAL == iCP - 1) {
                    j = jDl;
                    break;
                } else {
                    j -= jDl;
                    iAL++;
                }
            }
        } else {
            iAL = anVar.aL();
        }
        b(anVar, iAL, j);
        nB();
    }

    private boolean b(an anVar, int i, long j) {
        return this.Xn.a(anVar, i, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Xp = true;
        long j = this.XA;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                nt();
            } else {
                postDelayed(this.Xa, jUptimeMillis);
            }
        } else if (mx()) {
            nu();
        }
        nv();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Xp = false;
        removeCallbacks(this.WZ);
        removeCallbacks(this.Xa);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.Xa);
        } else if (motionEvent.getAction() == 1) {
            nu();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        an anVar = this.jb;
        if (anVar == null || !eY(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (anVar.aB() == 4) {
                return true;
            }
            this.Xn.e(anVar);
            return true;
        }
        if (keyCode == 89) {
            this.Xn.d(anVar);
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            h(anVar);
            return true;
        }
        if (keyCode == 87) {
            this.Xn.c(anVar);
            return true;
        }
        if (keyCode == 88) {
            this.Xn.b(anVar);
            return true;
        }
        if (keyCode == 126) {
            i(anVar);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        j(anVar);
        return true;
    }

    private boolean nE() {
        an anVar = this.jb;
        return (anVar == null || anVar.aB() == 4 || this.jb.aB() == 1 || !this.jb.aE()) ? false : true;
    }

    private void h(an anVar) {
        int iAB = anVar.aB();
        if (iAB == 1 || iAB == 4 || !anVar.aE()) {
            i(anVar);
        } else {
            j(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(an anVar) {
        int iAB = anVar.aB();
        if (iAB == 1) {
            this.Xn.a(anVar);
        } else if (iAB == 4) {
            b(anVar, anVar.aL(), -9223372036854775807L);
        }
        this.Xn.a(anVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(an anVar) {
        this.Xn.a(anVar, false);
    }

    private static boolean a(ba baVar, ba.c cVar) {
        if (baVar.cP() > 100) {
            return false;
        }
        int iCP = baVar.cP();
        for (int i = 0; i < iCP; i++) {
            if (baVar.a(i, cVar).fH == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    private static int a(TypedArray typedArray, int i) {
        return typedArray.getInt(R.styleable.AppLovinPlayerControlView_al_repeat_toggle_modes, i);
    }

    private final class b implements View.OnClickListener, an.d, k.a {
        private b() {
        }

        @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
        public void a(an anVar, an.c cVar) {
            if (cVar.b(4, 5)) {
                f.this.nw();
            }
            if (cVar.b(4, 5, 7)) {
                f.this.nB();
            }
            if (cVar.X(8)) {
                f.this.ny();
            }
            if (cVar.X(9)) {
                f.this.nz();
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                f.this.nx();
            }
            if (cVar.b(11, 0)) {
                f.this.nA();
            }
        }

        @Override // com.applovin.exoplayer2.ui.k.a
        public void a(k kVar, long j) {
            f.this.WG = true;
            if (f.this.WX != null) {
                f.this.WX.setText(ai.a(f.this.Wu, f.this.Wv, j));
            }
        }

        @Override // com.applovin.exoplayer2.ui.k.a
        public void b(k kVar, long j) {
            if (f.this.WX != null) {
                f.this.WX.setText(ai.a(f.this.Wu, f.this.Wv, j));
            }
        }

        @Override // com.applovin.exoplayer2.ui.k.a
        public void a(k kVar, long j, boolean z) {
            f.this.WG = false;
            if (z || f.this.jb == null) {
                return;
            }
            f fVar = f.this;
            fVar.b(fVar.jb, j);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            an anVar = f.this.jb;
            if (anVar == null) {
                return;
            }
            if (f.this.WO == view) {
                f.this.Xn.c(anVar);
                return;
            }
            if (f.this.WN == view) {
                f.this.Xn.b(anVar);
                return;
            }
            if (f.this.WR != view) {
                if (f.this.WS == view) {
                    f.this.Xn.d(anVar);
                    return;
                }
                if (f.this.WP == view) {
                    f.this.i(anVar);
                    return;
                }
                if (f.this.WQ == view) {
                    f.this.j(anVar);
                    return;
                } else {
                    if (f.this.WT != view) {
                        if (f.this.WU == view) {
                            f.this.Xn.b(anVar, !anVar.aG());
                            return;
                        }
                        return;
                    }
                    f.this.Xn.a(anVar, ab.L(anVar.aF(), f.this.Xu));
                    return;
                }
            }
            if (anVar.aB() != 4) {
                f.this.Xn.e(anVar);
            }
        }
    }

    private static final class a {
        public static boolean g(View view) {
            return view.isAccessibilityFocused();
        }
    }
}
