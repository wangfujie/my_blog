package com.blog.common.result;

import com.blog.common.utils.MessageSourceUtil;
import org.apache.commons.collections.map.HashedMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangfujie
 * @date 2018-08-10 9:57
 * @description 返回数据统一封装
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private int code = 200;

    private Object data;

    private boolean needRefresh = true;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public R() {
        put("code", 200);
        put("msg", MessageSourceUtil.getMessage("200"));
        put("needRefresh", true);
    }

    public static R error(){
        R r = new R();
        r.put("code", 500);
        r.put("msg", MessageSourceUtil.getMessage("500"));
        return r;
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    /**
     * 未查询到资源
     *
     * @return
     */
    public static R notFound() {
        R r = new R();
        r.put("code", "404");
        r.put("describe", MessageSourceUtil.getMessage("404"));
        return r;
    }

    public static R notFound(String msg) {
        return R.notFound().put("msg", msg);
    }


    /**
     * 填充单个对象的结果
     *
     * @param object
     * @return
     */
    public static R fillSingleData(Object object) {
        Map<String, Object> map = new HashedMap();
        map.put("object", object);
        return R.ok().put("data", map);
    }

    /**
     * 填充集合对象结果
     *
     * @param object
     * @return
     */
    public static R fillListData(Object object) {
        Map<String, Object> map = new HashedMap();
        map.put("list", object);
        return R.ok().put("data", map);
    }

    /**
     * 填充分页对象结果
     *
     * @param object
     * @return
     */
    public static R fillPageData(Object object) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", object);
        return R.ok().put("data", map);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public boolean isNeedRefresh() {
        return needRefresh;
    }

    public void setNeedRefresh(boolean needRefresh) {
        this.needRefresh = needRefresh;
    }
}