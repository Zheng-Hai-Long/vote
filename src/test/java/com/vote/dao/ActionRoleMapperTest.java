package com.vote.dao;

import com.vote.pojo.ActionRole;
import com.vote.pojo.vo.ActionRoleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 2017/11/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ActionRoleMapperTest {

    private final Logger logger = LoggerFactory.getLogger(ActionRoleMapperTest.class);

    @Autowired
    private ActionRoleMapper actionRoleMapper;

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsertSelective() throws Exception {

    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }

    @Test
    public void testQueryRoleList() throws Exception {
        ActionRoleVO vo = new ActionRoleVO();
        List<ActionRole> list = actionRoleMapper.queryRoleList(vo);
        logger.info("list:{}", list);
    }

    @Test
    public void testRoleAdd() throws Exception {

    }

    @Test
    public void testRoleEdit() throws Exception {

    }

    @Test
    public void testRoleEditOk() throws Exception {

    }

    @Test
    public void testRoleDelete() throws Exception {

    }

    @Test
    public void testSelectRoleList() throws Exception {

    }
}