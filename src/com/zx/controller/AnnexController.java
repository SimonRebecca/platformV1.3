package com.zx.controller;

import com.zx.service.AnnexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by zhangxin on 2015-08-13.
 */
@Controller
@RequestMapping("annex")
public class AnnexController {

    @Autowired
    private AnnexService annexService;

    @Description("上传附件")
    @RequestMapping("uploadFile")
    public void uploadFile(@RequestParam("uploadFile") MultipartFile[] files, HttpServletRequest request) throws IOException {
        annexService.uploadFile(files, request);
    }

}
