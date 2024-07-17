import React, { useState } from 'react';
import ReactDOM from 'react-dom/client';
import Cart from './components/cart';
import Checkout from './components/checkout';
import Login from './components/login';
import Product from './components/product';
import ProductList from './components/productlist';
import Register from './components/register';
import {Routes,Route, BrowserRouter,Link} from 'react-router-dom';
import './index.css';
import uac from './controllers/userAccountController';
import AppRoot from './components/AppRoot';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<AppRoot/>)

export default root