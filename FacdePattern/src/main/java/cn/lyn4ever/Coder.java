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
