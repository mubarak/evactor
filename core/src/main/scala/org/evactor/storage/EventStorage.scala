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
package org.evactor.storage

import org.evactor.model.events.Event
import org.evactor.model.State
import akka.actor.ActorSystem
import org.evactor.model.Message
import scala.collection.immutable.SortedSet
import scala.collection.immutable.SortedMap

abstract class EventStorage (val system: ActorSystem) {
  
  def storeMessage(message: Message): Unit
  
  def getEvent(id: String): Option[Event]
  
  def getEvents(channel: String, filter: Option[SortedMap[String, String]], fromTimestamp: Option[Long], toTimestamp: Option[Long], count: Int, start: Int): List[Event]
  
  @deprecated("use analysers to count events instead", "0.3")
  def getStatistics(channel: String, filter: Option[SortedMap[String, String]], fromTimestamp: Option[Long], toTimestamp: Option[Long], interval: String): (Long, List[Long])
  
  def count(channel: String, filter: Option[SortedMap[String, String]], fromTimestamp: Option[Long], toTimestamp: Option[Long]): Long
  
  def eventExists(event: Event): Boolean
  
  def getEventChannels(count: Int): List[(String, Long)]

  //TODO: def getIndexValues(channel: String, category: Option[String], index: SortedSet[String])
  
}
