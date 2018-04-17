package com.ch.rule;


/**
 * Created by hao on 2018/4/16.
 */
public interface ParamsMatch {

    boolean matched(WeMedia weMedia, String rule) throws Exception;
}
