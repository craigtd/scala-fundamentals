name := "scala-fundamentals"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.pegdown"    %  "pegdown"     % "1.6.0"  % "test"
)

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-o"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports"),
  Tests.Argument(TestFrameworks.ScalaTest, "-y", "org.scalatest.FlatSpec")
)

