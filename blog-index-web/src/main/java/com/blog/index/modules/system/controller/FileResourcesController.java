package com.blog.index.modules.system.controller;

import cn.hutool.core.io.FileUtil;
import com.blog.common.utils.CustomException;
import com.blog.common.utils.DateUtils;
import com.blog.common.utils.UuidBuild;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author wangfj
 * @date 2019-06-14 10:40
 * @description DESCRIPTION
 */
@RestController
public class FileResourcesController {

    @Value("${image.upload-path}")
    private String filePath;

//    @Value("${server.context-path}")
    private String contextPath = "";

    /**
     * 上传图片
     * @return
     */
    @PostMapping("/uploadImage" )
    @ApiOperation(value = "上传图片", notes = "上传图片" )
    public String uploadImage(@RequestParam("image") MultipartFile file){
        if (file == null){
            throw new CustomException("上传失败",708);
        }
        //文件名称
        String imageName = file.getOriginalFilename();
        //获取扩展名
        String extName = FileUtil.extName(imageName);
        String saveData = DateUtils.formatCustom(new Date(),"yyyyMMdd");
        String imageDatePath = FileUtil.getAbsolutePath(filePath + File.separator + saveData + "/");
        //创建目录
        FileUtil.mkdir(imageDatePath);
        //随机生成uuid作为上传的文件名称
        String fileUuid = UuidBuild.getUUID();

        //图片访问url
        String imageUrl = contextPath + "/" + saveData + "/" + fileUuid + "." + extName;
        File localFile = new File(imageDatePath + fileUuid + "." + extName);
        try {
            //文件写入指定位置
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageUrl;
    }

}
