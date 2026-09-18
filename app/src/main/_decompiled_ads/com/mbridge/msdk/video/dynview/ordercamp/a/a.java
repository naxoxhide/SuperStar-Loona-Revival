package com.mbridge.msdk.video.dynview.ordercamp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.video.dynview.h.b;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.io.File;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: OrderCampAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends BaseAdapter {
    private boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0520a f2519b;
    private List<CampaignEx> c;

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public a(List<CampaignEx> list) {
        this.c = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<CampaignEx> list = this.c;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List<CampaignEx> list = this.c;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x032f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View viewA;
        try {
            if (view == null) {
                viewA = a(i);
            } else {
                this.f2519b = (C0520a) view.getTag();
                viewA = view;
            }
            try {
                this.f2519b.a = (RelativeLayout) viewA.findViewById(d("mbridge_lv_item_rl"));
                this.f2519b.e = (TextView) viewA.findViewById(d("mbridge_lv_title_tv"));
                this.f2519b.g = (TextView) viewA.findViewById(d("mbridge_lv_tv_install"));
                this.f2519b.o = (MBHeatLevelLayoutView) viewA.findViewById(d("mbridge_lv_sv_heat_level"));
                this.f2519b.f = (TextView) viewA.findViewById(d("mbridge_lv_desc_tv"));
                this.f2519b.j = (ImageView) viewA.findViewById(d("mbridge_iv_flag"));
                this.f2519b.h = (TextView) viewA.findViewById(d("mbridge_order_viewed_tv"));
                double d = 5.0d;
                if (this.a) {
                    List<CampaignEx> list = this.c;
                    if (list != null && this.f2519b != null && list.size() != 0) {
                        if (this.f2519b.l != null && (this.f2519b.l instanceof MBCusRoundImageView)) {
                            this.f2519b.l.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                            a(this.f2519b.l, this.c.get(i).getImageUrl(), false);
                        }
                        if (this.f2519b.k != null) {
                            a(this.f2519b.k, this.c.get(i).getImageUrl(), false);
                        }
                        if (this.f2519b.m != null && (this.f2519b.m instanceof MBCusRoundImageView)) {
                            this.f2519b.m.setBorder(50, 20, -1);
                            a(this.f2519b.m, this.c.get(i).getIconUrl(), true);
                        }
                        double rating = this.c.get(i).getRating();
                        if (rating > 0.0d) {
                            d = rating;
                        }
                        if (this.f2519b.n != null) {
                            this.f2519b.n.setRating((int) d);
                            this.f2519b.n.setOrientation(0);
                        }
                        if (this.f2519b.o != null) {
                            this.f2519b.o.setHeatCount(this.c.get(i).getNumberRating());
                        }
                    }
                } else {
                    List<CampaignEx> list2 = this.c;
                    if (list2 != null && this.f2519b != null && list2.size() != 0) {
                        if (this.f2519b.c != null) {
                            a(this.f2519b.c, this.c.get(i).getImageUrl(), false);
                        }
                        if (this.f2519b.k != null) {
                            a(this.f2519b.k, this.c.get(i).getImageUrl(), false);
                        }
                        if (this.f2519b.d != null) {
                            this.f2519b.d.setBorderRadius(25);
                            a(this.f2519b.d, this.c.get(i).getIconUrl(), true);
                        }
                        double rating2 = this.c.get(i).getRating();
                        if (rating2 > 0.0d) {
                            d = rating2;
                        }
                        if (this.f2519b.i != null) {
                            this.f2519b.i.setRatingAndUser(d, this.c.get(i).getNumberRating());
                            this.f2519b.i.setOrientation(0);
                        }
                        if (this.f2519b.f2521b != null) {
                            this.f2519b.f2521b.setWidthRatio(1.0f);
                            this.f2519b.f2521b.setHeightRatio(1.0f);
                            this.f2519b.f2521b.setAutoscroll(false);
                        }
                        if (this.f2519b.c != null) {
                            this.f2519b.c.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                        }
                    }
                }
                C0520a c0520a = this.f2519b;
                if (c0520a != null) {
                    if (c0520a.e != null) {
                        this.f2519b.e.setText(this.c.get(i).getAppName());
                    }
                    if (this.f2519b.f != null) {
                        this.f2519b.f.setText(this.c.get(i).getAppDesc());
                    }
                    if (this.f2519b.g != null) {
                        String adCall = this.c.get(i).getAdCall();
                        if (this.f2519b.g instanceof MBridgeTextView) {
                            ((MBridgeTextView) this.f2519b.g).setObjectAnimator(new b().c(this.f2519b.g));
                        }
                        this.f2519b.g.setText(adCall);
                    }
                    if (this.f2519b.j != null) {
                        try {
                            String language = Locale.getDefault().getLanguage();
                            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                            if (contextG != null) {
                                if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                                    this.f2519b.j.setImageDrawable(contextG.getResources().getDrawable(contextG.getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.b.d().b())));
                                } else {
                                    this.f2519b.j.setImageDrawable(contextG.getResources().getDrawable(contextG.getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.b.d().b())));
                                }
                            }
                        } catch (Exception e) {
                            aa.d("OrderCampAdapter", e.getMessage());
                        }
                        af.a(2, this.f2519b.j, this.c.get(i), com.mbridge.msdk.foundation.controller.b.d().g(), false, null);
                        if (this.f2519b.h != null) {
                            try {
                                this.f2519b.h.setText(com.mbridge.msdk.foundation.controller.b.d().g().getResources().getString(com.mbridge.msdk.foundation.controller.b.d().g().getResources().getIdentifier("mbridge_reward_viewed_text_str", "string", com.mbridge.msdk.foundation.controller.b.d().b())));
                                this.f2519b.h.setVisibility(0);
                            } catch (Exception e2) {
                                aa.d("OrderCampAdapter", e2.getMessage());
                            }
                        }
                    } else if (this.f2519b.h != null) {
                        this.f2519b.h.setText(com.mbridge.msdk.foundation.controller.b.d().g().getResources().getString(com.mbridge.msdk.foundation.controller.b.d().g().getResources().getIdentifier("mbridge_reward_viewed_text_str", "string", com.mbridge.msdk.foundation.controller.b.d().b())));
                        this.f2519b.h.setVisibility(0);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                aa.d("OrderCampAdapter", e.getMessage());
            }
        } catch (Exception e4) {
            e = e4;
            viewA = view;
        }
        return viewA;
    }

    private View a(int i) {
        View viewCreateDynamicView;
        String str;
        try {
            List<CampaignEx> list = this.c;
            String cMPTEntryUrl = "";
            if (list == null || list.get(i) == null) {
                str = "501";
            } else {
                str = this.c.get(i).getMof_tplid() + "";
                cMPTEntryUrl = this.c.get(i).getCMPTEntryUrl();
            }
            if (TextUtils.isEmpty(cMPTEntryUrl)) {
                return a();
            }
            int iH = w.h(com.mbridge.msdk.foundation.controller.b.d().g());
            String strA = k.a(0, str, cMPTEntryUrl);
            if (TextUtils.isEmpty(strA)) {
                return a();
            }
            File file = new File(strA + File.separator + "template_config.json");
            if (file.isFile() && file.exists()) {
                List<String> listB = y.b(strA, "template_" + str + "_" + iH + "_item");
                if (listB == null) {
                    return a();
                }
                int iH2 = w.h(com.mbridge.msdk.foundation.controller.b.d().g());
                d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                viewCreateDynamicView = DynamicViewCreator.getInstance().createDynamicView(new DyOption.Builder().campaignEx(this.c.get(i)).fileDirs(listB).dyAdType(DyAdType.REWARD).orientation(iH2).adChoiceLink(af.c(this.c.get(i))).build());
                if (viewCreateDynamicView != null) {
                    this.a = true;
                    C0520a c0520a = new C0520a();
                    this.f2519b = c0520a;
                    c0520a.l = (MBCusRoundImageView) viewCreateDynamicView.findViewById(c("mbridge_lv_iv"));
                    this.f2519b.k = (ImageView) viewCreateDynamicView.findViewById(c("mbridge_lv_iv_burl"));
                    this.f2519b.m = (MBCusRoundImageView) viewCreateDynamicView.findViewById(c("mbridge_lv_icon_iv"));
                    this.f2519b.n = (MBStarLevelLayoutView) viewCreateDynamicView.findViewById(c("mbridge_lv_sv_starlevel"));
                    this.f2519b.p = (MBFrameLayout) viewCreateDynamicView.findViewById(c("mbridge_lv_ration"));
                    viewCreateDynamicView.setTag(this.f2519b);
                }
                return this.a ? viewCreateDynamicView : a();
            }
            return a();
        } catch (Exception e) {
            aa.d("OrderCampAdapter", e.getMessage());
            viewCreateDynamicView = null;
        }
    }

    private View a() {
        View viewInflate = LayoutInflater.from(com.mbridge.msdk.foundation.controller.b.d().g()).inflate(a("mbridge_order_layout_item"), (ViewGroup) null);
        C0520a c0520a = new C0520a();
        this.f2519b = c0520a;
        c0520a.c = (MBridgeImageView) viewInflate.findViewById(b("mbridge_lv_iv"));
        this.f2519b.k = (ImageView) viewInflate.findViewById(b("mbridge_lv_iv_burl"));
        this.f2519b.d = (RoundImageView) viewInflate.findViewById(b("mbridge_lv_icon_iv"));
        this.f2519b.i = (MBridgeLevelLayoutView) viewInflate.findViewById(b("mbridge_lv_sv_starlevel"));
        this.f2519b.f2521b = (MBRotationView) viewInflate.findViewById(b("mbridge_lv_ration"));
        viewInflate.setTag(this.f2519b);
        return viewInflate;
    }

    private void a(final ImageView imageView, String str, final boolean z) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new c() { // from class: com.mbridge.msdk.video.dynview.ordercamp.a.a.1
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str2) {
                    try {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                    } catch (Throwable th) {
                        aa.d("OrderCampAdapter", th.getMessage());
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str2, String str3) {
                    if (z) {
                        imageView.setVisibility(8);
                    }
                }
            });
        } else if (z) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.video.dynview.ordercamp.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OrderCampAdapter.java */
    static class C0520a {
        RelativeLayout a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        MBRotationView f2521b;
        MBridgeImageView c;
        RoundImageView d;
        TextView e;
        TextView f;
        TextView g;
        TextView h;
        MBridgeLevelLayoutView i;
        ImageView j;
        ImageView k;
        MBCusRoundImageView l;
        MBCusRoundImageView m;
        MBStarLevelLayoutView n;
        MBHeatLevelLayoutView o;
        MBFrameLayout p;

        C0520a() {
        }
    }

    private int a(String str) {
        return t.a(com.mbridge.msdk.foundation.controller.b.d().g().getApplicationContext(), str, "layout");
    }

    private int b(String str) {
        return t.a(com.mbridge.msdk.foundation.controller.b.d().g().getApplicationContext(), str, "id");
    }

    private int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private int d(String str) {
        if (this.a) {
            return c(str);
        }
        return b(str);
    }
}
