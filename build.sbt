name := "scala-common"
 
organization := "ml.generall"

version := "1.0-SNAPSHOT"
 
scalaVersion := "2.11.8"
 
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"


libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.5"
libraryDependencies += "org.typelevel" %% "scalaz-outlaws" % "0.2"
//libraryDependencies += "org.json4s" %% "json4s-native" % "3.4.1"


resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/stew/snapshots"

resolvers += Resolver.mavenLocal


unmanagedJars in Compile += file("lib/ajt-2.9.jar")
unmanagedJars in Compile += file("lib/commons-math-1.2.jar")
unmanagedJars in Compile += file("lib/Jama-1.0.2.jar")
unmanagedJars in Compile += file("lib/javaml-0.1.7.jar")
unmanagedJars in Compile += file("lib/libsvm.jar")
unmanagedJars in Compile += file("lib/weka.jar")