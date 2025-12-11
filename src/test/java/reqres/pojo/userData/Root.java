package reqres.pojo.userData;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Root {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data;
    private Support support;
    private Meta _meta;

    public Root() {
    }

    public Root(int page, int per_page, int total, int total_pages, List<Data> data, Support support, Meta _meta) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
        this._meta = _meta;
    }

    @Override
    public String toString() {
        return "Root{" +
                "page=" + page +
                ", per_page=" + per_page +
                ", total=" + total +
                ", total_pages=" + total_pages +
                ", data=" + data +
                ", support=" + support +
                ", _meta=" + _meta +
                '}';
    }
}
