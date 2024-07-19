import { useContext } from "react"
import { AppContext } from "../AppContext"

export default function Cart() {
    // console.log("Cart");
    const {cart} = useContext(AppContext);

    return (<>
        <h1>Cart</h1>
        {cart.length === 0 ? (
            <p>No items in cart...</p>
        ): (
            <ul>
                {cart.map((item,index) => (
                    <li key={index}>
                        {item.name} - ${item.price}
                    </li>
                ))}
            </ul>
        )}
    </>)
}