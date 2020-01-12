package netris.sync.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// import org.hibernate.annotations.TypeDef;

// @Entity
public class CameraAssembled {

    // @Id
    private Integer id;
    private String urlType;
    private String videoUrl;
    private String value;
    private Integer ttl;
    // @JsonIgnore
    // private String sourceDataUrl;
    // @JsonIgnore
    // private String tokenDataUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    // public String getSourceDataUrl() {
    //     return sourceDataUrl;
    // }

    // public void setSourceDataUrl(String sourceDataUrl) {
    //     this.sourceDataUrl = sourceDataUrl;
    // }

    // public String getTokenDataUrl() {
    //     return tokenDataUrl;
    // }

    // public void setTokenDataUrl(String tokenDataUrl) {
    //     this.tokenDataUrl = tokenDataUrl;
    // }

}
