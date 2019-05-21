new Vue({
    el: "#detailVue",
    data:{
        headMenu:[],
        recommendList:[],
        tagList:[],
        readRanking:[],
        friendLinks:[],
        treatiseInfo:{}
        },
    methods:{
        initInfo:function () {
            var self = this;

            //获取公共头菜单列表
            $.ajax({
                url:"/blog/blogCategory/getBlogMenuNode",
                type:"GET",
                success:function(data){
                    if (data.code == 200){
                        self.headMenu = data.data.list;
                    }
                }
            });

            // 推荐
            $.ajax({
                url:"/blog/blogTreatise/getRecommend",
                type:"GET",
                success:function(data){
                    if (data.code == 200){
                        self.recommendList = data.data.list;
                    }
                }
            });

            //标签云
            $.ajax({
                url:"/blog/blogTags/getShowTags",
                type:"GET",
                success:function(data){
                    if (data.code == 200){
                        self.tagList = data.data.list;
                    }
                }
            });

            //阅读排行，10条
            $.ajax({
                url:"/blog/blogTreatise/getReadRanking",
                type:"GET",
                data:{"currentPage":1,"pageSize":10},
                success:function(data){
                    if (data.code == 200){
                        self.readRanking = data.data.page.records;
                    }
                }
            });

            // 友情链接查询
            $.ajax({
                url:"/blog/blogFriendlyLinks/list",
                type:"GET",
                data:{"currentPage":1,"pageSize":5},
                success:function(data){
                    if (data.code == 200){
                        self.friendLinks = data.data.page.records;
                    }
                }
            });
        },
        getTreatiseDetail:function (treatiseUuid) {
            var self = this;
            $.ajax({
                url:"/blog/blogTreatise/info/" + treatiseUuid,
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
                url:"/blog/blogLogRecord/addRecord",
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
                alert("您点的太快了！不要太快哦！");
                console.log("点赞文章,接口调用失败");
            });
        },
        initDatePicker : function () {
            //使代码部分高亮显示
            SyntaxHighlighter.all();
        }
    },
    watch:{
        treatiseInfo:function(){
            //延迟加载，使代码部分高亮显示
            this.$nextTick(function () {
                this.initDatePicker();
            });
        }
    },
    created: function () {
        //初始数据加载
        this.initInfo();
        //获取参数
        var params = getRequestParams(window.location.search);
        var uuid = params.uuid;
        //如果传有主键uuid，则加载详情数据
        if (uuid){
            //初始化数据
            this.getTreatiseDetail(uuid);
        }
    }
});