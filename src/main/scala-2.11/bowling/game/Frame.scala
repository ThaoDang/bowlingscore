package bowling.game

/**
 * Created by thaodang on 2/11/15.
 */
abstract class Frame {
  def score: Int
}

case class PerfectStrike(val roll2: Int, val roll3: Int) extends Frame {
  override def score: Int = 10 + roll2 + roll3
}

case class SpareFrame(val roll3:Int) extends Frame {
  override def score: Int = 10 + roll3
}

case class StandardFrame(val roll1:Int, val roll2: Int) extends Frame {
  override def score: Int = roll1 + roll2
}

