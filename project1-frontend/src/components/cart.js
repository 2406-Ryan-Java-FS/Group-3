import React, { useContext, useState, useEffect } from "react";
import { Link } from "react-router-dom";
const CartPreview = () => {
  const { products, setProducts } = useState();
//   const dispatch = useContext(CartDispatchContext);

  const handleRemove = (productId) => {
  };

  const handleItemQuantity = (productId, quantity) => {
    // return updateItemQuantity(dispatch, productId, quantity);
  };

  useEffect(()=>{
    async function getAllProducts() {
        const url = "http://localhost:8080/products";
        const httpResponse = await fetch(url);
        const productList = await httpResponse.json();
        setProducts(productList);
    }
    // getAllProducts();
  }, [])



  return (
    <div>
      <ul className="cart-items">
        {products && products.map((product) => {
          return (
            <li className="cart-item" key={product.name}>
              <img className="product-image" src={product.image} />
              <div className="product-info">
                <p className="product-name">{product.name}</p>
                <p className="product-price">{product.price}</p>
              </div>
              <div className="product-quantity">
                <div className="quantity-control" onClick={() => handleItemQuantity(product.id, product.quantity + 1)}>+</div>
                 <p>{product.quantity}</p>
                <div className="quantity-control" onClick={() => handleItemQuantity(product.id, product.quantity - 1)}>-</div>
              </div>
              <div className="product-total">
                <p className="amount">{product.quantity * product.price}</p>
              </div>
              <button
                className="product-remove"
                onClick={() => handleRemove(product.id)}
              >
                ×
              </button>
            </li>
          );
        })}
      </ul>
      <div className="action-block">
      </div>
    </div>
  );
};

export default CartPreview;