package com.demo.pageUtils;

import java.util.List;

public interface PagingList<T> {
    public List<T> getItems();
    public int getTotal();
}
