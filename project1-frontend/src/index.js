import React from 'react';
import ReactDOM from 'react-dom/client';
import Cart from './components/cart';
import Checkout from './components/checkout';
import Login from './components/login';
import Navbar from './components/navbar';
import Product from './components/product';
import ProductList from './components/productlist';
import Register from './components/register';
import {Routes,Route, BrowserRouter,Link} from 'react-router-dom';
import './index.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
    {/* Links and Routes must be within BrowserRouter to avoid Errors*/}
    <nav>
    <Link to="/">Login</Link> ~ 
    <Link to="/register"> Register</Link> ~ 
    <Link to="/cart"> Cart</Link> ~ 
    <Link to="/checkout"> Checkout</Link> ~ 
    <Link to="/product"> Product</Link> ~ 
    <Link to="/product-list"> Product List</Link>
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
);
