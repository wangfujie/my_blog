var pages = 1;
var thisPage = 1;
var keyWord = "";
$(function(){
    //获取参数
    var params = getRequestParams(window.location.search);
    keyWord = params.keyWord;
    //默认加载列表
    getTreatiseList(thisPage,keyWord);

    $(window).scroll(function () {
        if ($(window).scrollTop() >= 25) {
            thisPage++;
            if (thisPage <= pages){
                getTreatiseList(thisPage,keyWord);
            }
        }
    });

    //增加网站浏览记录
    addLogRecord();
});

//博客文章列表查询
function getTreatiseList(pageNum,keyWord){
    if (pageNum == 1){
        $("#treatise-list").empty();
    }
    $.ajax({
        url:"/blogTreatise/list",
        type:"GET",
        data:{"currentPage":pageNum,"pageSize":5,"keyWord":keyWord},
        success:function(data){
            if (data.code == 200){
                pages = data.data.page.pages;
                $(data.data.page.records).each(function () {
                    var li = '<li>' +
                        '<h2><a href="/knowledge/treatise-detail.html?uuid=' + this.uuid + '" title="'+this.treatiseTitle+'">'+this.treatiseTitle+'</a></h2>' +
                        '<p class="blogtext">' + this.treatisePreview + '</p>' +
                        '<p class="bloginfo">' +
                            '<span>'+(this.source == 1 ? '原创' : '转载') + '</span>' +
                            '<span>'+this.createTime+'</span>' +
                            '<span>[<a href="/knowledge/knowledge.html?categoryId='+this.fId+'&thisCategory='+this.categoryId+'">'+this.categoryName+'</a>]</span>' +
                            '<span>阅读('+this.readNum+')</span>' +
                        '</p>' +
                        '</li>';
                    $("#treatise-list").append(li);
                });
            }
        }
    });
}

/**
 * 增加网站浏览记录
 */
function addLogRecord() {
    $.ajax({
        url: "/blogLogRecord/addRecord",
        type: "POST",
        data:{"recordType": 3}
    }).then(function (value) {
        if (value.code == 200) {
            console.log(value.code);
        }
    }).fail(function () {
        console.log("增加网站浏览记录,接口调用失败");
    });
}