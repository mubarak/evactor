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
package org.evactor.process

import akka.actor.ActorRef

/**
 * Trait extended by actors subscribing to the processor event bus  
 */
trait Subscriber extends UseProcessorEventBus {

  def subscribe(subscriber: ActorRef, subscriptions: List[Subscription]) {
    for(sub <- subscriptions){
      bus.subscribe(subscriber, sub)
    }
  }

  def unsubscribe(subscriber: ActorRef, subscriptions: List[Subscription]) {
    for(sub <- subscriptions){
      bus.unsubscribe(subscriber, sub)
    }
  }

}