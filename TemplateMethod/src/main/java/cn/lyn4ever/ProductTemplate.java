package cn.lyn4ever;

/**
 * 软件流程的模板
 * <p>
 * 1. 这里使用的是抽象类而不是接口
 * 2. 因为我们的流程方法不能定义为抽象的
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
