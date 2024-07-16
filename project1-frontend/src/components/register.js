
import userAccountController from "../controllers/userAccountController.js"

export default function Register() 
{
    const refUsername=useRef()
    
return(<>
    <center>
        <h1>Welcome Newcomer</h1>
        <table>
            <tr><td>Username:</td><td><input type="textbox"/></td></tr>
            <tr><td>Password:</td><td><input type="password" /></td></tr>
            <tr><td>Password Confirm:</td><td><input type="password" /></td></tr>
            <tr><td></td><td>
                <button onClick={
                    ()=>{
                        userAccountController.register(

                        )
                    }
                }>
                    Register New Account</button>
            </td></tr>
        </table>
    </center>
    </>)
}