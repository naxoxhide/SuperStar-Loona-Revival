package com.applovin.impl.adview;

import android.webkit.WebSettings;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class y {
    private final JSONObject aiq;

    public y(JSONObject jSONObject) {
        this.aiq = jSONObject;
    }

    Integer si() {
        String string = JsonUtils.getString(this.aiq, "mixed_content_mode", null);
        if (StringUtils.isValidString(string)) {
            if ("always_allow".equalsIgnoreCase(string)) {
                return 0;
            }
            if ("never_allow".equalsIgnoreCase(string)) {
                return 1;
            }
            if ("compatibility_mode".equalsIgnoreCase(string)) {
                return 2;
            }
        }
        return null;
    }

    WebSettings.PluginState sj() {
        String string = JsonUtils.getString(this.aiq, "plugin_state", null);
        if (StringUtils.isValidString(string)) {
            if ("on".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON_DEMAND;
            }
            if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equalsIgnoreCase(string)) {
                return WebSettings.PluginState.OFF;
            }
        }
        return null;
    }

    Boolean sk() {
        return JsonUtils.getBoolean(this.aiq, "allow_file_access", null);
    }

    Boolean sl() {
        return JsonUtils.getBoolean(this.aiq, "load_with_overview_mode", null);
    }

    Boolean sm() {
        return JsonUtils.getBoolean(this.aiq, "use_wide_view_port", null);
    }

    Boolean sn() {
        return JsonUtils.getBoolean(this.aiq, "allow_content_access", null);
    }

    Boolean so() {
        return JsonUtils.getBoolean(this.aiq, "use_built_in_zoom_controls", null);
    }

    Boolean sp() {
        return JsonUtils.getBoolean(this.aiq, "display_zoom_controls", null);
    }

    Boolean sq() {
        return JsonUtils.getBoolean(this.aiq, "save_form_data", null);
    }

    Boolean sr() {
        return JsonUtils.getBoolean(this.aiq, "geolocation_enabled", null);
    }

    Boolean ss() {
        return JsonUtils.getBoolean(this.aiq, "need_initial_focus", null);
    }

    Boolean st() {
        return JsonUtils.getBoolean(this.aiq, "allow_file_access_from_file_urls", null);
    }

    Boolean su() {
        return JsonUtils.getBoolean(this.aiq, "allow_universal_access_from_file_urls", null);
    }

    Boolean sv() {
        return JsonUtils.getBoolean(this.aiq, "offscreen_pre_raster", null);
    }

    Boolean sw() {
        return JsonUtils.getBoolean(this.aiq, "algorithmic_darkening_allowed", null);
    }

    Boolean sx() {
        return JsonUtils.getBoolean(this.aiq, "loads_images_automatically", null);
    }

    Boolean sy() {
        return JsonUtils.getBoolean(this.aiq, "block_network_image", null);
    }
}
