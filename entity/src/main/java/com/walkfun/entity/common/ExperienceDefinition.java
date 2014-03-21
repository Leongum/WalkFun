package com.walkfun.entity.common;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-22
 * Time: 上午10:31
 * To change this template use File | Settings | File Templates.
 */
public class ExperienceDefinition {

    private Double level;
    private Integer experience;
    private Integer totalExperience;
    private String title;
    private String titlePic;

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Integer totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitlePic() {
        return titlePic;
    }

    public void setTitlePic(String titlePic) {
        this.titlePic = titlePic;
    }
}
