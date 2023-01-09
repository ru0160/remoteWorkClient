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
}
