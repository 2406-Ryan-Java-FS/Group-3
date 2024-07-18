import { useEffect } from "react";
import uac from "../controllers/userAccountController";


export default function Profile()
{
    //causes fetch to happen 2 or 3 times
    // useEffect(()=>{
    //     async function weCanAsyncNow(){
    //         await uac.myPrivateInfo()
    //     }
    //     weCanAsyncNow()
    //     //globalStateSetter()//re-render. causes infinite loop.
    // })

    //await uac.myPrivateInfo()//can't

return(<>
<h1>Profile Page</h1>
{uac.loggedInUser==null?
<>No content to display. Not logged in.</>:
<>secretInformation: {uac.loggedInUser.secretInformation}</>}
</>)
}