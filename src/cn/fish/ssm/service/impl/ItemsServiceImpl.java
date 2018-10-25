package cn.fish.ssm.service.impl;

import cn.fish.ssm.mapper.ItemsMapper;
import cn.fish.ssm.mapper.ItemsMapperCustom;
import cn.fish.ssm.po.Items;
import cn.fish.ssm.po.ItemsCustom;
import cn.fish.ssm.po.ItemsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import cn.fish.ssm.service.ItemsService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {

        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public Integer updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        Integer rs = itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
        return rs;
    }

    @Override
    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom = new ItemsCustom();
        copyProperties(items, itemsCustom);

        return itemsCustom;
    }
}
