

package org.opengoofy.congomall.springboot.starter.minio;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

/**
 * Minio 单元测试
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Slf4j
@SpringBootApplication
public class MinioOperationsTest {
    
    private MinioTemplate minioTemplate;
    
    @Before
    public void before() {
        ConfigurableApplicationContext context = SpringApplication.run(MinioOperationsTest.class);
        minioTemplate = context.getBean(MinioTemplate.class);
    }
    
    @SneakyThrows
    @Test
    public void assertUpload() {
        File file = new File("src/test/resources/example-img.png");
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(), "image/png", new FileInputStream(file));
        String fileName = minioTemplate.upload(multipartFile);
        Assert.assertFalse(StringUtils.isEmpty(fileName));
    }
}
