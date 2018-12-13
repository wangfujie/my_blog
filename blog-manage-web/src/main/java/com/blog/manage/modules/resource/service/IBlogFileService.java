package com.blog.manage.modules.resource.service;

import com.baomidou.mybatisplus.service.IService;
import com.blog.common.result.R;
import com.blog.pojo.entity.BlogFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 文件信息表 服务接口
 */
public interface IBlogFileService extends IService<BlogFile> {

    /**
     * 上传文件
     * @param file
     * @return
     */
    R uploadFile(MultipartFile file);
}