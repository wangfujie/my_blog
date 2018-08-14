package com.blog.common.constant;

/**
 * @author wangfujie
 * @date 2018-08-10 9:39
 * @description 系统常量定义
 */
public final class SystemConst {
    private SystemConst(){}
    /***********************************************************/
    /**
     * 用户权限 session Key
     */
    public static final String PERMISSIONS = "permissions";
    /**
     * 菜单树 session Key
     */
    public static final String TREE_MENUS = "treeMenus";
    /**
     * 当前登录用户信息 session Key
     */
    public static final String ME = "about";
    public static final String RES = "res";
    public static final String CUR = "cur";
    public static final String REGION = "regionCode";

    /**
     * 逻辑删除标识
     */
    public static final int SYS_DELETE_FLAG = 1;

    /**
     * 菜单的类型 menu_type(1:目录 2:菜单 3:功能)
     */
    public static final int SYS_MENU_TYPE_CATALOG = 1;
    public static final int SYS_MENU_TYPE_MENU = 2;
    public static final int SYS_MENU_TYPE_FUNCTION = 3;

    /***********************************************************/
    /**
     * 默认分页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    public static final int MAX_PAGE_SIZE = 200;

}
