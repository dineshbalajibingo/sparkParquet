import org.apache.spark.sql.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SparkExample {

    private static String itemValue;
    public static void main(String[] args) {
    SparkSession spark = SparkSession
            .builder()
            .master("local")
            .appName("Java Spark SQL data sources example")
            .config("spark.some.config.option", "some-value")
            .getOrCreate();

           runBasicDataSourceExample(spark);
        System.out.println("Printing Outside Obj " +itemValue);
        spark.stop();

        }
    @SuppressWarnings("unchecked")
    private static void runBasicDataSourceExample(SparkSession spark) {

       Dataset<Row> parquetFileDF = spark.read().load("src/main/resources/data/userdata.parquet");
       parquetFileDF.createOrReplaceTempView("parquetFile");
        Dataset<Row>  namesDF = spark.sql("SELECT email FROM parquetFile where id=2");
        System.out.println(namesDF.schema());
        namesDF.show();
        for(Iterator<Row> iter = namesDF.toLocalIterator(); iter.hasNext();) {
           String item = (iter.next()).toString();
            System.out.println("Actual Value is *********" +item);
            itemValue = item.toString().substring(1, item.length() - 1);
            System.out.println("*****************"+ itemValue);
        }
        if(itemValue.equalsIgnoreCase("afreeman1@is.gd"))
        {
            System.out.println("Success !!!!!");
        }else{
            System.out.println("Nop !!!!!");
        }
    }

    }


