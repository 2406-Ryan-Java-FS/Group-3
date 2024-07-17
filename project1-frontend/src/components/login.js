import { useState } from "react"
import userAccountController from "../controllers/userAccountController"
import root from ".."
import AppRoot, { globalStateSetter } from "./AppRoot"

export default function Login() 
{
    let [x,setx]=useState()
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
            setx(x+1)
            globalStateSetter()
        }}
        >Login</button>
        
    </td>
    </tr>
</table>
</center>)
}