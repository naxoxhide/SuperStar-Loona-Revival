package com.fyber.inneractive.sdk.external;

/* JADX INFO: loaded from: classes2.dex */
public class ImpressionData {
    public Pricing a = new Pricing();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Video f905b;
    public String c;
    public Long d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public static class Pricing {
        public double a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f906b;

        public String getCurrency() {
            return this.f906b;
        }

        public double getValue() {
            return this.a;
        }

        public void setValue(double d) {
            this.a = d;
        }

        public String toString() {
            return "Pricing{value=" + this.a + ", currency='" + this.f906b + "'}";
        }
    }

    public static class Video {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f907b;

        public Video(boolean z, long j) {
            this.a = z;
            this.f907b = j;
        }

        public long getDuration() {
            return this.f907b;
        }

        public boolean isSkippable() {
            return this.a;
        }

        public String toString() {
            return "Video{skippable=" + this.a + ", duration=" + this.f907b + '}';
        }
    }

    public String getAdvertiserDomain() {
        return this.i;
    }

    public String getCampaignId() {
        return this.h;
    }

    public String getCountry() {
        return this.e;
    }

    public String getCreativeId() {
        return this.g;
    }

    public Long getDemandId() {
        return this.d;
    }

    public String getDemandSource() {
        return this.c;
    }

    public String getImpressionId() {
        return this.f;
    }

    public Pricing getPricing() {
        return this.a;
    }

    public Video getVideo() {
        return this.f905b;
    }

    public void setAdvertiserDomain(String str) {
        this.i = str;
    }

    public void setCampaignId(String str) {
        this.h = str;
    }

    public void setCountry(String str) {
        this.e = str;
    }

    public void setCpmValue(String str) {
        double d;
        try {
            d = Double.parseDouble(str);
        } catch (Exception unused) {
            d = 0.0d;
        }
        this.a.a = d;
    }

    public void setCreativeId(String str) {
        this.g = str;
    }

    public void setCurrency(String str) {
        this.a.f906b = str;
    }

    public void setDemandId(Long l) {
        this.d = l;
    }

    public void setDemandSource(String str) {
        this.c = str;
    }

    public void setDuration(long j) {
        this.f905b.f907b = j;
    }

    public void setImpressionId(String str) {
        this.f = str;
    }

    public void setPricing(Pricing pricing) {
        this.a = pricing;
    }

    public void setVideo(Video video) {
        this.f905b = video;
    }

    public String toString() {
        return "ImpressionData{pricing=" + this.a + ", video=" + this.f905b + ", demandSource='" + this.c + "', country='" + this.e + "', impressionId='" + this.f + "', creativeId='" + this.g + "', campaignId='" + this.h + "', advertiserDomain='" + this.i + "'}";
    }
}
