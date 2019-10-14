/**
 * Copyright 2018 the original author or authors
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

package com.bernardomg.tabletop.palette.test.integration.palette.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.bernardomg.tabletop.palette.palette.model.PaintOption;
import com.bernardomg.tabletop.palette.palette.model.PaletteGroupOption;
import com.bernardomg.tabletop.palette.palette.model.PaletteOption;
import com.bernardomg.tabletop.palette.palette.service.PaletteService;
import com.google.common.collect.Iterables;

/**
 * Integration tests for the {@link ExampleEntityService}.
 * <p>
 * As this service doesn't contain any actual business logic, and it just wraps
 * the example entities repository, these tests are for verifying everything is
 * set up correctly and working.
 */
@RunWith(JUnitPlatform.class)
@SpringJUnitConfig
@Transactional
@Rollback
@ContextConfiguration(
        locations = { "classpath:context/application-context.xml" })
public class ITPaletteServiceRead {

    /**
     * Service being tested.
     */
    @Autowired
    private PaletteService service;

    /**
     * Default constructor.
     */
    public ITPaletteServiceRead() {
        super();
    }

    @Test
    public void testRead_Empty() {
        final Iterable<PaletteGroupOption> read;

        read = service.getAll();

        Assertions.assertEquals(0, Iterables.size(read));
    }

    @Test
    @Sql({ "/db/palette_group.sql", "/db/palette.sql", "/db/paint.sql" })
    public void testRead_Full() {
        final Iterable<PaletteGroupOption> read;
        final PaletteGroupOption group;
        final PaletteOption palette;
        final PaintOption paint;

        read = service.getAll();

        Assertions.assertEquals(1, Iterables.size(read));

        group = read.iterator().next();
        Assertions.assertEquals("Group1", group.getName());
        Assertions.assertEquals(1, Iterables.size(group.getPalettes()));

        palette = group.getPalettes().iterator().next();
        Assertions.assertEquals("Palette1", palette.getName());
        Assertions.assertEquals(1, Iterables.size(palette.getPaints()));

        paint = palette.getPaints().iterator().next();
        Assertions.assertEquals("Paint1", paint.getName());
    }

    @Test
    @Sql({ "/db/palette_group.sql" })
    public void testRead_Group() {
        final Iterable<PaletteGroupOption> read;
        final PaletteGroupOption group;

        read = service.getAll();

        Assertions.assertEquals(1, Iterables.size(read));

        group = read.iterator().next();
        Assertions.assertEquals("Group1", group.getName());
        Assertions.assertEquals(0, Iterables.size(group.getPalettes()));
    }

    @Test
    @Sql({ "/db/palette_group.sql", "/db/palette.sql" })
    public void testRead_Group_Palette() {
        final Iterable<PaletteGroupOption> read;
        final PaletteGroupOption group;
        final PaletteOption palette;

        read = service.getAll();

        Assertions.assertEquals(1, Iterables.size(read));

        group = read.iterator().next();
        Assertions.assertEquals("Group1", group.getName());
        Assertions.assertEquals(1, Iterables.size(group.getPalettes()));

        palette = group.getPalettes().iterator().next();
        Assertions.assertEquals("Palette1", palette.getName());
        Assertions.assertEquals(0, Iterables.size(palette.getPaints()));
    }

}