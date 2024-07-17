import React, { useState } from "react";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import Login from "./login";
import Register from "./register";
import Cart from "./cart";
import Checkout from "./checkout";
import Product from "./product";
import ProductList from "./productlist";
import uac from "../controllers/userAccountController";

export let globalStateSetter

export default function AppRoot()
{
    let [x,setx]=useState(0)
    globalStateSetter=()=>{setx(x+1)}

return(<>
    <React.StrictMode>
    <BrowserRouter>
    {/* Links and Routes must be within BrowserRouter to avoid Errors*/}
    <nav>
    <Link to="/register"> Register</Link> ~ 
    <Link to="/cart"> Cart</Link> ~ 
    <Link to="/checkout"> Checkout</Link> ~ 
    <Link to="/product"> Product</Link> ~ 
    <Link to="/product-list"> Product List</Link><br/>
    {uac.loggedInUser==null?
        <>Not logged in <Link to="/">Login</Link></>:
        <>Logged in: {uac.loggedInUser.name} <Link>Logout</Link></>
    }
    </nav>
    <Routes>
      <Route path='' element={<Login/>}/>
      <Route path='register' element={<Register/>}/>
      <Route path='cart' element={<Cart/>}/>
      <Route path='checkout' element={<Checkout/>}/>
      <Route path='product' element={<Product/>}/>
      <Route path='product-list' element={<ProductList/>}/>
    </Routes>
    </BrowserRouter>
  
  </React.StrictMode>
  </>)
}