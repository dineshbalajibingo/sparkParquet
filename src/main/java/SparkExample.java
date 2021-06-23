import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkExample {
    public static void main(String[] args) {
    SparkSession spark = SparkSession
            .builder()
            .master("local")
            .appName("Java Spark SQL data sources example")
            .config("spark.some.config.option", "some-value")
            .getOrCreate();

           runBasicDataSourceExample(spark);
        spark.stop();

        }
    @SuppressWarnings("unchecked")
    private static void runBasicDataSourceExample(SparkSession spark) {

        Dataset<Row> parquetFileDF = spark.read().load("src/main/resources/data/userdata.parquet");
        parquetFileDF.createOrReplaceTempView("parquetFile");

        Dataset<Row> namesDF = spark.sql("SELECT last_name FROM parquetFile where id=2");
     /*   Dataset<String> namesDS = namesDF.map(
                (MapFunction<Row, String>) row -> "id: " + row.getString(1),
                Encoders.STRING());*/

        namesDF.show();
        System.out.println("*************************************"+namesDF.equals("Freeman"));
    }
    }


