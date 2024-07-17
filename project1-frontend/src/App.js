import './App.css';
import { Route, Routes } from 'react-router-dom';
import HomeComponent from './components/home';
import Cart from './components/cart';
import Checkout from './components/checkout';
import Login from './components/login';
import Navbar from './components/navbar';
import Product from './components/product';
import ProductList from './components/productlist';
import Register from './components/register';

function App() {

  return (<>
    
    <Navbar />
    <HomeComponent />
    <Cart />
    <Checkout />
    <Login />
    <Register /> 
    <Routes>
      <Route path='' element={<HomeComponent />} />
      <Route path='/products' element={<>
        <Product />
        <ProductList /> </>} />
      
    </Routes>
  </>)

}

export default App;