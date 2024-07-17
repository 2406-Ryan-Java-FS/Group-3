import { useState } from "react"
import userAccountController from "../controllers/userAccountController"
import root from ".."
import AppRoot, { globalStateSetter } from "./AppRoot"
import { useNavigate } from "react-router"

export default function Login() 
{
    let navigate=useNavigate()
return(
<center>
<h1>Welcome</h1>
<table>
    <tr><td>Username:</td><td><input id="idLoginUsername" type="textbox"/></td></tr>
    <tr><td>Password:</td><td><input id="idLoginPassword" type="password"/></td></tr>
    <tr>
        <td></td>
    <td>
        <button onClick={async()=>{
            await userAccountController.login(
                document.getElementById("idLoginUsername").value,
                document.getElementById("idLoginPassword").value)
                
            await userAccountController.myPrivateInfo()

            navigate("/")//does not cause redraw
            globalStateSetter()//causes redraw
        }}
        >Login</button>
        
    </td>
    </tr>
</table>
</center>)
}