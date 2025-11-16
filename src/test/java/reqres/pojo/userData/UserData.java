package reqres.pojo.userData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserData {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<Data> data;
    private Support support;
    private Meta _meta;


    public UserData() {
    }

    public UserData(Integer page, Meta _meta, Support support, List<Data> data, Integer total_pages, Integer total, Integer per_page) {
        this.page = page;
        this._meta = _meta;
        this.support = support;
        this.data = data;
        this.total_pages = total_pages;
        this.total = total;
        this.per_page = per_page;
    }

    @Override
    public String toString() {
        return "UserData{" +
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

