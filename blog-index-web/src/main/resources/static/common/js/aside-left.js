$(function(){
    // 推荐
    $.ajax({
        url:"/blogTreatise/getRecommend",
        type:"GET",
        success:function(data){
            if (data.code == 200){
                $(data.data.list).each(function () {
                    var li = '<li><a href="/knowledge/treatise-detail.html?uuid=' + this.uuid + '" title="'+this.treatiseTitle+'">'+this.treatiseTitle+'</a></li>';
                    $("#recommend").append(li);
                });
            }
        }
    });

    //标签云
    $.ajax({
        url:"/blogTags/getShowTags",
        type:"GET",
        success:function(data){
            if (data.code == 200){
                $(data.data.list).each(function () {
                    var a = '<a href="/tags/tags.html?tagName=' + this.tagName + '" target="_blank" >'+this.tagName+'</a>';
                    $("#show_tags").append(a);
                });
            }
        }
    });

    //阅读排行，10条
    $.ajax({
        url:"/blogTreatise/getReadRanking",
        type:"GET",
        data:{"currentPage":1,"pageSize":10},
        success:function(data){
            if (data.code == 200){
                $(data.data.page.records).each(function () {
                    var li = '<li><a href="/knowledge/treatise-detail.html?uuid=' + this.uuid + '" title="'+this.treatiseTitle+'">'+this.treatiseTitle+'</a></li>';
                    $("#read_ranking").append(li);
                });
            }
        }
    });

    // 友情链接查询
    $.ajax({
        url:"/blogFriendlyLinks/list",
        type:"GET",
        data:{"currentPage":1,"pageSize":5},
        success:function(data){
            if (data.code == 200){
                $(data.data.page.records).each(function () {
                    var li = '<li><a href="'+ this.linkUrl + '" title="'+this.linkTitle+'" target="_blank">'+this.linkName+'</a></li>';
                    $(".links").append(li);
                });
            }
        }
    });

    //搜索
    $('#keyboardQuery').click(function () {
        keyWord = $("#keyboard").val();
        window.location.href="/index.html?keyWord=" + keyWord;
    });
});