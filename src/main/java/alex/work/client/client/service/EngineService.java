package alex.work.client.client.service;

import alex.work.client.client.property.ClientProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class EngineService {
    private final ClearService clearService;
    private final CopyService copyService;
    private final UnZipService unZipService;
    private final ClientProperty property;

    @EventListener(ApplicationReadyEvent.class)
    public void processGradle() throws IOException {
        clearService.clear(property.getZipGradle());
        clearService.clear(property.getUnZipGradle());
        clearService.clear(property.getPathGradle());

        String filename = "/gradle.zip";

        copyService.copyFolder(property.getPathCloud(), property.getZipGradle());
        unZipService.unZip(property.getZipGradle(), property.getUnZipGradle(), filename);
        copyService.copyFolder(property.getUnZipGradle() + "/copyGradle", property.getPathGradle());

        clearService.clear(property.getZipGradle());
        clearService.clear(property.getUnZipGradle());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void processm2() throws IOException {
        clearService.clear(property.getZipM2());
        clearService.clear(property.getUnZipM2());
        clearService.clear(property.getM2Path());

        String filename = "/m2.zip";

        copyService.copyFolder(property.getM2PathCloud(), property.getZipM2());
        unZipService.unZip(property.getZipM2(), property.getUnZipM2(), filename);
        copyService.copyFolder(property.getUnZipM2() + "/copyM2", property.getM2Path());
    }
}
