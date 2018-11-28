package com.order.biz;

import java.util.List;

import com.order.entity.Items;
import com.order.entity.QueryVo;

public interface ItemsMapperBiz {
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
    
    List<Items> selectAllItems();
    /**
     * 
     * @Title: delItems   
     * @Description: TODO(批量删除)   
     * @param: @param ids
     * @param: @return      
     * @return: boolean      
     * @throws
     */
    public boolean delItems(String[] ids);
    /**
     * 
     * @Title: updateItems   
     * @Description: TODO(批量修改)   
     * @param: @param ids
     * @param: @param queryVo
     * @param: @return      
     * @return: boolean      
     * @throws
     */
    public boolean updateItems(QueryVo queryVo,String[] ids) ;
}