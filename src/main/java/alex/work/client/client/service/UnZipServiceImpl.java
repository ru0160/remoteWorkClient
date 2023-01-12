package alex.work.client.client.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UnZipServiceImpl implements UnZipService {
    @Override
    public void unZip(String source, String dest, String filename) {
        log.info("process unzip");
        try {
            ZipFile zipFile = new ZipFile(source + filename);


            zipFile.extractAll(dest);
        } catch (ZipException e) {
            e.printStackTrace();
        }
        log.info("unzip success");
    }
}
