new Vue({
    el: "#vueBodyDiv",
    data:{
        headMenu:[],
        recommendList:[],
        tagList:[],
        readRanking:[],
        friendLinks:[],
        treatiseList:[]
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

            //增加网站浏览记录
            $.ajax({
                url:"/blog/blogLogRecord/addRecord",
                type: "POST",
                data:{"recordType": 3}
            }).then(function (value) {
                if (value.code == 200) {
                    console.log(value.code);
                }
            }).fail(function () {
                console.log("增加网站浏览记录,接口调用失败");
            });
        },
        //获取文章列表
        getTreatiseList:function (pageNum,keyWord) {
            var self = this;
            if (pageNum == 1){
                self.treatiseList = [];
            }
            $.ajax({
                url:"/blog/blogTreatise/list",
                type:"GET",
                data:{"currentPage":pageNum,"pageSize":8,"keyWord":keyWord},
                success:function(value){
                    if (value.code == 200){
                        $('.pageList').pagination({
                            pageCount: value.data.page.pages,
                            current: value.data.page.current,
                            coping: true,
                            homePage: '首页',
                            endPage: '末页',
                            prevContent: '上页',
                            nextContent: '下页',
                            callback: function (api) {
                                self.getTreatiseList(api.getCurrent(),keyWord);
                                $('html , body').animate({scrollTop: 0},'slow');
                            }
                        });
                        self.treatiseList = value.data.page.records;
                    }
                }
            });
        }
    },
    created: function () {
        //获取公共部分数据初始数据
        this.initInfo();
        //获取第一页文章
        this.getTreatiseList(1);
    },
    mounted() {
        var vueThis = this;
        //搜索点击事件
        $('#keyboardQuery').click(function () {
            var keyWord = $("#keyboard").val();
            vueThis.getTreatiseList(1, keyWord);
            $('html,body').animate({ scrollTop: 0 }, 500);
        });
    }
});

// var pages = 1;
// var thisPage = 1;
// var keyWord = "";
// $(function(){
//     //获取参数
//     var params = getRequestParams(window.location.search);
//     keyWord = params.keyWord;
//     //默认加载列表
//     getTreatiseList(thisPage,keyWord);
//
//     $(window).scroll(function () {
//         if ($(window).scrollTop() >= 25) {
//             thisPage++;
//             if (thisPage <= pages){
//                 getTreatiseList(thisPage,keyWord);
//             }
//         }
//     });
//
//     //增加网站浏览记录
//     addLogRecord();
// });
//
// //博客文章列表查询
// function getTreatiseList(pageNum,keyWord){
//     if (pageNum == 1){
//         $("#treatise-list").empty();
//     }
//     $.ajax({
//         url:"/blog/blogTreatise/list",
//         type:"GET",
//         data:{"currentPage":pageNum,"pageSize":5,"keyWord":keyWord},
//         success:function(data){
//             if (data.code == 200){
//                 pages = data.data.page.pages;
//                 $(data.data.page.records).each(function () {
//                     var li = '<li>' +
//                         '<h2><a href="/knowledge/treatise-detail.html?uuid=' + this.uuid + '" title="'+this.treatiseTitle+'">'+this.treatiseTitle+'</a></h2>' +
//                         '<p class="blogtext">' + this.treatisePreview + '</p>' +
//                         '<p class="bloginfo">' +
//                             '<span>'+(this.source == 1 ? '原创' : '转载') + '</span>' +
//                             '<span>'+this.createTime+'</span>' +
//                             '<span>[<a href="/knowledge/knowledge.html?categoryId='+this.fId+'&thisCategory='+this.categoryId+'">'+this.categoryName+'</a>]</span>' +
//                             '<span>阅读('+this.readNum+')</span>' +
//                         '</p>' +
//                         '</li>';
//                     $("#treatise-list").append(li);
//                 });
//             }
//         }
//     });
// }
//
// /**
//  * 增加网站浏览记录
//  */
// function addLogRecord() {
//     $.ajax({
//         url:"/blog/blogLogRecord/addRecord",
//         type: "POST",
//         data:{"recordType": 3}
//     }).then(function (value) {
//         if (value.code == 200) {
//             console.log(value.code);
//         }
//     }).fail(function () {
//         console.log("增加网站浏览记录,接口调用失败");
//     });
// }