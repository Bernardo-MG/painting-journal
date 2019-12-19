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

package com.bernardomg.tabletop.palette.palette.service;

import com.bernardomg.tabletop.palette.palette.model.PaletteCreationForm;
import com.bernardomg.tabletop.palette.palette.model.PaletteGroupOption;
import com.bernardomg.tabletop.palette.palette.model.PaletteOption;
import com.bernardomg.tabletop.palette.palette.model.PaletteUpdateForm;

/**
 * Service for palettes.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface PaletteService {

    public Iterable<PaletteGroupOption> getAll();

    public Iterable<PaletteOption> getAllPalettes();

    public PaletteGroupOption getById(final Long id);

    public void saveGroup(final PaletteGroupOption paletteGroup);

    public void savePalette(final PaletteCreationForm palette);

    public void updatePalette(final PaletteUpdateForm palette);

}
