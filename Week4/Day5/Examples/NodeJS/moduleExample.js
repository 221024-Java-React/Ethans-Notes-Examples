//Modules allow us to export peices of our js code, and import them other places

export const people = [
    {
        name: "Ethan",
        company: "Revature",
        title: "Trainer"
    },
    {
        name: "Firas",
        company: "Revature",
        title: "Associate"
    },
    {
        name: "Adrian",
        company: "Revature",
        title: "Associate"
    }
];

export const sayHello = (person) => {
    console.log(`Hello ${person.name}`);
}