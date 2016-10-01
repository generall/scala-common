import java.io.{ObjectInputStream, FileInputStream}

import libsvm.LibSVM
import net.sf.javaml.core.DenseInstance

val ois = new ObjectInputStream(new FileInputStream("/tmp/svm.data"))

val svm = ois.readObject.asInstanceOf[LibSVM]


svm.classify(new DenseInstance(Array(1.0,1.0,1.0)))
svm.classify(new DenseInstance(Array(0.3,0.4,1.0)))