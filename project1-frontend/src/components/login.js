import userAccountController from "../controllers/userAccountController"

export default function Login() 
{
return(<>
    <center>
    <h1>Welcome</h1>
        <table>
            <tr><td>Username:</td><td><input id="idLoginUsername" type="textbox"/></td></tr>
            <tr><td>Password:</td><td><input id="idLoginPassword" type="password"/></td></tr>
            <tr><td></td><td>
                <button onClick={()=>{
                    userAccountController.login(
                        document.getElementById("idLoginUsername").value,
                        document.getElementById("idLoginPassword").value)
                }}>Login</button></td></tr>
        </table>
    </center>
</>)
}