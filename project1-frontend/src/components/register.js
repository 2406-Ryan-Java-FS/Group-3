
import { useRef } from "react"
import userAccountController from "../controllers/userAccountController"

export default function Register() 
{
    //const refUsername=useRef()
    const refPassword=useRef()
    const refPasswordConfirm=useRef()

return(<>
    <center>
        <h1>Welcome Newcomer</h1>
        <table>
            <tr><td>Username:</td><td><input id="idUsername" type="textbox"/></td></tr>
            <tr><td>Password:</td><td><input type="password" ref={refPassword}/></td></tr>
            <tr><td>Password Confirm:</td><td><input type="password" ref={refPasswordConfirm}/></td></tr>
            <tr><td></td><td>
                <button onClick={
                    ()=>{
                        console.log(`refPassword=`,refPassword)
                        userAccountController.register(
                            document.getElementById(`idUsername`).value,
                            refPassword.current.value
                        )
                    }
                }>
                    Register New Account</button>
            </td></tr>
        </table>
    </center>
    </>)
}