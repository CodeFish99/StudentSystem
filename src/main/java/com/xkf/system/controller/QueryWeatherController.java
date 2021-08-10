package com.xkf.system.controller;

import com.xkf.system.bean.ResultObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xukefei
 * @create 2021-08-09 下午4:28
 */
@RestController
public class QueryWeatherController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/queryWeather")
    @ApiOperation(value = "天气查询接口", notes = "返回最近7天天气预报")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "location", value = "地点")
    })
    public ResultObject queryWeather(@RequestParam(name = "location") String location) {
        String apiURL = "http://wthrcdn.etouch.cn/weather_mini?city=" + location;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        if (responseEntity.getStatusCodeValue() == 200) {
            return ResultObject.success("访问成功", responseEntity.getBody());
        } else {
            return ResultObject.error("访问失败", null);
        }
    }
}
