package demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "feature")
public class FeatureEndPoint {

    public final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

    public FeatureEndPoint() {
        this.featureMap.put("Department",new Feature(true));
        this.featureMap.put("user",new Feature(false));
        this.featureMap.put("Authentication",new Feature(false));

        System.out.println("FeatureEndPoint executed");
    }
    @ReadOperation
    public Map<String, Feature> features(){
        System.out.println("features executed");
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName){
        System.out.println("feature executed");
        return featureMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Feature{
        private boolean isEnabled;
    }
}
