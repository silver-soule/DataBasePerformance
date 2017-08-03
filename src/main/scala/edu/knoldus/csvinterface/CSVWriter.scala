package edu.knoldus.csvinterface

import java.io.{File, PrintWriter}

/**
  * Created by Neelaksh on 1/8/17.
  */
class CSVWriter(fileName:String) {
  def write(dataToWrite:List[List[String]]): Unit = {
    val outputdata = dataToWrite.map(row=>row.reduce((c1,c2) => c1 + "," + c2)).reduce(_ + "\n" + _)
    val writer = new PrintWriter(new File(fileName))
    writer.write(outputdata)
    writer.close()
  }

}
