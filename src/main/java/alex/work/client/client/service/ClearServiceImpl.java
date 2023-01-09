package alex.work.client.client.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClearServiceImpl implements ClearService {
    @Override
    public void clear(String source) throws IOException {
        log.info("process clear directory {}", source);
        FileUtils.cleanDirectory(new File(source));
        log.info("success clear directory {}", source);
    }
}
