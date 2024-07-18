import { Link } from "react-router-dom";


export default function NavBar() {

    return (<>
        <nav id="navbar">
            <Link to="/">Home</Link>
            <Link to="/products">Products</Link>
            <Link to="/categories">Categories</Link>
            <Link to="/cart">Cart</Link>
            <Link to="/checkout">Checkout</Link>
            <Link to="/login">Login</Link>
            <Link to="/register">Register</Link>
        </nav>
    </>)
}
