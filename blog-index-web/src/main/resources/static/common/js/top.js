$(function(){
    //监听回到顶部按钮的显示隐藏
    $(window).scroll(function () {
        if ($(window).scrollTop() >= 220) {
            $('#btn_top').fadeIn();
        }
        else {
            $('#btn_top').fadeOut();
        }
    });
    //回到顶部按钮的点击回到顶部
    $('#btn_top').click(function () {
        $('html,body').animate({ scrollTop: 0 }, 500);
    });
});