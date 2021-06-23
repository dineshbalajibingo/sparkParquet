import java.io.File;
import java.io.IOException;

public class COnvert {
    public static void main(String[] args) throws IOException {

        File fileParquet = new File("src/main/resources/data/userdata.parquet");
        File fileCSV = new File("src/main/resources/data/data.csv");

        ConvertUtils.convertParquetToCSV(fileParquet,fileCSV);
    }
}
