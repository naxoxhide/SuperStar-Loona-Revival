package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.ak;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.m.o;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g extends FrameLayout {
    private final a XH;
    private final AspectRatioFrameLayout XI;
    private final View XJ;
    private final View XK;
    private final boolean XL;
    private final ImageView XM;
    private final SubtitleView XN;
    private final View XO;
    private final TextView XP;
    private final f XQ;
    private final FrameLayout XR;
    private final FrameLayout XS;
    private boolean XT;
    private f.d XU;
    private boolean XV;
    private Drawable XW;
    private int XX;
    private boolean XY;
    private com.applovin.exoplayer2.l.k<? super ak> XZ;
    private CharSequence Ya;
    private int Yb;
    private boolean Yc;
    private boolean Yd;
    private boolean Ye;
    private int Yf;
    private boolean Yg;
    private an jb;

    private boolean fa(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Context context, AttributeSet attributeSet, int i) {
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int integer;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        boolean z6;
        boolean z7;
        boolean z8;
        int i7;
        boolean z9;
        super(context, attributeSet, i);
        a aVar = new a();
        this.XH = aVar;
        if (isInEditMode()) {
            this.XI = null;
            this.XJ = null;
            this.XK = null;
            this.XL = false;
            this.XM = null;
            this.XN = null;
            this.XO = null;
            this.XP = null;
            this.XQ = null;
            this.XR = null;
            this.XS = null;
            ImageView imageView = new ImageView(context);
            if (ai.acV >= 23) {
                a(getResources(), imageView);
            } else {
                b(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i8 = R.layout.applovin_exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AppLovinPlayerView, i, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppLovinPlayerView_al_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(R.styleable.AppLovinPlayerView_al_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerView_al_player_layout_id, i8);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerView_al_default_artwork, 0);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_use_controller, true);
                int i9 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_surface_type, 1);
                int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_resize_mode, 0);
                int i11 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_show_timeout, 5000);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_hide_on_touch, true);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.AppLovinPlayerView_al_show_buffering, 0);
                this.XY = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_keep_content_on_player_reset, this.XY);
                boolean z14 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                z3 = z12;
                z = z13;
                i3 = i10;
                z6 = z11;
                i6 = resourceId2;
                z5 = z10;
                i5 = color;
                z4 = zHasValue;
                i4 = i9;
                i8 = resourceId;
                i2 = i11;
                z2 = z14;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i2 = 5000;
            z = true;
            i3 = 0;
            z2 = true;
            integer = 0;
            z3 = true;
            i4 = 1;
            z4 = false;
            i5 = 0;
            z5 = true;
            i6 = 0;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i8, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.al_exo_content_frame);
        this.XI = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            a(aspectRatioFrameLayout, i3);
        }
        View viewFindViewById = findViewById(R.id.al_exo_shutter);
        this.XJ = viewFindViewById;
        if (viewFindViewById != null && z4) {
            viewFindViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i4 == 2) {
                z7 = true;
                this.XK = new TextureView(context);
            } else {
                if (i4 != 3) {
                    if (i4 == 4) {
                        try {
                            this.XK = (View) Class.forName("com.applovin.exoplayer2.m.i").getConstructor(Context.class).newInstance(context);
                        } catch (Exception e) {
                            throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e);
                        }
                    } else {
                        this.XK = new SurfaceView(context);
                    }
                    z7 = true;
                } else {
                    try {
                        z7 = true;
                        this.XK = (View) Class.forName("com.applovin.exoplayer2.m.a.i").getConstructor(Context.class).newInstance(context);
                        z9 = true;
                    } catch (Exception e2) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e2);
                    }
                }
                this.XK.setLayoutParams(layoutParams);
                this.XK.setOnClickListener(aVar);
                this.XK.setClickable(false);
                aspectRatioFrameLayout.addView(this.XK, 0);
                z8 = z9;
            }
            z9 = false;
            this.XK.setLayoutParams(layoutParams);
            this.XK.setOnClickListener(aVar);
            this.XK.setClickable(false);
            aspectRatioFrameLayout.addView(this.XK, 0);
            z8 = z9;
        } else {
            z7 = true;
            this.XK = null;
            z8 = false;
        }
        this.XL = z8;
        this.XR = (FrameLayout) findViewById(R.id.al_exo_ad_overlay);
        this.XS = (FrameLayout) findViewById(R.id.al_exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.al_exo_artwork);
        this.XM = imageView2;
        this.XV = (!z5 || imageView2 == null) ? false : z7;
        if (i6 != 0) {
            this.XW = ContextCompat.getDrawable(getContext(), i6);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.al_exo_subtitles);
        this.XN = subtitleView;
        if (subtitleView != null) {
            subtitleView.nX();
            subtitleView.nW();
        }
        View viewFindViewById2 = findViewById(R.id.al_exo_buffering);
        this.XO = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.XX = integer;
        TextView textView = (TextView) findViewById(R.id.al_exo_error_message);
        this.XP = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        f fVar = (f) findViewById(R.id.al_exo_controller);
        View viewFindViewById3 = findViewById(R.id.al_exo_controller_placeholder);
        if (fVar != null) {
            this.XQ = fVar;
            i7 = 0;
        } else if (viewFindViewById3 != null) {
            i7 = 0;
            f fVar2 = new f(context, null, 0, attributeSet);
            this.XQ = fVar2;
            fVar2.setId(R.id.al_exo_controller);
            fVar2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(fVar2, iIndexOfChild);
        } else {
            i7 = 0;
            this.XQ = null;
        }
        f fVar3 = this.XQ;
        this.Yb = fVar3 != null ? i2 : i7;
        this.Ye = z3;
        this.Yc = z;
        this.Yd = z2;
        this.XT = (!z6 || fVar3 == null) ? i7 : z7;
        nG();
        nQ();
        f fVar4 = this.XQ;
        if (fVar4 != null) {
            fVar4.a(aVar);
        }
    }

    public an getPlayer() {
        return this.jb;
    }

    public void setPlayer(an anVar) {
        com.applovin.exoplayer2.l.a.checkState(Looper.myLooper() == Looper.getMainLooper());
        com.applovin.exoplayer2.l.a.checkArgument(anVar == null || anVar.az() == Looper.getMainLooper());
        an anVar2 = this.jb;
        if (anVar2 == anVar) {
            return;
        }
        if (anVar2 != null) {
            anVar2.b(this.XH);
            if (anVar2.n(26)) {
                View view = this.XK;
                if (view instanceof TextureView) {
                    anVar2.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    anVar2.b((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.XN;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.jb = anVar;
        if (nH()) {
            this.XQ.setPlayer(anVar);
        }
        nO();
        nP();
        aq(true);
        if (anVar != null) {
            if (anVar.n(26)) {
                View view2 = this.XK;
                if (view2 instanceof TextureView) {
                    anVar.a((TextureView) view2);
                } else if (view2 instanceof SurfaceView) {
                    anVar.a((SurfaceView) view2);
                }
                nL();
            }
            if (this.XN != null && anVar.n(27)) {
                this.XN.setCues(anVar.bd());
            }
            anVar.a(this.XH);
            ao(false);
            return;
        }
        nG();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.XK;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        com.applovin.exoplayer2.l.a.N(this.XI);
        this.XI.setResizeMode(i);
    }

    public int getResizeMode() {
        com.applovin.exoplayer2.l.a.N(this.XI);
        return this.XI.getResizeMode();
    }

    public boolean getUseArtwork() {
        return this.XV;
    }

    public void setUseArtwork(boolean z) {
        com.applovin.exoplayer2.l.a.checkState((z && this.XM == null) ? false : true);
        if (this.XV != z) {
            this.XV = z;
            aq(false);
        }
    }

    public Drawable getDefaultArtwork() {
        return this.XW;
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.XW != drawable) {
            this.XW = drawable;
            aq(false);
        }
    }

    public boolean getUseController() {
        return this.XT;
    }

    public void setUseController(boolean z) {
        com.applovin.exoplayer2.l.a.checkState((z && this.XQ == null) ? false : true);
        if (this.XT == z) {
            return;
        }
        this.XT = z;
        if (nH()) {
            this.XQ.setPlayer(this.jb);
        } else {
            f fVar = this.XQ;
            if (fVar != null) {
                fVar.nt();
                this.XQ.setPlayer(null);
            }
        }
        nQ();
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.XJ;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.XY != z) {
            this.XY = z;
            aq(false);
        }
    }

    public void setShowBuffering(int i) {
        if (this.XX != i) {
            this.XX = i;
            nO();
        }
    }

    public void setErrorMessageProvider(com.applovin.exoplayer2.l.k<? super ak> kVar) {
        if (this.XZ != kVar) {
            this.XZ = kVar;
            nP();
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        com.applovin.exoplayer2.l.a.checkState(this.XP != null);
        this.Ya = charSequence;
        nP();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        an anVar = this.jb;
        if (anVar != null && anVar.aP()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zFa = fa(keyEvent.getKeyCode());
        if ((zFa && nH() && !this.XQ.mx()) || a(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            ao(true);
            return true;
        }
        if (!zFa || !nH()) {
            return false;
        }
        ao(true);
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        return nH() && this.XQ.a(keyEvent);
    }

    public void nF() {
        ap(nK());
    }

    public void nG() {
        f fVar = this.XQ;
        if (fVar != null) {
            fVar.nt();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.Yb;
    }

    public void setControllerShowTimeoutMs(int i) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.Yb = i;
        if (this.XQ.mx()) {
            nF();
        }
    }

    public boolean getControllerHideOnTouch() {
        return this.Ye;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.Ye = z;
        nQ();
    }

    public boolean getControllerAutoShow() {
        return this.Yc;
    }

    public void setControllerAutoShow(boolean z) {
        this.Yc = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.Yd = z;
    }

    public void setControllerVisibilityListener(f.d dVar) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        f.d dVar2 = this.XU;
        if (dVar2 == dVar) {
            return;
        }
        if (dVar2 != null) {
            this.XQ.b(dVar2);
        }
        this.XU = dVar;
        if (dVar != null) {
            this.XQ.a(dVar);
        }
    }

    @Deprecated
    public void setControlDispatcher(com.applovin.exoplayer2.i iVar) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setControlDispatcher(iVar);
    }

    public void setShowRewindButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowRewindButton(z);
    }

    public void setShowFastForwardButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowFastForwardButton(z);
    }

    public void setShowPreviousButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowPreviousButton(z);
    }

    public void setShowNextButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowNextButton(z);
    }

    public void setRepeatToggleModes(int i) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.applovin.exoplayer2.l.a.N(this.XQ);
        this.XQ.setShowMultiWindowTimeBar(z);
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.a aVar) {
        com.applovin.exoplayer2.l.a.N(this.XI);
        this.XI.setAspectRatioListener(aVar);
    }

    public View getVideoSurfaceView() {
        return this.XK;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.XS;
    }

    public SubtitleView getSubtitleView() {
        return this.XN;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!nH() || this.jb == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Yg = true;
            return true;
        }
        if (action != 1 || !this.Yg) {
            return false;
        }
        this.Yg = false;
        performClick();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return nJ();
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!nH() || this.jb == null) {
            return false;
        }
        ao(true);
        return true;
    }

    protected void a(AspectRatioFrameLayout aspectRatioFrameLayout, float f) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f);
        }
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) com.applovin.exoplayer2.l.a.q(this.XR, "exo_ad_overlay must be present for ad playback");
    }

    public List<com.applovin.exoplayer2.ui.a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        if (this.XS != null) {
            arrayList.add(new com.applovin.exoplayer2.ui.a(this.XS, 3, "Transparent overlay does not impact viewability"));
        }
        if (this.XQ != null) {
            arrayList.add(new com.applovin.exoplayer2.ui.a(this.XQ, 0));
        }
        return s.d(arrayList);
    }

    private boolean nH() {
        if (!this.XT) {
            return false;
        }
        com.applovin.exoplayer2.l.a.N(this.XQ);
        return true;
    }

    private boolean nI() {
        if (!this.XV) {
            return false;
        }
        com.applovin.exoplayer2.l.a.N(this.XM);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nJ() {
        if (!nH() || this.jb == null) {
            return false;
        }
        if (!this.XQ.mx()) {
            ao(true);
        } else if (this.Ye) {
            this.XQ.nt();
        }
        return true;
    }

    private void ao(boolean z) {
        if (!(aP() && this.Yd) && nH()) {
            boolean z2 = this.XQ.mx() && this.XQ.getShowTimeoutMs() <= 0;
            boolean zNK = nK();
            if (z || z2 || zNK) {
                ap(zNK);
            }
        }
    }

    private boolean nK() {
        an anVar = this.jb;
        if (anVar == null) {
            return true;
        }
        int iAB = anVar.aB();
        return this.Yc && (iAB == 1 || iAB == 4 || !this.jb.aE());
    }

    private void ap(boolean z) {
        if (nH()) {
            this.XQ.setShowTimeoutMs(z ? 0 : this.Yb);
            this.XQ.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aP() {
        an anVar = this.jb;
        return anVar != null && anVar.aP() && this.jb.aE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(boolean z) {
        an anVar = this.jb;
        if (anVar == null || anVar.aU().isEmpty()) {
            if (this.XY) {
                return;
            }
            nM();
            nN();
            return;
        }
        if (z && !this.XY) {
            nN();
        }
        com.applovin.exoplayer2.j.h hVarAV = anVar.aV();
        for (int i = 0; i < hVarAV.fR; i++) {
            com.applovin.exoplayer2.j.g gVarEU = hVarAV.eU(i);
            if (gVarEU != null) {
                for (int i2 = 0; i2 < gVarEU.kD(); i2++) {
                    if (u.ba(gVarEU.dZ(i2).dz) == 2) {
                        nM();
                        return;
                    }
                }
            }
        }
        nN();
        if (nI() && (b(anVar.aW()) || b(this.XW))) {
            return;
        }
        nM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nL() {
        an anVar = this.jb;
        o oVarAY = anVar != null ? anVar.aY() : o.afk;
        int i = oVarAY.dE;
        int i2 = oVarAY.height;
        int i3 = oVarAY.afl;
        float f = (i2 == 0 || i == 0) ? 0.0f : (i * oVarAY.dH) / i2;
        View view = this.XK;
        if (view instanceof TextureView) {
            if (f > 0.0f && (i3 == 90 || i3 == 270)) {
                f = 1.0f / f;
            }
            if (this.Yf != 0) {
                view.removeOnLayoutChangeListener(this.XH);
            }
            this.Yf = i3;
            if (i3 != 0) {
                this.XK.addOnLayoutChangeListener(this.XH);
            }
            a((TextureView) this.XK, this.Yf);
        }
        a(this.XI, this.XL ? 0.0f : f);
    }

    private boolean b(ac acVar) {
        if (acVar.eX == null) {
            return false;
        }
        return b(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(acVar.eX, 0, acVar.eX.length)));
    }

    private boolean b(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                a(this.XI, intrinsicWidth / intrinsicHeight);
                this.XM.setImageDrawable(drawable);
                this.XM.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private void nM() {
        ImageView imageView = this.XM;
        if (imageView != null) {
            imageView.setImageResource(android.R.color.transparent);
            this.XM.setVisibility(4);
        }
    }

    private void nN() {
        View view = this.XJ;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nO() {
        int i;
        if (this.XO != null) {
            an anVar = this.jb;
            boolean z = true;
            if (anVar == null || anVar.aB() != 2 || ((i = this.XX) != 2 && (i != 1 || !this.jb.aE()))) {
                z = false;
            }
            this.XO.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP() {
        com.applovin.exoplayer2.l.k<? super ak> kVar;
        TextView textView = this.XP;
        if (textView != null) {
            CharSequence charSequence = this.Ya;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.XP.setVisibility(0);
                return;
            }
            an anVar = this.jb;
            ak akVarAx = anVar != null ? anVar.ax() : null;
            if (akVarAx != null && (kVar = this.XZ) != null) {
                this.XP.setText((CharSequence) kVar.k(akVarAx).second);
                this.XP.setVisibility(0);
            } else {
                this.XP.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ() {
        f fVar = this.XQ;
        if (fVar == null || !this.XT) {
            setContentDescription(null);
        } else if (fVar.getVisibility() == 0) {
            setContentDescription(this.Ye ? getResources().getString(R.string.al_exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R.string.al_exo_controls_show));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nR() {
        if (aP() && this.Yd) {
            nG();
        } else {
            ao(false);
        }
    }

    private static void a(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.applovin_exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(R.color.al_exo_edit_mode_background_color, null));
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.applovin_exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R.color.al_exo_edit_mode_background_color));
    }

    private static void a(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i != 0) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate(i, f, f2);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    private final class a implements View.OnClickListener, View.OnLayoutChangeListener, an.d, f.d {
        private Object Yh;
        private final ba.a bI = new ba.a();

        public a() {
        }

        @Override // com.applovin.exoplayer2.an.d
        public void e(List<com.applovin.exoplayer2.i.a> list) {
            if (g.this.XN != null) {
                g.this.XN.setCues(list);
            }
        }

        @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.m.n
        public void a(o oVar) {
            g.this.nL();
        }

        @Override // com.applovin.exoplayer2.an.d
        public void cE() {
            if (g.this.XJ != null) {
                g.this.XJ.setVisibility(4);
            }
        }

        @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
        public void a(ad adVar, com.applovin.exoplayer2.j.h hVar) {
            an anVar = (an) com.applovin.exoplayer2.l.a.checkNotNull(g.this.jb);
            ba baVarAX = anVar.aX();
            if (baVarAX.isEmpty()) {
                this.Yh = null;
            } else if (!anVar.aU().isEmpty()) {
                this.Yh = baVarAX.a(anVar.aK(), this.bI, true).ch;
            } else {
                Object obj = this.Yh;
                if (obj != null) {
                    int iC = baVarAX.c(obj);
                    if (iC != -1) {
                        if (anVar.aL() == baVarAX.a(iC, this.bI).cN) {
                            return;
                        }
                    }
                    this.Yh = null;
                }
            }
            g.this.aq(false);
        }

        @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
        public void Z(int i) {
            g.this.nO();
            g.this.nP();
            g.this.nR();
        }

        @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
        public void e(boolean z, int i) {
            g.this.nO();
            g.this.nR();
        }

        @Override // com.applovin.exoplayer2.an.d, com.applovin.exoplayer2.an.b
        public void a(an.e eVar, an.e eVar2, int i) {
            if (g.this.aP() && g.this.Yd) {
                g.this.nG();
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            g.a((TextureView) view, g.this.Yf);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.nJ();
        }

        @Override // com.applovin.exoplayer2.ui.f.d
        public void eZ(int i) {
            g.this.nQ();
        }
    }
}
