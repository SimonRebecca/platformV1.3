package com.zx.service;

import com.zx.base.BaseService;
import com.zx.pojo.Annex;
import com.zx.util.WebUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangxin on 2015-08-13.
 */
@Service
public class AnnexService extends BaseService<Annex> {

    public void uploadFile(MultipartFile[] files, HttpServletRequest request) throws IOException {
        // 文件保存路径
        String filePath = request.getSession().getServletContext().getRealPath("/annex/" + WebUtil.getCurrentYear() + "/" + WebUtil.getCurrentMonth() + "/");
        File f = new File(filePath);
        if (!f.exists()) {
            f.mkdirs();
        }
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                // 保存到数据
                Annex annex = new Annex();
                annex.setAnnexName(file.getOriginalFilename());
                annex.setCreateTime(new Date());
                Serializable annexId = super.save(annex);
                //完整路径
                String suffer = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String pathName = filePath + "/" + WebUtil.getCurrentYMD() + "-" + annexId + suffer;
                //转存文件
                file.transferTo(new File(pathName));
                //更新路径到数据库
                annex.setAnnexPath(pathName);
                super.update(annex);
            }
        }
    }

}
