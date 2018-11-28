package com.order.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName:  QueryVo   
 * @Description:TODO(拓展类)   
 * @author: maple
 * @date:   2018年11月21日 下午2:36:06   
 *     
 * @Copyright: 2018 www.hwua.com Inc. All rights reserved.
 */
public class QueryVo {
		private Items items;
		private String[] ids;
		private List<Items> itemsList=new ArrayList<Items>();
		public Items getItems() {
			return items;
		}
		public void setItems(Items items) {
			this.items = items;
		}
		public String[] getIds() {
			return ids;
		}
		public void setIds(String[] ids) {
			this.ids = ids;
		}
		public List<Items> getItemsList() {
			return itemsList;
		}
		public void setItemsList(List<Items> itemsList) {
			this.itemsList = itemsList;
		}
		
}
