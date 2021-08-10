package com.xkf.system.controller;

import com.xkf.system.bean.ResultObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author xukefei
 * @create 2021-08-09 下午1:45
 */
@RestController
@ResponseBody
public class UpLoadController {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, headers = "content-type=multipart/form-data")
    @ApiOperation(value = "上传文件", notes = "上传文件", httpMethod = "POST")
    public ResultObject upload(@RequestPart(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultObject.error("文件为空，请选择文件", null);
        }
        String fileName = file.getOriginalFilename();
        String filePath = "/Users/xianyubuxian/uploadfiles/";

        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);
            return ResultObject.success("上传成功", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultObject.error("上传失败", null);
    }
}
