new Vue({
    el: "#treatiseDetail",
    data:{treatiseInfo:{}},
    methods:{
        initInfo:function (treatiseUuid) {
            var self = this;
            $.ajax({
                url: "/blogTreatise/info/" + treatiseUuid,
                type: "GET"
            }).then(function (value) {
                if (value.code == 200) {
                    var tags = value.data.object.tags;
                    if (tags){
                        value.data.object.tagsList = tags.split(",");
                    }
                    self.treatiseInfo = value.data.object;
                }
            }).fail(function () {
                console.log("获取失败");
            });
        },
        addPraiseNum: function () {
            var self = this;
            $.ajax({
                url: "/blogLogRecord/addRecord",
                type: "POST",
                data:{"recordType": 1, "treatiseUuid":self.treatiseInfo.uuid}
            }).then(function (value) {
                if (value.code == 200) {
                    self.treatiseInfo.praiseNum = self.treatiseInfo.praiseNum + 1;
                    alert(value.msg);
                }else {
                    alert(value.msg);
                }
            }).fail(function () {
                console.log("点赞文章,接口调用失败");
            });
        }
    },
    created: function () {
        //获取参数
        var params = getRequestParams(window.location.search);
        var uuid = params.uuid;
        //如果传有主键uuid，则加载详情数据
        if (uuid){
            //初始化数据
            this.initInfo(uuid);
        }
    },
    mounted() {
        //使代码部分高亮显示
        SyntaxHighlighter.all();
    }
});