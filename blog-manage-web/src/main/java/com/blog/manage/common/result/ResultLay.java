package com.blog.manage.common.result;

import com.baomidou.mybatisplus.plugins.Page;
import java.util.HashMap;

/**
 * @author wangfujie
 * @date 2018-09-14 13:44
 * @description 后台适配lay ui的table数据返回封装
 */
public class ResultLay extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private int code = 0;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultLay() {
        put("code", 0);
        put("msg", "操作成功!");
    }

    public static ResultLay error(String msg) {
        return error(500, msg);
    }

    public static ResultLay error(int code, String msg) {
        ResultLay r = new ResultLay();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultLay ok(String msg) {
        ResultLay r = new ResultLay();
        r.put("msg", msg);
        return r;
    }

    public static ResultLay ok() {
        return new ResultLay();
    }

    /**
     * 填充集合对象结果
     *
     * @param object
     * @return
     */
    public static ResultLay fillListData(Object object) {
        ResultLay r = new ResultLay();
        r.put("data",object);
        return r;
    }

    /**
     * 填充分页对象结果
     *
     * @param page
     * @return
     */
    public static ResultLay fillPageData(Page page) {
        ResultLay r = new ResultLay();
        r.put("data",page.getRecords());
        r.put("count",page.getTotal());
        return r;
    }

    @Override
    public ResultLay put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
