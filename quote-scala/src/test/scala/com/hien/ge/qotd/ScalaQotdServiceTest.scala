package com.hien.ge.qotd

import java.util.{Calendar, Date}

import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ScalaQotdServiceTest extends SpecificationWithJUnit {

  def service = new ScalaQotdService(Seq(
    "Be the change you wish to see in the world" +
      " - Mahatma Gandhi",
    "A person who never made a mistake never tried anything new" +
      " - Albert Einstein"
  ))

  val today = new Date()
  val tomorrow = incrementDay(today)
  val dayAfterTomorrow = incrementDay(tomorrow)

  "Quote service" should {
    "return same quote for same day in multiple invocations" in {
      service.getQuote(today) must be(service.getQuote(today))
    }

    "return different quote for different days" in {
      service.getQuote(today) must not be (
        service.getQuote(tomorrow))
    }

    "repeat quote if total quotes are less than days in year" in {
      service.getQuote(today) must be(
        service.getQuote(dayAfterTomorrow))
    }
  }

  def incrementDay(date: Date) = {
    val cal = Calendar.getInstance()
    cal.setTime(date)
    cal.add(Calendar.DATE, 1)
    cal.getTime
  }
}
