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

package com.bernardomg.tabletop.palette.palette.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bernardomg.tabletop.palette.palette.model.PaletteGroupOption;
import com.bernardomg.tabletop.palette.palette.service.PaletteService;
import com.bernardomg.tabletop.palette.response.DefaultResponse;
import com.bernardomg.tabletop.palette.response.Response;

/**
 * Rest controller for palettes.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/palette/group")
public class PaletteGroupController {

    /**
     * Palette service.
     */
    private final PaletteService paletteService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            example entity service
     */
    @Autowired
    public PaletteGroupController(final PaletteService service) {
        super();

        paletteService = checkNotNull(service, "The service is required");
    }

    @GetMapping
    public Response<Iterable<PaletteGroupOption>> read() {
        final Iterable<PaletteGroupOption> read;

        read = paletteService.getAll();

        return new DefaultResponse<>(read);
    }

    @GetMapping(path = "/{id}")
    public Response<PaletteGroupOption>
            readById(@PathVariable("id") final Long id) {
        final PaletteGroupOption read;

        read = paletteService.getById(id);

        return new DefaultResponse<>(read);
    }

    @PostMapping
    public Response<PaletteGroupOption>
            save(@RequestBody @Valid final PaletteGroupOption paletteGroup) {
        paletteService.saveGroup(paletteGroup);

        // TODO: Return the new data
        return new DefaultResponse<>();
    }

}