import { useState } from "react"
import userAccountController from "../controllers/userAccountController"

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
        <button onClick={()=>{
            userAccountController.login(
                document.getElementById("idLoginUsername").value,
                document.getElementById("idLoginPassword").value)
            setx(x+1)
        }}
        >Login</button>
        
    </td>
    </tr>
</table>
</center>)
}