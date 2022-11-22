export interface Todo {
    id: number;
    title: string;
    description: string;
    finished: boolean;
}

export interface ContextState {
    todos: Todo[];
    addTodo: (todo: Todo) => void;
    updateTodo: (id: number) => void;
    removeTodo: (id: number) => void;
}