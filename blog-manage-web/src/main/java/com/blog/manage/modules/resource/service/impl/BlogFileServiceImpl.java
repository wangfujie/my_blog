package com.blog.manage.modules.resource.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.blog.common.result.R;
import com.blog.common.utils.UuidBuild;
import com.blog.manage.modules.resource.mapper.BlogFileMapper;
import com.blog.manage.modules.resource.service.IBlogFileService;
import com.blog.pojo.entity.BlogFile;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 文件信息表 服务接口实现类
 */
@Service
@Transactional
public class BlogFileServiceImpl extends ServiceImpl<BlogFileMapper, BlogFile> implements IBlogFileService {

    @Value("${web.upload-path}")
    private String filePath;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public R uploadFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String fileUuid = UuidBuild.getUUID();
        File localFile = new File(filePath + fileUuid);
        try {
            //文件写入指定位置
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件信息存入数据库
        BlogFile blogFile = new BlogFile();
        blogFile.setFileName(fileName);
        blogFile.setFilePath(filePath + fileName);
        //获取文件大小，字节转带单位
        String fileSize = FileUtils.byteCountToDisplaySize(file.getSize());
        blogFile.setFileSize(fileSize);
        blogFile.setFileType(file.getContentType());
        blogFile.setShortPath(filePath);
        blogFile.setFileUuid(fileUuid);
        blogFile.setCreateTime(new Date());
        insert(blogFile);
        return R.fillSingleData(blogFile.getId());
    }
}