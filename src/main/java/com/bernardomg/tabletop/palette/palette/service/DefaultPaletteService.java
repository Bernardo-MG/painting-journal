
package com.bernardomg.tabletop.palette.palette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardomg.tabletop.palette.paint.model.PaintOption;

@Service
public final class DefaultPaletteService implements PaletteService {

    @Autowired
    public DefaultPaletteService() {
        super();
    }

    @Override
    public final void save(final Iterable<PaintOption> paints) {

    }

}