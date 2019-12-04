// http://en.wikipedia.org/wiki/Composite_pattern

trait Graphic {
  def print: Unit
}

class CompositeGraphic extends Graphic {
  private var mChildGraphics = List[Graphic]()

  override def print = {
    print("(")
    mChildGraphics.foreach ((g:Graphic) => {
      g.print
    })
    print(")")
    println()
  }

  def add(graphic: Graphic) = {
    mChildGraphics = graphic :: mChildGraphics
  }

  def remove(graphic: Graphic) = {
    mChildGraphics = mChildGraphics.filterNot(_ == graphic)
  }
}

class Ellipse extends Graphic {
  override def print = {
    println("Ellipse")
  }
}

object CompositeSample {
  def main(args: Array[String]) = {
    val ellipse1 = new Ellipse
    val ellipse2 = new Ellipse
    val ellipse3 = new Ellipse
    val ellipse4 = new Ellipse

    var graphic = new CompositeGraphic
    var graphic1 = new CompositeGraphic
    var graphic2 = new CompositeGraphic

    graphic1.add(ellipse1)
    graphic1.add(ellipse2)
    graphic1.add(ellipse3)

    graphic2.add(ellipse4)

    graphic.add(graphic1)
    graphic.add(graphic2)

    graphic.print
  }
}

