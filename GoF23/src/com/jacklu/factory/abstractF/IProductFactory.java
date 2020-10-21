package com.jacklu.factory.abstractF;

//抽象产品工厂
public interface IProductFactory {
    //成产手机
    IPhoneProduct phoneProduct();
    //生产路由器
    IRouterProduct routerProduct();
}
