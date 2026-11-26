package com.shaoyi.messagewall;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    List<MessageInfo> messageInfoList = new ArrayList<>();
    @RequestMapping("/getlist")
    public List<MessageInfo> getList() {
        return messageInfoList;
    }


    @RequestMapping("/publish")
    public boolean publish(MessageInfo messageInfo){
        System.out.print(messageInfo);

        if(StringUtils.hasText(messageInfo.getFrom())
                && StringUtils.hasText(messageInfo.getTo())
                && StringUtils.hasText(messageInfo.getMessage())){
            messageInfoList.add(messageInfo);
            return true;
        }
        return false;
    }
}
