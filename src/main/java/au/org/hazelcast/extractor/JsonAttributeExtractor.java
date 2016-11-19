package au.org.hazelcast.extractor;

import au.org.hazelcast.model.JsonWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.hazelcast.query.extractor.ValueCollector;
import com.hazelcast.query.extractor.ValueExtractor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by proy on 19/11/16.
 */
@Slf4j
public class JsonAttributeExtractor extends ValueExtractor<JsonWrapper, String> {
    @Override
    public void extract(JsonWrapper jsonWrapper, String string, ValueCollector valueCollector) {
        valueCollector.addObject(jsonWrapper.getAttribute(string));
    }
}
