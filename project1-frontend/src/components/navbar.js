import { Link } from "react-router-dom";


export default function NavBar() {

    return (<>
        <nav id="navbar">
            <Link to="/">Home</Link>
            <Link to="/products">Products</Link>
        </nav>
    </>)
}