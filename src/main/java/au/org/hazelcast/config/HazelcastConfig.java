package au.org.hazelcast.config;

import au.org.hazelcast.extractor.JsonAttributeExtractor;
import au.org.hazelcast.model.JsonWrapper;
import au.org.hazelcast.serializer.JsonWrapperSerializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.nio.serialization.StreamSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by proy on 19/11/16.
 */
@Configuration
public class HazelcastConfig {
    @Bean
    Config config(JsonWrapperSerializer jsonWrapperSerializer) {
        Config config = new Config();
        config.getSerializationConfig().addSerializerConfig(getSerializerConfig(jsonWrapperSerializer, JsonWrapper.class));
        config.addMapConfig(mapConfig());
        return config;
    }

    @Bean
    HazelcastInstance hazelcastInstance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }

    private SerializerConfig getSerializerConfig(StreamSerializer serializer, Class clazz) {
        SerializerConfig config = new SerializerConfig()
                .setImplementation(serializer)
                .setTypeClass(clazz);
        return config;
    }

    @Bean
    MapConfig mapConfig() {
        MapConfig config = new MapConfig("json-map-store");
        config.getMapAttributeConfigs().add(mapAttributeConfig());
        config.addMapIndexConfig(mapIndexConfig());
        return config;
    }

    MapAttributeConfig mapAttributeConfig() {
        MapAttributeConfig mapAttributeConfig = new MapAttributeConfig();
        mapAttributeConfig.setName("attribute");
        mapAttributeConfig.setExtractor(JsonAttributeExtractor.class.getCanonicalName());
        return mapAttributeConfig;
    }

    MapIndexConfig mapIndexConfig() {
        MapIndexConfig mapIndexConfig = new MapIndexConfig("attribute[name]", true);
        return mapIndexConfig;
    }
}
