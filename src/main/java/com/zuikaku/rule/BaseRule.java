package com.zuikaku.rule;

import java.util.List;

/**
 * 爬取规则基类，抽象类
 */
public abstract class BaseRule<T> {
    public abstract List<T> getContentList(String url);
}
