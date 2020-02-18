package cn.lyn4ever.v3;


import cn.lyn4ever.bean.Score;
import cn.lyn4ever.v3.impl.AppNoticeImpl;
import cn.lyn4ever.v3.impl.MailNoticeImpl;
import cn.lyn4ever.v3.impl.SiteNoticeImpl;
import cn.lyn4ever.v3.impl.SmsNoticeImpl;

public class NoticeDemo3 {

    public void sendNotice(Score score) {
        NoticeService3 noticeService = new NoticeService3();

        if (score.getScore() >= 60) {
            if (score.getSendAPPMsg() == 1) {
                noticeService.notice(new AppNoticeImpl());
            }
            if (score.getSendSms() == 1) {
                noticeService.notice(new SmsNoticeImpl());
            }
            if (score.getSendMail() == 1) {
                noticeService.notice(new MailNoticeImpl());
            }
            if (score.getSiteMsg() == 1) {
                noticeService.notice(new SiteNoticeImpl());
            }
        }
    }
}
