import React from 'react';
import { useParams } from 'react-router-dom';

import { makeStyles } from '@material-ui/core/styles';

import Box from '@material-ui/core/Box';

import PaletteGroupEditor from 'palettes/containers/PaletteGroupEditor';

const useStyles = makeStyles((theme) => ({
   root: {
      padding: theme.spacing(3, 2)
   }
}));

function PaletteEditorView() {

   const { id } = useParams();

   const classes = useStyles();

   return <Box className={classes.root}>
      <PaletteGroupEditor id={id} />
   </Box>;
}

PaletteEditorView.propTypes = {};

export default PaletteEditorView;
