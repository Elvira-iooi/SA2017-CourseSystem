package hello.Controller;

import com.github.pagehelper.PageInfo;
import hello.Entity.Student;
import hello.Exception.StorageException;
import hello.Service.implement.ImportServiceImpl;
import hello.Service.implement.StudentServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ELLLisa on 2017/6/21.
 */
@RestController
@RequestMapping(value = "/batchimport")
public class BatchController {

    private static Log log = LogFactory.getLog(BatchController.class);

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private ImportServiceImpl importService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Student> batchimport(@RequestParam(value = "filename") MultipartFile file) throws IOException {

        log.info("BatchController ..batchimport() start");

        //保存文件，启动batch
        try {
            importService.store(file);
            jobLauncher.run(job, new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters());
        } catch (StorageException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to convert xlsx file.");
            return null;
        }

        List<Student> studentList = studentService.getAll();
        return new PageInfo<Student>(studentList);
    }


}