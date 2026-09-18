package com.igaworks.adpopcorn.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b a;

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public int a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Exception unused) {
            return i;
        }
    }

    public long a(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Exception unused) {
            return j;
        }
    }

    public String a(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Exception unused) {
            return str3;
        }
    }

    public void a(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("completeFlag", 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public void a(Context context, String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("adpopcorn_news_daily_completed_list", 0).edit();
                    editorEdit.putBoolean(str, true);
                    editorEdit.commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean a(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Exception unused) {
            return z;
        }
    }

    public void b(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("adpopcorn_news_daily_completed_list", 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public void b(Context context, String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("completeFlag", 0).edit();
                    editorEdit.putBoolean(str, true);
                    editorEdit.commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void b(Context context, String str, String str2, int i) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putInt(str2, i);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public void b(Context context, String str, String str2, long j) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putLong(str2, j);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public void b(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putString(str2, str3);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public void b(Context context, String str, String str2, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putBoolean(str2, z);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public void c(Context context, String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("adpopcorn_popupad_hidden_sp", 0).edit();
                    editorEdit.putLong(str, Calendar.getInstance().getTimeInMillis());
                    editorEdit.commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean d(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            if (str.length() <= 0) {
                return false;
            }
            long j = context.getSharedPreferences("adpopcorn_popupad_hidden_sp", 0).getLong(str, 0L);
            if (j == 0) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return calendar.get(6) == Calendar.getInstance().get(6);
        } catch (Exception unused) {
            return false;
        }
    }

    public void e(Context context, String str) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    public boolean f(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            if (str.length() > 0) {
                return context.getSharedPreferences("adpopcorn_news_daily_completed_list", 0).getBoolean(str, false);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean g(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            if (str.length() > 0) {
                return context.getSharedPreferences("completeFlag", 0).getBoolean(str, false);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
