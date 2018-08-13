(function(w, d) {

    var LOCAL_PUBLIC = '/public/';
    requirejs({
        paths: {
            'sha_256': LOCAL_PUBLIC+'/libs/sha_256',
            'dec': LOCAL_PUBLIC+'/libs/DEC',
            'encrypt': LOCAL_PUBLIC+'/libs/encrypt'
        },
        shim: {
            'dec': ['jquery']
        }
    });

    require(['jquery', 'vue', 'bootstrap', 'jquery.md5', 'dec', 'encrypt'], function($, Vue) {
        var key=[];
        var vm = new Vue({
            el:'#rrapp',
            data:{
                username: '',
                password: '',
                captcha: '',
                error: false,
                errorMsg: '',
                src: '/captcha.jpg',
                loginTitle: ''
            },
            beforeCreate: function(){
                if(self != top){
                    top.location.href = self.location.href;
                }
            },
            methods: {
                forgotPassword: function() {
                    location.href = './forgot-password.html';
                },
                refreshCode: function(){
                    this.src = "/captcha.jpg?t=" + $.now();
                },
                login: function (event) {
                    var data = "username="+vm.username+"&password="+$.md5(vm.password)+"&captcha="+vm.captcha;
                    $.ajax({
                        type: "get",
                        url: "/data/login",
                        data: data,
                        dataType: "json",
                        success: function(result){
                            if(result.code == 200){//登录成功
                                sessionStorage.setItem("accessToken", result.data.object.accessToken);
                                sessionStorage.setItem("refreshToken", result.data.object.refreshToken);
                                console.log('systemId',result.data.object)
                                sessionStorage.setItem("master",result.data.object.master);
                                // sessionStorage.setItem("systemId",result.data.object.integrateCurNo);

                                $.ajax({
                                    url: '/sysconfig/token',
                                    async: false,
                                    beforeSend: function(request, XHR) {
                                        request.setRequestHeader("token", sessionStorage.getItem('accessToken'));
                                    },
                                    dataType: 'json',
                                    contentType: 'application/json;charset=utf-8',
                                    success: function(data) {
                                        sessionStorage.setItem("isToken", data.data.object.enable);
                                    }
                                });
                                var roleId = result.data.object.user.roleId;
                                //当前页面刷新，shiro自动跳转到配置页面
                                history.go(0);

                            }else{
                                vm.error = true;
                                vm.errorMsg = result.msg;

                                vm.refreshCode();
                            }
                        }
                    });
                },
                getLoginTitle: function() {
                    $.ajax({
                        type: 'GET',
                        url: '/getInfoOnLoginPage',
                        success: function(data) {
                            vm.loginTitle = data.data;
                        },
                    })
                }
            },
            created: function() {
                this.refreshCode();
                this.getLoginTitle();
            },
            mounted: function() {
                this.password && ($("#remember").prop('checked', true));
            },
            watch: {
                username: function(value) {
                }
            }
        });
    });
})(window, document);