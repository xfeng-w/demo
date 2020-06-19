package com.xfeng.demo.jsonview;

/**
 * @author xuefeng.wang
 * @date 2020-06-17
 */
public interface View {
    /**
     * 选框属性
     */
    interface SelectionsView {
    }

    /**
     * API接口属性
     */
    interface ApiView extends SelectionsView {
    }

    /**
     * 页面接口属性
     */
    interface PageView extends ApiView {
    }

    /**
     * 页面接口更多属性
     */
    interface PageMoreView extends PageView {
    }

    /**
     * 额外的属性
     */
    interface PageExtraView extends PageMoreView {
    }
}
