import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javafx.scene.control.Alert;
import models.JavaEETechnology;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class RestProtocolPerformer implements ProtocolPerformer {
    private static final Logger log = LogManager.getLogger(RestProtocolPerformer.class);

    private final Client client;

    private WebResource service;

    RestProtocolPerformer() {
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
    }

    public void connect(String address) {
        service = client.resource(address);
    }

    public List<JavaEETechnology> getAllTechnologies() {
        List<JavaEETechnology> returnedTechnologies = new ArrayList<>();
        String response = service.path("javaeehandbook").accept(MediaType.APPLICATION_JSON).get(String.class);
        JSONArray array = new JSONArray(response);

        for(int i = 0; i < array.length(); ++i) {
            JavaEETechnology technology = new JavaEETechnology();
            technology.fromJSON(array.getJSONObject(i));
            returnedTechnologies.add(technology);
        }

        return returnedTechnologies;
    }

    @Override
    public void insert(JavaEETechnology technology) {
        service.path("javaeehandbook").type(MediaType.APPLICATION_JSON).post(technology.toJSON().toString());
    }

    @Override
    public void delete(JavaEETechnology technology) {
        service.path("javaeehandbook").type(MediaType.APPLICATION_JSON).delete(technology.toJSON().toString());
    }

    @Override
    public void update(JavaEETechnology technology) {
        service.path("javaeehandbook").type(MediaType.APPLICATION_JSON).put(technology.toJSON().toString());
    }

    static void showErrorAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
