package hello.Page;

import java.beans.Transient;

/**
 * Created by ELLLisa on 2017/6/21.
 */
public class PageHelperEntity {

    private Integer page = 1;
    private Integer rows = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
