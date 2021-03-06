/*
    Copyright (c) 2007,2014 Mirco Attocchi
	
    This file is part of WebAppCommon.

    WebAppCommon is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    WebAppCommon is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with WebAppCommon.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.webappcommon.lib.datamapping.test;

import it.webappcommon.lib.datamapping.StandardDao;

import org.apache.log4j.Logger;

/**
 * <p>DataMappingTest class.</p>
 *
 * @author Mirco
 * @version $Id: $Id
 */
public class DataMappingTest {

	/** Constant <code>logger</code> */
	protected static Logger logger = Logger.getLogger(DataMappingTest.class.getName());

	/**
	 * <p>main.</p>
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		
		DemoObject o = new DemoObject();
		
		new StandardDao<DemoObject>().insert(o);
		
	}
}
