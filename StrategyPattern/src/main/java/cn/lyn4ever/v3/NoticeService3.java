package cn.lyn4ever.v3;

public class NoticeService3 {
    /**
     * 只提供一个通知方法，参数为通知接口
     * @param iNotice
     */
    public void notice(INotice iNotice) {
        iNotice.notice();
    }
}
