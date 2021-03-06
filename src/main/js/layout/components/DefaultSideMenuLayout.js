import React from 'react';

import { useIntl } from 'react-intl';

import PropTypes from 'prop-types';

import sideLinks from 'layout/links';

import SideMenuLayout from 'layout/components/SideMenuLayout';

/**
 * Base layout for the application. This will frame all the views.
 * 
 * It contains a navigation bar on the left side, and the view on the rest of the screen.
 */
function DefaultSideMenuLayout({ children }) {

   const intl = useIntl();

   return <SideMenuLayout links={ sideLinks } title={ intl.formatMessage({ id: 'app.name' }) }>{ children }</SideMenuLayout>;
}

DefaultSideMenuLayout.propTypes = {
   /** Children elements, the view contents */
   children: PropTypes.oneOfType([
      PropTypes.array,
      PropTypes.object
   ])
};

export default DefaultSideMenuLayout;
