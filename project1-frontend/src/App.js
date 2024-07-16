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
    
    
    <HomeComponent />
    <Cart />
    <Checkout />
    <Login />
    <Navbar />
    <Product />
    <ProductList />
    <Register /> 
    {/* <Routes>
      <Route path='' element={<HomeComponent />} />
      
    </Routes> */}
  </>)

}

export default App;