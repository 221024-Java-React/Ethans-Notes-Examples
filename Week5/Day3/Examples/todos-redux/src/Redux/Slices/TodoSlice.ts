import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import { Todo } from "../../Types/Todo";

interface TodoSliceState {
    todos: Todo[]
};

const initialState: TodoSliceState = {
    todos: []
};

//Create our slice and map our reducers
export const TodoSlice = createSlice({
    //We need to name our slice
    name:"todo",
    initialState,
    reducers: {
        addTodo: (state:TodoSliceState, action:PayloadAction<Todo>) => {
            state.todos = [...state.todos, action.payload];
            return state;
        },

        updateTodo: (state:TodoSliceState, action:PayloadAction<number>) => {
            for(let i = 0; i<state.todos.length; i++){
                let todo = state.todos[i];
                if(todo.id === action.payload){
                    todo.finished = !todo.finished;
                    state.todos.splice(i, 1, todo);
                }
            }

            return state;
        },

        removeTodo: (state:TodoSliceState, action:PayloadAction<number>) => {
            state.todos = state.todos.filter((todo:Todo) => todo.id !== action.payload);
            return state;
        }
    }
});

export const {addTodo, updateTodo, removeTodo} = TodoSlice.actions;
export default TodoSlice.reducer;