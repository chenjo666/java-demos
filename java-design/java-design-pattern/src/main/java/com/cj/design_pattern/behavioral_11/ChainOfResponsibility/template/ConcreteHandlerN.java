package com.cj.design_pattern.behavioral_11.ChainOfResponsibility.template;

public class ConcreteHandlerN extends Handler {
    @Override
    public void resolve(Request request) {
        // 请求是否能被解决，能：自身解决；不能：交给下一个职责链节点解决
        if (isResolveByHandlerN(request)) {
            System.out.println("成功解决！");
        } else if (this.getNext() != null) {
            this.getNext().resolve(request);
        }
    }
    public boolean isResolveByHandlerN(Request request) {
        return true;
    }
}
