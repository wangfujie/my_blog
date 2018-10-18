package com.blog.manage.modules.system.vo;

/**
 * @author wangfujie
 * @date 2018-10-18 16:30
 * @description UEditor需要的返回值内容封装
 */
public class ReturnUploadImage {
    /**
     * 文件名称
     */
    private String title;
    /**
     * 文件名称
     */
    private String original;
    /**
     * 状态，SUCCESS 一定要大写
     */
    private String state;
    /**
     * 文件返回url
     */
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
