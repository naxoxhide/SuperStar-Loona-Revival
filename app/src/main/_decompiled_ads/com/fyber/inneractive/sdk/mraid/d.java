package com.fyber.inneractive.sdk.mraid;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {
    public d(Map<String, String> map, com.fyber.inneractive.sdk.web.i iVar, k0 k0Var) {
        super(map, iVar, k0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.b
    public void a() {
        L l;
        com.fyber.inneractive.sdk.web.i iVar = this.c;
        Map<String, String> map = this.f974b;
        Context contextL = iVar.l();
        boolean z = true;
        if (com.fyber.inneractive.sdk.util.j.a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event"))) {
            try {
                Map<String, Object> mapA = iVar.a(map);
                Intent type = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
                HashMap map2 = (HashMap) mapA;
                for (String str : map2.keySet()) {
                    Object obj = map2.get(str);
                    if (obj instanceof Long) {
                        type.putExtra(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        type.putExtra(str, ((Integer) obj).intValue());
                    } else {
                        type.putExtra(str, (String) obj);
                    }
                }
                type.setFlags(268435456);
                contextL.startActivity(type);
            } catch (ActivityNotFoundException unused) {
                IAlog.a("There is no calendar app installed!", new Object[0]);
                iVar.a(g.CREATE_CALENDAR_EVENT, "Action is unsupported on this device - no calendar app installed");
                z = false;
            } catch (IllegalArgumentException e) {
                IAlog.a("invalid parameters for create calendar ", e.getMessage());
                iVar.a(g.CREATE_CALENDAR_EVENT, e.getMessage());
                z = false;
            } catch (Exception unused2) {
                IAlog.a("Failed to create calendar event.", new Object[0]);
                iVar.a(g.CREATE_CALENDAR_EVENT, "could not create calendar event");
                z = false;
            }
            if (z || (l = iVar.g) == 0) {
            }
            ((com.fyber.inneractive.sdk.web.i.f) l).c();
            return;
        }
        IAlog.a("createCalendarEvent supported for devices post-ICS", new Object[0]);
        iVar.a(g.CREATE_CALENDAR_EVENT, "Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
        z = false;
        if (z) {
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.a
    public String c() {
        return null;
    }
}
