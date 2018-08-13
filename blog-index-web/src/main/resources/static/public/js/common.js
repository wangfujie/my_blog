/**
 * 1、所有的js 初始化操作，都可以放在这里进行分配；
 * 2、本地的定义的可以全部都配置在下面requirejs 的申明体中；
 * 3、后期所有的js文件 声明都需要时闭包方式进行；
 */
(function (w, d) {
    requirejs({
        paths: {
            'aside-menu': '/public/js/aside-menu',
            'my-ueditor': '/public/libs/my-ueditor',
            'pagination': '/public/libs/pagination',
            'simplex-noise': '/public/libs/simplex-noise',
            'sha_256': '/public/libs/sha_256'
        }
    });
    require(['jquery'], function ($) {
        //ajax全局配置
        $.ajaxSetup({
            dataType: "json",
            contentType: 'application/x-www-form-urlencoded',
            cache: false,
            beforeSend: function (request, XHR) {
                request.setRequestHeader("token", sessionStorage.getItem("accessToken"));
            },
            complete: function (XHR, TS) {

            }
        });

        (function () {
            w.USERINFO = null;
            //获取用户信息
            $.ajax({
                url: '/user/loginUserInfo',
                async: false,
                success: function (res) {
                    if (res.code == 200) {
                        USERINFO = res.userinfo;
                        Object.freeze(USERINFO);
                    } else if(location.href.indexOf('/login.html')<0){
                        location.href = '/login.html'
                    }
                },
                error: function() {
                    if(location.href.indexOf('/login.html')<0){
                        location.href = '/login.html'
                    }
                }
            });
            //获取系统时间
            $.ajax({
                url: '/sysconfig/time',
                async: false,
                success: function (res) {
                    if (res.code == 200) {
                        w.sysTime = res.data.object.currentDateTime;
                    }
                }
            });

            //配置面包屑导航
            /*
             * 请忽略当前位置  和首页导航标签
             * data = [
             *   { text: '导航名称', link: '导航链接'}, //二级导航
             *   { text: '导航名称', link: '导航链接'} //三级导航
             * ]
             * */
            w.Breadcrumb = function (data) {
                this.breadcrumbEl = $('.breadcrumb')[0];  //面包削元素
                this.data = data;
                this.init();
            };

            Breadcrumb.prototype = {
                init: function () {
                    this.render(this.data);
                },
                render: function (data) {
                    var proto = Object.prototype.toString;
                    var dataType = proto.call(data).slice(8, -1);
                    var html = '<li>当前位置：<a href="/index.html">首页</a></li>';
                    var text, link;

                    if (dataType === 'Array') {
                        for (var i = 0, len = data.length; i < len; i++) {
                            text = data[i].text || '';
                            link = data[i].link || 'javascript:;';

                            html += '<li><a href="' + link + '">' + text + '</a></li>';
                        }
                        $(this.breadcrumbEl).html(html);
                    }
                }
            };

        })(w, d, $);

    });
}(window, document));


/**
 *  loading  遮罩效果
 * @type {Element}
 */

(function (w,d) {
    /* 初始化一个遮罩对象 */
    var loadingElt = d.createElement('div');
    var imgElt = d.createElement('img');
    loadingElt.style.cssText = "top: 0; left: 0; " +
        "position: fixed; background: rgba(240, 243, 244, .3);" +
        "display: block; z-index: 10000; " +
        "width: 100%; height: 100%; ";
    imgElt.setAttribute('src', '/public/img/loading.gif');
    imgElt.style.cssText = "position: absolute; " +
        "top: 50%; left: 50%; width: 50px; height: 50px;" +
        "transform: translate(-50%, -50%);";
    loadingElt.appendChild(imgElt);

    /* 页面初始化完成去除遮罩 */
    w.addEventListener('load', function() {
        d.body.removeChild(loadingElt);
    });
    /* 页面dom加载完成 添加遮罩 */
    d.addEventListener("DOMContentLoaded", function(event) {
        d.body.appendChild(loadingElt);
    });
    /***************************************************/
}(window, document))