package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonJumpLoader extends c {
    private int d;
    private com.mbridge.msdk.foundation.same.e.b g;
    private i h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1920b = 0;
    private String c = null;
    JumpLoaderResult a = null;
    private d e = null;
    private boolean f = true;
    private Handler i = new Handler(Looper.getMainLooper());

    public CommonJumpLoader(Context context) {
        this.g = new com.mbridge.msdk.foundation.same.e.b(context);
        this.h = new i(context);
    }

    public final void a(String str, CampaignEx campaignEx, d dVar, String str2, boolean z, boolean z2, int i) {
        String id;
        this.c = str2;
        this.e = dVar;
        this.a = null;
        this.d = i;
        boolean z3 = false;
        if (campaignEx != null) {
            z3 = CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode());
            id = campaignEx.getId();
        } else {
            id = "";
        }
        this.h.a(str2, dVar, z3, id, str, campaignEx, z, z2, i);
    }

    public final void a(String str, CampaignEx campaignEx, d dVar) {
        this.c = new String(campaignEx.getClickURL());
        this.e = dVar;
        this.a = null;
        this.h.a(campaignEx.getClickURL(), dVar, CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode()), campaignEx.getId(), str, campaignEx, true, false, com.mbridge.msdk.click.a.a.j);
    }

    @Override // com.mbridge.msdk.click.c
    public final void a() {
        this.f = false;
    }

    public static class JumpLoaderResult implements NoProGuard, Serializable {
        public static final int CODE_DOWNLOAD = 3;
        public static final int CODE_LINK = 2;
        public static final int CODE_MARKET = 1;
        public static final int CODE_NULL = 4;
        private static final long serialVersionUID = 1;
        private int code;
        private String content;
        private String exceptionMsg;
        private String header;
        private boolean is302Jump;
        private boolean jumpDone;
        private String msg;
        private String noticeurl;
        private int statusCode;
        private boolean success;
        private int type;
        private String url;

        public int getStatusCode() {
            return this.statusCode;
        }

        public void setStatusCode(int i) {
            this.statusCode = i;
        }

        public boolean isIs302Jump() {
            return this.is302Jump;
        }

        public void setIs302Jump(boolean z) {
            this.is302Jump = z;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public String getHeader() {
            return this.header;
        }

        public void setHeader(String str) {
            this.header = str;
        }

        public String getExceptionMsg() {
            return this.exceptionMsg;
        }

        public void setExceptionMsg(String str) {
            this.exceptionMsg = str;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getNoticeurl() {
            return this.noticeurl;
        }

        public void setNoticeurl(String str) {
            this.noticeurl = str;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public void setSuccess(boolean z) {
            this.success = z;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public boolean isjumpDone() {
            return this.jumpDone;
        }

        public void setjumpDone(boolean z) {
            this.jumpDone = z;
        }
    }
}
