export type User = {
    userId: number;
    firstName: string;
    lastName: string;
    email: string;
    accounts: Account[]
};

export type Account = {
    accountNumber: number;
    ower: User;
    type: 'SAVING' | 'CHECKING' | 'LOAN',
    balance: number
};

export type UserSliceState = {
    user: User | undefined;
    loginError: boolean;
    loggedIn: boolean;
    loading: boolean;
}

export type LoginObject = {
    email: string;
    password: string;
}