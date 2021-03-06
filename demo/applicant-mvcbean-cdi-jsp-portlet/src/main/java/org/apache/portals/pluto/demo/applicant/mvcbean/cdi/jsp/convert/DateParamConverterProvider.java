/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.portals.pluto.demo.applicant.mvcbean.cdi.jsp.convert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.portlet.PortletPreferences;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;


/**
 * @author  Neil Griffin
 */
@ApplicationScoped
public class DateParamConverterProvider implements ParamConverterProvider {

	@Inject
	protected PortletPreferences portletPreferences;

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type baseType, Annotation[] annotations) {

		if (rawType == null) {
			return null;
		}

		if (rawType.equals(Date.class)) {
			return (ParamConverter<T>) new DateParamConverter(portletPreferences);
		}

		return null;
	}
}
