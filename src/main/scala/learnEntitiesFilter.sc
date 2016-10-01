import java.io.{FileOutputStream, ObjectOutputStream}

import libsvm.{svm_parameter, LibSVM}
import net.sf.javaml.core.{DefaultDataset, Dataset, DenseInstance}
import scala.io.Source

import org.json4s._
import org.json4s.native.JsonMethods._
implicit val formats = DefaultFormats
val strJson = Source.fromFile("/home/generall/data/entity_filtering.json").mkString
val json = parse(strJson)
case class MyLearnObj(
                     val avgWeight: Double,
                     val maxWeight: Double,
                     val wordCount: Int,
                     val vote: String
                     )
val data = new DefaultDataset
json.children
  .map(x => x.extract[MyLearnObj])
  .map(x => new DenseInstance(Array(x.avgWeight, x.maxWeight, x.wordCount), x.vote))
  .foreach(x => data.add(x) )
val svm: LibSVM = new LibSVM()
val params = svm.getParameters
params.svm_type = svm_parameter.C_SVC
params.kernel_type = svm_parameter.LINEAR
params.gamma = 0.1
params.degree = 3
params.coef0 = 0.0
params.nr_weight = 1
params.weight_label = Array(0, 1)
params.weight = Array(2.0, 1.0)
svm.buildClassifier(data)
val outStream = new ObjectOutputStream(new FileOutputStream("/tmp/svm.data"))
outStream.writeObject(svm)

