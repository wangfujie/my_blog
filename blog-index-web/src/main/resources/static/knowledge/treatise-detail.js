$(function () {
   var params = getRequestParams(window.location.search);
   var uuid = params.uuid;
    $.ajax({
        url:"/blogTreatise/info/" + uuid,
        type:"GET",
        success:function(data){
            if (data.code == 200){
               var treatise = data.data.object;
               //标题
                $("#treatise_title").text(treatise.treatiseTitle);
                //来源
                $("#treatise_source").text(treatise.source == 1 ? "原创" : "转载");
                //时间
                $("#create_time").text(treatise.createTime);
                //分类
                $("#category_type").text(treatise.categoryName);
                //阅读
                $("#read_num").text(treatise.readNum);
                //标签
                var tag_aar = treatise.tags.split(",");
                for (var tag in tag_aar){
                    var tag_a = '<a href="#" target="_blank">'+tag_aar[tag]+'</a>';
                    $("#the_tags").append(tag_a);
                }
               //简介
                var summary = '<strong>简介</strong>';
                $("#summary").append(summary);
                $("#summary").append(treatise.treatisePreview);
                //正文
                $("#treatise_body").append(treatise.treatiseBody);
                //转载
                if (treatise.source == 2){
                    var p = '<p>转载自：<a target="_blank" href="'+treatise.reprintUrl+'">'+treatise.reprintUrl+'</a></p>';
                    $("#treatise_body").append(p);
                }
                //赞数量
                $("#diggnum").text(treatise.praiseNum);
            }
        }
    });
});