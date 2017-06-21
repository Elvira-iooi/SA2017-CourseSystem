package hello.Batch;

import org.springframework.core.io.ClassPathResource;

/**
 * Created by luping on 2017/6/22.
 */
public class PoiItemReader<T> {
    private int linesToSkip;
    ClassPathResource resource;
    StudentExcelRowMapper rowMapper;

    public void setLinesToSkip(int linesToSkip) {
        this.linesToSkip = linesToSkip;
    }

    public void setResource(ClassPathResource resource) {
        this.resource = resource;
    }


    public void setRowMapper(StudentExcelRowMapper rowMapper) {
        this.rowMapper = rowMapper;
    }
}
