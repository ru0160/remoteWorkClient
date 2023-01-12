package alex.work.client.client.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "client")
public class ClientProperty {
    private String pathCloud;
    private String pathGradle;
    private String unZipGradle;
    private String zipGradle;
    private String m2PathCloud;
    private String m2Path;
    private String unZipM2;
    private String zipM2;
}
