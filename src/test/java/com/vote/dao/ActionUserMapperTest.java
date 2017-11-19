package com.vote.dao;

import com.vote.pojo.ActionUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by admin on 2017/11/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ActionUserMapperTest {

    private final Logger logger = LoggerFactory.getLogger(ActionUserMapperTest.class);

    @Autowired
    private ActionUserMapper actionUserMapper;

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        ActionUser user = actionUserMapper.selectByPrimaryKey(1);
        logger.info("action_user:{}", user);
    }
}