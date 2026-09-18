package com.mbridge.msdk.foundation.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;

/* JADX INFO: compiled from: SharedPerferenceManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static final String a = "a";
    private static a e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    SharedPreferences f2058b;
    FastKV c;
    private final boolean d;

    private a() {
        c.a();
        this.d = true;
    }

    public static synchronized a a() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    public final void a(String str, String str2) {
        try {
            Context contextG = b.d().g();
            if (contextG == null) {
                return;
            }
            if (this.d && this.c == null) {
                try {
                    this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.c = null;
                }
            }
            FastKV fastKV = this.c;
            if (fastKV != null) {
                try {
                    fastKV.putString(str, str2);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f2058b == null && contextG != null) {
                this.f2058b = contextG.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor editorEdit = this.f2058b.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, int i) {
        try {
            Context contextG = b.d().g();
            if (contextG == null) {
                return;
            }
            if (this.d && this.c == null) {
                try {
                    this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.c = null;
                }
            }
            FastKV fastKV = this.c;
            if (fastKV != null) {
                try {
                    fastKV.putInt(str, i);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f2058b == null && contextG != null) {
                this.f2058b = contextG.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor editorEdit = this.f2058b.edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, long j) {
        try {
            Context contextG = b.d().g();
            if (contextG == null) {
                aa.d(a, "context is null in put");
                return;
            }
            if (this.d && this.c == null) {
                try {
                    this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.c = null;
                }
            }
            FastKV fastKV = this.c;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f2058b == null && contextG != null) {
                this.f2058b = contextG.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor editorEdit = this.f2058b.edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final Long a(String str) {
        try {
            Context contextG = b.d().g();
            if (contextG == null) {
                aa.d(a, "context is null in get");
                return 0L;
            }
            if (this.d && this.c == null) {
                try {
                    this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.c = null;
                }
            }
            FastKV fastKV = this.c;
            if (fastKV != null) {
                try {
                    return Long.valueOf(fastKV.getLong(str, 0L));
                } catch (Exception unused2) {
                    return 0L;
                }
            }
            if (this.f2058b == null && contextG != null) {
                this.f2058b = contextG.getSharedPreferences("mbridge", 0);
            }
            return Long.valueOf(this.f2058b.getLong(str, 0L));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public final int b(String str, int i) {
        try {
            Context contextG = b.d().g();
            if (contextG == null) {
                return i;
            }
            if (this.d && this.c == null) {
                try {
                    this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.c = null;
                }
            }
            FastKV fastKV = this.c;
            if (fastKV != null) {
                try {
                    return fastKV.getInt(str, i);
                } catch (Exception unused2) {
                    return i;
                }
            }
            if (this.f2058b == null) {
                this.f2058b = contextG.getSharedPreferences("mbridge", 0);
            }
            return this.f2058b.getInt(str, i);
        } catch (Exception e2) {
            e2.printStackTrace();
            return i;
        }
    }

    public final String b(String str) {
        try {
            Context contextG = b.d().g();
            if (contextG == null) {
                return null;
            }
            if (this.d && this.c == null) {
                try {
                    this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.c = null;
                }
            }
            FastKV fastKV = this.c;
            if (fastKV != null) {
                try {
                    return fastKV.getString(str, "");
                } catch (Exception unused2) {
                    return "";
                }
            }
            if (this.f2058b == null && contextG != null) {
                this.f2058b = contextG.getSharedPreferences("mbridge", 0);
            }
            return this.f2058b.getString(str, "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void c(String str) {
        Context contextG = b.d().g();
        if (contextG == null) {
            return;
        }
        if (this.d && this.c == null) {
            try {
                this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
                this.c = null;
            }
        }
        FastKV fastKV = this.c;
        if (fastKV != null) {
            try {
                fastKV.remove(str);
            } catch (Exception unused2) {
            }
        } else {
            if (this.f2058b == null && contextG != null) {
                this.f2058b = contextG.getSharedPreferences("mbridge", 0);
            }
            this.f2058b.edit().remove(str).apply();
        }
    }
}
