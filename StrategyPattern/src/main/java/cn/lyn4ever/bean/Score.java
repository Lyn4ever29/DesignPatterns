package cn.lyn4ever.bean;

/**
 * 成绩对象
 */
public class Score {
    //成绩
    private int score;
    //是否使用app消息通知，使用0表示否，1表示是。下同
    private int sendAPPMsg;
    //是否使用短信通知
    private int sendSms;
    //是否使用邮件通知
    private int sendMail;
    //是否使用站内消息通知
    private int siteMsg;

    //其他的一些非主要属性不再此加入，比如手机号，邮箱号等

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSendAPPMsg() {
        return sendAPPMsg;
    }

    public void setSendAPPMsg(int sendAPPMsg) {
        this.sendAPPMsg = sendAPPMsg;
    }

    public int getSendSms() {
        return sendSms;
    }

    public void setSendSms(int sendSms) {
        this.sendSms = sendSms;
    }

    public int getSendMail() {
        return sendMail;
    }

    public void setSendMail(int sendMail) {
        this.sendMail = sendMail;
    }

    public int getSiteMsg() {
        return siteMsg;
    }

    public void setSiteMsg(int siteMsg) {
        this.siteMsg = siteMsg;
    }
}
