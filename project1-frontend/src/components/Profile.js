import uac from "../controllers/userAccountController";


export default function Profile()
{
return(<>
<h1>Profile Page</h1>
{uac.loggedInUser==null?
<>No content to display. Not logged in.</>:
<>secretInformation: {uac.loggedInUser.secretInformation}</>}
</>)
}