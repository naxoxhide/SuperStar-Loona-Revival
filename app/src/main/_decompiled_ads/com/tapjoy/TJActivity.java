package com.tapjoy;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tapjoy.internal.p7;
import com.tapjoy.internal.q7;
import com.tapjoy.internal.t1;
import com.tapjoy.internal.v1;

/* JADX INFO: loaded from: classes4.dex */
public class TJActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RelativeLayout.LayoutParams f2682b;
    public TJCloseButton c;
    public ProgressBar d;
    public RelativeLayout a = null;
    public boolean e = false;

    public static /* synthetic */ WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }

    public void a() {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 29) {
            ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), new OnApplyWindowInsetsListener() { // from class: com.tapjoy.-$$Lambda$PqC46XVWxt9YeQ8Ku9hA90Kz6eU
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return TJActivity.a(view, windowInsetsCompat);
                }
            });
        }
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(16777216, 16777216);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f2682b = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.a = relativeLayout;
        relativeLayout.setLayoutParams(this.f2682b);
        this.a.setBackgroundColor(0);
        this.d = new ProgressBar(this, null, R.attr.progressBarStyleLarge);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.d.setLayoutParams(layoutParams);
        TJCloseButton tJCloseButton = new TJCloseButton(this);
        this.c = tJCloseButton;
        tJCloseButton.setOnClickListener(this);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (v1.m.j) {
            this.e = true;
            t1.a(this);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        if (this.e) {
            this.e = false;
            t1.b(this);
        }
        super.onStop();
    }

    public void setCloseButtonClickable(boolean z) {
        this.c.setClickableRequested(z);
    }

    public void setCloseButtonVisibility(boolean z) {
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(4);
        }
    }

    public void setProgressSpinnerVisibility(boolean z) {
        TapjoyUtil.runOnMainThread(new p7(this, z));
    }

    public void showErrorDialog() {
        if (isFinishing()) {
            return;
        }
        new AlertDialog.Builder(this, R.style.Theme.Material.Light.Dialog.Alert).setMessage("An error occurred. Please try again later.").setPositiveButton("OK", new q7(this)).create().show();
    }
}
