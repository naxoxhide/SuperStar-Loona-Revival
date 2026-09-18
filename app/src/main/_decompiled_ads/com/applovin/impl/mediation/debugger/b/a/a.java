package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements Comparable<a> {
    private final b aon;
    private final List<b> aoo;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private final String f7do;
    private final MaxAdFormat format;
    private final String name;

    public a(JSONObject jSONObject, Map<String, com.applovin.impl.mediation.debugger.b.c.b> map, n nVar) {
        this.f7do = JsonUtils.getString(jSONObject, "name", "");
        this.name = JsonUtils.getString(jSONObject, "display_name", "");
        this.format = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "format", null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "waterfalls", new JSONArray());
        this.aoo = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                this.aoo.add(new b(jSONObject2, map, this.format, nVar));
            }
        }
        this.aon = this.aoo.isEmpty() ? null : this.aoo.get(0);
    }

    public String mQ() {
        return this.f7do;
    }

    public String getName() {
        return this.name;
    }

    public String tG() {
        MaxAdFormat maxAdFormat = this.format;
        return maxAdFormat != null ? maxAdFormat.getLabel() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public MaxAdFormat getFormat() {
        return this.format;
    }

    public b uG() {
        return this.aon;
    }

    public List<b> uH() {
        return this.aoo;
    }

    public String uI() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------- ").append(this.name).append(" ----------").append("\nIdentifier - ").append(this.f7do).append("\nFormat     - ").append(tG());
        return sb.toString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        return this.name.compareToIgnoreCase(aVar.name);
    }
}
