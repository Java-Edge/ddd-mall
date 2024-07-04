

package org.opengoofy.congomall.test.h2;

import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * H2 数据库测试
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class H2Test {
    
    @Test
    @SneakyThrows
    public void h2Test() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        // 如果要测试 h2 持久化存储，请替换存储目录 jdbc:h2:file:/Users/single/Desktop/temp/h2_test_file;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MYSQL
        hikariDataSource.setJdbcUrl("jdbc:h2:mem:config;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MYSQL");
        hikariDataSource.setUsername("sa");
        hikariDataSource.setPassword("");
        try (
                Connection connection = hikariDataSource.getConnection();
                Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS `repository`(id varchar(36) PRIMARY KEY, `key` TEXT, `value` TEXT, parent TEXT)");
            ResultSet resultSet = statement.executeQuery("select id from `repository` where id = '1'");
            if (resultSet.next()) {
                System.out.println(String.format("H2 数据库已存在值: %s", resultSet.getString("id")));
                resultSet.close();
                statement.executeUpdate("update `repository` set `key` = '3', `value` = '4', `parent` = '5' where id = '1'");
                return;
            }
            statement.executeUpdate("insert into `repository` (`id`, `key`, `value`, `parent`) values ('1', '2', '3', '4')");
        }
    }
}
