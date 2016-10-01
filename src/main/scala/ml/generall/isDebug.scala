package ml.generall

import scala.util.{Failure, Success, Try}

/**
  * Created by generall on 24.09.16.
  */
object isDebug {
  val debug = Try(sys.env("DEBUG")) match {
    case Success(value) => value == "true"
    case Failure(_) => false
  }

  def apply() = debug
}
