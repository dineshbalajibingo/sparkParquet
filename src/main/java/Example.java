import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

public class Example {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("JavaSparkSQL");
        JavaSparkContext ctx = new JavaSparkContext(sparkConf);
        SQLContext sqlContext = new SQLContext(ctx);
        Dataset<Row> usersDF = sqlContext.read().load("src/main/resources/data/userdata1.parquet");
       // usersDF.select("name", "favorite_color").write().save("namesAndFavColors.parquet");
        usersDF.show();
    }

}
