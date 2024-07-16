import React from 'react';
import ReactDOM from 'react-dom/client';
import Cart from './components/cart';
import Checkout from './components/checkout';
import Login from './components/login';
import Navbar from './components/navbar';
import Product from './components/product';
import ProductList from './components/productlist';
import Register from './components/register';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Cart />
    <Checkout />
    <Login />
    <Navbar />
    <Product />
    <ProductList />
    <Register />    
  </React.StrictMode>
);
