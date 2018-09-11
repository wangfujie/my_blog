var keyWord = "";
var thisCategory = 0;
$(function () {
    var params = getRequestParams(window.location.search);
    var categoryId = params.categoryId;
    thisCategory = params.thisCategory;
    //默认加载分类
    getCategoryList(categoryId,thisCategory);
    //默认加载列表
    if (thisCategory == null || thisCategory == 0){
        thisCategory = categoryId;
    }
    getTreatiseList(1,keyWord,thisCategory);
    $('#keyboardQuery').click(function () {
        keyWord = $("#keyboard").val();
        getTreatiseList(1, keyWord,thisCategory);
    });
    //为分类a标签添加点击事件
    $("#categoryList").on("click","a",function(event){
        //获取点击标签的val值
        thisCategory = event.target.getAttribute("val");
        //删除所有标签的id属性
        $("#categoryList a").removeAttr("id");
        //设置点击标签的id属性，选中
        event.target.id = "thisCategory";
        //加载查询列表
        getTreatiseList(1,keyWord,thisCategory);
    })
});

/**
 * 博客文章列表查询
 * @param pageNum
 * @param keyWord
 */
function getTreatiseList(pageNum,keyWord,categoryId) {
    $("#treatise-list").empty();
    $.ajax({
        url: "/blogTreatise/list",
        type: "GET",
        data: {"currentPage": pageNum, "pageSize": 5, "keyWord": keyWord, "categoryId":categoryId},
        success: function (data) {
            if (data.code == 200) {
                $('.pageList').pagination({
                    pageCount: data.data.page.pages,
                    current: data.data.page.current,
                    jump: true,
                    coping: true,
                    homePage: '首页',
                    endPage: '末页',
                    prevContent: '上页',
                    nextContent: '下页',
                    callback: function (api) {
                        getTreatiseList(api.getCurrent(), keyWord, categoryId);
                    }
                });
                $(data.data.page.records).each(function () {
                    var li = '<li>' +
                        '<h2><a href="/knowledge/treatise-detail.html?uuid=' + this.uuid + '" title="' + this.treatiseTitle + '">' + this.treatiseTitle + '</a></h2>' +
                        '<p class="blogtext">' + this.treatisePreview + '</p>' +
                        '<p class="bloginfo">' +
                        '<span>' + (this.source == 1 ? '原创' : '转载') + '</span>' +
                        '<span>' + this.createTime + '</span>' +
                        '<span>[<a href="/blogCategory/info/' + this.categoryId + '">' + this.categoryName + '</a>]</span>' +
                        '<span>阅读(' + this.readNum + ')</span>' +
                        '</p>' +
                        '</li>';
                    $("#treatise-list").append(li);
                });
            }
        }
    });
}

/**
 * 获取分类列表
 * @param categoryId
 * @param thisCategory
 */
function getCategoryList(categoryId,thisCategory){
    $.ajax({
        url: "/blogCategory/getCategoryList",
        type: "GET",
        data: {"categoryId":categoryId},
        success: function (data) {
            if (data.code == 200) {
                $(data.data.list).each(function () {
                    var a;
                    if (thisCategory == this.id){
                        a = '<a id="thisCategory" val="'+this.id+'">'+this.categoryName+'</a>';
                    } else {
                        a = '<a val="'+this.id+'">'+this.categoryName+'</a>';
                    }
                    $("#categoryList").append(a);
                });
            }
        }
    });
}