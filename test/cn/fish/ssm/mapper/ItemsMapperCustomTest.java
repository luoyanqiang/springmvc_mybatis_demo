package cn.fish.ssm.mapper;

import cn.fish.ssm.po.ItemsCustom;
import cn.fish.ssm.po.ItemsQueryVo;
import org.junit.Before;
import org.junit.Test;
import cn.fish.ssm.service.impl.ItemsServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ItemsMapperCustomTest {

    private ItemsServiceImpl itemsServiceImpl;

    @Before
    public void setUp() throws Exception {
        // new ClassPathXmlApplicationContext("")
    }

    @Test
    public void findItemsList() throws Exception {
        ItemsServiceImpl itemsService = new ItemsServiceImpl();
        ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
        ItemsCustom items = new ItemsCustom();
        items.setName("鞋");
        itemsQueryVo.setItems(items);
        List list = itemsService.findItemsList(itemsQueryVo);
        System.out.println(list);
    }
}