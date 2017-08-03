name := "databasespeedtester"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"

libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19" % "test"

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.19.3"
