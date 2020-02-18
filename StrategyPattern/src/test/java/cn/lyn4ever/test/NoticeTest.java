package cn.lyn4ever.test;


import cn.lyn4ever.bean.Score;
import cn.lyn4ever.v1.IfDemo;
import cn.lyn4ever.v2.NoticeDemo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoticeTest {

    private Score score;

    @BeforeEach
    public void beforeTest(){
        score = new Score();
        score.setScore(95);
        score.setSendAPPMsg(1);
        score.setSendMail(1);
        score.setSendSms(1);
        score.setSiteMsg(1);
    }

    @Test
    public void ifDemoTest() {
        IfDemo ifDemo = new IfDemo();
        ifDemo.sendNotice(score);
    }

    @Test
    public void noticeDemoTest(){
        NoticeDemo noticeDemo = new NoticeDemo();
        noticeDemo.sendNotice(score);
    }
}
