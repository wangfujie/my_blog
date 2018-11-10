$(function(){
    //获取站点主地址（http://127.0.0.1:8080）
    var url = window.location.origin;

    //获取公共头菜单列表
    $.ajax({
        url:"/blogCategory/getBlogMenuNode",
        type:"GET",
        success:function(data){
            if (data.code == 200){
                $(data.data.list).each(function () {
                    var li = '<li><a href="'+ this.linkUrl + '">'+this.categoryName+'</a>';
                    if (this.subNodeList != null && this.subNodeList.length > 0){
                        li += '<ul class="sub">';
                            this.subNodeList.forEach(function (value,i) {
                                li += '<li><a href="' + value.linkUrl + '">'+value.categoryName+'</a></li>';
                            })
                        li += '</ul>';
                    }
                    li += '</li>';
                    $("#starlist").append(li);
                });
            }
        }
    });
});