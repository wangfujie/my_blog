package com.blog.manage.modules.resource.service.impl;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.blog.common.result.R;
import com.blog.common.utils.DateUtils;
import com.blog.common.utils.UuidBuild;
import com.blog.manage.modules.resource.mapper.BlogFileMapper;
import com.blog.manage.modules.resource.service.IBlogFileService;
import com.blog.pojo.entity.BlogFile;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 文件信息表 服务接口实现类
 */
@Service
@Transactional
public class BlogFileServiceImpl extends ServiceImpl<BlogFileMapper, BlogFile> implements IBlogFileService {

    @Value("${resource.upload-path}")
    private String filePath;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public R uploadFile(MultipartFile file) {
        //文件名称
        String fileName = file.getOriginalFilename();
        String fileDatePath = FileUtil.getAbsolutePath(filePath + File.separator + DateUtils.formatCustom(new Date(),"yyyyMMdd") + "/");
        //创建目录
        FileUtil.mkdir(fileDatePath);
        //随机生成uuid作为上传的文件名称
        String fileUuid = UuidBuild.getUUID();
        File localFile = new File(fileDatePath + fileUuid);
        try {
            //文件写入指定位置
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件信息存入数据库
        BlogFile blogFile = new BlogFile();
        blogFile.setFileName(fileName);
        blogFile.setFilePath(fileDatePath + fileUuid);
        //获取文件大小，字节转带单位
        String fileSize = FileUtils.byteCountToDisplaySize(file.getSize());
        blogFile.setFileSize(fileSize);
        blogFile.setFileType(file.getContentType());
        blogFile.setShortPath(fileDatePath);
        blogFile.setFileUuid(fileUuid);
        blogFile.setCreateTime(new Date());
        insert(blogFile);
        return R.fillSingleData(blogFile);
    }

    /**
     * 下载文件
     *
     * @param blogFile
     * @param response
     */
    @Override
    public void downloadFile(BlogFile blogFile, HttpServletResponse response) throws FileNotFoundException {
        //输入流读取文件
        InputStream is = new FileInputStream(new File(blogFile.getFilePath()));

        //文件名称编码设置，处理中文
        String fileName = null;
        try {
            fileName = URLEncoder.encode(blogFile.getFileName(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //设置返回的请求头
        response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
        response.setContentType("application/octet-stream");
        OutputStream out = null;

        try {
            out = response.getOutputStream();
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) > 0) {
                out.write(b, 0, len);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}