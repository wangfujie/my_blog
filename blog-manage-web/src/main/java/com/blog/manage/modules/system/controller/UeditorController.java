package com.blog.manage.modules.system.controller;

import com.blog.manage.common.ueditor.ActionEnter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wangfujie
 * @date 2018-10-18 15:00
 * @description 用于处理关于ueditor插件相关的请求
 */
@RestController
@CrossOrigin
@RequestMapping("/sys/ueditor")
public class UeditorController {

    @RequestMapping(value = "/exec")
    public String exec(HttpServletRequest request) throws Exception{
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("=========================rootPath: " + rootPath);
        return  new ActionEnter( request, rootPath).exec();
    }

//    @RequestMapping(value ="upload")
//    public String uploadImage(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        //这个是UEditor需要的返回值内容，UEditor要的返回值需要封装成Json格式
//        ReturnUploadImage rui = null;
//        // 转型为MultipartHttpRequest：
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        // 获得文件：
//        MultipartFile file = multipartRequest.getFile("upfile"); //UEditor传到后台的是这个upfile，其他的文件上传，应该也差不多是这个，还没去研究，断点一下就知道了
//        // 写入文件
//        File imageFile = new File("/" + "Uuid()saadsa" + ".jpg");
//        file.transferTo(imageFile);
//        //现在获取了File接下来要上传到OSS上
//        if (imageFile != null) {
//            rui = new ReturnUploadImage();
//            //这里需要设置文件名称如：xxx.jpg
//            rui.setTitle(imageFile.getName());
//            //这里需要设置文件名称如：xxx.jpg
//            rui.setOriginal(imageFile.getName());
//            // 判断文件是否为图片文件
//            String r = ImageUtils.fileDetermine(imageFile, 3 * 1024);
//            if (!StringUtils.isEmpty(r)) {
//                // 上传文件(这里文件类型，要根据实际上传的类型去做，暂时是直接设置了.jpg，并且先保存到磁盘，这样对磁盘比较伤，每次上传都要先保存到磁盘，然后再删除)
//                ResultInfo resultInfo = OSSObjTools.uploadObject(imageFile,
//                        "subWebPublicNotice");//这里是自己封装的OSS，上传到OSS上面
//                // 判断如果返回结果不为空并且MD5返回值比较结果正确，就设置文件路径保存到数据库
//                if (resultInfo != null && resultInfo.geteTag().equalsIgnoreCase(MD5Tools.file2MD5(imageFile))) {
//                    rui.setState("SUCCESS");//这里上传成功的话一定要设置大写的 SUCCESS，失败还没测试，猜应该是FAIL，回头再去官网找找
//                    rui.setUrl(CommonTools.catchUrlPath(PubParam.BUCKET_NAME,
//                            PubParam.Mark_ShenZhen) + resultInfo.getFilePath());//这里是设置返回给UEditor的图片地址
//                }
//            }
//            // 判断临时存放的文件是否存在
//            if (imageFile.exists()) {
//                // 删除临时存放的文件
//                imageFile.delete();
//            }
//        }
//        //这边就是为了返回给UEditor做的格式转换
//        String result = JSON.toJSONString(rui);
//        response.getWriter().write(result);
//        return null;
//    }
}