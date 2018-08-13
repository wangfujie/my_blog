package com.blog.index.modules.system.controller;

import com.blog.common.result.R;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author wangfujie
 * @date 2018-08-10 16:03
 * @description 验证码接口
 */
@RestController
@RequestMapping("/sys/code")
@Api(value = "验证码", description = "验证码接口")
public class SysCodeController {

    @Autowired
    private Producer producer;

    /**
     * 生成验证码
     * @param response
     * @param httpSession
     * @throws IOException
     */
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, HttpSession httpSession) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到session
        httpSession.setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    @PostMapping("/validate/{code}")
    @ApiOperation(value = "校验验证码", notes = "校验验证码")
    public R validateCode(@PathVariable("code") String code, HttpSession httpSession) {
        String kaptcha = (String) httpSession.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.hasLength(kaptcha) && StringUtils.hasLength(code)) {
            if (kaptcha.equals(code)) {
                return R.ok("校验成功");
            }
        }
        return R.error("验证码错误");
    }
}