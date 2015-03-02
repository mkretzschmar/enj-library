/*
 * EnJ - EnOcean Java API
 * 
 * Copyright 2014 Andrea Biasi, Dario Bonino 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package it.polito.elite.enocean.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.polito.elite.enocean.enj.eep.EEPAttribute;
import it.polito.elite.enocean.enj.eep.EEPAttributeChangeListener;
import it.polito.elite.enocean.enj.eep.eep26.attributes.EEP26RockerSwitch2RockerAction;

/**
 * @author bonino
 *
 */
public class SimpleRockerSwitchListener implements EEPAttributeChangeListener
{
	private Logger logger;

	/**
	 * 
	 */
	public SimpleRockerSwitchListener()
	{
		this.logger = LoggerFactory.getLogger(SimpleRockerSwitchListener.class);
	}

	/* (non-Javadoc)
	 * @see it.polito.elite.enocean.enj.eep.EEPAttributeChangeListener#handleAttributeChange(int, it.polito.elite.enocean.enj.eep.EEPAttribute)
	 */
	@Override
	public void handleAttributeChange(int channelId, EEPAttribute<?> attribute)
	{
		//cast
		if(attribute instanceof EEP26RockerSwitch2RockerAction)
		{
			EEP26RockerSwitch2RockerAction action = (EEP26RockerSwitch2RockerAction)attribute;
			boolean a1 = action.getButtonValue(EEP26RockerSwitch2RockerAction.AI);
			boolean a0 = action.getButtonValue(EEP26RockerSwitch2RockerAction.AO);
			boolean b1 = action.getButtonValue(EEP26RockerSwitch2RockerAction.BI);
			boolean b0 = action.getButtonValue(EEP26RockerSwitch2RockerAction.BO);
			
			this.logger.info("A0: "+a0+" A1: "+a1+" B0: "+b0+" B1: "+b1);
		}

	}

}
