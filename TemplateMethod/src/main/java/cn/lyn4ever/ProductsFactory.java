package cn.lyn4ever;

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
