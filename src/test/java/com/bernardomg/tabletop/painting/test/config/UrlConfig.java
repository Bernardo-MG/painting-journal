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

package com.bernardomg.tabletop.painting.test.config;

/**
 * Contains configuration information for the controller URLs.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class UrlConfig {

    /**
     * Palettes REST URL.
     */
    public static final String PALETTE       = "/rest/palette";

    /**
     * Palette groups REST URL.
     */
    public static final String PALETTE_GROUP = "/rest/palette/group";

    /**
     * Products REST URL.
     */
    public static final String PRODUCT       = "/rest/product";

    /**
     * Default constructor to avoid initialization.
     */
    private UrlConfig() {
        super();
    }

}
