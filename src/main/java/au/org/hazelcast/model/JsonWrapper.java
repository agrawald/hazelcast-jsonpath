package au.org.hazelcast.model;

import com.jayway.jsonpath.JsonPath;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by proy on 19/11/16.
 */
@ToString
@NoArgsConstructor
public class JsonWrapper {
    @Getter @Setter
    private String rawJson;

    public JsonWrapper(String rawJson) {
        this.rawJson = rawJson;
    }

    public Object getAttribute(String key) {
        return JsonPath.parse(rawJson).read(key);
    }
}
