package bowling.game

import org.scalatest.{Matchers, FunSpec, FunSuite}

/**
 * Created by thaodang on 2/11/15.
 */
class FrameTest extends FunSpec with Matchers {
  describe("PerfectStrike")
  {
    it("should total up score for all three rolls") {
      PerfectStrike(2, 3).score should be(15)
    }
  }

  describe("StandardFrame")
  {
    it("should total up score for both rolls") {
      StandardFrame(2, 3).score should be(5)
    }
  }

  describe("SpareFrame")
  {
    it("should total up score for all rolls") {
      SpareFrame(5).score should be(15)
    }
  }
}
