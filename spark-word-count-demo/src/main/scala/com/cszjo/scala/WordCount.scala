package com.cszjo.scala

import org.apache.log4j.Logger
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by hansiming on 2017/8/11.
  */
object WordCount {

  def main(args: Array[String]): Unit = {

    //Scala有两种变量，val和var。val就不能再赋值了。与之对应的，var可以在它生命周期中被多次赋值。
    val logger = Logger.getLogger(this.getClass)

    if(args.length < 2) {
      logger.error("wrong parameters number, parameters should have input path and output path")
      System.exit(1)
    }

    val inputPath = args(0)
    val outputPath = args(1)
    logger.info("input path = {}, output path = {}", inputPath, outputPath);

    val jobName = "WordCountByScala"

    val conf = new SparkConf().setAppName(jobName)
    val sc = new SparkContext(conf)


    val textFile = sc.textFile(inputPath)

    //Spark 中 map函数会对每一条输入进行指定的操作，然后为每一条输入返回一个对象；
    //而flatMap函数则是两个操作的集合——正是“先映射后扁平化”：
    //操作1：同map函数一样：对每一条输入进行指定的操作，然后为每一条输入返回一个对象
    //操作2：最后将所有对象合并为一个对象
    val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)

    counts.saveAsTextFile(outputPath)
  }
}
