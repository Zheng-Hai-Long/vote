package com.vote.dao;

import com.vote.pojo.ActionFunction;
import com.vote.pojo.ActionUser;
import com.vote.pojo.vo.ActionFunctionVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

/**
 * Created by admin on 2017/11/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ActionFunctionMapperTest {

    private final Logger logger = LoggerFactory.getLogger(ActionFunctionMapperTest.class);
    @Autowired
    private ActionFunctionMapper actionFunctionMapper;

    @Test
    public void testFunctionEdit() throws Exception {
        ActionFunction actionFunction = actionFunctionMapper.functionEdit(1);
        logger.info("actionFuntion:{}",actionFunction);
    }

    @Test
    public void testQueryFunctionList(){
        ActionFunctionVO vo = new ActionFunctionVO();
        vo.setFunName("用户管理");
        List<ActionFunction> list = actionFunctionMapper.queryFunctionList(vo);
        logger.info("list:{}", list);
    }

    @Test
    public void testFunctionEditParentFun(){
        ActionFunction actionFunction = actionFunctionMapper.functionEditParentFun(1);
        logger.info("ActionFunction:{}", actionFunction);
    }

    @Test
    public void testSelectRoleFunList(){
        List<ActionFunction> list = actionFunctionMapper.selectRoleFunList();
        logger.info("list:{}", list);
    }

    @Test
    public void testIndexUserFunParam(){
        ActionUser user = new ActionUser();
        //user.set
        //List<ActionFunction> list = actionFunctionMapper.indexUserFunParam(user);
    }

    @Test
    public void testFunctionListTo(){
        List<ActionFunction> list = actionFunctionMapper.functionListTo(1);
        logger.info("list:{}", list);
    }

}