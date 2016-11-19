package au.org.hazelcast.serializer;

import au.org.hazelcast.model.JsonWrapper;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by proy on 19/11/16.
 */
@Component
public class JsonWrapperSerializer implements StreamSerializer<JsonWrapper> {
    @Override
    public void write(ObjectDataOutput objectDataOutput, JsonWrapper jsonWrapper) throws IOException {
        objectDataOutput.writeUTF(jsonWrapper.getRawJson());
    }

    @Override
    public JsonWrapper read(ObjectDataInput objectDataInput) throws IOException {
        return new JsonWrapper(objectDataInput.readUTF());
    }

    @Override
    public int getTypeId() {
        return 3;
    }

    @Override
    public void destroy() {

    }
}
