package com.cszjo.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by hansiming on 2017/8/11.
 */
public class WordCount {

    public static void main(String[] args) {

        Logger logger = org.slf4j.LoggerFactory.getLogger(WordCount.class);

        if(args.length < 2) {
            logger.error("wrong parameters number, parameters should have input path and output path");
            System.exit(1);
        }

        String inputPath = args[0];
        String outputPath = args[1];

        logger.info("input path = {}, output path = {}", inputPath, outputPath);

        SparkConf conf = new SparkConf().setAppName("WordCountByJava");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> input = sc.textFile(inputPath);

        JavaPairRDD<String, Integer> counts = input.flatMap(
                s -> Arrays.asList(s.split(" ")).iterator()
        ).mapToPair(
                s -> new Tuple2<>(s, 1)
        ).reduceByKey(
                (a, b) -> a + b
        );

        counts.saveAsTextFile(outputPath);
    }
}
