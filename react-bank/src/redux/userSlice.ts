import { createSlice } from '@reduxjs/toolkit'
import { PayloadAction, createAsyncThunk } from '@reduxjs/toolkit'
import axios from 'axios';
import type {User, UserSliceState, LoginObject} from '../Types';

//Some initial state for this slice of the store
//This will be our user
const initialState:UserSliceState = {
    user: undefined,
    loginError: false,
    loggedIn: false,
    loading: true
};

export const loginUser = createAsyncThunk(
    "user/login",
    async (body: LoginObject, thunkAPI) => {
        try{
            let res = await axios.post("http://localhost:8080/user/login", body);
            return res.data;
        }  catch(e){
           return thunkAPI.rejectWithValue(e);
        }
    }
);

export const retrieveUserInfo = createAsyncThunk(
    "user/get",
    async (body, thunkAPI) => {
        try{
            let res = await axios.get("http://localhost:8080/user/"+localStorage.getItem("userId"));
            return res.data;
        } catch(e){
            return thunkAPI.rejectWithValue(e);
        }
    }
)

export const userSlice = createSlice({
    name:"user",
    initialState,
    reducers:{},
    extraReducers(builder) {
        builder.addCase(retrieveUserInfo.pending, (state, action) => {
            state.loading = true;
            return state;
        });

        builder.addCase(loginUser.fulfilled, (state, action) => {
            console.log("User: " + action.payload.userId + " was logged in");
            state.user = action.payload;
            state.loginError = false;
            state.loggedIn = true;
            localStorage.setItem("userId", action.payload.userId);
            return state;
        });

        builder.addCase(retrieveUserInfo.fulfilled, (state, action) => {
            state.user = action.payload;
            state.loading = false;
            return state;
        });

        builder.addCase(loginUser.rejected, (state, action)=> {
            state.loginError = true;
            state.loggedIn = false;
            return state;
        });
    }
});

export default userSlice.reducer;