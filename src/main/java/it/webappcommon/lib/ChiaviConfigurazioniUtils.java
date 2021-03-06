/*
    Copyright (c) 2012,2013 Mirco Attocchi
	
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

package it.webappcommon.lib;

/**
 * <p>ChiaviConfigurazioniUtils class.</p>
 *
 * @author Mirco
 * @version $Id: $Id
 */
public class ChiaviConfigurazioniUtils {

    /**
     * Verifica se il valore di una chiave di Configurazione e' true.
     *
     * @param aValue a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean isTrue(String aValue) {
        boolean res = false;

        if (aValue != null && !aValue.isEmpty() && Boolean.parseBoolean(aValue.toLowerCase())) {
            res = true;
        }

        return res;
    }
}
