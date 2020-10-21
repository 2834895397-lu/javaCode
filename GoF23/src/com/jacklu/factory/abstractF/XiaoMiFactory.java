package com.jacklu.factory.abstractF;

public class XiaoMiFactory implements IProductFactory{

    @Override
    public IPhoneProduct phoneProduct() {
        return new XiaoMiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new XiaoMiRouter();
    }
}
