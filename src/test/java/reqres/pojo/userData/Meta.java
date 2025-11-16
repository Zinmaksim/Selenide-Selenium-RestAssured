package reqres.pojo.userData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Meta {
    private String powered_by;
    private String upgrade_url;
    private String docs_url;
    private String template_gallery;
    private String message;
    private List<String> features;
    private String upgrade_cta;

    public Meta(String powered_by, String upgrade_url, String docs_url, String template_gallery, String message, List<String> features, String upgrade_cta) {
        this.powered_by = powered_by;
        this.upgrade_url = upgrade_url;
        this.docs_url = docs_url;
        this.template_gallery = template_gallery;
        this.message = message;
        this.features = features;
        this.upgrade_cta = upgrade_cta;
    }

    public Meta() {
    }

    @Override
    public String toString() {
        return "{" +
                "powered_by='" + powered_by + '\'' +
                ", upgrade_url='" + upgrade_url + '\'' +
                ", docs_url='" + docs_url + '\'' +
                ", template_gallery='" + template_gallery + '\'' +
                ", message='" + message + '\'' +
                ", features=" + features +
                ", upgrade_cta='" + upgrade_cta + '\'' +
                '}';
    }
}
