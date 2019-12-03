trait Entry {
  def getName(): String
  def printList(prefix: String): Unit
  def printList(): Unit = {
    println("")
  }
}

class File(name: String) extends Entry {
  override def getName(): String = {
    name
  }
  override def printList(prefix: String): Unit = {
    println(prefix + "/" + name)
  }
}

class Directory(name: String) extends Entry {
  var list = List[Entry]()
  override def getName(): String = {
    name
  }
  def add(entry: Entry): Unit = {
    list = list :+ entry
  }
  def printList(prefix: String): Unit = {
    println(prefix + "/" + name)
    list.foreach((entry: Entry) => {
      entry.printList(prefix + "/" + name)
    })
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println("hello")
    val dir1 = new Directory("workspace")
    val dir2 = new Directory("composite")
    
    val file1 = new File("file1")
    val file2 = new File("file2")
    dir1.add(file1)
    dir2.add(file2)
    dir1.add(dir2)
   //  print(dir1)
    dir1.printList("root")
  }
}
  
