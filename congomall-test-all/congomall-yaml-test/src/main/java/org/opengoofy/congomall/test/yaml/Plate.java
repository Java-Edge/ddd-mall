

package org.opengoofy.congomall.test.yaml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 盘子
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plate {
    
    private Apple apple;
    
    private Banana banana;
}
