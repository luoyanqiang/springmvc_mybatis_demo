package cn.fish.ssm.mapper;

import cn.fish.ssm.po.Items;
import cn.fish.ssm.po.ItemsExample;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ItemsMapperTest {

    private ItemsMapper itemsMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        itemsMapper = (ItemsMapper) context.getBean("itemsMapper");
    }

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExampleWithBLOBs() {
    }

    @Test
    public void selectByExample() {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andNameLike("%鞋%");

        List list = itemsMapper.selectByExample(itemsExample);
        System.out.println(list);
    }

    @Test
    public void selectByPrimaryKey() {
        Items items = itemsMapper.selectByPrimaryKey(2);
        System.out.println(items);
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExampleWithBLOBs() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}