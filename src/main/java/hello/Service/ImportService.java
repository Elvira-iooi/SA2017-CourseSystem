package hello.Service;

import hello.Exception.StorageException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by ELLLisa on 2017/6/21.
 */
public interface ImportService {

    //本地缓存文件
    public String store(MultipartFile file) throws StorageException;


}