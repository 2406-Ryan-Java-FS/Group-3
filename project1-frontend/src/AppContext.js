import { createContext, useState } from 'react';

export const AppContext = createContext();

export default function AppProvider({ children }) {

    //Here is where you can setup and create 'state' or any data
    //you want your Components to have access to.
    
    const [cart, setCart] = useState([]);

    function addToCart(product) {
        setCart([...cart,product]);
    }

    const data = {
        cart:cart,
        addToCart:addToCart
    }

    return (
        <AppContext.Provider value={data} >
            {children}
        </AppContext.Provider>
    );

}