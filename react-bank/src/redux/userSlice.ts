import { createSlice } from '@reduxjs/toolkit'
import type { PayloadAction } from '@reduxjs/toolkit'
import type {User, UserSliceState} from '../Types';

//Some initial state for this slice of the store
//This will be our user
const initialState:UserSliceState = {
    user: undefined
};

export const userSlide = createSlice({
    name:"user",
    initialState,
    reducers:{},
    extraReducers(builder) {
        //async thunks go, aka where we will handle our axios calls   
    }
});