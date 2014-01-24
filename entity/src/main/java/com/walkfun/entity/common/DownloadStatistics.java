package com.walkfun.entity.common;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-1-22
 * Time: 下午10:16
 * To change this template use File | Settings | File Templates.
 */
public class DownloadStatistics {

    private String platform;

    private Date downloadTime;

    private String version;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getDownloadTime() {
        return downloadTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
