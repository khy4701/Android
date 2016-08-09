package com.example.busproject;

/**
 * Created by 한국정보기술 on 2016-08-05.
 */
public class StationVO {

    private String beginTm;
    private String lastTm;
    private String stationNm;
    private String stationNo;
    private String sectionId;
    private boolean IsStop;

    public StationVO()
    {}

    public StationVO(String beginTm, String lastTm, String stationNm, String stationNo, String sectionId, boolean IsStop) {
        this.beginTm = beginTm;
        this.lastTm = lastTm;
        this.stationNm = stationNm;
        this.stationNo = stationNo;
        this.sectionId = sectionId;
        this.IsStop = IsStop;
    }

    public String getBeginTm() {
        return beginTm;
    }

    public void setBeginTm(String beginTm) {
        this.beginTm = beginTm;
    }

    public String getLastTm() {
        return lastTm;
    }

    public void setLastTm(String lastTm) {
        this.lastTm = lastTm;
    }

    public String getStationNm() {
        return stationNm;
    }

    public void setStationNm(String stationNm) {
        this.stationNm = stationNm;
    }

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public boolean getIsStop() {
        return IsStop;
    }

    public void setIsStop(boolean isStop) {
        IsStop = isStop;
    }
}
