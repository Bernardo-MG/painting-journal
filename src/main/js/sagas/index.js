import { all } from 'redux-saga/effects';
import { apiSagas } from 'api/sagas';
import { notificationSagas } from 'notifications/sagas';

/**
 * Application redux sagas.
 * 
 * It is just a merge of all the sagas in the application.
 */
export default function* rootSaga() {
   yield all([...apiSagas, ...notificationSagas]);
}
