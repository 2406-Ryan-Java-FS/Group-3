import './App.css';
import { Link, Route, Routes } from 'react-router-dom';
import HomeComponent from './components/home';
import Cart from './components/cart';
import Checkout from './components/checkout';
import Login from './components/login';
import Navbar from './components/navbar';
import Product from './components/product';
import ProductList from './components/productlist';
import Register from './components/register';
import Category from './components/category';
import AddCategory from './components/addCategory';
import { useState } from 'react';
import uac from './controllers/userAccountController';

export let globalStateSetter

function App() {

  let [x,setx]=useState(0)
  globalStateSetter=()=>{setx(x+1)}

  return (<>
    
    <Navbar /> 
    <Routes>
      <Route path='' element={<HomeComponent />} />
      <Route path='/products' element={<>
        <ProductList />
        <Product /> </>} />
      <Route path='/categories' element={<>
        <Category />
        <AddCategory /> </>} />
      <Route path='/cart' element={<Cart />} />
      <Route path='/checkout' element={<Checkout />} />
      <Route path='/login' element={<Login />} />
      <Route path='/register' element={<Register />} />
    </Routes>
  </>)

}

export default App;