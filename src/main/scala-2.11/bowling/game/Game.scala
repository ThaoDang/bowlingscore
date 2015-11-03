package bowling.game

/**
 * Created by thaodang on 2/11/15.
 */
class Game() {
  var frames = List[Frame]()
  var currentRolls = List[Int]()

  def roll(pins: Int): Unit = {
    currentRolls match {
      case List(10, roll2, roll3) => addStrikeToFrames(pins, roll2, roll3)
      case List(roll1, roll2) if roll1 + roll2 < 10 => addStandardFrameToFrames(pins, roll1, roll2)
      case List(roll1, roll2, roll3) if roll1 + roll2 == 10 => addSpareToFrames(pins, roll1, roll2, roll3)
      case _ => currentRolls = currentRolls :+ pins
    }
  }

  def addStandardFrameToFrames(pins: Int, roll1: Int, roll2: Int): Unit = {
    validateNumberOfFrames
    frames = frames :+ StandardFrame(roll1, roll2)
    currentRolls = List(pins)
  }

  def addStrikeToFrames(pins: Int, roll2: Int, roll3: Int): Unit = {
    validateNumberOfFrames
    frames = frames :+ PerfectStrike(roll2, roll3)
    if(roll2 == 10) {frames = frames :+ PerfectStrike(roll3, pins); currentRolls = List(roll3, pins)}
    else addStandardFrameToFrames(pins, roll2, roll3)
  }

  def validateNumberOfFrames: Unit = {
    if (frames.size > 9) throw new scala.Exception("Exceeded number of frames")
  }

  def addSpareToFrames(pins: Int, roll1: Int, roll2: Int, roll3: Int): Unit = {
    validateNumberOfFrames
    frames = frames :+ SpareFrame(roll3)
    currentRolls = List(roll3, pins)
  }

  def score(): Int = {
    currentRolls match {
      case List(10, roll2, roll3) => frames :+ PerfectStrike(roll2, roll3)
      case List(roll1, roll2, roll3) if roll1 + roll2 == 10 => frames = frames :+ SpareFrame(roll3)
      case List(roll1, roll2) => frames = frames :+ StandardFrame(roll1, roll2)
      case _ => throw new Exception("left over rolls to calculate!!!")
    }
    if (frames == 10) frames.foldLeft(0)((sum, frame) => sum + frame.score)
    else throw new Exception(s"problems!!! ${frames.size}")
  }
}
