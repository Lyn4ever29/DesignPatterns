#	[模板方法模式](https://github.com/Lyn4ever29/DesignPatterns/tree/master/TemplateMethod)

拿我们最熟悉的一个软件开发流程为例，进行一个项目开发，主要进行以下步骤：

产品经理进行需求分析——> UI设计原型图——>开发人员进行开发——>测试——>上线

可能不同的公司会有一点儿变化 ，但是这并不影响我们学习模板方法设设计模式。上边这个流程就是一个项目开发的流程模板，无认论什么样的项目，这个流程是不会变的。比如：不可能是先开发后进行UI设计，测试是不可能放在开发之前的。我们根据上边的模板，写出如下类：

```java
/**
 * 软件开发工厂
 */
public class ProductsFactory {

    private void analysisDemand() {
        System.out.println("需求分析");
    }

    private void pageDesign() {
        System.out.println("页面原型设计");
    }

    private void develop() {
        System.out.println("程序员进行开发");
    }

    private void test() {
        System.out.println("进行测试");
    }

    /**
     * 发行一个完整的项目
     */
    public void getProduct() {
        analysisDemand();
        pageDesign();
        develop();
        test();
    }
}
```

就这样，一个项目就完全生产成功了。但是，当一个新的项目来了之后，我们还是要按照这个流程再来一次，而且这个流程的顺序是不能变的。所以，面对不同的项目我们就要复制这个类，而且，它的getProduct()方法中的方法调用顺序不可改变。我们对上边这个类进行抽象一次，写出了如下类：

```java
package cn.lyn4ever;

/**
 * 软件流程的模板
 * <p>
 * 1. 这里使用的是抽象类而不是接口
 * 2. 在Jdk8及以后，接口中也可以不非抽象方法
 */
public abstract class ProductTemplate {

    abstract void analysisDemand();
    abstract void pageDesign();
    abstract void develop();
    abstract void test();

    /**
     * 发行一个完整的项目的流程
     */
    public void getProduct() {
        analysisDemand();
        pageDesign();
        develop();
        test();
    }
}
```

这时，当我们想要进行开发其它项目时，只需要继承这个抽象类，并实现自己对应的这四个方法，就可以了。虽然不同的项目，这四个步骤的具体实现不一样，但是它们的流程就是getProduct()中的方法。

> tips:

1. 这么做的好处是定义了一个特定而且不可变的算法骨架（本例中的软件开发流程）,子类只能对算法中的每一步进行修改，而不能修改算法的流程和走向。
2. 将每一步的实现都延迟到了子类中，如果要在这个流程中添加一个，只需要修改这个类中的getProduc()方法，让子类自己去实现。



# [门面模式(外观模式)](https://github.com/Lyn4ever29/DesignPatterns/tree/master/FacdePattern)

门面模式，又称外观模式，就是对外提供一个可访问的接口，而隐藏自身的实现。

这么说可能有点儿绕口，这个模式我们在开发中经常用到，只不过没有注意过罢了。比如在sprinbmvc项目中，controller对service层的方法，我们在service中利用dao层进行了一系列的操作，在controller层只需要方法这个方法就可以了。说最简单点儿，就是将复杂的代码抽象成一个公共的高可用的方法。

就比如上边的软件开发的例子中，当UI把产品原型图设计好了之后，会交给程序员来开发。但是，他并不会交给某个特定的程序员，只会交给技术主管，让技术主管来决定让谁来开发哪些页面或功能。技术主管就是所以程序员的“门面”，负责接待、分发、交付等职责。这个“门面”也不一定是领导，只要是能代表程序员这一个开发部门的人就可以。

我们可以设计出如下类：

```java
package cn.lyn4ever;

/**
 * 进行开发的程序员们
 */
public class Coder {

    private ClientCoder coderA;
    private ClientCoder coderB;

    private ServerCoder coderC;
    private ServerCoder coderD;

    public Coder(ClientCoder coderA, ClientCoder coderB, ServerCoder coderC, ServerCoder coderD) {
        this.coderA = coderA;
        this.coderB = coderB;
        this.coderC = coderC;
        this.coderD = coderD;
    }

    /**
     * 开发产品A
     */
    public void getProductA() {
        coderA.coding();
        coderB.coding();
        coderD.coding();
    }

    /**
     * 开发产品B
     */
    public void getProductB() {
        coderB.coding();
        coderC.coding();
    }
}
```

也就是说，产品经理只需要对接技术主管这个"Facde"就可以拿到这个产品，而不用去对接程序员。UML图如下：

![](https://gitee.com/lyn4ever/picgo-img/raw/master/img/20200220042904.png)

> ​	当然，产品经理也可有一个“门面”



#	二者的异同

相同之处：都体现了面向对象的“封装”特点

不同之处：模板方法模式是定义了一套“模板”，而模板的步骤中的实现是由子类完成的，也就是有一定的“开放—封闭”。而门面模式是完全封闭的，只对你提供一个调用入口，对我内部的实现，你无权查看和修改

[项目代码]()

![](https://lyn4ever.gitee.io/img/wx/gzh2.png)

