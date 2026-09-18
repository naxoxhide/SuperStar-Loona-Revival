package com.mbridge.msdk.video.dynview.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.dynview.e.e;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DataEnergizeWrapper.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static boolean j = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.i.c.b f2500b;
    private Map<String, Bitmap> c;
    private volatile boolean d;
    private String e = "#FFFFFFFF";
    private String f = "#60000000";
    private String g = "#FF5F5F5F";
    private String h = "#90ECECEC";
    private volatile long i = 0;
    private com.mbridge.msdk.video.dynview.i.c.a k = null;
    private boolean l = false;
    private int m = 0;
    public com.mbridge.msdk.video.dynview.d.a a = new com.mbridge.msdk.video.dynview.d.a() { // from class: com.mbridge.msdk.video.dynview.j.a.1
        @Override // com.mbridge.msdk.video.dynview.d.a
        public final void a() {
            if (!a.this.l || a.this.f2500b == null) {
                return;
            }
            a.this.f2500b.a(a.this.m * 1000, a.this.k);
            a.this.l = false;
        }

        @Override // com.mbridge.msdk.video.dynview.d.a
        public final void b() {
            if (a.this.f2500b != null) {
                a.this.f2500b.b();
                a.this.l = true;
            }
        }

        @Override // com.mbridge.msdk.video.dynview.d.a
        public final void c() {
            if (a.this.f2500b != null) {
                a.this.f2500b.b();
                a.this.l = true;
            }
        }
    };

    /* JADX WARN: Code duplicated, block: B:50:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:73:0x028f  */
    public final void a(com.mbridge.msdk.video.dynview.c cVar, View view, final Map map, e eVar) {
        CampaignEx campaignEx;
        CampaignEx campaignEx2;
        RoundImageView roundImageView;
        RoundImageView roundImageView2;
        ImageView imageView;
        ImageView imageView2;
        int i;
        int i2;
        if (this.c == null) {
            this.c = new HashMap();
        }
        final List<CampaignEx> listG = cVar.g();
        if (view == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_ROOTVIEW);
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
            return;
        }
        if (listG == null || listG.size() <= 1) {
            campaignEx = null;
            campaignEx2 = null;
        } else {
            CampaignEx campaignEx3 = listG.get(0);
            campaignEx = listG.get(1);
            campaignEx2 = campaignEx3;
        }
        if (campaignEx2 == null && eVar != null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (campaignEx == null && eVar != null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            j = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(j, "mbridge_top_item_rl"));
        MBridgeImageView mBridgeImageView = (MBridgeImageView) view.findViewById(a(j, "mbridge_top_iv"));
        MBRotationView mBRotationView = (MBRotationView) view.findViewById(a(j, "mbridge_top_ration"));
        TextView textView = (TextView) view.findViewById(a(j, "mbridge_top_title_tv"));
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(a(j, "mbridge_bottom_item_rl"));
        MBRotationView mBRotationView2 = (MBRotationView) view.findViewById(a(j, "mbridge_bottom_ration"));
        MBridgeImageView mBridgeImageView2 = (MBridgeImageView) view.findViewById(a(j, "mbridge_bottom_iv"));
        boolean z = j;
        if (z) {
            imageView = (MBCusRoundImageView) view.findViewById(a(z, "mbridge_top_icon_iv"));
            imageView2 = (MBCusRoundImageView) view.findViewById(a(j, "mbridge_bottom_icon_iv"));
            roundImageView2 = null;
            roundImageView = null;
        } else {
            RoundImageView roundImageView3 = (RoundImageView) view.findViewById(a(z, "mbridge_top_icon_iv"));
            roundImageView = (RoundImageView) view.findViewById(a(j, "mbridge_bottom_icon_iv"));
            roundImageView2 = roundImageView3;
            imageView = null;
            imageView2 = null;
        }
        CampaignEx campaignEx4 = campaignEx;
        TextView textView2 = (TextView) view.findViewById(a(j, "mbridge_bottom_title_tv"));
        ImageView imageView3 = (ImageView) view.findViewById(a(j, "mbridge_reward_choice_one_like_iv"));
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.dynview.j.a.4
                @Override // com.mbridge.msdk.widget.a
                protected final void a(View view2) {
                    if (a.this.d) {
                        return;
                    }
                    a.this.d = true;
                    a.a(a.this, map, listG, 0);
                }
            });
        }
        if (mBridgeImageView != null) {
            mBridgeImageView.setCustomBorder(20, 20, 0, 0, 10, -16777216);
            a(campaignEx2.getImageUrl(), mBridgeImageView, cVar, view);
            if (mBRotationView != null) {
                if (campaignEx2.getCanStart2C1Anim()) {
                    if (!TextUtils.isEmpty(campaignEx2.getIconUrl())) {
                        ImageView imageView4 = new ImageView(cVar.a());
                        imageView4.setLayoutParams(new FrameLayout.LayoutParams(-1, af.b(cVar.a(), 200.0f)));
                        imageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        mBRotationView.addView(imageView4);
                        a(campaignEx2.getIconUrl(), imageView4);
                        mBRotationView.setWidthRatio(0.45f);
                        mBRotationView.setHeightRatio(0.9f);
                        mBRotationView.setAutoscroll(true);
                    } else {
                        imageView3 = imageView3;
                        mBRotationView.setWidthRatio(1.0f);
                        mBRotationView.setHeightRatio(1.0f);
                        i = 0;
                        mBRotationView.setAutoscroll(false);
                    }
                } else {
                    imageView3 = imageView3;
                    i = 0;
                    mBRotationView.setWidthRatio(1.0f);
                    mBRotationView.setHeightRatio(1.0f);
                    mBRotationView.setAutoscroll(false);
                }
            }
            i = 0;
        } else {
            i = 0;
        }
        if (roundImageView2 != null) {
            roundImageView2.setType(i);
            a(campaignEx2.getIconUrl(), roundImageView2);
        }
        if (imageView != null) {
            a(campaignEx2.getIconUrl(), imageView);
        }
        if (textView != null) {
            if (!TextUtils.isEmpty(campaignEx2.getAppName())) {
                textView.setText(campaignEx2.getAppName());
            } else {
                textView.setVisibility(8);
            }
        }
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.dynview.j.a.5
                @Override // com.mbridge.msdk.widget.a
                protected final void a(View view2) {
                    if (a.this.d) {
                        return;
                    }
                    a.this.d = true;
                    a.a(a.this, map, listG, 1);
                }
            });
        }
        if (mBridgeImageView2 != null) {
            mBridgeImageView2.setCustomBorder(20, 20, 0, 0, 10, -16777216);
            a(campaignEx4.getImageUrl(), mBridgeImageView2, cVar, view);
            if (mBRotationView2 == null) {
                i2 = 0;
            } else if (campaignEx4.getCanStart2C1Anim()) {
                if (!TextUtils.isEmpty(campaignEx4.getIconUrl())) {
                    ImageView imageView5 = new ImageView(cVar.a());
                    imageView5.setLayoutParams(new FrameLayout.LayoutParams(-1, af.b(cVar.a(), 200.0f)));
                    imageView5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    mBRotationView2.addView(imageView5);
                    a(campaignEx4.getIconUrl(), imageView5);
                    mBRotationView2.setWidthRatio(0.45f);
                    mBRotationView2.setHeightRatio(0.9f);
                    mBRotationView2.setAutoscroll(true);
                    i2 = 0;
                } else {
                    mBRotationView2.setWidthRatio(1.0f);
                    mBRotationView2.setHeightRatio(1.0f);
                    i2 = 0;
                    mBRotationView2.setAutoscroll(false);
                }
            } else {
                i2 = 0;
                mBRotationView2.setWidthRatio(1.0f);
                mBRotationView2.setHeightRatio(1.0f);
                mBRotationView2.setAutoscroll(false);
            }
        } else {
            i2 = 0;
        }
        if (roundImageView != null) {
            RoundImageView roundImageView4 = roundImageView;
            roundImageView4.setType(i2);
            a(campaignEx4.getIconUrl(), roundImageView4);
        }
        if (imageView2 != null) {
            a(campaignEx4.getIconUrl(), imageView2);
        }
        if (textView2 != null) {
            textView2.setText(campaignEx4.getAppName());
        }
        String cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
        cVar.e();
        String strA = al.a(cMPTEntryUrl, "cltp");
        final String strA2 = al.a(cMPTEntryUrl, "xt");
        long j2 = !TextUtils.isEmpty(strA) ? Long.parseLong(strA) : 0L;
        if (j2 != 0) {
            if (map != null && map.containsKey("is_dy_success")) {
                j = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            final TextView textView3 = (TextView) view.findViewById(a(j, "mbridge_choice_one_countdown_tv"));
            if (textView3 != null) {
                textView3.setTextSize(11.0f);
                textView3.setTextColor(Color.parseColor(this.e));
                String str = this.f;
                if (textView3 != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor(str));
                    gradientDrawable.setCornerRadius(af.b(textView3.getContext(), 12));
                    gradientDrawable.setStroke(af.b(textView3.getContext(), 1), Color.parseColor(str));
                    textView3.setBackground(gradientDrawable);
                }
                textView3.setVisibility(0);
                textView3.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.dynview.j.a.11
                    @Override // com.mbridge.msdk.widget.a
                    protected final void a(View view2) {
                        if (a.this.d) {
                            return;
                        }
                        a.this.d = true;
                        a.b(a.this, map);
                    }
                });
                final CampaignEx campaignEx5 = campaignEx2;
                this.k = new com.mbridge.msdk.video.dynview.i.c.a() { // from class: com.mbridge.msdk.video.dynview.j.a.2
                    @Override // com.mbridge.msdk.video.dynview.i.c.a
                    public final void a(long j3) {
                        String str2;
                        a.this.m = (int) (j3 / 1000);
                        long j4 = a.this.m;
                        String strG = w.g(textView3.getContext());
                        if (strG.startsWith("zh")) {
                            if (strG.contains("TW") || strG.contains("HK")) {
                                str2 = j4 + " 秒後自動播放";
                            } else {
                                str2 = j4 + " 秒后自动播放";
                            }
                        } else if (strG.startsWith(ApStyleManager.Language.JA)) {
                            str2 = j4 + " 秒後自動的に再生 ";
                        } else if (strG.startsWith(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
                            str2 = "Automatische Wiedergabe nach " + j4 + " Sekunden";
                        } else if (strG.startsWith(ApStyleManager.Language.KO)) {
                            str2 = j4 + " 초 후 자동 재생 ";
                        } else if (strG.startsWith("fr")) {
                            str2 = "Lecture de vidéo dans " + j4 + " secondes";
                        } else if (strG.startsWith("ar")) {
                            str2 = " ثوان" + j4 + "لعب تلقائيا بعد ";
                        } else if (strG.startsWith("ru")) {
                            str2 = "Автовоспроизведение через " + j4 + " секунд";
                        } else {
                            str2 = "Auto play after " + j4 + " s";
                        }
                        textView3.setText(str2);
                        a.this.i++;
                        if (TextUtils.isEmpty(strA2) || !strA2.equals("1")) {
                            return;
                        }
                        HashMap map2 = new HashMap();
                        map2.put("type", "choseFromTwoHeartbeat");
                        map2.put("xtSecond", a.this.i + "");
                        map2.put("autoPlayCountDownTime", a.this.m + "");
                        com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx5, map2);
                    }

                    @Override // com.mbridge.msdk.video.dynview.i.c.a
                    public final void a() {
                        a.b(a.this, map);
                    }
                };
                com.mbridge.msdk.video.dynview.i.c.b bVarA = new com.mbridge.msdk.video.dynview.i.c.b().b(j2 * 1000).a(1000L).a(this.k);
                this.f2500b = bVarA;
                bVarA.a();
            }
            ImageView imageView6 = (ImageView) view.findViewById(a(j, "mbridge_iv_link"));
            if (campaignEx2 != null) {
                if (campaignEx2.getAdchoice() != null) {
                    campaignEx2.getAdchoice().a("");
                }
                af.a(4, imageView6, campaignEx2, com.mbridge.msdk.foundation.controller.b.d().g(), false, new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.video.dynview.j.a.3
                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void a() {
                        if (a.this.f2500b != null) {
                            a.this.f2500b.b();
                            a.this.l = true;
                        }
                    }

                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void b() {
                        if (!a.this.l || a.this.f2500b == null) {
                            return;
                        }
                        a.this.f2500b.a(a.this.m * 1000, a.this.k);
                        a.this.l = false;
                    }

                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void a(String str2) {
                        if (!a.this.l || a.this.f2500b == null) {
                            return;
                        }
                        a.this.f2500b.a(a.this.m * 1000, a.this.k);
                        a.this.l = false;
                    }
                });
            }
        } else {
            imageView3 = imageView3;
        }
        if (cVar != null && imageView3 != null) {
            if (cVar.e() == 1) {
                imageView3.setImageResource(t.a(context.getApplicationContext(), com.mbridge.msdk.video.dynview.i.a.a(context, 1), "drawable"));
            } else {
                imageView3.setImageResource(t.a(context.getApplicationContext(), com.mbridge.msdk.video.dynview.i.a.a(context, 2), "drawable"));
            }
        }
        if (eVar != null) {
            eVar.a(view, null);
        }
    }

    public final void b(com.mbridge.msdk.video.dynview.c cVar, View view, Map map, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            j = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        boolean z = j;
        LinearLayout linearLayout = z ? (LinearLayout) view.findViewById(a(z, "mbridge_reward_heat_mllv")) : null;
        ImageView imageView = (ImageView) view.findViewById(a(j, "mbridge_reward_icon_riv"));
        TextView textView = (TextView) view.findViewById(a(j, "mbridge_reward_title_tv"));
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(a(j, "mbridge_reward_stars_mllv"));
        TextView textView2 = (TextView) view.findViewById(a(j, "mbridge_reward_click_tv"));
        ImageView imageView2 = (ImageView) view.findViewById(a(j, "mbridge_videoview_bg"));
        TextView textView3 = (TextView) view.findViewById(a(j, "mbridge_reward_desc_tv"));
        List<View> arrayList = new ArrayList<>();
        List<CampaignEx> listG = cVar.g();
        if (listG != null && listG.size() > 0) {
            CampaignEx campaignEx = listG.get(0);
            if (campaignEx != null) {
                if (imageView != null) {
                    if (j) {
                        if (imageView instanceof MBCusRoundImageView) {
                            ((MBCusRoundImageView) imageView).setCustomBorder(30, 30, 30, 30, 10, -1);
                        }
                    } else {
                        ((RoundImageView) imageView).setBorderRadius(10);
                    }
                    a(campaignEx.getIconUrl(), imageView);
                }
                if (textView != null) {
                    textView.setText(campaignEx.getAppName());
                }
                if (textView3 != null) {
                    textView3.setText(campaignEx.getAppDesc());
                }
                if (linearLayout2 != null) {
                    double rating = campaignEx.getRating();
                    if (rating <= 0.0d) {
                        rating = 5.0d;
                    }
                    if (j) {
                        if (linearLayout2 != null && (linearLayout2 instanceof MBStarLevelLayoutView)) {
                            MBStarLevelLayoutView mBStarLevelLayoutView = (MBStarLevelLayoutView) linearLayout2;
                            mBStarLevelLayoutView.setRating((int) rating);
                            mBStarLevelLayoutView.setOrientation(0);
                        }
                        if (linearLayout != null && (linearLayout instanceof MBHeatLevelLayoutView)) {
                            ((MBHeatLevelLayoutView) linearLayout).setHeatCount(campaignEx.getNumberRating());
                        }
                    } else {
                        ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, campaignEx.getNumberRating());
                    }
                }
                if (textView2 != null) {
                    textView2.setText(campaignEx.getAdCall());
                }
                int iH = cVar.h();
                if (iH == 102 || iH == 202 || iH == 302) {
                    if (textView2 != null) {
                        arrayList.add(textView2);
                    }
                } else if (iH != 802) {
                    if (iH == 904 && cVar.k()) {
                        arrayList.add(view);
                    }
                } else {
                    if (imageView != null) {
                        arrayList.add(imageView);
                    }
                    if (textView2 != null) {
                        arrayList.add(textView2);
                    }
                    a(imageView2, campaignEx.getImageUrl(), iH);
                }
                eVar.a(view, arrayList);
                return;
            }
            eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
            return;
        }
        eVar.a(com.mbridge.msdk.video.dynview.c.a.CAMPAIGNEX_IS_NULL);
    }

    public final void a(com.mbridge.msdk.video.dynview.c cVar, View view, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            return;
        }
        try {
            ImageView imageView = (ImageView) view.findViewById(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_iv_adbanner_bg", "id"));
            if (imageView != null) {
                imageView.setBackgroundColor(Color.parseColor(this.h));
            }
            ImageView imageView2 = (ImageView) view.findViewById(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), "mbridge_iv_adbanner", "id"));
            if (imageView2 != null) {
                imageView2.setBackgroundColor(Color.parseColor(this.h));
            }
            eVar.a(view, new ArrayList());
        } catch (Exception e) {
            aa.a("DataEnergizeWrapper", e.getMessage());
            eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
        }
    }

    public final void c(com.mbridge.msdk.video.dynview.c cVar, View view, final Map map, e eVar) {
        try {
            if (this.c == null) {
                this.c = new HashMap();
            }
            final List<CampaignEx> listG = cVar.g();
            if (view.getContext() == null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                j = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            ListView listView = (ListView) view.findViewById(a(j, "mbridge_order_view_lv"));
            GridView gridView = (GridView) view.findViewById(a(j, "mbridge_order_view_h_lv"));
            ImageView imageView = (ImageView) view.findViewById(a(j, "mbridge_order_view_iv_close"));
            com.mbridge.msdk.video.dynview.ordercamp.a.a aVar = new com.mbridge.msdk.video.dynview.ordercamp.a.a(listG);
            if (cVar.e() == 1) {
                if (listView != null) {
                    if (listView != null && cVar != null) {
                        try {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) listView.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.height = -1;
                                float fC = (cVar.c() - af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 720.0f)) / 2.0f;
                                int iB = af.b(com.mbridge.msdk.foundation.controller.b.d().g(), 10.0f);
                                int i = (int) fC;
                                layoutParams.setMargins(iB, i, iB, i);
                                listView.setLayoutParams(layoutParams);
                            }
                        } catch (Exception e) {
                            aa.d("DataEnergizeWrapper", e.getMessage());
                        }
                    }
                    listView.setAdapter((ListAdapter) aVar);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mbridge.msdk.video.dynview.j.a.6
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
                            a.a(a.this, map, listG, i2);
                        }
                    });
                }
            } else if (gridView != null) {
                int iD = (int) cVar.d();
                int size = iD / listG.size();
                int i2 = size / 9;
                int i3 = i2 / 2;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams2.width = iD - (i2 * 2);
                gridView.setLayoutParams(layoutParams2);
                gridView.setColumnWidth((size - i2) - (i3 / 2));
                gridView.setHorizontalSpacing(i3);
                gridView.setStretchMode(0);
                gridView.setNumColumns(listG.size());
                gridView.setAdapter((ListAdapter) aVar);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mbridge.msdk.video.dynview.j.a.7
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view2, int i4, long j2) {
                        a.a(a.this, map, listG, i4);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.dynview.j.a.8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        a.a(a.this, map);
                    }
                });
            }
            if (eVar != null) {
                eVar.a(view, null);
            }
        } catch (Exception unused) {
            if (eVar != null) {
                eVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            }
        }
    }

    private void a(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        a(imageView, str, -1);
    }

    private void a(ImageView imageView, String str, int i) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new AnonymousClass9(i, imageView));
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.video.dynview.j.a$9, reason: invalid class name */
    /* JADX INFO: compiled from: DataEnergizeWrapper.java */
    final class AnonymousClass9 implements com.mbridge.msdk.foundation.same.c.c {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f2509b;

        AnonymousClass9(int i, ImageView imageView) {
            this.a = i;
            this.f2509b = imageView;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(final Bitmap bitmap, String str) {
            if (bitmap != null && !bitmap.isRecycled()) {
                int i = this.a;
                if (i == 501 || i == 802) {
                    com.mbridge.msdk.foundation.same.f.b.d().execute(new Runnable() { // from class: com.mbridge.msdk.video.dynview.j.a.9.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                final Bitmap bitmapA = l.a(bitmap, 10);
                                AnonymousClass9.this.f2509b.post(new Runnable() { // from class: com.mbridge.msdk.video.dynview.j.a.9.1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        AnonymousClass9.this.f2509b.setImageBitmap(bitmapA);
                                    }
                                });
                            } catch (Exception e) {
                                aa.d("DataEnergizeWrapper", e.getMessage());
                            }
                        }
                    });
                    return;
                } else {
                    this.f2509b.setImageBitmap(bitmap);
                    return;
                }
            }
            int iA = t.a(this.f2509b.getContext(), "mbridge_icon_play_bg", "drawable");
            this.f2509b.setBackgroundColor(Color.parseColor(a.this.g));
            this.f2509b.setImageResource(iA);
            this.f2509b.setScaleType(ImageView.ScaleType.CENTER);
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            try {
                int iA = t.a(this.f2509b.getContext(), "mbridge_icon_play_bg", "drawable");
                this.f2509b.setBackgroundColor(Color.parseColor(a.this.g));
                this.f2509b.setImageResource(iA);
                this.f2509b.setScaleType(ImageView.ScaleType.CENTER);
            } catch (Exception e) {
                aa.a("DataEnergizeWrapper", e.getMessage());
            }
        }
    }

    private void a(final String str, final ImageView imageView, final com.mbridge.msdk.video.dynview.c cVar, final View view) {
        com.mbridge.msdk.foundation.same.c.b.a(imageView.getContext()).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.video.dynview.j.a.10
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                ImageView imageView2;
                if (bitmap == null || bitmap.isRecycled() || (imageView2 = imageView) == null) {
                    return;
                }
                imageView2.setImageBitmap(bitmap);
                if (a.this.c != null) {
                    a.this.c.put(SameMD5.getMD5(str), bitmap);
                    a.a(a.this, cVar, view);
                }
            }
        });
        try {
            Bitmap bitmapA = a();
            if (bitmapA == null || bitmapA.isRecycled()) {
                return;
            }
            a(cVar, view);
        } catch (Exception e) {
            aa.d("DataEnergizeWrapper", e.getMessage());
        }
    }

    private int a(boolean z, String str) {
        try {
            if (z) {
                if (TextUtils.isEmpty(str)) {
                    return -1;
                }
                return str.hashCode();
            }
            return t.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, "id");
        } catch (Exception e) {
            aa.d("DataEnergizeWrapper", e.getMessage());
            return -1;
        }
    }

    private Bitmap a() {
        Bitmap bitmapCreateBitmap = null;
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
            bitmapCreateBitmap.eraseColor(Color.parseColor(this.h));
            return bitmapCreateBitmap;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return bitmapCreateBitmap;
            }
            e.printStackTrace();
            return bitmapCreateBitmap;
        }
    }

    private void a(com.mbridge.msdk.video.dynview.c cVar, View view) {
        com.mbridge.msdk.video.dynview.g.a.C0517a c0517aA = com.mbridge.msdk.video.dynview.g.a.a();
        c0517aA.a(cVar.e()).a(true);
        if (cVar.e() != 2 || cVar.d() > cVar.c()) {
            c0517aA.a(cVar.d()).b(cVar.c());
        } else {
            c0517aA.a(cVar.c()).b(cVar.d());
        }
        if (view.getBackground() == null) {
            view.setBackground(c0517aA.a());
        }
    }

    private void b() {
        com.mbridge.msdk.video.dynview.i.a.a.a().b();
        com.mbridge.msdk.video.dynview.i.c.b bVar = this.f2500b;
        if (bVar != null) {
            bVar.b();
            this.f2500b = null;
        }
        com.mbridge.msdk.video.dynview.b.a.a().a = null;
        if (this.a != null) {
            this.a = null;
        }
        Map<String, Bitmap> map = this.c;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.c.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Bitmap> next = it.next();
                        if (next != null && next.getValue() != null && !next.getValue().isRecycled()) {
                            next.getValue().recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.c.clear();
        }
    }

    static /* synthetic */ void a(a aVar, Map map, List list, int i) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof d)) {
            d dVar = (d) map.get("choice_one_callback");
            if (dVar != null) {
                dVar.a((CampaignEx) list.get(i));
                try {
                    CampaignEx campaignEx = (CampaignEx) list.get(i);
                    HashMap map2 = new HashMap();
                    map2.put("click", "0");
                    map2.put("time", aVar.i + "");
                    map2.put("choose_cid", campaignEx.getId());
                    map2.put("position", i + "");
                    map2.put("type", "choseFromTwoSelect");
                    com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx, map2);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            aVar.b();
            return;
        }
        if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
            com.mbridge.msdk.video.dynview.e.c cVar = (com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback");
            if (cVar != null) {
                cVar.a((CampaignEx) list.get(i), i);
            }
            aVar.b();
        }
    }

    static /* synthetic */ void a(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("order_view_callback") && (map.get("order_view_callback") instanceof com.mbridge.msdk.video.dynview.e.c)) {
                    ((com.mbridge.msdk.video.dynview.e.c) map.get("order_view_callback")).a();
                    aVar.b();
                }
            } catch (Exception e) {
                aa.d("DataEnergizeWrapper", e.getMessage());
            }
        }
    }

    static /* synthetic */ void a(a aVar, com.mbridge.msdk.video.dynview.c cVar, View view) {
        Map<String, Bitmap> map = aVar.c;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.mbridge.msdk.video.dynview.h.b();
        Map<String, Bitmap> map2 = aVar.c;
        if (view != null) {
            com.mbridge.msdk.video.dynview.i.a.a.a().a(map2, cVar, view);
        }
    }

    static /* synthetic */ void b(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey("choice_one_callback") && (map.get("choice_one_callback") instanceof d)) {
                    ((d) map.get("choice_one_callback")).a();
                    aVar.b();
                }
            } catch (Exception e) {
                aa.d("DataEnergizeWrapper", e.getMessage());
            }
        }
    }
}
