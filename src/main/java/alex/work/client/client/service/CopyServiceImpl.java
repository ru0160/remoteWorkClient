package alex.work.client.client.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class CopyServiceImpl implements CopyService {

    @Override
    public void copyFolder(String source, String destination) {
        log.info("process copy directory: {} to {}", source, destination);
        File srcDir = new File(source);

        File destDir = new File(destination);

        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("success copy directory {}", destination);
    }
}
