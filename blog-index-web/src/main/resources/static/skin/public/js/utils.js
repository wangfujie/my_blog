/**
 * 将url传参的参数转为对象
 * @param url
 */
function getRequestParams(url) {
// var url = location.search; //获取url中"?"符后的字串
    var theParams = {};
    if (url.indexOf("?") != -1) {
        var str = url.substring(url.indexOf("?")+1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theParams[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
    return theParams;
}