

package org.opengoofy.congomall.test.yaml;

import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

import java.util.Collections;

public class YamlTestApplicationTests {
    
    @Test
    public void assertYaml() {
        Plate plate = new Plate(new Apple("1", "苹果"), new Banana("2", "香蕉"));
        CustomerRepresenter customerRepresenter = new CustomerRepresenter();
        customerRepresenter.addClassTag(plate.getClass(), Tag.MAP);
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setLineBreak(DumperOptions.LineBreak.getPlatformLineBreak());
        String yaml = new Yaml(customerRepresenter, dumperOptions).dumpAs(Collections.singletonList(plate), null, DumperOptions.FlowStyle.BLOCK);
        System.out.println(yaml);
    }
}
