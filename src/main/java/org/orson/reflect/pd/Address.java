package org.orson.reflect.pd;

public class Address {

    private String province;

    private String zone;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }
}
