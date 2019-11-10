import * as types from 'notifications/actions/types';

const defaultState = {
   notifications: []
};

const notification = (state = defaultState, action) => {
   let notSelected;
   let selected;

   if (action.timestamps) {
      notSelected = state.notifications.filter((notif) => !action.timestamps.includes(notif.timestamp));
      selected = state.notifications.filter((notif) => action.timestamps.includes(notif.timestamp)).map((notif) => ({ ...notif, displayed: true }));
   }
   switch (action.type) {
   case types.ADD_NOTIFICATION:
      return {
         ...state,
         notifications: [
            ...state.notifications,
            {
               timestamp: action.timestamp,
               variant: action.variant,
               message: action.message,
               displayed: false
            }
         ]
      };
   case types.DELETE_NOTIFICATION:
      return {
         ...state,
         notifications: state.notifications.filter((notif) => notif.timestamp !== action.timestamp)
      };
   case types.SET_DISPLAYED_NOTIFICATIONS:
      return {
         ...state,
         notifications: [...notSelected, ...selected]
      };
   default:
      return state;
   }
};

export default notification;
