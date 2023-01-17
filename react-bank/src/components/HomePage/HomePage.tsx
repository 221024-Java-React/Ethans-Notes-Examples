import React, {useEffect} from 'react'
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { RootState, AppDispatch } from '../../redux/store';
import { retrieveUserInfo } from '../../redux/userSlice';

export const HomePage = () => {

    const navigate = useNavigate();
    const dispatch:AppDispatch = useDispatch();
    const state = useSelector((state:RootState) => state.user);

    useEffect(()=> {
        if(localStorage.getItem("userId") && !state.user){
            console.log("User is logged in, just get their info");
            dispatch(retrieveUserInfo());
        } else if(!localStorage.getItem("userId")){
            console.log("Get outa here. SCRAM");
            navigate("/");
        }

        console.log(state);
    }, [state])

  return (
    <div>HomePage</div>
  )
}
