package com.blog.index.modules.other.vo;

import com.blog.pojo.entity.BlogCategory;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;

/**
 * @author wangfujie
 * @date 2018-09-06 14:28
 * @description 菜单封装（分类）
 */
public class BlogMenuNode extends BlogCategory {

    /**
     * 系统部署的ip地址
     */
    private String ipAddress;

    /**
     * 子节点菜单
     */
    private List<BlogCategory> subNodeList;

    public List<BlogCategory> getSubNodeList() {
        return subNodeList;
    }

    public void setSubNodeList(List<BlogCategory> subNodeList) {
        this.subNodeList = subNodeList;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
