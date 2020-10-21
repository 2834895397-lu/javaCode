package com.jacklu.factory.abstractF;

public class HuaWeiFactory implements IProductFactory {
    @Override
    public IPhoneProduct phoneProduct() {
        return new HuaWeiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new HuaWeiRouter();
    }
}
