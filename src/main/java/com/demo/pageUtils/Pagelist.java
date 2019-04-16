package com.demo.pageUtils;

import java.util.List;
import java.util.Map;

public interface Pagelist {

    List<Map<String, Object>> getPageList(int pageIndex, int pageSize, List<Map<String, Object>> list);
}
