import { createContext, useState } from 'react';

export const AppContext = createContext();

export default function AppProvider({ children }) {

    //Here is where you can setup and create 'state' or any data
    //you want your Components to have access to.
    const [budget, setBudget] = useState(1000);

    const [items, setItems] = useState(["Apples", "Oranges", "Bananas"]);

    function updateBudget(newBudget) {
        setBudget(newBudget);
    }

    function addItem(newItem) {
        setItems([...items, newItem]);
    }

    const data = {
        budget: budget,
        updateBudget: updateBudget,
        items: items,
        addItem: addItem
    }

    return (
        <AppContext.Provider value={data} >
            {children}
        </AppContext.Provider>
    );

}