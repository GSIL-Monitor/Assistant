package com.rongzi.assistant.service;

import com.rongzi.assistant.model.WechatParam;

public interface WechatService {

    /**
     * 添加好友
     *
     * @param wechatParam
     * @return
     */
    int addFriend(WechatParam wechatParam);

    /**
     * 更新微信好友状态
     * @param wechatParam
     */
    void updateFriendStatus(WechatParam wechatParam);
}
