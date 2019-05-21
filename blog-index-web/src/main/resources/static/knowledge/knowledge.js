new Vue({
    el: "#vueBodyDiv",
    data:{
        headMenu:[],
        recommendList:[],
        tagList:[],
        readRanking:[],
        friendLinks:[],
        categoryList:[],
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
        //获取分类
        getCategoryList:function(categoryId,selectCategory){
            var self = this;
            $.ajax({
                url:"/blog/blogCategory/getCategoryList",
                type: "GET",
                data: {"categoryId":categoryId},
                success: function (data) {
                    if (data.code == 200) {
                        $(data.data.list).each(function () {
                            if (selectCategory == this.id){
                                this['tagId'] = "thisCategory";
                            }else {
                                this['tagId'] = "";
                            }
                        });
                        self.categoryList = data.data.list;
                    }
                }
            });
        },
        //获取文章列表
        getTreatiseList:function (pageNum,keyWord,categoryId) {
            var self = this;
            if (pageNum == 1){
                self.treatiseList = [];
            }
            $.ajax({
                url:"/blog/blogTreatise/list",
                type:"GET",
                data:{"currentPage":pageNum,"pageSize":8,"keyWord":keyWord,"categoryId":categoryId},
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
        //获取参数
        var params = getRequestParams(window.location.search);
        var keyWord = params.keyWord;
        var categoryId = params.categoryId;
        var thisCategory = params.thisCategory;
        //默认加载分类
        this.getCategoryList(categoryId,thisCategory);

        //默认加载列表
        if (thisCategory == null || thisCategory == 0){
            thisCategory = categoryId;
        }

        //获取第一页文章
        this.getTreatiseList(1, keyWord, thisCategory);
    },
    mounted() {
        var vueThis = this;
        //搜索点击事件
        $('#keyboardQuery').click(function () {
            var keyWord = $("#keyboard").val();
            vueThis.getTreatiseList(1, keyWord);
            $('html,body').animate({ scrollTop: 0 }, 500);
        });

        //为分类a标签添加点击事件
        $("#categoryList").on("click","a",function(event){
            //获取点击标签的val值
            var thisCategory = event.target.getAttribute("val");
            //删除所有标签的id属性
            $("#categoryList a").removeAttr("id");
            //设置点击标签的id属性，选中
            event.target.id = "thisCategory";
            var keyWord = $("#keyboard").val();
            //加载查询列表
            vueThis.getTreatiseList(1,keyWord,thisCategory);
        });

    }
});

// var keyWord = "";
// var thisCategory = 0;
// $(function () {
//     var params = getRequestParams(window.location.search);
//     var categoryId = params.categoryId;
//     thisCategory = params.thisCategory;
//     //默认加载分类
//     getCategoryList(categoryId,thisCategory);
//     //默认加载列表
//     if (thisCategory == null || thisCategory == 0){
//         thisCategory = categoryId;
//     }
//     getTreatiseList(1,keyWord,thisCategory);
//     $('#keyboardQuery').click(function () {
//         keyWord = $("#keyboard").val();
//         getTreatiseList(1, keyWord,thisCategory);
//     });
//     //为分类a标签添加点击事件
//     $("#categoryList").on("click","a",function(event){
//         //获取点击标签的val值
//         thisCategory = event.target.getAttribute("val");
//         //删除所有标签的id属性
//         $("#categoryList a").removeAttr("id");
//         //设置点击标签的id属性，选中
//         event.target.id = "thisCategory";
//         //加载查询列表
//         getTreatiseList(1,keyWord,thisCategory);
//     })
// });
//
// /**
//  * 博客文章列表查询
//  * @param pageNum
//  * @param keyWord
//  */
// function getTreatiseList(pageNum,keyWord,categoryId) {
//     $("#treatise-list").empty();
//     $.ajax({
//         url:"/blog/blogTreatise/list",
//         type: "GET",
//         data: {"currentPage": pageNum, "pageSize": 5, "keyWord": keyWord, "categoryId":categoryId},
//         success: function (data) {
//             if (data.code == 200) {
//                 $('.pageList').pagination({
//                     pageCount: data.data.page.pages,
//                     current: data.data.page.current,
//                     jump: true,
//                     coping: true,
//                     homePage: '首页',
//                     endPage: '末页',
//                     prevContent: '上页',
//                     nextContent: '下页',
//                     callback: function (api) {
//                         getTreatiseList(api.getCurrent(), keyWord, categoryId);
//                     }
//                 });
//                 $(data.data.page.records).each(function () {
//                     var li = '<li>' +
//                         '<h2><a href="/knowledge/treatise-detail.html?uuid=' + this.uuid + '" title="' + this.treatiseTitle + '">' + this.treatiseTitle + '</a></h2>' +
//                         '<p class="blogtext">' + this.treatisePreview + '</p>' +
//                         '<p class="bloginfo">' +
//                         '<span>' + (this.source == 1 ? '原创' : '转载') + '</span>' +
//                         '<span>' + this.createTime + '</span>' +
//                         '<span>[<a href="/knowledge/knowledge.html?categoryId='+this.fId+'&thisCategory='+this.categoryId+'">'+this.categoryName+'</a>]</span>' +
//                         '<span>阅读(' + this.readNum + ')</span>' +
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
//  * 获取分类列表
//  * @param categoryId
//  * @param thisCategory
//  */
// function getCategoryList(categoryId,thisCategory){
//     $.ajax({
//         url:"/blog/blogCategory/getCategoryList",
//         type: "GET",
//         data: {"categoryId":categoryId},
//         success: function (data) {
//             if (data.code == 200) {
//                 $(data.data.list).each(function () {
//                     var a;
//                     if (thisCategory == this.id){
//                         a = '<a id="thisCategory" val="'+this.id+'">'+this.categoryName+'</a>';
//                     } else {
//                         a = '<a val="'+this.id+'">'+this.categoryName+'</a>';
//                     }
//                     $("#categoryList").append(a);
//                 });
//             }
//         }
//     });
// }