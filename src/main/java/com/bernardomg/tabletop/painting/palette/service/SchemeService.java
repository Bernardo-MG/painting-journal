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

package com.bernardomg.tabletop.painting.palette.service;

import com.bernardomg.tabletop.painting.palette.model.data.SchemeData;
import com.bernardomg.tabletop.painting.palette.model.form.SchemeCreationForm;
import com.bernardomg.tabletop.painting.palette.model.form.SchemeUpdateForm;

/**
 * Service for palettes.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface SchemeService {

    public Boolean deleteScheme(final Long id);

    public Iterable<SchemeData> getAllSchemes();

    public SchemeData saveScheme(final SchemeCreationForm scheme);

    public SchemeData updateScheme(final SchemeUpdateForm scheme);

}
