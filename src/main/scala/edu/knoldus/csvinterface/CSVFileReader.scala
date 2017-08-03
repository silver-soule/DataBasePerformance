package edu.knoldus.csvinterface

import java.io.FileNotFoundException

import scala.io.BufferedSource


/**
  * Created by Neelaksh on 1/8/17.
  */
class CSVFileReader(val fileName:String) {
  /**
    *
    * @return a returns a
    */
  def read():List[List[String]] = {
    lazy val bufferedSource:BufferedSource = io.Source.fromFile(fileName)
    try{
      generateData(bufferedSource)
    }
    catch{
      case _:FileNotFoundException => throw new Exception
    }

  }

  def generateData(bufferedSource:io.Source) : List[List[String]] = {
    val pattern = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"
    try {
      val iteratorOfData: Iterator[Array[String]] =
        for {line <- bufferedSource.getLines
        } yield line.split(pattern, -1).map(string=>string.trim.replaceAll("^\"|\"$", ""))
      iteratorOfData.toList.map(_.toList)
    }
    catch{
      case _=> throw new Exception
    }
    finally {
      bufferedSource.close
    }
  }
}