package com.example.busproject;

/**
 * Created by 한국정보기술 on 2016-08-04.
 */
public class BusVO {
    private String busRouteId ;
    private String busRoutNm;
    private String routeType;

    public BusVO()
    {}

    public BusVO(String busRouteId, String busRoutNm, String routeType) {
        this.busRouteId = busRouteId;
        this.busRoutNm = busRoutNm;
        this.routeType = routeType;
    }

    public String getBusRouteId() {
        return busRouteId;
    }

    public void setBusRouteId(String busRouteId) {
        this.busRouteId = busRouteId;
    }

    public String getBusRoutNm() {
        return busRoutNm;
    }

    public void setBusRoutNm(String busRoutNm) {
        this.busRoutNm = busRoutNm;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }
}
