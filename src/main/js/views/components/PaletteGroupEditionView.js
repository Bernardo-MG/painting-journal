import React from 'react';

import { makeStyles } from '@material-ui/core/styles';

import Box from '@material-ui/core/Box';

import PaletteGroupUpdateForm from 'palettes/containers/PaletteGroupUpdateForm';

const useStyles = makeStyles((theme) => ({
   root: {
      padding: theme.spacing(3, 2)
   }
}));

function PaletteGroupEditionView() {

   const classes = useStyles();

   return <Box className={classes.root}>
      <PaletteGroupUpdateForm />
   </Box>;
}

PaletteGroupEditionView.propTypes = {};

export default PaletteGroupEditionView;
