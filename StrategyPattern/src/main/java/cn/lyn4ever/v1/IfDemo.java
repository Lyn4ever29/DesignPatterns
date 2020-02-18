package cn.lyn4ever.v1;

import cn.lyn4ever.bean.Score;

/**
 * 使用常规的if-else操作
 */
public class IfDemo {

    /**
     * 使用if-else进行通知
     *
     * @param score 传入的分数对象
     */
    public void sendNotice(Score score) {

        if (score.getScore() >= 60) {
            if (score.getSendAPPMsg() == 1) {
                //这里是进行通知的具体实现，为了和后边形成更直接的对比，我加了好多代码
                System.out.println("进行app消息推送1");
                System.out.println("进行app消息推送2");
                System.out.println("进行app消息推送3");
                System.out.println("进行app消息推送4");
            }
            if (score.getSendSms() == 1) {
                System.out.println("进行短信通知1");
                System.out.println("进行短信通知2");
                System.out.println("进行短信通知3");
                System.out.println("进行短信通知4");
            }
            if (score.getSendMail() == 1) {
                System.out.println("进行邮件通知1");
                System.out.println("进行邮件通知2");
                System.out.println("进行邮件通知3");
                System.out.println("进行邮件通知4");
            }
            if (score.getSiteMsg() == 1) {
                System.out.println("进行站内消息通知1");
                System.out.println("进行站内消息通知2");
                System.out.println("进行站内消息通知3");
                System.out.println("进行站内消息通知4");
            }
        }
    }
}
