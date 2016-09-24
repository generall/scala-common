package ml.generall

/**
  * Created by generall on 24.09.16.
  */
object isDebug {
  val debug = sys.env("DEBUG") == "true"
  def apply() = debug
}
