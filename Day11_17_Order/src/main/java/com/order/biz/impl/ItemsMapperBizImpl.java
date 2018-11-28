package com.order.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.order.biz.ItemsMapperBiz;
import com.order.dao.ItemsMapper;
import com.order.entity.Items;
import com.order.entity.QueryVo;
@Service("itemsMapperBizImpl")
public class ItemsMapperBizImpl implements ItemsMapperBiz{
	@Resource(name="itemsMapper")
	private ItemsMapper im;
	public int deleteByPrimaryKey(Integer id) {
		return im.deleteByPrimaryKey(id);
	}

	public int insert(Items record) {
		return im.insert(record);
	}

	public int insertSelective(Items record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Items selectByPrimaryKey(Integer id) {
		return im.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Items record) {
		return im.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(Items record) {
		return im.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(Items record) {
		return im.updateByPrimaryKey(record);
	}

	public List<Items> selectAllItems() {
		return im.selectAllItems();
	}

	public boolean delItems(String[] ids) {
		int row = 0; // 受影响的函数
		int count = 0;// 计数
		for (int i = 0; i < ids.length; i++) {
			row = im.deleteByPrimaryKey(new Integer(ids[i]));
			if (row > 0) {
				count++;
			}
		}
		return (count == ids.length) ? true : false;
	}

	public boolean updateItems( QueryVo queryVo,String[] ids) {
		int count = 0;// 修改的次数
		// 根据id筛选出 你要修改的对象
		List<Items> itemlist = queryVo.getItemsList();
		for (int i = 0; i < itemlist.size(); i++) {
			for (int j = 0; j < ids.length; j++) {
				Integer id = new Integer(ids[j]);
				if (id.equals(itemlist.get(i).getId())) {
					// 执行修改操作
					int row = im.updateByPrimaryKeySelective(itemlist.get(i));
					if (row > 0) {
						count++;
					}
				}
			}
		}
		return (count == ids.length) ? true : false;
	}

}
