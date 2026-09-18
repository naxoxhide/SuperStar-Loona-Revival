package com.tnkfactory.ad.pub.model;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class Vdo_iconsVO {
    public String duration;
    public String height;
    public ArrayList<String> icon_click_tracking_url;
    public String icon_click_url;
    public String icon_url;
    public ArrayList<String> icon_view_tracking_url;
    public String offset;
    public String program;
    public String width;
    public String xPosition;
    public String yPosition;

    public void parser(HashMap<String, Object> map) {
        this.xPosition = (String) map.get("xPosition");
        this.duration = (String) map.get("duration");
        this.icon_url = (String) map.get(CampaignEx.JSON_KEY_ICON_URL);
        this.icon_click_tracking_url = new ArrayList<>();
        Object obj = map.get("icon_click_tracking_url");
        if (obj != null) {
            try {
                for (Object obj2 : (Object[]) obj) {
                    this.icon_click_tracking_url.add((String) obj2);
                }
            } catch (Exception unused) {
            }
        }
        this.icon_view_tracking_url = new ArrayList<>();
        Object obj3 = map.get("icon_view_tracking_url");
        if (obj3 != null) {
            try {
                for (Object obj4 : (Object[]) obj3) {
                    this.icon_view_tracking_url.add((String) obj4);
                }
            } catch (Exception unused2) {
            }
        }
        this.offset = (String) map.get("offset");
        this.icon_click_url = (String) map.get("icon_click_url");
        this.yPosition = (String) map.get("yPosition");
        this.width = (String) map.get("width");
        this.program = (String) map.get("program");
        this.height = (String) map.get("height");
    }
}
