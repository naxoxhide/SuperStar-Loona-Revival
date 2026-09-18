package com.igaworks.adpopcorn.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import com.igaworks.adpopcorn.a.d;
import com.igaworks.adpopcorn.activity.layout.ApOfferWallLayout;
import com.igaworks.adpopcorn.activity.layout.f.b;
import com.igaworks.adpopcorn.cores.common.h;
import com.igaworks.adpopcorn.style.APOfferwallTabInfo;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.igaworks.adpopcorn.style.a;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ApOfferWallActivity_NT extends Activity {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f1500b;
    private boolean c;
    private boolean d;
    private ApOfferWallLayout e;
    private int f;
    private APOfferwallTabInfo g;
    private List<String> h;
    private b i;
    private com.igaworks.adpopcorn.activity.layout.g.b j;
    private com.igaworks.adpopcorn.activity.layout.e.b k;
    private String l;
    private String m;
    private int n;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.n != 1) {
                this.e.onActivityResult(i, i2, intent);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        try {
            d dVar = this.f1500b;
            if (dVar != null) {
                if (this.n == 1) {
                    dVar.c(this.l);
                } else {
                    dVar.c((String) null);
                }
            }
            overridePendingTransition(0, 0);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            if (this.n == 1) {
                if (this.i != null) {
                    this.d = this.f1500b.c((Activity) this);
                    h.a(this.a, "ApOfferWallActivity_NT", "onConfigurationChanged landscapeMode : " + this.d, 3);
                    this.i.setApOfferWallOrientation(this.d);
                    this.i.a(configuration);
                }
            } else if (this.e != null) {
                this.d = this.f1500b.c((Activity) this);
                h.a(this.a, "ApOfferWallActivity_NT", "onConfigurationChanged landscapeMode : " + this.d, 3);
                this.e.setApOfferWallOrientation(this.d);
                this.e.onCustomConfigurationChanged(configuration);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = false;
        this.a = this;
        if (bundle != null) {
            try {
                this.c = bundle.getBoolean("app_restart", false);
                h.a(this.a, "ApOfferWallActivity_NT", "savedInstanceState >> app_restart : " + this.c, 3);
            } catch (Exception unused) {
                h.a(this.a, "ApOfferWallActivity_NT", "onCreate Exception", 3);
                return;
            }
        }
        if (!this.c) {
            Intent intent = getIntent();
            this.f = intent.getIntExtra("offerwallType", 0);
            this.g = (APOfferwallTabInfo) intent.getSerializableExtra("offerwallTabInfo");
            getWindow().getDecorView().setBackgroundColor(0);
            int i = Build.VERSION.SDK_INT;
            if (i >= 11) {
                getWindow().setFlags(16777216, 16777216);
            }
            int iC = a.b().c(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE);
            this.n = iC;
            if (iC == 1) {
                this.h = intent.getStringArrayListExtra("offerwallFilterCampaignList");
                this.l = intent.getStringExtra("offerwallAppKey");
                this.m = intent.getStringExtra("offerwallHashKey");
                this.f1500b = d.a(this.a);
                d.b((Activity) this);
                if (intent.getIntExtra("offerwallOrientation", 1) == 2) {
                    this.d = true;
                    if (i >= 9) {
                        setRequestedOrientation(6);
                    } else {
                        setRequestedOrientation(0);
                    }
                } else {
                    this.d = false;
                    setRequestedOrientation(1);
                }
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                if (i >= 23) {
                    window.setStatusBarColor(Color.parseColor("#ffffff"));
                    getWindow().getDecorView().setSystemUiVisibility(8192);
                }
                if (this.d) {
                    this.f = 0;
                }
                b bVar = new b(this.a);
                this.i = bVar;
                bVar.setApOfferWallOrientation(this.d);
                this.i.setTabOfferwallInfo(this.g);
                this.i.setOfferwallType(this.f);
                this.i.b(this.l, this.m);
                this.i.setOfferwallActivity(this);
                this.i.setFilterCampaignKeyList(this.h);
                setContentView(this.i);
                this.i.setCustomViewMode(false);
                this.i.a(false, false);
            } else if (iC == 2) {
                this.f1500b = d.a(this.a);
                d.b((Activity) this);
                if (intent.getIntExtra("offerwallOrientation", 1) == 2) {
                    this.d = true;
                    if (i >= 9) {
                        setRequestedOrientation(6);
                    } else {
                        setRequestedOrientation(0);
                    }
                } else {
                    this.d = false;
                    setRequestedOrientation(1);
                }
                Window window2 = getWindow();
                window2.addFlags(Integer.MIN_VALUE);
                if (i >= 23) {
                    window2.setStatusBarColor(Color.parseColor("#ffffff"));
                    getWindow().getDecorView().setSystemUiVisibility(8192);
                }
                if (this.d) {
                    this.f = 0;
                }
                com.igaworks.adpopcorn.activity.layout.g.b bVar2 = new com.igaworks.adpopcorn.activity.layout.g.b(this.a);
                this.j = bVar2;
                bVar2.setApOfferWallOrientation(this.d);
                this.j.setTabOfferwallInfo(this.g);
                this.j.setOfferwallType(this.f);
                this.j.setOfferwallActivity(this);
                setContentView(this.j);
                this.j.o();
            } else if (iC == 3) {
                this.f1500b = d.a(this.a);
                d.b((Activity) this);
                if (intent.getIntExtra("offerwallOrientation", 1) == 2) {
                    this.d = true;
                    if (i >= 9) {
                        setRequestedOrientation(6);
                    } else {
                        setRequestedOrientation(0);
                    }
                } else {
                    this.d = false;
                    setRequestedOrientation(1);
                }
                Window window3 = getWindow();
                window3.addFlags(Integer.MIN_VALUE);
                if (i >= 23) {
                    window3.setStatusBarColor(Color.parseColor("#ffffff"));
                    getWindow().getDecorView().setSystemUiVisibility(8192);
                }
                if (this.d) {
                    this.f = 0;
                }
                com.igaworks.adpopcorn.activity.layout.e.b bVar3 = new com.igaworks.adpopcorn.activity.layout.e.b(this.a);
                this.k = bVar3;
                bVar3.setApOfferWallOrientation(this.d);
                this.k.setTabOfferwallInfo(this.g);
                this.k.setOfferwallType(this.f);
                this.k.setOfferwallActivity(this);
                setContentView(this.k);
                this.k.a(false, false);
            } else {
                this.f1500b = d.a(this.a);
                d.b((Activity) this);
                this.d = this.f1500b.c((Activity) this);
                ApOfferWallLayout apOfferWallLayout = new ApOfferWallLayout(this.a);
                this.e = apOfferWallLayout;
                apOfferWallLayout.setApOfferWallOrientation(this.d);
                if (!this.d) {
                    this.e.setTabOfferwallInfo(this.g);
                }
                this.e.setOfferwallType(this.f);
                this.e.setOfferwallActivity(this);
                this.e.setFilterCampaignKeyList(this.h);
                setContentView(this.e);
                this.e.setCustomViewMode(false);
                this.e.initOfferwallLayout(false, false);
            }
        }
        if (com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
            getWindow().addFlags(524288);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d dVar;
        super.onDestroy();
        try {
            if (!this.c && (dVar = this.f1500b) != null) {
                dVar.c(false);
            }
            int i = this.n;
            if (i == 1) {
                b bVar = this.i;
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            if (i == 2) {
                com.igaworks.adpopcorn.activity.layout.g.b bVar2 = this.j;
                if (bVar2 != null) {
                    bVar2.g();
                    return;
                }
                return;
            }
            if (i == 3) {
                com.igaworks.adpopcorn.activity.layout.e.b bVar3 = this.k;
                if (bVar3 != null) {
                    bVar3.g();
                    return;
                }
                return;
            }
            ApOfferWallLayout apOfferWallLayout = this.e;
            if (apOfferWallLayout != null) {
                apOfferWallLayout.destroy();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            this.f1500b.d();
            int i = this.n;
            if (i != 1) {
                if (i == 2) {
                    com.igaworks.adpopcorn.activity.layout.g.b bVar = this.j;
                    if (bVar != null) {
                        bVar.t();
                    }
                } else if (i == 3) {
                    com.igaworks.adpopcorn.activity.layout.e.b bVar2 = this.k;
                    if (bVar2 != null) {
                        bVar2.s();
                    }
                } else {
                    this.e.pause();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        try {
            if (this.n != 1) {
                this.e.onRequestPermissionsResult(i, strArr, iArr);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (this.c) {
                finish();
                return;
            }
            int i = this.n;
            if (i == 1) {
                this.i.a(this.l, this.m);
                return;
            }
            if (i == 2) {
                this.j.u();
            } else if (i == 3) {
                this.k.t();
            } else {
                this.e.resume(false);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        try {
            bundle.putBoolean("app_restart", true);
        } catch (Exception unused) {
        }
    }
}
