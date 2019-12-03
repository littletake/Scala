// scalaでクラスの練習
// scalaでは最初の宣言文でフィールドの宣言とコンストラクタの引数を決める

// クラス練習
class Point(val x: Int, val y: Int){
  // ２点間の距離を算出
   def distance(that: Point): Int = {
    val xdiff = math.abs(this.x - that.x)
    val ydiff = math.abs(this.y - that.y)
    math.sqrt(xdiff * xdiff + ydiff * ydiff).toInt
  }
  // pointの足し算
  def +(that: Point): Point = 
    new Point(x + that.x, y + that.y)
}

// 継承練習
abstract class Shape {
  def draw(): Unit = {
  println("不明な図形")
  }
}

class Triangle extends Shape {
  override def draw(): Unit = {
    println("三角形")
  }
}

class Rectangle extends Shape {
  override def draw(): Unit = {
    println("四角形")
  }
}

class UnknownShape extends Shape

// main部分
object Test {
  def main(args: Array[String]): Unit = {
    // val point1 = new Point(10, 10)
    // val point2 = new Point(1, 1)
    // println(point1.x, point1.y)
    // println(point1.distance(point2))

    var shape: Shape = new Triangle
    shape.draw()
    shape = new Rectangle
    shape.draw()
    shape = new UnknownShape
    shape.draw()
  }
}
    
