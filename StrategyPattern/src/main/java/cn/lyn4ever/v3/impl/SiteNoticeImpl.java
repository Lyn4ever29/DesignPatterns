package cn.lyn4ever.v3.impl;

import cn.lyn4ever.v3.INotice;

public class SiteNoticeImpl implements INotice {
    @Override
    public void notice() {
        System.out.println("进行站内消息通知");
    }
}
