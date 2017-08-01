package edu.knoldus

import com.sun.net.httpserver.Authenticator.{Failure, Success}

import scala.util.Try


/**
  * Created by Neelaksh on 1/8/17.
  */
class CSVReader(val fileName:String) {
  def read():List[QueryInfo] = {
    val pattern = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"
    var bufferedSource:io.Source = null
    try {
      bufferedSource = io.Source.fromFile(fileName)
      val iteratorOfData: Iterator[Array[String]] =
        for {line <- bufferedSource.getLines
        } yield line.split(pattern, -1) //pattern.findAllIn(line).toList
      iteratorOfData.toList.map(_.toList).map(x => QueryInfo.apply(x))
    }
    catch{
      case _ => throw new Exception
    }
    finally {
      bufferedSource.close
    }

    //if(bufferedSource!=null) bufferedSource.close
    //queryData
  }
}