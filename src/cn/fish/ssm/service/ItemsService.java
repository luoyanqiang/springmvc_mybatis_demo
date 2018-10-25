package cn.fish.ssm.service;

import cn.fish.ssm.po.Items;
import cn.fish.ssm.po.ItemsCustom;
import cn.fish.ssm.po.ItemsQueryVo;

import java.util.List;

public interface ItemsService {

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    public Integer updateItems(Integer id, ItemsCustom items) throws Exception;

    public ItemsCustom findItemsById(Integer id) throws  Exception;

}
