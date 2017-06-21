package hello.Service.implement;

import hello.Exception.StorageException;
import hello.Service.ImportService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ELLLisa on 2017/6/21.
 */
@Service
public class ImportServiceImpl implements ImportService {

    private static Log log = LogFactory.getLog(ImportServiceImpl.class);

    @Override
    public String store(MultipartFile file) throws StorageException {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename() + ".");
            }
            File student_file = new File("students.xlsx");
            FileOutputStream stream = new FileOutputStream(student_file);
            BufferedOutputStream out = new BufferedOutputStream(stream);
            out.write(file.getBytes());
            out.flush();
            out.close();
            return file.getOriginalFilename();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename() + ".", e);
        }
    }


}
