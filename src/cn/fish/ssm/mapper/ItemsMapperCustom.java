package cn.fish.ssm.mapper;

import cn.fish.ssm.po.ItemsCustom;
import cn.fish.ssm.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

}