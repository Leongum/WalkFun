package com.usavich.entity.mission;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 6:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class MissionPlacePackage {

    private Integer packageId;
    private String placeName;
    private String placePoint;
    private String sequence;

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlacePoint() {
        return placePoint;
    }

    public void setPlacePoint(String placePoint) {
        this.placePoint = placePoint;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
