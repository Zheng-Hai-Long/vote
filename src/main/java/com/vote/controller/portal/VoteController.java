package com.vote.controller.portal;

import com.vote.common.ServerResponse;
import com.vote.pojo.ActionFunction;
import com.vote.pojo.vo.ActionFunctionVO;
import com.vote.service.ActionFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 2017/11/19.
 */
@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private ActionFunctionService actionFunctionService;

    @RequestMapping(value = "/get_action_function_list", method = RequestMethod.GET)
    public ServerResponse<List<ActionFunction>> get_action_function_list(){
        ActionFunctionVO vo = new ActionFunctionVO();
        List<ActionFunction> list = actionFunctionService.queryFunctionList(vo);
        return ServerResponse.createBySuccess(list);
    }
}
