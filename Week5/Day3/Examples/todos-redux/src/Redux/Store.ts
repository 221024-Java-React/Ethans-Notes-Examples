//This will hold our application state
import {configureStore} from '@reduxjs/toolkit';

//We will also import all of our reducer functions in here
import TodoSlice from './Slices/TodoSlice';
import UserSlice from './Slices/PersonSlice';

export const store = configureStore({
    //map all of our reducers for our store
    reducer: {
        todo: TodoSlice,
        user: UserSlice
    }
});

//Because we are using typescript, we need to export a couple of special types
export type RootState = ReturnType<typeof store.getState>;
export type DispatchType = typeof store.dispatch;