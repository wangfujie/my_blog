/**
 * Created by zhang on 2017/7/26.
 */
require(['jquery', 'vue', 'sockjs', 'stomp'], function ($, Vue, sockjs, stomp) {
    //
    $(function () {
        /*var stompClient = null;
        var socket = new SockJS('/endpointSang');
        stompClient = Stomp.over(socket);
        localStorage.setItem("websocketConnected", true);
        stompClient.connect({}, function (frame) {
            stompClient.subscribe('/topic/kickOutUser', function (response) {
                var kickOutUser = JSON.parse(response.body);
                if (USERINFO.uuid == kickOutUser.uuid) {
                    $.bootstrapDialog.failure('您的账号在' + kickOutUser.ipAddress + '处登录', function () {
                        location.href = '/login.html';
                    })
                }
            })
        });*/
    });

    var vm = new Vue({
        el: '#headerContent',
        data: {
            userDetail: {
                userName: '',
                headImageUrl: '',
                deptName: ''
            },
            isLogin: false,
            isShow: false,
            limitsRoleCenter: false,
            isToIndex: true,
            alarmReadList: [],
            checks: [],
            isRemind: false,
            headline: '',
            messageRecordObj: {},
            systemName: '',
            headlineObj: {
                '/index': '总览',
                '/data-exchange-controls/index': '监控和告警 - 数据交换监控',
                '/exchange-statistics/task-statistics': '数据交换统计 - 按交换任务统计',
                '/resource-analyze/index': '信息资源目录分析',
                '/service-statistics/service-statistics': '共享开放服务统计 - 按服务统计',
                '/statistics-by-unit/index': '数据交换统计 - 按单位统计',
                '/preview/exchange-log': '数据交换统计 - 数据交换日志',
                '/preview/call-log': '共享开放服务统计 - 服务调用日志',
                '/preview/sys-monitor': '监控和告警 - 采集系统告警',
                '/preview/acq-monitor': '监控和告警 - 采集端告警',
                '/service-statistics/company-statistics': '共享开放服务统计 - 按单位统计',
                '/danger-setting/danger-setting': '系统设置 - 采集系统告警设置',
                '/system/user/user-list': '系统管理 - 用户管理',
                '/system/role/role-list': '系统管理 - 角色管理'
            }
        },
        methods: {
            toUser: function () {
                /*if (this.limitsRoleCenter) {
                    window.open('../user/index.html');
                }*/
            },
            showRemindContent: function () {
                this.isShow = !this.isShow;
                if (this.isShow)
                    $('.remind-content').fadeIn('fast');
                else
                    $('.remind-content').fadeOut('fast');
            },
            getUserDetail: function () {
                if (USERINFO) {
                    this.userDetail.userName = USERINFO.userName;
                    this.userDetail.headImageUrl = USERINFO.headImageUrl;
                    this.userDetail.deptName = USERINFO.deptName;
                    this.isLogin = true;

                    if (USERINFO.roleId == 2 || USERINFO.roleId == 3)
                        this.limitsRoleCenter = false;
                    else
                        this.limitsRoleCenter = true;
                }
            },
            read: function () {
                /*$.post('/alarmReadRecord/updateBatch', JSON.stringify(this.checks), function (data) {
                    if (data.code == 200) {
                        vm.getAlarmRead(true);
                        vm.checks = [];
                    }
                })*/
            },
            getAlarmRead: function (isRefresh) {
                /*if (USERINFO.roleId == 2 || USERINFO.roleId == 3) return false;

                $.get('/alarmReadRecord/queryListByNum/5', function (data) {
                    if (data.code == 200) {
                        vm.alarmReadList = data.data.page;
                        var len = vm.alarmReadList.length;
                        if (len) {
                            vm.isRemind = true;
                            for (var i = 0; i < len; i++) {
                                vm.checks.push(vm.alarmReadList[i].id);
                            }
                        } else {
                            //vm.isRemind = false;

                            if (isRefresh)
                                location.reload();
                        }
                    }
                })*/
            },
            getHeadline: function() {
                var matchStr = /[a-zA-z]+:\/\/([^\s]*).html/.exec(location.href), url = '';
                if(matchStr) {
                    var str = /[a-zA-z]+:\/\/([^\s]*).html/.exec(location.href)[1].split('/');
                    for(var i = 1, len = str.length; i < len; i++ ) {
                        url += '/' + str[i];
                    }
                } else
                    url = '/index';

                url == '/' && (url = '/index');
                this.headline = this.headlineObj[url];
            },
            //获取获取未读消息条数
            getMessageRecord: function() {
                $.ajax('/monitorAndAlarm/getMessageRecord')
                    .done(function(data) {
                        if(data.code == 200) {
                            vm.messageRecordObj = data.data;
                        }
                    })
            },
            loadTabsData: function() {
                // var systemId=$("#systemId").val();
                // var systemId = sessionStorage.getItem("systemId");
                var params = {integrateFlag : 1};
                $.post("/system/productIntegrate/list",
                    params,
                    function(data){
                       var rows= data.data.page.records;
                       var systemId=data.integrateCurNo;
                        sessionStorage.setItem("master",data.master);
                        sessionStorage.setItem("deptMaster",data.deptMaster);
                        var p=$("#topTabs");
                        for(var i=0;i<rows.length;i++){
                            var row=rows[i];
                            var li=$('<li></li>');
                            var a=$('<a style="color: #FFFFFF;"></a>');
                            if(row.productNo==systemId){
                                li.addClass("active")
                                a.attr("href","###");
                            }else{
                                a.attr("href",row.jumpUrl);
                            }
                            a.html("<img src=" + '../../public' + row.icon +"/>&nbsp;"+row.productShowName);
                            if(row.curOpenFlag !="1"){
                                a.attr("target","_blank");
                            }
                            li.append(a);
                            p.append(li);
                        }
                    }
                );
            },
            getSystermName: function() {
                $.ajax({
                    type: "GET",
                    url:"/data/loginInfo",
                    success: function(data) {
                        if(data.code == 200) {
                            if(data.systemName && data.systemSubName) {
                                vm.systemName = data.systemName + '-' + data.systemSubName;
                                $("#systemName")[0].innerText = vm.systemName;
                            } else {
                                vm.systemName = data.systemName;
                                $("#systemName")[0].innerText = vm.systemName
                            }
                        }
                    }
                })
            }
        },
        computed: {
            getTime: function () {
                //获取当前时间
                var timeStr = '';
                var date = new Date();
                var year = date.getFullYear();
                var month = (date.getMonth() + 1).toString().length == 1 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
                var day = date.getDate().toString().length == 1 ? '0' + date.getDate() : date.getDate();
                timeStr = year + '-' + month + '-' + day;

                return timeStr;
            }
        },
        created: function () {
            //获取用户信息
            this.getUserDetail();
            this.getAlarmRead(false);
            this.getHeadline();
            this.getMessageRecord();
        },
        mounted: function () {
            this.$nextTick(function() {
                $('.retract').click(function() {
                    $('.app').toggleClass('app-aside-folded');
                    setTimeout(function() {
                        $(window).trigger("resize");
                    }, 300)
                });

                $('#headline').text(this.headline);
            });
            this.loadTabsData();
            this.getSystermName();
        }
    });

    (function() {
        $('#userName').text(USERINFO.userName.length > 5 ?
        USERINFO.userName.substr(0, 5) + '...': USERINFO.userName)
            .attr('title', USERINFO.userName);
        USERINFO.headImageUrl && $('#userPortrait').attr('src', USERINFO.headImageUrl);
    }())
});
