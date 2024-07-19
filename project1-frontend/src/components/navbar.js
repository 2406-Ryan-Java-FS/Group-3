import { Link } from "react-router-dom";
import uac from "../controllers/userAccountController";
import { globalStateSetter } from "../App";

export default function NavBar() {

    return (<>
        <nav id="navbar">
            <Link to="/">Home</Link>
            <Link to="/products">Products</Link>
            <Link to="/categories">Categories</Link>
            <Link to="/cart">Cart</Link>
            <Link to="/checkout">Checkout</Link>
            <Link to="/register">Register</Link>
        </nav>
        <br/>
        {uac.loggedInUser==null?
        <>Not logged in <Link to="/login">Login</Link></>:
        <>Logged in: {uac.loggedInUser.name}{" "}
        <Link onClick={async()=>{uac.logout();globalStateSetter()}}>Logout</Link>
        </>}
        
    </>)
}
