import libsvm.{svm_parameter, LibSVM}
import net.sf.javaml.classification.Classifier
import net.sf.javaml.core.{DenseInstance, Instance, Dataset, DefaultDataset}
import net.sf.javaml.tools.InstanceTools

val data: Dataset = new DefaultDataset()



List(
  (1, "up"),
  (2, "up"),
  (3, "up"),
  (4, "down"),
  (5, "up"),
  (6, "down"),
  (7, "up"),
  (8, "down"),
  (9, "down"),
  (10, "down")
).map(x => new DenseInstance(Array(x._1.toDouble), x._2)).foreach(data.add(_))


data.size()

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

svm.getWeights


svm.classify(new DenseInstance(Array(1.0)))
svm.classify(new DenseInstance(Array(2.0)))
svm.classify(new DenseInstance(Array(3.0)))
svm.classify(new DenseInstance(Array(4.0)))
svm.classify(new DenseInstance(Array(5.0)))
svm.classify(new DenseInstance(Array(6.0)))
svm.classify(new DenseInstance(Array(7.0)))
svm.classify(new DenseInstance(Array(8.0)))
svm.classify(new DenseInstance(Array(9.0)))
svm.classify(new DenseInstance(Array(10.0)))
