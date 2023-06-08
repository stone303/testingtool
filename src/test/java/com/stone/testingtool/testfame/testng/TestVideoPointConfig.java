package com.stone.testingtool.testfame.testng;

import com.stone.testingtool.testfame.config.EnvTest;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author guocang.shi
 */
public class TestVideoPointConfig {
    @Test
    void videoPointConfigTest()
    {
        // 自定义HttpClientConfig对象
        // 设置响应超时时长为3秒，单位是毫秒
        HttpClientConfig clientConfig = HttpClientConfig
                .httpClientConfig()
                .setParam("http.socket.timeout", 3000);
        // 定义RestAssuredConfig对象
        // 传入自定义的HttpClientConfig对象
        RestAssuredConfig myTimeout = RestAssuredConfig
                .config()
                .httpClient(clientConfig);

        String param="{\"limit\":10,\"pageNo\":1,\"total\":71,\"pointName\":\"\"}";

        given().config(myTimeout).header("authorization", EnvTest.getworktaken()).
                body(param).contentType(ContentType.JSON).log().all().
                when().
                post(EnvTest.getUrl()+"/videoPointConfig/queryPage").
                then().
                log().
                all().statusCode(200).
                body("msg",equalTo("success"))
                .body("data.total",equalTo(5));
    }
}

