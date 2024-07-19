import React, { useContext, useState, useEffect } from "react";
import { Link, useLocation } from "react-router-dom";

let products;

export default function Cart()
{
  //const { products, setProducts } = useState();
//   const dispatch = useContext(CartDispatchContext);
  const location=useLocation();

  const handleRemove = (productId) => {
  };

  const handleItemQuantity = (productId, quantity) => {
    // return updateItemQuantity(dispatch, productId, quantity);
  };

  useEffect(()=>{
      async function yayReact(){
        const url = "http://localhost:8080/products";
        const httpResponse = await fetch(url);
        products = await httpResponse.json();
        //setProducts(productList);
      }
      yayReact()
  },[location])

// return (<>
// <h1>Cart</h1>
// <table>
//   <th><td>Price</td><td>Name</td>
  
//   </th>
//   {products && products.map((product) => {
//     return (
//       <li className="cart-item" key={product.name}>
//         {/* <img className="product-image" src={product.image} alt='product-image'/> */}
//         <div className="product-info">
//           <p className="product-name">{product.name}</p>
//           <p className="product-price">{product.price}</p>
//         </div>
//         <div className="product-quantity">
//           <div className="quantity-control" onClick={() => handleItemQuantity(product.id, product.quantity + 1)}>+</div>
//             <p>{product.quantity}</p>
//           <div className="quantity-control" onClick={() => handleItemQuantity(product.id, product.quantity - 1)}>-</div>
//         </div>
//         <div className="product-total">
//           <p className="amount">{product.quantity * product.price}</p>
//         </div>
//         <button
//           className="product-remove"
//           onClick={() => handleRemove(product.id)}
//         >
//           ×
//         </button>
//       </li>
//     );
//   })}
// </table>
// </>);


  return (
    <div>
      <h1>Cart</h1>
      <ul className="cart-items">
        {products && products.map((product) => {
          return (
            <li className="cart-item" key={product.name}>
              {/* <img className="product-image" src={product.image} alt='product-image'/> */}
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