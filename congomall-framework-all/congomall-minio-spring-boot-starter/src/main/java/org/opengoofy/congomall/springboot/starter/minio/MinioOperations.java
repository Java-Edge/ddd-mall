package org.opengoofy.congomall.springboot.starter.minio;

import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import org.springframework.web.multipart.MultipartFile;

/**
 * 抽象一组基本 Minio 操作的接口，由 {@link MinioTemplate} 实现
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public interface MinioOperations {
    
    /**
     * 上传文件
     *
     * @param args
     * @return
     */
    ObjectWriteResponse upload(PutObjectArgs args);
    
    /**
     * 上传文件
     *
     * @param multipartFile
     * @return 文件名
     */
    String upload(MultipartFile multipartFile);
}
