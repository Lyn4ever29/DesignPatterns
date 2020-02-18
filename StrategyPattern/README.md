##	策略模式
###	1.需求分析：
一个考试系统，当考生的成绩通过后（成绩大于60分）会通过各种方式通知用户。

* 通知方式有：APP消息推送、短信、邮件、站内消息四种方式；
* 但是每种方式是否进行通知是要进行在表中配置的；
* 假设我们从表中查询后的对象如下：

```java
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
    
    //get and set method
}
```

### 2.常规操作

* 最简单的就是使用if-else进行判断了。对每个配置条件进行判断，如果需要进行通知就进行通知

```java

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
```

对于每种通知方法，我只进行了一句简单的打印，实际中就会写上进行通知的方法

* Junit测试代码（与业务代码无关）

```java
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
}
```

 这样写没有任何问题，代码肯定是能跑起来的。但是，我们是直挂将每个通知的方法（也就是每种通知方法的具体实现）写在了上边代码中，如果要改的话我们就要对这里进行修改。所以我们进行一次优化，就是将上边的每一种通知代码进行一次方法抽取。

###	3.使用方法抽取进行优化

将上边的各个通知方法进行一次抽取，可以放在本类下，也可以将通知方法单独放在一个类中，我是放在了一个单独的类中。通知类有如下方法：

```java
/**
 * 通知类，
 */
public class NoticeService {
    
    public void sendAppNotice(){
        System.out.println("进行app推送通知1");
        System.out.println("进行app推送通知2");
        System.out.println("进行app推送通知3");
        System.out.println("进行app推送通知4");
    }

    public void sendSms(){
        System.out.println("进行短信通知1");
        System.out.println("进行短信通知2");
        System.out.println("进行短信通知3");
        System.out.println("进行短信通知4");
    }

    public void sendMail(){
        System.out.println("进行邮件通知1");
        System.out.println("进行邮件通知2");
        System.out.println("进行邮件通知3");
        System.out.println("进行邮件通知4");
    }

    public void sendSiteMsg(){
        System.out.println("进行站内消息通知1");
        System.out.println("进行站内消息通知2");
        System.out.println("进行站内消息通知3");
        System.out.println("进行站内消息通知4");
    }
}
```

* 这时的这个socre判断通知类如下：

```java
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
```

* 进行测试的方法

```java
@Test
public void noticeDemoTest(){
    NoticeDemo noticeDemo = new NoticeDemo();
    noticeDemo.sendNotice(score);
}
```

有小伙伴会问了，这样写的方法和上边没有任何区别啊？为什么要这么做？

* 这样的话就将整个通知方法的细节放在几个单独的方法中，只需要一句就可以调用通知方法了
* 而且当我们要修改通知方法的代码时，不用修改原来的方法啊

这种方式虽然将通知方法进行了单独的方法抽取，降低了一定的耦合。但是呢？

如果，我们有一个或多个新的通知方式要添加，比如微信、QQ。那你要改的地方是哪儿？

1.在Score的bean中添加两个字段，这个是必须的

2.在NoticeService中添加两个新的通知方法

```java
public void sendQQ(){
        System.out.println("进行QQ消息通知1");
        System.out.println("进行QQ消息通知2");
        System.out.println("进行QQ消息通知3");
        System.out.println("进行QQ消息通知4");
}
public void sendWX(){
        System.out.println("进行WX消息通知1");
        System.out.println("进行WX消息通知2");
        System.out.println("进行WX消息通知3");
        System.out.println("进行WX消息通知4");
}
```

3.在NoticeDemo中添加两个if判断

```java
if (score.getSendQQ() == 1) {
    noticeService.sendQQ();
}
if (score.getSendWX() == 1) {
    noticeService.sendWX();
}
```

### 3.使用策略模式进行优化

**策略模式（Strategy）**，定义了一组算法，将每个算法都封装起来，并且使它们之间可以互换

* 定义一个通知的接口

```
package cn.lyn4ever.v3;

public interface INotice {
    void notice();
}
```

* 写出它不同通知方式的不同实现(只写一个)

```java
public class AppNoticeImpl implements INotice {

    @Override
    public void notice() {
        System.out.println("进行app消息推送");
    }
}
```

* 通知的service方法如下：

```java
public class NoticeService3 {
    /**
     * 只提供一个通知方法，参数为通知接口
     * @param iNotice
     */
    public void notice(INotice iNotice) {
        iNotice.notice();
    }
}
```

* 利用分数判断的通知方法如下：

```java
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
```

* 有的小伙伴可能会认为这不是在重复造轮子吗？这和方法一、方法二让人更难理解

* 其实并不是在重复地造轮子，这样做就体现了面向对象开发的“封装”特性，相比第一种方法，更好地“面向对象”开发，而且封装了整个每一个通知方法的实现，降低了通知这个功能的耦合度，使得每一种通知方法有自己的实现。

* 比如上边的一个新需要，当我们需要新增“QQ”和“微信”通知的时候，这时只需要添加两个新的INotice的实现类，并在if条件中加两句就可以了，NoticeService类不用再次修改

  

  更多的设计模式学习，请关注我的微信公众号“小鱼与Java”

  ![更多的设计模式学习](https://lyn4ever.gitee.io/img/wx/gzh2.png)