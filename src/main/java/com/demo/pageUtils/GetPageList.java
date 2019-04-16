package com.demo.pageUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetPageList implements Pagelist {

    @Override
    public List<Map<String, Object>> getPageList(int pageIndex, int pageSize, List<Map<String, Object>> list) {
	int begin =(pageIndex-1)*pageSize;
	int end = begin+pageSize;
	if(end>list.size()){
		end= list.size();
	}
	List<Map<String, Object>> pagelist = new ArrayList<Map<String, Object>>();
	for (int i = begin; i < end; i++) {
		pagelist.add(list.get(i));
	}
	return pagelist;
    }


}
