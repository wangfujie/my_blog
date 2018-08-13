/* 预防在ie9上出现未知错误 */
if (!window.console) {
    window.console = {
        log: function (msg) {
            return msg
        },
        error: function (msg) {
            return msg
        }
    }
}
(function (w, XHR) {
    /**
     * 纯页面js实现页面加载不变形的效果
     * @type {Element}
     */
    var hidden_style = document.createElement("style");
    hidden_style.setAttribute("id", "body_hidden_style");
    hidden_style.innerHTML = "body{margin:0px;height:100%;overflow:hidden!important;}body>.app{visibility:hidden;}";
    document.head.appendChild(hidden_style);

	w.LOCAL_RES_PATH = '/';
    w.ContextPath = "";
    w.WEB_DIR_PATH = '/plugins';
    var LOCAL_LIBS_PATH = '/public/libs';
    var LOCAL_CSS_PATH = '/public/css';
    w.pro_v = '1.0.1';
    var oReq = new XHR();
    oReq.open("GET", "/public/libs/require.min.js?v=" + pro_v, false); // 同步请求
    oReq.send(null);
    eval(oReq.responseText);
    w.require = require;
    w.define = define;
    w.requirejs = requirejs;
    requirejs.config({
        baseUrl: WEB_DIR_PATH + '/js',
        waitSeconds: 30,
        urlArgs: 'v=' + pro_v,
        paths: {
            'etheme': 'echarts/theme/macarons',
            'datatables': 'datatables/jquery.dataTables.min',
            'datatables.extend': 'datatables/jquery.dataTables.extend',
            'highstacks': 'highstacks/highstock',
            'echarts': 'echarts/echarts-all',
            'echarts3': 'echarts3/echarts.min',
            'echarts-test': LOCAL_LIBS_PATH + '/echarts-test',
            'ZeroClipboard': 'ueditor/third-party/zeroclipboard/ZeroClipboard',
            'ueditor': 'ueditor/ueditor.all',
            'ueconfig': 'ueditor/ueditor.config',
            'chosen': 'chosen/chosen.jquery.min',
            'uelang': 'ueditor/lang/zh-cn/zh-cn',
            'datepicker': 'datepicker/bootstrap-datepicker.min',
            'datepicker.lang': 'datepicker/bootstrap-datepicker.zh-CN.min',
            'datepicker.extend': 'datepicker/datepicker.extend',
            'timepicker': 'timepicker/bootstrap-timepicker.min',
            'datetimepicker': 'datetimepicker/bootstrap-datetimepicker.min',
            'datetimepicker.lang': 'datetimepicker/bootstrap-datetimepicker.zh-CN',
            'datetimepicker.extend': 'datetimepicker/datetimepicker.extend',
            'resize': 'resize/jquery.ba-resize.min',
            'flowplayer': 'flowplayer/flowplayer-3.2.13.min',
            'parsley': 'parsley/parsley.min',
            'parsley.extend': 'parsley/parsley.extend',
            'parsley.lang': 'parsley/i18n/zh_cn',
            'parsley.lang.extend': 'parsley/i18n/zh_cn.extra',
            'bootstrap-dialog': 'bootstrap-dialog/bootstrap-dialog.min',
            'sortable': 'sortable/jquery.sortable',
            'ajaxfileupload': 'ajaxfileupload/ajaxfileupload',
            'bootstrap.plugin': 'app.plugin',
            'bootstrap': 'bootstrap',
            'app': 'app.min',
            'jquery': 'jquery',
            'jquery.cookie': 'jquery.cookie/jquery.cookie',
            'smartMenu': 'jquery.smartMenu/jquery.smartMenu',
            'jquery.md5': 'jquery.md5/jquery.md5',
            'spark-md5': 'spark-md5/spark-md5.min',
            'util': WEB_DIR_PATH + '/html/js/util',
            'login': WEB_DIR_PATH + '/html/js/login',
            'cropbox': 'cropbox/jquery.cropbox',
            'mousewheel': 'mousewheel/jquery.mousewheel',
            'tree': 'tree/lib/Aimara',
            'treeview': 'treeview/bootstrap-treeview',
            'daterangepicker': 'daterangepicker/daterangepicker',
            'moment': 'daterangepicker/moment-with-locales',
            'area': 'area_bak',
            'base64': 'base64',
            'marquee': 'limarquee/jquery.liMarquee',
            'mricode.pagination': 'mricode.pagination/mricode.pagination',
            'vue': LOCAL_LIBS_PATH + '/vue.min',
            'vuejs': LOCAL_LIBS_PATH + '/vue',
            'vue-validator.min': LOCAL_LIBS_PATH + '/vue-validator.min',
            'validate': LOCAL_LIBS_PATH + '/validate',
            'aside-menu': LOCAL_LIBS_PATH + '/../js/aside-menu',
            'sockjs': LOCAL_LIBS_PATH + '/sockjs.min',
            'stomp': LOCAL_LIBS_PATH + '/stomp',
            
            'iCheck':'iCheck/icheck.min',
    	    'validator':'nice-validator/jquery.validator',
                'validator.lang':'nice-validator/local/zh-CN',
    	    'jquery.form':'jquery-form/jquery.form',
                'jquery-confirm':'jquery-confirm/jquery-confirm.min',
    	    'select2':'select2/select2.full.min',
                'select2.lang':'select2/i18n/zh-CN',
    	    'bootstrapTable':'bootstrap-table/bootstrap-table',
                'bootstrapTable.lang':'bootstrap-table/locale/bootstrap-table-zh-CN.min',
    	    'bootstrap-treeview':'treeview/bootstrap-treeview',
    	    'data.treeview':'treeview/data.treeview',
    	    'layui':'layui/layui',
                'layer':'layer/layer',
    	    'zTree':'zTree/js/jquery.ztree.all',
    	    'smartWizard':'smartWizard/js/jquery.smartWizard',
                'global_custom':LOCAL_RES_PATH+'public/js/global_custom',
    	    'UE':'ueditor/ueditor.all',
    	    'UE.config':'ueditor/ueditor.config',
                'UE.lang':'ueditor/lang/zh-cn/zh-cn',
                'curdtools':LOCAL_LIBS_PATH + '/../js/curdtools',
        },
        shim: {
            'echarts': {
                echarts: "echarts"
            },
            'resize': ['jquery'],
            'ajaxfileupload': ['jquery'],
            'chosen': ['jquery', 'css!../js/chosen/chosen.css'],
            'sortable': ['jquery'],
            'cookie': ['jquery'],
            'smartMenu': ['jquery', 'css!../js/jquery.smartMenu/smartMenu.css'],
            'jquery.md5': ['jquery'],
            'bootstrap': ['jquery', 'css!' + WEB_DIR_PATH + '/css/animate.css'
                , 'css!' + WEB_DIR_PATH + '/css/font-awesome.min.css'
                , 'css!' + WEB_DIR_PATH + '/css/simple-line-icons.css'
                , 'css!' + WEB_DIR_PATH + '/css/bootstrap.css'
                , 'css!' + WEB_DIR_PATH + '/css/font.css'
                , 'css!' + WEB_DIR_PATH + '/css/app.min.css'
                , 'css!' + LOCAL_CSS_PATH + '/common.css'
                , 'css!' + LOCAL_CSS_PATH + '/custom.css'
	            , 'css!' + LOCAL_CSS_PATH + '/catalogue.css'
	          	, 'css!' + LOCAL_CSS_PATH + '/release.css'],
            'paginator': ['bootstrap'],
            'datatables.extend': ['jquery', 'datatables'],
            'datatables': ['jquery', 'css!../js/datatables/datatables.css'],
            'datepicker': ['jquery', 'css!../js/datepicker/datepicker.css'],
            'datepicker.lang': ['datepicker'],
            'datepicker.extend': [, 'datepicker'],
            'timepicker': ['jquery', 'css!../js/timepicker/bootstrap-timepicker.css'],
            'datetimepicker': ['jquery', 'css!../js/datetimepicker/bootstrap-datetimepicker.min.css'],
            'datetimepicker.lang': ['datetimepicker'],
            'datetimepicker.extend': [, 'datetimepicker'],
            'bootstrap.plugin': ['bootstrap'],
            'bootstrap-dialog': ['bootstrap'],
            'parsley': ['jquery', 'css!../js/parsley/parsley.css'],
            'parsley.extend': ['parsley', 'parsley.lang', 'parsley.lang.extend'],
            'parsley.lang': ['parsley'],
            'parsley.lang.extend': ['parsley'],
            'daterangepicker': ["jquery", "css!../js/daterangepicker/daterangepicker"],
            'cropbox': ['jquery', 'mousewheel', 'css!../js/cropbox/jquery.cropbox.css'],
            'treeview': ['bootstrap', 'css!../js/treeview/bootstrap-treeview.min.css'],
            'marquee': ['jquery', 'css!../js/limarquee/liMarquee.css'],
            'uelang': {
                deps: ['ueditor', 'ZeroClipboard']
            },
            'util': ['jquery'],
            'ueditor': ['ueconfig'],
            'highstacks': {
                deps: ['jquery'],
                exports: 'Highcharts'
            },
            'graphic/lib/raphael': {

                exports: 'Raphael'
            },
            'mricode.pagination': ['jquery', 'css!../js/mricode.pagination/mricode.pagination.css'],
            
            
            'iCheck': ['jquery', 'css!../js/iCheck/all.css'],
        	'jquery.form':['jquery'],
        	'jquery-confirm': ['jquery', 'css!../js/jquery-confirm/jquery-confirm.min.css'],
        	'validator': ['jquery', 'css!nice-validator/jquery.validator.css'],
        	'validator.lang': ['validator'],
        	'select2': ['jquery', 'css!../js/select2/select2.min.css'],
        	'select2.lang': ['select2'],
        	'daterangepicker': ['jquery', 'moment', 'css!../js/daterangepicker/daterangepicker.css'],
        	'bootstrapTable': ['jquery', 'css!../js/bootstrap-table/bootstrap-table.min.css'],
        	'bootstrapTable.lang': ['bootstrapTable'],
        	'bootstrap-treeview':['jquery'],
        	'data.treeview':['jquery'],
        	'layui':['jquery','css!../js/layui/css/layui.css'],
        	'layer':['jquery','css!../js/layui/css/layui.css','css!../js/layer/skin/default/layer.css'],
        	'zTree': ['jquery', 'css!../js/zTree/css/zTreeStyle/zTreeStyle.css','css!../js/zTree/css/zTreeStyle/zTreeStyle.css'],
        	'smartWizard':['jquery', 'css!../js/smartWizard/css/smart_wizard.css'
        	               , 'css!../js/smartWizard/css/smart_wizard_theme_dots.css'],
        	'ajaxfileupload':['jquery'],
        	'UE':['UE.config'],
        	'UE.lang':['UE']
        }
    });
    /**
     * common.js的公共插件代码
     */
    oReq.open("GET", "/public/js/common.js?v=" + pro_v, false); // 同步请求
    oReq.send(null);
    eval(oReq.responseText);

    //在requirejs 下 echart必须使用的 url路径
    window.UEDITOR_HOME_URL = WEB_DIR_PATH + '/js/ueditor/';
    require(['jquery', 'global_custom', 'bootstrap'], function ($, global_custom) {
        $(hidden_style).remove();
        window.basePathJS = location.protocol + '//' + location.host;
        global_custom.initGlobalCustom(basePathJS);
        delete hidden_style;
    })
    // 初始化工具类
    require(['jquery','layer', 'curdtools'],function($,layer){
		window.layer = layer;
	})
	require(['jquery','validator'],function($,validator){
		window.$ = window.jQuery = $;
		$.validator = jQuery.validator = validator;
	})
}(window, XMLHttpRequest));
/**
 * 初始换业务模块
 */
(function (w, d) {
    require(['jquery', 'vue'], function ($, vue) {
        $(document).on("dragstart", function () {
            return false;
        });
        window.$ = window.jQuery = $;
        window.vue = vue;
        $("[v-include]").each(function () {
            var that = $(this);
            $.ajax({
                url: that.attr("v-include"),
                data: {v: pro_v},
                dataType: 'text',
                type: 'get',
                success: function (d) {
                    that.html(d);
                    that.removeAttr("v-include")
                }
            });
        });
        $(document).on("mouseenter", "[data-toggle='tooltip']", function () {
            $(this).tooltip('show');
        });

        $(document).on("selectstart", ".pagination", function (e) {
            e.preventDefault();
            return false;
        })
    });

    require(['jquery', 'bootstrap-dialog'], function ($, bdg) {
        $.bootstrapDialog = bdg;
        $.bootstrapDialog.DEFAULT_TEXTS[bdg.TYPE_DEFAULT] = '信息';
        $.bootstrapDialog.DEFAULT_TEXTS[bdg.TYPE_INFO] = '信息';
        $.bootstrapDialog.DEFAULT_TEXTS[bdg.TYPE_PRIMARY] = '信息';
        $.bootstrapDialog.DEFAULT_TEXTS[bdg.TYPE_SUCCESS] = '成功';
        $.bootstrapDialog.DEFAULT_TEXTS[bdg.TYPE_WARNING] = '警告';
        $.bootstrapDialog.DEFAULT_TEXTS[bdg.TYPE_DANGER] = '危险';
        $.bootstrapDialog.DEFAULT_TEXTS['OK'] = '确认';
        $.bootstrapDialog.DEFAULT_TEXTS['CANCEL'] = '取消';
        $.bootstrapDialog.DEFAULT_TEXTS['CONFIRM'] = '确认';
        $.bootstrapDialog.onModal = function (e) {
            e.preventDefault();
            var $this = $(this);
            $.bootstrapDialog.show({
                closable: false,
                onshow: function (dialog) {
                    dialog.getModal().html('');
                    dialog.getModal().load(encodeURI($this.attr("href")));
                    dialog.updateClosable();
                }
            });
            return false;
        }
        $.bootstrapDialog.modalTip = function (content) {
            $.bootstrapDialog.show({
                message: content,
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                }
            });
        };
        //成功的模态窗口定制
        $.bootstrapDialog.success = function (content, func) {

            var $success = $('<div class="padder padder-v"><div class="title">提示</div><div class="row m-t-sm">' +
                '<div class="col-xs-4 m-t m-r-n col-xs-offset-1"><img class="img-full" src="../public/img/success-pic.png"></div>' +
                '<div class="col-xs-7 m-t"><h3 style="color: #58666e">' + content + '</h3></div>' +
                '<div class="col-xs-12 m-t-lg" style="padding: 0 100px;"><button class="btn btn-info btn-block" data-dismiss="modal" aria-label="Close">确 &nbsp;认</button></div>' +
                '</div></div>');

            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                },
                onhidden: function () {
                    if (func && typeof func == 'function')
                        func.apply(this);
                }
            });
        };
        $.bootstrapDialog.preview = function (pram) {
            var $success = '<div class="item">' +
                '<div class="top text-right w-full padder padder-v"> ' +
                '<button class="close block" data-dismiss="modal">×</button> ' +
                '</div>' +
                '</div>' +
                '<div class="row padder-v padder m-t-sm"> ' +
                '<style>' +
                '.content p{' +
                'font-size: 18px;' +
                'text-indent:2em;' +
                '} ' +
                '</style> ' +
                '<div class="col-xs-12 text-left"> ' +
                '<p class=" font-bold h3">' +
                pram.title
                + '</p>' +
                '</div>' +
                '<div class="col-xs-12 m-t-md"> ' +
                '<p class="text-muted">' +
                pram.time + '  ' +
                pram.author
                + '</p> ' +
                '</div> ' +
                '<div class="line line-dashed b-b line-lg "></div> ' +
                '<div class="col-xs-12 content"> ' +
                pram.content
                + '</div> ' +
                '</div>';
            $.bootstrapDialog.show({
                onshow: function (dialog) {
//                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin", "0 auto");
                    dialog.getModalDialog().css("margin-top", "20px");
                    dialog.getModalDialog().css("width", "80%");
                    dialog.getModalContent().html($success);
                },
                onshown: function () {
//                     func.apply(this);
                }
            });
        };
        $.bootstrapDialog.addSuccess = function (param, sureFunc, cancelFunc) {
            var content = param.content;
            var button = param.button;
            var $success = $('<div class="padder padder-v"> <div class="row m-t-sm"> <div class="col-xs-4 col-sm-offset-4 ">' +
                ' <img class="img-full img-responsive center-block" src="' + WEB_DIR_PATH + '/images/success01.png"></div>' +
                '<div class="col-xs-12 m-t text-center"> <p class="h4">提示</p>' +
                '<p class="h5 m-t-md">' + content + '</p> </div>' +
                '<div class="col-xs-12 m-t-lg" style="padding: 0 50px;">' +
                '<div class="row">' +
                '<div class="col-sm-6" style="padding-right: 5px;padding-left: 0px;">' +
                '<button class="btn btn-default btn-block "  name="modal_cancel" aria-label="cancel">' + button.cencel +
                '</button> </div> <div class="col-sm-6" style="padding-left: 5px;padding-right: 0px;">' +
                '<button class="btn btn-info btn-block "  name="modal_sure" aria-label="sure"> ' + button.sure +
                '</button> </div> </div> </div></div></div>');
            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                },
                onshown: function () {
                    $('[name=modal_sure]').unbind().click(function () {
                        if (sureFunc && typeof sureFunc == 'function')
                            sureFunc.apply(this);
                    });
                    $('[name=modal_cancel]').unbind().click(function () {
                        if (cancelFunc && typeof cancelFunc == 'function')
                            cancelFunc.apply(this);
                    });
                },
                onhidden: function () {
                    if (cancelFunc && typeof cancelFunc == 'function')
                        cancelFunc.apply(this);
                }
            });
        };
        //成功的是否模态窗口定制
        $.bootstrapDialog.success_IsTrue = function (content, sureFunc, cancelFunc) {
            var $success = $('<div class="padder padder-v"> <div class="row m-t-sm"> <div class="col-xs-4 col-sm-offset-4 ">' +
                ' <img class="img-full img-responsive center-block" src="' + WEB_DIR_PATH + '/images/success01.png"></div>' +
                '<div class="col-xs-12 m-t text-center"> <p class="h4">提示</p>' +
                '<p class="h5 m-t-md">' + content + '</p> </div>' +
                '<div class="col-xs-12 m-t-lg" style="padding: 0 50px;">' +
                '<div class="row">' +
                '<div class="col-sm-6" style="padding-right: 5px;">' +
                '<button class="btn btn-default btn-block " data-dismiss="modal" name="modal_cancel" aria-label="cancel">' +
                '取消 </button> </div> <div class="col-sm-6" style="padding-left: 5px;">' +
                '<button class="btn btn-info btn-block " data-dismiss="modal" name="modal_sure" aria-label="sure"> 确定' +
                '</button> </div> </div> </div></div></div>');
            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                },
                onshown: function () {
                    $('[name=modal_sure]').unbind().click(function () {
                        if (sureFunc && typeof sureFunc == 'function')
                            sureFunc.apply(this);
                    });
                    $('[name=modal_cancel]').unbind().click(function () {
                        if (cancelFunc && typeof cancelFunc == 'function')
                            cancelFunc.apply(this);
                    });
                },
                onhidden: function () {
                    if (cancelFunc && typeof cancelFunc == 'function')
                        cancelFunc.apply(this);
                }

            });
        };
        //修改成功的模态窗口定制
        $.bootstrapDialog.success_update = function (content, func) {
            var $success = $('<div class="padder padder-v"><div class="row m-t-sm">' +
                '<div class="col-xs-4 m-t m-r-n col-xs-offset-1"><img class="img-full" src="' + WEB_DIR_PATH + '/images/success_update.png"></div>' +
                '<div class="col-xs-7 m-t"><h3>' + content + '</h3></div>' +
                '<div class="col-xs-12 m-t-lg" style="padding: 0 100px;"><button class="btn btn-info btn-block" name="modal_update" data-dismiss="modal" aria-label="Close">确 &nbsp;认</button></div>' +
                '</div></div>');
            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                },
                onshown: function () {
                    $('[name=modal_update]').unbind().click(function () {
                        if (func && typeof func == 'function')
                            func.apply(this);
                    });
                },
                onhidden: function () {
                    if (func && typeof func == 'function')
                        func.apply(this);
                }
            });
        };
        //修改成功模态窗口定制
        $.bootstrapDialog.submit = function (content, sureFunc) {
            var $success = $('<div class="padder padder-v"> <div class="row m-t-sm"> <div class="col-xs-4 col-sm-offset-4 ">' +
                ' <img class="img-full img-responsive center-block" src="' + WEB_DIR_PATH + '/images/success_update.png"></div>' +
                '<div class="col-xs-12 m-t text-center"> ' +
                '<p class="h5 m-t-md">' + content + '</p> </div>' +
                '<div class="col-xs-12 m-t-lg" style="padding: 0 100px;"><button class="btn btn-info btn-block" name="modal_update" data-dismiss="modal" aria-label="Close">确 &nbsp;认</button></div>' +
                '</div> </div>');
            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                },
                onshown: function () {
                    $('[name=modal_update]').unbind().click(function () {
                        if (sureFunc && typeof sureFunc == 'function')
                            sureFunc.apply(this);
                    });
                },
                onhidden: function () {
                    if (sureFunc && typeof sureFunc == 'function')
                        sureFunc.apply(this);
                }

            });
        };
        //失败的模态窗口定制
        $.bootstrapDialog.failure = function (content, sureFunc) {
            var $success = $('<div class="padder padder-v"><div class="title">提示</div><div class="row m-t-sm">' +
                '<div class="col-xs-4 m-t m-r-n col-xs-offset-1"><img class="img-full" src="../public/img/fail-pic.png"></div>' +
                '<div class="col-xs-7 m-t"><h3 style="color: #58666e">' + content + '</h3></div>' +
                '<div class="col-xs-12 m-t-lg" style="padding: 0 100px;"><button class="btn btn-info btn-block" data-dismiss="modal" aria-label="Close">确 &nbsp;认</button></div>' +
                '</div></div>');
            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                },
                onshown: function () {
                    $('[name=modal_failure]').unbind().click(function () {
                        if (sureFunc && typeof sureFunc == 'function')
                            sureFunc.apply(this);
                    });
                },
                onhidden: function () {
                    if (sureFunc && typeof sureFunc == 'function')
                        sureFunc.apply(this);
                }
            });
        };

        //警告的模态窗口定制
        $.bootstrapDialog.warning = function (content, sureFunc, cancelFunc) {
            var $success = $('<div class="padder padder-v"><div class="title">警告</div> <div class="row m-t-sm"> <div class="col-xs-4 col-sm-offset-4 ">' +
                ' <img class="img-full img-responsive center-block" src="../public/img/alert-pic.png"></div>' +
                '<div class="col-xs-12 m-t text-center">' +
                '<p class="h5 m-t-md">' + content + '</p> </div>' +
                '<div class="col-xs-12 m-t-lg" style="padding: 0 50px;">' +
                '<div class="row">' +
                '<div class="col-sm-6" style="padding-right: 5px;">' +

                '<button class="btn btn-info btn-block " data-dismiss="modal" name="modal_sure" aria-label="sure">' +
                '确定 </button> </div> <div class="col-sm-6" style="padding-left: 5px;">' +
                '<button class="btn btn-default btn-block " data-dismiss="modal" name="modal_cancel" aria-label="cancel"> 取消' +
                '</button> </div> </div> </div> </div> </div>');

            /*'<button class="btn btn-default btn-block " data-dismiss="modal" name="modal_cancel" aria-label="cancel">' +
            '取消 </button> </div> <div class="col-sm-6" style="padding-left: 5px;">' +
            '<button class="btn btn-info btn-block " data-dismiss="modal" name="modal_sure" aria-label="sure"> 确定' +*/
            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                },
                onshown: function () {
                    $('[name=modal_sure]').unbind().click(function () {
                        if (sureFunc && typeof sureFunc == 'function')
                            sureFunc.apply(this);
                    });
                    $('[name=modal_cancel]').unbind().click(function () {
                        if (cancelFunc && typeof cancelFunc == 'function')
                            cancelFunc.apply(this);
                    });
                },
                onhidden: function () {
                    if (cancelFunc && typeof cancelFunc == 'function')
                        cancelFunc.apply(this);
                }

            });
        };
        //禁止警告的模态窗口定制
        //execute:是否在模态窗关闭是执行sureFunc
        $.bootstrapDialog.warning_ban = function (content, sureFunc, execute) {
            var $success = $('<div class="padder padder-v"> <div class="title">警告</div><div class="row m-t-sm"> <div class="col-xs-4 col-sm-offset-4 ">' +
                ' <img class="img-full img-responsive center-block" src="../public/img/alert-pic.png"></div>' +
                '<div class="col-xs-12 m-t text-center">' +
                '<p class="h5 m-t-md">' + content + '</p> </div>' +
                '<div class="col-xs-12 m-t-lg" style="padding: 0 100px;"><button class="btn btn-info btn-block" name="modal_sure" data-dismiss="modal" aria-label="Close">确 &nbsp;认</button></div>' +
                '</div> </div>');
            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                },
                onshown: function () {
                    $('[name=modal_sure]').unbind().click(function () {
                        execute = false; //如果用户点击了确定按钮则不执行onhidden中的函数
                        if (sureFunc && typeof sureFunc == 'function')
                            sureFunc.apply(this);
                    });
                },
                onhidden: function () {
                    execute && sureFunc.apply(this);
                }

            });
        };
        //新建窗口的模态窗口定制
        $.bootstrapDialog.window_open = function (content, url) {
            var $success = $('<div class="padder padder-v"> <div class="row m-t-sm"> <div class="col-xs-4 col-sm-offset-4 ">' +
                ' <img class="img-full img-responsive center-block" src="' + WEB_DIR_PATH + '/images/warning.png"></div>' +
                '<div class="col-xs-12 m-t text-center"> <p class="h4">警告</p>' +
                '<p class="h5 m-t-md">' + content + '</p> </div>' +
                '<div class="col-xs-12 m-t-lg" style="padding: 0 50px;">' +
                '<div class="row">' +
                '<div class="col-sm-6" style="padding-right: 5px;">' +
                '<button class="btn btn-default btn-block " data-dismiss="modal" name="modal_cancel" aria-label="cancel">' +
                '取 &nbsp;消 </button> </div> <div class="col-sm-6" style="padding-left: 5px;">' +
                '<a href="' + url + '" target="_blank" class="btn btn-info btn-block" name="modal_sure" >确 &nbsp;认</a> </div> </div> </div> </div> </div>');
            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                }, onshown: function (dialogRef) {
                    $('[name=modal_cancel]').unbind().click(function () {
                        dialogRef.close();
                    });
                    $('[name=modal_sure]').unbind("click").click(function () {
                        //$(".bootstrap-dialog,.modal-backdrop").remove()
                        dialogRef.close();
                    });
                }
            });
        };
        //提示框
        $.bootstrapDialog.tip = function (content, sureFunc) {
            var $success = $('<div class="padder padder"> <div class="row "> <div class="col-xs-12 tip text-center"' +
                '<p class="h4 m-t-sm m-b-sm">提示</p></div>' +
                '<div class="col-xs-12  text-center"> <p class="h5 m-t-md"></p>' + content + '<p></p> </div>' +
                '<div class="col-xs-12 m-t-md">' +
                '<button class="btn btn-info btn-block" name="modal_sure" data-dismiss="modal" aria-label="Close">确 &nbsp;认</button>' +
                '</div></div> </div>');
            $.bootstrapDialog.show({
                size: "size-small",
                onshow: function (dialog) {
                    dialog.getModalHeader().remove();
                    dialog.getModalDialog().css("margin-top", $(window).height() / 2 * 0.4 + "px");
                    dialog.getModalContent().html($success);
                },
                onshown: function () {
                    $('[name=modal_sure]').unbind().click(function () {
                        if (sureFunc) {
                            sureFunc.apply();
                        }
                    });
                },
                onhidden: function () {
                    if (sureFunc) {
                        sureFunc.apply();
                    }
                }

            });
        };
        $(document).on('click', '[data-toggle="ajaxModal"]', $.bootstrapDialog.onModal);

        //数据报送表单提交的模态框
        $.bootstrapDialog.reportSubmit = function (serialNum, submitMsg) {
            /* var $success = '<div class="modal-dialog" style="margin-top: 16%;" ><div class="modal-content"><div class="modal-body">' +
             '<div class="row"><div class="col-md-2" style="height: 80px;line-height: 80px;text-align: right;">' +
             '<img src="' + WEB_DIR_PATH + '/images/success_report.png" style="width:62px;height:62px;"/>' +
             '</div><div class="col-md-10" style="padding-left: 30px;padding-right: 30px;"><h4>数据报送资料提交成功</h4>' +
             '<div>申请流水单号为：<b id="Num">'+ serialNum +'</b>，可通过流水单号查询审批进度，系统将自动返回 用户中心</div></div></div></div>' +
             '<div class="modal-footer" style="text-align: center;"><a href="myBatabase.jsp" id="return-person" class="btn" style="color:#fff;background-color: #2f8cff;">返回 个人中心</a></div></div></div>';
             $.bootstrapDialog.show({
             onshow: function (dialog) {
             dialog.getModal().html($success);
             }
             });
             $(document).click(function() {
             location.href = 'myBatabase.jsp';
             });*/
            if (SU_USER) {
                var $success = '<div class="modal-dialog" style="margin-top: 16%;" ><div class="modal-content"><div class="modal-body">' +
                    '<div class="row"><div class="col-md-2" style="height: 80px;line-height: 80px;text-align: right;">' +
                    '<img src="' + WEB_DIR_PATH + '/images/success_report.png" style="width:62px;height:62px;"/>' +
                    '</div><div class="col-md-10" style="padding-left: 30px;padding-right: 30px;"><h4>数据报送历史数据保存成功</h4>' +
                    '<div>申请流水单号为：<b id="Num">' + serialNum + '</b>，可通过流水单号查询审批进度，系统将自动(<b id="auto-time">3s</b>)返回 历史数据</div></div></div></div>' +
                    '<div class="modal-footer" style="text-align: center;"><a  href="case.jsp" id="return-history" class="btn" style="color:#fff;background-color: #2f8cff;">返回 历史数据</a></div></div></div>';
                $.bootstrapDialog.show({
                    onshow: function (dialog) {
                        dialog.getModal().html($success);
                    }
                });
            } else {
                var v = '';
                if (submitMsg == 0) {
                    v = '设立登记'
                } else if (submitMsg == 1) {
                    v = '变更'
                } else if (submitMsg == 2) {
                    v = '注销申请'
                } else if (submitMsg == 3) {
                    v = '年检'
                } else {
                    v = '数据报送'
                }
                var $success = '<div class="modal-dialog" style="margin-top: 16%;" ><div class="modal-content"><div class="modal-body">' +
                    '<div class="row"><div class="col-md-2" style="height: 80px;line-height: 80px;text-align: right;">' +
                    '<img src="' + WEB_DIR_PATH + '/images/success_report.png" style="width:62px;height:62px;"/>' +
                    '</div><div class="col-md-10" style="padding-left: 30px;padding-right: 30px;"><h4>' + v + '资料提交成功</h4>' +
                    '<div>申请流水单号为：<b id="Num">' + serialNum + '</b>，可通过流水单号查询审批进度，系统将自动(<b id="auto-time">3s</b>)返回 用户中心</div></div></div></div>' +
                    '<div class="modal-footer" style="text-align: center;"><a href="myBatabase.jsp" id="return-person" class="btn" style="color:#fff;background-color: #2f8cff;">返回 个人中心</a></div></div></div>';
                $.bootstrapDialog.show({
                    onshow: function (dialog) {
                        dialog.getModal().html($success);
                    }
                });
            }

            var time = 2;
            var setTime = setInterval(function () {

                $('#auto-time').text(time + 's');
                time--;
                if (time == 0) {
                    clearInterval(setTime);
                    if (SU_USER) {
                        location.href = 'case.jsp';
                    } else {
                        location.href = 'myBatabase.jsp';
                    }

                }
            }, 1000);

            /*$(document).click(function(){
             if(SU_USER){
             location.href = 'case.jsp';
             }else{
             location.href = 'myBatabase.jsp';
             }
             });*/
        }

    })

}(window, document));



// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = decodeURIComponent(window.location.search).substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

function formatTimeToStr(times, pattern) {
    var d = new Date(times).Format("yyyy-MM-dd hh:mm:ss");
    if (pattern) {
        d = new Date(times).Format(pattern);
    }
    return d.toLocaleString();
}

var m_tool = {
    cutStr: function (str, len) {
        var str_length = 0;
        var str_len = 0;
        var str_cut = new String();
        str_len = str.length;
        for (var i = 0; i < str_len; i++) {
            a = str.charAt(i);
            str_length++;
            if (escape(a).length > 4) {
                //中文字符的长度经编码之后大于4
                str_length++;
            }
            str_cut = str_cut.concat(a);
            if (str_length >= len) {
                str_cut = str_cut.concat("...");
                return str_cut;
            }
        }
        //如果给定字符串小于指定长度，则返回源字符串；
        if (str_length < len) {
            return str;
        }
    },
    getStrLength: function (str) {
        var str_length = 0;
        var str_len = 0;
        str_len = str.length;
        for (var i = 0; i < str_len; i++) {
            a = str.charAt(i);
            str_length++;
            if (escape(a).length > 4) {
                //中文字符的长度经编码之后大于4
                str_length++;
            }
        }
        //如果给定字符串小于指定长度，则返回源字符串；
        return str_length;
    }
}

var DICT_CONF = {INDUSTRY_CONF: {}, CATEGORY_CONF: {}};

/**
 * 加载配置文件
 */
function loadDataConf(func) {
    var INDUSTRY_CONF = {};
    var CATEGORY_CONF = {};
    var apply_data = {};
    $.post("/common/Industry_getIndustryList", {iDisplayStart: 0, iDisplayLength: 9999}, function (d) {
        var aaData = d.aaData;
        if (d.aaData && d.aaData.length > 0) {
            for (var i in aaData) {
                INDUSTRY_CONF[aaData[i].id] = aaData[i].name;
                INDUSTRY_CONF[aaData[i].name] = aaData[i].id;
            }
            DICT_CONF.INDUSTRY_CONF = INDUSTRY_CONF;
        }
        apply_data['industry_list'] = aaData;
        //console.log(d);
    }, 'json').done(function () {
        $.post("/common/Category_getCategoryAllList", {iDisplayStart: 0, iDisplayLength: 9999}, function (d) {
            //console.log(d);
            var aaData = d.aaData;
            if (aaData && aaData.length > 0) {
                for (var i in aaData) {
                    CATEGORY_CONF[aaData[i].id] = aaData[i].name;
                    CATEGORY_CONF[aaData[i].name] = aaData[i].id;
                }
                DICT_CONF.CATEGORY_CONF = CATEGORY_CONF;
            }
            apply_data['category_list'] = aaData;
        }, 'json').done(function () {
            func.apply(this, [apply_data]);
        });
    })
}
