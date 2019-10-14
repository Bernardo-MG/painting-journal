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

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.bernardomg.tabletop.palette.palette.model.PaintOption;
import com.bernardomg.tabletop.palette.palette.model.PaletteGroupOption;
import com.bernardomg.tabletop.palette.palette.model.PaletteOption;
import com.bernardomg.tabletop.palette.palette.model.persistence.PaletteGroup;
import com.bernardomg.tabletop.palette.palette.repository.PaintRepository;
import com.bernardomg.tabletop.palette.palette.repository.PaletteGroupRepository;
import com.bernardomg.tabletop.palette.palette.repository.PaletteRepository;
import com.bernardomg.tabletop.palette.palette.service.PaletteService;

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
public class ITPaletteServiceSave {

    @Autowired
    private PaintRepository        paintRepository;

    @Autowired
    private PaletteGroupRepository paletteGroupRepository;

    @Autowired
    private PaletteRepository      paletteRepository;

    /**
     * Service being tested.
     */
    @Autowired
    private PaletteService         service;

    /**
     * Default constructor.
     */
    public ITPaletteServiceSave() {
        super();
    }

    @Test
    public void testSave_Empty_Count() {
        final PaletteGroupOption paletteGroup;

        paletteGroup = new PaletteGroupOption();

        service.save(paletteGroup);

        Assertions.assertEquals(0, paletteGroupRepository.count());
        Assertions.assertEquals(0, paletteRepository.count());
        Assertions.assertEquals(0, paintRepository.count());
    }

    @Test
    public void testSave_EmptyName() {
        final PaletteGroupOption paletteGroup;

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("");

        service.save(paletteGroup);

        Assertions.assertEquals(0, paletteGroupRepository.count());
        Assertions.assertEquals(0, paletteRepository.count());
        Assertions.assertEquals(0, paintRepository.count());
    }

    @Test
    public void testSave_NoPalettes_Count() {
        final PaletteGroupOption paletteGroup;

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("group");

        service.save(paletteGroup);

        Assertions.assertEquals(1, paletteGroupRepository.count());
        Assertions.assertEquals(0, paletteRepository.count());
        Assertions.assertEquals(0, paintRepository.count());
    }

    @Test
    public void testSave_NoPalettes_Created() {
        final PaletteGroupOption paletteGroup;
        final PaletteGroup group;

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("group");

        service.save(paletteGroup);

        group = paletteGroupRepository.findAll().iterator().next();

        Assertions.assertEquals("group", group.getName());
    }

    @Test
    public void testSave_Palettes_Count() {
        final PaletteGroupOption paletteGroup;
        final Collection<PaletteOption> palettes;
        final PaletteOption palette;

        palette = new PaletteOption();
        palette.setName("palette");

        palettes = new ArrayList<>();
        palettes.add(palette);

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("group");

        paletteGroup.setPalettes(palettes);

        service.save(paletteGroup);

        Assertions.assertEquals(1, paletteGroupRepository.count());
        Assertions.assertEquals(1, paletteRepository.count());
        Assertions.assertEquals(0, paintRepository.count());
    }

    @Test
    public void testSave_Palettes_Paints_Count() {
        final PaletteGroupOption paletteGroup;
        final Collection<PaletteOption> palettes;
        final PaletteOption palette;
        final Collection<PaintOption> paints;
        final PaintOption paint;

        paint = new PaintOption();
        paint.setName("paint");

        paints = new ArrayList<>();
        paints.add(paint);

        palette = new PaletteOption();
        palette.setName("palette");
        palette.setPaints(paints);

        palettes = new ArrayList<>();
        palettes.add(palette);

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("group");

        paletteGroup.setPalettes(palettes);

        service.save(paletteGroup);

        Assertions.assertEquals(1, paletteGroupRepository.count());
        Assertions.assertEquals(1, paletteRepository.count());
        Assertions.assertEquals(1, paintRepository.count());
    }

    @Test
    public void testSave_Palettes_Paints_NoGroupName_Count() {
        final PaletteGroupOption paletteGroup;
        final Collection<PaletteOption> palettes;
        final PaletteOption palette;
        final Collection<PaintOption> paints;
        final PaintOption paint;

        paint = new PaintOption();
        paint.setName("paint");

        paints = new ArrayList<>();
        paints.add(paint);

        palette = new PaletteOption();
        palette.setName("palette");
        palette.setPaints(paints);

        palettes = new ArrayList<>();
        palettes.add(palette);

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("");

        paletteGroup.setPalettes(palettes);

        service.save(paletteGroup);

        Assertions.assertEquals(0, paletteGroupRepository.count());
        Assertions.assertEquals(0, paletteRepository.count());
        Assertions.assertEquals(0, paintRepository.count());
    }

    @Test
    public void testSave_Palettes_Paints_NoPaintName_Count() {
        final PaletteGroupOption paletteGroup;
        final Collection<PaletteOption> palettes;
        final PaletteOption palette;
        final Collection<PaintOption> paints;
        final PaintOption paint;

        paint = new PaintOption();
        paint.setName("");

        paints = new ArrayList<>();
        paints.add(paint);

        palette = new PaletteOption();
        palette.setName("palette");
        palette.setPaints(paints);

        palettes = new ArrayList<>();
        palettes.add(palette);

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("group");

        paletteGroup.setPalettes(palettes);

        service.save(paletteGroup);

        Assertions.assertEquals(1, paletteGroupRepository.count());
        Assertions.assertEquals(1, paletteRepository.count());
        Assertions.assertEquals(0, paintRepository.count());
    }

    @Test
    public void testSave_Palettes_Paints_NoPaletteName_Count() {
        final PaletteGroupOption paletteGroup;
        final Collection<PaletteOption> palettes;
        final PaletteOption palette;
        final Collection<PaintOption> paints;
        final PaintOption paint;

        paint = new PaintOption();
        paint.setName("paint");

        paints = new ArrayList<>();
        paints.add(paint);

        palette = new PaletteOption();
        palette.setName("");
        palette.setPaints(paints);

        palettes = new ArrayList<>();
        palettes.add(palette);

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("group");

        paletteGroup.setPalettes(palettes);

        service.save(paletteGroup);

        Assertions.assertEquals(1, paletteGroupRepository.count());
        Assertions.assertEquals(0, paletteRepository.count());
        Assertions.assertEquals(0, paintRepository.count());
    }

    @Test
    public void testSave_RepeatGroupName() {
        final PaletteGroupOption paletteGroup;

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("group");

        service.save(paletteGroup);
        service.save(paletteGroup);

        Assertions.assertEquals(2, paletteGroupRepository.count());
        Assertions.assertEquals(0, paletteRepository.count());
        Assertions.assertEquals(0, paintRepository.count());
    }

    @Test
    public void testSave_RepeatPaintName() {
        final PaletteGroupOption paletteGroup;
        final Collection<PaletteOption> palettes;
        final PaletteOption palette;
        final Collection<PaintOption> paints;
        final PaintOption paintA;
        final PaintOption paintB;

        paintA = new PaintOption();
        paintA.setName("paint");

        paintB = new PaintOption();
        paintB.setName("paint");

        paints = new ArrayList<>();
        paints.add(paintA);
        paints.add(paintB);

        palette = new PaletteOption();
        palette.setName("palette");
        palette.setPaints(paints);

        palettes = new ArrayList<>();
        palettes.add(palette);

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("group");

        paletteGroup.setPalettes(palettes);

        service.save(paletteGroup);

        Assertions.assertEquals(1, paletteGroupRepository.count());
        Assertions.assertEquals(1, paletteRepository.count());
        Assertions.assertEquals(2, paintRepository.count());
    }

    @Test
    public void testSave_RepeatPaletteName() {
        final PaletteGroupOption paletteGroup;
        final Collection<PaletteOption> palettes;
        final PaletteOption paletteA;
        final PaletteOption paletteB;

        paletteA = new PaletteOption();
        paletteA.setName("palette");

        paletteB = new PaletteOption();
        paletteB.setName("palette");

        palettes = new ArrayList<>();
        palettes.add(paletteA);
        palettes.add(paletteB);

        paletteGroup = new PaletteGroupOption();
        paletteGroup.setName("group");

        paletteGroup.setPalettes(palettes);

        service.save(paletteGroup);

        Assertions.assertEquals(1, paletteGroupRepository.count());
        Assertions.assertEquals(2, paletteRepository.count());
        Assertions.assertEquals(0, paintRepository.count());
    }

}