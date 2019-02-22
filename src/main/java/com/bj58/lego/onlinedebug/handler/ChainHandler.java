package com.bj58.lego.onlinedebug.handler;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 17:50
 */
public abstract class ChainHandler implements Handler {

    protected Handler nextHandler = null;

    @Override
    public Handler getNextHandler() {
        return nextHandler;
    }

    @Override
    public boolean hasNextHandler() {
        return getNextHandler() == null ? false : true;
    }

    @Override
    public boolean setNextHandler(Handler next) {
        this.nextHandler = next;
        return true;
    }
}
