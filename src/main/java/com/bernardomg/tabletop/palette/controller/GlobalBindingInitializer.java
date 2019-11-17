/**
 * Copyright 2019 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bernardomg.tabletop.palette.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Initializes all the controllers with a common configuration.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ControllerAdvice
public class GlobalBindingInitializer {

    /**
     * Default constructor.
     */
    public GlobalBindingInitializer() {
        super();
    }

    /**
     * Sets the fields which can't be bound.
     * 
     * @param dataBinder
     *            data binder
     */
    @InitBinder
    public void setDisallowedFields(final WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}
