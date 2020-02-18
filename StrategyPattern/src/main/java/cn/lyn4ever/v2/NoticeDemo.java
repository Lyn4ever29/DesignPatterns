package cn.lyn4ever.v2;

import cn.lyn4ever.bean.Score;

/**
 * 进行分数判断是否通知的类
 */
public class NoticeDemo {
    /**
     * 处理是否进行通知的主要方法
     *
     * @param score
     */
    public void sendNotice(Score score) {
        NoticeService noticeService = new NoticeService();

        if (score.getScore() >= 60) {
            if (score.getSendAPPMsg() == 1) {
                //这里只需要写这一句就可以进行通知，而不像刚才那样，下同
                noticeService.sendAppNotice();
            }
            if (score.getSendSms() == 1) {
                noticeService.sendSms();
            }
            if (score.getSendMail() == 1) {
                noticeService.sendMail();
            }
            if (score.getSiteMsg() == 1) {
                noticeService.sendSiteMsg();
            }
        }
    }
}
