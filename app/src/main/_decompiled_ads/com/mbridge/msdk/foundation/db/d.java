package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ag;

/* JADX INFO: compiled from: CampaignClickDao.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends a<CommonJumpLoader.JumpLoaderResult> {
    public static final String a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f2075b;

    private d(g gVar) {
        super(gVar);
    }

    public static synchronized d a(g gVar) {
        if (f2075b == null) {
            f2075b = new d(gVar);
        }
        return f2075b;
    }

    public final synchronized void a() {
        try {
            getWritableDatabase().delete("campaignclick", " ( " + System.currentTimeMillis() + " - " + CampaignEx.JSON_KEY_ST_TS + ") > cti", null);
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
    }

    public final synchronized long a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            String strA = ag.a(campaignEx.getJumpResult());
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            contentValues.put("unitid", str);
            contentValues.put("result", strA);
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval() * 1000));
            contentValues.put(CampaignEx.JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
            com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            contentValues.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(System.currentTimeMillis()));
            if (cVarB != null && cVarB.ab() > 0) {
                contentValues.put("cpei", Integer.valueOf(cVarB.ab() * 1000));
            }
            if (cVarB != null && cVarB.ac() > 0) {
                contentValues.put("cpoci", Integer.valueOf(cVarB.ac() * 1000));
            }
            if (c(campaignEx.getId(), str)) {
                String str2 = "id = " + campaignEx.getId() + " AND unitid = " + str;
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                return getWritableDatabase().update("campaignclick", contentValues, str2, null);
            }
            return getWritableDatabase().insert("campaignclick", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized boolean a(String str, String str2) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id='" + str + "' AND unitid='" + str2 + "' AND cti + " + CampaignEx.JSON_KEY_ST_TS + " > " + System.currentTimeMillis(), null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Exception e) {
            aa.d(a, e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005f A[Catch: all -> 0x0063, TRY_ENTER, TryCatch #0 {all -> 0x0063, blocks: (B:14:0x0042, B:20:0x004b, B:34:0x005f, B:35:0x0062), top: B:39:0x0002 }] */
    public final synchronized CommonJumpLoader.JumpLoaderResult b(String str, String str2) {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            try {
                cursorQuery = getReadableDatabase().query("campaignclick", null, "id=? AND unitid=?", new String[]{str, str2}, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("result"));
                                if (!TextUtils.isEmpty(string)) {
                                    CommonJumpLoader.JumpLoaderResult jumpLoaderResult = (CommonJumpLoader.JumpLoaderResult) ag.a(string);
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    return jumpLoaderResult;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (cursorQuery != null) {
                        }
                        return null;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            return null;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    private synchronized boolean c(String str, String str2) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id='" + str + "' AND unitid= '" + str2 + "'", null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            cursorRawQuery.close();
            return true;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return false;
    }
}
