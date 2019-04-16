package com.demo.pageUtils;
import java.io.Serializable;
import java.util.List;
public class PagingListBean<T>  implements PagingList<T> ,Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<T> items=null;
    private int total=0;

    public PagingListBean() {
        super();
    }
    public PagingListBean(List<T> items, int total) {
        super();
        this.items = items;
        this.total = total;
    }
    public List<T> getItems() {
        return items;
    }
    public void setItems(List<T> items) {
        this.items = items;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }



}
