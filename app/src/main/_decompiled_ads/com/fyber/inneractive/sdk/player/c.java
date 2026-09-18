package com.fyber.inneractive.sdk.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.config.global.features.n;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.response.i;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements com.fyber.inneractive.sdk.player.controller.g.f, com.fyber.inneractive.sdk.player.controller.g.e {
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.controller.g f1002b;
    public String c;
    public final s d;
    public f0 e;
    public InneractiveAdRequest f;
    public com.fyber.inneractive.sdk.measurement.a g;
    public com.fyber.inneractive.sdk.measurement.d h;
    public Bitmap k;
    public o l;
    public o.a m;
    public g r;
    public int s;
    public com.fyber.inneractive.sdk.model.vast.o t;
    public f i = null;
    public boolean j = true;
    public boolean n = false;
    public volatile boolean o = false;
    public boolean p = false;
    public int q = 0;
    public com.fyber.inneractive.sdk.player.controller.g.d u = new a();

    public class a implements com.fyber.inneractive.sdk.player.controller.g.d {
        public a() {
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.fyber.inneractive.sdk.player.enums.b.values().length];
            a = iArr;
            try {
                iArr[com.fyber.inneractive.sdk.player.enums.b.Prepared.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Buffering.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Playing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Paused.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.fyber.inneractive.sdk.player.enums.b.Completed.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.c$c, reason: collision with other inner class name */
    public interface InterfaceC0276c {
        void a(c cVar);
    }

    public class d extends Exception {
    }

    public c(Context context, Set<Vendor> set, s sVar) {
        this.a = context;
        this.d = sVar;
        a();
    }

    public void a(Bitmap bitmap) {
        IAlog.a("IAMediaPlayerFlowManager: saving snapshot %s", bitmap);
        this.k = null;
        this.k = bitmap;
    }

    public abstract void a(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject);

    public abstract void a(i iVar, VideoClickOrigin videoClickOrigin, t... tVarArr);

    public abstract View b();

    public abstract com.fyber.inneractive.sdk.model.vast.c c();

    public void d() {
        com.fyber.inneractive.sdk.player.controller.g gVar = this.f1002b;
        if (gVar != null) {
            com.fyber.inneractive.sdk.player.enums.b bVar = gVar.e;
            if (bVar == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar == com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                gVar.a(1, true);
            } else {
                gVar.l();
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g.f
    public void e(boolean z) {
        try {
            f0 f0Var = this.e;
            com.fyber.inneractive.sdk.response.g gVar = f0Var != null ? (com.fyber.inneractive.sdk.response.g) f0Var.f927b : null;
            r rVar = r.VAST_MEDIA_LOAD_RETRY_ATTEMPTED;
            InneractiveAdRequest inneractiveAdRequest = this.f;
            f0 f0Var2 = this.e;
            com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(rVar, inneractiveAdRequest, gVar, f0Var2 == null ? null : f0Var2.c.c());
            if (this.t != null && gVar != null) {
                aVar.f.put(new com.fyber.inneractive.sdk.network.s.b().a("waudio", String.valueOf(z)).a("url", this.t.g).a("bitrate", this.t.e).a("mime", TextUtils.isEmpty(this.t.d) ? "na" : this.t.d).a("delivery", this.t.a).a("media_file_index", Integer.valueOf(this.q)).a("player", this.f1002b.f()).a);
            }
            aVar.a((String) null);
        } catch (Exception unused) {
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g.f
    public void a(Exception exc) {
        JSONObject jSONObject;
        Object[] objArr = new Object[1];
        objArr[0] = exc != null ? exc.getMessage() : "no exception";
        IAlog.a("IMediaPlayerFlowManager: onPlayerError called with: %s", objArr);
        InneractiveVideoError inneractiveVideoError = new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, exc);
        if (exc instanceof d) {
            ((d) exc).getClass();
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
        }
        a(inneractiveVideoError, jSONObject);
        if (this.n) {
            IAlog.a("IMediaPlayerFlowManager: onPlayerError video was prepared. This is a critical error. Aborting!", new Object[0]);
            a(new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, exc), new JSONObject());
        }
    }

    public final void a() {
        boolean zA;
        com.fyber.inneractive.sdk.player.controller.g aVar;
        Context context = this.a;
        s sVar = this.d;
        if (sVar != null) {
            try {
                zA = ((com.fyber.inneractive.sdk.config.global.features.r) sVar.a(com.fyber.inneractive.sdk.config.global.features.r.class)).a("use_fmp_cache_mechanism", false);
            } catch (Throwable th) {
                if (IAlog.a <= 3) {
                    IAlog.a("Failed creating exo player", new Object[0]);
                    th.printStackTrace();
                }
                aVar = null;
            }
        } else {
            zA = false;
        }
        aVar = new com.fyber.inneractive.sdk.player.controller.d(context, zA, sVar);
        if (aVar == null) {
            aVar = new com.fyber.inneractive.sdk.player.controller.a(context);
        }
        this.f1002b = aVar;
        if (!aVar.f1018b.contains(this)) {
            aVar.f1018b.add(this);
        }
        com.fyber.inneractive.sdk.player.controller.g gVar = this.f1002b;
        if (!gVar.c.contains(this)) {
            gVar.c.add(this);
        }
        this.f1002b.f = this.u;
    }

    public static boolean a(int i, b0 b0Var, int i2) {
        if (i2 == 1 || InneractiveAdManager.isCurrentUserAChild()) {
            return true;
        }
        if (i <= 15999) {
            return false;
        }
        c0 c0Var = b0Var != null ? ((a0) b0Var).f : null;
        return (c0Var == null || c0Var.h == Skip.DEFAULT || c0Var.j == UnitDisplayType.REWARDED) ? false : true;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public static int a(c cVar) {
        T t;
        f0 f0Var = cVar.e;
        if (f0Var == null || (t = f0Var.f927b) == 0) {
            return -1;
        }
        return ((com.fyber.inneractive.sdk.response.g) t).w;
    }

    public boolean a(s sVar, k kVar) {
        return kVar.e() && IAConfigManager.M.E.d() && sVar != null && sVar.a(n.class) != null && ((n) sVar.a(n.class)).a("enable_app_info_button", true);
    }
}
