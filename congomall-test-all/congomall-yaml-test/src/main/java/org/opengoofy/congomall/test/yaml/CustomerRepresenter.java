

package org.opengoofy.congomall.test.yaml;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自定义 Representer
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
public class CustomerRepresenter extends Representer {
    
    @Override
    protected NodeTuple representJavaBeanProperty(final Object javaBean, final Property property, final Object propertyValue, final Tag customTag) {
        NodeTuple nodeTuple = super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);
        return nodeTuple;
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    protected Node representMapping(final Tag tag, final Map<?, ?> mapping, final DumperOptions.FlowStyle flowStyle) {
        Map skippedEmptyValuesMapping = new LinkedHashMap<>(mapping.size(), 1);
        for (Map.Entry<?, ?> entry : mapping.entrySet()) {
            if (entry.getValue() instanceof Collection && ((Collection) entry.getValue()).isEmpty()) {
                continue;
            }
            if (entry.getValue() instanceof Map && ((Map) entry.getValue()).isEmpty()) {
                continue;
            }
            skippedEmptyValuesMapping.put(entry.getKey(), entry.getValue());
        }
        return super.representMapping(tag, skippedEmptyValuesMapping, flowStyle);
    }
}
