import { useState, useEffect } from "react";

const Order = () => {
    const [orders, setOrders] = useState([
    ]);
    const updateOrderStatus = (orderId, status) => {
      setOrders(orders.map(order => order.id === orderId ? { ...order, status } : order));
    };
  
    useEffect(()=>{
        async function getAllOrders() {
            const url = "http://localhost:8080/orders";
            const httpResponse = await fetch(url);
            const orderList = await httpResponse.json();
            setOrders(orderList);
        }
        // getAllOrders();
      }, [])

  
  
  
    return (
  <div className="checkout-page">
        <h1 className="my-4">Order Management</h1>
        <div>
          <table className="styled-table">
            <thead>
              <tr>
                <th>Order ID</th>
                <th>Customer</th>
                <th>Status</th>
                <th>Total</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {orders && orders.map(order => (
                <tr key={order.id}>
                  <td>{order.id}</td>
                  <td>{order.customer}</td>
                  <td>{order.status}</td>
                  <td>${order.total.toFixed(2)}</td>
  
                    <td>
                      <select 
                        className="form-select"
                        value={order.status} 
                        onChange={(e) => updateOrderStatus(order.id, e.target.value)}
                      >
                        <option value="Processing">Processing</option>
                        <option value="Shipped">Shipped</option>
                        <option value="Delivered">Delivered</option>
                      </select>
                    </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  };
  
  export default Order;
  