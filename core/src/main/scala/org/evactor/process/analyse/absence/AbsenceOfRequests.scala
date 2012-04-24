/*
 * Copyright 2012 Albert Örwall
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.evactor.process.analyse.absence

import akka.actor.Actor._
import org.evactor.process.ProcessorConfiguration
import org.evactor.process.Subscription
import org.evactor.utils.JavaHelpers.any2option

class AbsenceOfRequests (
    override val name: String,
    override val subscriptions: List[Subscription], 
    val channel: String, 
    val category: Option[String],
    val timeFrame: Long)
  extends ProcessorConfiguration(name, subscriptions) {

  def this(name: String, subscription: Subscription, 
    channel: String, category: String, timeFrame: Long) = {
    this(name, List(subscription), channel, category, timeFrame)
  }
  
  def processor = new AbsenceOfRequestsAnalyser(subscriptions, channel, category, timeFrame)

}