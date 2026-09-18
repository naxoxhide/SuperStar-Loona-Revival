package com.bytedance.sdk.openadsdk.api.init;

import android.os.Build;
import android.text.TextUtils;
import b.a.a.a.a.a.a.i.c;
import b.b.a.a.j.f.b;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.utils.a0;

/* JADX INFO: loaded from: classes2.dex */
public final class PAGConfig implements InitConfig {
    private static String l;
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f428b;
    private int c;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g = 0;
    private boolean h;
    private boolean i;
    private String j;
    private String k;

    public static class Builder {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f429b;
        private int c;
        private int d = -1;
        private int e = -1;
        private int f = -1;
        private int g = 0;
        private boolean h;
        private boolean i;
        private String j;
        private String k;

        public Builder() {
            this.h = Build.VERSION.SDK_INT >= 14;
            this.i = false;
        }

        public Builder appIcon(int i) {
            this.c = i;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public PAGConfig build() {
            PAGConfig pAGConfig = new PAGConfig();
            pAGConfig.b(this.a);
            pAGConfig.c(this.d);
            pAGConfig.a(this.c);
            pAGConfig.e(this.g);
            pAGConfig.c(this.h);
            pAGConfig.b(this.i);
            pAGConfig.d(this.e);
            pAGConfig.b(this.f);
            pAGConfig.a(this.f429b);
            pAGConfig.a(this.j);
            pAGConfig.c(this.k);
            return pAGConfig;
        }

        public Builder debugLog(boolean z) {
            this.f429b = z;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            return this;
        }

        public Builder setChildDirected(int i) {
            this.d = i;
            return this;
        }

        public Builder setDoNotSell(int i) {
            this.f = i;
            return this;
        }

        public Builder setGDPRConsent(int i) {
            this.e = i;
            return this;
        }

        public Builder setPackageName(String str) {
            this.j = str;
            return this;
        }

        public Builder setUserData(String str) {
            this.k = str;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.i = z;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.g = i;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.h = z;
            return this;
        }
    }

    public static void debugLog(boolean z) {
        if (v.a() != null) {
            if (z) {
                v.a().b(1);
                v.a().a();
                c.c();
            } else {
                v.a().b(0);
                b.a(b.EnumC0046b.OFF);
                m.a();
                c.a();
            }
        }
    }

    public static int getChildDirected() {
        a0.d("getCoppa");
        return v.a().getCoppa();
    }

    public static int getDoNotSell() {
        a0.d("getCCPA");
        return h.a().e();
    }

    public static int getGDPRConsent() {
        a0.d("getGdpr");
        int gdpr = v.a().getGdpr();
        if (gdpr == 1) {
            return 0;
        }
        if (gdpr == 0) {
            return 1;
        }
        return gdpr;
    }

    public static void setAppIconId(int i) {
        if (v.a() != null) {
            v.a().d(i);
        }
    }

    public static void setChildDirected(int i) {
        a0.d("setCoppa");
        if (i < -1 || i > 1) {
            i = -1;
        }
        if (i == getChildDirected()) {
            return;
        }
        v.a().a(i);
    }

    public static void setDoNotSell(int i) {
        a0.d("setCCPA");
        if (i < -1 || i > 1) {
            i = -1;
        }
        if (i == getDoNotSell()) {
            return;
        }
        h.a().a(i);
    }

    public static void setGDPRConsent(int i) {
        a0.d("setGdpr");
        int i2 = -1;
        int i3 = 1;
        if (i >= -1 && i <= 1) {
            i2 = i;
        }
        if (i2 == getGDPRConsent()) {
            return;
        }
        if (i == 1) {
            i3 = 0;
        } else if (i != 0) {
            i3 = i2;
        }
        v.a().c(i3);
    }

    public static void setPackageName(String str) {
        l = str;
    }

    public static void setUserData(String str) {
        if (v.a() != null) {
            v.a().a(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getAppIconId() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getAppId() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getCcpa() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getCoppa() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getData() {
        return this.k;
    }

    public boolean getDebugLog() {
        return this.f428b;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getGdpr() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getPackageName() {
        return TextUtils.isEmpty(this.j) ? l : this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getTitleBarTheme() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isSupportMultiProcess() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isUseTextureView() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i < -1 || i > 1) {
            i = -1;
        }
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f428b = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.k = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i < -1 || i > 1) {
            i = -1;
        }
        this.f = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (i < -1 || i > 1) {
            i = -1;
        }
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.j = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.i = z;
        b.a.a.a.a.a.a.c.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        this.h = z;
    }
}
