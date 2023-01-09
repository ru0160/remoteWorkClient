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
    public void process() throws IOException {
        clearService.clear(property.getZipGradle());
        clearService.clear(property.getUnZipGradle());
        clearService.clear(property.getPathGradle());

        copyService.copyFolder(property.getPathCloud(), property.getZipGradle());
        unZipService.unZip(property.getZipGradle(), property.getUnZipGradle());
        copyService.copyFolder(property.getUnZipGradle(), property.getPathGradle());

        clearService.clear(property.getZipGradle());
        clearService.clear(property.getUnZipGradle());
    }
}
