import React, { useContext, useState, useEffect } from "react";
import { Link } from "react-router-dom";
const Checkout = () => {
    const [items, setItems]=useState([]);
    const [discount, setDiscount] = useState(0);
    const [discountCode, setDiscountCode] = useState('');
    const [shippingCost, setShippingCost] = useState(5.99);
    const [taxRate, setTaxRate] = useState(0.07);
    const applyDiscountCode = () => {
      if (discountCode === 'DISCOUNT10') {
        setDiscount(0.10);
      } else {
        alert('Invalid discount code');
      }
    };
  
    const calculateTotal = () => {
      const subtotal = items.reduce((total, item) => total + item.price * item.quantity, 0);
      const discountAmount = subtotal * discount;
      const tax = (subtotal - discountAmount) * taxRate;
      return subtotal - discountAmount + tax + shippingCost;
    };
  

    useEffect(()=>{
        async function getAllItemsFromCart() {
            const url = "http://localhost:8080/cart";
            const httpResponse = await fetch(url);
            const productList = await httpResponse.json();
            setItems(productList);
        }
        // getAllItemsFromCart();
      }, [])


  
    return (
      <div className="checkout-page">
        <div className="container">
          <div className="order-summary">
            <h2>
              Summary
              <span>{` (${items.length}) Items`}</span>
            </h2>
            <ul className="cart-items">
              {items && items.map((product) => {
                return (
                  <li className="cart-item" key={product.name}>
                    <img className="product-image" src={product.image} />
                    <div className="product-info">
                      <p className="product-name">{product.name}</p>
                      <p className="product-price">{product.price}</p>
                    </div>
                    <p className="product-quantity">{product.quantity}</p>
                    <div className="product-total">
                      <p className="quantity">
                        {`${product.quantity} ${
                          product.quantity > 1 ? "Nos." : "No."
                        }`}
                      </p>
                      <p className="amount">{product.quantity * product.price}</p>
                    </div>
                  </li>
                );
              })}
            </ul>
  
            <ul className="total-breakup">
              <li>
                <p>Subtotal</p>
                <p>${items.reduce((total, item) => total + item.price * item.quantity, 0).toFixed(2)}</p>
              </li>
              <li>
                <p>Tax</p>
                <p>${(items.reduce((total, item) => total + item.price * item.quantity, 0) * taxRate).toFixed(2)}</p>
              </li>
              <li>
                <p>Discount</p>
                <p>${((items.reduce((total, item) => total + item.price * item.quantity, 0)) * discount).toFixed(2)}</p>
              </li>
              <li>
                <p>Shipping</p>
                <p>${shippingCost}</p>
              </li>
              <li>
              <div className="coupon-code">
                <input 
                  className="code-input"
                  type="text" 
                  value={discountCode} 
                  onChange={(e) => setDiscountCode(e.target.value)} 
                  placeholder="Discount code" 
                />
                <button className="code-btn" onClick={applyDiscountCode}>Apply</button>
              </div>
              </li>
              <li>
                <h2>Total</h2>
                <h2>${calculateTotal().toFixed(2)}</h2>
              </li>
            </ul>
          </div>
        </div>
      </div>
    );
  };
  
  export default Checkout;