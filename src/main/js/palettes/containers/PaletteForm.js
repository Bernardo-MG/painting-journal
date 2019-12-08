import React from 'react';

import { useDispatch } from 'react-redux';

import { useSuggestions } from 'suggestions';

import { savePalette } from 'palettes/actions';

import PaletteEditor from 'palettes/components/PaletteEditor';

function PaletteForm() {

   const suggestions = useSuggestions();

   const dispatch = useDispatch();

   function handleSave(form) {
      dispatch(savePalette(form));
   }

   return <PaletteEditor
      suggestions={suggestions}
      onSave={handleSave} />;
}

PaletteForm.propTypes = {};

export default PaletteForm;