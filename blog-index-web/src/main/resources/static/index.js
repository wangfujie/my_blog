var pages = 1;
var thisPage = 1;
var keyWord = "";
$(function(){
    //默认加载列表
    getTreatiseList(thisPage,keyWord);
    $('#keyboardQuery').click(function () {
       thisPage = 1;
       keyWord = $("#keyboard").val();
       getTreatiseList(thisPage, keyWord);
    });
    window.onscroll= function(){
        //变量t是滚动条滚动时，距离顶部的距离
        var t = document.documentElement.scrollTop||document.body.scrollTop;
        //当滚动到距离顶部200px时，继续加载数据
        if(t <= 20){
            thisPage++;
            if (thisPage <= pages){
                getTreatiseList(thisPage,keyWord);
            }
        }
    }
});

//博客文章列表查询
function getTreatiseList(pageNum,keyWord){
    if (pageNum == 1){
        $("#treatise-list").empty();
    }
    $.ajax({
        url:"/blogTreatise/list",
        type:"GET",
        data:{"currentPage":pageNum,"pageSize":3,"keyWord":keyWord},
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
                            '<span>[<a href="/blogCategory/info/'+this.categoryId+'">'+this.categoryName+'</a>]</span>' +
                            '<span>阅读('+this.readNum+')</span>' +
                        '</p>' +
                        '</li>';
                    $("#treatise-list").append(li);
                });
            }
        }
    });
}