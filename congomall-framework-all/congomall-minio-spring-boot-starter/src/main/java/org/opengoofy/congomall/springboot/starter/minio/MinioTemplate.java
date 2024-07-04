package org.opengoofy.congomall.springboot.starter.minio;

import org.opengoofy.congomall.springboot.starter.minio.config.MinioProperties;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Minio 模板操作
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@AllArgsConstructor
public class MinioTemplate implements MinioOperations {
    
    private final MinioClient minioClient;
    
    private final MinioProperties minioProperties;
    
    @SneakyThrows
    @Override
    public ObjectWriteResponse upload(PutObjectArgs args) {
        return minioClient.putObject(args);
    }
    
    @SneakyThrows
    @Override
    public String upload(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        String[] fileNameSplit = fileName.split("\\.");
        fileName = fileNameSplit.length > 1 ? fileNameSplit[0] + "_" + System.currentTimeMillis() + "." + fileNameSplit[1] : fileName + "_" + System.currentTimeMillis();
        try (InputStream inputStream = multipartFile.getInputStream()) {
            PutObjectArgs objectArgs = PutObjectArgs.builder()
                    .bucket(minioProperties.getBucket())
                    .object(fileName)
                    .stream(inputStream, inputStream.available(), -1L)
                    .contentType(multipartFile.getContentType())
                    .build();
            minioClient.putObject(objectArgs);
        }
        return fileName;
    }
}
