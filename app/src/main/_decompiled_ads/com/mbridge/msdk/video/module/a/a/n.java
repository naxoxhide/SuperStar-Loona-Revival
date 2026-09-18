package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.factory.IJSFactory;

/* JADX INFO: compiled from: VideoViewJSListener.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends o {
    private IJSFactory l;
    private int m;
    private boolean n;
    private int o;
    private boolean p;

    public n(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, int i, int i2, com.mbridge.msdk.video.module.a.a aVar2, int i3, boolean z, int i4) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i3, z);
        this.n = false;
        this.p = false;
        this.l = iJSFactory;
        this.m = i;
        this.n = i2 == 0;
        if (iJSFactory == null) {
            this.a = false;
        }
        this.o = i4;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0298  */
    /* JADX WARN: Code duplicated, block: B:84:0x0229  */
    /* JADX WARN: Code duplicated, block: B:86:0x0234  */
    /* JADX WARN: Code duplicated, block: B:90:0x0255  */
    /* JADX WARN: Code duplicated, block: B:92:0x025d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0267  */
    @Override // com.mbridge.msdk.video.module.a.a.o, com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i, Object obj) {
        Integer num;
        int i2;
        if (this.a) {
            if (i != 1) {
                if (i == 2) {
                    this.l.getJSVideoModule().dismissAllAlert();
                    if (i == 2) {
                        this.l.getJSNotifyProxy().a(2, "");
                    }
                    this.l.getJSVideoModule().videoOperate(3);
                    if (this.l.getJSCommon().g() != 2) {
                        if (this.f2548b.getVideo_end_type() != 3) {
                            this.l.getJSVideoModule().setVisible(8);
                        } else {
                            this.l.getJSVideoModule().setVisible(0);
                        }
                        if (this.m == 2 || this.l.getJSContainerModule().endCardShowing() || this.f2548b.getAdSpaceT() == 2) {
                            i = 16;
                        } else {
                            this.l.getJSContainerModule().showEndcard(this.f2548b.getVideo_end_type());
                        }
                    } else {
                        i = 16;
                    }
                    this.l.getJSNotifyProxy().a(1);
                } else if (i != 5) {
                    if (i == 6) {
                        this.l.getJSVideoModule().dismissAllAlert();
                        if (i == 2) {
                            this.l.getJSNotifyProxy().a(2, "");
                        }
                        this.l.getJSVideoModule().videoOperate(3);
                        if (this.l.getJSCommon().g() != 2) {
                            if (this.f2548b.getVideo_end_type() != 3) {
                                this.l.getJSVideoModule().setVisible(8);
                            } else {
                                this.l.getJSVideoModule().setVisible(0);
                            }
                            if (this.m == 2) {
                                i = 16;
                            } else {
                                i = 16;
                            }
                        } else {
                            i = 16;
                        }
                        this.l.getJSNotifyProxy().a(1);
                    } else if (i != 8) {
                        if (i != 114) {
                            if (i != 116) {
                                switch (i) {
                                    case 10:
                                        this.p = true;
                                        this.l.getJSNotifyProxy().a(0);
                                        break;
                                    case 11:
                                    case 12:
                                        this.l.getJSVideoModule().videoOperate(3);
                                        if (this.f2548b.getVideo_end_type() != 3) {
                                            if (this.f2548b.getAdSpaceT() != 2) {
                                                this.l.getJSVideoModule().setVisible(8);
                                            }
                                        } else {
                                            this.l.getJSVideoModule().setVisible(0);
                                        }
                                        if (i == 12) {
                                            h();
                                            i2 = 2;
                                        } else {
                                            i2 = 1;
                                        }
                                        this.l.getJSNotifyProxy().a(i2);
                                        if (this.l.getJSCommon().g() == 2) {
                                            this.l.getJSVideoModule().setVisible(0);
                                            com.mbridge.msdk.video.signal.i jSVideoModule = this.l.getJSVideoModule();
                                            this.l.getJSContainerModule().showMiniCard(jSVideoModule.getBorderViewTop(), jSVideoModule.getBorderViewLeft(), jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                                        } else if (i == 12) {
                                            if (this.o == 1) {
                                                if (this.f2548b.getAdSpaceT() != 2) {
                                                    this.l.getJSContainerModule().showEndcard(this.f2548b.getVideo_end_type());
                                                } else {
                                                    this.l.getJSContainerModule().showVideoEndCover();
                                                }
                                            }
                                        } else if (this.f2548b.getAdSpaceT() != 2) {
                                            this.l.getJSContainerModule().showEndcard(this.f2548b.getVideo_end_type());
                                        } else {
                                            this.l.getJSContainerModule().showVideoEndCover();
                                        }
                                        this.l.getJSVideoModule().dismissAllAlert();
                                        if (i == 12 && !this.p && this.o == 1) {
                                            h();
                                            g();
                                            f();
                                            e();
                                        }
                                        break;
                                    case 13:
                                        if (!this.l.getJSVideoModule().isH5Canvas()) {
                                            this.l.getJSVideoModule().closeVideoOperate(0, 2);
                                        }
                                        this.l.getJSNotifyProxy().a(-1);
                                        break;
                                    case 14:
                                        if (!this.n) {
                                            this.l.getJSVideoModule().closeVideoOperate(0, 1);
                                        }
                                        break;
                                    case 15:
                                        if (obj != null && (obj instanceof MBridgeVideoView.a)) {
                                            this.n = true;
                                            this.l.getJSNotifyProxy().a((MBridgeVideoView.a) obj);
                                        }
                                        break;
                                    default:
                                        switch (i) {
                                            case 123:
                                            case 124:
                                                this.l.getJSNotifyProxy().a(i == 123 ? 7 : 6, "");
                                                break;
                                            case 125:
                                                this.l.getJSContainerModule().hideAlertWebview();
                                                break;
                                        }
                                        break;
                                }
                            } else {
                                com.mbridge.msdk.video.signal.i jSVideoModule2 = this.l.getJSVideoModule();
                                this.l.getJSContainerModule().configurationChanged(jSVideoModule2.getBorderViewWidth(), jSVideoModule2.getBorderViewHeight(), jSVideoModule2.getBorderViewRadius());
                            }
                        } else if (this.l.getJSCommon().g() == 2) {
                            com.mbridge.msdk.video.signal.i jSVideoModule3 = this.l.getJSVideoModule();
                            this.l.getJSContainerModule().showMiniCard(jSVideoModule3.getBorderViewTop(), jSVideoModule3.getBorderViewLeft(), jSVideoModule3.getBorderViewWidth(), jSVideoModule3.getBorderViewHeight(), jSVideoModule3.getBorderViewRadius());
                        }
                    } else if (!this.l.getJSContainerModule().showAlertWebView()) {
                        this.l.getJSVideoModule().showAlertView();
                    } else {
                        this.l.getJSVideoModule().alertWebViewShowed();
                    }
                } else if (obj != null && (obj instanceof Integer)) {
                    if (((Integer) obj).intValue() == 1) {
                        num = 2;
                    } else {
                        num = 1;
                    }
                    this.l.getJSVideoModule().soundOperate(num.intValue(), -1);
                    this.l.getJSNotifyProxy().a(5, num + "");
                }
            } else if (!this.l.getJSContainerModule().endCardShowing()) {
                this.l.getJSNotifyProxy().a(1, obj != null ? obj.toString() : "");
            }
        }
        super.a(i, obj);
    }
}
