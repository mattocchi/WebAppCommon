/*
    Copyright (c) Twig (http://twigstechtips.blogspot.it/2010/03/css-ie8-meta-tag-to-disable.html)
	
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

package it.attocchi.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/*
 * Usage on web.xml:
 * 
 * 	
 <!-- IE7VersionFilter -->
 <filter>
 <display-name>IE7VersionFilter</display-name>
 <filter-name>IE7VersionFilter</filter-name>
 <filter-class>it.attocchi.web.filters.IE7VersionFilter</filter-class>
 </filter>
 <filter-mapping>
 <filter-name>IE7VersionFilter</filter-name>
 <servlet-name>Faces Servlet</servlet-name>
 </filter-mapping>
 <!-- IE7VersionFilter -->

 */
public class IE7VersionFilter implements Filter {

	protected final Logger logger = Logger.getLogger(IE9TextFilter.class.getName());

	String pathToBeIgnored;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String path = httpRequest.getRequestURI();
		// if (path.startsWith("/specialpath")) {
		if (pathToBeIgnored != null && wildCardMatch(path, pathToBeIgnored)) {
			logger.info("IE7VersionFilter not applied for " + path);
			chain.doFilter(request, response); // Just continue chain.
		} else {
			// Do your business stuff here for all paths other than
			// /specialpath.
			/*
			 * http://twigstechtips.blogspot.com/2010/03/css-ie8-meta-tag-to-disable
			 * .html
			 */
			httpResponse.setHeader("X-UA-Compatible", "IE=7");

			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		pathToBeIgnored = config.getInitParameter("pathToBeIgnored");
	}

	/**
	 * Performs a wildcard matching for the text and pattern provided.
	 * 
	 * @param text
	 *            the text to be tested for matches.
	 * 
	 * @param pattern
	 *            the pattern to be matched for. This can contain the wildcard
	 *            character '*' (asterisk).
	 * 
	 * @return <tt>true</tt> if a match is found, <tt>false</tt> otherwise.
	 */

	public static boolean wildCardMatch(String text, String pattern) {
		// Create the cards by splitting using a RegEx. If more speed
		// is desired, a simpler character based splitting can be done.
		String[] cards = pattern.split("\\*");

		// Iterate over the cards.
		for (String card : cards) {
			int idx = text.indexOf(card);

			// Card not detected in the text.
			if (idx == -1) {
				return false;
			}

			// Move ahead, towards the right of the text.
			text = text.substring(idx + card.length());
		}

		return true;
	}

}