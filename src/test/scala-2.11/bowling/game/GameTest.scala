package bowling.game

import org.scalatest.{Matchers, FunSpec}

/**
 * Created by thaodang on 2/11/15.
 */
class GameTest extends FunSpec with Matchers {

  describe("A new game has started") {
    it("should store the score for the perfect strike run") {
      val game = new Game()
      perfectStrikeFrame(game)
      perfectStrikeFrame(game)
      perfectStrikeFrame(game)
      perfectStrikeFrame(game)
      perfectStrikeFrame(game)
      perfectStrikeFrame(game)
      perfectStrikeFrame(game)
      perfectStrikeFrame(game)
      perfectStrikeFrame(game)
      perfectStrikeFrame(game)
      frame(game, 10, 10)
      game.score should be(300)
    }

    it("should store the score for the standard frame") {
      val game = new Game()
      frame(game, 3, 5)
      frame(game, 6, 3)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      game.score should be(17)
    }

    it("should store the score for a spare") {
      val game = new Game()
      frame(game, 3, 7)
      frame(game, 6, 3)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      missedFrame(game)
      game.score should be(25)
    }
    
  }

  def perfectStrikeFrame(game: Game): Unit = {
    game.roll(10)
  }

  def missedFrame(game: Game) = {
    game.roll(0)
    game.roll(0)
  }
  def frame(game: Game, roll1: Int, roll2: Int) = {
    game.roll(roll1)
    game.roll(roll2)
  }
}
